package com.tencent.mm.plugin.welab.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.x.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b uME = new b();
    public String tag = "";
    public Map<String, Integer> uLV = new HashMap();

    static {
        AppMethodBeat.i(80636);
        AppMethodBeat.o(80636);
    }

    public static b ddC() {
        return uME;
    }

    private b() {
        AppMethodBeat.i(80628);
        ddm();
        AppMethodBeat.o(80628);
    }

    private void ddm() {
        AppMethodBeat.i(80629);
        this.tag = (String) g.RP().Ry().get(a.USERINFO_WELAB_REDPOINT_STRING, null);
        ab.i("WeLabRedPointMgr", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (CharSequence charSequence : this.tag.split("&")) {
                if (!TextUtils.isEmpty(charSequence)) {
                    String[] split = charSequence.split("=");
                    if (split != null && split.length == 2) {
                        this.uLV.put(split[0], Integer.valueOf(bo.ank(split[1])));
                    }
                }
            }
        }
        AppMethodBeat.o(80629);
    }

    public final boolean e(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(80630);
        if (aVar.field_RedPoint != 1 || aVar.ddt()) {
            AppMethodBeat.o(80630);
            return false;
        } else if (agT(aVar.field_LabsAppId)) {
            AppMethodBeat.o(80630);
            return false;
        } else {
            AppMethodBeat.o(80630);
            return true;
        }
    }

    private boolean agT(String str) {
        AppMethodBeat.i(80631);
        if (this.uLV.containsKey(str) && ((Integer) this.uLV.get(str)).intValue() == 1) {
            AppMethodBeat.o(80631);
            return true;
        }
        AppMethodBeat.o(80631);
        return false;
    }

    public final void f(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(80632);
        if (aVar.field_RedPoint == 1 && !agT(aVar.field_LabsAppId) && aVar.ddu()) {
            c.PK().y(266267, true);
        }
        AppMethodBeat.o(80632);
    }

    public static void ddD() {
        Object obj;
        AppMethodBeat.i(80633);
        List<com.tencent.mm.plugin.welab.d.a.a> ddk = com.tencent.mm.plugin.welab.a.ddj().ddk();
        if (ddk == null || ddk.isEmpty()) {
        }
        for (com.tencent.mm.plugin.welab.d.a.a aVar : ddk) {
            if (aVar != null && uME.e(aVar)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            c.PK().bZ(266267, 266241);
        }
        AppMethodBeat.o(80633);
    }

    public static boolean ddE() {
        AppMethodBeat.i(80634);
        boolean bY = c.PK().bY(266267, 266241);
        AppMethodBeat.o(80634);
        return bY;
    }

    public static boolean ddF() {
        AppMethodBeat.i(80635);
        boolean z = ah.doB().getBoolean("key_has_enter_welab", false);
        AppMethodBeat.o(80635);
        return z;
    }
}
