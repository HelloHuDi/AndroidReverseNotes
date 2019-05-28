package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.C20998j.C20997a;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.GameDetailRankUI.C34304a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.ui.GameRankHeadView */
public class GameRankHeadView extends LinearLayout implements OnClickListener {
    private TextView gsf;
    private C20992c mYa;
    C20997a ngQ;
    private C21003k ngS;
    private TextView ngo;
    private TextView nlM;
    private ImageView nlN;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameRankHeadView$1 */
    class C247781 implements C20997a {
        C247781() {
        }

        /* renamed from: f */
        public final void mo36316f(int i, String str, boolean z) {
            AppMethodBeat.m2504i(112144);
            if (GameRankHeadView.this.mYa != null) {
                GameRankHeadView.this.ngS.mo36321ei(GameRankHeadView.this.getContext());
                GameRankHeadView.this.ngS.biT();
                if (z) {
                    GameRankHeadView.m85544c(GameRankHeadView.this);
                }
            }
            AppMethodBeat.m2505o(112144);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m85544c(GameRankHeadView gameRankHeadView) {
        AppMethodBeat.m2504i(112149);
        gameRankHeadView.bFm();
        AppMethodBeat.m2505o(112149);
    }

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112145);
        super.onFinishInflate();
        this.gsf = (TextView) findViewById(2131824470);
        this.nlM = (TextView) findViewById(2131824471);
        this.ngo = (TextView) findViewById(2131824472);
        this.nlN = (ImageView) findViewById(2131824473);
        C4990ab.m7416i("MicroMsg.GameRankHeadView", "initView finished");
        AppMethodBeat.m2505o(112145);
    }

    private void bFm() {
        AppMethodBeat.m2504i(112146);
        if (C46494g.m87726a(getContext(), this.mYa)) {
            if (this.mYa.versionCode > C46001c.m85447Or(this.mYa.field_packageName)) {
                this.ngo.setText(C25738R.string.c55);
                AppMethodBeat.m2505o(112146);
                return;
            }
            this.ngo.setText(C25738R.string.c53);
            AppMethodBeat.m2505o(112146);
            return;
        }
        switch (this.mYa.status) {
            case 0:
                if (this.ngS == null) {
                    this.ngo.setVisibility(8);
                    this.nlN.setVisibility(8);
                    AppMethodBeat.m2505o(112146);
                    return;
                }
                this.ngo.setVisibility(0);
                this.nlN.setVisibility(0);
                switch (this.ngS.status) {
                    case 0:
                        this.ngo.setText(C25738R.string.c50);
                        AppMethodBeat.m2505o(112146);
                        return;
                    case 1:
                        this.ngo.setText(C25738R.string.c51);
                        AppMethodBeat.m2505o(112146);
                        return;
                    case 2:
                        this.ngo.setText(C25738R.string.c4z);
                        AppMethodBeat.m2505o(112146);
                        return;
                    case 3:
                        this.ngo.setText(C25738R.string.c52);
                        break;
                }
                AppMethodBeat.m2505o(112146);
                return;
            default:
                this.ngo.setText(C25738R.string.c50);
                AppMethodBeat.m2505o(112146);
                return;
        }
    }

    public void setData(C34304a c34304a) {
        AppMethodBeat.m2504i(112147);
        this.gsf.setText(c34304a.ngJ);
        this.nlM.setText(c34304a.ngK);
        this.mYa = c34304a.ngL;
        this.mYa.cKG = 1203;
        this.mYa.position = 2;
        if (this.ngS == null) {
            this.ngS = new C21003k(this.mYa);
        }
        this.ngS.mo36321ei(getContext());
        this.ngS.biT();
        bFm();
        if (this.ngQ != null) {
            C20998j.m32284a(this.ngQ);
        } else {
            this.ngQ = new C247781();
            C20998j.m32284a(this.ngQ);
        }
        this.ngo.setOnClickListener(this);
        AppMethodBeat.m2505o(112147);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112148);
        new C46016d(getContext()).mo73916a(this.mYa, new C21003k(this.mYa));
        AppMethodBeat.m2505o(112148);
    }
}
