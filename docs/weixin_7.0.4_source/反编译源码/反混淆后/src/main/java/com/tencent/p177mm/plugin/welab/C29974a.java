package com.tencent.p177mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C26207nl;
import com.tencent.p177mm.p230g.p231a.C45338kf;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C29973b;
import com.tencent.p177mm.plugin.welab.p1331d.C40360a;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.welab.a */
public final class C29974a {
    public static final C29974a uLP = new C29974a();
    public C40360a uLQ;
    public Map<String, C29973b> uLR = new HashMap();
    public C29973b uLS;
    public C25814c udB;

    public C29974a() {
        AppMethodBeat.m2504i(80527);
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePG = true;
        this.udB = c17927a.ahG();
        AppMethodBeat.m2505o(80527);
    }

    static {
        AppMethodBeat.m2504i(80535);
        AppMethodBeat.m2505o(80535);
    }

    public static C29974a ddj() {
        return uLP;
    }

    /* renamed from: a */
    public static String m47421a(C23169a c23169a) {
        AppMethodBeat.m2504i(80528);
        String str = "";
        C29973b agH = uLP.agH(c23169a.field_LabsAppId);
        if (agH != null) {
            str = agH.ddr();
            C4990ab.m7417i("WelabMgr", "get appName from opener , appid %s, appName %s", c23169a.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            str = c23169a.agR("field_Title");
        }
        AppMethodBeat.m2505o(80528);
        return str;
    }

    /* renamed from: b */
    public static String m47422b(C23169a c23169a) {
        AppMethodBeat.m2504i(80529);
        String str = "";
        C29973b agH = uLP.agH(c23169a.field_LabsAppId);
        if (agH != null) {
            str = agH.ddq();
            C4990ab.m7417i("WelabMgr", "get icon url from opener , appid %s, url %s", c23169a.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            str = c23169a.field_Icon;
        }
        AppMethodBeat.m2505o(80529);
        return str;
    }

    private C29973b agH(String str) {
        AppMethodBeat.m2504i(80530);
        C29973b c29973b = (C29973b) this.uLR.get(str);
        AppMethodBeat.m2505o(80530);
        return c29973b;
    }

    /* renamed from: Z */
    public static void m47420Z(boolean z, boolean z2) {
        AppMethodBeat.m2504i(80531);
        C43996e.m78983aa(z, z2);
        AppMethodBeat.m2505o(80531);
    }

    public final List<C23169a> ddk() {
        AppMethodBeat.m2504i(80532);
        List dds = this.uLQ.dds();
        Iterator it = dds.iterator();
        while (it.hasNext()) {
            C23169a c23169a = (C23169a) it.next();
            if (!c23169a.isRunning() || (!(c23169a.field_Switch == 2 || c23169a.field_Switch == 1) || "labs1de6f3".equals(c23169a.field_LabsAppId))) {
                it.remove();
            }
        }
        C4990ab.m7417i("WelabMgr", "online lab %s", dds.toString());
        AppMethodBeat.m2505o(80532);
        return dds;
    }

    public final C23169a agI(String str) {
        AppMethodBeat.m2504i(80533);
        C40360a c40360a = this.uLQ;
        C23169a c23169a = new C23169a();
        c23169a.field_LabsAppId = str;
        c40360a.mo10102b((C4925c) c23169a, new String[0]);
        AppMethodBeat.m2505o(80533);
        return c23169a;
    }

    /* renamed from: ed */
    public static void m47423ed(List<C23169a> list) {
        AppMethodBeat.m2504i(80534);
        if (!list.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList();
            for (C23169a c23169a : list) {
                if (!(c23169a.ddx() || c23169a.isExpired())) {
                    arrayList.add(c23169a.field_LabsAppId);
                }
            }
            C26207nl c26207nl = new C26207nl();
            c26207nl.cJJ.cJK = arrayList;
            C4879a.xxA.mo10055m(c26207nl);
            for (String equals : arrayList) {
                if ("labs_nearbylife".equals(equals)) {
                    C4879a.xxA.mo10055m(new C45338kf());
                    AppMethodBeat.m2505o(80534);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(80534);
    }
}
