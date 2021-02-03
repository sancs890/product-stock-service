pipeline{
  agent any
  stages{
    stage("build){
      steps{
        echo "run backend"
        sh 'mvn -B -DskipTests clean package'
      }
    }
  }
}
