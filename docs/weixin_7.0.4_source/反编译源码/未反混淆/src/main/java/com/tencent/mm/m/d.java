package com.tencent.mm.m;

import android.view.ContextMenu.ContextMenuInfo;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    public static final int[] evX = new int[]{1};
    HashMap<String, HashMap<String, String>> evY = new HashMap();
    public Map<String, String> evZ = null;
    private int id;
    int version;

    public static class a {
        public String id;
        public String title;
        public String url;

        public a(String str, String str2, String str3) {
            this.id = str;
            this.title = str2;
            this.url = str3;
        }
    }

    public static class b implements ContextMenuInfo {
        private static int ewa = Downloads.MIN_WAIT_FOR_NETWORK;
        public final int id;
        public final String key;
        public final String title;

        public b(String str, String str2) {
            AppMethodBeat.i(57866);
            int i = ewa;
            ewa = i + 1;
            this.id = i;
            this.key = str;
            this.title = str2;
            AppMethodBeat.o(57866);
        }
    }

    public d(int i) {
        AppMethodBeat.i(57867);
        this.id = i;
        AppMethodBeat.o(57867);
    }

    static boolean kB(String str) {
        AppMethodBeat.i(57868);
        try {
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(57868);
                return false;
            }
            ArrayList<String> arrayList = new ArrayList();
            if (!bo.isNullOrNil(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bo.isNullOrNil(split[i])) {
                            arrayList.add(split[i]);
                        }
                    }
                }
            }
            String dor = aa.dor();
            if (bo.isNullOrNil(dor)) {
                AppMethodBeat.o(57868);
                return false;
            }
            ab.d("MicroMsg.ConfigListInfo", "locale is ".concat(String.valueOf(dor)));
            for (String str2 : arrayList) {
                if (str2.trim().toLowerCase().equals(FacebookRequestErrorClassification.KEY_OTHER) && !dor.equals("zh_CN")) {
                    ab.d("MicroMsg.ConfigListInfo", "find other");
                    AppMethodBeat.o(57868);
                    return true;
                } else if (str2.trim().toLowerCase().equals(dor.trim().toLowerCase())) {
                    ab.d("MicroMsg.ConfigListInfo", "find ");
                    AppMethodBeat.o(57868);
                    return true;
                }
            }
            AppMethodBeat.o(57868);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.ConfigListInfo", "exception:%s", bo.l(e));
            ab.d("MicroMsg.ConfigListInfo", "isContainLocale failed " + e.getMessage());
        }
    }

    private static LinkedList<a> c(Map<String, String> map, String str) {
        AppMethodBeat.i(57869);
        LinkedList<a> linkedList = null;
        int i = 0;
        while (true) {
            String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
            if (map.get(str2) == null) {
                break;
            }
            String str3 = str2 + ".id";
            String str4 = str2 + ".title";
            String str5 = str2 + ".url";
            if (!map.containsKey(str3)) {
                break;
            }
            LinkedList<a> linkedList2;
            a aVar = new a((String) map.get(str3), (String) map.get(str4), (String) map.get(str5));
            if (linkedList == null) {
                linkedList2 = new LinkedList();
            } else {
                linkedList2 = linkedList;
            }
            linkedList2.add(aVar);
            i++;
            linkedList = linkedList2;
        }
        AppMethodBeat.o(57869);
        return linkedList;
    }

    public static LinkedList<a> g(Map<String, String> map) {
        AppMethodBeat.i(57870);
        LinkedList<a> linkedList = null;
        int i = 0;
        while (true) {
            String str = ".ConfigList.Config" + (i == 0 ? "" : Integer.valueOf(i));
            if (map.get(str + ".$name") == null) {
                AppMethodBeat.o(57870);
                break;
            }
            LinkedList<a> c;
            if (((String) map.get(str + ".$name")).equalsIgnoreCase("JDWebViewMenu")) {
                c = c(map, str + ".menuItems.menuItem");
                linkedList = c(map, str + ".menuItems.newMenuItem");
                if (c == null) {
                    AppMethodBeat.o(57870);
                    break;
                } else if (linkedList != null && linkedList.size() > 0) {
                    ab.d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", Integer.valueOf(c.size()), Integer.valueOf(linkedList.size()));
                    c.addAll(linkedList);
                }
            } else {
                c = linkedList;
            }
            i++;
            linkedList = c;
        }
        return linkedList;
    }
}
