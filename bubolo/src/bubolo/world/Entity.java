package bubolo.world;

import java.io.Serializable;

/**
 * Base class for game objects. Anything that is part of the game logic should
 * inherit from this class.
 * @author BU673 - Clone Industries
 */
public abstract class Entity implements Serializable
{
	// Used when serializing and deserializing.
	private static final long serialVersionUID = -7558368147503376322L;

	/**
	 * Gets the entity's x position.
	 * @return the entity's x position.
	 */
	public float getX()
	{
		// TODO (cdc - 2/9/2014): properly implement this. Initially, I threw a 
		// NotImplementedException when this was called. However, that made writing
		// passable tests for the graphics code impossible.
		return 0.f;
	}
	
	/**
	 * Gets the entity's y position.
	 * @return the entity's y position.
	 */
	public float getY()
	{
		// TODO (cdc - 2/9/2014): properly implement this. Initially, I threw a 
		// NotImplementedException when this was called. However, that made writing
		// passable tests for the graphics code impossible.
		return 0.f;
	}
}