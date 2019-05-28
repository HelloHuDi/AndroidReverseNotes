package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.model.C39216x;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12123y;
import com.tencent.p177mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.p177mm.plugin.game.widget.GameTagListView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameBestSellingItemView */
public class GameBestSellingItemView extends LinearLayout implements OnClickListener {
    AutoResizeTextView neN;
    ImageView neO;
    TextView neP;
    GameTagListView neQ;
    GameDownloadView neR;
    View neS;
    private int neT;
    private C12123y neU;
    private C28226d neV;

    public GameBestSellingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111729);
        super.onFinishInflate();
        this.neN = (AutoResizeTextView) findViewById(2131824295);
        this.neO = (ImageView) findViewById(2131821535);
        this.neP = (TextView) findViewById(2131821537);
        this.neQ = (GameTagListView) findViewById(2131824297);
        this.neR = (GameDownloadView) findViewById(2131824296);
        this.neS = findViewById(2131824298);
        this.neT = C46001c.getScreenWidth(getContext()) - C1338a.fromDPToPix(getContext(), FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        setOnClickListener(this);
        AppMethodBeat.m2505o(111729);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111730);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naG == null || C5046bo.m7548ek(c28226d.mVH.naG.mZK)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111730);
            return;
        }
        this.neV = c28226d;
        C12123y c12123y = (C12123y) c28226d.mVH.naG.mZK.get(c28226d.mVI);
        int i = c28226d.mVI + 1;
        if (c12123y == null || c12123y.mZk == null) {
            setVisibility(8);
        } else {
            this.neU = c12123y;
            C20992c a = C39216x.m66823a(this.neU.mZk);
            a.scene = 10;
            a.cKG = 1022;
            a.position = this.neV.mVI + 1;
            this.neR.setDownloadInfo(new C21003k(a));
            setVisibility(0);
            this.neN.setText(String.valueOf(i));
            if (i == 1) {
                this.neN.setTextColor(C46001c.parseColor("#EED157"));
            } else if (i == 2) {
                this.neN.setTextColor(C46001c.parseColor("#BDC5CB"));
            } else if (i == 3) {
                this.neN.setTextColor(C46001c.parseColor("#D4B897"));
            } else {
                this.neN.setTextColor(C46001c.parseColor("#B2B2B2"));
            }
            C28203e.bFH().mo46096a(this.neO, c12123y.mZk.mZr, C1338a.getDensity(getContext()));
            this.neP.setText(c12123y.mZk.Name);
            this.neQ.mo46170f(c12123y.mZk.mZH, this.neT);
            if (C5046bo.m7548ek(c12123y.nar) && c12123y.nas == null && c12123y.Desc == null) {
                this.neS.setVisibility(8);
            } else {
                if (this.neS instanceof ViewStub) {
                    this.neS = ((ViewStub) this.neS).inflate();
                }
                ((GameFeedSocialInfoView) this.neS.findViewById(2131824642)).setData(c12123y);
            }
        }
        if (!c28226d.mVJ) {
            C34276a.m56205a(getContext(), 10, 1022, c28226d.mVI + 1, c12123y.mZk.mZr, GameIndexListView.getSourceScene(), C34276a.m56208kY(c28226d.mVH.mZL));
            c28226d.mVJ = true;
        }
        AppMethodBeat.m2505o(111730);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111731);
        if (this.neU == null || C5046bo.isNullOrNil(this.neU.mZk.mZm)) {
            AppMethodBeat.m2505o(111731);
            return;
        }
        C34277b.m56211a(getContext(), 10, 1022, this.neV.mVI + 1, C46001c.m85455ax(getContext(), this.neU.mZk.mZm), this.neU.mZk.mZr, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
        AppMethodBeat.m2505o(111731);
    }
}
