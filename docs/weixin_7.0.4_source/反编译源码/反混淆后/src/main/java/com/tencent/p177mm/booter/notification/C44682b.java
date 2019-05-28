package com.tencent.p177mm.booter.notification;

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
import android.support.p057v4.app.C0363v.C0358c;
import android.support.p057v4.app.C17432y;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.notification.C18105f.C18104a;
import com.tencent.p177mm.booter.notification.p841a.C25976e;
import com.tencent.p177mm.booter.notification.queue.C9203b;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C24672an;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C42184aq;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C37964e;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p230g.p231a.C18373qd;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42253y.C379882;
import com.tencent.p177mm.platformtools.C42253y.C422541;
import com.tencent.p177mm.plugin.base.stub.C33714b;
import com.tencent.p177mm.plugin.notification.C3559d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.booter.notification.b */
public final class C44682b implements C24672an, C42184aq {
    C7620bi cKd;
    Context context = null;
    private String edo;
    private String edp;
    String edq;
    Intent edr;
    private boolean eds;
    private boolean edt;
    private long edu;
    C18105f edv = C18104a.eec;
    private C25976e edw;
    @SuppressLint({"HandlerLeak"})
    C7306ak edx = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(15892);
            super.handleMessage(message);
            C4996ah.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
            String string = message.getData().getString("notification.show.talker");
            String string2 = message.getData().getString("notification.show.message.content");
            int i = message.getData().getInt("notification.show.message.type");
            int i2 = message.getData().getInt("notification.show.tipsflag");
            C4990ab.m7417i("MicroMsg.MMNotification", "notify need to deal: %s", string);
            try {
                if (message.what == 1) {
                    C44682b.m81241a(C44682b.this, string, string2, i, i2, true);
                    AppMethodBeat.m2505o(15892);
                    return;
                }
                C44682b.m81241a(C44682b.this, string, string2, i, i2, false);
                AppMethodBeat.m2505o(15892);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMNotification", e, "showNotifiHandler", new Object[0]);
                AppMethodBeat.m2505o(15892);
            }
        }
    };
    private final C4884c edy = new C181012();
    private final C4884c edz = new C259783();
    String talker;

    /* renamed from: com.tencent.mm.booter.notification.b$2 */
    class C181012 extends C4884c<C37781pe> {
        C181012() {
            AppMethodBeat.m2504i(15893);
            this.xxI = C37781pe.class.getName().hashCode();
            AppMethodBeat.m2505o(15893);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15894);
            C37781pe c37781pe = (C37781pe) c4883b;
            if (c37781pe != null && (c37781pe instanceof C37781pe)) {
                C7620bi c7620bi = c37781pe.cLt.cKd;
                if (c7620bi != null) {
                    C44682b c44682b = C44682b.this;
                    if (c7620bi.field_isSend == 1) {
                        C4990ab.m7421w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", Long.valueOf(c7620bi.field_msgSvrId));
                    } else {
                        c44682b.cKd = c7620bi;
                        int b = C44682b.m81242b(c7620bi);
                        c44682b.talker = c7620bi.field_talker;
                        String str = c7620bi.field_content;
                        int type = c7620bi.getType();
                        c44682b.edq = "";
                        c44682b.edr = null;
                        C4990ab.m7417i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", c44682b.talker, Long.valueOf(c7620bi.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b), C5046bo.anv(str));
                        if (C18105f.m28525a(c44682b.talker, c44682b.cKd, b, true)) {
                            c44682b.edx.sendMessageDelayed(C44682b.m81240a(c44682b.talker, str, type, b, 1), 200);
                        } else {
                            C4990ab.m7420w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(15894);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.b$3 */
    class C259783 extends C4884c<C18373qd> {
        C259783() {
            AppMethodBeat.m2504i(15895);
            this.xxI = C18373qd.class.getName().hashCode();
            AppMethodBeat.m2505o(15895);
        }

        /* renamed from: a */
        private boolean m41438a(C18373qd c18373qd) {
            AppMethodBeat.m2504i(15896);
            if (c18373qd != null && (c18373qd instanceof C18373qd)) {
                String str = c18373qd.cMt.cKE;
                int i = c18373qd.cMt.msgType;
                C44682b c44682b = C44682b.this;
                try {
                    C4990ab.m7421w("showSendMsgFailNotification fromUserName:%s msgType:%d", str, Integer.valueOf(i));
                    if (!ChattingUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) c44682b.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
                        Intent intent = new Intent(c44682b.context, ChattingUI.class);
                        intent.putExtra("nofification_type", "pushcontent_notification");
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("MainUI_User_Last_Msg_Type", i);
                        intent.addFlags(536870912);
                        intent.addFlags(67108864);
                        PendingIntent activity = PendingIntent.getActivity(c44682b.context, 35, intent, ErrorDialogData.SUPPRESSED);
                        C0358c e = C45186a.m83262bt(c44682b.context, C45186a.dgM()).mo625g(null).mo626j(System.currentTimeMillis()).mo621d(c44682b.context.getString(C25738R.string.f9209t0)).mo623e(c44682b.context.getString(C25738R.string.czo));
                        e.f362EI = activity;
                        Notification build = e.build();
                        build.icon = C45186a.bWV();
                        build.defaults |= 1;
                        build.flags |= 16;
                        c44682b.mo41574a(35, build, true);
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.MMNotification", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(15896);
            return false;
        }
    }

    public C44682b(Context context) {
        AppMethodBeat.m2504i(15898);
        this.context = context;
        this.talker = "";
        this.edq = "";
        this.edo = "";
        this.edu = 0;
        this.edt = false;
        this.edr = null;
        this.edw = new C25976e();
        C3559d.m5893a(this);
        C37964e.m64230a((C42184aq) this);
        C33714b.m55095a(this);
        C4879a.xxA.mo10052c(this.edz);
        C4879a.xxA.mo10052c(this.edy);
        AppMethodBeat.m2505o(15898);
    }

    /* renamed from: jO */
    public final void mo41582jO(String str) {
        this.edo = str;
    }

    /* renamed from: IG */
    public final String mo41567IG() {
        return this.edo;
    }

    /* renamed from: bv */
    public final void mo41575bv(boolean z) {
        AppMethodBeat.m2504i(15899);
        this.eds = z;
        C4990ab.m7417i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", Boolean.valueOf(this.eds), C5046bo.dpG());
        AppMethodBeat.m2505o(15899);
    }

    public final void cancelNotification(String str) {
        AppMethodBeat.m2504i(15900);
        C4990ab.m7418v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.edp + "  curChattingTalker:" + this.edo);
        if (this.edt) {
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(str);
            if (aoZ != null && aoZ.field_unReadCount != 0) {
                cancel();
                AppMethodBeat.m2505o(15900);
                return;
            } else if (C32798u.m53585nR(C1855t.fkP) == 0) {
                cancel();
                AppMethodBeat.m2505o(15900);
                return;
            } else {
                AppMethodBeat.m2505o(15900);
                return;
            }
        }
        AppMethodBeat.m2505o(15900);
    }

    /* renamed from: IH */
    public final void mo41568IH() {
        AppMethodBeat.m2504i(15901);
        try {
            String string = C4996ah.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                for (String ank : string.split(",")) {
                    int ank2 = C5046bo.ank(ank);
                    if (ank2 > 0) {
                        C9638aw.getNotification().cancel(ank2);
                    }
                }
            }
            AppMethodBeat.m2505o(15901);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMNotification", e, "try cancel notification fail: %s", e.getMessage());
            AppMethodBeat.m2505o(15901);
        }
    }

    /* renamed from: BV */
    public final void mo41566BV() {
        AppMethodBeat.m2504i(15902);
        C4990ab.m7410d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
        AppMethodBeat.m2505o(15902);
    }

    private void cancel() {
        AppMethodBeat.m2504i(15903);
        this.edt = false;
        C25979e.cancel();
        AppMethodBeat.m2505o(15903);
    }

    /* renamed from: a */
    public final void mo27972a(C7620bi c7620bi) {
        AppMethodBeat.m2504i(15904);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(15904);
        } else if (c7620bi.field_isSend == 1) {
            C4990ab.m7421w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", Long.valueOf(c7620bi.field_msgSvrId));
            AppMethodBeat.m2505o(15904);
        } else {
            C1828b oE = C1829bf.m3758oE(c7620bi.dqJ);
            if (oE == null || oE.scene != 1) {
                int b = C44682b.m81242b(c7620bi);
                this.cKd = c7620bi;
                this.talker = c7620bi.field_talker;
                String str = c7620bi.field_content;
                int type = c7620bi.getType();
                this.edq = "";
                this.edr = null;
                C4990ab.m7417i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(c7620bi.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b), C5046bo.anv(str));
                if (C18105f.m28525a(this.talker, this.cKd, b, false)) {
                    this.edx.sendMessageDelayed(C44682b.m81240a(this.talker, str, type, b, 0), 200);
                    AppMethodBeat.m2505o(15904);
                    return;
                }
                C4990ab.m7420w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                AppMethodBeat.m2505o(15904);
                return;
            }
            AppMethodBeat.m2505o(15904);
        }
    }

    /* renamed from: a */
    static Message m81240a(String str, String str2, int i, int i2, int i3) {
        AppMethodBeat.m2504i(15905);
        C4990ab.m7411d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", str, Integer.valueOf(i), C5046bo.dpG().toString());
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i);
        bundle.putInt("notification.show.tipsflag", i2);
        obtain.setData(bundle);
        obtain.what = i3;
        AppMethodBeat.m2505o(15905);
        return obtain;
    }

    public final Looper getLooper() {
        AppMethodBeat.m2504i(15906);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.m2505o(15906);
        return mainLooper;
    }

    /* renamed from: L */
    public final void mo27970L(List<C7620bi> list) {
        C6575cy c6575cy = null;
        AppMethodBeat.m2504i(15907);
        if (list == null || list.size() <= 0) {
            String str = "MicroMsg.MMNotification";
            String str2 = "notifyOther newMsgList:%d :%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
            objArr[1] = C5046bo.dpG();
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(15907);
            return;
        }
        int b;
        int size = list.size() - 1;
        boolean z = false;
        while (size >= 0) {
            C6575cy c6575cy2 = (C7620bi) list.get(size);
            b = C44682b.m81242b(c6575cy2);
            if (C18105f.m28525a(c6575cy2.field_talker, c6575cy2, b, false)) {
                c6575cy = c6575cy2;
                break;
            } else {
                size--;
                z = b;
            }
        }
        boolean b2 = z;
        if (c6575cy == null) {
            C4990ab.m7420w("MicroMsg.MMNotification", "notifyOther msg == null");
            AppMethodBeat.m2505o(15907);
            return;
        }
        this.edq = "";
        this.talker = c6575cy.field_talker;
        String str3 = c6575cy.field_content;
        size = c6575cy.getType();
        this.cKd = c6575cy;
        C4990ab.m7417i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(c6575cy.field_msgSvrId), Integer.valueOf(size), Integer.valueOf(b2), C5046bo.anv(str3));
        this.edx.sendMessageDelayed(C44682b.m81240a(this.talker, str3, size, b2, 0), 200);
        AppMethodBeat.m2505o(15907);
    }

    /* renamed from: ik */
    public final void mo41580ik(int i) {
        AppMethodBeat.m2504i(15912);
        C18103d.m28522in(i);
        AppMethodBeat.m2505o(15912);
    }

    /* renamed from: y */
    public final void mo41584y(String str, int i) {
        AppMethodBeat.m2504i(15913);
        C18103d.m28523z(str, i);
        AppMethodBeat.m2505o(15913);
    }

    /* renamed from: bw */
    public final void mo41576bw(boolean z) {
        AppMethodBeat.m2504i(15914);
        C18103d.m28519bx(z);
        AppMethodBeat.m2505o(15914);
    }

    public final void notify(int i, Notification notification) {
        AppMethodBeat.m2504i(15916);
        mo41574a(i, notification, true);
        AppMethodBeat.m2505o(15916);
    }

    /* renamed from: c */
    public final int mo41577c(Notification notification) {
        AppMethodBeat.m2504i(15919);
        int a = mo41570a(notification, true);
        AppMethodBeat.m2505o(15919);
        return a;
    }

    /* renamed from: a */
    public final Notification mo41573a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.m2504i(15921);
        Notification a = mo41571a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.m2505o(15921);
        return a;
    }

    /* renamed from: a */
    public final void mo27971a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        AppMethodBeat.m2504i(15908);
        C25985d.m41451a("webview", new C422541(str3, str4, bundle, str, str2, i), new C379882());
        AppMethodBeat.m2505o(15908);
    }

    /* renamed from: a */
    public final Notification mo41572a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6) {
        AppMethodBeat.m2504i(15909);
        Notification a = C18104a.eec.eeb.edT.mo71725a(notification, i, 1, pendingIntent, str, str2, str3, bitmap, C25738R.drawable.bdq, str4, pendingIntent2, C25738R.drawable.bdp, str5, pendingIntent3, str6);
        AppMethodBeat.m2505o(15909);
        return a;
    }

    /* renamed from: k */
    public final void mo41583k(int i, String str) {
        AppMethodBeat.m2504i(15910);
        C18104a.eec;
        C25979e.m41440k(i, str);
        AppMethodBeat.m2505o(15910);
    }

    /* renamed from: II */
    public final void mo41569II() {
        AppMethodBeat.m2504i(15911);
        C18104a.eec;
        C44684c.m81263II();
        AppMethodBeat.m2505o(15911);
    }

    /* renamed from: il */
    public final void mo41581il(int i) {
        AppMethodBeat.m2504i(15915);
        C18104a.eec;
        if (i != 0) {
            List<Integer> io = C9203b.m16707IP().eei.mo33544io(i);
            if (io.isEmpty()) {
                AppMethodBeat.m2505o(15915);
                return;
            }
            C17432y L = C17432y.m27074L(C4996ah.getContext());
            for (Integer intValue : io) {
                C9203b.m16707IP().mo20610a(L, intValue.intValue());
            }
        }
        AppMethodBeat.m2505o(15915);
    }

    /* renamed from: a */
    public final void mo41574a(int i, Notification notification, boolean z) {
        AppMethodBeat.m2504i(15917);
        C18104a.eec.mo33541b(new NotificationItem(i, notification, z));
        AppMethodBeat.m2505o(15917);
    }

    /* renamed from: a */
    public final int mo41570a(Notification notification, boolean z) {
        AppMethodBeat.m2504i(15918);
        int b = C18104a.eec.mo33541b(new NotificationItem(notification, z));
        AppMethodBeat.m2505o(15918);
        return b;
    }

    public final void cancel(int i) {
        AppMethodBeat.m2504i(15920);
        C18104a.eec;
        C9203b.m16707IP().cancel(i);
        AppMethodBeat.m2505o(15920);
    }

    /* renamed from: a */
    public final Notification mo41571a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.m2504i(15922);
        Notification a = C18104a.eec.mo33540a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.m2505o(15922);
        return a;
    }

    /* renamed from: b */
    static int m81242b(C7620bi c7620bi) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(15923);
        if (C1855t.m3913mZ(c7620bi.field_talker)) {
            i = 0;
        } else {
            i = 3;
        }
        if (c7620bi.field_bizChatId != -1 && C17903f.m28103kq(c7620bi.field_talker)) {
            C45142c aK = C41747z.aeT().mo60349aK(c7620bi.field_bizChatId);
            if (!aK.isGroup() && aK.mo73052lc(1)) {
                AppMethodBeat.m2505o(15923);
                return i;
            }
        }
        String str = c7620bi.dqJ;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(15923);
            return i;
        }
        Map z = C5049br.m7595z(str, "msgsource");
        if (z == null || z.isEmpty()) {
            AppMethodBeat.m2505o(15923);
            return i;
        }
        try {
            int i3 = C5046bo.getInt((String) z.get(".msgsource.tips"), i);
            if ((i3 & 1) != 0 || (i3 & 2) == 0) {
                i2 = i3;
            }
            AppMethodBeat.m2505o(15923);
            return i2;
        } catch (Exception e) {
            AppMethodBeat.m2505o(15923);
            return i;
        }
    }
}
