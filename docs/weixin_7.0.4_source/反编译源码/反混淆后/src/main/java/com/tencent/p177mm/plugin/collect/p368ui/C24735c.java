package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.collect.ui.c */
public final class C24735c extends Preference {
    String edV = null;
    private TextView iDT = null;
    private ImageView kEn = null;
    private Context mContext = null;
    String mTitle = null;
    private View mView = null;

    public C24735c(Context context) {
        super(context);
        AppMethodBeat.m2504i(41324);
        this.mContext = context;
        setLayoutResource(2130969165);
        AppMethodBeat.m2505o(41324);
    }

    public C24735c(Context context, byte b) {
        super(context);
        AppMethodBeat.m2504i(41325);
        this.mContext = context;
        setLayoutResource(2130969164);
        AppMethodBeat.m2505o(41325);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(41326);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(41326);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(41327);
        super.onBindView(view);
        this.iDT = (TextView) view.findViewById(16908310);
        this.kEn = (ImageView) view.findViewById(2131822889);
        this.iDT.setText(C44089j.m79293b(this.mContext, this.mTitle, this.iDT.getTextSize()));
        if (C5046bo.isNullOrNil(this.edV)) {
            this.kEn.setVisibility(8);
            AppMethodBeat.m2505o(41327);
            return;
        }
        this.kEn.setVisibility(0);
        C1720g.m3537RQ();
        C7616ad aoN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(this.edV);
        if (aoN == null || ((int) aoN.ewQ) <= 0) {
            C4990ab.m7410d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
            final long anU = C5046bo.anU();
            C26417a.flu.mo20966a(this.edV, "", new C9636a() {
                /* renamed from: o */
                public final void mo6218o(String str, boolean z) {
                    AppMethodBeat.m2504i(41323);
                    if (z) {
                        C4990ab.m7418v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (C5046bo.anU() - anU) + " ms");
                        C41730b.m73489U(str, 3);
                        C17884o.acv().mo67495pZ(str);
                    } else {
                        C4990ab.m7420w("MicroMsg.CollectPayInfoPreference", "getContact failed");
                    }
                    C40460b.m69434b(C24735c.this.kEn, C24735c.this.edV);
                    AppMethodBeat.m2505o(41323);
                }
            });
            AppMethodBeat.m2505o(41327);
            return;
        }
        C40460b.m69434b(this.kEn, this.edV);
        AppMethodBeat.m2505o(41327);
    }
}
