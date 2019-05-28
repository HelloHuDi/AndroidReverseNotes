package com.tencent.p177mm.plugin.wenote.model.nativenote.p586c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.b */
public final class C46456b {
    public float hke = -1.0f;
    public float hkf = -1.0f;
    public int klY = 0;
    public float uQU = -1.0f;
    public float uQV = -1.0f;
    public int uQW = -1;
    public float uQX = -1.0f;
    public float uQY = -1.0f;
    public float uQZ = -1.0f;
    public float uRa = -1.0f;
    public int uRb = -1;

    /* renamed from: a */
    public final void mo74678a(int i, float f, float f2, float f3, float f4, int i2) {
        this.klY = i;
        this.uQU = f;
        this.uQV = f2;
        this.hke = f3;
        this.hkf = f4;
        if (this.klY == 1) {
            this.uQW = i2;
        } else {
            this.uQW = 0;
        }
    }

    public final void reset() {
        this.klY = 0;
        this.uQU = -1.0f;
        this.uQV = -1.0f;
        this.hke = -1.0f;
        this.hkf = -1.0f;
        this.uQW = -1;
        this.uQX = -1.0f;
        this.uQY = -1.0f;
        this.uQZ = -1.0f;
        this.uRa = -1.0f;
        this.uRb = -1;
    }

    private boolean deY() {
        return this.uQU >= 0.0f && this.uQV >= 0.0f && this.hke >= 0.0f && this.hkf >= 0.0f && this.uQW >= 0;
    }

    private boolean deZ() {
        return this.uQX >= 0.0f && this.uQY >= 0.0f && this.uQZ >= 0.0f && this.uRa >= 0.0f && this.uRb >= 0;
    }

    public final int getType() {
        AppMethodBeat.m2504i(26854);
        if (!deY()) {
            AppMethodBeat.m2505o(26854);
            return 0;
        } else if (deZ()) {
            int abs = Math.abs((int) (this.hke - this.uQZ));
            int abs2 = Math.abs((int) (this.hkf - this.uRa));
            if (abs > 30 || abs2 > 30 || this.uQW != this.uRb) {
                AppMethodBeat.m2505o(26854);
                return 3;
            }
            AppMethodBeat.m2505o(26854);
            return 2;
        } else {
            AppMethodBeat.m2505o(26854);
            return 1;
        }
    }
}
