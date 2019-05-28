package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.b;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {

    static class a extends b {
        private final PendingResult Jh;
        MediaBrowserCompat Ji;
        private final Context mContext;
        private final Intent mIntent;

        a(Context context, Intent intent, PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.Jh = pendingResult;
        }

        public final void onConnected() {
            try {
                MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, this.Ji.HJ.dH());
                KeyEvent keyEvent = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent == null) {
                    throw new IllegalArgumentException("KeyEvent may not be null");
                }
                mediaControllerCompat.Jj.dispatchMediaButtonEvent(keyEvent);
                finish();
            } catch (RemoteException e) {
            }
        }

        public final void onConnectionSuspended() {
            finish();
        }

        public final void onConnectionFailed() {
            finish();
        }

        private void finish() {
            this.Ji.disconnect();
            this.Jh.finish();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName g = g(context, "android.intent.action.MEDIA_BUTTON");
            if (g != null) {
                intent.setComponent(g);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                    return;
                } else {
                    context.startService(intent);
                    return;
                }
            }
            g = g(context, "android.media.browse.MediaBrowserService");
            if (g != null) {
                PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                a aVar = new a(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, g, aVar);
                aVar.Ji = mediaBrowserCompat;
                mediaBrowserCompat.HJ.connect();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        new StringBuilder("Ignore unsupported intent: ").append(intent);
    }

    private static ComponentName g(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }
}
