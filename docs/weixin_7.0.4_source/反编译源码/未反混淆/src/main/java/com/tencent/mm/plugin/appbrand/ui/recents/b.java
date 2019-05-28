package com.tencent.mm.plugin.appbrand.ui.recents;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderCollectionEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandStarAppStorage;", "activity", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "getTitle", "", "onClick", "", "v", "Landroid/view/View;", "queryList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "shouldShowcaseEnableSwitch", "show", "", "plugin-appbrand-integration_release"})
public final class b extends d<s> {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ b iLW;
        final /* synthetic */ boolean iLX;

        a(b bVar, boolean z) {
            this.iLW = bVar;
            this.iLX = z;
        }

        public final void run() {
            AppMethodBeat.i(135123);
            AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.iLW.iMd;
            j.o(appBrandNearbyShowcaseView, "mShowcaseView");
            appBrandNearbyShowcaseView.setVisibility(this.iLX ? 0 : 8);
            AppMethodBeat.o(135123);
        }
    }

    public b(Activity activity, ViewGroup viewGroup) {
        super(s.class, activity, viewGroup);
    }

    public final void eH(boolean z) {
        AppMethodBeat.i(135124);
        this.iMd.post(new a(this, z));
        AppMethodBeat.o(135124);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<LocalUsageInfo> aNk() {
        AppMethodBeat.i(135125);
        List a = ((af) g.K(af.class)).a(this.iMb, com.tencent.mm.plugin.appbrand.appusage.af.a.DESC);
        AppMethodBeat.o(135125);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTitle() {
        AppMethodBeat.i(135126);
        String string = getActivity().getString(R.string.n1);
        j.o(string, "activity.getString(com.t…list_collection_entrance)");
        AppMethodBeat.o(135126);
        return string;
    }

    public final void onClick(View view) {
        int i;
        AppMethodBeat.i(135127);
        Activity activity = getActivity();
        j.o(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null || intent.getIntExtra("extra_get_usage_reason", 3) != 9) {
            i = 0;
        } else {
            i = 2;
        }
        com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a aVar = AppBrandLauncherFolderUI.iGG;
        activity = getActivity();
        j.o(activity, "activity");
        Context context = activity;
        Intent intent2 = new Intent();
        intent2.putExtra("extra_get_usage_reason", 8);
        intent2.putExtra("extra_get_usage_prescene", i);
        intent2.putExtra("extra_enter_scene", 1);
        com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a.p(context, intent2);
        AppMethodBeat.o(135127);
    }
}
