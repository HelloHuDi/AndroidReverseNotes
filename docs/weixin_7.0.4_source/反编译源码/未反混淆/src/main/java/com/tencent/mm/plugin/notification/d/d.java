package com.tencent.mm.plugin.notification.d;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;

public final class d extends a<bi> {
    private c oVX = new c<qc>() {
        {
            AppMethodBeat.i(23130);
            this.xxI = qc.class.getName().hashCode();
            AppMethodBeat.o(23130);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23131);
            final qc qcVar = (qc) bVar;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23129);
                    bi biVar = qcVar.cMs.csG;
                    if (d.TU(biVar.field_talker)) {
                        d.this.ch(biVar);
                    }
                    AppMethodBeat.o(23129);
                }
            });
            AppMethodBeat.o(23131);
            return false;
        }
    };
    private c oVY = new c<qe>() {
        {
            AppMethodBeat.i(23133);
            this.xxI = qe.class.getName().hashCode();
            AppMethodBeat.o(23133);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23134);
            final qe qeVar = (qe) bVar;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23132);
                    bi biVar = qeVar.cMu.csG;
                    if (d.TU(biVar.field_talker)) {
                        d.this.ci(biVar);
                    }
                    AppMethodBeat.o(23132);
                }
            });
            AppMethodBeat.o(23134);
            return false;
        }
    };

    public d() {
        AppMethodBeat.i(23136);
        AppMethodBeat.o(23136);
    }

    public final /* bridge */ /* synthetic */ long cj(Object obj) {
        return ((bi) obj).field_msgId;
    }

    public final /* synthetic */ ArrayList ck(Object obj) {
        AppMethodBeat.i(23149);
        ArrayList ae = f.ae((bi) obj);
        AppMethodBeat.o(23149);
        return ae;
    }

    public final void bWK() {
        AppMethodBeat.i(23137);
        com.tencent.mm.sdk.b.a.xxA.c(this.oVX);
        AppMethodBeat.o(23137);
    }

    public final void bWL() {
        AppMethodBeat.i(23138);
        com.tencent.mm.sdk.b.a.xxA.c(this.oVY);
        AppMethodBeat.o(23138);
    }

    public final void jq(final long j) {
        AppMethodBeat.i(23139);
        aw.ZK();
        final bi jf = com.tencent.mm.model.c.XO().jf(j);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23135);
                ab.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", Long.valueOf(j));
                ov ovVar = new ov();
                ovVar.cLh.csG = jf;
                com.tencent.mm.sdk.b.a.xxA.m(ovVar);
                AppMethodBeat.o(23135);
            }
        });
        AppMethodBeat.o(23139);
    }

    public final void bWM() {
        AppMethodBeat.i(23140);
        com.tencent.mm.sdk.b.a.xxA.d(this.oVX);
        AppMethodBeat.o(23140);
    }

    public final void bWN() {
        AppMethodBeat.i(23141);
        com.tencent.mm.sdk.b.a.xxA.d(this.oVY);
        AppMethodBeat.o(23141);
    }

    public final void bWF() {
        AppMethodBeat.i(23142);
        ab.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", Integer.valueOf(this.oVG.oVR.size()));
        if (!g.RN().QY()) {
            ab.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
            AppMethodBeat.o(23142);
        } else if (this.oVG.oVR.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            if (VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            ab.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            com.tencent.mm.bp.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
            AppMethodBeat.o(23142);
        } else {
            if (this.oVG.oVR.size() == 1) {
                long j = this.oVG.get(0);
                aw.ZK();
                String str = com.tencent.mm.model.c.XO().jf(j).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(536870912);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                com.tencent.mm.bp.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
            }
            AppMethodBeat.o(23142);
        }
    }

    public final int getType() {
        return 1;
    }

    public final void N(ArrayList<Long> arrayList) {
        AppMethodBeat.i(23143);
        aw.ZK();
        com.tencent.mm.model.c.XO().K(arrayList);
        AppMethodBeat.o(23143);
    }

    public final String Aq(int i) {
        AppMethodBeat.i(23144);
        String string = getContext().getString(R.string.d8h, new Object[]{Integer.valueOf(i)});
        AppMethodBeat.o(23144);
        return string;
    }

    public final String eL(int i, int i2) {
        AppMethodBeat.i(23145);
        String string = getContext().getString(R.string.d9y, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        AppMethodBeat.o(23145);
        return string;
    }

    public final String af(int i, int i2, int i3) {
        AppMethodBeat.i(23146);
        String string = getContext().getString(R.string.d9z, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
        AppMethodBeat.o(23146);
        return string;
    }

    public final String eM(int i, int i2) {
        AppMethodBeat.i(23147);
        String string;
        if (i2 <= 0) {
            string = getContext().getString(R.string.d9w, new Object[]{Integer.valueOf(i)});
            AppMethodBeat.o(23147);
            return string;
        }
        string = getContext().getString(R.string.d9v, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.o(23147);
        return string;
    }

    public final boolean jr(long j) {
        AppMethodBeat.i(23148);
        aw.ZK();
        ab.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", Long.valueOf(j), Long.valueOf(com.tencent.mm.model.c.XO().jf(j).field_msgId));
        if (com.tencent.mm.model.c.XO().jf(j).field_msgId != 0) {
            AppMethodBeat.o(23148);
            return true;
        }
        AppMethodBeat.o(23148);
        return false;
    }

    static /* synthetic */ boolean TU(String str) {
        AppMethodBeat.i(23150);
        if ((ad.aou(str) || ad.aow(str)) && !ad.mR(str)) {
            AppMethodBeat.o(23150);
            return false;
        }
        AppMethodBeat.o(23150);
        return true;
    }
}
