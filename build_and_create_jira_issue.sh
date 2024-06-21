#!/bin/bash

# Run the Maven build
mvn clean test --file Automation_Scripts/pom.xml
EXIT_CODE=$?

# Check if the build failed
if [ $EXIT_CODE -ne 0 ]; then
  echo "Build failed, creating Jira issue..."
  pipe: atlassian/jira-create-issue:0.7.0
  variables:
    JIRA_BASE_URL: $JIRA_BASE_URL
    JIRA_USER_EMAIL: $JIRA_USER_EMAIL
    JIRA_API_TOKEN: $JIRA_API_TOKEN
    JIRA_PROJECT: $JIRA_PROJECT
    JIRA_ISSUE_TYPE: "Bug"
    JIRA_ISSUE_SUMMARY: "Build Failure: $(date +'%Y-%m-%d %H:%M:%S')"
    JIRA_ISSUE_DESCRIPTION: "This issue is created from Bitbucket Pipelines."
else
  echo "Build succeeded."
fi

exit $EXIT_CODE
