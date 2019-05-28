package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class f {
    private View jcl;
    private MMActivity jiE;
    private b kha;
    private int klA;
    private View klB;
    private TextView klC;
    private TextView klD;
    private CdnImageView klE;
    private ImageView[] klF;
    private ImageView klG;
    private oa klH;

    public f(MMActivity mMActivity, View view, int i, b bVar) {
        this(mMActivity, view, i, bVar, null);
    }

    public f(MMActivity mMActivity, View view, int i, b bVar, oa oaVar) {
        AppMethodBeat.i(88479);
        this.klF = new ImageView[3];
        this.jiE = mMActivity;
        this.jcl = view;
        this.klA = i;
        this.kha = bVar;
        this.klH = oaVar;
        this.klB = this.jcl.findViewById(R.id.af3);
        this.klC = (TextView) this.jcl.findViewById(R.id.af5);
        this.klD = (TextView) this.jcl.findViewById(R.id.af6);
        this.klE = (CdnImageView) this.jcl.findViewById(R.id.af4);
        this.klF[0] = (ImageView) this.jcl.findViewById(R.id.af8);
        this.klF[1] = (ImageView) this.jcl.findViewById(R.id.af9);
        this.klF[2] = (ImageView) this.jcl.findViewById(R.id.af_);
        this.klG = (ImageView) this.jcl.findViewById(R.id.afa);
        if (this.klA == 1) {
            this.klC.setText(this.jiE.getString(R.string.aft, new Object[]{Integer.valueOf(0)}));
            this.klE.setImageResource(R.raw.card_home_member_card_icon);
            AppMethodBeat.o(88479);
        } else if (this.klA == 2) {
            this.klC.setText(R.string.ahf);
            this.klE.setImageResource(R.raw.card_home_friend_ticket_icon);
            AppMethodBeat.o(88479);
        } else if (this.klA == 3) {
            this.klC.setText(R.string.aib);
            this.klE.setImageResource(R.raw.card_home_my_ticket_icon);
            AppMethodBeat.o(88479);
        } else {
            if (this.klA == 4) {
                if (this.klH == null) {
                    ab.w("MicroMsg.CardHomePageItemController", "cell element is null");
                    bde();
                }
                this.jcl.findViewById(R.id.af7).setVisibility(8);
                this.klC.setText(this.klH.vTt);
                this.klE.setUseSdcardCache(true);
                this.klE.setUrl(this.klH.vTu);
                if (bo.isNullOrNil(this.klH.vTv)) {
                    this.klD.setVisibility(8);
                } else {
                    this.klD.setText(this.klH.vTv);
                    this.klD.setVisibility(0);
                    AppMethodBeat.o(88479);
                    return;
                }
            }
            AppMethodBeat.o(88479);
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(88480);
        this.klB.setOnClickListener(onClickListener);
        AppMethodBeat.o(88480);
    }

    public final void cu() {
        AppMethodBeat.i(88481);
        if (this.klA == 2) {
            l lVar = (l) am.bbb().getValue("key_share_card_layout_data");
            if (lVar == null) {
                ab.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
                AppMethodBeat.o(88481);
                return;
            }
            if (bo.isNullOrNil(lVar.kfM)) {
                this.klD.setVisibility(8);
            } else {
                this.klD.setVisibility(0);
                this.klD.setText(lVar.kfM);
            }
            if (bo.ek(lVar.kfL)) {
                for (int i = 0; i < 3; i++) {
                    this.klF[i].setVisibility(8);
                }
            } else {
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 < lVar.kfL.size()) {
                        this.klF[i2].setVisibility(0);
                        m.a(this.klF[i2], (String) lVar.kfL.get(i2), this.jiE.getResources().getDimensionPixelSize(R.dimen.l8), (int) R.drawable.bcm, false);
                    } else {
                        this.klF[i2].setVisibility(8);
                    }
                }
            }
            if (bo.ek(lVar.kfL) || lVar.kfL.size() != 1 || !lVar.cML || lVar.cMM) {
                this.klG.setVisibility(8);
                AppMethodBeat.o(88481);
                return;
            }
            this.klG.setVisibility(0);
            AppMethodBeat.o(88481);
            return;
        }
        if (this.klA == 3) {
            this.klC.setText(R.string.aib);
            this.jcl.findViewById(R.id.af7).setVisibility(8);
            String str = (String) am.bbb().getValue("key_card_entrance_tips");
            if (bo.isNullOrNil(str)) {
                this.klD.setVisibility(8);
            } else {
                this.klD.setText(str);
                this.klD.setVisibility(0);
                AppMethodBeat.o(88481);
                return;
            }
        }
        AppMethodBeat.o(88481);
    }

    public final void bde() {
        AppMethodBeat.i(88482);
        this.jcl.setVisibility(8);
        AppMethodBeat.o(88482);
    }
}
