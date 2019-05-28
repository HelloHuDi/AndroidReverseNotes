package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5069y;

/* renamed from: com.tencent.mm.g.c.ce */
public abstract class C37841ce extends C4925c {
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

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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
                    C5069y c5069y = new C5069y();
                    int bX = c5069y.mo10393bX(this.field_lvbuffer);
                    if (bX != 0) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(bX)));
                        return;
                    }
                    if (!c5069y.dof()) {
                        this.dFh = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dFi = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dFj = c5069y.getLong();
                    }
                    if (!c5069y.dof()) {
                        this.dFk = c5069y.getLong();
                    }
                    if (!c5069y.dof()) {
                        this.dFl = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.iconUrl = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.jumpUrl = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dFm = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dFn = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.category = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dFo = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dFp = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dFq = c5069y.getLong();
                    }
                    if (!c5069y.dof()) {
                        this.dFr = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dFs = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dFt = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dFu = c5069y.getString();
                    }
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    /* renamed from: iy */
    public final void mo60557iy(String str) {
        this.dFl = str;
        this.dqp = true;
    }

    /* renamed from: jl */
    public final void mo60558jl(String str) {
        this.iconUrl = str;
        this.dqp = true;
    }

    /* renamed from: jm */
    public final void mo60559jm(String str) {
        this.jumpUrl = str;
        this.dqp = true;
    }

    /* renamed from: jn */
    public final void mo60560jn(String str) {
        this.dFm = str;
        this.dqp = true;
    }

    /* renamed from: jo */
    public final void mo60561jo(String str) {
        this.dFn = str;
        this.dqp = true;
    }

    /* renamed from: jp */
    public final void mo60562jp(String str) {
        this.category = str;
        this.dqp = true;
    }

    /* renamed from: hV */
    public final void mo60555hV(int i) {
        this.dFo = i;
        this.dqp = true;
    }

    /* renamed from: hW */
    public final void mo60556hW(int i) {
        this.dFp = i;
        this.dqp = true;
    }

    /* renamed from: eH */
    public final void mo60554eH(long j) {
        this.dFq = j;
        this.dqp = true;
    }

    /* renamed from: jq */
    public final void mo60563jq(String str) {
        this.dFr = str;
        this.dqp = true;
    }

    /* renamed from: jr */
    public final void mo60564jr(String str) {
        this.dFs = str;
        this.dqp = true;
    }

    /* renamed from: js */
    public final void mo60565js(String str) {
        this.dFt = str;
        this.dqp = true;
    }

    /* renamed from: jt */
    public final void mo60566jt(String str) {
        this.dFu = str;
        this.dqp = true;
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        try {
            if (this.dqp) {
                C5069y c5069y = new C5069y();
                c5069y.dog();
                c5069y.mo10391LY(this.dFh);
                c5069y.mo10391LY(this.dFi);
                c5069y.mo10403mq(this.dFj);
                c5069y.mo10403mq(this.dFk);
                c5069y.amu(this.dFl);
                c5069y.amu(this.iconUrl);
                c5069y.amu(this.jumpUrl);
                c5069y.amu(this.dFm);
                c5069y.amu(this.dFn);
                c5069y.amu(this.category);
                c5069y.mo10391LY(this.dFo);
                c5069y.mo10391LY(this.dFp);
                c5069y.mo10403mq(this.dFq);
                c5069y.amu(this.dFr);
                c5069y.amu(this.dFs);
                c5069y.amu(this.dFt);
                c5069y.amu(this.dFu);
                this.field_lvbuffer = c5069y.doh();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", e.getMessage());
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
