package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bl;
import com.tencent.mm.sdk.e.c.a;

public final class c extends bl {
    public static a ccO = bl.Hm();

    static {
        AppMethodBeat.i(102622);
        AppMethodBeat.o(102622);
    }

    public final a Ag() {
        return ccO;
    }

    public final boolean buq() {
        if (this.field_dataType == 4) {
            return true;
        }
        return false;
    }

    public final boolean isFinished() {
        return this.field_status == 3;
    }

    public final float getProgress() {
        AppMethodBeat.i(102621);
        float max = Math.max(0.0f, Math.min(99.0f, ((float) this.field_offset) / ((float) this.field_totalLen)) * 100.0f);
        AppMethodBeat.o(102621);
        return max;
    }
}
