package game;

public class App {
    static Game m_Game;
    public static void init() {
        m_Game = new Game();
    }
    public static void render() {
        Game.printBoard();
    }
    public static void update() {
        Game.update();
    }
    
    public static void main(String[] args) {
        init();   
        while (!Game.isGameOver()) {
            render();
            update();
        }
    }
}
