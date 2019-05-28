package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class f extends a {
    protected TextView gnB;
    public ArrayList<od> kaY;
    private View ksI;
    private ImageView ksJ;
    private TextView ksK;
    private TextView ksL;
    private View ksM;
    private TextView ksN;
    private TextView ksO;
    private ImageView ksP;
    private TextView ksQ;

    public f(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.i(88985);
        this.gnB = (TextView) beI().findViewById(R.id.abf);
        this.ksI = beI().findViewById(R.id.abd);
        this.ksJ = (ImageView) beI().findViewById(R.id.akh);
        this.ksK = (TextView) beI().findViewById(R.id.aki);
        this.ksL = (TextView) beI().findViewById(R.id.akj);
        this.ksM = beI().findViewById(R.id.akk);
        this.ksN = (TextView) beI().findViewById(R.id.akm);
        this.ksO = (TextView) beI().findViewById(R.id.akn);
        this.ksP = (ImageView) beI().findViewById(R.id.akl);
        this.ksQ = (TextView) beI().findViewById(R.id.ako);
        AppMethodBeat.o(88985);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.i(88986);
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
        ab.i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (bo.isNullOrNil(this.kaS.aZV().vUe)) {
            m.a(this.ksJ, R.drawable.azs, l.Hn(this.kaS.aZV().color));
        } else {
            m.a(this.mContext, this.ksJ, this.kaS.aZV().vUe, this.mContext.getResources().getDimensionPixelSize(R.dimen.wh), l.Hn(this.kaS.aZV().color));
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        tm tmVar;
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() >= 2) {
            ab.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            tmVar = (tm) this.kaS.aZV().vTW.get(0);
            tm tmVar2 = (tm) this.kaS.aZV().vTW.get(1);
            stringBuilder.append(tmVar.title).append(" - ").append(tmVar2.title);
            if (!(TextUtils.isEmpty(tmVar.kbX) || TextUtils.isEmpty(tmVar2.kbX))) {
                stringBuilder2.append(tmVar.kbX).append(" ").append(tmVar.kbW);
                stringBuilder2.append(" - ");
                stringBuilder2.append(tmVar2.kbX).append(" ").append(tmVar2.kbW);
            }
        } else if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() == 1) {
            ab.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            tmVar = (tm) this.kaS.aZV().vTW.get(0);
            stringBuilder.append(tmVar.title);
            stringBuilder2.append(tmVar.kbW);
        }
        if (TextUtils.isEmpty(stringBuilder.toString())) {
            this.ksK.setText("");
        } else {
            this.ksK.setText(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(stringBuilder2.toString())) {
            ab.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.ksL.setText(stringBuilder2.toString());
            this.ksL.setVisibility(0);
        } else if (TextUtils.isEmpty(this.kaS.aZV().vUm)) {
            this.ksL.setVisibility(8);
        } else {
            ab.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.ksL.setText(this.kaS.aZV().vUm);
            this.ksL.setVisibility(0);
        }
        ab.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.kaS.aZV().vUa);
        if (this.kaS.aZV().vUa <= 0) {
            this.ksM.setVisibility(8);
            this.ksQ.setVisibility(8);
        } else {
            this.ksM.setVisibility(0);
            this.ksM.setOnClickListener(this.gKK);
            m.a(this.ksP, R.drawable.azt, l.Hn(this.kaS.aZV().color));
            od odVar = null;
            if (this.kaY != null && this.kaY.size() > 0) {
                odVar = (od) this.kaY.get(0);
            }
            if (this.kaS.aZV().vUa == 1 && odVar != null) {
                this.ksN.setText(odVar.name);
                this.ksO.setText(this.mContext.getString(R.string.ahn, new Object[]{l.g(this.mContext, odVar.qVo), odVar.fBg}));
                this.ksQ.setVisibility(8);
                this.ksM.setTag(odVar.name);
            } else if (this.kaS.aZV().vUa > 1 && odVar != null) {
                this.ksN.setText(odVar.name);
                this.ksO.setText(this.mContext.getString(R.string.ahn, new Object[]{l.g(this.mContext, odVar.qVo), odVar.fBg}));
                this.ksQ.setVisibility(0);
                this.ksQ.setOnClickListener(this.gKK);
                this.ksM.setTag(odVar.name);
            } else if (this.kaS.aZV().vUa > 0) {
                this.ksN.setText(R.string.acx);
                this.ksO.setText(this.mContext.getString(R.string.aic, new Object[]{Integer.valueOf(this.kaS.aZV().vUa)}));
                this.ksQ.setVisibility(8);
                this.ksQ.setOnClickListener(null);
                this.ksM.setTag(this.mContext.getString(R.string.acx));
            }
        }
        if (this.kaS.aZU()) {
            this.ksI.setVisibility(8);
            AppMethodBeat.o(88986);
            return;
        }
        this.ksI.setVisibility(0);
        AppMethodBeat.o(88986);
    }
}
