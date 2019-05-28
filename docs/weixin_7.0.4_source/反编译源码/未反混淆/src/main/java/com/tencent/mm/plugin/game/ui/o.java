package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.bo;

public final class o extends b {
    public o(Context context, int i) {
        super(context);
        this.mXC = i;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(112083);
        if (view.getTag() instanceof n) {
            n nVar = (n) view.getTag();
            switch (nVar.field_msgType) {
                case 6:
                    if (!bo.isNullOrNil(nVar.mWo)) {
                        b.a(this.mContext, 13, 1301, 5, c.ax(this.mContext, nVar.mWo), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                        AppMethodBeat.o(112083);
                        return;
                    }
                    break;
                default:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", nVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    b.a(this.mContext, 13, 1301, 5, c.b(this.mContext, nVar.field_appId, null, bundle), 0, nVar.field_appId, this.mXC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    break;
            }
            AppMethodBeat.o(112083);
            return;
        }
        AppMethodBeat.o(112083);
    }
}
