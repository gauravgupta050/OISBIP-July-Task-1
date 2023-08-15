import java.util.*;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void updatePassword(String newPassword) {
        password = newPassword;
        System.out.println("Password updated successfully.");
    }

    public String getUsername() {
        return username;
    }
}

class MCQ {
    private String question;
    private List<String> options;
    private int correctOption;

    public MCQ(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean checkAnswer(int selectedOption) {
        return selectedOption == correctOption;
    }
}

class Timer {
    private int seconds;

    public Timer(int seconds) {
        this.seconds = seconds;
    }

    public void start() {
        while (seconds > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds--;
        }
        System.out.println("Time's up!");
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a user
        User user = new User("user123", "password");

        // Login
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (user.authenticate(password)) {
            System.out.println("Login successful. Welcome, " + user.getUsername());

            // Update profile and password
            System.out.print("Do you want to update your password? (yes/no): ");
            String updatePasswordChoice = scanner.nextLine();
            if (updatePasswordChoice.equalsIgnoreCase("yes")) {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                user.updatePassword(newPassword);
            }

            // Selecting answers for MCQs
            List<String> options = Arrays.asList("Option A", "Option B", "Option C", "Option D");
            MCQ mcq = new MCQ("What is the capital of France?", options, 2);

            System.out.println(mcq.getQuestion());
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Select an option: ");
            int selectedOption = scanner.nextInt();

            if (mcq.checkAnswer(selectedOption)) {
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect answer.");
            }

            // Timer and auto submit
            Timer timer = new Timer(60); // 60 seconds
            System.out.println("Quiz will start in 3 seconds...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.start();

            // Closing session and Logout
            System.out.println("Quiz completed. Session closed.");
        } else {
            System.out.println("Login failed. Incorrect password.");
        }
    }
}