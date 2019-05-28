package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.cq */
public abstract class C32685cq extends C4925c {
    private static final int dHA = "TitleKey_android".hashCode();
    private static final int dHB = "Title_cn".hashCode();
    private static final int dHC = "Title_hk".hashCode();
    private static final int dHD = "Title_tw".hashCode();
    private static final int dHE = "Title_en".hashCode();
    private static final int dHF = "Desc_cn".hashCode();
    private static final int dHG = "Desc_hk".hashCode();
    private static final int dHH = "Desc_tw".hashCode();
    private static final int dHI = "Desc_en".hashCode();
    private static final int dHJ = "Introduce_cn".hashCode();
    private static final int dHK = "Introduce_hk".hashCode();
    private static final int dHL = "Introduce_tw".hashCode();
    private static final int dHM = "Introduce_en".hashCode();
    private static final int dHN = "starttime".hashCode();
    private static final int dHO = "endtime".hashCode();
    private static final int dHP = "ThumbUrl_cn".hashCode();
    private static final int dHQ = "ThumbUrl_hk".hashCode();
    private static final int dHR = "ThumbUrl_tw".hashCode();
    private static final int dHS = "ThumbUrl_en".hashCode();
    private static final int dHT = "ImgUrl_android_cn".hashCode();
    private static final int dHU = "ImgUrl_android_hk".hashCode();
    private static final int dHV = "ImgUrl_android_tw".hashCode();
    private static final int dHW = "ImgUrl_android_en".hashCode();
    private static final int dHX = "RedPoint".hashCode();
    private static final int dHY = "WeAppDebugMode".hashCode();
    private static final int dHZ = "idkey".hashCode();
    private static final int dHr = "LabsAppId".hashCode();
    private static final int dHs = "Type".hashCode();
    private static final int dHt = "BizType".hashCode();
    private static final int dHu = "Switch".hashCode();
    private static final int dHv = "AllVer".hashCode();
    private static final int dHw = "DetailURL".hashCode();
    private static final int dHx = "WeAppUser".hashCode();
    private static final int dHy = "WeAppPath".hashCode();
    private static final int dHz = "Pos".hashCode();
    private static final int dIa = "idkeyValue".hashCode();
    private static final int dIb = "Icon".hashCode();
    private static final int dIc = "ImgUrl_cn".hashCode();
    private static final int dId = "ImgUrl_hk".hashCode();
    private static final int dIe = "ImgUrl_tw".hashCode();
    private static final int dIf = "ImgUrl_en".hashCode();
    private static final int dIg = "bItemFromXExpt".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dji = "expId".hashCode();
    private static final int djj = "sequence".hashCode();
    private static final int djk = "prioritylevel".hashCode();
    private boolean dGB = true;
    private boolean dGC = true;
    private boolean dGD = true;
    private boolean dGE = true;
    private boolean dGF = true;
    private boolean dGG = true;
    private boolean dGH = true;
    private boolean dGI = true;
    private boolean dGJ = true;
    private boolean dGK = true;
    private boolean dGL = true;
    private boolean dGM = true;
    private boolean dGN = true;
    private boolean dGO = true;
    private boolean dGP = true;
    private boolean dGQ = true;
    private boolean dGR = true;
    private boolean dGS = true;
    private boolean dGT = true;
    private boolean dGU = true;
    private boolean dGV = true;
    private boolean dGW = true;
    private boolean dGX = true;
    private boolean dGY = true;
    private boolean dGZ = true;
    private boolean dHa = true;
    private boolean dHb = true;
    private boolean dHc = true;
    private boolean dHd = true;
    private boolean dHe = true;
    private boolean dHf = true;
    private boolean dHg = true;
    private boolean dHh = true;
    private boolean dHi = true;
    private boolean dHj = true;
    private boolean dHk = true;
    private boolean dHl = true;
    private boolean dHm = true;
    private boolean dHn = true;
    private boolean dHo = true;
    private boolean dHp = true;
    private boolean dHq = true;
    private boolean diU = true;
    private boolean dja = true;
    private boolean djb = true;
    private boolean djc = true;
    public int field_AllVer;
    public int field_BizType;
    public String field_Desc_cn;
    public String field_Desc_en;
    public String field_Desc_hk;
    public String field_Desc_tw;
    public String field_DetailURL;
    public String field_Icon;
    public String field_ImgUrl_android_cn;
    public String field_ImgUrl_android_en;
    public String field_ImgUrl_android_hk;
    public String field_ImgUrl_android_tw;
    public String field_ImgUrl_cn;
    public String field_ImgUrl_en;
    public String field_ImgUrl_hk;
    public String field_ImgUrl_tw;
    public String field_Introduce_cn;
    public String field_Introduce_en;
    public String field_Introduce_hk;
    public String field_Introduce_tw;
    public String field_LabsAppId;
    public int field_Pos;
    public int field_RedPoint;
    public int field_Switch;
    public String field_ThumbUrl_cn;
    public String field_ThumbUrl_en;
    public String field_ThumbUrl_hk;
    public String field_ThumbUrl_tw;
    public String field_TitleKey_android;
    public String field_Title_cn;
    public String field_Title_en;
    public String field_Title_hk;
    public String field_Title_tw;
    public int field_Type;
    public int field_WeAppDebugMode;
    public String field_WeAppPath;
    public String field_WeAppUser;
    public int field_bItemFromXExpt;
    public long field_endtime;
    public String field_expId;
    public int field_idkey;
    public int field_idkeyValue;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_starttime;
    public int field_status;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dHr == hashCode) {
                    this.field_LabsAppId = cursor.getString(i);
                    this.dGB = true;
                } else if (dji == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (dHs == hashCode) {
                    this.field_Type = cursor.getInt(i);
                } else if (dHt == hashCode) {
                    this.field_BizType = cursor.getInt(i);
                } else if (dHu == hashCode) {
                    this.field_Switch = cursor.getInt(i);
                } else if (dHv == hashCode) {
                    this.field_AllVer = cursor.getInt(i);
                } else if (dHw == hashCode) {
                    this.field_DetailURL = cursor.getString(i);
                } else if (dHx == hashCode) {
                    this.field_WeAppUser = cursor.getString(i);
                } else if (dHy == hashCode) {
                    this.field_WeAppPath = cursor.getString(i);
                } else if (dHz == hashCode) {
                    this.field_Pos = cursor.getInt(i);
                } else if (dHA == hashCode) {
                    this.field_TitleKey_android = cursor.getString(i);
                } else if (dHB == hashCode) {
                    this.field_Title_cn = cursor.getString(i);
                } else if (dHC == hashCode) {
                    this.field_Title_hk = cursor.getString(i);
                } else if (dHD == hashCode) {
                    this.field_Title_tw = cursor.getString(i);
                } else if (dHE == hashCode) {
                    this.field_Title_en = cursor.getString(i);
                } else if (dHF == hashCode) {
                    this.field_Desc_cn = cursor.getString(i);
                } else if (dHG == hashCode) {
                    this.field_Desc_hk = cursor.getString(i);
                } else if (dHH == hashCode) {
                    this.field_Desc_tw = cursor.getString(i);
                } else if (dHI == hashCode) {
                    this.field_Desc_en = cursor.getString(i);
                } else if (dHJ == hashCode) {
                    this.field_Introduce_cn = cursor.getString(i);
                } else if (dHK == hashCode) {
                    this.field_Introduce_hk = cursor.getString(i);
                } else if (dHL == hashCode) {
                    this.field_Introduce_tw = cursor.getString(i);
                } else if (dHM == hashCode) {
                    this.field_Introduce_en = cursor.getString(i);
                } else if (dHN == hashCode) {
                    this.field_starttime = cursor.getLong(i);
                } else if (dHO == hashCode) {
                    this.field_endtime = cursor.getLong(i);
                } else if (djj == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (djk == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dHP == hashCode) {
                    this.field_ThumbUrl_cn = cursor.getString(i);
                } else if (dHQ == hashCode) {
                    this.field_ThumbUrl_hk = cursor.getString(i);
                } else if (dHR == hashCode) {
                    this.field_ThumbUrl_tw = cursor.getString(i);
                } else if (dHS == hashCode) {
                    this.field_ThumbUrl_en = cursor.getString(i);
                } else if (dHT == hashCode) {
                    this.field_ImgUrl_android_cn = cursor.getString(i);
                } else if (dHU == hashCode) {
                    this.field_ImgUrl_android_hk = cursor.getString(i);
                } else if (dHV == hashCode) {
                    this.field_ImgUrl_android_tw = cursor.getString(i);
                } else if (dHW == hashCode) {
                    this.field_ImgUrl_android_en = cursor.getString(i);
                } else if (dHX == hashCode) {
                    this.field_RedPoint = cursor.getInt(i);
                } else if (dHY == hashCode) {
                    this.field_WeAppDebugMode = cursor.getInt(i);
                } else if (dHZ == hashCode) {
                    this.field_idkey = cursor.getInt(i);
                } else if (dIa == hashCode) {
                    this.field_idkeyValue = cursor.getInt(i);
                } else if (dIb == hashCode) {
                    this.field_Icon = cursor.getString(i);
                } else if (dIc == hashCode) {
                    this.field_ImgUrl_cn = cursor.getString(i);
                } else if (dId == hashCode) {
                    this.field_ImgUrl_hk = cursor.getString(i);
                } else if (dIe == hashCode) {
                    this.field_ImgUrl_tw = cursor.getString(i);
                } else if (dIf == hashCode) {
                    this.field_ImgUrl_en = cursor.getString(i);
                } else if (dIg == hashCode) {
                    this.field_bItemFromXExpt = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dGB) {
            contentValues.put("LabsAppId", this.field_LabsAppId);
        }
        if (this.field_expId == null) {
            this.field_expId = "";
        }
        if (this.dja) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.dGC) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.dGD) {
            contentValues.put("BizType", Integer.valueOf(this.field_BizType));
        }
        if (this.dGE) {
            contentValues.put("Switch", Integer.valueOf(this.field_Switch));
        }
        if (this.dGF) {
            contentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
        }
        if (this.dGG) {
            contentValues.put("DetailURL", this.field_DetailURL);
        }
        if (this.dGH) {
            contentValues.put("WeAppUser", this.field_WeAppUser);
        }
        if (this.dGI) {
            contentValues.put("WeAppPath", this.field_WeAppPath);
        }
        if (this.dGJ) {
            contentValues.put("Pos", Integer.valueOf(this.field_Pos));
        }
        if (this.dGK) {
            contentValues.put("TitleKey_android", this.field_TitleKey_android);
        }
        if (this.dGL) {
            contentValues.put("Title_cn", this.field_Title_cn);
        }
        if (this.dGM) {
            contentValues.put("Title_hk", this.field_Title_hk);
        }
        if (this.dGN) {
            contentValues.put("Title_tw", this.field_Title_tw);
        }
        if (this.dGO) {
            contentValues.put("Title_en", this.field_Title_en);
        }
        if (this.dGP) {
            contentValues.put("Desc_cn", this.field_Desc_cn);
        }
        if (this.dGQ) {
            contentValues.put("Desc_hk", this.field_Desc_hk);
        }
        if (this.dGR) {
            contentValues.put("Desc_tw", this.field_Desc_tw);
        }
        if (this.dGS) {
            contentValues.put("Desc_en", this.field_Desc_en);
        }
        if (this.dGT) {
            contentValues.put("Introduce_cn", this.field_Introduce_cn);
        }
        if (this.dGU) {
            contentValues.put("Introduce_hk", this.field_Introduce_hk);
        }
        if (this.dGV) {
            contentValues.put("Introduce_tw", this.field_Introduce_tw);
        }
        if (this.dGW) {
            contentValues.put("Introduce_en", this.field_Introduce_en);
        }
        if (this.dGX) {
            contentValues.put("starttime", Long.valueOf(this.field_starttime));
        }
        if (this.dGY) {
            contentValues.put("endtime", Long.valueOf(this.field_endtime));
        }
        if (this.djb) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.djc) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dGZ) {
            contentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
        }
        if (this.dHa) {
            contentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
        }
        if (this.dHb) {
            contentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
        }
        if (this.dHc) {
            contentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
        }
        if (this.dHd) {
            contentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
        }
        if (this.dHe) {
            contentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
        }
        if (this.dHf) {
            contentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
        }
        if (this.dHg) {
            contentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
        }
        if (this.dHh) {
            contentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
        }
        if (this.dHi) {
            contentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
        }
        if (this.dHj) {
            contentValues.put("idkey", Integer.valueOf(this.field_idkey));
        }
        if (this.dHk) {
            contentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
        }
        if (this.dHl) {
            contentValues.put("Icon", this.field_Icon);
        }
        if (this.dHm) {
            contentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
        }
        if (this.dHn) {
            contentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
        }
        if (this.dHo) {
            contentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
        }
        if (this.dHp) {
            contentValues.put("ImgUrl_en", this.field_ImgUrl_en);
        }
        if (this.dHq) {
            contentValues.put("bItemFromXExpt", Integer.valueOf(this.field_bItemFromXExpt));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
