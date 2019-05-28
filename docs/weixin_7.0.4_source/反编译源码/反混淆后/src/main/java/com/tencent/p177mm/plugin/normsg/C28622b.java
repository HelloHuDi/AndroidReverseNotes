package com.tencent.p177mm.plugin.normsg;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mrs.p656b.C7374c;
import com.tencent.p127d.p132e.p133a.C41668e;
import com.tencent.p127d.p132e.p133a.C8766d;
import com.tencent.p127d.p132e.p133a.C8766d.C8767a;
import com.tencent.p127d.p132e.p133a.p134a.C41661f;
import com.tencent.p177mm.compatible.p221e.C1414ab;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p209c.C45275c;
import com.tencent.p177mm.plugin.normsg.Normsg.C12721a;
import com.tencent.p177mm.plugin.normsg.Normsg.C21379b;
import com.tencent.p177mm.plugin.normsg.Normsg.C21380d;
import com.tencent.p177mm.plugin.normsg.Normsg.C21381c;
import com.tencent.p177mm.plugin.normsg.p473a.C3554a;
import com.tencent.p177mm.plugin.normsg.p474b.C21384a;
import com.tencent.p177mm.plugin.normsg.p474b.C21391c;
import com.tencent.p177mm.plugin.normsg.p474b.C21394d;
import com.tencent.p177mm.plugin.normsg.p474b.C43348e;
import com.tencent.p177mm.plugin.normsg.p474b.C43349f;
import com.tencent.p177mm.plugin.normsg.p474b.C43350g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import java.io.File;
import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.normsg.b */
enum C28622b implements C3554a {
    ;
    
    private static final C5004al oTF = null;

    /* renamed from: com.tencent.mm.plugin.normsg.b$1 */
    class C127221 implements Runnable {
        C127221() {
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:16:0x013e, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:17:0x013f, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.NormsgSourceImpl", "exception:%s", com.tencent.p177mm.sdk.platformtools.C5046bo.m7574l(r0));
     */
        /* JADX WARNING: Missing block: B:18:0x0152, code skipped:
            r0 = r1;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(10313);
            if (C1720g.m3531RK()) {
                long currentTimeMillis = System.currentTimeMillis();
                String str = C4996ah.getContext().getApplicationInfo().sourceDir;
                C1720g.m3534RN();
                byte[] Ak = C21379b.m32781Ak(C1668a.m3383QF());
                C1720g.m3534RN();
                byte[] Al = C21379b.m32782Al(C1668a.m3383QF());
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String format = String.format("<k25>%s</k25>", new Object[]{C21394d.m32816v(Ak, 0, Ak.length)});
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
                        format = format + String.format("<k28>%s</k28><k29>%s</k29>", new Object[]{C21394d.m32816v(Al, 0, 4), C21394d.m32816v(Al, 4, 8)});
                    } else {
                        format = format + String.format("<k27>%s</k27>", new Object[]{C21394d.m32816v(Al, 0, Al.length)});
                    }
                }
                try {
                    String hostAddress = Inet4Address.getByName("mp.weixin.qq.com").getHostAddress();
                    Object obj = format + String.format("<k32>%s</k32>", new Object[]{C5046bo.nullAsNil(hostAddress)});
                    C4990ab.m7416i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + currentTimeMillis2 + ", value: " + obj + "]");
                    C1720g.m3536RP().mo5239Ry().set(79, obj);
                    AppMethodBeat.m2505o(10313);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.NormsgSourceImpl", e, "Failed checkSoftType2.", new Object[0]);
                    AppMethodBeat.m2505o(10313);
                    return;
                }
            }
            AppMethodBeat.m2505o(10313);
        }

        public final String toString() {
            AppMethodBeat.m2504i(10314);
            String str = super.toString() + "|checkSoftTypeExtra";
            AppMethodBeat.m2505o(10314);
            return str;
        }
    }

    private C28622b(String str) {
    }

    static {
        oTF = new C5004al("NormsgWorker");
        AppMethodBeat.m2505o(10349);
    }

    /* renamed from: Am */
    public final byte[] mo8082Am(int i) {
        AppMethodBeat.m2504i(10317);
        byte[] Aj = C21379b.m32780Aj(i);
        AppMethodBeat.m2505o(10317);
        return Aj;
    }

    /* renamed from: ae */
    public final void mo8097ae(int i, int i2, int i3) {
        AppMethodBeat.m2504i(10318);
        Context context = C4996ah.getContext();
        if (i2 <= 0 || i2 > 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("action invalid: ".concat(String.valueOf(i2)));
            AppMethodBeat.m2505o(10318);
            throw illegalArgumentException;
        }
        C8767a c8767a = new C8767a(context, i, i2, (byte) 0);
        long j = (long) (i3 * 1000);
        if (j < C41661f.AtJ) {
            c8767a.Ato = C41661f.AtJ;
        } else if (j > C41661f.AtG * 12) {
            c8767a.Ato = C41661f.AtG * 12;
        }
        c8767a.Ato = j;
        C41668e.dQs().mo67145a(new C8766d(c8767a, (byte) 0));
        AppMethodBeat.m2505o(10318);
    }

    /* renamed from: TQ */
    public final String mo8093TQ(String str) {
        AppMethodBeat.m2504i(10319);
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ((str.charAt(i) ^ -89) ^ ((byte) (((i + 1) ^ length) ^ -1))));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(10319);
        return stringBuilder2;
    }

    private static String bVO() {
        AppMethodBeat.m2504i(10320);
        String LL;
        if (new C7374c().get("clicfg_use_new_cached_imei_method", false)) {
            LL = C1427q.m3027LL();
            AppMethodBeat.m2505o(10320);
            return LL;
        }
        LL = C1427q.m3026LK();
        AppMethodBeat.m2505o(10320);
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
    /* renamed from: An */
    public final String mo8083An(int i) {
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
        AppMethodBeat.m2504i(10321);
        String str = "";
        if (C1720g.m3531RK()) {
            str = (String) C1720g.m3536RP().mo5239Ry().get(79, (Object) "");
        }
        C1720g.m3539RS().mo10310m(new C127221(), 5000);
        String str2 = "";
        if (C1720g.m3531RK()) {
            str2 = C1720g.m3536RP().eJN.ybP.ybm ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        Context applicationContext = C4996ah.getContext().getApplicationContext();
        String gE = C5023at.m7474gE(applicationContext);
        String gF = C5023at.m7475gF(applicationContext);
        Context context = C4996ah.getContext();
        if (context == null) {
            C4990ab.m7420w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
        } else if (Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
            obj = 1;
            i2 = obj == null ? 1 : 0;
            i3 = C21379b.bVI() ? 1 : 0;
            i4 = Debug.isDebuggerConnected() ? 1 : 0;
            i5 = (C43349f.oVf || C43349f.oVg || C43349f.oVh) ? 1 : 0;
            i6 = C43348e.oVb ? 1 : 0;
            i7 = C43350g.oVi ? 1 : 0;
            bVJ = C21379b.bVJ();
            v = bVJ == null ? C21394d.m32816v(bVJ, 0, bVJ.length) : "";
            versionCode = C28622b.getVersionCode();
            eK = C28622b.m45462eK(versionCode, i);
            Ma = C1427q.m3042Ma();
            stringBuilder = new StringBuilder();
            append = stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>");
            str = (String) Ma.get("model name");
            if (str == null) {
                str = C1427q.m3035LT()[0];
            }
            append = append.append(C28622b.m45461TR(str)).append("</k1><k2>").append(C28622b.m45461TR(C1427q.m3037LV())).append("</k2><k3>").append(C28622b.m45461TR(C1427q.m3038LW())).append("</k3><k4>").append(C28622b.m45461TR(C28622b.bVO())).append("</k4><k5>").append(C28622b.m45461TR(C1427q.m3039LX())).append("</k5><k6>").append(C28622b.m45461TR(C1427q.m3040LY())).append("</k6><k7>").append(C28622b.m45461TR(C1427q.getAndroidId())).append("</k7><k8>").append(C28622b.m45461TR(C1427q.m3041LZ())).append("</k8><k9>").append(C28622b.m45461TR(C1427q.m3034LS())).append("</k9><k10>").append(C1427q.m3043Mb()).append("</k10><k11>").append(C5046bo.nullAsNil(C28622b.m45461TR((String) Ma.get("hardware")))).append("</k11><k12>").append(C5046bo.nullAsNil(C28622b.m45461TR((String) Ma.get("revision")))).append("</k12><k13>").append(C5046bo.nullAsNil(C28622b.m45461TR((String) Ma.get("serial")))).append("</k13><k14>").append(C28622b.m45461TR(C1427q.m3031LP())).append("</k14><k15>").append(C28622b.m45461TR(C1427q.m3036LU())).append("</k15><k16>");
            str = (String) Ma.get("features");
            if (str == null) {
                str = (String) Ma.get("flags");
            }
            append2 = append.append(C5046bo.nullAsNil(C28622b.m45461TR(str))).append("</k16><k18>").append(v).append("</k18><k21>").append(C5046bo.nullAsNil(C28622b.m45461TR(gE))).append("</k21><k22>").append(C5046bo.nullAsNil(C28622b.m45461TR(C1427q.m3046bC(applicationContext)))).append("</k22><k24>").append(C5046bo.nullAsNil(C28622b.m45461TR(gF))).append("</k24><k26>").append(i4).append("</k26><k30>");
            activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = activeNetworkInfo.getExtraInfo();
            } else {
                str = null;
            }
            append = append2.append(C5046bo.nullAsNil(C28622b.m45461TR(str))).append("</k30><k33>").append(C28622b.m45461TR(C4996ah.getPackageName())).append("</k33><k34>").append(C5046bo.nullAsNil(C28622b.m45461TR(C1414ab.get("ro.build.fingerprint")))).append("</k34><k35>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.BOARD))).append("</k35><k36>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.BOOTLOADER))).append("</k36><k37>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.BRAND))).append("</k37><k38>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.DEVICE))).append("</k38><k39>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.HARDWARE))).append("</k39><k40>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.PRODUCT))).append("</k40><k41>").append(i5).append("</k41><k42>").append(C5046bo.nullAsNil(C28622b.m45461TR(C1414ab.get("ro.product.manufacturer")))).append("</k42><k43>").append(System.getString(C4996ah.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
            str = C5046bo.nullAsNil(C5046bo.m7554gP(C4996ah.getContext()));
            if (str.length() > 0) {
                str = C1178g.m2591x(str.getBytes());
            }
            append.append(str).append("</k45><k46>").append(str2).append("</k46><k47>").append(C28622b.m45461TR(C28622b.bVP())).append("</k47><k48>").append(C28622b.bVO()).append("</k48><k49>").append(C6457e.eSi).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(C5046bo.nullAsNil(C28622b.m45461TR(eK))).append("</k58><k59>").append(i).append("</k59><k60>").append(C28622b.m45461TR(C5058f.xxZ.getString("FEATURE_ID"))).append("</k60><k61>").append(C1427q.m3029LN()).append("</k61></softtype>");
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(10321);
            return str;
        }
        obj = null;
        if (obj == null) {
        }
        if (C21379b.bVI()) {
        }
        if (Debug.isDebuggerConnected()) {
        }
        if (!C43349f.oVf) {
        }
        if (C43348e.oVb) {
        }
        if (C43350g.oVi) {
        }
        bVJ = C21379b.bVJ();
        if (bVJ == null) {
        }
        versionCode = C28622b.getVersionCode();
        eK = C28622b.m45462eK(versionCode, i);
        Ma = C1427q.m3042Ma();
        stringBuilder = new StringBuilder();
        append = stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>");
        str = (String) Ma.get("model name");
        if (str == null) {
        }
        append = append.append(C28622b.m45461TR(str)).append("</k1><k2>").append(C28622b.m45461TR(C1427q.m3037LV())).append("</k2><k3>").append(C28622b.m45461TR(C1427q.m3038LW())).append("</k3><k4>").append(C28622b.m45461TR(C28622b.bVO())).append("</k4><k5>").append(C28622b.m45461TR(C1427q.m3039LX())).append("</k5><k6>").append(C28622b.m45461TR(C1427q.m3040LY())).append("</k6><k7>").append(C28622b.m45461TR(C1427q.getAndroidId())).append("</k7><k8>").append(C28622b.m45461TR(C1427q.m3041LZ())).append("</k8><k9>").append(C28622b.m45461TR(C1427q.m3034LS())).append("</k9><k10>").append(C1427q.m3043Mb()).append("</k10><k11>").append(C5046bo.nullAsNil(C28622b.m45461TR((String) Ma.get("hardware")))).append("</k11><k12>").append(C5046bo.nullAsNil(C28622b.m45461TR((String) Ma.get("revision")))).append("</k12><k13>").append(C5046bo.nullAsNil(C28622b.m45461TR((String) Ma.get("serial")))).append("</k13><k14>").append(C28622b.m45461TR(C1427q.m3031LP())).append("</k14><k15>").append(C28622b.m45461TR(C1427q.m3036LU())).append("</k15><k16>");
        str = (String) Ma.get("features");
        if (str == null) {
        }
        append2 = append.append(C5046bo.nullAsNil(C28622b.m45461TR(str))).append("</k16><k18>").append(v).append("</k18><k21>").append(C5046bo.nullAsNil(C28622b.m45461TR(gE))).append("</k21><k22>").append(C5046bo.nullAsNil(C28622b.m45461TR(C1427q.m3046bC(applicationContext)))).append("</k22><k24>").append(C5046bo.nullAsNil(C28622b.m45461TR(gF))).append("</k24><k26>").append(i4).append("</k26><k30>");
        activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
        }
        append = append2.append(C5046bo.nullAsNil(C28622b.m45461TR(str))).append("</k30><k33>").append(C28622b.m45461TR(C4996ah.getPackageName())).append("</k33><k34>").append(C5046bo.nullAsNil(C28622b.m45461TR(C1414ab.get("ro.build.fingerprint")))).append("</k34><k35>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.BOARD))).append("</k35><k36>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.BOOTLOADER))).append("</k36><k37>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.BRAND))).append("</k37><k38>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.DEVICE))).append("</k38><k39>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.HARDWARE))).append("</k39><k40>").append(C5046bo.nullAsNil(C28622b.m45461TR(Build.PRODUCT))).append("</k40><k41>").append(i5).append("</k41><k42>").append(C5046bo.nullAsNil(C28622b.m45461TR(C1414ab.get("ro.product.manufacturer")))).append("</k42><k43>").append(System.getString(C4996ah.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
        str = C5046bo.nullAsNil(C5046bo.m7554gP(C4996ah.getContext()));
        if (str.length() > 0) {
        }
        append.append(str).append("</k45><k46>").append(str2).append("</k46><k47>").append(C28622b.m45461TR(C28622b.bVP())).append("</k47><k48>").append(C28622b.bVO()).append("</k48><k49>").append(C6457e.eSi).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(C5046bo.nullAsNil(C28622b.m45461TR(eK))).append("</k58><k59>").append(i).append("</k59><k60>").append(C28622b.m45461TR(C5058f.xxZ.getString("FEATURE_ID"))).append("</k60><k61>").append(C1427q.m3029LN()).append("</k61></softtype>");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(10321);
        return str;
    }

    /* renamed from: TR */
    private static String m45461TR(String str) {
        AppMethodBeat.m2504i(10322);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(10322);
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
        AppMethodBeat.m2505o(10322);
        return str;
    }

    /* renamed from: eK */
    private static String m45462eK(int i, int i2) {
        PackageInfo packageInfo;
        AppMethodBeat.m2504i(10323);
        String str = "";
        try {
            packageInfo = C4996ah.getContext().getPackageManager().getPackageInfo(C4996ah.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            C4990ab.m7420w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + C4996ah.getPackageName());
        }
        if (packageInfo != null) {
            C7053e c7053e;
            Object[] objArr;
            try {
                str = C45275c.m83484y(new File(packageInfo.applicationInfo.sourceDir));
                if (C5046bo.isNullOrNil(str)) {
                    C7053e.pXa.mo8378a(322, 13, 1, true);
                    c7053e = C7053e.pXa;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4013);
                    objArr[1] = String.format("%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    c7053e.mo8381e(11098, objArr);
                }
            } catch (Exception e2) {
                C4990ab.m7420w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + e2.getMessage());
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                C7053e.pXa.mo8378a(322, 12, 1, true);
                c7053e = C7053e.pXa;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4012);
                objArr[1] = String.format("%s|%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r9.getMessage()});
                c7053e.mo8381e(11098, objArr);
            }
        }
        AppMethodBeat.m2505o(10323);
        return str;
    }

    private static int getVersionCode() {
        PackageInfo packageInfo;
        int i = 0;
        AppMethodBeat.m2504i(10324);
        try {
            packageInfo = C4996ah.getContext().getPackageManager().getPackageInfo(C4996ah.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            C4990ab.m7420w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + C4996ah.getPackageName());
        }
        if (packageInfo != null) {
            i = packageInfo.versionCode;
        }
        AppMethodBeat.m2505o(10324);
        return i;
    }

    private static String bVP() {
        String str;
        AppMethodBeat.m2504i(10325);
        String str2 = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                str = "wifi";
            } else {
                str = activeNetworkInfo.getSubtype();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", C5046bo.m7574l(e));
            str = str2;
        }
        AppMethodBeat.m2505o(10325);
        return str;
    }

    /* renamed from: jE */
    public final String mo8108jE(boolean z) {
        AppMethodBeat.m2504i(10326);
        String aZ = C21379b.m32783aZ(",", z);
        AppMethodBeat.m2505o(10326);
        return aZ;
    }

    public final String bVQ() {
        AppMethodBeat.m2504i(10327);
        String str;
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            C4990ab.m7420w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
            str = "";
            AppMethodBeat.m2505o(10327);
            return str;
        }
        List<PackageInfo> installedPackages = C4996ah.getContext().getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        for (PackageInfo packageInfo : installedPackages) {
            stringBuilder.append(packageInfo.packageName).append(10);
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(10327);
        return str;
    }

    public final boolean bVI() {
        AppMethodBeat.m2504i(10328);
        boolean bVI = C21379b.bVI();
        AppMethodBeat.m2505o(10328);
        return bVI;
    }

    public final boolean bVR() {
        boolean z = false;
        AppMethodBeat.m2504i(10329);
        try {
            z = C21379b.bVK();
            AppMethodBeat.m2505o(10329);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "unexpected error.", new Object[z]);
            AppMethodBeat.m2505o(10329);
        }
        return z;
    }

    public final boolean bVL() {
        AppMethodBeat.m2504i(10330);
        C4990ab.m7417i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", Boolean.valueOf(C21379b.bVL()));
        AppMethodBeat.m2505o(10330);
        return C21379b.bVL();
    }

    public final boolean bVM() {
        AppMethodBeat.m2504i(10331);
        C4990ab.m7417i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", Boolean.valueOf(C21379b.bVM()));
        AppMethodBeat.m2505o(10331);
        return C21379b.bVM();
    }

    public final boolean bVN() {
        AppMethodBeat.m2504i(10332);
        C4990ab.m7417i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", Boolean.valueOf(C21379b.bVN()));
        AppMethodBeat.m2505o(10332);
        return C21379b.bVN();
    }

    /* renamed from: c */
    public final boolean mo8105c(Object obj, Class cls) {
        AppMethodBeat.m2504i(10333);
        boolean b = C21380d.m32791b(obj, cls);
        AppMethodBeat.m2505o(10333);
        return b;
    }

    public final byte[] bVS() {
        AppMethodBeat.m2504i(10334);
        byte[] Aj = C21379b.m32780Aj(0);
        AppMethodBeat.m2505o(10334);
        return Aj;
    }

    /* renamed from: cg */
    public final boolean mo8106cg(Object obj) {
        AppMethodBeat.m2504i(10335);
        boolean cg = C21380d.m32792cg(obj);
        AppMethodBeat.m2505o(10335);
        return cg;
    }

    /* renamed from: a */
    public final void mo8094a(View view, Class<? extends C4883b> cls) {
        AppMethodBeat.m2504i(10336);
        C21391c.m32814a(view, cls);
        AppMethodBeat.m2505o(10336);
    }

    /* renamed from: Ao */
    public final void mo8084Ao(int i) {
        AppMethodBeat.m2504i(10337);
        C21384a.bVT().mo36839Ao(i);
        AppMethodBeat.m2505o(10337);
    }

    /* renamed from: a */
    public final boolean mo8096a(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray) {
        AppMethodBeat.m2504i(10338);
        boolean a = C12721a.m20742a(i, bArr, i2, i3, pInt, pInt2, pByteArray);
        AppMethodBeat.m2505o(10338);
        return a;
    }

    /* renamed from: TI */
    public final void mo8085TI(String str) {
        AppMethodBeat.m2504i(10339);
        C21381c.m32793TI(str);
        AppMethodBeat.m2505o(10339);
    }

    /* renamed from: TJ */
    public final void mo8086TJ(String str) {
        AppMethodBeat.m2504i(10340);
        C21381c.m32794TJ(str);
        AppMethodBeat.m2505o(10340);
    }

    /* renamed from: TK */
    public final void mo8087TK(String str) {
        AppMethodBeat.m2504i(10341);
        C21381c.m32795TK(str);
        AppMethodBeat.m2505o(10341);
    }

    /* renamed from: TL */
    public final boolean mo8088TL(String str) {
        AppMethodBeat.m2504i(10342);
        boolean TL = C21381c.m32796TL(str);
        AppMethodBeat.m2505o(10342);
        return TL;
    }

    /* renamed from: TM */
    public final byte[] mo8089TM(String str) {
        AppMethodBeat.m2504i(10343);
        byte[] TM = C21381c.m32797TM(str);
        AppMethodBeat.m2505o(10343);
        return TM;
    }

    /* renamed from: fu */
    public final void mo8107fu(String str, String str2) {
        AppMethodBeat.m2504i(10344);
        C21381c.m32802fu(str, str2);
        AppMethodBeat.m2505o(10344);
    }

    /* renamed from: a */
    public final void mo8095a(String str, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(10345);
        C21381c.m32801a(str, motionEvent);
        AppMethodBeat.m2505o(10345);
    }

    /* renamed from: TN */
    public final void mo8090TN(String str) {
        AppMethodBeat.m2504i(10346);
        C21381c.m32798TN(str);
        AppMethodBeat.m2505o(10346);
    }

    /* renamed from: TO */
    public final boolean mo8091TO(String str) {
        AppMethodBeat.m2504i(10347);
        boolean TO = C21381c.m32799TO(str);
        AppMethodBeat.m2505o(10347);
        return TO;
    }

    /* renamed from: TP */
    public final byte[] mo8092TP(String str) {
        AppMethodBeat.m2504i(10348);
        byte[] TP = C21381c.m32800TP(str);
        AppMethodBeat.m2505o(10348);
        return TP;
    }
}
