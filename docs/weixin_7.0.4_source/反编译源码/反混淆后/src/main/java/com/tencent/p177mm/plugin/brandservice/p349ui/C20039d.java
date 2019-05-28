package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C36082b;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C40676a;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.d */
public final class C20039d extends C46635a {
    private static C36082b jKQ;
    String jKR;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.d$1 */
    class C200401 extends C36082b {
        C200401() {
        }

        /* renamed from: a */
        public final boolean mo22881a(Context context, C46635a c46635a, Object... objArr) {
            return true;
        }

        /* renamed from: c */
        public final View mo22882c(Context context, View view) {
            AppMethodBeat.m2504i(13937);
            if (view == null) {
                view = View.inflate(context, 2130970572, null);
            }
            AppMethodBeat.m2505o(13937);
            return view;
        }

        /* renamed from: a */
        public final void mo22879a(Context context, C40676a c40676a, C46635a c46635a) {
            AppMethodBeat.m2504i(13938);
            if (context == null || c40676a == null || c46635a == null) {
                C4990ab.m7412e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                AppMethodBeat.m2505o(13938);
            } else if (!(c40676a instanceof C20041a)) {
                C4990ab.m7412e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
                AppMethodBeat.m2505o(13938);
            } else if (c46635a instanceof C20039d) {
                C11188a.m18896b(((C20041a) c40676a).jKK, ((C20039d) c46635a).jKR);
                AppMethodBeat.m2505o(13938);
            } else {
                C4990ab.m7412e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
                AppMethodBeat.m2505o(13938);
            }
        }

        /* renamed from: a */
        public final void mo22880a(View view, C40676a c40676a) {
            AppMethodBeat.m2504i(13939);
            if (!(view == null || c40676a == null || !(c40676a instanceof C20041a))) {
                ((C20041a) c40676a).jKK = (TextView) view.findViewById(2131821694);
            }
            AppMethodBeat.m2505o(13939);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.d$a */
    public static class C20041a implements C40676a {
        public TextView jKK;
    }

    public C20039d(Object obj) {
        super(1, obj);
    }

    public final C36082b aVY() {
        AppMethodBeat.m2504i(13940);
        if (jKQ == null) {
            jKQ = new C200401();
        }
        C36082b c36082b = jKQ;
        AppMethodBeat.m2505o(13940);
        return c36082b;
    }

    public final C40676a aVZ() {
        AppMethodBeat.m2504i(13941);
        C20041a c20041a = new C20041a();
        AppMethodBeat.m2505o(13941);
        return c20041a;
    }

    /* renamed from: a */
    public final void mo35282a(Context context, C40676a c40676a, Object... objArr) {
        if (this.data instanceof String) {
            this.jKR = (String) this.data;
        }
    }
}
