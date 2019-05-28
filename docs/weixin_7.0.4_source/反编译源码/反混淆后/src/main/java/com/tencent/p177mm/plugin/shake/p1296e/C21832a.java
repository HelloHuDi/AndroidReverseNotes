package com.tencent.p177mm.plugin.shake.p1296e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.shake.e.a */
public final class C21832a {
    public LinkedList<C21833a> fPL = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.shake.e.a$a */
    public static class C21833a {
        public String qwN;
        public List<String> qwO = new ArrayList();
        public String qwP = "";
        public String qwQ = "";
        public String summary;
        public String title;
        public int type;

        public C21833a() {
            AppMethodBeat.m2504i(24943);
            AppMethodBeat.m2505o(24943);
        }

        public C21833a(int i) {
            AppMethodBeat.m2504i(24944);
            this.type = i;
            AppMethodBeat.m2505o(24944);
        }
    }

    public C21832a() {
        AppMethodBeat.m2504i(24945);
        AppMethodBeat.m2505o(24945);
    }

    /* renamed from: l */
    public static LinkedList<C21832a> m33381l(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(24946);
        LinkedList<C21832a> linkedList = new LinkedList();
        int i = 0;
        Object obj = null;
        while (i < 1000) {
            Object obj2;
            C21832a c21832a = new C21832a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < 1000) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!C5046bo.isNullOrNil((String) map.get(str3 + ".type"))) {
                    try {
                        int intValue = Integer.valueOf((String) map.get(str3 + ".type")).intValue();
                        obj2 = null;
                        if (intValue == 2) {
                            C21833a c21833a = new C21833a(intValue);
                            c21833a.qwN = C5046bo.nullAsNil((String) map.get(str3 + ".comment.id"));
                            c21833a.title = C5046bo.nullAsNil((String) map.get(str3 + ".comment.title"));
                            obj2 = c21833a;
                        } else if (intValue == 3) {
                            obj2 = C21832a.m33380a(map, intValue, str3);
                        } else if (intValue == 4) {
                            obj2 = C21832a.m33380a(map, intValue, str3);
                        } else if (intValue == 5) {
                            obj2 = C21832a.m33380a(map, intValue, str3);
                        } else if (intValue == 6) {
                            obj2 = C21832a.m33380a(map, intValue, str3);
                        }
                        if (obj2 != null) {
                            linkedList2.add(obj2);
                        }
                        i2++;
                        obj = null;
                    } catch (Exception e) {
                        new StringBuilder("Exception in parseActionList: ").append(e.getMessage());
                        if (obj != null) {
                            AppMethodBeat.m2505o(24946);
                            return linkedList;
                        }
                        c21832a.fPL = linkedList2;
                        int i3 = 1;
                    }
                } else if (obj != null) {
                    AppMethodBeat.m2505o(24946);
                    return linkedList;
                } else {
                    c21832a.fPL = linkedList2;
                    obj2 = 1;
                    linkedList.add(c21832a);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            linkedList.add(c21832a);
            i++;
            obj = obj2;
        }
        AppMethodBeat.m2505o(24946);
        return linkedList;
    }

    /* renamed from: a */
    private static C21833a m33380a(Map<String, String> map, int i, String str) {
        AppMethodBeat.m2504i(24947);
        C21833a c21833a = new C21833a(i);
        c21833a.title = C5046bo.nullAsNil((String) map.get(str + ".title"));
        c21833a.summary = C5046bo.nullAsNil((String) map.get(str + ".summary"));
        String str2 = str + ".thumburl";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 100) {
                break;
            }
            String str3 = (String) map.get(str2 + (i3 > 0 ? Integer.valueOf(i3) : ""));
            if (C5046bo.isNullOrNil(str3)) {
                break;
            }
            c21833a.qwO.add(str3);
            i2 = i3 + 1;
        }
        switch (i) {
            case 3:
                c21833a.qwN = C5046bo.nullAsNil((String) map.get(str + ".h5url.link"));
                c21833a.qwP = C5046bo.nullAsNil((String) map.get(str + ".h5url.title"));
                c21833a.qwQ = C5046bo.nullAsNil((String) map.get(str + ".h5url.username"));
                break;
            case 4:
                c21833a.qwN = C5046bo.nullAsNil((String) map.get(str + ".bizprofile.username"));
                c21833a.qwP = C5046bo.nullAsNil((String) map.get(str + ".bizprofile.showchat"));
                break;
            case 5:
                c21833a.qwN = C5046bo.nullAsNil((String) map.get(str + ".nativepay.wx_pay_url"));
                break;
            case 6:
                c21833a.qwN = C5046bo.nullAsNil((String) map.get(str + ".product.product_id"));
                break;
        }
        AppMethodBeat.m2505o(24947);
        return c21833a;
    }
}
