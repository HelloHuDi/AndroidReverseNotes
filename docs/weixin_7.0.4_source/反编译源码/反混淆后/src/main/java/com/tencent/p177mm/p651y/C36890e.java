package com.tencent.p177mm.p651y;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.view.PhotoEditText;

/* renamed from: com.tencent.mm.y.e */
public final class C36890e extends C36398c {
    private static final float eHB = C4996ah.getResources().getDimension(C25738R.dimen.f10374zk);
    private static final int eHC = ((int) C4996ah.getResources().getDimension(C25738R.dimen.a3t));
    private static final int eHD = ((int) C4996ah.getResources().getDimension(C25738R.dimen.a77));
    /* renamed from: oz */
    private static TextPaint f15477oz;
    public int eHE = -65536;
    public SpannableString eHF;
    public int mColor = -1;

    static {
        AppMethodBeat.m2504i(116299);
        TextPaint textPaint = new TextPaint(1);
        f15477oz = textPaint;
        textPaint.setStrokeCap(Cap.ROUND);
        f15477oz.setStyle(Style.FILL);
        f15477oz.setDither(true);
        f15477oz.setTextSize(eHB);
        AppMethodBeat.m2505o(116299);
    }

    public C36890e(Context context, Matrix matrix, String str, Rect rect, SpannableString spannableString, int i, int i2) {
        super(context, matrix, str, rect);
        this.mColor = i;
        this.eHF = spannableString;
        this.eHE = i2;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Qf */
    public final Bitmap mo57316Qf() {
        AppMethodBeat.m2504i(116297);
        f15477oz.setColor(this.mColor);
        if (this.eHF == null) {
            AppMethodBeat.m2505o(116297);
            return null;
        }
        PhotoEditText photoEditText = new PhotoEditText(this.mContext);
        int al = C1338a.m2856al(this.mContext, C25738R.dimen.f10373zi);
        photoEditText.setPadding(al, 0, al, 0);
        photoEditText.setTextBackground(this.eHE);
        photoEditText.setTextColor(this.mColor);
        photoEditText.setTextSize((float) Math.round(eHB / this.mContext.getResources().getDisplayMetrics().density));
        photoEditText.setText(C44089j.m79293b(this.mContext, this.eHF, eHB / 1.3f));
        photoEditText.setSingleLine(false);
        photoEditText.setMaxWidth((int) (((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - (this.mContext.getResources().getDimension(C25738R.dimen.f10373zi) * 2.0f)));
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
        AppMethodBeat.m2505o(116297);
        return createBitmap;
    }

    public final void setSelected(boolean z) {
        AppMethodBeat.m2504i(116298);
        super.setSelected(z);
        if (!z) {
            this.eHn = false;
        }
        AppMethodBeat.m2505o(116298);
    }
}
