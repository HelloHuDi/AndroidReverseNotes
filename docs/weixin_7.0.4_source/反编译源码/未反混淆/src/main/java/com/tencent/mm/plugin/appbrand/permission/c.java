package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.d;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static Set<String> iwi;

    static {
        AppMethodBeat.i(102245);
        HashSet hashSet = new HashSet();
        iwi = hashSet;
        hashSet.add(com.tencent.mm.plugin.appbrand.jsapi.live.c.NAME);
        iwi.add(d.NAME);
        AppMethodBeat.o(102245);
    }

    static int c(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, String str2) {
        boolean z;
        int i = j.INVALID_ID;
        AppMethodBeat.i(102244);
        if (cVar instanceof u) {
            z = true;
        } else {
            z = iwi.contains(str);
        }
        if (!z) {
            AppMethodBeat.o(102244);
        } else if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(102244);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("permissionBytes")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("permissionBytes");
                    if (jSONArray.length() < 3) {
                        ab.w("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", Integer.valueOf(jSONArray.length()));
                        AppMethodBeat.o(102244);
                    } else {
                        if (cVar instanceof q) {
                            switch (((q) cVar).getRuntime().gNN.gWy.awz()) {
                                case SUSPEND:
                                    i = jSONArray.optInt(2, j.INVALID_ID);
                                    break;
                                case DESTROYED:
                                case BACKGROUND:
                                    i = jSONArray.optInt(1, j.INVALID_ID);
                                    break;
                                default:
                                    i = jSONArray.optInt(0, j.INVALID_ID);
                                    break;
                            }
                        }
                        i = jSONArray.optInt(0, j.INVALID_ID);
                        ab.i("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", str, Integer.valueOf(i));
                        AppMethodBeat.o(102244);
                    }
                } else {
                    AppMethodBeat.o(102244);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", e.getMessage());
                AppMethodBeat.o(102244);
            }
        }
        return i;
    }
}
