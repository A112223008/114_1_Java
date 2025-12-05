PowerShell emoji config for TemplateMethodDemo

This project prints emoji to the console. On Windows PowerShell (v5.1), emoji may not display correctly by default. Follow these steps to make emoji appear, or let the program fall back to ASCII labels.

Steps to try in PowerShell before running the Java program:

1) Set the code page to UTF-8 and set the output encoding:

   chcp 65001; $OutputEncoding = [System.Text.UTF8Encoding]::new()

2) Use a font in the terminal that supports emoji (e.g., "Segoe UI Emoji").
   - Right-click the title bar -> Properties -> Font -> choose "Consolas" or a font with emoji support
   - Windows Terminal supports emoji fonts per profile; set font to "Cascadia Code PL" or the OS emoji font.

3) Compile and run the Java file with UTF-8 source encoding to ensure literals are read correctly:

   # compile (from project folder)
   javac --encoding UTF-8 TemplateMethodDemo.java

   # run (ensure JVM uses UTF-8 for file.encoding if needed)
   java -Dfile.encoding=UTF-8 TemplateMethodDemo

Notes and fallbacks:
- If emoji still display as boxes or question marks, the program will use short ASCII fallbacks like "[HIT]" or "[X]".
- For PowerShell Core (pwsh) or Windows Terminal the UTF-8 handling is usually better.

If you'd like, I can adjust the Java program to detect the console encoding more robustly or provide a command-line flag to force ASCII-only output.
