package com.tencent.p177mm.view.p1096b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p204br.C18117b;

/* renamed from: com.tencent.mm.view.b.c */
public final class C46717c extends C30844a {
    public C46717c(Context context, C18117b c18117b) {
        super(context, c18117b);
    }

    public final Rect getAliveRect() {
        AppMethodBeat.m2504i(116421);
        Rect boardRect;
        if (super.getAliveRect().isEmpty()) {
            boardRect = getBoardRect();
            AppMethodBeat.m2505o(116421);
            return boardRect;
        }
        boardRect = super.getAliveRect();
        AppMethodBeat.m2505o(116421);
        return boardRect;
    }

    public final boolean dMM() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dML() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116422);
        canvas.drawColor(0);
        canvas.setMatrix(this.cjd);
        getPresenter().onDraw(canvas);
        AppMethodBeat.m2505o(116422);
    }
}
