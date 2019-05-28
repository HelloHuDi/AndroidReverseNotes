package com.tencent.p177mm.plugin.p436hp.p437b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1271v.C1270a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26087az;
import com.tencent.p177mm.p230g.p231a.C32523bi;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.p436hp.p1552c.C46030b;
import com.tencent.p177mm.plugin.p436hp.tinker.C21075g;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C44553d;
import com.tinkerboots.sdk.C44598a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.hp.b.d */
public class C34360d implements C1816at {
    private final C4884c<C26087az> kXG = new C343621();
    private boolean ntC = true;
    private final C6948h ntD = new C6948h();
    private final C4884c<C6471cq> ntE = new C343612();
    private final C6947f ntF = new C6947f();
    private final C4884c<C32523bi> ntG = new C283163();

    /* renamed from: com.tencent.mm.plugin.hp.b.d$3 */
    class C283163 extends C4884c<C32523bi> {
        C283163() {
            AppMethodBeat.m2504i(90588);
            this.xxI = C32523bi.class.getName().hashCode();
            AppMethodBeat.m2505o(90588);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(90589);
            C1720g.m3540Rg().mo14541a(new C46030b(), 0);
            AppMethodBeat.m2505o(90589);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.hp.b.d$2 */
    class C343612 extends C4884c<C6471cq> {
        C343612() {
            AppMethodBeat.m2504i(90586);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(90586);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(90587);
            C21075g.m32384el(C4996ah.getContext());
            C44598a.dWj().mo71470SG(C21075g.m32385em(C4996ah.getContext()));
            AppMethodBeat.m2505o(90587);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.hp.b.d$1 */
    class C343621 extends C4884c<C26087az> {
        C343621() {
            AppMethodBeat.m2504i(90584);
            this.xxI = C26087az.class.getName().hashCode();
            AppMethodBeat.m2505o(90584);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(90585);
            C26087az c26087az = (C26087az) c4883b;
            if (C34360d.this.ntC) {
                int i;
                Context context = C4996ah.getContext();
                String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_after_install", "");
                C44553d c44553d = C31097a.m50180iX(context).ABJ;
                String str = c44553d == null ? "" : c44553d.ABO;
                C4990ab.m7417i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isAfterInstallDialogHaveShow currentVersion :%s tinkerVersion:%s", string, str);
                if (C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(str) || !(C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(str) || !string.equalsIgnoreCase(str))) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    str = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_msg_key", "");
                    c26087az.cuh.cui = true;
                    c26087az.cuh.bzH = str;
                    if (!C5046bo.isNullOrNil(str)) {
                        C39251a.m66896wV(2);
                    }
                    context = C4996ah.getContext();
                    String string2 = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_version_key", "");
                    if (!TextUtils.isEmpty(string2)) {
                        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_after_install", string2).apply();
                    }
                }
                C34360d.this.ntC = false;
            }
            AppMethodBeat.m2505o(90585);
            return false;
        }
    }

    public C34360d() {
        AppMethodBeat.m2504i(90590);
        AppMethodBeat.m2505o(90590);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(90591);
        C44042b.m79163a(new C3299g(), "//tinker");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("prconfignotify", this.ntD, true);
        C4879a.xxA.mo10052c(this.kXG);
        this.ntE.dnU();
        C4879a.xxA.mo10052c(this.ntF);
        C4879a.xxA.mo10052c(this.ntG);
        C4990ab.m7410d("Tinker.SubCoreHotpatch", "onAccountPostReset");
        C21075g.m32384el(C4996ah.getContext());
        try {
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue >= 3600000) {
                C4990ab.m7417i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", Integer.valueOf(Calendar.getInstance().get(11)));
                if (Calendar.getInstance().get(11) == 0) {
                    currentTimeMillis = (currentTimeMillis - (((long) C21075g.m32385em(C4996ah.getContext())) * 3600000)) + (((long) new Random().nextInt(60)) * 60000);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                    C4990ab.m7417i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", Integer.valueOf(r4), Long.valueOf(currentTimeMillis), Long.valueOf(longValue));
                } else {
                    C44598a.dWj().mo71472rF(true);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                    C4990ab.m7417i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(longValue));
                }
            } else {
                C44598a.dWj().mo71472rF(false);
                C4990ab.m7416i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
            }
            C6947f.m11472iT(currentTimeMillis);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Tinker.SubCoreHotpatch", e, "", new Object[0]);
        }
        C1270a.cfp.mo4562BG();
        AppMethodBeat.m2505o(90591);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(90592);
        C44042b.m79162N("//tinker");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("prconfignotify", this.ntD, true);
        C4879a.xxA.mo10053d(this.kXG);
        this.ntE.dead();
        C4879a.xxA.mo10053d(this.ntF);
        C4879a.xxA.mo10053d(this.ntG);
        C4990ab.m7410d("Tinker.SubCoreHotpatch", "onAccountRelease");
        AppMethodBeat.m2505o(90592);
    }
}
