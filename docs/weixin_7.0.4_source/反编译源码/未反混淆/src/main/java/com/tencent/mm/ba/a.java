package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    int bJt = -1;
    public int fLV = 0;
    private String frQ = "";
    private String frR = "";
    private int frS = 0;
    private int frT = 0;
    private String path = "";
    public String username = "";

    public a() {
        AppMethodBeat.i(78430);
        AppMethodBeat.o(78430);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(78431);
        this.username = cursor.getString(0);
        this.fLV = cursor.getInt(1);
        this.path = cursor.getString(2);
        this.frQ = cursor.getString(3);
        this.frR = cursor.getString(4);
        this.frS = cursor.getInt(5);
        this.frT = cursor.getInt(6);
        AppMethodBeat.o(78431);
    }

    public final ContentValues Hl() {
        String str;
        String str2;
        AppMethodBeat.i(78432);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("bgflag", Integer.valueOf(this.fLV));
        }
        if ((this.bJt & 4) != 0) {
            str = "path";
            if (this.path == null) {
                str2 = "";
            } else {
                str2 = this.path;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 8) != 0) {
            str = "reserved1";
            if (this.frQ == null) {
                str2 = "";
            } else {
                str2 = this.frQ;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 16) != 0) {
            str = "reserved2";
            if (this.frR == null) {
                str2 = "";
            } else {
                str2 = this.frR;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.frS));
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.frT));
        }
        AppMethodBeat.o(78432);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
