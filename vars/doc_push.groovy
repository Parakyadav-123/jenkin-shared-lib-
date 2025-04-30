def call(String Project, String Imagetag, String dockerhubuser) {
  withCredentials([usernamePassword(
    credentialsId: 'dockerhubcred',
    usernameVariable: 'DOCKER_USER',
    passwordVariable: 'DOCKER_PASS'
  )]) {
    sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
  }

  sh "docker push ${dockerhubuser}/${Project}:${Imagetag}"
}
