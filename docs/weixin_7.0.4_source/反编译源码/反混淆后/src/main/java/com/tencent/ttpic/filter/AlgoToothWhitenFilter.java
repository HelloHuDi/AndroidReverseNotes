package com.tencent.ttpic.filter;

import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C25624m.C25629b;
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
        AppMethodBeat.m2504i(81951);
        AppMethodBeat.m2505o(81951);
    }

    public AlgoToothWhitenFilter(int i, float f, float f2, float f3) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(81948);
        this.algoTexture = i;
        this.radius = f;
        this.centerX = f2;
        this.centerY = f3;
        initParams();
        AppMethodBeat.m2505o(81948);
    }

    public void initParams() {
        AppMethodBeat.m2504i(81949);
        addParam(new C0933f("radius", this.radius));
        addParam(new C25629b("center", this.centerX, this.centerY));
        addParam(new C0933f("whiteTeeth", this.whiteTeeth));
        addParam(new C0933f("eyePouch", this.eyePouch));
        addParam(new C25627n("inputAlgoTexture", this.algoTexture, 33985));
        AppMethodBeat.m2505o(81949);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.m2504i(81950);
        if (map.containsKey("whiteTeeth")) {
            this.whiteTeeth = ((Float) map.get("whiteTeeth")).floatValue();
        }
        if (map.containsKey("eyePouch")) {
            this.eyePouch = ((Float) map.get("eyePouch")).floatValue();
        }
        this.whiteTeeth /= 100.0f;
        this.eyePouch /= 100.0f;
        addParam(new C0933f("whiteTeeth", this.whiteTeeth));
        addParam(new C0933f("eyePouch", this.eyePouch));
        AppMethodBeat.m2505o(81950);
    }
}
