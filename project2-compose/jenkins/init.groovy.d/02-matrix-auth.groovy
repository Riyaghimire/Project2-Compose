#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()
println "--> Configuring Matrix Authorization"

def strategy = new GlobalMatrixAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER, "admin")
instance.setAuthorizationStrategy(strategy)

instance.save()
