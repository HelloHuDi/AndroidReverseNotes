package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.app.e;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.ci.i;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;
import com.tencent.mm.vending.h.h;
import java.io.File;

public class PluginZero extends f implements d {
    private static final int[] yae = new int[]{6, 6, 0, 1, 2, 3, 4, 5};
    private a yab = new a();
    private b yac = new b();
    private final e yad = new e();
    public com.tencent.mm.plugin.zero.a.b yaf;
    public b yag = new b();
    public a yah = new a();

    public static final class a extends com.tencent.mm.ci.a<com.tencent.mm.plugin.zero.a.a> implements com.tencent.mm.plugin.zero.a.a {
        public final void a(final Service service) {
            AppMethodBeat.i(58758);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.plugin.zero.a.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58756);
                    ((com.tencent.mm.plugin.zero.a.a) obj).a(service);
                    AppMethodBeat.o(58756);
                }
            });
            AppMethodBeat.o(58758);
        }

        public final void b(final Service service) {
            AppMethodBeat.i(58759);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.plugin.zero.a.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58757);
                    ((com.tencent.mm.plugin.zero.a.a) obj).b(service);
                    AppMethodBeat.o(58757);
                }
            });
            AppMethodBeat.o(58759);
        }
    }

    public static final class b extends com.tencent.mm.ci.a<c> implements c {
        public final void a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
            AppMethodBeat.i(58761);
            final NotifyService notifyService2 = notifyService;
            final int i2 = i;
            final byte[] bArr3 = bArr;
            final byte[] bArr4 = bArr2;
            final long j2 = j;
            a(new com.tencent.mm.ci.a.a<c>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58760);
                    ((c) obj).a(notifyService2, i2, bArr3, bArr4, j2);
                    AppMethodBeat.o(58760);
                }
            });
            AppMethodBeat.o(58761);
        }
    }

    public PluginZero() {
        AppMethodBeat.i(58762);
        AppMethodBeat.o(58762);
    }

    public String toString() {
        return "plugin-zero";
    }

    public void installed() {
        AppMethodBeat.i(58763);
        alias(d.class);
        AppMethodBeat.o(58763);
    }

    public void dependency() {
        AppMethodBeat.i(58764);
        dependsOnRoot();
        AppMethodBeat.o(58764);
    }

    public void configure(final g gVar) {
        AppMethodBeat.i(58765);
        try {
            initSDRoot();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.PluginZero", e, "what happened?", new Object[0]);
        }
        ah.ce(gVar.eHT);
        com.tencent.mm.kernel.a.a.k("configure [%s], setup broken library handler...", this);
        setupStubLog();
        setupVendingLog();
        if (gVar.SG()) {
            com.tencent.mm.kernel.a.a.k("configure [%s], for process[%s]...", this, gVar.eHT);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.yab));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.yac));
            com.tencent.mm.kernel.a.a.k("configure [%s], make worker core...", this);
            com.tencent.mm.kernel.g RQ = com.tencent.mm.kernel.g.RQ();
            if (!RQ.eKs) {
                RQ.eKs = true;
                RQ.eKl = new com.tencent.mm.kernel.e(com.tencent.mm.kernel.a.c.Sa());
                RQ.eKm = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.Sa());
                RQ.eKn = new com.tencent.mm.kernel.b(RQ.eKp, RQ.eJn);
                RQ.eKo = new com.tencent.mm.cc.b(ah.getContext());
            }
            NotifyReceiver.In();
            com.tencent.mm.kernel.g.RQ().a(new com.tencent.mm.kernel.api.g() {
                public final void BR() {
                    AppMethodBeat.i(58746);
                    com.tencent.mm.kernel.a.a.k("onStartupDone", new Object[0]);
                    AppMethodBeat.o(58746);
                }

                public final void bi(boolean z) {
                    AppMethodBeat.i(58747);
                    if (z) {
                        l.m(gVar.cc, true);
                        l.n(gVar.cc, true);
                    }
                    ab.dot();
                    AppMethodBeat.o(58747);
                }
            });
            com.tencent.mm.kernel.g.RQ();
            i.Aiy = new h(com.tencent.mm.ci.d.c(com.tencent.mm.kernel.g.RS().doN()), "WeChat.WORKER");
            com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.Aiy);
            new com.tencent.mm.plugin.zero.tasks.a().before(this);
        }
        if (gVar.SG() || gVar.lQ(":push")) {
            new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
        }
        if (gVar.lQ(":push")) {
            AppLogic.setCallBack(new AppCallBack(ah.getContext()));
            k.a(com.tencent.mm.kernel.b.eJm, getClass().getClassLoader());
            SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        }
        AppMethodBeat.o(58765);
    }

    private void initSDRoot() {
        AppMethodBeat.i(58766);
        if (new File(ac.eSj + "SdcardInfo.cfg").exists()) {
            String str;
            String str2 = com.tencent.mm.compatible.util.e.eSl;
            y yVar = new y(ac.eSj + "SdcardInfo.cfg");
            String str3 = (String) yVar.get(1, "");
            int intValue = ((Integer) yVar.get(2, Integer.valueOf(0))).intValue();
            int i = VERSION.SDK_INT;
            if (bo.isNullOrNil(str3)) {
                yVar.set(1, str2);
                yVar.set(2, Integer.valueOf(i));
                str = str2;
            } else {
                str = str3;
            }
            ab.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", str3, str, str2, Integer.valueOf(intValue), Integer.valueOf(i));
            com.tencent.mm.compatible.util.e.kw(str);
            if (!(intValue == i || com.tencent.mm.compatible.util.f.Mn())) {
                if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted") && new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    yVar.set(1, str2);
                    yVar.set(2, Integer.valueOf(i));
                    com.tencent.mm.compatible.util.e.kw(str2);
                    ab.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", com.tencent.mm.compatible.util.e.eSl, Boolean.valueOf(com.tencent.mm.compatible.util.f.Mn()));
                    AppMethodBeat.o(58766);
                    return;
                }
                ab.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", com.tencent.mm.compatible.util.e.eSl, Boolean.valueOf(com.tencent.mm.compatible.util.f.Mn()), str2);
            }
            AppMethodBeat.o(58766);
            return;
        }
        com.tencent.mm.compatible.util.e.kw(com.tencent.mm.compatible.util.e.eSl);
        ab.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", com.tencent.mm.compatible.util.e.eSl);
        AppMethodBeat.o(58766);
    }

    public void execute(final g gVar) {
        AppMethodBeat.i(58767);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.RQ().eKp.aD(new com.tencent.mm.ai.p.a() {
                public final void a(p pVar, boolean z) {
                }

                public final void a(p pVar) {
                    AppMethodBeat.i(58748);
                    PluginZero.this.yad.aU(gVar.cc);
                    AppMethodBeat.o(58748);
                }
            });
            NotifyReceiver.Io();
        }
        AppMethodBeat.o(58767);
    }

    private void setupStubLog() {
        AppMethodBeat.i(58768);
        com.tencent.e.a.b.a(new com.tencent.e.a.b.a() {
            public final void println(int i, String str, String str2) {
                AppMethodBeat.i(58749);
                if (isLoggable(str, i)) {
                    com.tencent.mm.sdk.platformtools.ab.a dos = ab.dos();
                    int myPid = Process.myPid();
                    int myTid = Process.myTid();
                    switch (i) {
                        case 2:
                            dos.logV(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                            AppMethodBeat.o(58749);
                            return;
                        case 3:
                            dos.logD(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                            AppMethodBeat.o(58749);
                            return;
                        case 4:
                            dos.logI(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                            AppMethodBeat.o(58749);
                            return;
                        case 5:
                            dos.logW(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                            AppMethodBeat.o(58749);
                            return;
                        case 6:
                            dos.logE(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                            AppMethodBeat.o(58749);
                            return;
                        case 7:
                            dos.logF(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                            AppMethodBeat.o(58749);
                            return;
                        default:
                            AppMethodBeat.o(58749);
                            return;
                    }
                }
                AppMethodBeat.o(58749);
            }

            public final boolean isLoggable(String str, int i) {
                AppMethodBeat.i(58750);
                if (i < 2 || i > 7 || PluginZero.yae[i] < ab.getLogLevel()) {
                    AppMethodBeat.o(58750);
                    return false;
                }
                AppMethodBeat.o(58750);
                return true;
            }
        });
        AppMethodBeat.o(58768);
    }

    private void setupVendingLog() {
        AppMethodBeat.i(58769);
        com.tencent.mm.vending.f.a.a(new com.tencent.mm.vending.f.a.a() {
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(58751);
                ab.e(str, str2, objArr);
                AppMethodBeat.o(58751);
            }

            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(58752);
                ab.w(str, str2, objArr);
                AppMethodBeat.o(58752);
            }

            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(58753);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(58753);
            }

            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(58754);
                ab.d(str, str2, objArr);
                AppMethodBeat.o(58754);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(58755);
                ab.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(58755);
            }
        });
        AppMethodBeat.o(58769);
    }

    public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b bVar) {
        this.yaf = bVar;
    }

    public com.tencent.mm.vending.b.b addNotifyReceiverCallback(c cVar) {
        AppMethodBeat.i(58770);
        ab.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", this, cVar);
        com.tencent.mm.vending.b.b aD = this.yag.aD(cVar);
        AppMethodBeat.o(58770);
        return aD;
    }

    public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a aVar) {
        AppMethodBeat.i(58771);
        com.tencent.mm.vending.b.b aD = this.yah.aD(aVar);
        AppMethodBeat.o(58771);
        return aD;
    }
}
