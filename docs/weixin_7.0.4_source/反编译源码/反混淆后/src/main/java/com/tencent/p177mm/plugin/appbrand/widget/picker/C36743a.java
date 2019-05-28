package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.a */
public final class C36743a extends C33642d {
    private static final int huq = 2131820573;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.a$1 */
    class C367441 implements OnClickListener {
        C367441() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126683);
            C36743a.this.hide();
            AppMethodBeat.m2505o(126683);
        }
    }

    /* renamed from: cV */
    public static C36743a m60964cV(View view) {
        AppMethodBeat.m2504i(126684);
        C36743a c36743a = (C36743a) view.getRootView().findViewById(huq);
        AppMethodBeat.m2505o(126684);
        return c36743a;
    }

    public C36743a(Context context) {
        super(context);
        AppMethodBeat.m2504i(126685);
        super.setId(huq);
        setBackgroundResource(C25738R.color.f12084rr);
        setOnClickListener(new C367441());
        AppMethodBeat.m2505o(126685);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(126686);
        if (isShown()) {
            int i3;
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i3 = 0;
            } else {
                i3 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i3 > 0) {
                mo54201du(i, MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED));
                AppMethodBeat.m2505o(126686);
                return;
            }
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(126686);
    }

    public final void setId(int i) {
    }

    public final void show() {
        AppMethodBeat.m2504i(126687);
        super.show();
        AppMethodBeat.m2505o(126687);
    }

    public final void hide() {
        AppMethodBeat.m2504i(126688);
        super.hide();
        AppMethodBeat.m2505o(126688);
    }
}
