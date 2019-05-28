package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.List;

final class j {
    static final j bTz;
    float bTA;
    float bTB;
    float bTC;
    float bTD;
    float bTE;
    float bTF;
    boolean bTG;
    float height;
    float width;

    j() {
    }

    static {
        AppMethodBeat.i(115955);
        j jVar = new j();
        bTz = jVar;
        jVar.height = 0.0f;
        jVar.width = 0.0f;
        jVar.bTB = 0.0f;
        jVar.bTA = 0.0f;
        jVar.bTF = 0.0f;
        jVar.bTE = 0.0f;
        jVar.bTD = 0.0f;
        jVar.bTC = 0.0f;
        AppMethodBeat.o(115955);
    }

    public final void z(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    public final void f(float f, float f2, float f3, float f4) {
        this.bTC = f;
        this.bTD = f2;
        this.bTE = f3;
        this.bTF = f4;
    }

    static void a(FloatBuffer floatBuffer, List<j> list) {
        AppMethodBeat.i(115953);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(115953);
            return;
        }
        for (j jVar : list) {
            if (jVar != null) {
                floatBuffer.put(jVar.bTA).put(jVar.bTB).put(jVar.width).put(jVar.height).put(jVar.bTC).put(jVar.bTD).put(jVar.bTE).put(jVar.bTF).put(jVar.bTG ? 1.0f : 0.0f);
            }
        }
        AppMethodBeat.o(115953);
    }

    public final String toString() {
        AppMethodBeat.i(115954);
        String str = "glyph(" + this.bTA + ", " + this.bTB + ", [" + this.width + ", " + this.height + "], [" + this.bTC + ", " + this.bTD + ", " + this.bTE + ", " + this.bTF + ", " + this.bTG + "])";
        AppMethodBeat.o(115954);
        return str;
    }
}
