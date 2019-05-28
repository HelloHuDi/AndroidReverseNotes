package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12110ad;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedSubscriptView */
public class GameFeedSubscriptView extends LinearLayout implements OnClickListener {
    private ImageView kEn;
    private C12110ad niK;
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
        AppMethodBeat.m2504i(111950);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(2130969715, this, true);
        this.niP = (TextView) inflate.findViewById(2131824499);
        this.niQ = (TextView) inflate.findViewById(2131824500);
        this.niR = (LinearLayout) inflate.findViewById(2131824502);
        this.kEn = (ImageView) inflate.findViewById(2131823704);
        this.niS = (TextView) inflate.findViewById(2131821045);
        this.niT = (TextView) inflate.findViewById(2131824503);
        this.niU = (TextView) inflate.findViewById(2131824501);
        this.niP.setOnClickListener(this);
        this.niQ.setOnClickListener(this);
        this.niR.setOnClickListener(this);
        this.niU.setOnClickListener(this);
        AppMethodBeat.m2505o(111950);
    }

    public void setData(C12110ad c12110ad) {
        AppMethodBeat.m2504i(111951);
        if (c12110ad == null || (c12110ad.naK == null && c12110ad.naL == null)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111951);
            return;
        }
        this.niK = c12110ad;
        setVisibility(0);
        this.niP.setVisibility(8);
        this.niQ.setVisibility(8);
        this.niR.setVisibility(8);
        if (c12110ad.naK != null) {
            switch (c12110ad.naK.mZX) {
                case 1:
                    this.niQ.setVisibility(0);
                    this.niQ.setText(c12110ad.naK.Desc);
                    break;
                case 2:
                    this.niP.setVisibility(0);
                    this.niP.setText(c12110ad.naK.Desc);
                    break;
                case 3:
                    this.niR.setVisibility(0);
                    if (!C5046bo.isNullOrNil(c12110ad.naK.mZW)) {
                        C12125a c12125a = new C12125a();
                        c12125a.eQf = true;
                        C28203e.bFH().mo46098a(this.kEn, c12110ad.naK.mZW, c12125a.bFI());
                        this.kEn.setVisibility(0);
                    }
                    this.niS.setText(c12110ad.naK.Name);
                    this.niT.setText(c12110ad.naK.Desc);
                    break;
            }
        }
        if (c12110ad.naL != null) {
            this.niU.setText(c12110ad.naL.Desc);
            this.niU.setVisibility(0);
            AppMethodBeat.m2505o(111951);
            return;
        }
        this.niU.setVisibility(8);
        AppMethodBeat.m2505o(111951);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111952);
        if (this.niK == null) {
            AppMethodBeat.m2505o(111952);
            return;
        }
        if (view.getId() == 2131824499 || view.getId() == 2131824500 || view.getId() == 2131824502) {
            if (!(this.niK.naK == null || C5046bo.isNullOrNil(this.niK.naK.mZj))) {
                C46001c.m85455ax(getContext(), this.niK.naK.mZj);
                m66835wJ(1);
                AppMethodBeat.m2505o(111952);
                return;
            }
        } else if (!(view.getId() != 2131824501 || this.niK.naL == null || C5046bo.isNullOrNil(this.niK.naL.mZj))) {
            C46001c.m85455ax(getContext(), this.niK.naL.mZj);
            m66835wJ(2);
        }
        AppMethodBeat.m2505o(111952);
    }

    /* renamed from: wJ */
    private void m66835wJ(int i) {
        String T;
        AppMethodBeat.m2504i(111953);
        if (i == 1) {
            T = C34276a.m56203T(this.niK.mZL, "clickType", "leftCorner");
        } else {
            T = C34276a.m56203T(this.niK.mZL, "clickType", "rightCorner");
        }
        C34277b.m56211a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.niK.mZN, 7, this.niK.fKh, GameIndexListView.getSourceScene(), T);
        AppMethodBeat.m2505o(111953);
    }
}
