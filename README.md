# DJ Music App

## Project Overview
DJ Music App is a native Android application built with Kotlin and Jetpack Compose based on the provided Figma design.
The focus of this project is to replicate the UI as closely as possible, maintain clean code organization, and support basic user interactions.

## Screens Implemented
- Home Screen
- Settings Screen
- Library / Audio Picker Screen
- Sound Merger Screen
- DJ Mixer Screen

## Tech Stack
- Kotlin
- Jetpack Compose
- Android Studio
- Navigation Compose
- MVVM (simple/lightweight structure)
- Static / Mock Data

## Project Structure
- `core/`
    - navigation
- `features/`
    - home
    - settings
    - library
    - merger
    - mixer
- `ui/theme/`
- `data/model/`

## How to Run the App

1. Open Android Studio.
2. Select **Open** and choose the project folder.
3. Wait until Gradle sync completes successfully.
4. Connect an Android device or start an emulator.
5. Select the `app` configuration in the top toolbar.
6. Click **Run** to launch the project.

### Notes
- This project uses static/mock data only.
- No backend configuration is needed.
- No additional environment variables are required.

## Assumptions
- Static/mock data is used because backend integration is not required in the test scope
- Audio lists are represented using mock local data
- Some actions such as audio processing are represented at UI level only
- Where design details were not fully specified, reasonable UI assumptions were made to stay visually consistent

## Limitations
- No backend integration
- No real audio mixing / merging processing
- No persistent local storage for settings switches unless explicitly required
- Some screens focus on UI and interaction flow rather than full functional implementation