public class ToDo extends Task{
    protected String type = "T";
    public ToDo(int index, String description) {
        super(index, description);
    }

    @Override
    public String getTask() {
        return index + ". [" + type + "][" + getStatusIcon() + "] " + description;
    }
}
