package android.support.p057v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.app.C0363v.C0357a;
import android.support.p057v4.app.C0363v.C0358c;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.w */
final class C6193w implements C0356u {
    /* renamed from: FA */
    final C0358c f1782FA;
    /* renamed from: FB */
    final List<Bundle> f1783FB = new ArrayList();
    /* renamed from: Ff */
    RemoteViews f1784Ff;
    /* renamed from: Fg */
    RemoteViews f1785Fg;
    /* renamed from: Fh */
    RemoteViews f1786Fh;
    /* renamed from: Fk */
    int f1787Fk;
    final Builder mBuilder;
    final Bundle mExtras = new Bundle();

    C6193w(C0358c c0358c) {
        boolean z;
        this.f1782FA = c0358c;
        if (VERSION.SDK_INT >= 26) {
            this.mBuilder = new Builder(c0358c.mContext, c0358c.mChannelId);
        } else {
            this.mBuilder = new Builder(c0358c.mContext);
        }
        Notification notification = c0358c.f390Fl;
        Builder lights = this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, c0358c.f364EK).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
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
        lights = lights.setAutoCancel(z).setDefaults(notification.defaults).setContentTitle(c0358c.f360EG).setContentText(c0358c.f361EH).setContentInfo(c0358c.f366EM).setContentIntent(c0358c.f362EI).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = c0358c.f363EJ;
        if ((notification.flags & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        lights.setFullScreenIntent(pendingIntent, z).setLargeIcon(c0358c.f365EL).setNumber(c0358c.f367EN).setProgress(c0358c.f373EU, c0358c.f374EV, c0358c.f375EW);
        if (VERSION.SDK_INT < 21) {
            this.mBuilder.setSound(notification.sound, notification.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.mBuilder.setSubText(c0358c.f371ES).setUsesChronometer(c0358c.f369EP).setPriority(c0358c.mPriority);
            Iterator it = c0358c.f359EF.iterator();
            while (it.hasNext()) {
                m9948a((C0357a) it.next());
            }
            if (c0358c.mExtras != null) {
                this.mExtras.putAll(c0358c.mExtras);
            }
            if (VERSION.SDK_INT < 20) {
                if (c0358c.f379Fa) {
                    this.mExtras.putBoolean("android.support.localOnly", true);
                }
                if (c0358c.f376EX != null) {
                    this.mExtras.putString("android.support.groupKey", c0358c.f376EX);
                    if (c0358c.f377EY) {
                        this.mExtras.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.mExtras.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (c0358c.f378EZ != null) {
                    this.mExtras.putString("android.support.sortKey", c0358c.f378EZ);
                }
            }
            this.f1784Ff = c0358c.f384Ff;
            this.f1785Fg = c0358c.f385Fg;
        }
        if (VERSION.SDK_INT >= 19) {
            this.mBuilder.setShowWhen(c0358c.f368EO);
            if (!(VERSION.SDK_INT >= 21 || c0358c.f391Fm == null || c0358c.f391Fm.isEmpty())) {
                this.mExtras.putStringArray("android.people", (String[]) c0358c.f391Fm.toArray(new String[c0358c.f391Fm.size()]));
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.mBuilder.setLocalOnly(c0358c.f379Fa).setGroup(c0358c.f376EX).setGroupSummary(c0358c.f377EY).setSortKey(c0358c.f378EZ);
            this.f1787Fk = c0358c.f389Fk;
        }
        if (VERSION.SDK_INT >= 21) {
            this.mBuilder.setCategory(c0358c.f382Fd).setColor(c0358c.mColor).setVisibility(c0358c.f392iZ).setPublicVersion(c0358c.f383Fe).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = c0358c.f391Fm.iterator();
            while (it2.hasNext()) {
                this.mBuilder.addPerson((String) it2.next());
            }
            this.f1786Fh = c0358c.f386Fh;
        }
        if (VERSION.SDK_INT >= 24) {
            this.mBuilder.setExtras(c0358c.mExtras).setRemoteInputHistory(c0358c.f372ET);
            if (c0358c.f384Ff != null) {
                this.mBuilder.setCustomContentView(c0358c.f384Ff);
            }
            if (c0358c.f385Fg != null) {
                this.mBuilder.setCustomBigContentView(c0358c.f385Fg);
            }
            if (c0358c.f386Fh != null) {
                this.mBuilder.setCustomHeadsUpContentView(c0358c.f386Fh);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.mBuilder.setBadgeIconType(c0358c.f387Fi).setShortcutId(c0358c.f388Fj).setTimeoutAfter(c0358c.mTimeout).setGroupAlertBehavior(c0358c.f389Fk);
            if (c0358c.f381Fc) {
                this.mBuilder.setColorized(c0358c.f380Fb);
            }
            if (!TextUtils.isEmpty(c0358c.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    /* renamed from: ds */
    public final Builder mo609ds() {
        return this.mBuilder;
    }

    /* renamed from: a */
    private void m9948a(C0357a c0357a) {
        if (VERSION.SDK_INT >= 20) {
            Bundle bundle;
            Action.Builder builder = new Action.Builder(c0357a.icon, c0357a.title, c0357a.actionIntent);
            if (c0357a.f356EB != null) {
                for (RemoteInput addRemoteInput : C0320aa.m514b(c0357a.f356EB)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (c0357a.mExtras != null) {
                bundle = new Bundle(c0357a.mExtras);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", c0357a.f358ED);
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(c0357a.f358ED);
            }
            builder.addExtras(bundle);
            this.mBuilder.addAction(builder.build());
        } else if (VERSION.SDK_INT >= 16) {
            this.f1783FB.add(C0366x.m614a(this.mBuilder, c0357a));
        }
    }

    /* renamed from: b */
    static void m9949b(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
