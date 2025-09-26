// 01-create-users.groovy
import jenkins.model.*
import hudson.security.*

// Create users: admin and pipeline (non-admin)
def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin','H@ppy1234')      // replace with secure admin password
hudsonRealm.createAccount('pipeline','1234H@ppy') // replace with pipeline user password
instance.setSecurityRealm(hudsonRealm)
instance.save()
