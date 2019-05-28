package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static Map<String, List<Integer>> tnY = new ConcurrentHashMap();
    private static Map<String, Boolean> tnZ = new ConcurrentHashMap();
    private static Map<String, Integer> toa = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(45918);
        AppMethodBeat.o(45918);
    }

    public static void acn(String str) {
        AppMethodBeat.i(45910);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45910);
            return;
        }
        Object valueOf;
        if (toa.containsKey(str)) {
            Integer num = (Integer) toa.get(str);
            if (num != null) {
                valueOf = Integer.valueOf(num.intValue() + 1);
                toa.put(str, valueOf);
                AppMethodBeat.o(45910);
            }
        }
        valueOf = Integer.valueOf(1);
        toa.put(str, valueOf);
        AppMethodBeat.o(45910);
    }

    public static void aco(String str) {
        AppMethodBeat.i(45911);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45911);
            return;
        }
        toa.remove(str);
        AppMethodBeat.o(45911);
    }

    public static void dr(String str, int i) {
        AppMethodBeat.i(45912);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45912);
        } else if (tnY.containsKey(str)) {
            List list = (List) tnY.get(str);
            list.add(Integer.valueOf(i));
            tnY.put(str, list);
            AppMethodBeat.o(45912);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            tnY.put(str, arrayList);
            AppMethodBeat.o(45912);
        }
    }

    private static boolean acp(String str) {
        AppMethodBeat.i(45913);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45913);
            return false;
        }
        if (toa.containsKey(str)) {
            Integer num = (Integer) toa.get(str);
            if (num == null) {
                AppMethodBeat.o(45913);
                return false;
            } else if (num.intValue() > 1) {
                AppMethodBeat.o(45913);
                return true;
            }
        }
        AppMethodBeat.o(45913);
        return false;
    }

    public static void r(String str, int i, boolean z) {
        AppMethodBeat.i(45914);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45914);
            return;
        }
        if (tnY.containsKey(str) && ((List) tnY.get(str)).size() > 0) {
            if (i == 1) {
                h.pYm.k(965, 10, 1);
                h.pYm.k(965, 30, 1);
                if (acp(str)) {
                    h.pYm.k(965, 25, 1);
                }
            } else if (i == 2) {
                h.pYm.k(965, 11, 1);
                h.pYm.k(965, 31, 1);
                if (acp(str)) {
                    h.pYm.k(965, 26, 1);
                }
            }
            if (acp(str)) {
                h.pYm.k(965, 24, 1);
            }
            h.pYm.k(965, 29, 1);
            if (z) {
                h.pYm.k(965, 20, 1);
            } else {
                h.pYm.k(965, 21, 1);
            }
        }
        if (tnZ.containsKey(str)) {
            Boolean bool = (Boolean) tnZ.get(str);
            if (bool != null) {
                if (bool.booleanValue()) {
                    h.pYm.k(965, 18, 1);
                    AppMethodBeat.o(45914);
                    return;
                }
                h.pYm.k(965, 19, 1);
            }
        }
        AppMethodBeat.o(45914);
    }

    public static void bz(String str, boolean z) {
        AppMethodBeat.i(45915);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45915);
            return;
        }
        tnZ.put(str, Boolean.valueOf(z));
        AppMethodBeat.o(45915);
    }

    public static void acq(String str) {
        AppMethodBeat.i(45916);
        if (!(bo.isNullOrNil(str) || tnY.containsKey(str))) {
            tnY.put(str, new ArrayList());
        }
        AppMethodBeat.o(45916);
    }

    public static void acr(String str) {
        AppMethodBeat.i(45917);
        if (!bo.isNullOrNil(str)) {
            tnY.remove(str);
            tnZ.remove(str);
        }
        AppMethodBeat.o(45917);
    }
}
