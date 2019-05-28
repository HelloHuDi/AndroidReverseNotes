package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C10173c;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31284f;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.l */
public final class C42611l extends C7563j<C42610k> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C42610k.gSs, "DevPkgLaunchExtInfo")};

    public C42611l(C4927e c4927e) {
        super(c4927e, C42610k.gSs, "DevPkgLaunchExtInfo", C42610k.diI);
    }

    static {
        AppMethodBeat.m2504i(102104);
        AppMethodBeat.m2505o(102104);
    }

    /* renamed from: bn */
    public final String mo68052bn(String str, int i) {
        AppMethodBeat.m2504i(102103);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(102103);
            return str2;
        }
        C4925c c42610k = new C42610k();
        c42610k.field_appId = str;
        c42610k.field_versionType = i;
        if (super.mo10102b(c42610k, C42610k.gSr)) {
            str2 = c42610k.field_extJson;
            AppMethodBeat.m2505o(102103);
            return str2;
        }
        str2 = "";
        AppMethodBeat.m2505o(102103);
        return str2;
    }

    /* renamed from: n */
    public final boolean mo68053n(String str, int i, String str2) {
        boolean z;
        AppMethodBeat.m2504i(102102);
        if (C5046bo.isNullOrNil(str)) {
            z = false;
        } else {
            C4925c c42610k = new C42610k();
            c42610k.field_appId = str;
            c42610k.field_versionType = i;
            if (super.mo10102b(c42610k, C42610k.gSr)) {
                c42610k.field_extJson = C5046bo.m7532bc(str2, "{}");
                z = super.mo10103c(c42610k, new String[0]);
            } else {
                c42610k.field_extJson = C5046bo.m7532bc(str2, "{}");
                z = super.mo10101b(c42610k);
            }
        }
        C45124d.m82930i("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "appId:%s,versionType:%s,extInfo:%s", str, Integer.valueOf(i), str2);
        if (z) {
            List zA;
            String optString;
            try {
                zA = C31284f.m50509zA(new JSONObject(str2).optString("module_list"));
            } catch (Exception e) {
                zA = null;
            }
            if (!C5046bo.m7548ek(zA)) {
                ((C0997b) C37384e.m62985B(C0997b.class)).mo3974xF().mo60847a(str, i, -1, zA);
            }
            try {
                zA = C10173c.m17798zy(new JSONObject(str2).optString("wxacode_lib_info_list"));
            } catch (Exception e2) {
                zA = null;
            }
            if (!C5046bo.m7548ek(zA)) {
                ((C0997b) C37384e.m62985B(C0997b.class)).mo3974xF().mo60858az(zA);
            }
            try {
                optString = new JSONObject(str2).optString("without_lib_md5");
            } catch (Exception e3) {
                optString = null;
            }
            if (!C5046bo.isNullOrNil(optString)) {
                ((C0997b) C37384e.m62985B(C0997b.class)).mo3974xF().mo60860b(str, "__WITHOUT_CODELIB__", 0, i, optString, 12);
            }
        }
        AppMethodBeat.m2505o(102102);
        return z;
    }
}
