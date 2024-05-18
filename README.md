# Storyful
1. Install Java
2. Install Maven
3. Install Git
4. Install Eclipse
5. Open Git bash in folder and run below command
   mvn archetype:generate                      \
   "-DarchetypeGroupId=io.cucumber"           \
   "-DarchetypeArtifactId=cucumber-archetype" \
   "-DarchetypeVersion=7.17.0"               \
   "-DgroupId=hellocucumber"                  \
   "-DartifactId=hellocucumber"               \
   "-Dpackage=hellocucumber"                  \
   "-Dversion=1.0.0-SNAPSHOT"                 \
   "-DinteractiveMode=false"
6. Required to have selenium webdriver compatible to browser version.
7. Update driver path in the code.