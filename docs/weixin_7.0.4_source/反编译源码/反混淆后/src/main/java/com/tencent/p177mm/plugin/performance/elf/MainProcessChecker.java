package com.tencent.p177mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mmkv.MMKV;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C15427bn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Calendar;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.performance.elf.MainProcessChecker */
public class MainProcessChecker extends AbstractProcessChecker {
    private static final long[] pfE = new long[]{0, 86400000};
    private static String pfO = "";
    private boolean nDl = false;
    private int pfA = 85;
    private float pfB = (((float) this.pfA) * 0.01f);
    private boolean pfC = true;
    private boolean pfD = false;
    private long pfF;
    private long pfG;
    private long pfH;
    private long pfI;
    private long pfJ;
    private int pfK = 1;
    private long pfL;
    private StringBuilder pfM = new StringBuilder();
    private long pfN = 0;
    private long pfu = 1048576;
    private long pfv = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    private long pfw = 734003200;
    private long pfx = this.pfw;
    private int pfy = 95;
    private float pfz = (((float) this.pfy) * 0.01f);

    /* renamed from: com.tencent.mm.plugin.performance.elf.MainProcessChecker$1 */
    class C394841 implements Runnable {
        C394841() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111057);
            if (MainProcessChecker.this.pfi.pfm) {
                C4990ab.m7420w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
                C7053e.pXa.mo8378a(959, 7, 1, true);
                AppMethodBeat.m2505o(111057);
                return;
            }
            C4990ab.m7420w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
            AppMethodBeat.m2505o(111057);
        }
    }

    public MainProcessChecker() {
        AppMethodBeat.m2504i(111058);
        AppMethodBeat.m2505o(111058);
    }

    public final void start() {
        AppMethodBeat.m2504i(111059);
        super.start();
        try {
            if (C1720g.m3528K(C34069a.class) == null) {
                C4990ab.m7420w("MicroMsg.MainProcessChecker", "IExptService is null!");
                AppMethodBeat.m2505o(111059);
                return;
            }
            this.pfx = ((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_android_process_native, this.pfw);
            this.pfz = ((float) ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_android_process_vm, this.pfy)) * 0.01f;
            this.pfB = ((float) ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_android_process_java, this.pfA)) * 0.01f;
            pfE[0] = (long) ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_android_process_work_begin, 0);
            pfE[1] = ((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_android_process_work_end, 86400000);
            this.pfu = ((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_android_process_traffic_per_min, 1048576);
            this.pfv = ((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_android_process_jiffy_per_min, (long) ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
            try {
                this.nDl = MMKV.defaultMMKV().getBoolean("MicroMsg.ProcessElf", false);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MainProcessChecker", e, "", new Object[0]);
                this.nDl = false;
            }
            this.pfC = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_android_process_is_hard_mode, true);
            this.pfD = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_android_process_is_check_launcher_ui, false);
            this.pfL = ((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_android_process_check_time, 1200000);
            this.pfM.append(" \n***************ProcessElf Config****************\n| isEnable:").append(this.nDl).append("\n| isHardMode:").append(this.pfC).append("\n| workTime:").append(pfE[0]).append("-").append(pfE[1]).append("ms\n| NATIVE_SIZE:").append(this.pfx).append("B\n| MEMORY_VM_TOP:").append(this.pfz).append("%\n| MEMORY_JAVA_TOP:").append(this.pfB).append("%\n| TRAFFIC_PER_MIN:").append(this.pfu).append("B\n| JIFFIES_PER_MIN:").append(this.pfv).append("jiffy\n| CHECK_TIME:").append(this.pfL).append("ms\n************************************************\n");
            C4990ab.m7416i("MicroMsg.MainProcessChecker", this.pfM.toString());
            AppMethodBeat.m2505o(111059);
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", e2);
            AppMethodBeat.m2505o(111059);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String bZl() {
        AppMethodBeat.m2504i(111060);
        StringBuilder stringBuilder = new StringBuilder(this.pfM);
        stringBuilder.append(super.bZl());
        HashMap hashMap = new HashMap();
        int U = AbstractProcessChecker.m86081U(hashMap);
        if (U >= 300) {
            stringBuilder.append("threadCount:").append(U).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append(hashMap.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            C7053e.pXa.mo8378a(959, 8, 1, true);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(111060);
        return stringBuilder2;
    }

    /* Access modifiers changed, original: protected */
    public String getTag() {
        return "MicroMsg.MainProcessChecker";
    }

    /* Access modifiers changed, original: protected|final */
    public final void awE() {
        AppMethodBeat.m2504i(111061);
        C4990ab.m7417i(getTag(), "onScreenOff enable:%s", Boolean.valueOf(this.nDl));
        if (this.nDl) {
            if (C43369b.DEBUG || ((double) AbstractProcessChecker.m86086zJ()) >= 4.20906795008E9d || ((double) Debug.getNativeHeapSize()) > ((double) this.pfw) * 1.4d || ((double) ((1.0f * ((float) Runtime.getRuntime().totalMemory())) / ((float) Runtime.getRuntime().maxMemory()))) >= 0.98d) {
                bZk();
            }
            AppMethodBeat.m2505o(111061);
            return;
        }
        AppMethodBeat.m2505o(111061);
    }

    /* renamed from: Q */
    public final boolean mo62432Q(long j, long j2) {
        AppMethodBeat.m2504i(111062);
        C4990ab.m7417i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isEnable:%s isForeground:%s", Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(this.nDl), Boolean.valueOf(this.caA));
        if (!this.nDl) {
            this.pfK |= 0;
            bZq();
            m67460jK(false);
            this.pfK = 1;
            AppMethodBeat.m2505o(111062);
            return false;
        } else if (C5046bo.isNullOrNil(this.pfi.pfl)) {
            C4990ab.m7420w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
            this.pfK |= 2;
            bZq();
            m67460jK(false);
            this.pfK = 1;
            AppMethodBeat.m2505o(111062);
            return false;
        } else if (this.caA) {
            C4990ab.m7420w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
            this.pfK |= 4;
            bZq();
            m67460jK(false);
            this.pfK = 1;
            AppMethodBeat.m2505o(111062);
            return false;
        } else {
            Object obj;
            if (SystemClock.uptimeMillis() - this.pfN >= j2) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                C4990ab.m7421w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", Long.valueOf(j2));
                this.pfK |= 4;
                bZq();
                m67460jK(false);
                this.pfK = 1;
                AppMethodBeat.m2505o(111062);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.set(14, 0);
            currentTimeMillis -= instance.getTimeInMillis();
            if (C43369b.DEBUG || (pfE[0] <= currentTimeMillis && currentTimeMillis <= pfE[1])) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                C4990ab.m7421w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", Long.valueOf(pfE[0]), Long.valueOf(pfE[1]));
                this.pfK |= 8;
                bZq();
                m67460jK(false);
                this.pfK = 1;
                AppMethodBeat.m2505o(111062);
                return false;
            }
            if (this.pfD) {
                if (this.caA || !pfO.equalsIgnoreCase(this.pfi.pfl)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    C4990ab.m7420w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                    this.pfK |= 16;
                    bZq();
                    m67460jK(false);
                    this.pfK = 1;
                    AppMethodBeat.m2505o(111062);
                    return false;
                }
            }
            try {
                if (bZp()) {
                    this.pfK |= 32;
                    bZq();
                    m67460jK(false);
                    this.pfK = 1;
                    AppMethodBeat.m2505o(111062);
                    return false;
                }
                if (this.pfC) {
                    C4990ab.m7417i(getTag(), "[isTraffic] diff:%s byte", Long.valueOf(((C15427bn.m23706mu(this.pfF) + C15427bn.m23707mv(this.pfG)) + C15427bn.m23705mt(this.pfH)) + C15427bn.m23707mv(this.pfI)));
                    if (((float) (((C15427bn.m23706mu(this.pfF) + C15427bn.m23707mv(this.pfG)) + C15427bn.m23705mt(this.pfH)) + C15427bn.m23707mv(this.pfI))) > ((1.0f * ((float) j2)) / 60000.0f) * ((float) this.pfu)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.pfK |= 512;
                        C4990ab.m7416i(getTag(), "is over Traffic, just return");
                        bZq();
                        m67460jK(false);
                        this.pfK = 1;
                        AppMethodBeat.m2505o(111062);
                        return false;
                    }
                }
                if (this.pfC) {
                    C4990ab.m7417i(getTag(), "[isCpuBusy] diff:%s Jiffies", Long.valueOf(AbstractProcessChecker.bZo() - this.pfJ));
                    if (((float) (AbstractProcessChecker.bZo() - this.pfJ)) >= ((1.0f * ((float) j2)) / 60000.0f) * ((float) this.pfv)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.pfK |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        C4990ab.m7416i(getTag(), "is cpu busy, just return");
                        bZq();
                        m67460jK(false);
                        this.pfK = 1;
                        AppMethodBeat.m2505o(111062);
                        return false;
                    }
                }
                boolean z = false;
                C4990ab.m7417i(getTag(), "[isOverMemory] java[%s:%s]", Float.valueOf((1.0f * ((float) Runtime.getRuntime().totalMemory())) / ((float) Runtime.getRuntime().maxMemory())), Float.valueOf(this.pfB));
                if ((1.0f * ((float) Runtime.getRuntime().totalMemory())) / ((float) Runtime.getRuntime().maxMemory()) >= this.pfB) {
                    this.pfK |= 64;
                    z = true;
                }
                C4990ab.m7417i(getTag(), "[isOverMemory] vm[%s:%s]", Float.valueOf((1.0f * ((float) AbstractProcessChecker.m86086zJ())) / 4.2949673E9f), Float.valueOf(this.pfz));
                if ((1.0f * ((float) AbstractProcessChecker.m86086zJ())) / 4.2949673E9f >= this.pfz) {
                    this.pfK |= 256;
                    z = true;
                }
                C4990ab.m7421w(getTag(), "[isOverMemory] native[%s:%s]", Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(this.pfx));
                if ((Debug.getNativeHeapSize() > this.pfx ? 1 : null) != null) {
                    this.pfK |= 256;
                    z = true;
                }
                bZq();
                m67460jK(z);
                this.pfK = 1;
                AppMethodBeat.m2505o(111062);
                return z;
            } catch (Throwable th) {
                bZq();
                m67460jK(false);
                this.pfK = 1;
                AppMethodBeat.m2505o(111062);
            }
        }
    }

    /* renamed from: jJ */
    public final void mo62438jJ(boolean z) {
        AppMethodBeat.m2504i(111063);
        super.mo62438jJ(z);
        C4990ab.m7417i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", Boolean.valueOf(z));
        if (!z) {
            this.pfN = SystemClock.uptimeMillis();
        }
        AppMethodBeat.m2505o(111063);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isEnable() {
        return this.nDl;
    }

    /* Access modifiers changed, original: protected|final */
    public final long bZm() {
        return this.pfL;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: eU */
    public final void mo62436eU(int i, int i2) {
        AppMethodBeat.m2504i(111064);
        super.mo62436eU(i, i2);
        C4990ab.m7421w(getTag(), "[onCallUp] %s -> %s", Integer.valueOf(i2), Integer.valueOf(i));
        if (C4996ah.bqo()) {
            C7053e.pXa.mo8378a(959, 1, 1, true);
            this.pfh.postDelayed(new C394841(), 30000);
        }
        AppMethodBeat.m2505o(111064);
    }

    /* renamed from: jK */
    private void m67460jK(boolean z) {
        AppMethodBeat.m2504i(111065);
        if (C4996ah.bqo() && this.nDl) {
            if (z) {
                C7053e.pXa.mo8378a(959, 0, 1, true);
                C7053e.pXa.mo8378a(959, 2, 1, true);
                if (MainProcessChecker.m67459eV(this.pfK, 64)) {
                    C7053e.pXa.mo8378a(959, 3, 1, true);
                }
                if (MainProcessChecker.m67459eV(this.pfK, 256)) {
                    C7053e.pXa.mo8378a(959, 4, 1, true);
                }
                if (MainProcessChecker.m67459eV(this.pfK, 128)) {
                    C7053e.pXa.mo8378a(959, 5, 1, true);
                }
            } else if (MainProcessChecker.m67459eV(this.pfK, 8)) {
                C7053e.pXa.mo8378a(959, 100, 1, true);
            } else if (MainProcessChecker.m67459eV(this.pfK, 16)) {
                C7053e.pXa.mo8378a(959, 101, 1, true);
            } else if (MainProcessChecker.m67459eV(this.pfK, 32)) {
                C7053e.pXa.mo8378a(959, 102, 1, true);
            } else if (MainProcessChecker.m67459eV(this.pfK, 512)) {
                C7053e.pXa.mo8378a(959, 103, 1, true);
            } else if (MainProcessChecker.m67459eV(this.pfK, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
                C7053e.pXa.mo8378a(959, 104, 1, true);
            } else if (MainProcessChecker.m67459eV(this.pfK, 64) || MainProcessChecker.m67459eV(this.pfK, 128) || MainProcessChecker.m67459eV(this.pfK, 256)) {
                C7053e.pXa.mo8378a(959, 105, 1, true);
            }
            if (MainProcessChecker.m67459eV(this.pfK, 4)) {
                C7053e.pXa.mo8378a(959, 106, 1, false);
                AppMethodBeat.m2505o(111065);
                return;
            }
            C7053e.pXa.mo8378a(959, 107, 1, false);
            AppMethodBeat.m2505o(111065);
            return;
        }
        AppMethodBeat.m2505o(111065);
    }

    /* renamed from: eV */
    private static boolean m67459eV(int i, int i2) {
        return (i & i2) > 0;
    }

    private void bZq() {
        AppMethodBeat.m2504i(111066);
        this.pfF = C15427bn.m23706mu(0);
        this.pfG = C15427bn.m23707mv(0);
        this.pfH = C15427bn.m23705mt(0);
        this.pfI = C15427bn.dpy();
        this.pfJ = AbstractProcessChecker.bZo();
        AppMethodBeat.m2505o(111066);
    }

    /* renamed from: UD */
    public static void m67458UD(String str) {
        pfO = str;
    }
}
