package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C45522w;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherFolderUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherFolderUI.C2468a;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderRecentsEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandUsageStorage;", "activity", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "queryList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "shouldShowcaseEnableSwitch", "show", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.c */
public final class C2487c extends C33558d<C45522w> {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.c$a */
    static final class C2488a implements Runnable {
        final /* synthetic */ boolean iLX;
        final /* synthetic */ C2487c iLY;

        C2488a(C2487c c2487c, boolean z) {
            this.iLY = c2487c;
            this.iLX = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(135128);
            AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.iLY.iMd;
            C25052j.m39375o(appBrandNearbyShowcaseView, "mShowcaseView");
            appBrandNearbyShowcaseView.setVisibility(this.iLX ? 0 : 8);
            AppMethodBeat.m2505o(135128);
        }
    }

    public C2487c(Activity activity, ViewGroup viewGroup) {
        super(C45522w.class, activity, viewGroup);
    }

    /* renamed from: eH */
    public final void mo6421eH(boolean z) {
        AppMethodBeat.m2504i(135129);
        this.iMd.post(new C2488a(this, z));
        AppMethodBeat.m2505o(135129);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<? extends LocalUsageInfo> aNk() {
        AppMethodBeat.m2504i(135130);
        List nD = ((C45522w) C42340f.m74878E(C45522w.class)).mo73336nD(this.iMb);
        AppMethodBeat.m2505o(135130);
        return nD;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTitle() {
        AppMethodBeat.m2504i(135131);
        String string = getActivity().getString(C25738R.string.f9031n2);
        C25052j.m39375o(string, "activity.getString(com.t…eader_recent_tag_wording)");
        AppMethodBeat.m2505o(135131);
        return string;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(135132);
        C2468a c2468a = AppBrandLauncherFolderUI.iGG;
        Activity activity = getActivity();
        C25052j.m39375o(activity, "activity");
        Context context = activity;
        Intent intent = new Intent();
        intent.putExtra("extra_get_usage_reason", 3);
        C2468a.m4706o(context, intent);
        AppMethodBeat.m2505o(135132);
    }
}
