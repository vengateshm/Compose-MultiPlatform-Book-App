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
**Android**

<img src = "https://github.com/user-attachments/assets/a6bd8803-9cc8-4810-9a55-e7d962a17ab2" width="240" height="480"/> <img src = "https://github.com/user-attachments/assets/71985c85-060b-44c0-9b6b-03cde782c76d" width="240" height="480"/>
<img src = "https://github.com/user-attachments/assets/d09efaf6-1c07-4158-9224-a645767da675" width="240" height="480"/> 

**iOS**

<img src = "https://github.com/user-attachments/assets/62cff188-b68d-422a-bb35-574b32fbb21e" width="240" height="480"/> <img src = "https://github.com/user-attachments/assets/f9bc6c2a-4e17-413c-bae6-d35be91a6cd7" width="240" height="480"/>
<img src = "https://github.com/user-attachments/assets/ad1b2574-dc6c-405c-8fd2-f0dca52cdb2a" width="240" height="480"/>

**Desktop**

<img src = "https://github.com/user-attachments/assets/3b3ccab5-2a89-48bb-82ac-8230a80369c9" width="480" height="280"/> <img src = "https://github.com/user-attachments/assets/922546d0-01c4-4f29-a479-ed64ba2e7aa0" width="480" height="280"/>
<img src = "https://github.com/user-attachments/assets/fee0562b-00af-4eba-86fa-ada78c16b316" width="480" height="280"/> 
