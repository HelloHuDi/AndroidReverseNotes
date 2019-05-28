package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class z extends j<aa> {
    public static final String ihX = j.a(aa.gSs, "LaunchWxaAppRespTable");

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        AppMethodBeat.i(131917);
        boolean a = a((aa) cVar, strArr);
        AppMethodBeat.o(131917);
        return a;
    }

    static {
        AppMethodBeat.i(131920);
        AppMethodBeat.o(131920);
    }

    public z(e eVar) {
        super(eVar, aa.gSs, "LaunchWxaAppRespTable", aa.diI);
    }

    public final aa a(String str, axr axr) {
        AppMethodBeat.i(131910);
        if (bo.isNullOrNil(str) || axr == null) {
            AppMethodBeat.o(131910);
            return null;
        }
        boolean z;
        aa aaVar = new aa();
        aaVar.a(axr);
        aaVar.field_appId = str;
        aa aaVar2 = new aa();
        aaVar2.field_appId = str;
        boolean z2 = !a(aaVar2, "appId");
        if (z2 || !aaVar2.equals(aaVar)) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            if (z2) {
                a(aaVar, false);
            } else {
                b(aaVar, false, "appId");
            }
        }
        if (z) {
            if (a(aaVar2, "appId")) {
                AppMethodBeat.o(131910);
                return aaVar2;
            }
        }
        AppMethodBeat.o(131910);
        return aaVar;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(131911);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(131911);
            return false;
        }
        aa aaVar = new aa();
        aaVar.field_appId = str;
        boolean a = a(aaVar, false, "appId");
        AppMethodBeat.o(131911);
        return a;
    }

    private boolean a(aa aaVar, boolean z, String... strArr) {
        AppMethodBeat.i(131912);
        if (!bo.Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    aaVar.field_appIdHash = aaVar.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean a = super.a((c) aaVar, z, strArr);
        AppMethodBeat.o(131912);
        return a;
    }

    public final boolean a(aa aaVar, String... strArr) {
        AppMethodBeat.i(131913);
        if (!bo.Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    aaVar.field_appIdHash = aaVar.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean b = super.b((c) aaVar, strArr);
        AppMethodBeat.o(131913);
        return b;
    }

    private boolean a(aa aaVar, boolean z) {
        AppMethodBeat.i(131914);
        aaVar.field_appIdHash = aaVar.field_appId.hashCode();
        super.a((c) aaVar, z);
        ab.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", aaVar.field_appId, Boolean.valueOf(a(aaVar, "appId")));
        AppMethodBeat.o(131914);
        return a(aaVar, "appId");
    }

    private boolean b(aa aaVar, boolean z, String... strArr) {
        AppMethodBeat.i(131915);
        if (!bo.Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    aaVar.field_appIdHash = aaVar.field_appId.hashCode();
                    break;
                }
            }
        }
        ab.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", aaVar.field_appId, Boolean.valueOf(super.b(aaVar, z, strArr)));
        AppMethodBeat.o(131915);
        return super.b(aaVar, z, strArr);
    }
}
