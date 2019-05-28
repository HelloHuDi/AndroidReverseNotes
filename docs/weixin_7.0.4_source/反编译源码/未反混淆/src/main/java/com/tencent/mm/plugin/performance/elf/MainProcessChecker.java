package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mmkv.MMKV;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Calendar;
import java.util.HashMap;

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

    public MainProcessChecker() {
        AppMethodBeat.i(111058);
        AppMethodBeat.o(111058);
    }

    public final void start() {
        AppMethodBeat.i(111059);
        super.start();
        try {
            if (g.K(a.class) == null) {
                ab.w("MicroMsg.MainProcessChecker", "IExptService is null!");
                AppMethodBeat.o(111059);
                return;
            }
            this.pfx = ((a) g.K(a.class)).a(a.a.clicfg_android_process_native, this.pfw);
            this.pfz = ((float) ((a) g.K(a.class)).a(a.a.clicfg_android_process_vm, this.pfy)) * 0.01f;
            this.pfB = ((float) ((a) g.K(a.class)).a(a.a.clicfg_android_process_java, this.pfA)) * 0.01f;
            pfE[0] = (long) ((a) g.K(a.class)).a(a.a.clicfg_android_process_work_begin, 0);
            pfE[1] = ((a) g.K(a.class)).a(a.a.clicfg_android_process_work_end, 86400000);
            this.pfu = ((a) g.K(a.class)).a(a.a.clicfg_android_process_traffic_per_min, 1048576);
            this.pfv = ((a) g.K(a.class)).a(a.a.clicfg_android_process_jiffy_per_min, (long) ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
            try {
                this.nDl = MMKV.defaultMMKV().getBoolean("MicroMsg.ProcessElf", false);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MainProcessChecker", e, "", new Object[0]);
                this.nDl = false;
            }
            this.pfC = ((a) g.K(a.class)).a(a.a.clicfg_android_process_is_hard_mode, true);
            this.pfD = ((a) g.K(a.class)).a(a.a.clicfg_android_process_is_check_launcher_ui, false);
            this.pfL = ((a) g.K(a.class)).a(a.a.clicfg_android_process_check_time, 1200000);
            this.pfM.append(" \n***************ProcessElf Config****************\n| isEnable:").append(this.nDl).append("\n| isHardMode:").append(this.pfC).append("\n| workTime:").append(pfE[0]).append("-").append(pfE[1]).append("ms\n| NATIVE_SIZE:").append(this.pfx).append("B\n| MEMORY_VM_TOP:").append(this.pfz).append("%\n| MEMORY_JAVA_TOP:").append(this.pfB).append("%\n| TRAFFIC_PER_MIN:").append(this.pfu).append("B\n| JIFFIES_PER_MIN:").append(this.pfv).append("jiffy\n| CHECK_TIME:").append(this.pfL).append("ms\n************************************************\n");
            ab.i("MicroMsg.MainProcessChecker", this.pfM.toString());
            AppMethodBeat.o(111059);
        } catch (Exception e2) {
            ab.e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", e2);
            AppMethodBeat.o(111059);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String bZl() {
        AppMethodBeat.i(111060);
        StringBuilder stringBuilder = new StringBuilder(this.pfM);
        stringBuilder.append(super.bZl());
        HashMap hashMap = new HashMap();
        int U = AbstractProcessChecker.U(hashMap);
        if (U >= 300) {
            stringBuilder.append("threadCount:").append(U).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append(hashMap.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            e.pXa.a(959, 8, 1, true);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(111060);
        return stringBuilder2;
    }

    /* Access modifiers changed, original: protected */
    public String getTag() {
        return "MicroMsg.MainProcessChecker";
    }

    /* Access modifiers changed, original: protected|final */
    public final void awE() {
        AppMethodBeat.i(111061);
        ab.i(getTag(), "onScreenOff enable:%s", Boolean.valueOf(this.nDl));
        if (this.nDl) {
            if (b.DEBUG || ((double) AbstractProcessChecker.zJ()) >= 4.20906795008E9d || ((double) Debug.getNativeHeapSize()) > ((double) this.pfw) * 1.4d || ((double) ((1.0f * ((float) Runtime.getRuntime().totalMemory())) / ((float) Runtime.getRuntime().maxMemory()))) >= 0.98d) {
                bZk();
            }
            AppMethodBeat.o(111061);
            return;
        }
        AppMethodBeat.o(111061);
    }

    public final boolean Q(long j, long j2) {
        AppMethodBeat.i(111062);
        ab.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isEnable:%s isForeground:%s", Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(this.nDl), Boolean.valueOf(this.caA));
        if (!this.nDl) {
            this.pfK |= 0;
            bZq();
            jK(false);
            this.pfK = 1;
            AppMethodBeat.o(111062);
            return false;
        } else if (bo.isNullOrNil(this.pfi.pfl)) {
            ab.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
            this.pfK |= 2;
            bZq();
            jK(false);
            this.pfK = 1;
            AppMethodBeat.o(111062);
            return false;
        } else if (this.caA) {
            ab.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
            this.pfK |= 4;
            bZq();
            jK(false);
            this.pfK = 1;
            AppMethodBeat.o(111062);
            return false;
        } else {
            Object obj;
            if (SystemClock.uptimeMillis() - this.pfN >= j2) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                ab.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", Long.valueOf(j2));
                this.pfK |= 4;
                bZq();
                jK(false);
                this.pfK = 1;
                AppMethodBeat.o(111062);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.set(14, 0);
            currentTimeMillis -= instance.getTimeInMillis();
            if (b.DEBUG || (pfE[0] <= currentTimeMillis && currentTimeMillis <= pfE[1])) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                ab.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", Long.valueOf(pfE[0]), Long.valueOf(pfE[1]));
                this.pfK |= 8;
                bZq();
                jK(false);
                this.pfK = 1;
                AppMethodBeat.o(111062);
                return false;
            }
            if (this.pfD) {
                if (this.caA || !pfO.equalsIgnoreCase(this.pfi.pfl)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    ab.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                    this.pfK |= 16;
                    bZq();
                    jK(false);
                    this.pfK = 1;
                    AppMethodBeat.o(111062);
                    return false;
                }
            }
            try {
                if (bZp()) {
                    this.pfK |= 32;
                    bZq();
                    jK(false);
                    this.pfK = 1;
                    AppMethodBeat.o(111062);
                    return false;
                }
                if (this.pfC) {
                    ab.i(getTag(), "[isTraffic] diff:%s byte", Long.valueOf(((bn.mu(this.pfF) + bn.mv(this.pfG)) + bn.mt(this.pfH)) + bn.mv(this.pfI)));
                    if (((float) (((bn.mu(this.pfF) + bn.mv(this.pfG)) + bn.mt(this.pfH)) + bn.mv(this.pfI))) > ((1.0f * ((float) j2)) / 60000.0f) * ((float) this.pfu)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.pfK |= 512;
                        ab.i(getTag(), "is over Traffic, just return");
                        bZq();
                        jK(false);
                        this.pfK = 1;
                        AppMethodBeat.o(111062);
                        return false;
                    }
                }
                if (this.pfC) {
                    ab.i(getTag(), "[isCpuBusy] diff:%s Jiffies", Long.valueOf(AbstractProcessChecker.bZo() - this.pfJ));
                    if (((float) (AbstractProcessChecker.bZo() - this.pfJ)) >= ((1.0f * ((float) j2)) / 60000.0f) * ((float) this.pfv)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.pfK |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        ab.i(getTag(), "is cpu busy, just return");
                        bZq();
                        jK(false);
                        this.pfK = 1;
                        AppMethodBeat.o(111062);
                        return false;
                    }
                }
                boolean z = false;
                ab.i(getTag(), "[isOverMemory] java[%s:%s]", Float.valueOf((1.0f * ((float) Runtime.getRuntime().totalMemory())) / ((float) Runtime.getRuntime().maxMemory())), Float.valueOf(this.pfB));
                if ((1.0f * ((float) Runtime.getRuntime().totalMemory())) / ((float) Runtime.getRuntime().maxMemory()) >= this.pfB) {
                    this.pfK |= 64;
                    z = true;
                }
                ab.i(getTag(), "[isOverMemory] vm[%s:%s]", Float.valueOf((1.0f * ((float) AbstractProcessChecker.zJ())) / 4.2949673E9f), Float.valueOf(this.pfz));
                if ((1.0f * ((float) AbstractProcessChecker.zJ())) / 4.2949673E9f >= this.pfz) {
                    this.pfK |= 256;
                    z = true;
                }
                ab.w(getTag(), "[isOverMemory] native[%s:%s]", Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(this.pfx));
                if ((Debug.getNativeHeapSize() > this.pfx ? 1 : null) != null) {
                    this.pfK |= 256;
                    z = true;
                }
                bZq();
                jK(z);
                this.pfK = 1;
                AppMethodBeat.o(111062);
                return z;
            } catch (Throwable th) {
                bZq();
                jK(false);
                this.pfK = 1;
                AppMethodBeat.o(111062);
            }
        }
    }

    public final void jJ(boolean z) {
        AppMethodBeat.i(111063);
        super.jJ(z);
        ab.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", Boolean.valueOf(z));
        if (!z) {
            this.pfN = SystemClock.uptimeMillis();
        }
        AppMethodBeat.o(111063);
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
    public final void eU(int i, int i2) {
        AppMethodBeat.i(111064);
        super.eU(i, i2);
        ab.w(getTag(), "[onCallUp] %s -> %s", Integer.valueOf(i2), Integer.valueOf(i));
        if (ah.bqo()) {
            e.pXa.a(959, 1, 1, true);
            this.pfh.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111057);
                    if (MainProcessChecker.this.pfi.pfm) {
                        ab.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
                        e.pXa.a(959, 7, 1, true);
                        AppMethodBeat.o(111057);
                        return;
                    }
                    ab.w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
                    AppMethodBeat.o(111057);
                }
            }, 30000);
        }
        AppMethodBeat.o(111064);
    }

    private void jK(boolean z) {
        AppMethodBeat.i(111065);
        if (ah.bqo() && this.nDl) {
            if (z) {
                e.pXa.a(959, 0, 1, true);
                e.pXa.a(959, 2, 1, true);
                if (eV(this.pfK, 64)) {
                    e.pXa.a(959, 3, 1, true);
                }
                if (eV(this.pfK, 256)) {
                    e.pXa.a(959, 4, 1, true);
                }
                if (eV(this.pfK, 128)) {
                    e.pXa.a(959, 5, 1, true);
                }
            } else if (eV(this.pfK, 8)) {
                e.pXa.a(959, 100, 1, true);
            } else if (eV(this.pfK, 16)) {
                e.pXa.a(959, 101, 1, true);
            } else if (eV(this.pfK, 32)) {
                e.pXa.a(959, 102, 1, true);
            } else if (eV(this.pfK, 512)) {
                e.pXa.a(959, 103, 1, true);
            } else if (eV(this.pfK, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
                e.pXa.a(959, 104, 1, true);
            } else if (eV(this.pfK, 64) || eV(this.pfK, 128) || eV(this.pfK, 256)) {
                e.pXa.a(959, 105, 1, true);
            }
            if (eV(this.pfK, 4)) {
                e.pXa.a(959, 106, 1, false);
                AppMethodBeat.o(111065);
                return;
            }
            e.pXa.a(959, 107, 1, false);
            AppMethodBeat.o(111065);
            return;
        }
        AppMethodBeat.o(111065);
    }

    private static boolean eV(int i, int i2) {
        return (i & i2) > 0;
    }

    private void bZq() {
        AppMethodBeat.i(111066);
        this.pfF = bn.mu(0);
        this.pfG = bn.mv(0);
        this.pfH = bn.mt(0);
        this.pfI = bn.dpy();
        this.pfJ = AbstractProcessChecker.bZo();
        AppMethodBeat.o(111066);
    }

    public static void UD(String str) {
        pfO = str;
    }
}
