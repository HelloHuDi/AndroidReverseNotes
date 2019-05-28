package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.q */
public final class C43722q implements C1202f {
    private String sKY;
    public C14018a sLI;
    private int sLf;
    public String sLs;
    public int sLt;

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.q$a */
    public interface C14018a {
        void abU(String str);

        void cHM();

        /* renamed from: mi */
        void mo26252mi(boolean z);
    }

    public C43722q() {
        AppMethodBeat.m2504i(26128);
        this.sLI = null;
        this.sLt = -1;
        this.sLs = null;
        this.sKY = null;
        this.sLf = 0;
        C9638aw.m17182Rg().mo14539a(611, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(613, (C1202f) this);
        AppMethodBeat.m2505o(26128);
    }

    public C43722q(C14018a c14018a) {
        this();
        this.sLI = c14018a;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26129);
        C4990ab.m7411d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (c1207m.getType() == 611) {
                C14014d c14014d = (C14014d) c1207m;
                this.sLt = c14014d.sKX;
                this.sLs = c14014d.sKW;
                this.sKY = c14014d.sKY;
                C4990ab.m7411d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", Integer.valueOf(this.sLt), this.sKY, Boolean.valueOf(C5046bo.isNullOrNil(this.sLs)));
                if (this.sLI != null) {
                    this.sLI.abU(this.sLs);
                }
            }
            if (c1207m.getType() == 613) {
                if (((C43719j) c1207m).f17224Kt == 0) {
                    C4990ab.m7410d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                    if (this.sLI != null) {
                        this.sLI.mo26252mi(true);
                        AppMethodBeat.m2505o(26129);
                        return;
                    }
                }
                C4990ab.m7410d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
                if (this.sLI != null) {
                    this.sLI.mo26252mi(false);
                }
            }
            AppMethodBeat.m2505o(26129);
            return;
        }
        if (this.sLI != null) {
            this.sLI.cHM();
        }
        AppMethodBeat.m2505o(26129);
    }
}
