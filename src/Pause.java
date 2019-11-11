import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import edu.utc.game.*;

public class Pause implements Scene {
		SkeletonGameScene gameScene;
		Scene menuScene;
		public Score score;
		Background bg = new Background();
		Target resume = new Target(840, 330, 240, 78);
		Target pauseExit = new Target(905, 759, 110, 78);
		Text scoreText;
		
		public Pause(SkeletonGameScene gameScene, Scene menuScene) {
			this.gameScene = gameScene;
			this.menuScene = menuScene;
			bg.ChangeBG("res/Pause.png");
		}
		
		public void setScore(Score score) {
			this.score = score;
			scoreText = new Text(100, 27, 30, 30, String.valueOf(score.getScoreValue()));
		}
		
		public Scene drawFrame(int delta) {
			glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
			
			if(resume.clicked()) {
				score.startTime();
				return gameScene;
			}	
			if (pauseExit.clicked()) {
				score.resetScore();
				gameScene.setScore(score);
				return menuScene;
			}
			
			
			//update all game objects
			resume.update(delta);
			pauseExit.update(delta);
			bg.update(delta);
			scoreText.update(delta);
			//draw all game objects
			
			pauseExit.draw();
			resume.draw();
			bg.draw();
			scoreText.draw();
			

			
			//to change a scene, return other instead of this.
			return this;
		}
		
	}