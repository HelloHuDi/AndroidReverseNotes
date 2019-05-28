package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.c.a;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class e extends a {
    private NotificationManager FJ = ((NotificationManager) this.mContext.getSystemService("notification"));
    public c edT = new c();
    private Context mContext = ah.getContext();

    public e() {
        AppMethodBeat.i(15951);
        AppMethodBeat.o(15951);
    }

    public final int a(NotificationItem notificationItem) {
        AppMethodBeat.i(15953);
        if (notificationItem == null) {
            AppMethodBeat.o(15953);
            return -1;
        }
        int a = a(notificationItem, null);
        AppMethodBeat.o(15953);
        return a;
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(15954);
        Notification a = this.edT.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(15954);
        return a;
    }

    public static void cancel() {
        AppMethodBeat.i(15952);
        y L = y.L(ah.getContext());
        LinkedList linkedList = new LinkedList();
        Queue<Integer> IR = b.IP().IR();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : IR) {
            stringBuilder.append(num + ";");
            if (!linkedList.contains(num)) {
                b.IP().a(L, num.intValue());
                linkedList.add(num);
            }
        }
        ab.i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", stringBuilder);
        AppMethodBeat.o(15952);
    }

    public static void k(int i, String str) {
        ArrayList arrayList;
        AppMethodBeat.i(15955);
        ab.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", Integer.valueOf(i), str);
        if (i == -1) {
            i = f.Nr();
        }
        c.im(i);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList();
            List Nq = f.Nq();
            if (Nq == null) {
                Nq = new ArrayList();
            }
            for (String str2 : Nq) {
                a aVar = new a();
                aVar.userName = str2;
                aVar.edE = f.kF(str2);
                arrayList.add(aVar);
            }
        } else {
            a aVar2;
            ArrayList IL = c.IL();
            if (IL == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = IL;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar2 = (a) it.next();
                if (aVar2.userName.equals(str)) {
                    arrayList.remove(aVar2);
                    break;
                }
            }
            aVar2 = null;
            if (aVar2 == null) {
                aVar2 = new a();
            }
            aVar2.userName = str;
            aVar2.edE = f.kF(str);
            if (aVar2.edE == 0 && arrayList.isEmpty()) {
                c.f(null);
                AppMethodBeat.o(15955);
                return;
            } else if (aVar2.edE > 0) {
                arrayList.add(aVar2);
            }
        }
        c.f(arrayList);
        AppMethodBeat.o(15955);
    }
}
