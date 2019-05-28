package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Intent;
import android.support.p057v4.app.C0338m;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C26766ae;
import com.tencent.p177mm.plugin.appbrand.appusage.C26766ae.C26764a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherBlankPage;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI.Fragment;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C24709a;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionFolderActivityContext;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "onActivityDidCreate", "", "intent", "Landroid/content/Intent;", "onActivityDidResume", "onActivityWillDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showListPage", "showList", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.e */
public final class C45700e extends C24709a implements C4931a {
    private final String TAG = "CollectionFolderActivityContext";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.e$a */
    static final class C2484a implements Runnable {
        final /* synthetic */ C45700e iLJ;

        C2484a(C45700e c45700e) {
            this.iLJ = c45700e;
        }

        public final void run() {
            AppMethodBeat.m2504i(135093);
            this.iLJ.mo17538eE(true);
            AppMethodBeat.m2505o(135093);
        }
    }

    public C45700e(MMActivity mMActivity) {
        C25052j.m39376p(mMActivity, "activity");
        super(mMActivity);
        AppMethodBeat.m2504i(135099);
        AppMethodBeat.m2505o(135099);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(135094);
        C1694a K = C1720g.m3528K(C10118af.class);
        C25052j.m39375o(K, "MMKernel.service(IAppBra…ctionStorage::class.java)");
        if (((C10118af) K).getCount() > 0) {
            aNg().runOnUiThread(new C2484a(this));
        }
        AppMethodBeat.m2505o(135094);
    }

    /* renamed from: eE */
    public final void mo17538eE(boolean z) {
        AppMethodBeat.m2504i(135095);
        MMActivity aNg = aNg();
        C25052j.m39375o(aNg, "activity");
        if (aNg.isFinishing()) {
            AppMethodBeat.m2505o(135095);
            return;
        }
        Class cls;
        if (z) {
            cls = AppBrandCollectionDisplayVerticalList.class;
        } else {
            cls = AppBrandLauncherBlankPage.class;
        }
        MMActivity aNg2 = aNg();
        C25052j.m39375o(aNg2, "activity");
        if (cls.isInstance(aNg2.getSupportFragmentManager().findFragmentById(16908290))) {
            AppMethodBeat.m2505o(135095);
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
        C25052j.m39375o(aNg, "activity");
        C0338m beginTransaction = aNg.getSupportFragmentManager().beginTransaction();
        if (z) {
            appBrandCollectionDisplayVerticalList = new AppBrandCollectionDisplayVerticalList();
        } else {
            appBrandCollectionDisplayVerticalList = AppBrandLauncherBlankPage.m65231cO(aNg().getString(C25738R.string.f9030n1), aNg().getString(C25738R.string.f8861he));
        }
        beginTransaction.mo556b(16908290, appBrandCollectionDisplayVerticalList).commitAllowingStateLoss();
        C10118af c10118af = (C10118af) C1720g.m3528K(C10118af.class);
        aNg2 = aNg();
        if (aNg2 != null) {
            Intent intent = aNg2.getIntent();
            if (intent != null) {
                int intExtra = intent.getIntExtra("extra_enter_scene", -1);
                C4990ab.m7416i(this.TAG, "EnterScene = ".concat(String.valueOf(intExtra)));
                switch (intExtra) {
                    case 1:
                    case 3:
                    case 4:
                        C19690c.m30505pG(intExtra);
                        break;
                }
            }
        }
        if (z) {
            c10118af.mo10117d(this);
        } else {
            C4931a c4931a = this;
            C5004al aNS = C45673m.aNS();
            C25052j.m39375o(aNS, "ThreadUtil.getWorkerThread()");
            c10118af.mo10114a(c4931a, aNS.getLooper());
        }
        if (z) {
            C45694h.m84420b(C38519g.WASERVICE);
            C45694h.m84420b(C38519g.WAGAME);
        }
        AppMethodBeat.m2505o(135095);
    }

    /* renamed from: N */
    public final void mo41600N(Intent intent) {
        AppMethodBeat.m2504i(135096);
        View findViewById = aNg().findViewById(16908290);
        if (findViewById != null) {
            findViewById.setBackgroundColor(-855310);
        }
        mo17538eE(true);
        if (intent != null) {
            int intExtra = intent.getIntExtra("extra_get_usage_reason", 7);
            int intExtra2 = intent.getIntExtra("extra_get_usage_prescene", 0);
            C26764a c26764a = C26766ae.haH;
            C26764a.m42596cP(intExtra, intExtra2);
            AppMethodBeat.m2505o(135096);
            return;
        }
        AppMethodBeat.m2505o(135096);
    }

    public final void onActivityDidResume() {
        AppMethodBeat.m2504i(135097);
        aNg().setMMTitle((int) C25738R.string.f9030n1);
        AppMethodBeat.m2505o(135097);
    }

    public final void onActivityWillDestroy() {
        AppMethodBeat.m2504i(135098);
        super.onActivityWillDestroy();
        ((C10118af) C1720g.m3528K(C10118af.class)).mo10117d(this);
        AppMethodBeat.m2505o(135098);
    }
}
