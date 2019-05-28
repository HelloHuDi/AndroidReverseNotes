package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.model.app.r */
final class C40441r {
    public String appId;
    public int fOZ;

    public C40441r(String str, int i) {
        this.appId = str;
        this.fOZ = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(79360);
        if (obj == null) {
            AppMethodBeat.m2505o(79360);
            return false;
        } else if (obj instanceof C40441r) {
            C40441r c40441r = (C40441r) obj;
            if (c40441r.appId.equals(this.appId) && c40441r.fOZ == this.fOZ) {
                AppMethodBeat.m2505o(79360);
                return true;
            }
            AppMethodBeat.m2505o(79360);
            return false;
        } else {
            AppMethodBeat.m2505o(79360);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(79361);
        String str = this.appId + this.fOZ;
        AppMethodBeat.m2505o(79361);
        return str;
    }
}
