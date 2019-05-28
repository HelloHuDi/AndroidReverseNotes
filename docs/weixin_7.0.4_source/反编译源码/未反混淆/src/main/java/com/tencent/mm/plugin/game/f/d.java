package com.tencent.mm.plugin.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void a(f fVar) {
        AppMethodBeat.i(112323);
        if (fVar == null) {
            ab.e("MicroMsg.GameDataUtil", "Null appInfo");
            AppMethodBeat.o(112323);
        } else if (bo.isNullOrNil(fVar.field_appId)) {
            ab.e("MicroMsg.GameDataUtil", "Invalid appId");
            AppMethodBeat.o(112323);
        } else {
            boolean z;
            boolean n;
            String str = fVar.field_appId;
            f bT = g.bT(str, true);
            if (bT == null) {
                bT = new f();
                bT.field_appId = str;
                z = true;
            } else {
                z = false;
            }
            String dor = aa.dor();
            if (dor.equals("zh_CN")) {
                bT.field_appName = fVar.field_appName;
            } else if (dor.equals("zh_TW") || dor.equals("zh_HK")) {
                bT.field_appName_tw = fVar.field_appName;
            } else {
                bT.field_appName_en = fVar.field_appName;
            }
            bT.field_appType = fVar.field_appType;
            bT.field_packageName = fVar.field_packageName;
            bT.ih(fVar.dna);
            bT.ik(fVar.dnf);
            bT.hq(fVar.dnj);
            bT.il(fVar.dng);
            bT.iq(fVar.dnm);
            bT.ir(fVar.dnn);
            bT.io(fVar.dnk);
            bT.ip(fVar.dnl);
            bT.hr(fVar.dnp);
            if (!bo.isNullOrNil(fVar.dnd)) {
                bT.ii(fVar.dnd);
            }
            if (z) {
                n = a.bYJ().n(bT);
                com.tencent.mm.plugin.s.a.a.a.bYQ().Us(str);
            } else if (bT.field_appVersion < fVar.field_appVersion) {
                ab.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", Integer.valueOf(bT.field_appVersion), Integer.valueOf(fVar.field_appVersion));
                n = a.bYJ().a(bT, new String[0]);
                com.tencent.mm.plugin.s.a.a.a.bYQ().Us(str);
            } else if (a(bT, fVar)) {
                ab.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", bT.field_appIconUrl, fVar.field_appIconUrl);
                bT.field_appIconUrl = fVar.field_appIconUrl;
                n = a.bYJ().a(bT, new String[0]);
                a.bYH().dW(str, 1);
                a.bYH().dW(str, 2);
                a.bYH().dW(str, 3);
                a.bYH().dW(str, 4);
                a.bYH().dW(str, 5);
            } else {
                n = a.bYJ().a(bT, new String[0]);
            }
            ab.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", str, Boolean.valueOf(z), Boolean.valueOf(n));
            AppMethodBeat.o(112323);
        }
    }

    private static boolean a(f fVar, f fVar2) {
        AppMethodBeat.i(112324);
        if (fVar == null || bo.isNullOrNil(fVar.field_appIconUrl)) {
            AppMethodBeat.o(112324);
            return true;
        } else if (fVar2 == null || bo.isNullOrNil(fVar2.field_appIconUrl)) {
            AppMethodBeat.o(112324);
            return false;
        } else if (fVar.field_appIconUrl.equals(fVar2.field_appIconUrl)) {
            AppMethodBeat.o(112324);
            return false;
        } else {
            AppMethodBeat.o(112324);
            return true;
        }
    }

    public static void ac(LinkedList<? extends f> linkedList) {
        AppMethodBeat.i(112325);
        if (linkedList == null) {
            ab.e("MicroMsg.GameDataUtil", "Null appInfos");
            AppMethodBeat.o(112325);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a((f) it.next());
        }
        AppMethodBeat.o(112325);
    }
}
