package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONObject;

public final class l extends j<k> {
    public static final String[] fjY = new String[]{j.a(k.gSs, "DevPkgLaunchExtInfo")};

    public l(e eVar) {
        super(eVar, k.gSs, "DevPkgLaunchExtInfo", k.diI);
    }

    static {
        AppMethodBeat.i(102104);
        AppMethodBeat.o(102104);
    }

    public final String bn(String str, int i) {
        AppMethodBeat.i(102103);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(102103);
            return str2;
        }
        c kVar = new k();
        kVar.field_appId = str;
        kVar.field_versionType = i;
        if (super.b(kVar, k.gSr)) {
            str2 = kVar.field_extJson;
            AppMethodBeat.o(102103);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(102103);
        return str2;
    }

    public final boolean n(String str, int i, String str2) {
        boolean z;
        AppMethodBeat.i(102102);
        if (bo.isNullOrNil(str)) {
            z = false;
        } else {
            c kVar = new k();
            kVar.field_appId = str;
            kVar.field_versionType = i;
            if (super.b(kVar, k.gSr)) {
                kVar.field_extJson = bo.bc(str2, "{}");
                z = super.c(kVar, new String[0]);
            } else {
                kVar.field_extJson = bo.bc(str2, "{}");
                z = super.b(kVar);
            }
        }
        d.i("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "appId:%s,versionType:%s,extInfo:%s", str, Integer.valueOf(i), str2);
        if (z) {
            List zA;
            String optString;
            try {
                zA = f.zA(new JSONObject(str2).optString("module_list"));
            } catch (Exception e) {
                zA = null;
            }
            if (!bo.ek(zA)) {
                ((b) com.tencent.luggage.a.e.B(b.class)).xF().a(str, i, -1, zA);
            }
            try {
                zA = WxaAttributes.c.zy(new JSONObject(str2).optString("wxacode_lib_info_list"));
            } catch (Exception e2) {
                zA = null;
            }
            if (!bo.ek(zA)) {
                ((b) com.tencent.luggage.a.e.B(b.class)).xF().az(zA);
            }
            try {
                optString = new JSONObject(str2).optString("without_lib_md5");
            } catch (Exception e3) {
                optString = null;
            }
            if (!bo.isNullOrNil(optString)) {
                ((b) com.tencent.luggage.a.e.B(b.class)).xF().b(str, "__WITHOUT_CODELIB__", 0, i, optString, 12);
            }
        }
        AppMethodBeat.o(102102);
        return z;
    }
}
