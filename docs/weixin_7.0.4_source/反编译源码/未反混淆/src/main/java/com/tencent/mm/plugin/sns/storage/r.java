package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;

public final class r {
    long createTime;
    private int guJ;
    public int offset;
    public int reX;
    private long rfC;
    public int rfD;
    public String rfE;
    private int rfF;
    private long rfG;
    public String rfH;
    public byte[] rfI;
    public int type;
    private String userName;

    public final ContentValues cro() {
        AppMethodBeat.i(37976);
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqId", Long.valueOf(this.rfC));
        contentValues.put("type", Integer.valueOf(this.type));
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("userName", this.userName);
        contentValues.put("totallen", Integer.valueOf(this.rfD));
        contentValues.put("offset", Integer.valueOf(this.offset));
        contentValues.put("local_flag", Integer.valueOf(this.guJ));
        contentValues.put("tmp_path", this.rfE);
        contentValues.put("nums", Integer.valueOf(this.rfF));
        contentValues.put("try_times", Long.valueOf(this.rfG));
        contentValues.put("StrId", this.rfH);
        contentValues.put("upload_buf", this.rfI);
        AppMethodBeat.o(37976);
        return contentValues;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(37977);
        this.reX = cursor.getInt(0);
        long j = cursor.getLong(1);
        this.rfC = j;
        this.rfH = i.jV(j);
        this.type = cursor.getInt(2);
        this.createTime = cursor.getLong(3);
        this.userName = cursor.getString(4);
        this.rfD = cursor.getInt(5);
        this.offset = cursor.getInt(6);
        this.guJ = cursor.getInt(7);
        this.rfE = cursor.getString(8);
        this.rfF = cursor.getInt(9);
        this.rfG = cursor.getLong(10);
        this.rfH = cursor.getString(11);
        this.rfI = cursor.getBlob(12);
        AppMethodBeat.o(37977);
    }

    public final void crp() {
        this.guJ |= 4;
    }

    public final void crq() {
        this.guJ &= -5;
    }
}
