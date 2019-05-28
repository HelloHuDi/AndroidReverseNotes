package com.tencent.p177mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C36391e.C16099b;
import com.tencent.p177mm.wallet_core.p650ui.C36391e.C30882c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.ak */
public final class C22587ak {
    public int mRetryCount = 0;
    private ArrayList<Bankcard> tCR = new ArrayList();
    private ArrayList<Bankcard> tCS = new ArrayList();
    public C22586aj tCT = null;
    public Bankcard tCU = null;
    public C29629ai tCV = null;
    public C40114n tCW = null;
    public C22590b tCX = null;
    private List<C22591c> tCY = new LinkedList();
    public Bankcard tCZ = null;
    public long tDa = C5046bo.anT();
    long tDb = 0;
    public long tDc = -1;
    private String tDd = "";
    public int tDe = Downloads.MIN_WAIT_FOR_NETWORK;
    public String tDf = "";
    public String tDg = "";
    int tgW = 0;
    int tgX = 0;
    public Bankcard thy = null;
    private ArrayList<Bankcard> tlM = new ArrayList();
    private ArrayList<Bankcard> tlN = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.ak$1 */
    class C225881 implements C16099b {
        C225881() {
        }

        /* renamed from: bZ */
        public final void mo28534bZ(Object obj) {
            AppMethodBeat.m2504i(46963);
            if (obj == null || !(obj instanceof Double)) {
                C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
                if (C22587ak.this.thy != null) {
                    C22587ak.this.thy.twS = -1.0d;
                }
            } else {
                if (((Double) obj).doubleValue() < 0.0d) {
                    C4990ab.m7419v("MicroMsg.WalletUserInfoManger", "val is zero %s", C5046bo.dpG().toString());
                }
                if (C22587ak.this.thy != null) {
                    C22587ak.this.thy.twS = ((Double) obj).doubleValue();
                    AppMethodBeat.m2505o(46963);
                    return;
                }
            }
            AppMethodBeat.m2505o(46963);
        }
    }

    public C22587ak() {
        AppMethodBeat.m2504i(46964);
        cQv();
        AppMethodBeat.m2505o(46964);
    }

    public final boolean cQl() {
        AppMethodBeat.m2504i(46965);
        if (this.tCT == null || (this.tCT != null && this.tCT.cQj())) {
            AppMethodBeat.m2505o(46965);
            return true;
        }
        AppMethodBeat.m2505o(46965);
        return false;
    }

    public final boolean cQg() {
        AppMethodBeat.m2504i(46966);
        if (this.tCT == null || !this.tCT.cQg()) {
            AppMethodBeat.m2505o(46966);
            return false;
        }
        AppMethodBeat.m2505o(46966);
        return true;
    }

    public final boolean cQi() {
        AppMethodBeat.m2504i(46967);
        if (this.tCT == null || !this.tCT.cQi()) {
            AppMethodBeat.m2505o(46967);
            return false;
        }
        AppMethodBeat.m2505o(46967);
        return true;
    }

    public final boolean cQh() {
        AppMethodBeat.m2504i(46968);
        if (this.tCT == null || !this.tCT.cQh()) {
            AppMethodBeat.m2505o(46968);
            return false;
        }
        AppMethodBeat.m2505o(46968);
        return true;
    }

    public final boolean cQk() {
        AppMethodBeat.m2504i(46969);
        if (this.tCT == null || !this.tCT.cQk()) {
            AppMethodBeat.m2505o(46969);
            return false;
        }
        AppMethodBeat.m2505o(46969);
        return true;
    }

    public final int cQm() {
        return this.tCT != null ? this.tCT.field_soter_pay_open_type : 0;
    }

    /* renamed from: h */
    public final Bankcard mo38170h(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(46970);
        Bankcard bankcard;
        if (z && this.thy != null && this.thy.field_bindSerial.equals(str)) {
            bankcard = this.thy;
            AppMethodBeat.m2505o(46970);
            return bankcard;
        } else if (z2 && this.tCZ != null && this.tCZ.field_bindSerial.equals(str)) {
            bankcard = this.tCZ;
            AppMethodBeat.m2505o(46970);
            return bankcard;
        } else {
            if (!(this.tlM == null || this.tlM.isEmpty())) {
                Iterator it = this.tlM.iterator();
                while (it.hasNext()) {
                    bankcard = (Bankcard) it.next();
                    if (bankcard.field_bindSerial.equals(str)) {
                        AppMethodBeat.m2505o(46970);
                        return bankcard;
                    }
                }
            }
            AppMethodBeat.m2505o(46970);
            return null;
        }
    }

    public final String cQn() {
        if (this.tCT != null) {
            return this.tCT.field_ftf_pay_url;
        }
        return null;
    }

    public final C29629ai cQo() {
        AppMethodBeat.m2504i(46971);
        C29629ai c29629ai;
        if (this.tCV == null) {
            c29629ai = new C29629ai();
            AppMethodBeat.m2505o(46971);
            return c29629ai;
        }
        c29629ai = this.tCV;
        AppMethodBeat.m2505o(46971);
        return c29629ai;
    }

    public final boolean cQp() {
        return this.tCT != null && this.tCT.field_isDomesticUser;
    }

    public final String bhp() {
        if (this.tCT != null) {
            return this.tCT.field_true_name;
        }
        return null;
    }

    public final int cQq() {
        if (this.tCT != null) {
            return this.tCT.field_cre_type;
        }
        return 1;
    }

    public final String cQr() {
        if (this.tCT != null) {
            return this.tCT.field_cre_name;
        }
        return "";
    }

    public final String cQs() {
        AppMethodBeat.m2504i(46972);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, null);
        if (!C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(46972);
            return str;
        } else if (this.tCT != null) {
            str = this.tCT.field_lct_wording;
            AppMethodBeat.m2505o(46972);
            return str;
        } else {
            AppMethodBeat.m2505o(46972);
            return null;
        }
    }

    public final String cQt() {
        if (this.tCT != null) {
            return this.tCT.field_lct_url;
        }
        return null;
    }

    public final String cQu() {
        if (this.tCT != null) {
            return this.tCT.field_forget_passwd_url;
        }
        return "";
    }

    public final void cQv() {
        AppMethodBeat.m2504i(46973);
        if (C1720g.m3534RN().mo5161QY()) {
            this.tCT = C14241r.cPE().cRh();
            if (this.tCT != null) {
                this.tCV = new C29629ai(this.tCT.field_switchConfig, this.tCT.field_wallet_entrance_balance_switch_state);
            } else {
                this.tCV = new C29629ai();
            }
            if (!C5046bo.isNullOrNil(this.tCT.field_bank_priority)) {
                try {
                    this.tCY = C43804af.m78523aE(new JSONObject(this.tCT.field_bank_priority));
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletUserInfoManger", e, "", new Object[0]);
                }
            }
            this.thy = C14241r.cPG().cRc();
            this.tCZ = C14241r.cPG().cRd();
            C36391e.m59986a("wallet_balance", new C225881());
            this.tlM = C14241r.cPG().cQB();
            this.tlN = C14241r.cPG().cRe();
            this.tCU = C14241r.cPG().cRf();
            this.tCW = C14241r.cPK().cQZ();
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "loadDbData!");
            cQQ();
            AppMethodBeat.m2505o(46973);
            return;
        }
        C4990ab.m7420w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
        AppMethodBeat.m2505o(46973);
    }

    public final boolean cQw() {
        AppMethodBeat.m2504i(46974);
        if (C1947ae.gjv) {
            AppMethodBeat.m2505o(46974);
            return true;
        }
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(-1))).intValue();
        if (intValue != -1) {
            if (intValue == 1) {
                AppMethodBeat.m2505o(46974);
                return true;
            }
            AppMethodBeat.m2505o(46974);
            return false;
        } else if (this.tCT == null) {
            AppMethodBeat.m2505o(46974);
            return false;
        } else if (this.tCT.field_lqt_state == 1) {
            AppMethodBeat.m2505o(46974);
            return true;
        } else {
            AppMethodBeat.m2505o(46974);
            return false;
        }
    }

    public final int cQx() {
        if (this.tCT != null) {
            return this.tCT.field_is_show_lqb;
        }
        return 0;
    }

    public final boolean cQy() {
        if (this.tCT == null) {
            return false;
        }
        if (this.tCT.field_is_open_lqb == 1) {
            return true;
        }
        return false;
    }

    public final String cQz() {
        if (this.tCT != null) {
            return this.tCT.field_lqb_open_url;
        }
        return null;
    }

    public final boolean cQA() {
        if (this.tCT == null) {
            return false;
        }
        if (this.tCT.field_paymenu_use_new == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: Km */
    public final void mo38129Km() {
        AppMethodBeat.m2504i(46975);
        if (this.tCT != null) {
            this.tCT.field_is_reg = -1;
            this.tCT = null;
        }
        if (this.tCV != null) {
            this.tCV = null;
        }
        if (this.thy != null) {
            this.thy = null;
        }
        if (this.tlM != null) {
            this.tlM.clear();
            this.tlM = null;
        }
        if (this.tlN != null) {
            this.tlN.clear();
            this.tlN = null;
        }
        this.tDb = 0;
        C36391e.m59987a(new C30882c("wallet_balance_version", Integer.valueOf(-1)), new C30882c("wallet_balance_last_update_time", Integer.valueOf(-1)), new C30882c("wallet_balance", Integer.valueOf(-1)));
        this.tDa = C5046bo.anT();
        AppMethodBeat.m2505o(46975);
    }

    public final ArrayList<Bankcard> cQB() {
        AppMethodBeat.m2504i(46976);
        if (this.tlM == null || this.tlM.size() <= 0) {
            this.tlM = C14241r.cPG().cQB();
        }
        if (this.tlM == null || this.tlM.size() <= 0) {
            AppMethodBeat.m2505o(46976);
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.tlM.iterator();
        while (it.hasNext()) {
            arrayList.add((Bankcard) it.next());
        }
        AppMethodBeat.m2505o(46976);
        return arrayList;
    }

    public final List<C22591c> cQC() {
        AppMethodBeat.m2504i(46977);
        if (this.tCY == null || this.tCY.size() <= 0) {
            AppMethodBeat.m2505o(46977);
            return null;
        }
        List<C22591c> list = this.tCY;
        AppMethodBeat.m2505o(46977);
        return list;
    }

    public final ArrayList<Bankcard> cQD() {
        AppMethodBeat.m2504i(46978);
        if (this.tlM == null || this.tlM.size() <= 0) {
            AppMethodBeat.m2505o(46978);
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.tlM.iterator();
        while (it.hasNext()) {
            Bankcard bankcard = (Bankcard) it.next();
            if (!(bankcard.cPe() || bankcard.cPg())) {
                arrayList.add(bankcard);
            }
        }
        AppMethodBeat.m2505o(46978);
        return arrayList;
    }

    /* renamed from: nf */
    public final ArrayList<Bankcard> mo38171nf(boolean z) {
        AppMethodBeat.m2504i(46979);
        ArrayList arrayList = new ArrayList();
        if (z) {
            if (!(this.thy == null || cQi())) {
                arrayList.add(this.thy);
            }
            if (!(this.tCZ == null || cQi())) {
                arrayList.add(this.tCZ);
            }
        }
        if (this.tlM != null && this.tlM.size() > 0) {
            Iterator it = this.tlM.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        AppMethodBeat.m2505o(46979);
        return arrayList;
    }

    @Deprecated
    /* renamed from: ng */
    public final ArrayList<Bankcard> mo38172ng(boolean z) {
        AppMethodBeat.m2504i(138994);
        ArrayList nf = mo38171nf(z);
        AppMethodBeat.m2505o(138994);
        return nf;
    }

    public final ArrayList<Bankcard> cQE() {
        AppMethodBeat.m2504i(46981);
        ArrayList arrayList = new ArrayList();
        if (!(this.thy == null || cQi())) {
            arrayList.add(this.thy);
        }
        if (!(this.tCZ == null || cQi())) {
            arrayList.add(this.tCZ);
        }
        Iterator it;
        if (this.tCR != null && this.tlM != null && this.tCR.size() == this.tlM.size() && this.tCR.size() > 0) {
            it = this.tCR.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        } else if (this.tlM != null && this.tlM.size() > 0) {
            it = this.tlM.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        AppMethodBeat.m2505o(46981);
        return arrayList;
    }

    public final ArrayList<Bankcard> cQF() {
        AppMethodBeat.m2504i(46982);
        ArrayList arrayList = new ArrayList();
        if (!(this.thy == null || cQi())) {
            arrayList.add(this.thy);
        }
        if (!(this.tCS == null || this.tlM == null || this.tCS.size() <= 0)) {
            Iterator it = this.tCS.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (!bankcard.cPg()) {
                    arrayList.add(bankcard);
                }
            }
        }
        AppMethodBeat.m2505o(46982);
        return arrayList;
    }

    /* renamed from: f */
    public final void mo38169f(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        AppMethodBeat.m2504i(46983);
        if (this.tlM == null || arrayList == null || arrayList2 == null) {
            C4990ab.m7412e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
            AppMethodBeat.m2505o(46983);
            return;
        }
        Iterator it;
        arrayList.clear();
        arrayList2.clear();
        if (this.tlM != null) {
            it = this.tlM.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        if (this.tlN != null) {
            it = this.tlN.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bankcard.field_wxcreditState == 0) {
                    arrayList2.add(bankcard);
                } else {
                    arrayList.add(bankcard);
                }
            }
        }
        AppMethodBeat.m2505o(46983);
    }

    public final boolean cQG() {
        AppMethodBeat.m2504i(46984);
        if (cQH()) {
            AppMethodBeat.m2505o(46984);
            return false;
        } else if (this.tlM == null || this.tlM.size() <= 0) {
            AppMethodBeat.m2505o(46984);
            return true;
        } else {
            AppMethodBeat.m2505o(46984);
            return false;
        }
    }

    private boolean cQH() {
        AppMethodBeat.m2504i(46985);
        if ((this.tCV == null || !this.tCV.cPW()) && (this.tlN == null || this.tlN.size() <= 0)) {
            AppMethodBeat.m2505o(46985);
            return false;
        }
        AppMethodBeat.m2505o(46985);
        return true;
    }

    public final boolean cQI() {
        AppMethodBeat.m2504i(46986);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        mo38169f(arrayList, arrayList2);
        if (C22587ak.m34280dR(arrayList2)) {
            AppMethodBeat.m2505o(46986);
            return true;
        }
        AppMethodBeat.m2505o(46986);
        return false;
    }

    /* renamed from: dR */
    private static boolean m34280dR(List<Bankcard> list) {
        AppMethodBeat.m2504i(46987);
        if (list.size() == 0) {
            AppMethodBeat.m2505o(46987);
            return false;
        }
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(46987);
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            AppMethodBeat.m2505o(46987);
            return true;
        }
        int i = 0;
        for (CharSequence charSequence : split) {
            if (!TextUtils.isEmpty(charSequence)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Bankcard bankcard = (Bankcard) list.get(i2);
                    if (bankcard != null && charSequence.equals(bankcard.field_bankcardType)) {
                        i++;
                        break;
                    }
                }
            }
        }
        if (i < list.size()) {
            AppMethodBeat.m2505o(46987);
            return true;
        }
        AppMethodBeat.m2505o(46987);
        return false;
    }

    public final boolean acC(String str) {
        AppMethodBeat.m2504i(46988);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(46988);
            return false;
        }
        Iterator it;
        Bankcard bankcard;
        if (this.tlM != null) {
            it = this.tlM.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.cPb()) {
                    AppMethodBeat.m2505o(46988);
                    return false;
                }
            }
        }
        if (this.tlN != null) {
            it = this.tlN.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.field_bankcardState == 0) {
                    AppMethodBeat.m2505o(46988);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(46988);
        return true;
    }

    /* renamed from: a */
    public final void mo38133a(C22586aj c22586aj, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, C40114n c40114n, C22590b c22590b, Bankcard bankcard3, int i, int i2, List<C22591c> list) {
        AppMethodBeat.m2504i(46989);
        C4990ab.m7417i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", Integer.valueOf(i2));
        if (i2 == 8) {
            this.tCR = arrayList;
        }
        if (i2 == 24 || i2 == 25) {
            this.tCS = arrayList;
        }
        this.tCY = list;
        this.tlM = arrayList;
        this.tlN = arrayList2;
        this.thy = bankcard;
        this.tCV = new C29629ai(c22586aj.field_switchConfig, c22586aj.field_wallet_entrance_balance_switch_state);
        this.tCU = bankcard2;
        this.tCW = c40114n;
        this.tCX = c22590b;
        this.tCZ = bankcard3;
        C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + c22586aj.field_switchConfig);
        cQQ();
        if (i < 0) {
            i = 600;
        }
        this.tDa = C5046bo.anT() + ((long) i);
        this.tDb = C5046bo.anT() + 600;
        C4990ab.m7417i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", Integer.valueOf(i), Long.valueOf(this.tDa), Long.valueOf(this.tDb));
        C14241r.cPG().apM();
        if (!(i2 == 24 || i2 == 25 || arrayList == null)) {
            C14241r.cPG().mo63409dU(arrayList);
        }
        if (arrayList2 != null) {
            C14241r.cPG().mo63409dU(arrayList2);
        }
        if (bankcard != null) {
            C14241r.cPG().mo63410f(bankcard);
        }
        if (bankcard2 != null) {
            C14241r.cPG().mo63410f(bankcard2);
        }
        if (bankcard3 != null) {
            C14241r.cPG().mo63410f(bankcard3);
        }
        mo38132a(c22586aj);
        C14241r.cPK().apM();
        if (c40114n != null) {
            C14241r.cPK().mo10101b((C4925c) c40114n);
        }
        AppMethodBeat.m2505o(46989);
    }

    /* renamed from: a */
    public final void mo38132a(C22586aj c22586aj) {
        AppMethodBeat.m2504i(46990);
        this.tCT = c22586aj;
        C14241r.cPE().apM();
        C14241r.cPE().mo38098b(c22586aj);
        AppMethodBeat.m2505o(46990);
    }

    public final int cQJ() {
        return this.tDe > 0 ? this.tDe : Downloads.MIN_WAIT_FOR_NETWORK;
    }

    private static String cQK() {
        AppMethodBeat.m2504i(46991);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(196612, null);
        AppMethodBeat.m2505o(46991);
        return str;
    }

    public static void acD(String str) {
        AppMethodBeat.m2504i(46992);
        if (!C5046bo.isNullOrNil(str)) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(196612, (Object) str);
        }
        AppMethodBeat.m2505o(46992);
    }

    @Deprecated
    /* renamed from: a */
    public final Bankcard mo38130a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(46993);
        Bankcard a = mo38131a(arrayList, str, z, z2, false);
        AppMethodBeat.m2505o(46993);
        return a;
    }

    /* renamed from: a */
    public final Bankcard mo38131a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(46994);
        Bankcard b = m34279b(arrayList, str, z, z2, z3);
        AppMethodBeat.m2505o(46994);
        return b;
    }

    @Deprecated
    /* renamed from: b */
    private Bankcard m34279b(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList2;
        Bankcard bankcard;
        AppMethodBeat.m2504i(46995);
        if (arrayList2 == null) {
            arrayList2 = this.tlM;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = C22587ak.cQK();
        }
        if (z && this.thy != null) {
            if (cQh()) {
                bankcard = this.thy;
                AppMethodBeat.m2505o(46995);
                return bankcard;
            } else if (str != null && str.equals(this.thy.field_bindSerial)) {
                bankcard = this.thy;
                AppMethodBeat.m2505o(46995);
                return bankcard;
            } else if (this.tCZ != null && this.tCT != null && this.tCT.field_lqt_state == 1 && str != null && str.equals(this.tCZ.field_bindSerial)) {
                bankcard = this.tCZ;
                AppMethodBeat.m2505o(46995);
                return bankcard;
            } else if (!cQi() && (arrayList2 == null || arrayList2.size() == 0)) {
                bankcard = this.thy;
                AppMethodBeat.m2505o(46995);
                return bankcard;
            }
        }
        if (arrayList2 == null || arrayList2.size() <= 0) {
            C4990ab.m7412e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            AppMethodBeat.m2505o(46995);
            return null;
        } else if (arrayList2.size() == 1 && z2) {
            C4990ab.m7412e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
            bankcard = (Bankcard) arrayList2.get(0);
            AppMethodBeat.m2505o(46995);
            return bankcard;
        } else {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!C5046bo.isNullOrNil(str)) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    bankcard = (Bankcard) it.next();
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        if (z3 && bankcard.cPg()) {
                            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
                            if (!z || this.thy == null) {
                                Iterator it2 = arrayList2.iterator();
                                while (it2.hasNext()) {
                                    bankcard = (Bankcard) it2.next();
                                    if (!bankcard.cPg()) {
                                        AppMethodBeat.m2505o(46995);
                                        return bankcard;
                                    }
                                }
                                continue;
                            } else {
                                bankcard = this.thy;
                                AppMethodBeat.m2505o(46995);
                                return bankcard;
                            }
                        }
                        AppMethodBeat.m2505o(46995);
                        return bankcard;
                    }
                }
            }
            if (z2) {
                bankcard = (Bankcard) arrayList2.get(0);
                AppMethodBeat.m2505o(46995);
                return bankcard;
            }
            AppMethodBeat.m2505o(46995);
            return null;
        }
    }

    public final String cQL() {
        AppMethodBeat.m2504i(46996);
        if (this.tlM == null || this.tlM.size() <= 0) {
            C4990ab.m7412e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            AppMethodBeat.m2505o(46996);
            return null;
        }
        Iterator it = this.tlM.iterator();
        if (it.hasNext()) {
            String str = ((Bankcard) it.next()).field_bindSerial;
            AppMethodBeat.m2505o(46996);
            return str;
        }
        AppMethodBeat.m2505o(46996);
        return null;
    }

    private static void acE(String str) {
        AppMethodBeat.m2504i(46997);
        if (str != null) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(196633, (Object) str);
        }
        AppMethodBeat.m2505o(46997);
    }

    public final boolean cQM() {
        AppMethodBeat.m2504i(46998);
        long fp = C5046bo.m7549fp(this.tDc);
        C4990ab.m7410d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(fp)));
        if (fp > 300) {
            AppMethodBeat.m2505o(46998);
            return true;
        }
        AppMethodBeat.m2505o(46998);
        return false;
    }

    public final int cQN() {
        if (this.tCT != null) {
            return this.tCT.field_lqt_cell_is_show;
        }
        return 0;
    }

    public final String cQO() {
        if (this.tCT != null) {
            return this.tCT.field_lqt_cell_lqt_title;
        }
        return null;
    }

    public final String cQP() {
        if (this.tCT != null) {
            return this.tCT.field_lqt_cell_lqt_wording;
        }
        return null;
    }

    private void cQQ() {
        AppMethodBeat.m2504i(46999);
        C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.tCT == null) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.tlM == null) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.tlM.size() == 0) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.tlM.size());
        }
        if (this.tlN == null) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.tlN.size() == 0) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.tlN.size());
        }
        if (this.thy == null) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.tCU == null) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.tCW == null) {
            C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
            AppMethodBeat.m2505o(46999);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        AppMethodBeat.m2505o(46999);
    }

    public static void acF(String str) {
        AppMethodBeat.m2504i(47000);
        C4990ab.m7417i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", str, C5046bo.dpG().toString());
        C22587ak.acE(str);
        AppMethodBeat.m2505o(47000);
    }

    public static Bankcard cQR() {
        AppMethodBeat.m2504i(47001);
        Bankcard a = C14241r.cPI().mo38130a(null, null, true, true);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
        }
        AppMethodBeat.m2505o(47001);
        return a;
    }
}
