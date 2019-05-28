package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0014\u0010\u001e\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "getDataList", "()Ljava/util/ArrayList;", "mListener", "cloneList", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceList", "list", "", "plugin-appbrand-integration_release"})
final class k extends a<m> {
    final ArrayList<LocalUsageInfo> iLD;
    private final m.a iLO;

    public k(ArrayList<LocalUsageInfo> arrayList, m.a aVar) {
        j.p(arrayList, "dataList");
        AppMethodBeat.i(135113);
        this.iLD = arrayList;
        this.iLO = aVar;
        AppMethodBeat.o(135113);
    }

    public final /* synthetic */ void a(v vVar, int i, List list) {
        AppMethodBeat.i(135111);
        m mVar = (m) vVar;
        j.p(mVar, "holder");
        j.p(list, "payloads");
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            if (!(obj instanceof Bundle)) {
                obj = null;
            }
            Bundle bundle = (Bundle) obj;
            if (!(bundle == null || bundle.isEmpty())) {
                Object obj2 = this.iLD.get(i);
                j.o(obj2, "dataList[position]");
                LocalUsageInfo localUsageInfo = (LocalUsageInfo) obj2;
                j.p(localUsageInfo, "newItem");
                j.p(bundle, "diffs");
                mVar.iLT = localUsageInfo;
                if (bundle.get("icon") != null) {
                    mVar.aNe();
                }
                if (bundle.get("nick_name") != null) {
                    mVar.aNf();
                }
                AppMethodBeat.o(135111);
                return;
            }
        }
        a(mVar, i);
        AppMethodBeat.o(135111);
    }

    public final ArrayList<LocalUsageInfo> aNd() {
        ArrayList<LocalUsageInfo> arrayList;
        AppMethodBeat.i(135105);
        synchronized (this.iLD) {
            try {
                arrayList = new ArrayList(this.iLD.size());
                arrayList.addAll(this.iLD);
            } finally {
                AppMethodBeat.o(135105);
            }
        }
        return arrayList;
    }

    public final void aO(List<? extends LocalUsageInfo> list) {
        AppMethodBeat.i(135106);
        j.p(list, "list");
        synchronized (this.iLD) {
            try {
                this.iLD.clear();
                this.iLD.addAll(list);
            } finally {
                AppMethodBeat.o(135106);
            }
        }
    }

    public final int getItemCount() {
        AppMethodBeat.i(135107);
        int size = this.iLD.size();
        AppMethodBeat.o(135107);
        return size;
    }

    private void a(m mVar, int i) {
        AppMethodBeat.i(135109);
        j.p(mVar, "holder");
        Object obj = this.iLD.get(i);
        j.o(obj, "dataList[position]");
        mVar.f((LocalUsageInfo) obj);
        AppMethodBeat.o(135109);
    }

    public final int getItemViewType(int i) {
        return 1;
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(135112);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.iLD.get(i);
        long hashCode = (long) (localUsageInfo.username + localUsageInfo.har).hashCode();
        AppMethodBeat.o(135112);
        return hashCode;
    }
}
