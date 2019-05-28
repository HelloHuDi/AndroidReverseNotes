package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.content.Intent;
import android.support.v4.f.a;
import android.util.Pair;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WCFirebaseMessagingService extends FirebaseMessagingService {
    static List<Pair<Long, Long>> mqH = new LinkedList();
    private WakerLock wakerlock;

    static {
        AppMethodBeat.i(56458);
        AppMethodBeat.o(56458);
    }

    public final void onDeletedMessages() {
        AppMethodBeat.i(56454);
        super.onDeletedMessages();
        ab.i("MicroMsg.FCM.WCFirebaseMessagingService", "Deleted messages on server.");
        h.pYm.X(11250, "1,1");
        e.pXa.a(901, 31, 1, false);
        AppMethodBeat.o(56454);
    }

    public final void a(String str, Exception exception) {
        AppMethodBeat.i(56455);
        super.a(str, exception);
        h.pYm.X(11250, "1,1");
        e.pXa.a(901, 30, 1, false);
        AppMethodBeat.o(56455);
    }

    public final void a(RemoteMessage remoteMessage) {
        AppMethodBeat.i(56456);
        ab.i("MicroMsg.FCM.WCFirebaseMessagingService", "on message received");
        a bwG = a.bwG();
        if (bwG == null) {
            ab.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcmRegister is null");
            e.pXa.a(901, 26, 1, false);
            AppMethodBeat.o(56456);
        } else if (bwG.bwJ()) {
            try {
                Context context = ah.getContext();
                if (l.bL(context)) {
                    ab.i("MicroMsg.FCM.WCFirebaseMessagingService", "Logout or exit MM. no need show Notification.");
                    h.pYm.X(11250, "1,2");
                    e.pXa.a(901, 28, 1, false);
                    AppMethodBeat.o(56456);
                    return;
                }
                String str;
                if (remoteMessage.bxe == null) {
                    remoteMessage.bxe = new a();
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
                    ab.i("MicroMsg.FCM.WCFirebaseMessagingService", "msg data is empty: ");
                    h.pYm.X(11250, "1,0");
                    e.pXa.a(901, 29, 1, false);
                    AppMethodBeat.o(56456);
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
                e.pXa.a(901, 32, 1, false);
                String str14 = "MicroMsg.FCM.WCFirebaseMessagingService";
                String str15 = "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                Object[] objArr = new Object[11];
                objArr[0] = str2;
                objArr[1] = str4;
                objArr[2] = str5;
                objArr[3] = bo.anv(str6);
                objArr[4] = str7;
                objArr[5] = str8;
                objArr[6] = str9;
                objArr[7] = Integer.valueOf(str10 == null ? -1 : str10.length());
                objArr[8] = str11;
                objArr[9] = str12;
                objArr[10] = str13;
                ab.i(str14, str15, objArr);
                long j = bo.isNullOrNil(str4) ? 0 : bo.getLong(str4, 0);
                long j2 = bo.isNullOrNil(str2) ? 0 : bo.getLong(str2, 0);
                long j3 = bo.isNullOrNil(str5) ? 0 : bo.getLong(str5, 0);
                int Ra = com.tencent.mm.kernel.a.Ra();
                if (j == 0 || !Integer.toHexString(Ra).equals(Long.toHexString(j))) {
                    ab.e("MicroMsg.FCM.WCFirebaseMessagingService", "Logined user changed. no need show Notification.uin:" + j + ", oldUin:" + Ra);
                    h.pYm.X(11250, "1,3");
                    e.pXa.a(901, j == 0 ? 33 : 34, 1, false);
                    AppMethodBeat.o(56456);
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
                    ab.w("MicroMsg.FCM.WCFirebaseMessagingService", "already has this seq:".concat(String.valueOf(j2)));
                    e.pXa.a(901, 35, 1, false);
                    AppMethodBeat.o(56456);
                    return;
                }
                mqH.add(Pair.create(Long.valueOf(j3), Long.valueOf(j2)));
                if (mqH.size() > 60) {
                    mqH.remove(0);
                }
                if (this.wakerlock == null) {
                    this.wakerlock = new WakerLock(context, "MicroMsg.FCM.WCFirebaseMessagingService");
                    ab.i("MicroMsg.FCM.WCFirebaseMessagingService", "start new wakerlock");
                }
                this.wakerlock.lock(200, "FcmBroadcastReceiver.onReceive");
                ab.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync");
                Intent intent = new Intent(ah.getContext(), NotifyService.class);
                intent.putExtra("notify_option_type", 2);
                intent.putExtra("notify_uin", com.tencent.mm.kernel.a.Ra());
                intent.putExtra("notify_respType", 2147480001);
                intent.putExtra("notify_respBuf", new byte[0]);
                intent.putExtra("notfiy_recv_time", bo.anU());
                g.RQ();
                intent.putExtra("notify_skey", g.RO().jQ(1));
                d.aH(intent);
                ab.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync end!");
                AppMethodBeat.o(56456);
            } catch (Exception e) {
                ab.e("MicroMsg.FCM.WCFirebaseMessagingService", "onMessageReceived error :".concat(String.valueOf(e.toString())));
                ab.printErrStackTrace("MicroMsg.FCM.WCFirebaseMessagingService", e, "", new Object[0]);
                e.pXa.a(901, 36, 1, false);
                AppMethodBeat.o(56456);
            }
        } else {
            ab.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcm push not reg to server.");
            e.pXa.a(901, 25, 1, false);
            AppMethodBeat.o(56456);
        }
    }

    public static void bwL() {
        AppMethodBeat.i(56457);
        mqH.clear();
        AppMethodBeat.o(56457);
    }
}
