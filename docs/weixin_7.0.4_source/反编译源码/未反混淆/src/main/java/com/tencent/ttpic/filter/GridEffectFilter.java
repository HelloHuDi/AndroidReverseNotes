package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GridEffectFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = " precision mediump float;\n   precision mediump int; \n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int gridType; \n \n void main(void) {\n     if (gridType == 0) { \n         gl_FragColor = texture2D(inputImageTexture, textureCoordinate); \n     } else if (gridType == 1) { \n         if (textureCoordinate.x <= 0.5) { \n             gl_FragColor = texture2D(inputImageTexture, vec2(1.0 - textureCoordinate.x * 2.0, textureCoordinate.y)); \n         } else { \n             gl_FragColor = texture2D(inputImageTexture, vec2(textureCoordinate.x * 2.0 - 1.0, textureCoordinate.y)); \n         } \n     } else if (gridType == 2) { \n         if (textureCoordinate.y <= 0.5) { \n             gl_FragColor = texture2D(inputImageTexture, vec2(textureCoordinate.x, 1.0 - textureCoordinate.y * 2.0)); \n         } else { \n             gl_FragColor = texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y * 2.0 - 1.0)); \n         } \n     } else if (gridType == 3) { \n         float px = textureCoordinate.x * 2.0; \n         float py = textureCoordinate.y * 2.0; \n         if (px > 1.0) { \n             px = px - 1.0; \n         } \n         if (py > 1.0) { \n             py = py - 1.0; \n         } \n         gl_FragColor = texture2D(inputImageTexture, vec2(px, py)); \n     } else if (gridType == 4) { \n         float px = textureCoordinate.x * 3.0; \n         float py = textureCoordinate.y * 3.0; \n         if (px > 2.0) { \n             px = px - 2.0; \n         } else if (px > 1.0) { \n             px = px - 1.0; \n         } \n         if (py > 2.0) { \n             py = py - 2.0; \n         } else if (py > 1.0) { \n             py = py - 1.0; \n         } \n         gl_FragColor = texture2D(inputImageTexture, vec2(px, py)); \n     } else if (gridType == 5) { \n     } else { \n         gl_FragColor = texture2D(inputImageTexture, textureCoordinate); \n     } \n }";

    public GridEffectFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82573);
        initParams();
        AppMethodBeat.o(82573);
    }

    private void initParams() {
        AppMethodBeat.i(82574);
        addParam(new i("gridType", 0));
        AppMethodBeat.o(82574);
    }

    public void setGridType(int i) {
        AppMethodBeat.i(82575);
        addParam(new i("gridType", i));
        AppMethodBeat.o(82575);
    }
}
