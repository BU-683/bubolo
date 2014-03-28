package bubolo.world.entity.concrete;

import java.util.UUID;

import bubolo.util.AdaptiveTileChecker;
import bubolo.world.Adaptable;
import bubolo.world.World;
import bubolo.world.entity.Terrain;

/**
 * Road is a Terrain type that offers tanks improved movement speed.
 * 
 * @author BU CS673 - Clone Productions
 */
public class Road extends Terrain implements Adaptable
{
	/**
	 * Used when serializing and de-serializing.
	 */
	private static final long serialVersionUID = -5302600252810938564L;

	private int tilingState = 0;

	/**
	 * Intended to be generic -- this is a list of all of the StationaryEntities classes that should
	 * result in a valid match when checking surrounding tiles to determine adaptive tiling state.
	 */
	private Class[] matchingTypes = new Class[] { Road.class };

	/**
	 * Construct a new Road with a random UUID.
	 */
	public Road()
	{
		super();
	}

	/**
	 * Construct a new Road with the specified UUID.
	 * 
	 * @param id
	 *            is the existing UUID to be applied to the new Road.
	 */
	public Road(UUID id)
	{
		super(id);
	}

	@Override
	public void update(World w)
	{
		super.update(w);
		updateTilingState(w);
	}

	@Override
	public void updateTilingState(World w)
	{
		if (this.getTile() != null)
		{
			setTilingState(AdaptiveTileChecker.getTilingState(this.getTile(), w, matchingTypes));
		}
		else
		{
			setTilingState(0);
		}
	}

	@Override
	public int getTilingState()
	{
		return tilingState;
	}

	@Override
	public void setTilingState(int newState)
	{
		tilingState = newState;
	}

	// TODO: Add Road functionality!
}
