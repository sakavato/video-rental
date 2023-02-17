public class InitCommand extends Command {
    private VRUI ui;
    public InitCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.init();
    }
}