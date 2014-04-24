/**
 *
 */

package bubolo.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Base class for ui screens that are drawn in the LWJGL window.
 * 
 * @author BU CS673 - Clone Productions
 */
public abstract class Screen
{
	/** The scene2d.ui stage. **/
	protected final Stage stage;
	
	/** The base table for the screen. **/
	protected final Table layout;
	
	/**
	 * Default constructor.
	 */
	protected Screen()
	{
		stage = new Stage();
		layout = new Table();

		layout.setFillParent(true);
	    layout.top();
	    stage.addActor(layout);
		
		Gdx.input.setInputProcessor(stage);
	}
	
	/**
	 * Updates and draws the screen.
	 */
	public final void update()
	{
		update(false);
	}
	
	/**
	 * Updates and draws the screen.
	 * @param debug true if the screen should be drawn in debug mode.
	 */
	public final void update(boolean debug)
	{
		if (debug)
		{
			layout.debug();
		}
		
		stage.act();
		stage.draw();
		
		if (debug)
		{
			Table.drawDebug(stage);
		}
	}
}