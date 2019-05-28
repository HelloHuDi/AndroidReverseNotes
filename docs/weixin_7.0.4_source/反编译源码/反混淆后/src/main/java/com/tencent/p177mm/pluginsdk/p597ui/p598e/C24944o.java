package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.o */
public class C24944o extends C23322n {
    private Object tag;
    private C24945a vsx;

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.o$a */
    public interface C24945a {
        /* renamed from: a */
        void mo25466a(View view, Object obj);
    }

    public C24944o(Object obj, C24945a c24945a) {
        super(2, null);
        this.vsx = c24945a;
        this.tag = obj;
    }

    public C24944o(Object obj, C24945a c24945a, int i) {
        super(2, null);
        AppMethodBeat.m2504i(40543);
        this.vsx = c24945a;
        this.tag = obj;
        mo39044Hy(i);
        AppMethodBeat.m2505o(40543);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(40544);
        if (this.vsx != null) {
            this.vsx.mo25466a(view, this.tag);
        }
        AppMethodBeat.m2505o(40544);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.m2504i(40545);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        AppMethodBeat.m2505o(40545);
    }
}
