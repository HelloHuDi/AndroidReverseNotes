package com.tencent.p177mm.p1192h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C303869;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.h.a */
public final class C42124a {
    public String Title;
    public String desc;
    private C42128c eeT;
    public int showType;
    public String url;

    /* renamed from: jY */
    public static C42124a m74268jY(String str) {
        AppMethodBeat.m2504i(77627);
        C42128c ka = C42128c.m74275ka(str);
        if (ka != null) {
            C42124a c42124a = new C42124a();
            c42124a.eeT = ka;
            c42124a.url = ka.url;
            c42124a.desc = ka.desc;
            c42124a.showType = ka.showType;
            c42124a.Title = ka.Title;
            AppMethodBeat.m2505o(77627);
            return c42124a;
        }
        AppMethodBeat.m2505o(77627);
        return null;
    }

    /* renamed from: a */
    public final boolean mo67669a(Context context, OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(77629);
        String str = this.desc;
        String str2 = this.Title;
        if (!((Activity) context).isFinishing()) {
            C5652a c5652a = new C5652a(context);
            c5652a.asD(str2);
            c5652a.asE(str);
            c5652a.mo11458a(onDismissListener);
            c5652a.mo11482rc(false);
            c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(new C303869());
            C5653c aMb = c5652a.aMb();
            aMb.show();
            C30379h.m48455a(context, aMb);
        }
        AppMethodBeat.m2505o(77629);
        return true;
    }

    /* renamed from: a */
    public final boolean mo67668a(Context context, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(77628);
        if (this.showType == 3 || this.showType == 4) {
            String str = this.eeT.eff;
            String str2 = this.eeT.efg;
            if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
                str = context.getString(this.showType == 3 ? C25738R.string.f9262up : C25738R.string.f9187s6);
                str2 = context.getString(this.showType == 3 ? C25738R.string.f9183s2 : C25738R.string.f9076or);
            }
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                String str3 = this.desc;
                String str4 = this.Title;
                if (!C5046bo.isNullOrNil(str)) {
                    str2 = str;
                }
                if (!C5046bo.isNullOrNil(str)) {
                    onClickListener2 = onClickListener;
                }
                C30379h.m48443a(context, str3, str4, str2, onClickListener2);
            } else {
                C30379h.m48466d(context, this.desc, this.Title, str, str2, onClickListener, onClickListener2);
            }
            AppMethodBeat.m2505o(77628);
            return true;
        } else if (this.showType == 1) {
            C30379h.m48461b(context, this.desc, this.Title, true);
            AppMethodBeat.m2505o(77628);
            return true;
        } else if (this.showType == 5) {
            C30379h.m48461b(context, this.desc, this.Title, true);
            AppMethodBeat.m2505o(77628);
            return true;
        } else {
            AppMethodBeat.m2505o(77628);
            return false;
        }
    }
}
