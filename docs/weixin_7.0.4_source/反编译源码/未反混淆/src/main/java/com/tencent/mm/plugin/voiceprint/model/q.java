package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q implements f {
    private String sKY;
    public a sLI;
    private int sLf;
    public String sLs;
    public int sLt;

    public interface a {
        void abU(String str);

        void cHM();

        void mi(boolean z);
    }

    public q() {
        AppMethodBeat.i(26128);
        this.sLI = null;
        this.sLt = -1;
        this.sLs = null;
        this.sKY = null;
        this.sLf = 0;
        aw.Rg().a(611, (f) this);
        aw.Rg().a(613, (f) this);
        AppMethodBeat.o(26128);
    }

    public q(a aVar) {
        this();
        this.sLI = aVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26129);
        ab.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (mVar.getType() == 611) {
                d dVar = (d) mVar;
                this.sLt = dVar.sKX;
                this.sLs = dVar.sKW;
                this.sKY = dVar.sKY;
                ab.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", Integer.valueOf(this.sLt), this.sKY, Boolean.valueOf(bo.isNullOrNil(this.sLs)));
                if (this.sLI != null) {
                    this.sLI.abU(this.sLs);
                }
            }
            if (mVar.getType() == 613) {
                if (((j) mVar).Kt == 0) {
                    ab.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                    if (this.sLI != null) {
                        this.sLI.mi(true);
                        AppMethodBeat.o(26129);
                        return;
                    }
                }
                ab.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
                if (this.sLI != null) {
                    this.sLI.mi(false);
                }
            }
            AppMethodBeat.o(26129);
            return;
        }
        if (this.sLI != null) {
            this.sLI.cHM();
        }
        AppMethodBeat.o(26129);
    }
}
