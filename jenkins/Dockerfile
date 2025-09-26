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

# Switch back to Jenkins user
USER jenkins
