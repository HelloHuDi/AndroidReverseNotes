package com.tencent.p177mm.plugin.normsg;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Base64;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p1164a.C17725d.C177241;
import com.tencent.p127d.p1164a.C41660b;
import com.tencent.p127d.p132e.p133a.C41668e;
import com.tencent.p127d.p807b.C8760c;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.lib.riskscanner.p1533a.C37876a;
import com.tencent.p177mm.plugin.normsg.p474b.C21384a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.concurrent.CountDownLatch;

@Keep
/* renamed from: com.tencent.mm.plugin.normsg.Normsg */
public abstract class Normsg {

    @Keep
    /* renamed from: com.tencent.mm.plugin.normsg.Normsg$J2CBridge */
    static final class J2CBridge {
        /* renamed from: aa */
        private static native byte[] m5846aa(int i);

        /* renamed from: ab */
        private static native void m5847ab();

        /* renamed from: ac */
        private static native boolean m5848ac();

        /* renamed from: ad */
        private static native String m5849ad(String str, boolean z);

        /* renamed from: ae */
        private static native byte[] m5850ae();

        /* renamed from: af */
        private static native byte[] m5851af(int i);

        /* renamed from: ag */
        private static native byte[] m5852ag(int i);

        /* renamed from: ah */
        private static native boolean m5853ah();

        /* renamed from: ai */
        private static native boolean m5854ai();

        /* renamed from: aj */
        private static native boolean m5855aj();

        /* renamed from: ak */
        private static native boolean m5856ak();

        /* renamed from: be */
        private static native String m5857be();

        /* renamed from: bf */
        private static native String m5858bf(int i);

        /* renamed from: bg */
        private static native boolean m5859bg(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray);

        /* renamed from: ca */
        private static native boolean m5860ca(Object obj, Class<?> cls);

        /* renamed from: cb */
        private static native boolean m5861cb(Object obj);

        /* renamed from: da */
        private static native void m5862da(String str);

        /* renamed from: db */
        private static native void m5863db(String str);

        /* renamed from: dc */
        private static native void m5864dc(String str);

        /* renamed from: dd */
        private static native boolean m5865dd(String str);

        /* renamed from: de */
        private static native byte[] m5866de(String str);

        /* renamed from: df */
        private static native void m5867df(String str, String str2);

        /* renamed from: dg */
        private static native void m5868dg(String str, MotionEvent motionEvent);

        /* renamed from: dh */
        private static native void m5869dh(String str);

        /* renamed from: di */
        private static native boolean m5870di(String str);

        /* renamed from: dj */
        private static native byte[] m5871dj(String str);

        private J2CBridge() {
        }

        static /* synthetic */ byte[] access$000(int i) {
            AppMethodBeat.m2504i(10275);
            byte[] aa = J2CBridge.m5846aa(i);
            AppMethodBeat.m2505o(10275);
            return aa;
        }

        static /* synthetic */ void access$100() {
            AppMethodBeat.m2504i(10276);
            J2CBridge.m5847ab();
            AppMethodBeat.m2505o(10276);
        }

        static /* synthetic */ boolean access$1000() {
            AppMethodBeat.m2504i(10285);
            boolean ak = J2CBridge.m5856ak();
            AppMethodBeat.m2505o(10285);
            return ak;
        }

        static /* synthetic */ String access$1100() {
            AppMethodBeat.m2504i(10286);
            String be = J2CBridge.m5857be();
            AppMethodBeat.m2505o(10286);
            return be;
        }

        static /* synthetic */ String access$1200(int i) {
            AppMethodBeat.m2504i(10287);
            String bf = J2CBridge.m5858bf(i);
            AppMethodBeat.m2505o(10287);
            return bf;
        }

        static /* synthetic */ boolean access$1300(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray) {
            AppMethodBeat.m2504i(10288);
            boolean bg = J2CBridge.m5859bg(i, bArr, i2, i3, pInt, pInt2, pByteArray);
            AppMethodBeat.m2505o(10288);
            return bg;
        }

        static /* synthetic */ boolean access$1400(Object obj, Class cls) {
            AppMethodBeat.m2504i(10289);
            boolean ca = J2CBridge.m5860ca(obj, cls);
            AppMethodBeat.m2505o(10289);
            return ca;
        }

        static /* synthetic */ boolean access$1500(Object obj) {
            AppMethodBeat.m2504i(10290);
            boolean cb = J2CBridge.m5861cb(obj);
            AppMethodBeat.m2505o(10290);
            return cb;
        }

        static /* synthetic */ void access$1600(String str) {
            AppMethodBeat.m2504i(10291);
            J2CBridge.m5862da(str);
            AppMethodBeat.m2505o(10291);
        }

        static /* synthetic */ void access$1700(String str) {
            AppMethodBeat.m2504i(10292);
            J2CBridge.m5863db(str);
            AppMethodBeat.m2505o(10292);
        }

        static /* synthetic */ void access$1800(String str) {
            AppMethodBeat.m2504i(10293);
            J2CBridge.m5864dc(str);
            AppMethodBeat.m2505o(10293);
        }

        static /* synthetic */ boolean access$1900(String str) {
            AppMethodBeat.m2504i(10294);
            boolean dd = J2CBridge.m5865dd(str);
            AppMethodBeat.m2505o(10294);
            return dd;
        }

        static /* synthetic */ boolean access$200() {
            AppMethodBeat.m2504i(10277);
            boolean ac = J2CBridge.m5848ac();
            AppMethodBeat.m2505o(10277);
            return ac;
        }

        static /* synthetic */ byte[] access$2000(String str) {
            AppMethodBeat.m2504i(10295);
            byte[] de = J2CBridge.m5866de(str);
            AppMethodBeat.m2505o(10295);
            return de;
        }

        static /* synthetic */ void access$2100(String str, String str2) {
            AppMethodBeat.m2504i(10296);
            J2CBridge.m5867df(str, str2);
            AppMethodBeat.m2505o(10296);
        }

        static /* synthetic */ void access$2200(String str, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(10297);
            J2CBridge.m5868dg(str, motionEvent);
            AppMethodBeat.m2505o(10297);
        }

        static /* synthetic */ void access$2300(String str) {
            AppMethodBeat.m2504i(10298);
            J2CBridge.m5869dh(str);
            AppMethodBeat.m2505o(10298);
        }

        static /* synthetic */ boolean access$2400(String str) {
            AppMethodBeat.m2504i(10299);
            boolean di = J2CBridge.m5870di(str);
            AppMethodBeat.m2505o(10299);
            return di;
        }

        static /* synthetic */ byte[] access$2500(String str) {
            AppMethodBeat.m2504i(10300);
            byte[] dj = J2CBridge.m5871dj(str);
            AppMethodBeat.m2505o(10300);
            return dj;
        }

        static /* synthetic */ String access$300(String str, boolean z) {
            AppMethodBeat.m2504i(10278);
            String ad = J2CBridge.m5849ad(str, z);
            AppMethodBeat.m2505o(10278);
            return ad;
        }

        static /* synthetic */ byte[] access$400() {
            AppMethodBeat.m2504i(10279);
            byte[] ae = J2CBridge.m5850ae();
            AppMethodBeat.m2505o(10279);
            return ae;
        }

        static /* synthetic */ byte[] access$500(int i) {
            AppMethodBeat.m2504i(10280);
            byte[] af = J2CBridge.m5851af(i);
            AppMethodBeat.m2505o(10280);
            return af;
        }

        static /* synthetic */ byte[] access$600(int i) {
            AppMethodBeat.m2504i(10281);
            byte[] ag = J2CBridge.m5852ag(i);
            AppMethodBeat.m2505o(10281);
            return ag;
        }

        static /* synthetic */ boolean access$700() {
            AppMethodBeat.m2504i(10282);
            boolean ah = J2CBridge.m5853ah();
            AppMethodBeat.m2505o(10282);
            return ah;
        }

        static /* synthetic */ boolean access$800() {
            AppMethodBeat.m2504i(10283);
            boolean ai = J2CBridge.m5854ai();
            AppMethodBeat.m2505o(10283);
            return ai;
        }

        static /* synthetic */ boolean access$900() {
            AppMethodBeat.m2504i(10284);
            boolean aj = J2CBridge.m5855aj();
            AppMethodBeat.m2505o(10284);
            return aj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.Normsg$a */
    public static final class C12721a extends Normsg {
        public static String bVH() {
            AppMethodBeat.m2504i(10262);
            String access$1100 = J2CBridge.access$1100();
            AppMethodBeat.m2505o(10262);
            return access$1100;
        }

        /* renamed from: Ai */
        public static String m20741Ai(int i) {
            AppMethodBeat.m2504i(10263);
            String access$1200 = J2CBridge.access$1200(i);
            AppMethodBeat.m2505o(10263);
            return access$1200;
        }

        /* renamed from: a */
        public static boolean m20742a(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray) {
            AppMethodBeat.m2504i(10264);
            boolean access$1300 = J2CBridge.access$1300(i, bArr, i2, i3, pInt, pInt2, pByteArray);
            AppMethodBeat.m2505o(10264);
            return access$1300;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.Normsg$b */
    public static final class C21379b extends Normsg {
        /* renamed from: Aj */
        public static byte[] m32780Aj(int i) {
            AppMethodBeat.m2504i(10265);
            byte[] access$000 = J2CBridge.access$000(i);
            AppMethodBeat.m2505o(10265);
            return access$000;
        }

        public static boolean bVI() {
            AppMethodBeat.m2504i(10266);
            boolean access$200 = J2CBridge.access$200();
            AppMethodBeat.m2505o(10266);
            return access$200;
        }

        /* renamed from: aZ */
        public static String m32783aZ(String str, boolean z) {
            AppMethodBeat.m2504i(10267);
            String access$300 = J2CBridge.access$300(str, z);
            AppMethodBeat.m2505o(10267);
            return access$300;
        }

        public static byte[] bVJ() {
            AppMethodBeat.m2504i(10268);
            byte[] access$400 = J2CBridge.access$400();
            AppMethodBeat.m2505o(10268);
            return access$400;
        }

        /* renamed from: Ak */
        public static byte[] m32781Ak(int i) {
            AppMethodBeat.m2504i(10269);
            byte[] access$500 = J2CBridge.access$500(i);
            AppMethodBeat.m2505o(10269);
            return access$500;
        }

        /* renamed from: Al */
        public static byte[] m32782Al(int i) {
            AppMethodBeat.m2504i(10270);
            byte[] access$600 = J2CBridge.access$600(i);
            AppMethodBeat.m2505o(10270);
            return access$600;
        }

        public static boolean bVK() {
            AppMethodBeat.m2504i(10271);
            boolean access$700 = J2CBridge.access$700();
            AppMethodBeat.m2505o(10271);
            return access$700;
        }

        public static boolean bVL() {
            AppMethodBeat.m2504i(10272);
            boolean access$800 = J2CBridge.access$800();
            AppMethodBeat.m2505o(10272);
            return access$800;
        }

        public static boolean bVM() {
            AppMethodBeat.m2504i(10273);
            boolean access$900 = J2CBridge.access$900();
            AppMethodBeat.m2505o(10273);
            return access$900;
        }

        public static boolean bVN() {
            AppMethodBeat.m2504i(10274);
            boolean access$1000 = J2CBridge.access$1000();
            AppMethodBeat.m2505o(10274);
            return access$1000;
        }
    }

    @Keep
    /* renamed from: com.tencent.mm.plugin.normsg.Normsg$C2JBridge */
    static final class C2JBridge {
        private C2JBridge() {
        }

        @Keep
        /* renamed from: c1 */
        private static String m32784c1() {
            AppMethodBeat.m2504i(10255);
            String str = "";
            Bundle bN = C37876a.m63921bN(C4996ah.getContext());
            if (bN != null && bN.getInt("errCode", -100) == 0) {
                byte[] byteArray = bN.getByteArray("reqBufferBase64");
                if (byteArray != null) {
                    str = Base64.encodeToString(byteArray, 2);
                }
            }
            AppMethodBeat.m2505o(10255);
            return str;
        }

        @Keep
        /* renamed from: c2 */
        private static long m32785c2() {
            AppMethodBeat.m2504i(10256);
            long bVU = C21384a.bVT().bVU();
            AppMethodBeat.m2505o(10256);
            return bVU;
        }

        @Keep
        /* renamed from: c3 */
        private static void m32786c3(int i, String str) {
            AppMethodBeat.m2504i(10257);
            C7060h.pYm.mo8374X(i, str);
            AppMethodBeat.m2505o(10257);
        }

        @Keep
        /* renamed from: c4 */
        private static void m32787c4(int i, int i2, int i3) {
            AppMethodBeat.m2504i(10258);
            C7060h.pYm.mo15419k((long) i, (long) i2, (long) i3);
            AppMethodBeat.m2505o(10258);
        }

        @Keep
        /* renamed from: c5 */
        private static void m32788c5(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(10259);
            C7060h.pYm.mo8380d(i, i2, i3, i4, false);
            AppMethodBeat.m2505o(10259);
        }

        @Keep
        /* renamed from: c6 */
        private static String m32789c6() {
            AppMethodBeat.m2504i(10260);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String[] strArr = new String[]{""};
            C41668e.dQs().mo67143EH();
            Context context = C4996ah.getContext();
            C41668e.dQs().mo67144a(context, C1427q.m3026LK(), new C177241(new C41660b() {
                /* renamed from: m */
                public final boolean mo8081m(int i, byte[] bArr) {
                    boolean z = false;
                    AppMethodBeat.m2504i(10254);
                    if (i == 0) {
                        strArr[0] = Base64.encodeToString(bArr, 2);
                        z = true;
                    }
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(10254);
                    return z;
                }
            }, new C8760c(context)));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
            }
            String str = strArr[0];
            AppMethodBeat.m2505o(10260);
            return str;
        }

        @Keep
        /* renamed from: c7 */
        private static String m32790c7() {
            AppMethodBeat.m2504i(10261);
            String str = C13720d.cvQ().rOh;
            if (str != null) {
                AppMethodBeat.m2505o(10261);
                return str;
            }
            str = "";
            AppMethodBeat.m2505o(10261);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.Normsg$d */
    public static final class C21380d extends Normsg {
        /* renamed from: b */
        public static boolean m32791b(Object obj, Class<?> cls) {
            AppMethodBeat.m2504i(10311);
            boolean access$1400 = J2CBridge.access$1400(obj, cls);
            AppMethodBeat.m2505o(10311);
            return access$1400;
        }

        /* renamed from: cg */
        public static boolean m32792cg(Object obj) {
            AppMethodBeat.m2504i(10312);
            boolean access$1500 = J2CBridge.access$1500(obj);
            AppMethodBeat.m2505o(10312);
            return access$1500;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.Normsg$c */
    public static final class C21381c extends Normsg {
        /* renamed from: TI */
        public static void m32793TI(String str) {
            AppMethodBeat.m2504i(10301);
            J2CBridge.access$1600(str);
            AppMethodBeat.m2505o(10301);
        }

        /* renamed from: TJ */
        public static void m32794TJ(String str) {
            AppMethodBeat.m2504i(10302);
            J2CBridge.access$1700(str);
            AppMethodBeat.m2505o(10302);
        }

        /* renamed from: TK */
        public static void m32795TK(String str) {
            AppMethodBeat.m2504i(10303);
            J2CBridge.access$1800(str);
            AppMethodBeat.m2505o(10303);
        }

        /* renamed from: TL */
        public static boolean m32796TL(String str) {
            AppMethodBeat.m2504i(10304);
            boolean access$1900 = J2CBridge.access$1900(str);
            AppMethodBeat.m2505o(10304);
            return access$1900;
        }

        /* renamed from: TM */
        public static byte[] m32797TM(String str) {
            AppMethodBeat.m2504i(10305);
            byte[] access$2000 = J2CBridge.access$2000(str);
            AppMethodBeat.m2505o(10305);
            return access$2000;
        }

        /* renamed from: fu */
        public static void m32802fu(String str, String str2) {
            AppMethodBeat.m2504i(10306);
            J2CBridge.access$2100(str, str2);
            AppMethodBeat.m2505o(10306);
        }

        /* renamed from: a */
        public static void m32801a(String str, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(10307);
            J2CBridge.access$2200(str, motionEvent);
            AppMethodBeat.m2505o(10307);
        }

        /* renamed from: TN */
        public static void m32798TN(String str) {
            AppMethodBeat.m2504i(10308);
            J2CBridge.access$2300(str);
            AppMethodBeat.m2505o(10308);
        }

        /* renamed from: TO */
        public static boolean m32799TO(String str) {
            AppMethodBeat.m2504i(10309);
            boolean access$2400 = J2CBridge.access$2400(str);
            AppMethodBeat.m2505o(10309);
            return access$2400;
        }

        /* renamed from: TP */
        public static byte[] m32800TP(String str) {
            AppMethodBeat.m2504i(10310);
            byte[] access$2500 = J2CBridge.access$2500(str);
            AppMethodBeat.m2505o(10310);
            return access$2500;
        }
    }

    static {
        Normsg.initializeOnMainThread();
    }

    private static final void initializeOnMainThread() {
        final boolean[] zArr = new boolean[]{false};
        Runnable c213821 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(10253);
                synchronized (zArr) {
                    try {
                        System.loadLibrary("stlport_shared");
                        System.loadLibrary("wechatxlog");
                        System.loadLibrary("wechatnormsg");
                        zArr[0] = true;
                        zArr.notifyAll();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(10253);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c213821.run();
            return;
        }
        C7305d.m12301h(c213821, "NormsgInit").start();
        synchronized (zArr) {
            while (!zArr[0]) {
                try {
                    zArr.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
