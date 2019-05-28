package com.tencent.p177mm.plugin.game.p428f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.f.d */
public final class C20964d {
    /* renamed from: a */
    public static void m32218a(C40439f c40439f) {
        AppMethodBeat.m2504i(112323);
        if (c40439f == null) {
            C4990ab.m7412e("MicroMsg.GameDataUtil", "Null appInfo");
            AppMethodBeat.m2505o(112323);
        } else if (C5046bo.isNullOrNil(c40439f.field_appId)) {
            C4990ab.m7412e("MicroMsg.GameDataUtil", "Invalid appId");
            AppMethodBeat.m2505o(112323);
        } else {
            boolean z;
            boolean n;
            String str = c40439f.field_appId;
            C40439f bT = C46494g.m87739bT(str, true);
            if (bT == null) {
                bT = new C40439f();
                bT.field_appId = str;
                z = true;
            } else {
                z = false;
            }
            String dor = C4988aa.dor();
            if (dor.equals("zh_CN")) {
                bT.field_appName = c40439f.field_appName;
            } else if (dor.equals("zh_TW") || dor.equals("zh_HK")) {
                bT.field_appName_tw = c40439f.field_appName;
            } else {
                bT.field_appName_en = c40439f.field_appName;
            }
            bT.field_appType = c40439f.field_appType;
            bT.field_packageName = c40439f.field_packageName;
            bT.mo44076ih(c40439f.dna);
            bT.mo44079ik(c40439f.dnf);
            bT.mo44071hq(c40439f.dnj);
            bT.mo44080il(c40439f.dng);
            bT.mo44085iq(c40439f.dnm);
            bT.mo44086ir(c40439f.dnn);
            bT.mo44083io(c40439f.dnk);
            bT.mo44084ip(c40439f.dnl);
            bT.mo44072hr(c40439f.dnp);
            if (!C5046bo.isNullOrNil(c40439f.dnd)) {
                bT.mo44077ii(c40439f.dnd);
            }
            if (z) {
                n = C34832a.bYJ().mo56573n(bT);
                C3753a.bYQ().mo25135Us(str);
            } else if (bT.field_appVersion < c40439f.field_appVersion) {
                C4990ab.m7417i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", Integer.valueOf(bT.field_appVersion), Integer.valueOf(c40439f.field_appVersion));
                n = C34832a.bYJ().mo56566a(bT, new String[0]);
                C3753a.bYQ().mo25135Us(str);
            } else if (C20964d.m32219a(bT, c40439f)) {
                C4990ab.m7417i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", bT.field_appIconUrl, c40439f.field_appIconUrl);
                bT.field_appIconUrl = c40439f.field_appIconUrl;
                n = C34832a.bYJ().mo56566a(bT, new String[0]);
                C34832a.bYH().mo48331dW(str, 1);
                C34832a.bYH().mo48331dW(str, 2);
                C34832a.bYH().mo48331dW(str, 3);
                C34832a.bYH().mo48331dW(str, 4);
                C34832a.bYH().mo48331dW(str, 5);
            } else {
                n = C34832a.bYJ().mo56566a(bT, new String[0]);
            }
            C4990ab.m7417i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", str, Boolean.valueOf(z), Boolean.valueOf(n));
            AppMethodBeat.m2505o(112323);
        }
    }

    /* renamed from: a */
    private static boolean m32219a(C40439f c40439f, C40439f c40439f2) {
        AppMethodBeat.m2504i(112324);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appIconUrl)) {
            AppMethodBeat.m2505o(112324);
            return true;
        } else if (c40439f2 == null || C5046bo.isNullOrNil(c40439f2.field_appIconUrl)) {
            AppMethodBeat.m2505o(112324);
            return false;
        } else if (c40439f.field_appIconUrl.equals(c40439f2.field_appIconUrl)) {
            AppMethodBeat.m2505o(112324);
            return false;
        } else {
            AppMethodBeat.m2505o(112324);
            return true;
        }
    }

    /* renamed from: ac */
    public static void m32220ac(LinkedList<? extends C40439f> linkedList) {
        AppMethodBeat.m2504i(112325);
        if (linkedList == null) {
            C4990ab.m7412e("MicroMsg.GameDataUtil", "Null appInfos");
            AppMethodBeat.m2505o(112325);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C20964d.m32218a((C40439f) it.next());
        }
        AppMethodBeat.m2505o(112325);
    }
}
