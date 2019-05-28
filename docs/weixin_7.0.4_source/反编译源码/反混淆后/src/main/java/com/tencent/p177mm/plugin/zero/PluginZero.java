package com.tencent.p177mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.p150mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import com.tencent.p136e.p137a.C0926b.C0925a;
import com.tencent.p177mm.app.C1246e;
import com.tencent.p177mm.booter.NotifyReceiver;
import com.tencent.p177mm.booter.NotifyReceiver.NotifyService;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.kernel.p238a.C1651a;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p183ai.C6300p.C1213a;
import com.tencent.p177mm.p212cc.C1349b;
import com.tencent.p177mm.p217ci.C37655i;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.p217ci.C6455d;
import com.tencent.p177mm.plugin.zero.p591a.C23228b;
import com.tencent.p177mm.plugin.zero.p591a.C30032a;
import com.tencent.p177mm.plugin.zero.p591a.C44034c;
import com.tencent.p177mm.plugin.zero.p591a.C44035d;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.plugin.zero.tasks.C35780a;
import com.tencent.p177mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.p177mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4990ab.C4989a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5144y;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.p177mm.vending.p640f.C5687a;
import com.tencent.p177mm.vending.p640f.C5687a.C5686a;
import com.tencent.p177mm.vending.p642h.C5707g;
import com.tencent.p177mm.vending.p642h.C7369h;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.zero.PluginZero */
public class PluginZero extends C7597f implements C44035d {
    private static final int[] yae = new int[]{6, 6, 0, 1, 2, 3, 4, 5};
    private C44036a yab = new C44036a();
    private C44037b yac = new C44037b();
    private final C1246e yad = new C1246e();
    public C23228b yaf;
    public C35778b yag = new C35778b();
    public C35776a yah = new C35776a();

    /* renamed from: com.tencent.mm.plugin.zero.PluginZero$3 */
    class C148213 implements C0925a {
        C148213() {
        }

        public final void println(int i, String str, String str2) {
            AppMethodBeat.m2504i(58749);
            if (isLoggable(str, i)) {
                C4989a dos = C4990ab.dos();
                int myPid = Process.myPid();
                int myTid = Process.myTid();
                switch (i) {
                    case 2:
                        dos.logV(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.m2505o(58749);
                        return;
                    case 3:
                        dos.logD(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.m2505o(58749);
                        return;
                    case 4:
                        dos.logI(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.m2505o(58749);
                        return;
                    case 5:
                        dos.logW(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.m2505o(58749);
                        return;
                    case 6:
                        dos.logE(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.m2505o(58749);
                        return;
                    case 7:
                        dos.logF(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.m2505o(58749);
                        return;
                    default:
                        AppMethodBeat.m2505o(58749);
                        return;
                }
            }
            AppMethodBeat.m2505o(58749);
        }

        public final boolean isLoggable(String str, int i) {
            AppMethodBeat.m2504i(58750);
            if (i < 2 || i > 7 || PluginZero.yae[i] < C4990ab.getLogLevel()) {
                AppMethodBeat.m2505o(58750);
                return false;
            }
            AppMethodBeat.m2505o(58750);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.zero.PluginZero$4 */
    class C300314 implements C5686a {
        C300314() {
        }

        /* renamed from: e */
        public final void mo11577e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(58751);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(58751);
        }

        /* renamed from: w */
        public final void mo11580w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(58752);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(58752);
        }

        /* renamed from: i */
        public final void mo11578i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(58753);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(58753);
        }

        /* renamed from: d */
        public final void mo11576d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(58754);
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(58754);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(58755);
            C4990ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.m2505o(58755);
        }
    }

    /* renamed from: com.tencent.mm.plugin.zero.PluginZero$a */
    public static final class C35776a extends C6454a<C30032a> implements C30032a {
        /* renamed from: a */
        public final void mo48264a(final Service service) {
            AppMethodBeat.m2504i(58758);
            mo14669a(new C1387a<C30032a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(58756);
                    ((C30032a) obj).mo48264a(service);
                    AppMethodBeat.m2505o(58756);
                }
            });
            AppMethodBeat.m2505o(58758);
        }

        /* renamed from: b */
        public final void mo48265b(final Service service) {
            AppMethodBeat.m2504i(58759);
            mo14669a(new C1387a<C30032a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(58757);
                    ((C30032a) obj).mo48265b(service);
                    AppMethodBeat.m2505o(58757);
                }
            });
            AppMethodBeat.m2505o(58759);
        }
    }

    /* renamed from: com.tencent.mm.plugin.zero.PluginZero$b */
    public static final class C35778b extends C6454a<C44034c> implements C44034c {
        /* renamed from: a */
        public final void mo56551a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
            AppMethodBeat.m2504i(58761);
            final NotifyService notifyService2 = notifyService;
            final int i2 = i;
            final byte[] bArr3 = bArr;
            final byte[] bArr4 = bArr2;
            final long j2 = j;
            mo14669a(new C1387a<C44034c>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(58760);
                    ((C44034c) obj).mo56551a(notifyService2, i2, bArr3, bArr4, j2);
                    AppMethodBeat.m2505o(58760);
                }
            });
            AppMethodBeat.m2505o(58761);
        }
    }

    public PluginZero() {
        AppMethodBeat.m2504i(58762);
        AppMethodBeat.m2505o(58762);
    }

    public String toString() {
        return "plugin-zero";
    }

    public void installed() {
        AppMethodBeat.m2504i(58763);
        alias(C44035d.class);
        AppMethodBeat.m2505o(58763);
    }

    public void dependency() {
        AppMethodBeat.m2504i(58764);
        dependsOnRoot();
        AppMethodBeat.m2505o(58764);
    }

    public void configure(final C1681g c1681g) {
        AppMethodBeat.m2504i(58765);
        try {
            initSDRoot();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.PluginZero", e, "what happened?", new Object[0]);
        }
        C4996ah.m7430ce(c1681g.eHT);
        C1651a.m3339k("configure [%s], setup broken library handler...", this);
        setupStubLog();
        setupVendingLog();
        if (c1681g.mo5181SG()) {
            C1651a.m3339k("configure [%s], for process[%s]...", this, c1681g.eHT);
            C1720g.m3543a(C7234a.class, new C6625e(this.yab));
            C1720g.m3543a(C35779b.class, new C6625e(this.yac));
            C1651a.m3339k("configure [%s], make worker core...", this);
            C1720g RQ = C1720g.m3537RQ();
            if (!RQ.eKs) {
                RQ.eKs = true;
                RQ.eKl = new C1706e(C6610c.m10890Sa());
                RQ.eKm = new C1668a(C6610c.m10890Sa());
                RQ.eKn = new C1682b(RQ.eKp, RQ.eJn);
                RQ.eKo = new C1349b(C4996ah.getContext());
            }
            NotifyReceiver.m41395In();
            C1720g.m3537RQ().mo5252a(new C1675g() {
                /* renamed from: BR */
                public final void mo5176BR() {
                    AppMethodBeat.m2504i(58746);
                    C1651a.m3339k("onStartupDone", new Object[0]);
                    AppMethodBeat.m2505o(58746);
                }

                /* renamed from: bi */
                public final void mo5177bi(boolean z) {
                    AppMethodBeat.m2504i(58747);
                    if (z) {
                        C1737l.m3593m(c1681g.f1233cc, true);
                        C1737l.m3594n(c1681g.f1233cc, true);
                    }
                    C4990ab.dot();
                    AppMethodBeat.m2505o(58747);
                }
            });
            C1720g.m3537RQ();
            C37655i.Aiy = new C7369h(C6455d.m10673c(C1720g.m3539RS().doN()), "WeChat.WORKER");
            C5707g.m8573a("WeChat.WORKER", C37655i.Aiy);
            new C35780a().before(this);
        }
        if (c1681g.mo5181SG() || c1681g.mo5183lQ(":push")) {
            new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
        }
        if (c1681g.mo5183lQ(":push")) {
            AppLogic.setCallBack(new AppCallBack(C4996ah.getContext()));
            C1449k.m3079a(C1682b.eJm, getClass().getClassLoader());
            SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        }
        AppMethodBeat.m2505o(58765);
    }

    private void initSDRoot() {
        AppMethodBeat.m2504i(58766);
        if (new File(C5128ac.eSj + "SdcardInfo.cfg").exists()) {
            String str;
            String str2 = C6457e.eSl;
            C5144y c5144y = new C5144y(C5128ac.eSj + "SdcardInfo.cfg");
            String str3 = (String) c5144y.get(1, "");
            int intValue = ((Integer) c5144y.get(2, Integer.valueOf(0))).intValue();
            int i = VERSION.SDK_INT;
            if (C5046bo.isNullOrNil(str3)) {
                c5144y.set(1, str2);
                c5144y.set(2, Integer.valueOf(i));
                str = str2;
            } else {
                str = str3;
            }
            C4990ab.m7417i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", str3, str, str2, Integer.valueOf(intValue), Integer.valueOf(i));
            C6457e.m10679kw(str);
            if (!(intValue == i || C1445f.m3070Mn())) {
                if (C1448h.getExternalStorageState().equals("mounted") && new File(C1448h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    c5144y.set(1, str2);
                    c5144y.set(2, Integer.valueOf(i));
                    C6457e.m10679kw(str2);
                    C4990ab.m7417i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", C6457e.eSl, Boolean.valueOf(C1445f.m3070Mn()));
                    AppMethodBeat.m2505o(58766);
                    return;
                }
                C4990ab.m7417i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", C6457e.eSl, Boolean.valueOf(C1445f.m3070Mn()), str2);
            }
            AppMethodBeat.m2505o(58766);
            return;
        }
        C6457e.m10679kw(C6457e.eSl);
        C4990ab.m7417i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", C6457e.eSl);
        AppMethodBeat.m2505o(58766);
    }

    public void execute(final C1681g c1681g) {
        AppMethodBeat.m2504i(58767);
        if (c1681g.mo5181SG()) {
            C1720g.m3537RQ().eKp.mo14670aD(new C1213a() {
                /* renamed from: a */
                public final void mo4484a(C6300p c6300p, boolean z) {
                }

                /* renamed from: a */
                public final void mo4483a(C6300p c6300p) {
                    AppMethodBeat.m2504i(58748);
                    PluginZero.this.yad.mo4530aU(c1681g.f1233cc);
                    AppMethodBeat.m2505o(58748);
                }
            });
            NotifyReceiver.m41396Io();
        }
        AppMethodBeat.m2505o(58767);
    }

    private void setupStubLog() {
        AppMethodBeat.m2504i(58768);
        C0926b.m2095a(new C148213());
        AppMethodBeat.m2505o(58768);
    }

    private void setupVendingLog() {
        AppMethodBeat.m2504i(58769);
        C5687a.m8539a(new C300314());
        AppMethodBeat.m2505o(58769);
    }

    public void setILightPushDelegate(C23228b c23228b) {
        this.yaf = c23228b;
    }

    public C7358b addNotifyReceiverCallback(C44034c c44034c) {
        AppMethodBeat.m2504i(58770);
        C4990ab.m7417i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", this, c44034c);
        C7358b aD = this.yag.mo14670aD(c44034c);
        AppMethodBeat.m2505o(58770);
        return aD;
    }

    public C7358b addICoreServiceLifecycleCallback(C30032a c30032a) {
        AppMethodBeat.m2504i(58771);
        C7358b aD = this.yah.mo14670aD(c30032a);
        AppMethodBeat.m2505o(58771);
        return aD;
    }
}
