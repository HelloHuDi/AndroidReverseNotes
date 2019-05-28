package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ae;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionFolderActivityContext;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "onActivityDidCreate", "", "intent", "Landroid/content/Intent;", "onActivityDidResume", "onActivityWillDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showListPage", "showList", "", "plugin-appbrand-integration_release"})
public final class e extends com.tencent.mm.plugin.appbrand.ui.a.a implements com.tencent.mm.sdk.e.k.a {
    private final String TAG = "CollectionFolderActivityContext";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ e iLJ;

        a(e eVar) {
            this.iLJ = eVar;
        }

        public final void run() {
            AppMethodBeat.i(135093);
            this.iLJ.eE(true);
            AppMethodBeat.o(135093);
        }
    }

    public e(MMActivity mMActivity) {
        j.p(mMActivity, "activity");
        super(mMActivity);
        AppMethodBeat.i(135099);
        AppMethodBeat.o(135099);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(135094);
        com.tencent.mm.kernel.c.a K = g.K(af.class);
        j.o(K, "MMKernel.service(IAppBra…ctionStorage::class.java)");
        if (((af) K).getCount() > 0) {
            aNg().runOnUiThread(new a(this));
        }
        AppMethodBeat.o(135094);
    }

    public final void eE(boolean z) {
        AppMethodBeat.i(135095);
        MMActivity aNg = aNg();
        j.o(aNg, "activity");
        if (aNg.isFinishing()) {
            AppMethodBeat.o(135095);
            return;
        }
        Class cls;
        if (z) {
            cls = AppBrandCollectionDisplayVerticalList.class;
        } else {
            cls = AppBrandLauncherBlankPage.class;
        }
        MMActivity aNg2 = aNg();
        j.o(aNg2, "activity");
        if (cls.isInstance(aNg2.getSupportFragmentManager().findFragmentById(16908290))) {
            AppMethodBeat.o(135095);
            return;
        }
        Fragment appBrandCollectionDisplayVerticalList;
        aNg().removeAllOptionMenu();
        if (z) {
            aNg().dyc();
        } else {
            aNg().dyb();
        }
        aNg = aNg();
        j.o(aNg, "activity");
        android.support.v4.app.m beginTransaction = aNg.getSupportFragmentManager().beginTransaction();
        if (z) {
            appBrandCollectionDisplayVerticalList = new AppBrandCollectionDisplayVerticalList();
        } else {
            appBrandCollectionDisplayVerticalList = AppBrandLauncherBlankPage.cO(aNg().getString(R.string.n1), aNg().getString(R.string.he));
        }
        beginTransaction.b(16908290, appBrandCollectionDisplayVerticalList).commitAllowingStateLoss();
        af afVar = (af) g.K(af.class);
        aNg2 = aNg();
        if (aNg2 != null) {
            Intent intent = aNg2.getIntent();
            if (intent != null) {
                int intExtra = intent.getIntExtra("extra_enter_scene", -1);
                ab.i(this.TAG, "EnterScene = ".concat(String.valueOf(intExtra)));
                switch (intExtra) {
                    case 1:
                    case 3:
                    case 4:
                        c.pG(intExtra);
                        break;
                }
            }
        }
        if (z) {
            afVar.d(this);
        } else {
            com.tencent.mm.sdk.e.k.a aVar = this;
            al aNS = com.tencent.mm.plugin.appbrand.r.m.aNS();
            j.o(aNS, "ThreadUtil.getWorkerThread()");
            afVar.a(aVar, aNS.getLooper());
        }
        if (z) {
            h.b(com.tencent.mm.plugin.appbrand.task.g.WASERVICE);
            h.b(com.tencent.mm.plugin.appbrand.task.g.WAGAME);
        }
        AppMethodBeat.o(135095);
    }

    public final void N(Intent intent) {
        AppMethodBeat.i(135096);
        View findViewById = aNg().findViewById(16908290);
        if (findViewById != null) {
            findViewById.setBackgroundColor(-855310);
        }
        eE(true);
        if (intent != null) {
            int intExtra = intent.getIntExtra("extra_get_usage_reason", 7);
            int intExtra2 = intent.getIntExtra("extra_get_usage_prescene", 0);
            com.tencent.mm.plugin.appbrand.appusage.ae.a aVar = ae.haH;
            com.tencent.mm.plugin.appbrand.appusage.ae.a.cP(intExtra, intExtra2);
            AppMethodBeat.o(135096);
            return;
        }
        AppMethodBeat.o(135096);
    }

    public final void onActivityDidResume() {
        AppMethodBeat.i(135097);
        aNg().setMMTitle((int) R.string.n1);
        AppMethodBeat.o(135097);
    }

    public final void onActivityWillDestroy() {
        AppMethodBeat.i(135098);
        super.onActivityWillDestroy();
        ((af) g.K(af.class)).d(this);
        AppMethodBeat.o(135098);
    }
}
