package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.f */
public abstract class C32695f extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkc = "snsId".hashCode();
    private static final int dkd = "userName".hashCode();
    private static final int dke = "localFlag".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dkg = "head".hashCode();
    private static final int dkh = "localPrivate".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkj = "sourceType".hashCode();
    private static final int dkk = "likeFlag".hashCode();
    private static final int dkl = "pravited".hashCode();
    private static final int dkm = "stringSeq".hashCode();
    private static final int dkn = C8741b.CONTENT.hashCode();
    private static final int dko = "attrBuf".hashCode();
    private static final int dkp = "postBuf".hashCode();
    private static final int dkq = "adinfo".hashCode();
    private static final int dkr = "adxml".hashCode();
    private static final int dks = "createAdTime".hashCode();
    private static final int dkt = "exposureTime".hashCode();
    private static final int dku = "firstControlTime".hashCode();
    private static final int dkv = "recxml".hashCode();
    private static final int dkw = "subType".hashCode();
    private static final int dkx = "exposureCount".hashCode();
    private static final int dky = "atAdinfo".hashCode();
    private static final int dkz = "remindInfoGroup".hashCode();
    private boolean djE = true;
    private boolean djF = true;
    private boolean djG = true;
    private boolean djH = true;
    private boolean djI = true;
    private boolean djJ = true;
    private boolean djK = true;
    private boolean djL = true;
    private boolean djM = true;
    private boolean djN = true;
    private boolean djO = true;
    private boolean djP = true;
    private boolean djQ = true;
    private boolean djR = true;
    private boolean djS = true;
    private boolean djT = true;
    private boolean djU = true;
    private boolean djV = true;
    private boolean djW = true;
    private boolean djX = true;
    private boolean djY = true;
    private boolean djZ = true;
    private boolean dka = true;
    private boolean dkb = true;
    public String field_adinfo;
    public String field_adxml;
    public String field_atAdinfo;
    public byte[] field_attrBuf;
    public byte[] field_content;
    public int field_createAdTime;
    public int field_createTime;
    public int field_exposureCount;
    public int field_exposureTime;
    public int field_firstControlTime;
    public int field_head;
    public int field_likeFlag;
    public int field_localFlag;
    public int field_localPrivate;
    public byte[] field_postBuf;
    public int field_pravited;
    public String field_recxml;
    public byte[] field_remindInfoGroup;
    public long field_snsId;
    public int field_sourceType;
    public String field_stringSeq;
    public int field_subType;
    public int field_type;
    public String field_userName;

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkc == hashCode) {
                    this.field_snsId = cursor.getLong(i);
                } else if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (dke == hashCode) {
                    this.field_localFlag = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (dkg == hashCode) {
                    this.field_head = cursor.getInt(i);
                } else if (dkh == hashCode) {
                    this.field_localPrivate = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dkj == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (dkk == hashCode) {
                    this.field_likeFlag = cursor.getInt(i);
                } else if (dkl == hashCode) {
                    this.field_pravited = cursor.getInt(i);
                } else if (dkm == hashCode) {
                    this.field_stringSeq = cursor.getString(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (dko == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i);
                } else if (dkp == hashCode) {
                    this.field_postBuf = cursor.getBlob(i);
                } else if (dkq == hashCode) {
                    this.field_adinfo = cursor.getString(i);
                } else if (dkr == hashCode) {
                    this.field_adxml = cursor.getString(i);
                } else if (dks == hashCode) {
                    this.field_createAdTime = cursor.getInt(i);
                } else if (dkt == hashCode) {
                    this.field_exposureTime = cursor.getInt(i);
                } else if (dku == hashCode) {
                    this.field_firstControlTime = cursor.getInt(i);
                } else if (dkv == hashCode) {
                    this.field_recxml = cursor.getString(i);
                } else if (dkw == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (dkx == hashCode) {
                    this.field_exposureCount = cursor.getInt(i);
                } else if (dky == hashCode) {
                    this.field_atAdinfo = cursor.getString(i);
                } else if (dkz == hashCode) {
                    this.field_remindInfoGroup = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djE) {
            contentValues.put("snsId", Long.valueOf(this.field_snsId));
        }
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.djG) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.djH) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.djI) {
            contentValues.put("head", Integer.valueOf(this.field_head));
        }
        if (this.djJ) {
            contentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.djL) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.djM) {
            contentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
        }
        if (this.djN) {
            contentValues.put("pravited", Integer.valueOf(this.field_pravited));
        }
        if (this.djO) {
            contentValues.put("stringSeq", this.field_stringSeq);
        }
        if (this.djP) {
            contentValues.put(C8741b.CONTENT, this.field_content);
        }
        if (this.djQ) {
            contentValues.put("attrBuf", this.field_attrBuf);
        }
        if (this.djR) {
            contentValues.put("postBuf", this.field_postBuf);
        }
        if (this.djS) {
            contentValues.put("adinfo", this.field_adinfo);
        }
        if (this.djT) {
            contentValues.put("adxml", this.field_adxml);
        }
        if (this.djU) {
            contentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
        }
        if (this.djV) {
            contentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
        }
        if (this.djW) {
            contentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
        }
        if (this.djX) {
            contentValues.put("recxml", this.field_recxml);
        }
        if (this.djY) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.djZ) {
            contentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
        }
        if (this.dka) {
            contentValues.put("atAdinfo", this.field_atAdinfo);
        }
        if (this.dkb) {
            contentValues.put("remindInfoGroup", this.field_remindInfoGroup);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
