#!/bin/bash

# Script to push MiniSpotify project to GitHub
# Run this script from the project root directory

echo "🚀 Pushing MiniSpotify to GitHub..."

# Navigate to project directory
cd "/Users/zhizhu/iCloud云盘（归档）/Desktop/garbage/星蝶 StarryButterfly/LaiOffer/Spotify"

# Update remote URL
echo "📝 Updating remote URL..."
git remote set-url origin https://github.com/leo-Zhizhu/MiniSpotify-frontend.git

# Verify remote
echo "✅ Verifying remote..."
git remote -v

# Push to GitHub
echo "📤 Pushing to GitHub..."
git push -u origin master --force

echo "✅ Done! Check https://github.com/leo-Zhizhu/MiniSpotify-frontend"
