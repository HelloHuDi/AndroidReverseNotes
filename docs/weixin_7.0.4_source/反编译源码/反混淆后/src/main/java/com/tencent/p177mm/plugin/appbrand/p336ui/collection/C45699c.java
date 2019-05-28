package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u0013R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "attachListView", "", "list", "getItemId", "", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "item", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "remove", "index", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.c */
public final class C45699c extends ArrayAdapter<LocalUsageInfo> {
    final ArrayList<LocalUsageInfo> iLD;
    DragSortListView iLp;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.c$a */
    static final class C38529a implements OnClickListener {
        final /* synthetic */ int exi;
        final /* synthetic */ C45699c iLH;

        C38529a(C45699c c45699c, int i) {
            this.iLH = c45699c;
            this.exi = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(135088);
            DragSortListView a = this.iLH.iLp;
            if (a != null) {
                a.removeItem(this.exi);
                AppMethodBeat.m2505o(135088);
                return;
            }
            AppMethodBeat.m2505o(135088);
        }
    }

    public C45699c(Context context, ArrayList<LocalUsageInfo> arrayList) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(arrayList, "dataList");
        super(context, C38530d.iLI, arrayList);
        AppMethodBeat.m2504i(135092);
        this.iLD = arrayList;
        AppMethodBeat.m2505o(135092);
    }

    /* renamed from: pR */
    public final LocalUsageInfo mo73494pR(int i) {
        AppMethodBeat.m2504i(135089);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) getItem(i);
        super.remove(localUsageInfo);
        AppMethodBeat.m2505o(135089);
        return localUsageInfo;
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(135090);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) getItem(i);
        long hashCode = (long) (localUsageInfo.username + localUsageInfo.har).hashCode();
        AppMethodBeat.m2505o(135090);
        return hashCode;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C27328j c27328j;
        Object tag;
        int i2;
        AppMethodBeat.m2504i(135091);
        if (view == null || view.getTag() == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            C25052j.m39375o(from, "LayoutInflater.from(context)");
            View inflate2 = from.inflate(C38530d.iLI, viewGroup, false);
            inflate = ((ViewStub) inflate2.findViewById(2131821156)).inflate();
            if (inflate != null) {
                inflate.setBackground(null);
            }
            C25052j.m39375o(inflate2, "view");
            c27328j = new C27328j(inflate2);
        } else {
            tag = view.getTag();
            if (tag == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
                AppMethodBeat.m2505o(135091);
                throw c44941v;
            }
            c27328j = (C27328j) tag;
        }
        tag = getItem(i);
        C25052j.m39375o(tag, "getItem(position)");
        c27328j.mo54033f((LocalUsageInfo) tag);
        inflate = c27328j.apJ;
        C25052j.m39375o(inflate, "holder.itemView");
        inflate.setClickable(false);
        if (i == getCount() - 1) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        c27328j.iLS.setVisibility(i2);
        View view2 = c27328j.iLN;
        C25052j.m39375o(view2, "rightExtraBottomLine");
        view2.setVisibility(i2);
        c27328j.iLM.setOnClickListener(new C38529a(this, i));
        inflate = c27328j.apJ;
        C25052j.m39375o(inflate, "holder.itemView");
        AppMethodBeat.m2505o(135091);
        return inflate;
    }
}
