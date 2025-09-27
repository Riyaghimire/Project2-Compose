# Use official Jenkins LTS base image
FROM jenkins/jenkins:lts-jdk11

USER root

# Install prerequisites and Docker CLI
RUN apt-get update && apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg \
    lsb-release \
    docker.io \
    git \
    jq \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Install Jenkins plugins
RUN jenkins-plugin-cli --plugins \
    docker-workflow \
    pipeline-stage-view \
    git \
    credentials-binding \
    matrix-auth \
    role-strategy \
    audit-trail \
    warnings-ng \
    workflow-aggregator

# Set environment variables for Docker-in-Docker (optional, can also be in docker-compose.yml)
ENV DOCKER_HOST=tcp://dind:2375
ENV DOCKER_TLS_VERIFY=0

# Create Jenkins user directories for Docker if needed
RUN mkdir -p /var/jenkins_home/.docker && chown -R jenkins:jenkins /var/jenkins_home

# Switch back to Jenkins user
USER jenkins

# Expose default Jenkins ports
EXPOSE 8080 50000
