package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class az extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dnE = "flag".hashCode();
    private static final int dwA = "count".hashCode();
    private static final int dwb = "productID".hashCode();
    private static final int dwc = "packIconUrl".hashCode();
    private static final int dwd = "packGrayIconUrl".hashCode();
    private static final int dwe = "packCoverUrl".hashCode();
    private static final int dwf = "packName".hashCode();
    private static final int dwg = "packDesc".hashCode();
    private static final int dwh = "packAuthInfo".hashCode();
    private static final int dwi = "packPrice".hashCode();
    private static final int dwj = "packType".hashCode();
    private static final int dwk = "packFlag".hashCode();
    private static final int dwl = "packExpire".hashCode();
    private static final int dwm = "packTimeStamp".hashCode();
    private static final int dwn = "packCopyright".hashCode();
    private static final int dwo = "sort".hashCode();
    private static final int dwp = "lastUseTime".hashCode();
    private static final int dwq = "packStatus".hashCode();
    private static final int dwr = "recommand".hashCode();
    private static final int dws = "sync".hashCode();
    private static final int dwt = "idx".hashCode();
    private static final int dwu = "BigIconUrl".hashCode();
    private static final int dwv = "MutiLanName".hashCode();
    private static final int dww = "recommandType".hashCode();
    private static final int dwx = "lang".hashCode();
    private static final int dwy = "recommandWord".hashCode();
    private static final int dwz = "buttonType".hashCode();
    private boolean diU = true;
    private boolean djK = true;
    private boolean dnC = true;
    private boolean dvB = true;
    private boolean dvC = true;
    private boolean dvD = true;
    private boolean dvE = true;
    private boolean dvF = true;
    private boolean dvG = true;
    private boolean dvH = true;
    private boolean dvI = true;
    private boolean dvJ = true;
    private boolean dvK = true;
    private boolean dvL = true;
    private boolean dvM = true;
    private boolean dvN = true;
    private boolean dvO = true;
    private boolean dvP = true;
    private boolean dvQ = true;
    private boolean dvR = true;
    private boolean dvS = true;
    private boolean dvT = true;
    private boolean dvU = true;
    private boolean dvV = true;
    private boolean dvW = true;
    private boolean dvX = true;
    private boolean dvY = true;
    private boolean dvZ = true;
    private boolean dwa = true;
    public String field_BigIconUrl;
    public String field_MutiLanName;
    public int field_buttonType;
    public int field_count;
    public int field_flag;
    public int field_idx;
    public String field_lang;
    public long field_lastUseTime;
    public String field_packAuthInfo;
    public String field_packCopyright;
    public String field_packCoverUrl;
    public String field_packDesc;
    public long field_packExpire;
    public int field_packFlag;
    public String field_packGrayIconUrl;
    public String field_packIconUrl;
    public String field_packName;
    public String field_packPrice;
    public int field_packStatus;
    public long field_packTimeStamp;
    public int field_packType;
    public String field_productID;
    public int field_recommand;
    public int field_recommandType;
    public String field_recommandWord;
    public int field_sort;
    public int field_status;
    public int field_sync;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dwb == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.dvB = true;
                } else if (dwc == hashCode) {
                    this.field_packIconUrl = cursor.getString(i);
                } else if (dwd == hashCode) {
                    this.field_packGrayIconUrl = cursor.getString(i);
                } else if (dwe == hashCode) {
                    this.field_packCoverUrl = cursor.getString(i);
                } else if (dwf == hashCode) {
                    this.field_packName = cursor.getString(i);
                } else if (dwg == hashCode) {
                    this.field_packDesc = cursor.getString(i);
                } else if (dwh == hashCode) {
                    this.field_packAuthInfo = cursor.getString(i);
                } else if (dwi == hashCode) {
                    this.field_packPrice = cursor.getString(i);
                } else if (dwj == hashCode) {
                    this.field_packType = cursor.getInt(i);
                } else if (dwk == hashCode) {
                    this.field_packFlag = cursor.getInt(i);
                } else if (dwl == hashCode) {
                    this.field_packExpire = cursor.getLong(i);
                } else if (dwm == hashCode) {
                    this.field_packTimeStamp = cursor.getLong(i);
                } else if (dwn == hashCode) {
                    this.field_packCopyright = cursor.getString(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dwo == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (dwp == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (dwq == hashCode) {
                    this.field_packStatus = cursor.getInt(i);
                } else if (dnE == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (dwr == hashCode) {
                    this.field_recommand = cursor.getInt(i);
                } else if (dws == hashCode) {
                    this.field_sync = cursor.getInt(i);
                } else if (dwt == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (dwu == hashCode) {
                    this.field_BigIconUrl = cursor.getString(i);
                } else if (dwv == hashCode) {
                    this.field_MutiLanName = cursor.getString(i);
                } else if (dww == hashCode) {
                    this.field_recommandType = cursor.getInt(i);
                } else if (dwx == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (dwy == hashCode) {
                    this.field_recommandWord = cursor.getString(i);
                } else if (dwz == hashCode) {
                    this.field_buttonType = cursor.getInt(i);
                } else if (dwA == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dvB) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.dvC) {
            contentValues.put("packIconUrl", this.field_packIconUrl);
        }
        if (this.dvD) {
            contentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
        }
        if (this.dvE) {
            contentValues.put("packCoverUrl", this.field_packCoverUrl);
        }
        if (this.dvF) {
            contentValues.put("packName", this.field_packName);
        }
        if (this.dvG) {
            contentValues.put("packDesc", this.field_packDesc);
        }
        if (this.dvH) {
            contentValues.put("packAuthInfo", this.field_packAuthInfo);
        }
        if (this.dvI) {
            contentValues.put("packPrice", this.field_packPrice);
        }
        if (this.dvJ) {
            contentValues.put("packType", Integer.valueOf(this.field_packType));
        }
        if (this.dvK) {
            contentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
        }
        if (this.dvL) {
            contentValues.put("packExpire", Long.valueOf(this.field_packExpire));
        }
        if (this.dvM) {
            contentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
        }
        if (this.dvN) {
            contentValues.put("packCopyright", this.field_packCopyright);
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dvO) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.dvP) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.dvQ) {
            contentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
        }
        if (this.dnC) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.dvR) {
            contentValues.put("recommand", Integer.valueOf(this.field_recommand));
        }
        if (this.dvS) {
            contentValues.put("sync", Integer.valueOf(this.field_sync));
        }
        if (this.dvT) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.dvU) {
            contentValues.put("BigIconUrl", this.field_BigIconUrl);
        }
        if (this.dvV) {
            contentValues.put("MutiLanName", this.field_MutiLanName);
        }
        if (this.dvW) {
            contentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
        }
        if (this.dvX) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.dvY) {
            contentValues.put("recommandWord", this.field_recommandWord);
        }
        if (this.dvZ) {
            contentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
        }
        if (this.dwa) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
