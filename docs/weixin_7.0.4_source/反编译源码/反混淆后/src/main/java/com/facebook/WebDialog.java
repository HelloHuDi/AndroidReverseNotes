package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebDialog {
    private WebDialog() {
    }

    public static int getWebDialogTheme() {
        AppMethodBeat.m2504i(96597);
        int webDialogTheme = com.facebook.internal.WebDialog.getWebDialogTheme();
        AppMethodBeat.m2505o(96597);
        return webDialogTheme;
    }

    public static void setWebDialogTheme(int i) {
        AppMethodBeat.m2504i(96598);
        com.facebook.internal.WebDialog.setWebDialogTheme(i);
        AppMethodBeat.m2505o(96598);
    }
}
