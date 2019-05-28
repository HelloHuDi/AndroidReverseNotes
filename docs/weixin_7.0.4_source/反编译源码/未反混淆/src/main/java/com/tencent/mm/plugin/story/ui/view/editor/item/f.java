package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.b;
import com.tencent.mm.bz.a;
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.plugin.story.ui.view.editor.PhotoEditText;
import com.tencent.smtt.sdk.WebView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ(\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "textSize", "", "createBitmap", "Landroid/graphics/Bitmap;", "text", "", "textColor", "", "textBgColor", "reshowText", "", "viewMatrix", "Landroid/graphics/Matrix;", "setText", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-story_release"})
public final class f extends a {
    private final float eOg = getResources().getDimension(R.dimen.a02);

    public f(Context context) {
        super(context);
        AppMethodBeat.i(110697);
        AppMethodBeat.o(110697);
    }

    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(110693);
        j.p(rect, "validRect");
        getTouchTracker().aKk.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) * 0.7f);
        AppMethodBeat.o(110693);
    }

    public final void setText(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.i(110694);
        Bitmap f = f(charSequence, i, i2);
        setText(charSequence);
        setSourceDataType(e.TEXT);
        setColor(i);
        setTextBg(i2);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            getTouchTracker().aKk.preTranslate(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        }
        setBitmap(f);
        postInvalidate();
        AppMethodBeat.o(110694);
    }

    public final void a(CharSequence charSequence, int i, int i2, Matrix matrix) {
        AppMethodBeat.i(110695);
        j.p(matrix, "viewMatrix");
        setText(charSequence, i, i2);
        setViewMatrix(matrix);
        setSourceDataType(e.TEXT);
        AppMethodBeat.o(110695);
    }

    public final Bitmap f(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.i(110696);
        setSourceDataType(e.TEXT);
        Context context = getContext();
        j.o(context, "context");
        PhotoEditText photoEditText = new PhotoEditText(context);
        int fromDPToPix = a.fromDPToPix(getContext(), 16);
        int fromDPToPix2 = a.fromDPToPix(getContext(), 8);
        photoEditText.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
        photoEditText.setTextColor(i);
        photoEditText.setTextBackground(i2);
        photoEditText.setTextSize(0, this.eOg);
        photoEditText.setText(charSequence);
        photoEditText.setSingleLine(false);
        photoEditText.setTypeface(photoEditText.getTypeface(), 1);
        if (i2 == 0 && i != WebView.NIGHT_MODE_COLOR) {
            b.f(photoEditText);
        }
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
        int width = com.tencent.mm.plugin.story.f.l.czI().width();
        if (width > 0) {
            photoEditText.setMaxWidth(width);
        }
        photoEditText.measure(0, 0);
        Bitmap createBitmap = Bitmap.createBitmap(photoEditText.getMeasuredWidth(), photoEditText.getMeasuredHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        photoEditText.draw(canvas);
        canvas.save();
        canvas.translate((float) fromDPToPix, (float) fromDPToPix2);
        photoEditText.getLayout().draw(canvas);
        canvas.restore();
        j.o(createBitmap, "bitmap");
        AppMethodBeat.o(110696);
        return createBitmap;
    }
}
