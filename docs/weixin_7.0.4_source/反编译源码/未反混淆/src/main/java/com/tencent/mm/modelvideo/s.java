package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Map;

public final class s {
    public int bJt = -1;
    public int cFa = 0;
    public String cIS = "";
    public long cKK = 0;
    public String cMW = "";
    public String cMn = "";
    String clientId = "";
    public long createTime = 0;
    public int egF = 0;
    public String fUG = "";
    public int fVG = 0;
    public long fVs = 0;
    public String fWW = "";
    public int fWY = 0;
    public int fWZ = 0;
    public int fXa = 0;
    public long fXb = 0;
    public long fXc = 0;
    public int fXd = 0;
    public int fXe = 0;
    public int fXf = 0;
    public int fXg = 0;
    public int fXh = 0;
    public int fXi = 0;
    public String fXj = "";
    public int fXk = 0;
    public String fXl = "";
    public cfh fXm = new cfh();
    public baa fXn = new baa();
    public String fileName = "";
    public int frO = 0;
    public int status = 0;
    public int videoFormat = 0;

    public s() {
        AppMethodBeat.i(50782);
        AppMethodBeat.o(50782);
    }

    public static String ue(String str) {
        String str2;
        AppMethodBeat.i(50783);
        try {
            Map z = br.z(str, "msg");
            if (z != null) {
                str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
                AppMethodBeat.o(50783);
                return str2;
            }
        } catch (Exception e) {
        }
        str2 = "";
        AppMethodBeat.o(50783);
        return str2;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(50784);
        this.fileName = cursor.getString(0);
        this.clientId = cursor.getString(1);
        this.cKK = cursor.getLong(2);
        this.fVG = cursor.getInt(3);
        this.fWY = cursor.getInt(4);
        this.frO = cursor.getInt(5);
        this.fWZ = cursor.getInt(6);
        this.fXa = cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.createTime = cursor.getLong(9);
        this.fXb = cursor.getLong(10);
        this.fXc = cursor.getLong(11);
        this.fXd = cursor.getInt(12);
        this.fXe = cursor.getInt(13);
        this.fXf = cursor.getInt(14);
        this.fXg = cursor.getInt(15);
        this.cIS = cursor.getString(16);
        this.fWW = cursor.getString(17);
        this.fXh = cursor.getInt(18);
        this.fXi = cursor.getInt(19);
        this.fUG = cursor.getString(20);
        this.fXj = cursor.getString(21);
        this.fXk = cursor.getInt(22);
        this.fVs = cursor.getLong(23);
        this.fXl = cursor.getString(24);
        this.cMW = cursor.getString(25);
        Z(cursor.getBlob(26));
        this.cMn = cursor.getString(27);
        this.egF = cursor.getInt(28);
        aa(cursor.getBlob(29));
        this.cFa = cursor.getInt(30);
        this.videoFormat = cursor.getInt(31);
        AppMethodBeat.o(50784);
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(50785);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("filename", getFileName());
        }
        if ((this.bJt & 2) != 0) {
            String str;
            String str2 = "clientid";
            if (this.clientId == null) {
                str = "";
            } else {
                str = this.clientId;
            }
            contentValues.put(str2, str);
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("msgsvrid", Long.valueOf(this.cKK));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("netoffset", Integer.valueOf(this.fVG));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("filenowsize", Integer.valueOf(this.fWY));
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.frO));
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("thumbnetoffset", Integer.valueOf(this.fWZ));
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("thumblen", Integer.valueOf(this.fXa));
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("createtime", Long.valueOf(this.createTime));
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("lastmodifytime", Long.valueOf(this.fXb));
        }
        if ((this.bJt & 2048) != 0) {
            contentValues.put("downloadtime", Long.valueOf(this.fXc));
        }
        if ((this.bJt & 4096) != 0) {
            contentValues.put("videolength", Integer.valueOf(this.fXd));
        }
        if ((this.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            contentValues.put("msglocalid", Integer.valueOf(this.fXe));
        }
        if ((this.bJt & 16384) != 0) {
            contentValues.put("nettimes", Integer.valueOf(this.fXf));
        }
        if ((this.bJt & 32768) != 0) {
            contentValues.put("cameratype", Integer.valueOf(this.fXg));
        }
        if ((this.bJt & 65536) != 0) {
            contentValues.put("user", getUser());
        }
        if ((this.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("human", alt());
        }
        if ((this.bJt & 262144) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.fXh));
        }
        if ((this.bJt & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.fXi));
        }
        if ((this.bJt & 1048576) != 0) {
            contentValues.put("reserved3", alv());
        }
        if ((this.bJt & 2097152) != 0) {
            contentValues.put("reserved4", alw());
        }
        if ((this.bJt & 4194304) != 0) {
            contentValues.put("videofuncflag", Integer.valueOf(this.fXk));
        }
        if ((this.bJt & 8388608) != 0) {
            contentValues.put("masssendid", Long.valueOf(this.fVs));
        }
        if ((this.bJt & 16777216) != 0) {
            contentValues.put("masssendlist", this.fXl);
        }
        if ((this.bJt & 33554432) != 0) {
            contentValues.put("videomd5", this.cMW);
        }
        if ((this.bJt & 67108864) != 0) {
            contentValues.put("streamvideo", alu());
        }
        if ((this.bJt & 134217728) != 0) {
            contentValues.put("statextstr", this.cMn);
        }
        if ((this.bJt & 268435456) != 0) {
            contentValues.put("downloadscene", Integer.valueOf(this.egF));
        }
        if ((this.bJt & 536870912) != 0) {
            contentValues.put("mmsightextinfo", alA());
        }
        if ((this.bJt & 1) != 0) {
            contentValues.put("preloadsize", Integer.valueOf(this.cFa));
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("videoformat", Integer.valueOf(this.videoFormat));
        }
        AppMethodBeat.o(50785);
        return contentValues;
    }

    private byte[] alu() {
        AppMethodBeat.i(50786);
        byte[] bArr = new byte[0];
        try {
            bArr = this.fXm.toByteArray();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
        }
        AppMethodBeat.o(50786);
        return bArr;
    }

    private void Z(byte[] bArr) {
        AppMethodBeat.i(50787);
        this.fXm = new cfh();
        try {
            this.fXm.parseFrom(bArr);
            AppMethodBeat.o(50787);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
            AppMethodBeat.o(50787);
        }
    }

    public final String getFileName() {
        return this.fileName == null ? "" : this.fileName;
    }

    public final String getUser() {
        return this.cIS == null ? "" : this.cIS;
    }

    public final String alt() {
        return this.fWW == null ? "" : this.fWW;
    }

    public final String alv() {
        return this.fUG == null ? "" : this.fUG;
    }

    public final String alw() {
        return this.fXj == null ? "" : this.fXj;
    }

    public final boolean alx() {
        if (this.status == 140 || this.status == 141 || this.status == ErrorCode.NEEDDOWNLOAD_3) {
            return true;
        }
        return false;
    }

    public final boolean aly() {
        if (this.status == 121 || this.status == 122 || this.status == 120 || this.status == 123) {
            return true;
        }
        return false;
    }

    public final boolean alz() {
        if (this.status == 199 || this.status == 199) {
            return true;
        }
        return false;
    }

    private void aa(byte[] bArr) {
        AppMethodBeat.i(50788);
        this.fXn = new baa();
        try {
            this.fXn.parseFrom(bArr);
            AppMethodBeat.o(50788);
        } catch (Exception e) {
            AppMethodBeat.o(50788);
        }
    }

    private byte[] alA() {
        AppMethodBeat.i(50789);
        byte[] bArr = new byte[0];
        try {
            bArr = this.fXn.toByteArray();
        } catch (Exception e) {
        }
        AppMethodBeat.o(50789);
        return bArr;
    }
}
