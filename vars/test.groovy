def call() {
  pipeline {
    agent {label 'slave1'}

    stages {
      
      stage ('Install Nginx') {
        steps {
          echo 'BUILD'
          sh 'sudo apt update '
          sh 'sudo apt install nginx -y'
          sh 'sudo nginx -v'
              } 
            }
      
      stage ('START'){
          steps {
            echo 'SART'
            sh 'sudo systemctl start nginx'
                }
            }

      stage ('TEST') {
          steps {
            echo 'TEST'
            sh 'curl localhost'
                } 
            }
        }
    }
}
  
