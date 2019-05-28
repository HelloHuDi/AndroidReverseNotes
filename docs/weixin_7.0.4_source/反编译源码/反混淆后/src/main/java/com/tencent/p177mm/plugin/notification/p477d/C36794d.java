package com.tencent.p177mm.plugin.notification.p477d;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C26212ov;
import com.tencent.p177mm.p230g.p231a.C6541qc;
import com.tencent.p177mm.p230g.p231a.C6542qe;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.notification.p476c.C34627a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.notification.d.d */
public final class C36794d extends C34627a<C7620bi> {
    private C4884c oVX = new C69991();
    private C4884c oVY = new C70002();

    /* renamed from: com.tencent.mm.plugin.notification.d.d$1 */
    class C69991 extends C4884c<C6541qc> {
        C69991() {
            AppMethodBeat.m2504i(23130);
            this.xxI = C6541qc.class.getName().hashCode();
            AppMethodBeat.m2505o(23130);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23131);
            final C6541qc c6541qc = (C6541qc) c4883b;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(23129);
                    C7620bi c7620bi = c6541qc.cMs.csG;
                    if (C36794d.m61100TU(c7620bi.field_talker)) {
                        C36794d.this.mo55219ch(c7620bi);
                    }
                    AppMethodBeat.m2505o(23129);
                }
            });
            AppMethodBeat.m2505o(23131);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.d.d$2 */
    class C70002 extends C4884c<C6542qe> {
        C70002() {
            AppMethodBeat.m2504i(23133);
            this.xxI = C6542qe.class.getName().hashCode();
            AppMethodBeat.m2505o(23133);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23134);
            final C6542qe c6542qe = (C6542qe) c4883b;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(23132);
                    C7620bi c7620bi = c6542qe.cMu.csG;
                    if (C36794d.m61100TU(c7620bi.field_talker)) {
                        C36794d.this.mo55220ci(c7620bi);
                    }
                    AppMethodBeat.m2505o(23132);
                }
            });
            AppMethodBeat.m2505o(23134);
            return false;
        }
    }

    public C36794d() {
        AppMethodBeat.m2504i(23136);
        AppMethodBeat.m2505o(23136);
    }

    /* renamed from: cj */
    public final /* bridge */ /* synthetic */ long mo55221cj(Object obj) {
        return ((C7620bi) obj).field_msgId;
    }

    /* renamed from: ck */
    public final /* synthetic */ ArrayList mo55222ck(Object obj) {
        AppMethodBeat.m2504i(23149);
        ArrayList ae = C34636f.m56830ae((C7620bi) obj);
        AppMethodBeat.m2505o(23149);
        return ae;
    }

    public final void bWK() {
        AppMethodBeat.m2504i(23137);
        C4879a.xxA.mo10052c(this.oVX);
        AppMethodBeat.m2505o(23137);
    }

    public final void bWL() {
        AppMethodBeat.m2504i(23138);
        C4879a.xxA.mo10052c(this.oVY);
        AppMethodBeat.m2505o(23138);
    }

    /* renamed from: jq */
    public final void mo55228jq(final long j) {
        AppMethodBeat.m2504i(23139);
        C9638aw.m17190ZK();
        final C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(23135);
                C4990ab.m7411d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", Long.valueOf(j));
                C26212ov c26212ov = new C26212ov();
                c26212ov.cLh.csG = jf;
                C4879a.xxA.mo10055m(c26212ov);
                AppMethodBeat.m2505o(23135);
            }
        });
        AppMethodBeat.m2505o(23139);
    }

    public final void bWM() {
        AppMethodBeat.m2504i(23140);
        C4879a.xxA.mo10053d(this.oVX);
        AppMethodBeat.m2505o(23140);
    }

    public final void bWN() {
        AppMethodBeat.m2504i(23141);
        C4879a.xxA.mo10053d(this.oVY);
        AppMethodBeat.m2505o(23141);
    }

    public final void bWF() {
        AppMethodBeat.m2504i(23142);
        C4990ab.m7417i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", Integer.valueOf(this.oVG.oVR.size()));
        if (!C1720g.m3534RN().mo5161QY()) {
            C4990ab.m7420w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
            AppMethodBeat.m2505o(23142);
        } else if (this.oVG.oVR.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            if (VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            C4990ab.m7410d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            C25985d.m41473f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
            AppMethodBeat.m2505o(23142);
        } else {
            if (this.oVG.oVR.size() == 1) {
                long j = this.oVG.get(0);
                C9638aw.m17190ZK();
                String str = C18628c.m29080XO().mo15340jf(j).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(536870912);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                C25985d.m41473f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
            }
            AppMethodBeat.m2505o(23142);
        }
    }

    public final int getType() {
        return 1;
    }

    /* renamed from: N */
    public final void mo55214N(ArrayList<Long> arrayList) {
        AppMethodBeat.m2504i(23143);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15239K(arrayList);
        AppMethodBeat.m2505o(23143);
    }

    /* renamed from: Aq */
    public final String mo55213Aq(int i) {
        AppMethodBeat.m2504i(23144);
        String string = getContext().getString(C25738R.string.d8h, new Object[]{Integer.valueOf(i)});
        AppMethodBeat.m2505o(23144);
        return string;
    }

    /* renamed from: eL */
    public final String mo55223eL(int i, int i2) {
        AppMethodBeat.m2504i(23145);
        String string = getContext().getString(C25738R.string.d9y, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        AppMethodBeat.m2505o(23145);
        return string;
    }

    /* renamed from: af */
    public final String mo55215af(int i, int i2, int i3) {
        AppMethodBeat.m2504i(23146);
        String string = getContext().getString(C25738R.string.d9z, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
        AppMethodBeat.m2505o(23146);
        return string;
    }

    /* renamed from: eM */
    public final String mo55224eM(int i, int i2) {
        AppMethodBeat.m2504i(23147);
        String string;
        if (i2 <= 0) {
            string = getContext().getString(C25738R.string.d9w, new Object[]{Integer.valueOf(i)});
            AppMethodBeat.m2505o(23147);
            return string;
        }
        string = getContext().getString(C25738R.string.d9v, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.m2505o(23147);
        return string;
    }

    /* renamed from: jr */
    public final boolean mo55229jr(long j) {
        AppMethodBeat.m2504i(23148);
        C9638aw.m17190ZK();
        C4990ab.m7411d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", Long.valueOf(j), Long.valueOf(C18628c.m29080XO().mo15340jf(j).field_msgId));
        if (C18628c.m29080XO().mo15340jf(j).field_msgId != 0) {
            AppMethodBeat.m2505o(23148);
            return true;
        }
        AppMethodBeat.m2505o(23148);
        return false;
    }

    /* renamed from: TU */
    static /* synthetic */ boolean m61100TU(String str) {
        AppMethodBeat.m2504i(23150);
        if ((C7616ad.aou(str) || C7616ad.aow(str)) && !C7616ad.m13548mR(str)) {
            AppMethodBeat.m2505o(23150);
            return false;
        }
        AppMethodBeat.m2505o(23150);
        return true;
    }
}
