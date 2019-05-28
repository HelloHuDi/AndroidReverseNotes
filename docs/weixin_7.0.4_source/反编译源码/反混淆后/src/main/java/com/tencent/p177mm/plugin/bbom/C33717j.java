package com.tencent.p177mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.notification.C18103d;
import com.tencent.p177mm.booter.notification.C18105f.C18104a;
import com.tencent.p177mm.booter.notification.C25979e;
import com.tencent.p177mm.booter.notification.C44684c;
import com.tencent.p177mm.booter.notification.C44684c.C44685a;
import com.tencent.p177mm.booter.notification.NotificationItem;
import com.tencent.p177mm.booter.notification.p841a.C18100d;
import com.tencent.p177mm.booter.notification.p841a.C25976e;
import com.tencent.p177mm.booter.notification.p841a.C25977g;
import com.tencent.p177mm.booter.notification.p841a.C37621a;
import com.tencent.p177mm.booter.notification.p841a.C37622h;
import com.tencent.p177mm.booter.notification.queue.C9203b;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.plugin.zero.p591a.C23228b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.bbom.j */
public final class C33717j implements C23228b {
    /* renamed from: a */
    public final void mo38834a(long j, String str, String str2, String str3, String str4, int i) {
        int i2;
        AppMethodBeat.m2504i(18260);
        if (C5046bo.isNullOrNil(str2)) {
            Context context = C4996ah.getContext();
            if (C18559f.m28908kH(str)) {
                i2 = C25738R.string.ao1;
            } else {
                i2 = C25738R.string.ce1;
            }
            str2 = context.getString(i2);
        }
        C25979e c25979e = C18104a.eec.eeb;
        if (!C37885a.m63953MF()) {
            C25979e.cancel();
        }
        try {
            C44684c c44684c = c25979e.edT;
            Context context2 = C4996ah.getContext();
            C4996ah.getContext();
            boolean IX = C25976e.m41426IX();
            C4996ah.getContext();
            boolean IV = C25976e.m41424IV();
            C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", Boolean.valueOf(IX), Boolean.valueOf(IV));
            if (j != 0) {
                if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7416i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
                    AppMethodBeat.m2505o(18260);
                    return;
                } else if (C18559f.m28881Nn() && !C18559f.m28882No()) {
                    C4990ab.m7416i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
                    AppMethodBeat.m2505o(18260);
                    return;
                } else if (!C37885a.m63950MC()) {
                    C4990ab.m7416i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
                    AppMethodBeat.m2505o(18260);
                    return;
                } else if (C44684c.m81271eS(j)) {
                    C4990ab.m7416i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
                    AppMethodBeat.m2505o(18260);
                    return;
                } else {
                    Bitmap a;
                    C9203b.m16707IP().restore();
                    int IK = C44684c.m81265IK() + 1;
                    C44685a a2 = C44684c.m81268a(C44684c.m81266IL(), str);
                    if (a2 == null) {
                        i2 = 0;
                    } else {
                        i2 = a2.edE;
                    }
                    int i3 = i2 + 1;
                    List IL = C44684c.m81266IL();
                    if (IL == null) {
                        IL = new ArrayList();
                    }
                    C44685a a3 = C44684c.m81268a(IL, str);
                    if (a3 == null) {
                        a3 = new C44685a();
                        a3.userName = str;
                        a3.edE = 1;
                        IL.add(a3);
                    } else {
                        a3.edE++;
                    }
                    C44684c.m81272f(IL);
                    C44684c.m81273im(C44684c.m81265IK() + 1);
                    int size = IL.size();
                    if (C25976e.m41423IU()) {
                        IV = false;
                        IX = false;
                    }
                    Notification IJ = C44684c.m81264IJ();
                    int jP = C9203b.m16707IP().mo20615jP(str);
                    c44684c.cfT.eeH = IK;
                    c44684c.cfT.eeG = size;
                    c44684c.cfT.eeN = IX;
                    c44684c.cfT.eeM = IV;
                    boolean MF = C37885a.m63953MF();
                    int bWV = C45186a.bWV();
                    C25977g c25977g = c44684c.cfT;
                    c25977g.eez.mo73171a(c25977g.mContext, IV, IX, IJ, null);
                    int i4 = c25977g.eez.eel;
                    C4990ab.m7417i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", Integer.valueOf(jP), str, Integer.valueOf(i), Integer.valueOf(IK), Integer.valueOf(size), Boolean.FALSE, Boolean.valueOf(MF));
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
                    PendingIntent b = C18100d.m28514b(context2, jP, intent);
                    String d = C37622h.m63530d(context2, str2, MF);
                    String a4 = C37622h.m63521a(context2, str3, size, IK, i3, MF);
                    String e = C37622h.m63531e(context2, str3, MF);
                    if (C37885a.m63953MF()) {
                        a = C37621a.m63515a(context2, C37621a.m63514H(str, str4));
                    } else {
                        a = null;
                    }
                    NotificationItem notificationItem = new NotificationItem(jP, str, c44684c.mo71726a(IJ, bWV, i4, b, d, a4, e, a, str));
                    notificationItem.edW = j;
                    notificationItem.edX = i3;
                    c44684c.mo67551a(notificationItem, c44684c.cfT);
                    C18103d.m28522in(c44684c.cfT.eeH);
                    C18103d.m28523z(str, i3);
                }
            }
            AppMethodBeat.m2505o(18260);
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.Notification.Handle", "push:notify, error");
            C4990ab.printErrStackTrace("MicroMsg.Notification.Handle", e2, "", new Object[0]);
            AppMethodBeat.m2505o(18260);
        }
    }

    public final void aVq() {
        AppMethodBeat.m2504i(18261);
        C18104a.eec;
        C25979e.m41440k(-1, null);
        AppMethodBeat.m2505o(18261);
    }
}
