package com.tencent.p177mm.plugin.appbrand.permission;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.live.C10454d;
import com.tencent.p177mm.plugin.appbrand.jsapi.live.C46893c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.c */
public final class C42653c {
    private static Set<String> iwi;

    static {
        AppMethodBeat.m2504i(102245);
        HashSet hashSet = new HashSet();
        iwi = hashSet;
        hashSet.add(C46893c.NAME);
        iwi.add(C10454d.NAME);
        AppMethodBeat.m2505o(102245);
    }

    /* renamed from: c */
    static int m75525c(C2241c c2241c, String str, String str2) {
        boolean z;
        int i = C8415j.INVALID_ID;
        AppMethodBeat.m2504i(102244);
        if (c2241c instanceof C44709u) {
            z = true;
        } else {
            z = iwi.contains(str);
        }
        if (!z) {
            AppMethodBeat.m2505o(102244);
        } else if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(102244);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("permissionBytes")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("permissionBytes");
                    if (jSONArray.length() < 3) {
                        C4990ab.m7421w("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", Integer.valueOf(jSONArray.length()));
                        AppMethodBeat.m2505o(102244);
                    } else {
                        if (c2241c instanceof C38492q) {
                            switch (((C38492q) c2241c).getRuntime().gNN.gWy.awz()) {
                                case SUSPEND:
                                    i = jSONArray.optInt(2, C8415j.INVALID_ID);
                                    break;
                                case DESTROYED:
                                case BACKGROUND:
                                    i = jSONArray.optInt(1, C8415j.INVALID_ID);
                                    break;
                                default:
                                    i = jSONArray.optInt(0, C8415j.INVALID_ID);
                                    break;
                            }
                        }
                        i = jSONArray.optInt(0, C8415j.INVALID_ID);
                        C4990ab.m7417i("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", str, Integer.valueOf(i));
                        AppMethodBeat.m2505o(102244);
                    }
                } else {
                    AppMethodBeat.m2505o(102244);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", e.getMessage());
                AppMethodBeat.m2505o(102244);
            }
        }
        return i;
    }
}
