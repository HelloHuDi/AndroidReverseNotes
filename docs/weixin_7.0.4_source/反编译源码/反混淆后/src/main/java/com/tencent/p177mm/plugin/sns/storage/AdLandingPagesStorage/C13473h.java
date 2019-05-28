package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h */
public final class C13473h {
    /* renamed from: gj */
    public static String m21625gj(String str, String str2) {
        AppMethodBeat.m2504i(37721);
        String str3 = C13473h.cqi() + C13473h.m21627gl(str, str2);
        AppMethodBeat.m2505o(37721);
        return str3;
    }

    /* renamed from: gk */
    public static String m21626gk(String str, String str2) {
        AppMethodBeat.m2504i(37722);
        C5730e.m8643tf(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + C4995ag.m7428ck(str2);
        AppMethodBeat.m2505o(37722);
        return str3;
    }

    /* renamed from: gl */
    private static String m21627gl(String str, String str2) {
        AppMethodBeat.m2504i(37723);
        String str3 = str + "_img_" + C4995ag.m7428ck(str2);
        AppMethodBeat.m2505o(37723);
        return str3;
    }

    /* renamed from: gm */
    public static Bitmap m21628gm(String str, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(37724);
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(37724);
        } else {
            try {
                String gj = C13473h.m21625gj(str, str2);
                if (!TextUtils.isEmpty(gj) && C5730e.m8628ct(gj)) {
                    bitmap = MMBitmapFactory.decodeFile(gj);
                    AppMethodBeat.m2505o(37724);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", C5046bo.m7574l(e));
            }
            AppMethodBeat.m2505o(37724);
        }
        return bitmap;
    }

    /* renamed from: a */
    public static void m21619a(String str, int i, C3951a c3951a) {
        AppMethodBeat.m2504i(37725);
        C13473h.m21623c("adId", str, false, i, c3951a);
        AppMethodBeat.m2505o(37725);
    }

    /* renamed from: a */
    public static void m21620a(String str, C3951a c3951a) {
        AppMethodBeat.m2504i(37726);
        C13473h.m21622b("adId", str, false, 41, c3951a);
        AppMethodBeat.m2505o(37726);
    }

    /* renamed from: b */
    private static void m21622b(String str, String str2, boolean z, int i, C3951a c3951a) {
        AppMethodBeat.m2504i(37727);
        C4990ab.m7416i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        C34990e.m57457a(str2, C13473h.m21625gj(str, str2), z, i, c3951a);
        AppMethodBeat.m2505o(37727);
    }

    /* renamed from: c */
    public static void m21623c(String str, String str2, boolean z, int i, C3951a c3951a) {
        AppMethodBeat.m2504i(37728);
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str)) {
            c3951a.cmD();
            AppMethodBeat.m2505o(37728);
        } else if (AdLandingPagesProxy.getInstance().isUseSnsDownloadImage()) {
            C13473h.m21621a(str, str2, c3951a);
            AppMethodBeat.m2505o(37728);
        } else {
            C13473h.m21622b(str, str2, z, i, c3951a);
            AppMethodBeat.m2505o(37728);
        }
    }

    /* renamed from: a */
    private static void m21621a(String str, String str2, C3951a c3951a) {
        AppMethodBeat.m2504i(37729);
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str)) {
            c3951a.cmD();
            AppMethodBeat.m2505o(37729);
            return;
        }
        C4990ab.m7416i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + str2 + " for adid:" + str);
        C34990e.m57456a(str2, C13473h.cqi(), C13473h.m21627gl(str, str2), c3951a);
        AppMethodBeat.m2505o(37729);
    }

    /* renamed from: d */
    public static void m21624d(String str, String str2, boolean z, int i, C3951a c3951a) {
        AppMethodBeat.m2504i(37730);
        C4990ab.m7416i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download sight for " + str2 + " for adid:" + str);
        C34990e.m57457a(str2, C13473h.m21626gk(str, str2), z, i, c3951a);
        AppMethodBeat.m2505o(37730);
    }

    public static String cqi() {
        AppMethodBeat.m2504i(37731);
        String str = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/";
        AppMethodBeat.m2505o(37731);
        return str;
    }
}
