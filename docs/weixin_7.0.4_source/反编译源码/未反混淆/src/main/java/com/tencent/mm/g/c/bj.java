package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.sdk.e.c;

public abstract class bj extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)"};
    private static final int diR = "rowid".hashCode();
    private static final int dqy = "talker".hashCode();
    private static final int dxr = "state".hashCode();
    private static final int dyW = "encryptTalker".hashCode();
    private static final int dyX = "displayName".hashCode();
    private static final int dyY = "lastModifiedTime".hashCode();
    private static final int dyZ = "isNew".hashCode();
    private static final int dza = "addScene".hashCode();
    private static final int dzb = "fmsgSysRowId".hashCode();
    private static final int dzc = "fmsgIsSend".hashCode();
    private static final int dzd = "fmsgType".hashCode();
    private static final int dze = "fmsgContent".hashCode();
    private static final int dzf = "recvFmsgType".hashCode();
    private static final int dzg = "contentFromUsername".hashCode();
    private static final int dzh = "contentNickname".hashCode();
    private static final int dzi = "contentPhoneNumMD5".hashCode();
    private static final int dzj = "contentFullPhoneNumMD5".hashCode();
    private static final int dzk = "contentVerifyContent".hashCode();
    private boolean dqn = true;
    private boolean dwF = true;
    private boolean dyH = true;
    private boolean dyI = true;
    private boolean dyJ = true;
    private boolean dyK = true;
    private boolean dyL = true;
    private boolean dyM = true;
    private boolean dyN = true;
    private boolean dyO = true;
    private boolean dyP = true;
    private boolean dyQ = true;
    private boolean dyR = true;
    private boolean dyS = true;
    private boolean dyT = true;
    private boolean dyU = true;
    private boolean dyV = true;
    public int field_addScene;
    public String field_contentFromUsername;
    public String field_contentFullPhoneNumMD5;
    public String field_contentNickname;
    public String field_contentPhoneNumMD5;
    public String field_contentVerifyContent;
    public String field_displayName;
    public String field_encryptTalker;
    public String field_fmsgContent;
    public int field_fmsgIsSend;
    public long field_fmsgSysRowId;
    public int field_fmsgType;
    public int field_isNew;
    public long field_lastModifiedTime;
    public int field_recvFmsgType;
    public int field_state;
    public String field_talker;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dqy == hashCode) {
                    this.field_talker = cursor.getString(i);
                    this.dqn = true;
                } else if (dyW == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (dyX == hashCode) {
                    this.field_displayName = cursor.getString(i);
                } else if (dxr == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (dyY == hashCode) {
                    this.field_lastModifiedTime = cursor.getLong(i);
                } else if (dyZ == hashCode) {
                    this.field_isNew = cursor.getInt(i);
                } else if (dza == hashCode) {
                    this.field_addScene = cursor.getInt(i);
                } else if (dzb == hashCode) {
                    this.field_fmsgSysRowId = cursor.getLong(i);
                } else if (dzc == hashCode) {
                    this.field_fmsgIsSend = cursor.getInt(i);
                } else if (dzd == hashCode) {
                    this.field_fmsgType = cursor.getInt(i);
                } else if (dze == hashCode) {
                    this.field_fmsgContent = cursor.getString(i);
                } else if (dzf == hashCode) {
                    this.field_recvFmsgType = cursor.getInt(i);
                } else if (dzg == hashCode) {
                    this.field_contentFromUsername = cursor.getString(i);
                } else if (dzh == hashCode) {
                    this.field_contentNickname = cursor.getString(i);
                } else if (dzi == hashCode) {
                    this.field_contentPhoneNumMD5 = cursor.getString(i);
                } else if (dzj == hashCode) {
                    this.field_contentFullPhoneNumMD5 = cursor.getString(i);
                } else if (dzk == hashCode) {
                    this.field_contentVerifyContent = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_talker == null) {
            this.field_talker = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (this.dqn) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.dyH) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.field_displayName == null) {
            this.field_displayName = "";
        }
        if (this.dyI) {
            contentValues.put("displayName", this.field_displayName);
        }
        if (this.dwF) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.dyJ) {
            contentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
        }
        if (this.dyK) {
            contentValues.put("isNew", Integer.valueOf(this.field_isNew));
        }
        if (this.dyL) {
            contentValues.put("addScene", Integer.valueOf(this.field_addScene));
        }
        if (this.dyM) {
            contentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
        }
        if (this.dyN) {
            contentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
        }
        if (this.dyO) {
            contentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
        }
        if (this.field_fmsgContent == null) {
            this.field_fmsgContent = "";
        }
        if (this.dyP) {
            contentValues.put("fmsgContent", this.field_fmsgContent);
        }
        if (this.dyQ) {
            contentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
        }
        if (this.field_contentFromUsername == null) {
            this.field_contentFromUsername = "";
        }
        if (this.dyR) {
            contentValues.put("contentFromUsername", this.field_contentFromUsername);
        }
        if (this.field_contentNickname == null) {
            this.field_contentNickname = "";
        }
        if (this.dyS) {
            contentValues.put("contentNickname", this.field_contentNickname);
        }
        if (this.field_contentPhoneNumMD5 == null) {
            this.field_contentPhoneNumMD5 = "";
        }
        if (this.dyT) {
            contentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
        }
        if (this.field_contentFullPhoneNumMD5 == null) {
            this.field_contentFullPhoneNumMD5 = "";
        }
        if (this.dyU) {
            contentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
        }
        if (this.field_contentVerifyContent == null) {
            this.field_contentVerifyContent = "";
        }
        if (this.dyV) {
            contentValues.put("contentVerifyContent", this.field_contentVerifyContent);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
