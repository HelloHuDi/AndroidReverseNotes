package com.tencent.smtt.sdk;

import android.content.Intent;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

class ac extends FileChooserParams {
    final /* synthetic */ WebChromeClient.FileChooserParams a;
    final /* synthetic */ SystemWebChromeClient b;

    ac(SystemWebChromeClient systemWebChromeClient, WebChromeClient.FileChooserParams fileChooserParams) {
        this.b = systemWebChromeClient;
        this.a = fileChooserParams;
    }

    public Intent createIntent() {
        AppMethodBeat.i(64161);
        Intent createIntent = this.a.createIntent();
        AppMethodBeat.o(64161);
        return createIntent;
    }

    public String[] getAcceptTypes() {
        AppMethodBeat.i(64157);
        String[] acceptTypes = this.a.getAcceptTypes();
        AppMethodBeat.o(64157);
        return acceptTypes;
    }

    public String getFilenameHint() {
        AppMethodBeat.i(64160);
        String filenameHint = this.a.getFilenameHint();
        AppMethodBeat.o(64160);
        return filenameHint;
    }

    public int getMode() {
        AppMethodBeat.i(64156);
        int mode = this.a.getMode();
        AppMethodBeat.o(64156);
        return mode;
    }

    public CharSequence getTitle() {
        AppMethodBeat.i(64159);
        CharSequence title = this.a.getTitle();
        AppMethodBeat.o(64159);
        return title;
    }

    public boolean isCaptureEnabled() {
        AppMethodBeat.i(64158);
        boolean isCaptureEnabled = this.a.isCaptureEnabled();
        AppMethodBeat.o(64158);
        return isCaptureEnabled;
    }
}
