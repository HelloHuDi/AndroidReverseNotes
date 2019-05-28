package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5069y;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

/* renamed from: com.tencent.mm.g.c.s */
public abstract class C26315s extends C4925c {
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

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
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
                    C5069y c5069y = new C5069y();
                    int bX = c5069y.mo10393bX(this.field_lvbuff);
                    if (bX != 0) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(bX)));
                        return;
                    }
                    this.dmY = c5069y.getString();
                    this.dmZ = c5069y.getString();
                    this.dna = c5069y.getString();
                    this.dnb = c5069y.getInt();
                    this.dnc = c5069y.getInt();
                    this.dnd = c5069y.getString();
                    this.dne = c5069y.getString();
                    this.dnf = c5069y.getString();
                    this.dng = c5069y.getString();
                    if (!c5069y.dof()) {
                        this.dnh = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dni = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnj = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dnk = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnl = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnm = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnn = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dno = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnp = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dnq = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnr = c5069y.getInt();
                    }
                    if (!c5069y.dof()) {
                        this.dns = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnt = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnu = c5069y.getString();
                    }
                    if (!c5069y.dof()) {
                        this.dnv = c5069y.getInt();
                    }
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    /* renamed from: if */
    public final void mo44074if(String str) {
        this.dmY = str;
        this.dmv = true;
    }

    /* renamed from: ig */
    public final void mo44075ig(String str) {
        this.dmZ = str;
        this.dmv = true;
    }

    /* renamed from: Hn */
    public final String mo44068Hn() {
        return this.dna;
    }

    /* renamed from: ih */
    public final void mo44076ih(String str) {
        this.dna = str;
        this.dmv = true;
    }

    /* renamed from: ii */
    public final void mo44077ii(String str) {
        this.dnd = str;
        this.dmv = true;
    }

    /* renamed from: ij */
    public final void mo44078ij(String str) {
        this.dne = str;
        this.dmv = true;
    }

    /* renamed from: Ho */
    public final String mo44069Ho() {
        return this.dnf;
    }

    /* renamed from: ik */
    public final void mo44079ik(String str) {
        this.dnf = str;
        this.dmv = true;
    }

    /* renamed from: Hp */
    public final String mo44070Hp() {
        return this.dng;
    }

    /* renamed from: il */
    public final void mo44080il(String str) {
        this.dng = str;
        this.dmv = true;
    }

    /* renamed from: im */
    public final void mo44081im(String str) {
        this.dnh = str;
        this.dmv = true;
    }

    /* renamed from: in */
    public final void mo44082in(String str) {
        this.dni = str;
        this.dmv = true;
    }

    /* renamed from: hq */
    public final void mo44071hq(int i) {
        this.dnj = i;
        this.dmv = true;
    }

    /* renamed from: io */
    public final void mo44083io(String str) {
        this.dnk = str;
        this.dmv = true;
    }

    /* renamed from: ip */
    public final void mo44084ip(String str) {
        this.dnl = str;
        this.dmv = true;
    }

    /* renamed from: iq */
    public final void mo44085iq(String str) {
        this.dnm = str;
        this.dmv = true;
    }

    /* renamed from: ir */
    public final void mo44086ir(String str) {
        this.dnn = str;
        this.dmv = true;
    }

    /* renamed from: is */
    public final void mo44087is(String str) {
        this.dno = str;
        this.dmv = true;
    }

    /* renamed from: hr */
    public final void mo44072hr(int i) {
        this.dnp = i;
        this.dmv = true;
    }

    /* renamed from: it */
    public final void mo44088it(String str) {
        this.dnq = str;
        this.dmv = true;
    }

    /* renamed from: iu */
    public final void mo44089iu(String str) {
        this.dns = str;
        this.dmv = true;
    }

    /* renamed from: iv */
    public final void mo44090iv(String str) {
        this.dnt = str;
        this.dmv = true;
    }

    /* renamed from: iw */
    public final void mo44091iw(String str) {
        this.dnu = str;
        this.dmv = true;
    }

    /* renamed from: hs */
    public final void mo44073hs(int i) {
        this.dnv = i;
        this.dmv = true;
    }

    /* renamed from: Hl */
    public ContentValues mo10098Hl() {
        try {
            if (this.dmv) {
                C5069y c5069y = new C5069y();
                c5069y.dog();
                c5069y.amu(this.dmY);
                c5069y.amu(this.dmZ);
                c5069y.amu(this.dna);
                c5069y.mo10391LY(this.dnb);
                c5069y.mo10391LY(this.dnc);
                c5069y.amu(this.dnd);
                c5069y.amu(this.dne);
                c5069y.amu(this.dnf);
                c5069y.amu(this.dng);
                c5069y.amu(this.dnh);
                c5069y.amu(this.dni);
                c5069y.mo10391LY(this.dnj);
                c5069y.amu(this.dnk);
                c5069y.amu(this.dnl);
                c5069y.amu(this.dnm);
                c5069y.amu(this.dnn);
                c5069y.amu(this.dno);
                c5069y.mo10391LY(this.dnp);
                c5069y.amu(this.dnq);
                c5069y.mo10391LY(this.dnr);
                c5069y.amu(this.dns);
                c5069y.amu(this.dnt);
                c5069y.amu(this.dnu);
                c5069y.mo10391LY(this.dnv);
                this.field_lvbuff = c5069y.doh();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", e.getMessage());
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
