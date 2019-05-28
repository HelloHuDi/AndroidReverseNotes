package com.tencent.p177mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C45162a;
import com.tencent.p177mm.audio.p195b.C9035b;
import com.tencent.p177mm.audio.p195b.C9035b.C9039a;
import com.tencent.p177mm.compatible.p219b.C18168c.C18169a;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.p183ai.C41737j.C37445a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelvoice.t */
public final class C1885t implements C45162a {
    private static int cri = 100;
    private C9035b crg;
    String fileName = "";
    private C37445a gat = null;
    private int status = 0;

    /* renamed from: com.tencent.mm.modelvoice.t$1 */
    class C18861 implements C9039a {
        C18861() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(116658);
            if (C1885t.this.gat != null) {
                C1885t.this.gat.onError();
            }
            try {
                C1885t.this.crg.release();
                C1885t.this.status = -1;
                AppMethodBeat.m2505o(116658);
            } catch (Exception e) {
                C4990ab.m7412e("VoiceRecorder", "setErrorListener File[" + C1885t.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                AppMethodBeat.m2505o(116658);
            }
        }
    }

    public final int getStatus() {
        return this.status;
    }

    /* renamed from: EC */
    public final int mo5465EC() {
        C9035b c9035b = this.crg;
        if ((c9035b.cpa == C18169a.PCM || c9035b.cpa == C18169a.SILK) && c9035b.coZ != null) {
            return c9035b.coZ.cpR;
        }
        return 1;
    }

    /* renamed from: a */
    public final void mo5466a(C37445a c37445a) {
        this.gat = c37445a;
    }

    public C1885t(C18169a c18169a) {
        AppMethodBeat.m2504i(116659);
        this.crg = new C9035b(c18169a);
        AppMethodBeat.m2505o(116659);
    }

    /* renamed from: el */
    public final boolean mo5467el(String str) {
        AppMethodBeat.m2504i(116660);
        String str2 = "VoiceRecorder";
        String str3 = "[startRecord] fileName:%s size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(C5046bo.isNullOrNil(str) ? 0 : str.length());
        C4990ab.m7417i(str2, str3, objArr);
        C1446a c1446a = new C1446a();
        if (this.fileName.length() > 0) {
            C4990ab.m7412e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            AppMethodBeat.m2505o(116660);
            return false;
        }
        this.fileName = str;
        try {
            this.crg.mo20473a(new C18861());
            this.crg.mo20469EE();
            this.crg.mo20470EF();
            this.crg.mo20468ED();
            this.crg.setOutputFile(this.fileName);
            this.crg.setMaxDuration(70000);
            this.crg.prepare();
            this.crg.start();
            C4990ab.m7410d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + c1446a.mo4908Mr());
            this.status = 1;
            AppMethodBeat.m2505o(116660);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.m2505o(116660);
            return false;
        }
    }

    /* renamed from: EB */
    public final boolean mo5464EB() {
        AppMethodBeat.m2504i(116661);
        if (this.crg == null) {
            AppMethodBeat.m2505o(116661);
            return true;
        }
        try {
            this.crg.mo20472EH();
            this.crg.release();
            this.fileName = "";
            this.status = 0;
            AppMethodBeat.m2505o(116661);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.m2505o(116661);
            return false;
        }
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.m2504i(116662);
        if (this.status == 1) {
            int maxAmplitude = this.crg.getMaxAmplitude();
            if (maxAmplitude > cri) {
                cri = maxAmplitude;
            }
            maxAmplitude = (maxAmplitude * 100) / cri;
            AppMethodBeat.m2505o(116662);
            return maxAmplitude;
        }
        AppMethodBeat.m2505o(116662);
        return 0;
    }
}
