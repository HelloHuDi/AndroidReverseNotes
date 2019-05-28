package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.List;

/* renamed from: com.tencent.magicbrush.handler.glfont.j */
final class C32200j {
    static final C32200j bTz;
    float bTA;
    float bTB;
    float bTC;
    float bTD;
    float bTE;
    float bTF;
    boolean bTG;
    float height;
    float width;

    C32200j() {
    }

    static {
        AppMethodBeat.m2504i(115955);
        C32200j c32200j = new C32200j();
        bTz = c32200j;
        c32200j.height = 0.0f;
        c32200j.width = 0.0f;
        c32200j.bTB = 0.0f;
        c32200j.bTA = 0.0f;
        c32200j.bTF = 0.0f;
        c32200j.bTE = 0.0f;
        c32200j.bTD = 0.0f;
        c32200j.bTC = 0.0f;
        AppMethodBeat.m2505o(115955);
    }

    /* renamed from: z */
    public final void mo52867z(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    /* renamed from: f */
    public final void mo52865f(float f, float f2, float f3, float f4) {
        this.bTC = f;
        this.bTD = f2;
        this.bTE = f3;
        this.bTF = f4;
    }

    /* renamed from: a */
    static void m52524a(FloatBuffer floatBuffer, List<C32200j> list) {
        AppMethodBeat.m2504i(115953);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(115953);
            return;
        }
        for (C32200j c32200j : list) {
            if (c32200j != null) {
                floatBuffer.put(c32200j.bTA).put(c32200j.bTB).put(c32200j.width).put(c32200j.height).put(c32200j.bTC).put(c32200j.bTD).put(c32200j.bTE).put(c32200j.bTF).put(c32200j.bTG ? 1.0f : 0.0f);
            }
        }
        AppMethodBeat.m2505o(115953);
    }

    public final String toString() {
        AppMethodBeat.m2504i(115954);
        String str = "glyph(" + this.bTA + ", " + this.bTB + ", [" + this.width + ", " + this.height + "], [" + this.bTC + ", " + this.bTD + ", " + this.bTE + ", " + this.bTF + ", " + this.bTG + "])";
        AppMethodBeat.m2505o(115954);
        return str;
    }
}
