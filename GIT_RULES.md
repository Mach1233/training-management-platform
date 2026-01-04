# Git Usage Rules (Solo Developer)

## Branch Strategy (GitFlow)
- **main**: Only for stable, tested releases. Never push directly—use pull requests (PRs).
- **develop**: For ongoing work. Commit here daily.
- **Feature branches**: For new tasks (e.g., `feature/setup-db`). Merge to develop via PR.
- **Release branches**: For preparing versions (e.g., `release/v1.0`). Merge to main and develop.
- **Hotfix branches**: For urgent fixes on main.

## Commit Rules
- Commit often (every 30-60 mins).
- Use descriptive messages: `git commit -m "Add .gitignore for Java/Node"`.
- Always push to remote.

## PR Rules
- Create PRs for merges (e.g., feature → develop).
- Review your own code before merging.

## Protection
- **main** requires PR approval and passing tests.

## Solo Tips
- Use GitHub Issues for tasks (e.g., Issue #1: "DB Setup").
- Link commits to issues.
