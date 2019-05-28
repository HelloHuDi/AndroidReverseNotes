package com.tencent.ttpic.gles;

import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TextureDataPipe {
    public static final int BUFFER_BUSY = 1;
    public static final int BUFFER_FREE = 0;
    public static final int BUFFER_READY = 2;
    public static final String TAG = "TextureDataPipe";
    private static float[] sMtxIdentity = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public List<List<PointF>> mPoints = new ArrayList();
    public h mTexFrame = new h();
    public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
    public long mTimestamp;

    public interface OnFrameAvailableListener {
        void onFrameAvailable();
    }

    public TextureDataPipe() {
        AppMethodBeat.i(50044);
        AppMethodBeat.o(50044);
    }

    public void getTransformMatrix(float[] fArr) {
        AppMethodBeat.i(50045);
        if (fArr.length != 16) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(50045);
            throw illegalArgumentException;
        }
        System.arraycopy(sMtxIdentity, 0, fArr, 0, sMtxIdentity.length);
        AppMethodBeat.o(50045);
    }

    public boolean isBusy() {
        AppMethodBeat.i(50046);
        if (this.mTextureDataFlag.get() == 1) {
            AppMethodBeat.o(50046);
            return true;
        }
        AppMethodBeat.o(50046);
        return false;
    }

    public boolean isReady() {
        AppMethodBeat.i(50047);
        if (this.mTextureDataFlag.get() == 2) {
            AppMethodBeat.o(50047);
            return true;
        }
        AppMethodBeat.o(50047);
        return false;
    }

    public void release() {
        AppMethodBeat.i(50048);
        this.mTexFrame.clear();
        AppMethodBeat.o(50048);
    }

    public void makeFree() {
        AppMethodBeat.i(50049);
        this.mTextureDataFlag.getAndSet(0);
        AppMethodBeat.o(50049);
    }

    public void makeBusy() {
        AppMethodBeat.i(50050);
        this.mTextureDataFlag.getAndSet(1);
        AppMethodBeat.o(50050);
    }

    public void makeDataReady() {
        AppMethodBeat.i(50051);
        this.mTextureDataFlag.getAndSet(2);
        AppMethodBeat.o(50051);
    }

    public int getTexureCurrentStatus() {
        AppMethodBeat.i(50052);
        int andAdd = this.mTextureDataFlag.getAndAdd(0);
        AppMethodBeat.o(50052);
        return andAdd;
    }
}
