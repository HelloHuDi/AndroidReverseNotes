package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.widget.f */
public final class C38781f extends C2788a {
    protected TextView gnB;
    public ArrayList<C23422od> kaY;
    private View ksI;
    private ImageView ksJ;
    private TextView ksK;
    private TextView ksL;
    private View ksM;
    private TextView ksN;
    private TextView ksO;
    private ImageView ksP;
    private TextView ksQ;

    public C38781f(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.m2504i(88985);
        this.gnB = (TextView) beI().findViewById(2131822004);
        this.ksI = beI().findViewById(2131822002);
        this.ksJ = (ImageView) beI().findViewById(2131822339);
        this.ksK = (TextView) beI().findViewById(2131822340);
        this.ksL = (TextView) beI().findViewById(2131822341);
        this.ksM = beI().findViewById(2131822342);
        this.ksN = (TextView) beI().findViewById(2131822344);
        this.ksO = (TextView) beI().findViewById(2131822345);
        this.ksP = (ImageView) beI().findViewById(2131822343);
        this.ksQ = (TextView) beI().findViewById(2131822346);
        AppMethodBeat.m2505o(88985);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.m2504i(88986);
        if (this.kaS.aZV().vUy != null && !TextUtils.isEmpty(this.kaS.aZV().vUy.title)) {
            this.iPD.setText(this.kaS.aZV().vUy.title);
        } else if (TextUtils.isEmpty(this.kaS.aZV().kdg)) {
            this.iPD.setText("");
        } else {
            this.iPD.setText(this.kaS.aZV().kdg);
        }
        if (this.kaS.aZV().vUy == null || TextUtils.isEmpty(this.kaS.aZV().vUy.kbW)) {
            this.gnB.setText("");
            this.gnB.setVisibility(8);
        } else {
            this.gnB.setText(this.kaS.aZV().vUy.kbW);
            this.gnB.setVisibility(0);
        }
        C4990ab.m7416i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (C5046bo.isNullOrNil(this.kaS.aZV().vUe)) {
            C45778m.m84643a(this.ksJ, C25738R.drawable.azs, C38736l.m65701Hn(this.kaS.aZV().color));
        } else {
            C45778m.m84641a(this.mContext, this.ksJ, this.kaS.aZV().vUe, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10273wh), C38736l.m65701Hn(this.kaS.aZV().color));
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        C23446tm c23446tm;
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() >= 2) {
            C4990ab.m7416i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            c23446tm = (C23446tm) this.kaS.aZV().vTW.get(0);
            C23446tm c23446tm2 = (C23446tm) this.kaS.aZV().vTW.get(1);
            stringBuilder.append(c23446tm.title).append(" - ").append(c23446tm2.title);
            if (!(TextUtils.isEmpty(c23446tm.kbX) || TextUtils.isEmpty(c23446tm2.kbX))) {
                stringBuilder2.append(c23446tm.kbX).append(" ").append(c23446tm.kbW);
                stringBuilder2.append(" - ");
                stringBuilder2.append(c23446tm2.kbX).append(" ").append(c23446tm2.kbW);
            }
        } else if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() == 1) {
            C4990ab.m7416i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            c23446tm = (C23446tm) this.kaS.aZV().vTW.get(0);
            stringBuilder.append(c23446tm.title);
            stringBuilder2.append(c23446tm.kbW);
        }
        if (TextUtils.isEmpty(stringBuilder.toString())) {
            this.ksK.setText("");
        } else {
            this.ksK.setText(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(stringBuilder2.toString())) {
            C4990ab.m7416i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.ksL.setText(stringBuilder2.toString());
            this.ksL.setVisibility(0);
        } else if (TextUtils.isEmpty(this.kaS.aZV().vUm)) {
            this.ksL.setVisibility(8);
        } else {
            C4990ab.m7416i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.ksL.setText(this.kaS.aZV().vUm);
            this.ksL.setVisibility(0);
        }
        C4990ab.m7412e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.kaS.aZV().vUa);
        if (this.kaS.aZV().vUa <= 0) {
            this.ksM.setVisibility(8);
            this.ksQ.setVisibility(8);
        } else {
            this.ksM.setVisibility(0);
            this.ksM.setOnClickListener(this.gKK);
            C45778m.m84643a(this.ksP, C25738R.drawable.azt, C38736l.m65701Hn(this.kaS.aZV().color));
            C23422od c23422od = null;
            if (this.kaY != null && this.kaY.size() > 0) {
                c23422od = (C23422od) this.kaY.get(0);
            }
            if (this.kaS.aZV().vUa == 1 && c23422od != null) {
                this.ksN.setText(c23422od.name);
                this.ksO.setText(this.mContext.getString(C25738R.string.ahn, new Object[]{C38736l.m65730g(this.mContext, c23422od.qVo), c23422od.fBg}));
                this.ksQ.setVisibility(8);
                this.ksM.setTag(c23422od.name);
            } else if (this.kaS.aZV().vUa > 1 && c23422od != null) {
                this.ksN.setText(c23422od.name);
                this.ksO.setText(this.mContext.getString(C25738R.string.ahn, new Object[]{C38736l.m65730g(this.mContext, c23422od.qVo), c23422od.fBg}));
                this.ksQ.setVisibility(0);
                this.ksQ.setOnClickListener(this.gKK);
                this.ksM.setTag(c23422od.name);
            } else if (this.kaS.aZV().vUa > 0) {
                this.ksN.setText(C25738R.string.acx);
                this.ksO.setText(this.mContext.getString(C25738R.string.aic, new Object[]{Integer.valueOf(this.kaS.aZV().vUa)}));
                this.ksQ.setVisibility(8);
                this.ksQ.setOnClickListener(null);
                this.ksM.setTag(this.mContext.getString(C25738R.string.acx));
            }
        }
        if (this.kaS.aZU()) {
            this.ksI.setVisibility(8);
            AppMethodBeat.m2505o(88986);
            return;
        }
        this.ksI.setVisibility(0);
        AppMethodBeat.m2505o(88986);
    }
}
