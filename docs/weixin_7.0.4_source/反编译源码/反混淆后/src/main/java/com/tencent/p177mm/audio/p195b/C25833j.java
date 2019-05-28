package com.tencent.p177mm.audio.p195b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C9035b.C9039a;
import com.tencent.p177mm.compatible.p219b.C18168c.C18169a;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.audio.b.j */
public final class C25833j {
    public static int cri = 100;
    private C45293b cop = new C45293b(C4996ah.getContext());
    public C9035b crg = new C9035b(C18169a.AMR);
    public C1294a crh = null;
    String fileName = "";
    public int status = 0;

    /* renamed from: com.tencent.mm.audio.b.j$a */
    public interface C1294a {
        void onError();
    }

    /* renamed from: com.tencent.mm.audio.b.j$1 */
    class C258341 implements C9039a {
        C258341() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(116529);
            C25833j.this.cop.mo73178Mm();
            if (C25833j.this.crh != null) {
                C25833j.this.crh.onError();
            }
            try {
                C25833j.this.crg.release();
                C25833j.this.status = -1;
                AppMethodBeat.m2505o(116529);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + C25833j.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                AppMethodBeat.m2505o(116529);
            }
        }
    }

    public C25833j() {
        AppMethodBeat.m2504i(116530);
        AppMethodBeat.m2505o(116530);
    }

    /* renamed from: en */
    public final boolean mo43819en(String str) {
        AppMethodBeat.m2504i(116531);
        C1446a c1446a = new C1446a();
        if (this.fileName.length() > 0) {
            C4990ab.m7412e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            AppMethodBeat.m2505o(116531);
            return false;
        }
        this.fileName = str;
        try {
            this.cop.requestFocus();
            this.crg.mo20473a(new C258341());
            this.crg.mo20469EE();
            this.crg.mo20470EF();
            this.crg.mo20468ED();
            this.crg.setOutputFile(this.fileName);
            this.crg.setMaxDuration(3600010);
            this.crg.prepare();
            this.crg.start();
            C4990ab.m7410d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + c1446a.mo4908Mr());
            this.status = 1;
            AppMethodBeat.m2505o(116531);
            return true;
        } catch (Exception e) {
            this.cop.mo73178Mm();
            C4990ab.m7412e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.m2505o(116531);
            return false;
        }
    }

    /* renamed from: EB */
    public final boolean mo43818EB() {
        AppMethodBeat.m2504i(116532);
        this.cop.mo73178Mm();
        if (this.crg == null) {
            AppMethodBeat.m2505o(116532);
            return true;
        }
        try {
            this.crg.mo20472EH();
            this.crg.release();
            this.fileName = "";
            this.status = 0;
            AppMethodBeat.m2505o(116532);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            AppMethodBeat.m2505o(116532);
            return false;
        }
    }
}
