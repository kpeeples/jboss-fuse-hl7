jboss-fuse-hl7
==============
Step 1 – View the README in 'installs' directory
Step 2 – Install HAPI TestPanel
Step 3 – Add the JBoss Fuse product from the JBoss.org (or Red Hat Customer Support Portal)
https://www.jboss.org/products/fuse.html
Step 4 - Update the zip filename in init.sh in the FUSE_BIN variable
Step 5 - Run 'init.sh' & read output
Step 6 - Install and/or Setup JBDS for project import
https://www.jboss.org/products/fuse.html
Step 7 - Add the JBoss Fuse server
admin=redhat,admin update users.properties in /etc first
Step 8 - Import the maven project to review the files
Step 9 - Start JBoss Fuse
 [kpeeples@localhost bin]$ ./fuse Please wait while JBoss Fuse is loading... 100% [=================================================================]
JBoss Fuse (6.0.0.redhat-024) http://www.redhat.com/products/jbossenterprisemiddleware/fuse/
Hit '' for a list of available commands and '[cmd] --help' for help on a specific command. Hit '' or 'osgi:shutdown' to shutdown JBoss Fuse.
JBossFuse:karaf@root>
Step 10 - When the JBoss Fuse console appears, install the Fuse Application Bundle (FAB) 
JBossFuse:karaf@root>osgi:install -s fab:mvn:hl7test/eip/6.0.0.redhat-024
show .m2 repo
view the OSGi list to make sure the FAB has been created and active
osgi:list - l
[ 234] [Active     ] [Created     ] [       ] [   60] fab:mvn:hl7test/eip/6.0.0.redh
at-024
Step 11 - Create a HL7 Listener to act as the Interface Engine or Processor. 
Step 12 - Send Messages from testpanel to be directed to another listener or to a service
Step 13 -  Use `log:display` on the ESB shell to check out the business logging
