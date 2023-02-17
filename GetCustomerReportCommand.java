public class GetCustomerReportCommand extends Command {
    private VRUI ui;
    public GetCustomerReportCommand(VRUI ui) {
        this.ui = ui;
    }

    @Override
    void execute() {
        ui.getCustomerReport();
    }
}