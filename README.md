# Archetype Spring

 This Archetype creates:
 
  - Folder structure
  - .gitignore and README.md
  - External properties folder
  - Classes as an sample
  
  This example shows how to create custom variables and change them to existing ones
  see at: [archetype-metadata.xml](src/main/resources/META-INF/maven/archetype-metadata.xml)
  
  sample:
  ```xml
   <requiredProperty key="greeting-msg">
              <defaultValue>Hi, I was generated from an archetype!</defaultValue>
   </requiredProperty>
   <requiredProperty key="artifactIdLower">
              <defaultValue>${artifactId.toLowerCase()}</defaultValue>
   </requiredProperty>
   ```

## Sample of project created with this archetype
![](images/structure.png)

## How to use

 In IntelliJ:
 - File -> New -> Project -> Maven -> (mark) Create from archetype -> Add Archetype
 
![](images/add_archetype.png)
 
 - Select the archetype and complete the creation.
 
![](images/new_project.png)

## Based of:

 - https://www.baeldung.com/maven-archetype
 - https://github.com/eugenp/tutorials/tree/master/maven-archetype
