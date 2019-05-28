package com.tencent.p177mm.plugin.game.luggage.p432d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.game.luggage.p430c.C41284a;
import com.tencent.p177mm.plugin.game.luggage.p430c.C46005b;
import com.tencent.p177mm.plugin.game.luggage.p430c.p431a.C34290b;
import com.tencent.p177mm.plugin.game.luggage.p430c.p431a.C34291c;
import com.tencent.p177mm.plugin.webview.luggage.C22857k;
import com.tencent.p177mm.plugin.webview.luggage.p1330b.C40224l;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.luggage.d.c */
public final class C24775c extends C22857k {
    private C46005b mUB;
    private C34291c mUC;
    private C12140e mUm;
    private C34290b mUz;

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.c$1 */
    class C121381 implements Runnable {
        C121381() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135918);
            if (C5046bo.isNullOrNil(C24775c.this.mUm.bPP.getString("game_hv_menu_appid"))) {
                C24775c.this.mUB = new C46005b(C24775c.this.mUm, C24775c.this.getMenuHelp());
                AppMethodBeat.m2505o(135918);
                return;
            }
            C24775c.this.mUC = new C34291c(C24775c.this.mUm, C24775c.m38674b(C24775c.this));
            AppMethodBeat.m2505o(135918);
        }
    }

    /* renamed from: b */
    static /* synthetic */ C34290b m38674b(C24775c c24775c) {
        AppMethodBeat.m2504i(135924);
        C34290b h5GameMenuHelp = c24775c.getH5GameMenuHelp();
        AppMethodBeat.m2505o(135924);
        return h5GameMenuHelp;
    }

    public C24775c(C12140e c12140e) {
        super(c12140e);
        this.mUm = c12140e;
    }

    public final C40224l getMenuHelp() {
        AppMethodBeat.m2504i(135919);
        if (this.ujb == null) {
            this.ujb = new C41284a();
        }
        C40224l c40224l = this.ujb;
        AppMethodBeat.m2505o(135919);
        return c40224l;
    }

    private C34290b getH5GameMenuHelp() {
        AppMethodBeat.m2504i(135920);
        if (this.mUz == null) {
            this.mUz = new C34290b(this.mUm.bPP.getString("game_hv_menu_appid"));
        }
        C34290b c34290b = this.mUz;
        AppMethodBeat.m2505o(135920);
        return c34290b;
    }

    public final void bDx() {
        AppMethodBeat.m2504i(135921);
        if (!this.mUm.bPe.mo43477xi().mo60233aZ(!(this.mUm instanceof C39210a))) {
            ((Activity) this.mContext).finish();
        }
        AppMethodBeat.m2505o(135921);
    }

    public final void bDy() {
        long j;
        AppMethodBeat.m2504i(135922);
        boolean z = false;
        if (getContext() instanceof MMActivity) {
            z = ((MMActivity) getContext()).mController.hideVKB();
        }
        C121381 c121381 = new C121381();
        if (z) {
            j = 100;
        } else {
            j = 0;
        }
        C5004al.m7442n(c121381, j);
        AppMethodBeat.m2505o(135922);
    }

    public final void bDz() {
        AppMethodBeat.m2504i(135923);
        if (this.mUB != null) {
            this.mUB.cXg();
        }
        if (this.mUC != null) {
            C34291c c34291c = this.mUC;
            if (c34291c.mUo != null) {
                c34291c.mUo.cpE();
            }
        }
        AppMethodBeat.m2505o(135923);
    }
}
