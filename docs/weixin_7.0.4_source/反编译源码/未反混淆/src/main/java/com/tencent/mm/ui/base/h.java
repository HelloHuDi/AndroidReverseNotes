package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class h {

    public interface a {
        void BB(int i);
    }

    public interface d {
        void bV(int i, int i2);
    }

    public interface b {
        boolean s(CharSequence charSequence);
    }

    public interface c {
        void iE(int i);
    }

    public static void a(Context context, Dialog dialog) {
        AppMethodBeat.i(106421);
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
        }
        AppMethodBeat.o(106421);
    }

    public static Toast bO(Context context, String str) {
        AppMethodBeat.i(106423);
        Toast bQ = bQ(context, str);
        AppMethodBeat.o(106423);
        return bQ;
    }

    public static void bP(Context context, String str) {
        AppMethodBeat.i(106424);
        Toast.makeText(context, str, 0).show();
        AppMethodBeat.o(106424);
    }

    public static Toast bQ(Context context, String str) {
        AppMethodBeat.i(106425);
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.show();
        AppMethodBeat.o(106425);
        return makeText;
    }

    public static com.tencent.mm.ui.widget.a.c J(Context context, String str, String str2) {
        AppMethodBeat.i(139072);
        com.tencent.mm.ui.widget.a.c b = b(context, str, str2, true);
        AppMethodBeat.o(139072);
        return b;
    }

    public static com.tencent.mm.ui.widget.a.c b(Context context, String str, String str2, boolean z) {
        AppMethodBeat.i(106427);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106427);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.rc(z);
        aVar.Qc(R.string.s6).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(106403);
                dialogInterface.cancel();
                AppMethodBeat.o(106403);
            }
        });
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106427);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c g(Context context, int i, int i2) {
        String string;
        AppMethodBeat.i(106428);
        String string2 = i > 0 ? context.getString(i) : "";
        if (i2 > 0) {
            string = context.getString(i2);
        } else {
            string = "";
        }
        com.tencent.mm.ui.widget.a.c b = b(context, string2, string, true);
        AppMethodBeat.o(106428);
        return b;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, OnClickListener onClickListener) {
        AppMethodBeat.i(106429);
        com.tencent.mm.ui.widget.a.c a = a(context, i, i2, true, onClickListener);
        AppMethodBeat.o(106429);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.i(106430);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106430);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        if (i2 > 0) {
            aVar.PV(i2);
        }
        aVar.PZ(i);
        aVar.Qc(R.string.s6).a(onClickListener);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106430);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, OnClickListener onClickListener) {
        AppMethodBeat.i(106431);
        com.tencent.mm.ui.widget.a.c a = a(context, str, str2, true, onClickListener);
        AppMethodBeat.o(106431);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.i(106432);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106432);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.Qc(R.string.s6).a(onClickListener);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106432);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        AppMethodBeat.i(106433);
        com.tencent.mm.ui.widget.a.c a = a(context, str, str2, str3, true, onClickListener);
        AppMethodBeat.o(106433);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.i(106434);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106434);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.asJ(str3).a(onClickListener);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106434);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106435);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106435);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.Qc(R.string.s6).a(onClickListener);
        aVar.Qd(R.string.or).b(onClickListener2);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106435);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106436);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106436);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.Qc(R.string.s6).a(onClickListener);
        aVar.Qd(R.string.or).b(onClickListener2);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106436);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106437);
        com.tencent.mm.ui.widget.a.c a = a(context, str, str2, str3, str4, z, onClickListener, onClickListener2, -1);
        AppMethodBeat.o(106437);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        AppMethodBeat.i(106438);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106438);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.asJ(str3).a(onClickListener);
        aVar.asK(str4).b(onClickListener2);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        if (i > 0) {
            aMb.PT(context.getResources().getColor(i));
        }
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106438);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106439);
        com.tencent.mm.ui.widget.a.c a = a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", onClickListener, onClickListener2);
        AppMethodBeat.o(106439);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c b(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106440);
        com.tencent.mm.ui.widget.a.c a = a(context, i > 0 ? context.getString(i) : "", context.getString(R.string.tz), false, onClickListener, onClickListener2);
        AppMethodBeat.o(106440);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106441);
        com.tencent.mm.ui.widget.a.c a = a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2);
        AppMethodBeat.o(106441);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i5) {
        AppMethodBeat.i(106442);
        com.tencent.mm.ui.widget.a.c a = a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2, i5);
        AppMethodBeat.o(106442);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        AppMethodBeat.i(106443);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106443);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        if (i2 != 0) {
            aVar.PV(i2);
        }
        aVar.PZ(i);
        aVar.Qc(i3).a(onClickListener);
        aVar.Qd(i4).b(onClickListener2);
        aVar.f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(106412);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
                AppMethodBeat.o(106412);
            }
        });
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106443);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c d(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106444);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106444);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.asJ(str3).a(onClickListener);
        aVar.asK(str4).b(onClickListener2);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106444);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        AppMethodBeat.i(106445);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106445);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.asJ(str3).a(onClickListener);
        aVar.asK(str4).b(onClickListener2);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.PT(context.getResources().getColor(i));
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106445);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106446);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106446);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.asJ(str3).a(onClickListener);
        aVar.asK(str4).b(onClickListener2);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106446);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i, int i2) {
        AppMethodBeat.i(106447);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106447);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.asJ(str3).a(onClickListener);
        aVar.asK(str4).b(onClickListener2);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        if (i > 0) {
            aMb.PT(context.getResources().getColor(i));
        }
        if (i2 > 0) {
            aMb.PU(context.getResources().getColor(i2));
        }
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106447);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, View view, String str) {
        AppMethodBeat.i(106448);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106448);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str);
        aVar.fn(view);
        aVar.rc(true);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106448);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, View view, OnClickListener onClickListener) {
        AppMethodBeat.i(106449);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106449);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str);
        aVar.fn(view);
        aVar.Qc(R.string.s6).a(onClickListener);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106449);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106450);
        com.tencent.mm.ui.widget.a.c a = a(context, true, str, view, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.o(106450);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(106451);
        com.tencent.mm.ui.widget.a.c a = a(context, z, str, view, str2, str3, onClickListener, onClickListener2, -1);
        AppMethodBeat.o(106451);
        return a;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        AppMethodBeat.i(106452);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106452);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str);
        aVar.fn(view);
        aVar.asJ(str2).a(onClickListener);
        aVar.asK(str3).b(onClickListener2);
        aVar.rc(z);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        if (i > 0) {
            aMb.PT(context.getResources().getColor(i));
        }
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106452);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, View view, OnClickListener onClickListener) {
        AppMethodBeat.i(106453);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106453);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str);
        aVar.fn(view);
        aVar.asJ(str2).a(onClickListener);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106453);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, View view, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        AppMethodBeat.i(106454);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106454);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str);
        aVar.asE(null);
        aVar.fn(view);
        aVar.Qc(R.string.s6).a(onClickListener);
        aVar.Qd(R.string.or).b(onClickListener2);
        aVar.f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(106413);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
                AppMethodBeat.o(106413);
            }
        });
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106454);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, int i, b bVar) {
        AppMethodBeat.i(106455);
        com.tencent.mm.ui.widget.a.c b = b(context, str, str2, str3, i, bVar);
        AppMethodBeat.o(106455);
        return b;
    }

    private static com.tencent.mm.ui.widget.a.c b(final Context context, String str, String str2, String str3, int i, final b bVar) {
        AppMethodBeat.i(106456);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106456);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.rc(false);
        aVar.rd(true);
        aVar.Qd(R.string.or).b(null);
        aVar.asD(str);
        View inflate = View.inflate(context, R.layout.ad8, null);
        final MMEditText mMEditText = (MMEditText) inflate.findViewById(R.id.l3);
        if (!bo.isNullOrNil(str2)) {
            mMEditText.asB(str2);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.bn0);
        if (bo.isNullOrNil(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.Qc(R.string.s6).a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(106415);
                boolean z = true;
                if (bVar != null) {
                    z = bVar.s(mMEditText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(106414);
                                ((MMActivity) context).aqX();
                                AppMethodBeat.o(106414);
                            }
                        });
                    }
                }
                AppMethodBeat.o(106415);
            }
        });
        if (i > 0) {
            com.tencent.mm.ui.tools.b.c.d(mMEditText).PM(i).a(null);
        }
        aVar.fn(inflate);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        if (context instanceof MMActivity) {
            inflate.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106416);
                    ((MMActivity) context).showVKB();
                    AppMethodBeat.o(106416);
                }
            });
        }
        AppMethodBeat.o(106456);
        return aMb;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, List<String> list, int i, final a aVar) {
        AppMethodBeat.i(106457);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106457);
            return null;
        } else if (list.isEmpty()) {
            ab.w("MicroMsg.MMAlert", "show switch alert fail");
            AppMethodBeat.o(106457);
            return null;
        } else {
            com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(context);
            aVar2.rc(false);
            aVar2.Qd(R.string.or);
            aVar2.asD(str);
            View inflate = View.inflate(context, R.layout.ad9, null);
            final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.d93);
            for (int size = list.size() - 1; size >= 0; size--) {
                TextView textView = (TextView) View.inflate(context, R.layout.aml, null);
                textView.setText((CharSequence) list.get(size));
                if (size == i) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                }
                if (size == list.size() - 1) {
                    context.getResources().getDimensionPixelSize(R.dimen.m4);
                    textView.setBackgroundResource(R.drawable.a2r);
                }
                textView.setTag(Integer.valueOf(size));
                linearLayout.addView(textView, 0);
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(106418);
                        for (int i = 0; i < linearLayout.getChildCount(); i++) {
                            TextView textView = (TextView) linearLayout.getChildAt(i);
                            if (textView.getId() != R.id.bn0) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                            }
                        }
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                        final int intValue = ((Integer) view.getTag()).intValue();
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(106417);
                                ((Dialog) linearLayout.getTag()).dismiss();
                                if (aVar != null) {
                                    aVar.BB(intValue);
                                }
                                AppMethodBeat.o(106417);
                            }
                        });
                        AppMethodBeat.o(106418);
                    }
                });
            }
            aVar2.fn(inflate);
            com.tencent.mm.ui.widget.a.c aMb = aVar2.aMb();
            linearLayout.setTag(aMb);
            aMb.show();
            a(context, aMb);
            AppMethodBeat.o(106457);
            return aMb;
        }
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, OnClickListener onClickListener, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106458);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106458);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.Qc(R.string.s6).a(onClickListener);
        aVar.f(onCancelListener);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        a(context, aMb);
        AppMethodBeat.o(106458);
        return aMb;
    }

    public static p b(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106459);
        p a = a(context, 0, str, z, onCancelListener);
        AppMethodBeat.o(106459);
        return a;
    }

    public static p b(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106460);
        p a = a(context, 2, str, true, onCancelListener);
        AppMethodBeat.o(106460);
        return a;
    }

    public static p a(Context context, int i, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106461);
        p a = a(context, i, -1, str, z, onCancelListener);
        AppMethodBeat.o(106461);
        return a;
    }

    public static p a(Context context, int i, int i2, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106462);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106462);
            return null;
        }
        y.activateBroadcast(true);
        final WeakReference weakReference = new WeakReference(onCancelListener);
        p b = p.b(context, str, z, i, i2, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(106419);
                OnCancelListener onCancelListener = (OnCancelListener) weakReference.get();
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                y.activateBroadcast(false);
                AppMethodBeat.o(106419);
            }
        });
        a(context, b);
        AppMethodBeat.o(106462);
        return b;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, d dVar) {
        AppMethodBeat.i(106463);
        Dialog b = b(context, str, list, list2, str2, true, dVar);
        AppMethodBeat.o(106463);
        return b;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, boolean z, d dVar) {
        AppMethodBeat.i(106464);
        Dialog b = b(context, str, list, list2, str2, z, dVar);
        AppMethodBeat.o(106464);
        return b;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, d dVar) {
        AppMethodBeat.i(106465);
        Dialog b = b(context, str, list, list2, null, true, dVar);
        AppMethodBeat.o(106465);
        return b;
    }

    @Deprecated
    private static Dialog b(Context context, final String str, List<String> list, final List<Integer> list2, final String str2, boolean z, final d dVar) {
        AppMethodBeat.i(106466);
        if ((list == null || list.size() == 0) && bo.isNullOrNil(str2)) {
            AppMethodBeat.o(106466);
            return null;
        }
        List list3;
        if (list3 == null) {
            list3 = new ArrayList();
        }
        if (z) {
            j jVar = new j(context);
            jVar.rBl = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(106420);
                    if (!bo.isNullOrNil(str)) {
                        lVar.setHeaderTitle(str);
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list3.size()) {
                            break;
                        }
                        lVar.e(((Integer) list2.get(i2)).intValue(), (CharSequence) list3.get(i2));
                        i = i2 + 1;
                    }
                    if (!bo.isNullOrNil(str2)) {
                        lVar.e(-1, str2);
                    }
                    AppMethodBeat.o(106420);
                }
            };
            jVar.rBm = new com.tencent.mm.ui.base.n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(106404);
                    if (dVar != null) {
                        dVar.bV(i, menuItem.getItemId());
                    }
                    AppMethodBeat.o(106404);
                }
            };
            jVar.e(null);
            Dialog cuu = jVar.cuu();
            a(context, cuu);
            AppMethodBeat.o(106466);
            return cuu;
        }
        com.tencent.mm.ui.widget.a.d dVar2 = new com.tencent.mm.ui.widget.a.d(context, 1, false);
        dVar2.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(106405);
                if (!bo.isNullOrNil(str)) {
                    lVar.setHeaderTitle(str);
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list3.size()) {
                        break;
                    }
                    lVar.e(((Integer) list2.get(i2)).intValue(), (CharSequence) list3.get(i2));
                    i = i2 + 1;
                }
                if (!bo.isNullOrNil(str2)) {
                    lVar.e(-1, str2);
                }
                AppMethodBeat.o(106405);
            }
        };
        dVar2.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(106406);
                if (dVar != null) {
                    dVar.bV(i, menuItem.getItemId());
                }
                AppMethodBeat.o(106406);
            }
        };
        dVar2.cpD();
        AppMethodBeat.o(106466);
        return null;
    }

    public static Dialog a(Context context, String str, String[] strArr, c cVar) {
        AppMethodBeat.i(106467);
        Dialog a = a(context, str, strArr, null, true, cVar, null);
        AppMethodBeat.o(106467);
        return a;
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar) {
        AppMethodBeat.i(106468);
        Dialog a = a(context, str, strArr, str2, true, cVar, null);
        AppMethodBeat.o(106468);
        return a;
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, boolean z, c cVar) {
        AppMethodBeat.i(106469);
        Dialog a = a(context, str, strArr, str2, z, cVar, null);
        AppMethodBeat.o(106469);
        return a;
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106470);
        Dialog a = a(context, str, strArr, str2, true, cVar, onCancelListener);
        AppMethodBeat.o(106470);
        return a;
    }

    @Deprecated
    public static Dialog a(Context context, final String str, String[] strArr, String str2, boolean z, final c cVar, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106471);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(106471);
            return null;
        } else if ((strArr == null || strArr.length == 0) && bo.isNullOrNil(str2)) {
            AppMethodBeat.o(106471);
            return null;
        } else {
            final ArrayList arrayList = new ArrayList();
            if (strArr != null && strArr.length > 0) {
                Collections.addAll(arrayList, strArr);
            }
            if (!bo.isNullOrNil(str2)) {
                arrayList.add(str2);
            }
            if (z) {
                j jVar = new j(context);
                jVar.rBl = new com.tencent.mm.ui.base.n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(106407);
                        lVar.setHeaderTitle(str);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                lVar.e(i2, (CharSequence) arrayList.get(i2));
                                i = i2 + 1;
                            } else {
                                AppMethodBeat.o(106407);
                                return;
                            }
                        }
                    }
                };
                jVar.rBm = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(106408);
                        if (cVar != null) {
                            cVar.iE(menuItem.getItemId());
                        }
                        AppMethodBeat.o(106408);
                    }
                };
                jVar.e(onCancelListener);
                Dialog cuu = jVar.cuu();
                a(context, cuu);
                AppMethodBeat.o(106471);
                return cuu;
            }
            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(context, 1, false);
            dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(106409);
                    lVar.setHeaderTitle(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            lVar.e(i2, (CharSequence) arrayList.get(i2));
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.o(106409);
                            return;
                        }
                    }
                }
            };
            dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(106410);
                    if (cVar != null) {
                        cVar.iE(menuItem.getItemId());
                    }
                    AppMethodBeat.o(106410);
                }
            };
            dVar.cpD();
            AppMethodBeat.o(106471);
            return null;
        }
    }

    public static Toast bN(Context context, String str) {
        AppMethodBeat.i(139071);
        Toast bQ = bQ(context, str);
        AppMethodBeat.o(139071);
        return bQ;
    }
}
