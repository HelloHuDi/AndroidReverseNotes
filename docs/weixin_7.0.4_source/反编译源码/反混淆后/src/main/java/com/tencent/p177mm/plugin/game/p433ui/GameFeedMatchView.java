package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
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

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedMatchView */
public class GameFeedMatchView extends LinearLayout implements OnClickListener {
    private C28226d neV;
    private GameRoundImageView niC;
    private GameFeedTitleDescView nim;
    private GameFeedSubscriptView niz;

    public GameFeedMatchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111934);
        super.onFinishInflate();
        this.nim = (GameFeedTitleDescView) findViewById(2131824480);
        this.niC = (GameRoundImageView) findViewById(2131824486);
        this.niz = (GameFeedSubscriptView) findViewById(2131824485);
        setOnClickListener(this);
        AppMethodBeat.m2505o(111934);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111935);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naD == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(111935);
            return;
        }
        this.neV = c28226d;
        C12110ad c12110ad = c28226d.mVH;
        setVisibility(0);
        this.nim.mo73904b(c12110ad.naD.Title, c12110ad.naD.Desc, null);
        if (C5046bo.isNullOrNil(c12110ad.naD.mZi)) {
            setVisibility(8);
        } else {
            this.niC.setVisibility(0);
            C28203e.bFH().mo46097a(this.niC, c12110ad.naD.mZi, getResources().getDimensionPixelSize(C25738R.dimen.f9912jy), getResources().getDimensionPixelSize(C25738R.dimen.f9911jx), (C46001c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        }
        this.niz.setData(c12110ad);
        if (!this.neV.mVJ) {
            C34276a.m56205a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.m2505o(111935);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111936);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.m2505o(111936);
            return;
        }
        if (!C5046bo.isNullOrNil(this.neV.mVH.mZj)) {
            C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.m2505o(111936);
    }
}
