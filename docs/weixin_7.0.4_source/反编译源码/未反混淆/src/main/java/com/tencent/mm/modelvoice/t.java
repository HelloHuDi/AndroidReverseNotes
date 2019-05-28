package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class t implements a {
    private static int cri = 100;
    private b crg;
    String fileName = "";
    private j.a gat = null;
    private int status = 0;

    public final int getStatus() {
        return this.status;
    }

    public final int EC() {
        b bVar = this.crg;
        if ((bVar.cpa == c.a.PCM || bVar.cpa == c.a.SILK) && bVar.coZ != null) {
            return bVar.coZ.cpR;
        }
        return 1;
    }

    public final void a(j.a aVar) {
        this.gat = aVar;
    }

    public t(c.a aVar) {
        AppMethodBeat.i(116659);
        this.crg = new b(aVar);
        AppMethodBeat.o(116659);
    }

    public final boolean el(String str) {
        AppMethodBeat.i(116660);
        String str2 = "VoiceRecorder";
        String str3 = "[startRecord] fileName:%s size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(bo.isNullOrNil(str) ? 0 : str.length());
        ab.i(str2, str3, objArr);
        g.a aVar = new g.a();
        if (this.fileName.length() > 0) {
            ab.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            AppMethodBeat.o(116660);
            return false;
        }
        this.fileName = str;
        try {
            this.crg.a(new b.a() {
                public final void onError() {
                    AppMethodBeat.i(116658);
                    if (t.this.gat != null) {
                        t.this.gat.onError();
                    }
                    try {
                        t.this.crg.release();
                        t.this.status = -1;
                        AppMethodBeat.o(116658);
                    } catch (Exception e) {
                        ab.e("VoiceRecorder", "setErrorListener File[" + t.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                        AppMethodBeat.o(116658);
                    }
                }
            });
            this.crg.EE();
            this.crg.EF();
            this.crg.ED();
            this.crg.setOutputFile(this.fileName);
            this.crg.setMaxDuration(70000);
            this.crg.prepare();
            this.crg.start();
            ab.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.Mr());
            this.status = 1;
            AppMethodBeat.o(116660);
            return true;
        } catch (Exception e) {
            ab.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.o(116660);
            return false;
        }
    }

    public final boolean EB() {
        AppMethodBeat.i(116661);
        if (this.crg == null) {
            AppMethodBeat.o(116661);
            return true;
        }
        try {
            this.crg.EH();
            this.crg.release();
            this.fileName = "";
            this.status = 0;
            AppMethodBeat.o(116661);
            return true;
        } catch (Exception e) {
            ab.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.o(116661);
            return false;
        }
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.i(116662);
        if (this.status == 1) {
            int maxAmplitude = this.crg.getMaxAmplitude();
            if (maxAmplitude > cri) {
                cri = maxAmplitude;
            }
            maxAmplitude = (maxAmplitude * 100) / cri;
            AppMethodBeat.o(116662);
            return maxAmplitude;
        }
        AppMethodBeat.o(116662);
        return 0;
    }
}
