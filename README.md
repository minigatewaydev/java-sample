# Java Code Sample

This sample is constructed using Visual Studio Code 1.38.1, so the editor is required if you want to run the application out of the box. You may also use another IDE of your choice, but some code structure may need some modification or conversion.

__Note: This sample is constructed with plain Java without any framework.__

## Project dependency
This project uses the following library:
- Google GSON (https://github.com/google/gson)
- Apache HTTP Component (https://hc.apache.org/index.html) - contain 11 <code>.jar</code> library files
- Apache Common Lang (https://commons.apache.org/proper/commons-lang/)

## Running sample in VSC

- Download as ZIP and extract
- In VSC, File > Open Folder

Before running the sample, please manually restore all dependencies by going to <code>.classpath</code> file. Change all entries under <code>classpathentry</code> and point it into the actual local __.jar__ file. If you don't have it, please download it using the link provided on __Project dependency__ above.

After all restored:

- Change the required information in <code>App.java</code> file
- Click on "Run" or "Debug" link on top of <code>main</code> method
