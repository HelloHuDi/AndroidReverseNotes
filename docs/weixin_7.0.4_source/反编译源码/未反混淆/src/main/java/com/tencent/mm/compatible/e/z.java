package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class z {
    public final int height;
    public final int width;

    public z(int i, int i2) {
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
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (this.width == zVar.width && this.height == zVar.height) {
            return true;
        }
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(93019);
        String str = this.width + VideoMaterialUtil.CRAZYFACE_X + this.height;
        AppMethodBeat.o(93019);
        return str;
    }

    public final int hashCode() {
        return this.height ^ ((this.width << 16) | (this.width >>> 16));
    }
}
