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
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12110ad;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedVideoView */
public class GameFeedVideoView extends LinearLayout implements OnClickListener {
    private C28226d neV;
    private GameRoundImageView niW;
    private LinearLayout niX;
    private ImageView niY;
    private TextView niZ;
    private GameFeedTitleDescView nim;
    private FrameLayout nip;
    private GameFeedSubscriptView niz;

    public GameFeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111957);
        super.onFinishInflate();
        this.nim = (GameFeedTitleDescView) findViewById(2131824480);
        this.nip = (FrameLayout) findViewById(2131824483);
        this.niW = (GameRoundImageView) findViewById(2131824505);
        this.niX = (LinearLayout) findViewById(2131824506);
        this.niY = (ImageView) findViewById(2131824507);
        this.niZ = (TextView) findViewById(2131824508);
        this.niz = (GameFeedSubscriptView) findViewById(2131824485);
        setOnClickListener(this);
        AppMethodBeat.m2505o(111957);
    }

    public void setVideoData(C28226d c28226d) {
        AppMethodBeat.m2504i(111958);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naB == null || C5046bo.isNullOrNil(c28226d.mVH.naB.mZi)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111958);
            return;
        }
        this.neV = c28226d;
        C12110ad c12110ad = c28226d.mVH;
        setVisibility(0);
        this.nim.mo73904b(c12110ad.naB.Title, c12110ad.naB.Desc, null);
        C28203e.bFH().mo46097a(this.niW, c12110ad.naB.mZi, getResources().getDimensionPixelSize(C25738R.dimen.f9905jp), getResources().getDimensionPixelSize(C25738R.dimen.f9904jo), (C46001c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        if (C5046bo.isNullOrNil(c12110ad.naB.ndH)) {
            this.niX.setVisibility(8);
        } else {
            this.niX.setVisibility(0);
            this.niY.setVisibility(8);
            this.niZ.setText(c12110ad.naB.ndH);
        }
        this.niz.setData(c12110ad);
        AppMethodBeat.m2505o(111958);
    }

    public void setLiveData(C28226d c28226d) {
        AppMethodBeat.m2504i(111959);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naC == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(111959);
            return;
        }
        this.neV = c28226d;
        C12110ad c12110ad = c28226d.mVH;
        setVisibility(0);
        this.nim.mo73904b(c12110ad.naC.Title, c12110ad.naC.Desc, null);
        if (C5046bo.isNullOrNil(c12110ad.naC.mZi)) {
            this.nip.setVisibility(8);
        } else {
            this.nip.setVisibility(0);
            C28203e.bFH().mo46097a(this.niW, c12110ad.naC.mZi, getResources().getDimensionPixelSize(C25738R.dimen.f9905jp), getResources().getDimensionPixelSize(C25738R.dimen.f9904jo), (C46001c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        }
        if (C5046bo.isNullOrNil(c12110ad.naC.ncZ)) {
            this.niX.setVisibility(8);
        } else {
            this.niX.setVisibility(0);
            this.niY.setVisibility(0);
            this.niZ.setText(c12110ad.naC.ncZ);
        }
        this.niz.setData(c12110ad);
        if (!this.neV.mVJ) {
            C34276a.m56205a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.m2505o(111959);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111960);
        if (this.neV == null) {
            AppMethodBeat.m2505o(111960);
            return;
        }
        if (!C5046bo.isNullOrNil(this.neV.mVH.mZj)) {
            C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.m2505o(111960);
    }
}
