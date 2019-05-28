package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class a implements g {
    protected MMActivity jiE;
    protected b kaS;
    protected com.tencent.mm.plugin.card.ui.e.a kjF;
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

    public a(MMActivity mMActivity) {
        this.jiE = mMActivity;
    }

    public final void a(b bVar, com.tencent.mm.plugin.card.ui.e.a aVar) {
        AppMethodBeat.i(88693);
        this.kaS = bVar;
        this.kjF = aVar;
        bdD();
        AppMethodBeat.o(88693);
    }

    public final void release() {
        this.kaS = null;
        this.kjF = null;
        this.jiE = null;
    }

    public final String bdx() {
        AppMethodBeat.i(88694);
        String str = "";
        if (!TextUtils.isEmpty(this.kaS.aZV().vUu)) {
            str = this.kaS.aZV().vUu;
        } else if (this.kaS.aZW().vSd == 0) {
            str = getString(R.string.aga);
        } else if (this.kaS.aZW().vSe == 0) {
            if (TextUtils.isEmpty(this.kaS.aZV().vUb)) {
                str = getString(R.string.acj);
            } else {
                str = this.kaS.aZV().vUb;
            }
        }
        AppMethodBeat.o(88694);
        return str;
    }

    private String getString(int i) {
        AppMethodBeat.i(88695);
        String string = this.jiE.getString(i);
        AppMethodBeat.o(88695);
        return string;
    }

    public final boolean bdy() {
        AppMethodBeat.i(88696);
        if (this.kaS.aZW().status == 0 || this.kaS.aZW().status == 1 || this.kaS.aZW().status == 2) {
            AppMethodBeat.o(88696);
            return true;
        }
        AppMethodBeat.o(88696);
        return false;
    }

    public final boolean bdz() {
        AppMethodBeat.i(88697);
        if (this.kjF.emC == 3 || ((this.kjF.emC == 6 && this.kaS.aZW().vSa == 0) || this.kjF.emC == 4 || this.kjF.emC == 5 || this.kjF.emC == 15)) {
            AppMethodBeat.o(88697);
            return true;
        }
        AppMethodBeat.o(88697);
        return false;
    }

    private boolean bdA() {
        AppMethodBeat.i(88698);
        if (TextUtils.isEmpty(this.kaS.aZW().code)) {
            AppMethodBeat.o(88698);
            return false;
        }
        AppMethodBeat.o(88698);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bdB() {
        AppMethodBeat.i(88699);
        if (this.kaS.isAcceptable() || !(l.tm(this.kjF.emC) || l.tn(this.kjF.emC) || this.kjF.emC == 23)) {
            AppMethodBeat.o(88699);
            return false;
        }
        AppMethodBeat.o(88699);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bdC() {
        AppMethodBeat.i(88700);
        if (this.kaS.aZS() || this.kjF.emC != 6) {
            AppMethodBeat.o(88700);
            return false;
        }
        AppMethodBeat.o(88700);
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
        AppMethodBeat.i(88702);
        if ((this.kjF.emC == 6 && (!this.kaS.isNormal() || this.kaS.aZS())) || this.kjF.emC == 5 || (this.kjF.emC == 23 && this.kaS.aZU())) {
            AppMethodBeat.o(88702);
            return true;
        }
        AppMethodBeat.o(88702);
        return false;
    }

    public boolean bdQ() {
        return false;
    }

    public boolean bdR() {
        return true;
    }

    public boolean bdS() {
        AppMethodBeat.i(88703);
        if ((bdA() && bdy() && bdz()) || this.kok) {
            AppMethodBeat.o(88703);
            return true;
        }
        AppMethodBeat.o(88703);
        return false;
    }

    public boolean bdT() {
        return false;
    }

    public boolean bdU() {
        AppMethodBeat.i(88704);
        if (this.kaS.isNormal()) {
            AppMethodBeat.o(88704);
            return false;
        }
        AppMethodBeat.o(88704);
        return true;
    }

    public boolean bdV() {
        AppMethodBeat.i(88705);
        if (this.kaS.aZV().vUo == null || this.kaS.aZV().vUo.wcS == null || this.kaS.aZV().vUo.wcS.size() <= 0 || TextUtils.isEmpty((CharSequence) this.kaS.aZV().vUo.wcS.get(0))) {
            AppMethodBeat.o(88705);
            return false;
        }
        AppMethodBeat.o(88705);
        return true;
    }

    public boolean bdW() {
        AppMethodBeat.i(88706);
        if (this.kaS.aZW().vSc == null || this.kaS.aZW().vSc.size() <= 0 || !((bdy() && bdz()) || this.kok)) {
            AppMethodBeat.o(88706);
            return false;
        }
        AppMethodBeat.o(88706);
        return true;
    }

    public boolean bdX() {
        return false;
    }

    public final boolean bdY() {
        AppMethodBeat.i(88707);
        if (this.kaS.aZW().vSg == null || TextUtils.isEmpty(this.kaS.aZW().vSg.title)) {
            AppMethodBeat.o(88707);
            return false;
        }
        AppMethodBeat.o(88707);
        return true;
    }

    public boolean bdZ() {
        AppMethodBeat.i(88708);
        if (this.kaS.aZW().vSj == null || TextUtils.isEmpty(this.kaS.aZW().vSj.title)) {
            AppMethodBeat.o(88708);
            return false;
        }
        AppMethodBeat.o(88708);
        return true;
    }

    public boolean bea() {
        AppMethodBeat.i(88709);
        if (this.kaS.aZV().vUk != null) {
            AppMethodBeat.o(88709);
            return true;
        }
        AppMethodBeat.o(88709);
        return false;
    }

    public boolean beb() {
        AppMethodBeat.i(88710);
        if (TextUtils.isEmpty(this.kaS.aZV().vUh)) {
            AppMethodBeat.o(88710);
            return false;
        }
        AppMethodBeat.o(88710);
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
        AppMethodBeat.i(88711);
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
        ab.i(str, str2, objArr);
        AppMethodBeat.o(88711);
    }

    /* Access modifiers changed, original: protected */
    public void bdD() {
        AppMethodBeat.i(88701);
        ab.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (l.tm(this.kjF.emC) || l.tn(this.kjF.emC)) {
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
        } else if (l.to(this.kjF.emC)) {
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
            if (!(TextUtils.isEmpty(this.kjF.kiN) || this.kjF.kiN.equals(r.Yz()) || this.kaS.aZU())) {
                ab.i("MicroMsg.CardBaseShowLogic", " detail page");
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
            ab.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            ab.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.kok) {
            this.kol = false;
            this.kom = false;
            ab.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (this.kol) {
            this.kok = false;
            ab.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        } else {
            this.kok = true;
            ab.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        }
        ab.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.kok);
        AppMethodBeat.o(88701);
    }
}
