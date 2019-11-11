import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import java.util.List;
import edu.utc.game.*;

public class SkeletonGameScene implements Scene {
		Pause pauseScene;
		Victory victoryScene;
		Score score = new Score();
		Background bg = new Background();
		Target pause = new Target(1822, 0, 73, 33);
		Target click = new Target(700, 440, 521, 152);
		List<Text> scoreTexts = new java.util.ArrayList<Text>();
		Text scoreText = new Text(100, 27, 30, 30, "0");

		
		public SkeletonGameScene() {
			bg.ChangeBG("res/game.png");
			for(int i = 0; i <= 10; i++) {
				scoreTexts.add(new Text(100, 27, 30, 30, String.valueOf(i))); 
			}
		}
		
		public void setPauseScene(Pause pauseScene) {
			this.pauseScene = pauseScene;
		}

		public void setVictoryScene(Victory victoryScene) {
			this.victoryScene = victoryScene;
		}
		
		public void setScore(Score score) {
			this.score = score;
			scoreText = scoreTexts.get(score.getScoreValue());
		}
		
		
		public Scene drawFrame(int delta) {
			glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
			//System.out.println(score.getTime());
			if(pause.clicked()) {
				pauseScene.setScore(score);
				score.pauseTime();
				return pauseScene;
			}	
			if (click.clicked()) {
				if(score.getScoreValue() == 0) {
					score.startTime();
				}
				score.setScoreValue(score.getScoreValue() + 1);
				scoreText = scoreTexts.get(score.getScoreValue());
			}
			if(score.getScoreValue() == 10) {
				victoryScene.setScore(score);
				score.pauseTime();
				return victoryScene;
			}

			//update all game objects
			pause.update(delta);
			click.update(delta);
			bg.update(delta);
			//draw all game objects			
		
			pause.draw();
			click.draw();
			bg.draw();
			scoreText.draw();
			
			

			
			//to change a scene, return other instead of this.
			return this;
		}
		
	}