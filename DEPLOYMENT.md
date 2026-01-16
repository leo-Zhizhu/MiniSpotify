# Deployment Guide

## Uploading to GitHub

Follow these steps to upload the project to GitHub:

### Step 1: Update Remote URL

```bash
cd "/Users/zhizhu/iCloud云盘（归档）/Desktop/garbage/星蝶 StarryButterfly/LaiOffer/Spotify"
git remote set-url origin https://github.com/leo-Zhizhu/MiniSpotify-frontend.git
```

Or if you prefer SSH:
```bash
git remote set-url origin git@github.com:leo-Zhizhu/MiniSpotify-frontend.git
```

### Step 2: Verify Remote

```bash
git remote -v
```

You should see:
```
origin  https://github.com/leo-Zhizhu/MiniSpotify-frontend.git (fetch)
origin  https://github.com/leo-Zhizhu/MiniSpotify-frontend.git (push)
```

### Step 3: Push to GitHub

If the repository is empty:
```bash
git push -u origin master
```

If the repository has existing content and you want to overwrite it:
```bash
git push -u origin master --force
```

**Note**: Use `--force` only if you're sure you want to overwrite the remote repository.

### Step 4: Verify Upload

Visit https://github.com/leo-Zhizhu/MiniSpotify-frontend to verify all files are uploaded.

## Alternative: Using GitHub Desktop or Android Studio

1. **GitHub Desktop**:
   - Open GitHub Desktop
   - File > Add Local Repository
   - Select the project folder
   - Repository > Repository Settings > Remote
   - Set primary remote to: `https://github.com/leo-Zhizhu/MiniSpotify-frontend.git`
   - Click "Publish repository"

2. **Android Studio**:
   - VCS > Git > Remotes
   - Edit the origin URL to: `https://github.com/leo-Zhizhu/MiniSpotify-frontend.git`
   - VCS > Git > Push
   - Select master branch and push

## Troubleshooting

### Authentication Issues

If you get authentication errors:

1. **For HTTPS**: Use a Personal Access Token instead of password
   - GitHub Settings > Developer settings > Personal access tokens
   - Generate a new token with `repo` permissions
   - Use the token as password when prompted

2. **For SSH**: Ensure your SSH key is added to GitHub
   - Check: `ssh -T git@github.com`
   - If not configured, follow: https://docs.github.com/en/authentication/connecting-to-github-with-ssh

### Branch Name Issues

If your default branch is `main` instead of `master`:

```bash
git branch -M main
git push -u origin main
```

Or push to master:
```bash
git push -u origin master
```
