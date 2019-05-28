package com.tencent.p177mm.plugin.fcm;

import android.content.Context;
import android.content.Intent;
import android.support.p057v4.p065f.C6197a;
import android.util.Pair;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.NotifyReceiver.NotifyService;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fcm.WCFirebaseMessagingService */
public class WCFirebaseMessagingService extends FirebaseMessagingService {
    static List<Pair<Long, Long>> mqH = new LinkedList();
    private WakerLock wakerlock;

    static {
        AppMethodBeat.m2504i(56458);
        AppMethodBeat.m2505o(56458);
    }

    public final void onDeletedMessages() {
        AppMethodBeat.m2504i(56454);
        super.onDeletedMessages();
        C4990ab.m7416i("MicroMsg.FCM.WCFirebaseMessagingService", "Deleted messages on server.");
        C7060h.pYm.mo8374X(11250, "1,1");
        C7053e.pXa.mo8378a(901, 31, 1, false);
        AppMethodBeat.m2505o(56454);
    }

    /* renamed from: a */
    public final void mo32802a(String str, Exception exception) {
        AppMethodBeat.m2504i(56455);
        super.mo32802a(str, exception);
        C7060h.pYm.mo8374X(11250, "1,1");
        C7053e.pXa.mo8378a(901, 30, 1, false);
        AppMethodBeat.m2505o(56455);
    }

    /* renamed from: a */
    public final void mo32801a(RemoteMessage remoteMessage) {
        AppMethodBeat.m2504i(56456);
        C4990ab.m7416i("MicroMsg.FCM.WCFirebaseMessagingService", "on message received");
        C39085a bwG = C39085a.bwG();
        if (bwG == null) {
            C4990ab.m7420w("MicroMsg.FCM.WCFirebaseMessagingService", "fcmRegister is null");
            C7053e.pXa.mo8378a(901, 26, 1, false);
            AppMethodBeat.m2505o(56456);
        } else if (bwG.bwJ()) {
            try {
                Context context = C4996ah.getContext();
                if (C1737l.m3591bL(context)) {
                    C4990ab.m7416i("MicroMsg.FCM.WCFirebaseMessagingService", "Logout or exit MM. no need show Notification.");
                    C7060h.pYm.mo8374X(11250, "1,2");
                    C7053e.pXa.mo8378a(901, 28, 1, false);
                    AppMethodBeat.m2505o(56456);
                    return;
                }
                String str;
                if (remoteMessage.bxe == null) {
                    remoteMessage.bxe = new C6197a();
                    for (String str2 : remoteMessage.bxd.keySet()) {
                        Object obj = remoteMessage.bxd.get(str2);
                        if (obj instanceof String) {
                            String str3 = (String) obj;
                            if (!(str2.startsWith("google.") || str2.startsWith("gcm.") || str2.equals("from") || str2.equals("message_type") || str2.equals("collapse_key"))) {
                                remoteMessage.bxe.put(str2, str3);
                            }
                        }
                    }
                }
                Map map = remoteMessage.bxe;
                if (map.isEmpty()) {
                    C4990ab.m7416i("MicroMsg.FCM.WCFirebaseMessagingService", "msg data is empty: ");
                    C7060h.pYm.mo8374X(11250, "1,0");
                    C7053e.pXa.mo8378a(901, 29, 1, false);
                    AppMethodBeat.m2505o(56456);
                    return;
                }
                str2 = (String) map.get("seq");
                String str4 = (String) map.get(OpenSDKTool4Assistant.EXTRA_UIN);
                String str5 = (String) map.get("cmd");
                String str6 = (String) map.get("username");
                String str7 = (String) map.get("time");
                String str8 = (String) map.get("collapse_key");
                String str9 = (String) map.get("sound");
                String str10 = (String) map.get("alert");
                String str11 = (String) map.get("msgType");
                String str12 = (String) map.get("badge");
                String str13 = (String) map.get("from");
                C7053e.pXa.mo8378a(901, 32, 1, false);
                String str14 = "MicroMsg.FCM.WCFirebaseMessagingService";
                String str15 = "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                Object[] objArr = new Object[11];
                objArr[0] = str2;
                objArr[1] = str4;
                objArr[2] = str5;
                objArr[3] = C5046bo.anv(str6);
                objArr[4] = str7;
                objArr[5] = str8;
                objArr[6] = str9;
                objArr[7] = Integer.valueOf(str10 == null ? -1 : str10.length());
                objArr[8] = str11;
                objArr[9] = str12;
                objArr[10] = str13;
                C4990ab.m7417i(str14, str15, objArr);
                long j = C5046bo.isNullOrNil(str4) ? 0 : C5046bo.getLong(str4, 0);
                long j2 = C5046bo.isNullOrNil(str2) ? 0 : C5046bo.getLong(str2, 0);
                long j3 = C5046bo.isNullOrNil(str5) ? 0 : C5046bo.getLong(str5, 0);
                int Ra = C1668a.m3396Ra();
                if (j == 0 || !Integer.toHexString(Ra).equals(Long.toHexString(j))) {
                    C4990ab.m7412e("MicroMsg.FCM.WCFirebaseMessagingService", "Logined user changed. no need show Notification.uin:" + j + ", oldUin:" + Ra);
                    C7060h.pYm.mo8374X(11250, "1,3");
                    C7053e.pXa.mo8378a(901, j == 0 ? 33 : 34, 1, false);
                    AppMethodBeat.m2505o(56456);
                    return;
                }
                Object obj2;
                for (Pair pair : mqH) {
                    if (((Long) pair.first).longValue() == j3 && ((Long) pair.second).longValue() == j2) {
                        obj2 = 1;
                        break;
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    C4990ab.m7420w("MicroMsg.FCM.WCFirebaseMessagingService", "already has this seq:".concat(String.valueOf(j2)));
                    C7053e.pXa.mo8378a(901, 35, 1, false);
                    AppMethodBeat.m2505o(56456);
                    return;
                }
                mqH.add(Pair.create(Long.valueOf(j3), Long.valueOf(j2)));
                if (mqH.size() > 60) {
                    mqH.remove(0);
                }
                if (this.wakerlock == null) {
                    this.wakerlock = new WakerLock(context, "MicroMsg.FCM.WCFirebaseMessagingService");
                    C4990ab.m7416i("MicroMsg.FCM.WCFirebaseMessagingService", "start new wakerlock");
                }
                this.wakerlock.lock(200, "FcmBroadcastReceiver.onReceive");
                C4990ab.m7416i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync");
                Intent intent = new Intent(C4996ah.getContext(), NotifyService.class);
                intent.putExtra("notify_option_type", 2);
                intent.putExtra("notify_uin", C1668a.m3396Ra());
                intent.putExtra("notify_respType", 2147480001);
                intent.putExtra("notify_respBuf", new byte[0]);
                intent.putExtra("notfiy_recv_time", C5046bo.anU());
                C1720g.m3537RQ();
                intent.putExtra("notify_skey", C1720g.m3535RO().mo5189jQ(1));
                C25985d.m41463aH(intent);
                C4990ab.m7416i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync end!");
                AppMethodBeat.m2505o(56456);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FCM.WCFirebaseMessagingService", "onMessageReceived error :".concat(String.valueOf(e.toString())));
                C4990ab.printErrStackTrace("MicroMsg.FCM.WCFirebaseMessagingService", e, "", new Object[0]);
                C7053e.pXa.mo8378a(901, 36, 1, false);
                AppMethodBeat.m2505o(56456);
            }
        } else {
            C4990ab.m7420w("MicroMsg.FCM.WCFirebaseMessagingService", "fcm push not reg to server.");
            C7053e.pXa.mo8378a(901, 25, 1, false);
            AppMethodBeat.m2505o(56456);
        }
    }

    public static void bwL() {
        AppMethodBeat.m2504i(56457);
        mqH.clear();
        AppMethodBeat.m2505o(56457);
    }
}
