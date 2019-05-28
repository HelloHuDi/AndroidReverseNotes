package com.tencent.p177mm.plugin.card.p355ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C33753g;
import com.tencent.p177mm.plugin.card.p355ui.view.C11358g;
import com.tencent.p177mm.plugin.card.p355ui.view.C20197m;
import com.tencent.p177mm.plugin.card.p931d.C11280q;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.card.ui.b */
public final class C11332b implements ActivityLifecycleCallbacks {
    private int kix = 0;

    /* renamed from: com.tencent.mm.plugin.card.ui.b$1 */
    class C113331 implements Runnable {
        C113331() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88237);
            C4990ab.m7416i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
            C33753g bbm = C42852am.bbm();
            if (bbm != null) {
                bbm.mo54286a(C11280q.EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND);
            }
            AppMethodBeat.m2505o(88237);
        }
    }

    public static Application aMe() {
        AppMethodBeat.m2504i(88238);
        Application application = (Application) C4996ah.getContext().getApplicationContext();
        AppMethodBeat.m2505o(88238);
        return application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.m2504i(88239);
        if (this.kix < 0) {
            if (activity == null || !(activity instanceof CardDetailUI)) {
                C1720g.m3539RS().mo10302aa(new C113331());
            } else {
                CardDetailUI cardDetailUI = (CardDetailUI) activity;
                if (cardDetailUI.kiM != null) {
                    C11358g c11358g = cardDetailUI.kiM.kjk;
                    if (c11358g != null && (c11358g instanceof C20197m)) {
                        C4990ab.m7416i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
                        cardDetailUI.kiM.kjk.mo23067d(C42839c.CARDCODEREFRESHACTION_ENTERFOREGROUND);
                    }
                }
            }
        }
        this.kix++;
        AppMethodBeat.m2505o(88239);
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
