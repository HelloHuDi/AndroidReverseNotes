package com.tencent.mm.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public class a extends ap {
    public static com.tencent.mm.sdk.e.c.a ccO;
    private static a ewR = null;
    public long ewQ;
    public int versionCode;

    public interface a {
        /* renamed from: do */
        String m4do(String str);

        String dp(String str);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public a(String str) {
        this();
        AppMethodBeat.i(59620);
        if (str == null) {
            str = "";
        }
        setUsername(str);
        AppMethodBeat.o(59620);
    }

    public a() {
        AppMethodBeat.i(59621);
        this.versionCode = 0;
        super.setUsername("");
        super.iB("");
        super.iC("");
        super.iD("");
        super.iy("");
        super.iz("");
        super.iG("");
        super.iF("");
        super.iA("");
        super.hv(0);
        super.iE("");
        super.hu(0);
        super.setType(0);
        super.hw(0);
        super.hx(0);
        super.iI("");
        super.hA(0);
        super.iT("");
        super.hG(0);
        super.hB(0);
        super.iM("");
        super.iN("");
        super.hC(0);
        super.hD(0);
        super.iO("");
        super.iP("");
        super.hE(1);
        super.hz(0);
        super.hF(0);
        super.iQ("");
        super.iR("");
        super.iS("");
        super.setSource(0);
        super.iV("");
        super.iU("");
        super.eC(0);
        super.iL("");
        super.iW("");
        super.hH(0);
        super.iZ("");
        super.ja("");
        super.jb("");
        super.je("");
        super.iJ("");
        super.iK("");
        this.versionCode = 0;
        AppMethodBeat.o(59621);
    }

    public static void a(a aVar) {
        ewR = aVar;
    }

    public static String kN(String str) {
        AppMethodBeat.i(59622);
        if (ewR != null) {
            String str2 = ewR.m4do(str);
            AppMethodBeat.o(59622);
            return str2;
        }
        AppMethodBeat.o(59622);
        return null;
    }

    public final int Ny() {
        AppMethodBeat.i(59623);
        int i = 32;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            i = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            i = this.field_conRemarkPYFull.charAt(0);
        } else if (super.Ht() != null && !super.Ht().equals("")) {
            i = super.Ht().charAt(0);
        } else if (super.Hu() != null && !super.Hu().equals("")) {
            i = super.Hu().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            i = this.field_nickname.charAt(0);
        } else if (!(this.field_username == null || this.field_username.equals("") || !isLetter(this.field_username.charAt(0)))) {
            i = this.field_username.charAt(0);
        }
        if (i >= 97 && i <= 122) {
            i = (char) (i - 32);
        } else if (i < 65 || i > 90) {
            i = 123;
        }
        AppMethodBeat.o(59623);
        return i;
    }

    public final void Nz() {
        AppMethodBeat.i(59624);
        setType(0);
        AppMethodBeat.o(59624);
    }

    public final void NC() {
        AppMethodBeat.i(59627);
        ab.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), bo.dpG());
        setType(this.field_type & -2);
        AppMethodBeat.o(59627);
    }

    public static int NS() {
        return 1;
    }

    public static int NT() {
        return 8;
    }

    public static int NU() {
        return SQLiteGlobal.journalSizeLimit;
    }

    public static int NV() {
        return 16;
    }

    public static int NW() {
        return 32;
    }

    public static boolean jh(int i) {
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Ob() {
        return (SQLiteGlobal.journalSizeLimit & this.field_type) != 0;
    }

    public final boolean Of() {
        return (32768 & this.field_type) != 0;
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public final int Oh() {
        return (int) this.ewQ;
    }

    public final String Ht() {
        AppMethodBeat.i(59645);
        String Hu;
        if (super.Ht() == null || super.Ht().length() < 0) {
            Hu = Hu();
            AppMethodBeat.o(59645);
            return Hu;
        }
        Hu = super.Ht();
        AppMethodBeat.o(59645);
        return Hu;
    }

    public final String Hu() {
        AppMethodBeat.i(59646);
        String str;
        if (super.Hu() == null || super.Hu().length() < 0) {
            str = this.field_nickname;
            AppMethodBeat.o(59646);
            return str;
        }
        str = super.Hu();
        AppMethodBeat.o(59646);
        return str;
    }

    public final String Hq() {
        AppMethodBeat.i(59647);
        String dp = ewR != null ? ewR.dp(this.field_username) : null;
        if (dp == null) {
            dp = super.Hq();
            AppMethodBeat.o(59647);
            return dp;
        }
        AppMethodBeat.o(59647);
        return dp;
    }

    public final String Oi() {
        AppMethodBeat.i(59648);
        String str = ewR != null ? ewR.m4do(this.field_username) : null;
        if (str != null) {
            AppMethodBeat.o(59648);
            return str;
        } else if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            str = Ok();
            AppMethodBeat.o(59648);
            return str;
        } else {
            str = this.field_nickname;
            AppMethodBeat.o(59648);
            return str;
        }
    }

    public final String Ok() {
        AppMethodBeat.i(59650);
        String Hq = Hq();
        if (bo.isNullOrNil(Hq)) {
            Hq = kO(this.field_username);
            if (Hq == null || Hq.length() == 0) {
                Hq = this.field_username;
                AppMethodBeat.o(59650);
                return Hq;
            }
            AppMethodBeat.o(59650);
            return Hq;
        }
        AppMethodBeat.o(59650);
        return Hq;
    }

    public final int getSource() {
        AppMethodBeat.i(59651);
        int source = super.getSource() % 1000000;
        AppMethodBeat.o(59651);
        return source;
    }

    public final int Ol() {
        AppMethodBeat.i(59652);
        int source = super.getSource();
        AppMethodBeat.o(59652);
        return source;
    }

    private static String kO(String str) {
        AppMethodBeat.i(59653);
        if (str == null) {
            AppMethodBeat.o(59653);
            return null;
        } else if (str.toLowerCase().endsWith("@t.qq.com")) {
            str = "@" + str.replace("@t.qq.com", "");
            AppMethodBeat.o(59653);
            return str;
        } else if (str.toLowerCase().endsWith("@qqim")) {
            str = str.replace("@qqim", "");
            long longValue = Long.valueOf(str).longValue();
            if (longValue < 0) {
                str = new p(longValue).toString();
                AppMethodBeat.o(59653);
                return str;
            }
            AppMethodBeat.o(59653);
            return str;
        } else {
            AppMethodBeat.o(59653);
            return str;
        }
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(59655);
        super.d(cursor);
        this.ewQ = this.xDa;
        super.H(null);
        AppMethodBeat.o(59655);
    }

    private int Om() {
        int i = this.versionCode + 1;
        this.versionCode = i;
        return i;
    }

    public final void iy(String str) {
        AppMethodBeat.i(59657);
        if (!bo.isEqual(Hq(), str)) {
            super.iy(str);
            Om();
        }
        AppMethodBeat.o(59657);
    }

    public final void iC(String str) {
        AppMethodBeat.i(59661);
        if (!bo.isEqual(Ht(), str)) {
            super.iC(str);
            Om();
        }
        AppMethodBeat.o(59661);
    }

    public final void iD(String str) {
        AppMethodBeat.i(59662);
        if (!bo.isEqual(Hu(), str)) {
            super.iD(str);
            Om();
        }
        AppMethodBeat.o(59662);
    }

    public void iR(String str) {
        AppMethodBeat.i(59689);
        if (!bo.isEqual(getProvince(), str)) {
            super.iR(str);
            Om();
        }
        AppMethodBeat.o(59689);
    }

    public void iS(String str) {
        AppMethodBeat.i(59690);
        if (!bo.isEqual(getCity(), str)) {
            super.iS(str);
            Om();
        }
        AppMethodBeat.o(59690);
    }

    public final void NA() {
        AppMethodBeat.i(59625);
        setType(this.field_type | 4);
        AppMethodBeat.o(59625);
    }

    public final void NB() {
        AppMethodBeat.i(59626);
        setType(this.field_type | 1);
        AppMethodBeat.o(59626);
    }

    public final void ND() {
        AppMethodBeat.i(59628);
        setType(this.field_type | 8);
        AppMethodBeat.o(59628);
    }

    public final void NE() {
        AppMethodBeat.i(59629);
        setType(this.field_type & -9);
        AppMethodBeat.o(59629);
    }

    public final void NF() {
        AppMethodBeat.i(59630);
        setType(this.field_type | SQLiteGlobal.journalSizeLimit);
        AppMethodBeat.o(59630);
    }

    public final void NG() {
        AppMethodBeat.i(59631);
        setType(this.field_type & -524289);
        AppMethodBeat.o(59631);
    }

    public final void NH() {
        AppMethodBeat.i(59632);
        setType(this.field_type | 2);
        AppMethodBeat.o(59632);
    }

    public final void NI() {
        AppMethodBeat.i(59633);
        setType(this.field_type & -3);
        AppMethodBeat.o(59633);
    }

    public final void NJ() {
        AppMethodBeat.i(59634);
        setType(this.field_type & -2049);
        AppMethodBeat.o(59634);
    }

    public final void NK() {
        AppMethodBeat.i(59635);
        setType(this.field_type | 32);
        AppMethodBeat.o(59635);
    }

    public final void NL() {
        AppMethodBeat.i(59636);
        setType(this.field_type & -33);
        AppMethodBeat.o(59636);
    }

    public final void NM() {
        AppMethodBeat.i(59637);
        setType(this.field_type | 64);
        AppMethodBeat.o(59637);
    }

    public final void NN() {
        AppMethodBeat.i(59638);
        setType(this.field_type & -65);
        AppMethodBeat.o(59638);
    }

    public final void NO() {
        AppMethodBeat.i(59639);
        setType(this.field_type | 512);
        AppMethodBeat.o(59639);
    }

    public final void NP() {
        AppMethodBeat.i(59640);
        setType(this.field_type & -513);
        AppMethodBeat.o(59640);
    }

    public final void NQ() {
        AppMethodBeat.i(59641);
        setType(this.field_type | 256);
        AppMethodBeat.o(59641);
    }

    public final void NR() {
        AppMethodBeat.i(59642);
        setType(this.field_type & -257);
        AppMethodBeat.o(59642);
    }

    public final boolean NX() {
        AppMethodBeat.i(139033);
        boolean jh = jh(this.field_type);
        AppMethodBeat.o(139033);
        return jh;
    }

    public final boolean NY() {
        if ((this.field_type & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public final boolean NZ() {
        return (this.field_type & 4) != 0;
    }

    public final boolean Oa() {
        return (this.field_type & 8) != 0;
    }

    public final boolean Oc() {
        return (this.field_type & 64) != 0;
    }

    public final boolean DX() {
        return (this.field_type & 512) != 0;
    }

    public final boolean Kc() {
        return (this.field_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    public final boolean Od() {
        return (this.field_type & 256) != 0;
    }

    public final boolean Oe() {
        return (this.field_type & 2048) != 0;
    }

    public final void Og() {
        AppMethodBeat.i(59644);
        setType(this.field_type | 32768);
        AppMethodBeat.o(59644);
    }

    public final String Oj() {
        AppMethodBeat.i(59649);
        String Oi;
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            Oi = Oi();
            AppMethodBeat.o(59649);
            return Oi;
        }
        Oi = this.field_conRemark;
        AppMethodBeat.o(59649);
        return Oi;
    }

    public final void ji(int i) {
        AppMethodBeat.i(59654);
        hx((this.field_chatroomFlag & -2) | (i & 1));
        AppMethodBeat.o(59654);
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(59656);
        if (!bo.isEqual(this.field_username, str)) {
            super.setUsername(str);
            Om();
        }
        AppMethodBeat.o(59656);
    }

    public final void iz(String str) {
        AppMethodBeat.i(59658);
        if (!bo.isEqual(this.field_conRemark, str)) {
            super.iz(str);
            Om();
        }
        AppMethodBeat.o(59658);
    }

    public final void iA(String str) {
        AppMethodBeat.i(59659);
        if (!bo.isEqual(this.field_domainList, str)) {
            super.iA(str);
            Om();
        }
        AppMethodBeat.o(59659);
    }

    public final void iB(String str) {
        AppMethodBeat.i(59660);
        if (!bo.isEqual(this.field_nickname, str)) {
            super.iB(str);
            Om();
        }
        AppMethodBeat.o(59660);
    }

    public final void hu(int i) {
        AppMethodBeat.i(59663);
        if (!bo.gW(this.field_showHead, i)) {
            super.hu(i);
            Om();
        }
        AppMethodBeat.o(59663);
    }

    public final void setType(int i) {
        AppMethodBeat.i(59664);
        if (!bo.gW(this.field_type, i)) {
            super.setType(i);
            Om();
        }
        AppMethodBeat.o(59664);
    }

    public final void hv(int i) {
        AppMethodBeat.i(59665);
        if (!bo.gW(this.field_weiboFlag, i)) {
            super.hv(i);
            Om();
        }
        AppMethodBeat.o(59665);
    }

    public final void iE(String str) {
        AppMethodBeat.i(59666);
        if (!bo.isEqual(this.field_weiboNickname, str)) {
            super.iE(str);
            Om();
        }
        AppMethodBeat.o(59666);
    }

    public final void iF(String str) {
        AppMethodBeat.i(59667);
        if (!bo.isEqual(this.field_conRemarkPYFull, str)) {
            super.iF(str);
            Om();
        }
        AppMethodBeat.o(59667);
    }

    public final void iG(String str) {
        AppMethodBeat.i(59668);
        if (!bo.isEqual(this.field_conRemarkPYShort, str)) {
            super.iG(str);
            Om();
        }
        AppMethodBeat.o(59668);
    }

    public final void H(byte[] bArr) {
        AppMethodBeat.i(59669);
        if (!bo.isEqual(this.field_lvbuff, bArr)) {
            super.H(bArr);
            Om();
        }
        AppMethodBeat.o(59669);
    }

    public final void hw(int i) {
        AppMethodBeat.i(59670);
        if (!bo.gW(this.field_verifyFlag, i)) {
            super.hw(i);
            Om();
        }
        AppMethodBeat.o(59670);
    }

    public final void iH(String str) {
        AppMethodBeat.i(59671);
        if (!bo.isEqual(this.field_encryptUsername, str)) {
            super.iH(str);
            Om();
        }
        AppMethodBeat.o(59671);
    }

    public final void hx(int i) {
        AppMethodBeat.i(59672);
        if (!bo.gW(this.field_chatroomFlag, i)) {
            super.hx(i);
            Om();
        }
        AppMethodBeat.o(59672);
    }

    public final void hy(int i) {
        AppMethodBeat.i(59673);
        if (!bo.gW(this.field_deleteFlag, i)) {
            super.hy(i);
            Om();
        }
        AppMethodBeat.o(59673);
    }

    public final void iI(String str) {
        AppMethodBeat.i(59674);
        if (!bo.isEqual(this.field_contactLabelIds, str)) {
            super.iI(str);
            Om();
        }
        AppMethodBeat.o(59674);
    }

    public final void hz(int i) {
        AppMethodBeat.i(59675);
        if (!bo.gW(this.dtR, i)) {
            super.hz(i);
            Om();
        }
        AppMethodBeat.o(59675);
    }

    public final void hA(int i) {
        AppMethodBeat.i(59676);
        if (!bo.gW(this.dtS, i)) {
            super.hA(i);
            Om();
        }
        AppMethodBeat.o(59676);
    }

    public final void iL(String str) {
        AppMethodBeat.i(59677);
        if (!bo.isEqual(this.dtT, str)) {
            super.iL(str);
            Om();
        }
        AppMethodBeat.o(59677);
    }

    public final void eC(long j) {
        AppMethodBeat.i(59678);
        if (!bo.af(this.dtU, j)) {
            super.eC(j);
            Om();
        }
        AppMethodBeat.o(59678);
    }

    public final void hB(int i) {
        AppMethodBeat.i(59679);
        if (!bo.gW(this.uin, i)) {
            super.hB(i);
            Om();
        }
        AppMethodBeat.o(59679);
    }

    public final void iM(String str) {
        AppMethodBeat.i(59680);
        if (!bo.isEqual(this.dtV, str)) {
            super.iM(str);
            Om();
        }
        AppMethodBeat.o(59680);
    }

    public final void iN(String str) {
        AppMethodBeat.i(59681);
        if (!bo.isEqual(this.cFl, str)) {
            super.iN(str);
            Om();
        }
        AppMethodBeat.o(59681);
    }

    public final void hC(int i) {
        AppMethodBeat.i(59682);
        if (!bo.gW(this.dtW, i)) {
            super.hC(i);
            Om();
        }
        AppMethodBeat.o(59682);
    }

    public final void hD(int i) {
        AppMethodBeat.i(59683);
        if (!bo.gW(this.dtX, i)) {
            super.hD(i);
            Om();
        }
        AppMethodBeat.o(59683);
    }

    public final void iO(String str) {
        AppMethodBeat.i(59684);
        if (!bo.isEqual(this.dtY, str)) {
            super.iO(str);
            Om();
        }
        AppMethodBeat.o(59684);
    }

    public final void iP(String str) {
        AppMethodBeat.i(59685);
        if (!bo.isEqual(this.dtZ, str)) {
            super.iP(str);
            Om();
        }
        AppMethodBeat.o(59685);
    }

    public final void hE(int i) {
        AppMethodBeat.i(59686);
        if (!bo.gW(this.dua, i)) {
            super.hE(i);
            Om();
        }
        AppMethodBeat.o(59686);
    }

    public final void hF(int i) {
        AppMethodBeat.i(59687);
        if (!bo.gW(this.dub, i)) {
            super.hF(i);
            Om();
        }
        AppMethodBeat.o(59687);
    }

    public final void iQ(String str) {
        AppMethodBeat.i(59688);
        if (!bo.isEqual(this.signature, str)) {
            super.iQ(str);
            Om();
        }
        AppMethodBeat.o(59688);
    }

    public final void iT(String str) {
        AppMethodBeat.i(59691);
        if (!bo.isEqual(this.due, str)) {
            super.iT(str);
            Om();
        }
        AppMethodBeat.o(59691);
    }

    public final void hG(int i) {
        AppMethodBeat.i(59692);
        if (!bo.gW(this.duf, i)) {
            super.hG(i);
            Om();
        }
        AppMethodBeat.o(59692);
    }

    public final void setSource(int i) {
        AppMethodBeat.i(59693);
        if (!bo.gW(super.getSource(), i)) {
            super.setSource(i);
            Om();
        }
        AppMethodBeat.o(59693);
    }

    public final void iU(String str) {
        AppMethodBeat.i(59694);
        if (!bo.isEqual(this.dug, str)) {
            super.iU(str);
            Om();
        }
        AppMethodBeat.o(59694);
    }

    public final void iV(String str) {
        AppMethodBeat.i(59695);
        if (!bo.isEqual(this.duh, str)) {
            super.iV(str);
            Om();
        }
        AppMethodBeat.o(59695);
    }

    public void iW(String str) {
        AppMethodBeat.i(59696);
        if (!bo.isEqual(this.dui, str)) {
            super.iW(str);
            Om();
        }
        AppMethodBeat.o(59696);
    }

    public final void hH(int i) {
        AppMethodBeat.i(59697);
        if (!bo.gW(this.duj, i)) {
            super.hH(i);
            Om();
        }
        AppMethodBeat.o(59697);
    }

    public final void hI(int i) {
        AppMethodBeat.i(59698);
        if (!bo.gW(this.duk, i)) {
            super.hI(i);
            Om();
        }
        AppMethodBeat.o(59698);
    }

    public final void iX(String str) {
        AppMethodBeat.i(59699);
        if (!bo.isEqual(this.dul, str)) {
            super.iX(str);
            Om();
        }
        AppMethodBeat.o(59699);
    }

    public final void iY(String str) {
        AppMethodBeat.i(59700);
        if (!bo.isEqual(this.dum, str)) {
            super.iY(str);
            Om();
        }
        AppMethodBeat.o(59700);
    }

    public final void iZ(String str) {
        AppMethodBeat.i(59701);
        if (!bo.isEqual(this.dun, str)) {
            super.iZ(str);
            Om();
        }
        AppMethodBeat.o(59701);
    }

    public final void ja(String str) {
        AppMethodBeat.i(59702);
        if (!bo.isEqual(this.duo, str)) {
            super.ja(str);
            Om();
        }
        AppMethodBeat.o(59702);
    }

    public final void jb(String str) {
        AppMethodBeat.i(59703);
        if (!bo.isEqual(this.dup, str)) {
            super.jb(str);
            Om();
        }
        AppMethodBeat.o(59703);
    }

    public final void jc(String str) {
        AppMethodBeat.i(59704);
        if (!bo.isEqual(this.duq, str)) {
            super.jc(str);
            Om();
        }
        AppMethodBeat.o(59704);
    }

    public final void jd(String str) {
        AppMethodBeat.i(59705);
        if (!bo.isEqual(this.dur, str)) {
            super.jd(str);
            Om();
        }
        AppMethodBeat.o(59705);
    }

    public final void je(String str) {
        AppMethodBeat.i(59706);
        if (!bo.isEqual(this.dus, str)) {
            super.je(str);
            Om();
        }
        AppMethodBeat.o(59706);
    }

    public final void iK(String str) {
        AppMethodBeat.i(59707);
        if (!bo.isEqual(this.field_openImAppid, str)) {
            super.iK(str);
            Om();
        }
        AppMethodBeat.o(59707);
    }

    static {
        AppMethodBeat.i(59708);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "alias";
        aVar.xDd.put("alias", "TEXT default '' ");
        stringBuilder.append(" alias TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "conRemark";
        aVar.xDd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "domainList";
        aVar.xDd.put("domainList", "TEXT default '' ");
        stringBuilder.append(" domainList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "nickname";
        aVar.xDd.put("nickname", "TEXT default '' ");
        stringBuilder.append(" nickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "pyInitial";
        aVar.xDd.put("pyInitial", "TEXT default '' ");
        stringBuilder.append(" pyInitial TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "quanPin";
        aVar.xDd.put("quanPin", "TEXT default '' ");
        stringBuilder.append(" quanPin TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "showHead";
        aVar.xDd.put("showHead", "INTEGER default '0' ");
        stringBuilder.append(" showHead INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "type";
        aVar.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "weiboFlag";
        aVar.xDd.put("weiboFlag", "INTEGER default '0' ");
        stringBuilder.append(" weiboFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "weiboNickname";
        aVar.xDd.put("weiboNickname", "TEXT default '' ");
        stringBuilder.append(" weiboNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "conRemarkPYFull";
        aVar.xDd.put("conRemarkPYFull", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYFull TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "conRemarkPYShort";
        aVar.xDd.put("conRemarkPYShort", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYShort TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuff";
        aVar.xDd.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "verifyFlag";
        aVar.xDd.put("verifyFlag", "INTEGER default '0' ");
        stringBuilder.append(" verifyFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "encryptUsername";
        aVar.xDd.put("encryptUsername", "TEXT default '' ");
        stringBuilder.append(" encryptUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomFlag";
        aVar.xDd.put("chatroomFlag", "INTEGER");
        stringBuilder.append(" chatroomFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleteFlag";
        aVar.xDd.put("deleteFlag", "INTEGER default '0' ");
        stringBuilder.append(" deleteFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "contactLabelIds";
        aVar.xDd.put("contactLabelIds", "TEXT default '' ");
        stringBuilder.append(" contactLabelIds TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "descWordingId";
        aVar.xDd.put("descWordingId", "TEXT default '' ");
        stringBuilder.append(" descWordingId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "openImAppid";
        aVar.xDd.put("openImAppid", "TEXT");
        stringBuilder.append(" openImAppid TEXT");
        aVar.columns[21] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(59708);
    }
}
