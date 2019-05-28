package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.tools.o;

public final class b extends o {
    public boolean gcl = true;
    public int gcm;
    public int gcn;
    a gco;
    public VoiceSearchLayout gcp;
    private com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.a gcq = new com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.a() {
        public final void amE() {
            AppMethodBeat.i(116785);
            if (com.tencent.mm.r.a.bJ(ah.getContext()) || com.tencent.mm.r.a.bH(ah.getContext())) {
                AppMethodBeat.o(116785);
                return;
            }
            ab.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
            h.pYm.e(10453, Integer.valueOf(b.this.gcm), Integer.valueOf(3));
            if (b.this.gco != null) {
                b.this.gco.amJ();
            }
            AppMethodBeat.o(116785);
        }

        public final void amF() {
            AppMethodBeat.i(116786);
            ab.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
            h.pYm.e(10453, Integer.valueOf(b.this.gcm), Integer.valueOf(4));
            if (b.this.zGZ != null) {
                b.this.zGZ.setEditTextEnabled(true);
                b.this.zGZ.setStatusBtnEnabled(true);
            }
            AppMethodBeat.o(116786);
        }

        public final void a(boolean z, String[] strArr, long j) {
            AppMethodBeat.i(116787);
            ab.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", Boolean.valueOf(z), Long.valueOf(j));
            if (b.this.gco != null) {
                b.this.gco.a(z, strArr, j, b.this.gcn);
            }
            AppMethodBeat.o(116787);
        }
    };

    public interface a extends com.tencent.mm.ui.tools.o.b {
        void a(boolean z, String[] strArr, long j, int i);

        void amJ();
    }

    public b() {
        AppMethodBeat.i(116788);
        AppMethodBeat.o(116788);
    }

    public b(byte b) {
        super((byte) 0);
        AppMethodBeat.i(116789);
        AppMethodBeat.o(116789);
    }

    public final void a(a aVar) {
        this.gco = aVar;
        this.zHa = aVar;
    }

    public final void cancel() {
        AppMethodBeat.i(116790);
        ab.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.gcp != null) {
            this.gcp.amA();
        }
        if (this.zGZ != null) {
            this.zGZ.setEditTextEnabled(true);
            this.zGZ.setStatusBtnEnabled(true);
        }
        AppMethodBeat.o(116790);
    }

    public final boolean amG() {
        boolean z = false;
        AppMethodBeat.i(116791);
        String str = "MicroMsg.VoiceSearchViewHelper";
        String str2 = "check has voice search, Enable %B, layout is null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.gcl);
        if (this.gcp == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        z = this.gcl;
        AppMethodBeat.o(116791);
        return z;
    }

    public final void amH() {
        AppMethodBeat.i(116792);
        ab.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.zGZ != null) {
            this.zGZ.setEditTextEnabled(false);
            this.zGZ.setStatusBtnEnabled(false);
        }
        if (this.gcp == null || this.gcp.getVisibility() != 8) {
            AppMethodBeat.o(116792);
            return;
        }
        ab.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
        VoiceSearchLayout voiceSearchLayout = this.gcp;
        int i = this.gcn;
        ab.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.o(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")));
        if (com.tencent.mm.pluginsdk.permission.b.o(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")) {
            boolean z;
            ab.d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.cFy);
            voiceSearchLayout.gbW = i;
            voiceSearchLayout.cFy = true;
            voiceSearchLayout.gbV = false;
            if (voiceSearchLayout.gbT != null) {
                voiceSearchLayout.gbT.amE();
            }
            voiceSearchLayout.setVisibility(0);
            voiceSearchLayout.gci.ae(50, 50);
            voiceSearchLayout.dc(true);
            voiceSearchLayout.gch = 0;
            voiceSearchLayout.gca = new f(new com.tencent.mm.modelvoiceaddr.f.b() {
                public final void ams() {
                    AppMethodBeat.i(116766);
                    VoiceSearchLayout.k(VoiceSearchLayout.this);
                    VoiceSearchLayout.l(VoiceSearchLayout.this);
                    if (VoiceSearchLayout.this.gci != null) {
                        VoiceSearchLayout.this.gci.stopTimer();
                    }
                    AppMethodBeat.o(116766);
                }

                public final void a(String[] strArr, long j) {
                    AppMethodBeat.i(116767);
                    try {
                        ab.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
                        if (strArr != null) {
                            ab.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + strArr.length + " " + strArr.toString());
                            for (Object valueOf : strArr) {
                                ab.d("MicroMsg.VoiceSearchLayout", "search username  :".concat(String.valueOf(valueOf)));
                            }
                        }
                        VoiceSearchLayout.this.reset();
                        VoiceSearchLayout.this.gbT.a(true, strArr, j);
                        AppMethodBeat.o(116767);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                        AppMethodBeat.o(116767);
                    }
                }

                public final void amr() {
                    AppMethodBeat.i(116768);
                    VoiceSearchLayout.this.reset();
                    VoiceSearchLayout.this.gbT.a(false, null, -1);
                    AppMethodBeat.o(116768);
                }
            }, i);
            f fVar = voiceSearchLayout.gca;
            ab.i("MicroMsg.SceneVoiceAddr", "start record");
            if (fVar.gaL == 0 && at.is2G(ah.getContext())) {
                z = true;
            } else {
                z = false;
            }
            fVar.gaW = z;
            ab.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", Boolean.valueOf(fVar.gaW));
            d.post(new com.tencent.mm.modelvoiceaddr.f.a(), "SceneVoiceAddr_record");
            AppMethodBeat.o(116792);
            return;
        }
        if (voiceSearchLayout.getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.permission.b.b((Activity) voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO", 80);
        }
        AppMethodBeat.o(116792);
    }

    public final void a(Activity activity, Menu menu) {
        AppMethodBeat.i(116793);
        super.a(activity, menu);
        if (this.gcp != null) {
            this.gcp.setOnSearchListener(this.gcq);
        }
        AppMethodBeat.o(116793);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(116794);
        if (4 == i) {
            boolean z;
            if (this.gcp == null || this.gcp.getVisibility() != 0) {
                z = false;
            } else {
                z = true;
            }
            ab.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", Boolean.valueOf(z));
            cancel();
            if (z) {
                AppMethodBeat.o(116794);
                return true;
            }
        }
        ab.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(116794);
        return onKeyDown;
    }

    public final void amI() {
        AppMethodBeat.i(116795);
        cancel();
        AppMethodBeat.o(116795);
    }
}
