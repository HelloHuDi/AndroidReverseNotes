package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C25624m.C25634l;
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
    private C25634l mMaskParam = new C25634l("inputImageTexture3");
    private long transitionDuration;
    private long transitionStartTime = -1;

    public TransitionBlendFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(83045);
        initParams();
        AppMethodBeat.m2505o(83045);
    }

    private void initParams() {
        AppMethodBeat.m2504i(83046);
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        addParam(this.mMaskParam);
        addParam(new C0935i("maskType", 0));
        AppMethodBeat.m2505o(83046);
    }

    public void setItem(StickerItem stickerItem) {
        this.item = stickerItem;
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setLastTex(int i) {
        AppMethodBeat.m2504i(83047);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(83047);
    }

    public void setDuration(long j) {
        this.transitionDuration = j;
    }

    public void setEaseCurve(int i) {
        this.easeCurve = i;
    }

    public void setMaskType(int i) {
        AppMethodBeat.m2504i(83048);
        addParam(new C0935i("maskType", i));
        AppMethodBeat.m2505o(83048);
    }

    public void updatePreview(long j) {
        AppMethodBeat.m2504i(83049);
        if (this.transitionStartTime < 0) {
            this.transitionStartTime = j;
        }
        updateTextureParam(j);
        AppMethodBeat.m2505o(83049);
    }

    private void updateTextureParam(long j) {
        AppMethodBeat.m2504i(83050);
        if (this.item.frames <= 0 || this.item.frameDuration <= 0.0d) {
            clearTextureParam();
            AppMethodBeat.m2505o(83050);
            return;
        }
        Bitmap nextFrame = getNextFrame(((int) (((double) (((long) getDuration((double) this.transitionStartTime, (double) (this.transitionStartTime + this.transitionDuration), (double) j)) - this.transitionStartTime)) / Math.max(this.item.frameDuration, 1.0d))) % this.item.frames);
        if (BitmapUtils.isLegal(nextFrame)) {
            boolean z;
            C25634l c25634l = this.mMaskParam;
            c25634l.bMS = nextFrame;
            if (c25634l.bMS == null || c25634l.bMS.isRecycled()) {
                z = false;
            } else {
                z = true;
            }
            c25634l.update = z;
            AppMethodBeat.m2505o(83050);
            return;
        }
        clearTextureParam();
        AppMethodBeat.m2505o(83050);
    }

    private Bitmap getNextFrame(int i) {
        AppMethodBeat.m2504i(83051);
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.f18271id, i);
        if (loadImage == null) {
            loadImage = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.f18271id + "_" + i + ".png", MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        }
        AppMethodBeat.m2505o(83051);
        return loadImage;
    }

    /* Access modifiers changed, original: protected */
    public void clearTextureParam() {
        AppMethodBeat.m2504i(83052);
        setPositions(GlUtil.EMPTY_POSITIONS);
        this.transitionStartTime = -1;
        AppMethodBeat.m2505o(83052);
    }

    public void reset() {
        AppMethodBeat.m2504i(83053);
        this.transitionStartTime = -1;
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        AppMethodBeat.m2505o(83053);
    }

    private double getDuration(double d, double d2, double d3) {
        AppMethodBeat.m2504i(83054);
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
        AppMethodBeat.m2505o(83054);
        return d4;
    }
}
