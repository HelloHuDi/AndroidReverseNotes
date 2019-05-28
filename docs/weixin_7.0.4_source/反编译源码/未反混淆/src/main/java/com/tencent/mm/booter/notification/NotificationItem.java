package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.v;
import android.support.v4.app.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR = new Creator<NotificationItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NotificationItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(15956);
            NotificationItem notificationItem = new NotificationItem(parcel, (byte) 0);
            AppMethodBeat.o(15956);
            return notificationItem;
        }
    };
    Notification Fl;
    private final String TAG;
    private Bitmap b;
    private PendingIntent edU;
    public String edV;
    public long edW;
    public int edX;
    public boolean edY;
    public int edZ;
    public int eea;
    public int id;

    public NotificationItem(int i, String str, Notification notification) {
        this(i, str, notification, true);
    }

    public NotificationItem(int i, Notification notification, boolean z) {
        this(i, null, notification, z);
    }

    public NotificationItem(Notification notification, boolean z) {
        this(-1, notification, z);
    }

    @TargetApi(11)
    private NotificationItem(int i, String str, Notification notification, boolean z) {
        AppMethodBeat.i(15957);
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.edW = 0;
        this.edX = 0;
        this.edY = true;
        this.edZ = 0;
        this.eea = 0;
        this.id = i;
        this.edV = str;
        if (VERSION.SDK_INT >= 11) {
            this.b = notification.largeIcon;
        }
        this.Fl = notification;
        this.edY = z;
        this.edZ = 0;
        AppMethodBeat.o(15957);
    }

    public final synchronized void clear() {
        AppMethodBeat.i(15958);
        if (!(this.b == null || this.b.isRecycled())) {
            ab.i("MicroMsg.NotificationItem", "recycle bitmap:%s", this.b.toString());
            this.b.recycle();
        }
        this.Fl = null;
        this.b = null;
        this.edU = null;
        AppMethodBeat.o(15958);
    }

    public final synchronized int a(g gVar) {
        int i;
        NotificationItem notificationItem = null;
        synchronized (this) {
            AppMethodBeat.i(15959);
            this.id = this.id == -1 ? b.IP().n(this.edV, this.edY) : this.id;
            Context context = ah.getContext();
            if (context == null) {
                ab.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                AppMethodBeat.o(15959);
                i = -1;
            } else if (this.Fl == null) {
                ab.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                AppMethodBeat.o(15959);
                i = -1;
            } else {
                NotificationItem notificationItem2;
                b IP = b.IP();
                String str = this.edV;
                if (bo.isNullOrNil(str)) {
                    notificationItem2 = null;
                } else {
                    Iterator it = IP.iterator();
                    while (it.hasNext()) {
                        notificationItem2 = (NotificationItem) it.next();
                        if (notificationItem2 != null && notificationItem2.edV != null && notificationItem2.edV.equals(str)) {
                            break;
                        }
                    }
                    notificationItem2 = null;
                }
                if (notificationItem2 != null) {
                    b IP2 = b.IP();
                    ab.d("MicroMsg.Notification.Queue", "mark: %d", Integer.valueOf(notificationItem2.id));
                    IP2.mark = r7;
                }
                if (!(notificationItem2 == null || notificationItem2.Fl.tickerText == null || this.Fl.tickerText == null || !notificationItem2.Fl.tickerText.equals(this.Fl.tickerText))) {
                    this.Fl.tickerText += " ";
                }
                IP = b.IP();
                if (this.id == -1) {
                    ab.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (IP.mark > 0) {
                        if (IP.mark == this.id) {
                            ab.d("MicroMsg.Notification.Queue", "remove mark: %d", Integer.valueOf(IP.mark));
                            IP.iq(IP.mark);
                        }
                        IP.mark = -1;
                    }
                    IP.iq(this.id);
                    if (IP.eeh.size() >= 5) {
                        notificationItem = IP.IQ();
                    }
                    IP.eeh.e(this);
                    IP.eei.c(this);
                    ab.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", toString(), Integer.valueOf(IP.eeh.size()));
                }
                if (notificationItem != null) {
                    b.IP().cancel(notificationItem.id);
                }
                this.eea = d.a(this.Fl, gVar);
                if (context != null) {
                    if (this.Fl == null) {
                        ab.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = ah.getContext();
                        if (context2 == null) {
                            ab.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.Fl == null) {
                            ab.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.Fl.icon) == null) {
                                this.Fl.icon = R.drawable.icon;
                            }
                        }
                        ab.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", Integer.valueOf(this.Fl.defaults), this.Fl.sound, g.b(this.Fl.vibrate));
                        try {
                            Object obj;
                            if (e.IY() == 1 && this.Fl.defaults != 2 && this.Fl.vibrate == null) {
                                this.Fl.defaults = 0;
                                this.Fl.sound = null;
                                ab.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            if (d.iW(26)) {
                                ab.i("MicroMsg.NotificationItem", "manual add led to notification");
                                this.Fl.ledARGB = -16711936;
                                this.Fl.ledOnMS = 300;
                                this.Fl.ledOffMS = 1000;
                            }
                            y L = y.L(ah.getContext());
                            int i2 = this.id;
                            Notification notification = this.Fl;
                            Bundle a = v.a(notification);
                            if (a == null || !a.getBoolean("android.support.useSideChannel")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj != null) {
                                L.a(new y.b(L.mContext.getPackageName(), i2, notification));
                                L.FJ.cancel(null, i2);
                            } else {
                                L.FJ.notify(null, i2, notification);
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.NotificationItem", e, "Notification Exception?", new Object[0]);
                        }
                        if (this.edW != 0) {
                            c.eR(this.edW);
                        }
                    }
                }
                i = this.id;
                AppMethodBeat.o(15959);
            }
        }
        return i;
    }

    private NotificationItem(Parcel parcel) {
        AppMethodBeat.i(15960);
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.edW = 0;
        this.edX = 0;
        this.edY = true;
        this.edZ = 0;
        this.eea = 0;
        if (parcel == null) {
            AppMethodBeat.o(15960);
            return;
        }
        boolean z;
        this.id = parcel.readInt();
        this.edV = parcel.readString();
        this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.Fl = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
        this.edU = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.edY = z;
        this.edW = parcel.readLong();
        this.edX = parcel.readInt();
        AppMethodBeat.o(15960);
    }

    static {
        AppMethodBeat.i(15963);
        AppMethodBeat.o(15963);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        AppMethodBeat.i(15962);
        String str = "id: " + this.id + ",msgId: " + this.edW + ",userName: " + this.edV + ",unreadCount: " + this.edX;
        AppMethodBeat.o(15962);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        int i2;
        AppMethodBeat.i(15961);
        parcel.writeInt(this.id);
        if (this.edV == null) {
            str = "";
        } else {
            str = this.edV;
        }
        parcel.writeString(str);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.Fl, 0);
        parcel.writeParcelable(this.edU, 0);
        if (this.edY) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.edW);
        parcel.writeInt(this.edX);
        AppMethodBeat.o(15961);
    }
}
