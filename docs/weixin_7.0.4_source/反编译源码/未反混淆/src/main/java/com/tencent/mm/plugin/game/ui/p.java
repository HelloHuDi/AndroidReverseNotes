package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class p extends b {
    public p(Context context, int i) {
        super(context);
        this.mXC = i;
    }

    public final void onClick(View view) {
        n nVar;
        AppMethodBeat.i(112087);
        Object tag = view.getTag();
        if (tag == null) {
            ab.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            nVar = null;
        } else if (tag instanceof Long) {
            n iP = ((c) g.K(c.class)).bCY().iP(((Long) tag).longValue());
            if (iP != null) {
                iP.bEl();
            }
            nVar = iP;
        } else {
            ab.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            nVar = null;
        }
        if (nVar == null) {
            ab.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            AppMethodBeat.o(112087);
            return;
        }
        switch (nVar.field_msgType) {
            case 5:
                if (!bo.isNullOrNil(nVar.mWM)) {
                    b.a(this.mContext, 13, 1301, 3, com.tencent.mm.plugin.game.f.c.ax(this.mContext, nVar.mWM), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    AppMethodBeat.o(112087);
                    return;
                }
                break;
            case 6:
                if (!bo.isNullOrNil(nVar.mWJ)) {
                    b.a(this.mContext, 13, 1301, 3, com.tencent.mm.plugin.game.f.c.ax(this.mContext, nVar.mWJ), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    AppMethodBeat.o(112087);
                    return;
                }
                break;
            case 10:
            case 11:
                if (bo.isNullOrNil(nVar.mWh)) {
                    b.a(this.mContext, 13, 1301, 3, b.a(this.mContext, nVar), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    AppMethodBeat.o(112087);
                    return;
                }
                b.a(this.mContext, 13, 1301, 3, com.tencent.mm.plugin.game.f.c.ax(this.mContext, nVar.mWh), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                AppMethodBeat.o(112087);
                return;
            default:
                b.a(this.mContext, 13, 1301, 3, b.a(this.mContext, nVar), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                break;
        }
        AppMethodBeat.o(112087);
    }
}
