package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebDialog {
    private WebDialog() {
    }

    public static int getWebDialogTheme() {
        AppMethodBeat.i(96597);
        int webDialogTheme = com.facebook.internal.WebDialog.getWebDialogTheme();
        AppMethodBeat.o(96597);
        return webDialogTheme;
    }

    public static void setWebDialogTheme(int i) {
        AppMethodBeat.i(96598);
        com.facebook.internal.WebDialog.setWebDialogTheme(i);
        AppMethodBeat.o(96598);
    }
}
