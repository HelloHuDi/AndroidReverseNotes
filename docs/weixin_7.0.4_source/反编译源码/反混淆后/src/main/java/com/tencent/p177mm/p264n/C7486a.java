package com.tencent.p177mm.p264n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.n.a */
public class C7486a extends C6562ap {
    public static C4924a ccO;
    private static C1888a ewR = null;
    public long ewQ;
    public int versionCode;

    /* renamed from: com.tencent.mm.n.a$a */
    public interface C1888a {
        /* renamed from: do */
        String mo5471do(String str);

        /* renamed from: dp */
        String mo5472dp(String str);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C7486a(String str) {
        this();
        AppMethodBeat.m2504i(59620);
        if (str == null) {
            str = "";
        }
        setUsername(str);
        AppMethodBeat.m2505o(59620);
    }

    public C7486a() {
        AppMethodBeat.m2504i(59621);
        this.versionCode = 0;
        super.setUsername("");
        super.mo14703iB("");
        super.mo14704iC("");
        super.mo14705iD("");
        super.mo14728iy("");
        super.mo14729iz("");
        super.mo14708iG("");
        super.mo14707iF("");
        super.mo14702iA("");
        super.mo14697hv(0);
        super.mo14706iE("");
        super.mo14696hu(0);
        super.setType(0);
        super.mo14698hw(0);
        super.mo14699hx(0);
        super.mo14710iI("");
        super.mo14685hA(0);
        super.mo14721iT("");
        super.mo14691hG(0);
        super.mo14686hB(0);
        super.mo14714iM("");
        super.mo14715iN("");
        super.mo14687hC(0);
        super.mo14688hD(0);
        super.mo14716iO("");
        super.mo14717iP("");
        super.mo14689hE(1);
        super.mo14701hz(0);
        super.mo14690hF(0);
        super.mo14718iQ("");
        super.mo14719iR("");
        super.mo14720iS("");
        super.setSource(0);
        super.mo14723iV("");
        super.mo14722iU("");
        super.mo14680eC(0);
        super.mo14713iL("");
        super.mo14724iW("");
        super.mo14692hH(0);
        super.mo14727iZ("");
        super.mo14730ja("");
        super.mo14731jb("");
        super.mo14734je("");
        super.mo14711iJ("");
        super.mo14712iK("");
        this.versionCode = 0;
        AppMethodBeat.m2505o(59621);
    }

    /* renamed from: a */
    public static void m12941a(C1888a c1888a) {
        ewR = c1888a;
    }

    /* renamed from: kN */
    public static String m12943kN(String str) {
        AppMethodBeat.m2504i(59622);
        if (ewR != null) {
            String str2 = ewR.mo5471do(str);
            AppMethodBeat.m2505o(59622);
            return str2;
        }
        AppMethodBeat.m2505o(59622);
        return null;
    }

    /* renamed from: Ny */
    public final int mo16696Ny() {
        AppMethodBeat.m2504i(59623);
        int i = 32;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            i = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            i = this.field_conRemarkPYFull.charAt(0);
        } else if (super.mo14676Ht() != null && !super.mo14676Ht().equals("")) {
            i = super.mo14676Ht().charAt(0);
        } else if (super.mo14677Hu() != null && !super.mo14677Hu().equals("")) {
            i = super.mo14677Hu().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && C7486a.isLetter(this.field_nickname.charAt(0))) {
            i = this.field_nickname.charAt(0);
        } else if (!(this.field_username == null || this.field_username.equals("") || !C7486a.isLetter(this.field_username.charAt(0)))) {
            i = this.field_username.charAt(0);
        }
        if (i >= 97 && i <= 122) {
            i = (char) (i - 32);
        } else if (i < 65 || i > 90) {
            i = 123;
        }
        AppMethodBeat.m2505o(59623);
        return i;
    }

    /* renamed from: Nz */
    public final void mo16697Nz() {
        AppMethodBeat.m2504i(59624);
        setType(0);
        AppMethodBeat.m2505o(59624);
    }

    /* renamed from: NC */
    public final void mo16677NC() {
        AppMethodBeat.m2504i(59627);
        C4990ab.m7421w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), C5046bo.dpG());
        setType(this.field_type & -2);
        AppMethodBeat.m2505o(59627);
    }

    /* renamed from: NS */
    public static int m12935NS() {
        return 1;
    }

    /* renamed from: NT */
    public static int m12936NT() {
        return 8;
    }

    /* renamed from: NU */
    public static int m12937NU() {
        return SQLiteGlobal.journalSizeLimit;
    }

    /* renamed from: NV */
    public static int m12938NV() {
        return 16;
    }

    /* renamed from: NW */
    public static int m12939NW() {
        return 32;
    }

    /* renamed from: jh */
    public static boolean m12942jh(int i) {
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: Ob */
    public final boolean mo16699Ob() {
        return (SQLiteGlobal.journalSizeLimit & this.field_type) != 0;
    }

    /* renamed from: Of */
    public final boolean mo16703Of() {
        return (32768 & this.field_type) != 0;
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /* renamed from: Oh */
    public final int mo16705Oh() {
        return (int) this.ewQ;
    }

    /* renamed from: Ht */
    public final String mo14676Ht() {
        AppMethodBeat.m2504i(59645);
        String Hu;
        if (super.mo14676Ht() == null || super.mo14676Ht().length() < 0) {
            Hu = mo14677Hu();
            AppMethodBeat.m2505o(59645);
            return Hu;
        }
        Hu = super.mo14676Ht();
        AppMethodBeat.m2505o(59645);
        return Hu;
    }

    /* renamed from: Hu */
    public final String mo14677Hu() {
        AppMethodBeat.m2504i(59646);
        String str;
        if (super.mo14677Hu() == null || super.mo14677Hu().length() < 0) {
            str = this.field_nickname;
            AppMethodBeat.m2505o(59646);
            return str;
        }
        str = super.mo14677Hu();
        AppMethodBeat.m2505o(59646);
        return str;
    }

    /* renamed from: Hq */
    public final String mo14673Hq() {
        AppMethodBeat.m2504i(59647);
        String dp = ewR != null ? ewR.mo5472dp(this.field_username) : null;
        if (dp == null) {
            dp = super.mo14673Hq();
            AppMethodBeat.m2505o(59647);
            return dp;
        }
        AppMethodBeat.m2505o(59647);
        return dp;
    }

    /* renamed from: Oi */
    public final String mo16706Oi() {
        AppMethodBeat.m2504i(59648);
        String str = ewR != null ? ewR.mo5471do(this.field_username) : null;
        if (str != null) {
            AppMethodBeat.m2505o(59648);
            return str;
        } else if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            str = mo16708Ok();
            AppMethodBeat.m2505o(59648);
            return str;
        } else {
            str = this.field_nickname;
            AppMethodBeat.m2505o(59648);
            return str;
        }
    }

    /* renamed from: Ok */
    public final String mo16708Ok() {
        AppMethodBeat.m2504i(59650);
        String Hq = mo14673Hq();
        if (C5046bo.isNullOrNil(Hq)) {
            Hq = C7486a.m12944kO(this.field_username);
            if (Hq == null || Hq.length() == 0) {
                Hq = this.field_username;
                AppMethodBeat.m2505o(59650);
                return Hq;
            }
            AppMethodBeat.m2505o(59650);
            return Hq;
        }
        AppMethodBeat.m2505o(59650);
        return Hq;
    }

    public final int getSource() {
        AppMethodBeat.m2504i(59651);
        int source = super.getSource() % 1000000;
        AppMethodBeat.m2505o(59651);
        return source;
    }

    /* renamed from: Ol */
    public final int mo16709Ol() {
        AppMethodBeat.m2504i(59652);
        int source = super.getSource();
        AppMethodBeat.m2505o(59652);
        return source;
    }

    /* renamed from: kO */
    private static String m12944kO(String str) {
        AppMethodBeat.m2504i(59653);
        if (str == null) {
            AppMethodBeat.m2505o(59653);
            return null;
        } else if (str.toLowerCase().endsWith("@t.qq.com")) {
            str = "@" + str.replace("@t.qq.com", "");
            AppMethodBeat.m2505o(59653);
            return str;
        } else if (str.toLowerCase().endsWith("@qqim")) {
            str = str.replace("@qqim", "");
            long longValue = Long.valueOf(str).longValue();
            if (longValue < 0) {
                str = new C1183p(longValue).toString();
                AppMethodBeat.m2505o(59653);
                return str;
            }
            AppMethodBeat.m2505o(59653);
            return str;
        } else {
            AppMethodBeat.m2505o(59653);
            return str;
        }
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(59655);
        super.mo8995d(cursor);
        this.ewQ = this.xDa;
        super.mo14672H(null);
        AppMethodBeat.m2505o(59655);
    }

    /* renamed from: Om */
    private int m12940Om() {
        int i = this.versionCode + 1;
        this.versionCode = i;
        return i;
    }

    /* renamed from: iy */
    public final void mo14728iy(String str) {
        AppMethodBeat.m2504i(59657);
        if (!C5046bo.isEqual(mo14673Hq(), str)) {
            super.mo14728iy(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59657);
    }

    /* renamed from: iC */
    public final void mo14704iC(String str) {
        AppMethodBeat.m2504i(59661);
        if (!C5046bo.isEqual(mo14676Ht(), str)) {
            super.mo14704iC(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59661);
    }

    /* renamed from: iD */
    public final void mo14705iD(String str) {
        AppMethodBeat.m2504i(59662);
        if (!C5046bo.isEqual(mo14677Hu(), str)) {
            super.mo14705iD(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59662);
    }

    /* renamed from: iR */
    public void mo14719iR(String str) {
        AppMethodBeat.m2504i(59689);
        if (!C5046bo.isEqual(getProvince(), str)) {
            super.mo14719iR(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59689);
    }

    /* renamed from: iS */
    public void mo14720iS(String str) {
        AppMethodBeat.m2504i(59690);
        if (!C5046bo.isEqual(getCity(), str)) {
            super.mo14720iS(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59690);
    }

    /* renamed from: NA */
    public final void mo16675NA() {
        AppMethodBeat.m2504i(59625);
        setType(this.field_type | 4);
        AppMethodBeat.m2505o(59625);
    }

    /* renamed from: NB */
    public final void mo16676NB() {
        AppMethodBeat.m2504i(59626);
        setType(this.field_type | 1);
        AppMethodBeat.m2505o(59626);
    }

    /* renamed from: ND */
    public final void mo16678ND() {
        AppMethodBeat.m2504i(59628);
        setType(this.field_type | 8);
        AppMethodBeat.m2505o(59628);
    }

    /* renamed from: NE */
    public final void mo16679NE() {
        AppMethodBeat.m2504i(59629);
        setType(this.field_type & -9);
        AppMethodBeat.m2505o(59629);
    }

    /* renamed from: NF */
    public final void mo16680NF() {
        AppMethodBeat.m2504i(59630);
        setType(this.field_type | SQLiteGlobal.journalSizeLimit);
        AppMethodBeat.m2505o(59630);
    }

    /* renamed from: NG */
    public final void mo16681NG() {
        AppMethodBeat.m2504i(59631);
        setType(this.field_type & -524289);
        AppMethodBeat.m2505o(59631);
    }

    /* renamed from: NH */
    public final void mo16682NH() {
        AppMethodBeat.m2504i(59632);
        setType(this.field_type | 2);
        AppMethodBeat.m2505o(59632);
    }

    /* renamed from: NI */
    public final void mo16683NI() {
        AppMethodBeat.m2504i(59633);
        setType(this.field_type & -3);
        AppMethodBeat.m2505o(59633);
    }

    /* renamed from: NJ */
    public final void mo16684NJ() {
        AppMethodBeat.m2504i(59634);
        setType(this.field_type & -2049);
        AppMethodBeat.m2505o(59634);
    }

    /* renamed from: NK */
    public final void mo16685NK() {
        AppMethodBeat.m2504i(59635);
        setType(this.field_type | 32);
        AppMethodBeat.m2505o(59635);
    }

    /* renamed from: NL */
    public final void mo16686NL() {
        AppMethodBeat.m2504i(59636);
        setType(this.field_type & -33);
        AppMethodBeat.m2505o(59636);
    }

    /* renamed from: NM */
    public final void mo16687NM() {
        AppMethodBeat.m2504i(59637);
        setType(this.field_type | 64);
        AppMethodBeat.m2505o(59637);
    }

    /* renamed from: NN */
    public final void mo16688NN() {
        AppMethodBeat.m2504i(59638);
        setType(this.field_type & -65);
        AppMethodBeat.m2505o(59638);
    }

    /* renamed from: NO */
    public final void mo16689NO() {
        AppMethodBeat.m2504i(59639);
        setType(this.field_type | 512);
        AppMethodBeat.m2505o(59639);
    }

    /* renamed from: NP */
    public final void mo16690NP() {
        AppMethodBeat.m2504i(59640);
        setType(this.field_type & -513);
        AppMethodBeat.m2505o(59640);
    }

    /* renamed from: NQ */
    public final void mo16691NQ() {
        AppMethodBeat.m2504i(59641);
        setType(this.field_type | 256);
        AppMethodBeat.m2505o(59641);
    }

    /* renamed from: NR */
    public final void mo16692NR() {
        AppMethodBeat.m2504i(59642);
        setType(this.field_type & -257);
        AppMethodBeat.m2505o(59642);
    }

    /* renamed from: NX */
    public final boolean mo16693NX() {
        AppMethodBeat.m2504i(139033);
        boolean jh = C7486a.m12942jh(this.field_type);
        AppMethodBeat.m2505o(139033);
        return jh;
    }

    /* renamed from: NY */
    public final boolean mo16694NY() {
        if ((this.field_type & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    /* renamed from: NZ */
    public final boolean mo16695NZ() {
        return (this.field_type & 4) != 0;
    }

    /* renamed from: Oa */
    public final boolean mo16698Oa() {
        return (this.field_type & 8) != 0;
    }

    /* renamed from: Oc */
    public final boolean mo16700Oc() {
        return (this.field_type & 64) != 0;
    }

    /* renamed from: DX */
    public final boolean mo16673DX() {
        return (this.field_type & 512) != 0;
    }

    /* renamed from: Kc */
    public final boolean mo16674Kc() {
        return (this.field_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    /* renamed from: Od */
    public final boolean mo16701Od() {
        return (this.field_type & 256) != 0;
    }

    /* renamed from: Oe */
    public final boolean mo16702Oe() {
        return (this.field_type & 2048) != 0;
    }

    /* renamed from: Og */
    public final void mo16704Og() {
        AppMethodBeat.m2504i(59644);
        setType(this.field_type | 32768);
        AppMethodBeat.m2505o(59644);
    }

    /* renamed from: Oj */
    public final String mo16707Oj() {
        AppMethodBeat.m2504i(59649);
        String Oi;
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            Oi = mo16706Oi();
            AppMethodBeat.m2505o(59649);
            return Oi;
        }
        Oi = this.field_conRemark;
        AppMethodBeat.m2505o(59649);
        return Oi;
    }

    /* renamed from: ji */
    public final void mo16711ji(int i) {
        AppMethodBeat.m2504i(59654);
        mo14699hx((this.field_chatroomFlag & -2) | (i & 1));
        AppMethodBeat.m2505o(59654);
    }

    public final void setUsername(String str) {
        AppMethodBeat.m2504i(59656);
        if (!C5046bo.isEqual(this.field_username, str)) {
            super.setUsername(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59656);
    }

    /* renamed from: iz */
    public final void mo14729iz(String str) {
        AppMethodBeat.m2504i(59658);
        if (!C5046bo.isEqual(this.field_conRemark, str)) {
            super.mo14729iz(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59658);
    }

    /* renamed from: iA */
    public final void mo14702iA(String str) {
        AppMethodBeat.m2504i(59659);
        if (!C5046bo.isEqual(this.field_domainList, str)) {
            super.mo14702iA(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59659);
    }

    /* renamed from: iB */
    public final void mo14703iB(String str) {
        AppMethodBeat.m2504i(59660);
        if (!C5046bo.isEqual(this.field_nickname, str)) {
            super.mo14703iB(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59660);
    }

    /* renamed from: hu */
    public final void mo14696hu(int i) {
        AppMethodBeat.m2504i(59663);
        if (!C5046bo.m7563gW(this.field_showHead, i)) {
            super.mo14696hu(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59663);
    }

    public final void setType(int i) {
        AppMethodBeat.m2504i(59664);
        if (!C5046bo.m7563gW(this.field_type, i)) {
            super.setType(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59664);
    }

    /* renamed from: hv */
    public final void mo14697hv(int i) {
        AppMethodBeat.m2504i(59665);
        if (!C5046bo.m7563gW(this.field_weiboFlag, i)) {
            super.mo14697hv(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59665);
    }

    /* renamed from: iE */
    public final void mo14706iE(String str) {
        AppMethodBeat.m2504i(59666);
        if (!C5046bo.isEqual(this.field_weiboNickname, str)) {
            super.mo14706iE(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59666);
    }

    /* renamed from: iF */
    public final void mo14707iF(String str) {
        AppMethodBeat.m2504i(59667);
        if (!C5046bo.isEqual(this.field_conRemarkPYFull, str)) {
            super.mo14707iF(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59667);
    }

    /* renamed from: iG */
    public final void mo14708iG(String str) {
        AppMethodBeat.m2504i(59668);
        if (!C5046bo.isEqual(this.field_conRemarkPYShort, str)) {
            super.mo14708iG(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59668);
    }

    /* renamed from: H */
    public final void mo14672H(byte[] bArr) {
        AppMethodBeat.m2504i(59669);
        if (!C5046bo.isEqual(this.field_lvbuff, bArr)) {
            super.mo14672H(bArr);
            m12940Om();
        }
        AppMethodBeat.m2505o(59669);
    }

    /* renamed from: hw */
    public final void mo14698hw(int i) {
        AppMethodBeat.m2504i(59670);
        if (!C5046bo.m7563gW(this.field_verifyFlag, i)) {
            super.mo14698hw(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59670);
    }

    /* renamed from: iH */
    public final void mo14709iH(String str) {
        AppMethodBeat.m2504i(59671);
        if (!C5046bo.isEqual(this.field_encryptUsername, str)) {
            super.mo14709iH(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59671);
    }

    /* renamed from: hx */
    public final void mo14699hx(int i) {
        AppMethodBeat.m2504i(59672);
        if (!C5046bo.m7563gW(this.field_chatroomFlag, i)) {
            super.mo14699hx(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59672);
    }

    /* renamed from: hy */
    public final void mo14700hy(int i) {
        AppMethodBeat.m2504i(59673);
        if (!C5046bo.m7563gW(this.field_deleteFlag, i)) {
            super.mo14700hy(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59673);
    }

    /* renamed from: iI */
    public final void mo14710iI(String str) {
        AppMethodBeat.m2504i(59674);
        if (!C5046bo.isEqual(this.field_contactLabelIds, str)) {
            super.mo14710iI(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59674);
    }

    /* renamed from: hz */
    public final void mo14701hz(int i) {
        AppMethodBeat.m2504i(59675);
        if (!C5046bo.m7563gW(this.dtR, i)) {
            super.mo14701hz(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59675);
    }

    /* renamed from: hA */
    public final void mo14685hA(int i) {
        AppMethodBeat.m2504i(59676);
        if (!C5046bo.m7563gW(this.dtS, i)) {
            super.mo14685hA(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59676);
    }

    /* renamed from: iL */
    public final void mo14713iL(String str) {
        AppMethodBeat.m2504i(59677);
        if (!C5046bo.isEqual(this.dtT, str)) {
            super.mo14713iL(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59677);
    }

    /* renamed from: eC */
    public final void mo14680eC(long j) {
        AppMethodBeat.m2504i(59678);
        if (!C5046bo.m7521af(this.dtU, j)) {
            super.mo14680eC(j);
            m12940Om();
        }
        AppMethodBeat.m2505o(59678);
    }

    /* renamed from: hB */
    public final void mo14686hB(int i) {
        AppMethodBeat.m2504i(59679);
        if (!C5046bo.m7563gW(this.uin, i)) {
            super.mo14686hB(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59679);
    }

    /* renamed from: iM */
    public final void mo14714iM(String str) {
        AppMethodBeat.m2504i(59680);
        if (!C5046bo.isEqual(this.dtV, str)) {
            super.mo14714iM(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59680);
    }

    /* renamed from: iN */
    public final void mo14715iN(String str) {
        AppMethodBeat.m2504i(59681);
        if (!C5046bo.isEqual(this.cFl, str)) {
            super.mo14715iN(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59681);
    }

    /* renamed from: hC */
    public final void mo14687hC(int i) {
        AppMethodBeat.m2504i(59682);
        if (!C5046bo.m7563gW(this.dtW, i)) {
            super.mo14687hC(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59682);
    }

    /* renamed from: hD */
    public final void mo14688hD(int i) {
        AppMethodBeat.m2504i(59683);
        if (!C5046bo.m7563gW(this.dtX, i)) {
            super.mo14688hD(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59683);
    }

    /* renamed from: iO */
    public final void mo14716iO(String str) {
        AppMethodBeat.m2504i(59684);
        if (!C5046bo.isEqual(this.dtY, str)) {
            super.mo14716iO(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59684);
    }

    /* renamed from: iP */
    public final void mo14717iP(String str) {
        AppMethodBeat.m2504i(59685);
        if (!C5046bo.isEqual(this.dtZ, str)) {
            super.mo14717iP(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59685);
    }

    /* renamed from: hE */
    public final void mo14689hE(int i) {
        AppMethodBeat.m2504i(59686);
        if (!C5046bo.m7563gW(this.dua, i)) {
            super.mo14689hE(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59686);
    }

    /* renamed from: hF */
    public final void mo14690hF(int i) {
        AppMethodBeat.m2504i(59687);
        if (!C5046bo.m7563gW(this.dub, i)) {
            super.mo14690hF(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59687);
    }

    /* renamed from: iQ */
    public final void mo14718iQ(String str) {
        AppMethodBeat.m2504i(59688);
        if (!C5046bo.isEqual(this.signature, str)) {
            super.mo14718iQ(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59688);
    }

    /* renamed from: iT */
    public final void mo14721iT(String str) {
        AppMethodBeat.m2504i(59691);
        if (!C5046bo.isEqual(this.due, str)) {
            super.mo14721iT(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59691);
    }

    /* renamed from: hG */
    public final void mo14691hG(int i) {
        AppMethodBeat.m2504i(59692);
        if (!C5046bo.m7563gW(this.duf, i)) {
            super.mo14691hG(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59692);
    }

    public final void setSource(int i) {
        AppMethodBeat.m2504i(59693);
        if (!C5046bo.m7563gW(super.getSource(), i)) {
            super.setSource(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59693);
    }

    /* renamed from: iU */
    public final void mo14722iU(String str) {
        AppMethodBeat.m2504i(59694);
        if (!C5046bo.isEqual(this.dug, str)) {
            super.mo14722iU(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59694);
    }

    /* renamed from: iV */
    public final void mo14723iV(String str) {
        AppMethodBeat.m2504i(59695);
        if (!C5046bo.isEqual(this.duh, str)) {
            super.mo14723iV(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59695);
    }

    /* renamed from: iW */
    public void mo14724iW(String str) {
        AppMethodBeat.m2504i(59696);
        if (!C5046bo.isEqual(this.dui, str)) {
            super.mo14724iW(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59696);
    }

    /* renamed from: hH */
    public final void mo14692hH(int i) {
        AppMethodBeat.m2504i(59697);
        if (!C5046bo.m7563gW(this.duj, i)) {
            super.mo14692hH(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59697);
    }

    /* renamed from: hI */
    public final void mo14693hI(int i) {
        AppMethodBeat.m2504i(59698);
        if (!C5046bo.m7563gW(this.duk, i)) {
            super.mo14693hI(i);
            m12940Om();
        }
        AppMethodBeat.m2505o(59698);
    }

    /* renamed from: iX */
    public final void mo14725iX(String str) {
        AppMethodBeat.m2504i(59699);
        if (!C5046bo.isEqual(this.dul, str)) {
            super.mo14725iX(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59699);
    }

    /* renamed from: iY */
    public final void mo14726iY(String str) {
        AppMethodBeat.m2504i(59700);
        if (!C5046bo.isEqual(this.dum, str)) {
            super.mo14726iY(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59700);
    }

    /* renamed from: iZ */
    public final void mo14727iZ(String str) {
        AppMethodBeat.m2504i(59701);
        if (!C5046bo.isEqual(this.dun, str)) {
            super.mo14727iZ(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59701);
    }

    /* renamed from: ja */
    public final void mo14730ja(String str) {
        AppMethodBeat.m2504i(59702);
        if (!C5046bo.isEqual(this.duo, str)) {
            super.mo14730ja(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59702);
    }

    /* renamed from: jb */
    public final void mo14731jb(String str) {
        AppMethodBeat.m2504i(59703);
        if (!C5046bo.isEqual(this.dup, str)) {
            super.mo14731jb(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59703);
    }

    /* renamed from: jc */
    public final void mo14732jc(String str) {
        AppMethodBeat.m2504i(59704);
        if (!C5046bo.isEqual(this.duq, str)) {
            super.mo14732jc(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59704);
    }

    /* renamed from: jd */
    public final void mo14733jd(String str) {
        AppMethodBeat.m2504i(59705);
        if (!C5046bo.isEqual(this.dur, str)) {
            super.mo14733jd(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59705);
    }

    /* renamed from: je */
    public final void mo14734je(String str) {
        AppMethodBeat.m2504i(59706);
        if (!C5046bo.isEqual(this.dus, str)) {
            super.mo14734je(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59706);
    }

    /* renamed from: iK */
    public final void mo14712iK(String str) {
        AppMethodBeat.m2504i(59707);
        if (!C5046bo.isEqual(this.field_openImAppid, str)) {
            super.mo14712iK(str);
            m12940Om();
        }
        AppMethodBeat.m2505o(59707);
    }

    static {
        AppMethodBeat.m2504i(59708);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[21];
        c4924a.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "alias";
        c4924a.xDd.put("alias", "TEXT default '' ");
        stringBuilder.append(" alias TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "conRemark";
        c4924a.xDd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "domainList";
        c4924a.xDd.put("domainList", "TEXT default '' ");
        stringBuilder.append(" domainList TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "nickname";
        c4924a.xDd.put("nickname", "TEXT default '' ");
        stringBuilder.append(" nickname TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "pyInitial";
        c4924a.xDd.put("pyInitial", "TEXT default '' ");
        stringBuilder.append(" pyInitial TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "quanPin";
        c4924a.xDd.put("quanPin", "TEXT default '' ");
        stringBuilder.append(" quanPin TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "showHead";
        c4924a.xDd.put("showHead", "INTEGER default '0' ");
        stringBuilder.append(" showHead INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "type";
        c4924a.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "weiboFlag";
        c4924a.xDd.put("weiboFlag", "INTEGER default '0' ");
        stringBuilder.append(" weiboFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "weiboNickname";
        c4924a.xDd.put("weiboNickname", "TEXT default '' ");
        stringBuilder.append(" weiboNickname TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "conRemarkPYFull";
        c4924a.xDd.put("conRemarkPYFull", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYFull TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "conRemarkPYShort";
        c4924a.xDd.put("conRemarkPYShort", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYShort TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "lvbuff";
        c4924a.xDd.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        c4924a.columns[14] = "verifyFlag";
        c4924a.xDd.put("verifyFlag", "INTEGER default '0' ");
        stringBuilder.append(" verifyFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "encryptUsername";
        c4924a.xDd.put("encryptUsername", "TEXT default '' ");
        stringBuilder.append(" encryptUsername TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "chatroomFlag";
        c4924a.xDd.put("chatroomFlag", "INTEGER");
        stringBuilder.append(" chatroomFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[17] = "deleteFlag";
        c4924a.xDd.put("deleteFlag", "INTEGER default '0' ");
        stringBuilder.append(" deleteFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "contactLabelIds";
        c4924a.xDd.put("contactLabelIds", "TEXT default '' ");
        stringBuilder.append(" contactLabelIds TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[19] = "descWordingId";
        c4924a.xDd.put("descWordingId", "TEXT default '' ");
        stringBuilder.append(" descWordingId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[20] = "openImAppid";
        c4924a.xDd.put("openImAppid", "TEXT");
        stringBuilder.append(" openImAppid TEXT");
        c4924a.columns[21] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(59708);
    }
}
