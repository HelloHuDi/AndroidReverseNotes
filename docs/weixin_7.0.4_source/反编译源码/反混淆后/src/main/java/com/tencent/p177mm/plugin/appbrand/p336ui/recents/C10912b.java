package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherFolderUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherFolderUI.C2468a;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderCollectionEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandStarAppStorage;", "activity", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "queryList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "shouldShowcaseEnableSwitch", "show", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.b */
public final class C10912b extends C33558d<C26779s> {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.b$a */
    static final class C10913a implements Runnable {
        final /* synthetic */ C10912b iLW;
        final /* synthetic */ boolean iLX;

        C10913a(C10912b c10912b, boolean z) {
            this.iLW = c10912b;
            this.iLX = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(135123);
            AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.iLW.iMd;
            C25052j.m39375o(appBrandNearbyShowcaseView, "mShowcaseView");
            appBrandNearbyShowcaseView.setVisibility(this.iLX ? 0 : 8);
            AppMethodBeat.m2505o(135123);
        }
    }

    public C10912b(Activity activity, ViewGroup viewGroup) {
        super(C26779s.class, activity, viewGroup);
    }

    /* renamed from: eH */
    public final void mo6421eH(boolean z) {
        AppMethodBeat.m2504i(135124);
        this.iMd.post(new C10913a(this, z));
        AppMethodBeat.m2505o(135124);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<LocalUsageInfo> aNk() {
        AppMethodBeat.m2504i(135125);
        List a = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(this.iMb, C10117a.DESC);
        AppMethodBeat.m2505o(135125);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTitle() {
        AppMethodBeat.m2504i(135126);
        String string = getActivity().getString(C25738R.string.f9030n1);
        C25052j.m39375o(string, "activity.getString(com.t…list_collection_entrance)");
        AppMethodBeat.m2505o(135126);
        return string;
    }

    public final void onClick(View view) {
        int i;
        AppMethodBeat.m2504i(135127);
        Activity activity = getActivity();
        C25052j.m39375o(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null || intent.getIntExtra("extra_get_usage_reason", 3) != 9) {
            i = 0;
        } else {
            i = 2;
        }
        C2468a c2468a = AppBrandLauncherFolderUI.iGG;
        activity = getActivity();
        C25052j.m39375o(activity, "activity");
        Context context = activity;
        Intent intent2 = new Intent();
        intent2.putExtra("extra_get_usage_reason", 8);
        intent2.putExtra("extra_get_usage_prescene", i);
        intent2.putExtra("extra_enter_scene", 1);
        C2468a.m4707p(context, intent2);
        AppMethodBeat.m2505o(135127);
    }
}
