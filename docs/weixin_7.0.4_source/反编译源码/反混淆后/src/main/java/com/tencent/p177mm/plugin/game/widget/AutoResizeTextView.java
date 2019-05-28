package com.tencent.p177mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.widget.C21045a.C21044b;

/* renamed from: com.tencent.mm.plugin.game.widget.AutoResizeTextView */
public class AutoResizeTextView extends TextView implements C21044b {
    private C21045a nnT;

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112354);
        m20136h(attributeSet);
        AppMethodBeat.m2505o(112354);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112355);
        m20136h(attributeSet);
        AppMethodBeat.m2505o(112355);
    }

    /* renamed from: h */
    private void m20136h(AttributeSet attributeSet) {
        AppMethodBeat.m2504i(112356);
        this.nnT = C21045a.m32345a(this, attributeSet).mo36378a(this);
        AppMethodBeat.m2505o(112356);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(112357);
        super.onLayout(z, i, i2, i3, i4);
        if (this.nnT != null) {
            this.nnT.bFJ();
        }
        AppMethodBeat.m2505o(112357);
    }

    public void setTextSize(int i, float f) {
        AppMethodBeat.m2504i(112358);
        super.setTextSize(i, f);
        if (this.nnT != null) {
            C21045a c21045a = this.nnT;
            if (!c21045a.noc) {
                Context context = c21045a.f4384sW.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                c21045a.setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
            }
        }
        AppMethodBeat.m2505o(112358);
    }

    public void setLines(int i) {
        AppMethodBeat.m2504i(112359);
        super.setLines(i);
        if (this.nnT != null) {
            this.nnT.mo36384wP(i);
        }
        AppMethodBeat.m2505o(112359);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.m2504i(112360);
        super.setMaxLines(i);
        if (this.nnT != null) {
            this.nnT.mo36384wP(i);
        }
        AppMethodBeat.m2505o(112360);
    }

    public C21045a getAutofitHelper() {
        return this.nnT;
    }

    public void setSizeToFit(boolean z) {
        AppMethodBeat.m2504i(112361);
        this.nnT.mo36381hV(z);
        AppMethodBeat.m2505o(112361);
    }

    public float getMaxTextSize() {
        return this.nnT.noa;
    }

    public void setMaxTextSize(float f) {
        AppMethodBeat.m2504i(112362);
        C21045a c21045a = this.nnT;
        Context context = c21045a.f4384sW.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f, system.getDisplayMetrics());
        if (applyDimension != c21045a.noa) {
            c21045a.noa = applyDimension;
            c21045a.bFJ();
        }
        AppMethodBeat.m2505o(112362);
    }

    public float getMinTextSize() {
        return this.nnT.nnZ;
    }

    public void setMinTextSize(int i) {
        AppMethodBeat.m2504i(112363);
        this.nnT.mo36382n(2, (float) i);
        AppMethodBeat.m2505o(112363);
    }

    public float getPrecision() {
        return this.nnT.nob;
    }

    public void setPrecision(float f) {
        AppMethodBeat.m2504i(112364);
        this.nnT.mo36379aD(f);
        AppMethodBeat.m2505o(112364);
    }
}
