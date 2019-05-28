package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fw extends c {
    private static final int dID = "versionInfo".hashCode();
    private static final int dJq = "reserved".hashCode();
    private static final int dZQ = "usernameHash".hashCode();
    private static final int dZR = "shortNickname".hashCode();
    private static final int dZS = "roundedSquareIconURL".hashCode();
    private static final int dZT = "bigHeadURL".hashCode();
    private static final int dZU = "smallHeadURL".hashCode();
    private static final int dZV = "appOpt".hashCode();
    private static final int dZW = "registerSource".hashCode();
    private static final int dZX = "appInfo".hashCode();
    private static final int dZY = "bindWxaInfo".hashCode();
    private static final int dZZ = "dynamicInfo".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)"};
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlj = "signature".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dpW = "brandIconURL".hashCode();
    private static final int dqk = "nickname".hashCode();
    private static final int eaa = "syncTimeSecond".hashCode();
    private static final int eab = "syncVersion".hashCode();
    private static final int eac = "bizMenu".hashCode();
    private boolean dIy = true;
    private boolean dJk = true;
    private boolean dZD = true;
    private boolean dZE = true;
    private boolean dZF = true;
    private boolean dZG = true;
    private boolean dZH = true;
    private boolean dZI = true;
    private boolean dZJ = true;
    private boolean dZK = true;
    private boolean dZL = true;
    private boolean dZM = true;
    private boolean dZN = true;
    private boolean dZO = true;
    private boolean dZP = true;
    private boolean dkE = true;
    private boolean dkS = true;
    private boolean dlm = true;
    private boolean dpI = true;
    private boolean dqg = true;
    public String field_appId;
    public String field_appInfo;
    public int field_appOpt;
    public String field_bigHeadURL;
    public String field_bindWxaInfo;
    public String field_bizMenu;
    public String field_brandIconURL;
    public String field_dynamicInfo;
    public String field_nickname;
    public String field_registerSource;
    public String field_reserved;
    public String field_roundedSquareIconURL;
    public String field_shortNickname;
    public String field_signature;
    public String field_smallHeadURL;
    public long field_syncTimeSecond;
    public String field_syncVersion;
    public String field_username;
    public int field_usernameHash;
    public String field_versionInfo;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dZQ == hashCode) {
                    this.field_usernameHash = cursor.getInt(i);
                    this.dZD = true;
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dqk == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (dZR == hashCode) {
                    this.field_shortNickname = cursor.getString(i);
                } else if (dpW == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (dZS == hashCode) {
                    this.field_roundedSquareIconURL = cursor.getString(i);
                } else if (dZT == hashCode) {
                    this.field_bigHeadURL = cursor.getString(i);
                } else if (dZU == hashCode) {
                    this.field_smallHeadURL = cursor.getString(i);
                } else if (dlj == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (dZV == hashCode) {
                    this.field_appOpt = cursor.getInt(i);
                } else if (dZW == hashCode) {
                    this.field_registerSource = cursor.getString(i);
                } else if (dZX == hashCode) {
                    this.field_appInfo = cursor.getString(i);
                } else if (dID == hashCode) {
                    this.field_versionInfo = cursor.getString(i);
                } else if (dZY == hashCode) {
                    this.field_bindWxaInfo = cursor.getString(i);
                } else if (dZZ == hashCode) {
                    this.field_dynamicInfo = cursor.getString(i);
                } else if (dJq == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (eaa == hashCode) {
                    this.field_syncTimeSecond = cursor.getLong(i);
                } else if (eab == hashCode) {
                    this.field_syncVersion = cursor.getString(i);
                } else if (eac == hashCode) {
                    this.field_bizMenu = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dZD) {
            contentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dqg) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.dZE) {
            contentValues.put("shortNickname", this.field_shortNickname);
        }
        if (this.dpI) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.dZF) {
            contentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
        }
        if (this.dZG) {
            contentValues.put("bigHeadURL", this.field_bigHeadURL);
        }
        if (this.dZH) {
            contentValues.put("smallHeadURL", this.field_smallHeadURL);
        }
        if (this.dkS) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.dZI) {
            contentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
        }
        if (this.dZJ) {
            contentValues.put("registerSource", this.field_registerSource);
        }
        if (this.dZK) {
            contentValues.put("appInfo", this.field_appInfo);
        }
        if (this.dIy) {
            contentValues.put("versionInfo", this.field_versionInfo);
        }
        if (this.dZL) {
            contentValues.put("bindWxaInfo", this.field_bindWxaInfo);
        }
        if (this.dZM) {
            contentValues.put("dynamicInfo", this.field_dynamicInfo);
        }
        if (this.dJk) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.dZN) {
            contentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
        }
        if (this.dZO) {
            contentValues.put("syncVersion", this.field_syncVersion);
        }
        if (this.dZP) {
            contentValues.put("bizMenu", this.field_bizMenu);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
