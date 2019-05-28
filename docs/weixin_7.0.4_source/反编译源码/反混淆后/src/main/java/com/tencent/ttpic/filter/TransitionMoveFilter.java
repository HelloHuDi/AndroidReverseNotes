package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class TransitionMoveFilter extends BaseFilter implements ITransitionFilter {
    public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float moveX;\n uniform float moveY;\n \n void main(void) {\n     vec2 location = textureCoordinate + vec2(moveX, moveY); \n     if (location.x < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(1.0, 0.0)); \n     } else if (location.x > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(-1.0, 0.0)); \n     } else if (location.y < 0.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, 1.0)); \n     } else if (location.y > 1.0) { \n         gl_FragColor = texture2D(inputImageTexture, location + vec2(0.0, -1.0)); \n     } else { \n         gl_FragColor = texture2D(inputImageTexture2, location); \n     } \n }";
    private int easeCurve;
    private int moveOrientation = 1;
    private long transitionDuration;
    private long transitionStartTime = -1;

    public TransitionMoveFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(83065);
        initParams();
        AppMethodBeat.m2505o(83065);
    }

    private void initParams() {
        AppMethodBeat.m2504i(83066);
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        addParam(new C0933f("moveX", 0.0f));
        addParam(new C0933f("moveY", 0.0f));
        AppMethodBeat.m2505o(83066);
    }

    public void setDataPath(String str) {
    }

    public void setLastTex(int i) {
        AppMethodBeat.m2504i(83067);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(83067);
    }

    public void setDuration(long j) {
        this.transitionDuration = j;
    }

    public void setEaseCurve(int i) {
        this.easeCurve = i;
    }

    public void setMoveOrientation(int i) {
        this.moveOrientation = i;
    }

    public void updatePreview(long j) {
        AppMethodBeat.m2504i(83068);
        if (this.transitionStartTime < 0) {
            this.transitionStartTime = j;
        }
        updateTextureParam(j);
        AppMethodBeat.m2505o(83068);
    }

    private void updateTextureParam(long j) {
        float f;
        float f2 = 1.0f;
        AppMethodBeat.m2504i(83069);
        float duration = ((float) (((long) getDuration((double) this.transitionStartTime, (double) (this.transitionStartTime + this.transitionDuration), (double) j)) - this.transitionStartTime)) / ((float) this.transitionDuration);
        if (duration <= 1.0f) {
            f2 = duration;
        }
        if (this.moveOrientation == 1) {
            duration = 0.0f;
            f = f2;
        } else if (this.moveOrientation == 2) {
            duration = 0.0f;
            f = -f2;
        } else if (this.moveOrientation == 3) {
            duration = f2;
            f = 0.0f;
        } else {
            duration = -f2;
            f = 0.0f;
        }
        addParam(new C0933f("moveX", f));
        addParam(new C0933f("moveY", duration));
        AppMethodBeat.m2505o(83069);
    }

    public void reset() {
        AppMethodBeat.m2504i(83070);
        this.transitionStartTime = -1;
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        AppMethodBeat.m2505o(83070);
    }

    private double getDuration(double d, double d2, double d3) {
        AppMethodBeat.m2504i(83071);
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
        AppMethodBeat.m2505o(83071);
        return d4;
    }
}
