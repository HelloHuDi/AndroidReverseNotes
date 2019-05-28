package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public final class k {
    public static c a(Context context, j jVar, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(47375);
        if (((Activity) context).isFinishing() || jVar == null) {
            AppMethodBeat.o(47375);
            return null;
        }
        a aVar = new a(context);
        aVar.rc(false);
        aVar.Qd(R.string.or).b(onClickListener2);
        aVar.Qc(R.string.f8v).a(onClickListener);
        aVar.asD(jVar.title);
        View inflate = View.inflate(context, R.layout.b46, null);
        ((TextView) inflate.findViewById(R.id.cx)).setText(jVar.content);
        if (jVar.tzi != null) {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.nc);
            for (j.a aVar2 : jVar.tzi) {
                View inflate2 = View.inflate(context, R.layout.b45, null);
                TextView textView = (TextView) inflate2.findViewById(R.id.a_6);
                ((TextView) inflate2.findViewById(R.id.cx)).setText(aVar2.tzj.name);
                textView.setText(aVar2.tzj.value);
                linearLayout.addView(inflate2);
            }
        }
        aVar.fn(inflate);
        c aMb = aVar.aMb();
        aMb.show();
        h.a(context, aMb);
        AppMethodBeat.o(47375);
        return aMb;
    }

    public static c a(Context context, b bVar, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(47376);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(47376);
            return null;
        } else if (bVar == null || (TextUtils.isEmpty(bVar.twx) && (bVar.twy == null || bVar.twy.isEmpty()))) {
            ab.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            AppMethodBeat.o(47376);
            return null;
        } else {
            a aVar = new a(context);
            aVar.rc(false);
            aVar.Qd(R.string.or).b(onClickListener2);
            if (z) {
                aVar.Qc(R.string.f8h).a(onClickListener);
            } else {
                aVar.PV(R.string.f8o);
                aVar.Qc(R.string.f8v).a(onClickListener);
            }
            View inflate = View.inflate(context, R.layout.b46, null);
            if (bVar.twy != null && !bVar.twy.isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.nc);
                linearLayout.removeAllViews();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bVar.twy.size() || i2 >= bVar.twy.size()) {
                        break;
                    }
                    View inflate2 = View.inflate(context, R.layout.b45, null);
                    TextView textView = (TextView) inflate2.findViewById(R.id.a_6);
                    ((TextView) inflate2.findViewById(R.id.cx)).setText(((b.b) bVar.twy.get(i2)).key);
                    textView.setText(((b.b) bVar.twy.get(i2)).value);
                    linearLayout.addView(inflate2, i2);
                    i = i2 + 1;
                }
            } else {
                ab.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
            }
            ((TextView) inflate.findViewById(R.id.cx)).setText(bVar.twx);
            if (z) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.kv);
                textView2.setVisibility(0);
                textView2.setText(context.getString(R.string.f8i));
            }
            aVar.fn(inflate);
            c aMb = aVar.aMb();
            aMb.show();
            h.a(context, aMb);
            AppMethodBeat.o(47376);
            return aMb;
        }
    }
}
