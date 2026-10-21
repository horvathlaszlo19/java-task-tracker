# Task Tracker CLI

A simple command-line application for managing tasks, built as part of the [roadmap.sh Task Tracker project](https://roadmap.sh/projects/task-tracker).

## Features

- Add, update, and delete tasks.
- Mark tasks as `todo`, `in-progress`, or `done`.
- List all tasks or filter them by status.
- Store tasks persistently in a JSON file.

## Usage

```bash
# Add a task
task-cli add "Buy groceries"

# Update a task
task-cli update 1 "Buy groceries and cook dinner"

# Delete a task
task-cli delete 1

# Change task status
task-cli mark-in-progress 1
task-cli mark-done 1

# List all tasks
task-cli show-all

# List tasks by status
task-cli show-todo
task-cli show-in-progress
task-cli show-done