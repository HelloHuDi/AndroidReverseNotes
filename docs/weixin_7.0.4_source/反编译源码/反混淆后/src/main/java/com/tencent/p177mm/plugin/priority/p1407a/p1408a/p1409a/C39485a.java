package com.tencent.p177mm.plugin.priority.p1407a.p1408a.p1409a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelcontrol.C45448b;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.priority.a.a.a.a */
public final class C39485a {
    /* renamed from: UE */
    public static final boolean m67464UE(String str) {
        boolean z;
        AppMethodBeat.m2504i(97739);
        if (C1855t.m3912mY(str) && C1855t.m3928nN(str)) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (!C1855t.m3896kH(str) || C1855t.m3927nM(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || z2) {
            AppMethodBeat.m2505o(97739);
            return true;
        }
        AppMethodBeat.m2505o(97739);
        return false;
    }

    public static final boolean bZv() {
        AppMethodBeat.m2504i(97740);
        if (!C39485a.bZw()) {
            AppMethodBeat.m2505o(97740);
            return false;
        } else if (C39485a.bZx()) {
            AppMethodBeat.m2505o(97740);
            return true;
        } else {
            AppMethodBeat.m2505o(97740);
            return false;
        }
    }

    public static final boolean bZw() {
        AppMethodBeat.m2504i(97741);
        if (C45448b.afz()) {
            AppMethodBeat.m2505o(97741);
            return false;
        }
        AppMethodBeat.m2505o(97741);
        return true;
    }

    public static final boolean bZx() {
        AppMethodBeat.m2504i(97742);
        int i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            C4990ab.m7416i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(97742);
            return false;
        } else if (i == 2 && !C5023at.isWifi(C4996ah.getContext())) {
            AppMethodBeat.m2505o(97742);
            return false;
        } else if (i != 1) {
            AppMethodBeat.m2505o(97742);
            return false;
        } else if (C5023at.isWifi(C4996ah.getContext())) {
            AppMethodBeat.m2505o(97742);
            return true;
        } else {
            boolean bZy = C39485a.bZy();
            AppMethodBeat.m2505o(97742);
            return bZy;
        }
    }

    private static boolean bZy() {
        AppMethodBeat.m2504i(97743);
        long j = (long) C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ChatImgAutoDownloadMax"), 0);
        long a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
        long anl = C5046bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
        long a2 = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, null), 0);
        C4990ab.m7410d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + anl + " month " + a2 + " maxcount " + j + " current " + a);
        if (anl != a2) {
            C4990ab.m7417i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", Long.valueOf(anl));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(0));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
            a = 0;
        }
        if (a <= j || j <= 0) {
            AppMethodBeat.m2505o(97743);
            return true;
        }
        C4990ab.m7416i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + a + " C2C image, can not auto download.");
        AppMethodBeat.m2505o(97743);
        return false;
    }
}
