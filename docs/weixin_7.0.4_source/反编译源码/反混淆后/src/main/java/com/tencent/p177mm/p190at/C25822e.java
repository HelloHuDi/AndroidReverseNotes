package com.tencent.p177mm.p190at;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.at.e */
public final class C25822e {
    public int bJt = -2;
    public long cKK;
    int cvd;
    public int dJA = 0;
    public String fDA = "";
    public String fDB = "";
    public int fDC;
    public int fDD;
    public String fDE = "";
    private String fDF = "";
    public int fDG;
    public long fDH;
    int fDI;
    public int fDJ = 0;
    public String fDK = "";
    int fDL = 1;
    private boolean fDM;
    private boolean fDN;
    private boolean fDO;
    private boolean fDP;
    private boolean fDQ;
    private boolean fDR;
    private boolean fDS;
    private boolean fDT;
    private boolean fDU;
    private boolean fDV;
    private boolean fDW;
    private boolean fDX;
    private boolean fDY;
    private boolean fDZ;
    public long fDy;
    public String fDz = "";
    private boolean fEa;
    private boolean fEb;
    private boolean fEc;
    private boolean fEd;
    private boolean fEe;
    private boolean fEf;
    public int frO;
    public int offset;
    public int status;

    /* renamed from: sa */
    public final void mo43802sa(String str) {
        this.fDF = str;
        this.fEc = true;
    }

    public final void setStatus(int i) {
        this.status = i;
        this.fDV = true;
    }

    /* renamed from: lr */
    public final void mo43795lr(int i) {
        this.fDI = i;
        this.fDW = true;
    }

    /* renamed from: ls */
    public final void mo43796ls(int i) {
        this.fDG = i;
        this.fDT = true;
    }

    /* renamed from: fG */
    public final void mo43793fG(long j) {
        this.fDH = j;
        this.fDU = true;
    }

    /* renamed from: fH */
    public final void mo43794fH(long j) {
        this.fDy = j;
        this.fDM = true;
    }

    /* renamed from: eI */
    public final void mo43792eI(long j) {
        if (this.cKK != j) {
            this.fDN = true;
        }
        this.cKK = j;
    }

    public final void setOffset(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(78192);
        if (this.offset != i) {
            this.fDO = true;
        }
        this.offset = i;
        C4990ab.m7413e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i), Long.valueOf(this.fDH), Integer.valueOf(this.frO));
        if (i >= this.frO) {
            i2 = 1;
        }
        mo43800lw(i2);
        AppMethodBeat.m2505o(78192);
    }

    /* renamed from: lt */
    public final void mo43797lt(int i) {
        this.frO = i;
        this.fDP = true;
    }

    /* renamed from: sb */
    public final void mo43803sb(String str) {
        this.fDz = str;
        this.fDQ = true;
    }

    /* renamed from: sc */
    public final void mo43804sc(String str) {
        this.fDA = str;
        this.fDR = true;
    }

    /* renamed from: sd */
    public final void mo43805sd(String str) {
        this.fDB = str;
        this.fDS = true;
    }

    /* renamed from: lu */
    public final void mo43798lu(int i) {
        this.fDJ = i;
        this.fDX = true;
    }

    public final void setSource(int i) {
        this.cvd = i;
        this.fDY = true;
    }

    /* renamed from: lv */
    public final void mo43799lv(int i) {
        this.fDD = i;
        this.fEe = true;
    }

    public final boolean agP() {
        return this.frO != 0 && this.frO == this.offset;
    }

    /* renamed from: se */
    public final void mo43806se(String str) {
        AppMethodBeat.m2504i(78193);
        if ((this.fDK == null && str != null) || !(this.fDK == null || this.fDK.equals(str))) {
            this.fDZ = true;
        }
        this.fDK = str;
        AppMethodBeat.m2505o(78193);
    }

    public final void agR() {
        this.dJA = 1;
        this.fEa = true;
    }

    /* renamed from: sf */
    public final void mo43810sf(String str) {
        this.fDE = str;
        this.fEf = true;
    }

    /* renamed from: d */
    public final void mo43791d(Cursor cursor) {
        AppMethodBeat.m2504i(78194);
        this.fDy = (long) cursor.getInt(0);
        this.cKK = cursor.getLong(1);
        this.offset = cursor.getInt(2);
        this.frO = cursor.getInt(3);
        this.fDz = cursor.getString(4);
        this.fDB = cursor.getString(5);
        this.fDG = cursor.getInt(6);
        this.fDH = (long) cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.fDI = cursor.getInt(9);
        this.fDJ = cursor.getInt(10);
        this.cvd = cursor.getInt(11);
        this.fDK = cursor.getString(12);
        this.dJA = cursor.getInt(14);
        this.fDL = cursor.getInt(15);
        this.fDF = cursor.getString(16);
        this.fDC = cursor.getInt(17);
        this.fDA = cursor.getString(18);
        this.fDD = cursor.getInt(19);
        this.fDE = cursor.getString(20);
        AppMethodBeat.m2505o(78194);
    }

    /* renamed from: lw */
    public final void mo43800lw(int i) {
        if (this.fDL != i) {
            this.fEb = true;
        }
        this.fDL = i;
    }

    /* renamed from: lx */
    public final void mo43801lx(int i) {
        this.fDC = i;
        this.fEd = true;
    }

    /* renamed from: Hl */
    public final ContentValues mo43786Hl() {
        AppMethodBeat.m2504i(78195);
        ContentValues contentValues = new ContentValues();
        if (this.fDM) {
            contentValues.put("id", Long.valueOf(this.fDy));
        }
        if (this.fDN) {
            contentValues.put("msgSvrId", Long.valueOf(this.cKK));
        }
        if (this.fDO) {
            contentValues.put("offset", Integer.valueOf(this.offset));
        }
        if (this.fDP) {
            contentValues.put("totalLen", Integer.valueOf(this.frO));
        }
        if (this.fDQ) {
            contentValues.put("bigImgPath", this.fDz);
        }
        if (this.fDR) {
            contentValues.put("midImgPath", this.fDA);
        }
        if (this.fDS) {
            contentValues.put("thumbImgPath", this.fDB);
        }
        if (this.fDT) {
            contentValues.put("createtime", Integer.valueOf(this.fDG));
        }
        if (this.fDU) {
            contentValues.put("msglocalid", Long.valueOf(this.fDH));
        }
        if (this.fDV) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if (this.fDW) {
            contentValues.put("nettimes", Integer.valueOf(this.fDI));
        }
        if (this.fDX) {
            contentValues.put("reserved1", Integer.valueOf(this.fDJ));
        }
        if (this.fDY) {
            contentValues.put("reserved2", Integer.valueOf(this.cvd));
        }
        if (this.fDZ) {
            contentValues.put("reserved3", this.fDK);
        }
        if (this.fEa) {
            contentValues.put("hashdthumb", Integer.valueOf(this.dJA));
        }
        if (this.fEb) {
            contentValues.put("iscomplete", Integer.valueOf(this.offset < this.frO ? 0 : 1));
        }
        if (this.fEc) {
            contentValues.put("origImgMD5", this.fDF);
        }
        if (this.fEd) {
            contentValues.put("compressType", Integer.valueOf(this.fDC));
        }
        if (this.fEe) {
            contentValues.put("forwardType", Integer.valueOf(this.fDD));
        }
        if (this.fEf) {
            contentValues.put("hevcPath", this.fDE);
        }
        AppMethodBeat.m2505o(78195);
        return contentValues;
    }

    public final void agS() {
        this.fDM = false;
        this.fDN = false;
        this.fDO = false;
        this.fDP = false;
        this.fDQ = false;
        this.fDR = false;
        this.fDS = false;
        this.fDT = false;
        this.fDU = false;
        this.fDV = false;
        this.fDW = false;
        this.fDX = false;
        this.fDY = false;
        this.fDZ = false;
        this.fEa = false;
        this.fEb = false;
        this.fEc = false;
        this.fEd = false;
        this.fEe = false;
        this.fEf = false;
    }

    public final boolean agQ() {
        return this.fDJ > 0;
    }
}
