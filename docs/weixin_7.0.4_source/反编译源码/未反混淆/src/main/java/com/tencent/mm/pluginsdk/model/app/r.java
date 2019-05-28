package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r {
    public String appId;
    public int fOZ;

    public r(String str, int i) {
        this.appId = str;
        this.fOZ = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(79360);
        if (obj == null) {
            AppMethodBeat.o(79360);
            return false;
        } else if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.appId.equals(this.appId) && rVar.fOZ == this.fOZ) {
                AppMethodBeat.o(79360);
                return true;
            }
            AppMethodBeat.o(79360);
            return false;
        } else {
            AppMethodBeat.o(79360);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(79361);
        String str = this.appId + this.fOZ;
        AppMethodBeat.o(79361);
        return str;
    }
}
