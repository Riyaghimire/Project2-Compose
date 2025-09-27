# Use official Jenkins LTS base image
FROM jenkins/jenkins:lts-jdk11

USER root

# Install prerequisites: Docker CLI, Git, Node.js, jq
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

# Install Node.js 20 LTS
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm

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

# Make sure Jenkins user can use Docker socket
RUN groupadd -f docker \
    && usermod -aG docker jenkins

# Switch back to Jenkins user
USER jenkins

EXPOSE 8080 50000
