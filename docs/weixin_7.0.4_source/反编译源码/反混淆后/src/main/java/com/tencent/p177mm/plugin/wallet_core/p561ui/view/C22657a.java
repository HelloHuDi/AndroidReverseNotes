package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.a */
public final class C22657a {

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.a$a */
    public interface C22665a {
        /* renamed from: a */
        boolean mo8358a(boolean z, String str, String str2, String str3, String str4);
    }

    /* renamed from: a */
    public static C5653c m34348a(final Context context, String str, String str2, String str3, int i, final C30387b c30387b, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(47862);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47862);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(true);
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(onClickListener);
        c5652a.asD(str);
        View inflate = View.inflate(context, 2130971043, null);
        final EditText editText = (EditText) inflate.findViewById(2131820980);
        if (!C5046bo.isNullOrNil(str2)) {
            editText.append(C44089j.m79293b(context, (CharSequence) str2, editText.getTextSize()));
        }
        ((TextView) inflate.findViewById(2131823800)).setVisibility(8);
        if (!C5046bo.isNullOrNil(str3)) {
            editText.setHint(str3);
        }
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11462a(false, new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.a$1$1 */
            class C143301 implements Runnable {
                C143301() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(47852);
                    ((MMActivity) context).aqX();
                    AppMethodBeat.m2505o(47852);
                }
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(47853);
                boolean z = true;
                if (c30387b != null) {
                    z = c30387b.mo4760s(editText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        C5004al.m7441d(new C143301());
                    }
                }
                AppMethodBeat.m2505o(47853);
            }
        });
        if (i > 0) {
            C7357c.m12555d(editText).mo15877PM(i).mo15879a(null);
        }
        c5652a.mo11479fn(inflate);
        Dialog aMb = c5652a.aMb();
        aMb.show();
        C22657a.m34350a(context, aMb);
        if (context instanceof MMActivity) {
            inflate.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(47854);
                    ((MMActivity) context).showVKB();
                    AppMethodBeat.m2505o(47854);
                }
            });
        }
        AppMethodBeat.m2505o(47862);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m34349a(Context context, String str, String str2, String str3, boolean z, String str4, String str5, String str6, C22665a c22665a, C5662c c5662c) {
        AppMethodBeat.m2504i(47863);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47863);
            return null;
        }
        final Context context2;
        final C5659a c5659a = new C5659a(context);
        c5659a.mo11526re(true);
        c5659a.mo11512a(c5662c);
        c5659a.mo11514al(str);
        View inflate = View.inflate(context, 2130971044, null);
        final EditText editText = (EditText) inflate.findViewById(2131820980);
        if (!C5046bo.isNullOrNil(str2)) {
            editText.append(C44089j.m79293b(context, (CharSequence) str2, editText.getTextSize()));
        }
        if (!C5046bo.isNullOrNil(str3)) {
            editText.setHint(str3);
        }
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131828591);
        final LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(2131825133);
        final TextView textView = (TextView) inflate.findViewById(2131827035);
        final TextView textView2 = (TextView) inflate.findViewById(2131827036);
        TextView textView3 = (TextView) inflate.findViewById(2131828593);
        ((ImageView) inflate.findViewById(2131828592)).getDrawable().setColorFilter(-15970418, Mode.SRC_ATOP);
        textView3.setText(C4996ah.getContext().getString(C25738R.string.dng));
        final C22665a c22665a2 = c22665a;
        final Context context3 = context;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(47855);
                if (c22665a2 != null) {
                    c22665a2.mo8358a(true, editText.getText().toString().trim(), null, null, null);
                }
                C22657a.m34351a(context3, c5659a.gud);
                AppMethodBeat.m2505o(47855);
            }
        });
        if (z) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
        } else {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            textView.setText(str4 + "  " + str5);
            textView2.setText(str6);
            final C22665a c22665a3 = c22665a;
            final String str7 = str4;
            final String str8 = str5;
            final Context context4 = context;
            inflate.findViewById(2131828594).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47856);
                    if (c22665a3 != null) {
                        c22665a3.mo8358a(false, editText.getText().toString().trim(), str7, str8, textView2.getText().toString().trim());
                    }
                    C22657a.m34351a(context4, c5659a.gud);
                    AppMethodBeat.m2505o(47856);
                }
            });
            inflate.findViewById(2131828595).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47857);
                    linearLayout.setVisibility(0);
                    linearLayout2.setVisibility(8);
                    textView.setText("");
                    textView2.setText("");
                    AppMethodBeat.m2505o(47857);
                }
            });
        }
        final Context context5 = context;
        final C22665a c22665a4 = c22665a;
        final EditText editText2 = editText;
        final String str9 = str4;
        final String str10 = str5;
        final TextView textView4 = textView2;
        c5659a.mo11509Qg(C25738R.string.f9187s6).mo11522b(new C5662c() {

            /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.a$6$1 */
            class C143311 implements Runnable {
                C143311() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(47858);
                    ((MMActivity) context5).aqX();
                    AppMethodBeat.m2505o(47858);
                }
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(47859);
                if (context5 instanceof MMActivity) {
                    if (c22665a4 != null) {
                        boolean z2;
                        if (C5046bo.isNullOrNil(textView.getText().toString().trim())) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        c22665a4.mo8358a(z2, editText2.getText().toString().trim(), str9, str10, textView4.getText().toString().trim());
                    }
                    if (context5 instanceof MMActivity) {
                        C5004al.m7441d(new C143311());
                    }
                }
                AppMethodBeat.m2505o(47859);
            }
        });
        C7357c.m12555d(editText).mo15877PM(20).mo15879a(null);
        c5659a.mo11524fo(inflate);
        c5659a.show();
        if (context instanceof MMActivity) {
            context2 = context;
            c5659a.gud.getContentView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(47860);
                    ((MMActivity) context2).showVKB();
                    AppMethodBeat.m2505o(47860);
                }
            });
        }
        context2 = context;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(47861);
                ((InputMethodManager) context2.getSystemService("input_method")).showSoftInput(editText, 2);
                AppMethodBeat.m2505o(47861);
            }
        });
        AppMethodBeat.m2505o(47863);
        return null;
    }

    /* renamed from: a */
    private static void m34350a(Context context, Dialog dialog) {
        AppMethodBeat.m2504i(47864);
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
        }
        AppMethodBeat.m2505o(47864);
    }
}
