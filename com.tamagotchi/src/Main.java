import model.Animal;
import service.UserInputService;

public class Main {
    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        final Animal animal = userInputService.userInputAnimalTypeName();
        userInputService.doActions(animal);
    }
}