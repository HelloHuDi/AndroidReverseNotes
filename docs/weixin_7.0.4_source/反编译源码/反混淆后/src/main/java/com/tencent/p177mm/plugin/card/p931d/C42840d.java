package com.tencent.p177mm.plugin.card.p931d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C18296ik;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.d.d */
public final class C42840d {

    /* renamed from: com.tencent.mm.plugin.card.d.d$b */
    public interface C20133b {
        void aZA();

        void bdj();
    }

    /* renamed from: com.tencent.mm.plugin.card.d.d$5 */
    static class C275715 implements OnClickListener {
        C275715() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88830);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(88830);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.d.d$8 */
    static class C275738 implements OnClickListener {
        C275738() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.d.d$a */
    public static class C27574a implements C20133b {
        public void aZA() {
        }

        public void bdj() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.d.d$2 */
    static class C387342 implements OnClickListener {
        C387342() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88827);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(88827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.d.d$9 */
    static class C387359 implements OnClickListener {
        C387359() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88833);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(88833);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.d.d$3 */
    static class C428423 implements OnClickListener {
        C428423() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88828);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(88828);
        }
    }

    /* renamed from: a */
    public static void m76035a(MMActivity mMActivity, final String str, String str2, final C20133b c20133b) {
        String string;
        AppMethodBeat.m2504i(88835);
        if (TextUtils.isEmpty(str2)) {
            string = mMActivity.getString(C25738R.string.f9089p5);
        } else {
            string = str2;
        }
        C30379h.m48453a((Context) mMActivity, true, string, mMActivity.getString(C25738R.string.f9238tz), mMActivity.getString(C25738R.string.f9187s6), mMActivity.getString(C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(88826);
                dialogInterface.dismiss();
                c20133b.aZA();
                AppMethodBeat.m2505o(88826);
            }
        }, new C428423());
        AppMethodBeat.m2505o(88835);
    }

    /* renamed from: a */
    public static void m76034a(MMActivity mMActivity, final C20133b c20133b) {
        AppMethodBeat.m2504i(88836);
        C30379h.m48453a((Context) mMActivity, true, mMActivity.getString(C25738R.string.ad0), "", mMActivity.getString(C25738R.string.f9187s6), mMActivity.getString(C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(88829);
                dialogInterface.dismiss();
                c20133b.bdj();
                AppMethodBeat.m2505o(88829);
            }
        }, new C275715());
        AppMethodBeat.m2505o(88836);
    }

    /* renamed from: c */
    public static void m76040c(MMActivity mMActivity, String str) {
        AppMethodBeat.m2504i(88837);
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(C25738R.string.aih);
        }
        C42840d.m76036a(mMActivity, str, false);
        AppMethodBeat.m2505o(88837);
    }

    /* renamed from: b */
    public static void m76037b(MMActivity mMActivity, String str, int i) {
        AppMethodBeat.m2504i(88838);
        if (TextUtils.isEmpty(str)) {
            str = "errcode = ".concat(String.valueOf(i));
        }
        C42840d.m76036a(mMActivity, str, false);
        AppMethodBeat.m2505o(88838);
    }

    /* renamed from: a */
    public static void m76036a(final MMActivity mMActivity, String str, final boolean z) {
        AppMethodBeat.m2504i(88839);
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(C25738R.string.aih);
        }
        C30379h.m48448a((Context) mMActivity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(88831);
                dialogInterface.dismiss();
                if (z) {
                    mMActivity.finish();
                }
                AppMethodBeat.m2505o(88831);
            }
        });
        AppMethodBeat.m2505o(88839);
    }

    /* renamed from: c */
    public static void m76039c(final MMActivity mMActivity) {
        AppMethodBeat.m2504i(88840);
        C30379h.m48440a((Context) mMActivity, mMActivity.getString(C25738R.string.agl, new Object[]{mMActivity.getString(C25738R.string.acr)}), mMActivity.getString(C25738R.string.f9238tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(88832);
                mMActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                AppMethodBeat.m2505o(88832);
            }
        }, new C275738());
        AppMethodBeat.m2505o(88840);
    }

    /* renamed from: c */
    public static void m76038c(final Context context, int i, int i2, String str) {
        AppMethodBeat.m2504i(88841);
        if (i == -1) {
            AppMethodBeat.m2505o(88841);
            return;
        }
        C5653c a;
        if (i == 2130968983) {
            a = C42840d.m76032a(context, i, context.getResources().getString(i2), str, context.getResources().getString(C25738R.string.aew), new C387359());
        } else {
            a = C42840d.m76033a(context, i, context.getResources().getString(i2), str, context.getResources().getString(C25738R.string.afb), context.getResources().getString(C25738R.string.aew), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(88834);
                    dialogInterface.dismiss();
                    C18296ik c18296ik = new C18296ik();
                    c18296ik.cDz.context = context;
                    C4879a.xxA.mo10055m(c18296ik);
                    C4990ab.m7416i("MicroMsg.CardDialogHelper", "enter to cardhome");
                    AppMethodBeat.m2505o(88834);
                }
            }, new C387342());
        }
        if (a != null) {
            a.show();
        }
        AppMethodBeat.m2505o(88841);
    }

    /* renamed from: a */
    private static C5653c m76032a(Context context, int i, String str, String str2, String str3, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(88842);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
        TextView textView;
        if (i == 2130968982) {
            textView = (TextView) inflate.findViewById(2131822318);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(C25738R.string.ade);
            }
            textView.setText(context.getResources().getString(C25738R.string.aco, new Object[]{str2}));
        } else if (i == 2130968981) {
            textView = (TextView) inflate.findViewById(2131822318);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(C25738R.string.ade);
            }
            textView.setText(context.getResources().getString(C25738R.string.acn, new Object[]{str2}));
        }
        C5653c a = C30379h.m48441a(context, str, str3, inflate, onClickListener);
        AppMethodBeat.m2505o(88842);
        return a;
    }

    /* renamed from: a */
    private static C5653c m76033a(Context context, int i, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(88843);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
        TextView textView;
        if (i == 2130968982) {
            textView = (TextView) inflate.findViewById(2131822318);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(C25738R.string.ade);
            }
            textView.setText(context.getResources().getString(C25738R.string.aco, new Object[]{str2}));
        } else if (i == 2130968981) {
            textView = (TextView) inflate.findViewById(2131822318);
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(C25738R.string.ade);
            }
            textView.setText(context.getResources().getString(C25738R.string.acn, new Object[]{str2}));
        }
        C5653c a = C30379h.m48437a(context, str, inflate, str3, str4, onClickListener, onClickListener2);
        AppMethodBeat.m2505o(88843);
        return a;
    }
}
