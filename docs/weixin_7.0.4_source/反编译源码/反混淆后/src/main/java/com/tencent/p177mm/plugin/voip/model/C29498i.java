package com.tencent.p177mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.voip.model.i */
public final class C29498i {

    /* renamed from: com.tencent.mm.plugin.voip.model.i$a */
    public static class C22459a {
        public int fMk = 0;
        public int hitCount = 0;

        /* renamed from: ah */
        public static String m34142ah(Map<String, C22459a> map) {
            AppMethodBeat.m2504i(4366);
            StringBuilder stringBuilder = new StringBuilder();
            if (map != null) {
                try {
                    if (map.size() > 0) {
                        stringBuilder.append("<voiptenmin>");
                        for (Entry entry : map.entrySet()) {
                            Object key = entry.getKey();
                            C22459a c22459a = (C22459a) entry.getValue();
                            stringBuilder.append("<".concat(String.valueOf(key)));
                            stringBuilder.append(" hitcount = \"");
                            stringBuilder.append(c22459a.hitCount);
                            stringBuilder.append("\"");
                            stringBuilder.append(" sendcount = \"");
                            stringBuilder.append(c22459a.fMk);
                            stringBuilder.append("\"");
                            stringBuilder.append("/>");
                        }
                        stringBuilder.append("</voiptenmin>");
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("PostTaskTenMinutesLogicState", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(4366);
                    return null;
                }
            }
            C4990ab.m7410d("PostTaskTenMinutesLogicState", "mapToXml " + stringBuilder.toString());
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(4366);
            return stringBuilder2;
        }

        public static Map<String, C22459a> abV(String str) {
            Throwable e;
            AppMethodBeat.m2504i(4367);
            Map<String, C22459a> map = null;
            C4990ab.m7410d("PostTaskTenMinutesLogicState", "xml ".concat(String.valueOf(str)));
            if (str != null) {
                try {
                    Map z = C5049br.m7595z(str, "voiptenmin");
                    if (z != null && z.size() > 0) {
                        HashMap hashMap = new HashMap();
                        try {
                            for (Entry entry : z.entrySet()) {
                                String str2 = (String) entry.getKey();
                                if (str2 == null) {
                                    break;
                                }
                                String[] split = str2.split("\\.");
                                C4990ab.m7410d("PostTaskTenMinutesLogicState", "key is ".concat(String.valueOf(str2)));
                                C4990ab.m7410d("PostTaskTenMinutesLogicState", "array is " + split.length);
                                if (str2 != null && split.length >= 4) {
                                    C22459a c22459a;
                                    C4990ab.m7410d("PostTaskTenMinutesLogicState", "getValue is " + ((String) entry.getValue()) + "array[1] " + split[2]);
                                    if (hashMap.containsKey(split[2])) {
                                        c22459a = (C22459a) hashMap.get(split[2]);
                                    } else {
                                        c22459a = new C22459a();
                                    }
                                    if (str2.contains("hitcount")) {
                                        c22459a.hitCount = C5046bo.getInt((String) entry.getValue(), 0);
                                    } else if (str2.contains("sendcount")) {
                                        c22459a.fMk = C5046bo.getInt((String) entry.getValue(), 0);
                                    }
                                    C4990ab.m7410d("PostTaskTenMinutesLogicState", "hitCount " + c22459a.hitCount + "sendCount " + c22459a.fMk);
                                    hashMap.put(split[2], c22459a);
                                }
                            }
                            Object map2 = hashMap;
                        } catch (Exception e2) {
                            e = e2;
                            map2 = hashMap;
                            C4990ab.m7413e("PostTaskTenMinutesLogicState", "exception:%s", C5046bo.m7574l(e));
                            AppMethodBeat.m2505o(4367);
                            return map2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    C4990ab.m7413e("PostTaskTenMinutesLogicState", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(4367);
                    return map2;
                }
            }
            AppMethodBeat.m2505o(4367);
            return map2;
        }
    }

    /* renamed from: Iv */
    public static boolean m46854Iv() {
        AppMethodBeat.m2504i(4368);
        if (C5046bo.m7549fp(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(77828, null), 0)) * 1000 > 1800000) {
            AppMethodBeat.m2505o(4368);
            return true;
        }
        AppMethodBeat.m2505o(4368);
        return false;
    }
}
