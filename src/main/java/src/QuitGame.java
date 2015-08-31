package src;

/**
 * Created by Lucien.Minot on 4/13/2015.
 */
public class QuitGame implements GameOver {

    public static boolean quitGame = false;
    MessageDisplayer messager = new MessageHandler();

    @Override
    public void quitGame() {
        quitGame = true;
        messager.quittingGameMessage();
        System.exit(0);
    }

    public boolean GameExited(){
        return quitGame;
    }
}
