package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.sdk.e.c;

public abstract class bu extends c {
    private static final int dCc = "ssidmd5".hashCode();
    private static final int dCd = "ssid".hashCode();
    private static final int dCe = "mid".hashCode();
    private static final int dCf = "connectState".hashCode();
    private static final int dCg = "expiredTime".hashCode();
    private static final int dCh = "wifiType".hashCode();
    private static final int dCi = NativeProtocol.WEB_DIALOG_ACTION.hashCode();
    private static final int dCj = "showUrl".hashCode();
    private static final int dCk = "showWordEn".hashCode();
    private static final int dCl = "showWordCn".hashCode();
    private static final int dCm = "showWordTw".hashCode();
    private static final int dCn = "mac".hashCode();
    private static final int dCo = "verifyResult".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnT = "url".hashCode();
    private boolean dBP = true;
    private boolean dBQ = true;
    private boolean dBR = true;
    private boolean dBS = true;
    private boolean dBT = true;
    private boolean dBU = true;
    private boolean dBV = true;
    private boolean dBW = true;
    private boolean dBX = true;
    private boolean dBY = true;
    private boolean dBZ = true;
    private boolean dCa = true;
    private boolean dCb = true;
    private boolean dnP = true;
    public int field_action;
    public int field_connectState;
    public long field_expiredTime;
    public String field_mac;
    public String field_mid;
    public String field_showUrl;
    public String field_showWordCn;
    public String field_showWordEn;
    public String field_showWordTw;
    public String field_ssid;
    public String field_ssidmd5;
    public String field_url;
    public int field_verifyResult;
    public int field_wifiType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dCc == hashCode) {
                    this.field_ssidmd5 = cursor.getString(i);
                    this.dBP = true;
                } else if (dCd == hashCode) {
                    this.field_ssid = cursor.getString(i);
                } else if (dCe == hashCode) {
                    this.field_mid = cursor.getString(i);
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (dCf == hashCode) {
                    this.field_connectState = cursor.getInt(i);
                } else if (dCg == hashCode) {
                    this.field_expiredTime = cursor.getLong(i);
                } else if (dCh == hashCode) {
                    this.field_wifiType = cursor.getInt(i);
                } else if (dCi == hashCode) {
                    this.field_action = cursor.getInt(i);
                } else if (dCj == hashCode) {
                    this.field_showUrl = cursor.getString(i);
                } else if (dCk == hashCode) {
                    this.field_showWordEn = cursor.getString(i);
                } else if (dCl == hashCode) {
                    this.field_showWordCn = cursor.getString(i);
                } else if (dCm == hashCode) {
                    this.field_showWordTw = cursor.getString(i);
                } else if (dCn == hashCode) {
                    this.field_mac = cursor.getString(i);
                } else if (dCo == hashCode) {
                    this.field_verifyResult = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dBP) {
            contentValues.put("ssidmd5", this.field_ssidmd5);
        }
        if (this.dBQ) {
            contentValues.put("ssid", this.field_ssid);
        }
        if (this.dBR) {
            contentValues.put("mid", this.field_mid);
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.dBS) {
            contentValues.put("connectState", Integer.valueOf(this.field_connectState));
        }
        if (this.dBT) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.dBU) {
            contentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
        }
        if (this.dBV) {
            contentValues.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(this.field_action));
        }
        if (this.dBW) {
            contentValues.put("showUrl", this.field_showUrl);
        }
        if (this.dBX) {
            contentValues.put("showWordEn", this.field_showWordEn);
        }
        if (this.dBY) {
            contentValues.put("showWordCn", this.field_showWordCn);
        }
        if (this.dBZ) {
            contentValues.put("showWordTw", this.field_showWordTw);
        }
        if (this.dCa) {
            contentValues.put("mac", this.field_mac);
        }
        if (this.dCb) {
            contentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
