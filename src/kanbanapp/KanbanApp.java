package kanbanapp;

public class KanbanApp {

    public static void main(String[] args) {

        worker wk = new worker();
        while (true) { //displays kanban task app if login sucessful
            if (wk.signIn()) {
                wk.displayTaskApp();
            }
        }

    }

}
// -----------------------------------------------End of File-------------------------------------------------------------------//