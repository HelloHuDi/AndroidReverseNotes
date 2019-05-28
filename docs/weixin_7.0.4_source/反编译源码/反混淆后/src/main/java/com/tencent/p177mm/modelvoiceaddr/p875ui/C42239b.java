package com.tencent.p177mm.modelvoiceaddr.p875ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoiceaddr.C42235f;
import com.tencent.p177mm.modelvoiceaddr.C42235f.C9751a;
import com.tencent.p177mm.modelvoiceaddr.p875ui.VoiceSearchLayout.C265074;
import com.tencent.p177mm.modelvoiceaddr.p875ui.VoiceSearchLayout.C37969a;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.modelvoiceaddr.ui.b */
public final class C42239b extends C5601o {
    public boolean gcl = true;
    public int gcm;
    public int gcn;
    C9756a gco;
    public VoiceSearchLayout gcp;
    private C37969a gcq = new C328551();

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.b$a */
    public interface C9756a extends C5600b {
        /* renamed from: a */
        void mo21125a(boolean z, String[] strArr, long j, int i);

        void amJ();
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.b$1 */
    class C328551 implements C37969a {
        C328551() {
        }

        public final void amE() {
            AppMethodBeat.m2504i(116785);
            if (C35973a.m59179bJ(C4996ah.getContext()) || C35973a.m59177bH(C4996ah.getContext())) {
                AppMethodBeat.m2505o(116785);
                return;
            }
            C4990ab.m7410d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
            C7060h.pYm.mo8381e(10453, Integer.valueOf(C42239b.this.gcm), Integer.valueOf(3));
            if (C42239b.this.gco != null) {
                C42239b.this.gco.amJ();
            }
            AppMethodBeat.m2505o(116785);
        }

        public final void amF() {
            AppMethodBeat.m2504i(116786);
            C4990ab.m7410d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
            C7060h.pYm.mo8381e(10453, Integer.valueOf(C42239b.this.gcm), Integer.valueOf(4));
            if (C42239b.this.zGZ != null) {
                C42239b.this.zGZ.setEditTextEnabled(true);
                C42239b.this.zGZ.setStatusBtnEnabled(true);
            }
            AppMethodBeat.m2505o(116786);
        }

        /* renamed from: a */
        public final void mo53424a(boolean z, String[] strArr, long j) {
            AppMethodBeat.m2504i(116787);
            C4990ab.m7411d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", Boolean.valueOf(z), Long.valueOf(j));
            if (C42239b.this.gco != null) {
                C42239b.this.gco.mo21125a(z, strArr, j, C42239b.this.gcn);
            }
            AppMethodBeat.m2505o(116787);
        }
    }

    public C42239b() {
        AppMethodBeat.m2504i(116788);
        AppMethodBeat.m2505o(116788);
    }

    public C42239b(byte b) {
        super((byte) 0);
        AppMethodBeat.m2504i(116789);
        AppMethodBeat.m2505o(116789);
    }

    /* renamed from: a */
    public final void mo67775a(C9756a c9756a) {
        this.gco = c9756a;
        this.zHa = c9756a;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(116790);
        C4990ab.m7410d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.gcp != null) {
            this.gcp.amA();
        }
        if (this.zGZ != null) {
            this.zGZ.setEditTextEnabled(true);
            this.zGZ.setStatusBtnEnabled(true);
        }
        AppMethodBeat.m2505o(116790);
    }

    public final boolean amG() {
        boolean z = false;
        AppMethodBeat.m2504i(116791);
        String str = "MicroMsg.VoiceSearchViewHelper";
        String str2 = "check has voice search, Enable %B, layout is null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.gcl);
        if (this.gcp == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        z = this.gcl;
        AppMethodBeat.m2505o(116791);
        return z;
    }

    public final void amH() {
        AppMethodBeat.m2504i(116792);
        C4990ab.m7410d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.zGZ != null) {
            this.zGZ.setEditTextEnabled(false);
            this.zGZ.setStatusBtnEnabled(false);
        }
        if (this.gcp == null || this.gcp.getVisibility() != 8) {
            AppMethodBeat.m2505o(116792);
            return;
        }
        C4990ab.m7410d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
        VoiceSearchLayout voiceSearchLayout = this.gcp;
        int i = this.gcn;
        C4990ab.m7417i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(C35805b.m58714o(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")));
        if (C35805b.m58714o(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")) {
            boolean z;
            C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.cFy);
            voiceSearchLayout.gbW = i;
            voiceSearchLayout.cFy = true;
            voiceSearchLayout.gbV = false;
            if (voiceSearchLayout.gbT != null) {
                voiceSearchLayout.gbT.amE();
            }
            voiceSearchLayout.setVisibility(0);
            voiceSearchLayout.gci.mo16770ae(50, 50);
            voiceSearchLayout.mo67768dc(true);
            voiceSearchLayout.gch = 0;
            voiceSearchLayout.gca = new C42235f(new C265074(), i);
            C42235f c42235f = voiceSearchLayout.gca;
            C4990ab.m7416i("MicroMsg.SceneVoiceAddr", "start record");
            if (c42235f.gaL == 0 && C5023at.is2G(C4996ah.getContext())) {
                z = true;
            } else {
                z = false;
            }
            c42235f.gaW = z;
            C4990ab.m7417i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", Boolean.valueOf(c42235f.gaW));
            C7305d.post(new C9751a(), "SceneVoiceAddr_record");
            AppMethodBeat.m2505o(116792);
            return;
        }
        if (voiceSearchLayout.getContext() instanceof Activity) {
            C35805b.m58709b((Activity) voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO", 80);
        }
        AppMethodBeat.m2505o(116792);
    }

    /* renamed from: a */
    public final void mo11358a(Activity activity, Menu menu) {
        AppMethodBeat.m2504i(116793);
        super.mo11358a(activity, menu);
        if (this.gcp != null) {
            this.gcp.setOnSearchListener(this.gcq);
        }
        AppMethodBeat.m2505o(116793);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(116794);
        if (4 == i) {
            boolean z;
            if (this.gcp == null || this.gcp.getVisibility() != 0) {
                z = false;
            } else {
                z = true;
            }
            C4990ab.m7411d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", Boolean.valueOf(z));
            cancel();
            if (z) {
                AppMethodBeat.m2505o(116794);
                return true;
            }
        }
        C4990ab.m7410d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(116794);
        return onKeyDown;
    }

    public final void amI() {
        AppMethodBeat.m2504i(116795);
        cancel();
        AppMethodBeat.m2505o(116795);
    }
}
