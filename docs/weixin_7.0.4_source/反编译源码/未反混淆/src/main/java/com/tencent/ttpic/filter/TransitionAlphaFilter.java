package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class TransitionAlphaFilter extends BaseFilter implements ITransitionFilter {
    public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float alpha;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(last, current, alpha); \n }";
    private int easeCurve;
    private long transitionDuration;
    private long transitionStartTime = -1;

    public TransitionAlphaFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(83038);
        initParams();
        AppMethodBeat.o(83038);
    }

    private void initParams() {
        AppMethodBeat.i(83039);
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(new f("alpha", 0.0f));
        AppMethodBeat.o(83039);
    }

    public void setDataPath(String str) {
    }

    public void setLastTex(int i) {
        AppMethodBeat.i(83040);
        addParam(new n("inputImageTexture2", i, 33986));
        AppMethodBeat.o(83040);
    }

    public void setDuration(long j) {
        this.transitionDuration = j;
    }

    public void setEaseCurve(int i) {
        this.easeCurve = i;
    }

    public void updatePreview(long j) {
        AppMethodBeat.i(83041);
        if (this.transitionStartTime < 0) {
            this.transitionStartTime = j;
        }
        updateTextureParam(j);
        AppMethodBeat.o(83041);
    }

    private void updateTextureParam(long j) {
        float f = 1.0f;
        AppMethodBeat.i(83042);
        float duration = ((float) (((long) getDuration((double) this.transitionStartTime, (double) (this.transitionStartTime + this.transitionDuration), (double) j)) - this.transitionStartTime)) / ((float) this.transitionDuration);
        if (duration <= 1.0f) {
            f = duration;
        }
        addParam(new f("alpha", f));
        AppMethodBeat.o(83042);
    }

    public void reset() {
        AppMethodBeat.i(83043);
        this.transitionStartTime = -1;
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        AppMethodBeat.o(83043);
    }

    private double getDuration(double d, double d2, double d3) {
        AppMethodBeat.i(83044);
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
        AppMethodBeat.o(83044);
        return d4;
    }
}
