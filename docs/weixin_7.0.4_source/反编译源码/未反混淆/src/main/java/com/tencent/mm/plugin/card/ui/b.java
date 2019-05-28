package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b implements ActivityLifecycleCallbacks {
    private int kix = 0;

    public static Application aMe() {
        AppMethodBeat.i(88238);
        Application application = (Application) ah.getContext().getApplicationContext();
        AppMethodBeat.o(88238);
        return application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.i(88239);
        if (this.kix < 0) {
            if (activity == null || !(activity instanceof CardDetailUI)) {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(88237);
                        ab.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
                        com.tencent.mm.plugin.card.b.g bbm = am.bbm();
                        if (bbm != null) {
                            bbm.a(q.EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND);
                        }
                        AppMethodBeat.o(88237);
                    }
                });
            } else {
                CardDetailUI cardDetailUI = (CardDetailUI) activity;
                if (cardDetailUI.kiM != null) {
                    com.tencent.mm.plugin.card.ui.view.g gVar = cardDetailUI.kiM.kjk;
                    if (gVar != null && (gVar instanceof m)) {
                        ab.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
                        cardDetailUI.kiM.kjk.d(c.CARDCODEREFRESHACTION_ENTERFOREGROUND);
                    }
                }
            }
        }
        this.kix++;
        AppMethodBeat.o(88239);
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.kix--;
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }
}
