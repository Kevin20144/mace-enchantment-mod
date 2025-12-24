BOOTSTRAP=scripts/bootstrap.sh

.PHONY: bootstrap build

bootstrap:
	@echo "Running bootstrap script (may require sudo)..."
	bash $(BOOTSTRAP)

build:
	@echo "Building with Gradle wrapper using JAVA_HOME if set..."
	JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ./gradlew build --no-daemon
