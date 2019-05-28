package com.tencent.p177mm.plugin.facedetectaction.p404ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask */
public class FaceActionMask extends RelativeLayout {
    private Paint mcJ = new Paint(1);
    private Paint mcK;
    private PorterDuffXfermode mcL;
    private boolean mcM = false;
    private Rect rect = new Rect();

    public FaceActionMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(707);
        this.mcJ.setStyle(Style.FILL);
        this.mcK = new Paint(1);
        setWillNotDraw(false);
        this.mcL = new PorterDuffXfermode(Mode.CLEAR);
        setLayerType(1, null);
        AppMethodBeat.m2505o(707);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(708);
        canvas.save();
        float width = (float) (((double) getWidth()) * 0.35d);
        float width2 = (float) (((double) getWidth()) * 0.5d);
        float height = (float) (((double) getHeight()) * 0.4d);
        this.rect.left = 0;
        this.rect.right = getWidth();
        this.rect.top = 0;
        this.rect.bottom = getHeight();
        this.mcJ.setColor(-1);
        canvas.drawARGB(255, 0, 0, 0);
        canvas.drawRect(this.rect, this.mcJ);
        if (!this.mcM) {
            this.mcK.setStyle(Style.FILL_AND_STROKE);
            this.mcK.setXfermode(this.mcL);
            canvas.drawCircle(width2, height, width, this.mcK);
        }
        canvas.restore();
        AppMethodBeat.m2505o(708);
    }
}
