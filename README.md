# Java-Mini-Project
# Blood Bank Management

# Introduction

This is our Java Mini Project, which is a part of term evaluation of Java SBL (Skill based Lab), of SEM III, 2nd Year.
It's a semester-long project to be done in a team, with a mentor.

# Group Details

1. Project Mentor - Dr. Ravita Mishra
2. Team members - We have a team of 5 students, namely
    ▪️ Frontend : Siddharth Jha, Roll 25
    ▪️ Frontend : Sushant Tulasi, Roll 62
    ▪️ Frontend : Vaibhav Boudh, Roll 08
    ▫️ Backend : Girish Chougule, Roll 11
    ▫️ Backend : Varun Gupta, Roll 20

# Directory Structure

|-- bin/ (This is where compiled .class files will be generated)
|-- src/
|   |-- com/
|       |-- About.java
|       |-- Donate.java
|       |-- Donor.java
|       |-- DonorDAO.java
|       |-- Home.java
|       |-- Login.java
|       |-- Search.java
|-- lib/
|   |-- YourJDBCJarFile.jar
|-- resources/
|   |-- blood.png
|-- README.md (Your project's documentation) (this file)

1. bin/: This directory is where compiled .class files are generated when you compile your Java code. It's a good practice to keep compiled files separate from your source code.
2. lib/: You can place external libraries or JAR files here. In your case, it contains the JDBC JAR file.
3. resources/: This directory is for storing non-source code resources that your project uses. In your case, it contains the blood.png image.
4. src/: This directory contains your source code files. In your case, it includes Java files like About.java, Donate.java, Donor.java, and others.
5. README.md: This is a common practice for providing documentation and information about your project. You can use Markdown format to describe your project, its usage, and any instructions for setting it up.

💠 Regarding the com/ folder within the src/ directory,
it's a common convention in Java to organize your source code under a package structure, and com is a common package name to start with.
You can place your Java files (About.java, Donate.java, etc.) under this package to follow standard Java package naming conventions.
💠 For example, the package declaration in your Java files would look like:
	package com;