package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.v;
import android.support.v4.app.y;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.f.a;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.List;
import java.util.Map;

public final class b implements an, aq {
    bi cKd;
    Context context = null;
    private String edo;
    private String edp;
    String edq;
    Intent edr;
    private boolean eds;
    private boolean edt;
    private long edu;
    f edv = a.eec;
    private e edw;
    @SuppressLint({"HandlerLeak"})
    ak edx = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(15892);
            super.handleMessage(message);
            ah.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
            String string = message.getData().getString("notification.show.talker");
            String string2 = message.getData().getString("notification.show.message.content");
            int i = message.getData().getInt("notification.show.message.type");
            int i2 = message.getData().getInt("notification.show.tipsflag");
            ab.i("MicroMsg.MMNotification", "notify need to deal: %s", string);
            try {
                if (message.what == 1) {
                    b.a(b.this, string, string2, i, i2, true);
                    AppMethodBeat.o(15892);
                    return;
                }
                b.a(b.this, string, string2, i, i2, false);
                AppMethodBeat.o(15892);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMNotification", e, "showNotifiHandler", new Object[0]);
                AppMethodBeat.o(15892);
            }
        }
    };
    private final c edy = new c<pe>() {
        {
            AppMethodBeat.i(15893);
            this.xxI = pe.class.getName().hashCode();
            AppMethodBeat.o(15893);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15894);
            pe peVar = (pe) bVar;
            if (peVar != null && (peVar instanceof pe)) {
                bi biVar = peVar.cLt.cKd;
                if (biVar != null) {
                    b bVar2 = b.this;
                    if (biVar.field_isSend == 1) {
                        ab.w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", Long.valueOf(biVar.field_msgSvrId));
                    } else {
                        bVar2.cKd = biVar;
                        int b = b.b(biVar);
                        bVar2.talker = biVar.field_talker;
                        String str = biVar.field_content;
                        int type = biVar.getType();
                        bVar2.edq = "";
                        bVar2.edr = null;
                        ab.i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", bVar2.talker, Long.valueOf(biVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b), bo.anv(str));
                        if (f.a(bVar2.talker, bVar2.cKd, b, true)) {
                            bVar2.edx.sendMessageDelayed(b.a(bVar2.talker, str, type, b, 1), 200);
                        } else {
                            ab.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                        }
                    }
                }
            }
            AppMethodBeat.o(15894);
            return false;
        }
    };
    private final c edz = new c<qd>() {
        {
            AppMethodBeat.i(15895);
            this.xxI = qd.class.getName().hashCode();
            AppMethodBeat.o(15895);
        }

        private boolean a(qd qdVar) {
            AppMethodBeat.i(15896);
            if (qdVar != null && (qdVar instanceof qd)) {
                String str = qdVar.cMt.cKE;
                int i = qdVar.cMt.msgType;
                b bVar = b.this;
                try {
                    ab.w("showSendMsgFailNotification fromUserName:%s msgType:%d", str, Integer.valueOf(i));
                    if (!ChattingUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) bVar.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
                        Intent intent = new Intent(bVar.context, ChattingUI.class);
                        intent.putExtra("nofification_type", "pushcontent_notification");
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("MainUI_User_Last_Msg_Type", i);
                        intent.addFlags(536870912);
                        intent.addFlags(67108864);
                        PendingIntent activity = PendingIntent.getActivity(bVar.context, 35, intent, ErrorDialogData.SUPPRESSED);
                        v.c e = com.tencent.mm.bo.a.bt(bVar.context, com.tencent.mm.bo.a.dgM()).g(null).j(System.currentTimeMillis()).d(bVar.context.getString(R.string.t0)).e(bVar.context.getString(R.string.czo));
                        e.EI = activity;
                        Notification build = e.build();
                        build.icon = com.tencent.mm.bo.a.bWV();
                        build.defaults |= 1;
                        build.flags |= 16;
                        bVar.a(35, build, true);
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.MMNotification", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(15896);
            return false;
        }
    };
    String talker;

    public b(Context context) {
        AppMethodBeat.i(15898);
        this.context = context;
        this.talker = "";
        this.edq = "";
        this.edo = "";
        this.edu = 0;
        this.edt = false;
        this.edr = null;
        this.edw = new e();
        d.a(this);
        com.tencent.mm.modelvoice.e.a((aq) this);
        com.tencent.mm.plugin.base.stub.b.a(this);
        com.tencent.mm.sdk.b.a.xxA.c(this.edz);
        com.tencent.mm.sdk.b.a.xxA.c(this.edy);
        AppMethodBeat.o(15898);
    }

    public final void jO(String str) {
        this.edo = str;
    }

    public final String IG() {
        return this.edo;
    }

    public final void bv(boolean z) {
        AppMethodBeat.i(15899);
        this.eds = z;
        ab.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", Boolean.valueOf(this.eds), bo.dpG());
        AppMethodBeat.o(15899);
    }

    public final void cancelNotification(String str) {
        AppMethodBeat.i(15900);
        ab.v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.edp + "  curChattingTalker:" + this.edo);
        if (this.edt) {
            aw.ZK();
            com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(str);
            if (aoZ != null && aoZ.field_unReadCount != 0) {
                cancel();
                AppMethodBeat.o(15900);
                return;
            } else if (u.nR(t.fkP) == 0) {
                cancel();
                AppMethodBeat.o(15900);
                return;
            } else {
                AppMethodBeat.o(15900);
                return;
            }
        }
        AppMethodBeat.o(15900);
    }

    public final void IH() {
        AppMethodBeat.i(15901);
        try {
            String string = ah.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                for (String ank : string.split(",")) {
                    int ank2 = bo.ank(ank);
                    if (ank2 > 0) {
                        aw.getNotification().cancel(ank2);
                    }
                }
            }
            AppMethodBeat.o(15901);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMNotification", e, "try cancel notification fail: %s", e.getMessage());
            AppMethodBeat.o(15901);
        }
    }

    public final void BV() {
        AppMethodBeat.i(15902);
        ab.d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
        AppMethodBeat.o(15902);
    }

    private void cancel() {
        AppMethodBeat.i(15903);
        this.edt = false;
        e.cancel();
        AppMethodBeat.o(15903);
    }

    public final void a(bi biVar) {
        AppMethodBeat.i(15904);
        if (biVar == null) {
            AppMethodBeat.o(15904);
        } else if (biVar.field_isSend == 1) {
            ab.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", Long.valueOf(biVar.field_msgSvrId));
            AppMethodBeat.o(15904);
        } else {
            com.tencent.mm.model.bf.b oE = bf.oE(biVar.dqJ);
            if (oE == null || oE.scene != 1) {
                int b = b(biVar);
                this.cKd = biVar;
                this.talker = biVar.field_talker;
                String str = biVar.field_content;
                int type = biVar.getType();
                this.edq = "";
                this.edr = null;
                ab.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(biVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b), bo.anv(str));
                if (f.a(this.talker, this.cKd, b, false)) {
                    this.edx.sendMessageDelayed(a(this.talker, str, type, b, 0), 200);
                    AppMethodBeat.o(15904);
                    return;
                }
                ab.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                AppMethodBeat.o(15904);
                return;
            }
            AppMethodBeat.o(15904);
        }
    }

    static Message a(String str, String str2, int i, int i2, int i3) {
        AppMethodBeat.i(15905);
        ab.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", str, Integer.valueOf(i), bo.dpG().toString());
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i);
        bundle.putInt("notification.show.tipsflag", i2);
        obtain.setData(bundle);
        obtain.what = i3;
        AppMethodBeat.o(15905);
        return obtain;
    }

    public final Looper getLooper() {
        AppMethodBeat.i(15906);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.o(15906);
        return mainLooper;
    }

    public final void L(List<bi> list) {
        cy cyVar = null;
        AppMethodBeat.i(15907);
        if (list == null || list.size() <= 0) {
            String str = "MicroMsg.MMNotification";
            String str2 = "notifyOther newMsgList:%d :%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
            objArr[1] = bo.dpG();
            ab.w(str, str2, objArr);
            AppMethodBeat.o(15907);
            return;
        }
        int b;
        int size = list.size() - 1;
        boolean z = false;
        while (size >= 0) {
            cy cyVar2 = (bi) list.get(size);
            b = b(cyVar2);
            if (f.a(cyVar2.field_talker, cyVar2, b, false)) {
                cyVar = cyVar2;
                break;
            } else {
                size--;
                z = b;
            }
        }
        boolean b2 = z;
        if (cyVar == null) {
            ab.w("MicroMsg.MMNotification", "notifyOther msg == null");
            AppMethodBeat.o(15907);
            return;
        }
        this.edq = "";
        this.talker = cyVar.field_talker;
        String str3 = cyVar.field_content;
        size = cyVar.getType();
        this.cKd = cyVar;
        ab.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(cyVar.field_msgSvrId), Integer.valueOf(size), Integer.valueOf(b2), bo.anv(str3));
        this.edx.sendMessageDelayed(a(this.talker, str3, size, b2, 0), 200);
        AppMethodBeat.o(15907);
    }

    public final void ik(int i) {
        AppMethodBeat.i(15912);
        d.in(i);
        AppMethodBeat.o(15912);
    }

    public final void y(String str, int i) {
        AppMethodBeat.i(15913);
        d.z(str, i);
        AppMethodBeat.o(15913);
    }

    public final void bw(boolean z) {
        AppMethodBeat.i(15914);
        d.bx(z);
        AppMethodBeat.o(15914);
    }

    public final void notify(int i, Notification notification) {
        AppMethodBeat.i(15916);
        a(i, notification, true);
        AppMethodBeat.o(15916);
    }

    public final int c(Notification notification) {
        AppMethodBeat.i(15919);
        int a = a(notification, true);
        AppMethodBeat.o(15919);
        return a;
    }

    public final Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(15921);
        Notification a = a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(15921);
        return a;
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        AppMethodBeat.i(15908);
        com.tencent.mm.bp.d.a("webview", new com.tencent.mm.platformtools.y.AnonymousClass1(str3, str4, bundle, str, str2, i), new com.tencent.mm.bp.b() {
            public final void e(Exception exception) {
                AppMethodBeat.i(16671);
                ab.e("MiroMsg.NotificationUtil", "Load plugin failed");
                AppMethodBeat.o(16671);
            }
        });
        AppMethodBeat.o(15908);
    }

    public final Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6) {
        AppMethodBeat.i(15909);
        Notification a = a.eec.eeb.edT.a(notification, i, 1, pendingIntent, str, str2, str3, bitmap, R.drawable.bdq, str4, pendingIntent2, R.drawable.bdp, str5, pendingIntent3, str6);
        AppMethodBeat.o(15909);
        return a;
    }

    public final void k(int i, String str) {
        AppMethodBeat.i(15910);
        a.eec;
        e.k(i, str);
        AppMethodBeat.o(15910);
    }

    public final void II() {
        AppMethodBeat.i(15911);
        a.eec;
        c.II();
        AppMethodBeat.o(15911);
    }

    public final void il(int i) {
        AppMethodBeat.i(15915);
        a.eec;
        if (i != 0) {
            List<Integer> io = com.tencent.mm.booter.notification.queue.b.IP().eei.io(i);
            if (io.isEmpty()) {
                AppMethodBeat.o(15915);
                return;
            }
            y L = y.L(ah.getContext());
            for (Integer intValue : io) {
                com.tencent.mm.booter.notification.queue.b.IP().a(L, intValue.intValue());
            }
        }
        AppMethodBeat.o(15915);
    }

    public final void a(int i, Notification notification, boolean z) {
        AppMethodBeat.i(15917);
        a.eec.b(new NotificationItem(i, notification, z));
        AppMethodBeat.o(15917);
    }

    public final int a(Notification notification, boolean z) {
        AppMethodBeat.i(15918);
        int b = a.eec.b(new NotificationItem(notification, z));
        AppMethodBeat.o(15918);
        return b;
    }

    public final void cancel(int i) {
        AppMethodBeat.i(15920);
        a.eec;
        com.tencent.mm.booter.notification.queue.b.IP().cancel(i);
        AppMethodBeat.o(15920);
    }

    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(15922);
        Notification a = a.eec.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(15922);
        return a;
    }

    static int b(bi biVar) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(15923);
        if (t.mZ(biVar.field_talker)) {
            i = 0;
        } else {
            i = 3;
        }
        if (biVar.field_bizChatId != -1 && f.kq(biVar.field_talker)) {
            com.tencent.mm.aj.a.c aK = z.aeT().aK(biVar.field_bizChatId);
            if (!aK.isGroup() && aK.lc(1)) {
                AppMethodBeat.o(15923);
                return i;
            }
        }
        String str = biVar.dqJ;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(15923);
            return i;
        }
        Map z = br.z(str, "msgsource");
        if (z == null || z.isEmpty()) {
            AppMethodBeat.o(15923);
            return i;
        }
        try {
            int i3 = bo.getInt((String) z.get(".msgsource.tips"), i);
            if ((i3 & 1) != 0 || (i3 & 2) == 0) {
                i2 = i3;
            }
            AppMethodBeat.o(15923);
            return i2;
        } catch (Exception e) {
            AppMethodBeat.o(15923);
            return i;
        }
    }
}
