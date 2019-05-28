package com.tencent.p177mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42558b;
import com.tencent.p177mm.plugin.label.p1276a.C24783b;
import com.tencent.p177mm.plugin.label.p1277b.C21157a;
import com.tencent.p177mm.plugin.label.p1277b.C43237d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.cmh;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40622ai;
import com.tencent.p177mm.storage.C46619af;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.label.b */
public final class C43239b implements C24783b {
    ArrayList<String> nHp;
    ArrayList<String> nHq;
    private C1202f nHr = new C344021();
    String username;

    /* renamed from: com.tencent.mm.plugin.label.b$1 */
    class C344021 implements C1202f {
        C344021() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(22488);
            C4990ab.m7412e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
            switch (c1207m.getType()) {
                case C42558b.CTRL_INDEX /*635*/:
                    if (i == 0 && i2 == 0) {
                        C43239b.m76889i(C43239b.this.username, C43239b.this.nHp);
                        AppMethodBeat.m2505o(22488);
                        return;
                    }
                    C43239b.this.bIW();
                    C4990ab.m7412e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                    AppMethodBeat.m2505o(22488);
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        int i3;
                        int i4;
                        if (C43239b.this.nHq == null || C43239b.this.nHq.isEmpty()) {
                            i3 = 0;
                        } else {
                            i3 = C43239b.this.nHq.size();
                        }
                        if (C43239b.this.nHp == null || C43239b.this.nHp.isEmpty()) {
                            i4 = 0;
                        } else {
                            i4 = C43239b.this.nHp.size() - i3;
                        }
                        if (i3 > 0 || i4 > 0) {
                            C4990ab.m7411d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                            C7060h.pYm.mo8381e(11220, C1853r.m3846Yz(), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0), Integer.valueOf(0));
                        }
                    }
                    C43239b.this.bIW();
                    break;
            }
            AppMethodBeat.m2505o(22488);
        }
    }

    public C43239b() {
        AppMethodBeat.m2504i(22489);
        AppMethodBeat.m2505o(22489);
    }

    public final void ahw() {
        AppMethodBeat.m2504i(22490);
        C21160e.bIZ().ahw();
        AppMethodBeat.m2505o(22490);
    }

    /* renamed from: PD */
    public final String mo41631PD(String str) {
        AppMethodBeat.m2504i(22491);
        String PD = C21160e.bIZ().mo64066PD(str);
        AppMethodBeat.m2505o(22491);
        return PD;
    }

    /* renamed from: PE */
    public final String mo41632PE(String str) {
        AppMethodBeat.m2504i(22492);
        String PE = C21160e.bIZ().mo64067PE(str);
        AppMethodBeat.m2505o(22492);
        return PE;
    }

    /* renamed from: a */
    public final void mo33518a(C4931a c4931a) {
        AppMethodBeat.m2504i(22493);
        C21160e.bIZ().mo10116c(c4931a);
        AppMethodBeat.m2505o(22493);
    }

    /* renamed from: b */
    public final void mo33519b(C4931a c4931a) {
        AppMethodBeat.m2504i(22494);
        C21160e.bIZ().mo10117d(c4931a);
        AppMethodBeat.m2505o(22494);
    }

    public final List<String> bIV() {
        AppMethodBeat.m2504i(22495);
        C40622ai bIZ = C21160e.bIZ();
        long anU = C5046bo.anU();
        ArrayList dsn = bIZ.dsn();
        if (dsn == null) {
            AppMethodBeat.m2505o(22495);
            return null;
        }
        bIZ.dso();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dsn.size(); i++) {
            ArrayList arrayList2 = (ArrayList) bIZ.xXe.get(Integer.valueOf(((C46619af) dsn.get(i)).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(((C46619af) dsn.get(i)).field_labelName);
            }
        }
        C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(dsn.size()), Integer.valueOf(arrayList.size()), C5046bo.dpG());
        AppMethodBeat.m2505o(22495);
        return arrayList;
    }

    /* renamed from: PF */
    public final List<String> mo41633PF(String str) {
        AppMethodBeat.m2504i(22496);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            AppMethodBeat.m2505o(22496);
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            AppMethodBeat.m2505o(22496);
            return null;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        AppMethodBeat.m2505o(22496);
        return arrayList;
    }

    /* renamed from: cd */
    public final String mo41639cd(List<String> list) {
        AppMethodBeat.m2504i(22497);
        if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            AppMethodBeat.m2505o(22497);
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
        AppMethodBeat.m2505o(22497);
        return stringBuilder2;
    }

    /* renamed from: eQ */
    public final synchronized void mo41641eQ(String str, String str2) {
        AppMethodBeat.m2504i(22498);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", String.valueOf(str), String.valueOf(str2));
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
            AppMethodBeat.m2505o(22498);
        } else {
            ArrayList arrayList = (ArrayList) mo41633PF(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                C4990ab.m7420w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
                AppMethodBeat.m2505o(22498);
            } else {
                this.username = str;
                this.nHp = arrayList;
                int size = arrayList.size();
                this.nHq = new ArrayList();
                for (int i = 0; i < size; i++) {
                    C46619af aoE = C21160e.bIZ().aoE((String) arrayList.get(i));
                    if (aoE != null && aoE.field_isTemporary) {
                        this.nHq.add(arrayList.get(i));
                    }
                }
                C9638aw.m17182Rg().mo14539a((int) C42558b.CTRL_INDEX, this.nHr);
                C9638aw.m17182Rg().mo14539a(638, this.nHr);
                if (this.nHq == null || this.nHq.isEmpty()) {
                    C43239b.m76889i(str, arrayList);
                    bIW();
                    AppMethodBeat.m2505o(22498);
                } else {
                    C4990ab.m7417i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", this.nHq.toString());
                    C9638aw.m17182Rg().mo14541a(new C21157a(this.nHq), 0);
                    AppMethodBeat.m2505o(22498);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void bIW() {
        AppMethodBeat.m2504i(22499);
        this.username = null;
        this.nHp = null;
        this.nHq = null;
        C9638aw.m17182Rg().mo14546b((int) C42558b.CTRL_INDEX, this.nHr);
        C9638aw.m17182Rg().mo14546b(638, this.nHr);
        AppMethodBeat.m2505o(22499);
    }

    /* renamed from: i */
    static void m76889i(String str, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(22500);
        String str2 = "MicroMsg.Label.ContactLabelManagerImpl";
        String str3 = "cpan[saveContact] username:%s,list:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        C4990ab.m7411d(str2, str3, objArr);
        if (C5046bo.isNullOrNil(str) || arrayList == null || arrayList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            AppMethodBeat.m2505o(22500);
            return;
        }
        String str4 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str4 = C21158c.m32494cf(C21160e.bIZ().mo64071ai(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        cmh cmh = new cmh();
        cmh.wcD = str4;
        cmh.jBB = str;
        linkedList.add(cmh);
        C9638aw.m17182Rg().mo14541a(new C43237d(linkedList), 0);
        AppMethodBeat.m2505o(22500);
    }

    /* renamed from: ce */
    public final void mo41640ce(List<String> list) {
        AppMethodBeat.m2504i(22501);
        C9638aw.m17182Rg().mo14541a(new C21157a((List) list), 0);
        AppMethodBeat.m2505o(22501);
    }

    /* renamed from: i */
    public final void mo41642i(List<String> list, List<String> list2) {
        String str;
        String str2;
        AppMethodBeat.m2504i(22502);
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator it = list2.iterator();
            for (String str22 : list) {
                ArrayList<String> P = C5046bo.m7508P(((String) it.next()).split(","));
                if (P != null && P.size() > 0) {
                    for (String str3 : P) {
                        String str4;
                        String eR;
                        if (hashMap.containsKey(str3)) {
                            str4 = (String) hashMap.get(str3);
                            eR = C21158c.m32495eR(str4, str22);
                            if (!eR.equalsIgnoreCase(str4)) {
                                hashMap.put(str3, eR);
                            }
                        } else {
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(str3);
                            if (aoO != null) {
                                str4 = aoO.field_contactLabelIds;
                                eR = C21158c.m32495eR(str4, str22);
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
            C9638aw.m17182Rg().mo14541a(new C43237d(linkedList), 0);
        }
        AppMethodBeat.m2505o(22502);
    }

    /* renamed from: PG */
    public final /* synthetic */ List mo41634PG(String str) {
        AppMethodBeat.m2504i(22503);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            AppMethodBeat.m2505o(22503);
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        List R = C21160e.bIZ().mo64068R(str.split(","));
        AppMethodBeat.m2505o(22503);
        return R;
    }

    /* renamed from: PH */
    public final /* synthetic */ List mo41635PH(String str) {
        AppMethodBeat.m2504i(22504);
        ArrayList aoD = C21160e.bIZ().aoD(str);
        AppMethodBeat.m2505o(22504);
        return aoD;
    }

    public final /* synthetic */ List bIX() {
        AppMethodBeat.m2504i(22505);
        ArrayList dsm = C21160e.bIZ().dsm();
        AppMethodBeat.m2505o(22505);
        return dsm;
    }
}
