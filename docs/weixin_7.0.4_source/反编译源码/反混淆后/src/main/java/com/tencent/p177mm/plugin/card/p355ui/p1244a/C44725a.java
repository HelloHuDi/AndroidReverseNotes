package com.tencent.p177mm.plugin.card.p355ui.p1244a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p355ui.C38766e.C20176a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.ui.a.a */
public class C44725a implements C42867g {
    protected MMActivity jiE;
    protected C42837b kaS;
    protected C20176a kjF;
    boolean kok = false;
    private boolean kol = false;
    private boolean kom = false;
    private boolean kon = false;
    private boolean koo = false;
    private boolean kop = false;
    private boolean koq = false;
    private boolean kor = false;
    private boolean kos = false;
    private boolean kot = false;

    public C44725a(MMActivity mMActivity) {
        this.jiE = mMActivity;
    }

    /* renamed from: a */
    public final void mo68381a(C42837b c42837b, C20176a c20176a) {
        AppMethodBeat.m2504i(88693);
        this.kaS = c42837b;
        this.kjF = c20176a;
        bdD();
        AppMethodBeat.m2505o(88693);
    }

    public final void release() {
        this.kaS = null;
        this.kjF = null;
        this.jiE = null;
    }

    public final String bdx() {
        AppMethodBeat.m2504i(88694);
        String str = "";
        if (!TextUtils.isEmpty(this.kaS.aZV().vUu)) {
            str = this.kaS.aZV().vUu;
        } else if (this.kaS.aZW().vSd == 0) {
            str = getString(C25738R.string.aga);
        } else if (this.kaS.aZW().vSe == 0) {
            if (TextUtils.isEmpty(this.kaS.aZV().vUb)) {
                str = getString(C25738R.string.acj);
            } else {
                str = this.kaS.aZV().vUb;
            }
        }
        AppMethodBeat.m2505o(88694);
        return str;
    }

    private String getString(int i) {
        AppMethodBeat.m2504i(88695);
        String string = this.jiE.getString(i);
        AppMethodBeat.m2505o(88695);
        return string;
    }

    public final boolean bdy() {
        AppMethodBeat.m2504i(88696);
        if (this.kaS.aZW().status == 0 || this.kaS.aZW().status == 1 || this.kaS.aZW().status == 2) {
            AppMethodBeat.m2505o(88696);
            return true;
        }
        AppMethodBeat.m2505o(88696);
        return false;
    }

    public final boolean bdz() {
        AppMethodBeat.m2504i(88697);
        if (this.kjF.emC == 3 || ((this.kjF.emC == 6 && this.kaS.aZW().vSa == 0) || this.kjF.emC == 4 || this.kjF.emC == 5 || this.kjF.emC == 15)) {
            AppMethodBeat.m2505o(88697);
            return true;
        }
        AppMethodBeat.m2505o(88697);
        return false;
    }

    private boolean bdA() {
        AppMethodBeat.m2504i(88698);
        if (TextUtils.isEmpty(this.kaS.aZW().code)) {
            AppMethodBeat.m2505o(88698);
            return false;
        }
        AppMethodBeat.m2505o(88698);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bdB() {
        AppMethodBeat.m2504i(88699);
        if (this.kaS.isAcceptable() || !(C38736l.m65734tm(this.kjF.emC) || C38736l.m65735tn(this.kjF.emC) || this.kjF.emC == 23)) {
            AppMethodBeat.m2505o(88699);
            return false;
        }
        AppMethodBeat.m2505o(88699);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bdC() {
        AppMethodBeat.m2504i(88700);
        if (this.kaS.aZS() || this.kjF.emC != 6) {
            AppMethodBeat.m2505o(88700);
            return false;
        }
        AppMethodBeat.m2505o(88700);
        return true;
    }

    public final boolean bcT() {
        return this.kok;
    }

    public boolean bdE() {
        return this.kol;
    }

    public final boolean bdF() {
        return this.kom;
    }

    public final boolean bdG() {
        return this.kon;
    }

    public final boolean bdH() {
        return this.koo;
    }

    public final boolean bdI() {
        return this.kop;
    }

    public final boolean bdJ() {
        return this.kor;
    }

    public final boolean bdK() {
        return this.kos;
    }

    public final boolean bdL() {
        return this.kot;
    }

    public boolean bdM() {
        return true;
    }

    public boolean bdN() {
        return false;
    }

    public boolean bdO() {
        return false;
    }

    public boolean bdP() {
        AppMethodBeat.m2504i(88702);
        if ((this.kjF.emC == 6 && (!this.kaS.isNormal() || this.kaS.aZS())) || this.kjF.emC == 5 || (this.kjF.emC == 23 && this.kaS.aZU())) {
            AppMethodBeat.m2505o(88702);
            return true;
        }
        AppMethodBeat.m2505o(88702);
        return false;
    }

    public boolean bdQ() {
        return false;
    }

    public boolean bdR() {
        return true;
    }

    public boolean bdS() {
        AppMethodBeat.m2504i(88703);
        if ((bdA() && bdy() && bdz()) || this.kok) {
            AppMethodBeat.m2505o(88703);
            return true;
        }
        AppMethodBeat.m2505o(88703);
        return false;
    }

    public boolean bdT() {
        return false;
    }

    public boolean bdU() {
        AppMethodBeat.m2504i(88704);
        if (this.kaS.isNormal()) {
            AppMethodBeat.m2505o(88704);
            return false;
        }
        AppMethodBeat.m2505o(88704);
        return true;
    }

    public boolean bdV() {
        AppMethodBeat.m2504i(88705);
        if (this.kaS.aZV().vUo == null || this.kaS.aZV().vUo.wcS == null || this.kaS.aZV().vUo.wcS.size() <= 0 || TextUtils.isEmpty((CharSequence) this.kaS.aZV().vUo.wcS.get(0))) {
            AppMethodBeat.m2505o(88705);
            return false;
        }
        AppMethodBeat.m2505o(88705);
        return true;
    }

    public boolean bdW() {
        AppMethodBeat.m2504i(88706);
        if (this.kaS.aZW().vSc == null || this.kaS.aZW().vSc.size() <= 0 || !((bdy() && bdz()) || this.kok)) {
            AppMethodBeat.m2505o(88706);
            return false;
        }
        AppMethodBeat.m2505o(88706);
        return true;
    }

    public boolean bdX() {
        return false;
    }

    public final boolean bdY() {
        AppMethodBeat.m2504i(88707);
        if (this.kaS.aZW().vSg == null || TextUtils.isEmpty(this.kaS.aZW().vSg.title)) {
            AppMethodBeat.m2505o(88707);
            return false;
        }
        AppMethodBeat.m2505o(88707);
        return true;
    }

    public boolean bdZ() {
        AppMethodBeat.m2504i(88708);
        if (this.kaS.aZW().vSj == null || TextUtils.isEmpty(this.kaS.aZW().vSj.title)) {
            AppMethodBeat.m2505o(88708);
            return false;
        }
        AppMethodBeat.m2505o(88708);
        return true;
    }

    public boolean bea() {
        AppMethodBeat.m2504i(88709);
        if (this.kaS.aZV().vUk != null) {
            AppMethodBeat.m2505o(88709);
            return true;
        }
        AppMethodBeat.m2505o(88709);
        return false;
    }

    public boolean beb() {
        AppMethodBeat.m2504i(88710);
        if (TextUtils.isEmpty(this.kaS.aZV().vUh)) {
            AppMethodBeat.m2505o(88710);
            return false;
        }
        AppMethodBeat.m2505o(88710);
        return true;
    }

    public boolean bec() {
        return false;
    }

    public boolean bed() {
        return false;
    }

    public final void bee() {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(88711);
        String str = "MicroMsg.CardBaseShowLogic";
        String str2 = "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ";
        Object[] objArr = new Object[12];
        if (bdA()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bdx();
        if (this.kok) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        if (bdE()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[3] = Integer.valueOf(i);
        if (this.kom) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[4] = Integer.valueOf(i);
        if (this.kon) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[5] = Integer.valueOf(i);
        if (this.koo) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[6] = Integer.valueOf(i);
        if (this.kop) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        if (this.koq) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[8] = Integer.valueOf(i);
        if (this.kor) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[9] = Integer.valueOf(i);
        if (this.kos) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[10] = Integer.valueOf(i);
        if (!this.kot) {
            i2 = 0;
        }
        objArr[11] = Integer.valueOf(i2);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(88711);
    }

    /* Access modifiers changed, original: protected */
    public void bdD() {
        AppMethodBeat.m2504i(88701);
        C4990ab.m7416i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (C38736l.m65734tm(this.kjF.emC) || C38736l.m65735tn(this.kjF.emC)) {
            if (this.kaS.isAcceptable()) {
                this.kol = true;
                this.kom = true;
                this.kor = true;
                this.kop = true;
                this.koq = true;
            } else if (this.kaS.isAcceptable()) {
                this.kol = false;
                this.kom = false;
                this.kop = false;
            } else {
                this.kol = true;
                this.kom = false;
                if (this.kaS.aZR()) {
                    this.kos = true;
                    this.kop = true;
                    this.koo = true;
                } else {
                    this.kop = false;
                }
                this.koq = true;
            }
        } else if (this.kjF.emC == 6) {
            if (this.kaS.aZS()) {
                this.kol = true;
                this.kom = true;
                this.kop = false;
            } else if (this.kaS.isNormal()) {
                this.kos = true;
                this.kop = true;
                this.kon = true;
                this.koo = true;
            } else {
                this.kol = false;
                this.kom = false;
                this.kop = false;
                this.kon = true;
            }
        } else if (C38736l.m65736to(this.kjF.emC)) {
            this.kol = false;
            this.kom = false;
            this.kon = true;
            if (this.kaS.isNormal()) {
                this.kos = true;
                this.kop = true;
                this.koo = true;
            } else {
                this.kot = true;
            }
        } else if (this.kjF.emC == 23) {
            if (this.kaS.isAcceptable()) {
                this.kol = true;
                this.kom = true;
                this.kop = false;
                this.koq = true;
            } else {
                this.kol = true;
                this.kom = false;
                this.kop = false;
                this.koq = true;
            }
            if (!(TextUtils.isEmpty(this.kjF.kiN) || this.kjF.kiN.equals(C1853r.m3846Yz()) || this.kaS.aZU())) {
                C4990ab.m7416i("MicroMsg.CardBaseShowLogic", " detail page");
                this.kol = false;
                this.kom = false;
                this.kon = true;
                if (this.kaS.isNormal()) {
                    this.kos = true;
                    this.kop = true;
                    this.koo = true;
                }
            }
        }
        if (this.kaS.aZR()) {
            this.kol = false;
            this.kom = false;
            C4990ab.m7416i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            C4990ab.m7416i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.kok) {
            this.kol = false;
            this.kom = false;
            C4990ab.m7416i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (this.kol) {
            this.kok = false;
            C4990ab.m7416i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        } else {
            this.kok = true;
            C4990ab.m7416i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        }
        C4990ab.m7416i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.kok);
        AppMethodBeat.m2505o(88701);
    }
}
