package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static Dialog f(Context context, final View view) {
        AppMethodBeat.i(35903);
        View inflate = LayoutInflater.from(context).inflate(R.layout.a_q, null);
        String str = aa.doo() ? "font_1.otf" : aa.dop() ? "font_2.otf" : null;
        TextView textView = (TextView) inflate.findViewById(R.id.csn);
        if (!bo.isNullOrNil(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!aa.don()) {
            textView.setTextSize(1, 10.0f);
        }
        final Dialog dialog = new Dialog(context, R.style.zt);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(35900);
                ab.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.o(35900);
            }
        });
        ((TextView) inflate.findViewById(R.id.csp)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(35901);
                ab.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
                AppMethodBeat.o(35901);
            }
        });
        View findViewById = inflate.findViewById(R.id.csl);
        int b = b.b(context, 10.0f);
        bo.n(findViewById, b, b, b, b);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(35902);
                ab.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.o(35902);
            }
        });
        dialog.show();
        AppMethodBeat.o(35903);
        return dialog;
    }
}
