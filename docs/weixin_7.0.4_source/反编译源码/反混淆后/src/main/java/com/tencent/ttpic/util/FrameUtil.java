package com.tencent.ttpic.util;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.util.C5988a;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;

public class FrameUtil {
    private static final C41672h EMPTY_FRAME = new C41672h();
    private static final String TAG = FrameUtil.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(50270);
        AppMethodBeat.m2505o(50270);
    }

    public static int getLength(C41672h c41672h) {
        int i = 0;
        while (c41672h != null && c41672h.texture[0] > 0) {
            i++;
            c41672h = c41672h.bJA;
        }
        return i;
    }

    public static int getLength(BaseFilter baseFilter) {
        AppMethodBeat.m2504i(50260);
        int i = 0;
        while (baseFilter != null) {
            i++;
            baseFilter = baseFilter.getmNextFilter();
        }
        AppMethodBeat.m2505o(50260);
        return i;
    }

    public static void printFilterList(BaseFilter baseFilter) {
        AppMethodBeat.m2504i(50261);
        int i = 0;
        Object baseFilter2;
        while (baseFilter2 != null) {
            int i2 = i + 1;
            new StringBuilder("[FILTER] ").append(i).append(" ").append(baseFilter2);
            baseFilter2 = baseFilter2.getmNextFilter();
            i = i2;
        }
        AppMethodBeat.m2505o(50261);
    }

    public static boolean isValid(C41672h c41672h) {
        return (c41672h == null || c41672h.texture[0] == 0) ? false : true;
    }

    public static C41672h getSecondLastRenderFrame(C41672h c41672h) {
        AppMethodBeat.m2504i(50262);
        C41672h c41672h2;
        if (isValid(c41672h) && isValid(c41672h.bJA)) {
            c41672h2 = c41672h;
            while (true) {
                C41672h c41672h3 = c41672h;
                if (isValid(c41672h3) && isValid(c41672h3.bJA)) {
                    c41672h = c41672h3.bJA;
                    c41672h2 = c41672h3;
                } else {
                    AppMethodBeat.m2505o(50262);
                }
            }
            AppMethodBeat.m2505o(50262);
            return c41672h2;
        }
        c41672h2 = EMPTY_FRAME;
        AppMethodBeat.m2505o(50262);
        return c41672h2;
    }

    public static C41672h getLastRenderFrame(C41672h c41672h) {
        AppMethodBeat.m2504i(50263);
        C41672h c41672h2;
        if (isValid(c41672h)) {
            c41672h2 = c41672h;
            while (true) {
                C41672h c41672h3 = c41672h;
                if (isValid(c41672h3)) {
                    c41672h = c41672h3.bJA;
                    c41672h2 = c41672h3;
                } else {
                    AppMethodBeat.m2505o(50263);
                    return c41672h2;
                }
            }
        }
        c41672h2 = EMPTY_FRAME;
        AppMethodBeat.m2505o(50263);
        return c41672h2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void clearTailFrame(BaseFilter baseFilter, C41672h c41672h) {
        AppMethodBeat.m2504i(50265);
        int length = getLength(baseFilter);
        while (true) {
            int i = length - 1;
            if (length > 0 && c41672h != null) {
                c41672h = c41672h.bJA;
                length = i;
            } else if (c41672h != null) {
                c41672h.clear();
            }
        }
        if (c41672h != null) {
        }
        AppMethodBeat.m2505o(50265);
    }

    public static C41672h rotateCorrect(C41672h c41672h, int i, int i2, int i3, BaseFilter baseFilter, C41672h c41672h2) {
        AppMethodBeat.m2504i(50266);
        if (i3 == 0) {
            AppMethodBeat.m2505o(50266);
            return c41672h;
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
        C5988a.benchStart("[VideoFilterList] mRotationFilter before");
        baseFilter.nativeSetRotationAndFlip(i6, 0, 0);
        baseFilter.RenderProcess(c41672h.texture[0], i5, i4, -1, 0.0d, c41672h2);
        C5988a.auz("[VideoFilterList] mRotationFilter before");
        AppMethodBeat.m2505o(50266);
        return c41672h2;
    }

    public static void clearFrame(C41672h c41672h, float f, float f2, float f3, float f4, int i, int i2) {
        AppMethodBeat.m2504i(50267);
        if (c41672h == null) {
            AppMethodBeat.m2505o(50267);
            return;
        }
        c41672h.mo67189a(-1, i, i2, 0.0d);
        GLES20.glClearColor(f, f2, f3, f4);
        GLES20.glClear(16384);
        AppMethodBeat.m2505o(50267);
    }

    public static List<BaseFilter> filterChain2List(BaseFilter baseFilter) {
        AppMethodBeat.m2504i(50268);
        ArrayList arrayList = new ArrayList();
        while (baseFilter != null) {
            BaseFilter baseFilter2 = baseFilter.getmNextFilter();
            baseFilter.setNextFilter(null, null);
            arrayList.add(baseFilter);
            baseFilter = baseFilter2;
        }
        AppMethodBeat.m2505o(50268);
        return arrayList;
    }

    public static void filterList2Chain(List<BaseFilter> list) {
        AppMethodBeat.m2504i(50269);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.m2505o(50269);
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
                AppMethodBeat.m2505o(50269);
                return;
            }
        }
    }

    public static C41672h renderProcessBySwitchFbo(int i, int i2, int i3, BaseFilter baseFilter, C41672h c41672h, C41672h c41672h2) {
        C41672h c41672h3;
        AppMethodBeat.m2504i(50264);
        if (c41672h.texture[0] == i) {
            c41672h3 = c41672h2;
        } else {
            c41672h3 = c41672h;
        }
        baseFilter.RenderProcess(i, i2, i3, -1, 0.0d, c41672h3);
        AppMethodBeat.m2505o(50264);
        return c41672h3;
    }
}
