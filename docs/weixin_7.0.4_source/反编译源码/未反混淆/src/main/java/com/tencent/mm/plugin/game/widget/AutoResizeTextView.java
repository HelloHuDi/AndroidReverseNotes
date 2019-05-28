package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.widget.a.b;

public class AutoResizeTextView extends TextView implements b {
    private a nnT;

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112354);
        h(attributeSet);
        AppMethodBeat.o(112354);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112355);
        h(attributeSet);
        AppMethodBeat.o(112355);
    }

    private void h(AttributeSet attributeSet) {
        AppMethodBeat.i(112356);
        this.nnT = a.a(this, attributeSet).a(this);
        AppMethodBeat.o(112356);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(112357);
        super.onLayout(z, i, i2, i3, i4);
        if (this.nnT != null) {
            this.nnT.bFJ();
        }
        AppMethodBeat.o(112357);
    }

    public void setTextSize(int i, float f) {
        AppMethodBeat.i(112358);
        super.setTextSize(i, f);
        if (this.nnT != null) {
            a aVar = this.nnT;
            if (!aVar.noc) {
                Context context = aVar.sW.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                aVar.setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
            }
        }
        AppMethodBeat.o(112358);
    }

    public void setLines(int i) {
        AppMethodBeat.i(112359);
        super.setLines(i);
        if (this.nnT != null) {
            this.nnT.wP(i);
        }
        AppMethodBeat.o(112359);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.i(112360);
        super.setMaxLines(i);
        if (this.nnT != null) {
            this.nnT.wP(i);
        }
        AppMethodBeat.o(112360);
    }

    public a getAutofitHelper() {
        return this.nnT;
    }

    public void setSizeToFit(boolean z) {
        AppMethodBeat.i(112361);
        this.nnT.hV(z);
        AppMethodBeat.o(112361);
    }

    public float getMaxTextSize() {
        return this.nnT.noa;
    }

    public void setMaxTextSize(float f) {
        AppMethodBeat.i(112362);
        a aVar = this.nnT;
        Context context = aVar.sW.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f, system.getDisplayMetrics());
        if (applyDimension != aVar.noa) {
            aVar.noa = applyDimension;
            aVar.bFJ();
        }
        AppMethodBeat.o(112362);
    }

    public float getMinTextSize() {
        return this.nnT.nnZ;
    }

    public void setMinTextSize(int i) {
        AppMethodBeat.i(112363);
        this.nnT.n(2, (float) i);
        AppMethodBeat.o(112363);
    }

    public float getPrecision() {
        return this.nnT.nob;
    }

    public void setPrecision(float f) {
        AppMethodBeat.i(112364);
        this.nnT.aD(f);
        AppMethodBeat.o(112364);
    }
}
