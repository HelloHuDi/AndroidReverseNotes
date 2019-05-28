package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    String fNM;
    double fNN;
    double latitude;
    double longitude;

    public final String toString() {
        AppMethodBeat.i(78562);
        String str = "gspType:" + this.fNM + " longitude: " + this.longitude + " latitude: " + this.latitude + " distance: " + this.fNN;
        AppMethodBeat.o(78562);
        return str;
    }
}
