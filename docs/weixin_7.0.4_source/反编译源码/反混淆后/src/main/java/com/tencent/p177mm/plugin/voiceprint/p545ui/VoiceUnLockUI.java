package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.voiceprint.model.C14014d;
import com.tencent.p177mm.plugin.voiceprint.model.C43719j;
import com.tencent.p177mm.plugin.voiceprint.model.C43722q;
import com.tencent.p177mm.plugin.voiceprint.model.C43722q.C14018a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI */
public class VoiceUnLockUI extends BaseVoicePrintUI implements C14018a {
    private C43722q sMT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26241);
        super.onCreate(bundle);
        this.sMT = new C43722q(this);
        C4990ab.m7410d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        C9638aw.m17182Rg().mo14541a(new C14014d(73, ""), 0);
        AppMethodBeat.m2505o(26241);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHU() {
        AppMethodBeat.m2504i(26242);
        C4990ab.m7411d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", this.sLO);
        if (!(C5046bo.isNullOrNil(this.sLO) || C5046bo.isNullOrNil(this.sMT.sLs))) {
            C1207m c43719j = new C43719j(this.sLO, this.sMT.sLt);
            c43719j.sLb = true;
            C9638aw.m17182Rg().mo14541a(c43719j, 0);
            this.sLJ.setEnabled(false);
            this.sLM.bQs();
        }
        AppMethodBeat.m2505o(26242);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKm() {
        AppMethodBeat.m2504i(26243);
        findViewById(2131823774).setVisibility(8);
        this.sLM.bQs();
        this.sLM.setTitleText((int) C25738R.string.f2f);
        this.sLM.cIf();
        this.sLJ.setEnabled(false);
        AppMethodBeat.m2505o(26243);
    }

    /* Access modifiers changed, original: protected */
    public void cId() {
        AppMethodBeat.m2504i(26246);
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        startActivity(intent);
        finish();
        AppMethodBeat.m2505o(26246);
    }

    public final void cHM() {
        AppMethodBeat.m2504i(26247);
        cHT();
        AppMethodBeat.m2505o(26247);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26248);
        super.onDestroy();
        C1202f c1202f = this.sMT;
        C9638aw.m17182Rg().mo14546b(611, c1202f);
        C9638aw.m17182Rg().mo14546b(613, c1202f);
        c1202f.sLI = null;
        AppMethodBeat.m2505o(26248);
    }

    public final void abU(String str) {
        AppMethodBeat.m2504i(26244);
        this.sLs = str;
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        AppMethodBeat.m2505o(26244);
    }

    /* renamed from: mi */
    public final void mo26252mi(boolean z) {
        AppMethodBeat.m2504i(26245);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        if (z) {
            C4990ab.m7410d("MicroMsg.VoiceUnLockUI", "unlock success");
            cId();
            AppMethodBeat.m2505o(26245);
            return;
        }
        this.sLM.setErr((int) C25738R.string.f2e);
        this.sLM.cIg();
        AppMethodBeat.m2505o(26245);
    }
}
