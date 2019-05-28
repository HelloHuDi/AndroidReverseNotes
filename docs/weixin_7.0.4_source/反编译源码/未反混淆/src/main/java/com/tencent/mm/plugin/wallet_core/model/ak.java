package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.b;
import com.tencent.mm.wallet_core.ui.e.c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak {
    public int mRetryCount = 0;
    private ArrayList<Bankcard> tCR = new ArrayList();
    private ArrayList<Bankcard> tCS = new ArrayList();
    public aj tCT = null;
    public Bankcard tCU = null;
    public ai tCV = null;
    public n tCW = null;
    public b tCX = null;
    private List<c> tCY = new LinkedList();
    public Bankcard tCZ = null;
    public long tDa = bo.anT();
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

    public ak() {
        AppMethodBeat.i(46964);
        cQv();
        AppMethodBeat.o(46964);
    }

    public final boolean cQl() {
        AppMethodBeat.i(46965);
        if (this.tCT == null || (this.tCT != null && this.tCT.cQj())) {
            AppMethodBeat.o(46965);
            return true;
        }
        AppMethodBeat.o(46965);
        return false;
    }

    public final boolean cQg() {
        AppMethodBeat.i(46966);
        if (this.tCT == null || !this.tCT.cQg()) {
            AppMethodBeat.o(46966);
            return false;
        }
        AppMethodBeat.o(46966);
        return true;
    }

    public final boolean cQi() {
        AppMethodBeat.i(46967);
        if (this.tCT == null || !this.tCT.cQi()) {
            AppMethodBeat.o(46967);
            return false;
        }
        AppMethodBeat.o(46967);
        return true;
    }

    public final boolean cQh() {
        AppMethodBeat.i(46968);
        if (this.tCT == null || !this.tCT.cQh()) {
            AppMethodBeat.o(46968);
            return false;
        }
        AppMethodBeat.o(46968);
        return true;
    }

    public final boolean cQk() {
        AppMethodBeat.i(46969);
        if (this.tCT == null || !this.tCT.cQk()) {
            AppMethodBeat.o(46969);
            return false;
        }
        AppMethodBeat.o(46969);
        return true;
    }

    public final int cQm() {
        return this.tCT != null ? this.tCT.field_soter_pay_open_type : 0;
    }

    public final Bankcard h(String str, boolean z, boolean z2) {
        AppMethodBeat.i(46970);
        Bankcard bankcard;
        if (z && this.thy != null && this.thy.field_bindSerial.equals(str)) {
            bankcard = this.thy;
            AppMethodBeat.o(46970);
            return bankcard;
        } else if (z2 && this.tCZ != null && this.tCZ.field_bindSerial.equals(str)) {
            bankcard = this.tCZ;
            AppMethodBeat.o(46970);
            return bankcard;
        } else {
            if (!(this.tlM == null || this.tlM.isEmpty())) {
                Iterator it = this.tlM.iterator();
                while (it.hasNext()) {
                    bankcard = (Bankcard) it.next();
                    if (bankcard.field_bindSerial.equals(str)) {
                        AppMethodBeat.o(46970);
                        return bankcard;
                    }
                }
            }
            AppMethodBeat.o(46970);
            return null;
        }
    }

    public final String cQn() {
        if (this.tCT != null) {
            return this.tCT.field_ftf_pay_url;
        }
        return null;
    }

    public final ai cQo() {
        AppMethodBeat.i(46971);
        ai aiVar;
        if (this.tCV == null) {
            aiVar = new ai();
            AppMethodBeat.o(46971);
            return aiVar;
        }
        aiVar = this.tCV;
        AppMethodBeat.o(46971);
        return aiVar;
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
        AppMethodBeat.i(46972);
        g.RQ();
        String str = (String) g.RP().Ry().get(a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, null);
        if (!bo.isNullOrNil(str)) {
            AppMethodBeat.o(46972);
            return str;
        } else if (this.tCT != null) {
            str = this.tCT.field_lct_wording;
            AppMethodBeat.o(46972);
            return str;
        } else {
            AppMethodBeat.o(46972);
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
        AppMethodBeat.i(46973);
        if (g.RN().QY()) {
            this.tCT = r.cPE().cRh();
            if (this.tCT != null) {
                this.tCV = new ai(this.tCT.field_switchConfig, this.tCT.field_wallet_entrance_balance_switch_state);
            } else {
                this.tCV = new ai();
            }
            if (!bo.isNullOrNil(this.tCT.field_bank_priority)) {
                try {
                    this.tCY = af.aE(new JSONObject(this.tCT.field_bank_priority));
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.WalletUserInfoManger", e, "", new Object[0]);
                }
            }
            this.thy = r.cPG().cRc();
            this.tCZ = r.cPG().cRd();
            e.a("wallet_balance", new b() {
                public final void bZ(Object obj) {
                    AppMethodBeat.i(46963);
                    if (obj == null || !(obj instanceof Double)) {
                        ab.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
                        if (ak.this.thy != null) {
                            ak.this.thy.twS = -1.0d;
                        }
                    } else {
                        if (((Double) obj).doubleValue() < 0.0d) {
                            ab.v("MicroMsg.WalletUserInfoManger", "val is zero %s", bo.dpG().toString());
                        }
                        if (ak.this.thy != null) {
                            ak.this.thy.twS = ((Double) obj).doubleValue();
                            AppMethodBeat.o(46963);
                            return;
                        }
                    }
                    AppMethodBeat.o(46963);
                }
            });
            this.tlM = r.cPG().cQB();
            this.tlN = r.cPG().cRe();
            this.tCU = r.cPG().cRf();
            this.tCW = r.cPK().cQZ();
            ab.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
            cQQ();
            AppMethodBeat.o(46973);
            return;
        }
        ab.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
        AppMethodBeat.o(46973);
    }

    public final boolean cQw() {
        AppMethodBeat.i(46974);
        if (ae.gjv) {
            AppMethodBeat.o(46974);
            return true;
        }
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(-1))).intValue();
        if (intValue != -1) {
            if (intValue == 1) {
                AppMethodBeat.o(46974);
                return true;
            }
            AppMethodBeat.o(46974);
            return false;
        } else if (this.tCT == null) {
            AppMethodBeat.o(46974);
            return false;
        } else if (this.tCT.field_lqt_state == 1) {
            AppMethodBeat.o(46974);
            return true;
        } else {
            AppMethodBeat.o(46974);
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

    public final void Km() {
        AppMethodBeat.i(46975);
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
        e.a(new c("wallet_balance_version", Integer.valueOf(-1)), new c("wallet_balance_last_update_time", Integer.valueOf(-1)), new c("wallet_balance", Integer.valueOf(-1)));
        this.tDa = bo.anT();
        AppMethodBeat.o(46975);
    }

    public final ArrayList<Bankcard> cQB() {
        AppMethodBeat.i(46976);
        if (this.tlM == null || this.tlM.size() <= 0) {
            this.tlM = r.cPG().cQB();
        }
        if (this.tlM == null || this.tlM.size() <= 0) {
            AppMethodBeat.o(46976);
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.tlM.iterator();
        while (it.hasNext()) {
            arrayList.add((Bankcard) it.next());
        }
        AppMethodBeat.o(46976);
        return arrayList;
    }

    public final List<c> cQC() {
        AppMethodBeat.i(46977);
        if (this.tCY == null || this.tCY.size() <= 0) {
            AppMethodBeat.o(46977);
            return null;
        }
        List<c> list = this.tCY;
        AppMethodBeat.o(46977);
        return list;
    }

    public final ArrayList<Bankcard> cQD() {
        AppMethodBeat.i(46978);
        if (this.tlM == null || this.tlM.size() <= 0) {
            AppMethodBeat.o(46978);
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
        AppMethodBeat.o(46978);
        return arrayList;
    }

    public final ArrayList<Bankcard> nf(boolean z) {
        AppMethodBeat.i(46979);
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
        AppMethodBeat.o(46979);
        return arrayList;
    }

    @Deprecated
    public final ArrayList<Bankcard> ng(boolean z) {
        AppMethodBeat.i(138994);
        ArrayList nf = nf(z);
        AppMethodBeat.o(138994);
        return nf;
    }

    public final ArrayList<Bankcard> cQE() {
        AppMethodBeat.i(46981);
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
        AppMethodBeat.o(46981);
        return arrayList;
    }

    public final ArrayList<Bankcard> cQF() {
        AppMethodBeat.i(46982);
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
        AppMethodBeat.o(46982);
        return arrayList;
    }

    public final void f(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        AppMethodBeat.i(46983);
        if (this.tlM == null || arrayList == null || arrayList2 == null) {
            ab.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
            AppMethodBeat.o(46983);
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
        AppMethodBeat.o(46983);
    }

    public final boolean cQG() {
        AppMethodBeat.i(46984);
        if (cQH()) {
            AppMethodBeat.o(46984);
            return false;
        } else if (this.tlM == null || this.tlM.size() <= 0) {
            AppMethodBeat.o(46984);
            return true;
        } else {
            AppMethodBeat.o(46984);
            return false;
        }
    }

    private boolean cQH() {
        AppMethodBeat.i(46985);
        if ((this.tCV == null || !this.tCV.cPW()) && (this.tlN == null || this.tlN.size() <= 0)) {
            AppMethodBeat.o(46985);
            return false;
        }
        AppMethodBeat.o(46985);
        return true;
    }

    public final boolean cQI() {
        AppMethodBeat.i(46986);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        f(arrayList, arrayList2);
        if (dR(arrayList2)) {
            AppMethodBeat.o(46986);
            return true;
        }
        AppMethodBeat.o(46986);
        return false;
    }

    private static boolean dR(List<Bankcard> list) {
        AppMethodBeat.i(46987);
        if (list.size() == 0) {
            AppMethodBeat.o(46987);
            return false;
        }
        g.RQ();
        String str = (String) g.RP().Ry().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(46987);
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(46987);
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
            AppMethodBeat.o(46987);
            return true;
        }
        AppMethodBeat.o(46987);
        return false;
    }

    public final boolean acC(String str) {
        AppMethodBeat.i(46988);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(46988);
            return false;
        }
        Iterator it;
        Bankcard bankcard;
        if (this.tlM != null) {
            it = this.tlM.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.cPb()) {
                    AppMethodBeat.o(46988);
                    return false;
                }
            }
        }
        if (this.tlN != null) {
            it = this.tlN.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.field_bankcardState == 0) {
                    AppMethodBeat.o(46988);
                    return false;
                }
            }
        }
        AppMethodBeat.o(46988);
        return true;
    }

    public final void a(aj ajVar, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, n nVar, b bVar, Bankcard bankcard3, int i, int i2, List<c> list) {
        AppMethodBeat.i(46989);
        ab.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", Integer.valueOf(i2));
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
        this.tCV = new ai(ajVar.field_switchConfig, ajVar.field_wallet_entrance_balance_switch_state);
        this.tCU = bankcard2;
        this.tCW = nVar;
        this.tCX = bVar;
        this.tCZ = bankcard3;
        ab.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + ajVar.field_switchConfig);
        cQQ();
        if (i < 0) {
            i = 600;
        }
        this.tDa = bo.anT() + ((long) i);
        this.tDb = bo.anT() + 600;
        ab.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", Integer.valueOf(i), Long.valueOf(this.tDa), Long.valueOf(this.tDb));
        r.cPG().apM();
        if (!(i2 == 24 || i2 == 25 || arrayList == null)) {
            r.cPG().dU(arrayList);
        }
        if (arrayList2 != null) {
            r.cPG().dU(arrayList2);
        }
        if (bankcard != null) {
            r.cPG().f(bankcard);
        }
        if (bankcard2 != null) {
            r.cPG().f(bankcard2);
        }
        if (bankcard3 != null) {
            r.cPG().f(bankcard3);
        }
        a(ajVar);
        r.cPK().apM();
        if (nVar != null) {
            r.cPK().b((com.tencent.mm.sdk.e.c) nVar);
        }
        AppMethodBeat.o(46989);
    }

    public final void a(aj ajVar) {
        AppMethodBeat.i(46990);
        this.tCT = ajVar;
        r.cPE().apM();
        r.cPE().b(ajVar);
        AppMethodBeat.o(46990);
    }

    public final int cQJ() {
        return this.tDe > 0 ? this.tDe : Downloads.MIN_WAIT_FOR_NETWORK;
    }

    private static String cQK() {
        AppMethodBeat.i(46991);
        g.RQ();
        String str = (String) g.RP().Ry().get(196612, null);
        AppMethodBeat.o(46991);
        return str;
    }

    public static void acD(String str) {
        AppMethodBeat.i(46992);
        if (!bo.isNullOrNil(str)) {
            g.RQ();
            g.RP().Ry().set(196612, (Object) str);
        }
        AppMethodBeat.o(46992);
    }

    @Deprecated
    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        AppMethodBeat.i(46993);
        Bankcard a = a(arrayList, str, z, z2, false);
        AppMethodBeat.o(46993);
        return a;
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(46994);
        Bankcard b = b(arrayList, str, z, z2, z3);
        AppMethodBeat.o(46994);
        return b;
    }

    @Deprecated
    private Bankcard b(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList2;
        Bankcard bankcard;
        AppMethodBeat.i(46995);
        if (arrayList2 == null) {
            arrayList2 = this.tlM;
        }
        if (bo.isNullOrNil(str)) {
            str = cQK();
        }
        if (z && this.thy != null) {
            if (cQh()) {
                bankcard = this.thy;
                AppMethodBeat.o(46995);
                return bankcard;
            } else if (str != null && str.equals(this.thy.field_bindSerial)) {
                bankcard = this.thy;
                AppMethodBeat.o(46995);
                return bankcard;
            } else if (this.tCZ != null && this.tCT != null && this.tCT.field_lqt_state == 1 && str != null && str.equals(this.tCZ.field_bindSerial)) {
                bankcard = this.tCZ;
                AppMethodBeat.o(46995);
                return bankcard;
            } else if (!cQi() && (arrayList2 == null || arrayList2.size() == 0)) {
                bankcard = this.thy;
                AppMethodBeat.o(46995);
                return bankcard;
            }
        }
        if (arrayList2 == null || arrayList2.size() <= 0) {
            ab.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            AppMethodBeat.o(46995);
            return null;
        } else if (arrayList2.size() == 1 && z2) {
            ab.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
            bankcard = (Bankcard) arrayList2.get(0);
            AppMethodBeat.o(46995);
            return bankcard;
        } else {
            ab.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!bo.isNullOrNil(str)) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    bankcard = (Bankcard) it.next();
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        if (z3 && bankcard.cPg()) {
                            ab.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
                            if (!z || this.thy == null) {
                                Iterator it2 = arrayList2.iterator();
                                while (it2.hasNext()) {
                                    bankcard = (Bankcard) it2.next();
                                    if (!bankcard.cPg()) {
                                        AppMethodBeat.o(46995);
                                        return bankcard;
                                    }
                                }
                                continue;
                            } else {
                                bankcard = this.thy;
                                AppMethodBeat.o(46995);
                                return bankcard;
                            }
                        }
                        AppMethodBeat.o(46995);
                        return bankcard;
                    }
                }
            }
            if (z2) {
                bankcard = (Bankcard) arrayList2.get(0);
                AppMethodBeat.o(46995);
                return bankcard;
            }
            AppMethodBeat.o(46995);
            return null;
        }
    }

    public final String cQL() {
        AppMethodBeat.i(46996);
        if (this.tlM == null || this.tlM.size() <= 0) {
            ab.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            AppMethodBeat.o(46996);
            return null;
        }
        Iterator it = this.tlM.iterator();
        if (it.hasNext()) {
            String str = ((Bankcard) it.next()).field_bindSerial;
            AppMethodBeat.o(46996);
            return str;
        }
        AppMethodBeat.o(46996);
        return null;
    }

    private static void acE(String str) {
        AppMethodBeat.i(46997);
        if (str != null) {
            g.RQ();
            g.RP().Ry().set(196633, (Object) str);
        }
        AppMethodBeat.o(46997);
    }

    public final boolean cQM() {
        AppMethodBeat.i(46998);
        long fp = bo.fp(this.tDc);
        ab.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(fp)));
        if (fp > 300) {
            AppMethodBeat.o(46998);
            return true;
        }
        AppMethodBeat.o(46998);
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
        AppMethodBeat.i(46999);
        ab.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.tCT == null) {
            ab.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.tlM == null) {
            ab.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.tlM.size() == 0) {
            ab.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            ab.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.tlM.size());
        }
        if (this.tlN == null) {
            ab.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.tlN.size() == 0) {
            ab.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            ab.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.tlN.size());
        }
        if (this.thy == null) {
            ab.i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            ab.i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.tCU == null) {
            ab.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            ab.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.tCW == null) {
            ab.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
            AppMethodBeat.o(46999);
            return;
        }
        ab.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        AppMethodBeat.o(46999);
    }

    public static void acF(String str) {
        AppMethodBeat.i(47000);
        ab.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", str, bo.dpG().toString());
        acE(str);
        AppMethodBeat.o(47000);
    }

    public static Bankcard cQR() {
        AppMethodBeat.i(47001);
        Bankcard a = r.cPI().a(null, null, true, true);
        if (a == null) {
            ab.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
        }
        AppMethodBeat.o(47001);
        return a;
    }
}
