package com.tencent.mm.plugin.f.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public abstract class a {
    public abstract List<com.tencent.mm.plugin.f.b.a> Q(bi biVar);

    public abstract String aZm();

    public final void P(bi biVar) {
        int i = 0;
        if (biVar != null) {
            List S = b.aZc().aZd().S(biVar);
            List Q = Q(biVar);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int a = a(S, Q, arrayList, arrayList2);
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
            ab.i(str, str2, objArr);
            if (a >= 0) {
                if (!arrayList.isEmpty()) {
                    b.aZc().aZd().bd(arrayList);
                }
                if (!arrayList2.isEmpty()) {
                    b.aZc().aZd().be(arrayList2);
                }
            }
        }
    }

    private static int a(List<com.tencent.mm.plugin.f.b.a> list, List<com.tencent.mm.plugin.f.b.a> list2, List<com.tencent.mm.plugin.f.b.a> list3, List<com.tencent.mm.plugin.f.b.a> list4) {
        if (list2 == null || list2.isEmpty()) {
            return -1;
        }
        com.tencent.mm.plugin.f.b.a aVar;
        if (list == null || list.isEmpty()) {
            for (com.tencent.mm.plugin.f.b.a aVar2 : list2) {
                list3.add(aVar2);
            }
            return 0;
        }
        int size = list.size();
        int size2 = list2.size();
        int i = 0;
        int i2 = 0;
        while (i < size2) {
            aVar2 = (com.tencent.mm.plugin.f.b.a) list2.get(i);
            if (aVar2 != null) {
                com.tencent.mm.plugin.f.b.a aVar3 = i2 < size ? (com.tencent.mm.plugin.f.b.a) list.get(i2) : null;
                if (aVar3 != null) {
                    if (aVar2.field_msgSubType != aVar3.field_msgSubType) {
                        if (aVar2.field_msgSubType >= aVar3.field_msgSubType) {
                            break;
                        }
                        int i3 = i + 1;
                        list3.add(aVar2);
                        i = i3;
                    } else {
                        if (!bo.isEqual(aVar2.field_path, aVar3.field_path)) {
                            aVar2.xDa = aVar3.xDa;
                            list4.add(aVar2);
                        } else if (!bo.af(aVar2.field_size, aVar3.field_size)) {
                            aVar2.xDa = aVar3.xDa;
                            list4.add(aVar2);
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

    protected static com.tencent.mm.plugin.f.b.a R(bi biVar) {
        com.tencent.mm.plugin.f.b.a aVar = new com.tencent.mm.plugin.f.b.a();
        aVar.field_msgId = biVar.field_msgId;
        aVar.field_msgType = biVar.getType();
        aVar.field_username = biVar.field_talker;
        aVar.field_msgtime = biVar.field_createTime;
        return aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final String Gh(String str) {
        if (bo.isNullOrNil(str)) {
            return "";
        }
        String str2 = g.RP().eJL;
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return str;
        }
        ab.d("MicroMsg.AbstractMsgHandler", "%s cut down result[%s] root[%s] path[%s]", aZm(), str.substring(indexOf + str2.length()), str2, str);
        return str.substring(indexOf + str2.length());
    }
}
