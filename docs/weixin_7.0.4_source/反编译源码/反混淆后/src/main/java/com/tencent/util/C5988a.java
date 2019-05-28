package com.tencent.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.util.a */
public class C5988a {
    private static int COUNT = 10;
    private static final String TAG = C5988a.class.getSimpleName();
    private static Map<String, Long> startTimeMap = new HashMap();
    private static Map<String, List<Long>> totalTimeMap = new HashMap();

    static {
        AppMethodBeat.m2504i(86572);
        AppMethodBeat.m2505o(86572);
    }

    public static void benchStart(String str) {
        AppMethodBeat.m2504i(86569);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(86569);
            return;
        }
        startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(86569);
    }

    public static void auz(String str) {
        AppMethodBeat.m2504i(86570);
        if (TextUtils.isEmpty(str) || startTimeMap.get(str) == null) {
            AppMethodBeat.m2505o(86570);
            return;
        }
        List list;
        List list2 = (List) totalTimeMap.get(str);
        if (list2 == null) {
            ArrayList arrayList = new ArrayList();
            totalTimeMap.put(str, arrayList);
            list = arrayList;
        } else {
            list = list2;
        }
        list.add(Long.valueOf(System.currentTimeMillis() - ((Long) startTimeMap.get(str)).longValue()));
        if (list.size() >= COUNT) {
            new StringBuilder("[time]").append(str).append(": ").append(C5988a.getTotalTime(list) / ((long) list.size())).append("ms");
            list.clear();
        }
        AppMethodBeat.m2505o(86570);
    }

    private static long getTotalTime(List<Long> list) {
        long j = 0;
        AppMethodBeat.m2504i(86571);
        if (list == null) {
            AppMethodBeat.m2505o(86571);
            return 0;
        }
        Iterator it = list.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = ((Long) it.next()).longValue() + j2;
            } else {
                AppMethodBeat.m2505o(86571);
                return j2;
            }
        }
    }
}
