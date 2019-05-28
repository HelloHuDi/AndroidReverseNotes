package com.tencent.p177mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p203bg.C32336d;
import com.tencent.p177mm.plugin.talkroom.C39945a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.talkroom.model.c */
public final class C36823c implements C32336d {
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    public String nMN = "";
    public boolean nNp = false;
    private Notification oHJ;
    public boolean sxP = false;
    private String sxQ;

    /* renamed from: com.tencent.mm.plugin.talkroom.model.c$1 */
    class C368241 implements Runnable {
        C368241() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25765);
            C39952b.cEg();
            C4990ab.m7418v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
            C39952b.cEg();
            C36823c.cEo();
            AppMethodBeat.m2505o(25765);
        }
    }

    private static boolean cEl() {
        AppMethodBeat.m2504i(25766);
        if (C5046bo.isNullOrNil(C39952b.cEh().syD)) {
            C4990ab.m7420w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
            C4990ab.m7418v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
            C36823c.cEo();
            AppMethodBeat.m2505o(25766);
            return false;
        }
        AppMethodBeat.m2505o(25766);
        return true;
    }

    public final void akC() {
        this.nNp = false;
    }

    /* renamed from: l */
    public final void mo53061l(String str, int i, int i2) {
        this.nNp = false;
    }

    public final void akD() {
    }

    /* renamed from: mk */
    public final void mo53062mk(int i) {
    }

    /* renamed from: tO */
    public final void mo53063tO(String str) {
        this.nMN = str;
    }

    /* renamed from: aU */
    public final void mo53053aU(String str, String str2) {
        AppMethodBeat.m2504i(25767);
        if (this.sxP) {
            AppMethodBeat.m2505o(25767);
            return;
        }
        cEn();
        AppMethodBeat.m2505o(25767);
    }

    /* renamed from: g */
    public final void mo53060g(int i, int i2, String str) {
    }

    public final void akF() {
    }

    public final void akG() {
    }

    public final void akH() {
    }

    public final void cEm() {
        AppMethodBeat.m2504i(25769);
        this.mHandler.post(new C368241());
        AppMethodBeat.m2505o(25769);
    }

    public C36823c() {
        AppMethodBeat.m2504i(25770);
        AppMethodBeat.m2505o(25770);
    }

    public final void abt(String str) {
        AppMethodBeat.m2504i(25771);
        if (C36823c.cEl()) {
            C4990ab.m7418v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(str)));
            this.sxQ = str;
            this.oHJ = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(str).mo626j(0).build();
            this.oHJ.icon = C25738R.drawable.apq;
            this.oHJ.flags = 32;
            cEn();
            AppMethodBeat.m2505o(25771);
            return;
        }
        AppMethodBeat.m2505o(25771);
    }

    private void cEn() {
        AppMethodBeat.m2504i(25772);
        if (!C36823c.cEl()) {
            AppMethodBeat.m2505o(25772);
        } else if (this.oHJ == null) {
            C4990ab.m7412e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
            AppMethodBeat.m2505o(25772);
        } else {
            CharSequence string;
            String aU = C43685h.m78271aU(C4996ah.getContext(), C39952b.cEh().syD);
            if (C39952b.cEh().syR) {
                string = C4996ah.getContext().getString(C25738R.string.eup);
            } else {
                string = C4996ah.getContext().getString(C25738R.string.eum, new Object[]{Integer.valueOf(C39952b.cEh().bJF().size())});
            }
            Intent BW = C39945a.gkF.mo38847BW();
            BW.putExtra("enter_chat_usrname", C39952b.cEh().syD);
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 100, BW, 268435456);
            C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(this.sxQ).mo626j(0).mo621d(aU).mo623e(string);
            e.f362EI = activity;
            this.oHJ = e.build();
            this.oHJ.icon = C25738R.drawable.apq;
            this.oHJ.flags = 32;
            C9638aw.getNotification().mo41574a(100, this.oHJ, false);
            AppMethodBeat.m2505o(25772);
        }
    }

    public static void cEo() {
        AppMethodBeat.m2504i(25773);
        C4990ab.m7418v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
        C9638aw.getNotification().cancel(100);
        AppMethodBeat.m2505o(25773);
    }

    public final void akE() {
        AppMethodBeat.m2504i(25768);
        C4990ab.m7418v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        C36823c.cEo();
        AppMethodBeat.m2505o(25768);
    }
}
