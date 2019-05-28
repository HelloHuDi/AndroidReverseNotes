package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.m.a;
import com.tencent.mm.splash.o;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.n;
import com.tencent.mm.vending.h.d;
import java.io.File;

public class WeChatSplashStartup implements a {
    private Application app;
    h profile;
    private String thisProcess;

    public final void b(Application application, String str) {
        AppMethodBeat.i(137971);
        this.app = application;
        this.thisProcess = str;
        this.profile = w.cfw;
        g.a(this.profile);
        h hVar = this.profile;
        hVar.eMA.a(new com.tencent.mm.kernel.b.h.AnonymousClass6(this.app));
        AppMethodBeat.o(137971);
    }

    public final void a(o.a aVar) {
        AppMethodBeat.i(137972);
        b(aVar);
        AppMethodBeat.o(137972);
    }

    public final void BQ() {
        AppMethodBeat.i(137973);
        b(null);
        AppMethodBeat.o(137973);
    }

    private void b(final o.a aVar) {
        AppMethodBeat.i(137974);
        com.tencent.mm.f.a.bb(this.app);
        com.tencent.mm.blink.a.ig(2);
        final boolean z = aVar == null;
        this.profile.onCreate();
        this.profile.eJE.a(new g());
        if (!z) {
            com.tencent.mm.splash.h.dqZ();
            new c<ml>() {
                {
                    AppMethodBeat.i(137944);
                    this.xxI = ml.class.getName().hashCode();
                    AppMethodBeat.o(137944);
                }

                public final /* synthetic */ boolean a(b bVar) {
                    AppMethodBeat.i(137945);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(138003);
                            ab.i("MicroMsg.WeChatSplashStartup", "Replay pending messages, so early.");
                            o.Bx();
                            AppMethodBeat.o(138003);
                        }
                    });
                    dead();
                    AppMethodBeat.o(137945);
                    return false;
                }
            }.dnU();
            new c<mm>() {
                public final /* synthetic */ boolean a(b bVar) {
                    AppMethodBeat.i(138012);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(138009);
                            ab.i("MicroMsg.WeChatSplashStartup", "Replay pending messages.");
                            aVar.drj();
                            AppMethodBeat.o(138009);
                        }
                    });
                    dead();
                    AppMethodBeat.o(138012);
                    return false;
                }
            }.dnU();
        }
        g.RQ().a(bh(z));
        com.tencent.mm.splash.h.a(new e() {
            n cfB = new n();

            {
                AppMethodBeat.i(137948);
                AppMethodBeat.o(137948);
            }

            public final boolean n(Intent intent) {
                AppMethodBeat.i(137949);
                if (intent == null || w.a(intent, "absolutely_exit_pid", 0) != Process.myPid()) {
                    AppMethodBeat.o(137949);
                    return false;
                }
                ab.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
                MMAppMgr.pQ(w.a(intent, "kill_service", true));
                AppMethodBeat.o(137949);
                return true;
            }

            public final boolean a(Activity activity, final Runnable runnable) {
                AppMethodBeat.i(137950);
                g.RN();
                boolean z = !com.tencent.mm.kernel.a.QX() && av.fly.T("login_user_name", "").equals("");
                if (!z) {
                    AppMethodBeat.o(137950);
                    return false;
                } else if (com.tencent.mm.sdk.platformtools.g.xyf) {
                    boolean a = MMAppMgr.a(activity, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(137986);
                            runnable.run();
                            AppMethodBeat.o(137986);
                        }
                    });
                    AppMethodBeat.o(137950);
                    return a;
                } else {
                    AppMethodBeat.o(137950);
                    return false;
                }
            }

            public final boolean b(Activity activity, Runnable runnable) {
                AppMethodBeat.i(137951);
                boolean c = this.cfB.c(activity, runnable);
                AppMethodBeat.o(137951);
                return c;
            }

            public final boolean a(Activity activity, int i, String[] strArr, int[] iArr) {
                AppMethodBeat.i(137952);
                boolean a = this.cfB.a(activity, i, strArr, iArr);
                AppMethodBeat.o(137952);
                return a;
            }
        });
        com.tencent.mm.splash.h.a(o.ceX);
        g.RQ().a(new com.tencent.mm.kernel.api.g() {
            public final void BR() {
                AppMethodBeat.i(137943);
                g.RQ().b(this);
                if (z) {
                    com.tencent.mm.splash.h.g("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
                    String dqR = com.tencent.mm.splash.a.dqR();
                    if (new File(dqR).exists()) {
                        File file = new File(dqR + "/main-process-blocking");
                        if (file.exists()) {
                            boolean delete = file.delete();
                            com.tencent.mm.splash.h.g("MicroMsg.FigLeaf", "deleteRequest result %s.", Boolean.valueOf(delete));
                        }
                        AppMethodBeat.o(137943);
                        return;
                    }
                    com.tencent.mm.splash.h.g("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
                    AppMethodBeat.o(137943);
                    return;
                }
                aVar.done();
                AppMethodBeat.o(137943);
            }

            public final void bi(boolean z) {
            }
        });
        g.RQ().a(new com.tencent.mm.kernel.api.g() {
            public final void BR() {
                AppMethodBeat.i(137957);
                g.RQ().b(this);
                com.tencent.mm.blink.a.BO();
                WeChatSplashStartup.a(WeChatSplashStartup.this);
                if (WeChatSplashStartup.this.profile.SG()) {
                    try {
                        ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.WeChatSplashStartup", e, "%s", e.getMessage());
                    }
                }
                if (WeChatSplashStartup.this.profile.SG()) {
                    com.tencent.mm.kernel.a RN = g.RN();
                    ab.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", Boolean.valueOf(RN.QY()), Integer.valueOf(RN.eIS), bo.dpG());
                    if (RN.QY() && RN.eIS != 0) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, RN.eIS);
                        ab.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", Integer.valueOf(RN.eIS), bo.dpG());
                        RN.eIS = 0;
                    }
                }
                AppMethodBeat.o(137957);
            }

            public final void bi(boolean z) {
            }
        });
        g.RQ().a(new com.tencent.mm.kernel.api.g() {
            public final void bi(boolean z) {
            }

            public final void BR() {
                AppMethodBeat.i(137953);
                v.a.cfp.BB();
                AppMethodBeat.o(137953);
            }
        });
        AppMethodBeat.o(137974);
    }

    private d bh(boolean z) {
        AppMethodBeat.i(137975);
        if (z) {
            AppMethodBeat.o(137975);
            return null;
        }
        final j Bm = j.Bm();
        Bm.Bn();
        g.RQ().a(new com.tencent.mm.kernel.api.g() {
            public final void BR() {
                AppMethodBeat.i(137993);
                Bm.cet.quit();
                g.RQ().b(this);
                AppMethodBeat.o(137993);
            }

            public final void bi(boolean z) {
            }
        });
        com.tencent.mm.kernel.a.c.Sa().d(Bm.cet.getLooper());
        d dVar = Bm.ceu;
        AppMethodBeat.o(137975);
        return dVar;
    }
}
