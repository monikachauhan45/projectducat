//Jenkinsfiles (Declarative Pipeline)
pipeline{
          //Specifies that this pipelilne can run on any available agent
           agent any
         // Defines tools required (configured in Manage Jenkins > Global Tool Configuration)
         tools{
               //Replace 'JDK-25' and 'Maven-3.8.6' with your configured names
               jdk 'JDK-25.0.2'
               maven 'Maven-3.8.6'

         }

         stages{
                stage('Checkout Code'){
                      steps{
                             //Checkout the source code from your Git repository
                            git url: 'https://github.com/monikachauhan45/projectducat',
                            branch: 'main'// Specify your branch name
                      }
                }

                stage('Build and Test')
                       {
                             steps{
                              //Execute Maven goals to clean the project and run tests
                             //'clean test' command runs the tests using the surefire plugins
                             bat 'mvn clean test'
                             }
                       }
         }

          post{
                 always{
                         //This is the correct method that Jenkins recognizes
                         junit 'target/surefire-reports/*.xml'
                 }
          }
}

