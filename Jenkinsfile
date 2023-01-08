pipeline {
    agent any
    triggers {
        githubPush()
    }

    tools {
        maven 'mvn_v3_8_6'
        nodejs 'NodeJS_v18.13.0'
    }

    stages {
        stage('Install dependencies') {
            steps {
                sh '''
                    ls
                    cd spring-petclinic-angular
                    pwd
                    ls
                    npm install --legacy-peer-deps
                    cd ..
                '''
            }
        }

        stage('Build backend') {
            steps {
            sh '''
                echo "---------------------Building backend..."
                cd spring-petclinic-rest
                mvn -B install --file pom.xml
                cd ..
                echo "---------------------Done building backend"
            '''
            }
            
        }

        stage('Unit-Test backend') {
            steps {
                sh '''
                    echo "---------------------Unit-testing backend..."
                    echo "---------------------finished unit-testing backend"
                '''
            }
        }

        stage('Build frontend') {
            steps {
                sh '''
                    cd spring-petclinic-angular
                    npm run build --if-present -- --prod
                    cd ..
                '''
            }
        }

        stage('Lint frontend') {
            steps {
                sh '''
                    cd spring-petclinic-angular
                    npm run lint
                    cd ..
                '''
            }
        }

        stage('Unit-Test frontend') {
            steps {
                sh '''
                    cd spring-petclinic-angular
                    npm run test-headless
                    cd ..
                '''
            }
        }

        stage('UI-Tests') {
            steps {
                sh '''
                    echo "---------------------Starting UI-Testing with Cypress..."
                    echo "---------------------finished UI-Tests with Cypress"
                '''
            }
        }


    }
}