package com.tencent.p177mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.mm.plugin.api.recordView.d */
final class C33058d {
    static float[] eZY = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static final float[] eZZ = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    static final Object lock = new Object();
    volatile boolean eWi;
    int eZH;
    int eZI;
    int eZJ;
    int eZM;
    int eZN;
    int eZR;
    int eZS;
    ByteBuffer eZU;
    ByteBuffer eZV;
    FloatBuffer eZh;
    FloatBuffer eZi;
    private int fcn;
    private int fco;
    float[] gLB;
    volatile boolean gLJ;
    boolean gLv;
    int gLw;
    int gLx;
    int gLy;
    float[] gLz;
    int rotate;

    static {
        AppMethodBeat.m2504i(76336);
        AppMethodBeat.m2505o(76336);
    }

    public C33058d() {
        AppMethodBeat.m2504i(76334);
        this.fcn = 0;
        this.fco = 0;
        this.gLv = false;
        this.gLw = 0;
        this.gLx = 0;
        this.rotate = 0;
        this.eZM = -1;
        this.eZN = -1;
        this.eZH = -1;
        this.gLz = new float[16];
        this.gLB = eZY;
        this.eWi = false;
        this.gLJ = false;
        this.eWi = false;
        AppMethodBeat.m2505o(76334);
    }

    /* renamed from: cM */
    public final void mo53622cM(int i, int i2) {
        AppMethodBeat.m2504i(76335);
        C4990ab.m7417i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", Integer.valueOf(i), Integer.valueOf(i2), this);
        if (!(i == this.fcn && i2 == this.fco)) {
            C4990ab.m7416i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.fcn = i;
            this.fco = i2;
        }
        AppMethodBeat.m2505o(76335);
    }
}
