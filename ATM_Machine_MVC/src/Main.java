import model.ATM;
import view.ATMView;
import controller.ATMController;

public class Main {
    public static void main(String[] args) {
        ATM model = new ATM();
        ATMView view = new ATMView();
        ATMController controller = new ATMController(model, view);
    }
}
