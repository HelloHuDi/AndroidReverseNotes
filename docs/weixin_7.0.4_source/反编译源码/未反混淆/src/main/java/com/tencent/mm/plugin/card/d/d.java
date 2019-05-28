package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class d {

    public interface b {
        void aZA();

        void bdj();
    }

    public static class a implements b {
        public void aZA() {
        }

        public void bdj() {
        }
    }

    public static void a(MMActivity mMActivity, final String str, String str2, final b bVar) {
        String string;
        AppMethodBeat.i(88835);
        if (TextUtils.isEmpty(str2)) {
            string = mMActivity.getString(R.string.p5);
        } else {
            string = str2;
        }
        h.a((Context) mMActivity, true, string, mMActivity.getString(R.string.tz), mMActivity.getString(R.string.s6), mMActivity.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88826);
                dialogInterface.dismiss();
                bVar.aZA();
                AppMethodBeat.o(88826);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88828);
                dialogInterface.dismiss();
                AppMethodBeat.o(88828);
            }
        });
        AppMethodBeat.o(88835);
    }

    public static void a(MMActivity mMActivity, final b bVar) {
        AppMethodBeat.i(88836);
        h.a((Context) mMActivity, true, mMActivity.getString(R.string.ad0), "", mMActivity.getString(R.string.s6), mMActivity.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88829);
                dialogInterface.dismiss();
                bVar.bdj();
                AppMethodBeat.o(88829);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88830);
                dialogInterface.dismiss();
                AppMethodBeat.o(88830);
            }
        });
        AppMethodBeat.o(88836);
    }

    public static void c(MMActivity mMActivity, String str) {
        AppMethodBeat.i(88837);
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(R.string.aih);
        }
        a(mMActivity, str, false);
        AppMethodBeat.o(88837);
    }

    public static void b(MMActivity mMActivity, String str, int i) {
        AppMethodBeat.i(88838);
        if (TextUtils.isEmpty(str)) {
            str = "errcode = ".concat(String.valueOf(i));
        }
        a(mMActivity, str, false);
        AppMethodBeat.o(88838);
    }

    public static void a(final MMActivity mMActivity, String str, final boolean z) {
        AppMethodBeat.i(88839);
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(R.string.aih);
        }
        h.a((Context) mMActivity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88831);
                dialogInterface.dismiss();
                if (z) {
                    mMActivity.finish();
                }
                AppMethodBeat.o(88831);
            }
        });
        AppMethodBeat.o(88839);
    }

    public static void c(final MMActivity mMActivity) {
        AppMethodBeat.i(88840);
        h.a((Context) mMActivity, mMActivity.getString(R.string.agl, new Object[]{mMActivity.getString(R.string.acr)}), mMActivity.getString(R.string.tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88832);
                mMActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                AppMethodBeat.o(88832);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(88840);
    }

    public static void c(final Context context, int i, int i2, String str) {
        AppMethodBeat.i(88841);
        if (i == -1) {
            AppMethodBeat.o(88841);
            return;
        }
        c a;
        if (i == R.layout.ka) {
            a = a(context, i, context.getResources().getString(i2), str, context.getResources().getString(R.string.aew), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(88833);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(88833);
                }
            });
        } else {
            a = a(context, i, context.getResources().getString(i2), str, context.getResources().getString(R.string.afb), context.getResources().getString(R.string.aew), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(88834);
                    dialogInterface.dismiss();
                    ik ikVar = new ik();
                    ikVar.cDz.context = context;
                    com.tencent.mm.sdk.b.a.xxA.m(ikVar);
                    ab.i("MicroMsg.CardDialogHelper", "enter to cardhome");
                    AppMethodBeat.o(88834);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(88827);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(88827);
                }
            });
        }
        if (a != null) {
            a.show();
        }
        AppMethodBeat.o(88841);
    }

    private static c a(Context context, int i, String str, String str2, String str3, OnClickListener onClickListener) {
        AppMethodBeat.i(88842);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
        TextView textView;
        if (i == R.layout.k_) {
            textView = (TextView) inflate.findViewById(R.id.ajx);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ade);
            }
            textView.setText(context.getResources().getString(R.string.aco, new Object[]{str2}));
        } else if (i == R.layout.k9) {
            textView = (TextView) inflate.findViewById(R.id.ajx);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ade);
            }
            textView.setText(context.getResources().getString(R.string.acn, new Object[]{str2}));
        }
        c a = h.a(context, str, str3, inflate, onClickListener);
        AppMethodBeat.o(88842);
        return a;
    }

    private static c a(Context context, int i, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(88843);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
        TextView textView;
        if (i == R.layout.k_) {
            textView = (TextView) inflate.findViewById(R.id.ajx);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ade);
            }
            textView.setText(context.getResources().getString(R.string.aco, new Object[]{str2}));
        } else if (i == R.layout.k9) {
            textView = (TextView) inflate.findViewById(R.id.ajx);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.ade);
            }
            textView.setText(context.getResources().getString(R.string.acn, new Object[]{str2}));
        }
        c a = h.a(context, str, inflate, str3, str4, onClickListener, onClickListener2);
        AppMethodBeat.o(88843);
        return a;
    }
}
