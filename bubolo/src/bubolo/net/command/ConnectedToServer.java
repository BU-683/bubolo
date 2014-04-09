/**
 * Copyright (c) 2014 BU MET CS673 Game Engineering Team
 *
 * See the file license.txt for copying permission.
 */

package bubolo.net.command;

import bubolo.net.Network;
import bubolo.net.NetworkCommand;
import bubolo.net.NetworkSystem;
import bubolo.world.World;

/**
 * Notifies a client that it has connected to the server.
 * 
 * @author BU CS673 - Clone Productions
 */
public class ConnectedToServer implements NetworkCommand
{
	private static final long serialVersionUID = 1L;

	private final String serverName;

	/**
	 * Constructs a ConnectedToServer object.
	 * 
	 * @param serverName
	 *            the name of the server player.
	 */
	public ConnectedToServer(String serverName)
	{
		this.serverName = serverName;
	}

	@Override
	public void execute(World world)
	{
		Network net = NetworkSystem.getInstance();
		net.getNotifier().notifyConnect(serverName);
	}
}
