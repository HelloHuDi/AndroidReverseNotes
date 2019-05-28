package com.google.p114b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.google.b.b */
public final class C45062b {
    public final int height;
    public final int width;

    public final boolean equals(Object obj) {
        if (!(obj instanceof C45062b)) {
            return false;
        }
        C45062b c45062b = (C45062b) obj;
        if (this.width == c45062b.width && this.height == c45062b.height) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public final String toString() {
        AppMethodBeat.m2504i(57216);
        String str = this.width + VideoMaterialUtil.CRAZYFACE_X + this.height;
        AppMethodBeat.m2505o(57216);
        return str;
    }
}
