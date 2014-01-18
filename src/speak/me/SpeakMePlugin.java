package speak.me;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SpeakMePlugin extends Service {
	
	// CHANGE THIS TO BE A DESCRIPTIVE CATEGORY
	static final String CATEGORY_ADD_IF = "speak.me.category.DEFAULT_PLUGIN_CATEGORY";

	// Processes the command
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand( intent, flags, startId );
		return START_STICKY;
	}

	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
