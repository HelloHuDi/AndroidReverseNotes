package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedNoGamePlayTemplate extends LinearLayout implements OnClickListener {
    private ImageView iUn;
    GameDownloadView neR;
    private d neV;
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
        AppMethodBeat.i(111942);
        super.onFinishInflate();
        this.niD = (GameFeedTitleDescView) findViewById(R.id.c5d);
        this.niE = (FrameLayout) findViewById(R.id.c5q);
        this.niq = (GameRoundImageView) findViewById(R.id.c5r);
        this.nir = (ImageView) findViewById(R.id.c5h);
        this.niF = (RelativeLayout) findViewById(R.id.c5s);
        this.iUn = (ImageView) findViewById(R.id.zr);
        this.niG = (TextView) findViewById(R.id.zt);
        this.neR = (GameDownloadView) findViewById(R.id.c0z);
        setOnClickListener(this);
        this.niE.setOnClickListener(this);
        AppMethodBeat.o(111942);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111943);
        ab.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
        if (dVar == null || dVar.mVH == null || dVar.mVH.naF == null) {
            setVisibility(8);
            AppMethodBeat.o(111943);
            return;
        }
        ab.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
        this.neV = dVar;
        ad adVar = dVar.mVH;
        setVisibility(0);
        this.niD.b(adVar.naF.Title, adVar.naF.Desc, adVar.naF.ndm);
        this.niE.setVisibility(0);
        if (bo.isNullOrNil(adVar.naF.mZi)) {
            this.niE.setVisibility(8);
        } else {
            e.bFH().a(this.niq, adVar.naF.mZi, getResources().getDimensionPixelSize(R.dimen.jy), getResources().getDimensionPixelSize(R.dimen.jx), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            if (bo.isNullOrNil(adVar.naF.nbr)) {
                this.nir.setVisibility(8);
            } else {
                this.nir.setVisibility(0);
            }
        }
        if (adVar.naF.mZk != null) {
            this.niF.setVisibility(0);
            e.bFH().a(this.iUn, adVar.naF.mZk.mZr, a.getDensity(getContext()));
            this.niG.setText(adVar.naF.mZk.Name);
            com.tencent.mm.plugin.game.model.c a = x.a(adVar.naF.mZk);
            a.scene = 10;
            a.cKG = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            a.position = this.neV.position;
            this.neR.setDownloadInfo(new k(a));
        }
        if (!this.neV.mVJ) {
            com.tencent.mm.plugin.game.e.a.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.kY(this.neV.mVH.mZL));
            this.neV.mVJ = true;
        }
        AppMethodBeat.o(111943);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111944);
        if (this.neV == null || this.neV.mVH == null || this.neV.mVH.naF == null) {
            AppMethodBeat.o(111944);
        } else if (view.getId() != R.id.c5q || bo.isNullOrNil(this.neV.mVH.naF.nbr)) {
            if (!bo.isNullOrNil(this.neV.mVH.mZj)) {
                b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.mZj), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.T(this.neV.mVH.mZL, "clickType", "card"));
            }
            AppMethodBeat.o(111944);
        } else {
            b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.neV.position, c.ax(getContext(), this.neV.mVH.naF.nbr), this.neV.mVH.fKh, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.T(this.neV.mVH.mZL, "clickType", "middle"));
            AppMethodBeat.o(111944);
        }
    }
}
