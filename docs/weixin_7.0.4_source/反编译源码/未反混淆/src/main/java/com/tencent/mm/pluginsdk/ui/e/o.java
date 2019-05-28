package com.tencent.mm.pluginsdk.ui.e;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o extends n {
    private Object tag;
    private a vsx;

    public interface a {
        void a(View view, Object obj);
    }

    public o(Object obj, a aVar) {
        super(2, null);
        this.vsx = aVar;
        this.tag = obj;
    }

    public o(Object obj, a aVar, int i) {
        super(2, null);
        AppMethodBeat.i(40543);
        this.vsx = aVar;
        this.tag = obj;
        Hy(i);
        AppMethodBeat.o(40543);
    }

    public void onClick(View view) {
        AppMethodBeat.i(40544);
        if (this.vsx != null) {
            this.vsx.a(view, this.tag);
        }
        AppMethodBeat.o(40544);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(40545);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        AppMethodBeat.o(40545);
    }
}
