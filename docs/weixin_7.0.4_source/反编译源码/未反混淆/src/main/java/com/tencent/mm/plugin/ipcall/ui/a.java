package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a {
    String countryCode;
    String fHE;
    String fHF;
    private int nzG;

    public a(String str, String str2, int i, String str3) {
        this.fHE = str;
        this.countryCode = str2;
        this.nzG = i;
        this.fHF = str3;
    }

    public final int bIc() {
        AppMethodBeat.i(21952);
        if (this.nzG == 0) {
            AppMethodBeat.o(21952);
            return 0;
        }
        int i;
        for (String equals : IPCallCountryCodeScrollbar.nBP) {
            if (equals.equals(String.valueOf((char) this.nzG))) {
                i = this.nzG;
                AppMethodBeat.o(21952);
                return i;
            }
        }
        i = "#".charAt(0);
        AppMethodBeat.o(21952);
        return i;
    }
}
