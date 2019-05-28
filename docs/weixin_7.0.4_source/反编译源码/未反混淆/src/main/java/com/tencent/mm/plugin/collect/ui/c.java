package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    String edV = null;
    private TextView iDT = null;
    private ImageView kEn = null;
    private Context mContext = null;
    String mTitle = null;
    private View mView = null;

    public c(Context context) {
        super(context);
        AppMethodBeat.i(41324);
        this.mContext = context;
        setLayoutResource(R.layout.p6);
        AppMethodBeat.o(41324);
    }

    public c(Context context, byte b) {
        super(context);
        AppMethodBeat.i(41325);
        this.mContext = context;
        setLayoutResource(R.layout.p5);
        AppMethodBeat.o(41325);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(41326);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(41326);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(41327);
        super.onBindView(view);
        this.iDT = (TextView) view.findViewById(16908310);
        this.kEn = (ImageView) view.findViewById(R.id.azd);
        this.iDT.setText(j.b(this.mContext, this.mTitle, this.iDT.getTextSize()));
        if (bo.isNullOrNil(this.edV)) {
            this.kEn.setVisibility(8);
            AppMethodBeat.o(41327);
            return;
        }
        this.kEn.setVisibility(0);
        g.RQ();
        ad aoN = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoN(this.edV);
        if (aoN == null || ((int) aoN.ewQ) <= 0) {
            ab.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
            final long anU = bo.anU();
            a.flu.a(this.edV, "", new b.a() {
                public final void o(String str, boolean z) {
                    AppMethodBeat.i(41323);
                    if (z) {
                        ab.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bo.anU() - anU) + " ms");
                        com.tencent.mm.ah.b.U(str, 3);
                        o.acv().pZ(str);
                    } else {
                        ab.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
                    }
                    com.tencent.mm.pluginsdk.ui.a.b.b(c.this.kEn, c.this.edV);
                    AppMethodBeat.o(41323);
                }
            });
            AppMethodBeat.o(41327);
            return;
        }
        com.tencent.mm.pluginsdk.ui.a.b.b(this.kEn, this.edV);
        AppMethodBeat.o(41327);
    }
}
