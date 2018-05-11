# Environment setup 
##### Intellij Idea
1. Go to [Jetbrains.com](https://www.jetbrains.com/idea/download/#section=windows)
2. Download and install Intellij IDEA (Community version)
##### Java Development kit
1. Go to [oracle.com](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Select 'Download' tab 
3. Click on 'Java Platform (JDK) 10'
4. Download 'jdk-10.0.1_windows-x64_bin.exe' file
##### Additional settings
1. Open Intellij IDEA 
2. Click on 'Create new project'
3. Project SDK: choose JDK file
4. Give a 'project name' and pay attention to 'project location'
5. 'qaauto' - on this parent folder of project right-click -
'Add framework support' - Choose 'Maven'
6. Download [Geckodriver file](https://github.com/mozilla/geckodriver/releases)
copy this file to windows/system 32
7. Download a [Markdown plugin](http://plugins.jetbrains.com/plugin/7793-markdown-support)
for creation of files with .md extension
8. For adding a plugin go to: File - Settings - Plugin - Select a zip file
##### GitHUB setup
1. Go to [github.com](github.com)
2. Go through Sign Up flow
3. Create new _public_ repository
4. Create .gitignore file (.iml, target, .idea )
5. Upload project using drag&drop
6. Copy URL from "Clone&Download" to Intellij IDEA -> VCS -> Checkout for Version Control -> GIT 
7. Go to [https://gitforwindows.org/](https://gitforwindows.org/)
8. Download and install Git for Windows
9. Paste git.exe full path to Intellij IDEA -> VCS -> Checkout for Version Control -> GIT 
10. To Commit and Push go to [ProjectFolder] - Git -> Commit Directory