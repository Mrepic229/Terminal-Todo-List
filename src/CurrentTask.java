public enum CurrentTask {
    CLOSE{
        @Override
        public void doCurrentTask(TodoList list) {
            System.exit(0);
        }
        public String menuDisplay() {
            return "Close Program";
        }
    },
    
    READ {
        @Override
        public void doCurrentTask(TodoList list) {
            list.readJson();
            list.printTasks();
        }
        public String menuDisplay() {
            return "See your Todo list";
        }
    },

    WRITE {
        @Override
        public void doCurrentTask(TodoList list) {
            list.makeNewTask();
        }
        public String menuDisplay() {
            return "Add to your todo list";
        }
    },

    REMOVE {
        @Override
        public void doCurrentTask(TodoList list) {
            list.removeTask();
        }
        public String menuDisplay() {
            return "Remove task";
        }
    };

    public abstract String menuDisplay();
    public abstract void doCurrentTask(TodoList list);
}
