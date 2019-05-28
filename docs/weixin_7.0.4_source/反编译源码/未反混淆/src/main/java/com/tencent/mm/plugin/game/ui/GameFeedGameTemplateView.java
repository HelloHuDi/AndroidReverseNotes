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
import com.tencent.mm.bz.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public class GameFeedGameTemplateView extends LinearLayout implements OnClickListener {
    private TextView kEq;
    private int neT;
    private d neV;
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
        AppMethodBeat.i(111925);
        super.onFinishInflate();
        this.ngV = (ImageView) findViewById(R.id.zr);
        this.ngW = (TextView) findViewById(R.id.zt);
        this.nio = (GameTagListView) findViewById(R.id.c5f);
        this.kEq = (TextView) findViewById(R.id.o7);
        this.nip = (FrameLayout) findViewById(R.id.c5g);
        this.niq = (GameRoundImageView) findViewById(R.id.bl);
        this.nir = (ImageView) findViewById(R.id.c5h);
        this.nis = (GameFeedSubscriptView) findViewById(R.id.c5i);
        this.nit = (GameDownloadView) findViewById(R.id.c0z);
        setOnClickListener(this);
        this.neT = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), ErrorCode.NEEDDOWNLOAD_FALSE_5);
        AppMethodBeat.o(111925);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(111926);
        super.onDetachedFromWindow();
        AppMethodBeat.o(111926);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(111927);
        super.onAttachedToWindow();
        AppMethodBeat.o(111927);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111928);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naE == null) {
            setVisibility(8);
            AppMethodBeat.o(111928);
            return;
        }
        this.neV = dVar;
        ad adVar = dVar.mVH;
        setVisibility(0);
        e.bFH().a(this.ngV, adVar.naE.mZk.mZr, a.getDensity(getContext()));
        this.ngW.setText(adVar.naE.mZk.Name);
        this.nio.f(adVar.naE.mZk.mZH, this.neT);
        if (bo.isNullOrNil(adVar.naE.nbp)) {
            this.kEq.setVisibility(8);
        } else {
            this.kEq.setText(adVar.naE.nbp);
            this.kEq.setVisibility(0);
        }
        this.nip.setVisibility(0);
        if (!bo.isNullOrNil(adVar.naE.nbr)) {
            c(this.niq, adVar.naE.mZi);
            this.nir.setVisibility(0);
        } else if (bo.isNullOrNil(adVar.naE.mZi)) {
            this.nip.setVisibility(8);
        } else {
            c(this.niq, adVar.naE.mZi);
            this.nir.setVisibility(8);
        }
        this.nip.setOnClickListener(this);
        this.nis.setData(adVar);
        com.tencent.mm.plugin.game.model.c a = x.a(this.neV.mVH.naE.mZk);
        a.scene = 10;
        a.cKG = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        a.position = this.neV.position;
        this.nit.setDownloadInfo(new k(a));
        if (!this.neV.mVJ) {
            com.tencent.mm.plugin.game.e.a.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.o(111928);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111929);
        if (this.neV == null || this.neV.mVH == null) {
            AppMethodBeat.o(111929);
        } else if (view.getId() != R.id.c5g || bo.isNullOrNil(this.neV.mVH.naE.nbq)) {
            if (!bo.isNullOrNil(this.neV.mVH.mZj)) {
                b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.T(this.neV.mVH.mZL, "clickType", "card"));
            }
            AppMethodBeat.o(111929);
        } else {
            b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.naE.nbq), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.T(this.neV.mVH.mZL, "clickType", "middle"));
            AppMethodBeat.o(111929);
        }
    }

    private void c(ImageView imageView, String str) {
        AppMethodBeat.i(111930);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.jy);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.jx);
        e.bFH().a(imageView, str, dimensionPixelSize, dimensionPixelSize2, (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        AppMethodBeat.o(111930);
    }
}
