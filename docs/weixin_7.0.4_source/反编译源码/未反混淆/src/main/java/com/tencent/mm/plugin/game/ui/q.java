package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q implements OnClickListener {
    int emC;
    protected Context mContext;
    private c mVZ;
    String nlL = null;

    public q(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(112143);
        if (view.getTag() instanceof c) {
            this.mVZ = (c) view.getTag();
            ab.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.mVZ.field_appId);
            if (g.u(this.mContext, this.mVZ.field_appId)) {
                ab.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.mVZ.field_appId + ", pkg = " + this.mVZ.field_packageName + ", openId = " + this.mVZ.field_openId);
                e.ak(this.mContext, this.mVZ.field_appId);
                b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 3, this.mVZ.field_appId, this.emC, this.mVZ.ctu, this.mVZ.mVB);
                AppMethodBeat.o(112143);
                return;
            }
            ab.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", this.nlL);
            if (bo.isNullOrNil(this.nlL)) {
                ab.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
                AppMethodBeat.o(112143);
                return;
            }
            com.tencent.mm.plugin.game.f.c.ax(this.mContext, this.nlL);
            b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 11, this.mVZ.field_appId, this.emC, this.mVZ.ctu, this.mVZ.mVB);
            AppMethodBeat.o(112143);
            return;
        }
        ab.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
        AppMethodBeat.o(112143);
    }
}
