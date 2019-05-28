package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Base64;
import android.view.MotionEvent;
import com.tencent.d.e.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.CountDownLatch;

@Keep
public abstract class Normsg {

    @Keep
    static final class J2CBridge {
        private static native byte[] aa(int i);

        private static native void ab();

        private static native boolean ac();

        private static native String ad(String str, boolean z);

        private static native byte[] ae();

        private static native byte[] af(int i);

        private static native byte[] ag(int i);

        private static native boolean ah();

        private static native boolean ai();

        private static native boolean aj();

        private static native boolean ak();

        private static native String be();

        private static native String bf(int i);

        private static native boolean bg(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray);

        private static native boolean ca(Object obj, Class<?> cls);

        private static native boolean cb(Object obj);

        private static native void da(String str);

        private static native void db(String str);

        private static native void dc(String str);

        private static native boolean dd(String str);

        private static native byte[] de(String str);

        private static native void df(String str, String str2);

        private static native void dg(String str, MotionEvent motionEvent);

        private static native void dh(String str);

        private static native boolean di(String str);

        private static native byte[] dj(String str);

        private J2CBridge() {
        }

        static /* synthetic */ byte[] access$000(int i) {
            AppMethodBeat.i(10275);
            byte[] aa = aa(i);
            AppMethodBeat.o(10275);
            return aa;
        }

        static /* synthetic */ void access$100() {
            AppMethodBeat.i(10276);
            ab();
            AppMethodBeat.o(10276);
        }

        static /* synthetic */ boolean access$1000() {
            AppMethodBeat.i(10285);
            boolean ak = ak();
            AppMethodBeat.o(10285);
            return ak;
        }

        static /* synthetic */ String access$1100() {
            AppMethodBeat.i(10286);
            String be = be();
            AppMethodBeat.o(10286);
            return be;
        }

        static /* synthetic */ String access$1200(int i) {
            AppMethodBeat.i(10287);
            String bf = bf(i);
            AppMethodBeat.o(10287);
            return bf;
        }

        static /* synthetic */ boolean access$1300(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray) {
            AppMethodBeat.i(10288);
            boolean bg = bg(i, bArr, i2, i3, pInt, pInt2, pByteArray);
            AppMethodBeat.o(10288);
            return bg;
        }

        static /* synthetic */ boolean access$1400(Object obj, Class cls) {
            AppMethodBeat.i(10289);
            boolean ca = ca(obj, cls);
            AppMethodBeat.o(10289);
            return ca;
        }

        static /* synthetic */ boolean access$1500(Object obj) {
            AppMethodBeat.i(10290);
            boolean cb = cb(obj);
            AppMethodBeat.o(10290);
            return cb;
        }

        static /* synthetic */ void access$1600(String str) {
            AppMethodBeat.i(10291);
            da(str);
            AppMethodBeat.o(10291);
        }

        static /* synthetic */ void access$1700(String str) {
            AppMethodBeat.i(10292);
            db(str);
            AppMethodBeat.o(10292);
        }

        static /* synthetic */ void access$1800(String str) {
            AppMethodBeat.i(10293);
            dc(str);
            AppMethodBeat.o(10293);
        }

        static /* synthetic */ boolean access$1900(String str) {
            AppMethodBeat.i(10294);
            boolean dd = dd(str);
            AppMethodBeat.o(10294);
            return dd;
        }

        static /* synthetic */ boolean access$200() {
            AppMethodBeat.i(10277);
            boolean ac = ac();
            AppMethodBeat.o(10277);
            return ac;
        }

        static /* synthetic */ byte[] access$2000(String str) {
            AppMethodBeat.i(10295);
            byte[] de = de(str);
            AppMethodBeat.o(10295);
            return de;
        }

        static /* synthetic */ void access$2100(String str, String str2) {
            AppMethodBeat.i(10296);
            df(str, str2);
            AppMethodBeat.o(10296);
        }

        static /* synthetic */ void access$2200(String str, MotionEvent motionEvent) {
            AppMethodBeat.i(10297);
            dg(str, motionEvent);
            AppMethodBeat.o(10297);
        }

        static /* synthetic */ void access$2300(String str) {
            AppMethodBeat.i(10298);
            dh(str);
            AppMethodBeat.o(10298);
        }

        static /* synthetic */ boolean access$2400(String str) {
            AppMethodBeat.i(10299);
            boolean di = di(str);
            AppMethodBeat.o(10299);
            return di;
        }

        static /* synthetic */ byte[] access$2500(String str) {
            AppMethodBeat.i(10300);
            byte[] dj = dj(str);
            AppMethodBeat.o(10300);
            return dj;
        }

        static /* synthetic */ String access$300(String str, boolean z) {
            AppMethodBeat.i(10278);
            String ad = ad(str, z);
            AppMethodBeat.o(10278);
            return ad;
        }

        static /* synthetic */ byte[] access$400() {
            AppMethodBeat.i(10279);
            byte[] ae = ae();
            AppMethodBeat.o(10279);
            return ae;
        }

        static /* synthetic */ byte[] access$500(int i) {
            AppMethodBeat.i(10280);
            byte[] af = af(i);
            AppMethodBeat.o(10280);
            return af;
        }

        static /* synthetic */ byte[] access$600(int i) {
            AppMethodBeat.i(10281);
            byte[] ag = ag(i);
            AppMethodBeat.o(10281);
            return ag;
        }

        static /* synthetic */ boolean access$700() {
            AppMethodBeat.i(10282);
            boolean ah = ah();
            AppMethodBeat.o(10282);
            return ah;
        }

        static /* synthetic */ boolean access$800() {
            AppMethodBeat.i(10283);
            boolean ai = ai();
            AppMethodBeat.o(10283);
            return ai;
        }

        static /* synthetic */ boolean access$900() {
            AppMethodBeat.i(10284);
            boolean aj = aj();
            AppMethodBeat.o(10284);
            return aj;
        }
    }

    public static final class a extends Normsg {
        public static String bVH() {
            AppMethodBeat.i(10262);
            String access$1100 = J2CBridge.access$1100();
            AppMethodBeat.o(10262);
            return access$1100;
        }

        public static String Ai(int i) {
            AppMethodBeat.i(10263);
            String access$1200 = J2CBridge.access$1200(i);
            AppMethodBeat.o(10263);
            return access$1200;
        }

        public static boolean a(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray) {
            AppMethodBeat.i(10264);
            boolean access$1300 = J2CBridge.access$1300(i, bArr, i2, i3, pInt, pInt2, pByteArray);
            AppMethodBeat.o(10264);
            return access$1300;
        }
    }

    public static final class b extends Normsg {
        public static byte[] Aj(int i) {
            AppMethodBeat.i(10265);
            byte[] access$000 = J2CBridge.access$000(i);
            AppMethodBeat.o(10265);
            return access$000;
        }

        public static boolean bVI() {
            AppMethodBeat.i(10266);
            boolean access$200 = J2CBridge.access$200();
            AppMethodBeat.o(10266);
            return access$200;
        }

        public static String aZ(String str, boolean z) {
            AppMethodBeat.i(10267);
            String access$300 = J2CBridge.access$300(str, z);
            AppMethodBeat.o(10267);
            return access$300;
        }

        public static byte[] bVJ() {
            AppMethodBeat.i(10268);
            byte[] access$400 = J2CBridge.access$400();
            AppMethodBeat.o(10268);
            return access$400;
        }

        public static byte[] Ak(int i) {
            AppMethodBeat.i(10269);
            byte[] access$500 = J2CBridge.access$500(i);
            AppMethodBeat.o(10269);
            return access$500;
        }

        public static byte[] Al(int i) {
            AppMethodBeat.i(10270);
            byte[] access$600 = J2CBridge.access$600(i);
            AppMethodBeat.o(10270);
            return access$600;
        }

        public static boolean bVK() {
            AppMethodBeat.i(10271);
            boolean access$700 = J2CBridge.access$700();
            AppMethodBeat.o(10271);
            return access$700;
        }

        public static boolean bVL() {
            AppMethodBeat.i(10272);
            boolean access$800 = J2CBridge.access$800();
            AppMethodBeat.o(10272);
            return access$800;
        }

        public static boolean bVM() {
            AppMethodBeat.i(10273);
            boolean access$900 = J2CBridge.access$900();
            AppMethodBeat.o(10273);
            return access$900;
        }

        public static boolean bVN() {
            AppMethodBeat.i(10274);
            boolean access$1000 = J2CBridge.access$1000();
            AppMethodBeat.o(10274);
            return access$1000;
        }
    }

    @Keep
    static final class C2JBridge {
        private C2JBridge() {
        }

        @Keep
        private static String c1() {
            AppMethodBeat.i(10255);
            String str = "";
            Bundle bN = com.tencent.mm.lib.riskscanner.a.a.bN(ah.getContext());
            if (bN != null && bN.getInt("errCode", -100) == 0) {
                byte[] byteArray = bN.getByteArray("reqBufferBase64");
                if (byteArray != null) {
                    str = Base64.encodeToString(byteArray, 2);
                }
            }
            AppMethodBeat.o(10255);
            return str;
        }

        @Keep
        private static long c2() {
            AppMethodBeat.i(10256);
            long bVU = com.tencent.mm.plugin.normsg.b.a.bVT().bVU();
            AppMethodBeat.o(10256);
            return bVU;
        }

        @Keep
        private static void c3(int i, String str) {
            AppMethodBeat.i(10257);
            h.pYm.X(i, str);
            AppMethodBeat.o(10257);
        }

        @Keep
        private static void c4(int i, int i2, int i3) {
            AppMethodBeat.i(10258);
            h.pYm.k((long) i, (long) i2, (long) i3);
            AppMethodBeat.o(10258);
        }

        @Keep
        private static void c5(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(10259);
            h.pYm.d(i, i2, i3, i4, false);
            AppMethodBeat.o(10259);
        }

        @Keep
        private static String c6() {
            AppMethodBeat.i(10260);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String[] strArr = new String[]{""};
            e.dQs().EH();
            Context context = ah.getContext();
            e.dQs().a(context, q.LK(), new com.tencent.d.a.d.AnonymousClass1(new com.tencent.d.a.b() {
                public final boolean m(int i, byte[] bArr) {
                    boolean z = false;
                    AppMethodBeat.i(10254);
                    if (i == 0) {
                        strArr[0] = Base64.encodeToString(bArr, 2);
                        z = true;
                    }
                    countDownLatch.countDown();
                    AppMethodBeat.o(10254);
                    return z;
                }
            }, new com.tencent.d.b.c(context)));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
            }
            String str = strArr[0];
            AppMethodBeat.o(10260);
            return str;
        }

        @Keep
        private static String c7() {
            AppMethodBeat.i(10261);
            String str = com.tencent.mm.plugin.soter.d.d.cvQ().rOh;
            if (str != null) {
                AppMethodBeat.o(10261);
                return str;
            }
            str = "";
            AppMethodBeat.o(10261);
            return str;
        }
    }

    public static final class d extends Normsg {
        public static boolean b(Object obj, Class<?> cls) {
            AppMethodBeat.i(10311);
            boolean access$1400 = J2CBridge.access$1400(obj, cls);
            AppMethodBeat.o(10311);
            return access$1400;
        }

        public static boolean cg(Object obj) {
            AppMethodBeat.i(10312);
            boolean access$1500 = J2CBridge.access$1500(obj);
            AppMethodBeat.o(10312);
            return access$1500;
        }
    }

    public static final class c extends Normsg {
        public static void TI(String str) {
            AppMethodBeat.i(10301);
            J2CBridge.access$1600(str);
            AppMethodBeat.o(10301);
        }

        public static void TJ(String str) {
            AppMethodBeat.i(10302);
            J2CBridge.access$1700(str);
            AppMethodBeat.o(10302);
        }

        public static void TK(String str) {
            AppMethodBeat.i(10303);
            J2CBridge.access$1800(str);
            AppMethodBeat.o(10303);
        }

        public static boolean TL(String str) {
            AppMethodBeat.i(10304);
            boolean access$1900 = J2CBridge.access$1900(str);
            AppMethodBeat.o(10304);
            return access$1900;
        }

        public static byte[] TM(String str) {
            AppMethodBeat.i(10305);
            byte[] access$2000 = J2CBridge.access$2000(str);
            AppMethodBeat.o(10305);
            return access$2000;
        }

        public static void fu(String str, String str2) {
            AppMethodBeat.i(10306);
            J2CBridge.access$2100(str, str2);
            AppMethodBeat.o(10306);
        }

        public static void a(String str, MotionEvent motionEvent) {
            AppMethodBeat.i(10307);
            J2CBridge.access$2200(str, motionEvent);
            AppMethodBeat.o(10307);
        }

        public static void TN(String str) {
            AppMethodBeat.i(10308);
            J2CBridge.access$2300(str);
            AppMethodBeat.o(10308);
        }

        public static boolean TO(String str) {
            AppMethodBeat.i(10309);
            boolean access$2400 = J2CBridge.access$2400(str);
            AppMethodBeat.o(10309);
            return access$2400;
        }

        public static byte[] TP(String str) {
            AppMethodBeat.i(10310);
            byte[] access$2500 = J2CBridge.access$2500(str);
            AppMethodBeat.o(10310);
            return access$2500;
        }
    }

    static {
        initializeOnMainThread();
    }

    private static final void initializeOnMainThread() {
        final boolean[] zArr = new boolean[]{false};
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(10253);
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
                        AppMethodBeat.o(10253);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass1.run();
            return;
        }
        com.tencent.mm.sdk.g.d.h(anonymousClass1, "NormsgInit").start();
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
