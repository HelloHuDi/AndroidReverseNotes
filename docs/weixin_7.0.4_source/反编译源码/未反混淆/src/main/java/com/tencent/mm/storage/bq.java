package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;

public final class bq {
    int bJt;
    public String name;
    int status;
    public a xZV;
    private int xZW;

    public static class a {
        private String cIS;
        private String cSx;

        public a(String str) {
            AppMethodBeat.i(60230);
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.cIS = str.substring(0, indexOf);
                this.cSx = str.substring(indexOf);
                AppMethodBeat.o(60230);
                return;
            }
            this.cIS = str;
            this.cSx = "";
            AppMethodBeat.o(60230);
        }

        public final String apT(String str) {
            return this.cSx != null ? this.cSx : str;
        }
    }

    public bq() {
        this.bJt = b.CTRL_INDEX;
        this.name = "";
        this.xZV = null;
        this.xZV = null;
        this.name = "";
        this.status = 0;
        this.xZW = 0;
    }

    public bq(String str, boolean z, int i) {
        AppMethodBeat.i(60231);
        this.bJt = b.CTRL_INDEX;
        this.name = "";
        this.xZV = null;
        this.xZV = new a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.xZW = i;
        AppMethodBeat.o(60231);
    }

    public final void setEnable(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean isEnable() {
        return (this.status & 1) != 0;
    }

    public final boolean dum() {
        return (this.status & 2) != 0;
    }

    public final boolean dun() {
        return this.xZW == 1;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(60232);
        if ((this.bJt & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.xZV == null) {
                this.xZV = new a(this.name);
            }
        }
        if ((this.bJt & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.bJt & 128) != 0) {
            this.xZW = cursor.getInt(7);
        }
        AppMethodBeat.o(60232);
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(60233);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.xZW));
        }
        AppMethodBeat.o(60233);
        return contentValues;
    }
}
