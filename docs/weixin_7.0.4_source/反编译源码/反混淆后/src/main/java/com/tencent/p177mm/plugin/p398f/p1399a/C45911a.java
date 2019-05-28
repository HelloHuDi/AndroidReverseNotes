package com.tencent.p177mm.plugin.p398f.p1399a;

import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.f.a.a */
public abstract class C45911a {
    /* renamed from: Q */
    public abstract List<C34092a> mo45810Q(C7620bi c7620bi);

    public abstract String aZm();

    /* renamed from: P */
    public final void mo73747P(C7620bi c7620bi) {
        int i = 0;
        if (c7620bi != null) {
            List S = C45913b.aZc().aZd().mo61892S(c7620bi);
            List Q = mo45810Q(c7620bi);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int a = C45911a.m85148a(S, Q, arrayList, arrayList2);
            String str = "MicroMsg.AbstractMsgHandler";
            String str2 = "%s handle compare[%d] db[%d] create[%d] insert[%d] update[%d]";
            Object[] objArr = new Object[6];
            objArr[0] = aZm();
            objArr[1] = Integer.valueOf(a);
            objArr[2] = Integer.valueOf(S != null ? S.size() : 0);
            if (Q != null) {
                i = Q.size();
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(arrayList.size());
            objArr[5] = Integer.valueOf(arrayList2.size());
            C4990ab.m7417i(str, str2, objArr);
            if (a >= 0) {
                if (!arrayList.isEmpty()) {
                    C45913b.aZc().aZd().mo61895bd(arrayList);
                }
                if (!arrayList2.isEmpty()) {
                    C45913b.aZc().aZd().mo61896be(arrayList2);
                }
            }
        }
    }

    /* renamed from: a */
    private static int m85148a(List<C34092a> list, List<C34092a> list2, List<C34092a> list3, List<C34092a> list4) {
        if (list2 == null || list2.isEmpty()) {
            return -1;
        }
        C34092a c34092a;
        if (list == null || list.isEmpty()) {
            for (C34092a c34092a2 : list2) {
                list3.add(c34092a2);
            }
            return 0;
        }
        int size = list.size();
        int size2 = list2.size();
        int i = 0;
        int i2 = 0;
        while (i < size2) {
            c34092a2 = (C34092a) list2.get(i);
            if (c34092a2 != null) {
                C34092a c34092a3 = i2 < size ? (C34092a) list.get(i2) : null;
                if (c34092a3 != null) {
                    if (c34092a2.field_msgSubType != c34092a3.field_msgSubType) {
                        if (c34092a2.field_msgSubType >= c34092a3.field_msgSubType) {
                            break;
                        }
                        int i3 = i + 1;
                        list3.add(c34092a2);
                        i = i3;
                    } else {
                        if (!C5046bo.isEqual(c34092a2.field_path, c34092a3.field_path)) {
                            c34092a2.xDa = c34092a3.xDa;
                            list4.add(c34092a2);
                        } else if (!C5046bo.m7521af(c34092a2.field_size, c34092a3.field_size)) {
                            c34092a2.xDa = c34092a3.xDa;
                            list4.add(c34092a2);
                        }
                        i++;
                        i2++;
                    }
                } else {
                    break;
                }
            }
            break;
        }
        return 1;
    }

    /* renamed from: R */
    protected static C34092a m85147R(C7620bi c7620bi) {
        C34092a c34092a = new C34092a();
        c34092a.field_msgId = c7620bi.field_msgId;
        c34092a.field_msgType = c7620bi.getType();
        c34092a.field_username = c7620bi.field_talker;
        c34092a.field_msgtime = c7620bi.field_createTime;
        return c34092a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Gh */
    public final String mo73746Gh(String str) {
        if (C5046bo.isNullOrNil(str)) {
            return "";
        }
        String str2 = C1720g.m3536RP().eJL;
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return str;
        }
        C4990ab.m7411d("MicroMsg.AbstractMsgHandler", "%s cut down result[%s] root[%s] path[%s]", aZm(), str.substring(indexOf + str2.length()), str2, str);
        return str.substring(indexOf + str2.length());
    }
}
