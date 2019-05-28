package com.tencent.p177mm.compatible.p221e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.compatible.e.z */
public final class C26046z {
    public final int height;
    public final int width;

    public C26046z(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C26046z)) {
            return false;
        }
        C26046z c26046z = (C26046z) obj;
        if (this.width == c26046z.width && this.height == c26046z.height) {
            return true;
        }
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(93019);
        String str = this.width + VideoMaterialUtil.CRAZYFACE_X + this.height;
        AppMethodBeat.m2505o(93019);
        return str;
    }

    public final int hashCode() {
        return this.height ^ ((this.width << 16) | (this.width >>> 16));
    }
}
