package com.example.sarthak.fluxus2k16;


        import android.content.Context;
        import android.content.Intent;
        import android.util.Log;

        import com.parse.ParsePushBroadcastReceiver;

        import org.json.JSONException;
        import org.json.JSONObject;
        import android.support.v4.app.NotificationCompat;
        import android.app.Notification;
        import android.app.NotificationManager;
        import android.app.PendingIntent;


public class ParsePushReceiver extends ParsePushBroadcastReceiver {
    private final String TAG = ParsePushReceiver.class.getSimpleName();

    //private NotificationUtils notificationUtils;

    private Intent parseIntent;
    int id=0;

    public ParsePushReceiver() {
        super();
    }

    @Override
    protected void onPushReceive(Context context, Intent intent) {
        GlobalApplication g=new GlobalApplication();
        super.onPushReceive(context, intent);

        if (intent == null)
            return;

        try {
            JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));

            Log.e(TAG, "Push received: " + json);

            parseIntent = intent;
            id=(int)System.currentTimeMillis();
            parsePushJson(context, json);

        } catch (JSONException e) {
            Log.e(TAG, "Push message json exception: " + e.getMessage());
        }
        //ParseWakefulBroadCastReceiver.completeWakefulIntent(intent);
    }

    @Override
    protected void onPushDismiss(Context context, Intent intent) {
        super.onPushDismiss(context, intent);
    }

    @Override
    protected void onPushOpen(Context context, Intent intent) {
        super.onPushOpen(context, intent);
    }

    /**
     * Parses the push notification json
     *
     * @param context
     * @param json
     */
    private void parsePushJson(Context context, JSONObject json) {
        try {
            boolean isBackground = json.getBoolean("is_background");
            JSONObject data = json.getJSONObject("data");
            String title = data.getString("title");
            String message = data.getString("message");
            Database d=new Database(context);
            d.saveNotifications(id,title,message);

            if (!isBackground) {
                Intent resultIntent = new Intent(context, MainActivity.class);

                Intent cIntent = new Intent(context, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(context, id, cIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                // Create custom notification
                NotificationCompat.Builder  builder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.fluxus_icon)
                        .setContentText(message)
                        .setContentTitle(title)
                        .setContentIntent(pendingIntent);

                Notification notification = builder.build();

                NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                nm.notify(id, notification);
            }

        } catch (JSONException e) {
            Log.e(TAG, "Push message json exception: " + e.getMessage());
        }
    }


    /**
     * Shows the notification message in the notification bar
     * If the app is in background, launches the app
     *
     * @param context
     * @param title
     * @param message
     * @param intent
     */
    /*private void showNotificationMessage(Context context, String title, String message, Intent intent) {

        notificationUtils = new NotificationUtils(context);

        intent.putExtras(parseIntent.getExtras());

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        notificationUtils.showNotificationMessage(title, message, intent);
    }*/
}