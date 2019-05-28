package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceResetUI */
public class VoiceResetUI extends VoiceUnLockUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cId() {
        AppMethodBeat.m2504i(26222);
        C4990ab.m7410d("MicroMsg.VoiceResetUI", "unlock success");
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
        AppMethodBeat.m2505o(26222);
    }
}
