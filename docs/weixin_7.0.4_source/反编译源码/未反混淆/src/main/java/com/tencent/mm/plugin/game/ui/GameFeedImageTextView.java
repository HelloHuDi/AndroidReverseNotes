package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedImageTextView extends LinearLayout implements OnClickListener {
    private int ieu = 0;
    private d neV;
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
        AppMethodBeat.i(111931);
        super.onFinishInflate();
        this.nim = (GameFeedTitleDescView) findViewById(R.id.c5d);
        this.niq = (GameRoundImageView) findViewById(R.id.c5j);
        this.niu = (LinearLayout) findViewById(R.id.c5k);
        this.niv = (GameRoundImageView) findViewById(R.id.c5l);
        this.niw = (GameRoundImageView) findViewById(R.id.c5m);
        this.nix = (GameRoundImageView) findViewById(R.id.c5n);
        this.niy = (TextView) findViewById(R.id.c5o);
        this.niz = (GameFeedSubscriptView) findViewById(R.id.c5i);
        setOnClickListener(this);
        this.ieu = (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight();
        this.niA = (this.ieu - (a.fromDPToPix(getContext(), 10) * 2)) / 3;
        this.niB = a.fromDPToPix(getContext(), 105);
        if (this.niA < this.niB) {
            this.niB = this.niA;
        }
        LayoutParams layoutParams = this.niv.getLayoutParams();
        layoutParams.width = this.niB;
        layoutParams.height = this.niB;
        this.niv.setLayoutParams(layoutParams);
        this.niw.setLayoutParams(layoutParams);
        this.nix.setLayoutParams(layoutParams);
        AppMethodBeat.o(111931);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111932);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naA == null) {
            setVisibility(8);
            AppMethodBeat.o(111932);
            return;
        }
        this.neV = dVar;
        ad adVar = dVar.mVH;
        setVisibility(0);
        this.nim.b(adVar.naA.Title, adVar.naA.ncM, null);
        if (bo.ek(adVar.naA.ncN)) {
            this.niq.setVisibility(8);
            this.niu.setVisibility(8);
        } else {
            int size = adVar.naA.ncN.size();
            if (size == 1) {
                this.niu.setVisibility(8);
                this.niq.setVisibility(0);
                e.bFH().a(this.niq, (String) adVar.naA.ncN.get(0), getResources().getDimensionPixelSize(R.dimen.jp), getResources().getDimensionPixelSize(R.dimen.jo), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            } else {
                this.niq.setVisibility(8);
                this.niu.setVisibility(0);
                this.niy.setVisibility(8);
                e.a.a aVar = new e.a.a();
                aVar.nnP = true;
                e.a bFI = aVar.bFI();
                e.bFH().a(this.niv, (String) adVar.naA.ncN.get(0), bFI);
                e.bFH().a(this.niw, (String) adVar.naA.ncN.get(1), bFI);
                if (size > 2) {
                    e.bFH().a(this.nix, (String) adVar.naA.ncN.get(2), bFI);
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
        this.niz.setData(adVar);
        if (!this.neV.mVJ) {
            com.tencent.mm.plugin.game.e.a.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.o(111932);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111933);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.o(111933);
            return;
        }
        if (!bo.isNullOrNil(this.neV.mVH.mZj)) {
            b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.T(this.neV.mVH.mZL, "clickType", "card"));
        }
        AppMethodBeat.o(111933);
    }
}
