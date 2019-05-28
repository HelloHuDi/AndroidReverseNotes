package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.o */
public final class C35503o extends C23322n {
    private C35502a tJt;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.o$a */
    public interface C35502a {
        /* renamed from: df */
        void mo9537df(View view);
    }

    public C35503o(C35502a c35502a) {
        this(c35502a, (byte) 0);
    }

    public C35503o(String str, C35502a c35502a) {
        this(c35502a, (byte) 0);
        AppMethodBeat.m2504i(47535);
        if (!C5046bo.isNullOrNil(str)) {
            mo39045gP(Color.parseColor(str), C4996ah.getContext().getResources().getColor(C25738R.color.a0j));
        }
        AppMethodBeat.m2505o(47535);
    }

    private C35503o(C35502a c35502a, byte b) {
        super(2, null);
        this.tJt = c35502a;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(47536);
        if (this.tJt != null) {
            this.tJt.mo9537df(view);
        }
        AppMethodBeat.m2505o(47536);
    }

    /* renamed from: Hy */
    public final void mo39044Hy(int i) {
        AppMethodBeat.m2504i(47537);
        Context context = C4996ah.getContext();
        super.mo39044Hy(i);
        if (i == 5) {
            mo39045gP(context.getResources().getColor(C25738R.color.a69), context.getResources().getColor(C25738R.color.a0j));
        }
        AppMethodBeat.m2505o(47537);
    }
}
