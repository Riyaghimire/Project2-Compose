// 02-matrix-auth.groovy
import jenkins.model.*
import hudson.security.*
import hudson.model.Item

def instance = Jenkins.getInstance()

// Use Global Matrix Authorization Strategy and give precise permissions.
def strategy = new GlobalMatrixAuthorizationStrategy()

// Admin gets full admin rights
strategy.add(Jenkins.ADMINISTER, "admin")

// pipeline user: give minimal rights required to run jobs and read projects
strategy.add(hudson.model.Hudson.READ, "pipeline")
strategy.add(Item.READ, "pipeline")
strategy.add(Item.BUILD, "pipeline")

// Do not add anonymous permissions => anonymous access disabled
instance.setAuthorizationStrategy(strategy)
instance.save()
