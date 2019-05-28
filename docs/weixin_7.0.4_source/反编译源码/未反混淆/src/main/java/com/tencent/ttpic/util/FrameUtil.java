package com.tencent.ttpic.util;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.util.a;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;

public class FrameUtil {
    private static final h EMPTY_FRAME = new h();
    private static final String TAG = FrameUtil.class.getSimpleName();

    static {
        AppMethodBeat.i(50270);
        AppMethodBeat.o(50270);
    }

    public static int getLength(h hVar) {
        int i = 0;
        while (hVar != null && hVar.texture[0] > 0) {
            i++;
            hVar = hVar.bJA;
        }
        return i;
    }

    public static int getLength(BaseFilter baseFilter) {
        AppMethodBeat.i(50260);
        int i = 0;
        while (baseFilter != null) {
            i++;
            baseFilter = baseFilter.getmNextFilter();
        }
        AppMethodBeat.o(50260);
        return i;
    }

    public static void printFilterList(BaseFilter baseFilter) {
        AppMethodBeat.i(50261);
        int i = 0;
        Object baseFilter2;
        while (baseFilter2 != null) {
            int i2 = i + 1;
            new StringBuilder("[FILTER] ").append(i).append(" ").append(baseFilter2);
            baseFilter2 = baseFilter2.getmNextFilter();
            i = i2;
        }
        AppMethodBeat.o(50261);
    }

    public static boolean isValid(h hVar) {
        return (hVar == null || hVar.texture[0] == 0) ? false : true;
    }

    public static h getSecondLastRenderFrame(h hVar) {
        AppMethodBeat.i(50262);
        h hVar2;
        if (isValid(hVar) && isValid(hVar.bJA)) {
            hVar2 = hVar;
            while (true) {
                h hVar3 = hVar;
                if (isValid(hVar3) && isValid(hVar3.bJA)) {
                    hVar = hVar3.bJA;
                    hVar2 = hVar3;
                } else {
                    AppMethodBeat.o(50262);
                }
            }
            AppMethodBeat.o(50262);
            return hVar2;
        }
        hVar2 = EMPTY_FRAME;
        AppMethodBeat.o(50262);
        return hVar2;
    }

    public static h getLastRenderFrame(h hVar) {
        AppMethodBeat.i(50263);
        h hVar2;
        if (isValid(hVar)) {
            hVar2 = hVar;
            while (true) {
                h hVar3 = hVar;
                if (isValid(hVar3)) {
                    hVar = hVar3.bJA;
                    hVar2 = hVar3;
                } else {
                    AppMethodBeat.o(50263);
                    return hVar2;
                }
            }
        }
        hVar2 = EMPTY_FRAME;
        AppMethodBeat.o(50263);
        return hVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void clearTailFrame(BaseFilter baseFilter, h hVar) {
        AppMethodBeat.i(50265);
        int length = getLength(baseFilter);
        while (true) {
            int i = length - 1;
            if (length > 0 && hVar != null) {
                hVar = hVar.bJA;
                length = i;
            } else if (hVar != null) {
                hVar.clear();
            }
        }
        if (hVar != null) {
        }
        AppMethodBeat.o(50265);
    }

    public static h rotateCorrect(h hVar, int i, int i2, int i3, BaseFilter baseFilter, h hVar2) {
        AppMethodBeat.i(50266);
        if (i3 == 0) {
            AppMethodBeat.o(50266);
            return hVar;
        }
        int i4;
        int i5;
        int i6 = (i3 + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if (i6 == 90 || i6 == 270) {
            i4 = i;
            i5 = i2;
        } else {
            i4 = i2;
            i5 = i;
        }
        a.benchStart("[VideoFilterList] mRotationFilter before");
        baseFilter.nativeSetRotationAndFlip(i6, 0, 0);
        baseFilter.RenderProcess(hVar.texture[0], i5, i4, -1, 0.0d, hVar2);
        a.auz("[VideoFilterList] mRotationFilter before");
        AppMethodBeat.o(50266);
        return hVar2;
    }

    public static void clearFrame(h hVar, float f, float f2, float f3, float f4, int i, int i2) {
        AppMethodBeat.i(50267);
        if (hVar == null) {
            AppMethodBeat.o(50267);
            return;
        }
        hVar.a(-1, i, i2, 0.0d);
        GLES20.glClearColor(f, f2, f3, f4);
        GLES20.glClear(16384);
        AppMethodBeat.o(50267);
    }

    public static List<BaseFilter> filterChain2List(BaseFilter baseFilter) {
        AppMethodBeat.i(50268);
        ArrayList arrayList = new ArrayList();
        while (baseFilter != null) {
            BaseFilter baseFilter2 = baseFilter.getmNextFilter();
            baseFilter.setNextFilter(null, null);
            arrayList.add(baseFilter);
            baseFilter = baseFilter2;
        }
        AppMethodBeat.o(50268);
        return arrayList;
    }

    public static void filterList2Chain(List<BaseFilter> list) {
        AppMethodBeat.i(50269);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(50269);
            return;
        }
        BaseFilter baseFilter = (BaseFilter) list.get(0);
        int i = 1;
        while (true) {
            BaseFilter baseFilter2 = baseFilter;
            if (i < list.size()) {
                baseFilter2.setNextFilter((BaseFilter) list.get(i), null);
                baseFilter = (BaseFilter) list.get(i);
                i++;
            } else {
                AppMethodBeat.o(50269);
                return;
            }
        }
    }

    public static h renderProcessBySwitchFbo(int i, int i2, int i3, BaseFilter baseFilter, h hVar, h hVar2) {
        h hVar3;
        AppMethodBeat.i(50264);
        if (hVar.texture[0] == i) {
            hVar3 = hVar2;
        } else {
            hVar3 = hVar;
        }
        baseFilter.RenderProcess(i, i2, i3, -1, 0.0d, hVar3);
        AppMethodBeat.o(50264);
        return hVar3;
    }
}
