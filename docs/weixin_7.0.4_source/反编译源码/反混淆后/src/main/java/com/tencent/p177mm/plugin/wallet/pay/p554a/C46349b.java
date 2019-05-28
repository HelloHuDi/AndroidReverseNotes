package com.tencent.p177mm.plugin.wallet.pay.p554a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.b */
public final class C46349b {
    private static Map<String, List<Integer>> tnY = new ConcurrentHashMap();
    private static Map<String, Boolean> tnZ = new ConcurrentHashMap();
    private static Map<String, Integer> toa = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(45918);
        AppMethodBeat.m2505o(45918);
    }

    public static void acn(String str) {
        AppMethodBeat.m2504i(45910);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45910);
            return;
        }
        Object valueOf;
        if (toa.containsKey(str)) {
            Integer num = (Integer) toa.get(str);
            if (num != null) {
                valueOf = Integer.valueOf(num.intValue() + 1);
                toa.put(str, valueOf);
                AppMethodBeat.m2505o(45910);
            }
        }
        valueOf = Integer.valueOf(1);
        toa.put(str, valueOf);
        AppMethodBeat.m2505o(45910);
    }

    public static void aco(String str) {
        AppMethodBeat.m2504i(45911);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45911);
            return;
        }
        toa.remove(str);
        AppMethodBeat.m2505o(45911);
    }

    /* renamed from: dr */
    public static void m87110dr(String str, int i) {
        AppMethodBeat.m2504i(45912);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45912);
        } else if (tnY.containsKey(str)) {
            List list = (List) tnY.get(str);
            list.add(Integer.valueOf(i));
            tnY.put(str, list);
            AppMethodBeat.m2505o(45912);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            tnY.put(str, arrayList);
            AppMethodBeat.m2505o(45912);
        }
    }

    private static boolean acp(String str) {
        AppMethodBeat.m2504i(45913);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45913);
            return false;
        }
        if (toa.containsKey(str)) {
            Integer num = (Integer) toa.get(str);
            if (num == null) {
                AppMethodBeat.m2505o(45913);
                return false;
            } else if (num.intValue() > 1) {
                AppMethodBeat.m2505o(45913);
                return true;
            }
        }
        AppMethodBeat.m2505o(45913);
        return false;
    }

    /* renamed from: r */
    public static void m87111r(String str, int i, boolean z) {
        AppMethodBeat.m2504i(45914);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45914);
            return;
        }
        if (tnY.containsKey(str) && ((List) tnY.get(str)).size() > 0) {
            if (i == 1) {
                C7060h.pYm.mo15419k(965, 10, 1);
                C7060h.pYm.mo15419k(965, 30, 1);
                if (C46349b.acp(str)) {
                    C7060h.pYm.mo15419k(965, 25, 1);
                }
            } else if (i == 2) {
                C7060h.pYm.mo15419k(965, 11, 1);
                C7060h.pYm.mo15419k(965, 31, 1);
                if (C46349b.acp(str)) {
                    C7060h.pYm.mo15419k(965, 26, 1);
                }
            }
            if (C46349b.acp(str)) {
                C7060h.pYm.mo15419k(965, 24, 1);
            }
            C7060h.pYm.mo15419k(965, 29, 1);
            if (z) {
                C7060h.pYm.mo15419k(965, 20, 1);
            } else {
                C7060h.pYm.mo15419k(965, 21, 1);
            }
        }
        if (tnZ.containsKey(str)) {
            Boolean bool = (Boolean) tnZ.get(str);
            if (bool != null) {
                if (bool.booleanValue()) {
                    C7060h.pYm.mo15419k(965, 18, 1);
                    AppMethodBeat.m2505o(45914);
                    return;
                }
                C7060h.pYm.mo15419k(965, 19, 1);
            }
        }
        AppMethodBeat.m2505o(45914);
    }

    /* renamed from: bz */
    public static void m87109bz(String str, boolean z) {
        AppMethodBeat.m2504i(45915);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45915);
            return;
        }
        tnZ.put(str, Boolean.valueOf(z));
        AppMethodBeat.m2505o(45915);
    }

    public static void acq(String str) {
        AppMethodBeat.m2504i(45916);
        if (!(C5046bo.isNullOrNil(str) || tnY.containsKey(str))) {
            tnY.put(str, new ArrayList());
        }
        AppMethodBeat.m2505o(45916);
    }

    public static void acr(String str) {
        AppMethodBeat.m2504i(45917);
        if (!C5046bo.isNullOrNil(str)) {
            tnY.remove(str);
            tnZ.remove(str);
        }
        AppMethodBeat.m2505o(45917);
    }
}
