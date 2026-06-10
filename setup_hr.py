import os
import re
import subprocess

def get_target_directory():
    # List all directories, ignoring hidden ones like .git
    dirs = [d for d in os.listdir('.') if os.path.isdir(d) and not d.startswith('.')]
    
    print("\n--- Select a Directory ---")
    for idx, d in enumerate(dirs):
        print(f"{idx + 1}. {d}")
    print(f"{len(dirs) + 1}. [Create new directory]")
    
    choice = input("Enter choice (number): ")
    
    try:
        choice_idx = int(choice) - 1
        if 0 <= choice_idx < len(dirs):
            return dirs[choice_idx]
        elif choice_idx == len(dirs):
            new_dir = input("Enter new directory name: ")
            os.makedirs(new_dir)
            return new_dir
    except (ValueError, IndexError):
        print("Invalid choice, defaulting to current directory.")
    
    return "."

def create_and_commit():
    # 1. Select destination
    target_dir = get_target_directory()
    os.chdir(target_dir) # Move into the chosen directory
    
    # 2. Get File and Code details
    filename = input("Enter filename (e.g., ElectronicsShop): ").strip()
    if not filename.endswith(".java"):
        filename += ".java"
    
    print("Paste code (Ctrl+D to finish):")
    lines = []
    while True:
        try:
            line = input()
            lines.append(line)
        except EOFError:
            break
    code = "\n".join(lines)

    # 3. Sanitize
    code = re.sub(r'package\s+.*?;', '', code)
    class_name = os.path.splitext(filename)[0]
    code = re.sub(r'public\s+class\s+\w+', f'public class {class_name}', code)

    # 4. Write to file
    with open(filename, 'w') as f:
        f.write(code)
    print(f"Created {filename} in {os.getcwd()}")

    # 5. Git Automation
    try:
        subprocess.run(["git", "add", filename], check=True)
        subprocess.run(["git", "commit", "-m", f"Add solution: {class_name} in {target_dir}"], check=True)
        print("Git commit successful.")
    except subprocess.CalledProcessError as e:
        print(f"Git operation failed: {e}")

if __name__ == "__main__":
    create_and_commit()