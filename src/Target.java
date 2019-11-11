import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwGetMouseButton;

import edu.utc.game.*;

public class Target extends GameObject{
	private boolean pressed = false;
	// construct a target in a random location within the bounds of the UI
		public Target(int x, int y, int w, int h) {
		
			this.hitbox.setSize(w, h);
			this.setColor(1,0,1);
			this.hitbox.setLocation(x, y);
		}	
		
		public boolean mouseButtonIsPressed(int button)
		{
			if(glfwGetMouseButton(Game.ui.getWindow(), button) == GLFW_RELEASE) {
				pressed = true;
			}
			if(glfwGetMouseButton(Game.ui.getWindow(), button) == GLFW_PRESS && pressed) {
				pressed = false;
				return true;
			}
			else {
				return false;
			}
			
		}
		
		// if the space key is pressed, check to see if we should deactivate this target
		public void update(int delta)
		{			
			
		}
		
		public boolean clicked(){
			boolean clicked = false;
			boolean firstTime = true;
			if(mouseButtonIsPressed(0)) {
				XYPair<Integer> lastClick = Game.ui.getMouseLocation();
				int xMouse = lastClick.x;
				int yMouse = lastClick.y;
				if(this.getHitbox().contains(xMouse, yMouse)){
					clicked = true;
				}	

			}
			return clicked;
		}
	
	}