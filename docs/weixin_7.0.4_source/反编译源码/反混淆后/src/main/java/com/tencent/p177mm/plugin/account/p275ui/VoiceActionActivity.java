package com.tencent.p177mm.plugin.account.p275ui;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.account.model.VoiceActionService;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.ui.VoiceActionActivity */
public class VoiceActionActivity extends SearchActionVerificationClientActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: up */
    public final Class<? extends SearchActionVerificationClientService> mo19736up() {
        AppMethodBeat.m2504i(125632);
        C4990ab.m7410d("MicroMsg.VoiceActionActivity", "getServiceClass");
        Class cls = VoiceActionService.class;
        AppMethodBeat.m2505o(125632);
        return cls;
    }
}
