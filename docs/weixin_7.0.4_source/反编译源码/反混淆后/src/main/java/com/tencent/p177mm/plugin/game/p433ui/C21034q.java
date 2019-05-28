package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.q */
public final class C21034q implements OnClickListener {
    int emC;
    protected Context mContext;
    private C20992c mVZ;
    String nlL = null;

    public C21034q(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(112143);
        if (view.getTag() instanceof C20992c) {
            this.mVZ = (C20992c) view.getTag();
            C4990ab.m7416i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.mVZ.field_appId);
            if (C46494g.m87757u(this.mContext, this.mVZ.field_appId)) {
                C4990ab.m7410d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.mVZ.field_appId + ", pkg = " + this.mVZ.field_packageName + ", openId = " + this.mVZ.field_openId);
                C20993e.m32265ak(this.mContext, this.mVZ.field_appId);
                C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 3, this.mVZ.field_appId, this.emC, this.mVZ.ctu, this.mVZ.mVB);
                AppMethodBeat.m2505o(112143);
                return;
            }
            C4990ab.m7417i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", this.nlL);
            if (C5046bo.isNullOrNil(this.nlL)) {
                C4990ab.m7412e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
                AppMethodBeat.m2505o(112143);
                return;
            }
            C46001c.m85455ax(this.mContext, this.nlL);
            C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 11, this.mVZ.field_appId, this.emC, this.mVZ.ctu, this.mVZ.mVB);
            AppMethodBeat.m2505o(112143);
            return;
        }
        C4990ab.m7412e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
        AppMethodBeat.m2505o(112143);
    }
}
