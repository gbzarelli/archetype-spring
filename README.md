# Archetype Java Sample

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

Based of:

 - https://www.baeldung.com/maven-archetype
 - https://github.com/eugenp/tutorials/tree/master/maven-archetype