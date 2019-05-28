package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.pluginsdk.ui.e.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class AsyncTextView extends TextView implements Runnable {
    private Context context;
    private int klY;
    private String rgY;
    private boolean rgZ;
    private String rha;
    private a rhb;
    private boolean rhc;
    private String userName;

    public AsyncTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void a(String str, String str2, a aVar, boolean z, String str3, int i, boolean z2) {
        AppMethodBeat.i(38144);
        this.userName = str;
        this.rgY = str2;
        this.klY = i;
        this.rgZ = z;
        this.rha = str3;
        this.rhb = aVar;
        this.rhc = z2;
        run();
        AppMethodBeat.o(38144);
    }

    public void run() {
        AppMethodBeat.i(38145);
        if (getTag() instanceof String) {
            if (!(bo.Q((String) getTag(), this.userName) || this.rgZ || !r0.equals(this.userName))) {
                AppMethodBeat.o(38145);
                return;
            }
        }
        int i = this.klY == 10 ? 3 : 2;
        o oVar = new o(new com.tencent.mm.plugin.sns.data.a(this.rgZ, this.userName, this.rha, 1), this.rhb, i);
        Context context = getContext();
        String str = this.rgY;
        getTextSize();
        k kVar = new k(j.c(context, str, i));
        kVar.a(oVar, this.rgY, 0);
        setText(kVar, BufferType.SPANNABLE);
        setTag(this.userName);
        AppMethodBeat.o(38145);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(38146);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.o(38146);
        } catch (Throwable th) {
            AppMethodBeat.o(38146);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(38147);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(38147);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AsyncTextView", th, "", new Object[0]);
            AppMethodBeat.o(38147);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(38148);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(38148);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(38148);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(38149);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(38149);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(38149);
            return true;
        }
    }
}
