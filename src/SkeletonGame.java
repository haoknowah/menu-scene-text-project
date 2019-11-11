import edu.utc.game.*;

public class SkeletonGame extends Game{

	public Menu menu;
	public SkeletonGameScene skeletonGame;
	public Pause pause;
	public Victory victory;
	
	public static void main(String[] args)
	{
		//System.setProperty("org.lwjgl.librarypath", new File("natives").getAbsolutePath()); 
		SkeletonGame game = new SkeletonGame();
		game.gameLoop();
	}
	
	public SkeletonGame()
	{
		initUI(1920, 1080, "Skeleton Game");
		menu = new Menu();
		skeletonGame = new SkeletonGameScene();
		pause = new Pause(skeletonGame, menu);
		victory = new Victory();
		this.setScene(menu);
		menu.setScene(skeletonGame);
		skeletonGame.setPauseScene(pause);
		skeletonGame.setVictoryScene(victory);
		victory.setGameScene(skeletonGame);
		victory.setMenuScene(menu);
		//glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

	}
	
}


