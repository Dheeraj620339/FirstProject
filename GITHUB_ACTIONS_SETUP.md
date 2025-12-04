# GitHub Actions Setup Instructions

## Overview
Your GitHub Actions workflow has been created at [`.github/workflows/build_and_release.yml`](file:///C:/Users/manvi/AndroidStudioProjects/DheerajBioApp/.github/workflows/build_and_release.yml). To complete the setup, you need to:

1. Generate an Android signing keystore
2. Configure GitHub Secrets
3. Update your `app/build.gradle.kts` to use the keystore for signing

---

## Step 1: Generate Android Keystore

Since `keytool` wasn't found in your system PATH, you can generate the keystore using one of these methods:

### Option A: Using Android Studio
1. Open Android Studio
2. Go to **Build** → **Generate Signed Bundle / APK**
3. Select **APK** or **AAB**
4. Click **Create new...**
5. Fill in the details:
   - **Key store path**: Choose a location (e.g., `my-release-key.keystore`)
   - **Password**: `password123` (or your preferred password)
   - **Alias**: `my-key-alias`
   - **Key password**: `password123` (or your preferred password)
   - Fill in the certificate information
6. Click **OK**

### Option B: Using Command Line (if you have JDK installed)
Find your JDK installation and run:
```bash
"C:\Path\To\JDK\bin\keytool.exe" -genkey -v -keystore my-release-key.keystore -alias my-key-alias -keyalg RSA -keysize 2048 -validity 10000
```

You'll be prompted for passwords and certificate details.

---

## Step 2: Convert Keystore to Base64

After generating the keystore, convert it to Base64:

```powershell
[Convert]::ToBase64String([IO.File]::ReadAllBytes("my-release-key.keystore")) | Out-File keystore_base64.txt
```

This will create a `keystore_base64.txt` file with the encoded keystore.

---

## Step 3: Configure GitHub Secrets

1. Go to your GitHub repository: https://github.com/Dheeraj620339/FirstProject
2. Click **Settings** → **Secrets and variables** → **Actions**
3. Click **New repository secret** and add these four secrets:

| Secret Name | Value |
|------------|-------|
| `KEYSTORE_BASE64` | Paste the entire content from `keystore_base64.txt` |
| `KEYSTORE_PASSWORD` | `password123` (or your chosen password) |
| `KEY_ALIAS` | `my-key-alias` |
| `KEY_PASSWORD` | `password123` (or your chosen key password) |

---

## Step 4: Update app/build.gradle.kts

Add the following signing configuration to your `app/build.gradle.kts`:

```kotlin
android {
    // ... existing config ...
    
    signingConfigs {
        create("release") {
            storeFile = file(System.getenv("KEYSTORE_PATH") ?: "my-release-key.keystore")
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = System.getenv("KEY_ALIAS")
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }
    
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            // ... other release config ...
        }
    }
}
```

---

## Step 5: Test the Workflow

Once you've pushed the code and configured the secrets:
1. Go to your repository's **Actions** tab
2. You should see the workflow running automatically (triggered by the push to `main`)
3. If successful, you'll find:
   - APK and AAB artifacts in the workflow run
   - A new release created with the version from your `build.gradle.kts`

---

## Important Notes

> [!CAUTION]
> Never commit the `.keystore` file to your repository! Add it to `.gitignore`.

> [!TIP]
> Keep your keystore file and passwords in a safe place. If you lose them, you won't be able to update your app on the Play Store.

> [!NOTE]
> The workflow extracts the version name from `app/build.gradle.kts`. Ensure you have a `versionName` defined there.
