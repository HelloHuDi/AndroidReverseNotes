package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "getLayoutId", "", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionVerticalSortList extends Fragment {
    public static final a iLr = new a();
    private DragSortListView iLp;
    private c iLq;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$onActivityCreated$1$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList$d$1 */
        public static final class AnonymousClass1 extends com.tencent.mm.plugin.appbrand.appusage.f.b {
            final /* synthetic */ d iLt;

            AnonymousClass1(d dVar) {
                this.iLt = dVar;
            }

            public final void b(LocalUsageInfo localUsageInfo) {
                AppMethodBeat.i(135042);
                j.p(localUsageInfo, "info");
                Bundle arguments = this.iLt.iLs.getArguments();
                int i = arguments != null ? arguments.getInt("KEY_OPERATE_REPORT_SCENE") : 0;
                Bundle arguments2 = this.iLt.iLs.getArguments();
                com.tencent.mm.plugin.appbrand.report.e.a(localUsageInfo, 6, i, arguments2 != null ? arguments2.getString("KEY_OPERATE_REPORT_SCENE_ID") : null);
                AppMethodBeat.o(135042);
            }

            public final void d(LocalUsageInfo localUsageInfo) {
                AppMethodBeat.i(135043);
                j.p(localUsageInfo, "info");
                Bundle arguments = this.iLt.iLs.getArguments();
                int i = arguments != null ? arguments.getInt("KEY_OPERATE_REPORT_SCENE") : 0;
                Bundle arguments2 = this.iLt.iLs.getArguments();
                com.tencent.mm.plugin.appbrand.report.e.a(localUsageInfo, 7, i, arguments2 != null ? arguments2.getString("KEY_OPERATE_REPORT_SCENE_ID") : null);
                AppMethodBeat.o(135043);
            }

            public final void axa() {
                AppMethodBeat.i(135044);
                ab.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
                ((com.tencent.mm.plugin.appbrand.appusage.c) g.K(com.tencent.mm.plugin.appbrand.appusage.c.class)).a(com.tencent.mm.plugin.appbrand.appusage.z.b.CloseCollectionList);
                FragmentActivity activity = this.iLt.iLs.getActivity();
                if (activity != null) {
                    activity.finish();
                    AppMethodBeat.o(135044);
                    return;
                }
                AppMethodBeat.o(135044);
            }
        }

        d(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(135045);
            com.tencent.mm.plugin.appbrand.appusage.f.a aVar = f.gYW;
            f awZ = f.gYV;
            if (awZ == null) {
                j.dWJ();
            }
            c a = this.iLs.iLq;
            if (a == null) {
                j.dWJ();
            }
            awZ.a((List) a.iLD, (com.tencent.mm.plugin.appbrand.appusage.f.b) new AnonymousClass1(this));
            AppMethodBeat.o(135045);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "from", "", "to", "drop"})
    static final class b implements h {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        b(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        public final void dm(int i, int i2) {
            AppMethodBeat.i(135040);
            c a = this.iLs.iLq;
            if (a != null) {
                LocalUsageInfo pR = a.pR(i);
                if (pR != null) {
                    c a2 = this.iLs.iLq;
                    if (a2 != null) {
                        a2.insert(pR, i2);
                        AppMethodBeat.o(135040);
                        return;
                    }
                    AppMethodBeat.o(135040);
                    return;
                }
            }
            AppMethodBeat.o(135040);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "which", "", "remove"})
    static final class c implements DragSortListView.l {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        c(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        public final void remove(int i) {
            AppMethodBeat.i(135041);
            c a = this.iLs.iLq;
            if (a != null) {
                a.pR(i);
                AppMethodBeat.o(135041);
                return;
            }
            AppMethodBeat.o(135041);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionVerticalSortList iLs;

        e(AppBrandCollectionVerticalSortList appBrandCollectionVerticalSortList) {
            this.iLs = appBrandCollectionVerticalSortList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(135046);
            FragmentActivity activity = this.iLs.getActivity();
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.o(135046);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$Companion;", "", "()V", "KEY_DATA_LIST", "", "KEY_OPERATE_REPORT_SCENE", "KEY_OPERATE_REPORT_SCENE_ID", "TAG", "createSortList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(135049);
        AppMethodBeat.o(135049);
    }

    public final int getLayoutId() {
        return R.layout.bs;
    }

    public final void initView() {
        AppMethodBeat.i(135047);
        this.iLp = (DragSortListView) aMg();
        DragSortListView dragSortListView = this.iLp;
        if (dragSortListView != null) {
            dragSortListView.setDropListener(new b(this));
        }
        dragSortListView = this.iLp;
        if (dragSortListView != null) {
            dragSortListView.setRemoveListener(new c(this));
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            j.dWJ();
        }
        j.o(activity, "activity!!");
        Context context = activity;
        Bundle arguments = getArguments();
        if (arguments == null) {
            j.dWJ();
        }
        ArrayList parcelableArrayList = arguments.getParcelableArrayList("KEY_SORT_DATA_LIST");
        if (parcelableArrayList == null) {
            j.dWJ();
        }
        this.iLq = new c(context, parcelableArrayList);
        c cVar = this.iLq;
        if (cVar == null) {
            j.dWJ();
        }
        dragSortListView = this.iLp;
        if (dragSortListView == null) {
            j.dWJ();
        }
        j.p(dragSortListView, "list");
        cVar.iLp = dragSortListView;
        dragSortListView = cVar.iLp;
        if (dragSortListView == null) {
            j.dWJ();
        }
        dragSortListView.setAdapter((ListAdapter) cVar);
        AppMethodBeat.o(135047);
    }

    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(135048);
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.a(0, getString(R.string.o8), (OnMenuItemClickListener) new d(this), com.tencent.mm.ui.q.b.BLACK);
        }
        activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.setBackBtn(new e(this), R.raw.actionbar_icon_dark_close);
            AppMethodBeat.o(135048);
            return;
        }
        AppMethodBeat.o(135048);
    }
}
