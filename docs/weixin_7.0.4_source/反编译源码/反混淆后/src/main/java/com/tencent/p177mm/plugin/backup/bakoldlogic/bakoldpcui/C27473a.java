package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p230g.p231a.C37747jr;
import com.tencent.p177mm.p230g.p231a.C42024md;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e.C11116d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a */
public final class C27473a extends C14933b implements C11116d {
    private static String TAG = "MicroMsg.BakChatBanner";
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private int jAo = 0;
    private View jAp = null;
    private C4884c jAq;
    private int jzK = -1;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a$1 */
    class C111211 extends C4884c<C42024md> {

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a$1$1 */
        class C111221 implements Runnable {
            C111221() {
            }

            public final void run() {
                AppMethodBeat.m2504i(17898);
                if (C27473a.m43588a(C27473a.this)) {
                    C4879a.xxA.mo10055m(new C37747jr());
                }
                AppMethodBeat.m2505o(17898);
            }
        }

        C111211() {
            AppMethodBeat.m2504i(17899);
            this.xxI = C42024md.class.getName().hashCode();
            AppMethodBeat.m2505o(17899);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(17900);
            C27473a.this.getView().post(new C111221());
            AppMethodBeat.m2505o(17900);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a$3 */
    class C274743 implements Runnable {
        C274743() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17902);
            C27473a.this.aMN();
            AppMethodBeat.m2505o(17902);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a$2 */
    class C274752 implements OnClickListener {
        C274752() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17901);
            C27473a.this.jzK = C41257a.aUB().aUC().jzK;
            if (2 == C27473a.this.jzK || 3 == C27473a.this.jzK || 5 == C27473a.this.jzK || 6 == C27473a.this.jzK) {
                C4990ab.m7411d(C27473a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", Integer.valueOf(C41257a.aUB().aUC().jzK), Integer.valueOf(C27473a.this.jAo));
                C27473a.m43591d(C27473a.this);
                AppMethodBeat.m2505o(17901);
            } else if (4 == C27473a.this.jzK) {
                C4990ab.m7411d(C27473a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", Integer.valueOf(C41257a.aUB().aUC().jzK), Integer.valueOf(C27473a.this.jAo));
                C27473a.m43592e(C27473a.this);
                AppMethodBeat.m2505o(17901);
            } else {
                AppMethodBeat.m2505o(17901);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a$4 */
    class C274764 implements Runnable {
        C274764() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17903);
            C27473a.this.aMN();
            AppMethodBeat.m2505o(17903);
        }
    }

    public C27473a(Context context) {
        super(context);
        AppMethodBeat.m2504i(17904);
        if (this.view != null) {
            this.jAp = this.view.findViewById(2131821630);
            this.jAp.setOnClickListener(new C274752());
        }
        aMN();
        this.jAq = new C111211();
        C4879a.xxA.mo10052c(this.jAq);
        AppMethodBeat.m2505o(17904);
    }

    public final int getLayoutId() {
        return 2130968811;
    }

    /* renamed from: fs */
    private boolean m43593fs(boolean z) {
        AppMethodBeat.m2504i(17905);
        this.jzK = C41257a.aUB().aUC().jzK;
        C4990ab.m7411d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", Integer.valueOf(this.jzK), Boolean.valueOf(z));
        if (this.jzK < 2 || this.jzK > 6) {
            this.jAp.setVisibility(8);
            AppMethodBeat.m2505o(17905);
            return false;
        }
        this.jAp.setVisibility(0);
        if (z && !C41257a.aUB().aUC().aUJ()) {
            C41257a.aUB().aUC().mo45238a((C11116d) this);
        }
        if (2 == this.jzK) {
            ((ImageView) this.view.findViewById(2131821631)).setImageResource(C1318a.chatting_backup_computer);
            ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a21, new Object[]{Integer.valueOf(this.jAo)}));
        } else if (3 == this.jzK) {
            ((ImageView) this.view.findViewById(2131821631)).setImageResource(C1318a.chatting_backup_computer);
            ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a24, new Object[]{Integer.valueOf(this.jAo)}));
        } else if (4 == this.jzK) {
            ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a23));
            ((ImageView) this.view.findViewById(2131821631)).setImageResource(C1318a.chatting_backup_comfirm);
        } else if (5 == this.jzK) {
            ((ImageView) this.view.findViewById(2131821631)).setImageResource(C1318a.chatting_backup_computer);
            ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a20, new Object[]{Integer.valueOf(this.jAo)}));
        } else if (6 == this.jzK) {
            ((TextView) this.view.findViewById(2131821632)).setText(C4996ah.getContext().getString(C25738R.string.a22));
            ((ImageView) this.view.findViewById(2131821631)).setImageResource(C1318a.chatting_backup_comfirm);
        }
        AppMethodBeat.m2505o(17905);
        return true;
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(17906);
        this.jAo = C41257a.aUB().aUC().aUM();
        C41257a.aUB().aUC().mo45238a((C11116d) this);
        boolean fs = m43593fs(true);
        AppMethodBeat.m2505o(17906);
        return fs;
    }

    public final void release() {
        AppMethodBeat.m2504i(17907);
        this.jzK = -1;
        C41257a.aUB().aUC().aUK();
        AppMethodBeat.m2505o(17907);
    }

    public final void onError(int i) {
    }

    /* renamed from: rI */
    public final void mo22819rI(int i) {
        AppMethodBeat.m2504i(17908);
        C4990ab.m7411d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(C41257a.aUB().aUC().jzK), Integer.valueOf(i));
        this.jAo = i;
        this.handler.post(new C274743());
        AppMethodBeat.m2505o(17908);
    }

    /* renamed from: rJ */
    public final void mo22820rJ(int i) {
        AppMethodBeat.m2504i(17909);
        C4990ab.m7411d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(C41257a.aUB().aUC().jzK), Integer.valueOf(i));
        AppMethodBeat.m2505o(17909);
    }

    public final void aUP() {
        AppMethodBeat.m2504i(17910);
        C4990ab.m7411d(TAG, "onNetFinish PCBannerStatus:%d", Integer.valueOf(C41257a.aUB().aUC().jzK));
        C41257a.aUB().aUC();
        C27460e.m43573rF(17);
        this.handler.post(new C274764());
        AppMethodBeat.m2505o(17910);
    }

    public final void aSt() {
    }

    public final void aUQ() {
    }

    public final void destroy() {
        AppMethodBeat.m2504i(17911);
        C4879a.xxA.mo10053d(this.jAq);
        AppMethodBeat.m2505o(17911);
    }

    public final int getOrder() {
        return 3;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m43588a(C27473a c27473a) {
        AppMethodBeat.m2504i(17912);
        c27473a.jAo = C41257a.aUB().aUC().aUM();
        C4990ab.m7411d(TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", Integer.valueOf(C41257a.aUB().aUC().jzK), Integer.valueOf(c27473a.jAo));
        boolean fs = c27473a.m43593fs(false);
        AppMethodBeat.m2505o(17912);
        return fs;
    }

    /* renamed from: d */
    static /* synthetic */ void m43591d(C27473a c27473a) {
        AppMethodBeat.m2504i(17913);
        Intent intent = new Intent((Context) c27473a.vlu.get(), BakOperatingUI.class);
        intent.putExtra("from_bak_banner", true);
        MMWizardActivity.m23791J((Context) c27473a.vlu.get(), intent);
        AppMethodBeat.m2505o(17913);
    }

    /* renamed from: e */
    static /* synthetic */ void m43592e(C27473a c27473a) {
        AppMethodBeat.m2504i(17914);
        Intent intent = new Intent((Context) c27473a.vlu.get(), BakFinishUI.class);
        intent.putExtra("cmd", 1);
        MMWizardActivity.m23791J((Context) c27473a.vlu.get(), intent);
        AppMethodBeat.m2505o(17914);
    }
}
