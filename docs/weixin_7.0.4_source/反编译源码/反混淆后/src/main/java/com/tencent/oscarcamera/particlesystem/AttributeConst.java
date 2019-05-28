package com.tencent.oscarcamera.particlesystem;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class AttributeConst {
    /* renamed from: A */
    public static final String f17262A = "colorA";
    public static final int ATTR_A = 6;
    public static final int ATTR_B = 5;
    public static final int ATTR_CNT = 10;
    public static final int ATTR_G = 4;
    public static final int ATTR_HEIGHT = 1;
    public static final Map<String, Integer> ATTR_INDEX_MAP;
    public static final int ATTR_LIFE = 2;
    public static final int ATTR_R = 3;
    public static final int ATTR_WIDTH = 0;
    public static final int ATTR_X = 7;
    public static final int ATTR_Y = 8;
    public static final int ATTR_Z = 9;
    /* renamed from: B */
    public static final String f17263B = "colorB";
    public static final String EMISSION_RATE = "emissionRate";
    /* renamed from: G */
    public static final String f17264G = "colorG";
    public static final String HEIGHT = "height";
    public static final String LIFE = "life";
    public static final String MAX_COUNT = "particleCountMax";
    public static final String NAME = "name";
    public static final int PARAM_CNT = 11;
    public static final int PARAM_R0 = 0;
    public static final int PARAM_R1 = 1;
    public static final int PARAM_R2 = 2;
    public static final int PARAM_R3 = 3;
    public static final int PARAM_R4 = 4;
    public static final int PARAM_R5 = 5;
    public static final int PARAM_R6 = 6;
    public static final int PARAM_R7 = 7;
    public static final int PARAM_R8 = 8;
    public static final int PARAM_R9 = 9;
    public static final int PARAM_T = 10;
    /* renamed from: R */
    public static final String f17265R = "colorR";
    public static final String WIDTH = "width";
    /* renamed from: X */
    public static final String f17266X = "positionX";
    /* renamed from: Y */
    public static final String f17267Y = "positionY";
    /* renamed from: Z */
    public static final String f17268Z = "positionZ";

    static {
        AppMethodBeat.m2504i(81510);
        HashMap hashMap = new HashMap();
        ATTR_INDEX_MAP = hashMap;
        hashMap.put(LIFE, Integer.valueOf(2));
        ATTR_INDEX_MAP.put("width", Integer.valueOf(0));
        ATTR_INDEX_MAP.put("height", Integer.valueOf(1));
        ATTR_INDEX_MAP.put(f17266X, Integer.valueOf(7));
        ATTR_INDEX_MAP.put(f17267Y, Integer.valueOf(8));
        ATTR_INDEX_MAP.put(f17268Z, Integer.valueOf(9));
        ATTR_INDEX_MAP.put(f17265R, Integer.valueOf(3));
        ATTR_INDEX_MAP.put(f17264G, Integer.valueOf(4));
        ATTR_INDEX_MAP.put(f17263B, Integer.valueOf(5));
        ATTR_INDEX_MAP.put(f17262A, Integer.valueOf(6));
        AppMethodBeat.m2505o(81510);
    }
}
