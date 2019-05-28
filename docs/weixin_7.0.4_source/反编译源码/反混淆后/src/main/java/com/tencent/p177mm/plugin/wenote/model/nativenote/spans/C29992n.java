package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.n */
public final class C29992n extends C23184e {
    final boolean uRY;
    public final boolean uRZ;

    public C29992n(int i, int i2, boolean z, boolean z2) {
        super(i, i2);
        this.uRY = z;
        this.uRZ = z2;
    }

    /* renamed from: a */
    public final boolean mo48228a(C23184e c23184e) {
        AppMethodBeat.m2504i(26958);
        if (c23184e == null) {
            AppMethodBeat.m2505o(26958);
            return false;
        } else if (c23184e.isEmpty()) {
            boolean z;
            if (c23184e.aqm < this.aqm || c23184e.f4406Ls >= this.f4406Ls) {
                z = false;
            } else {
                z = true;
            }
            boolean z2;
            if (c23184e.aqm < this.aqm || c23184e.f4406Ls > this.f4406Ls) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || (z2 && this.uRZ)) {
                AppMethodBeat.m2505o(26958);
                return true;
            }
            AppMethodBeat.m2505o(26958);
            return false;
        } else if (Math.max(this.aqm, c23184e.aqm) < Math.min(this.f4406Ls, c23184e.f4406Ls)) {
            AppMethodBeat.m2505o(26958);
            return true;
        } else {
            AppMethodBeat.m2505o(26958);
            return false;
        }
    }

    public final int dfF() {
        AppMethodBeat.m2504i(26959);
        int abs = Math.abs(this.f4406Ls - this.aqm);
        AppMethodBeat.m2505o(26959);
        return abs;
    }
}
