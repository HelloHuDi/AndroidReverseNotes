package com.tencent.p177mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1271v.C1270a;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C6624h.C66236;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.p230g.p231a.C6521ml;
import com.tencent.p177mm.p230g.p231a.C6522mm;
import com.tencent.p177mm.p612ui.C44376n;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.splash.C5102a;
import com.tencent.p177mm.splash.C5106e;
import com.tencent.p177mm.splash.C5115h;
import com.tencent.p177mm.splash.C5122m.C5121a;
import com.tencent.p177mm.splash.C5126o.C5125a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p642h.C5703d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.app.WeChatSplashStartup */
public class WeChatSplashStartup implements C5121a {
    private Application app;
    C6624h profile;
    private String thisProcess;

    /* renamed from: com.tencent.mm.app.WeChatSplashStartup$5 */
    class C63125 implements C1675g {
        C63125() {
        }

        /* renamed from: BR */
        public final void mo5176BR() {
            AppMethodBeat.m2504i(137957);
            C1720g.m3537RQ().mo5255b(this);
            C1311a.m2791BO();
            WeChatSplashStartup.m63199a(WeChatSplashStartup.this);
            if (WeChatSplashStartup.this.profile.mo5181SG()) {
                try {
                    C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WeChatSplashStartup", e, "%s", e.getMessage());
                }
            }
            if (WeChatSplashStartup.this.profile.mo5181SG()) {
                C1668a RN = C1720g.m3534RN();
                C4990ab.m7417i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", Boolean.valueOf(RN.mo5161QY()), Integer.valueOf(RN.eIS), C5046bo.dpG());
                if (RN.mo5161QY() && RN.eIS != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, RN.eIS);
                    C4990ab.m7417i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", Integer.valueOf(RN.eIS), C5046bo.dpG());
                    RN.eIS = 0;
                }
            }
            AppMethodBeat.m2505o(137957);
        }

        /* renamed from: bi */
        public final void mo5177bi(boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.app.WeChatSplashStartup$8 */
    class C63148 implements C5681a<Void, Void> {
        C63148() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(137992);
            Iterator it = C5115h.drh().eaV.iterator();
            while (it.hasNext()) {
                long[] jArr = (long[]) it.next();
                C4990ab.m7417i("MicroMsg.WeChatSplashStartup", "splash %s, %s, %s", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2]));
                C7060h.pYm.mo8378a(jArr[0], jArr[1], jArr[2], false);
            }
            ArrayList arrayList = C5115h.drh().xHG;
            HashMap hashMap = new HashMap();
            String str = "NewSplash";
            hashMap.put("processName", WeChatSplashStartup.this.thisProcess);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C4990ab.m7417i("MicroMsg.WeChatSplashStartup", "splash message %s", (String) it2.next());
                C7060h.pYm.mo8382g(str, r0, hashMap);
            }
            C4990ab.m7417i("MicroMsg.WeChatSplashStartup", "report splash info %s %s", Integer.valueOf(r9.size()), Integer.valueOf(arrayList.size()));
            Void voidR = zXH;
            AppMethodBeat.m2505o(137992);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.app.WeChatSplashStartup$1 */
    class C322521 extends C4884c<C6521ml> {

        /* renamed from: com.tencent.mm.app.WeChatSplashStartup$1$1 */
        class C322511 implements Runnable {
            C322511() {
            }

            public final void run() {
                AppMethodBeat.m2504i(138003);
                C4990ab.m7416i("MicroMsg.WeChatSplashStartup", "Replay pending messages, so early.");
                C25800o.m41028Bx();
                AppMethodBeat.m2505o(138003);
            }
        }

        C322521() {
            AppMethodBeat.m2504i(137944);
            this.xxI = C6521ml.class.getName().hashCode();
            AppMethodBeat.m2505o(137944);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(137945);
            new Handler(Looper.getMainLooper()).post(new C322511());
            dead();
            AppMethodBeat.m2505o(137945);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.WeChatSplashStartup$3 */
    class C322543 implements C5106e {
        C44376n cfB = new C44376n();

        C322543() {
            AppMethodBeat.m2504i(137948);
            AppMethodBeat.m2505o(137948);
        }

        /* renamed from: n */
        public final boolean mo10482n(Intent intent) {
            AppMethodBeat.m2504i(137949);
            if (intent == null || C5068w.m7682a(intent, "absolutely_exit_pid", 0) != Process.myPid()) {
                AppMethodBeat.m2505o(137949);
                return false;
            }
            C4990ab.m7416i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
            MMAppMgr.m7914pQ(C5068w.m7683a(intent, "kill_service", true));
            AppMethodBeat.m2505o(137949);
            return true;
        }

        /* renamed from: a */
        public final boolean mo10480a(Activity activity, final Runnable runnable) {
            AppMethodBeat.m2504i(137950);
            C1720g.m3534RN();
            boolean z = !C1668a.m3395QX() && C6665av.fly.mo5292T("login_user_name", "").equals("");
            if (!z) {
                AppMethodBeat.m2505o(137950);
                return false;
            } else if (C5059g.xyf) {
                boolean a = MMAppMgr.m7896a(activity, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(137986);
                        runnable.run();
                        AppMethodBeat.m2505o(137986);
                    }
                });
                AppMethodBeat.m2505o(137950);
                return a;
            } else {
                AppMethodBeat.m2505o(137950);
                return false;
            }
        }

        /* renamed from: b */
        public final boolean mo10481b(Activity activity, Runnable runnable) {
            AppMethodBeat.m2504i(137951);
            boolean c = this.cfB.mo70241c(activity, runnable);
            AppMethodBeat.m2505o(137951);
            return c;
        }

        /* renamed from: a */
        public final boolean mo10479a(Activity activity, int i, String[] strArr, int[] iArr) {
            AppMethodBeat.m2504i(137952);
            boolean a = this.cfB.mo70239a(activity, i, strArr, iArr);
            AppMethodBeat.m2505o(137952);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.app.WeChatSplashStartup$6 */
    class C322556 implements C1675g {
        C322556() {
        }

        /* renamed from: bi */
        public final void mo5177bi(boolean z) {
        }

        /* renamed from: BR */
        public final void mo5176BR() {
            AppMethodBeat.m2504i(137953);
            C1270a.cfp.mo4560BB();
            AppMethodBeat.m2505o(137953);
        }
    }

    /* renamed from: b */
    public final void mo10501b(Application application, String str) {
        AppMethodBeat.m2504i(137971);
        this.app = application;
        this.thisProcess = str;
        this.profile = C1273w.cfw;
        C1720g.m3541a(this.profile);
        C6624h c6624h = this.profile;
        c6624h.eMA.mo14669a(new C66236(this.app));
        AppMethodBeat.m2505o(137971);
    }

    /* renamed from: a */
    public final void mo10500a(C5125a c5125a) {
        AppMethodBeat.m2504i(137972);
        m63201b(c5125a);
        AppMethodBeat.m2505o(137972);
    }

    /* renamed from: BQ */
    public final void mo10499BQ() {
        AppMethodBeat.m2504i(137973);
        m63201b(null);
        AppMethodBeat.m2505o(137973);
    }

    /* renamed from: b */
    private void m63201b(final C5125a c5125a) {
        AppMethodBeat.m2504i(137974);
        C1523a.m3163bb(this.app);
        C1311a.m2806ig(2);
        final boolean z = c5125a == null;
        this.profile.onCreate();
        this.profile.eJE.mo5127a(new C9001g());
        if (!z) {
            C5115h.dqZ();
            new C322521().dnU();
            new C4884c<C6522mm>() {

                /* renamed from: com.tencent.mm.app.WeChatSplashStartup$2$1 */
                class C322531 implements Runnable {
                    C322531() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(138009);
                        C4990ab.m7416i("MicroMsg.WeChatSplashStartup", "Replay pending messages.");
                        c5125a.drj();
                        AppMethodBeat.m2505o(138009);
                    }
                }

                /* renamed from: a */
                public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                    AppMethodBeat.m2504i(138012);
                    new Handler(Looper.getMainLooper()).post(new C322531());
                    dead();
                    AppMethodBeat.m2505o(138012);
                    return false;
                }
            }.dnU();
        }
        C1720g.m3537RQ().mo5254a(m63202bh(z));
        C5115h.m7769a(new C322543());
        C5115h.m7768a(C25800o.ceX);
        C1720g.m3537RQ().mo5252a(new C1675g() {
            /* renamed from: BR */
            public final void mo5176BR() {
                AppMethodBeat.m2504i(137943);
                C1720g.m3537RQ().mo5255b(this);
                if (z) {
                    C5115h.m7780g("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
                    String dqR = C5102a.dqR();
                    if (new File(dqR).exists()) {
                        File file = new File(dqR + "/main-process-blocking");
                        if (file.exists()) {
                            boolean delete = file.delete();
                            C5115h.m7780g("MicroMsg.FigLeaf", "deleteRequest result %s.", Boolean.valueOf(delete));
                        }
                        AppMethodBeat.m2505o(137943);
                        return;
                    }
                    C5115h.m7780g("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
                    AppMethodBeat.m2505o(137943);
                    return;
                }
                c5125a.done();
                AppMethodBeat.m2505o(137943);
            }

            /* renamed from: bi */
            public final void mo5177bi(boolean z) {
            }
        });
        C1720g.m3537RQ().mo5252a(new C63125());
        C1720g.m3537RQ().mo5252a(new C322556());
        AppMethodBeat.m2505o(137974);
    }

    /* renamed from: bh */
    private C5703d m63202bh(boolean z) {
        AppMethodBeat.m2504i(137975);
        if (z) {
            AppMethodBeat.m2505o(137975);
            return null;
        }
        final C45155j Bm = C45155j.m83048Bm();
        Bm.mo73066Bn();
        C1720g.m3537RQ().mo5252a(new C1675g() {
            /* renamed from: BR */
            public final void mo5176BR() {
                AppMethodBeat.m2504i(137993);
                Bm.cet.quit();
                C1720g.m3537RQ().mo5255b(this);
                AppMethodBeat.m2505o(137993);
            }

            /* renamed from: bi */
            public final void mo5177bi(boolean z) {
            }
        });
        C6610c.m10890Sa().mo14826d(Bm.cet.getLooper());
        C5703d c5703d = Bm.ceu;
        AppMethodBeat.m2505o(137975);
        return c5703d;
    }
}
