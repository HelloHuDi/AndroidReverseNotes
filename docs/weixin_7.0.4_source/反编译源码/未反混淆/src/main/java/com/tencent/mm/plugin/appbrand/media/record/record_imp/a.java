package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public int aOn = 0;
    public c coZ = null;
    public int cpA = -1;
    public RecordParam imf;
    public long img = 0;
    public a imh;
    public com.tencent.mm.audio.b.c.a imi = new com.tencent.mm.audio.b.c.a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(105656);
            ab.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
            if (a.this.imh != null) {
                a.this.imh.u(bArr, i);
            }
            AppMethodBeat.o(105656);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(105657);
            ab.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (a.this.imh != null) {
                a.this.imh.bN(i, i2);
            }
            AppMethodBeat.o(105657);
        }
    };
    public int sampleRate = 0;

    public interface a {
        void bN(int i, int i2);

        void u(byte[] bArr, int i);
    }

    public a(RecordParam recordParam) {
        AppMethodBeat.i(105658);
        if (recordParam == null) {
            recordParam = new RecordParam();
        }
        this.sampleRate = recordParam.sampleRate;
        this.aOn = recordParam.imk;
        this.cpA = recordParam.scene;
        this.imf = recordParam;
        AppMethodBeat.o(105658);
    }

    public final boolean EB() {
        boolean EB;
        AppMethodBeat.i(105659);
        ab.i("MicroMsg.Record.AppBrandRecorder", JsApiStopRecordVoice.NAME);
        if (this.coZ != null) {
            EB = this.coZ.EB();
        } else {
            EB = false;
        }
        this.img -= System.currentTimeMillis();
        ab.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", Long.valueOf(r2), Long.valueOf(this.img));
        AppMethodBeat.o(105659);
        return EB;
    }
}
