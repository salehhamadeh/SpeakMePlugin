package speak.me.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class SpeakMePlugin extends Service {
	
	// CHANGE THIS TO BE A DESCRIPTIVE CATEGORY
	static final String CATEGORY_ADD_IF = "speak.me.category.DEFAULT_PLUGIN_CATEGORY";
	private static final int MSG_SAY_HELLO = 16;
	/**
     * Handler of incoming messages from clients.
     */
    class IncomingHandler extends Handler {
        
		@Override
        public void handleMessage(Message msg) {
			Log.i("IH", "handleMessage");
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(), "hello!", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
	
    final Messenger mMessenger = new Messenger(new IncomingHandler());
    
	// Processes the command
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand( intent, flags, startId );
		return START_STICKY;
	}

	public void onDestroy() {
		super.onDestroy();
	}

	/**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }

}
