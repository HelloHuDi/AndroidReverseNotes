package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public final class b implements com.tencent.mm.plugin.label.a.b {
    ArrayList<String> nHp;
    ArrayList<String> nHq;
    private f nHr = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(22488);
            ab.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
            switch (mVar.getType()) {
                case com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX /*635*/:
                    if (i == 0 && i2 == 0) {
                        b.i(b.this.username, b.this.nHp);
                        AppMethodBeat.o(22488);
                        return;
                    }
                    b.this.bIW();
                    ab.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                    AppMethodBeat.o(22488);
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        int i3;
                        int i4;
                        if (b.this.nHq == null || b.this.nHq.isEmpty()) {
                            i3 = 0;
                        } else {
                            i3 = b.this.nHq.size();
                        }
                        if (b.this.nHp == null || b.this.nHp.isEmpty()) {
                            i4 = 0;
                        } else {
                            i4 = b.this.nHp.size() - i3;
                        }
                        if (i3 > 0 || i4 > 0) {
                            ab.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                            h.pYm.e(11220, r.Yz(), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0), Integer.valueOf(0));
                        }
                    }
                    b.this.bIW();
                    break;
            }
            AppMethodBeat.o(22488);
        }
    };
    String username;

    public b() {
        AppMethodBeat.i(22489);
        AppMethodBeat.o(22489);
    }

    public final void ahw() {
        AppMethodBeat.i(22490);
        e.bIZ().ahw();
        AppMethodBeat.o(22490);
    }

    public final String PD(String str) {
        AppMethodBeat.i(22491);
        String PD = e.bIZ().PD(str);
        AppMethodBeat.o(22491);
        return PD;
    }

    public final String PE(String str) {
        AppMethodBeat.i(22492);
        String PE = e.bIZ().PE(str);
        AppMethodBeat.o(22492);
        return PE;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(22493);
        e.bIZ().c(aVar);
        AppMethodBeat.o(22493);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(22494);
        e.bIZ().d(aVar);
        AppMethodBeat.o(22494);
    }

    public final List<String> bIV() {
        AppMethodBeat.i(22495);
        ai bIZ = e.bIZ();
        long anU = bo.anU();
        ArrayList dsn = bIZ.dsn();
        if (dsn == null) {
            AppMethodBeat.o(22495);
            return null;
        }
        bIZ.dso();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dsn.size(); i++) {
            ArrayList arrayList2 = (ArrayList) bIZ.xXe.get(Integer.valueOf(((af) dsn.get(i)).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(((af) dsn.get(i)).field_labelName);
            }
        }
        ab.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(dsn.size()), Integer.valueOf(arrayList.size()), bo.dpG());
        AppMethodBeat.o(22495);
        return arrayList;
    }

    public final List<String> PF(String str) {
        AppMethodBeat.i(22496);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            AppMethodBeat.o(22496);
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            AppMethodBeat.o(22496);
            return null;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        AppMethodBeat.o(22496);
        return arrayList;
    }

    public final String cd(List<String> list) {
        AppMethodBeat.i(22497);
        if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            AppMethodBeat.o(22497);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) list.get(i));
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(22497);
        return stringBuilder2;
    }

    public final synchronized void eQ(String str, String str2) {
        AppMethodBeat.i(22498);
        ab.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", String.valueOf(str), String.valueOf(str2));
        if (bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
            AppMethodBeat.o(22498);
        } else {
            ArrayList arrayList = (ArrayList) PF(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                ab.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
                AppMethodBeat.o(22498);
            } else {
                this.username = str;
                this.nHp = arrayList;
                int size = arrayList.size();
                this.nHq = new ArrayList();
                for (int i = 0; i < size; i++) {
                    af aoE = e.bIZ().aoE((String) arrayList.get(i));
                    if (aoE != null && aoE.field_isTemporary) {
                        this.nHq.add(arrayList.get(i));
                    }
                }
                aw.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, this.nHr);
                aw.Rg().a(638, this.nHr);
                if (this.nHq == null || this.nHq.isEmpty()) {
                    i(str, arrayList);
                    bIW();
                    AppMethodBeat.o(22498);
                } else {
                    ab.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", this.nHq.toString());
                    aw.Rg().a(new com.tencent.mm.plugin.label.b.a(this.nHq), 0);
                    AppMethodBeat.o(22498);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void bIW() {
        AppMethodBeat.i(22499);
        this.username = null;
        this.nHp = null;
        this.nHq = null;
        aw.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, this.nHr);
        aw.Rg().b(638, this.nHr);
        AppMethodBeat.o(22499);
    }

    static void i(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(22500);
        String str2 = "MicroMsg.Label.ContactLabelManagerImpl";
        String str3 = "cpan[saveContact] username:%s,list:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        ab.d(str2, str3, objArr);
        if (bo.isNullOrNil(str) || arrayList == null || arrayList.size() <= 0) {
            ab.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            AppMethodBeat.o(22500);
            return;
        }
        String str4 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str4 = c.cf(e.bIZ().ai(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        cmh cmh = new cmh();
        cmh.wcD = str4;
        cmh.jBB = str;
        linkedList.add(cmh);
        aw.Rg().a(new d(linkedList), 0);
        AppMethodBeat.o(22500);
    }

    public final void ce(List<String> list) {
        AppMethodBeat.i(22501);
        aw.Rg().a(new com.tencent.mm.plugin.label.b.a((List) list), 0);
        AppMethodBeat.o(22501);
    }

    public final void i(List<String> list, List<String> list2) {
        String str;
        String str2;
        AppMethodBeat.i(22502);
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator it = list2.iterator();
            for (String str22 : list) {
                ArrayList<String> P = bo.P(((String) it.next()).split(","));
                if (P != null && P.size() > 0) {
                    for (String str3 : P) {
                        String str4;
                        String eR;
                        if (hashMap.containsKey(str3)) {
                            str4 = (String) hashMap.get(str3);
                            eR = c.eR(str4, str22);
                            if (!eR.equalsIgnoreCase(str4)) {
                                hashMap.put(str3, eR);
                            }
                        } else {
                            aw.ZK();
                            ad aoO = c.XM().aoO(str3);
                            if (aoO != null) {
                                str4 = aoO.field_contactLabelIds;
                                eR = c.eR(str4, str22);
                                if (!eR.equalsIgnoreCase(str4)) {
                                    hashMap.put(str3, eR);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            str3 = (String) entry.getKey();
            str22 = (String) entry.getValue();
            cmh cmh = new cmh();
            cmh.jBB = str3;
            cmh.wcD = str22;
            linkedList.add(cmh);
        }
        if (linkedList.size() > 0) {
            aw.Rg().a(new d(linkedList), 0);
        }
        AppMethodBeat.o(22502);
    }

    public final /* synthetic */ List PG(String str) {
        AppMethodBeat.i(22503);
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            AppMethodBeat.o(22503);
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        List R = e.bIZ().R(str.split(","));
        AppMethodBeat.o(22503);
        return R;
    }

    public final /* synthetic */ List PH(String str) {
        AppMethodBeat.i(22504);
        ArrayList aoD = e.bIZ().aoD(str);
        AppMethodBeat.o(22504);
        return aoD;
    }

    public final /* synthetic */ List bIX() {
        AppMethodBeat.i(22505);
        ArrayList dsm = e.bIZ().dsm();
        AppMethodBeat.o(22505);
        return dsm;
    }
}
