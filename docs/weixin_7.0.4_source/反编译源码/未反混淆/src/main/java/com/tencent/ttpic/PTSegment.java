package com.tencent.ttpic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.opengl.GLES20;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.view.g;

public class PTSegment {
    private int SEG_HEIGHT = 16;
    private int SEG_WIDTH = 16;
    private FabbyStrokeFilter fabbyBgExtractFilter;
    private ExpFilter mExpFilter;
    private int mSegmentTex;
    private int mbgTex;
    private Bitmap mbp;
    private h segmentMaskFrame = new h();
    private h segmentOutFrame = new h();

    public PTSegment() {
        AppMethodBeat.i(81593);
        AppMethodBeat.o(81593);
    }

    public void init() {
        AppMethodBeat.i(81594);
        int[] iArr = new int[2];
        GLES20.glGenTextures(2, iArr, 0);
        this.mSegmentTex = iArr[0];
        this.mbgTex = iArr[1];
        this.mExpFilter = new ExpFilter();
        this.mExpFilter.ApplyGLSLFilter();
        this.fabbyBgExtractFilter = new FabbyStrokeFilter();
        this.fabbyBgExtractFilter.ApplyGLSLFilter();
        AppMethodBeat.o(81594);
    }

    public void setWidth_Height(int i, int i2) {
        this.SEG_WIDTH = i;
        this.SEG_HEIGHT = i2;
    }

    public h segTexture(PTFaceAttr pTFaceAttr, h hVar, float f, int i, int i2) {
        AppMethodBeat.i(81595);
        if (pTFaceAttr.getFaceCount() == 0 || !FabbyManager.getInstance().IsInitSuccess()) {
            AppMethodBeat.o(81595);
            return hVar;
        }
        if (this.mbp == null) {
            this.mbp = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.mbp.eraseColor(Color.argb(0, 255, 255, 255));
        }
        GlUtil.loadTexture(this.mbgTex, this.mbp);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        g.a(hVar.texture[0], i, i2, createBitmap);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, this.SEG_WIDTH * 16, this.SEG_HEIGHT * 16, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(this.SEG_WIDTH, this.SEG_HEIGHT, Config.ARGB_8888);
        FabbyManager.getInstance().segmentOnBitmap(createScaledBitmap, createBitmap2, this.SEG_WIDTH * 16, this.SEG_HEIGHT * 16, this.SEG_WIDTH, this.SEG_HEIGHT);
        GlUtil.loadTexture(this.mSegmentTex, createBitmap2);
        this.mExpFilter.updateParam((float) i, (float) i2, this.SEG_WIDTH, this.SEG_HEIGHT);
        this.mExpFilter.RenderProcess(this.mSegmentTex, i, i2, -1, 0.0d, this.segmentMaskFrame);
        this.fabbyBgExtractFilter.setRenderMode(1);
        this.fabbyBgExtractFilter.setmMaskTex(this.segmentMaskFrame.texture[0]);
        this.fabbyBgExtractFilter.setStepX(1.0f / ((float) i));
        this.fabbyBgExtractFilter.setStepY(1.0f / ((float) i2));
        this.fabbyBgExtractFilter.setStrokeGapInPixel(0.0f);
        this.fabbyBgExtractFilter.setStrokeWidthInPixel(((float) Math.min(i, i2)) * f);
        this.fabbyBgExtractFilter.setStrokeColor(new float[]{1.0f, 1.0f, 1.0f, 1.0f});
        this.fabbyBgExtractFilter.RenderProcess(hVar.texture[0], i, i2, this.mbgTex, 0.0d, this.segmentOutFrame);
        this.fabbyBgExtractFilter.setRenderMode(0);
        hVar = this.segmentOutFrame;
        AppMethodBeat.o(81595);
        return hVar;
    }

    public void destroy() {
        AppMethodBeat.i(81596);
        if (this.mExpFilter != null) {
            this.mExpFilter.clearGLSLSelf();
        }
        if (this.fabbyBgExtractFilter != null) {
            this.fabbyBgExtractFilter.clearGLSLSelf();
        }
        if (this.segmentMaskFrame != null) {
            this.segmentMaskFrame.clear();
        }
        if (this.segmentOutFrame != null) {
            this.segmentOutFrame.clear();
        }
        if (this.mbp != null) {
            this.mbp.recycle();
        }
        GLES20.glDeleteTextures(1, new int[]{this.mSegmentTex}, 0);
        AppMethodBeat.o(81596);
    }
}
