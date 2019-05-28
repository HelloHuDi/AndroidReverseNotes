package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;

/* renamed from: com.tencent.mm.plugin.sns.ui.EasyTextView */
public class EasyTextView extends View {
    private static final Paint feO = new Paint();
    private static int textSize = -1;
    private Context context;
    private String text = "";

    static {
        AppMethodBeat.m2504i(38210);
        feO.setAntiAlias(true);
        feO.setFilterBitmap(true);
        feO.setColor(737373);
        AppMethodBeat.m2505o(38210);
    }

    public EasyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38207);
        this.context = context;
        if (textSize == -1) {
            textSize = C4977b.m7371b(this.context, 12.0f);
            feO.setTextSize((float) textSize);
        }
        feO.setColor(this.context.getResources().getColor(C25738R.color.f11782h4));
        AppMethodBeat.m2505o(38207);
    }

    public void setTextSize(int i) {
        AppMethodBeat.m2504i(38208);
        feO.setTextSize((float) i);
        AppMethodBeat.m2505o(38208);
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.text = str;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.m2504i(38209);
        super.draw(canvas);
        canvas.drawText(this.text, 0.0f, (float) (getHeight() / 2), feO);
        AppMethodBeat.m2505o(38209);
    }
}
