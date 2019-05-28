package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.os.Bundle;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.p336ui.collection.C33552m.C33553a;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0014\u0010\u001e\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "getDataList", "()Ljava/util/ArrayList;", "mListener", "cloneList", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceList", "list", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.k */
final class C38531k extends C41523a<C33552m> {
    final ArrayList<LocalUsageInfo> iLD;
    private final C33553a iLO;

    public C38531k(ArrayList<LocalUsageInfo> arrayList, C33553a c33553a) {
        C25052j.m39376p(arrayList, "dataList");
        AppMethodBeat.m2504i(135113);
        this.iLD = arrayList;
        this.iLO = c33553a;
        AppMethodBeat.m2505o(135113);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27742a(C41531v c41531v, int i, List list) {
        AppMethodBeat.m2504i(135111);
        C33552m c33552m = (C33552m) c41531v;
        C25052j.m39376p(c33552m, "holder");
        C25052j.m39376p(list, "payloads");
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            if (!(obj instanceof Bundle)) {
                obj = null;
            }
            Bundle bundle = (Bundle) obj;
            if (!(bundle == null || bundle.isEmpty())) {
                Object obj2 = this.iLD.get(i);
                C25052j.m39375o(obj2, "dataList[position]");
                LocalUsageInfo localUsageInfo = (LocalUsageInfo) obj2;
                C25052j.m39376p(localUsageInfo, "newItem");
                C25052j.m39376p(bundle, "diffs");
                c33552m.iLT = localUsageInfo;
                if (bundle.get("icon") != null) {
                    c33552m.aNe();
                }
                if (bundle.get("nick_name") != null) {
                    c33552m.aNf();
                }
                AppMethodBeat.m2505o(135111);
                return;
            }
        }
        m65254a(c33552m, i);
        AppMethodBeat.m2505o(135111);
    }

    public final ArrayList<LocalUsageInfo> aNd() {
        ArrayList<LocalUsageInfo> arrayList;
        AppMethodBeat.m2504i(135105);
        synchronized (this.iLD) {
            try {
                arrayList = new ArrayList(this.iLD.size());
                arrayList.addAll(this.iLD);
            } finally {
                AppMethodBeat.m2505o(135105);
            }
        }
        return arrayList;
    }

    /* renamed from: aO */
    public final void mo61266aO(List<? extends LocalUsageInfo> list) {
        AppMethodBeat.m2504i(135106);
        C25052j.m39376p(list, "list");
        synchronized (this.iLD) {
            try {
                this.iLD.clear();
                this.iLD.addAll(list);
            } finally {
                AppMethodBeat.m2505o(135106);
            }
        }
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(135107);
        int size = this.iLD.size();
        AppMethodBeat.m2505o(135107);
        return size;
    }

    /* renamed from: a */
    private void m65254a(C33552m c33552m, int i) {
        AppMethodBeat.m2504i(135109);
        C25052j.m39376p(c33552m, "holder");
        Object obj = this.iLD.get(i);
        C25052j.m39375o(obj, "dataList[position]");
        c33552m.mo54033f((LocalUsageInfo) obj);
        AppMethodBeat.m2505o(135109);
    }

    public final int getItemViewType(int i) {
        return 1;
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(135112);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.iLD.get(i);
        long hashCode = (long) (localUsageInfo.username + localUsageInfo.har).hashCode();
        AppMethodBeat.m2505o(135112);
        return hashCode;
    }
}
