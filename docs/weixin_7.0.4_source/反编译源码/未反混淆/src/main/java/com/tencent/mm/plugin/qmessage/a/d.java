package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class d {
    public int bJt = -1;
    String extInfo = "";
    private int fCx = 0;
    private int fne = 0;
    private int frS = 0;
    private int frT = 0;
    private long gwC = 0;
    public int psK = 0;
    public long psL = 0;
    public long psM = 0;
    private String psN = "";
    private String psO = "";
    private String psP = "";
    private String psQ = "";
    public String username = "";

    public d() {
        AppMethodBeat.i(24079);
        AppMethodBeat.o(24079);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(24080);
        this.username = cursor.getString(0);
        this.gwC = cursor.getLong(1);
        this.extInfo = cursor.getString(2);
        this.psK = cursor.getInt(3);
        this.psL = cursor.getLong(4);
        this.psM = cursor.getLong(5);
        this.fne = cursor.getInt(6);
        this.fCx = cursor.getInt(7);
        this.frS = cursor.getInt(8);
        this.frT = cursor.getInt(9);
        this.psN = cursor.getString(10);
        this.psO = cursor.getString(11);
        this.psP = cursor.getString(12);
        this.psQ = cursor.getString(13);
        AppMethodBeat.o(24080);
    }

    public final ContentValues Hl() {
        String str;
        String str2;
        AppMethodBeat.i(24081);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("qq", Long.valueOf(this.gwC));
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put(Constants.EXTINFO, cbY());
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.psK));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("extupdateseq", Long.valueOf(this.psL));
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("imgupdateseq", Long.valueOf(this.psM));
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.fne));
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.fCx));
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.frS));
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.frT));
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            str = "reserved5";
            if (this.psN == null) {
                str2 = "";
            } else {
                str2 = this.psN;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 2048) != 0) {
            str = "reserved6";
            if (this.psO == null) {
                str2 = "";
            } else {
                str2 = this.psO;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 4096) != 0) {
            str = "reserved7";
            if (this.psP == null) {
                str2 = "";
            } else {
                str2 = this.psP;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            str = "reserved8";
            if (this.psQ == null) {
                str2 = "";
            } else {
                str2 = this.psQ;
            }
            contentValues.put(str, str2);
        }
        AppMethodBeat.o(24081);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String cbY() {
        return this.extInfo == null ? "" : this.extInfo;
    }
}
