package com.tencent.p177mm.plugin.masssend.p452ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p195b.C32307h;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C41737j.C37445a;
import com.tencent.p177mm.p183ai.C41737j.C41738b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.masssend.p992a.C12488f;
import com.tencent.p177mm.plugin.masssend.p992a.C39356a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23288b;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.masssend.ui.b */
public final class C28482b implements C23288b {
    final C7564ap gci = new C7564ap(new C284831(), true);
    private Vibrator kgA;
    long miD = -1;
    Toast miE;
    final C7564ap miP = new C7564ap(new C212724(), true);
    MassSendMsgUI ooq;
    ChatFooter oor;
    C12513a oos;
    ToneGenerator oot;
    private String oou;
    private List<String> oov;
    private boolean oow;
    private final C37445a oox = new C284842();
    private final C41738b ooy = new C284853();
    C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.masssend.ui.b$6 */
    class C34476 implements Runnable {
        C34476() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22772);
            C28482b.this.oot.stopTone();
            AppMethodBeat.m2505o(22772);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.b$a */
    class C12513a extends C32307h {
        String fileName;

        public C12513a(Context context) {
            super(context, false);
        }

        public final String getFileName() {
            return this.fileName;
        }

        /* renamed from: EH */
        public final boolean mo24432EH() {
            AppMethodBeat.m2504i(22774);
            this.fileName = super.getFileName();
            boolean EH = super.mo24432EH();
            super.reset();
            AppMethodBeat.m2505o(22774);
            return EH;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.b$4 */
    class C212724 implements C5015a {
        C212724() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(22770);
            if (C28482b.this.miD == -1) {
                C28482b.this.miD = C5046bo.m7588yz();
            }
            long az = C5046bo.m7525az(C28482b.this.miD);
            if (az >= 50000 && az <= 60000) {
                int i;
                if (C28482b.this.miE == null) {
                    i = (int) ((60000 - az) / 1000);
                    C28482b.this.miE = Toast.makeText(C28482b.this.ooq, C28482b.this.ooq.getResources().getQuantityString(C25738R.plurals.f9591c, i, new Object[]{Integer.valueOf(i)}), 0);
                } else {
                    i = (int) ((60000 - az) / 1000);
                    C28482b.this.miE.setText(C28482b.this.ooq.getResources().getQuantityString(C25738R.plurals.f9591c, i, new Object[]{Integer.valueOf(i)}));
                }
                C28482b.this.miE.show();
            }
            if (az >= 60000) {
                C4990ab.m7418v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
                if (C28482b.this.oos.mo24432EH()) {
                    C28482b.this.bNH();
                }
                C28482b.this.oor.bvH();
                C35988ay.m59201au(C28482b.this.ooq, C25738R.string.ew8);
                AppMethodBeat.m2505o(22770);
                return false;
            }
            AppMethodBeat.m2505o(22770);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.b$1 */
    class C284831 implements C5015a {
        C284831() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(22767);
            C28482b.this.oor.mo63902Lf(C28482b.this.oos.getMaxAmplitude());
            AppMethodBeat.m2505o(22767);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.b$2 */
    class C284842 implements C37445a {
        C284842() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(22768);
            C28482b.this.oos.reset();
            C28482b.this.gci.stopTimer();
            C28482b.this.miP.stopTimer();
            C4997aj.amB("keep_app_silent");
            C28482b.this.oor.bvH();
            C4990ab.m7418v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
            Toast.makeText(C28482b.this.ooq, C28482b.this.ooq.getString(C25738R.string.anm), 0).show();
            AppMethodBeat.m2505o(22768);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.b$3 */
    class C284853 implements C41738b {
        C284853() {
        }

        public final void acE() {
            AppMethodBeat.m2504i(22769);
            C28482b.this.oor.dki();
            AppMethodBeat.m2505o(22769);
        }
    }

    public C28482b(MassSendMsgUI massSendMsgUI, ChatFooter chatFooter, String str, List<String> list, boolean z) {
        AppMethodBeat.m2504i(22775);
        this.ooq = massSendMsgUI;
        this.oor = chatFooter;
        this.oou = str;
        this.oov = list;
        this.oow = z;
        this.oos = new C12513a(massSendMsgUI);
        this.oos.mo47621a(this.oox);
        this.oos.mo47622a(this.ooy);
        this.oot = new ToneGenerator(1, 60);
        this.kgA = (Vibrator) massSendMsgUI.getSystemService("vibrator");
        AppMethodBeat.m2505o(22775);
    }

    public final boolean bNG() {
        AppMethodBeat.m2504i(22776);
        this.gci.stopTimer();
        this.miP.stopTimer();
        this.miD = -1;
        if (this.oos.mo24432EH()) {
            bNH();
            this.oor.bvH();
        } else {
            this.oor.ddN();
        }
        C9638aw.m17176Cc().mo4648Ic();
        AppMethodBeat.m2505o(22776);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void bNH() {
        AppMethodBeat.m2504i(22777);
        C39356a c39356a = new C39356a();
        c39356a.onZ = this.oou;
        c39356a.ooa = this.oov.size();
        c39356a.filename = this.oos.fileName;
        c39356a.msgType = 34;
        c39356a.oob = this.oos.cqD;
        final C1207m c12488f = new C12488f(c39356a, this.oow);
        C9638aw.m17182Rg().mo14541a(c12488f, 0);
        Context context = this.ooq;
        this.ooq.getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, this.ooq.getString(C25738R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(22771);
                C9638aw.m17182Rg().mo14547c(c12488f);
                if (C28482b.this.tipDialog != null) {
                    C28482b.this.tipDialog.dismiss();
                    C28482b.this.tipDialog = null;
                }
                AppMethodBeat.m2505o(22771);
            }
        });
        AppMethodBeat.m2505o(22777);
    }

    public final boolean bNI() {
        AppMethodBeat.m2504i(22778);
        this.gci.stopTimer();
        this.miP.stopTimer();
        this.miD = -1;
        this.oor.bvH();
        C12513a c12513a = this.oos;
        c12513a.mo24432EH();
        C32850q.m53733uT(c12513a.fileName);
        C9638aw.m17176Cc().mo4648Ic();
        AppMethodBeat.m2505o(22778);
        return false;
    }

    public final boolean bNJ() {
        AppMethodBeat.m2504i(22779);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            this.oot.startTone(24);
            new C7306ak().postDelayed(new C34476(), 200);
            this.kgA.vibrate(50);
            this.gci.mo16770ae(100, 100);
            this.miP.mo16770ae(200, 200);
            this.oor.mo63901Le(this.ooq.getResources().getDisplayMetrics().heightPixels - this.oor.getHeight());
            this.oos.mo47624em("_USER_FOR_THROWBOTTLE_");
            this.oos.mo47622a(this.ooy);
            this.oos.mo47621a(this.oox);
            C9638aw.m17176Cc().mo4649Id();
            AppMethodBeat.m2505o(22779);
        } else {
            C23639t.m36492hO(this.ooq);
            AppMethodBeat.m2505o(22779);
        }
        return false;
    }

    /* renamed from: Qu */
    public final boolean mo38999Qu(String str) {
        AppMethodBeat.m2504i(22780);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(22780);
            return false;
        }
        MassSendMsgUI.m20402Qy(str);
        C39356a c39356a = new C39356a();
        c39356a.onZ = this.oou;
        c39356a.ooa = this.oov.size();
        c39356a.filename = str;
        c39356a.msgType = 1;
        final C1207m c12488f = new C12488f(c39356a, this.oow);
        C9638aw.m17182Rg().mo14541a(c12488f, 0);
        Context context = this.ooq;
        this.ooq.getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, this.ooq.getString(C25738R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(22773);
                C9638aw.m17182Rg().mo14547c(c12488f);
                if (C28482b.this.tipDialog != null) {
                    C28482b.this.tipDialog.dismiss();
                    C28482b.this.tipDialog = null;
                }
                AppMethodBeat.m2505o(22773);
            }
        });
        AppMethodBeat.m2505o(22780);
        return true;
    }

    public final void bNK() {
    }

    public final void bNL() {
    }

    /* renamed from: I */
    public final void mo38998I(MotionEvent motionEvent) {
    }

    public final void release() {
        AppMethodBeat.m2504i(22781);
        this.oot.release();
        AppMethodBeat.m2505o(22781);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(22782);
        this.gci.stopTimer();
        this.miP.stopTimer();
        this.miD = -1;
        this.oos.mo24432EH();
        C9638aw.m17176Cc().mo4648Ic();
        AppMethodBeat.m2505o(22782);
    }

    /* renamed from: iS */
    public final void mo39005iS(boolean z) {
    }
}
