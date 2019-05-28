package com.tencent.p177mm.plugin.notification.p477d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C18357ox;
import com.tencent.p177mm.p230g.p231a.C18386rp;
import com.tencent.p177mm.p230g.p231a.C26235rr;
import com.tencent.p177mm.p230g.p231a.C42022lj;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.notification.p476c.C34627a;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.notification.d.e */
public final class C36795e extends C34627a<C12732c> {
    private C4884c oWe = new C70021();
    private C4884c oWf = new C346352();

    /* renamed from: com.tencent.mm.plugin.notification.d.e$1 */
    class C70021 extends C4884c<C26235rr> {
        C70021() {
            AppMethodBeat.m2504i(23152);
            this.xxI = C26235rr.class.getName().hashCode();
            AppMethodBeat.m2505o(23152);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23153);
            final C26235rr c26235rr = (C26235rr) c4883b;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(23151);
                    C26235rr c26235rr = c26235rr;
                    C12732c c12732c = new C12732c();
                    c12732c.f2916id = c26235rr.cNG.cNB;
                    C36795e.this.mo55220ci(c12732c);
                    AppMethodBeat.m2505o(23151);
                }
            });
            AppMethodBeat.m2505o(23153);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.d.e$2 */
    class C346352 extends C4884c<C18386rp> {
        C346352() {
            AppMethodBeat.m2504i(23155);
            this.xxI = C18386rp.class.getName().hashCode();
            AppMethodBeat.m2505o(23155);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23156);
            final C18386rp c18386rp = (C18386rp) c4883b;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(23154);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(589825, Boolean.TRUE);
                    C18386rp c18386rp = c18386rp;
                    C12732c c12732c = new C12732c();
                    c12732c.f2916id = c18386rp.cNA.cNB;
                    C36795e.this.mo55219ch(c12732c);
                    AppMethodBeat.m2505o(23154);
                }
            });
            AppMethodBeat.m2505o(23156);
            return false;
        }
    }

    public C36795e() {
        AppMethodBeat.m2504i(23158);
        AppMethodBeat.m2505o(23158);
    }

    /* renamed from: cj */
    public final /* bridge */ /* synthetic */ long mo55221cj(Object obj) {
        return ((C12732c) obj).f2916id;
    }

    public final void bWF() {
        AppMethodBeat.m2504i(23159);
        List runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName != null) {
                C4990ab.m7411d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", componentName.getClassName());
                if (componentName.getClassName().contains("SnsTimeLineUI")) {
                    C4990ab.m7410d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                    AppMethodBeat.m2505o(23159);
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
        C25985d.m41473f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.m2505o(23159);
    }

    public final int getType() {
        return 2;
    }

    /* renamed from: N */
    public final void mo55214N(ArrayList<Long> arrayList) {
        AppMethodBeat.m2504i(23160);
        C42022lj c42022lj = new C42022lj();
        c42022lj.cHj.cCa = arrayList;
        C4879a.xxA.mo10055m(c42022lj);
        AppMethodBeat.m2505o(23160);
    }

    public final void bWK() {
        AppMethodBeat.m2504i(23161);
        C4879a.xxA.mo10052c(this.oWf);
        AppMethodBeat.m2505o(23161);
    }

    public final void bWL() {
        AppMethodBeat.m2504i(23162);
        C4879a.xxA.mo10052c(this.oWe);
        AppMethodBeat.m2505o(23162);
    }

    /* renamed from: jq */
    public final void mo55228jq(final long j) {
        AppMethodBeat.m2504i(23163);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(23157);
                C4990ab.m7411d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", Long.valueOf(j));
                C18357ox c18357ox = new C18357ox();
                c18357ox.cLl.cLm = (int) j;
                C4879a.xxA.mo10055m(c18357ox);
                AppMethodBeat.m2505o(23157);
            }
        });
        AppMethodBeat.m2505o(23163);
    }

    public final void bWM() {
        AppMethodBeat.m2504i(23164);
        C4879a.xxA.mo10053d(this.oWf);
        AppMethodBeat.m2505o(23164);
    }

    public final void bWN() {
        AppMethodBeat.m2504i(23165);
        C4879a.xxA.mo10053d(this.oWe);
        AppMethodBeat.m2505o(23165);
    }

    /* renamed from: Aq */
    public final String mo55213Aq(int i) {
        AppMethodBeat.m2504i(23166);
        String string = getContext().getString(C25738R.string.d8i, new Object[]{Integer.valueOf(i)});
        AppMethodBeat.m2505o(23166);
        return string;
    }

    /* renamed from: eL */
    public final String mo55223eL(int i, int i2) {
        AppMethodBeat.m2504i(23167);
        String string = getContext().getString(C25738R.string.d_0, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        AppMethodBeat.m2505o(23167);
        return string;
    }

    /* renamed from: af */
    public final String mo55215af(int i, int i2, int i3) {
        AppMethodBeat.m2504i(23168);
        String string = getContext().getString(C25738R.string.d_1, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
        AppMethodBeat.m2505o(23168);
        return string;
    }

    /* renamed from: eM */
    public final String mo55224eM(int i, int i2) {
        AppMethodBeat.m2504i(23169);
        String string;
        if (i2 <= 0) {
            string = getContext().getString(C25738R.string.d9x, new Object[]{Integer.valueOf(i)});
            AppMethodBeat.m2505o(23169);
            return string;
        }
        string = getContext().getString(C25738R.string.d8j, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.m2505o(23169);
        return string;
    }

    public final void bWt() {
        AppMethodBeat.m2504i(23171);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(589825, Boolean.FALSE);
        }
        AppMethodBeat.m2505o(23171);
    }

    /* renamed from: jr */
    public final boolean mo55229jr(long j) {
        AppMethodBeat.m2504i(23170);
        C4990ab.m7411d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", Long.valueOf(j), Boolean.valueOf(C21877n.qFD.mo62913CJ((int) j)));
        AppMethodBeat.m2505o(23170);
        return C21877n.qFD.mo62913CJ((int) j);
    }

    /* renamed from: ck */
    public final /* synthetic */ ArrayList mo55222ck(Object obj) {
        AppMethodBeat.m2504i(23172);
        ArrayList cmn = C21877n.qFD.cmn();
        if (cmn.size() == 0) {
            C4990ab.m7412e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        AppMethodBeat.m2505o(23172);
        return cmn;
    }
}
