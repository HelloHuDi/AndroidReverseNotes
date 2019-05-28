package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public abstract class ce extends c {
    private static final int dCn = "mac".hashCode();
    private static final int dEW = "deviceID".hashCode();
    private static final int dEX = "brandName".hashCode();
    private static final int dEY = "deviceType".hashCode();
    private static final int dEZ = "connProto".hashCode();
    private static final int dFa = "connStrategy".hashCode();
    private static final int dFb = "closeStrategy".hashCode();
    private static final int dFc = "md5Str".hashCode();
    private static final int dFd = "authKey".hashCode();
    private static final int dFe = "sessionKey".hashCode();
    private static final int dFf = "sessionBuf".hashCode();
    private static final int dFg = "authBuf".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnT = "url".hashCode();
    private static final int dqA = "lvbuffer".hashCode();
    public String category;
    private boolean dCa = true;
    private boolean dEL = true;
    private boolean dEM = true;
    private boolean dEN = true;
    private boolean dEO = true;
    private boolean dEP = true;
    private boolean dEQ = true;
    private boolean dER = true;
    private boolean dES = true;
    private boolean dET = true;
    private boolean dEU = true;
    private boolean dEV = true;
    public int dFh;
    public int dFi;
    public long dFj;
    private long dFk;
    public String dFl;
    public String dFm;
    public String dFn;
    private int dFo;
    public int dFp;
    public long dFq;
    public String dFr;
    public String dFs;
    private String dFt;
    public String dFu;
    private boolean dnP = true;
    public boolean dqp = true;
    public byte[] field_authBuf;
    public String field_authKey;
    public String field_brandName;
    public int field_closeStrategy;
    public String field_connProto;
    public int field_connStrategy;
    public String field_deviceID;
    public String field_deviceType;
    public byte[] field_lvbuffer;
    public long field_mac;
    public String field_md5Str;
    public byte[] field_sessionBuf;
    public byte[] field_sessionKey;
    public String field_url;
    public String iconUrl;
    public String jumpUrl;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dEW == hashCode) {
                    this.field_deviceID = cursor.getString(i);
                    this.dEL = true;
                } else if (dEX == hashCode) {
                    this.field_brandName = cursor.getString(i);
                } else if (dCn == hashCode) {
                    this.field_mac = cursor.getLong(i);
                } else if (dEY == hashCode) {
                    this.field_deviceType = cursor.getString(i);
                } else if (dEZ == hashCode) {
                    this.field_connProto = cursor.getString(i);
                } else if (dFa == hashCode) {
                    this.field_connStrategy = cursor.getInt(i);
                } else if (dFb == hashCode) {
                    this.field_closeStrategy = cursor.getInt(i);
                } else if (dFc == hashCode) {
                    this.field_md5Str = cursor.getString(i);
                } else if (dFd == hashCode) {
                    this.field_authKey = cursor.getString(i);
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (dFe == hashCode) {
                    this.field_sessionKey = cursor.getBlob(i);
                } else if (dFf == hashCode) {
                    this.field_sessionBuf = cursor.getBlob(i);
                } else if (dFg == hashCode) {
                    this.field_authBuf = cursor.getBlob(i);
                } else if (dqA == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    y yVar = new y();
                    int bX = yVar.bX(this.field_lvbuffer);
                    if (bX != 0) {
                        ab.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(bX)));
                        return;
                    }
                    if (!yVar.dof()) {
                        this.dFh = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dFi = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dFj = yVar.getLong();
                    }
                    if (!yVar.dof()) {
                        this.dFk = yVar.getLong();
                    }
                    if (!yVar.dof()) {
                        this.dFl = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.iconUrl = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.jumpUrl = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dFm = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dFn = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.category = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dFo = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dFp = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dFq = yVar.getLong();
                    }
                    if (!yVar.dof()) {
                        this.dFr = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dFs = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dFt = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dFu = yVar.getString();
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    public final void iy(String str) {
        this.dFl = str;
        this.dqp = true;
    }

    public final void jl(String str) {
        this.iconUrl = str;
        this.dqp = true;
    }

    public final void jm(String str) {
        this.jumpUrl = str;
        this.dqp = true;
    }

    public final void jn(String str) {
        this.dFm = str;
        this.dqp = true;
    }

    public final void jo(String str) {
        this.dFn = str;
        this.dqp = true;
    }

    public final void jp(String str) {
        this.category = str;
        this.dqp = true;
    }

    public final void hV(int i) {
        this.dFo = i;
        this.dqp = true;
    }

    public final void hW(int i) {
        this.dFp = i;
        this.dqp = true;
    }

    public final void eH(long j) {
        this.dFq = j;
        this.dqp = true;
    }

    public final void jq(String str) {
        this.dFr = str;
        this.dqp = true;
    }

    public final void jr(String str) {
        this.dFs = str;
        this.dqp = true;
    }

    public final void js(String str) {
        this.dFt = str;
        this.dqp = true;
    }

    public final void jt(String str) {
        this.dFu = str;
        this.dqp = true;
    }

    public final ContentValues Hl() {
        try {
            if (this.dqp) {
                y yVar = new y();
                yVar.dog();
                yVar.LY(this.dFh);
                yVar.LY(this.dFi);
                yVar.mq(this.dFj);
                yVar.mq(this.dFk);
                yVar.amu(this.dFl);
                yVar.amu(this.iconUrl);
                yVar.amu(this.jumpUrl);
                yVar.amu(this.dFm);
                yVar.amu(this.dFn);
                yVar.amu(this.category);
                yVar.LY(this.dFo);
                yVar.LY(this.dFp);
                yVar.mq(this.dFq);
                yVar.amu(this.dFr);
                yVar.amu(this.dFs);
                yVar.amu(this.dFt);
                yVar.amu(this.dFu);
                this.field_lvbuffer = yVar.doh();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.dEL) {
            contentValues.put("deviceID", this.field_deviceID);
        }
        if (this.dEM) {
            contentValues.put("brandName", this.field_brandName);
        }
        if (this.dCa) {
            contentValues.put("mac", Long.valueOf(this.field_mac));
        }
        if (this.dEN) {
            contentValues.put("deviceType", this.field_deviceType);
        }
        if (this.dEO) {
            contentValues.put("connProto", this.field_connProto);
        }
        if (this.dEP) {
            contentValues.put("connStrategy", Integer.valueOf(this.field_connStrategy));
        }
        if (this.dEQ) {
            contentValues.put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
        }
        if (this.dER) {
            contentValues.put("md5Str", this.field_md5Str);
        }
        if (this.dES) {
            contentValues.put("authKey", this.field_authKey);
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.dET) {
            contentValues.put("sessionKey", this.field_sessionKey);
        }
        if (this.dEU) {
            contentValues.put("sessionBuf", this.field_sessionBuf);
        }
        if (this.dEV) {
            contentValues.put("authBuf", this.field_authBuf);
        }
        if (this.dqp) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
