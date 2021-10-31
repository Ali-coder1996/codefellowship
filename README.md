# Labs 16 and 17: CodeFellowship Login, Profiles & Posts

> ## description :
* `@GetMapping("/")` --> render Home Page
* `@GetMapping("/login")` --> render login Page
* `@PostMapping("/signup")` --> create new Application user
* `@GetMapping("/myProfile")` --> render the logged in user profile page
* `@GetMapping("/users/{id}")` --> render the profile page for specific user by its ***id***.


> ## Templates
* `Home` --> home page (used to handel the main route`/`)
* `login` --> used to preview the login form.
* `signup` --> used to preview the signup form.
* `profile` --> used to preview the user details and post

### go to clone app
cd ~/codefellowship
### run the app u don't need to have IDE
./gradlew bootRun
