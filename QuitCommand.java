public class QuitCommand extends Command {
    private VRUI ui;
    public QuitCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.quit();
    }
}