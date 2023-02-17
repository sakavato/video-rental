public class ReturnVideoCommand extends Command {
    private VRUI ui;
    public ReturnVideoCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.returnVideo();
    }
}