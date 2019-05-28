package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.p1421a.C30375a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.n */
public class C23322n extends ClickableSpan implements C30375a {
    private int eHE;
    private String hcl;
    boolean mEnable = true;
    /* renamed from: nq */
    private WeakReference<View> f4409nq = null;
    public boolean ozq = false;
    private Context vsp = null;
    private int vsu;
    protected C44087h vsv = null;
    private C14932m vsw = null;

    public C23322n(int i, C14932m c14932m) {
        int i2;
        int i3;
        AppMethodBeat.m2504i(79878);
        if (c14932m != null) {
            int i4 = c14932m.linkColor;
            i2 = c14932m.backgroundColor;
            i3 = i4;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i3 == 0 && i2 == 0) {
            mo39044Hy(i);
        } else {
            mo39045gP(i3, i2);
        }
        this.vsv = new C44087h();
        this.vsw = c14932m;
        AppMethodBeat.m2505o(79878);
    }

    public C23322n(int i, int i2) {
        AppMethodBeat.m2504i(79879);
        mo39045gP(i, i2);
        this.vsv = new C44087h();
        AppMethodBeat.m2505o(79879);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Hy */
    public void mo39044Hy(int i) {
        AppMethodBeat.m2504i(79880);
        Context context = C4996ah.getContext();
        switch (i) {
            case 1:
                mo39045gP(context.getResources().getColor(C25738R.color.f11871k4), context.getResources().getColor(C25738R.color.f11626k));
                AppMethodBeat.m2505o(79880);
                return;
            case 2:
                mo39045gP(context.getResources().getColor(C25738R.color.f11795hi), context.getResources().getColor(C25738R.color.a0j));
                AppMethodBeat.m2505o(79880);
                return;
            case 3:
                mo39045gP(context.getResources().getColor(C25738R.color.a0s), context.getResources().getColor(C25738R.color.a0j));
                break;
        }
        AppMethodBeat.m2505o(79880);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: gP */
    public final void mo39045gP(int i, int i2) {
        this.vsu = i;
        this.eHE = i2;
    }

    /* renamed from: oT */
    public final void mo39047oT(boolean z) {
        this.ozq = z;
    }

    public final int getType() {
        return this.vsw == null ? BaseClientBuilder.API_PRIORITY_OTHER : this.vsw.type;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(79881);
        if (!(this.vsv == null || this.vsw == null || !this.mEnable)) {
            Context context;
            C44087h c44087h = this.vsv;
            if (this.vsp != null) {
                context = this.vsp;
            } else {
                context = view.getContext();
            }
            c44087h.mContext = context;
            this.vsv.mo23045a(view, this.vsw);
            this.vsv.mContext = null;
        }
        AppMethodBeat.m2505o(79881);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.m2504i(79882);
        super.updateDrawState(textPaint);
        textPaint.setColor(this.vsu);
        textPaint.setUnderlineText(false);
        textPaint.linkColor = this.vsu;
        if (this.ozq) {
            textPaint.bgColor = this.eHE;
            AppMethodBeat.m2505o(79882);
            return;
        }
        textPaint.bgColor = 0;
        AppMethodBeat.m2505o(79882);
    }

    public final void setContext(Context context) {
        this.vsp = context;
        this.vsv.mContext = context;
    }

    public final void setSessionId(String str) {
        this.hcl = str;
        if (this.vsv != null) {
            this.vsv.hcl = this.hcl;
        }
    }
}
