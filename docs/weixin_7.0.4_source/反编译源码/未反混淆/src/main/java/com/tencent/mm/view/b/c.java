package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.b;

public final class c extends a {
    public c(Context context, b bVar) {
        super(context, bVar);
    }

    public final Rect getAliveRect() {
        AppMethodBeat.i(116421);
        Rect boardRect;
        if (super.getAliveRect().isEmpty()) {
            boardRect = getBoardRect();
            AppMethodBeat.o(116421);
            return boardRect;
        }
        boardRect = super.getAliveRect();
        AppMethodBeat.o(116421);
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
        AppMethodBeat.i(116422);
        canvas.drawColor(0);
        canvas.setMatrix(this.cjd);
        getPresenter().onDraw(canvas);
        AppMethodBeat.o(116422);
    }
}
