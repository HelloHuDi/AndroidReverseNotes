package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public abstract class ap extends c {
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

    public void iy(String str) {
        this.field_alias = str;
        this.dtj = true;
    }

    public String Hq() {
        return this.field_alias;
    }

    public void iz(String str) {
        this.field_conRemark = str;
        this.dtk = true;
    }

    public final String Hr() {
        return this.field_conRemark;
    }

    public void iA(String str) {
        this.field_domainList = str;
        this.dtl = true;
    }

    public void iB(String str) {
        this.field_nickname = str;
        this.dqg = true;
    }

    public final String Hs() {
        return this.field_nickname;
    }

    public void iC(String str) {
        this.field_pyInitial = str;
        this.dtm = true;
    }

    public String Ht() {
        return this.field_pyInitial;
    }

    public void iD(String str) {
        this.field_quanPin = str;
        this.dtn = true;
    }

    public String Hu() {
        return this.field_quanPin;
    }

    public void hu(int i) {
        this.field_showHead = i;
        this.dto = true;
    }

    public void setType(int i) {
        this.field_type = i;
        this.djK = true;
    }

    public void hv(int i) {
        this.field_weiboFlag = i;
        this.dtp = true;
    }

    public void iE(String str) {
        this.field_weiboNickname = str;
        this.dtq = true;
    }

    public void iF(String str) {
        this.field_conRemarkPYFull = str;
        this.dtr = true;
    }

    public void iG(String str) {
        this.field_conRemarkPYShort = str;
        this.dts = true;
    }

    public void H(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.dmv = true;
    }

    public void hw(int i) {
        this.field_verifyFlag = i;
        this.dtt = true;
    }

    public void iH(String str) {
        this.field_encryptUsername = str;
        this.dtu = true;
    }

    public final String Hv() {
        return this.field_encryptUsername;
    }

    public void hx(int i) {
        this.field_chatroomFlag = i;
        this.dtv = true;
    }

    public void hy(int i) {
        this.field_deleteFlag = i;
        this.dtw = true;
    }

    public void iI(String str) {
        this.field_contactLabelIds = str;
        this.dtx = true;
    }

    public final void iJ(String str) {
        this.field_descWordingId = str;
        this.dty = true;
    }

    public void iK(String str) {
        this.field_openImAppid = str;
        this.dtz = true;
    }

    public void d(Cursor cursor) {
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
            Hw();
        }
    }

    public void hz(int i) {
        this.dtR = i;
        this.dmv = true;
    }

    public void hA(int i) {
        this.dtS = i;
        this.dmv = true;
    }

    public void iL(String str) {
        this.dtT = str;
        this.dmv = true;
    }

    public void eC(long j) {
        this.dtU = j;
        this.dmv = true;
    }

    public void hB(int i) {
        this.uin = i;
        this.dmv = true;
    }

    public void iM(String str) {
        this.dtV = str;
        this.dmv = true;
    }

    public void iN(String str) {
        this.cFl = str;
        this.dmv = true;
    }

    public void hC(int i) {
        this.dtW = i;
        this.dmv = true;
    }

    public void hD(int i) {
        this.dtX = i;
        this.dmv = true;
    }

    public void iO(String str) {
        this.dtY = str;
        this.dmv = true;
    }

    public void iP(String str) {
        this.dtZ = str;
        this.dmv = true;
    }

    public void hE(int i) {
        this.dua = i;
        this.dmv = true;
    }

    public void hF(int i) {
        this.dub = i;
        this.dmv = true;
    }

    public void iQ(String str) {
        this.signature = str;
        this.dmv = true;
    }

    public String getProvince() {
        return this.duc;
    }

    public void iR(String str) {
        this.duc = str;
        this.dmv = true;
    }

    public String getCity() {
        return this.dud;
    }

    public void iS(String str) {
        this.dud = str;
        this.dmv = true;
    }

    public void iT(String str) {
        this.due = str;
        this.dmv = true;
    }

    public void hG(int i) {
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

    public void iU(String str) {
        this.dug = str;
        this.dmv = true;
    }

    public void iV(String str) {
        this.duh = str;
        this.dmv = true;
    }

    public void iW(String str) {
        this.dui = str;
        this.dmv = true;
    }

    public void hH(int i) {
        this.duj = i;
        this.dmv = true;
    }

    public void hI(int i) {
        this.duk = i;
        this.dmv = true;
    }

    public void iX(String str) {
        this.dul = str;
        this.dmv = true;
    }

    public void iY(String str) {
        this.dum = str;
        this.dmv = true;
    }

    public void iZ(String str) {
        this.dun = str;
        this.dmv = true;
    }

    public void ja(String str) {
        this.duo = str;
        this.dmv = true;
    }

    public void jb(String str) {
        this.dup = str;
        this.dmv = true;
    }

    public void jc(String str) {
        this.duq = str;
        this.dmv = true;
    }

    public void jd(String str) {
        this.dur = str;
        this.dmv = true;
    }

    public void je(String str) {
        this.dus = str;
        this.dmv = true;
    }

    public final void hJ(int i) {
        this.dut = i;
        this.dmv = true;
    }

    public final void hK(int i) {
        this.duv = i;
        this.dmv = true;
    }

    public final void jf(String str) {
        this.duw = str;
        this.dmv = true;
    }

    public final void Hw() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                y yVar = new y();
                int bX = yVar.bX(this.field_lvbuff);
                if (bX != 0) {
                    ab.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(bX)));
                    return;
                }
                this.dtR = yVar.getInt();
                this.dtS = yVar.getInt();
                this.dtT = yVar.getString();
                this.dtU = yVar.getLong();
                this.uin = yVar.getInt();
                this.dtV = yVar.getString();
                this.cFl = yVar.getString();
                this.dtW = yVar.getInt();
                this.dtX = yVar.getInt();
                this.dtY = yVar.getString();
                this.dtZ = yVar.getString();
                this.dua = yVar.getInt();
                this.dub = yVar.getInt();
                this.signature = yVar.getString();
                this.duc = yVar.getString();
                this.dud = yVar.getString();
                this.due = yVar.getString();
                this.duf = yVar.getInt();
                this.cvd = yVar.getInt();
                this.dug = yVar.getString();
                this.field_verifyFlag = yVar.getInt();
                this.duh = yVar.getString();
                if (!yVar.dof()) {
                    this.dui = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.duj = yVar.getInt();
                }
                if (!yVar.dof()) {
                    this.duk = yVar.getInt();
                }
                if (!yVar.dof()) {
                    this.dul = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.dum = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.dun = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.duo = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.dup = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.duq = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.dur = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.dus = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.dut = yVar.getInt();
                }
                if (!yVar.dof()) {
                    this.duu = yVar.getString();
                }
                if (!yVar.dof()) {
                    this.duv = yVar.getInt();
                }
                if (!yVar.dof()) {
                    this.duw = yVar.getString();
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }

    public final ContentValues Hl() {
        try {
            if (this.dmv) {
                y yVar = new y();
                yVar.dog();
                yVar.LY(this.dtR);
                yVar.LY(this.dtS);
                yVar.amu(this.dtT);
                yVar.mq(this.dtU);
                yVar.LY(this.uin);
                yVar.amu(this.dtV);
                yVar.amu(this.cFl);
                yVar.LY(this.dtW);
                yVar.LY(this.dtX);
                yVar.amu(this.dtY);
                yVar.amu(this.dtZ);
                yVar.LY(this.dua);
                yVar.LY(this.dub);
                yVar.amu(this.signature);
                yVar.amu(this.duc);
                yVar.amu(this.dud);
                yVar.amu(this.due);
                yVar.LY(this.duf);
                yVar.LY(this.cvd);
                yVar.amu(this.dug);
                yVar.LY(this.field_verifyFlag);
                yVar.amu(this.duh);
                yVar.amu(this.dui);
                yVar.LY(this.duj);
                yVar.LY(this.duk);
                yVar.amu(this.dul);
                yVar.amu(this.dum);
                yVar.amu(this.dun);
                yVar.amu(this.duo);
                yVar.amu(this.dup);
                yVar.amu(this.duq);
                yVar.amu(this.dur);
                yVar.amu(this.dus);
                yVar.LY(this.dut);
                yVar.amu(this.duu);
                yVar.LY(this.duv);
                yVar.amu(this.duw);
                this.field_lvbuff = yVar.doh();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.BaseContact", "get value failed, %s", e.getMessage());
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
