package android.support.p057v4.media.session;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.support.p057v4.media.MediaBrowserCompat;
import android.support.p057v4.media.MediaBrowserCompat.C25345b;
import android.view.KeyEvent;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaButtonReceiver */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* renamed from: android.support.v4.media.session.MediaButtonReceiver$a */
    static class C0421a extends C25345b {
        /* renamed from: Jh */
        private final PendingResult f503Jh;
        /* renamed from: Ji */
        MediaBrowserCompat f504Ji;
        private final Context mContext;
        private final Intent mIntent;

        C0421a(Context context, Intent intent, PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.f503Jh = pendingResult;
        }

        public final void onConnected() {
            try {
                MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, this.f504Ji.f5152HJ.mo18335dH());
                KeyEvent keyEvent = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent == null) {
                    throw new IllegalArgumentException("KeyEvent may not be null");
                }
                mediaControllerCompat.f2379Jj.dispatchMediaButtonEvent(keyEvent);
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
            this.f504Ji.disconnect();
            this.f503Jh.finish();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName g = MediaButtonReceiver.m719g(context, "android.intent.action.MEDIA_BUTTON");
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
            g = MediaButtonReceiver.m719g(context, "android.media.browse.MediaBrowserService");
            if (g != null) {
                PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                C0421a c0421a = new C0421a(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, g, c0421a);
                c0421a.f504Ji = mediaBrowserCompat;
                mediaBrowserCompat.f5152HJ.connect();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        new StringBuilder("Ignore unsupported intent: ").append(intent);
    }

    /* renamed from: g */
    private static ComponentName m719g(Context context, String str) {
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
