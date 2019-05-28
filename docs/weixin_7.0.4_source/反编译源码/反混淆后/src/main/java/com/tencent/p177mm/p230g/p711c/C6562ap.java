package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5069y;

/* renamed from: com.tencent.mm.g.c.ap */
public abstract class C6562ap extends C4925c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)"};
    private static final int diR = "rowid".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dmS = "lvbuff".hashCode();
    private static final int dqk = "nickname".hashCode();
    private static final int dtA = "alias".hashCode();
    private static final int dtB = "conRemark".hashCode();
    private static final int dtC = "domainList".hashCode();
    private static final int dtD = "pyInitial".hashCode();
    private static final int dtE = "quanPin".hashCode();
    private static final int dtF = "showHead".hashCode();
    private static final int dtG = "weiboFlag".hashCode();
    private static final int dtH = "weiboNickname".hashCode();
    private static final int dtI = "conRemarkPYFull".hashCode();
    private static final int dtJ = "conRemarkPYShort".hashCode();
    private static final int dtK = "verifyFlag".hashCode();
    private static final int dtL = "encryptUsername".hashCode();
    private static final int dtM = "chatroomFlag".hashCode();
    private static final int dtN = "deleteFlag".hashCode();
    private static final int dtO = "contactLabelIds".hashCode();
    private static final int dtP = "descWordingId".hashCode();
    private static final int dtQ = "openImAppid".hashCode();
    public String cFl;
    private int cvd;
    private boolean djK = false;
    private boolean dlm = false;
    private boolean dmv = false;
    private boolean dqg = false;
    public int dtR;
    public int dtS;
    public String dtT;
    protected long dtU;
    protected String dtV;
    protected int dtW;
    public int dtX;
    protected String dtY;
    protected String dtZ;
    private boolean dtj = false;
    private boolean dtk = false;
    private boolean dtl = false;
    private boolean dtm = false;
    private boolean dtn = false;
    private boolean dto = false;
    private boolean dtp = false;
    private boolean dtq = false;
    private boolean dtr = false;
    private boolean dts = false;
    private boolean dtt = false;
    private boolean dtu = false;
    private boolean dtv = false;
    private boolean dtw = false;
    private boolean dtx = false;
    private boolean dty = false;
    private boolean dtz = false;
    public int dua;
    public int dub;
    private String duc;
    private String dud;
    public String due;
    protected int duf;
    public String dug;
    public String duh;
    public String dui;
    public int duj;
    public int duk;
    public String dul;
    public String dum;
    public String dun;
    public String duo;
    public String dup;
    public String duq;
    public String dur;
    public String dus;
    private int dut;
    private String duu;
    public int duv;
    public String duw;
    private String field_alias;
    protected int field_chatroomFlag;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_contactLabelIds;
    public int field_deleteFlag;
    public String field_descWordingId;
    public String field_domainList;
    public String field_encryptUsername;
    protected byte[] field_lvbuff;
    public String field_nickname;
    public String field_openImAppid;
    private String field_pyInitial;
    private String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    public String signature;
    public int uin;

    public void setUsername(String str) {
        this.field_username = str;
        this.dlm = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    /* renamed from: iy */
    public void mo14728iy(String str) {
        this.field_alias = str;
        this.dtj = true;
    }

    /* renamed from: Hq */
    public String mo14673Hq() {
        return this.field_alias;
    }

    /* renamed from: iz */
    public void mo14729iz(String str) {
        this.field_conRemark = str;
        this.dtk = true;
    }

    /* renamed from: Hr */
    public final String mo14674Hr() {
        return this.field_conRemark;
    }

    /* renamed from: iA */
    public void mo14702iA(String str) {
        this.field_domainList = str;
        this.dtl = true;
    }

    /* renamed from: iB */
    public void mo14703iB(String str) {
        this.field_nickname = str;
        this.dqg = true;
    }

    /* renamed from: Hs */
    public final String mo14675Hs() {
        return this.field_nickname;
    }

    /* renamed from: iC */
    public void mo14704iC(String str) {
        this.field_pyInitial = str;
        this.dtm = true;
    }

    /* renamed from: Ht */
    public String mo14676Ht() {
        return this.field_pyInitial;
    }

    /* renamed from: iD */
    public void mo14705iD(String str) {
        this.field_quanPin = str;
        this.dtn = true;
    }

    /* renamed from: Hu */
    public String mo14677Hu() {
        return this.field_quanPin;
    }

    /* renamed from: hu */
    public void mo14696hu(int i) {
        this.field_showHead = i;
        this.dto = true;
    }

    public void setType(int i) {
        this.field_type = i;
        this.djK = true;
    }

    /* renamed from: hv */
    public void mo14697hv(int i) {
        this.field_weiboFlag = i;
        this.dtp = true;
    }

    /* renamed from: iE */
    public void mo14706iE(String str) {
        this.field_weiboNickname = str;
        this.dtq = true;
    }

    /* renamed from: iF */
    public void mo14707iF(String str) {
        this.field_conRemarkPYFull = str;
        this.dtr = true;
    }

    /* renamed from: iG */
    public void mo14708iG(String str) {
        this.field_conRemarkPYShort = str;
        this.dts = true;
    }

    /* renamed from: H */
    public void mo14672H(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.dmv = true;
    }

    /* renamed from: hw */
    public void mo14698hw(int i) {
        this.field_verifyFlag = i;
        this.dtt = true;
    }

    /* renamed from: iH */
    public void mo14709iH(String str) {
        this.field_encryptUsername = str;
        this.dtu = true;
    }

    /* renamed from: Hv */
    public final String mo14678Hv() {
        return this.field_encryptUsername;
    }

    /* renamed from: hx */
    public void mo14699hx(int i) {
        this.field_chatroomFlag = i;
        this.dtv = true;
    }

    /* renamed from: hy */
    public void mo14700hy(int i) {
        this.field_deleteFlag = i;
        this.dtw = true;
    }

    /* renamed from: iI */
    public void mo14710iI(String str) {
        this.field_contactLabelIds = str;
        this.dtx = true;
    }

    /* renamed from: iJ */
    public final void mo14711iJ(String str) {
        this.field_descWordingId = str;
        this.dty = true;
    }

    /* renamed from: iK */
    public void mo14712iK(String str) {
        this.field_openImAppid = str;
        this.dtz = true;
    }

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (dtA == hashCode) {
                    this.field_alias = cursor.getString(i);
                } else if (dtB == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (dtC == hashCode) {
                    this.field_domainList = cursor.getString(i);
                } else if (dqk == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (dtD == hashCode) {
                    this.field_pyInitial = cursor.getString(i);
                } else if (dtE == hashCode) {
                    this.field_quanPin = cursor.getString(i);
                } else if (dtF == hashCode) {
                    this.field_showHead = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dtG == hashCode) {
                    this.field_weiboFlag = cursor.getInt(i);
                } else if (dtH == hashCode) {
                    this.field_weiboNickname = cursor.getString(i);
                } else if (dtI == hashCode) {
                    this.field_conRemarkPYFull = cursor.getString(i);
                } else if (dtJ == hashCode) {
                    this.field_conRemarkPYShort = cursor.getString(i);
                } else if (dmS == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (dtK == hashCode) {
                    this.field_verifyFlag = cursor.getInt(i);
                } else if (dtL == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                } else if (dtM == hashCode) {
                    this.field_chatroomFlag = cursor.getInt(i);
                } else if (dtN == hashCode) {
                    this.field_deleteFlag = cursor.getInt(i);
                } else if (dtO == hashCode) {
                    this.field_contactLabelIds = cursor.getString(i);
                } else if (dtP == hashCode) {
                    this.field_descWordingId = cursor.getString(i);
                } else if (dtQ == hashCode) {
                    this.field_openImAppid = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
            mo14679Hw();
        }
    }

    /* renamed from: hz */
    public void mo14701hz(int i) {
        this.dtR = i;
        this.dmv = true;
    }

    /* renamed from: hA */
    public void mo14685hA(int i) {
        this.dtS = i;
        this.dmv = true;
    }

    /* renamed from: iL */
    public void mo14713iL(String str) {
        this.dtT = str;
        this.dmv = true;
    }

    /* renamed from: eC */
    public void mo14680eC(long j) {
        this.dtU = j;
        this.dmv = true;
    }

    /* renamed from: hB */
    public void mo14686hB(int i) {
        this.uin = i;
        this.dmv = true;
    }

    /* renamed from: iM */
    public void mo14714iM(String str) {
        this.dtV = str;
        this.dmv = true;
    }

    /* renamed from: iN */
    public void mo14715iN(String str) {
        this.cFl = str;
        this.dmv = true;
    }

    /* renamed from: hC */
    public void mo14687hC(int i) {
        this.dtW = i;
        this.dmv = true;
    }

    /* renamed from: hD */
    public void mo14688hD(int i) {
        this.dtX = i;
        this.dmv = true;
    }

    /* renamed from: iO */
    public void mo14716iO(String str) {
        this.dtY = str;
        this.dmv = true;
    }

    /* renamed from: iP */
    public void mo14717iP(String str) {
        this.dtZ = str;
        this.dmv = true;
    }

    /* renamed from: hE */
    public void mo14689hE(int i) {
        this.dua = i;
        this.dmv = true;
    }

    /* renamed from: hF */
    public void mo14690hF(int i) {
        this.dub = i;
        this.dmv = true;
    }

    /* renamed from: iQ */
    public void mo14718iQ(String str) {
        this.signature = str;
        this.dmv = true;
    }

    public String getProvince() {
        return this.duc;
    }

    /* renamed from: iR */
    public void mo14719iR(String str) {
        this.duc = str;
        this.dmv = true;
    }

    public String getCity() {
        return this.dud;
    }

    /* renamed from: iS */
    public void mo14720iS(String str) {
        this.dud = str;
        this.dmv = true;
    }

    /* renamed from: iT */
    public void mo14721iT(String str) {
        this.due = str;
        this.dmv = true;
    }

    /* renamed from: hG */
    public void mo14691hG(int i) {
        this.duf = i;
        this.dmv = true;
    }

    public int getSource() {
        return this.cvd;
    }

    public void setSource(int i) {
        this.cvd = i;
        this.dmv = true;
    }

    /* renamed from: iU */
    public void mo14722iU(String str) {
        this.dug = str;
        this.dmv = true;
    }

    /* renamed from: iV */
    public void mo14723iV(String str) {
        this.duh = str;
        this.dmv = true;
    }

    /* renamed from: iW */
    public void mo14724iW(String str) {
        this.dui = str;
        this.dmv = true;
    }

    /* renamed from: hH */
    public void mo14692hH(int i) {
        this.duj = i;
        this.dmv = true;
    }

    /* renamed from: hI */
    public void mo14693hI(int i) {
        this.duk = i;
        this.dmv = true;
    }

    /* renamed from: iX */
    public void mo14725iX(String str) {
        this.dul = str;
        this.dmv = true;
    }

    /* renamed from: iY */
    public void mo14726iY(String str) {
        this.dum = str;
        this.dmv = true;
    }

    /* renamed from: iZ */
    public void mo14727iZ(String str) {
        this.dun = str;
        this.dmv = true;
    }

    /* renamed from: ja */
    public void mo14730ja(String str) {
        this.duo = str;
        this.dmv = true;
    }

    /* renamed from: jb */
    public void mo14731jb(String str) {
        this.dup = str;
        this.dmv = true;
    }

    /* renamed from: jc */
    public void mo14732jc(String str) {
        this.duq = str;
        this.dmv = true;
    }

    /* renamed from: jd */
    public void mo14733jd(String str) {
        this.dur = str;
        this.dmv = true;
    }

    /* renamed from: je */
    public void mo14734je(String str) {
        this.dus = str;
        this.dmv = true;
    }

    /* renamed from: hJ */
    public final void mo14694hJ(int i) {
        this.dut = i;
        this.dmv = true;
    }

    /* renamed from: hK */
    public final void mo14695hK(int i) {
        this.duv = i;
        this.dmv = true;
    }

    /* renamed from: jf */
    public final void mo14735jf(String str) {
        this.duw = str;
        this.dmv = true;
    }

    /* renamed from: Hw */
    public final void mo14679Hw() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                C5069y c5069y = new C5069y();
                int bX = c5069y.mo10393bX(this.field_lvbuff);
                if (bX != 0) {
                    C4990ab.m7412e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(bX)));
                    return;
                }
                this.dtR = c5069y.getInt();
                this.dtS = c5069y.getInt();
                this.dtT = c5069y.getString();
                this.dtU = c5069y.getLong();
                this.uin = c5069y.getInt();
                this.dtV = c5069y.getString();
                this.cFl = c5069y.getString();
                this.dtW = c5069y.getInt();
                this.dtX = c5069y.getInt();
                this.dtY = c5069y.getString();
                this.dtZ = c5069y.getString();
                this.dua = c5069y.getInt();
                this.dub = c5069y.getInt();
                this.signature = c5069y.getString();
                this.duc = c5069y.getString();
                this.dud = c5069y.getString();
                this.due = c5069y.getString();
                this.duf = c5069y.getInt();
                this.cvd = c5069y.getInt();
                this.dug = c5069y.getString();
                this.field_verifyFlag = c5069y.getInt();
                this.duh = c5069y.getString();
                if (!c5069y.dof()) {
                    this.dui = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.duj = c5069y.getInt();
                }
                if (!c5069y.dof()) {
                    this.duk = c5069y.getInt();
                }
                if (!c5069y.dof()) {
                    this.dul = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.dum = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.dun = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.duo = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.dup = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.duq = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.dur = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.dus = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.dut = c5069y.getInt();
                }
                if (!c5069y.dof()) {
                    this.duu = c5069y.getString();
                }
                if (!c5069y.dof()) {
                    this.duv = c5069y.getInt();
                }
                if (!c5069y.dof()) {
                    this.duw = c5069y.getString();
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        try {
            if (this.dmv) {
                C5069y c5069y = new C5069y();
                c5069y.dog();
                c5069y.mo10391LY(this.dtR);
                c5069y.mo10391LY(this.dtS);
                c5069y.amu(this.dtT);
                c5069y.mo10403mq(this.dtU);
                c5069y.mo10391LY(this.uin);
                c5069y.amu(this.dtV);
                c5069y.amu(this.cFl);
                c5069y.mo10391LY(this.dtW);
                c5069y.mo10391LY(this.dtX);
                c5069y.amu(this.dtY);
                c5069y.amu(this.dtZ);
                c5069y.mo10391LY(this.dua);
                c5069y.mo10391LY(this.dub);
                c5069y.amu(this.signature);
                c5069y.amu(this.duc);
                c5069y.amu(this.dud);
                c5069y.amu(this.due);
                c5069y.mo10391LY(this.duf);
                c5069y.mo10391LY(this.cvd);
                c5069y.amu(this.dug);
                c5069y.mo10391LY(this.field_verifyFlag);
                c5069y.amu(this.duh);
                c5069y.amu(this.dui);
                c5069y.mo10391LY(this.duj);
                c5069y.mo10391LY(this.duk);
                c5069y.amu(this.dul);
                c5069y.amu(this.dum);
                c5069y.amu(this.dun);
                c5069y.amu(this.duo);
                c5069y.amu(this.dup);
                c5069y.amu(this.duq);
                c5069y.amu(this.dur);
                c5069y.amu(this.dus);
                c5069y.mo10391LY(this.dut);
                c5069y.amu(this.duu);
                c5069y.mo10391LY(this.duv);
                c5069y.amu(this.duw);
                this.field_lvbuff = c5069y.doh();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SDK.BaseContact", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_alias == null) {
            this.field_alias = "";
        }
        if (this.dtj) {
            contentValues.put("alias", this.field_alias);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.dtk) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_domainList == null) {
            this.field_domainList = "";
        }
        if (this.dtl) {
            contentValues.put("domainList", this.field_domainList);
        }
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.dqg) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = "";
        }
        if (this.dtm) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.field_quanPin == null) {
            this.field_quanPin = "";
        }
        if (this.dtn) {
            contentValues.put("quanPin", this.field_quanPin);
        }
        if (this.dto) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dtp) {
            contentValues.put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
        }
        if (this.field_weiboNickname == null) {
            this.field_weiboNickname = "";
        }
        if (this.dtq) {
            contentValues.put("weiboNickname", this.field_weiboNickname);
        }
        if (this.field_conRemarkPYFull == null) {
            this.field_conRemarkPYFull = "";
        }
        if (this.dtr) {
            contentValues.put("conRemarkPYFull", this.field_conRemarkPYFull);
        }
        if (this.field_conRemarkPYShort == null) {
            this.field_conRemarkPYShort = "";
        }
        if (this.dts) {
            contentValues.put("conRemarkPYShort", this.field_conRemarkPYShort);
        }
        if (this.dmv) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.dtt) {
            contentValues.put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
        }
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.dtu) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.dtv) {
            contentValues.put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
        }
        if (this.dtw) {
            contentValues.put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
        }
        if (this.field_contactLabelIds == null) {
            this.field_contactLabelIds = "";
        }
        if (this.dtx) {
            contentValues.put("contactLabelIds", this.field_contactLabelIds);
        }
        if (this.field_descWordingId == null) {
            this.field_descWordingId = "";
        }
        if (this.dty) {
            contentValues.put("descWordingId", this.field_descWordingId);
        }
        if (this.dtz) {
            contentValues.put("openImAppid", this.field_openImAppid);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
