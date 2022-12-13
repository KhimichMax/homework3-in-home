package TodoList;

import Manager.Status;

public class Subtask extends Task {

    private Epic epic;

    public Subtask(String name, Epic epic) {
        super(name);
        this.epic = epic;
        super.setStatus(Status.NEW);
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
    }

}
