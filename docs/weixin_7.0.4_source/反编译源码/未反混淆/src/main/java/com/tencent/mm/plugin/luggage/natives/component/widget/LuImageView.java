package com.tencent.mm.plugin.luggage.natives.component.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuImageView extends AppCompatImageView {
    public LuImageView(Context context) {
        super(context);
    }

    public LuImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LuImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        Path path;
        AppMethodBeat.i(116891);
        Drawable background = getBackground();
        if (background instanceof a) {
            a aVar = (a) background;
            if (aVar.oiI == null) {
                aVar.oiI = aVar.bMS();
                if (aVar.oiI == null) {
                    path = null;
                }
            }
            path = aVar.j(aVar.oiI);
        } else {
            path = null;
        }
        if (path != null) {
            canvas.save();
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
        if (path != null) {
            canvas.restore();
        }
        AppMethodBeat.o(116891);
    }
}
