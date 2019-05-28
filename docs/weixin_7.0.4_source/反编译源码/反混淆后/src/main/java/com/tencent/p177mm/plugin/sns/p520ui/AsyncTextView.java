package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.data.C13357a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o.C24945a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.AsyncTextView */
public class AsyncTextView extends TextView implements Runnable {
    private Context context;
    private int klY;
    private String rgY;
    private boolean rgZ;
    private String rha;
    private C24945a rhb;
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

    /* renamed from: a */
    public final void mo47236a(String str, String str2, C24945a c24945a, boolean z, String str3, int i, boolean z2) {
        AppMethodBeat.m2504i(38144);
        this.userName = str;
        this.rgY = str2;
        this.klY = i;
        this.rgZ = z;
        this.rha = str3;
        this.rhb = c24945a;
        this.rhc = z2;
        run();
        AppMethodBeat.m2505o(38144);
    }

    public void run() {
        AppMethodBeat.m2504i(38145);
        if (getTag() instanceof String) {
            if (!(C5046bo.m7510Q((String) getTag(), this.userName) || this.rgZ || !r0.equals(this.userName))) {
                AppMethodBeat.m2505o(38145);
                return;
            }
        }
        int i = this.klY == 10 ? 3 : 2;
        C24944o c24944o = new C24944o(new C13357a(this.rgZ, this.userName, this.rha, 1), this.rhb, i);
        Context context = getContext();
        String str = this.rgY;
        getTextSize();
        C44090k c44090k = new C44090k(C44089j.m79298c(context, str, i));
        c44090k.mo69792a(c24944o, this.rgY, 0);
        setText(c44090k, BufferType.SPANNABLE);
        setTag(this.userName);
        AppMethodBeat.m2505o(38145);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(38146);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(38146);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(38146);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(38147);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(38147);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AsyncTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(38147);
        }
    }

    public int getBaseline() {
        AppMethodBeat.m2504i(38148);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.m2505o(38148);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(38148);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.m2504i(38149);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.m2505o(38149);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(38149);
            return true;
        }
    }
}
