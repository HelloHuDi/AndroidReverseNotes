package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class i {

    public static class a {
        public int fMk = 0;
        public int hitCount = 0;

        public static String ah(Map<String, a> map) {
            AppMethodBeat.i(4366);
            StringBuilder stringBuilder = new StringBuilder();
            if (map != null) {
                try {
                    if (map.size() > 0) {
                        stringBuilder.append("<voiptenmin>");
                        for (Entry entry : map.entrySet()) {
                            Object key = entry.getKey();
                            a aVar = (a) entry.getValue();
                            stringBuilder.append("<".concat(String.valueOf(key)));
                            stringBuilder.append(" hitcount = \"");
                            stringBuilder.append(aVar.hitCount);
                            stringBuilder.append("\"");
                            stringBuilder.append(" sendcount = \"");
                            stringBuilder.append(aVar.fMk);
                            stringBuilder.append("\"");
                            stringBuilder.append("/>");
                        }
                        stringBuilder.append("</voiptenmin>");
                    }
                } catch (Exception e) {
                    ab.e("PostTaskTenMinutesLogicState", "exception:%s", bo.l(e));
                    AppMethodBeat.o(4366);
                    return null;
                }
            }
            ab.d("PostTaskTenMinutesLogicState", "mapToXml " + stringBuilder.toString());
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(4366);
            return stringBuilder2;
        }

        public static Map<String, a> abV(String str) {
            Throwable e;
            AppMethodBeat.i(4367);
            Map<String, a> map = null;
            ab.d("PostTaskTenMinutesLogicState", "xml ".concat(String.valueOf(str)));
            if (str != null) {
                try {
                    Map z = br.z(str, "voiptenmin");
                    if (z != null && z.size() > 0) {
                        HashMap hashMap = new HashMap();
                        try {
                            for (Entry entry : z.entrySet()) {
                                String str2 = (String) entry.getKey();
                                if (str2 == null) {
                                    break;
                                }
                                String[] split = str2.split("\\.");
                                ab.d("PostTaskTenMinutesLogicState", "key is ".concat(String.valueOf(str2)));
                                ab.d("PostTaskTenMinutesLogicState", "array is " + split.length);
                                if (str2 != null && split.length >= 4) {
                                    a aVar;
                                    ab.d("PostTaskTenMinutesLogicState", "getValue is " + ((String) entry.getValue()) + "array[1] " + split[2]);
                                    if (hashMap.containsKey(split[2])) {
                                        aVar = (a) hashMap.get(split[2]);
                                    } else {
                                        aVar = new a();
                                    }
                                    if (str2.contains("hitcount")) {
                                        aVar.hitCount = bo.getInt((String) entry.getValue(), 0);
                                    } else if (str2.contains("sendcount")) {
                                        aVar.fMk = bo.getInt((String) entry.getValue(), 0);
                                    }
                                    ab.d("PostTaskTenMinutesLogicState", "hitCount " + aVar.hitCount + "sendCount " + aVar.fMk);
                                    hashMap.put(split[2], aVar);
                                }
                            }
                            Object map2 = hashMap;
                        } catch (Exception e2) {
                            e = e2;
                            map2 = hashMap;
                            ab.e("PostTaskTenMinutesLogicState", "exception:%s", bo.l(e));
                            AppMethodBeat.o(4367);
                            return map2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    ab.e("PostTaskTenMinutesLogicState", "exception:%s", bo.l(e));
                    AppMethodBeat.o(4367);
                    return map2;
                }
            }
            AppMethodBeat.o(4367);
            return map2;
        }
    }

    public static boolean Iv() {
        AppMethodBeat.i(4368);
        if (bo.fp(bo.a((Long) g.RP().Ry().get(77828, null), 0)) * 1000 > 1800000) {
            AppMethodBeat.o(4368);
            return true;
        }
        AppMethodBeat.o(4368);
        return false;
    }
}
