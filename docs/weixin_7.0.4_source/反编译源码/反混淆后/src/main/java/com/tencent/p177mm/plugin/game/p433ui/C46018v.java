package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.v */
public final class C46018v implements OnClickListener {
    private int gOW = 13;
    private Context mContext;
    private int mPosition;
    private int mXC;
    private int nne;

    public C46018v(Context context) {
        this.mContext = context;
    }

    /* renamed from: em */
    public final void mo73919em(int i, int i2) {
        this.mXC = i;
        this.nne = 1301;
        this.mPosition = i2;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(112217);
        String str;
        if (view.getTag() == null) {
            AppMethodBeat.m2505o(112217);
        } else if (view.getTag() instanceof C28229n) {
            C28229n c28229n = (C28229n) view.getTag();
            if (!C5046bo.m7548ek(c28229n.mWp)) {
                str = ((C28233i) c28229n.mWp.get(0)).mXv;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                } else {
                    C34277b.m56210a(this.mContext, this.gOW, this.nne, this.mPosition, C46001c.m85455ax(this.mContext, str), 0, c28229n.field_appId, this.mXC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    AppMethodBeat.m2505o(112217);
                    return;
                }
            }
            AppMethodBeat.m2505o(112217);
        } else {
            if (view.getTag() instanceof String) {
                str = (String) view.getTag();
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(112217);
                    return;
                } else {
                    C34277b.m56209a(this.mContext, this.gOW, this.nne, this.mPosition, C46001c.m85455ax(this.mContext, str), this.mXC, null);
                }
            }
            AppMethodBeat.m2505o(112217);
        }
    }
}
