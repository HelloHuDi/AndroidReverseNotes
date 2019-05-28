package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.o */
public final class C43208o extends C12195b {
    public C43208o(Context context, int i) {
        super(context);
        this.mXC = i;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(112083);
        if (view.getTag() instanceof C28229n) {
            C28229n c28229n = (C28229n) view.getTag();
            switch (c28229n.field_msgType) {
                case 6:
                    if (!C5046bo.isNullOrNil(c28229n.mWo)) {
                        C34277b.m56210a(this.mContext, 13, 1301, 5, C46001c.m85455ax(this.mContext, c28229n.mWo), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                        AppMethodBeat.m2505o(112083);
                        return;
                    }
                    break;
                default:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", c28229n.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    C34277b.m56210a(this.mContext, 13, 1301, 5, C46001c.m85457b(this.mContext, c28229n.field_appId, null, bundle), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    break;
            }
            AppMethodBeat.m2505o(112083);
            return;
        }
        AppMethodBeat.m2505o(112083);
    }
}
