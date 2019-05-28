package com.tencent.ttpic.gles;

import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GLSegSharedData {
    public EGLContext mSharedContext;
    public SegmentDataPipe[] mTexturePile = new SegmentDataPipe[2];

    public GLSegSharedData(EGLContext eGLContext) {
        AppMethodBeat.i(83229);
        this.mSharedContext = eGLContext;
        this.mTexturePile[0] = new SegmentDataPipe();
        this.mTexturePile[1] = new SegmentDataPipe();
        AppMethodBeat.o(83229);
    }

    public SegmentDataPipe getCurrentTexturePile() {
        int i;
        AppMethodBeat.i(83230);
        int i2 = this.mTexturePile[0].getTexureCurrentStatus() == 2 ? 1 : 0;
        if (this.mTexturePile[1].getTexureCurrentStatus() == 2) {
            i = 1;
        } else {
            i = 0;
        }
        SegmentDataPipe segmentDataPipe = (i2 == 0 || i == 0) ? i2 != 0 ? this.mTexturePile[0] : i != 0 ? this.mTexturePile[1] : null : this.mTexturePile[0].mTimestamp < this.mTexturePile[1].mTimestamp ? this.mTexturePile[0] : this.mTexturePile[1];
        AppMethodBeat.o(83230);
        return segmentDataPipe;
    }

    public SegmentDataPipe getFreeTexturePileMakeBusy() {
        SegmentDataPipe segmentDataPipe;
        AppMethodBeat.i(83231);
        for (int i = 0; i < this.mTexturePile.length; i++) {
            if (this.mTexturePile[i].getTexureCurrentStatus() == 0) {
                segmentDataPipe = this.mTexturePile[i];
                segmentDataPipe.makeBusy();
                break;
            }
        }
        segmentDataPipe = null;
        AppMethodBeat.o(83231);
        return segmentDataPipe;
    }

    public boolean judgeBrotherTextureIsReady(SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.i(83232);
        SegmentDataPipe segmentDataPipe2 = this.mTexturePile[0];
        if (this.mTexturePile[0] == segmentDataPipe) {
            segmentDataPipe2 = this.mTexturePile[1];
        }
        if (segmentDataPipe2.getTexureCurrentStatus() == 2) {
            AppMethodBeat.o(83232);
            return true;
        }
        AppMethodBeat.o(83232);
        return false;
    }

    public void clear() {
        AppMethodBeat.i(83233);
        for (SegmentDataPipe release : this.mTexturePile) {
            release.release();
        }
        AppMethodBeat.o(83233);
    }

    public void reset() {
        AppMethodBeat.i(83234);
        for (SegmentDataPipe makeFree : this.mTexturePile) {
            makeFree.makeFree();
        }
        AppMethodBeat.o(83234);
    }

    public void makeBrotherTextureFree(SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.i(83235);
        SegmentDataPipe segmentDataPipe2 = this.mTexturePile[0];
        if (this.mTexturePile[0] == segmentDataPipe) {
            segmentDataPipe2 = this.mTexturePile[1];
        }
        segmentDataPipe2.makeFree();
        AppMethodBeat.o(83235);
    }
}
