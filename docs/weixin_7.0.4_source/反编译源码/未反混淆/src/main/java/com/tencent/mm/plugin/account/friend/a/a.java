package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class a {
    String bCu = "";
    public int bJt = -1;
    private String cvZ = "";
    public String dtV = "";
    public String eBb = "";
    public String frQ = "";
    public int frT = 0;
    public String guC = "";
    long guD = 0;
    public String guE = "";
    public String guF = "";
    String guG = "";
    String guH = "";
    public String guI = "";
    public int guJ = 0;
    public byte[] guK;
    public int guL;
    public String guM = "";
    public int guN = 0;
    public String guO = "";
    public String guP = "";
    public String guQ = "";
    int guR = 0;
    public String guS = "";
    int guT = 0;
    int guU = 0;
    String guV = "";
    public String guW = "";
    String guX = "";
    int guY = -1;
    String guZ = "";
    long gva = -1;
    int gvb = -1;
    String gvc = "";
    String gvd = "";
    String gve = "";
    public long gvf = 0;
    private int id = 0;
    public int status = 0;
    public int type = 0;
    public String username = "";

    public a() {
        AppMethodBeat.i(108301);
        AppMethodBeat.o(108301);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(108302);
        vS(cursor.getString(1));
        this.guC = cursor.getString(2);
        this.guD = cursor.getLong(3);
        this.eBb = cursor.getString(4);
        this.guE = cursor.getString(5);
        this.guF = cursor.getString(6);
        this.username = cursor.getString(7);
        this.bCu = cursor.getString(8);
        this.guG = cursor.getString(9);
        this.guH = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.guI = cursor.getString(12);
        this.dtV = cursor.getString(13);
        int i = cursor.getInt(14);
        if (i == 65536) {
            this.status = 0;
        } else {
            this.status = i;
        }
        this.guJ = cursor.getInt(17);
        this.frQ = cursor.getString(15);
        this.frT = cursor.getInt(18);
        this.guK = cursor.getBlob(19);
        if (!bo.cb(this.guK)) {
            ah(this.guK);
        }
        this.guL = cursor.getInt(20);
        AppMethodBeat.o(108302);
    }

    private void ah(byte[] bArr) {
        AppMethodBeat.i(108303);
        try {
            y yVar = new y();
            int bX = yVar.bX(bArr);
            if (bX != 0) {
                ab.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(bX)));
                AppMethodBeat.o(108303);
                return;
            }
            this.guM = yVar.getString();
            this.guN = yVar.getInt();
            this.guO = yVar.getString();
            this.guP = yVar.getString();
            this.guQ = yVar.getString();
            this.guR = yVar.getInt();
            this.guS = yVar.getString();
            this.guT = yVar.getInt();
            this.guU = yVar.getInt();
            this.guV = yVar.getString();
            this.guW = yVar.getString();
            this.guX = yVar.getString();
            this.guY = yVar.getInt();
            this.guZ = yVar.getString();
            this.gva = yVar.getLong();
            this.gvb = yVar.getInt();
            this.gvc = yVar.getString();
            this.gvd = yVar.getString();
            this.gve = yVar.getString();
            this.gvf = yVar.getLong();
            AppMethodBeat.o(108303);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            AppMethodBeat.o(108303);
        }
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(108304);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("id", Integer.valueOf(this.id));
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("md5", Aq());
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("peopleid", apz());
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.guD));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("realname", apA());
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("realnamepyinitial", apB());
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("realnamequanpin", apC());
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("nickname", apD());
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("nicknamepyinitial", apE());
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("nicknamequanpin", apF());
        }
        if ((this.bJt & 2048) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.bJt & 4096) != 0) {
            contentValues.put("moblie", apG());
        }
        if ((this.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            contentValues.put(Scopes.EMAIL, getEmail());
        }
        if ((this.bJt & 16384) != 0) {
            int i = this.status;
            if (i == 0) {
                contentValues.put("status", Integer.valueOf(65536));
            } else {
                contentValues.put("status", Integer.valueOf(i));
            }
        }
        if ((this.bJt & 32768) != 0) {
            contentValues.put("reserved1", this.frQ);
        }
        if ((this.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.guJ));
        }
        if ((this.bJt & 262144) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.frT));
        }
        if ((this.bJt & SQLiteGlobal.journalSizeLimit) != 0) {
            this.guK = apy();
            contentValues.put("lvbuf", this.guK);
        }
        if ((this.bJt & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.guL));
        }
        AppMethodBeat.o(108304);
        return contentValues;
    }

    private byte[] apy() {
        AppMethodBeat.i(108305);
        try {
            y yVar = new y();
            yVar.dog();
            yVar.amu(this.guM);
            yVar.LY(this.guN);
            yVar.amu(this.guO);
            yVar.amu(this.guP);
            yVar.amu(this.guQ);
            yVar.LY(this.guR);
            yVar.amu(this.guS);
            yVar.LY(this.guT);
            yVar.LY(this.guU);
            yVar.amu(this.guV);
            yVar.amu(this.guW);
            yVar.amu(this.guX);
            yVar.LY(this.guY);
            yVar.amu(this.guZ);
            yVar.mq(this.gva);
            yVar.LY(this.gvb);
            yVar.amu(this.gvc);
            yVar.amu(this.gvd);
            yVar.amu(this.gve);
            yVar.mq(this.gvf);
            byte[] doh = yVar.doh();
            AppMethodBeat.o(108305);
            return doh;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            AppMethodBeat.o(108305);
            return null;
        }
    }

    public static int vR(String str) {
        int i = 0;
        AppMethodBeat.i(108306);
        try {
            i = bo.anc("0x" + str.substring(0, 8));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AddrUpload", e, "md5: %s", str);
        }
        AppMethodBeat.o(108306);
        return i;
    }

    public final void vS(String str) {
        AppMethodBeat.i(108307);
        this.cvZ = str;
        this.id = vR(str);
        AppMethodBeat.o(108307);
    }

    public final String Aq() {
        return this.cvZ == null ? "" : this.cvZ;
    }

    public final String apz() {
        return this.guC == null ? "" : this.guC;
    }

    public final String apA() {
        return this.eBb == null ? "" : this.eBb;
    }

    public final String apB() {
        return this.guE == null ? "" : this.guE;
    }

    public final String apC() {
        return this.guF == null ? "" : this.guF;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String apD() {
        return this.bCu == null ? "" : this.bCu;
    }

    public final String apE() {
        return this.guG == null ? "" : this.guG;
    }

    public final String apF() {
        return this.guH == null ? "" : this.guH;
    }

    public final String apG() {
        return this.guI == null ? "" : this.guI;
    }

    public final String getEmail() {
        return this.dtV == null ? "" : this.dtV;
    }

    public final void apH() {
        this.guJ |= 1;
    }

    public final boolean apI() {
        return (this.guJ & 1) == 0;
    }

    public final int Ny() {
        AppMethodBeat.i(108308);
        int i = 32;
        if (!bo.isNullOrNil(apB())) {
            i = apB().charAt(0);
        } else if (!bo.isNullOrNil(apC())) {
            i = apC().charAt(0);
        }
        if (i >= 97 && i <= 122) {
            i = (char) (i - 32);
        } else if (i < 65 || i > 90) {
            i = 123;
        }
        AppMethodBeat.o(108308);
        return i;
    }
}
