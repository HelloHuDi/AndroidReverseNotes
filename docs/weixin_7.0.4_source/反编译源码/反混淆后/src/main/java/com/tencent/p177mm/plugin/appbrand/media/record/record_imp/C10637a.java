package com.tencent.p177mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.record_imp.a */
public final class C10637a {
    public int aOn = 0;
    public C1292c coZ = null;
    public int cpA = -1;
    public RecordParam imf;
    public long img = 0;
    public C2393a imh;
    public C1293a imi = new C106381();
    public int sampleRate = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.record_imp.a$a */
    public interface C2393a {
        /* renamed from: bN */
        void mo6298bN(int i, int i2);

        /* renamed from: u */
        void mo6299u(byte[] bArr, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.record_imp.a$1 */
    class C106381 implements C1293a {
        C106381() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(105656);
            C4990ab.m7416i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
            if (C10637a.this.imh != null) {
                C10637a.this.imh.mo6299u(bArr, i);
            }
            AppMethodBeat.m2505o(105656);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
            AppMethodBeat.m2504i(105657);
            C4990ab.m7413e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (C10637a.this.imh != null) {
                C10637a.this.imh.mo6298bN(i, i2);
            }
            AppMethodBeat.m2505o(105657);
        }
    }

    public C10637a(RecordParam recordParam) {
        AppMethodBeat.m2504i(105658);
        if (recordParam == null) {
            recordParam = new RecordParam();
        }
        this.sampleRate = recordParam.sampleRate;
        this.aOn = recordParam.imk;
        this.cpA = recordParam.scene;
        this.imf = recordParam;
        AppMethodBeat.m2505o(105658);
    }

    /* renamed from: EB */
    public final boolean mo22163EB() {
        boolean EB;
        AppMethodBeat.m2504i(105659);
        C4990ab.m7416i("MicroMsg.Record.AppBrandRecorder", JsApiStopRecordVoice.NAME);
        if (this.coZ != null) {
            EB = this.coZ.mo4590EB();
        } else {
            EB = false;
        }
        this.img -= System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", Long.valueOf(r2), Long.valueOf(this.img));
        AppMethodBeat.m2505o(105659);
        return EB;
    }
}
