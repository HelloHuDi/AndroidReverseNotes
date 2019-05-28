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
import java.util.regex.Pattern;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010J\u0016\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "IEnterWxaListener", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.m */
public class C33552m extends C41531v implements OnClickListener {
    private final C33553a iLO;
    private final TextView iLP;
    private final TextView iLQ;
    final ImageView iLR;
    final View iLS;
    LocalUsageInfo iLT;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.m$a */
    public interface C33553a {
        void aMV();
    }

    public /* synthetic */ C33552m(View view) {
        this(view, null);
    }

    public C33552m(View view, C33553a c33553a) {
        C25052j.m39376p(view, "itemView");
        super(view);
        AppMethodBeat.m2504i(135119);
        this.iLO = c33553a;
        view.setOnClickListener(this);
        View findViewById = view.findViewById(2131820649);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.id.primary_text)");
        this.iLP = (TextView) findViewById;
        findViewById = view.findViewById(2131821153);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.id.tag_text)");
        this.iLQ = (TextView) findViewById;
        findViewById = view.findViewById(2131820915);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.id.icon)");
        this.iLR = (ImageView) findViewById;
        findViewById = view.findViewById(2131821128);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.id.divider)");
        this.iLS = findViewById;
        AppMethodBeat.m2505o(135119);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(135115);
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
            C33553a c33553a = this.iLO;
            if (c33553a != null) {
                c33553a.aMV();
                AppMethodBeat.m2505o(135115);
                return;
            }
            AppMethodBeat.m2505o(135115);
            return;
        }
        AppMethodBeat.m2505o(135115);
    }

    /* renamed from: f */
    public final void mo54033f(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.m2504i(135116);
        C25052j.m39376p(localUsageInfo, "dataItem");
        this.iLT = localUsageInfo;
        String no = C38114b.m64485no(localUsageInfo.har);
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
        AppMethodBeat.m2505o(135116);
    }

    /* Access modifiers changed, original: final */
    public final void aNe() {
        AppMethodBeat.m2504i(135117);
        C37926b abR = C37926b.abR();
        ImageView imageView = this.iLR;
        LocalUsageInfo localUsageInfo = this.iLT;
        if (localUsageInfo == null) {
            C25052j.dWJ();
        }
        abR.mo60683a(imageView, localUsageInfo.haO, C32804a.abQ(), (C37932f) C42201f.fqH);
        AppMethodBeat.m2505o(135117);
    }

    /* Access modifiers changed, original: final */
    public final void aNf() {
        AppMethodBeat.m2504i(135118);
        LocalUsageInfo localUsageInfo = this.iLT;
        if (localUsageInfo == null) {
            C25052j.dWJ();
        }
        String str = localUsageInfo.nickname;
        TextView textView = this.iLP;
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            localUsageInfo = this.iLT;
            if (localUsageInfo == null) {
                C25052j.dWJ();
            }
            String str2 = localUsageInfo.username;
            C25052j.m39375o(str2, "itemInfo!!.username");
            str = Pattern.quote("@app");
            C25052j.m39375o(str, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
            charSequence = C6163u.m9836aI(str2, str, "");
        } else {
            charSequence = str;
        }
        textView.setText(charSequence);
        AppMethodBeat.m2505o(135118);
    }
}
