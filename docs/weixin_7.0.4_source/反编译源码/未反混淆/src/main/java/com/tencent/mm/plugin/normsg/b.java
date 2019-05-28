package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.d.e.a.a.f;
import com.tencent.d.e.a.d;
import com.tencent.d.e.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.a.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mrs.b.c;
import java.io.File;
import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

enum b implements a {
    ;
    
    private static final al oTF = null;

    private b(String str) {
    }

    static {
        oTF = new al("NormsgWorker");
        AppMethodBeat.o(10349);
    }

    public final byte[] Am(int i) {
        AppMethodBeat.i(10317);
        byte[] Aj = com.tencent.mm.plugin.normsg.Normsg.b.Aj(i);
        AppMethodBeat.o(10317);
        return Aj;
    }

    public final void ae(int i, int i2, int i3) {
        AppMethodBeat.i(10318);
        Context context = ah.getContext();
        if (i2 <= 0 || i2 > 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("action invalid: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(10318);
            throw illegalArgumentException;
        }
        d.a aVar = new d.a(context, i, i2, (byte) 0);
        long j = (long) (i3 * 1000);
        if (j < f.AtJ) {
            aVar.Ato = f.AtJ;
        } else if (j > f.AtG * 12) {
            aVar.Ato = f.AtG * 12;
        }
        aVar.Ato = j;
        e.dQs().a(new d(aVar, (byte) 0));
        AppMethodBeat.o(10318);
    }

    public final String TQ(String str) {
        AppMethodBeat.i(10319);
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ((str.charAt(i) ^ -89) ^ ((byte) (((i + 1) ^ length) ^ -1))));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(10319);
        return stringBuilder2;
    }

    private static String bVO() {
        AppMethodBeat.i(10320);
        String LL;
        if (new c().get("clicfg_use_new_cached_imei_method", false)) {
            LL = q.LL();
            AppMethodBeat.o(10320);
            return LL;
        }
        LL = q.LK();
        AppMethodBeat.o(10320);
        return LL;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x04a5  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x04ab  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x03cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String An(int i) {
        Object obj;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        byte[] bVJ;
        String v;
        int versionCode;
        String eK;
        Map Ma;
        StringBuilder stringBuilder;
        StringBuilder append;
        StringBuilder append2;
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(10321);
        String str = "";
        if (g.RK()) {
            str = (String) g.RP().Ry().get(79, (Object) "");
        }
        g.RS().m(new Runnable() {
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing block: B:16:0x013e, code skipped:
            r0 = move-exception;
     */
            /* JADX WARNING: Missing block: B:17:0x013f, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NormsgSourceImpl", "exception:%s", com.tencent.mm.sdk.platformtools.bo.l(r0));
     */
            /* JADX WARNING: Missing block: B:18:0x0152, code skipped:
            r0 = r1;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(10313);
                if (g.RK()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str = ah.getContext().getApplicationInfo().sourceDir;
                    g.RN();
                    byte[] Ak = com.tencent.mm.plugin.normsg.Normsg.b.Ak(com.tencent.mm.kernel.a.QF());
                    g.RN();
                    byte[] Al = com.tencent.mm.plugin.normsg.Normsg.b.Al(com.tencent.mm.kernel.a.QF());
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    String format = String.format("<k25>%s</k25>", new Object[]{com.tencent.mm.plugin.normsg.b.d.v(Ak, 0, Ak.length)});
                    if (Al != null) {
                        if (Al.length == 8) {
                            byte b = Al[0];
                            Al[0] = Al[3];
                            Al[3] = b;
                            b = Al[1];
                            Al[1] = Al[2];
                            Al[2] = b;
                            b = Al[4];
                            Al[4] = Al[7];
                            Al[7] = b;
                            b = Al[5];
                            Al[5] = Al[6];
                            Al[6] = b;
                            format = format + String.format("<k28>%s</k28><k29>%s</k29>", new Object[]{com.tencent.mm.plugin.normsg.b.d.v(Al, 0, 4), com.tencent.mm.plugin.normsg.b.d.v(Al, 4, 8)});
                        } else {
                            format = format + String.format("<k27>%s</k27>", new Object[]{com.tencent.mm.plugin.normsg.b.d.v(Al, 0, Al.length)});
                        }
                    }
                    try {
                        String hostAddress = Inet4Address.getByName("mp.weixin.qq.com").getHostAddress();
                        Object obj = format + String.format("<k32>%s</k32>", new Object[]{bo.nullAsNil(hostAddress)});
                        ab.i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + currentTimeMillis2 + ", value: " + obj + "]");
                        g.RP().Ry().set(79, obj);
                        AppMethodBeat.o(10313);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.NormsgSourceImpl", e, "Failed checkSoftType2.", new Object[0]);
                        AppMethodBeat.o(10313);
                        return;
                    }
                }
                AppMethodBeat.o(10313);
            }

            public final String toString() {
                AppMethodBeat.i(10314);
                String str = super.toString() + "|checkSoftTypeExtra";
                AppMethodBeat.o(10314);
                return str;
            }
        }, 5000);
        String str2 = "";
        if (g.RK()) {
            str2 = g.RP().eJN.ybP.ybm ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        Context applicationContext = ah.getContext().getApplicationContext();
        String gE = at.gE(applicationContext);
        String gF = at.gF(applicationContext);
        Context context = ah.getContext();
        if (context == null) {
            ab.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
        } else if (Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
            obj = 1;
            i2 = obj == null ? 1 : 0;
            i3 = com.tencent.mm.plugin.normsg.Normsg.b.bVI() ? 1 : 0;
            i4 = Debug.isDebuggerConnected() ? 1 : 0;
            i5 = (com.tencent.mm.plugin.normsg.b.f.oVf || com.tencent.mm.plugin.normsg.b.f.oVg || com.tencent.mm.plugin.normsg.b.f.oVh) ? 1 : 0;
            i6 = com.tencent.mm.plugin.normsg.b.e.oVb ? 1 : 0;
            i7 = com.tencent.mm.plugin.normsg.b.g.oVi ? 1 : 0;
            bVJ = com.tencent.mm.plugin.normsg.Normsg.b.bVJ();
            v = bVJ == null ? com.tencent.mm.plugin.normsg.b.d.v(bVJ, 0, bVJ.length) : "";
            versionCode = getVersionCode();
            eK = eK(versionCode, i);
            Ma = q.Ma();
            stringBuilder = new StringBuilder();
            append = stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>");
            str = (String) Ma.get("model name");
            if (str == null) {
                str = q.LT()[0];
            }
            append = append.append(TR(str)).append("</k1><k2>").append(TR(q.LV())).append("</k2><k3>").append(TR(q.LW())).append("</k3><k4>").append(TR(bVO())).append("</k4><k5>").append(TR(q.LX())).append("</k5><k6>").append(TR(q.LY())).append("</k6><k7>").append(TR(q.getAndroidId())).append("</k7><k8>").append(TR(q.LZ())).append("</k8><k9>").append(TR(q.LS())).append("</k9><k10>").append(q.Mb()).append("</k10><k11>").append(bo.nullAsNil(TR((String) Ma.get("hardware")))).append("</k11><k12>").append(bo.nullAsNil(TR((String) Ma.get("revision")))).append("</k12><k13>").append(bo.nullAsNil(TR((String) Ma.get("serial")))).append("</k13><k14>").append(TR(q.LP())).append("</k14><k15>").append(TR(q.LU())).append("</k15><k16>");
            str = (String) Ma.get("features");
            if (str == null) {
                str = (String) Ma.get("flags");
            }
            append2 = append.append(bo.nullAsNil(TR(str))).append("</k16><k18>").append(v).append("</k18><k21>").append(bo.nullAsNil(TR(gE))).append("</k21><k22>").append(bo.nullAsNil(TR(q.bC(applicationContext)))).append("</k22><k24>").append(bo.nullAsNil(TR(gF))).append("</k24><k26>").append(i4).append("</k26><k30>");
            activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = activeNetworkInfo.getExtraInfo();
            } else {
                str = null;
            }
            append = append2.append(bo.nullAsNil(TR(str))).append("</k30><k33>").append(TR(ah.getPackageName())).append("</k33><k34>").append(bo.nullAsNil(TR(com.tencent.mm.compatible.e.ab.get("ro.build.fingerprint")))).append("</k34><k35>").append(bo.nullAsNil(TR(Build.BOARD))).append("</k35><k36>").append(bo.nullAsNil(TR(Build.BOOTLOADER))).append("</k36><k37>").append(bo.nullAsNil(TR(Build.BRAND))).append("</k37><k38>").append(bo.nullAsNil(TR(Build.DEVICE))).append("</k38><k39>").append(bo.nullAsNil(TR(Build.HARDWARE))).append("</k39><k40>").append(bo.nullAsNil(TR(Build.PRODUCT))).append("</k40><k41>").append(i5).append("</k41><k42>").append(bo.nullAsNil(TR(com.tencent.mm.compatible.e.ab.get("ro.product.manufacturer")))).append("</k42><k43>").append(System.getString(ah.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
            str = bo.nullAsNil(bo.gP(ah.getContext()));
            if (str.length() > 0) {
                str = com.tencent.mm.a.g.x(str.getBytes());
            }
            append.append(str).append("</k45><k46>").append(str2).append("</k46><k47>").append(TR(bVP())).append("</k47><k48>").append(bVO()).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.eSi).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(bo.nullAsNil(TR(eK))).append("</k58><k59>").append(i).append("</k59><k60>").append(TR(com.tencent.mm.sdk.platformtools.f.xxZ.getString("FEATURE_ID"))).append("</k60><k61>").append(q.LN()).append("</k61></softtype>");
            str = stringBuilder.toString();
            AppMethodBeat.o(10321);
            return str;
        }
        obj = null;
        if (obj == null) {
        }
        if (com.tencent.mm.plugin.normsg.Normsg.b.bVI()) {
        }
        if (Debug.isDebuggerConnected()) {
        }
        if (!com.tencent.mm.plugin.normsg.b.f.oVf) {
        }
        if (com.tencent.mm.plugin.normsg.b.e.oVb) {
        }
        if (com.tencent.mm.plugin.normsg.b.g.oVi) {
        }
        bVJ = com.tencent.mm.plugin.normsg.Normsg.b.bVJ();
        if (bVJ == null) {
        }
        versionCode = getVersionCode();
        eK = eK(versionCode, i);
        Ma = q.Ma();
        stringBuilder = new StringBuilder();
        append = stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>");
        str = (String) Ma.get("model name");
        if (str == null) {
        }
        append = append.append(TR(str)).append("</k1><k2>").append(TR(q.LV())).append("</k2><k3>").append(TR(q.LW())).append("</k3><k4>").append(TR(bVO())).append("</k4><k5>").append(TR(q.LX())).append("</k5><k6>").append(TR(q.LY())).append("</k6><k7>").append(TR(q.getAndroidId())).append("</k7><k8>").append(TR(q.LZ())).append("</k8><k9>").append(TR(q.LS())).append("</k9><k10>").append(q.Mb()).append("</k10><k11>").append(bo.nullAsNil(TR((String) Ma.get("hardware")))).append("</k11><k12>").append(bo.nullAsNil(TR((String) Ma.get("revision")))).append("</k12><k13>").append(bo.nullAsNil(TR((String) Ma.get("serial")))).append("</k13><k14>").append(TR(q.LP())).append("</k14><k15>").append(TR(q.LU())).append("</k15><k16>");
        str = (String) Ma.get("features");
        if (str == null) {
        }
        append2 = append.append(bo.nullAsNil(TR(str))).append("</k16><k18>").append(v).append("</k18><k21>").append(bo.nullAsNil(TR(gE))).append("</k21><k22>").append(bo.nullAsNil(TR(q.bC(applicationContext)))).append("</k22><k24>").append(bo.nullAsNil(TR(gF))).append("</k24><k26>").append(i4).append("</k26><k30>");
        activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
        }
        append = append2.append(bo.nullAsNil(TR(str))).append("</k30><k33>").append(TR(ah.getPackageName())).append("</k33><k34>").append(bo.nullAsNil(TR(com.tencent.mm.compatible.e.ab.get("ro.build.fingerprint")))).append("</k34><k35>").append(bo.nullAsNil(TR(Build.BOARD))).append("</k35><k36>").append(bo.nullAsNil(TR(Build.BOOTLOADER))).append("</k36><k37>").append(bo.nullAsNil(TR(Build.BRAND))).append("</k37><k38>").append(bo.nullAsNil(TR(Build.DEVICE))).append("</k38><k39>").append(bo.nullAsNil(TR(Build.HARDWARE))).append("</k39><k40>").append(bo.nullAsNil(TR(Build.PRODUCT))).append("</k40><k41>").append(i5).append("</k41><k42>").append(bo.nullAsNil(TR(com.tencent.mm.compatible.e.ab.get("ro.product.manufacturer")))).append("</k42><k43>").append(System.getString(ah.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
        str = bo.nullAsNil(bo.gP(ah.getContext()));
        if (str.length() > 0) {
        }
        append.append(str).append("</k45><k46>").append(str2).append("</k46><k47>").append(TR(bVP())).append("</k47><k48>").append(bVO()).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.eSi).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(bo.nullAsNil(TR(eK))).append("</k58><k59>").append(i).append("</k59><k60>").append(TR(com.tencent.mm.sdk.platformtools.f.xxZ.getString("FEATURE_ID"))).append("</k60><k61>").append(q.LN()).append("</k61></softtype>");
        str = stringBuilder.toString();
        AppMethodBeat.o(10321);
        return str;
    }

    private static String TR(String str) {
        AppMethodBeat.i(10322);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(10322);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case '\'':
                    stringBuilder.append("&apos;");
                    break;
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                default:
                    if (charAt <= '~' && charAt != '[' && charAt != ']') {
                        stringBuilder.append(charAt);
                        break;
                    }
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(10322);
        return str;
    }

    private static String eK(int i, int i2) {
        PackageInfo packageInfo;
        AppMethodBeat.i(10323);
        String str = "";
        try {
            packageInfo = ah.getContext().getPackageManager().getPackageInfo(ah.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            ab.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ah.getPackageName());
        }
        if (packageInfo != null) {
            com.tencent.mm.plugin.report.e eVar;
            Object[] objArr;
            try {
                str = com.tencent.mm.c.c.y(new File(packageInfo.applicationInfo.sourceDir));
                if (bo.isNullOrNil(str)) {
                    com.tencent.mm.plugin.report.e.pXa.a(322, 13, 1, true);
                    eVar = com.tencent.mm.plugin.report.e.pXa;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4013);
                    objArr[1] = String.format("%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    eVar.e(11098, objArr);
                }
            } catch (Exception e2) {
                ab.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + e2.getMessage());
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                com.tencent.mm.plugin.report.e.pXa.a(322, 12, 1, true);
                eVar = com.tencent.mm.plugin.report.e.pXa;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4012);
                objArr[1] = String.format("%s|%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r9.getMessage()});
                eVar.e(11098, objArr);
            }
        }
        AppMethodBeat.o(10323);
        return str;
    }

    private static int getVersionCode() {
        PackageInfo packageInfo;
        int i = 0;
        AppMethodBeat.i(10324);
        try {
            packageInfo = ah.getContext().getPackageManager().getPackageInfo(ah.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            ab.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ah.getPackageName());
        }
        if (packageInfo != null) {
            i = packageInfo.versionCode;
        }
        AppMethodBeat.o(10324);
        return i;
    }

    private static String bVP() {
        String str;
        AppMethodBeat.i(10325);
        String str2 = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                str = "wifi";
            } else {
                str = activeNetworkInfo.getSubtype();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", bo.l(e));
            str = str2;
        }
        AppMethodBeat.o(10325);
        return str;
    }

    public final String jE(boolean z) {
        AppMethodBeat.i(10326);
        String aZ = com.tencent.mm.plugin.normsg.Normsg.b.aZ(",", z);
        AppMethodBeat.o(10326);
        return aZ;
    }

    public final String bVQ() {
        AppMethodBeat.i(10327);
        String str;
        if (com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
            ab.w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
            str = "";
            AppMethodBeat.o(10327);
            return str;
        }
        List<PackageInfo> installedPackages = ah.getContext().getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        for (PackageInfo packageInfo : installedPackages) {
            stringBuilder.append(packageInfo.packageName).append(10);
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(10327);
        return str;
    }

    public final boolean bVI() {
        AppMethodBeat.i(10328);
        boolean bVI = com.tencent.mm.plugin.normsg.Normsg.b.bVI();
        AppMethodBeat.o(10328);
        return bVI;
    }

    public final boolean bVR() {
        boolean z = false;
        AppMethodBeat.i(10329);
        try {
            z = com.tencent.mm.plugin.normsg.Normsg.b.bVK();
            AppMethodBeat.o(10329);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "unexpected error.", new Object[z]);
            AppMethodBeat.o(10329);
        }
        return z;
    }

    public final boolean bVL() {
        AppMethodBeat.i(10330);
        ab.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", Boolean.valueOf(com.tencent.mm.plugin.normsg.Normsg.b.bVL()));
        AppMethodBeat.o(10330);
        return com.tencent.mm.plugin.normsg.Normsg.b.bVL();
    }

    public final boolean bVM() {
        AppMethodBeat.i(10331);
        ab.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", Boolean.valueOf(com.tencent.mm.plugin.normsg.Normsg.b.bVM()));
        AppMethodBeat.o(10331);
        return com.tencent.mm.plugin.normsg.Normsg.b.bVM();
    }

    public final boolean bVN() {
        AppMethodBeat.i(10332);
        ab.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", Boolean.valueOf(com.tencent.mm.plugin.normsg.Normsg.b.bVN()));
        AppMethodBeat.o(10332);
        return com.tencent.mm.plugin.normsg.Normsg.b.bVN();
    }

    public final boolean c(Object obj, Class cls) {
        AppMethodBeat.i(10333);
        boolean b = Normsg.d.b(obj, cls);
        AppMethodBeat.o(10333);
        return b;
    }

    public final byte[] bVS() {
        AppMethodBeat.i(10334);
        byte[] Aj = com.tencent.mm.plugin.normsg.Normsg.b.Aj(0);
        AppMethodBeat.o(10334);
        return Aj;
    }

    public final boolean cg(Object obj) {
        AppMethodBeat.i(10335);
        boolean cg = Normsg.d.cg(obj);
        AppMethodBeat.o(10335);
        return cg;
    }

    public final void a(View view, Class<? extends com.tencent.mm.sdk.b.b> cls) {
        AppMethodBeat.i(10336);
        com.tencent.mm.plugin.normsg.b.c.a(view, cls);
        AppMethodBeat.o(10336);
    }

    public final void Ao(int i) {
        AppMethodBeat.i(10337);
        com.tencent.mm.plugin.normsg.b.a.bVT().Ao(i);
        AppMethodBeat.o(10337);
    }

    public final boolean a(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray) {
        AppMethodBeat.i(10338);
        boolean a = Normsg.a.a(i, bArr, i2, i3, pInt, pInt2, pByteArray);
        AppMethodBeat.o(10338);
        return a;
    }

    public final void TI(String str) {
        AppMethodBeat.i(10339);
        Normsg.c.TI(str);
        AppMethodBeat.o(10339);
    }

    public final void TJ(String str) {
        AppMethodBeat.i(10340);
        Normsg.c.TJ(str);
        AppMethodBeat.o(10340);
    }

    public final void TK(String str) {
        AppMethodBeat.i(10341);
        Normsg.c.TK(str);
        AppMethodBeat.o(10341);
    }

    public final boolean TL(String str) {
        AppMethodBeat.i(10342);
        boolean TL = Normsg.c.TL(str);
        AppMethodBeat.o(10342);
        return TL;
    }

    public final byte[] TM(String str) {
        AppMethodBeat.i(10343);
        byte[] TM = Normsg.c.TM(str);
        AppMethodBeat.o(10343);
        return TM;
    }

    public final void fu(String str, String str2) {
        AppMethodBeat.i(10344);
        Normsg.c.fu(str, str2);
        AppMethodBeat.o(10344);
    }

    public final void a(String str, MotionEvent motionEvent) {
        AppMethodBeat.i(10345);
        Normsg.c.a(str, motionEvent);
        AppMethodBeat.o(10345);
    }

    public final void TN(String str) {
        AppMethodBeat.i(10346);
        Normsg.c.TN(str);
        AppMethodBeat.o(10346);
    }

    public final boolean TO(String str) {
        AppMethodBeat.i(10347);
        boolean TO = Normsg.c.TO(str);
        AppMethodBeat.o(10347);
        return TO;
    }

    public final byte[] TP(String str) {
        AppMethodBeat.i(10348);
        byte[] TP = Normsg.c.TP(str);
        AppMethodBeat.o(10348);
        return TP;
    }
}
