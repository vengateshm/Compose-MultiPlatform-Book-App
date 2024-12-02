This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

# Screenshots

<img src = "https://github.com/user-attachments/assets/a6bd8803-9cc8-4810-9a55-e7d962a17ab2" width="240" height="480"/> <img src = "https://github.com/user-attachments/assets/71985c85-060b-44c0-9b6b-03cde782c76d" width="240" height="480"/>
<img src = "https://github.com/user-attachments/assets/d09efaf6-1c07-4158-9224-a645767da675" width="240" height="480"/> 
