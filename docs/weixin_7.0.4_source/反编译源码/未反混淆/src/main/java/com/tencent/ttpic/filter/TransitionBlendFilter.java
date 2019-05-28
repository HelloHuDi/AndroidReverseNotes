package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.i;
import com.tencent.filter.m.l;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;

public class TransitionBlendFilter extends BaseFilter implements ITransitionFilter {
    public static final String FRAGMENT_SHADER = " precision mediump float;\n   precision mediump int; \n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform int maskType;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n     \n     if (maskType == 0) { \n         gl_FragColor = mix(last, current, mask.a); \n     } else if (maskType == 2) { \n         gl_FragColor = mask; \n     } else { \n         gl_FragColor = mix(last, current, mask.r); \n     } \n }";
    private String dataPath;
    private int easeCurve;
    private StickerItem item;
    private l mMaskParam = new l("inputImageTexture3");
    private long transitionDuration;
    private long transitionStartTime = -1;

    public TransitionBlendFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(83045);
        initParams();
        AppMethodBeat.o(83045);
    }

    private void initParams() {
        AppMethodBeat.i(83046);
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(this.mMaskParam);
        addParam(new i("maskType", 0));
        AppMethodBeat.o(83046);
    }

    public void setItem(StickerItem stickerItem) {
        this.item = stickerItem;
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setLastTex(int i) {
        AppMethodBeat.i(83047);
        addParam(new n("inputImageTexture2", i, 33986));
        AppMethodBeat.o(83047);
    }

    public void setDuration(long j) {
        this.transitionDuration = j;
    }

    public void setEaseCurve(int i) {
        this.easeCurve = i;
    }

    public void setMaskType(int i) {
        AppMethodBeat.i(83048);
        addParam(new i("maskType", i));
        AppMethodBeat.o(83048);
    }

    public void updatePreview(long j) {
        AppMethodBeat.i(83049);
        if (this.transitionStartTime < 0) {
            this.transitionStartTime = j;
        }
        updateTextureParam(j);
        AppMethodBeat.o(83049);
    }

    private void updateTextureParam(long j) {
        AppMethodBeat.i(83050);
        if (this.item.frames <= 0 || this.item.frameDuration <= 0.0d) {
            clearTextureParam();
            AppMethodBeat.o(83050);
            return;
        }
        Bitmap nextFrame = getNextFrame(((int) (((double) (((long) getDuration((double) this.transitionStartTime, (double) (this.transitionStartTime + this.transitionDuration), (double) j)) - this.transitionStartTime)) / Math.max(this.item.frameDuration, 1.0d))) % this.item.frames);
        if (BitmapUtils.isLegal(nextFrame)) {
            boolean z;
            l lVar = this.mMaskParam;
            lVar.bMS = nextFrame;
            if (lVar.bMS == null || lVar.bMS.isRecycled()) {
                z = false;
            } else {
                z = true;
            }
            lVar.update = z;
            AppMethodBeat.o(83050);
            return;
        }
        clearTextureParam();
        AppMethodBeat.o(83050);
    }

    private Bitmap getNextFrame(int i) {
        AppMethodBeat.i(83051);
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.id, i);
        if (loadImage == null) {
            loadImage = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + i + ".png", MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        }
        AppMethodBeat.o(83051);
        return loadImage;
    }

    /* Access modifiers changed, original: protected */
    public void clearTextureParam() {
        AppMethodBeat.i(83052);
        setPositions(GlUtil.EMPTY_POSITIONS);
        this.transitionStartTime = -1;
        AppMethodBeat.o(83052);
    }

    public void reset() {
        AppMethodBeat.i(83053);
        this.transitionStartTime = -1;
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        AppMethodBeat.o(83053);
    }

    private double getDuration(double d, double d2, double d3) {
        AppMethodBeat.i(83054);
        double d4 = (d3 - d) / (d2 - d);
        switch (this.easeCurve) {
            case 1:
                d4 = (Math.cos(d4 * 1.5707963267948966d) * (-(d2 - d))) + d2;
                break;
            case 2:
                d4 = (Math.sin(d4 * 1.5707963267948966d) * (d2 - d)) + d;
                break;
            case 3:
                d4 = ((Math.cos(d4 * 3.141592653589793d) - 1.0d) * ((-(d2 - d)) / 2.0d)) + d;
                break;
            default:
                d4 = (d4 * (d2 - d)) + d;
                break;
        }
        AppMethodBeat.o(83054);
        return d4;
    }
}
