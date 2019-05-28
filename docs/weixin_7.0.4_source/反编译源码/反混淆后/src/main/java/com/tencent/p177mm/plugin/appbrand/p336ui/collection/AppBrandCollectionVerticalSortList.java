package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Context;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C16018h;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C30819l;
import com.tencent.p177mm.plugin.appbrand.appusage.C10120c;
import com.tencent.p177mm.plugin.appbrand.appusage.C10134z.C10133b;
import com.tencent.p177mm.plugin.appbrand.appusage.C38128f;
import com.tencent.p177mm.plugin.appbrand.appusage.C38128f.C38126a;
import com.tencent.p177mm.plugin.appbrand.appusage.C38128f.C38129b;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI.Fragment;
import com.tencent.p177mm.plugin.appbrand.report.C19692e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList */
public final class AppBrandCollectionVerticalSortList extends Fragment {
    public static final C45698a iLr = new C45698a();
    private DragSortListView iLp;
    private C45699c iLq;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList$d */
    static final class C10864d implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$onActivityCreated$1$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList$d$1 */
        public static final class C108651 extends C38129b {
            final /* synthetic */ C10864d iLt;

            C108651(C10864d c10864d) {
                this.iLt = c10864d;
            }

            /* renamed from: b */
            public final void mo21481b(LocalUsageInfo localUsageInfo) {
                AppMethodBeat.m2504i(135042);
                C25052j.m39376p(localUsageInfo, "info");
                Bundle arguments = this.iLt.iLs.getArguments();
                int i = arguments != null ? arguments.getInt("KEY_OPERATE_REPORT_SCENE") : 0;
                Bundle arguments2 = this.iLt.iLs.getArguments();
                C19692e.m30513a(localUsageInfo, 6, i, arguments2 != null ? arguments2.getString("KEY_OPERATE_REPORT_SCENE_ID") : null);
                AppMethodBeat.m2505o(135042);
            }

            /* renamed from: d */
            public final void mo21483d(LocalUsageInfo localUsageInfo) {
                AppMethodBeat.m2504i(135043);
                C25052j.m39376p(localUsageInfo, "info");
                Bundle arguments = this.iLt.iLs.getArguments();
                int i = arguments != null ? arguments.getInt("KEY_OPERATE_REPORT_SCENE") : 0;
                Bundle arguments2 = this.iLt.iLs.getArguments();
                C19692e.m30513a(localUsageInfo, 7, i, arguments2 != null ? arguments2.getString("KEY_OPERATE_REPORT_SCENE_ID") : null);
                AppMethodBeat.m2505o(135043);
            }

            public final void axa() {
                AppMethodBeat.m2504i(135044);
                C4990ab.m7416i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
                ((C10120c) C1720g.m3528K(C10120c.class)).mo21478a(C10133b.CloseCollectionList);
                FragmentActivity activity = this.iLt.iLs.getActivity();
                if (activity != null) {
                    activity.finish();
                    AppMethodBeat.m2505o(135044);
                    return;
                }
                AppMethodBeat.m2505o(135044);
            }
        }

        C10864d(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(135045);
            C38126a c38126a = C38128f.gYW;
            C38128f awZ = C38128f.gYV;
            if (awZ == null) {
                C25052j.dWJ();
            }
            C45699c a = this.iLs.iLq;
            if (a == null) {
                C25052j.dWJ();
            }
            awZ.mo60875a((List) a.iLD, (C38129b) new C108651(this));
            AppMethodBeat.m2505o(135045);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "from", "", "to", "drop"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList$b */
    static final class C16698b implements C16018h {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        C16698b(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        /* renamed from: dm */
        public final void mo17752dm(int i, int i2) {
            AppMethodBeat.m2504i(135040);
            C45699c a = this.iLs.iLq;
            if (a != null) {
                LocalUsageInfo pR = a.mo73494pR(i);
                if (pR != null) {
                    C45699c a2 = this.iLs.iLq;
                    if (a2 != null) {
                        a2.insert(pR, i2);
                        AppMethodBeat.m2505o(135040);
                        return;
                    }
                    AppMethodBeat.m2505o(135040);
                    return;
                }
            }
            AppMethodBeat.m2505o(135040);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "which", "", "remove"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList$c */
    static final class C27326c implements C30819l {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        C27326c(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        public final void remove(int i) {
            AppMethodBeat.m2504i(135041);
            C45699c a = this.iLs.iLq;
            if (a != null) {
                a.mo73494pR(i);
                AppMethodBeat.m2505o(135041);
                return;
            }
            AppMethodBeat.m2505o(135041);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList$e */
    static final class C27327e implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        C27327e(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(135046);
            FragmentActivity activity = this.iLs.getActivity();
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.m2505o(135046);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$Companion;", "", "()V", "KEY_DATA_LIST", "", "KEY_OPERATE_REPORT_SCENE", "KEY_OPERATE_REPORT_SCENE_ID", "TAG", "createSortList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList$a */
    public static final class C45698a {
        private C45698a() {
        }

        public /* synthetic */ C45698a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(135049);
        AppMethodBeat.m2505o(135049);
    }

    public final int getLayoutId() {
        return 2130968668;
    }

    public final void initView() {
        AppMethodBeat.m2504i(135047);
        this.iLp = (DragSortListView) aMg();
        DragSortListView dragSortListView = this.iLp;
        if (dragSortListView != null) {
            dragSortListView.setDropListener(new C16698b(this));
        }
        dragSortListView = this.iLp;
        if (dragSortListView != null) {
            dragSortListView.setRemoveListener(new C27326c(this));
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            C25052j.dWJ();
        }
        C25052j.m39375o(activity, "activity!!");
        Context context = activity;
        Bundle arguments = getArguments();
        if (arguments == null) {
            C25052j.dWJ();
        }
        ArrayList parcelableArrayList = arguments.getParcelableArrayList("KEY_SORT_DATA_LIST");
        if (parcelableArrayList == null) {
            C25052j.dWJ();
        }
        this.iLq = new C45699c(context, parcelableArrayList);
        C45699c c45699c = this.iLq;
        if (c45699c == null) {
            C25052j.dWJ();
        }
        dragSortListView = this.iLp;
        if (dragSortListView == null) {
            C25052j.dWJ();
        }
        C25052j.m39376p(dragSortListView, "list");
        c45699c.iLp = dragSortListView;
        dragSortListView = c45699c.iLp;
        if (dragSortListView == null) {
            C25052j.dWJ();
        }
        dragSortListView.setAdapter((ListAdapter) c45699c);
        AppMethodBeat.m2505o(135047);
    }

    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.m2504i(135048);
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.mo17379a(0, getString(C25738R.string.f9063o8), (OnMenuItemClickListener) new C10864d(this), C5535b.BLACK);
        }
        activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.setBackBtn(new C27327e(this), C1318a.actionbar_icon_dark_close);
            AppMethodBeat.m2505o(135048);
            return;
        }
        AppMethodBeat.m2505o(135048);
    }
}
