import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import edu.utc.game.*;

public class Menu implements Scene {
		Scene gameScene;	
		Background bg = new Background();
		public boolean firstStart = true;
		
		Target launch = new Target(845, 383, 220, 62);
		Target exit = new Target(906, 583, 109, 78);
		
		public Menu() {
			bg.ChangeBG("res/MenuBG.png");
		}
		
		public void setScene(Scene gameScene) {
			this.gameScene = gameScene;
		}
		
		public Scene drawFrame(int delta) {
			glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
			
			if(launch.clicked()) {
				return gameScene;
			}	
			if (exit.clicked()) {
				Game.ui.destroy();
			}
			
			//update all game objects
			launch.update(delta);
			exit.update(delta);
			bg.update(delta);
			//draw all game objects
			
			launch.draw();
			exit.draw();
			bg.draw();

			firstStart = false;
			//to change a scene, return other instead of this.
			return this;
		}
		
	}