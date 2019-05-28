package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.axr;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.z */
public final class C38432z extends C7563j<C27157aa> {
    public static final String ihX = C7563j.m13217a(C27157aa.gSs, "LaunchWxaAppRespTable");

    /* renamed from: b */
    public final /* synthetic */ boolean mo10102b(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(131917);
        boolean a = mo61133a((C27157aa) c4925c, strArr);
        AppMethodBeat.m2505o(131917);
        return a;
    }

    static {
        AppMethodBeat.m2504i(131920);
        AppMethodBeat.m2505o(131920);
    }

    public C38432z(C4927e c4927e) {
        super(c4927e, C27157aa.gSs, "LaunchWxaAppRespTable", C27157aa.diI);
    }

    /* renamed from: a */
    public final C27157aa mo61132a(String str, axr axr) {
        AppMethodBeat.m2504i(131910);
        if (C5046bo.isNullOrNil(str) || axr == null) {
            AppMethodBeat.m2505o(131910);
            return null;
        }
        boolean z;
        C27157aa c27157aa = new C27157aa();
        c27157aa.mo44830a(axr);
        c27157aa.field_appId = str;
        C27157aa c27157aa2 = new C27157aa();
        c27157aa2.field_appId = str;
        boolean z2 = !mo61133a(c27157aa2, "appId");
        if (z2 || !c27157aa2.equals(c27157aa)) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            if (z2) {
                m65016a(c27157aa, false);
            } else {
                m65018b(c27157aa, false, "appId");
            }
        }
        if (z) {
            if (mo61133a(c27157aa2, "appId")) {
                AppMethodBeat.m2505o(131910);
                return c27157aa2;
            }
        }
        AppMethodBeat.m2505o(131910);
        return c27157aa;
    }

    /* renamed from: pI */
    public final boolean mo61134pI(String str) {
        AppMethodBeat.m2504i(131911);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(131911);
            return false;
        }
        C27157aa c27157aa = new C27157aa();
        c27157aa.field_appId = str;
        boolean a = m65017a(c27157aa, false, "appId");
        AppMethodBeat.m2505o(131911);
        return a;
    }

    /* renamed from: a */
    private boolean m65017a(C27157aa c27157aa, boolean z, String... strArr) {
        AppMethodBeat.m2504i(131912);
        if (!C5046bo.m7510Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    c27157aa.field_appIdHash = c27157aa.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean a = super.mo10100a((C4925c) c27157aa, z, strArr);
        AppMethodBeat.m2505o(131912);
        return a;
    }

    /* renamed from: a */
    public final boolean mo61133a(C27157aa c27157aa, String... strArr) {
        AppMethodBeat.m2504i(131913);
        if (!C5046bo.m7510Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    c27157aa.field_appIdHash = c27157aa.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean b = super.mo10102b((C4925c) c27157aa, strArr);
        AppMethodBeat.m2505o(131913);
        return b;
    }

    /* renamed from: a */
    private boolean m65016a(C27157aa c27157aa, boolean z) {
        AppMethodBeat.m2504i(131914);
        c27157aa.field_appIdHash = c27157aa.field_appId.hashCode();
        super.mo16759a((C4925c) c27157aa, z);
        C4990ab.m7417i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", c27157aa.field_appId, Boolean.valueOf(mo61133a(c27157aa, "appId")));
        AppMethodBeat.m2505o(131914);
        return mo61133a(c27157aa, "appId");
    }

    /* renamed from: b */
    private boolean m65018b(C27157aa c27157aa, boolean z, String... strArr) {
        AppMethodBeat.m2504i(131915);
        if (!C5046bo.m7510Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    c27157aa.field_appIdHash = c27157aa.field_appId.hashCode();
                    break;
                }
            }
        }
        C4990ab.m7417i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", c27157aa.field_appId, Boolean.valueOf(super.mo16762b(c27157aa, z, strArr)));
        AppMethodBeat.m2505o(131915);
        return super.mo16762b(c27157aa, z, strArr);
    }
}
