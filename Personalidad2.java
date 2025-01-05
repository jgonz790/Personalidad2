package Personalidad2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Personalidad2 {

    private String[][] questions;

    public Personalidad2() {
        questions = new String[10][];

        questions[0] = new String[]{"You like the authority", "You are enthusiastic", "You are a sentimental person", "You like the instructions"};
        questions[1] = new String[]{"Take the charge", "You take the risks", "Loyal", "Accurate in every step of the life"};
        questions[2] = new String[]{"Deterministic guy, straight to the point", "Entrepreneur", "Calm, peaceful", "Consistent...you just go for it"};
        questions[3] = new String[]{"You like the authority", "You are enthusiastic", "You are a sentimental person", "You like the instructions"};
        questions[4] = new String[]{"You like the authority", "You are enthusiastic", "You are a sentimental person", "You like the instructions"};
        questions[5] = new String[]{"Take the charge", "You take the risks", "Loyal", "Accurate in every step of the life"};
        questions[6] = new String[]{"Deterministic guy, straight to the point", "Entrepreneur", "Calm, peaceful", "Consistent...you just go for it"};
        questions[7] = new String[]{"You like the authority", "You are enthusiastic", "You are a sentimental person", "You like the instructions"};
        questions[8] = new String[]{"You like the authority", "You are enthusiastic", "You are a sentimental person", "You like the instructions"};
        questions[9] = new String[]{"Take  the charge", "You take the risks", "Loyal", "Accurate in every step of the life"};
    }

    public String askQuestions() {
        int total1 = 0, total2 = 0, total3 = 0, total4 = 0;
        Scanner sc = new Scanner(System.in);

        for (int q = 0; q < questions.length; q++) {
            System.out.println("Please select the answer that describes you best:");

            System.out.println("1. " + questions[q][0]);
            System.out.println("2. " + questions[q][1]);
            System.out.println("3. " + questions[q][2]);
            System.out.println("4. " + questions[q][3]);

            Set<Integer> selectedOptions = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                if (i == 3) { 
                    int remainingOption = findRemainingOption(selectedOptions);
                    selectedOptions.add(remainingOption);
                    total4 += remainingOption;
                    System.out.println("Automatically selected the remaining option: " + remainingOption);
                    break;
                }

                int n;
                while (true) {
                    System.out.println("Select option for statement " + (i + 1) + ": ");
                    try {
                        n = Integer.parseInt(sc.nextLine());
                        if (n > 0 && n < 5 && !selectedOptions.contains(n)) {
                            selectedOptions.add(n);
                            break;
                        } else {
                            System.out.println("Invalid answer. Please enter a unique number between 1 and 4.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid answer. Please enter a number between 1 and 4.");
                    }
                }
                switch (i) {
                    case 0:
                        total1 += n;
                        break;
                    case 1:
                        total2 += n;
                        break;
                    case 2:
                        total3 += n;
                        break;
                }
            }

            System.out.println("total1= " + total1);
            System.out.println("total2= " + total2);
            System.out.println("total3= " + total3);
            System.out.println("total4= " + total4);
        }

        return evaluate(total1, total2, total3, total4);
    }

    private int findRemainingOption(Set<Integer> selectedOptions) {
        for (int i = 1; i <= 4; i++) {
            if (!selectedOptions.contains(i)) {
                return i;
            }
        }
        return -1; 
    }

    public String evaluate(int total1, int total2, int total3, int total4) {
        if (total1 > Math.max(Math.max(total2, total3), total4)) {
            return "Personality Type 1";
        } else if (total2 > Math.max(Math.max(total1, total3), total4)) {
            return "Personality Type 2";
        } else if (total3 > Math.max(Math.max(total2, total1), total4)) {
            return "Personality Type 3";
        } else {
            return "Personality Type 4";
        }
    }

    public static void main(String[] args) {
        Personalidad2 pt = new Personalidad2();
        System.out.println(pt.askQuestions());
    }
}
