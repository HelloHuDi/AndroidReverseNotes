package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.C20998j.C20997a;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.widget.TextProgressBar;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadView */
public class GameDownloadView extends FrameLayout implements OnClickListener {
    private C20997a ngQ = new C282474();
    private C21003k ngS;
    private Button nhX;
    private TextProgressBar nhY;
    private C46016d nhZ;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadView$2 */
    class C121802 implements Runnable {
        C121802() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111893);
            GameDownloadView.this.ngS.mo36321ei(C4996ah.getContext());
            GameDownloadView.this.ngS.biT();
            GameDownloadView.m56248a(GameDownloadView.this);
            AppMethodBeat.m2505o(111893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadView$1 */
    class C282451 implements DialogInterface.OnClickListener {
        C282451() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(111892);
            GameDownloadView.m56248a(GameDownloadView.this);
            AppMethodBeat.m2505o(111892);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadView$3 */
    class C282463 implements Runnable {
        C282463() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111894);
            GameDownloadView.this.nhZ.mo73915a(GameDownloadView.this.nhY, GameDownloadView.this.nhX, GameDownloadView.this.ngS.mVZ, GameDownloadView.this.ngS);
            AppMethodBeat.m2505o(111894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadView$4 */
    class C282474 implements C20997a {
        C282474() {
        }

        /* renamed from: f */
        public final void mo36316f(int i, String str, boolean z) {
            AppMethodBeat.m2504i(111895);
            if (!z || C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(111895);
            } else if (GameDownloadView.this.ngS == null || GameDownloadView.this.ngS.mVZ == null || !GameDownloadView.this.ngS.mVZ.field_appId.equals(str)) {
                AppMethodBeat.m2505o(111895);
            } else {
                GameDownloadView.this.refresh();
                AppMethodBeat.m2505o(111895);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m56248a(GameDownloadView gameDownloadView) {
        AppMethodBeat.m2504i(111904);
        gameDownloadView.bFm();
        AppMethodBeat.m2505o(111904);
    }

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111896);
        AppMethodBeat.m2505o(111896);
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(111897);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(2130969704, this, true);
        this.nhX = (Button) inflate.findViewById(2131824401);
        this.nhY = (TextProgressBar) inflate.findViewById(2131824402);
        this.nhY.setTextSize(14);
        this.nhX.setOnClickListener(this);
        this.nhY.setOnClickListener(this);
        this.nhZ = new C46016d(getContext());
        this.nhZ.neA = new C282451();
        AppMethodBeat.m2505o(111897);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(111898);
        super.onDetachedFromWindow();
        C20998j.m32288b(this.ngQ);
        AppMethodBeat.m2505o(111898);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(111899);
        super.onAttachedToWindow();
        C20998j.m32284a(this.ngQ);
        AppMethodBeat.m2505o(111899);
    }

    public final void refresh() {
        AppMethodBeat.m2504i(111900);
        if (this.ngS != null) {
            this.ngS.mo36321ei(C4996ah.getContext());
            this.ngS.biT();
            bFm();
        }
        AppMethodBeat.m2505o(111900);
    }

    public void setDownloadInfo(C21003k c21003k) {
        AppMethodBeat.m2504i(111901);
        this.ngS = c21003k;
        C46001c.aNS().mo10302aa(new C121802());
        bFm();
        AppMethodBeat.m2505o(111901);
    }

    private void bFm() {
        AppMethodBeat.m2504i(111902);
        C5004al.m7441d(new C282463());
        AppMethodBeat.m2505o(111902);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111903);
        this.ngS.mo36321ei(C4996ah.getContext());
        this.nhZ.mo73916a(this.ngS.mVZ, this.ngS);
        AppMethodBeat.m2505o(111903);
    }
}
