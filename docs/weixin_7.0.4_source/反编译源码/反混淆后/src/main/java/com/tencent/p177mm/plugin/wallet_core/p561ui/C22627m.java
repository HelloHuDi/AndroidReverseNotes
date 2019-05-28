package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C6515lt;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.m */
public final class C22627m {

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$5 */
    public static class C226285 implements OnClickListener {
        final /* synthetic */ Dialog qHc;
        final /* synthetic */ String tHQ;
        final /* synthetic */ Context val$context;

        public C226285(String str, Context context, Dialog dialog) {
            this.tHQ = str;
            this.val$context = context;
            this.qHc = dialog;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47396);
            Intent intent = new Intent();
            C4990ab.m7417i("MicroMsg.WalletIdCardTip", "go to url %s", this.tHQ);
            intent.putExtra("rawUrl", r1);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("pay_channel", 1);
            C25985d.m41467b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            if (this.qHc != null && this.qHc.isShowing()) {
                this.qHc.dismiss();
            }
            AppMethodBeat.m2505o(47396);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$1 */
    public static class C226311 implements OnClickListener {
        final /* synthetic */ String tHO;
        final /* synthetic */ Context val$context;

        public C226311(String str, Context context) {
            this.tHO = str;
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47392);
            Intent intent = new Intent();
            C4990ab.m7417i("MicroMsg.WalletIdCardTip", "go to url %s", this.tHO);
            intent.putExtra("rawUrl", r1);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("pay_channel", 1);
            C25985d.m41467b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(47392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$4 */
    public static class C226334 implements OnClickListener {
        final /* synthetic */ Dialog qHc;

        public C226334(Dialog dialog) {
            this.qHc = dialog;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47395);
            if (this.qHc != null && this.qHc.isShowing()) {
                this.qHc.dismiss();
            }
            AppMethodBeat.m2505o(47395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$3 */
    public static class C226343 implements OnCancelListener {
        final /* synthetic */ Dialog qHc;

        public C226343(Dialog dialog) {
            this.qHc = dialog;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47394);
            C4990ab.m7416i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
            if (this.qHc != null && this.qHc.isShowing()) {
                this.qHc.dismiss();
            }
            AppMethodBeat.m2505o(47394);
        }
    }

    /* renamed from: a */
    public static Dialog m34314a(final Context context, final ECardInfo eCardInfo, final int i) {
        AppMethodBeat.m2504i(47402);
        View inflate = LayoutInflater.from(context).inflate(2130971111, null);
        ImageView imageView = (ImageView) inflate.findViewById(2131822694);
        int b = C4977b.m7371b(context, 50.0f);
        C5046bo.m7582n(imageView, b, b, b, b);
        TextView textView = (TextView) inflate.findViewById(2131828602);
        final Button button = (Button) inflate.findViewById(2131828813);
        TextView textView2 = (TextView) inflate.findViewById(2131828814);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131820932);
        TextView textView3 = (TextView) inflate.findViewById(2131828817);
        ((TextView) inflate.findViewById(2131828601)).setText(eCardInfo.title);
        if (C5046bo.isNullOrNil(eCardInfo.subtitle)) {
            textView.setVisibility(8);
        } else {
            textView.setText(eCardInfo.subtitle);
            textView.setVisibility(0);
        }
        b = eCardInfo.tys.length();
        int length = (eCardInfo.tys + eCardInfo.tyt).length();
        SpannableString spannableString = new SpannableString(eCardInfo.tys + eCardInfo.tyt);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(C25738R.color.a50)), b, length, 33);
        if (C5046bo.m7519ac(spannableString)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(spannableString);
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47397);
                    Intent intent = new Intent();
                    C4990ab.m7417i("MicroMsg.WalletIdCardTip", "go to url %s", eCardInfo.tyr);
                    intent.putExtra("rawUrl", r1);
                    intent.putExtra("geta8key_username", C1853r.m3846Yz());
                    intent.putExtra("pay_channel", 1);
                    C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    if (i == 0) {
                        C7060h.pYm.mo8381e(16500, Integer.valueOf(4));
                        AppMethodBeat.m2505o(47397);
                        return;
                    }
                    C7060h.pYm.mo8381e(16500, Integer.valueOf(6));
                    AppMethodBeat.m2505o(47397);
                }
            });
        }
        final Dialog dialog = new Dialog(context, C25738R.style.f11415zt);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(47398);
                C4990ab.m7416i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.m2505o(47398);
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(47399);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.m2505o(47399);
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(47400);
                C4990ab.m7417i("MicroMsg.WalletIdCardTip", "go to: %s", Integer.valueOf(eCardInfo.tyo));
                if (eCardInfo.tyo == 1) {
                    C36391e.m60016n(context, eCardInfo.cRf, false);
                } else {
                    C6515lt c6515lt = new C6515lt();
                    c6515lt.cHB.aIq = new WeakReference(context);
                    C4879a.xxA.mo10055m(c6515lt);
                }
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.m2505o(47400);
            }
        });
        if (eCardInfo.tyj == 1) {
            checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.m2504i(47401);
                    if (z) {
                        button.setEnabled(true);
                        button.setClickable(true);
                        AppMethodBeat.m2505o(47401);
                        return;
                    }
                    button.setEnabled(false);
                    button.setClickable(false);
                    AppMethodBeat.m2505o(47401);
                }
            });
            if (eCardInfo.tyk == 1) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
                button.setEnabled(false);
                button.setClickable(false);
            }
        } else {
            checkBox.setVisibility(8);
        }
        int length2 = eCardInfo.tyl.length();
        length = (eCardInfo.tyl + eCardInfo.tym).length();
        SpannableString spannableString2 = new SpannableString(eCardInfo.tyl + eCardInfo.tym);
        spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(C25738R.color.a50)), length2, length, 33);
        textView3.setText(spannableString2);
        textView3.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(47393);
                Intent intent = new Intent();
                C4990ab.m7417i("MicroMsg.WalletIdCardTip", "go to url %s", eCardInfo.tyn);
                intent.putExtra("rawUrl", r1);
                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                intent.putExtra("pay_channel", 1);
                C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(47393);
            }
        });
        dialog.show();
        C30379h.m48455a(context, dialog);
        AppMethodBeat.m2505o(47402);
        return dialog;
    }
}
