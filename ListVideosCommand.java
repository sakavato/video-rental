public class ListVideosCommand extends Command {
    private VRUI ui;
    public ListVideosCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.listCustomers();
    }
}