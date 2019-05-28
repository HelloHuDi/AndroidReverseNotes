package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedMatchView extends LinearLayout implements OnClickListener {
    private d neV;
    private GameRoundImageView niC;
    private GameFeedTitleDescView nim;
    private GameFeedSubscriptView niz;

    public GameFeedMatchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111934);
        super.onFinishInflate();
        this.nim = (GameFeedTitleDescView) findViewById(R.id.c5d);
        this.niC = (GameRoundImageView) findViewById(R.id.c5j);
        this.niz = (GameFeedSubscriptView) findViewById(R.id.c5i);
        setOnClickListener(this);
        AppMethodBeat.o(111934);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111935);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naD == null) {
            setVisibility(8);
            AppMethodBeat.o(111935);
            return;
        }
        this.neV = dVar;
        ad adVar = dVar.mVH;
        setVisibility(0);
        this.nim.b(adVar.naD.Title, adVar.naD.Desc, null);
        if (bo.isNullOrNil(adVar.naD.mZi)) {
            setVisibility(8);
        } else {
            this.niC.setVisibility(0);
            e.bFH().a(this.niC, adVar.naD.mZi, getResources().getDimensionPixelSize(R.dimen.jy), getResources().getDimensionPixelSize(R.dimen.jx), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        }
        this.niz.setData(adVar);
        if (!this.neV.mVJ) {
            a.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.o(111935);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111936);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.o(111936);
            return;
        }
        if (!bo.isNullOrNil(this.neV.mVH.mZj)) {
            b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.o(111936);
    }
}
