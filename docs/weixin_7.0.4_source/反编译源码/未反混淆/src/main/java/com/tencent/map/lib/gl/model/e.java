package com.tencent.map.lib.gl.model;

import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e {
    public float a;
    public float b;
    public float c;
    public float d = 1.0f;

    public e(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public e a(float[] fArr) {
        AppMethodBeat.i(98156);
        r0 = new float[4];
        Matrix.multiplyMV(r0, 0, fArr, 0, new float[]{this.a, this.b, this.c, this.d}, 0);
        e eVar = new e(r0[0] / r0[3], r0[1] / r0[3], r0[2] / r0[3]);
        AppMethodBeat.o(98156);
        return eVar;
    }

    public String toString() {
        AppMethodBeat.i(98157);
        String str = this.a + "," + this.b + "," + this.c;
        AppMethodBeat.o(98157);
        return str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a == eVar.a && this.b == eVar.b && this.c == eVar.c) {
            return true;
        }
        return false;
    }
}
