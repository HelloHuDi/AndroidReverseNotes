package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.sdk.customize.C45127a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.plugin.appbrand.appcache.C38114b;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bJ\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "getItemInfo$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "setItemInfo$plugin_appbrand_integration_release", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "onClick", "v", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.n */
public final class C33554n extends C41531v implements OnClickListener {
    final TextView iLP;
    private final TextView iLQ;
    final ImageView iLR;
    LocalUsageInfo iLT;

    public C33554n(View view) {
        C25052j.m39376p(view, "itemView");
        super(view);
        AppMethodBeat.m2504i(135122);
        view.setOnClickListener(this);
        View findViewById = view.findViewById(2131820735);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.id.name)");
        this.iLP = (TextView) findViewById;
        findViewById = view.findViewById(2131821153);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.id.tag_text)");
        this.iLQ = (TextView) findViewById;
        findViewById = view.findViewById(2131820915);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.id.icon)");
        this.iLR = (ImageView) findViewById;
        AppMethodBeat.m2505o(135122);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(135120);
        LocalUsageInfo localUsageInfo = this.iLT;
        if (localUsageInfo != null) {
            C45127a c45127a = C10600f.ijT;
            if (view == null) {
                C25052j.dWJ();
            }
            Context context = view.getContext();
            String str = localUsageInfo.username;
            String str2 = localUsageInfo.appId;
            int i = localUsageInfo.har;
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1103;
            c45127a.mo33003a(context, str, str2, null, i, 0, appBrandStatObject, null, null);
            AppMethodBeat.m2505o(135120);
            return;
        }
        AppMethodBeat.m2505o(135120);
    }

    /* renamed from: f */
    public final void mo54035f(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.m2504i(135121);
        C25052j.m39376p(localUsageInfo, "dataItem");
        this.iLT = localUsageInfo;
        this.iLP.setText(localUsageInfo.nickname);
        String no = C38114b.m64485no(localUsageInfo.har);
        CharSequence charSequence = no;
        int i = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i != 0) {
            this.iLQ.setVisibility(8);
        } else {
            this.iLQ.setVisibility(0);
            this.iLQ.setText(no);
        }
        C37926b.abR().mo60683a(this.iLR, localUsageInfo.haO, C32804a.abQ(), (C37932f) C42201f.fqH);
        AppMethodBeat.m2505o(135121);
    }
}
