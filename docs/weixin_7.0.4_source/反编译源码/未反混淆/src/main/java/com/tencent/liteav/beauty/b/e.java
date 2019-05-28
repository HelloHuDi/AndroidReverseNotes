package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends q {
    private int A;
    private float[] B;
    private int x;
    private int y;
    private int z;

    public void c() {
        AppMethodBeat.i(67050);
        super.c();
        this.x = GLES20.glGetUniformLocation(p(), "screenMode");
        this.y = GLES20.glGetUniformLocation(p(), "screenReplaceColor");
        this.z = GLES20.glGetUniformLocation(p(), "screenMirrorX");
        this.A = GLES20.glGetUniformLocation(p(), "screenMirrorY");
        b(this.B);
        AppMethodBeat.o(67050);
    }

    public void b(float[] fArr) {
        AppMethodBeat.i(67051);
        b(this.y, new float[]{(float) (((0.2989d * ((double) fArr[0])) + (0.5866d * ((double) fArr[1]))) + (0.1145d * ((double) fArr[2]))), (float) (0.7132d * ((double) (fArr[0] - r0[0]))), (float) (0.5647d * ((double) (fArr[2] - r0[0])))});
        AppMethodBeat.o(67051);
    }
}
