package bu.cs683.bubolomobile.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import bu.cs683.bubolomobile.BuboloMobile;
import bubolo.integration.sprint2.Sprint2_SinglePlayerApp;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		//initialize(new BuboloMobile(), config);
		initialize(new Sprint2_SinglePlayerApp(1067, 600), config);
	}
}
