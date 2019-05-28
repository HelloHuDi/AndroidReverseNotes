package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.model.C39216x;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12110ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate */
public class GameFeedNoGamePlayTemplate extends LinearLayout implements OnClickListener {
    private ImageView iUn;
    GameDownloadView neR;
    private C28226d neV;
    private GameFeedTitleDescView niD;
    private FrameLayout niE;
    private RelativeLayout niF;
    private TextView niG;
    private GameRoundImageView niq;
    private ImageView nir;

    public GameFeedNoGamePlayTemplate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(111942);
        super.onFinishInflate();
        this.niD = (GameFeedTitleDescView) findViewById(2131824480);
        this.niE = (FrameLayout) findViewById(2131824493);
        this.niq = (GameRoundImageView) findViewById(2131824494);
        this.nir = (ImageView) findViewById(2131824484);
        this.niF = (RelativeLayout) findViewById(2131824495);
        this.iUn = (ImageView) findViewById(2131821535);
        this.niG = (TextView) findViewById(2131821537);
        this.neR = (GameDownloadView) findViewById(2131824317);
        setOnClickListener(this);
        this.niE.setOnClickListener(this);
        AppMethodBeat.m2505o(111942);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111943);
        C4990ab.m7410d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naF == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(111943);
            return;
        }
        C4990ab.m7410d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
        this.neV = c28226d;
        C12110ad c12110ad = c28226d.mVH;
        setVisibility(0);
        this.niD.mo73904b(c12110ad.naF.Title, c12110ad.naF.Desc, c12110ad.naF.ndm);
        this.niE.setVisibility(0);
        if (C5046bo.isNullOrNil(c12110ad.naF.mZi)) {
            this.niE.setVisibility(8);
        } else {
            C28203e.bFH().mo46097a(this.niq, c12110ad.naF.mZi, getResources().getDimensionPixelSize(C25738R.dimen.f9912jy), getResources().getDimensionPixelSize(C25738R.dimen.f9911jx), (C46001c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            if (C5046bo.isNullOrNil(c12110ad.naF.nbr)) {
                this.nir.setVisibility(8);
            } else {
                this.nir.setVisibility(0);
            }
        }
        if (c12110ad.naF.mZk != null) {
            this.niF.setVisibility(0);
            C28203e.bFH().mo46096a(this.iUn, c12110ad.naF.mZk.mZr, C1338a.getDensity(getContext()));
            this.niG.setText(c12110ad.naF.mZk.Name);
            C20992c a = C39216x.m66823a(c12110ad.naF.mZk);
            a.scene = 10;
            a.cKG = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            a.position = this.neV.position;
            this.neR.setDownloadInfo(new C21003k(a));
        }
        if (!this.neV.mVJ) {
            C34276a.m56205a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.m2505o(111943);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111944);
        if (this.neV == null || this.neV.mVH == null || this.neV.mVH.naF == null) {
            AppMethodBeat.m2505o(111944);
        } else if (view.getId() != 2131824493 || C5046bo.isNullOrNil(this.neV.mVH.naF.nbr)) {
            if (!C5046bo.isNullOrNil(this.neV.mVH.mZj)) {
                C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "card"));
            }
            AppMethodBeat.m2505o(111944);
        } else {
            C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.naF.nbr), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "middle"));
            AppMethodBeat.m2505o(111944);
        }
    }
}
