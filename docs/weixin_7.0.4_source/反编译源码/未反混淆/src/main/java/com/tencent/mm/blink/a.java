package com.tencent.mm.blink;

import android.os.SystemClock;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;

public final class a {
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

    public static void q(long j, long j2) {
        AppMethodBeat.i(57683);
        j.q(j, j2);
        AppMethodBeat.o(57683);
    }

    public static void h(String str, long j) {
        AppMethodBeat.i(57684);
        j.h(str, j);
        AppMethodBeat.o(57684);
    }

    public static void jD(String str) {
        AppMethodBeat.i(57685);
        j.jD(str);
        AppMethodBeat.o(57685);
    }

    static {
        AppMethodBeat.i(57701);
        AppMethodBeat.o(57701);
    }

    public static void r(long j, long j2) {
        AppMethodBeat.i(57686);
        eaV.add(new long[]{709, j, j2});
        AppMethodBeat.o(57686);
    }

    public static void s(long j, long j2) {
        AppMethodBeat.i(57687);
        eaV.add(new long[]{783, j, j2});
        AppMethodBeat.o(57687);
    }

    public static void HJ() {
        AppMethodBeat.i(57688);
        eaX = System.currentTimeMillis();
        AppMethodBeat.o(57688);
    }

    public static void HK() {
        AppMethodBeat.i(57689);
        if (m2if(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            s(1, System.currentTimeMillis() - eaX);
            s(2, 1);
        }
        AppMethodBeat.o(57689);
    }

    public static void cZ(String str) {
        AppMethodBeat.i(57690);
        if (m2if(512) && ah.doy().equals(str)) {
            eaY = true;
            ab.i("MicroMsg.BlinkStartup", "report this time");
        }
        AppMethodBeat.o(57690);
    }

    public static void BO() {
        AppMethodBeat.i(57691);
        m2if(512);
        AppMethodBeat.o(57691);
    }

    public static void eM(long j) {
        AppMethodBeat.i(57692);
        if (System.currentTimeMillis() - j > 200) {
            m2if(512);
            eaY = false;
        }
        AppMethodBeat.o(57692);
    }

    public static void t(long j, long j2) {
        eaZ = j;
        eba = j2;
        ebb = eaZ;
        ebc = eba;
    }

    private static void a(int[] iArr, long j) {
        AppMethodBeat.i(57694);
        ab.i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j));
        r((long) iArr[0], j);
        if (com.tencent.mm.f.a.wY) {
            r((long) iArr[1], j);
            AppMethodBeat.o(57694);
            return;
        }
        r((long) iArr[2], j);
        AppMethodBeat.o(57694);
    }

    private static void b(int[] iArr, long j) {
        AppMethodBeat.i(57695);
        ab.i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j));
        long j2 = (long) iArr[0];
        eaV.add(new long[]{910, j2, j});
        AppMethodBeat.o(57695);
    }

    public static boolean HM() {
        AppMethodBeat.i(57696);
        if (eaY) {
            boolean z = m2if(256);
            AppMethodBeat.o(57696);
            return z;
        }
        AppMethodBeat.o(57696);
        return false;
    }

    /* renamed from: if */
    private static boolean m2if(int i) {
        AppMethodBeat.i(57697);
        if ((ebd & i) == 0) {
            ebd = (byte) (ebd | i);
            ab.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", Integer.valueOf(i));
            AppMethodBeat.o(57697);
            return true;
        }
        AppMethodBeat.o(57697);
        return false;
    }

    private static void eN(long j) {
        AppMethodBeat.i(57698);
        if (j > 10000) {
            HL();
        }
        AppMethodBeat.o(57698);
    }

    public static void ig(int i) {
        AppMethodBeat.i(57699);
        if (ebb == 0) {
            ab.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
            AppMethodBeat.o(57699);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - ebb;
        switch (i) {
            case 1:
                if (m2if(1)) {
                    a(eaC, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.o(57699);
                    return;
                }
                break;
            case 2:
                if (m2if(2)) {
                    a(eaD, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.o(57699);
                    return;
                }
                break;
            case 3:
                if (m2if(4)) {
                    a(eaE, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.o(57699);
                    return;
                }
                break;
            case 4:
                if (m2if(8)) {
                    a(eaF, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.o(57699);
                    return;
                }
                break;
            case 5:
                if (m2if(16)) {
                    eN(currentTimeMillis);
                    a(eaG, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    AppMethodBeat.o(57699);
                    return;
                }
                break;
            case 6:
                if (m2if(32)) {
                    eN(currentTimeMillis);
                    a(eaH, currentTimeMillis);
                    ebb = System.currentTimeMillis();
                    break;
                }
                break;
        }
        AppMethodBeat.o(57699);
    }

    public static void HN() {
        AppMethodBeat.i(57700);
        long currentTimeMillis = System.currentTimeMillis() - eaZ;
        a(eaI, currentTimeMillis);
        if (currentTimeMillis <= 3000) {
            a(eaJ, 1);
        } else if (currentTimeMillis > 3000 && currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            a(eaK, 1);
        } else if (currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME || currentTimeMillis > 10000) {
            a(eaM, 1);
        } else {
            a(eaL, 1);
        }
        a(eaB, 1);
        currentTimeMillis = SystemClock.elapsedRealtime() - eba;
        b(eaO, currentTimeMillis);
        if (currentTimeMillis <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            b(eaP, 1);
        } else if (currentTimeMillis > FaceGestureDetGLThread.BRIGHTNESS_DURATION && currentTimeMillis <= 4000) {
            b(eaQ, 1);
        } else if (currentTimeMillis > 4000 && currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            b(eaR, 1);
        } else if (currentTimeMillis > ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME && currentTimeMillis <= 8000) {
            b(eaS, 1);
        } else if (currentTimeMillis <= 8000 || currentTimeMillis > 10000) {
            b(eaU, 1);
        } else {
            b(eaT, 1);
        }
        b(eaN, 1);
        ArrayList arrayList = eaW;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(15854);
        objArr[1] = new Object[]{Long.valueOf(currentTimeMillis)};
        arrayList.add(objArr);
        AppMethodBeat.o(57700);
    }

    public static ArrayList<long[]> HO() {
        return eaV;
    }

    public static ArrayList<Object[]> HP() {
        return eaW;
    }

    public static void HL() {
        AppMethodBeat.i(139004);
        m2if(512);
        eaY = false;
        AppMethodBeat.o(139004);
    }
}
