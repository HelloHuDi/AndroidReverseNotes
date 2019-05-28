package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;

public abstract class ae extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private static final int doR = "bitFlag".hashCode();
    private static final int dpQ = "brandList".hashCode();
    private static final int dpR = "brandListVersion".hashCode();
    private static final int dpS = "brandListContent".hashCode();
    private static final int dpT = "brandFlag".hashCode();
    private static final int dpU = IssueStorage.COLUMN_EXT_INFO.hashCode();
    private static final int dpV = "brandInfo".hashCode();
    private static final int dpW = "brandIconURL".hashCode();
    private static final int dpX = "hadAlert".hashCode();
    private static final int dpY = "acceptType".hashCode();
    private static final int dpZ = "enterpriseFather".hashCode();
    private static final int dqa = "kfWorkerId".hashCode();
    private static final int dqb = "specialType".hashCode();
    private static final int dqc = "attrSyncVersion".hashCode();
    private static final int dqd = "incrementUpdateTime".hashCode();
    private boolean diU = true;
    private boolean djK = true;
    private boolean dkE = true;
    private boolean dlm = true;
    private boolean dln = true;
    private boolean doF = true;
    private boolean dpC = true;
    private boolean dpD = true;
    private boolean dpE = true;
    private boolean dpF = true;
    private boolean dpG = true;
    private boolean dpH = true;
    private boolean dpI = true;
    private boolean dpJ = true;
    private boolean dpK = true;
    private boolean dpL = true;
    private boolean dpM = true;
    private boolean dpN = true;
    private boolean dpO = true;
    private boolean dpP = true;
    public int field_acceptType;
    public String field_appId;
    public String field_attrSyncVersion;
    public int field_bitFlag;
    public int field_brandFlag;
    public String field_brandIconURL;
    public String field_brandInfo;
    public String field_brandList;
    public String field_brandListContent;
    public String field_brandListVersion;
    public String field_enterpriseFather;
    public String field_extInfo;
    public int field_hadAlert;
    public long field_incrementUpdateTime;
    public String field_kfWorkerId;
    public int field_specialType;
    public int field_status;
    public int field_type;
    public long field_updateTime;
    public String field_username;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dpQ == hashCode) {
                    this.field_brandList = cursor.getString(i);
                } else if (dpR == hashCode) {
                    this.field_brandListVersion = cursor.getString(i);
                } else if (dpS == hashCode) {
                    this.field_brandListContent = cursor.getString(i);
                } else if (dpT == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (dpU == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (dpV == hashCode) {
                    this.field_brandInfo = cursor.getString(i);
                } else if (dpW == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (dpX == hashCode) {
                    this.field_hadAlert = cursor.getInt(i);
                } else if (dpY == hashCode) {
                    this.field_acceptType = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dpZ == hashCode) {
                    this.field_enterpriseFather = cursor.getString(i);
                } else if (dqa == hashCode) {
                    this.field_kfWorkerId = cursor.getString(i);
                } else if (dqb == hashCode) {
                    this.field_specialType = cursor.getInt(i);
                } else if (dqc == hashCode) {
                    this.field_attrSyncVersion = cursor.getString(i);
                } else if (dqd == hashCode) {
                    this.field_incrementUpdateTime = cursor.getLong(i);
                } else if (doR == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.field_brandList == null) {
            this.field_brandList = "";
        }
        if (this.dpC) {
            contentValues.put("brandList", this.field_brandList);
        }
        if (this.dpD) {
            contentValues.put("brandListVersion", this.field_brandListVersion);
        }
        if (this.dpE) {
            contentValues.put("brandListContent", this.field_brandListContent);
        }
        if (this.dpF) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.dpG) {
            contentValues.put(IssueStorage.COLUMN_EXT_INFO, this.field_extInfo);
        }
        if (this.dpH) {
            contentValues.put("brandInfo", this.field_brandInfo);
        }
        if (this.dpI) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.dpJ) {
            contentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
        }
        if (this.dpK) {
            contentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dpL) {
            contentValues.put("enterpriseFather", this.field_enterpriseFather);
        }
        if (this.dpM) {
            contentValues.put("kfWorkerId", this.field_kfWorkerId);
        }
        if (this.dpN) {
            contentValues.put("specialType", Integer.valueOf(this.field_specialType));
        }
        if (this.dpO) {
            contentValues.put("attrSyncVersion", this.field_attrSyncVersion);
        }
        if (this.dpP) {
            contentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
        }
        if (this.doF) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
