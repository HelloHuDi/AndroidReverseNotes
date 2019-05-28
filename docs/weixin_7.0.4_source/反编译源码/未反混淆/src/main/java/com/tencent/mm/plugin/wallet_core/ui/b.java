package com.tencent.mm.plugin.wallet_core.ui;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class b {
    public h tDO = null;
    private Map<String, t> tDP = null;
    private Map<String, j> tDQ = null;

    public static final class a {
        public String pcj;
        public j tDR;
        public double tDS;
        public String tDT;

        public final String toString() {
            AppMethodBeat.i(47098);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.tDR != null) {
                stringBuffer.append("|faovrComposeId: " + this.tDR.tnk);
            }
            stringBuffer.append("|bankName: " + this.pcj);
            stringBuffer.append("|bankFavorAmount: " + this.tDS);
            stringBuffer.append("|bankType: " + this.tDT);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(47098);
            return stringBuffer2;
        }
    }

    public final boolean cRi() {
        AppMethodBeat.i(47099);
        if (this.tDP == null || this.tDP.size() <= 0) {
            AppMethodBeat.o(47099);
            return false;
        }
        AppMethodBeat.o(47099);
        return true;
    }

    public b(h hVar) {
        AppMethodBeat.i(47100);
        Assert.assertNotNull(hVar);
        this.tDO = hVar;
        Kh();
        AppMethodBeat.o(47100);
    }

    private void Kh() {
        int i = 0;
        AppMethodBeat.i(47101);
        this.tDP = new HashMap();
        LinkedList linkedList = this.tDO.tmV;
        if (linkedList != null) {
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                t tVar = (t) linkedList.get(i2);
                this.tDP.put(tVar.tmO, tVar);
            }
        } else {
            ab.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.tDQ = new HashMap();
        if (this.tDO.tmW == null || this.tDO.tmW.tni == null) {
            ab.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            AppMethodBeat.o(47101);
            return;
        }
        LinkedList linkedList2 = this.tDO.tmW.tni;
        while (i < linkedList2.size()) {
            j jVar = (j) linkedList2.get(i);
            this.tDQ.put(jVar.tnk, jVar);
            i++;
        }
        AppMethodBeat.o(47101);
    }

    public final Map<String, a> acR(String str) {
        AppMethodBeat.i(47102);
        Map bB = bB(str, false);
        AppMethodBeat.o(47102);
        return bB;
    }

    public final j bA(String str, boolean z) {
        AppMethodBeat.i(47103);
        j jVar;
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || !this.tDQ.containsKey(str)) {
            for (String str2 : this.tDQ.keySet()) {
                jVar = (j) this.tDQ.get(str2);
                if (!(jVar.tnm == null || jVar.tnm.size() == 0)) {
                    int i;
                    int size = jVar.tnm.size();
                    int i2 = 0;
                    Iterator it = jVar.tnm.iterator();
                    while (true) {
                        i = i2;
                        if (!it.hasNext()) {
                            break;
                        }
                        f fVar = (f) it.next();
                        if (!this.tDP.containsKey(fVar.tmO)) {
                            break;
                        }
                        t tVar = (t) this.tDP.get(fVar.tmO);
                        if (tVar.tnS.equals("") && tVar.tnU.size() == 0 && (!z || tVar.tnR == 0)) {
                            i++;
                        }
                        i2 = i;
                    }
                    if (i > 0 && i == size) {
                        AppMethodBeat.o(47103);
                        return jVar;
                    }
                }
            }
            AppMethodBeat.o(47103);
            return null;
        }
        jVar = (j) this.tDQ.get(str);
        AppMethodBeat.o(47103);
        return jVar;
    }

    public final Map<String, a> acS(String str) {
        AppMethodBeat.i(47104);
        HashMap hashMap = new HashMap();
        if (this.tDO.tmW != null && this.tDO.tmW.tni != null) {
            double d;
            LinkedList linkedList = this.tDO.tmW.tni;
            if (this.tDQ.containsKey(str)) {
                d = ((j) this.tDQ.get(str)).tnl;
            } else {
                d = 0.0d;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= linkedList.size()) {
                    break;
                }
                j jVar = (j) linkedList.get(i2);
                String str2 = null;
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !jVar.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str2 = jVar.tnk;
                } else if (jVar.tnk.startsWith(str) && !str.equals(jVar.tnk)) {
                    str2 = jVar.tnk.replace(str + "-", "");
                }
                String[] acV = acV(str2);
                if (acV != null && acV.length > 0) {
                    t tVar = (t) this.tDP.get(acV[0]);
                    if (tVar != null) {
                        Object obj;
                        if (tVar.tnR != 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null && tVar.tnU.size() > 0) {
                            Iterator it = tVar.tnU.iterator();
                            while (it.hasNext()) {
                                String a = aa.a((com.tencent.mm.bt.b) it.next());
                                a aVar = (a) hashMap.get(a);
                                if (aVar == null || jVar.tnl > aVar.tDR.tnl) {
                                    aVar = new a();
                                    aVar.tDR = jVar;
                                    aVar.pcj = tVar.pcj;
                                    aVar.tDS = jVar.tnl - d;
                                    aVar.tDT = tVar.tnS;
                                    hashMap.put(a, aVar);
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        } else {
            ab.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        }
        AppMethodBeat.o(47104);
        return hashMap;
    }

    public final Map<String, a> bB(String str, boolean z) {
        AppMethodBeat.i(47105);
        HashMap hashMap = new HashMap();
        if (this.tDO.tmW != null && this.tDO.tmW.tni != null) {
            double d;
            LinkedList linkedList = this.tDO.tmW.tni;
            if (this.tDQ.containsKey(str)) {
                d = ((j) this.tDQ.get(str)).tnl;
            } else {
                d = 0.0d;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= linkedList.size()) {
                    break;
                }
                j jVar = (j) linkedList.get(i2);
                String str2 = null;
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !jVar.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str2 = jVar.tnk;
                } else if (jVar.tnk.startsWith(str) && !str.equals(jVar.tnk)) {
                    str2 = jVar.tnk.replace(str + "-", "");
                }
                String[] acV = acV(str2);
                if (acV != null && acV.length > 0) {
                    t tVar = (t) this.tDP.get(acV[0]);
                    if (tVar != null) {
                        Object obj;
                        if (tVar.tnR != 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null && !bo.isNullOrNil(tVar.tnS) && tVar.tnU.size() <= 0 && (z || !tVar.tnS.equalsIgnoreCase("CFT"))) {
                            a aVar = (a) hashMap.get(tVar.tnS);
                            if (aVar == null || jVar.tnl > aVar.tDR.tnl) {
                                aVar = new a();
                                aVar.tDR = jVar;
                                aVar.pcj = tVar.pcj;
                                aVar.tDS = jVar.tnl - d;
                                aVar.tDT = tVar.tnS;
                                hashMap.put(tVar.tnS, aVar);
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        } else {
            ab.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        }
        AppMethodBeat.o(47105);
        return hashMap;
    }

    public final List<t> acT(String str) {
        AppMethodBeat.i(47106);
        LinkedList linkedList = new LinkedList();
        if (this.tDO.tmV != null) {
            Map acR = acR(str);
            for (int i = 0; i < this.tDO.tmV.size(); i++) {
                t tVar = (t) this.tDO.tmV.get(i);
                if (tVar != null) {
                    Object obj;
                    if (tVar.tnR != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && acR.containsKey(tVar.tnS)) {
                        linkedList.add(tVar);
                    }
                }
            }
        } else {
            ab.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        AppMethodBeat.o(47106);
        return linkedList;
    }

    public final int cRj() {
        AppMethodBeat.i(47107);
        int size = this.tDQ.size();
        AppMethodBeat.o(47107);
        return size;
    }

    public final j cRk() {
        AppMethodBeat.i(47108);
        if (!this.tDQ.isEmpty()) {
            Iterator it = this.tDQ.entrySet().iterator();
            if (it.hasNext()) {
                j jVar = (j) ((Entry) it.next()).getValue();
                AppMethodBeat.o(47108);
                return jVar;
            }
        }
        AppMethodBeat.o(47108);
        return null;
    }

    public final j acU(String str) {
        AppMethodBeat.i(47109);
        j jVar = (j) this.tDQ.get(str);
        AppMethodBeat.o(47109);
        return jVar;
    }

    public static String[] acV(String str) {
        AppMethodBeat.i(47110);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(47110);
            return null;
        }
        String[] split = str.split("-");
        AppMethodBeat.o(47110);
        return split;
    }

    public final String acW(String str) {
        AppMethodBeat.i(47111);
        String bC = bC(str, false);
        AppMethodBeat.o(47111);
        return bC;
    }

    public final String bC(String str, boolean z) {
        AppMethodBeat.i(47112);
        String[] acV = acV(str);
        String str2;
        if (acV != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < acV.length; i++) {
                t tVar = (t) this.tDP.get(acV[i]);
                if (tVar != null) {
                    Object obj;
                    if (tVar.tnR != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || (bo.isNullOrNil(tVar.tnS) && !z)) {
                        stringBuilder.append(acV[i]);
                        stringBuilder.append("-");
                    }
                }
            }
            if (stringBuilder.length() == 0) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                AppMethodBeat.o(47112);
                return str2;
            }
            str2 = stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
            AppMethodBeat.o(47112);
            return str2;
        }
        str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        AppMethodBeat.o(47112);
        return str2;
    }

    public final FavorPayInfo acX(String str) {
        AppMethodBeat.i(47113);
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.tDQ.get(str) == null) {
            favorPayInfo.tzb = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            if (this.tDO != null) {
                favorPayInfo.tze = this.tDO.tmU;
            }
            favorPayInfo.tzc = 0;
            AppMethodBeat.o(47113);
            return favorPayInfo;
        }
        favorPayInfo.tzb = str;
        if (this.tDO != null) {
            favorPayInfo.tze = this.tDO.tmU;
        }
        favorPayInfo.tzc = 0;
        String[] acV = acV(str);
        if (acV == null) {
            AppMethodBeat.o(47113);
            return favorPayInfo;
        }
        for (int length = acV.length - 1; length >= 0; length--) {
            t tVar = (t) this.tDP.get(acV[length]);
            if (tVar != null) {
                int i;
                if (tVar.tnR != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    break;
                }
                favorPayInfo.tzc = 1;
                if (tVar.tnU != null && tVar.tnU.size() > 0) {
                    favorPayInfo.tzg = new LinkedList();
                    Iterator it = tVar.tnU.iterator();
                    while (it.hasNext()) {
                        favorPayInfo.tzg.add(aa.a((com.tencent.mm.bt.b) it.next()));
                    }
                }
                if (!bo.isNullOrNil(tVar.tnS)) {
                    favorPayInfo.tzd = tVar.tnS;
                    break;
                }
            }
        }
        AppMethodBeat.o(47113);
        return favorPayInfo;
    }

    public static boolean a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        AppMethodBeat.i(47114);
        if (bankcard == null) {
            ab.w("MicroMsg.FavorLogicHelper", "curBankcard null");
            AppMethodBeat.o(47114);
            return true;
        }
        boolean z;
        if (!(favorPayInfo == null || bo.isNullOrNil(favorPayInfo.tzb))) {
            if (favorPayInfo.tzc != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !bo.isNullOrNil(favorPayInfo.tzd) && favorPayInfo.tzg != null && favorPayInfo.tzg.contains(bankcard.field_bindSerial)) {
                AppMethodBeat.o(47114);
                return false;
            }
        }
        if (favorPayInfo.tzc != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || ((bo.isNullOrNil(favorPayInfo.tzd) || bankcard.field_bankcardType == null || bankcard.field_bankcardType.equals(favorPayInfo.tzd)) && !(bo.isNullOrNil(favorPayInfo.tzd) && bankcard.field_bankcardType.equals("CFT")))) {
            AppMethodBeat.o(47114);
            return false;
        }
        AppMethodBeat.o(47114);
        return true;
    }

    public static List<Bankcard> bt(int i, String str) {
        boolean z;
        AppMethodBeat.i(47115);
        ArrayList nf = r.cPI().nf(true);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < nf.size(); i2++) {
                if (bo.isNullOrNil(str)) {
                    if (!((Bankcard) nf.get(i2)).field_bankcardType.equals("CFT")) {
                        z = true;
                    }
                    z = false;
                } else {
                    if (((Bankcard) nf.get(i2)).field_bankcardType.equals(str)) {
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    arrayList.add((Bankcard) nf.get(i2));
                }
            }
            AppMethodBeat.o(47115);
            return arrayList;
        }
        AppMethodBeat.o(47115);
        return nf;
    }

    private static String dV(List<String> list) {
        AppMethodBeat.i(47116);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                stringBuilder.append(((String) list.get(i2)));
                if (i2 < list.size() - 1) {
                    stringBuilder.append("-");
                }
                i = i2 + 1;
            } else {
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(47116);
                return stringBuilder2;
            }
        }
    }

    public final String acY(String str) {
        int i;
        AppMethodBeat.i(47117);
        ArrayList nf = r.cPI().nf(true);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (i = 0; i < nf.size(); i++) {
            hashMap.put(((Bankcard) nf.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        String[] acV = acV(str);
        if (acV != null) {
            for (Object obj : acV) {
                t tVar = (t) this.tDP.get(obj);
                if (tVar != null) {
                    boolean z;
                    if (tVar.tnR != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(tVar.tnS) || bo.isNullOrNil(tVar.tnS)) {
                            arrayList.add(obj);
                        } else {
                        }
                    }
                }
                arrayList.add(obj);
            }
        }
        String str2;
        if (arrayList.size() == 0) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.o(47117);
            return str2;
        }
        str2 = dV(arrayList);
        AppMethodBeat.o(47117);
        return str2;
    }

    public final List<t> cRl() {
        int i;
        AppMethodBeat.i(47118);
        ArrayList nf = r.cPI().nf(true);
        HashMap hashMap = new HashMap();
        for (i = 0; i < nf.size(); i++) {
            hashMap.put(((Bankcard) nf.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = this.tDO.tmV;
        if (linkedList2 != null) {
            for (i = 0; i < linkedList2.size(); i++) {
                t tVar = (t) linkedList2.get(i);
                if (tVar != null) {
                    boolean z;
                    if (tVar.tnR != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(tVar.tnS) || bo.isNullOrNil(tVar.tnS)) {
                            linkedList.add(tVar);
                        } else {
                        }
                    }
                }
                linkedList.add(tVar);
            }
        }
        AppMethodBeat.o(47118);
        return linkedList;
    }
}
