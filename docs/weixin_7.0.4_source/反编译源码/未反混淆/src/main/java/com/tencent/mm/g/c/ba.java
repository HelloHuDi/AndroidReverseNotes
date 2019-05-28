package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;

public abstract class ba extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)"};
    private static final int diR = "rowid".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int dlB = "size".hashCode();
    private static final int dmb = "source".hashCode();
    private static final int dwp = "lastUseTime".hashCode();
    private static final int dwt = "idx".hashCode();
    private static final int dxA = "temp".hashCode();
    private static final int dxB = "needupload".hashCode();
    private static final int dxC = "designerID".hashCode();
    private static final int dxD = "thumbUrl".hashCode();
    private static final int dxE = "cdnUrl".hashCode();
    private static final int dxF = "encrypturl".hashCode();
    private static final int dxG = "aeskey".hashCode();
    private static final int dxH = "width".hashCode();
    private static final int dxI = "height".hashCode();
    private static final int dxJ = "externUrl".hashCode();
    private static final int dxK = "externMd5".hashCode();
    private static final int dxL = "activityid".hashCode();
    private static final int dxM = "tpurl".hashCode();
    private static final int dxN = "tpauthkey".hashCode();
    private static final int dxO = "wxamMd5".hashCode();
    private static final int dxP = "attachedText".hashCode();
    private static final int dxQ = "captureStatus".hashCode();
    private static final int dxR = "attachedEmojiMD5".hashCode();
    private static final int dxS = "imitateMd5".hashCode();
    private static final int dxT = "captureUploadErrCode".hashCode();
    private static final int dxU = "captureUploadCounter".hashCode();
    private static final int dxV = "captureEnterTime".hashCode();
    private static final int dxW = "lensId".hashCode();
    private static final int dxX = "attachTextColor".hashCode();
    private static final int dxY = "captureScene".hashCode();
    private static final int dxn = "md5".hashCode();
    private static final int dxo = "svrid".hashCode();
    private static final int dxp = "catalog".hashCode();
    private static final int dxq = "start".hashCode();
    private static final int dxr = "state".hashCode();
    private static final int dxs = "name".hashCode();
    private static final int dxt = "reserved1".hashCode();
    private static final int dxu = "reserved2".hashCode();
    private static final int dxv = "reserved3".hashCode();
    private static final int dxw = "reserved4".hashCode();
    private static final int dxx = "app_id".hashCode();
    private static final int dxy = "groupId".hashCode();
    private static final int dxz = "framesInfo".hashCode();
    private boolean djK = true;
    private boolean djP = true;
    private boolean dlY = true;
    private boolean dlz = true;
    private boolean dvP = true;
    private boolean dvT = true;
    private boolean dwB = true;
    private boolean dwC = true;
    private boolean dwD = true;
    private boolean dwE = true;
    private boolean dwF = true;
    private boolean dwG = true;
    private boolean dwH = true;
    private boolean dwI = true;
    private boolean dwJ = true;
    private boolean dwK = true;
    private boolean dwL = true;
    private boolean dwM = true;
    private boolean dwN = true;
    private boolean dwO = true;
    private boolean dwP = true;
    private boolean dwQ = true;
    private boolean dwR = true;
    private boolean dwS = true;
    private boolean dwT = true;
    private boolean dwU = true;
    private boolean dwV = true;
    private boolean dwW = true;
    private boolean dwX = true;
    private boolean dwY = true;
    private boolean dwZ = true;
    private boolean dxa = true;
    private boolean dxb = true;
    private boolean dxc = true;
    private boolean dxd = true;
    private boolean dxe = true;
    private boolean dxf = true;
    private boolean dxg = true;
    private boolean dxh = true;
    private boolean dxi = true;
    private boolean dxj = true;
    private boolean dxk = true;
    private boolean dxl = true;
    private boolean dxm = true;
    public String field_activityid;
    public String field_aeskey;
    public String field_app_id;
    public String field_attachTextColor;
    public byte[] field_attachedEmojiMD5;
    public String field_attachedText;
    public long field_captureEnterTime;
    public int field_captureScene;
    public int field_captureStatus;
    public int field_captureUploadCounter;
    public int field_captureUploadErrCode;
    public int field_catalog;
    public String field_cdnUrl;
    public String field_content;
    public String field_designerID;
    public String field_encrypturl;
    public String field_externMd5;
    public String field_externUrl;
    public String field_framesInfo;
    public String field_groupId;
    public int field_height;
    public int field_idx;
    public String field_imitateMd5;
    public long field_lastUseTime;
    public String field_lensId;
    public String field_md5;
    public String field_name;
    public int field_needupload;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public int field_reserved4;
    public int field_size;
    public int field_source;
    public int field_start;
    public int field_state;
    public String field_svrid;
    public int field_temp;
    public String field_thumbUrl;
    public String field_tpauthkey;
    public String field_tpurl;
    public int field_type;
    public int field_width;
    public String field_wxamMd5;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                    this.dwB = true;
                } else if (dxo == hashCode) {
                    this.field_svrid = cursor.getString(i);
                } else if (dxp == hashCode) {
                    this.field_catalog = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dlB == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (dxq == hashCode) {
                    this.field_start = cursor.getInt(i);
                } else if (dxr == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (dxs == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dxt == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (dxu == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (dxv == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (dxw == hashCode) {
                    this.field_reserved4 = cursor.getInt(i);
                } else if (dxx == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (dxy == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (dwp == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (dxz == hashCode) {
                    this.field_framesInfo = cursor.getString(i);
                } else if (dwt == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (dxA == hashCode) {
                    this.field_temp = cursor.getInt(i);
                } else if (dmb == hashCode) {
                    this.field_source = cursor.getInt(i);
                } else if (dxB == hashCode) {
                    this.field_needupload = cursor.getInt(i);
                } else if (dxC == hashCode) {
                    this.field_designerID = cursor.getString(i);
                } else if (dxD == hashCode) {
                    this.field_thumbUrl = cursor.getString(i);
                } else if (dxE == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (dxF == hashCode) {
                    this.field_encrypturl = cursor.getString(i);
                } else if (dxG == hashCode) {
                    this.field_aeskey = cursor.getString(i);
                } else if (dxH == hashCode) {
                    this.field_width = cursor.getInt(i);
                } else if (dxI == hashCode) {
                    this.field_height = cursor.getInt(i);
                } else if (dxJ == hashCode) {
                    this.field_externUrl = cursor.getString(i);
                } else if (dxK == hashCode) {
                    this.field_externMd5 = cursor.getString(i);
                } else if (dxL == hashCode) {
                    this.field_activityid = cursor.getString(i);
                } else if (dxM == hashCode) {
                    this.field_tpurl = cursor.getString(i);
                } else if (dxN == hashCode) {
                    this.field_tpauthkey = cursor.getString(i);
                } else if (dxO == hashCode) {
                    this.field_wxamMd5 = cursor.getString(i);
                } else if (dxP == hashCode) {
                    this.field_attachedText = cursor.getString(i);
                } else if (dxQ == hashCode) {
                    this.field_captureStatus = cursor.getInt(i);
                } else if (dxR == hashCode) {
                    this.field_attachedEmojiMD5 = cursor.getBlob(i);
                } else if (dxS == hashCode) {
                    this.field_imitateMd5 = cursor.getString(i);
                } else if (dxT == hashCode) {
                    this.field_captureUploadErrCode = cursor.getInt(i);
                } else if (dxU == hashCode) {
                    this.field_captureUploadCounter = cursor.getInt(i);
                } else if (dxV == hashCode) {
                    this.field_captureEnterTime = cursor.getLong(i);
                } else if (dxW == hashCode) {
                    this.field_lensId = cursor.getString(i);
                } else if (dxX == hashCode) {
                    this.field_attachTextColor = cursor.getString(i);
                } else if (dxY == hashCode) {
                    this.field_captureScene = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.dwC) {
            contentValues.put("svrid", this.field_svrid);
        }
        if (this.dwD) {
            contentValues.put("catalog", Integer.valueOf(this.field_catalog));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dlz) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.dwE) {
            contentValues.put("start", Integer.valueOf(this.field_start));
        }
        if (this.dwF) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.dwG) {
            contentValues.put("name", this.field_name);
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.dwH) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.dwI) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.dwJ) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.dwK) {
            contentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
        }
        if (this.dwL) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.dwM) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.dvP) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.field_framesInfo == null) {
            this.field_framesInfo = "";
        }
        if (this.dwN) {
            contentValues.put("framesInfo", this.field_framesInfo);
        }
        if (this.dvT) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.dwO) {
            contentValues.put("temp", Integer.valueOf(this.field_temp));
        }
        if (this.dlY) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.dwP) {
            contentValues.put("needupload", Integer.valueOf(this.field_needupload));
        }
        if (this.dwQ) {
            contentValues.put("designerID", this.field_designerID);
        }
        if (this.dwR) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.dwS) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.dwT) {
            contentValues.put("encrypturl", this.field_encrypturl);
        }
        if (this.dwU) {
            contentValues.put("aeskey", this.field_aeskey);
        }
        if (this.dwV) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.dwW) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.dwX) {
            contentValues.put("externUrl", this.field_externUrl);
        }
        if (this.dwY) {
            contentValues.put("externMd5", this.field_externMd5);
        }
        if (this.dwZ) {
            contentValues.put("activityid", this.field_activityid);
        }
        if (this.dxa) {
            contentValues.put("tpurl", this.field_tpurl);
        }
        if (this.dxb) {
            contentValues.put("tpauthkey", this.field_tpauthkey);
        }
        if (this.dxc) {
            contentValues.put("wxamMd5", this.field_wxamMd5);
        }
        if (this.dxd) {
            contentValues.put("attachedText", this.field_attachedText);
        }
        if (this.dxe) {
            contentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
        }
        if (this.dxf) {
            contentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
        }
        if (this.dxg) {
            contentValues.put("imitateMd5", this.field_imitateMd5);
        }
        if (this.dxh) {
            contentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
        }
        if (this.dxi) {
            contentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
        }
        if (this.dxj) {
            contentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
        }
        if (this.dxk) {
            contentValues.put("lensId", this.field_lensId);
        }
        if (this.dxl) {
            contentValues.put("attachTextColor", this.field_attachTextColor);
        }
        if (this.dxm) {
            contentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }

    public void reset() {
    }
}
