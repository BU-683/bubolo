package bubolo.integration;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import bubolo.test.Sprint1Application;

public class Sprint1
{
	static Sprint1Application app = new Sprint1Application(300, 300);
	
	public static void main(String args[])
	{
			LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
			cfg.title = "test";
			cfg.width = 600;
			cfg.height = 600;
			new LwjglApplication(app, cfg);
	}

	
}
