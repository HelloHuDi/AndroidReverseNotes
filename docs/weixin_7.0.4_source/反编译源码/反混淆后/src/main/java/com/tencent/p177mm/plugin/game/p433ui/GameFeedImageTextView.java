package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12110ad;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedImageTextView */
public class GameFeedImageTextView extends LinearLayout implements OnClickListener {
    private int ieu = 0;
    private C28226d neV;
    private int niA = 0;
    private int niB;
    private GameFeedTitleDescView nim;
    private GameRoundImageView niq;
    private LinearLayout niu;
    private GameRoundImageView niv;
    private GameRoundImageView niw;
    private GameRoundImageView nix;
    private TextView niy;
    private GameFeedSubscriptView niz;

    public GameFeedImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111931);
        super.onFinishInflate();
        this.nim = (GameFeedTitleDescView) findViewById(2131824480);
        this.niq = (GameRoundImageView) findViewById(2131824486);
        this.niu = (LinearLayout) findViewById(2131824487);
        this.niv = (GameRoundImageView) findViewById(2131824488);
        this.niw = (GameRoundImageView) findViewById(2131824489);
        this.nix = (GameRoundImageView) findViewById(2131824490);
        this.niy = (TextView) findViewById(2131824491);
        this.niz = (GameFeedSubscriptView) findViewById(2131824485);
        setOnClickListener(this);
        this.ieu = (C46001c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight();
        this.niA = (this.ieu - (C1338a.fromDPToPix(getContext(), 10) * 2)) / 3;
        this.niB = C1338a.fromDPToPix(getContext(), 105);
        if (this.niA < this.niB) {
            this.niB = this.niA;
        }
        LayoutParams layoutParams = this.niv.getLayoutParams();
        layoutParams.width = this.niB;
        layoutParams.height = this.niB;
        this.niv.setLayoutParams(layoutParams);
        this.niw.setLayoutParams(layoutParams);
        this.nix.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(111931);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111932);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naA == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(111932);
            return;
        }
        this.neV = c28226d;
        C12110ad c12110ad = c28226d.mVH;
        setVisibility(0);
        this.nim.mo73904b(c12110ad.naA.Title, c12110ad.naA.ncM, null);
        if (C5046bo.m7548ek(c12110ad.naA.ncN)) {
            this.niq.setVisibility(8);
            this.niu.setVisibility(8);
        } else {
            int size = c12110ad.naA.ncN.size();
            if (size == 1) {
                this.niu.setVisibility(8);
                this.niq.setVisibility(0);
                C28203e.bFH().mo46097a(this.niq, (String) c12110ad.naA.ncN.get(0), getResources().getDimensionPixelSize(C25738R.dimen.f9905jp), getResources().getDimensionPixelSize(C25738R.dimen.f9904jo), (C46001c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            } else {
                this.niq.setVisibility(8);
                this.niu.setVisibility(0);
                this.niy.setVisibility(8);
                C12125a c12125a = new C12125a();
                c12125a.nnP = true;
                C28207a bFI = c12125a.bFI();
                C28203e.bFH().mo46098a(this.niv, (String) c12110ad.naA.ncN.get(0), bFI);
                C28203e.bFH().mo46098a(this.niw, (String) c12110ad.naA.ncN.get(1), bFI);
                if (size > 2) {
                    C28203e.bFH().mo46098a(this.nix, (String) c12110ad.naA.ncN.get(2), bFI);
                    this.nix.setVisibility(0);
                    if (size > 3) {
                        this.niy.setVisibility(0);
                        this.niy.setText(String.format("共%d张", new Object[]{Integer.valueOf(size)}));
                    }
                } else {
                    this.nix.setVisibility(4);
                }
            }
        }
        this.niz.setData(c12110ad);
        if (!this.neV.mVJ) {
            C34276a.m56205a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.m2505o(111932);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111933);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.m2505o(111933);
            return;
        }
        if (!C5046bo.isNullOrNil(this.neV.mVH.mZj)) {
            C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, C46001c.m85455ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56203T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.m2505o(111933);
    }
}
