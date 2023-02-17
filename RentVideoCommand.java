public class RentVideoCommand extends Command {
    private VRUI ui;
    public RentVideoCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.rentVideo();
    }
}