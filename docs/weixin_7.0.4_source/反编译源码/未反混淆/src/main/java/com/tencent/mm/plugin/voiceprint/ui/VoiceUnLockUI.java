package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceUnLockUI extends BaseVoicePrintUI implements a {
    private q sMT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26241);
        super.onCreate(bundle);
        this.sMT = new q(this);
        ab.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        aw.Rg().a(new d(73, ""), 0);
        AppMethodBeat.o(26241);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHU() {
        AppMethodBeat.i(26242);
        ab.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", this.sLO);
        if (!(bo.isNullOrNil(this.sLO) || bo.isNullOrNil(this.sMT.sLs))) {
            m jVar = new j(this.sLO, this.sMT.sLt);
            jVar.sLb = true;
            aw.Rg().a(jVar, 0);
            this.sLJ.setEnabled(false);
            this.sLM.bQs();
        }
        AppMethodBeat.o(26242);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKm() {
        AppMethodBeat.i(26243);
        findViewById(R.id.bma).setVisibility(8);
        this.sLM.bQs();
        this.sLM.setTitleText((int) R.string.f2f);
        this.sLM.cIf();
        this.sLJ.setEnabled(false);
        AppMethodBeat.o(26243);
    }

    /* Access modifiers changed, original: protected */
    public void cId() {
        AppMethodBeat.i(26246);
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        startActivity(intent);
        finish();
        AppMethodBeat.o(26246);
    }

    public final void cHM() {
        AppMethodBeat.i(26247);
        cHT();
        AppMethodBeat.o(26247);
    }

    public void onDestroy() {
        AppMethodBeat.i(26248);
        super.onDestroy();
        f fVar = this.sMT;
        aw.Rg().b(611, fVar);
        aw.Rg().b(613, fVar);
        fVar.sLI = null;
        AppMethodBeat.o(26248);
    }

    public final void abU(String str) {
        AppMethodBeat.i(26244);
        this.sLs = str;
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        AppMethodBeat.o(26244);
    }

    public final void mi(boolean z) {
        AppMethodBeat.i(26245);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        if (z) {
            ab.d("MicroMsg.VoiceUnLockUI", "unlock success");
            cId();
            AppMethodBeat.o(26245);
            return;
        }
        this.sLM.setErr((int) R.string.f2e);
        this.sLM.cIg();
        AppMethodBeat.o(26245);
    }
}
