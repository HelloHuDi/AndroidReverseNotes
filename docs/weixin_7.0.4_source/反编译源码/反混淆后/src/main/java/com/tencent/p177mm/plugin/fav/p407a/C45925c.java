package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32684bl;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;

/* renamed from: com.tencent.mm.plugin.fav.a.c */
public final class C45925c extends C32684bl {
    public static C4924a ccO = C32684bl.m53335Hm();

    static {
        AppMethodBeat.m2504i(102622);
        AppMethodBeat.m2505o(102622);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
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
        AppMethodBeat.m2504i(102621);
        float max = Math.max(0.0f, Math.min(99.0f, ((float) this.field_offset) / ((float) this.field_totalLen)) * 100.0f);
        AppMethodBeat.m2505o(102621);
        return max;
    }
}
