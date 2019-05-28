package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class GameFeedVideoView extends LinearLayout implements OnClickListener {
    private d neV;
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
        AppMethodBeat.i(111957);
        super.onFinishInflate();
        this.nim = (GameFeedTitleDescView) findViewById(R.id.c5d);
        this.nip = (FrameLayout) findViewById(R.id.c5g);
        this.niW = (GameRoundImageView) findViewById(R.id.c62);
        this.niX = (LinearLayout) findViewById(R.id.c63);
        this.niY = (ImageView) findViewById(R.id.c64);
        this.niZ = (TextView) findViewById(R.id.c65);
        this.niz = (GameFeedSubscriptView) findViewById(R.id.c5i);
        setOnClickListener(this);
        AppMethodBeat.o(111957);
    }

    public void setVideoData(d dVar) {
        AppMethodBeat.i(111958);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naB == null || bo.isNullOrNil(dVar.mVH.naB.mZi)) {
            setVisibility(8);
            AppMethodBeat.o(111958);
            return;
        }
        this.neV = dVar;
        ad adVar = dVar.mVH;
        setVisibility(0);
        this.nim.b(adVar.naB.Title, adVar.naB.Desc, null);
        e.bFH().a(this.niW, adVar.naB.mZi, getResources().getDimensionPixelSize(R.dimen.jp), getResources().getDimensionPixelSize(R.dimen.jo), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        if (bo.isNullOrNil(adVar.naB.ndH)) {
            this.niX.setVisibility(8);
        } else {
            this.niX.setVisibility(0);
            this.niY.setVisibility(8);
            this.niZ.setText(adVar.naB.ndH);
        }
        this.niz.setData(adVar);
        AppMethodBeat.o(111958);
    }

    public void setLiveData(d dVar) {
        AppMethodBeat.i(111959);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naC == null) {
            setVisibility(8);
            AppMethodBeat.o(111959);
            return;
        }
        this.neV = dVar;
        ad adVar = dVar.mVH;
        setVisibility(0);
        this.nim.b(adVar.naC.Title, adVar.naC.Desc, null);
        if (bo.isNullOrNil(adVar.naC.mZi)) {
            this.nip.setVisibility(8);
        } else {
            this.nip.setVisibility(0);
            e.bFH().a(this.niW, adVar.naC.mZi, getResources().getDimensionPixelSize(R.dimen.jp), getResources().getDimensionPixelSize(R.dimen.jo), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        }
        if (bo.isNullOrNil(adVar.naC.ncZ)) {
            this.niX.setVisibility(8);
        } else {
            this.niX.setVisibility(0);
            this.niY.setVisibility(0);
            this.niZ.setText(adVar.naC.ncZ);
        }
        this.niz.setData(adVar);
        if (!this.neV.mVJ) {
            a.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.o(111959);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111960);
        if (this.neV == null) {
            AppMethodBeat.o(111960);
            return;
        }
        if (!bo.isNullOrNil(this.neV.mVH.mZj)) {
            b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), a.T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.o(111960);
    }
}
