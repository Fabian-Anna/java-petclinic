/*
 *
 *  * Copyright 2016-2017 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

/**
 * @author Vitaliy Fedoriv
 */

import {Injectable} from '@angular/core';
import {forkJoin, Observable} from 'rxjs';
import {Visit, VisitAndPet, VisitPetAndOwner} from './visit';
import {environment} from '../../environments/environment';
import {HandleError, HttpErrorHandler} from '../error.service';
import {HttpClient} from '@angular/common/http';
import {catchError, map, mergeMap} from 'rxjs/operators';
import { PetService } from 'app/pets/pet.service';
import { OwnerService } from 'app/owners/owner.service';

@Injectable()
export class VisitService {

  private entityUrl = environment.REST_API_URL + 'visits';

  private readonly handlerError: HandleError;

  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler, private petservice: PetService, private ownerservice: OwnerService) {
    this.handlerError = httpErrorHandler.createHandleError('OwnerService');
  }

  getVisits(): Observable<Visit[]> {
    return this.http.get<Visit[]>(this.entityUrl)
      .pipe(
        catchError(this.handlerError('getVisits', []))
      );
  }

  getVisitsAndExpand(vetId: string): Observable<VisitPetAndOwner[]> {
    return this.getVisitsByVetId(vetId).pipe(
      mergeMap((visits: Visit[]) => {
        return forkJoin(
          visits.map(visit => {
            return this.petservice.getPetById(visit.petId).pipe(map(pet => ({ visit, pet })))
          })
        );
      }),

      mergeMap((visitsAndPets: VisitAndPet[]) => {
        return forkJoin(
          visitsAndPets.map(({visit, pet}) => {
            return this.ownerservice.getOwnerById(pet.ownerId).pipe(map(owner => ({ visit, pet, owner })))
          })
        );
      })
    );
  }

  getVisitsByVetId(vetId: string): Observable<Visit[]> {
    return this.http.get<Visit[]>(this.entityUrl+ '?vetId=' + vetId )
      .pipe(
        catchError(this.handlerError('getVisitsByVetId', []))
      );
    }

  getVisitById(visitId: string): Observable<Visit> {
    return this.http.get<Visit>(this.entityUrl + '/' + visitId)
      .pipe(
        catchError(this.handlerError('getVisitById', {} as Visit))
      );
  }

  addVisit(visit: Visit): Observable<Visit> {
    const ownerId = visit.pet.ownerId;
    const petId = visit.pet.id;

    const vetId = visit.vet?.id || visit.vetId;
    //const visitsUrl = environment.REST_API_URL + `owners/${ownerId}/pets/${petId}/visits`;
    const visitsUrl = environment.REST_API_URL + `owners/${ownerId}/pets/${petId}/vets/${vetId}/visits`;
    return this.http.post<Visit>(visitsUrl, visit)
      .pipe(
        catchError(this.handlerError('addVisit', visit))
      );
  }

  updateVisit(visitId: string, visit: Visit): Observable<Visit> {
    return this.http.put<Visit>(this.entityUrl + '/' + visitId, visit)
      .pipe(
        catchError(this.handlerError('updateVisit', visit))
      );
  }

  deleteVisit(visitId: string): Observable<number> {
    return this.http.delete<number>(this.entityUrl + '/' + visitId)
      .pipe(
        catchError(this.handlerError('deleteVisit', 0))
      );

  }
}
