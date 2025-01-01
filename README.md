# TaskFlow
#### Video Demo: [Video Link](https://www.youtube.com/watch?v=7c-fikqmOY8)

#### Description:
# README

This project is a web application that combines personal finance management features with a task management system, all implemented using **Flask**, **SQLite**, and the CS50 library for Python. The main goal is for users to register stock movements (buying and selling shares), manage their cash balance, and simultaneously keep track of daily tasks with priorities and due dates. Below is a detailed explanation of each application component, the files that compose it, and the key design decisions that were made.

---

## General Description

The project is divided into two main sections:

1. **Finance Section (Finance App)**
   This section allows users to look up real-time stock quotes, buy and sell stocks, review their transaction history, and keep track of their available cash. It’s inspired by a classic CS50 project but expanded to be more robust and user-friendly.

2. **Task Section (Task Manager)**
   This part of the application provides an interface for users to create, view, and complete tasks. Each task has a title, a description, a priority level (high, medium, or low), and a due date. The goal is to help users manage their daily to-dos, marking tasks as completed once they’re finished.

Throughout the development process, design decisions were guided by the principles of code simplicity, interface clarity, and future scalability (for example, more advanced reporting or automatic notifications).

---

## Project Structure

The project primarily consists of the following files and folders:

- **`app.py`**
  Holds all the Flask routes and logic. It defines decorators like `@app.route()` to handle various application URLs (`/`, `/login`, `/register`, `/buy`, `/sell`, `/tasks`, `/stats`, and so on). It also includes business logic such as validations, database queries, and rendering Jinja templates.
  - In the finance part, `app.py` handles features like buying, selling, transaction history, and viewing the user’s portfolio.
  - In the tasks part, `app.py` includes routes for creating new tasks, updating their status, viewing stats, etc.

- **`finance.db`** (or `tasks.db`, depending on your configuration)
  This is the SQLite database where user credentials (username and password hash), stock transactions (symbol, price, date, and type), and tasks (title, priority, status) are stored, among other data. In this project, a single database is used to store both financial and task-related data, although it could be scaled to multiple databases in the future.

- **`helpers.py`**
  A utility file that includes helper functions such as `apology()` for rendering error messages to users, and `lookup()` for fetching real-time stock prices from an API (or a simulated service). It also defines the `login_required` decorator, which restricts access to certain routes unless the user is logged in.

- **`templates/`**
  A folder for the Jinja-based HTML templates. Within it:
  - **`layout.html`**: The base template that defines the overall site structure (header, navigation bar, footer). Other templates extend this one so they share the same layout and navigation.
  - **`index.html`**: The homepage, displaying the user’s current stock portfolio (owned stocks, total value, cash balance).
  - **`quote.html`** and **`quoted.html`**: Pages for looking up a stock symbol and displaying the quote.
  - **`buy.html`** and **`sell.html`**: Forms to buy or sell shares.
  - **`history.html`**: Shows the user’s stock transactions in chronological order.
  - **`register.html`** and **`login.html`**: Pages for user registration and login, respectively.
  - **`tasks.html`**: The interface for creating and listing tasks. It includes a form to add new tasks and a table to display existing tasks.
  - **`stats.html`**: A view that displays task statistics (completed vs. pending, daily completion rate, etc.) using **Chart.js** to present data in graphical form.

- **`static/`** (optional)
  A directory for static files such as custom CSS, images, or additional JavaScript. Many projects rely on frameworks like Bootstrap for styling, but this is where you would place any custom CSS or JS if you need it.

---

## Design Decisions

1. **Using Flask**
   Flask was chosen for its ease of use and flexibility in small- to medium-sized projects. It also integrates well with the CS50 library, making it straightforward to include features like database access and user authentication.

2. **Database Structure**
   - For the finance component, a conventional schema is used: a `users` table for login credentials and account balances, and a `transactions` table for each stock buy/sell (including symbol, price, date, and transaction type).
   - For tasks, a `tasks` table is created to store fields like `title`, `description`, `priority`, `status`, `due_date`, and `user_id` to associate tasks with a specific user. This ensures users only see and manage their own tasks.

3. **Route Protection**
   A custom decorator, `@login_required`, ensures that routes such as `/buy`, `/sell`, `/tasks`, and `/stats` require authentication. This secures sensitive information and prevents non-logged-in users from accessing restricted features.

4. **Error Handling and Validation**
   - The `apology()` function is used to render error pages when invalid inputs are provided, such as incorrect stock symbols or negative share numbers.
   - For tasks, the system checks that a task’s title is not empty, and that a valid priority is selected.

5. **Statistics with Chart.js**
   On the `/stats` route, two main charts are displayed: a pie chart showing the proportion of completed versus pending tasks, and a bar chart representing daily completions. This provides a quick visual overview of the user’s performance and can motivate them to complete more tasks.

---

## How to Run the Project

1. **Install Dependencies**
   - Clone this repository and navigate to the project folder.
   - (Optional) Create a virtual environment and then install dependencies via `pip install -r requirements.txt` if provided, or install them manually:
     ```bash
     pip install flask cs50
     ```

2. **Initialize the Database**
   - If there are any scripts provided for database creation, run them:
     ```bash
     flask run
     ```
   - Alternatively, make sure you have `finance.db` properly set up if no automatic scripts are available.

3. **Run the Application**
   - Type:
     ```bash
     flask run
     ```
   - Open your browser and go to `http://127.0.0.1:5000/`. You should now see the homepage, where you can register or log in.

---

## Future Extensions

- **Notifications**: Implement a system to notify users (e.g., via email or pop-ups) when tasks are close to their due dates.
- **Additional Charts and Reports**: Expand the financial report section to include more detailed tracking of portfolio value over time.
- **Premium Features**: Introduce a “premium user” tier with added functionalities, such as higher cash limits or advanced task assignment features.

---

## Conclusion

This project demonstrates how to integrate two different functionalities—managing a stock portfolio and tracking daily tasks—within a single web environment. Special attention was given to code organization, application security (through login routes and password hashing with `generate_password_hash`), and user experience (with clearly organized pages and straightforward navigation).

Choosing **Flask** provides the flexibility needed to scale or extend the project easily. Relying on an SQLite database offers a simple, convenient setup sufficient for personal or academic-scale projects. Meanwhile, integrating libraries such as **Chart.js** in the `/stats` page enhances the user experience with visually appealing, motivational analytics.

We hope this README gives you a comprehensive overview of the project’s architecture, its files, and the rationale behind each design choice. Thank you for taking the time to review it, and we hope it proves useful for your own learning or for building similar projects!

#### Installation:
1. Clone this repository:
   ```bash
   git clone <repository-link>
   cd taskflow
