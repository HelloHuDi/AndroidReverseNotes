package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedSubscriptView extends LinearLayout implements OnClickListener {
    private ImageView kEn;
    private ad niK;
    private TextView niP;
    private TextView niQ;
    private LinearLayout niR;
    private TextView niS;
    private TextView niT;
    private TextView niU;

    public GameFeedSubscriptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111950);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a3z, this, true);
        this.niP = (TextView) inflate.findViewById(R.id.c5w);
        this.niQ = (TextView) inflate.findViewById(R.id.c5x);
        this.niR = (LinearLayout) inflate.findViewById(R.id.c5z);
        this.kEn = (ImageView) inflate.findViewById(R.id.bke);
        this.niS = (TextView) inflate.findViewById(R.id.mu);
        this.niT = (TextView) inflate.findViewById(R.id.c60);
        this.niU = (TextView) inflate.findViewById(R.id.c5y);
        this.niP.setOnClickListener(this);
        this.niQ.setOnClickListener(this);
        this.niR.setOnClickListener(this);
        this.niU.setOnClickListener(this);
        AppMethodBeat.o(111950);
    }

    public void setData(ad adVar) {
        AppMethodBeat.i(111951);
        if (adVar == null || (adVar.naK == null && adVar.naL == null)) {
            setVisibility(8);
            AppMethodBeat.o(111951);
            return;
        }
        this.niK = adVar;
        setVisibility(0);
        this.niP.setVisibility(8);
        this.niQ.setVisibility(8);
        this.niR.setVisibility(8);
        if (adVar.naK != null) {
            switch (adVar.naK.mZX) {
                case 1:
                    this.niQ.setVisibility(0);
                    this.niQ.setText(adVar.naK.Desc);
                    break;
                case 2:
                    this.niP.setVisibility(0);
                    this.niP.setText(adVar.naK.Desc);
                    break;
                case 3:
                    this.niR.setVisibility(0);
                    if (!bo.isNullOrNil(adVar.naK.mZW)) {
                        a aVar = new a();
                        aVar.eQf = true;
                        e.bFH().a(this.kEn, adVar.naK.mZW, aVar.bFI());
                        this.kEn.setVisibility(0);
                    }
                    this.niS.setText(adVar.naK.Name);
                    this.niT.setText(adVar.naK.Desc);
                    break;
            }
        }
        if (adVar.naL != null) {
            this.niU.setText(adVar.naL.Desc);
            this.niU.setVisibility(0);
            AppMethodBeat.o(111951);
            return;
        }
        this.niU.setVisibility(8);
        AppMethodBeat.o(111951);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111952);
        if (this.niK == null) {
            AppMethodBeat.o(111952);
            return;
        }
        if (view.getId() == R.id.c5w || view.getId() == R.id.c5x || view.getId() == R.id.c5z) {
            if (!(this.niK.naK == null || bo.isNullOrNil(this.niK.naK.mZj))) {
                c.ax(getContext(), this.niK.naK.mZj);
                wJ(1);
                AppMethodBeat.o(111952);
                return;
            }
        } else if (!(view.getId() != R.id.c5y || this.niK.naL == null || bo.isNullOrNil(this.niK.naL.mZj))) {
            c.ax(getContext(), this.niK.naL.mZj);
            wJ(2);
        }
        AppMethodBeat.o(111952);
    }

    private void wJ(int i) {
        String T;
        AppMethodBeat.i(111953);
        if (i == 1) {
            T = com.tencent.mm.plugin.game.e.a.T(this.niK.mZL, "clickType", "leftCorner");
        } else {
            T = com.tencent.mm.plugin.game.e.a.T(this.niK.mZL, "clickType", "rightCorner");
        }
        b.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.niK.mZN, 7, this.niK.fKh, GameIndexListView.getSourceScene(), T);
        AppMethodBeat.o(111953);
    }
}
