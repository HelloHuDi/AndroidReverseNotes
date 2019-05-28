package com.tencent.smtt.sdk;

import android.content.Intent;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

/* renamed from: com.tencent.smtt.sdk.ac */
class C24265ac extends FileChooserParams {
    /* renamed from: a */
    final /* synthetic */ WebChromeClient.FileChooserParams f4516a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f4517b;

    C24265ac(SystemWebChromeClient systemWebChromeClient, WebChromeClient.FileChooserParams fileChooserParams) {
        this.f4517b = systemWebChromeClient;
        this.f4516a = fileChooserParams;
    }

    public Intent createIntent() {
        AppMethodBeat.m2504i(64161);
        Intent createIntent = this.f4516a.createIntent();
        AppMethodBeat.m2505o(64161);
        return createIntent;
    }

    public String[] getAcceptTypes() {
        AppMethodBeat.m2504i(64157);
        String[] acceptTypes = this.f4516a.getAcceptTypes();
        AppMethodBeat.m2505o(64157);
        return acceptTypes;
    }

    public String getFilenameHint() {
        AppMethodBeat.m2504i(64160);
        String filenameHint = this.f4516a.getFilenameHint();
        AppMethodBeat.m2505o(64160);
        return filenameHint;
    }

    public int getMode() {
        AppMethodBeat.m2504i(64156);
        int mode = this.f4516a.getMode();
        AppMethodBeat.m2505o(64156);
        return mode;
    }

    public CharSequence getTitle() {
        AppMethodBeat.m2504i(64159);
        CharSequence title = this.f4516a.getTitle();
        AppMethodBeat.m2505o(64159);
        return title;
    }

    public boolean isCaptureEnabled() {
        AppMethodBeat.m2504i(64158);
        boolean isCaptureEnabled = this.f4516a.isCaptureEnabled();
        AppMethodBeat.m2505o(64158);
        return isCaptureEnabled;
    }
}
