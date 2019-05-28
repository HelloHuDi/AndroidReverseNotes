package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bJ\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "getItemInfo$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "setItemInfo$plugin_appbrand_integration_release", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "onClick", "v", "plugin-appbrand-integration_release"})
public final class n extends v implements OnClickListener {
    final TextView iLP;
    private final TextView iLQ;
    final ImageView iLR;
    LocalUsageInfo iLT;

    public n(View view) {
        j.p(view, "itemView");
        super(view);
        AppMethodBeat.i(135122);
        view.setOnClickListener(this);
        View findViewById = view.findViewById(R.id.eg);
        j.o(findViewById, "itemView.findViewById(R.id.name)");
        this.iLP = (TextView) findViewById;
        findViewById = view.findViewById(R.id.pr);
        j.o(findViewById, "itemView.findViewById(R.id.tag_text)");
        this.iLQ = (TextView) findViewById;
        findViewById = view.findViewById(R.id.jb);
        j.o(findViewById, "itemView.findViewById(R.id.icon)");
        this.iLR = (ImageView) findViewById;
        AppMethodBeat.o(135122);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(135120);
        LocalUsageInfo localUsageInfo = this.iLT;
        if (localUsageInfo != null) {
            a aVar = f.ijT;
            if (view == null) {
                j.dWJ();
            }
            Context context = view.getContext();
            String str = localUsageInfo.username;
            String str2 = localUsageInfo.appId;
            int i = localUsageInfo.har;
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1103;
            aVar.a(context, str, str2, null, i, 0, appBrandStatObject, null, null);
            AppMethodBeat.o(135120);
            return;
        }
        AppMethodBeat.o(135120);
    }

    public final void f(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.i(135121);
        j.p(localUsageInfo, "dataItem");
        this.iLT = localUsageInfo;
        this.iLP.setText(localUsageInfo.nickname);
        String no = b.no(localUsageInfo.har);
        CharSequence charSequence = no;
        int i = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i != 0) {
            this.iLQ.setVisibility(8);
        } else {
            this.iLQ.setVisibility(0);
            this.iLQ.setText(no);
        }
        com.tencent.mm.modelappbrand.a.b.abR().a(this.iLR, localUsageInfo.haO, com.tencent.mm.modelappbrand.a.a.abQ(), (com.tencent.mm.modelappbrand.a.b.f) com.tencent.mm.modelappbrand.a.f.fqH);
        AppMethodBeat.o(135121);
    }
}
