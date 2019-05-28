package com.tencent.p177mm.plugin.welab.p1563e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.plugin.welab.C29974a;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.welab.e.b */
public final class C46450b {
    private static final C46450b uME = new C46450b();
    public String tag = "";
    public Map<String, Integer> uLV = new HashMap();

    static {
        AppMethodBeat.m2504i(80636);
        AppMethodBeat.m2505o(80636);
    }

    public static C46450b ddC() {
        return uME;
    }

    private C46450b() {
        AppMethodBeat.m2504i(80628);
        ddm();
        AppMethodBeat.m2505o(80628);
    }

    private void ddm() {
        AppMethodBeat.m2504i(80629);
        this.tag = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WELAB_REDPOINT_STRING, null);
        C4990ab.m7416i("WeLabRedPointMgr", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (CharSequence charSequence : this.tag.split("&")) {
                if (!TextUtils.isEmpty(charSequence)) {
                    String[] split = charSequence.split("=");
                    if (split != null && split.length == 2) {
                        this.uLV.put(split[0], Integer.valueOf(C5046bo.ank(split[1])));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(80629);
    }

    /* renamed from: e */
    public final boolean mo74669e(C23169a c23169a) {
        AppMethodBeat.m2504i(80630);
        if (c23169a.field_RedPoint != 1 || c23169a.ddt()) {
            AppMethodBeat.m2505o(80630);
            return false;
        } else if (agT(c23169a.field_LabsAppId)) {
            AppMethodBeat.m2505o(80630);
            return false;
        } else {
            AppMethodBeat.m2505o(80630);
            return true;
        }
    }

    private boolean agT(String str) {
        AppMethodBeat.m2504i(80631);
        if (this.uLV.containsKey(str) && ((Integer) this.uLV.get(str)).intValue() == 1) {
            AppMethodBeat.m2505o(80631);
            return true;
        }
        AppMethodBeat.m2505o(80631);
        return false;
    }

    /* renamed from: f */
    public final void mo74670f(C23169a c23169a) {
        AppMethodBeat.m2504i(80632);
        if (c23169a.field_RedPoint == 1 && !agT(c23169a.field_LabsAppId) && c23169a.ddu()) {
            C16112c.m24429PK().mo28557y(266267, true);
        }
        AppMethodBeat.m2505o(80632);
    }

    public static void ddD() {
        Object obj;
        AppMethodBeat.m2504i(80633);
        List<C23169a> ddk = C29974a.ddj().ddk();
        if (ddk == null || ddk.isEmpty()) {
        }
        for (C23169a c23169a : ddk) {
            if (c23169a != null && uME.mo74669e(c23169a)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            C16112c.m24429PK().mo28553bZ(266267, 266241);
        }
        AppMethodBeat.m2505o(80633);
    }

    public static boolean ddE() {
        AppMethodBeat.m2504i(80634);
        boolean bY = C16112c.m24429PK().mo28552bY(266267, 266241);
        AppMethodBeat.m2505o(80634);
        return bY;
    }

    public static boolean ddF() {
        AppMethodBeat.m2504i(80635);
        boolean z = C4996ah.doB().getBoolean("key_has_enter_welab", false);
        AppMethodBeat.m2505o(80635);
        return z;
    }
}
