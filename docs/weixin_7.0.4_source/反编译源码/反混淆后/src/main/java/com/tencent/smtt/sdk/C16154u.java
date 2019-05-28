package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

/* renamed from: com.tencent.smtt.sdk.u */
class C16154u extends FileChooserParams {
    /* renamed from: a */
    final /* synthetic */ IX5WebChromeClient.FileChooserParams f3035a;
    /* renamed from: b */
    final /* synthetic */ C40981q f3036b;

    C16154u(C40981q c40981q, IX5WebChromeClient.FileChooserParams fileChooserParams) {
        this.f3036b = c40981q;
        this.f3035a = fileChooserParams;
    }

    public Intent createIntent() {
        AppMethodBeat.m2504i(64090);
        Intent createIntent = this.f3035a.createIntent();
        AppMethodBeat.m2505o(64090);
        return createIntent;
    }

    public String[] getAcceptTypes() {
        AppMethodBeat.m2504i(64086);
        String[] acceptTypes = this.f3035a.getAcceptTypes();
        AppMethodBeat.m2505o(64086);
        return acceptTypes;
    }

    public String getFilenameHint() {
        AppMethodBeat.m2504i(64089);
        String filenameHint = this.f3035a.getFilenameHint();
        AppMethodBeat.m2505o(64089);
        return filenameHint;
    }

    public int getMode() {
        AppMethodBeat.m2504i(64085);
        int mode = this.f3035a.getMode();
        AppMethodBeat.m2505o(64085);
        return mode;
    }

    public CharSequence getTitle() {
        AppMethodBeat.m2504i(64088);
        CharSequence title = this.f3035a.getTitle();
        AppMethodBeat.m2505o(64088);
        return title;
    }

    public boolean isCaptureEnabled() {
        AppMethodBeat.m2504i(64087);
        boolean isCaptureEnabled = this.f3035a.isCaptureEnabled();
        AppMethodBeat.m2505o(64087);
        return isCaptureEnabled;
    }
}
