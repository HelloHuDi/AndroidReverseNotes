package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.ax.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class u implements OnClickListener {
    private Context mContext;
    int mXC = 0;
    private c mXM;
    String nek = null;
    private int nnd;

    public u(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(112216);
        if (view.getTag() instanceof c) {
            this.mXM = (c) view.getTag();
            ab.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.mXM.field_appId);
            if (g.u(this.mContext, this.mXM.field_appId)) {
                ab.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.mXM.field_appId + ", pkg = " + this.mXM.field_packageName + ", openId = " + this.mXM.field_openId);
                b.a(this.mContext, this.mXM.scene, this.mXM.cKG, this.mXM.position, 3, this.mXM.field_appId, this.mXC, this.nek);
                e.ak(this.mContext, this.mXM.field_appId);
                AppMethodBeat.o(112216);
                return;
            }
            int i;
            int i2;
            ax.bEU();
            String str = this.mXM.dnl;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
                i = -1;
            } else {
                i = ax.a(new a().NY(str));
            }
            this.nnd = i;
            str = this.mXM.dnl;
            if (!bo.isNullOrNil(str)) {
                str = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
            }
            if (this.mXM.status == 3) {
                ax.bEU();
                ax.startToAuthorized(this.mContext, str);
            } else {
                ax.bEU();
                ax.aw(this.mContext, str);
            }
            i = 5;
            if (this.mXM.status == 3) {
                i = 10;
            }
            if (this.nnd == 4) {
                i2 = 8;
            } else {
                i2 = i;
            }
            b.a(this.mContext, this.mXM.scene, this.mXM.cKG, this.mXM.position, i2, this.mXM.field_appId, this.mXC, this.mXM.ctu, this.nek);
            AppMethodBeat.o(112216);
            return;
        }
        ab.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
        AppMethodBeat.o(112216);
    }
}
