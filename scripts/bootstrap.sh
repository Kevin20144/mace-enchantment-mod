#!/usr/bin/env bash
set -euo pipefail

# Non-interactive bootstrap for Debian/Ubuntu environments
export DEBIAN_FRONTEND=noninteractive

echo "==> Updating package lists"
sudo apt-get update -y

echo "==> Installing OpenJDK 21 (non-interactive)"
sudo DEBIAN_FRONTEND=noninteractive apt-get install -y openjdk-21-jdk-headless

echo "==> Setting JAVA_HOME to OpenJDK 21"
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"

echo "==> Verifying java version"
java -version || true

echo "==> Running Gradle build (using project Gradle wrapper)"
# Run build with the local Gradle wrapper
JAVA_HOME="$JAVA_HOME" ./gradlew build --no-daemon

echo "==> Bootstrap complete"
