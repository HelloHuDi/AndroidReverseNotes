package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.List;

public final class e extends a<c> {
    private c oWe = new c<rr>() {
        {
            AppMethodBeat.i(23152);
            this.xxI = rr.class.getName().hashCode();
            AppMethodBeat.o(23152);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23153);
            final rr rrVar = (rr) bVar;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23151);
                    rr rrVar = rrVar;
                    c cVar = new c();
                    cVar.id = rrVar.cNG.cNB;
                    e.this.ci(cVar);
                    AppMethodBeat.o(23151);
                }
            });
            AppMethodBeat.o(23153);
            return false;
        }
    };
    private c oWf = new c<rp>() {
        {
            AppMethodBeat.i(23155);
            this.xxI = rp.class.getName().hashCode();
            AppMethodBeat.o(23155);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23156);
            final rp rpVar = (rp) bVar;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23154);
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(589825, Boolean.TRUE);
                    rp rpVar = rpVar;
                    c cVar = new c();
                    cVar.id = rpVar.cNA.cNB;
                    e.this.ch(cVar);
                    AppMethodBeat.o(23154);
                }
            });
            AppMethodBeat.o(23156);
            return false;
        }
    };

    public e() {
        AppMethodBeat.i(23158);
        AppMethodBeat.o(23158);
    }

    public final /* bridge */ /* synthetic */ long cj(Object obj) {
        return ((c) obj).id;
    }

    public final void bWF() {
        AppMethodBeat.i(23159);
        List runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName != null) {
                ab.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", componentName.getClassName());
                if (componentName.getClassName().contains("SnsTimeLineUI")) {
                    ab.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                    AppMethodBeat.o(23159);
                    return;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("sns_resume_state", false);
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        intent.putExtra("preferred_tab", 2);
        if (VERSION.SDK_INT < 16) {
            intent.putExtra("is_need_resend_sns", true);
        }
        intent.putExtra("From_fail_notify", true);
        intent.putExtra("jump_sns_from_notify", true);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.o(23159);
    }

    public final int getType() {
        return 2;
    }

    public final void N(ArrayList<Long> arrayList) {
        AppMethodBeat.i(23160);
        lj ljVar = new lj();
        ljVar.cHj.cCa = arrayList;
        com.tencent.mm.sdk.b.a.xxA.m(ljVar);
        AppMethodBeat.o(23160);
    }

    public final void bWK() {
        AppMethodBeat.i(23161);
        com.tencent.mm.sdk.b.a.xxA.c(this.oWf);
        AppMethodBeat.o(23161);
    }

    public final void bWL() {
        AppMethodBeat.i(23162);
        com.tencent.mm.sdk.b.a.xxA.c(this.oWe);
        AppMethodBeat.o(23162);
    }

    public final void jq(final long j) {
        AppMethodBeat.i(23163);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23157);
                ab.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", Long.valueOf(j));
                ox oxVar = new ox();
                oxVar.cLl.cLm = (int) j;
                com.tencent.mm.sdk.b.a.xxA.m(oxVar);
                AppMethodBeat.o(23157);
            }
        });
        AppMethodBeat.o(23163);
    }

    public final void bWM() {
        AppMethodBeat.i(23164);
        com.tencent.mm.sdk.b.a.xxA.d(this.oWf);
        AppMethodBeat.o(23164);
    }

    public final void bWN() {
        AppMethodBeat.i(23165);
        com.tencent.mm.sdk.b.a.xxA.d(this.oWe);
        AppMethodBeat.o(23165);
    }

    public final String Aq(int i) {
        AppMethodBeat.i(23166);
        String string = getContext().getString(R.string.d8i, new Object[]{Integer.valueOf(i)});
        AppMethodBeat.o(23166);
        return string;
    }

    public final String eL(int i, int i2) {
        AppMethodBeat.i(23167);
        String string = getContext().getString(R.string.d_0, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        AppMethodBeat.o(23167);
        return string;
    }

    public final String af(int i, int i2, int i3) {
        AppMethodBeat.i(23168);
        String string = getContext().getString(R.string.d_1, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
        AppMethodBeat.o(23168);
        return string;
    }

    public final String eM(int i, int i2) {
        AppMethodBeat.i(23169);
        String string;
        if (i2 <= 0) {
            string = getContext().getString(R.string.d9x, new Object[]{Integer.valueOf(i)});
            AppMethodBeat.o(23169);
            return string;
        }
        string = getContext().getString(R.string.d8j, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.o(23169);
        return string;
    }

    public final void bWt() {
        AppMethodBeat.i(23171);
        if (aw.RK()) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(589825, Boolean.FALSE);
        }
        AppMethodBeat.o(23171);
    }

    public final boolean jr(long j) {
        AppMethodBeat.i(23170);
        ab.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", Long.valueOf(j), Boolean.valueOf(n.qFD.CJ((int) j)));
        AppMethodBeat.o(23170);
        return n.qFD.CJ((int) j);
    }

    public final /* synthetic */ ArrayList ck(Object obj) {
        AppMethodBeat.i(23172);
        ArrayList cmn = n.qFD.cmn();
        if (cmn.size() == 0) {
            ab.e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        AppMethodBeat.o(23172);
        return cmn;
    }
}
