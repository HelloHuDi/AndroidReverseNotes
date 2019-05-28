package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.d;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.booter.notification.c;
import com.tencent.mm.booter.notification.e;
import com.tencent.mm.booter.notification.f.a;
import com.tencent.mm.m.f;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public final class j implements b {
    public final void a(long j, String str, String str2, String str3, String str4, int i) {
        int i2;
        AppMethodBeat.i(18260);
        if (bo.isNullOrNil(str2)) {
            Context context = ah.getContext();
            if (f.kH(str)) {
                i2 = R.string.ao1;
            } else {
                i2 = R.string.ce1;
            }
            str2 = context.getString(i2);
        }
        e eVar = a.eec.eeb;
        if (!com.tencent.mm.m.a.MF()) {
            e.cancel();
        }
        try {
            c cVar = eVar.edT;
            Context context2 = ah.getContext();
            ah.getContext();
            boolean IX = com.tencent.mm.booter.notification.a.e.IX();
            ah.getContext();
            boolean IV = com.tencent.mm.booter.notification.a.e.IV();
            ab.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", Boolean.valueOf(IX), Boolean.valueOf(IV));
            if (j != 0) {
                if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
                    ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
                    AppMethodBeat.o(18260);
                    return;
                } else if (f.Nn() && !f.No()) {
                    ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
                    AppMethodBeat.o(18260);
                    return;
                } else if (!com.tencent.mm.m.a.MC()) {
                    ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
                    AppMethodBeat.o(18260);
                    return;
                } else if (c.eS(j)) {
                    ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
                    AppMethodBeat.o(18260);
                    return;
                } else {
                    Bitmap a;
                    com.tencent.mm.booter.notification.queue.b.IP().restore();
                    int IK = c.IK() + 1;
                    c.a a2 = c.a(c.IL(), str);
                    if (a2 == null) {
                        i2 = 0;
                    } else {
                        i2 = a2.edE;
                    }
                    int i3 = i2 + 1;
                    List IL = c.IL();
                    if (IL == null) {
                        IL = new ArrayList();
                    }
                    c.a a3 = c.a(IL, str);
                    if (a3 == null) {
                        a3 = new c.a();
                        a3.userName = str;
                        a3.edE = 1;
                        IL.add(a3);
                    } else {
                        a3.edE++;
                    }
                    c.f(IL);
                    c.im(c.IK() + 1);
                    int size = IL.size();
                    if (com.tencent.mm.booter.notification.a.e.IU()) {
                        IV = false;
                        IX = false;
                    }
                    Notification IJ = c.IJ();
                    int jP = com.tencent.mm.booter.notification.queue.b.IP().jP(str);
                    cVar.cfT.eeH = IK;
                    cVar.cfT.eeG = size;
                    cVar.cfT.eeN = IX;
                    cVar.cfT.eeM = IV;
                    boolean MF = com.tencent.mm.m.a.MF();
                    int bWV = com.tencent.mm.bo.a.bWV();
                    g gVar = cVar.cfT;
                    gVar.eez.a(gVar.mContext, IV, IX, IJ, null);
                    int i4 = gVar.eez.eel;
                    ab.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", Integer.valueOf(jP), str, Integer.valueOf(i), Integer.valueOf(IK), Integer.valueOf(size), Boolean.FALSE, Boolean.valueOf(MF));
                    Intent intent = new Intent(context2, LauncherUI.class);
                    intent.putExtra("nofification_type", "new_msg_nofification");
                    intent.putExtra("Main_User", str);
                    intent.putExtra("MainUI_User_Last_Msg_Type", i);
                    intent.addFlags(536870912);
                    intent.addFlags(67108864);
                    if (MF) {
                        intent.putExtra("talkerCount", 1);
                        intent.putExtra("Intro_Is_Muti_Talker", false);
                    } else {
                        if (size <= 1) {
                            intent.putExtra("Intro_Is_Muti_Talker", false);
                        } else {
                            intent.putExtra("Intro_Is_Muti_Talker", true);
                        }
                        intent.putExtra("talkerCount", size);
                    }
                    intent.putExtra("pushcontent_unread_count", IK);
                    PendingIntent b = d.b(context2, jP, intent);
                    String d = h.d(context2, str2, MF);
                    String a4 = h.a(context2, str3, size, IK, i3, MF);
                    String e = h.e(context2, str3, MF);
                    if (com.tencent.mm.m.a.MF()) {
                        a = com.tencent.mm.booter.notification.a.a.a(context2, com.tencent.mm.booter.notification.a.a.H(str, str4));
                    } else {
                        a = null;
                    }
                    NotificationItem notificationItem = new NotificationItem(jP, str, cVar.a(IJ, bWV, i4, b, d, a4, e, a, str));
                    notificationItem.edW = j;
                    notificationItem.edX = i3;
                    cVar.a(notificationItem, cVar.cfT);
                    com.tencent.mm.booter.notification.d.in(cVar.cfT.eeH);
                    com.tencent.mm.booter.notification.d.z(str, i3);
                }
            }
            AppMethodBeat.o(18260);
        } catch (Exception e2) {
            ab.e("MicroMsg.Notification.Handle", "push:notify, error");
            ab.printErrStackTrace("MicroMsg.Notification.Handle", e2, "", new Object[0]);
            AppMethodBeat.o(18260);
        }
    }

    public final void aVq() {
        AppMethodBeat.i(18261);
        a.eec;
        e.k(-1, null);
        AppMethodBeat.o(18261);
    }
}
