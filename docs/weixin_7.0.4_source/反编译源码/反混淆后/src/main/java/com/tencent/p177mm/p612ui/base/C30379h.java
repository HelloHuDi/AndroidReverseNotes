package com.tencent.p177mm.p612ui.base;

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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
/* renamed from: com.tencent.mm.ui.base.h */
public final class C30379h {

    /* renamed from: com.tencent.mm.ui.base.h$a */
    public interface C30381a {
        /* renamed from: BB */
        void mo26479BB(int i);
    }

    /* renamed from: com.tencent.mm.ui.base.h$d */
    public interface C30382d {
        /* renamed from: bV */
        void mo4975bV(int i, int i2);
    }

    /* renamed from: com.tencent.mm.ui.base.h$9 */
    public static class C303869 implements OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(106411);
            dialogInterface.cancel();
            AppMethodBeat.m2505o(106411);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.h$b */
    public interface C30387b {
        /* renamed from: s */
        boolean mo4760s(CharSequence charSequence);
    }

    /* renamed from: com.tencent.mm.ui.base.h$1 */
    static class C303891 implements OnClickListener {
        C303891() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(106403);
            dialogInterface.cancel();
            AppMethodBeat.m2505o(106403);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.h$c */
    public interface C30391c {
        /* renamed from: iE */
        void mo7700iE(int i);
    }

    /* renamed from: a */
    public static void m48455a(Context context, Dialog dialog) {
        AppMethodBeat.m2504i(106421);
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
        }
        AppMethodBeat.m2505o(106421);
    }

    /* renamed from: bO */
    public static Toast m48463bO(Context context, String str) {
        AppMethodBeat.m2504i(106423);
        Toast bQ = C30379h.m48465bQ(context, str);
        AppMethodBeat.m2505o(106423);
        return bQ;
    }

    /* renamed from: bP */
    public static void m48464bP(Context context, String str) {
        AppMethodBeat.m2504i(106424);
        Toast.makeText(context, str, 0).show();
        AppMethodBeat.m2505o(106424);
    }

    /* renamed from: bQ */
    public static Toast m48465bQ(Context context, String str) {
        AppMethodBeat.m2504i(106425);
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.show();
        AppMethodBeat.m2505o(106425);
        return makeText;
    }

    /* renamed from: J */
    public static C5653c m48417J(Context context, String str, String str2) {
        AppMethodBeat.m2504i(139072);
        C5653c b = C30379h.m48461b(context, str, str2, true);
        AppMethodBeat.m2505o(139072);
        return b;
    }

    /* renamed from: b */
    public static C5653c m48461b(Context context, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(106427);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106427);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.mo11482rc(z);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(new C303891());
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106427);
        return aMb;
    }

    /* renamed from: g */
    public static C5653c m48467g(Context context, int i, int i2) {
        String string;
        AppMethodBeat.m2504i(106428);
        String string2 = i > 0 ? context.getString(i) : "";
        if (i2 > 0) {
            string = context.getString(i2);
        } else {
            string = "";
        }
        C5653c b = C30379h.m48461b(context, string2, string, true);
        AppMethodBeat.m2505o(106428);
        return b;
    }

    /* renamed from: a */
    public static C5653c m48431a(Context context, int i, int i2, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106429);
        C5653c a = C30379h.m48433a(context, i, i2, true, onClickListener);
        AppMethodBeat.m2505o(106429);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48433a(Context context, int i, int i2, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106430);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106430);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        if (i2 > 0) {
            c5652a.mo11446PV(i2);
        }
        c5652a.mo11450PZ(i);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(onClickListener);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106430);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48438a(Context context, String str, String str2, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106431);
        C5653c a = C30379h.m48448a(context, str, str2, true, onClickListener);
        AppMethodBeat.m2505o(106431);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48448a(Context context, String str, String str2, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106432);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106432);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(onClickListener);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106432);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48443a(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106433);
        C5653c a = C30379h.m48447a(context, str, str2, str3, true, onClickListener);
        AppMethodBeat.m2505o(106433);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48447a(Context context, String str, String str2, String str3, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106434);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106434);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.asJ(str3).mo11457a(onClickListener);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106434);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48440a(Context context, String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106435);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106435);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(onClickListener);
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(onClickListener2);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106435);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48449a(Context context, String str, String str2, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106436);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106436);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(onClickListener);
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(onClickListener2);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106436);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48445a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106437);
        C5653c a = C30379h.m48446a(context, str, str2, str3, str4, z, onClickListener, onClickListener2, -1);
        AppMethodBeat.m2505o(106437);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48446a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        AppMethodBeat.m2504i(106438);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106438);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.asJ(str3).mo11457a(onClickListener);
        c5652a.asK(str4).mo11476b(onClickListener2);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        if (i > 0) {
            aMb.mo11485PT(context.getResources().getColor(i));
        }
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106438);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48432a(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106439);
        C5653c a = C30379h.m48440a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", onClickListener, onClickListener2);
        AppMethodBeat.m2505o(106439);
        return a;
    }

    /* renamed from: b */
    public static C5653c m48459b(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106440);
        C5653c a = C30379h.m48449a(context, i > 0 ? context.getString(i) : "", context.getString(C25738R.string.f9238tz), false, onClickListener, onClickListener2);
        AppMethodBeat.m2505o(106440);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48429a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106441);
        C5653c a = C30379h.m48445a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2);
        AppMethodBeat.m2505o(106441);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48430a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i5) {
        AppMethodBeat.m2504i(106442);
        C5653c a = C30379h.m48446a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2, i5);
        AppMethodBeat.m2505o(106442);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48428a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106443);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106443);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        if (i2 != 0) {
            c5652a.mo11446PV(i2);
        }
        c5652a.mo11450PZ(i);
        c5652a.mo11453Qc(i3).mo11457a(onClickListener);
        c5652a.mo11454Qd(i4).mo11476b(onClickListener2);
        c5652a.mo11478f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(106412);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
                AppMethodBeat.m2505o(106412);
            }
        });
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106443);
        return aMb;
    }

    /* renamed from: d */
    public static C5653c m48466d(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106444);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106444);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.asJ(str3).mo11457a(onClickListener);
        c5652a.asK(str4).mo11476b(onClickListener2);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106444);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48444a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        AppMethodBeat.m2504i(106445);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106445);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.asJ(str3).mo11457a(onClickListener);
        c5652a.asK(str4).mo11476b(onClickListener2);
        C5653c aMb = c5652a.aMb();
        aMb.mo11485PT(context.getResources().getColor(i));
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106445);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48453a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106446);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106446);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.asJ(str3).mo11457a(onClickListener);
        c5652a.asK(str4).mo11476b(onClickListener2);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106446);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48454a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i, int i2) {
        AppMethodBeat.m2504i(106447);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106447);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.asJ(str3).mo11457a(onClickListener);
        c5652a.asK(str4).mo11476b(onClickListener2);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        if (i > 0) {
            aMb.mo11485PT(context.getResources().getColor(i));
        }
        if (i2 > 0) {
            aMb.mo11486PU(context.getResources().getColor(i2));
        }
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106447);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48434a(Context context, View view, String str) {
        AppMethodBeat.m2504i(106448);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106448);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str);
        c5652a.mo11479fn(view);
        c5652a.mo11482rc(true);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106448);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48435a(Context context, String str, View view, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106449);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106449);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str);
        c5652a.mo11479fn(view);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(onClickListener);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106449);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48437a(Context context, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106450);
        C5653c a = C30379h.m48451a(context, true, str, view, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.m2505o(106450);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48451a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106451);
        C5653c a = C30379h.m48452a(context, z, str, view, str2, str3, onClickListener, onClickListener2, -1);
        AppMethodBeat.m2505o(106451);
        return a;
    }

    /* renamed from: a */
    public static C5653c m48452a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        AppMethodBeat.m2504i(106452);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106452);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str);
        c5652a.mo11479fn(view);
        c5652a.asJ(str2).mo11457a(onClickListener);
        c5652a.asK(str3).mo11476b(onClickListener2);
        c5652a.mo11482rc(z);
        C5653c aMb = c5652a.aMb();
        if (i > 0) {
            aMb.mo11485PT(context.getResources().getColor(i));
        }
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106452);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48441a(Context context, String str, String str2, View view, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106453);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106453);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str);
        c5652a.mo11479fn(view);
        c5652a.asJ(str2).mo11457a(onClickListener);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106453);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48436a(Context context, String str, View view, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(106454);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106454);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str);
        c5652a.asE(null);
        c5652a.mo11479fn(view);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(onClickListener);
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(onClickListener2);
        c5652a.mo11478f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(106413);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
                AppMethodBeat.m2505o(106413);
            }
        });
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106454);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48442a(Context context, String str, String str2, String str3, int i, C30387b c30387b) {
        AppMethodBeat.m2504i(106455);
        C5653c b = C30379h.m48460b(context, str, str2, str3, i, c30387b);
        AppMethodBeat.m2505o(106455);
        return b;
    }

    /* renamed from: b */
    private static C5653c m48460b(final Context context, String str, String str2, String str3, int i, final C30387b c30387b) {
        AppMethodBeat.m2504i(106456);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106456);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(true);
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(null);
        c5652a.asD(str);
        View inflate = View.inflate(context, 2130970094, null);
        final MMEditText mMEditText = (MMEditText) inflate.findViewById(2131820980);
        if (!C5046bo.isNullOrNil(str2)) {
            mMEditText.asB(str2);
        }
        TextView textView = (TextView) inflate.findViewById(2131823800);
        if (C5046bo.isNullOrNil(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11462a(false, new OnClickListener() {

            /* renamed from: com.tencent.mm.ui.base.h$12$1 */
            class C155301 implements Runnable {
                C155301() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(106414);
                    ((MMActivity) context).aqX();
                    AppMethodBeat.m2505o(106414);
                }
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(106415);
                boolean z = true;
                if (c30387b != null) {
                    z = c30387b.mo4760s(mMEditText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        C5004al.m7441d(new C155301());
                    }
                }
                AppMethodBeat.m2505o(106415);
            }
        });
        if (i > 0) {
            C7357c.m12555d(mMEditText).mo15877PM(i).mo15879a(null);
        }
        c5652a.mo11479fn(inflate);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        if (context instanceof MMActivity) {
            inflate.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(106416);
                    ((MMActivity) context).showVKB();
                    AppMethodBeat.m2505o(106416);
                }
            });
        }
        AppMethodBeat.m2505o(106456);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m48450a(Context context, String str, List<String> list, int i, final C30381a c30381a) {
        AppMethodBeat.m2504i(106457);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106457);
            return null;
        } else if (list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.MMAlert", "show switch alert fail");
            AppMethodBeat.m2505o(106457);
            return null;
        } else {
            C5652a c5652a = new C5652a(context);
            c5652a.mo11482rc(false);
            c5652a.mo11454Qd(C25738R.string.f9076or);
            c5652a.asD(str);
            View inflate = View.inflate(context, 2130970095, null);
            final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131825985);
            for (int size = list.size() - 1; size >= 0; size--) {
                TextView textView = (TextView) View.inflate(context, 2130970442, null);
                textView.setText((CharSequence) list.get(size));
                if (size == i) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_on, 0, 0, 0);
                }
                if (size == list.size() - 1) {
                    context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                    textView.setBackgroundResource(C25738R.drawable.a2r);
                }
                textView.setTag(Integer.valueOf(size));
                linearLayout.addView(textView, 0);
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(106418);
                        for (int i = 0; i < linearLayout.getChildCount(); i++) {
                            TextView textView = (TextView) linearLayout.getChildAt(i);
                            if (textView.getId() != 2131823800) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_off, 0, 0, 0);
                            }
                        }
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_on, 0, 0, 0);
                        final int intValue = ((Integer) view.getTag()).intValue();
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(106417);
                                ((Dialog) linearLayout.getTag()).dismiss();
                                if (c30381a != null) {
                                    c30381a.mo26479BB(intValue);
                                }
                                AppMethodBeat.m2505o(106417);
                            }
                        });
                        AppMethodBeat.m2505o(106418);
                    }
                });
            }
            c5652a.mo11479fn(inflate);
            C5653c aMb = c5652a.aMb();
            linearLayout.setTag(aMb);
            aMb.show();
            C30379h.m48455a(context, aMb);
            AppMethodBeat.m2505o(106457);
            return aMb;
        }
    }

    /* renamed from: a */
    public static C5653c m48439a(Context context, String str, String str2, OnClickListener onClickListener, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106458);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106458);
            return null;
        }
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(onClickListener);
        c5652a.mo11478f(onCancelListener);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
        AppMethodBeat.m2505o(106458);
        return aMb;
    }

    /* renamed from: b */
    public static C44275p m48458b(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106459);
        C44275p a = C30379h.m48427a(context, 0, str, z, onCancelListener);
        AppMethodBeat.m2505o(106459);
        return a;
    }

    /* renamed from: b */
    public static C44275p m48457b(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106460);
        C44275p a = C30379h.m48427a(context, 2, str, true, onCancelListener);
        AppMethodBeat.m2505o(106460);
        return a;
    }

    /* renamed from: a */
    public static C44275p m48427a(Context context, int i, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106461);
        C44275p a = C30379h.m48426a(context, i, -1, str, z, onCancelListener);
        AppMethodBeat.m2505o(106461);
        return a;
    }

    /* renamed from: a */
    public static C44275p m48426a(Context context, int i, int i2, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106462);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106462);
            return null;
        }
        C5288y.activateBroadcast(true);
        final WeakReference weakReference = new WeakReference(onCancelListener);
        C44275p b = C44275p.m79965b(context, str, z, i, i2, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(106419);
                OnCancelListener onCancelListener = (OnCancelListener) weakReference.get();
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                C5288y.activateBroadcast(false);
                AppMethodBeat.m2505o(106419);
            }
        });
        C30379h.m48455a(context, b);
        AppMethodBeat.m2505o(106462);
        return b;
    }

    /* renamed from: a */
    public static Dialog m48419a(Context context, String str, List<String> list, List<Integer> list2, String str2, C30382d c30382d) {
        AppMethodBeat.m2504i(106463);
        Dialog b = C30379h.m48456b(context, str, list, list2, str2, true, c30382d);
        AppMethodBeat.m2505o(106463);
        return b;
    }

    /* renamed from: a */
    public static Dialog m48420a(Context context, String str, List<String> list, List<Integer> list2, String str2, boolean z, C30382d c30382d) {
        AppMethodBeat.m2504i(106464);
        Dialog b = C30379h.m48456b(context, str, list, list2, str2, z, c30382d);
        AppMethodBeat.m2505o(106464);
        return b;
    }

    /* renamed from: a */
    public static Dialog m48418a(Context context, String str, List<String> list, List<Integer> list2, C30382d c30382d) {
        AppMethodBeat.m2504i(106465);
        Dialog b = C30379h.m48456b(context, str, list, list2, null, true, c30382d);
        AppMethodBeat.m2505o(106465);
        return b;
    }

    @Deprecated
    /* renamed from: b */
    private static Dialog m48456b(Context context, final String str, List<String> list, final List<Integer> list2, final String str2, boolean z, final C30382d c30382d) {
        AppMethodBeat.m2504i(106466);
        if ((list == null || list.size() == 0) && C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(106466);
            return null;
        }
        List list3;
        if (list3 == null) {
            list3 = new ArrayList();
        }
        if (z) {
            C46696j c46696j = new C46696j(context);
            c46696j.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(106420);
                    if (!C5046bo.isNullOrNil(str)) {
                        c44273l.setHeaderTitle(str);
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list3.size()) {
                            break;
                        }
                        c44273l.mo70068e(((Integer) list2.get(i2)).intValue(), (CharSequence) list3.get(i2));
                        i = i2 + 1;
                    }
                    if (!C5046bo.isNullOrNil(str2)) {
                        c44273l.mo70068e(-1, str2);
                    }
                    AppMethodBeat.m2505o(106420);
                }
            };
            c46696j.rBm = new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(106404);
                    if (c30382d != null) {
                        c30382d.mo4975bV(i, menuItem.getItemId());
                    }
                    AppMethodBeat.m2505o(106404);
                }
            };
            c46696j.mo75012e(null);
            Dialog cuu = c46696j.cuu();
            C30379h.m48455a(context, cuu);
            AppMethodBeat.m2505o(106466);
            return cuu;
        }
        C36356d c36356d = new C36356d(context, 1, false);
        c36356d.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(106405);
                if (!C5046bo.isNullOrNil(str)) {
                    c44273l.setHeaderTitle(str);
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list3.size()) {
                        break;
                    }
                    c44273l.mo70068e(((Integer) list2.get(i2)).intValue(), (CharSequence) list3.get(i2));
                    i = i2 + 1;
                }
                if (!C5046bo.isNullOrNil(str2)) {
                    c44273l.mo70068e(-1, str2);
                }
                AppMethodBeat.m2505o(106405);
            }
        };
        c36356d.rBm = new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(106406);
                if (c30382d != null) {
                    c30382d.mo4975bV(i, menuItem.getItemId());
                }
                AppMethodBeat.m2505o(106406);
            }
        };
        c36356d.cpD();
        AppMethodBeat.m2505o(106466);
        return null;
    }

    /* renamed from: a */
    public static Dialog m48421a(Context context, String str, String[] strArr, C30391c c30391c) {
        AppMethodBeat.m2504i(106467);
        Dialog a = C30379h.m48425a(context, str, strArr, null, true, c30391c, null);
        AppMethodBeat.m2505o(106467);
        return a;
    }

    /* renamed from: a */
    public static Dialog m48422a(Context context, String str, String[] strArr, String str2, C30391c c30391c) {
        AppMethodBeat.m2504i(106468);
        Dialog a = C30379h.m48425a(context, str, strArr, str2, true, c30391c, null);
        AppMethodBeat.m2505o(106468);
        return a;
    }

    /* renamed from: a */
    public static Dialog m48424a(Context context, String str, String[] strArr, String str2, boolean z, C30391c c30391c) {
        AppMethodBeat.m2504i(106469);
        Dialog a = C30379h.m48425a(context, str, strArr, str2, z, c30391c, null);
        AppMethodBeat.m2505o(106469);
        return a;
    }

    /* renamed from: a */
    public static Dialog m48423a(Context context, String str, String[] strArr, String str2, C30391c c30391c, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106470);
        Dialog a = C30379h.m48425a(context, str, strArr, str2, true, c30391c, onCancelListener);
        AppMethodBeat.m2505o(106470);
        return a;
    }

    @Deprecated
    /* renamed from: a */
    public static Dialog m48425a(Context context, final String str, String[] strArr, String str2, boolean z, final C30391c c30391c, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106471);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(106471);
            return null;
        } else if ((strArr == null || strArr.length == 0) && C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(106471);
            return null;
        } else {
            final ArrayList arrayList = new ArrayList();
            if (strArr != null && strArr.length > 0) {
                Collections.addAll(arrayList, strArr);
            }
            if (!C5046bo.isNullOrNil(str2)) {
                arrayList.add(str2);
            }
            if (z) {
                C46696j c46696j = new C46696j(context);
                c46696j.rBl = new C36073c() {
                    /* renamed from: a */
                    public final void mo5746a(C44273l c44273l) {
                        AppMethodBeat.m2504i(106407);
                        c44273l.setHeaderTitle(str);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                c44273l.mo70068e(i2, (CharSequence) arrayList.get(i2));
                                i = i2 + 1;
                            } else {
                                AppMethodBeat.m2505o(106407);
                                return;
                            }
                        }
                    }
                };
                c46696j.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(106408);
                        if (c30391c != null) {
                            c30391c.mo7700iE(menuItem.getItemId());
                        }
                        AppMethodBeat.m2505o(106408);
                    }
                };
                c46696j.mo75012e(onCancelListener);
                Dialog cuu = c46696j.cuu();
                C30379h.m48455a(context, cuu);
                AppMethodBeat.m2505o(106471);
                return cuu;
            }
            C36356d c36356d = new C36356d(context, 1, false);
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(106409);
                    c44273l.setHeaderTitle(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            c44273l.mo70068e(i2, (CharSequence) arrayList.get(i2));
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.m2505o(106409);
                            return;
                        }
                    }
                }
            };
            c36356d.rBm = new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(106410);
                    if (c30391c != null) {
                        c30391c.mo7700iE(menuItem.getItemId());
                    }
                    AppMethodBeat.m2505o(106410);
                }
            };
            c36356d.cpD();
            AppMethodBeat.m2505o(106471);
            return null;
        }
    }

    /* renamed from: bN */
    public static Toast m48462bN(Context context, String str) {
        AppMethodBeat.m2504i(139071);
        Toast bQ = C30379h.m48465bQ(context, str);
        AppMethodBeat.m2505o(139071);
        return bQ;
    }
}
