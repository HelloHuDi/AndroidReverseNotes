package com.tencent.mm.plugin.account.ui;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.VoiceActionService;
import com.tencent.mm.sdk.platformtools.ab;

public class VoiceActionActivity extends SearchActionVerificationClientActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final Class<? extends SearchActionVerificationClientService> up() {
        AppMethodBeat.i(125632);
        ab.d("MicroMsg.VoiceActionActivity", "getServiceClass");
        Class cls = VoiceActionService.class;
        AppMethodBeat.o(125632);
        return cls;
    }
}
