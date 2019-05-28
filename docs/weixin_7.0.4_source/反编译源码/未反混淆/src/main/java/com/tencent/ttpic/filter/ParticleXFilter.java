package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.particlesystemx.ParticleItemX;
import com.tencent.ttpic.particlesystemx.ParticleSystemX;
import com.tencent.ttpic.particlesystemx.ParticleX;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class ParticleXFilter extends NormalVideoFilter {
    private FastRenderFilter fastRenderFilter = new FastRenderFilter();
    private float frameInterval;
    private long lastFrameTimestamp = -1;
    private FloatBuffer particleDataBuffer;
    private ParticleItemX particleItemX = new ParticleItemX();
    private List<RenderParam> renderParams = new ArrayList();
    private int templateIndex;

    public ParticleXFilter(StickerItem stickerItem, String str, int i) {
        super(stickerItem, str);
        AppMethodBeat.i(82720);
        this.templateIndex = i;
        this.particleDataBuffer = ByteBuffer.allocateDirect(((stickerItem.transition.particleCountMax * 6) * 2) * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        AppMethodBeat.o(82720);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82721);
        super.ApplyGLSLFilter();
        this.fastRenderFilter.applyGLSLFilter();
        this.fastRenderFilter.setBlendMode(this.item.blendMode);
        AppMethodBeat.o(82721);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list, float[] fArr, float f) {
        int i;
        int i2;
        AppMethodBeat.i(82722);
        this.renderParams.clear();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lastFrameTimestamp != -1) {
            this.frameInterval = (((float) (currentTimeMillis - this.lastFrameTimestamp)) * 1.0f) / 1000.0f;
        }
        this.lastFrameTimestamp = currentTimeMillis;
        switch (this.item.type) {
            case 1:
                if (((double) this.width) / ((double) this.height) < 0.75d) {
                    i = (int) (((double) this.height) * 0.75d);
                    i2 = (int) (((double) this.height) * this.item.position[1]);
                    this.particleItemX.emitterX = (float) (((int) (((double) i) * this.item.position[0])) - ((i - this.width) / 2));
                    this.particleItemX.emitterY = (float) i2;
                    this.particleItemX.screenRatioScale = (((float) this.height) * 1.0f) / 960.0f;
                    break;
                }
                i = (int) (((double) this.width) / 0.75d);
                i = ((int) (((double) i) * this.item.position[1])) - ((i - this.height) / 2);
                this.particleItemX.emitterX = (float) ((int) (((double) this.width) * this.item.position[0]));
                this.particleItemX.emitterY = (float) i;
                this.particleItemX.screenRatioScale = (((float) this.width) * 1.0f) / 720.0f;
                break;
            case 2:
            case 4:
                if (!(list == null || list.isEmpty())) {
                    PointF pointF = (PointF) list.get(this.item.alignFacePoints[0]);
                    PointF pointF2 = (PointF) list.get(this.item.alignFacePoints.length == 1 ? this.item.alignFacePoints[0] : this.item.alignFacePoints[1]);
                    PointF pointF3 = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
                    pointF3.x = (float) (((double) pointF3.x) / this.mFaceDetScale);
                    pointF3.y = (float) (((double) pointF3.y) / this.mFaceDetScale);
                    this.particleItemX.emitterX = pointF3.x;
                    this.particleItemX.emitterY = pointF3.y;
                    break;
                }
        }
        ParticleSystemX instance = ParticleSystemX.getInstance();
        i2 = this.templateIndex;
        float f2 = this.particleItemX.emitterX;
        float f3 = this.particleItemX.emitterY;
        FloatBuffer floatBuffer = this.particleDataBuffer;
        float f4 = this.frameInterval;
        boolean z = (list == null || list.isEmpty()) ? false : true;
        i = instance.advanceByTemplate(i2, f2, f3, floatBuffer, f4, z);
        float[] fArr2 = new float[(i * 6)];
        this.particleDataBuffer.position(0);
        this.particleDataBuffer.get(fArr2);
        ParticleX[] particleXArr = new ParticleX[i];
        for (i = 0; i < particleXArr.length; i++) {
            ParticleX particleX = new ParticleX();
            particleX.startX = fArr2[(i * 6) + 0];
            particleX.startY = fArr2[(i * 6) + 1];
            particleX.positionX = fArr2[(i * 6) + 2];
            particleX.positionY = fArr2[(i * 6) + 3];
            particleX.scale = fArr2[(i * 6) + 4];
            particleX.rotate = fArr2[(i * 6) + 5];
            particleXArr[i] = particleX;
        }
        for (ParticleX particleX2 : particleXArr) {
            float f5;
            switch (this.item.transition.emissionMode) {
                case 0:
                    f3 = particleX2.startX + (particleX2.positionX * this.particleItemX.screenRatioScale);
                    f5 = particleX2.startY + (particleX2.positionY * this.particleItemX.screenRatioScale);
                    break;
                case 1:
                    f3 = this.particleItemX.emitterX + (particleX2.positionX * this.particleItemX.screenRatioScale);
                    f5 = this.particleItemX.emitterY + (particleX2.positionY * this.particleItemX.screenRatioScale);
                    break;
                case 2:
                    f3 = particleX2.positionX * this.particleItemX.screenRatioScale;
                    f5 = particleX2.positionY * this.particleItemX.screenRatioScale;
                    break;
                default:
                    f3 = 0.0f;
                    f5 = 0.0f;
                    break;
            }
            int i3 = 0;
            i = 0;
            if (this.item.anchorPoint != null) {
                i3 = this.item.anchorPoint[0];
                i = this.item.anchorPoint[1];
            }
            i2 = i;
            float f6 = f3 - ((float) i3);
            f3 = f5 - ((float) i2);
            f2 = f6 + (((float) this.item.width) * this.particleItemX.screenRatioScale);
            float f7 = (((float) this.item.height) * this.particleItemX.screenRatioScale) + f3;
            RenderParam renderParam = new RenderParam();
            renderParam.texture = getTextureId();
            renderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
            renderParam.texScale = particleX2.scale;
            renderParam.texAnchor[0] = ((f6 + f2) / 2.0f) - ((float) (this.width / 2));
            renderParam.texAnchor[1] = ((f7 + f3) / 2.0f) - ((float) (this.height / 2));
            renderParam.texRotate[2] = particleX2.rotate;
            renderParam.position = AlgoUtils.calPositionsTriangles(f6, f7, f2, f3, this.width, this.height);
            this.renderParams.add(renderParam);
        }
        AppMethodBeat.o(82722);
    }

    /* Access modifiers changed, original: protected */
    public void clearTextureParam() {
        AppMethodBeat.i(82723);
        super.clearTextureParam();
        this.renderParams.clear();
        ParticleSystemX.getInstance().clearParticles(this.templateIndex);
        AppMethodBeat.o(82723);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82724);
        super.updateVideoSize(i, i2, d);
        this.fastRenderFilter.updateVideoSize(i, i2);
        AppMethodBeat.o(82724);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(82725);
        BenchUtil.benchStart("fastRenderFilter.render");
        this.fastRenderFilter.render(i, this.renderParams, null, true);
        BenchUtil.benchEnd("fastRenderFilter.render");
        AppMethodBeat.o(82725);
        return true;
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82726);
        super.clearGLSLSelf();
        this.fastRenderFilter.clearGLSLSelf();
        ParticleSystemX.getInstance().release();
        AppMethodBeat.o(82726);
    }
}
