package com.tencent.p177mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0007J\u0014\u0010$\u001a\u00020\u001b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070%R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "deletePhoneItems", "getDeletePhoneItems", "()Ljava/util/ArrayList;", "getPhoneItems", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "remove", "phoneItem", "updatePhoneItems", "", "ViewHolder", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.h */
public final class C19670h extends C41523a<C19671a> {
    final Context context;
    final ArrayList<PhoneItem> ixw = new ArrayList();
    boolean ixx;
    ArrayList<PhoneItem> ixy;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "deleteIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.h$a */
    public static final class C19671a extends C41531v {
        final TextView ixA;
        final TextView ixB;
        final C19670h ixC;
        final ImageView ixz;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.h$a$a */
        static final class C19672a implements OnClickListener {
            final /* synthetic */ C19671a ixD;
            final /* synthetic */ PhoneItem ixE;

            C19672a(C19671a c19671a, PhoneItem phoneItem) {
                this.ixD = c19671a;
                this.ixE = phoneItem;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(134786);
                C19670h c19670h = this.ixD.ixC;
                PhoneItem phoneItem = this.ixE;
                C25052j.m39376p(phoneItem, "phoneItem");
                c19670h.ixw.add(phoneItem);
                c19670h.ixy.remove(phoneItem);
                c19670h.notifyDataSetChanged();
                AppMethodBeat.m2505o(134786);
            }
        }

        public C19671a(C19670h c19670h, View view) {
            C25052j.m39376p(c19670h, "adapter");
            C25052j.m39376p(view, "view");
            super(view);
            AppMethodBeat.m2504i(134787);
            this.ixC = c19670h;
            View findViewById = view.findViewById(2131821268);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.p…nager_dialog_item_delete)");
            this.ixz = (ImageView) findViewById;
            findViewById = view.findViewById(2131821269);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.p…anager_dialog_item_phone)");
            this.ixA = (TextView) findViewById;
            findViewById = view.findViewById(2131821270);
            C25052j.m39375o(findViewById, "view.findViewById(R.id.p…nager_dialog_item_remark)");
            this.ixB = (TextView) findViewById;
            AppMethodBeat.m2505o(134787);
        }
    }

    public C19670h(Context context, ArrayList<PhoneItem> arrayList) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(arrayList, "phoneItems");
        AppMethodBeat.m2504i(134791);
        this.context = context;
        this.ixy = arrayList;
        AppMethodBeat.m2505o(134791);
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(134789);
        int size = this.ixy.size();
        AppMethodBeat.m2505o(134789);
        return size;
    }
}
