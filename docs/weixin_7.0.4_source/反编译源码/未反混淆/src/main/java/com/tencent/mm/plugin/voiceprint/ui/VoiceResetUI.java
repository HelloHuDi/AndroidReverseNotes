package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class VoiceResetUI extends VoiceUnLockUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cId() {
        AppMethodBeat.i(26222);
        ab.d("MicroMsg.VoiceResetUI", "unlock success");
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
        AppMethodBeat.o(26222);
    }
}
