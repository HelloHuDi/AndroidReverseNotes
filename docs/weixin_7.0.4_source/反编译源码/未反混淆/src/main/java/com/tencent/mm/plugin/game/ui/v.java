package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class v implements OnClickListener {
    private int gOW = 13;
    private Context mContext;
    private int mPosition;
    private int mXC;
    private int nne;

    public v(Context context) {
        this.mContext = context;
    }

    public final void em(int i, int i2) {
        this.mXC = i;
        this.nne = 1301;
        this.mPosition = i2;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(112217);
        String str;
        if (view.getTag() == null) {
            AppMethodBeat.o(112217);
        } else if (view.getTag() instanceof n) {
            n nVar = (n) view.getTag();
            if (!bo.ek(nVar.mWp)) {
                str = ((i) nVar.mWp.get(0)).mXv;
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                } else {
                    b.a(this.mContext, this.gOW, this.nne, this.mPosition, c.ax(this.mContext, str), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    AppMethodBeat.o(112217);
                    return;
                }
            }
            AppMethodBeat.o(112217);
        } else {
            if (view.getTag() instanceof String) {
                str = (String) view.getTag();
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(112217);
                    return;
                } else {
                    b.a(this.mContext, this.gOW, this.nne, this.mPosition, c.ax(this.mContext, str), this.mXC, null);
                }
            }
            AppMethodBeat.o(112217);
        }
    }
}
