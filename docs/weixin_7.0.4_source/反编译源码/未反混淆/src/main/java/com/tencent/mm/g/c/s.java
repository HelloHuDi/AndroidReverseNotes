package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class s extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlj = "signature".hashCode();
    private static final int dmB = "appName".hashCode();
    private static final int dmC = "appDiscription".hashCode();
    private static final int dmD = "appIconUrl".hashCode();
    private static final int dmE = "appStoreUrl".hashCode();
    private static final int dmF = "appVersion".hashCode();
    private static final int dmG = "appWatermarkUrl".hashCode();
    private static final int dmH = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int dmI = "modifyTime".hashCode();
    private static final int dmJ = "appName_en".hashCode();
    private static final int dmK = "appName_tw".hashCode();
    private static final int dmL = "appName_hk".hashCode();
    private static final int dmM = "appDiscription_en".hashCode();
    private static final int dmN = "appDiscription_tw".hashCode();
    private static final int dmO = "appType".hashCode();
    private static final int dmP = "openId".hashCode();
    private static final int dmQ = "authFlag".hashCode();
    private static final int dmR = "appInfoFlag".hashCode();
    private static final int dmS = "lvbuff".hashCode();
    private static final int dmT = "serviceAppType".hashCode();
    private static final int dmU = "serviceAppInfoFlag".hashCode();
    private static final int dmV = "serviceShowFlag".hashCode();
    private static final int dmW = "appSupportContentType".hashCode();
    private static final int dmX = "svrAppSupportContentType".hashCode();
    private boolean diU = true;
    private boolean dkE = true;
    private boolean dkS = true;
    private boolean dmA = true;
    public String dmY;
    public String dmZ;
    private boolean dme = true;
    private boolean dmf = true;
    private boolean dmg = true;
    private boolean dmh = true;
    private boolean dmi = true;
    private boolean dmj = true;
    private boolean dmk = true;
    private boolean dml = true;
    private boolean dmm = true;
    private boolean dmn = true;
    private boolean dmo = true;
    private boolean dmp = true;
    private boolean dmq = true;
    private boolean dmr = true;
    private boolean dms = true;
    private boolean dmt = true;
    private boolean dmu = true;
    public boolean dmv = true;
    private boolean dmw = true;
    private boolean dmx = true;
    private boolean dmy = true;
    private boolean dmz = true;
    public String dna;
    public int dnb;
    public int dnc;
    public String dnd;
    public String dne;
    public String dnf;
    public String dng;
    public String dnh;
    public String dni;
    public int dnj;
    public String dnk;
    public String dnl;
    public String dnm;
    public String dnn;
    private String dno;
    public int dnp;
    private String dnq;
    private int dnr;
    public String dns;
    public String dnt;
    public String dnu;
    public int dnv;
    public String field_appDiscription;
    public String field_appDiscription_en;
    public String field_appDiscription_tw;
    public String field_appIconUrl;
    public String field_appId;
    public int field_appInfoFlag;
    public String field_appName;
    public String field_appName_en;
    public String field_appName_hk;
    public String field_appName_tw;
    public String field_appStoreUrl;
    public long field_appSupportContentType;
    public String field_appType;
    public int field_appVersion;
    public String field_appWatermarkUrl;
    public int field_authFlag;
    public byte[] field_lvbuff;
    public long field_modifyTime;
    public String field_openId;
    public String field_packageName;
    public int field_serviceAppInfoFlag;
    public int field_serviceAppType;
    public int field_serviceShowFlag;
    public String field_signature;
    public int field_status;
    public long field_svrAppSupportContentType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.dkE = true;
                } else if (dmB == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (dmC == hashCode) {
                    this.field_appDiscription = cursor.getString(i);
                } else if (dmD == hashCode) {
                    this.field_appIconUrl = cursor.getString(i);
                } else if (dmE == hashCode) {
                    this.field_appStoreUrl = cursor.getString(i);
                } else if (dmF == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (dmG == hashCode) {
                    this.field_appWatermarkUrl = cursor.getString(i);
                } else if (dmH == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dlj == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (dmI == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (dmJ == hashCode) {
                    this.field_appName_en = cursor.getString(i);
                } else if (dmK == hashCode) {
                    this.field_appName_tw = cursor.getString(i);
                } else if (dmL == hashCode) {
                    this.field_appName_hk = cursor.getString(i);
                } else if (dmM == hashCode) {
                    this.field_appDiscription_en = cursor.getString(i);
                } else if (dmN == hashCode) {
                    this.field_appDiscription_tw = cursor.getString(i);
                } else if (dmO == hashCode) {
                    this.field_appType = cursor.getString(i);
                } else if (dmP == hashCode) {
                    this.field_openId = cursor.getString(i);
                } else if (dmQ == hashCode) {
                    this.field_authFlag = cursor.getInt(i);
                } else if (dmR == hashCode) {
                    this.field_appInfoFlag = cursor.getInt(i);
                } else if (dmS == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (dmT == hashCode) {
                    this.field_serviceAppType = cursor.getInt(i);
                } else if (dmU == hashCode) {
                    this.field_serviceAppInfoFlag = cursor.getInt(i);
                } else if (dmV == hashCode) {
                    this.field_serviceShowFlag = cursor.getInt(i);
                } else if (dmW == hashCode) {
                    this.field_appSupportContentType = cursor.getLong(i);
                } else if (dmX == hashCode) {
                    this.field_svrAppSupportContentType = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    y yVar = new y();
                    int bX = yVar.bX(this.field_lvbuff);
                    if (bX != 0) {
                        ab.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(bX)));
                        return;
                    }
                    this.dmY = yVar.getString();
                    this.dmZ = yVar.getString();
                    this.dna = yVar.getString();
                    this.dnb = yVar.getInt();
                    this.dnc = yVar.getInt();
                    this.dnd = yVar.getString();
                    this.dne = yVar.getString();
                    this.dnf = yVar.getString();
                    this.dng = yVar.getString();
                    if (!yVar.dof()) {
                        this.dnh = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dni = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnj = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dnk = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnl = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnm = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnn = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dno = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnp = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dnq = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnr = yVar.getInt();
                    }
                    if (!yVar.dof()) {
                        this.dns = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnt = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnu = yVar.getString();
                    }
                    if (!yVar.dof()) {
                        this.dnv = yVar.getInt();
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    /* renamed from: if */
    public final void m12if(String str) {
        this.dmY = str;
        this.dmv = true;
    }

    public final void ig(String str) {
        this.dmZ = str;
        this.dmv = true;
    }

    public final String Hn() {
        return this.dna;
    }

    public final void ih(String str) {
        this.dna = str;
        this.dmv = true;
    }

    public final void ii(String str) {
        this.dnd = str;
        this.dmv = true;
    }

    public final void ij(String str) {
        this.dne = str;
        this.dmv = true;
    }

    public final String Ho() {
        return this.dnf;
    }

    public final void ik(String str) {
        this.dnf = str;
        this.dmv = true;
    }

    public final String Hp() {
        return this.dng;
    }

    public final void il(String str) {
        this.dng = str;
        this.dmv = true;
    }

    public final void im(String str) {
        this.dnh = str;
        this.dmv = true;
    }

    public final void in(String str) {
        this.dni = str;
        this.dmv = true;
    }

    public final void hq(int i) {
        this.dnj = i;
        this.dmv = true;
    }

    public final void io(String str) {
        this.dnk = str;
        this.dmv = true;
    }

    public final void ip(String str) {
        this.dnl = str;
        this.dmv = true;
    }

    public final void iq(String str) {
        this.dnm = str;
        this.dmv = true;
    }

    public final void ir(String str) {
        this.dnn = str;
        this.dmv = true;
    }

    public final void is(String str) {
        this.dno = str;
        this.dmv = true;
    }

    public final void hr(int i) {
        this.dnp = i;
        this.dmv = true;
    }

    public final void it(String str) {
        this.dnq = str;
        this.dmv = true;
    }

    public final void iu(String str) {
        this.dns = str;
        this.dmv = true;
    }

    public final void iv(String str) {
        this.dnt = str;
        this.dmv = true;
    }

    public final void iw(String str) {
        this.dnu = str;
        this.dmv = true;
    }

    public final void hs(int i) {
        this.dnv = i;
        this.dmv = true;
    }

    public ContentValues Hl() {
        try {
            if (this.dmv) {
                y yVar = new y();
                yVar.dog();
                yVar.amu(this.dmY);
                yVar.amu(this.dmZ);
                yVar.amu(this.dna);
                yVar.LY(this.dnb);
                yVar.LY(this.dnc);
                yVar.amu(this.dnd);
                yVar.amu(this.dne);
                yVar.amu(this.dnf);
                yVar.amu(this.dng);
                yVar.amu(this.dnh);
                yVar.amu(this.dni);
                yVar.LY(this.dnj);
                yVar.amu(this.dnk);
                yVar.amu(this.dnl);
                yVar.amu(this.dnm);
                yVar.amu(this.dnn);
                yVar.amu(this.dno);
                yVar.LY(this.dnp);
                yVar.amu(this.dnq);
                yVar.LY(this.dnr);
                yVar.amu(this.dns);
                yVar.amu(this.dnt);
                yVar.amu(this.dnu);
                yVar.LY(this.dnv);
                this.field_lvbuff = yVar.doh();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dme) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.dmf) {
            contentValues.put("appDiscription", this.field_appDiscription);
        }
        if (this.dmg) {
            contentValues.put("appIconUrl", this.field_appIconUrl);
        }
        if (this.dmh) {
            contentValues.put("appStoreUrl", this.field_appStoreUrl);
        }
        if (this.dmi) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.dmj) {
            contentValues.put("appWatermarkUrl", this.field_appWatermarkUrl);
        }
        if (this.dmk) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dkS) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.dml) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.dmm) {
            contentValues.put("appName_en", this.field_appName_en);
        }
        if (this.dmn) {
            contentValues.put("appName_tw", this.field_appName_tw);
        }
        if (this.dmo) {
            contentValues.put("appName_hk", this.field_appName_hk);
        }
        if (this.dmp) {
            contentValues.put("appDiscription_en", this.field_appDiscription_en);
        }
        if (this.dmq) {
            contentValues.put("appDiscription_tw", this.field_appDiscription_tw);
        }
        if (this.dmr) {
            contentValues.put("appType", this.field_appType);
        }
        if (this.dms) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.dmt) {
            contentValues.put("authFlag", Integer.valueOf(this.field_authFlag));
        }
        if (this.dmu) {
            contentValues.put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
        }
        if (this.dmv) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.dmw) {
            contentValues.put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
        }
        if (this.dmx) {
            contentValues.put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
        }
        if (this.dmy) {
            contentValues.put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
        }
        if (this.dmz) {
            contentValues.put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
        }
        if (this.dmA) {
            contentValues.put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
