package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class j {
    public static int cri = 100;
    private b cop = new b(ah.getContext());
    public b crg = new b(com.tencent.mm.compatible.b.c.a.AMR);
    public a crh = null;
    String fileName = "";
    public int status = 0;

    public interface a {
        void onError();
    }

    public j() {
        AppMethodBeat.i(116530);
        AppMethodBeat.o(116530);
    }

    public final boolean en(String str) {
        AppMethodBeat.i(116531);
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (this.fileName.length() > 0) {
            ab.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            AppMethodBeat.o(116531);
            return false;
        }
        this.fileName = str;
        try {
            this.cop.requestFocus();
            this.crg.a(new com.tencent.mm.audio.b.b.a() {
                public final void onError() {
                    AppMethodBeat.i(116529);
                    j.this.cop.Mm();
                    if (j.this.crh != null) {
                        j.this.crh.onError();
                    }
                    try {
                        j.this.crg.release();
                        j.this.status = -1;
                        AppMethodBeat.o(116529);
                    } catch (Exception e) {
                        ab.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                        AppMethodBeat.o(116529);
                    }
                }
            });
            this.crg.EE();
            this.crg.EF();
            this.crg.ED();
            this.crg.setOutputFile(this.fileName);
            this.crg.setMaxDuration(3600010);
            this.crg.prepare();
            this.crg.start();
            ab.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.Mr());
            this.status = 1;
            AppMethodBeat.o(116531);
            return true;
        } catch (Exception e) {
            this.cop.Mm();
            ab.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.o(116531);
            return false;
        }
    }

    public final boolean EB() {
        AppMethodBeat.i(116532);
        this.cop.Mm();
        if (this.crg == null) {
            AppMethodBeat.o(116532);
            return true;
        }
        try {
            this.crg.EH();
            this.crg.release();
            this.fileName = "";
            this.status = 0;
            AppMethodBeat.o(116532);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.o(116532);
            return false;
        }
    }
}
