package com.tencent.p177mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.p057v4.app.C17432y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.notification.C44684c.C44685a;
import com.tencent.p177mm.booter.notification.queue.C9203b;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* renamed from: com.tencent.mm.booter.notification.e */
public final class C25979e extends C41902a {
    /* renamed from: FJ */
    private NotificationManager f13662FJ = ((NotificationManager) this.mContext.getSystemService("notification"));
    public C44684c edT = new C44684c();
    private Context mContext = C4996ah.getContext();

    public C25979e() {
        AppMethodBeat.m2504i(15951);
        AppMethodBeat.m2505o(15951);
    }

    /* renamed from: a */
    public final int mo43866a(NotificationItem notificationItem) {
        AppMethodBeat.m2504i(15953);
        if (notificationItem == null) {
            AppMethodBeat.m2505o(15953);
            return -1;
        }
        int a = mo67551a(notificationItem, null);
        AppMethodBeat.m2505o(15953);
        return a;
    }

    @TargetApi(11)
    /* renamed from: a */
    public final Notification mo43867a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.m2504i(15954);
        Notification a = this.edT.mo71726a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.m2505o(15954);
        return a;
    }

    public static void cancel() {
        AppMethodBeat.m2504i(15952);
        C17432y L = C17432y.m27074L(C4996ah.getContext());
        LinkedList linkedList = new LinkedList();
        Queue<Integer> IR = C9203b.m16707IP().mo20609IR();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : IR) {
            stringBuilder.append(num + ";");
            if (!linkedList.contains(num)) {
                C9203b.m16707IP().mo20610a(L, num.intValue());
                linkedList.add(num);
            }
        }
        C4990ab.m7417i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", stringBuilder);
        AppMethodBeat.m2505o(15952);
    }

    /* renamed from: k */
    public static void m41440k(int i, String str) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(15955);
        C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", Integer.valueOf(i), str);
        if (i == -1) {
            i = C18559f.m28885Nr();
        }
        C44684c.m81273im(i);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList();
            List Nq = C18559f.m28884Nq();
            if (Nq == null) {
                Nq = new ArrayList();
            }
            for (String str2 : Nq) {
                C44685a c44685a = new C44685a();
                c44685a.userName = str2;
                c44685a.edE = C18559f.m28906kF(str2);
                arrayList.add(c44685a);
            }
        } else {
            C44685a c44685a2;
            ArrayList IL = C44684c.m81266IL();
            if (IL == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = IL;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c44685a2 = (C44685a) it.next();
                if (c44685a2.userName.equals(str)) {
                    arrayList.remove(c44685a2);
                    break;
                }
            }
            c44685a2 = null;
            if (c44685a2 == null) {
                c44685a2 = new C44685a();
            }
            c44685a2.userName = str;
            c44685a2.edE = C18559f.m28906kF(str);
            if (c44685a2.edE == 0 && arrayList.isEmpty()) {
                C44684c.m81272f(null);
                AppMethodBeat.m2505o(15955);
                return;
            } else if (c44685a2.edE > 0) {
                arrayList.add(c44685a2);
            }
        }
        C44684c.m81272f(arrayList);
        AppMethodBeat.m2505o(15955);
    }
}
