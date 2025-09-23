#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

println "--> Creating local admin user"
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin","admin123")
instance.setSecurityRealm(hudsonRealm)

instance.save()
