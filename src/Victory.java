import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import edu.utc.game.*;

public class Victory implements Scene {
		Scene menu;
		SkeletonGameScene gameScene;
		Score score = new Score();
		Background bg = new Background();
		Target exit = new Target(1822, 0, 73, 33);
		Text scoreText = new Text(100, 27, 30, 30, "0");
		Text scoreTime = new Text(50, 1000, 30, 30, "0");
		Sound win = new Sound("res/Win.wav");

		
		public Victory() {
			bg.ChangeBG("res/victory.png");
		}
		
		public void setMenuScene(Scene menu) {
			this.menu = menu;
		}
		
		public void setGameScene(SkeletonGameScene gameScene) {
			this.gameScene = gameScene;
		}
		
		public void setScore(Score score) {
			this.score = score;
			scoreText = new Text(100, 27, 30, 30, String.valueOf(score.getScoreValue()));
			scoreTime = new Text(215, 1020, 35, 35, String.valueOf(score.getTime()));
			win.play();
		}
		
		
		public Scene drawFrame(int delta) {
			glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
			
			if(exit.clicked()) {
				score.resetScore();
				gameScene.setScore(score);
				return menu;
			}
			

			//update all game objects
			exit.update(delta);
			bg.update(delta);
			//draw all game objects			
		
			exit.draw();
			bg.draw();
			scoreText.draw();
			scoreTime.draw();
			
			

			
			//to change a scene, return other instead of this.
			return this;
		}
		
	}