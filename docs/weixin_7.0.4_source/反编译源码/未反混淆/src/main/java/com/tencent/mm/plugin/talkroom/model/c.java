package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.bo.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class c implements d {
    private ak mHandler = new ak(Looper.getMainLooper());
    public String nMN = "";
    public boolean nNp = false;
    private Notification oHJ;
    public boolean sxP = false;
    private String sxQ;

    private static boolean cEl() {
        AppMethodBeat.i(25766);
        if (bo.isNullOrNil(b.cEh().syD)) {
            ab.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
            ab.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
            cEo();
            AppMethodBeat.o(25766);
            return false;
        }
        AppMethodBeat.o(25766);
        return true;
    }

    public final void akC() {
        this.nNp = false;
    }

    public final void l(String str, int i, int i2) {
        this.nNp = false;
    }

    public final void akD() {
    }

    public final void mk(int i) {
    }

    public final void tO(String str) {
        this.nMN = str;
    }

    public final void aU(String str, String str2) {
        AppMethodBeat.i(25767);
        if (this.sxP) {
            AppMethodBeat.o(25767);
            return;
        }
        cEn();
        AppMethodBeat.o(25767);
    }

    public final void g(int i, int i2, String str) {
    }

    public final void akF() {
    }

    public final void akG() {
    }

    public final void akH() {
    }

    public final void cEm() {
        AppMethodBeat.i(25769);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25765);
                b.cEg();
                ab.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
                b.cEg();
                c.cEo();
                AppMethodBeat.o(25765);
            }
        });
        AppMethodBeat.o(25769);
    }

    public c() {
        AppMethodBeat.i(25770);
        AppMethodBeat.o(25770);
    }

    public final void abt(String str) {
        AppMethodBeat.i(25771);
        if (cEl()) {
            ab.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(str)));
            this.sxQ = str;
            this.oHJ = a.bt(ah.getContext(), "reminder_channel_id").g(str).j(0).build();
            this.oHJ.icon = R.drawable.apq;
            this.oHJ.flags = 32;
            cEn();
            AppMethodBeat.o(25771);
            return;
        }
        AppMethodBeat.o(25771);
    }

    private void cEn() {
        AppMethodBeat.i(25772);
        if (!cEl()) {
            AppMethodBeat.o(25772);
        } else if (this.oHJ == null) {
            ab.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
            AppMethodBeat.o(25772);
        } else {
            CharSequence string;
            String aU = h.aU(ah.getContext(), b.cEh().syD);
            if (b.cEh().syR) {
                string = ah.getContext().getString(R.string.eup);
            } else {
                string = ah.getContext().getString(R.string.eum, new Object[]{Integer.valueOf(b.cEh().bJF().size())});
            }
            Intent BW = com.tencent.mm.plugin.talkroom.a.gkF.BW();
            BW.putExtra("enter_chat_usrname", b.cEh().syD);
            PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 100, BW, 268435456);
            android.support.v4.app.v.c e = a.bt(ah.getContext(), "reminder_channel_id").g(this.sxQ).j(0).d(aU).e(string);
            e.EI = activity;
            this.oHJ = e.build();
            this.oHJ.icon = R.drawable.apq;
            this.oHJ.flags = 32;
            aw.getNotification().a(100, this.oHJ, false);
            AppMethodBeat.o(25772);
        }
    }

    public static void cEo() {
        AppMethodBeat.i(25773);
        ab.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
        aw.getNotification().cancel(100);
        AppMethodBeat.o(25773);
    }

    public final void akE() {
        AppMethodBeat.i(25768);
        ab.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        cEo();
        AppMethodBeat.o(25768);
    }
}
