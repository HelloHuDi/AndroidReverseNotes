package com.tencent.mm.plugin.wallet_core.ui.view;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.e;

public final class a {

    public interface a {
        boolean a(boolean z, String str, String str2, String str3, String str4);
    }

    public static c a(final Context context, String str, String str2, String str3, int i, final b bVar, OnClickListener onClickListener) {
        AppMethodBeat.i(47862);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(47862);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.rc(false);
        aVar.rd(true);
        aVar.Qd(R.string.or).b(onClickListener);
        aVar.asD(str);
        View inflate = View.inflate(context, R.layout.b2r, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.l3);
        if (!bo.isNullOrNil(str2)) {
            editText.append(j.b(context, (CharSequence) str2, editText.getTextSize()));
        }
        ((TextView) inflate.findViewById(R.id.bn0)).setVisibility(8);
        if (!bo.isNullOrNil(str3)) {
            editText.setHint(str3);
        }
        aVar.Qc(R.string.s6).a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(47853);
                boolean z = true;
                if (bVar != null) {
                    z = bVar.s(editText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(47852);
                                ((MMActivity) context).aqX();
                                AppMethodBeat.o(47852);
                            }
                        });
                    }
                }
                AppMethodBeat.o(47853);
            }
        });
        if (i > 0) {
            com.tencent.mm.ui.tools.b.c.d(editText).PM(i).a(null);
        }
        aVar.fn(inflate);
        Dialog aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        if (context instanceof MMActivity) {
            inflate.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(47854);
                    ((MMActivity) context).showVKB();
                    AppMethodBeat.o(47854);
                }
            });
        }
        AppMethodBeat.o(47862);
        return aMb;
    }

    public static c a(Context context, String str, String str2, String str3, boolean z, String str4, String str5, String str6, a aVar, e.c cVar) {
        AppMethodBeat.i(47863);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(47863);
            return null;
        }
        final Context context2;
        final com.tencent.mm.ui.widget.a.e.a aVar2 = new com.tencent.mm.ui.widget.a.e.a(context);
        aVar2.re(true);
        aVar2.a(cVar);
        aVar2.al(str);
        View inflate = View.inflate(context, R.layout.b2s, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.l3);
        if (!bo.isNullOrNil(str2)) {
            editText.append(j.b(context, (CharSequence) str2, editText.getTextSize()));
        }
        if (!bo.isNullOrNil(str3)) {
            editText.setHint(str3);
        }
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f5i);
        final LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.cm1);
        final TextView textView = (TextView) inflate.findViewById(R.id.e0g);
        final TextView textView2 = (TextView) inflate.findViewById(R.id.e0h);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f5k);
        ((ImageView) inflate.findViewById(R.id.f5j)).getDrawable().setColorFilter(-15970418, Mode.SRC_ATOP);
        textView3.setText(ah.getContext().getString(R.string.dng));
        final a aVar3 = aVar;
        final Context context3 = context;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47855);
                if (aVar3 != null) {
                    aVar3.a(true, editText.getText().toString().trim(), null, null, null);
                }
                a.a(context3, aVar2.gud);
                AppMethodBeat.o(47855);
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
            final a aVar4 = aVar;
            final String str7 = str4;
            final String str8 = str5;
            final Context context4 = context;
            inflate.findViewById(R.id.f5l).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47856);
                    if (aVar4 != null) {
                        aVar4.a(false, editText.getText().toString().trim(), str7, str8, textView2.getText().toString().trim());
                    }
                    a.a(context4, aVar2.gud);
                    AppMethodBeat.o(47856);
                }
            });
            inflate.findViewById(R.id.f5m).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47857);
                    linearLayout.setVisibility(0);
                    linearLayout2.setVisibility(8);
                    textView.setText("");
                    textView2.setText("");
                    AppMethodBeat.o(47857);
                }
            });
        }
        final Context context5 = context;
        final a aVar5 = aVar;
        final EditText editText2 = editText;
        final String str9 = str4;
        final String str10 = str5;
        final TextView textView4 = textView2;
        aVar2.Qg(R.string.s6).b(new e.c() {
            public final void d(boolean z, String str) {
                AppMethodBeat.i(47859);
                if (context5 instanceof MMActivity) {
                    if (aVar5 != null) {
                        boolean z2;
                        if (bo.isNullOrNil(textView.getText().toString().trim())) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        aVar5.a(z2, editText2.getText().toString().trim(), str9, str10, textView4.getText().toString().trim());
                    }
                    if (context5 instanceof MMActivity) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(47858);
                                ((MMActivity) context5).aqX();
                                AppMethodBeat.o(47858);
                            }
                        });
                    }
                }
                AppMethodBeat.o(47859);
            }
        });
        com.tencent.mm.ui.tools.b.c.d(editText).PM(20).a(null);
        aVar2.fo(inflate);
        aVar2.show();
        if (context instanceof MMActivity) {
            context2 = context;
            aVar2.gud.getContentView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(47860);
                    ((MMActivity) context2).showVKB();
                    AppMethodBeat.o(47860);
                }
            });
        }
        context2 = context;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(47861);
                ((InputMethodManager) context2.getSystemService("input_method")).showSoftInput(editText, 2);
                AppMethodBeat.o(47861);
            }
        });
        AppMethodBeat.o(47863);
        return null;
    }

    private static void a(Context context, Dialog dialog) {
        AppMethodBeat.i(47864);
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
        }
        AppMethodBeat.o(47864);
    }
}
