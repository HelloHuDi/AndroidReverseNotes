package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;

public class YUVTexSaveProcess implements TexSaveProcess {
    private byte[] mData;
    private BaseFilter mFilter = new BaseFilter(GLSLRender.bKt);
    private h mRenderFrame = new h();
    private byte[] mYUVAData;

    public YUVTexSaveProcess() {
        AppMethodBeat.i(84304);
        AppMethodBeat.o(84304);
    }

    public void init() {
        AppMethodBeat.i(84305);
        this.mFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
        AppMethodBeat.o(84305);
    }

    public byte[] retrieveData(int i, int i2, int i3) {
        AppMethodBeat.i(84306);
        init();
        initData(i2, i3);
        this.mRenderFrame.a(-1, i2, i3, 0.0d);
        this.mFilter.OnDrawFrameGLSL();
        this.mFilter.renderTexture(i, i2, i3);
        if (b.AIH < 0) {
            GLSLRender.nativeToRGBData(this.mYUVAData, i2, i3);
        } else {
            GLSLRender.nativePushDataFromTexture(this.mYUVAData, i2, i3, b.AIH);
        }
        AlgoUtils.YUVX2YUV(this.mYUVAData, this.mData, i2, i3);
        byte[] bArr = this.mData;
        AppMethodBeat.o(84306);
        return bArr;
    }

    public void clear() {
        AppMethodBeat.i(84307);
        this.mFilter.clearGLSLSelf();
        this.mRenderFrame.clear();
        this.mData = null;
        this.mYUVAData = null;
        AppMethodBeat.o(84307);
    }

    private void initData(int i, int i2) {
        int i3 = ((i * i2) * 3) / 2;
        if (this.mData == null || this.mData.length < i3) {
            this.mData = new byte[i3];
            this.mYUVAData = new byte[((i * i2) * 4)];
        }
    }
}
