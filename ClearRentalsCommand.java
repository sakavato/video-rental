public class ClearRentalsCommand extends Command {
    private VRUI ui;
    public ClearRentalsCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.clearRentals();
    }
}