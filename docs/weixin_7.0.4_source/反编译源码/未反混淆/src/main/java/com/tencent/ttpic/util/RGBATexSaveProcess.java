package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.WMElement;

public class RGBATexSaveProcess implements TexSaveProcess {
    private byte[] mData;
    private BaseFilter mFilter = new BaseFilter(GLSLRender.bJB);
    private h mRenderFrame = new h();

    public RGBATexSaveProcess() {
        AppMethodBeat.i(83942);
        AppMethodBeat.o(83942);
    }

    public void init() {
        AppMethodBeat.i(83943);
        this.mFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
        AppMethodBeat.o(83943);
    }

    public byte[] retrieveData(int i, int i2, int i3) {
        AppMethodBeat.i(83944);
        init();
        initData(i2, i3);
        BenchUtil.benchStart(WMElement.ANIMATE_TYPE_SCALE);
        FrameUtil.clearFrame(this.mRenderFrame, 0.0f, 0.0f, 0.0f, 0.0f, i2, i3);
        this.mFilter.RenderProcess(i, i2, i3, -1, 0.0d, this.mRenderFrame);
        BenchUtil.benchEnd(WMElement.ANIMATE_TYPE_SCALE);
        BenchUtil.benchStart("saveTextureToRgbaBuffer");
        GlUtil.saveTextureToRgbaBuffer(this.mRenderFrame.texture[0], i2, i3, this.mData, this.mRenderFrame.bJz[0]);
        BenchUtil.benchEnd("saveTextureToRgbaBuffer");
        byte[] bArr = this.mData;
        AppMethodBeat.o(83944);
        return bArr;
    }

    public void clear() {
        AppMethodBeat.i(83945);
        this.mFilter.clearGLSLSelf();
        this.mRenderFrame.clear();
        this.mData = null;
        AppMethodBeat.o(83945);
    }

    private void initData(int i, int i2) {
        int i3 = (i * i2) * 4;
        if (this.mData == null || this.mData.length != i3) {
            this.mData = new byte[i3];
        }
    }
}
