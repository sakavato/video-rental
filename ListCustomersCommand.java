public class ListCustomersCommand extends Command {
    private VRUI ui;
    public ListCustomersCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.listVideos();
    }
}