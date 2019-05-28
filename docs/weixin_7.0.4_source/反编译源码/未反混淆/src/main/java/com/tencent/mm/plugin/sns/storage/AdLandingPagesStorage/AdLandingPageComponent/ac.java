package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac {
    public float height;
    public String iconUrl;
    public float qWR;
    public float width;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(36952);
        if (obj == this) {
            AppMethodBeat.o(36952);
            return true;
        } else if (obj instanceof ac) {
            ac acVar = (ac) obj;
            if (acVar.iconUrl.equals(this.iconUrl) && acVar.width == this.width && acVar.height == this.height && acVar.qWR == this.qWR) {
                AppMethodBeat.o(36952);
                return true;
            }
            AppMethodBeat.o(36952);
            return false;
        } else {
            AppMethodBeat.o(36952);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(36953);
        int hashCode = super.hashCode();
        AppMethodBeat.o(36953);
        return hashCode;
    }
}
