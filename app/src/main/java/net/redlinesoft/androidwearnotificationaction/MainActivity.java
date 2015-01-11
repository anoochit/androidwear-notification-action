package net.redlinesoft.androidwearnotificationaction;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void Notify(View view) {
        Intent intent = new Intent(this,NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:0,0?q=13.744033,100.494384(National Discovery Museum Institute)&z=17"));
        PendingIntent mapPendingIntent = PendingIntent.getActivity(this,1,mapIntent,0);
        
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("National Discovery Museum Institute");
        builder.setContentText("4, Sanam Chai Road, Phra Borom Maha Ratchawang, Khet Phra Nakhon, Bangkok, 10200");
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.addAction(R.drawable.ic_map,"Open Map",mapPendingIntent);

        NotificationManagerCompat manager =  NotificationManagerCompat.from(this);
        manager.notify(1,builder.build());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
