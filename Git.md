# Git


### Adding an existing project to GitHub 
```bash
    1. cd project folder
    2. git init
    3. git add .  (or git add -A)
    4. git commit -m "Initial commit"
    5. visit [GitHub], create a new repo, go to "quick setup", copy the git HTTP link URl
    6. git remote add origin ""remote repository URL
    # Sets the new remote
    7. git remote -v # Verifies the new remote URL
    8. git push -u origin master
```
### Untrack folder
```bash
git rm -r --cached <your directory>
#The -r option causes the removal of all files under your directory.
#The --cached option causes the files to only be removed from git  index, not your working copy. By default git rm <file> would delete <file>.
```
### Git push
```bash
git push origin master
每次我们要提交代码到服务器上时，都会使用到git push。
git push命令会有两个参数，origin - 远端仓库的名字，master -以及分支的名字
```
### Git commit
```bash
git commit -a -m "commit description"
#change multiple file
git commit -m ""
#only change one file
```
