package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.scanner.C21683b.C21684a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.scanner.ui.RoundCornerImageView */
public class RoundCornerImageView extends ImageView {
    private int qdE = 8;
    private int qdF = 8;

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(81143);
        init(context, attributeSet);
        AppMethodBeat.m2505o(81143);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(81144);
        init(context, attributeSet);
        AppMethodBeat.m2505o(81144);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(81145);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C21684a.RoundCornerImageView);
            this.qdE = obtainStyledAttributes.getDimensionPixelSize(0, this.qdE);
            this.qdF = obtainStyledAttributes.getDimensionPixelSize(1, this.qdF);
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(81145);
            return;
        }
        float f = context.getResources().getDisplayMetrics().density;
        this.qdE = (int) (((float) this.qdE) * f);
        this.qdF = (int) (f * ((float) this.qdF));
        AppMethodBeat.m2505o(81145);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.m2504i(81146);
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        if (createBitmap.isRecycled()) {
            createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
            canvas2 = new Canvas(createBitmap);
        }
        super.draw(canvas2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.qdE, (float) this.qdF, Direction.CW);
        path.setFillType(FillType.INVERSE_WINDING);
        canvas2.drawPath(path, paint);
        Paint paint2 = new Paint();
        paint2.setXfermode(null);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
        C4990ab.m7417i("RoundCornerImageView", "bitmap recycle %s", createBitmap.toString());
        createBitmap.recycle();
        AppMethodBeat.m2505o(81146);
    }
}
