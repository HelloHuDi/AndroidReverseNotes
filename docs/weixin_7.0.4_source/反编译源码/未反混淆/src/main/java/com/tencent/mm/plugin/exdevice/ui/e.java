package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a.d;

final class e {
    int auo;
    d lFy;
    int lFz;

    static class a {
        int auo;
        String lCH;
        d lFy = null;
        int lFz;
        String username;

        public final e bqg() {
            AppMethodBeat.i(20234);
            e eVar = new e(this.auo, this.lFz, this.lCH, this.username, this.lFy, (byte) 0);
            AppMethodBeat.o(20234);
            return eVar;
        }
    }

    /* synthetic */ e(int i, int i2, String str, String str2, d dVar, byte b) {
        this(i, i2, str, str2, dVar);
    }

    private e(int i, int i2, String str, String str2, d dVar) {
        AppMethodBeat.i(20235);
        this.auo = i;
        this.lFz = i2;
        if (i != 0) {
            if (dVar != null) {
                this.lFy = dVar;
                AppMethodBeat.o(20235);
                return;
            }
            d dVar2 = new d();
            dVar2.field_username = str2;
            dVar2.field_appusername = str;
            dVar2.field_ranknum = 0;
            dVar2.field_selfLikeState = 0;
            dVar2.field_rankID = "";
            dVar2.field_likecount = 0;
            dVar2.field_score = 0;
            this.lFy = dVar2;
        }
        AppMethodBeat.o(20235);
    }

    public final String toString() {
        AppMethodBeat.i(20236);
        String str = "{ view type: " + this.auo + " display flag: " + this.lFz;
        if (this.lFy != null) {
            str = str + this.lFy.toString();
        } else {
            str = str + " mExdeviceRankInfo is null";
        }
        str = str + "}";
        AppMethodBeat.o(20236);
        return str;
    }
}
