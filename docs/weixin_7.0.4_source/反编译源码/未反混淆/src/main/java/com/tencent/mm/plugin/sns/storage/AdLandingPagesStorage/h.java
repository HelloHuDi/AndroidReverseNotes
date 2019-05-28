package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class h {
    public static String gj(String str, String str2) {
        AppMethodBeat.i(37721);
        String str3 = cqi() + gl(str, str2);
        AppMethodBeat.o(37721);
        return str3;
    }

    public static String gk(String str, String str2) {
        AppMethodBeat.i(37722);
        e.tf(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + ag.ck(str2);
        AppMethodBeat.o(37722);
        return str3;
    }

    private static String gl(String str, String str2) {
        AppMethodBeat.i(37723);
        String str3 = str + "_img_" + ag.ck(str2);
        AppMethodBeat.o(37723);
        return str3;
    }

    public static Bitmap gm(String str, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(37724);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str)) {
            AppMethodBeat.o(37724);
        } else {
            try {
                String gj = gj(str, str2);
                if (!TextUtils.isEmpty(gj) && e.ct(gj)) {
                    bitmap = MMBitmapFactory.decodeFile(gj);
                    AppMethodBeat.o(37724);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", bo.l(e));
            }
            AppMethodBeat.o(37724);
        }
        return bitmap;
    }

    public static void a(String str, int i, a aVar) {
        AppMethodBeat.i(37725);
        c("adId", str, false, i, aVar);
        AppMethodBeat.o(37725);
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(37726);
        b("adId", str, false, 41, aVar);
        AppMethodBeat.o(37726);
    }

    private static void b(String str, String str2, boolean z, int i, a aVar) {
        AppMethodBeat.i(37727);
        ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        e.a(str2, gj(str, str2), z, i, aVar);
        AppMethodBeat.o(37727);
    }

    public static void c(String str, String str2, boolean z, int i, a aVar) {
        AppMethodBeat.i(37728);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str)) {
            aVar.cmD();
            AppMethodBeat.o(37728);
        } else if (AdLandingPagesProxy.getInstance().isUseSnsDownloadImage()) {
            a(str, str2, aVar);
            AppMethodBeat.o(37728);
        } else {
            b(str, str2, z, i, aVar);
            AppMethodBeat.o(37728);
        }
    }

    private static void a(String str, String str2, a aVar) {
        AppMethodBeat.i(37729);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str)) {
            aVar.cmD();
            AppMethodBeat.o(37729);
            return;
        }
        ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + str2 + " for adid:" + str);
        e.a(str2, cqi(), gl(str, str2), aVar);
        AppMethodBeat.o(37729);
    }

    public static void d(String str, String str2, boolean z, int i, a aVar) {
        AppMethodBeat.i(37730);
        ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download sight for " + str2 + " for adid:" + str);
        e.a(str2, gk(str, str2), z, i, aVar);
        AppMethodBeat.o(37730);
    }

    public static String cqi() {
        AppMethodBeat.i(37731);
        String str = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/";
        AppMethodBeat.o(37731);
        return str;
    }
}
