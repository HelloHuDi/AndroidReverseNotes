package com.tencent.p177mm.plugin.card.p355ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.sharecard.model.C27593l;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C44148oa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.f */
public final class C45795f {
    private View jcl;
    private MMActivity jiE;
    private C42856b kha;
    private int klA;
    private View klB;
    private TextView klC;
    private TextView klD;
    private CdnImageView klE;
    private ImageView[] klF;
    private ImageView klG;
    private C44148oa klH;

    public C45795f(MMActivity mMActivity, View view, int i, C42856b c42856b) {
        this(mMActivity, view, i, c42856b, null);
    }

    public C45795f(MMActivity mMActivity, View view, int i, C42856b c42856b, C44148oa c44148oa) {
        AppMethodBeat.m2504i(88479);
        this.klF = new ImageView[3];
        this.jiE = mMActivity;
        this.jcl = view;
        this.klA = i;
        this.kha = c42856b;
        this.klH = c44148oa;
        this.klB = this.jcl.findViewById(2131822139);
        this.klC = (TextView) this.jcl.findViewById(2131822141);
        this.klD = (TextView) this.jcl.findViewById(2131822142);
        this.klE = (CdnImageView) this.jcl.findViewById(2131822140);
        this.klF[0] = (ImageView) this.jcl.findViewById(2131822144);
        this.klF[1] = (ImageView) this.jcl.findViewById(2131822145);
        this.klF[2] = (ImageView) this.jcl.findViewById(2131822146);
        this.klG = (ImageView) this.jcl.findViewById(2131822147);
        if (this.klA == 1) {
            this.klC.setText(this.jiE.getString(C25738R.string.aft, new Object[]{Integer.valueOf(0)}));
            this.klE.setImageResource(C1318a.card_home_member_card_icon);
            AppMethodBeat.m2505o(88479);
        } else if (this.klA == 2) {
            this.klC.setText(C25738R.string.ahf);
            this.klE.setImageResource(C1318a.card_home_friend_ticket_icon);
            AppMethodBeat.m2505o(88479);
        } else if (this.klA == 3) {
            this.klC.setText(C25738R.string.aib);
            this.klE.setImageResource(C1318a.card_home_my_ticket_icon);
            AppMethodBeat.m2505o(88479);
        } else {
            if (this.klA == 4) {
                if (this.klH == null) {
                    C4990ab.m7420w("MicroMsg.CardHomePageItemController", "cell element is null");
                    bde();
                }
                this.jcl.findViewById(2131822143).setVisibility(8);
                this.klC.setText(this.klH.vTt);
                this.klE.setUseSdcardCache(true);
                this.klE.setUrl(this.klH.vTu);
                if (C5046bo.isNullOrNil(this.klH.vTv)) {
                    this.klD.setVisibility(8);
                } else {
                    this.klD.setText(this.klH.vTv);
                    this.klD.setVisibility(0);
                    AppMethodBeat.m2505o(88479);
                    return;
                }
            }
            AppMethodBeat.m2505o(88479);
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(88480);
        this.klB.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(88480);
    }

    /* renamed from: cu */
    public final void mo73594cu() {
        AppMethodBeat.m2504i(88481);
        if (this.klA == 2) {
            C27593l c27593l = (C27593l) C42852am.bbb().getValue("key_share_card_layout_data");
            if (c27593l == null) {
                C4990ab.m7420w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
                AppMethodBeat.m2505o(88481);
                return;
            }
            if (C5046bo.isNullOrNil(c27593l.kfM)) {
                this.klD.setVisibility(8);
            } else {
                this.klD.setVisibility(0);
                this.klD.setText(c27593l.kfM);
            }
            if (C5046bo.m7548ek(c27593l.kfL)) {
                for (int i = 0; i < 3; i++) {
                    this.klF[i].setVisibility(8);
                }
            } else {
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 < c27593l.kfL.size()) {
                        this.klF[i2].setVisibility(0);
                        C45778m.m84644a(this.klF[i2], (String) c27593l.kfL.get(i2), this.jiE.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8), (int) C25738R.drawable.bcm, false);
                    } else {
                        this.klF[i2].setVisibility(8);
                    }
                }
            }
            if (C5046bo.m7548ek(c27593l.kfL) || c27593l.kfL.size() != 1 || !c27593l.cML || c27593l.cMM) {
                this.klG.setVisibility(8);
                AppMethodBeat.m2505o(88481);
                return;
            }
            this.klG.setVisibility(0);
            AppMethodBeat.m2505o(88481);
            return;
        }
        if (this.klA == 3) {
            this.klC.setText(C25738R.string.aib);
            this.jcl.findViewById(2131822143).setVisibility(8);
            String str = (String) C42852am.bbb().getValue("key_card_entrance_tips");
            if (C5046bo.isNullOrNil(str)) {
                this.klD.setVisibility(8);
            } else {
                this.klD.setText(str);
                this.klD.setVisibility(0);
                AppMethodBeat.m2505o(88481);
                return;
            }
        }
        AppMethodBeat.m2505o(88481);
    }

    public final void bde() {
        AppMethodBeat.m2504i(88482);
        this.jcl.setVisibility(8);
        AppMethodBeat.m2505o(88482);
    }
}
