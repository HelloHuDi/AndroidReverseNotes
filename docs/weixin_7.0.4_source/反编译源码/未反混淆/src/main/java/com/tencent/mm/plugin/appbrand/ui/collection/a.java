package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "(Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-appbrand-integration_release"})
public final class a extends android.support.v7.widget.RecyclerView.a<n> {
    final ArrayList<LocalUsageInfo> iLD;

    public a(ArrayList<LocalUsageInfo> arrayList) {
        j.p(arrayList, "dataList");
        AppMethodBeat.i(135077);
        this.iLD = arrayList;
        AppMethodBeat.o(135077);
    }

    public final /* synthetic */ void a(v vVar, int i, List list) {
        AppMethodBeat.i(135076);
        n nVar = (n) vVar;
        j.p(nVar, "holder");
        j.p(list, "payloads");
        if (list.isEmpty()) {
            a(nVar, i);
        }
        AppMethodBeat.o(135076);
    }

    public final int getItemCount() {
        AppMethodBeat.i(135072);
        int size = this.iLD.size();
        AppMethodBeat.o(135072);
        return size;
    }

    private void a(n nVar, int i) {
        AppMethodBeat.i(135074);
        j.p(nVar, "holder");
        Object obj = this.iLD.get(i);
        j.o(obj, "dataList[position]");
        nVar.f((LocalUsageInfo) obj);
        AppMethodBeat.o(135074);
    }

    public final int getItemViewType(int i) {
        return 1;
    }
}
