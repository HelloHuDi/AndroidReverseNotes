package com.tencent.p177mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p195b.C25833j;
import com.tencent.p177mm.audio.p195b.C25833j.C1294a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.modelvoice.C9742k;
import com.tencent.p177mm.p1593bk.C41793a;
import com.tencent.p177mm.p183ai.C41737j.C37445a;
import com.tencent.p177mm.plugin.wenote.model.p1665b.C46452a;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.wenote.model.k */
public final class C40371k {
    private static C40371k uNN = null;
    public long duration;
    public C45293b gar = new C45293b(C4996ah.getContext());
    public long ljM;
    public boolean miB;
    public boolean miC;
    public long miD = -1;
    private Toast miE;
    public C25833j miM;
    private final C7306ak miO = new C403703();
    public final C7564ap miP = new C7564ap(new C231825(), true);
    public TextView mkf;
    public String path = "";
    public C9742k uNL;
    public String uNM = "";
    public int uNO = 0;
    public C46452a uNP;
    public C44003l uNQ = null;
    public final C7306ak uNR = new C357414();

    /* renamed from: com.tencent.mm.plugin.wenote.model.k$5 */
    class C231825 implements C5015a {
        C231825() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26668);
            if (C40371k.this.miD == -1) {
                C40371k.this.miD = C5046bo.m7588yz();
            }
            long az = C5046bo.m7525az(C40371k.this.miD);
            if (az >= 3590000 && az <= 3600000) {
                if (C40371k.this.miE == null) {
                    C40371k.this.miE = Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}), 0);
                } else {
                    C40371k.this.miE.setText(C4996ah.getContext().getString(C25738R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}));
                }
                C40371k.this.miE.show();
            }
            if (az >= 3600000) {
                C4990ab.m7418v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
                C40371k.this.miC = true;
                C40371k.m69233i(C40371k.this);
                if (C40371k.this.uNP != null) {
                    C40371k.this.uNP.ddS();
                }
                AppMethodBeat.m2505o(26668);
                return false;
            }
            AppMethodBeat.m2505o(26668);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.k$4 */
    class C357414 extends C7306ak {
        C357414() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(26667);
            if (C40371k.this.uNQ.uOi.booleanValue()) {
                C40371k.this.uNP.ddT();
                C40371k.this.uNQ.uOi = Boolean.FALSE;
            }
            C40371k.this.uNQ.uOB = (int) C41793a.m73795fY(C40371k.m69229e(C40371k.this));
            sendEmptyMessageDelayed(4096, 250);
            AppMethodBeat.m2505o(26667);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.k$3 */
    class C403703 extends C7306ak {
        C403703() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(26666);
            super.handleMessage(message);
            C40371k.this.miB = false;
            AppMethodBeat.m2505o(26666);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.k$1 */
    public class C403721 implements C37445a {
        public final void onError() {
            AppMethodBeat.m2504i(26664);
            C4990ab.m7412e("MicroMsg.WNNoteVoiceLogic", "SpeexRecorder,Record Failed");
            C40371k.this.miP.stopTimer();
            AppMethodBeat.m2505o(26664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.k$2 */
    public class C403732 implements C1294a {
        public final void onError() {
            AppMethodBeat.m2504i(26665);
            C4990ab.m7412e("MicroMsg.WNNoteVoiceLogic", "SimpleVoiceRecorder,Record Failed");
            C40371k.this.miP.stopTimer();
            AppMethodBeat.m2505o(26665);
        }
    }

    /* renamed from: e */
    static /* synthetic */ long m69229e(C40371k c40371k) {
        AppMethodBeat.m2504i(26678);
        long duration = c40371k.getDuration();
        AppMethodBeat.m2505o(26678);
        return duration;
    }

    /* renamed from: i */
    static /* synthetic */ void m69233i(C40371k c40371k) {
        AppMethodBeat.m2504i(26679);
        c40371k.bvG();
        AppMethodBeat.m2505o(26679);
    }

    private C40371k() {
        AppMethodBeat.m2504i(26669);
        AppMethodBeat.m2505o(26669);
    }

    public static C40371k ddK() {
        AppMethodBeat.m2504i(26670);
        if (uNN == null) {
            uNN = new C40371k();
        }
        C40371k c40371k = uNN;
        AppMethodBeat.m2505o(26670);
        return c40371k;
    }

    public final void ddL() {
        AppMethodBeat.m2504i(26671);
        if (this.miB) {
            if (!this.miC) {
                bvG();
            }
            AppMethodBeat.m2505o(26671);
            return;
        }
        AppMethodBeat.m2505o(26671);
    }

    public final String ddM() {
        AppMethodBeat.m2504i(26672);
        String str;
        if (C5730e.m8628ct(this.path)) {
            str = this.path;
            AppMethodBeat.m2505o(26672);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(26672);
        return str;
    }

    private void stopRecord() {
        AppMethodBeat.m2504i(26673);
        if (this.uNM.equals("speex")) {
            this.uNL.mo5464EB();
        } else {
            this.miM.mo43818EB();
        }
        if (this.gar != null) {
            this.gar.mo73178Mm();
        }
        AppMethodBeat.m2505o(26673);
    }

    private void bvG() {
        AppMethodBeat.m2504i(26674);
        if (this.miB) {
            this.uNR.removeMessages(4096);
            stopRecord();
            this.duration = getDuration();
            boolean z = this.duration < 800;
            this.miP.stopTimer();
            if (z) {
                bvI();
                ddN();
            }
            this.miB = false;
            AppMethodBeat.m2505o(26674);
            return;
        }
        AppMethodBeat.m2505o(26674);
    }

    private void ddN() {
        AppMethodBeat.m2504i(26675);
        this.miO.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.m2505o(26675);
    }

    private long getDuration() {
        AppMethodBeat.m2504i(26676);
        if (this.ljM == 0) {
            AppMethodBeat.m2505o(26676);
            return 0;
        }
        long az = C5046bo.m7525az(this.ljM);
        AppMethodBeat.m2505o(26676);
        return az;
    }

    private void bvI() {
        AppMethodBeat.m2504i(26677);
        C5728b c5728b = new C5728b(this.path);
        if (c5728b.exists()) {
            c5728b.delete();
        }
        AppMethodBeat.m2505o(26677);
    }

    public static void destroy() {
        uNN = null;
    }

    public static C40371k ddO() {
        return uNN;
    }
}
