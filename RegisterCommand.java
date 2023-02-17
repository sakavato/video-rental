public class RegisterCommand extends Command {
    private VRUI ui;
    private String category;

    public RegisterCommand(VRUI ui, String category) {
        this.ui = ui;
        this.category = category;
    }

    @Override
    void execute() {
        ui.register(category);
    }
}