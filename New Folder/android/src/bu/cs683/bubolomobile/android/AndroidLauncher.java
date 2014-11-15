package bu.cs683.bubolomobile.android;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;


import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import bu.cs683.bubolomobile.BuboloMobile;
import bu.cs683.bubolomobile.android.util.AndroidFileUtil;

public class AndroidLauncher extends AndroidApplication {
	private static Map<String, Texture> textures = new HashMap<String, Texture>();

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		BuboloMobile app = new BuboloMobile();
		loadAllTextures();
		app.SetTextures(textures);
		initialize(app, config);
		//initialize(new Sprint2_SinglePlayerApp(1067, 600), config);
		//new Sprint2_SinglePlayerApp(200, 200);
	}
	
	private void loadAllTextures(){

		
		File textureDirectory = new File("");
		for (File file : textureDirectory.listFiles())
		{	
			if (file.getName().endsWith("png"))
			{
				getTexture("" + file.getName());
			}
		}
	}
	static Texture getTexture(String path)
	{
		Texture texture = textures.get(path);
		if (texture == null)
		{
			texture = new Texture(new FileHandle(new File(path)));
			textures.put(path, texture);
		}

		return texture;
	}

}
