package com.tencent.ttpic.gles;

import android.graphics.PointF;
import com.tencent.filter.C41672h;
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
    public C41672h mTexFrame = new C41672h();
    public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
    public long mTimestamp;

    public interface OnFrameAvailableListener {
        void onFrameAvailable();
    }

    public TextureDataPipe() {
        AppMethodBeat.m2504i(50044);
        AppMethodBeat.m2505o(50044);
    }

    public void getTransformMatrix(float[] fArr) {
        AppMethodBeat.m2504i(50045);
        if (fArr.length != 16) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(50045);
            throw illegalArgumentException;
        }
        System.arraycopy(sMtxIdentity, 0, fArr, 0, sMtxIdentity.length);
        AppMethodBeat.m2505o(50045);
    }

    public boolean isBusy() {
        AppMethodBeat.m2504i(50046);
        if (this.mTextureDataFlag.get() == 1) {
            AppMethodBeat.m2505o(50046);
            return true;
        }
        AppMethodBeat.m2505o(50046);
        return false;
    }

    public boolean isReady() {
        AppMethodBeat.m2504i(50047);
        if (this.mTextureDataFlag.get() == 2) {
            AppMethodBeat.m2505o(50047);
            return true;
        }
        AppMethodBeat.m2505o(50047);
        return false;
    }

    public void release() {
        AppMethodBeat.m2504i(50048);
        this.mTexFrame.clear();
        AppMethodBeat.m2505o(50048);
    }

    public void makeFree() {
        AppMethodBeat.m2504i(50049);
        this.mTextureDataFlag.getAndSet(0);
        AppMethodBeat.m2505o(50049);
    }

    public void makeBusy() {
        AppMethodBeat.m2504i(50050);
        this.mTextureDataFlag.getAndSet(1);
        AppMethodBeat.m2505o(50050);
    }

    public void makeDataReady() {
        AppMethodBeat.m2504i(50051);
        this.mTextureDataFlag.getAndSet(2);
        AppMethodBeat.m2505o(50051);
    }

    public int getTexureCurrentStatus() {
        AppMethodBeat.m2504i(50052);
        int andAdd = this.mTextureDataFlag.getAndAdd(0);
        AppMethodBeat.m2505o(50052);
        return andAdd;
    }
}
