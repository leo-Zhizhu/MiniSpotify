# Deployment Instructions

Follow these steps to upload the project to GitHub:

## Step 1: Navigate to the project directory
```bash
cd "/Users/zhizhu/iCloud云盘（归档）/Desktop/garbage/星蝶 StarryButterfly/LaiOffer/spotify_backend"
```

## Step 2: Initialize Git (if not already initialized)
```bash
git init
```

## Step 3: Add the remote repository
```bash
git remote add origin https://github.com/leo-Zhizhu/MiniSpotify-Backend.git
```

## Step 4: Stage all files
```bash
git add .
```

## Step 5: Commit the changes
```bash
git commit -m "Initial commit: MiniSpotify Backend API"
```

## Step 6: Set the main branch (if needed)
```bash
git branch -M main
```

## Step 7: Push to GitHub
```bash
git push -u origin main
```

If you encounter authentication issues, you may need to:
- Use a Personal Access Token instead of password
- Or set up SSH keys for GitHub

## Alternative: If the repository already exists and has content

If the GitHub repository is not empty, you may need to pull first:
```bash
git pull origin main --allow-unrelated-histories
```

Then push:
```bash
git push -u origin main
```

## Verify

After pushing, verify your files are on GitHub:
- Visit: https://github.com/leo-Zhizhu/MiniSpotify-Backend
- Check that all source files are present
- Verify that `.mp3` files are NOT in the repository (they should be ignored)
