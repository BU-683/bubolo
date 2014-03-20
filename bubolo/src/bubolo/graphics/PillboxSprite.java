package bubolo.graphics;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import bubolo.util.TextureUtil;
import bubolo.world.entity.concrete.Pillbox;

/**
 * The graphical representation of a Pillbox
 * 
 * @author BU673 - Clone Industries
 */
class PillboxSprite extends Sprite<Pillbox>
{
	private TextureRegion[][] frames;

	private int colorId = ColorSets.NEUTRAL;

	/**
	 * Constructor for the PillboxSprite. This is Package-private because sprites should
	 * not be directly created outside of the graphics system.
	 * 
	 * @param pillbox
	 *            Reference to the pillbox that this PillboxSprite represents.
	 */
	PillboxSprite(Pillbox pillbox)
	{
		super(DrawLayer.STATIONARY_ELEMENTS, pillbox);

		frames = TextureUtil.splitFrames(
				Graphics.getTexture(Graphics.TEXTURE_PATH + "pillbox.png"), 32, 32);
	}

	@Override
	public void draw(SpriteBatch batch, Camera camera, DrawLayer layer)
	{
		if (isEntityDisposed())
		{
			Sprites.getInstance().removeSprite(this);
			return;
		}
		else
		{
			if (!this.getEntity().isOwned())
			{
				colorId = ColorSets.NEUTRAL;
			}
			else if (this.getEntity().isLocalPlayer())
			{
				colorId = ColorSets.BLUE;
			}
			else
			{
				colorId = ColorSets.RED;
			}
			drawTexture(batch, camera, layer, frames[0][colorId]);

			/**
			 * Get the current HP of this object and determine currentState currentState =
			 * 1 is full health currentState = 0 to .99 represents percentage of total
			 * health available for Pillbox we have 3 appearances 100 = 5 99 - 75 = 4 74 -
			 * 50 = 3 49 - 25 = 2 24 - 1 = 1 0 = 0 ("dead" for Pillbox is inactive, but
			 * still present on screen)
			 */
			/**
			 * Get the current HP of this object and determine currentState currentState =
			 * 1 is full health currentState = 0 to .99 represents percentage of total
			 * health available for Pillbox we have 3 appearances 100 = 5 99 - 75 = 4 74 -
			 * 50 = 3 49 - 25 = 2 24 - 1 = 1 0 = 0 ("dead" for Pillbox is inactive, but
			 * still present on screen)
			 */

			// Below line may be very very wrong... but hopefully the goal is clear, a 0-5
			// value

			// int currentState = round(((getEntity().getHP() / getEntity().getMaxHP()) *
			// 100)
			// / 20);

			// this is here to prevent errors--will always show a "dead" pillbox
			// TODO: update this once the Pillbox entity has been created.
			// int currentState = 0;

			/*
			 * setRegion stuff is from:
			 * http://libgdx.badlogicgames.com/nightlies/docs/api/com/
			 * badlogic/gdx/graphics/g2d/TextureRegion.html#setRegion(int, int, int, int)
			 * x,y,width,height Assuming our focus is on lower left... i.e. start at 0,32
			 * and increase X as we move right?
			 */

			/*
			 * switch (currentState) { case 5: specificImage.setRegion(0, 0, 32, 32);
			 * drawTexture(batch, camera, layer, specificImage); break; case 4:
			 * specificImage.setRegion(32, 0, 32, 32); drawTexture(batch, camera, layer,
			 * specificImage); break; case 3: specificImage.setRegion(64, 0, 32, 32);
			 * drawTexture(batch, camera, layer, specificImage); break; case 2:
			 * specificImage.setRegion(96, 0, 32, 32); drawTexture(batch, camera, layer,
			 * specificImage); break; case 1: specificImage.setRegion(128, 0, 32, 32);
			 * drawTexture(batch, camera, layer, specificImage); break; case 0:
			 * specificImage.setRegion(160, 0, 32, 32); drawTexture(batch, camera, layer,
			 * specificImage); break; default: // Something has gone horribly wrong... I'm
			 * sad :( throw new GameLogicException(
			 * "Programming error in PillboxSprite: default case reached."); }
			 */

		}
	}
}
