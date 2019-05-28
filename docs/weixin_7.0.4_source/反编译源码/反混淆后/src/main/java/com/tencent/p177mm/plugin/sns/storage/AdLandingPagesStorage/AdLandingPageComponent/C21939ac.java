package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac */
public final class C21939ac {
    public float height;
    public String iconUrl;
    public float qWR;
    public float width;

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(36952);
        if (obj == this) {
            AppMethodBeat.m2505o(36952);
            return true;
        } else if (obj instanceof C21939ac) {
            C21939ac c21939ac = (C21939ac) obj;
            if (c21939ac.iconUrl.equals(this.iconUrl) && c21939ac.width == this.width && c21939ac.height == this.height && c21939ac.qWR == this.qWR) {
                AppMethodBeat.m2505o(36952);
                return true;
            }
            AppMethodBeat.m2505o(36952);
            return false;
        } else {
            AppMethodBeat.m2505o(36952);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(36953);
        int hashCode = super.hashCode();
        AppMethodBeat.m2505o(36953);
        return hashCode;
    }
}
