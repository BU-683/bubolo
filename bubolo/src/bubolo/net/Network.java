/**
 * Copyright (c) 2014 BU MET CS673 Game Engineering Team
 *
 * See the file license.txt for copying permission.
 */

package bubolo.net;

import java.net.InetAddress;
import bubolo.world.World;

/**
 * The interface for the Network system.
 * 
 * @author BU CS673 - Clone Productions
 */
public interface Network
{	
	/**
	 * Identifies this player as the game server, and begins accepting connections 
	 * from other players. <code>startServer</code> must be called before
	 * calling <code>connect</code>. There should only be one game server per game.
	 * 
	 * @throws NetworkException if a network error occurs.
	 * @throws IllegalStateException if the server was already started.
	 */
	void startServer() throws NetworkException, IllegalStateException;
	
	/**
	 * Attempts to connect to the specified IP address.
	 * 
	 * @param serverIpAddress the IP address of a server. Note that this isn't necessarily
	 * the <i>game</i> server, since clients also connect directly to each other.
	 * @throws NetworkException if a network error occurs.
	 */
	void connect(InetAddress serverIpAddress) throws NetworkException;
	
	/**
	 * Queues a network command to be sent to the other players.
	 * 
	 * @param command the network command to send.
	 */
	void send(NetworkCommand command);
	
	/**
	 * Performs all network system updates. This should be called once 
	 * per game tick.
	 * 
	 * @param world reference to the game world. 
	 */
	void update(World world);
	
	/**
	 * Runs a NetworkCommand in the game logic thread.
	 * 
	 * @param command
	 */
	void postToGameThread(NetworkCommand command);
	
	/**
	 * Shuts down the network system.
	 */
	void dispose();
}
