package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a {
    public static final a uLP = new a();
    public com.tencent.mm.plugin.welab.d.a uLQ;
    public Map<String, b> uLR = new HashMap();
    public b uLS;
    public c udB;

    public a() {
        AppMethodBeat.i(80527);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePH = true;
        aVar.ePG = true;
        this.udB = aVar.ahG();
        AppMethodBeat.o(80527);
    }

    static {
        AppMethodBeat.i(80535);
        AppMethodBeat.o(80535);
    }

    public static a ddj() {
        return uLP;
    }

    public static String a(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(80528);
        String str = "";
        b agH = uLP.agH(aVar.field_LabsAppId);
        if (agH != null) {
            str = agH.ddr();
            ab.i("WelabMgr", "get appName from opener , appid %s, appName %s", aVar.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            str = aVar.agR("field_Title");
        }
        AppMethodBeat.o(80528);
        return str;
    }

    public static String b(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(80529);
        String str = "";
        b agH = uLP.agH(aVar.field_LabsAppId);
        if (agH != null) {
            str = agH.ddq();
            ab.i("WelabMgr", "get icon url from opener , appid %s, url %s", aVar.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            str = aVar.field_Icon;
        }
        AppMethodBeat.o(80529);
        return str;
    }

    private b agH(String str) {
        AppMethodBeat.i(80530);
        b bVar = (b) this.uLR.get(str);
        AppMethodBeat.o(80530);
        return bVar;
    }

    public static void Z(boolean z, boolean z2) {
        AppMethodBeat.i(80531);
        e.aa(z, z2);
        AppMethodBeat.o(80531);
    }

    public final List<com.tencent.mm.plugin.welab.d.a.a> ddk() {
        AppMethodBeat.i(80532);
        List dds = this.uLQ.dds();
        Iterator it = dds.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.welab.d.a.a aVar = (com.tencent.mm.plugin.welab.d.a.a) it.next();
            if (!aVar.isRunning() || (!(aVar.field_Switch == 2 || aVar.field_Switch == 1) || "labs1de6f3".equals(aVar.field_LabsAppId))) {
                it.remove();
            }
        }
        ab.i("WelabMgr", "online lab %s", dds.toString());
        AppMethodBeat.o(80532);
        return dds;
    }

    public final com.tencent.mm.plugin.welab.d.a.a agI(String str) {
        AppMethodBeat.i(80533);
        com.tencent.mm.plugin.welab.d.a aVar = this.uLQ;
        com.tencent.mm.plugin.welab.d.a.a aVar2 = new com.tencent.mm.plugin.welab.d.a.a();
        aVar2.field_LabsAppId = str;
        aVar.b((com.tencent.mm.sdk.e.c) aVar2, new String[0]);
        AppMethodBeat.o(80533);
        return aVar2;
    }

    public static void ed(List<com.tencent.mm.plugin.welab.d.a.a> list) {
        AppMethodBeat.i(80534);
        if (!list.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList();
            for (com.tencent.mm.plugin.welab.d.a.a aVar : list) {
                if (!(aVar.ddx() || aVar.isExpired())) {
                    arrayList.add(aVar.field_LabsAppId);
                }
            }
            nl nlVar = new nl();
            nlVar.cJJ.cJK = arrayList;
            com.tencent.mm.sdk.b.a.xxA.m(nlVar);
            for (String equals : arrayList) {
                if ("labs_nearbylife".equals(equals)) {
                    com.tencent.mm.sdk.b.a.xxA.m(new kf());
                    AppMethodBeat.o(80534);
                    return;
                }
            }
        }
        AppMethodBeat.o(80534);
    }
}
