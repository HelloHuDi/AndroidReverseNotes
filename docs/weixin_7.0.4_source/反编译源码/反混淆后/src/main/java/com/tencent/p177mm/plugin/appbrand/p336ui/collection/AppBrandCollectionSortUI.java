package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.C0338m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.p336ui.collection.AppBrandCollectionVerticalSortList.C45698a;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C18524i
@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getLayoutId", "", "initActivityCloseAnimation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI */
public final class AppBrandCollectionSortUI extends MMActivity {
    public static final C27325a iLo = new C27325a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI$Companion;", "", "()V", "KEY_OPERATE_REPORT_SCENE", "", "KEY_OPERATE_REPORT_SCENE_ID", "KEY_SORT_DATA_LIST", "startSortList", "", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI$a */
    public static final class C27325a {
        private C27325a() {
        }

        public /* synthetic */ C27325a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(135039);
        AppMethodBeat.m2505o(135039);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        String str = null;
        AppMethodBeat.m2504i(135036);
        super.onCreate(bundle);
        Intent intent = getIntent();
        ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra("KEY_SORT_DATA_LIST") : null;
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            super.finish();
            AppMethodBeat.m2505o(135036);
            return;
        }
        int intExtra;
        overridePendingTransition(C25738R.anim.f8288n, C25738R.anim.f8293s);
        mo17446xE(-855310);
        getContentView().setBackgroundColor(dyd());
        C0338m beginTransaction = getSupportFragmentManager().beginTransaction();
        C45698a c45698a = AppBrandCollectionVerticalSortList.iLr;
        intent = getIntent();
        if (intent != null) {
            intExtra = intent.getIntExtra("KEY_OPERATE_REPORT_SCENE", 0);
        } else {
            intExtra = 0;
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra("KEY_OPERATE_REPORT_SCENE_ID");
        }
        C25052j.m39376p(parcelableArrayListExtra, "list");
        AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList = new AppBrandCollectionVerticalSortList();
        Bundle bundle2 = new Bundle(1);
        bundle2.putParcelableArrayList("KEY_SORT_DATA_LIST", parcelableArrayListExtra);
        bundle2.putInt("KEY_OPERATE_REPORT_SCENE", intExtra);
        bundle2.putString("KEY_OPERATE_REPORT_SCENE_ID", str);
        appBrandCollectionVerticalSortList.setArguments(bundle2);
        beginTransaction.mo556b(16908290, appBrandCollectionVerticalSortList).commit();
        AppMethodBeat.m2505o(135036);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(135037);
        super.onResume();
        setMMTitle((int) C25738R.string.f9030n1);
        dyb();
        AppMethodBeat.m2505o(135037);
    }

    public final void initActivityCloseAnimation() {
    }

    public final void finish() {
        AppMethodBeat.m2504i(135038);
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8289o);
        }
        intent = getIntent();
        if (intent != null) {
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8293s);
        }
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8289o);
        AppMethodBeat.m2505o(135038);
    }
}
