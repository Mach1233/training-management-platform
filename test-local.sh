#!/bin/bash
echo "Starting local environment..."
docker compose -f docker/docker-compose.yml up -d

echo "Running Frontend Accessibility Tests..."
cd frontend && npm run test:a11y

echo "Running E2E Tests (Cypress)..."
# Assumes Cypress is installed/configured, or runs via npx
npx cypress run

echo "Running Performance Tests (JMeter)..."
# Placeholder for JMeter command
# jmeter -n -t tests/load.jmx

echo "Stopping environment..."
cd ..
docker compose -f docker/docker-compose.yml down
