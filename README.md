[![GitHub Pre-Release](https://img.shields.io/github/release-pre/CozmycDev/ArclightInteractionFix.svg)](https://github.com/CozmycDev/ArclightInteractionFix/releases)
[![Github All Releases](https://img.shields.io/github/downloads/CozmycDev/ArclightInteractionFix/total.svg)](https://github.com/CozmycDev/ArclightInteractionFix/releases)
![Size](https://img.shields.io/github/repo-size/CozmycDev/ArclightInteractionFix.svg)

# Arclight Interaction Fix

A bodge fix for the **PlayerInteractEvent** bug in Arclight, where interactions are not detected by plugins when looking **West**.

## 🔧 About
**ArclightInteractionFix** is designed primarily for **[ProjectKorra](https://github.com/ProjectKorra/ProjectKorra)** server admins but may also work with other plugins affected by the same Arclight issue. This plugin ensures that **PlayerInteractEvent** is properly triggered by handling **PlayerAnimationEvent** and injecting a fake interaction when necessary.

This is intended as a **temporary fix** until the Arclight developers address the issue—though there’s no clear timeline for an official resolution. This repository will be archived whenever that happens.

## 🛠️ Installation
1. Download the latest release from [Releases](https://github.com/CozmycDev/ArclightInteractionFix/releases).
2. Place the JAR file into your server's `plugins` folder.
3. Restart your server.

## ❓ Issues & Support
If you encounter any issues, please report them in the [Issues](https://github.com/CozmycDev/ArclightInteractionFix/issues) tab.

## ⚡ Compatibility
- ✅ Designed for **ProjectKorra** on **Arclight**
- ✅ Tested on **Arclight 1.20.1+**
- ✅ May work with other plugins affected by this bug

---

## Credits
- LuxaelNI for helping discover the root cause, test, and fix.
- The ProjectKorra team for their tireless work.
- The Arclight team for making the best damned hybrid I've used in years.
