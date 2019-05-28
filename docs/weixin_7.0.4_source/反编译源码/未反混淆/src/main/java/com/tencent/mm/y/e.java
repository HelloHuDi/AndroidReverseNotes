package com.tencent.mm.y;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.view.PhotoEditText;

public final class e extends c {
    private static final float eHB = ah.getResources().getDimension(R.dimen.zk);
    private static final int eHC = ((int) ah.getResources().getDimension(R.dimen.a3t));
    private static final int eHD = ((int) ah.getResources().getDimension(R.dimen.a77));
    private static TextPaint oz;
    public int eHE = -65536;
    public SpannableString eHF;
    public int mColor = -1;

    static {
        AppMethodBeat.i(116299);
        TextPaint textPaint = new TextPaint(1);
        oz = textPaint;
        textPaint.setStrokeCap(Cap.ROUND);
        oz.setStyle(Style.FILL);
        oz.setDither(true);
        oz.setTextSize(eHB);
        AppMethodBeat.o(116299);
    }

    public e(Context context, Matrix matrix, String str, Rect rect, SpannableString spannableString, int i, int i2) {
        super(context, matrix, str, rect);
        this.mColor = i;
        this.eHF = spannableString;
        this.eHE = i2;
    }

    /* Access modifiers changed, original: protected|final */
    public final Bitmap Qf() {
        AppMethodBeat.i(116297);
        oz.setColor(this.mColor);
        if (this.eHF == null) {
            AppMethodBeat.o(116297);
            return null;
        }
        PhotoEditText photoEditText = new PhotoEditText(this.mContext);
        int al = a.al(this.mContext, R.dimen.zi);
        photoEditText.setPadding(al, 0, al, 0);
        photoEditText.setTextBackground(this.eHE);
        photoEditText.setTextColor(this.mColor);
        photoEditText.setTextSize((float) Math.round(eHB / this.mContext.getResources().getDisplayMetrics().density));
        photoEditText.setText(j.b(this.mContext, this.eHF, eHB / 1.3f));
        photoEditText.setSingleLine(false);
        photoEditText.setMaxWidth((int) (((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - (this.mContext.getResources().getDimension(R.dimen.zi) * 2.0f)));
        photoEditText.measure(0, 0);
        Bitmap createBitmap = Bitmap.createBitmap(photoEditText.getMeasuredWidth() - al, photoEditText.getMeasuredHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        photoEditText.getLayout().getPaint().setColor(this.mColor);
        canvas.save();
        canvas.translate(-0.5f * ((float) al), 0.0f);
        photoEditText.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(((float) al) * 0.5f, 0.0f);
        photoEditText.getLayout().draw(canvas);
        canvas.restore();
        AppMethodBeat.o(116297);
        return createBitmap;
    }

    public final void setSelected(boolean z) {
        AppMethodBeat.i(116298);
        super.setSelected(z);
        if (!z) {
            this.eHn = false;
        }
        AppMethodBeat.o(116298);
    }
}
