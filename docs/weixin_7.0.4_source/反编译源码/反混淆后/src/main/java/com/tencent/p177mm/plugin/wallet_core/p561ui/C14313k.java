package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.wallet_core.model.C22590b;
import com.tencent.p177mm.plugin.wallet_core.model.C22590b.C4393b;
import com.tencent.p177mm.plugin.wallet_core.model.C29631j;
import com.tencent.p177mm.plugin.wallet_core.model.C29631j.C29632a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.k */
public final class C14313k {
    /* renamed from: a */
    public static C5653c m22492a(Context context, C29631j c29631j, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(47375);
        if (((Activity) context).isFinishing() || c29631j == null) {
            AppMethodBeat.m2505o(47375);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.mo11482rc(false);
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(onClickListener2);
        c5652a.mo11453Qc(C25738R.string.f8v).mo11457a(onClickListener);
        c5652a.asD(c29631j.title);
        View inflate = View.inflate(context, 2130971095, null);
        ((TextView) inflate.findViewById(2131820678)).setText(c29631j.content);
        if (c29631j.tzi != null) {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131821064);
            for (C29632a c29632a : c29631j.tzi) {
                View inflate2 = View.inflate(context, 2130971094, null);
                TextView textView = (TextView) inflate2.findViewById(2131821920);
                ((TextView) inflate2.findViewById(2131820678)).setText(c29632a.tzj.name);
                textView.setText(c29632a.tzj.value);
                linearLayout.addView(inflate2);
            }
        }
        c5652a.mo11479fn(inflate);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(47375);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m22491a(Context context, C22590b c22590b, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(47376);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47376);
            return null;
        } else if (c22590b == null || (TextUtils.isEmpty(c22590b.twx) && (c22590b.twy == null || c22590b.twy.isEmpty()))) {
            C4990ab.m7420w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            AppMethodBeat.m2505o(47376);
            return null;
        } else {
            C5652a c5652a = new C5652a(context);
            c5652a.mo11482rc(false);
            c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(onClickListener2);
            if (z) {
                c5652a.mo11453Qc(C25738R.string.f8h).mo11457a(onClickListener);
            } else {
                c5652a.mo11446PV(C25738R.string.f8o);
                c5652a.mo11453Qc(C25738R.string.f8v).mo11457a(onClickListener);
            }
            View inflate = View.inflate(context, 2130971095, null);
            if (c22590b.twy != null && !c22590b.twy.isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131821064);
                linearLayout.removeAllViews();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c22590b.twy.size() || i2 >= c22590b.twy.size()) {
                        break;
                    }
                    View inflate2 = View.inflate(context, 2130971094, null);
                    TextView textView = (TextView) inflate2.findViewById(2131821920);
                    ((TextView) inflate2.findViewById(2131820678)).setText(((C4393b) c22590b.twy.get(i2)).key);
                    textView.setText(((C4393b) c22590b.twy.get(i2)).value);
                    linearLayout.addView(inflate2, i2);
                    i = i2 + 1;
                }
            } else {
                C4990ab.m7412e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
            }
            ((TextView) inflate.findViewById(2131820678)).setText(c22590b.twx);
            if (z) {
                TextView textView2 = (TextView) inflate.findViewById(2131820972);
                textView2.setVisibility(0);
                textView2.setText(context.getString(C25738R.string.f8i));
            }
            c5652a.mo11479fn(inflate);
            C5653c aMb = c5652a.aMb();
            aMb.show();
            C30379h.m48455a(context, aMb);
            AppMethodBeat.m2505o(47376);
            return aMb;
        }
    }
}
