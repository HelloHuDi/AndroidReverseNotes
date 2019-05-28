package com.tencent.p177mm.plugin.wallet_core.p561ui;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.wallet.p748a.C43758t;
import com.tencent.p177mm.plugin.wallet.p748a.C46330j;
import com.tencent.p177mm.plugin.wallet.p748a.C7174f;
import com.tencent.p177mm.plugin.wallet.p748a.C7176h;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.b */
public final class C22621b {
    public C7176h tDO = null;
    private Map<String, C43758t> tDP = null;
    private Map<String, C46330j> tDQ = null;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.b$a */
    public static final class C22622a {
        public String pcj;
        public C46330j tDR;
        public double tDS;
        public String tDT;

        public final String toString() {
            AppMethodBeat.m2504i(47098);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.tDR != null) {
                stringBuffer.append("|faovrComposeId: " + this.tDR.tnk);
            }
            stringBuffer.append("|bankName: " + this.pcj);
            stringBuffer.append("|bankFavorAmount: " + this.tDS);
            stringBuffer.append("|bankType: " + this.tDT);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.m2505o(47098);
            return stringBuffer2;
        }
    }

    public final boolean cRi() {
        AppMethodBeat.m2504i(47099);
        if (this.tDP == null || this.tDP.size() <= 0) {
            AppMethodBeat.m2505o(47099);
            return false;
        }
        AppMethodBeat.m2505o(47099);
        return true;
    }

    public C22621b(C7176h c7176h) {
        AppMethodBeat.m2504i(47100);
        Assert.assertNotNull(c7176h);
        this.tDO = c7176h;
        m34306Kh();
        AppMethodBeat.m2505o(47100);
    }

    /* renamed from: Kh */
    private void m34306Kh() {
        int i = 0;
        AppMethodBeat.m2504i(47101);
        this.tDP = new HashMap();
        LinkedList linkedList = this.tDO.tmV;
        if (linkedList != null) {
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                C43758t c43758t = (C43758t) linkedList.get(i2);
                this.tDP.put(c43758t.tmO, c43758t);
            }
        } else {
            C4990ab.m7420w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.tDQ = new HashMap();
        if (this.tDO.tmW == null || this.tDO.tmW.tni == null) {
            C4990ab.m7420w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            AppMethodBeat.m2505o(47101);
            return;
        }
        LinkedList linkedList2 = this.tDO.tmW.tni;
        while (i < linkedList2.size()) {
            C46330j c46330j = (C46330j) linkedList2.get(i);
            this.tDQ.put(c46330j.tnk, c46330j);
            i++;
        }
        AppMethodBeat.m2505o(47101);
    }

    public final Map<String, C22622a> acR(String str) {
        AppMethodBeat.m2504i(47102);
        Map bB = mo38204bB(str, false);
        AppMethodBeat.m2505o(47102);
        return bB;
    }

    /* renamed from: bA */
    public final C46330j mo38203bA(String str, boolean z) {
        AppMethodBeat.m2504i(47103);
        C46330j c46330j;
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || !this.tDQ.containsKey(str)) {
            for (String str2 : this.tDQ.keySet()) {
                c46330j = (C46330j) this.tDQ.get(str2);
                if (!(c46330j.tnm == null || c46330j.tnm.size() == 0)) {
                    int i;
                    int size = c46330j.tnm.size();
                    int i2 = 0;
                    Iterator it = c46330j.tnm.iterator();
                    while (true) {
                        i = i2;
                        if (!it.hasNext()) {
                            break;
                        }
                        C7174f c7174f = (C7174f) it.next();
                        if (!this.tDP.containsKey(c7174f.tmO)) {
                            break;
                        }
                        C43758t c43758t = (C43758t) this.tDP.get(c7174f.tmO);
                        if (c43758t.tnS.equals("") && c43758t.tnU.size() == 0 && (!z || c43758t.tnR == 0)) {
                            i++;
                        }
                        i2 = i;
                    }
                    if (i > 0 && i == size) {
                        AppMethodBeat.m2505o(47103);
                        return c46330j;
                    }
                }
            }
            AppMethodBeat.m2505o(47103);
            return null;
        }
        c46330j = (C46330j) this.tDQ.get(str);
        AppMethodBeat.m2505o(47103);
        return c46330j;
    }

    public final Map<String, C22622a> acS(String str) {
        AppMethodBeat.m2504i(47104);
        HashMap hashMap = new HashMap();
        if (this.tDO.tmW != null && this.tDO.tmW.tni != null) {
            double d;
            LinkedList linkedList = this.tDO.tmW.tni;
            if (this.tDQ.containsKey(str)) {
                d = ((C46330j) this.tDQ.get(str)).tnl;
            } else {
                d = 0.0d;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= linkedList.size()) {
                    break;
                }
                C46330j c46330j = (C46330j) linkedList.get(i2);
                String str2 = null;
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !c46330j.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str2 = c46330j.tnk;
                } else if (c46330j.tnk.startsWith(str) && !str.equals(c46330j.tnk)) {
                    str2 = c46330j.tnk.replace(str + "-", "");
                }
                String[] acV = C22621b.acV(str2);
                if (acV != null && acV.length > 0) {
                    C43758t c43758t = (C43758t) this.tDP.get(acV[0]);
                    if (c43758t != null) {
                        Object obj;
                        if (c43758t.tnR != 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null && c43758t.tnU.size() > 0) {
                            Iterator it = c43758t.tnU.iterator();
                            while (it.hasNext()) {
                                String a = C1946aa.m4147a((C1332b) it.next());
                                C22622a c22622a = (C22622a) hashMap.get(a);
                                if (c22622a == null || c46330j.tnl > c22622a.tDR.tnl) {
                                    c22622a = new C22622a();
                                    c22622a.tDR = c46330j;
                                    c22622a.pcj = c43758t.pcj;
                                    c22622a.tDS = c46330j.tnl - d;
                                    c22622a.tDT = c43758t.tnS;
                                    hashMap.put(a, c22622a);
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        } else {
            C4990ab.m7420w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        }
        AppMethodBeat.m2505o(47104);
        return hashMap;
    }

    /* renamed from: bB */
    public final Map<String, C22622a> mo38204bB(String str, boolean z) {
        AppMethodBeat.m2504i(47105);
        HashMap hashMap = new HashMap();
        if (this.tDO.tmW != null && this.tDO.tmW.tni != null) {
            double d;
            LinkedList linkedList = this.tDO.tmW.tni;
            if (this.tDQ.containsKey(str)) {
                d = ((C46330j) this.tDQ.get(str)).tnl;
            } else {
                d = 0.0d;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= linkedList.size()) {
                    break;
                }
                C46330j c46330j = (C46330j) linkedList.get(i2);
                String str2 = null;
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !c46330j.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str2 = c46330j.tnk;
                } else if (c46330j.tnk.startsWith(str) && !str.equals(c46330j.tnk)) {
                    str2 = c46330j.tnk.replace(str + "-", "");
                }
                String[] acV = C22621b.acV(str2);
                if (acV != null && acV.length > 0) {
                    C43758t c43758t = (C43758t) this.tDP.get(acV[0]);
                    if (c43758t != null) {
                        Object obj;
                        if (c43758t.tnR != 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null && !C5046bo.isNullOrNil(c43758t.tnS) && c43758t.tnU.size() <= 0 && (z || !c43758t.tnS.equalsIgnoreCase("CFT"))) {
                            C22622a c22622a = (C22622a) hashMap.get(c43758t.tnS);
                            if (c22622a == null || c46330j.tnl > c22622a.tDR.tnl) {
                                c22622a = new C22622a();
                                c22622a.tDR = c46330j;
                                c22622a.pcj = c43758t.pcj;
                                c22622a.tDS = c46330j.tnl - d;
                                c22622a.tDT = c43758t.tnS;
                                hashMap.put(c43758t.tnS, c22622a);
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        } else {
            C4990ab.m7420w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        }
        AppMethodBeat.m2505o(47105);
        return hashMap;
    }

    public final List<C43758t> acT(String str) {
        AppMethodBeat.m2504i(47106);
        LinkedList linkedList = new LinkedList();
        if (this.tDO.tmV != null) {
            Map acR = acR(str);
            for (int i = 0; i < this.tDO.tmV.size(); i++) {
                C43758t c43758t = (C43758t) this.tDO.tmV.get(i);
                if (c43758t != null) {
                    Object obj;
                    if (c43758t.tnR != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && acR.containsKey(c43758t.tnS)) {
                        linkedList.add(c43758t);
                    }
                }
            }
        } else {
            C4990ab.m7420w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        AppMethodBeat.m2505o(47106);
        return linkedList;
    }

    public final int cRj() {
        AppMethodBeat.m2504i(47107);
        int size = this.tDQ.size();
        AppMethodBeat.m2505o(47107);
        return size;
    }

    public final C46330j cRk() {
        AppMethodBeat.m2504i(47108);
        if (!this.tDQ.isEmpty()) {
            Iterator it = this.tDQ.entrySet().iterator();
            if (it.hasNext()) {
                C46330j c46330j = (C46330j) ((Entry) it.next()).getValue();
                AppMethodBeat.m2505o(47108);
                return c46330j;
            }
        }
        AppMethodBeat.m2505o(47108);
        return null;
    }

    public final C46330j acU(String str) {
        AppMethodBeat.m2504i(47109);
        C46330j c46330j = (C46330j) this.tDQ.get(str);
        AppMethodBeat.m2505o(47109);
        return c46330j;
    }

    public static String[] acV(String str) {
        AppMethodBeat.m2504i(47110);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(47110);
            return null;
        }
        String[] split = str.split("-");
        AppMethodBeat.m2505o(47110);
        return split;
    }

    public final String acW(String str) {
        AppMethodBeat.m2504i(47111);
        String bC = mo38205bC(str, false);
        AppMethodBeat.m2505o(47111);
        return bC;
    }

    /* renamed from: bC */
    public final String mo38205bC(String str, boolean z) {
        AppMethodBeat.m2504i(47112);
        String[] acV = C22621b.acV(str);
        String str2;
        if (acV != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < acV.length; i++) {
                C43758t c43758t = (C43758t) this.tDP.get(acV[i]);
                if (c43758t != null) {
                    Object obj;
                    if (c43758t.tnR != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || (C5046bo.isNullOrNil(c43758t.tnS) && !z)) {
                        stringBuilder.append(acV[i]);
                        stringBuilder.append("-");
                    }
                }
            }
            if (stringBuilder.length() == 0) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                AppMethodBeat.m2505o(47112);
                return str2;
            }
            str2 = stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
            AppMethodBeat.m2505o(47112);
            return str2;
        }
        str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        AppMethodBeat.m2505o(47112);
        return str2;
    }

    public final FavorPayInfo acX(String str) {
        AppMethodBeat.m2504i(47113);
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.tDQ.get(str) == null) {
            favorPayInfo.tzb = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            if (this.tDO != null) {
                favorPayInfo.tze = this.tDO.tmU;
            }
            favorPayInfo.tzc = 0;
            AppMethodBeat.m2505o(47113);
            return favorPayInfo;
        }
        favorPayInfo.tzb = str;
        if (this.tDO != null) {
            favorPayInfo.tze = this.tDO.tmU;
        }
        favorPayInfo.tzc = 0;
        String[] acV = C22621b.acV(str);
        if (acV == null) {
            AppMethodBeat.m2505o(47113);
            return favorPayInfo;
        }
        for (int length = acV.length - 1; length >= 0; length--) {
            C43758t c43758t = (C43758t) this.tDP.get(acV[length]);
            if (c43758t != null) {
                int i;
                if (c43758t.tnR != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    break;
                }
                favorPayInfo.tzc = 1;
                if (c43758t.tnU != null && c43758t.tnU.size() > 0) {
                    favorPayInfo.tzg = new LinkedList();
                    Iterator it = c43758t.tnU.iterator();
                    while (it.hasNext()) {
                        favorPayInfo.tzg.add(C1946aa.m4147a((C1332b) it.next()));
                    }
                }
                if (!C5046bo.isNullOrNil(c43758t.tnS)) {
                    favorPayInfo.tzd = c43758t.tnS;
                    break;
                }
            }
        }
        AppMethodBeat.m2505o(47113);
        return favorPayInfo;
    }

    /* renamed from: a */
    public static boolean m34307a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        AppMethodBeat.m2504i(47114);
        if (bankcard == null) {
            C4990ab.m7420w("MicroMsg.FavorLogicHelper", "curBankcard null");
            AppMethodBeat.m2505o(47114);
            return true;
        }
        boolean z;
        if (!(favorPayInfo == null || C5046bo.isNullOrNil(favorPayInfo.tzb))) {
            if (favorPayInfo.tzc != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !C5046bo.isNullOrNil(favorPayInfo.tzd) && favorPayInfo.tzg != null && favorPayInfo.tzg.contains(bankcard.field_bindSerial)) {
                AppMethodBeat.m2505o(47114);
                return false;
            }
        }
        if (favorPayInfo.tzc != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || ((C5046bo.isNullOrNil(favorPayInfo.tzd) || bankcard.field_bankcardType == null || bankcard.field_bankcardType.equals(favorPayInfo.tzd)) && !(C5046bo.isNullOrNil(favorPayInfo.tzd) && bankcard.field_bankcardType.equals("CFT")))) {
            AppMethodBeat.m2505o(47114);
            return false;
        }
        AppMethodBeat.m2505o(47114);
        return true;
    }

    /* renamed from: bt */
    public static List<Bankcard> m34308bt(int i, String str) {
        boolean z;
        AppMethodBeat.m2504i(47115);
        ArrayList nf = C14241r.cPI().mo38171nf(true);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < nf.size(); i2++) {
                if (C5046bo.isNullOrNil(str)) {
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
            AppMethodBeat.m2505o(47115);
            return arrayList;
        }
        AppMethodBeat.m2505o(47115);
        return nf;
    }

    /* renamed from: dV */
    private static String m34309dV(List<String> list) {
        AppMethodBeat.m2504i(47116);
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
                AppMethodBeat.m2505o(47116);
                return stringBuilder2;
            }
        }
    }

    public final String acY(String str) {
        int i;
        AppMethodBeat.m2504i(47117);
        ArrayList nf = C14241r.cPI().mo38171nf(true);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (i = 0; i < nf.size(); i++) {
            hashMap.put(((Bankcard) nf.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        String[] acV = C22621b.acV(str);
        if (acV != null) {
            for (Object obj : acV) {
                C43758t c43758t = (C43758t) this.tDP.get(obj);
                if (c43758t != null) {
                    boolean z;
                    if (c43758t.tnR != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(c43758t.tnS) || C5046bo.isNullOrNil(c43758t.tnS)) {
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
            AppMethodBeat.m2505o(47117);
            return str2;
        }
        str2 = C22621b.m34309dV(arrayList);
        AppMethodBeat.m2505o(47117);
        return str2;
    }

    public final List<C43758t> cRl() {
        int i;
        AppMethodBeat.m2504i(47118);
        ArrayList nf = C14241r.cPI().mo38171nf(true);
        HashMap hashMap = new HashMap();
        for (i = 0; i < nf.size(); i++) {
            hashMap.put(((Bankcard) nf.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = this.tDO.tmV;
        if (linkedList2 != null) {
            for (i = 0; i < linkedList2.size(); i++) {
                C43758t c43758t = (C43758t) linkedList2.get(i);
                if (c43758t != null) {
                    boolean z;
                    if (c43758t.tnR != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(c43758t.tnS) || C5046bo.isNullOrNil(c43758t.tnS)) {
                            linkedList.add(c43758t);
                        } else {
                        }
                    }
                }
                linkedList.add(c43758t);
            }
        }
        AppMethodBeat.m2505o(47118);
        return linkedList;
    }
}
