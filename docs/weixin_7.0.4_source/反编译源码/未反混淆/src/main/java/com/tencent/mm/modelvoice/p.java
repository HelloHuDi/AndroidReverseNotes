package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class p {
    public int bJt = -1;
    public String cIS = "";
    public long cKK = 0;
    public String clientId = "";
    public long createTime = 0;
    int dqI = 0;
    String dqJ = "";
    public int fVG = 0;
    public String fWW = "";
    public int fWY = 0;
    public long fXb = 0;
    public int fXe = 0;
    int fXf = 0;
    String fYX = "";
    int fZe = 0;
    public String fileName = "";
    public int frO = 0;
    public int gaf = 0;
    int gag = 0;
    long gah = 0;
    int gai = 0;
    public int status = 0;

    public final boolean amd() {
        if (this.status == 5 || this.status == 6) {
            return true;
        }
        return false;
    }

    public final boolean ame() {
        if ((this.status <= 1 || this.status > 3) && this.status != 8) {
            return false;
        }
        return true;
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(116611);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("FileName", this.fileName);
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("User", this.cIS);
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("MsgId", Long.valueOf(this.cKK));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("NetOffset", Integer.valueOf(this.fVG));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("FileNowSize", Integer.valueOf(this.fWY));
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("TotalLen", Integer.valueOf(this.frO));
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("Status", Integer.valueOf(this.status));
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("CreateTime", Long.valueOf(this.createTime));
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("LastModifyTime", Long.valueOf(this.fXb));
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("ClientId", this.clientId);
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("VoiceLength", Integer.valueOf(this.gaf));
        }
        if ((this.bJt & 2048) != 0) {
            contentValues.put("MsgLocalId", Integer.valueOf(this.fXe));
        }
        if ((this.bJt & 4096) != 0) {
            contentValues.put("Human", this.fWW);
        }
        if ((this.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.fXf));
        }
        if ((this.bJt & 16384) != 0) {
            contentValues.put("reserved2", this.fYX);
        }
        if ((this.bJt & 32768) != 0) {
            contentValues.put("MsgSource", this.dqJ);
        }
        if ((this.bJt & 65536) != 0) {
            contentValues.put("MsgFlag", Integer.valueOf(this.dqI));
        }
        if ((this.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("MsgSeq", Integer.valueOf(this.gag));
        }
        if ((this.bJt & 262144) != 0) {
            contentValues.put("MasterBufId", Long.valueOf(this.gah));
        }
        if ((this.bJt & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("checksum", Integer.valueOf(this.gai));
        }
        AppMethodBeat.o(116611);
        return contentValues;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(116612);
        this.fileName = cursor.getString(0);
        this.cIS = cursor.getString(1);
        this.cKK = cursor.getLong(2);
        this.fVG = cursor.getInt(3);
        this.fWY = cursor.getInt(4);
        this.frO = cursor.getInt(5);
        this.status = cursor.getInt(6);
        this.createTime = cursor.getLong(7);
        this.fXb = cursor.getLong(8);
        this.clientId = cursor.getString(9);
        this.gaf = cursor.getInt(10);
        this.fXe = cursor.getInt(11);
        this.fWW = cursor.getString(12);
        this.fXf = cursor.getInt(13);
        this.fYX = cursor.getString(14);
        this.dqJ = cursor.getString(15);
        this.dqI = cursor.getInt(16);
        this.gag = cursor.getInt(17);
        this.gah = cursor.getLong(18);
        this.gai = cursor.getInt(19);
        AppMethodBeat.o(116612);
    }

    public p() {
        AppMethodBeat.i(116613);
        AppMethodBeat.o(116613);
    }
}
