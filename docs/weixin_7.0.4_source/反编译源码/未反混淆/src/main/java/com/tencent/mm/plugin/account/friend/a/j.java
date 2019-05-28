package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    int bJt = -1;
    public int dtS = 0;
    public int dub = 0;
    public String duc = "";
    public String dud = "";
    public String signature = "";
    public String username = "";

    public j() {
        AppMethodBeat.i(108356);
        AppMethodBeat.o(108356);
    }

    public final ContentValues Hl() {
        String str;
        String str2;
        AppMethodBeat.i(108357);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("sex", Integer.valueOf(this.dtS));
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.dub));
        }
        if ((this.bJt & 8) != 0) {
            str = "province";
            if (this.duc == null) {
                str2 = "";
            } else {
                str2 = this.duc;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 16) != 0) {
            str = "city";
            if (this.dud == null) {
                str2 = "";
            } else {
                str2 = this.dud;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 32) != 0) {
            str = "signature";
            if (this.signature == null) {
                str2 = "";
            } else {
                str2 = this.signature;
            }
            contentValues.put(str, str2);
        }
        AppMethodBeat.o(108357);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
