package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.k.u;
import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.regex.Pattern;

@l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010J\u0016\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "IEnterWxaListener", "plugin-appbrand-integration_release"})
public class m extends v implements OnClickListener {
    private final a iLO;
    private final TextView iLP;
    private final TextView iLQ;
    final ImageView iLR;
    final View iLS;
    LocalUsageInfo iLT;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"})
    public interface a {
        void aMV();
    }

    public /* synthetic */ m(View view) {
        this(view, null);
    }

    public m(View view, a aVar) {
        j.p(view, "itemView");
        super(view);
        AppMethodBeat.i(135119);
        this.iLO = aVar;
        view.setOnClickListener(this);
        View findViewById = view.findViewById(R.id.c5);
        j.o(findViewById, "itemView.findViewById(R.id.primary_text)");
        this.iLP = (TextView) findViewById;
        findViewById = view.findViewById(R.id.pr);
        j.o(findViewById, "itemView.findViewById(R.id.tag_text)");
        this.iLQ = (TextView) findViewById;
        findViewById = view.findViewById(R.id.jb);
        j.o(findViewById, "itemView.findViewById(R.id.icon)");
        this.iLR = (ImageView) findViewById;
        findViewById = view.findViewById(R.id.p3);
        j.o(findViewById, "itemView.findViewById(R.id.divider)");
        this.iLS = findViewById;
        AppMethodBeat.o(135119);
    }

    public void onClick(View view) {
        AppMethodBeat.i(135115);
        LocalUsageInfo localUsageInfo = this.iLT;
        if (localUsageInfo != null) {
            com.tencent.luggage.sdk.customize.a aVar = f.ijT;
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
            a aVar2 = this.iLO;
            if (aVar2 != null) {
                aVar2.aMV();
                AppMethodBeat.o(135115);
                return;
            }
            AppMethodBeat.o(135115);
            return;
        }
        AppMethodBeat.o(135115);
    }

    public final void f(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.i(135116);
        j.p(localUsageInfo, "dataItem");
        this.iLT = localUsageInfo;
        String no = b.no(localUsageInfo.har);
        CharSequence charSequence = no;
        int i = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i != 0) {
            this.iLQ.setVisibility(8);
        } else {
            this.iLQ.setVisibility(0);
            this.iLQ.setText(no);
        }
        aNf();
        aNe();
        AppMethodBeat.o(135116);
    }

    /* Access modifiers changed, original: final */
    public final void aNe() {
        AppMethodBeat.i(135117);
        com.tencent.mm.modelappbrand.a.b abR = com.tencent.mm.modelappbrand.a.b.abR();
        ImageView imageView = this.iLR;
        LocalUsageInfo localUsageInfo = this.iLT;
        if (localUsageInfo == null) {
            j.dWJ();
        }
        abR.a(imageView, localUsageInfo.haO, com.tencent.mm.modelappbrand.a.a.abQ(), (com.tencent.mm.modelappbrand.a.b.f) com.tencent.mm.modelappbrand.a.f.fqH);
        AppMethodBeat.o(135117);
    }

    /* Access modifiers changed, original: final */
    public final void aNf() {
        AppMethodBeat.i(135118);
        LocalUsageInfo localUsageInfo = this.iLT;
        if (localUsageInfo == null) {
            j.dWJ();
        }
        String str = localUsageInfo.nickname;
        TextView textView = this.iLP;
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            localUsageInfo = this.iLT;
            if (localUsageInfo == null) {
                j.dWJ();
            }
            String str2 = localUsageInfo.username;
            j.o(str2, "itemInfo!!.username");
            str = Pattern.quote("@app");
            j.o(str, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
            charSequence = u.aI(str2, str, "");
        } else {
            charSequence = str;
        }
        textView.setText(charSequence);
        AppMethodBeat.o(135118);
    }
}
