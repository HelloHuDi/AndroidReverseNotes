package com.tencent.ttpic.filter;

import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.Map;

public class AlgoToothWhitenFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/AlgoToothWhitenFragmentShader.dat");
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/AlgoToothWhitenVertexShader.dat");
    private int algoTexture;
    private float centerX;
    private float centerY;
    private float eyePouch = 0.0f;
    private float radius;
    private float whiteTeeth = 0.0f;

    static {
        AppMethodBeat.i(81951);
        AppMethodBeat.o(81951);
    }

    public AlgoToothWhitenFilter(int i, float f, float f2, float f3) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(81948);
        this.algoTexture = i;
        this.radius = f;
        this.centerX = f2;
        this.centerY = f3;
        initParams();
        AppMethodBeat.o(81948);
    }

    public void initParams() {
        AppMethodBeat.i(81949);
        addParam(new f("radius", this.radius));
        addParam(new b("center", this.centerX, this.centerY));
        addParam(new f("whiteTeeth", this.whiteTeeth));
        addParam(new f("eyePouch", this.eyePouch));
        addParam(new n("inputAlgoTexture", this.algoTexture, 33985));
        AppMethodBeat.o(81949);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(81950);
        if (map.containsKey("whiteTeeth")) {
            this.whiteTeeth = ((Float) map.get("whiteTeeth")).floatValue();
        }
        if (map.containsKey("eyePouch")) {
            this.eyePouch = ((Float) map.get("eyePouch")).floatValue();
        }
        this.whiteTeeth /= 100.0f;
        this.eyePouch /= 100.0f;
        addParam(new f("whiteTeeth", this.whiteTeeth));
        addParam(new f("eyePouch", this.eyePouch));
        AppMethodBeat.o(81950);
    }
}
