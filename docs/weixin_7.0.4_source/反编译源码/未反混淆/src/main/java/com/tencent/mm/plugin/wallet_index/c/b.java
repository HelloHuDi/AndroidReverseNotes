package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    public int nqa;
    public String nqb;
    public int tQZ = 0;

    private b(int i, String str) {
        this.nqa = i;
        this.nqb = str;
    }

    public static b bu(int i, String str) {
        b bVar;
        int i2 = 6;
        int i3 = R.string.g43;
        AppMethodBeat.i(48175);
        if (i > -15001) {
            switch (i) {
                case 0:
                    i3 = R.string.g42;
                    i2 = i;
                    break;
                case 1:
                case 7:
                    i3 = R.string.g44;
                    i2 = i;
                    break;
                case 3:
                case 105:
                    i2 = 3;
                    str = "Google Play not install";
                    break;
                case 6:
                    bVar = new b(6, str);
                    AppMethodBeat.o(48175);
                    return bVar;
                case 103:
                case 104:
                case 100000002:
                    i2 = 100000002;
                    i3 = R.string.g41;
                    break;
                case 109:
                    i3 = R.string.g45;
                    i2 = i;
                    break;
                case 110:
                    i3 = R.string.g47;
                    i2 = i;
                    break;
                case 111:
                    i3 = R.string.g48;
                    i2 = i;
                    break;
                case 112:
                    i3 = R.string.g46;
                    i2 = i;
                    break;
                case 113:
                    i2 = i;
                    break;
            }
        }
        i2 = i;
        ab.i("MicroMsg.IapResult", "code : " + i + ", errMsg : " + str + ", convert to errCode : " + i2);
        if (bo.isNullOrNil(str)) {
            b bVar2 = new b(i2, ah.getContext().getString(i3));
            AppMethodBeat.o(48175);
            return bVar2;
        }
        bVar = new b(i2, str);
        AppMethodBeat.o(48175);
        return bVar;
    }

    public final boolean cSU() {
        return this.nqa == 104 || this.nqa == 100000002;
    }

    public final String toString() {
        AppMethodBeat.i(48177);
        String str = "IapResult: " + this.nqb;
        AppMethodBeat.o(48177);
        return str;
    }

    public final boolean cSV() {
        boolean z;
        AppMethodBeat.i(48176);
        if (this.nqa == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || cSU()) {
            AppMethodBeat.o(48176);
            return false;
        }
        AppMethodBeat.o(48176);
        return true;
    }
}
