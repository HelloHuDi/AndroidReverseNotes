package com.tencent.mm.pluginsdk.ui.e;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.a.a;
import java.lang.ref.WeakReference;

public class n extends ClickableSpan implements a {
    private int eHE;
    private String hcl;
    boolean mEnable = true;
    private WeakReference<View> nq = null;
    public boolean ozq = false;
    private Context vsp = null;
    private int vsu;
    protected h vsv = null;
    private m vsw = null;

    public n(int i, m mVar) {
        int i2;
        int i3;
        AppMethodBeat.i(79878);
        if (mVar != null) {
            int i4 = mVar.linkColor;
            i2 = mVar.backgroundColor;
            i3 = i4;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i3 == 0 && i2 == 0) {
            Hy(i);
        } else {
            gP(i3, i2);
        }
        this.vsv = new h();
        this.vsw = mVar;
        AppMethodBeat.o(79878);
    }

    public n(int i, int i2) {
        AppMethodBeat.i(79879);
        gP(i, i2);
        this.vsv = new h();
        AppMethodBeat.o(79879);
    }

    /* Access modifiers changed, original: protected */
    public void Hy(int i) {
        AppMethodBeat.i(79880);
        Context context = ah.getContext();
        switch (i) {
            case 1:
                gP(context.getResources().getColor(R.color.k4), context.getResources().getColor(R.color.k));
                AppMethodBeat.o(79880);
                return;
            case 2:
                gP(context.getResources().getColor(R.color.hi), context.getResources().getColor(R.color.a0j));
                AppMethodBeat.o(79880);
                return;
            case 3:
                gP(context.getResources().getColor(R.color.a0s), context.getResources().getColor(R.color.a0j));
                break;
        }
        AppMethodBeat.o(79880);
    }

    /* Access modifiers changed, original: protected|final */
    public final void gP(int i, int i2) {
        this.vsu = i;
        this.eHE = i2;
    }

    public final void oT(boolean z) {
        this.ozq = z;
    }

    public final int getType() {
        return this.vsw == null ? BaseClientBuilder.API_PRIORITY_OTHER : this.vsw.type;
    }

    public void onClick(View view) {
        AppMethodBeat.i(79881);
        if (!(this.vsv == null || this.vsw == null || !this.mEnable)) {
            Context context;
            h hVar = this.vsv;
            if (this.vsp != null) {
                context = this.vsp;
            } else {
                context = view.getContext();
            }
            hVar.mContext = context;
            this.vsv.a(view, this.vsw);
            this.vsv.mContext = null;
        }
        AppMethodBeat.o(79881);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(79882);
        super.updateDrawState(textPaint);
        textPaint.setColor(this.vsu);
        textPaint.setUnderlineText(false);
        textPaint.linkColor = this.vsu;
        if (this.ozq) {
            textPaint.bgColor = this.eHE;
            AppMethodBeat.o(79882);
            return;
        }
        textPaint.bgColor = 0;
        AppMethodBeat.o(79882);
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
