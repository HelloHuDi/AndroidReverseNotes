package com.tencent.p177mm.plugin.remittance.p497ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C44141lp;
import com.tencent.p177mm.protocal.protobuf.abv;
import com.tencent.p177mm.protocal.protobuf.abw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.ui.b */
public final class C3728b {
    abv pQG = null;
    C44141lp pQH;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.b$a */
    class C3729a implements Comparator {
        C3729a() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((abv) obj).wjh - ((abv) obj2).wjh > 0 ? -1 : 1;
        }
    }

    public final void cft() {
        AppMethodBeat.m2504i(44808);
        C4990ab.m7416i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
        this.pQH = null;
        this.pQG = null;
        AppMethodBeat.m2505o(44808);
    }

    public final List<abw> cfu() {
        AppMethodBeat.m2504i(44809);
        if (this.pQH != null) {
            LinkedList linkedList = this.pQH.vPg;
            AppMethodBeat.m2505o(44809);
            return linkedList;
        }
        List<abw> linkedList2 = new LinkedList();
        AppMethodBeat.m2505o(44809);
        return linkedList2;
    }

    public final String cfv() {
        if (this.pQH == null) {
            return "";
        }
        return this.pQH.vPk;
    }

    public final boolean cfw() {
        if (this.pQH != null) {
            return true;
        }
        return false;
    }

    public final boolean cfx() {
        AppMethodBeat.m2504i(44810);
        if (this.pQH == null || this.pQH.vPg == null || this.pQH.vPg.size() <= 0) {
            AppMethodBeat.m2505o(44810);
            return false;
        }
        AppMethodBeat.m2505o(44810);
        return true;
    }

    /* renamed from: VR */
    public final void mo8364VR(String str) {
        AppMethodBeat.m2504i(44811);
        this.pQG = null;
        if (str == null) {
            this.pQG = null;
            AppMethodBeat.m2505o(44811);
        } else if (this.pQH == null) {
            C4990ab.m7412e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
            this.pQG = null;
            AppMethodBeat.m2505o(44811);
        } else {
            Iterator it = this.pQH.vPh.iterator();
            while (it.hasNext()) {
                abv abv = (abv) it.next();
                if (str.equals(abv.wjd)) {
                    this.pQG = abv;
                    AppMethodBeat.m2505o(44811);
                    return;
                }
            }
            AppMethodBeat.m2505o(44811);
        }
    }

    /* renamed from: a */
    public final boolean mo8365a(List<abw> list, abw abw) {
        AppMethodBeat.m2504i(44812);
        if (this.pQH == null) {
            C4990ab.m7412e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
            AppMethodBeat.m2505o(44812);
            return false;
        }
        abv abv;
        String bigInteger;
        if (abw != null) {
            bigInteger = new BigInteger(Long.toBinaryString(abw.wjm), 2).toString();
        } else {
            bigInteger = null;
        }
        LinkedList<abv> linkedList = new LinkedList();
        Iterator it = this.pQH.vPh.iterator();
        while (it.hasNext()) {
            abv = (abv) it.next();
            if (abw == null || (!C5046bo.isNullOrNil(bigInteger) && abv.wjd.contains(bigInteger))) {
                linkedList.add(abv);
            }
        }
        LinkedList linkedList2 = new LinkedList();
        for (abv abv2 : linkedList) {
            if (C3728b.m6033a((List) list, abv2)) {
                linkedList2.add(abv2);
            }
        }
        if (linkedList2.size() > 0) {
            Collections.sort(linkedList2, new C3729a());
            this.pQG = (abv) linkedList2.get(0);
            AppMethodBeat.m2505o(44812);
            return true;
        }
        this.pQG = null;
        AppMethodBeat.m2505o(44812);
        return false;
    }

    /* renamed from: a */
    private static boolean m6033a(List<abw> list, abv abv) {
        AppMethodBeat.m2504i(44813);
        if (abv.vPg.size() == 0) {
            AppMethodBeat.m2505o(44813);
            return false;
        }
        HashSet hashSet = new HashSet();
        for (abw abw : list) {
            hashSet.add(Long.valueOf(abw.wjm));
        }
        Iterator it = abv.vPg.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(((abw) it.next()).wjm))) {
                AppMethodBeat.m2505o(44813);
                return false;
            }
        }
        AppMethodBeat.m2505o(44813);
        return true;
    }
}
