package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;

public final class m {

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$5 */
    public static class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ Dialog qHc;
        final /* synthetic */ String tHQ;
        final /* synthetic */ Context val$context;

        public AnonymousClass5(String str, Context context, Dialog dialog) {
            this.tHQ = str;
            this.val$context = context;
            this.qHc = dialog;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(47396);
            Intent intent = new Intent();
            ab.i("MicroMsg.WalletIdCardTip", "go to url %s", this.tHQ);
            intent.putExtra("rawUrl", r1);
            intent.putExtra("geta8key_username", r.Yz());
            intent.putExtra("pay_channel", 1);
            d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            if (this.qHc != null && this.qHc.isShowing()) {
                this.qHc.dismiss();
            }
            AppMethodBeat.o(47396);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$1 */
    public static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ String tHO;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(String str, Context context) {
            this.tHO = str;
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(47392);
            Intent intent = new Intent();
            ab.i("MicroMsg.WalletIdCardTip", "go to url %s", this.tHO);
            intent.putExtra("rawUrl", r1);
            intent.putExtra("geta8key_username", r.Yz());
            intent.putExtra("pay_channel", 1);
            d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.o(47392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$4 */
    public static class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ Dialog qHc;

        public AnonymousClass4(Dialog dialog) {
            this.qHc = dialog;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(47395);
            if (this.qHc != null && this.qHc.isShowing()) {
                this.qHc.dismiss();
            }
            AppMethodBeat.o(47395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.m$3 */
    public static class AnonymousClass3 implements OnCancelListener {
        final /* synthetic */ Dialog qHc;

        public AnonymousClass3(Dialog dialog) {
            this.qHc = dialog;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(47394);
            ab.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
            if (this.qHc != null && this.qHc.isShowing()) {
                this.qHc.dismiss();
            }
            AppMethodBeat.o(47394);
        }
    }

    public static Dialog a(final Context context, final ECardInfo eCardInfo, final int i) {
        AppMethodBeat.i(47402);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b4l, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.au3);
        int b = b.b(context, 50.0f);
        bo.n(imageView, b, b, b, b);
        TextView textView = (TextView) inflate.findViewById(R.id.f5t);
        final Button button = (Button) inflate.findViewById(R.id.fai);
        TextView textView2 = (TextView) inflate.findViewById(R.id.faj);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.js);
        TextView textView3 = (TextView) inflate.findViewById(R.id.fam);
        ((TextView) inflate.findViewById(R.id.f5s)).setText(eCardInfo.title);
        if (bo.isNullOrNil(eCardInfo.subtitle)) {
            textView.setVisibility(8);
        } else {
            textView.setText(eCardInfo.subtitle);
            textView.setVisibility(0);
        }
        b = eCardInfo.tys.length();
        int length = (eCardInfo.tys + eCardInfo.tyt).length();
        SpannableString spannableString = new SpannableString(eCardInfo.tys + eCardInfo.tyt);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.a50)), b, length, 33);
        if (bo.ac(spannableString)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(spannableString);
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47397);
                    Intent intent = new Intent();
                    ab.i("MicroMsg.WalletIdCardTip", "go to url %s", eCardInfo.tyr);
                    intent.putExtra("rawUrl", r1);
                    intent.putExtra("geta8key_username", r.Yz());
                    intent.putExtra("pay_channel", 1);
                    d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    if (i == 0) {
                        h.pYm.e(16500, Integer.valueOf(4));
                        AppMethodBeat.o(47397);
                        return;
                    }
                    h.pYm.e(16500, Integer.valueOf(6));
                    AppMethodBeat.o(47397);
                }
            });
        }
        final Dialog dialog = new Dialog(context, R.style.zt);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(47398);
                ab.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.o(47398);
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47399);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.o(47399);
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47400);
                ab.i("MicroMsg.WalletIdCardTip", "go to: %s", Integer.valueOf(eCardInfo.tyo));
                if (eCardInfo.tyo == 1) {
                    e.n(context, eCardInfo.cRf, false);
                } else {
                    lt ltVar = new lt();
                    ltVar.cHB.aIq = new WeakReference(context);
                    a.xxA.m(ltVar);
                }
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                AppMethodBeat.o(47400);
            }
        });
        if (eCardInfo.tyj == 1) {
            checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(47401);
                    if (z) {
                        button.setEnabled(true);
                        button.setClickable(true);
                        AppMethodBeat.o(47401);
                        return;
                    }
                    button.setEnabled(false);
                    button.setClickable(false);
                    AppMethodBeat.o(47401);
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
        spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.a50)), length2, length, 33);
        textView3.setText(spannableString2);
        textView3.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47393);
                Intent intent = new Intent();
                ab.i("MicroMsg.WalletIdCardTip", "go to url %s", eCardInfo.tyn);
                intent.putExtra("rawUrl", r1);
                intent.putExtra("geta8key_username", r.Yz());
                intent.putExtra("pay_channel", 1);
                d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                AppMethodBeat.o(47393);
            }
        });
        dialog.show();
        com.tencent.mm.ui.base.h.a(context, dialog);
        AppMethodBeat.o(47402);
        return dialog;
    }
}
