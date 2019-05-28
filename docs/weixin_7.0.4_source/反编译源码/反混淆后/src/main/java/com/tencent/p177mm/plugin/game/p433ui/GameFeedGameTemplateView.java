package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tencent.p177mm.plugin.game.widget.GameTagListView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView */
public class GameFeedGameTemplateView extends LinearLayout implements OnClickListener {
    private TextView kEq;
    private int neT;
    private C28226d neV;
    private ImageView ngV;
    private TextView ngW;
    private GameTagListView nio;
    private FrameLayout nip;
    private GameRoundImageView niq;
    private ImageView nir;
    private GameFeedSubscriptView nis;
    private GameDownloadView nit;

    public GameFeedGameTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111925);
        super.onFinishInflate();
        this.ngV = (ImageView) findViewById(2131821535);
        this.ngW = (TextView) findViewById(2131821537);
        this.nio = (GameTagListView) findViewById(2131824482);
        this.kEq = (TextView) findViewById(2131821095);
        this.nip = (FrameLayout) findViewById(2131824483);
        this.niq = (GameRoundImageView) findViewById(2131820629);
        this.nir = (ImageView) findViewById(2131824484);
        this.nis = (GameFeedSubscriptView) findViewById(2131824485);
        this.nit = (GameDownloadView) findViewById(2131824317);
        setOnClickListener(this);
        this.neT = C46001c.getScreenWidth(getContext()) - C1338a.fromDPToPix(getContext(), ErrorCode.NEEDDOWNLOAD_FALSE_5);
        AppMethodBeat.m2505o(111925);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(111926);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(111926);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(111927);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(111927);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111928);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naE == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(111928);
            return;
        }
        this.neV = c28226d;
        C12110ad c12110ad = c28226d.mVH;
        setVisibility(0);
        C28203e.bFH().mo46096a(this.ngV, c12110ad.naE.mZk.mZr, C1338a.getDensity(getContext()));
        this.ngW.setText(c12110ad.naE.mZk.Name);
        this.nio.mo46170f(c12110ad.naE.mZk.mZH, this.neT);
        if (C5046bo.isNullOrNil(c12110ad.naE.nbp)) {
            this.kEq.setVisibility(8);
        } else {
            this.kEq.setText(c12110ad.naE.nbp);
            this.kEq.setVisibility(0);
        }
        this.nip.setVisibility(0);
        if (!C5046bo.isNullOrNil(c12110ad.naE.nbr)) {
            m66834c(this.niq, c12110ad.naE.mZi);
            this.nir.setVisibility(0);
        } else if (C5046bo.isNullOrNil(c12110ad.naE.mZi)) {
            this.nip.setVisibility(8);
        } else {
            m66834c(this.niq, c12110ad.naE.mZi);
            this.nir.setVisibility(8);
        }
        this.nip.setOnClickListener(this);
        this.nis.setData(c12110ad);
        C20992c a = C39216x.m66823a(this.neV.mVH.naE.mZk);
        a.scene = 10;
        a.cKG = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        a.position = this.neV.position;
        this.nit.setDownloadInfo(new C21003k(a));
        if (!this.neV.mVJ) {
            C34276a.m56205a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.m2505o(111928);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111929);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.m2505o(111929);
        } else if (view.getId() != 2131824483 || C5046bo.isNullOrNil(this.neV.mVH.naE.nbq)) {
            if (!C5046bo.isNullOrNil(this.neV.mVH.mZj)) {
                C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "card"));
            }
            AppMethodBeat.m2505o(111929);
        } else {
            C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.naE.nbq), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "middle"));
            AppMethodBeat.m2505o(111929);
        }
    }

    /* renamed from: c */
    private void m66834c(ImageView imageView, String str) {
        AppMethodBeat.m2504i(111930);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9912jy);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.f9911jx);
        C28203e.bFH().mo46097a(imageView, str, dimensionPixelSize, dimensionPixelSize2, (C46001c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        AppMethodBeat.m2505o(111930);
    }
}
