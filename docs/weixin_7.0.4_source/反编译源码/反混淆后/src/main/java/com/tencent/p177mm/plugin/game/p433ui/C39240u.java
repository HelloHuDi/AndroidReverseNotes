package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C39214ax;
import com.tencent.p177mm.plugin.game.model.C39214ax.C34300a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.u */
public final class C39240u implements OnClickListener {
    private Context mContext;
    int mXC = 0;
    private C20992c mXM;
    String nek = null;
    private int nnd;

    public C39240u(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(112216);
        if (view.getTag() instanceof C20992c) {
            this.mXM = (C20992c) view.getTag();
            C4990ab.m7416i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.mXM.field_appId);
            if (C46494g.m87757u(this.mContext, this.mXM.field_appId)) {
                C4990ab.m7410d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.mXM.field_appId + ", pkg = " + this.mXM.field_packageName + ", openId = " + this.mXM.field_openId);
                C34277b.m56211a(this.mContext, this.mXM.scene, this.mXM.cKG, this.mXM.position, 3, this.mXM.field_appId, this.mXC, this.nek);
                C20993e.m32265ak(this.mContext, this.mXM.field_appId);
                AppMethodBeat.m2505o(112216);
                return;
            }
            int i;
            int i2;
            C39214ax.bEU();
            String str = this.mXM.dnl;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
                i = -1;
            } else {
                i = C39214ax.m66818a(new C34300a().mo54824NY(str));
            }
            this.nnd = i;
            str = this.mXM.dnl;
            if (!C5046bo.isNullOrNil(str)) {
                str = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
            }
            if (this.mXM.status == 3) {
                C39214ax.bEU();
                C39214ax.startToAuthorized(this.mContext, str);
            } else {
                C39214ax.bEU();
                C39214ax.m66819aw(this.mContext, str);
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
            C34277b.m56212a(this.mContext, this.mXM.scene, this.mXM.cKG, this.mXM.position, i2, this.mXM.field_appId, this.mXC, this.mXM.ctu, this.nek);
            AppMethodBeat.m2505o(112216);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
        AppMethodBeat.m2505o(112216);
    }
}
