package com.tencent.p177mm.p249m;

import android.view.ContextMenu.ContextMenuInfo;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.m.d */
public final class C1766d {
    public static final int[] evX = new int[]{1};
    HashMap<String, HashMap<String, String>> evY = new HashMap();
    public Map<String, String> evZ = null;
    /* renamed from: id */
    private int f1237id;
    int version;

    /* renamed from: com.tencent.mm.m.d$a */
    public static class C1764a {
        /* renamed from: id */
        public String f1235id;
        public String title;
        public String url;

        public C1764a(String str, String str2, String str3) {
            this.f1235id = str;
            this.title = str2;
            this.url = str3;
        }
    }

    /* renamed from: com.tencent.mm.m.d$b */
    public static class C1765b implements ContextMenuInfo {
        private static int ewa = Downloads.MIN_WAIT_FOR_NETWORK;
        /* renamed from: id */
        public final int f1236id;
        public final String key;
        public final String title;

        public C1765b(String str, String str2) {
            AppMethodBeat.m2504i(57866);
            int i = ewa;
            ewa = i + 1;
            this.f1236id = i;
            this.key = str;
            this.title = str2;
            AppMethodBeat.m2505o(57866);
        }
    }

    public C1766d(int i) {
        AppMethodBeat.m2504i(57867);
        this.f1237id = i;
        AppMethodBeat.m2505o(57867);
    }

    /* renamed from: kB */
    static boolean m3641kB(String str) {
        AppMethodBeat.m2504i(57868);
        try {
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(57868);
                return false;
            }
            ArrayList<String> arrayList = new ArrayList();
            if (!C5046bo.isNullOrNil(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!C5046bo.isNullOrNil(split[i])) {
                            arrayList.add(split[i]);
                        }
                    }
                }
            }
            String dor = C4988aa.dor();
            if (C5046bo.isNullOrNil(dor)) {
                AppMethodBeat.m2505o(57868);
                return false;
            }
            C4990ab.m7410d("MicroMsg.ConfigListInfo", "locale is ".concat(String.valueOf(dor)));
            for (String str2 : arrayList) {
                if (str2.trim().toLowerCase().equals(FacebookRequestErrorClassification.KEY_OTHER) && !dor.equals("zh_CN")) {
                    C4990ab.m7410d("MicroMsg.ConfigListInfo", "find other");
                    AppMethodBeat.m2505o(57868);
                    return true;
                } else if (str2.trim().toLowerCase().equals(dor.trim().toLowerCase())) {
                    C4990ab.m7410d("MicroMsg.ConfigListInfo", "find ");
                    AppMethodBeat.m2505o(57868);
                    return true;
                }
            }
            AppMethodBeat.m2505o(57868);
            return false;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ConfigListInfo", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7410d("MicroMsg.ConfigListInfo", "isContainLocale failed " + e.getMessage());
        }
    }

    /* renamed from: c */
    private static LinkedList<C1764a> m3639c(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(57869);
        LinkedList<C1764a> linkedList = null;
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
            LinkedList<C1764a> linkedList2;
            C1764a c1764a = new C1764a((String) map.get(str3), (String) map.get(str4), (String) map.get(str5));
            if (linkedList == null) {
                linkedList2 = new LinkedList();
            } else {
                linkedList2 = linkedList;
            }
            linkedList2.add(c1764a);
            i++;
            linkedList = linkedList2;
        }
        AppMethodBeat.m2505o(57869);
        return linkedList;
    }

    /* renamed from: g */
    public static LinkedList<C1764a> m3640g(Map<String, String> map) {
        AppMethodBeat.m2504i(57870);
        LinkedList<C1764a> linkedList = null;
        int i = 0;
        while (true) {
            String str = ".ConfigList.Config" + (i == 0 ? "" : Integer.valueOf(i));
            if (map.get(str + ".$name") == null) {
                AppMethodBeat.m2505o(57870);
                break;
            }
            LinkedList<C1764a> c;
            if (((String) map.get(str + ".$name")).equalsIgnoreCase("JDWebViewMenu")) {
                c = C1766d.m3639c(map, str + ".menuItems.menuItem");
                linkedList = C1766d.m3639c(map, str + ".menuItems.newMenuItem");
                if (c == null) {
                    AppMethodBeat.m2505o(57870);
                    break;
                } else if (linkedList != null && linkedList.size() > 0) {
                    C4990ab.m7411d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", Integer.valueOf(c.size()), Integer.valueOf(linkedList.size()));
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
