package com.tencent.ttpic.fabby;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.GridSettingModel;
import java.util.Iterator;
import java.util.List;

public class FabbyUtil {

    public enum TRANSFORM_TYPE {
        ORIGIN(0),
        MIRROR_TOP_BOTTOM(1),
        MIRROR_LEFT_RIGHT(2);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(81881);
        }

        private TRANSFORM_TYPE(int i) {
            this.value = i;
        }
    }

    public static double getRangeValue(int i, float f, List<Pair<Float, Double>> list, double d) {
        AppMethodBeat.m2504i(81882);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(81882);
            return d;
        }
        Pair pair;
        Pair pair2 = null;
        Iterator it = list.iterator();
        while (true) {
            pair = pair2;
            if (!it.hasNext()) {
                pair2 = null;
                break;
            }
            pair2 = (Pair) it.next();
            if (((Float) pair2.first).floatValue() > f) {
                break;
            }
        }
        if (pair == null && pair2 == null) {
            AppMethodBeat.m2505o(81882);
            return 1.0d;
        }
        Pair pair3;
        Pair pair4;
        if (pair == null) {
            pair3 = pair2;
            pair4 = pair2;
        } else if (pair2 == null) {
            pair3 = pair;
            pair4 = pair;
        } else {
            pair3 = pair2;
            pair4 = pair;
        }
        if (((Float) pair4.first).equals(pair3.first)) {
            d = ((Double) pair4.second).doubleValue();
            AppMethodBeat.m2505o(81882);
            return d;
        }
        d = getValue(i, ((Double) pair4.second).doubleValue(), (double) ((Float) pair4.first).floatValue(), ((Double) pair3.second).doubleValue(), (double) ((Float) pair3.first).floatValue(), (double) f);
        AppMethodBeat.m2505o(81882);
        return d;
    }

    public static int getDivideValue(float f, List<Pair<Float, Integer>> list, int i) {
        AppMethodBeat.m2504i(81883);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(81883);
            return i;
        }
        Pair pair;
        Pair pair2 = null;
        Iterator it = list.iterator();
        while (true) {
            pair = pair2;
            if (!it.hasNext()) {
                break;
            }
            pair2 = (Pair) it.next();
            if (((Float) pair2.first).floatValue() > f) {
                break;
            }
        }
        if (pair == null) {
            AppMethodBeat.m2505o(81883);
            return 0;
        }
        i = ((Integer) pair.second).intValue();
        AppMethodBeat.m2505o(81883);
        return i;
    }

    private static double getValue(int i, double d, double d2, double d3, double d4, double d5) {
        AppMethodBeat.m2504i(81884);
        double d6 = (d5 - d2) / (d4 - d2);
        switch (i) {
            case 1:
                d6 = (Math.cos(d6 * 1.5707963267948966d) * (-(d3 - d))) + d3;
                break;
            case 2:
                d6 = (Math.sin(d6 * 1.5707963267948966d) * (d3 - d)) + d;
                break;
            case 3:
                d6 = ((Math.cos(d6 * 3.141592653589793d) - 1.0d) * ((-(d3 - d)) / 2.0d)) + d;
                break;
            default:
                d6 = (d6 * (d3 - d)) + d;
                break;
        }
        AppMethodBeat.m2505o(81884);
        return d6;
    }

    public static GridSettingModel getGridSetting(float f, List<Pair<Float, GridSettingModel>> list, GridSettingModel gridSettingModel) {
        AppMethodBeat.m2504i(81885);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(81885);
            return gridSettingModel;
        }
        Pair pair;
        Pair pair2 = null;
        Iterator it = list.iterator();
        while (true) {
            pair = pair2;
            if (!it.hasNext()) {
                break;
            }
            pair2 = (Pair) it.next();
            if (((Float) pair2.first).floatValue() > f) {
                break;
            }
        }
        if (pair == null) {
            AppMethodBeat.m2505o(81885);
            return gridSettingModel;
        }
        GridSettingModel gridSettingModel2 = (GridSettingModel) pair.second;
        AppMethodBeat.m2505o(81885);
        return gridSettingModel2;
    }

    public static boolean isHorizon(int i) {
        return i == 90 || i == 270;
    }
}
