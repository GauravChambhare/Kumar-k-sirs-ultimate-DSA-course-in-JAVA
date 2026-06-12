import os
import re
import subprocess

def navigate_to_target():
    """Allows nested navigation, going back, and creating folders."""
    while True:
        cwd = os.getcwd()
        print(f"\n--- Current Path: {cwd} ---")
        
        # List contents
        items = [d for d in os.listdir('.') if os.path.isdir(d) and not d.startswith('.')]
        
        print("Options:")
        print("  [..] Go back (parent directory)")
        print("  [.]  Select THIS directory")
        print("  [+]  Create new directory")
        print("-" * 20)
        
        for idx, item in enumerate(items):
            print(f"  {idx + 1}. {item}")
            
        choice = input("\nChoose (number to enter, '..', '.', or '+'): ").strip()
        
        if choice == '..':
            os.chdir('..')
        elif choice == '.':
            return os.getcwd()
        elif choice == '+':
            new_name = input("Enter new folder name: ")
            os.makedirs(new_name, exist_ok=True)
            os.chdir(new_name)
        elif choice.isdigit():
            idx = int(choice) - 1
            if 0 <= idx < len(items):
                os.chdir(items[idx])
            else:
                print("Invalid number.")
        else:
            print("Invalid input.")

def create_and_commit():
    # 1. Navigate to target
    target_dir = navigate_to_target()
    print(f"Target selected: {target_dir}")
    
    # 2. Get File details
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
    print(f"Successfully created {filename}")

    # 5. Git Automation
    try:
        subprocess.run(["git", "add", filename], check=True)
        subprocess.run(["git", "commit", "-m", f"Added solution: {class_name}"], check=True)
        print("Git commit successful.")
    except subprocess.CalledProcessError as e:
        print(f"Git operation failed: {e}")

if __name__ == "__main__":
    create_and_commit()