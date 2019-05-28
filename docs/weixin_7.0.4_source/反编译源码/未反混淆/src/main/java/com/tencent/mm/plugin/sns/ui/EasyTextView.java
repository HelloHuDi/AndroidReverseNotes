package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class EasyTextView extends View {
    private static final Paint feO = new Paint();
    private static int textSize = -1;
    private Context context;
    private String text = "";

    static {
        AppMethodBeat.i(38210);
        feO.setAntiAlias(true);
        feO.setFilterBitmap(true);
        feO.setColor(737373);
        AppMethodBeat.o(38210);
    }

    public EasyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38207);
        this.context = context;
        if (textSize == -1) {
            textSize = b.b(this.context, 12.0f);
            feO.setTextSize((float) textSize);
        }
        feO.setColor(this.context.getResources().getColor(R.color.h4));
        AppMethodBeat.o(38207);
    }

    public void setTextSize(int i) {
        AppMethodBeat.i(38208);
        feO.setTextSize((float) i);
        AppMethodBeat.o(38208);
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.text = str;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(38209);
        super.draw(canvas);
        canvas.drawText(this.text, 0.0f, (float) (getHeight() / 2), feO);
        AppMethodBeat.o(38209);
    }
}
