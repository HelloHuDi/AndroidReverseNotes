package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    abv pQG = null;
    lp pQH;

    class a implements Comparator {
        a() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((abv) obj).wjh - ((abv) obj2).wjh > 0 ? -1 : 1;
        }
    }

    public final void cft() {
        AppMethodBeat.i(44808);
        ab.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
        this.pQH = null;
        this.pQG = null;
        AppMethodBeat.o(44808);
    }

    public final List<abw> cfu() {
        AppMethodBeat.i(44809);
        if (this.pQH != null) {
            LinkedList linkedList = this.pQH.vPg;
            AppMethodBeat.o(44809);
            return linkedList;
        }
        List<abw> linkedList2 = new LinkedList();
        AppMethodBeat.o(44809);
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
        AppMethodBeat.i(44810);
        if (this.pQH == null || this.pQH.vPg == null || this.pQH.vPg.size() <= 0) {
            AppMethodBeat.o(44810);
            return false;
        }
        AppMethodBeat.o(44810);
        return true;
    }

    public final void VR(String str) {
        AppMethodBeat.i(44811);
        this.pQG = null;
        if (str == null) {
            this.pQG = null;
            AppMethodBeat.o(44811);
        } else if (this.pQH == null) {
            ab.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
            this.pQG = null;
            AppMethodBeat.o(44811);
        } else {
            Iterator it = this.pQH.vPh.iterator();
            while (it.hasNext()) {
                abv abv = (abv) it.next();
                if (str.equals(abv.wjd)) {
                    this.pQG = abv;
                    AppMethodBeat.o(44811);
                    return;
                }
            }
            AppMethodBeat.o(44811);
        }
    }

    public final boolean a(List<abw> list, abw abw) {
        AppMethodBeat.i(44812);
        if (this.pQH == null) {
            ab.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
            AppMethodBeat.o(44812);
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
            if (abw == null || (!bo.isNullOrNil(bigInteger) && abv.wjd.contains(bigInteger))) {
                linkedList.add(abv);
            }
        }
        LinkedList linkedList2 = new LinkedList();
        for (abv abv2 : linkedList) {
            if (a((List) list, abv2)) {
                linkedList2.add(abv2);
            }
        }
        if (linkedList2.size() > 0) {
            Collections.sort(linkedList2, new a());
            this.pQG = (abv) linkedList2.get(0);
            AppMethodBeat.o(44812);
            return true;
        }
        this.pQG = null;
        AppMethodBeat.o(44812);
        return false;
    }

    private static boolean a(List<abw> list, abv abv) {
        AppMethodBeat.i(44813);
        if (abv.vPg.size() == 0) {
            AppMethodBeat.o(44813);
            return false;
        }
        HashSet hashSet = new HashSet();
        for (abw abw : list) {
            hashSet.add(Long.valueOf(abw.wjm));
        }
        Iterator it = abv.vPg.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(((abw) it.next()).wjm))) {
                AppMethodBeat.o(44813);
                return false;
            }
        }
        AppMethodBeat.o(44813);
        return true;
    }
}
