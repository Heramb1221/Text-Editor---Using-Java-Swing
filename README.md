
# Text Editor - Using Java Swing


## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)
## Project Overview
The Text Editor - Using Java Swing is a lightweight desktop text editor built in Java. This application includes essential text editing features, offering users an efficient tool for tasks such as note-taking, writing, and simple text formatting.
## Features
- File Operations: Open, Save, and Exit
- Font Customization: Choose font style, size, and color
- Word Count and Line Count: Real-time status bar displaying word and line count
- Text Wrapping: Word wrap for better readability
- Scrollable Editor: Scroll pane for navigating large text
## Technologies Used
- **Java Swing** for the graphical user interface
- **Java AWT** for layout management and event handling

To run the project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Heramb1221/Text-Editor---Using-Java-Swing.git
   ```
2. Navigate to the project directory:
    ```bash
   cd Text-Editor---Using-Java-Swing
   ```
3. Compile the Java file (assuming you have JDK installed):
    ```bash
   javac editor/Texteditor.java
   ```
4. Run the application:
    ```bash
   java editor.Texteditor
   ```
Make sure you have audio files available on your system to test the player functionality.
## Usage
- Launch the application by running java editor.Texteditor.
- Use the File menu to open an existing text file or save your work.
- Adjust the Font options to set the text size and select a different Font Style.
- Click on Color to customize the text color using the color chooser.
- Check the real-time status bar for word and line count.


## Code Structure
```bash
Text-Editor---Using-Java-Swing/
├── editor/
│   └── Texteditor.java       # Main application code with UI components
├── icons/                    # Directory for application icons (optional)
├── screenshot.png            # Screenshot of the application (optional)
└── README.md                 # Project documentation

```


## Contributing
Contributions are greatly appreciated! To contribute to this project, please follow these guidelines:

1. Fork the repository on GitHub.
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature/YourFeature
   ```
3. Make your changes and commit them:
   ```bash
   git commit -m "Description of your changes"
   ```
4. Push your changes to your forked repository
   ```bash
   git push origin feature/YourFeature
   ```
5. Create a pull request detailing your changes for review.

## License
This project is licensed under the MIT License. See the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.


## Acknowledgements

 - Special thanks to the Java Sound API documentation for providing insights on audio playback.
 - Various online tutorials for inspiration on creating Swing-based applications


