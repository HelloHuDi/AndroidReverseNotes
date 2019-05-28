package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u0013R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "attachListView", "", "list", "getItemId", "", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "item", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "remove", "index", "plugin-appbrand-integration_release"})
public final class c extends ArrayAdapter<LocalUsageInfo> {
    final ArrayList<LocalUsageInfo> iLD;
    DragSortListView iLp;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements OnClickListener {
        final /* synthetic */ int exi;
        final /* synthetic */ c iLH;

        a(c cVar, int i) {
            this.iLH = cVar;
            this.exi = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(135088);
            DragSortListView a = this.iLH.iLp;
            if (a != null) {
                a.removeItem(this.exi);
                AppMethodBeat.o(135088);
                return;
            }
            AppMethodBeat.o(135088);
        }
    }

    public c(Context context, ArrayList<LocalUsageInfo> arrayList) {
        j.p(context, "context");
        j.p(arrayList, "dataList");
        super(context, d.iLI, arrayList);
        AppMethodBeat.i(135092);
        this.iLD = arrayList;
        AppMethodBeat.o(135092);
    }

    public final LocalUsageInfo pR(int i) {
        AppMethodBeat.i(135089);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) getItem(i);
        super.remove(localUsageInfo);
        AppMethodBeat.o(135089);
        return localUsageInfo;
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(135090);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) getItem(i);
        long hashCode = (long) (localUsageInfo.username + localUsageInfo.har).hashCode();
        AppMethodBeat.o(135090);
        return hashCode;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        j jVar;
        Object tag;
        int i2;
        AppMethodBeat.i(135091);
        if (view == null || view.getTag() == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            j.o(from, "LayoutInflater.from(context)");
            View inflate2 = from.inflate(d.iLI, viewGroup, false);
            inflate = ((ViewStub) inflate2.findViewById(R.id.pu)).inflate();
            if (inflate != null) {
                inflate.setBackground(null);
            }
            j.o(inflate2, "view");
            jVar = new j(inflate2);
        } else {
            tag = view.getTag();
            if (tag == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
                AppMethodBeat.o(135091);
                throw vVar;
            }
            jVar = (j) tag;
        }
        tag = getItem(i);
        j.o(tag, "getItem(position)");
        jVar.f((LocalUsageInfo) tag);
        inflate = jVar.apJ;
        j.o(inflate, "holder.itemView");
        inflate.setClickable(false);
        if (i == getCount() - 1) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        jVar.iLS.setVisibility(i2);
        View view2 = jVar.iLN;
        j.o(view2, "rightExtraBottomLine");
        view2.setVisibility(i2);
        jVar.iLM.setOnClickListener(new a(this, i));
        inflate = jVar.apJ;
        j.o(inflate, "holder.itemView");
        AppMethodBeat.o(135091);
        return inflate;
    }
}
