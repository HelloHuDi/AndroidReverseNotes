package com.tencent.p177mm.booter.notification;

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
import android.support.p057v4.app.C0363v;
import android.support.p057v4.app.C17432y;
import android.support.p057v4.app.C17432y.C8380b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.notification.p841a.C25976e;
import com.tencent.p177mm.booter.notification.p841a.C25977g;
import com.tencent.p177mm.booter.notification.queue.C9203b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.booter.notification.NotificationItem */
public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR = new C13271();
    /* renamed from: Fl */
    Notification f1223Fl;
    private final String TAG;
    /* renamed from: b */
    private Bitmap f1224b;
    private PendingIntent edU;
    public String edV;
    public long edW;
    public int edX;
    public boolean edY;
    public int edZ;
    public int eea;
    /* renamed from: id */
    public int f1225id;

    /* renamed from: com.tencent.mm.booter.notification.NotificationItem$1 */
    static class C13271 implements Creator<NotificationItem> {
        C13271() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NotificationItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(15956);
            NotificationItem notificationItem = new NotificationItem(parcel, (byte) 0);
            AppMethodBeat.m2505o(15956);
            return notificationItem;
        }
    }

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
        AppMethodBeat.m2504i(15957);
        this.TAG = "MicroMsg.NotificationItem";
        this.f1225id = -1;
        this.edW = 0;
        this.edX = 0;
        this.edY = true;
        this.edZ = 0;
        this.eea = 0;
        this.f1225id = i;
        this.edV = str;
        if (VERSION.SDK_INT >= 11) {
            this.f1224b = notification.largeIcon;
        }
        this.f1223Fl = notification;
        this.edY = z;
        this.edZ = 0;
        AppMethodBeat.m2505o(15957);
    }

    public final synchronized void clear() {
        AppMethodBeat.m2504i(15958);
        if (!(this.f1224b == null || this.f1224b.isRecycled())) {
            C4990ab.m7417i("MicroMsg.NotificationItem", "recycle bitmap:%s", this.f1224b.toString());
            this.f1224b.recycle();
        }
        this.f1223Fl = null;
        this.f1224b = null;
        this.edU = null;
        AppMethodBeat.m2505o(15958);
    }

    /* renamed from: a */
    public final synchronized int mo4658a(C25977g c25977g) {
        int i;
        NotificationItem notificationItem = null;
        synchronized (this) {
            AppMethodBeat.m2504i(15959);
            this.f1225id = this.f1225id == -1 ? C9203b.m16707IP().mo20616n(this.edV, this.edY) : this.f1225id;
            Context context = C4996ah.getContext();
            if (context == null) {
                C4990ab.m7412e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                AppMethodBeat.m2505o(15959);
                i = -1;
            } else if (this.f1223Fl == null) {
                C4990ab.m7412e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                AppMethodBeat.m2505o(15959);
                i = -1;
            } else {
                NotificationItem notificationItem2;
                C9203b IP = C9203b.m16707IP();
                String str = this.edV;
                if (C5046bo.isNullOrNil(str)) {
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
                    C9203b IP2 = C9203b.m16707IP();
                    C4990ab.m7411d("MicroMsg.Notification.Queue", "mark: %d", Integer.valueOf(notificationItem2.f1225id));
                    IP2.mark = r7;
                }
                if (!(notificationItem2 == null || notificationItem2.f1223Fl.tickerText == null || this.f1223Fl.tickerText == null || !notificationItem2.f1223Fl.tickerText.equals(this.f1223Fl.tickerText))) {
                    this.f1223Fl.tickerText += " ";
                }
                IP = C9203b.m16707IP();
                if (this.f1225id == -1) {
                    C4990ab.m7412e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (IP.mark > 0) {
                        if (IP.mark == this.f1225id) {
                            C4990ab.m7411d("MicroMsg.Notification.Queue", "remove mark: %d", Integer.valueOf(IP.mark));
                            IP.mo20613iq(IP.mark);
                        }
                        IP.mark = -1;
                    }
                    IP.mo20613iq(this.f1225id);
                    if (IP.eeh.size() >= 5) {
                        notificationItem = IP.mo20608IQ();
                    }
                    IP.eeh.mo20602e(this);
                    IP.eei.mo33543c(this);
                    C4990ab.m7417i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", toString(), Integer.valueOf(IP.eeh.size()));
                }
                if (notificationItem != null) {
                    C9203b.m16707IP().cancel(notificationItem.f1225id);
                }
                this.eea = C18103d.m28518a(this.f1223Fl, c25977g);
                if (context != null) {
                    if (this.f1223Fl == null) {
                        C4990ab.m7412e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = C4996ah.getContext();
                        if (context2 == null) {
                            C4990ab.m7412e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.f1223Fl == null) {
                            C4990ab.m7412e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.f1223Fl.icon) == null) {
                                this.f1223Fl.icon = C25738R.drawable.icon;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", Integer.valueOf(this.f1223Fl.defaults), this.f1223Fl.sound, C25977g.m41436b(this.f1223Fl.vibrate));
                        try {
                            Object obj;
                            if (C25976e.m41427IY() == 1 && this.f1223Fl.defaults != 2 && this.f1223Fl.vibrate == null) {
                                this.f1223Fl.defaults = 0;
                                this.f1223Fl.sound = null;
                                C4990ab.m7416i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            if (C1443d.m3068iW(26)) {
                                C4990ab.m7416i("MicroMsg.NotificationItem", "manual add led to notification");
                                this.f1223Fl.ledARGB = -16711936;
                                this.f1223Fl.ledOnMS = 300;
                                this.f1223Fl.ledOffMS = 1000;
                            }
                            C17432y L = C17432y.m27074L(C4996ah.getContext());
                            int i2 = this.f1225id;
                            Notification notification = this.f1223Fl;
                            Bundle a = C0363v.m609a(notification);
                            if (a == null || !a.getBoolean("android.support.useSideChannel")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj != null) {
                                L.mo31700a(new C8380b(L.mContext.getPackageName(), i2, notification));
                                L.f3891FJ.cancel(null, i2);
                            } else {
                                L.f3891FJ.notify(null, i2, notification);
                            }
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.NotificationItem", e, "Notification Exception?", new Object[0]);
                        }
                        if (this.edW != 0) {
                            C44684c.m81270eR(this.edW);
                        }
                    }
                }
                i = this.f1225id;
                AppMethodBeat.m2505o(15959);
            }
        }
        return i;
    }

    private NotificationItem(Parcel parcel) {
        AppMethodBeat.m2504i(15960);
        this.TAG = "MicroMsg.NotificationItem";
        this.f1225id = -1;
        this.edW = 0;
        this.edX = 0;
        this.edY = true;
        this.edZ = 0;
        this.eea = 0;
        if (parcel == null) {
            AppMethodBeat.m2505o(15960);
            return;
        }
        boolean z;
        this.f1225id = parcel.readInt();
        this.edV = parcel.readString();
        this.f1224b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f1223Fl = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
        this.edU = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.edY = z;
        this.edW = parcel.readLong();
        this.edX = parcel.readInt();
        AppMethodBeat.m2505o(15960);
    }

    static {
        AppMethodBeat.m2504i(15963);
        AppMethodBeat.m2505o(15963);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        AppMethodBeat.m2504i(15962);
        String str = "id: " + this.f1225id + ",msgId: " + this.edW + ",userName: " + this.edV + ",unreadCount: " + this.edX;
        AppMethodBeat.m2505o(15962);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        int i2;
        AppMethodBeat.m2504i(15961);
        parcel.writeInt(this.f1225id);
        if (this.edV == null) {
            str = "";
        } else {
            str = this.edV;
        }
        parcel.writeString(str);
        parcel.writeParcelable(this.f1224b, 0);
        parcel.writeParcelable(this.f1223Fl, 0);
        parcel.writeParcelable(this.edU, 0);
        if (this.edY) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.edW);
        parcel.writeInt(this.edX);
        AppMethodBeat.m2505o(15961);
    }
}
