package com.tencent.p177mm.plugin.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C19054n.C19055c;
import com.tencent.p177mm.plugin.appbrand.appcache.C19064q;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C38104an;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.appusage.C26783t;
import com.tencent.p177mm.plugin.appbrand.appusage.C41224x;
import com.tencent.p177mm.plugin.appbrand.appusage.C41224x.C41225a;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C26881g;
import com.tencent.p177mm.plugin.appbrand.launching.C19559ai;
import com.tencent.p177mm.plugin.appbrand.p1231o.C38454c;
import com.tencent.p177mm.plugin.appbrand.p1231o.C38454c.C33463a;
import com.tencent.p177mm.plugin.appbrand.p1231o.C45661d;
import com.tencent.p177mm.plugin.appbrand.p1472u.C33536a;
import com.tencent.p177mm.plugin.appbrand.service.C19732h;
import com.tencent.p177mm.plugin.appbrand.service.C19734i;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.appbrand.task.p1139a.C27308a;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.b */
public final class C33111b implements C44041a {

    /* renamed from: com.tencent.mm.plugin.appbrand.b$1 */
    class C331101 implements Runnable {
        C331101() {
        }

        public final void run() {
            AppMethodBeat.m2504i(128925);
            long anU = C5046bo.anU();
            int unzip = ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null);
            C4990ab.m7417i("[ZIP]", "unzip JNI %d, cost %d", Integer.valueOf(unzip), Long.valueOf(C5046bo.anU() - anU));
            AppMethodBeat.m2505o(128925);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b$2 */
    class C331122 implements Runnable {
        C331122() {
        }

        public final void run() {
            AppMethodBeat.m2504i(128926);
            long anU = C5046bo.anU();
            int i = -1;
            try {
                i = C42367l.m74943a(new ZipInputStream(new FileInputStream(new File("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
            } catch (Exception e) {
                C4990ab.m7413e("[ZIP]", "unzip Java ex=%s", e);
            }
            C4990ab.m7417i("[ZIP]", "unzip Java %d, cost %d", Integer.valueOf(i), Long.valueOf(C5046bo.anU() - anU));
            AppMethodBeat.m2505o(128926);
        }
    }

    /* JADX WARNING: Missing block: B:44:0x00e0, code skipped:
            if (r4.equals("false") != false) goto L_0x00bb;
     */
    /* JADX WARNING: Missing block: B:62:0x0131, code skipped:
            if (r5.equals("false") != false) goto L_0x010c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        int i = 2;
        boolean z = false;
        AppMethodBeat.m2504i(128927);
        boolean z2 = C5047bp.dpL() || C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE;
        String str2;
        if (!z2) {
            AppMethodBeat.m2505o(128927);
        } else if ("//enable_appbrand_monkey_test".equals(strArr[0])) {
            DebuggerShell.ayV();
            AppMethodBeat.m2505o(128927);
        } else if ("//disable_appbrand_monkey_test".equals(strArr[0])) {
            DebuggerShell.ayW();
            AppMethodBeat.m2505o(128927);
        } else if ("//appbrand_predownload_trigger".equals(strArr[0])) {
            ((C19732h) C1720g.m3528K(C19732h.class)).mo34966xO(strArr.length > 1 ? strArr[1].trim() : "");
            AppMethodBeat.m2505o(128927);
        } else if ("//wxafts".equals(strArr[0])) {
            if (strArr[1].contains("delete")) {
                C38454c c38454c = C33463a.iDD;
                C45661d c45661d = C45661d.iDE;
                C1173e.m2575t(new File(C45661d.aLD()));
                C4990ab.m7416i("MicroMsg.WxaFTSSearchCore", "forceUnzipBasicTemplate");
                c38454c.prepare();
            }
            AppMethodBeat.m2505o(128927);
        } else if ("//xweb_video".equals(strArr[0])) {
            String str3 = strArr[1];
            switch (str3.hashCode()) {
                case 3569038:
                    if (str3.equals("true")) {
                        i = 1;
                        break;
                    }
                case 94746189:
                    if (str3.equals("clear")) {
                        i = 0;
                        break;
                    }
                case 97196323:
                    break;
                default:
                    i = -1;
                    break;
            }
            switch (i) {
                case 0:
                    C33536a.aSi();
                    break;
                case 1:
                    C33536a.m54769rh(1);
                    break;
                case 2:
                    C33536a.m54769rh(0);
                    break;
            }
            AppMethodBeat.m2505o(128927);
        } else if ("//localwxalibrary".equals(strArr[0])) {
            C5018as amF = C5018as.amF("__appbrand_comm_lib__prefs");
            str2 = strArr[1];
            switch (str2.hashCode()) {
                case 3569038:
                    if (str2.equals("true")) {
                        i = 1;
                        break;
                    }
                case 94746189:
                    if (str2.equals("clear")) {
                        i = 0;
                        break;
                    }
                case 97196323:
                    break;
                default:
                    i = -1;
                    break;
            }
            switch (i) {
                case 0:
                    amF.edit().remove("localwxalibrary").commit();
                    break;
                case 1:
                    amF.edit().putBoolean("localwxalibrary", true).commit();
                    break;
                case 2:
                    amF.edit().putBoolean("localwxalibrary", false).commit();
                    break;
            }
            AppMethodBeat.m2505o(128927);
        } else if ("//getsearchshowoutwxaapp".equals(strArr[0])) {
            C41225a c41225a;
            if (strArr.length <= 1 || !strArr[1].contains("daily")) {
                c41225a = C41225a.SEARCH;
                C41224x.axL();
            } else {
                c41225a = C41225a.DAILY;
                C41224x.axL();
            }
            AppMethodBeat.m2505o(128927);
        } else if ("//callsearchshowoutwxaapp".equals(strArr[0])) {
            ((C19734i) C1720g.m3528K(C19734i.class)).axP();
            AppMethodBeat.m2505o(128927);
        } else if ("//wagame".equals(strArr[0])) {
            C26881g.m42816a(context, strArr);
            AppMethodBeat.m2505o(128927);
        } else {
            str2 = strArr[1].toLowerCase();
            z2 = true;
            switch (str2.hashCode()) {
                case -2120258717:
                    if (str2.equals("incremental_insert_24")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -2120258713:
                    if (str2.equals("incremental_insert_28")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -2094503115:
                    if (str2.equals("incremental_delete_28")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -2086708598:
                    if (str2.equals("deletebetalib")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1958532869:
                    if (str2.equals("historycount")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1897191982:
                    if (str2.equals("starmax")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1819844161:
                    if (str2.equals("javazip")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1513405239:
                    if (str2.equals("clear_mocklib")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1155441316:
                    if (str2.equals("jnizip")) {
                        z2 = false;
                        break;
                    }
                    break;
                case -917899243:
                    if (str2.equals("deletecontact")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -901868261:
                    if (str2.equals("force_modularizing")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -738930766:
                    if (str2.equals("disable_preload")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -725390129:
                    if (str2.equals("clearguide")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -681162920:
                    if (str2.equals("pkgcleanup")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -501183631:
                    if (str2.equals("releasepkghighversion")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -358696710:
                    if (str2.equals("deletelib")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -358692799:
                    if (str2.equals("deletepkg")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -78191370:
                    if (str2.equals("incremental_delete_latest")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 3545755:
                    if (str2.equals("sync")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 98712316:
                    if (str2.equals("guide")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 424332448:
                    if (str2.equals("incremental_lib")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1102626508:
                    if (str2.equals("disable_develop_lib")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1127987502:
                    if (str2.equals("resetsyncversion")) {
                        z2 = true;
                        break;
                    }
                    break;
            }
            C38105ax auV;
            C31281at c31281at;
            int i2;
            C31281at c31281at2;
            switch (z2) {
                case false:
                    C7305d.post(new C331101(), "TestZipJNI");
                    break;
                case true:
                    C7305d.post(new C331122(), "TestZipJava");
                    break;
                case true:
                    auV = C42340f.auV();
                    c31281at = new C31281at();
                    c31281at.field_appId = "@LibraryAppId";
                    c31281at.field_debugType = 999;
                    c31281at.field_version = 1;
                    auV.gVk.mo16760a((C4925c) c31281at, C31281at.gUR);
                    i2 = C38104an.VERSION;
                    C45694h.m84430pN(2);
                    break;
                case true:
                    C42340f.auV().mo60857ax("@LibraryAppId", 0);
                    i2 = C38104an.VERSION;
                    C45694h.m84430pN(2);
                    break;
                case true:
                    int i3;
                    CharSequence trim = strArr.length > 2 ? strArr[2].trim() : null;
                    if (strArr.length > 3) {
                        i3 = C5046bo.getInt(strArr[3].trim(), 0);
                    }
                    if (!TextUtils.isEmpty(trim)) {
                        C42340f.auV().mo60857ax(trim, i3);
                        break;
                    }
                    break;
                case true:
                    C7305d.post(C19055c.avx(), "WxaPkgCleanupByCMD");
                    break;
                case true:
                    C26842p.m42744zq(strArr[2]);
                    break;
                case true:
                    if (C5046bo.getInt(strArr[2].trim(), 0) > 0) {
                        z = true;
                    }
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_SHOW_HISTORY_COUNT_BOOLEAN, Boolean.valueOf(z));
                    break;
                case true:
                    C26842p.m42743zp(strArr[2]);
                    break;
                case true:
                    C42406r.m75079zt(strArr[2]);
                    break;
                case true:
                    C26783t.m42628nC(Math.max(0, C5046bo.getInt(strArr[2], 0)));
                    break;
                case true:
                    C25985d.m41448H(C4996ah.getContext(), "appbrand", ".ui.AppBrandGuideUI");
                    break;
                case true:
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.FALSE);
                    break;
                case true:
                    try {
                        String str4 = strArr[2];
                        C31283e c31283e = new C31283e();
                        c31283e.axy = 1000;
                        c31283e.hii = "fake";
                        C42340f.auV().mo60849a(str4, c31283e);
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case true:
                    c31281at2 = new C31281at();
                    c31281at2.field_appId = "wx4ffb369b6881ee5e";
                    c31281at2.field_version = 24;
                    c31281at2.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
                    c31281at2.field_versionState = 0;
                    c31281at2.field_debugType = 0;
                    c31281at2.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
                    C42340f.auV().mo60862d(c31281at2);
                    break;
                case true:
                    c31281at2 = new C31281at();
                    c31281at2.field_appId = "wx4ffb369b6881ee5e";
                    c31281at2.field_version = 28;
                    c31281at2.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
                    c31281at2.field_versionState = 0;
                    c31281at2.field_debugType = 0;
                    c31281at2.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
                    C42340f.auV().mo60862d(c31281at2);
                    break;
                case true:
                    c31281at2 = new C31281at();
                    c31281at2.field_appId = "wx4ffb369b6881ee5e";
                    c31281at2.field_version = 28;
                    c31281at2.field_debugType = 0;
                    C42340f.auV().mo60844a(c31281at2);
                    break;
                case true:
                    auV = C42340f.auV();
                    c31281at = auV.mo60842a("wx4ffb369b6881ee5e", 0, "version");
                    if (c31281at != null) {
                        auV.mo60844a(c31281at);
                        break;
                    }
                    break;
                case true:
                    new C19064q(C5046bo.getInt(strArr[2], 78), strArr[3]).run();
                    break;
                case true:
                    C38104an.avS();
                    Toast.makeText(C4996ah.getContext(), "MockLib已清除，重启微信生效", 1).show();
                    break;
                case true:
                    if (strArr.length < 3 || !strArr[2].equalsIgnoreCase("false")) {
                        z = true;
                    }
                    C19559ai.iiB = z;
                    break;
                case true:
                    if (strArr.length >= 3) {
                        C38104an.m64445dD(strArr[2].trim().contentEquals("1"));
                        break;
                    }
                    break;
                case true:
                    if (strArr.length < 3) {
                        C27308a.m43360eC(true);
                        break;
                    }
                    C27308a.m43360eC(strArr[2].trim().contentEquals("1"));
                    break;
            }
            AppMethodBeat.m2505o(128927);
        }
        return true;
    }
}
