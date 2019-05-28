package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class o extends n {
    private a tJt;

    public interface a {
        void df(View view);
    }

    public o(a aVar) {
        this(aVar, (byte) 0);
    }

    public o(String str, a aVar) {
        this(aVar, (byte) 0);
        AppMethodBeat.i(47535);
        if (!bo.isNullOrNil(str)) {
            gP(Color.parseColor(str), ah.getContext().getResources().getColor(R.color.a0j));
        }
        AppMethodBeat.o(47535);
    }

    private o(a aVar, byte b) {
        super(2, null);
        this.tJt = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(47536);
        if (this.tJt != null) {
            this.tJt.df(view);
        }
        AppMethodBeat.o(47536);
    }

    public final void Hy(int i) {
        AppMethodBeat.i(47537);
        Context context = ah.getContext();
        super.Hy(i);
        if (i == 5) {
            gP(context.getResources().getColor(R.color.a69), context.getResources().getColor(R.color.a0j));
        }
        AppMethodBeat.o(47537);
    }
}
