package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.ai;
import com.tencent.mm.plugin.appbrand.o.c;
import com.tencent.mm.plugin.appbrand.o.d;
import com.tencent.mm.plugin.appbrand.service.h;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

public final class b implements a {
    /* JADX WARNING: Missing block: B:44:0x00e0, code skipped:
            if (r4.equals("false") != false) goto L_0x00bb;
     */
    /* JADX WARNING: Missing block: B:62:0x0131, code skipped:
            if (r5.equals("false") != false) goto L_0x010c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        int i = 2;
        boolean z = false;
        AppMethodBeat.i(128927);
        boolean z2 = bp.dpL() || f.IS_FLAVOR_RED || f.IS_FLAVOR_PURPLE;
        String str2;
        if (!z2) {
            AppMethodBeat.o(128927);
        } else if ("//enable_appbrand_monkey_test".equals(strArr[0])) {
            DebuggerShell.ayV();
            AppMethodBeat.o(128927);
        } else if ("//disable_appbrand_monkey_test".equals(strArr[0])) {
            DebuggerShell.ayW();
            AppMethodBeat.o(128927);
        } else if ("//appbrand_predownload_trigger".equals(strArr[0])) {
            ((h) g.K(h.class)).xO(strArr.length > 1 ? strArr[1].trim() : "");
            AppMethodBeat.o(128927);
        } else if ("//wxafts".equals(strArr[0])) {
            if (strArr[1].contains("delete")) {
                c cVar = c.a.iDD;
                d dVar = d.iDE;
                e.t(new File(d.aLD()));
                ab.i("MicroMsg.WxaFTSSearchCore", "forceUnzipBasicTemplate");
                cVar.prepare();
            }
            AppMethodBeat.o(128927);
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
                    com.tencent.mm.plugin.appbrand.u.a.aSi();
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.u.a.rh(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.u.a.rh(0);
                    break;
            }
            AppMethodBeat.o(128927);
        } else if ("//localwxalibrary".equals(strArr[0])) {
            as amF = as.amF("__appbrand_comm_lib__prefs");
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
            AppMethodBeat.o(128927);
        } else if ("//getsearchshowoutwxaapp".equals(strArr[0])) {
            x.a aVar;
            if (strArr.length <= 1 || !strArr[1].contains("daily")) {
                aVar = x.a.SEARCH;
                x.axL();
            } else {
                aVar = x.a.DAILY;
                x.axL();
            }
            AppMethodBeat.o(128927);
        } else if ("//callsearchshowoutwxaapp".equals(strArr[0])) {
            ((i) g.K(i.class)).axP();
            AppMethodBeat.o(128927);
        } else if ("//wagame".equals(strArr[0])) {
            com.tencent.mm.plugin.appbrand.game.a.g.a(context, strArr);
            AppMethodBeat.o(128927);
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
            ax auV;
            at atVar;
            int i2;
            at atVar2;
            switch (z2) {
                case false:
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(128925);
                            long anU = bo.anU();
                            int unzip = ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null);
                            ab.i("[ZIP]", "unzip JNI %d, cost %d", Integer.valueOf(unzip), Long.valueOf(bo.anU() - anU));
                            AppMethodBeat.o(128925);
                        }
                    }, "TestZipJNI");
                    break;
                case true:
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(128926);
                            long anU = bo.anU();
                            int i = -1;
                            try {
                                i = l.a(new ZipInputStream(new FileInputStream(new File("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
                            } catch (Exception e) {
                                ab.e("[ZIP]", "unzip Java ex=%s", e);
                            }
                            ab.i("[ZIP]", "unzip Java %d, cost %d", Integer.valueOf(i), Long.valueOf(bo.anU() - anU));
                            AppMethodBeat.o(128926);
                        }
                    }, "TestZipJava");
                    break;
                case true:
                    auV = com.tencent.mm.plugin.appbrand.app.f.auV();
                    atVar = new at();
                    atVar.field_appId = "@LibraryAppId";
                    atVar.field_debugType = 999;
                    atVar.field_version = 1;
                    auV.gVk.a((com.tencent.mm.sdk.e.c) atVar, at.gUR);
                    i2 = an.VERSION;
                    com.tencent.mm.plugin.appbrand.task.h.pN(2);
                    break;
                case true:
                    com.tencent.mm.plugin.appbrand.app.f.auV().ax("@LibraryAppId", 0);
                    i2 = an.VERSION;
                    com.tencent.mm.plugin.appbrand.task.h.pN(2);
                    break;
                case true:
                    int i3;
                    CharSequence trim = strArr.length > 2 ? strArr[2].trim() : null;
                    if (strArr.length > 3) {
                        i3 = bo.getInt(strArr[3].trim(), 0);
                    }
                    if (!TextUtils.isEmpty(trim)) {
                        com.tencent.mm.plugin.appbrand.app.f.auV().ax(trim, i3);
                        break;
                    }
                    break;
                case true:
                    com.tencent.mm.sdk.g.d.post(n.c.avx(), "WxaPkgCleanupByCMD");
                    break;
                case true:
                    p.zq(strArr[2]);
                    break;
                case true:
                    if (bo.getInt(strArr[2].trim(), 0) > 0) {
                        z = true;
                    }
                    g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_SHOW_HISTORY_COUNT_BOOLEAN, Boolean.valueOf(z));
                    break;
                case true:
                    p.zp(strArr[2]);
                    break;
                case true:
                    r.zt(strArr[2]);
                    break;
                case true:
                    t.nC(Math.max(0, bo.getInt(strArr[2], 0)));
                    break;
                case true:
                    com.tencent.mm.bp.d.H(ah.getContext(), "appbrand", ".ui.AppBrandGuideUI");
                    break;
                case true:
                    g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.FALSE);
                    break;
                case true:
                    try {
                        String str4 = strArr[2];
                        WxaAttributes.e eVar = new WxaAttributes.e();
                        eVar.axy = 1000;
                        eVar.hii = "fake";
                        com.tencent.mm.plugin.appbrand.app.f.auV().a(str4, eVar);
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case true:
                    atVar2 = new at();
                    atVar2.field_appId = "wx4ffb369b6881ee5e";
                    atVar2.field_version = 24;
                    atVar2.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
                    atVar2.field_versionState = 0;
                    atVar2.field_debugType = 0;
                    atVar2.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.f.auV().d(atVar2);
                    break;
                case true:
                    atVar2 = new at();
                    atVar2.field_appId = "wx4ffb369b6881ee5e";
                    atVar2.field_version = 28;
                    atVar2.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
                    atVar2.field_versionState = 0;
                    atVar2.field_debugType = 0;
                    atVar2.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.f.auV().d(atVar2);
                    break;
                case true:
                    atVar2 = new at();
                    atVar2.field_appId = "wx4ffb369b6881ee5e";
                    atVar2.field_version = 28;
                    atVar2.field_debugType = 0;
                    com.tencent.mm.plugin.appbrand.app.f.auV().a(atVar2);
                    break;
                case true:
                    auV = com.tencent.mm.plugin.appbrand.app.f.auV();
                    atVar = auV.a("wx4ffb369b6881ee5e", 0, "version");
                    if (atVar != null) {
                        auV.a(atVar);
                        break;
                    }
                    break;
                case true:
                    new q(bo.getInt(strArr[2], 78), strArr[3]).run();
                    break;
                case true:
                    an.avS();
                    Toast.makeText(ah.getContext(), "MockLib已清除，重启微信生效", 1).show();
                    break;
                case true:
                    if (strArr.length < 3 || !strArr[2].equalsIgnoreCase("false")) {
                        z = true;
                    }
                    ai.iiB = z;
                    break;
                case true:
                    if (strArr.length >= 3) {
                        an.dD(strArr[2].trim().contentEquals("1"));
                        break;
                    }
                    break;
                case true:
                    if (strArr.length < 3) {
                        com.tencent.mm.plugin.appbrand.task.a.a.eC(true);
                        break;
                    }
                    com.tencent.mm.plugin.appbrand.task.a.a.eC(strArr[2].trim().contentEquals("1"));
                    break;
            }
            AppMethodBeat.o(128927);
        }
        return true;
    }
}
