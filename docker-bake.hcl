variable "GITHUB_SHA" {
  default = "latest"
}

variable "REGISTRY" {
  default = "${ vars.DOCKER_IMAGE_NAME }-dev"
}

group "default" {
  targets = [
    "frontend-react",
    "backend-spring",
  ]
}