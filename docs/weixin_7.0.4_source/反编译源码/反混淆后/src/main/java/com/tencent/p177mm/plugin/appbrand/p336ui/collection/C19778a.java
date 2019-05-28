package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "(Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.a */
public final class C19778a extends C41523a<C33554n> {
    final ArrayList<LocalUsageInfo> iLD;

    public C19778a(ArrayList<LocalUsageInfo> arrayList) {
        C25052j.m39376p(arrayList, "dataList");
        AppMethodBeat.m2504i(135077);
        this.iLD = arrayList;
        AppMethodBeat.m2505o(135077);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27742a(C41531v c41531v, int i, List list) {
        AppMethodBeat.m2504i(135076);
        C33554n c33554n = (C33554n) c41531v;
        C25052j.m39376p(c33554n, "holder");
        C25052j.m39376p(list, "payloads");
        if (list.isEmpty()) {
            m30610a(c33554n, i);
        }
        AppMethodBeat.m2505o(135076);
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(135072);
        int size = this.iLD.size();
        AppMethodBeat.m2505o(135072);
        return size;
    }

    /* renamed from: a */
    private void m30610a(C33554n c33554n, int i) {
        AppMethodBeat.m2504i(135074);
        C25052j.m39376p(c33554n, "holder");
        Object obj = this.iLD.get(i);
        C25052j.m39375o(obj, "dataList[position]");
        c33554n.mo54035f((LocalUsageInfo) obj);
        AppMethodBeat.m2505o(135074);
    }

    public final int getItemViewType(int i) {
        return 1;
    }
}
