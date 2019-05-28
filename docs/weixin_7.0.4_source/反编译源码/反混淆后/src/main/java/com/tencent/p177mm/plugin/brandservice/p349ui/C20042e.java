package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C36082b;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C40676a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.e */
public final class C20042e extends C46635a {
    private static C36082b jKQ;
    /* renamed from: Lp */
    int f4370Lp;
    long jKV;
    String jKW;
    String jMq;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.e$1 */
    class C200431 extends C36082b {
        C200431() {
        }

        /* renamed from: a */
        public final boolean mo22881a(Context context, C46635a c46635a, Object... objArr) {
            AppMethodBeat.m2504i(14015);
            if (!(context == null || c46635a == null)) {
                int i = 0;
                if (objArr != null && objArr.length >= 2 && (objArr[1] instanceof Integer)) {
                    i = ((Integer) objArr[1]).intValue();
                }
                C20042e c20042e = (C20042e) c46635a;
                Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                intent.putExtra("keyword", c20042e.jKW);
                intent.putExtra("businessType", c20042e.jKV);
                intent.putExtra("offset", c20042e.f4370Lp);
                intent.putExtra("showEditText", true);
                intent.putExtra("fromScene", i);
                context.startActivity(intent);
            }
            AppMethodBeat.m2505o(14015);
            return true;
        }

        /* renamed from: c */
        public final View mo22882c(Context context, View view) {
            AppMethodBeat.m2504i(14016);
            if (view == null) {
                view = View.inflate(context, 2130970573, null);
            }
            AppMethodBeat.m2505o(14016);
            return view;
        }

        /* renamed from: a */
        public final void mo22879a(Context context, C40676a c40676a, C46635a c46635a) {
            AppMethodBeat.m2504i(14017);
            if (context == null || c40676a == null || c46635a == null) {
                C4990ab.m7412e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                AppMethodBeat.m2505o(14017);
            } else if (!(c40676a instanceof C20044a)) {
                C4990ab.m7412e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                AppMethodBeat.m2505o(14017);
            } else if (c46635a instanceof C20042e) {
                ((C20044a) c40676a).iqU.setText(((C20042e) c46635a).jMq);
                AppMethodBeat.m2505o(14017);
            } else {
                C4990ab.m7412e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                AppMethodBeat.m2505o(14017);
            }
        }

        /* renamed from: a */
        public final void mo22880a(View view, C40676a c40676a) {
            AppMethodBeat.m2504i(14018);
            if (!(view == null || c40676a == null || !(c40676a instanceof C20044a))) {
                ((C20044a) c40676a).iqU = (TextView) view.findViewById(2131823632);
            }
            AppMethodBeat.m2505o(14018);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.e$a */
    public static class C20044a implements C40676a {
        public TextView iqU;
    }

    public C20042e(long j, int i, String str) {
        super(2, null);
        this.jKV = j;
        this.jKW = str;
        this.f4370Lp = i;
    }

    public final C36082b aVY() {
        AppMethodBeat.m2504i(14019);
        if (jKQ == null) {
            jKQ = new C200431();
        }
        C36082b c36082b = jKQ;
        AppMethodBeat.m2505o(14019);
        return c36082b;
    }

    public final C40676a aVZ() {
        AppMethodBeat.m2504i(14020);
        C20044a c20044a = new C20044a();
        AppMethodBeat.m2505o(14020);
        return c20044a;
    }

    /* renamed from: a */
    public final void mo35282a(Context context, C40676a c40676a, Object... objArr) {
        this.jMq = "";
    }
}
