package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public static String jvr = "]]>";
    public StringBuffer jvt = new StringBuffer();
    public String xyh = "";

    public i() {
        AppMethodBeat.i(51972);
        AppMethodBeat.o(51972);
    }

    public i(String str) {
        AppMethodBeat.i(51973);
        this.xyh = str;
        Fi(this.xyh);
        AppMethodBeat.o(51973);
    }

    private void Fi(String str) {
        AppMethodBeat.i(51974);
        this.jvt.append("<" + str + ">");
        AppMethodBeat.o(51974);
    }

    public final void Fj(String str) {
        AppMethodBeat.i(51975);
        this.jvt.append("</" + str + ">");
        AppMethodBeat.o(51975);
    }

    private void setText(String str) {
        AppMethodBeat.i(51976);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(51976);
        } else if (str.contains(jvr)) {
            this.jvt.append("<![CDATA[" + bo.ani(str) + "]]>");
            AppMethodBeat.o(51976);
        } else {
            this.jvt.append("<![CDATA[" + str + "]]>");
            AppMethodBeat.o(51976);
        }
    }

    public final void cY(String str, String str2) {
        AppMethodBeat.i(51977);
        Fi(str);
        setText(str2);
        Fj(str);
        AppMethodBeat.o(51977);
    }
}
