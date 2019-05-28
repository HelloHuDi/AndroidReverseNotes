package com.tencent.p177mm.plugin.sns.lucky.p1299ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.lucky.ui.a */
public final class C29040a {
    /* renamed from: f */
    public static Dialog m46131f(Context context, final View view) {
        AppMethodBeat.m2504i(35903);
        View inflate = LayoutInflater.from(context).inflate(2130969965, null);
        String str = C4988aa.doo() ? "font_1.otf" : C4988aa.dop() ? "font_2.otf" : null;
        TextView textView = (TextView) inflate.findViewById(2131825377);
        if (!C5046bo.isNullOrNil(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!C4988aa.don()) {
            textView.setTextSize(1, 10.0f);
        }
        final Dialog dialog = new Dialog(context, C25738R.style.f11415zt);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(35900);
                C4990ab.m7416i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.m2505o(35900);
            }
        });
        ((TextView) inflate.findViewById(2131825379)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(35901);
                C4990ab.m7416i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
                AppMethodBeat.m2505o(35901);
            }
        });
        View findViewById = inflate.findViewById(2131825375);
        int b = C4977b.m7371b(context, 10.0f);
        C5046bo.m7582n(findViewById, b, b, b, b);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(35902);
                C4990ab.m7416i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.m2505o(35902);
            }
        });
        dialog.show();
        AppMethodBeat.m2505o(35903);
        return dialog;
    }
}
