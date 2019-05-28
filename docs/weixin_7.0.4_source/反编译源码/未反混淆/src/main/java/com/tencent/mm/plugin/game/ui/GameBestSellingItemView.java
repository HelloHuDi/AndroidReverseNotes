package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bo;

public class GameBestSellingItemView extends LinearLayout implements OnClickListener {
    AutoResizeTextView neN;
    ImageView neO;
    TextView neP;
    GameTagListView neQ;
    GameDownloadView neR;
    View neS;
    private int neT;
    private y neU;
    private d neV;

    public GameBestSellingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111729);
        super.onFinishInflate();
        this.neN = (AutoResizeTextView) findViewById(R.id.c0d);
        this.neO = (ImageView) findViewById(R.id.zr);
        this.neP = (TextView) findViewById(R.id.zt);
        this.neQ = (GameTagListView) findViewById(R.id.c0f);
        this.neR = (GameDownloadView) findViewById(R.id.c0e);
        this.neS = findViewById(R.id.c0g);
        this.neT = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        setOnClickListener(this);
        AppMethodBeat.o(111729);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111730);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naG == null || bo.ek(dVar.mVH.naG.mZK)) {
            setVisibility(8);
            AppMethodBeat.o(111730);
            return;
        }
        this.neV = dVar;
        y yVar = (y) dVar.mVH.naG.mZK.get(dVar.mVI);
        int i = dVar.mVI + 1;
        if (yVar == null || yVar.mZk == null) {
            setVisibility(8);
        } else {
            this.neU = yVar;
            com.tencent.mm.plugin.game.model.c a = x.a(this.neU.mZk);
            a.scene = 10;
            a.cKG = 1022;
            a.position = this.neV.mVI + 1;
            this.neR.setDownloadInfo(new k(a));
            setVisibility(0);
            this.neN.setText(String.valueOf(i));
            if (i == 1) {
                this.neN.setTextColor(c.parseColor("#EED157"));
            } else if (i == 2) {
                this.neN.setTextColor(c.parseColor("#BDC5CB"));
            } else if (i == 3) {
                this.neN.setTextColor(c.parseColor("#D4B897"));
            } else {
                this.neN.setTextColor(c.parseColor("#B2B2B2"));
            }
            e.bFH().a(this.neO, yVar.mZk.mZr, a.getDensity(getContext()));
            this.neP.setText(yVar.mZk.Name);
            this.neQ.f(yVar.mZk.mZH, this.neT);
            if (bo.ek(yVar.nar) && yVar.nas == null && yVar.Desc == null) {
                this.neS.setVisibility(8);
            } else {
                if (this.neS instanceof ViewStub) {
                    this.neS = ((ViewStub) this.neS).inflate();
                }
                ((GameFeedSocialInfoView) this.neS.findViewById(R.id.c9r)).setData(yVar);
            }
        }
        if (!dVar.mVJ) {
            com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1022, dVar.mVI + 1, yVar.mZk.mZr, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.kY(dVar.mVH.mZL));
            dVar.mVJ = true;
        }
        AppMethodBeat.o(111730);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111731);
        if (this.neU == null || bo.isNullOrNil(this.neU.mZk.mZm)) {
            AppMethodBeat.o(111731);
            return;
        }
        b.a(getContext(), 10, 1022, this.neV.mVI + 1, c.ax(getContext(), this.neU.mZk.mZm), this.neU.mZk.mZr, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.kY(this.neV.mVH.mZL));
        AppMethodBeat.o(111731);
    }
}
