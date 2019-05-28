package com.tencent.p177mm.blink;

import android.os.SystemClock;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.blink.a */
public final class C1311a {
    public static final int[] eaB = new int[]{0, 1, 2};
    public static final int[] eaC = new int[]{3, 13, 23};
    public static final int[] eaD = new int[]{4, 14, 24};
    public static final int[] eaE = new int[]{5, 15, 25};
    public static final int[] eaF = new int[]{6, 16, 26};
    public static final int[] eaG = new int[]{7, 17, 27};
    public static final int[] eaH = new int[]{8, 18, 28};
    public static final int[] eaI = new int[]{9, 19, 29};
    public static final int[] eaJ = new int[]{63, 69, 75};
    public static final int[] eaK = new int[]{64, 70, 76};
    public static final int[] eaL = new int[]{65, 71, 77};
    public static final int[] eaM = new int[]{66, 72, 78};
    private static final int[] eaN = new int[]{0};
    private static final int[] eaO = new int[]{3};
    private static final int[] eaP = new int[]{9};
    private static final int[] eaQ = new int[]{10};
    private static final int[] eaR = new int[]{11};
    private static final int[] eaS = new int[]{12};
    private static final int[] eaT = new int[]{13};
    private static final int[] eaU = new int[]{14};
    private static final ArrayList<long[]> eaV = new ArrayList();
    private static final ArrayList<Object[]> eaW = new ArrayList();
    private static long eaX = 0;
    private static boolean eaY = false;
    private static long eaZ = 0;
    private static long eba = 0;
    private static long ebb = 0;
    private static long ebc = 0;
    private static byte ebd = (byte) 0;

    /* renamed from: q */
    public static void m2808q(long j, long j2) {
        AppMethodBeat.m2504i(57683);
        C1736j.m3589q(j, j2);
        AppMethodBeat.m2505o(57683);
    }

    /* renamed from: h */
    public static void m2804h(String str, long j) {
        AppMethodBeat.m2504i(57684);
        C1736j.m3586h(str, j);
        AppMethodBeat.m2505o(57684);
    }

    /* renamed from: jD */
    public static void m2807jD(String str) {
        AppMethodBeat.m2504i(57685);
        C1736j.m3588jD(str);
        AppMethodBeat.m2505o(57685);
    }

    static {
        AppMethodBeat.m2504i(57701);
        AppMethodBeat.m2505o(57701);
    }

    /* renamed from: r */
    public static void m2809r(long j, long j2) {
        AppMethodBeat.m2504i(57686);
        eaV.add(new long[]{709, j, j2});
        AppMethodBeat.m2505o(57686);
    }

    /* renamed from: s */
    public static void m2810s(long j, long j2) {
        AppMethodBeat.m2504i(57687);
        eaV.add(new long[]{783, j, j2});
        AppMethodBeat.m2505o(57687);
    }

    /* renamed from: HJ */
    public static void m2792HJ() {
        AppMethodBeat.m2504i(57688);
        eaX = System.currentTimeMillis();
        AppMethodBeat.m2505o(57688);
    }

    /* renamed from: HK */
    public static void m2793HK() {
        AppMethodBeat.m2504i(57689);
        if (C1311a.m2805if(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            C1311a.m2810s(1, System.currentTimeMillis() - eaX);
            C1311a.m2810s(2, 1);
        }
        AppMethodBeat.m2505o(57689);
    }

    /* renamed from: cZ */
    public static void m2801cZ(String str) {
        AppMethodBeat.m2504i(57690);
        if (C1311a.m2805if(512) && C4996ah.doy().equals(str)) {
            eaY = true;
            C4990ab.m7416i("MicroMsg.BlinkStartup", "report this time");
        }
        AppMethodBeat.m2505o(57690);
    }

    /* renamed from: BO */
    public static void m2791BO() {
        AppMethodBeat.m2504i(57691);
        C1311a.m2805if(512);
        AppMethodBeat.m2505o(57691);
    }

    /* renamed from: eM */
    public static void m2802eM(long j) {
        AppMethodBeat.m2504i(57692);
        if (System.currentTimeMillis() - j > 200) {
            C1311a.m2805if(512);
            eaY = false;
        }
        AppMethodBeat.m2505o(57692);
    }

    /* renamed from: t */
    public static void m2811t(long j, long j2) {
        eaZ = j;
        eba = j2;
        ebb = eaZ;
        ebc = eba;
    }

    /* renamed from: a */
    private static void m2799a(int[] iArr, long j) {
        AppMethodBeat.m2504i(57694);
        C4990ab.m7417i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j));
        C1311a.m2809r((long) iArr[0], j);
        if (C1523a.f1229wY) {
            C1311a.m2809r((long) iArr[1], j);
            AppMethodBeat.m2505o(57694);
            return;
        }
        C1311a.m2809r((long) iArr[2], j);
        AppMethodBeat.m2505o(57694);
    }

    /* renamed from: b */
    private static void m2800b(int[] iArr, long j) {
        AppMethodBeat.m2504i(57695);
        C4990ab.m7417i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j));
        long j2 = (long) iArr[0];
        eaV.add(new long[]{910, j2, j});
        AppMethodBeat.m2505o(57695);
    }

    /* renamed from: HM */
    public static boolean m2795HM() {
        AppMethodBeat.m2504i(57696);
        if (eaY) {
            boolean z = C1311a.m2805if(256);
            AppMethodBeat.m2505o(57696);
            return z;
        }
        AppMethodBeat.m2505o(57696);
        return false;
    }

    /* renamed from: if */
    private static boolean m2805if(int i) {
        AppMethodBeat.m2504i(57697);
        if ((ebd & i) == 0) {
            ebd = (byte) (ebd | i);
            C4990ab.m7417i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", Integer.valueOf(i));
            AppMethodBeat.m2505o(57697);
            return true;
        }
        AppMethodBeat.m2505o(57697);
        return false;
    }

    /* renamed from: eN */
    private static void m2803eN(long j) {
        AppMethodBeat.m2504i(57698);
        if (j > 10000) {
            C1311a.m2794HL();
        }
        AppMethodBeat.m2505o(57698);
    }

    /* renamed from: ig */
    public static void m2806ig(int i) {
        AppMethodBeat.m2504i(57699);
        if (ebb == 0) {
            C4990ab.m7412e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
            AppMethodBeat.m2505o(57699);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - ebb;
        switch (i) {
            case 1:
                if (C1311a.m2805if(1)) {
                    C1311a.m2799a(eaC, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.m2505o(57699);
                    return;
                }
                break;
            case 2:
                if (C1311a.m2805if(2)) {
                    C1311a.m2799a(eaD, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.m2505o(57699);
                    return;
                }
                break;
            case 3:
                if (C1311a.m2805if(4)) {
                    C1311a.m2799a(eaE, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.m2505o(57699);
                    return;
                }
                break;
            case 4:
                if (C1311a.m2805if(8)) {
                    C1311a.m2799a(eaF, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.m2505o(57699);
                    return;
                }
                break;
            case 5:
                if (C1311a.m2805if(16)) {
                    C1311a.m2803eN(currentTimeMillis);
                    C1311a.m2799a(eaG, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.m2505o(57699);
                    return;
                }
                break;
            case 6:
                if (C1311a.m2805if(32)) {
                    C1311a.m2803eN(currentTimeMillis);
                    C1311a.m2799a(eaH, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(57699);
    }

    /* renamed from: HN */
    public static void m2796HN() {
        AppMethodBeat.m2504i(57700);
        long currentTimeMillis = System.currentTimeMillis() - eaZ;
        C1311a.m2799a(eaI, currentTimeMillis);
        if (currentTimeMillis <= 3000) {
            C1311a.m2799a(eaJ, 1);
        } else if (currentTimeMillis > 3000 && currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            C1311a.m2799a(eaK, 1);
        } else if (currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME || currentTimeMillis > 10000) {
            C1311a.m2799a(eaM, 1);
        } else {
            C1311a.m2799a(eaL, 1);
        }
        C1311a.m2799a(eaB, 1);
        currentTimeMillis = SystemClock.elapsedRealtime() - eba;
        C1311a.m2800b(eaO, currentTimeMillis);
        if (currentTimeMillis <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            C1311a.m2800b(eaP, 1);
        } else if (currentTimeMillis > FaceGestureDetGLThread.BRIGHTNESS_DURATION && currentTimeMillis <= 4000) {
            C1311a.m2800b(eaQ, 1);
        } else if (currentTimeMillis > 4000 && currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            C1311a.m2800b(eaR, 1);
        } else if (currentTimeMillis > ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME && currentTimeMillis <= 8000) {
            C1311a.m2800b(eaS, 1);
        } else if (currentTimeMillis <= 8000 || currentTimeMillis > 10000) {
            C1311a.m2800b(eaU, 1);
        } else {
            C1311a.m2800b(eaT, 1);
        }
        C1311a.m2800b(eaN, 1);
        ArrayList arrayList = eaW;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(15854);
        objArr[1] = new Object[]{Long.valueOf(currentTimeMillis)};
        arrayList.add(objArr);
        AppMethodBeat.m2505o(57700);
    }

    /* renamed from: HO */
    public static ArrayList<long[]> m2797HO() {
        return eaV;
    }

    /* renamed from: HP */
    public static ArrayList<Object[]> m2798HP() {
        return eaW;
    }

    /* renamed from: HL */
    public static void m2794HL() {
        AppMethodBeat.m2504i(139004);
        C1311a.m2805if(512);
        eaY = false;
        AppMethodBeat.m2505o(139004);
    }
}
