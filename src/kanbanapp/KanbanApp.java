package kanbanapp;

public class KanbanApp {

    public static void main(String[] args) {

        worker wk = new worker();
        while (true) {
            if (wk.signIn()) {
                wk.displayTaskApp();
            }
        }

    }

}
