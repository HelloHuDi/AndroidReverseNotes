package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.v.a;
import android.support.v4.app.v.c;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class w implements u {
    final c FA;
    final List<Bundle> FB = new ArrayList();
    RemoteViews Ff;
    RemoteViews Fg;
    RemoteViews Fh;
    int Fk;
    final Builder mBuilder;
    final Bundle mExtras = new Bundle();

    w(c cVar) {
        boolean z;
        this.FA = cVar;
        if (VERSION.SDK_INT >= 26) {
            this.mBuilder = new Builder(cVar.mContext, cVar.mChannelId);
        } else {
            this.mBuilder = new Builder(cVar.mContext);
        }
        Notification notification = cVar.Fl;
        Builder lights = this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.EK).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        lights = lights.setOngoing(z);
        if ((notification.flags & 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        lights = lights.setOnlyAlertOnce(z);
        if ((notification.flags & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        lights = lights.setAutoCancel(z).setDefaults(notification.defaults).setContentTitle(cVar.EG).setContentText(cVar.EH).setContentInfo(cVar.EM).setContentIntent(cVar.EI).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = cVar.EJ;
        if ((notification.flags & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        lights.setFullScreenIntent(pendingIntent, z).setLargeIcon(cVar.EL).setNumber(cVar.EN).setProgress(cVar.EU, cVar.EV, cVar.EW);
        if (VERSION.SDK_INT < 21) {
            this.mBuilder.setSound(notification.sound, notification.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.mBuilder.setSubText(cVar.ES).setUsesChronometer(cVar.EP).setPriority(cVar.mPriority);
            Iterator it = cVar.EF.iterator();
            while (it.hasNext()) {
                a((a) it.next());
            }
            if (cVar.mExtras != null) {
                this.mExtras.putAll(cVar.mExtras);
            }
            if (VERSION.SDK_INT < 20) {
                if (cVar.Fa) {
                    this.mExtras.putBoolean("android.support.localOnly", true);
                }
                if (cVar.EX != null) {
                    this.mExtras.putString("android.support.groupKey", cVar.EX);
                    if (cVar.EY) {
                        this.mExtras.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.mExtras.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (cVar.EZ != null) {
                    this.mExtras.putString("android.support.sortKey", cVar.EZ);
                }
            }
            this.Ff = cVar.Ff;
            this.Fg = cVar.Fg;
        }
        if (VERSION.SDK_INT >= 19) {
            this.mBuilder.setShowWhen(cVar.EO);
            if (!(VERSION.SDK_INT >= 21 || cVar.Fm == null || cVar.Fm.isEmpty())) {
                this.mExtras.putStringArray("android.people", (String[]) cVar.Fm.toArray(new String[cVar.Fm.size()]));
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.mBuilder.setLocalOnly(cVar.Fa).setGroup(cVar.EX).setGroupSummary(cVar.EY).setSortKey(cVar.EZ);
            this.Fk = cVar.Fk;
        }
        if (VERSION.SDK_INT >= 21) {
            this.mBuilder.setCategory(cVar.Fd).setColor(cVar.mColor).setVisibility(cVar.iZ).setPublicVersion(cVar.Fe).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = cVar.Fm.iterator();
            while (it2.hasNext()) {
                this.mBuilder.addPerson((String) it2.next());
            }
            this.Fh = cVar.Fh;
        }
        if (VERSION.SDK_INT >= 24) {
            this.mBuilder.setExtras(cVar.mExtras).setRemoteInputHistory(cVar.ET);
            if (cVar.Ff != null) {
                this.mBuilder.setCustomContentView(cVar.Ff);
            }
            if (cVar.Fg != null) {
                this.mBuilder.setCustomBigContentView(cVar.Fg);
            }
            if (cVar.Fh != null) {
                this.mBuilder.setCustomHeadsUpContentView(cVar.Fh);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.mBuilder.setBadgeIconType(cVar.Fi).setShortcutId(cVar.Fj).setTimeoutAfter(cVar.mTimeout).setGroupAlertBehavior(cVar.Fk);
            if (cVar.Fc) {
                this.mBuilder.setColorized(cVar.Fb);
            }
            if (!TextUtils.isEmpty(cVar.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    public final Builder ds() {
        return this.mBuilder;
    }

    private void a(a aVar) {
        if (VERSION.SDK_INT >= 20) {
            Bundle bundle;
            Action.Builder builder = new Action.Builder(aVar.icon, aVar.title, aVar.actionIntent);
            if (aVar.EB != null) {
                for (RemoteInput addRemoteInput : aa.b(aVar.EB)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.mExtras != null) {
                bundle = new Bundle(aVar.mExtras);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.ED);
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.ED);
            }
            builder.addExtras(bundle);
            this.mBuilder.addAction(builder.build());
        } else if (VERSION.SDK_INT >= 16) {
            this.FB.add(x.a(this.mBuilder, aVar));
        }
    }

    static void b(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
