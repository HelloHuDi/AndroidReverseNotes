package com.tencent.mm.plugin.shake.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a {
    public LinkedList<a> fPL = new LinkedList();

    public static class a {
        public String qwN;
        public List<String> qwO = new ArrayList();
        public String qwP = "";
        public String qwQ = "";
        public String summary;
        public String title;
        public int type;

        public a() {
            AppMethodBeat.i(24943);
            AppMethodBeat.o(24943);
        }

        public a(int i) {
            AppMethodBeat.i(24944);
            this.type = i;
            AppMethodBeat.o(24944);
        }
    }

    public a() {
        AppMethodBeat.i(24945);
        AppMethodBeat.o(24945);
    }

    public static LinkedList<a> l(Map<String, String> map, String str) {
        AppMethodBeat.i(24946);
        LinkedList<a> linkedList = new LinkedList();
        int i = 0;
        Object obj = null;
        while (i < 1000) {
            Object obj2;
            a aVar = new a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < 1000) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!bo.isNullOrNil((String) map.get(str3 + ".type"))) {
                    try {
                        int intValue = Integer.valueOf((String) map.get(str3 + ".type")).intValue();
                        obj2 = null;
                        if (intValue == 2) {
                            a aVar2 = new a(intValue);
                            aVar2.qwN = bo.nullAsNil((String) map.get(str3 + ".comment.id"));
                            aVar2.title = bo.nullAsNil((String) map.get(str3 + ".comment.title"));
                            obj2 = aVar2;
                        } else if (intValue == 3) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 4) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 5) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 6) {
                            obj2 = a(map, intValue, str3);
                        }
                        if (obj2 != null) {
                            linkedList2.add(obj2);
                        }
                        i2++;
                        obj = null;
                    } catch (Exception e) {
                        new StringBuilder("Exception in parseActionList: ").append(e.getMessage());
                        if (obj != null) {
                            AppMethodBeat.o(24946);
                            return linkedList;
                        }
                        aVar.fPL = linkedList2;
                        int i3 = 1;
                    }
                } else if (obj != null) {
                    AppMethodBeat.o(24946);
                    return linkedList;
                } else {
                    aVar.fPL = linkedList2;
                    obj2 = 1;
                    linkedList.add(aVar);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            linkedList.add(aVar);
            i++;
            obj = obj2;
        }
        AppMethodBeat.o(24946);
        return linkedList;
    }

    private static a a(Map<String, String> map, int i, String str) {
        AppMethodBeat.i(24947);
        a aVar = new a(i);
        aVar.title = bo.nullAsNil((String) map.get(str + ".title"));
        aVar.summary = bo.nullAsNil((String) map.get(str + ".summary"));
        String str2 = str + ".thumburl";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 100) {
                break;
            }
            String str3 = (String) map.get(str2 + (i3 > 0 ? Integer.valueOf(i3) : ""));
            if (bo.isNullOrNil(str3)) {
                break;
            }
            aVar.qwO.add(str3);
            i2 = i3 + 1;
        }
        switch (i) {
            case 3:
                aVar.qwN = bo.nullAsNil((String) map.get(str + ".h5url.link"));
                aVar.qwP = bo.nullAsNil((String) map.get(str + ".h5url.title"));
                aVar.qwQ = bo.nullAsNil((String) map.get(str + ".h5url.username"));
                break;
            case 4:
                aVar.qwN = bo.nullAsNil((String) map.get(str + ".bizprofile.username"));
                aVar.qwP = bo.nullAsNil((String) map.get(str + ".bizprofile.showchat"));
                break;
            case 5:
                aVar.qwN = bo.nullAsNil((String) map.get(str + ".nativepay.wx_pay_url"));
                break;
            case 6:
                aVar.qwN = bo.nullAsNil((String) map.get(str + ".product.product_id"));
                break;
        }
        AppMethodBeat.o(24947);
        return aVar;
    }
}
