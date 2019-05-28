package com.tencent.mm.at;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class e {
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

    public final void sa(String str) {
        this.fDF = str;
        this.fEc = true;
    }

    public final void setStatus(int i) {
        this.status = i;
        this.fDV = true;
    }

    public final void lr(int i) {
        this.fDI = i;
        this.fDW = true;
    }

    public final void ls(int i) {
        this.fDG = i;
        this.fDT = true;
    }

    public final void fG(long j) {
        this.fDH = j;
        this.fDU = true;
    }

    public final void fH(long j) {
        this.fDy = j;
        this.fDM = true;
    }

    public final void eI(long j) {
        if (this.cKK != j) {
            this.fDN = true;
        }
        this.cKK = j;
    }

    public final void setOffset(int i) {
        int i2 = 0;
        AppMethodBeat.i(78192);
        if (this.offset != i) {
            this.fDO = true;
        }
        this.offset = i;
        ab.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i), Long.valueOf(this.fDH), Integer.valueOf(this.frO));
        if (i >= this.frO) {
            i2 = 1;
        }
        lw(i2);
        AppMethodBeat.o(78192);
    }

    public final void lt(int i) {
        this.frO = i;
        this.fDP = true;
    }

    public final void sb(String str) {
        this.fDz = str;
        this.fDQ = true;
    }

    public final void sc(String str) {
        this.fDA = str;
        this.fDR = true;
    }

    public final void sd(String str) {
        this.fDB = str;
        this.fDS = true;
    }

    public final void lu(int i) {
        this.fDJ = i;
        this.fDX = true;
    }

    public final void setSource(int i) {
        this.cvd = i;
        this.fDY = true;
    }

    public final void lv(int i) {
        this.fDD = i;
        this.fEe = true;
    }

    public final boolean agP() {
        return this.frO != 0 && this.frO == this.offset;
    }

    public final void se(String str) {
        AppMethodBeat.i(78193);
        if ((this.fDK == null && str != null) || !(this.fDK == null || this.fDK.equals(str))) {
            this.fDZ = true;
        }
        this.fDK = str;
        AppMethodBeat.o(78193);
    }

    public final void agR() {
        this.dJA = 1;
        this.fEa = true;
    }

    public final void sf(String str) {
        this.fDE = str;
        this.fEf = true;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(78194);
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
        AppMethodBeat.o(78194);
    }

    public final void lw(int i) {
        if (this.fDL != i) {
            this.fEb = true;
        }
        this.fDL = i;
    }

    public final void lx(int i) {
        this.fDC = i;
        this.fEd = true;
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(78195);
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
        AppMethodBeat.o(78195);
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
