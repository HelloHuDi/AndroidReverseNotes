package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.p */
public final class C43209p extends C12195b {
    public C43209p(Context context, int i) {
        super(context);
        this.mXC = i;
    }

    public final void onClick(View view) {
        C28229n c28229n;
        AppMethodBeat.m2504i(112087);
        Object tag = view.getTag();
        if (tag == null) {
            C4990ab.m7412e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            c28229n = null;
        } else if (tag instanceof Long) {
            C28229n iP = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(((Long) tag).longValue());
            if (iP != null) {
                iP.bEl();
            }
            c28229n = iP;
        } else {
            C4990ab.m7412e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            c28229n = null;
        }
        if (c28229n == null) {
            C4990ab.m7412e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            AppMethodBeat.m2505o(112087);
            return;
        }
        switch (c28229n.field_msgType) {
            case 5:
                if (!C5046bo.isNullOrNil(c28229n.mWM)) {
                    C34277b.m56210a(this.mContext, 13, 1301, 3, C46001c.m85455ax(this.mContext, c28229n.mWM), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    AppMethodBeat.m2505o(112087);
                    return;
                }
                break;
            case 6:
                if (!C5046bo.isNullOrNil(c28229n.mWJ)) {
                    C34277b.m56210a(this.mContext, 13, 1301, 3, C46001c.m85455ax(this.mContext, c28229n.mWJ), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    AppMethodBeat.m2505o(112087);
                    return;
                }
                break;
            case 10:
            case 11:
                if (C5046bo.isNullOrNil(c28229n.mWh)) {
                    C34277b.m56210a(this.mContext, 13, 1301, 3, C12195b.m20128a(this.mContext, c28229n), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    AppMethodBeat.m2505o(112087);
                    return;
                }
                C34277b.m56210a(this.mContext, 13, 1301, 3, C46001c.m85455ax(this.mContext, c28229n.mWh), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                AppMethodBeat.m2505o(112087);
                return;
            default:
                C34277b.m56210a(this.mContext, 13, 1301, 3, C12195b.m20128a(this.mContext, c28229n), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                break;
        }
        AppMethodBeat.m2505o(112087);
    }
}
