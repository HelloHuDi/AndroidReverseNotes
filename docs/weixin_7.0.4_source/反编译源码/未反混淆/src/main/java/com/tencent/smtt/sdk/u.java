package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

class u extends FileChooserParams {
    final /* synthetic */ IX5WebChromeClient.FileChooserParams a;
    final /* synthetic */ q b;

    u(q qVar, IX5WebChromeClient.FileChooserParams fileChooserParams) {
        this.b = qVar;
        this.a = fileChooserParams;
    }

    public Intent createIntent() {
        AppMethodBeat.i(64090);
        Intent createIntent = this.a.createIntent();
        AppMethodBeat.o(64090);
        return createIntent;
    }

    public String[] getAcceptTypes() {
        AppMethodBeat.i(64086);
        String[] acceptTypes = this.a.getAcceptTypes();
        AppMethodBeat.o(64086);
        return acceptTypes;
    }

    public String getFilenameHint() {
        AppMethodBeat.i(64089);
        String filenameHint = this.a.getFilenameHint();
        AppMethodBeat.o(64089);
        return filenameHint;
    }

    public int getMode() {
        AppMethodBeat.i(64085);
        int mode = this.a.getMode();
        AppMethodBeat.o(64085);
        return mode;
    }

    public CharSequence getTitle() {
        AppMethodBeat.i(64088);
        CharSequence title = this.a.getTitle();
        AppMethodBeat.o(64088);
        return title;
    }

    public boolean isCaptureEnabled() {
        AppMethodBeat.i(64087);
        boolean isCaptureEnabled = this.a.isCaptureEnabled();
        AppMethodBeat.o(64087);
        return isCaptureEnabled;
    }
}
