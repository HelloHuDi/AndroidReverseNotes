package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;

public class VideoBlendFilter2 extends BaseFilter {
    private static final String FRAGREMENT_SHADER = " precision highp float;\n varying vec2 canvasCoordinate;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec4 c1 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 c2 = texture2D(inputImageTexture, canvasCoordinate);\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     } else {\n        gl_FragColor = c1;\n     }\n}\n";
    private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}";
    private int blendmode;
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame = new C41672h();
    private float[] position = GlUtil.ORIGIN_POSITION_COORDS;
    private int watermarkHeight;
    private int watermarkWidth;

    public VideoBlendFilter2() {
        super(VERTEX_SHADER, FRAGREMENT_SHADER);
        AppMethodBeat.m2504i(49937);
        initParams();
        AppMethodBeat.m2505o(49937);
    }

    private void setBlendMode(int i) {
        AppMethodBeat.m2504i(49938);
        this.blendmode = i;
        addParam(new C0935i("blendmode", i));
        AppMethodBeat.m2505o(49938);
    }

    public void setWatermarkBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(49939);
        if (BitmapUtils.isLegal(bitmap)) {
            this.watermarkWidth = bitmap.getWidth();
            this.watermarkHeight = bitmap.getHeight();
            C25628k c25628k = new C25628k("inputImageTexture2", bitmap, 33986, true);
            c25628k.initialParams(getmProgramIds());
            addParam(c25628k);
            setBlendMode(1);
            AppMethodBeat.m2505o(49939);
            return;
        }
        this.watermarkHeight = 0;
        this.watermarkWidth = 0;
        setBlendMode(0);
        AppMethodBeat.m2505o(49939);
    }

    public void setWatermarkPosition(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(49940);
        this.position = AlgoUtils.calPositions((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), i5, i6);
        setPositions(this.position);
        AppMethodBeat.m2505o(49940);
    }

    public void initParams() {
        AppMethodBeat.m2504i(49941);
        addParam(new C0935i("blendmode", 0));
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        AppMethodBeat.m2505o(49941);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(49942);
        super.ApplyGLSLFilter();
        setPositions(this.position);
        setTexCords(GlUtil.ORIGIN_TEX_COORDS_REVERSE);
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(49942);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(49943);
        super.clearGLSLSelf();
        this.mCopyFilter.clearGLSLSelf();
        this.mCopyFrame.mo67193wF();
        AppMethodBeat.m2505o(49943);
    }

    public int getWatermarkWidth() {
        return this.watermarkWidth;
    }

    public int getWatermarkHeight() {
        return this.watermarkHeight;
    }

    public C41672h renderWatermark(int i, int i2, int i3) {
        AppMethodBeat.m2504i(49944);
        GlUtil.setBlendMode(true);
        this.mCopyFilter.RenderProcess(i, i2, i3, -1, 0.0d, this.mCopyFrame);
        OnDrawFrameGLSL();
        renderTexture(i, i2, i3);
        GlUtil.setBlendMode(false);
        C41672h c41672h = this.mCopyFrame;
        AppMethodBeat.m2505o(49944);
        return c41672h;
    }

    public boolean needRender() {
        return this.blendmode != 0;
    }
}
