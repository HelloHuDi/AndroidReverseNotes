package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFilter;
import com.tencent.ttpic.PTFilter.PTCopyFilter;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;

public class a {
    public static float FACE_DETECT_IMG_WIDTH = 180.0f;
    static final String TAG = a.class.getSimpleName();
    private boolean bZi = false;
    int eYW;
    int eYX;
    byte[] lho;
    PTFilter mPTFilter = null;
    private PTCopyFilter tbG = null;
    PTCopyFilter tbH = null;
    private int tbI;
    int tbJ;
    int tbK;
    private int tbL;
    private int tbM;
    private int tbN;
    int tbO;
    private boolean[] tbP = new boolean[7];

    public a() {
        AppMethodBeat.i(5119);
        AppMethodBeat.o(5119);
    }

    static {
        AppMethodBeat.i(5124);
        AppMethodBeat.o(5124);
    }

    public final void initial(int i, int i2) {
        AppMethodBeat.i(5120);
        clear();
        cLR();
        this.tbG = new PTCopyFilter();
        this.tbG.init();
        this.tbH = new PTCopyFilter();
        this.tbH.init();
        int[] iArr = new int[4];
        GLES20.glGenTextures(4, iArr, 0);
        this.tbK = iArr[0];
        this.tbL = iArr[1];
        this.tbM = iArr[2];
        this.tbN = iArr[3];
        this.tbI = i;
        this.tbJ = i2;
        iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.tbO = iArr[0];
        AppMethodBeat.o(5120);
    }

    private void cLR() {
        AppMethodBeat.i(GLType.GL_UNSIGNED_BYTE);
        a(TYPE.BASIC3, 10);
        a(TYPE.FACE_V, 0);
        a(TYPE.EYE, 0);
        a(TYPE.NOSE, 0);
        a(TYPE.CHIN, 0);
        AppMethodBeat.o(GLType.GL_UNSIGNED_BYTE);
    }

    private void a(TYPE type, int i) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(5122);
        boolean[] zArr;
        switch (type) {
            case EYE:
                zArr = this.tbP;
                if (i == 0) {
                    z = false;
                }
                zArr[0] = z;
                AppMethodBeat.o(5122);
                return;
            case CHIN:
                zArr = this.tbP;
                if (i != 0) {
                    z2 = true;
                }
                zArr[1] = z2;
                AppMethodBeat.o(5122);
                return;
            case NOSE:
                zArr = this.tbP;
                if (i == 0) {
                    z = false;
                }
                zArr[2] = z;
                AppMethodBeat.o(5122);
                return;
            case BASIC3:
                zArr = this.tbP;
                if (i == 0) {
                    z = false;
                }
                zArr[3] = z;
                AppMethodBeat.o(5122);
                return;
            case FACE_V:
                zArr = this.tbP;
                if (i == 0) {
                    z = false;
                }
                zArr[4] = z;
                AppMethodBeat.o(5122);
                return;
            case FACE_THIN:
                zArr = this.tbP;
                if (i == 0) {
                    z = false;
                }
                zArr[5] = z;
                AppMethodBeat.o(5122);
                return;
            case FACE_SHORTEN:
                zArr = this.tbP;
                if (i == 0) {
                    z = false;
                }
                zArr[6] = z;
                break;
        }
        AppMethodBeat.o(5122);
    }

    public final void clear() {
        AppMethodBeat.i(5123);
        if (this.mPTFilter != null) {
            this.mPTFilter.destroy();
            this.mPTFilter = null;
        }
        if (this.tbG != null) {
            this.tbG.destroy();
        }
        this.tbG = null;
        if (this.tbH != null) {
            this.tbH.destroy();
        }
        this.tbH = null;
        GLES20.glDeleteTextures(4, new int[]{this.tbK, this.tbL, this.tbM, this.tbN}, 0);
        GLES20.glDeleteFramebuffers(1, new int[]{this.tbO}, 0);
        AppMethodBeat.o(5123);
    }
}
