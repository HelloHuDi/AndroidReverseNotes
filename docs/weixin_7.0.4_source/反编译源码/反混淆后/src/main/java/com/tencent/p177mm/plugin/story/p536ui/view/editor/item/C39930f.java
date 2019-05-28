package com.tencent.p177mm.plugin.story.p536ui.view.editor.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.media.editor.p252a.C37889e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.PhotoEditText;
import com.tencent.smtt.sdk.WebView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ(\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "textSize", "", "createBitmap", "Landroid/graphics/Bitmap;", "text", "", "textColor", "", "textBgColor", "reshowText", "", "viewMatrix", "Landroid/graphics/Matrix;", "setText", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.f */
public final class C39930f extends C13878a {
    private final float eOg = getResources().getDimension(C25738R.dimen.a02);

    public C39930f(Context context) {
        super(context);
        AppMethodBeat.m2504i(110697);
        AppMethodBeat.m2505o(110697);
    }

    public final void setValidArea(Rect rect) {
        AppMethodBeat.m2504i(110693);
        C25052j.m39376p(rect, "validRect");
        getTouchTracker().aKk.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) * 0.7f);
        AppMethodBeat.m2505o(110693);
    }

    public final void setText(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.m2504i(110694);
        Bitmap f = mo63128f(charSequence, i, i2);
        setText(charSequence);
        setSourceDataType(C37889e.TEXT);
        setColor(i);
        setTextBg(i2);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            getTouchTracker().aKk.preTranslate(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        }
        setBitmap(f);
        postInvalidate();
        AppMethodBeat.m2505o(110694);
    }

    /* renamed from: a */
    public final void mo63127a(CharSequence charSequence, int i, int i2, Matrix matrix) {
        AppMethodBeat.m2504i(110695);
        C25052j.m39376p(matrix, "viewMatrix");
        setText(charSequence, i, i2);
        setViewMatrix(matrix);
        setSourceDataType(C37889e.TEXT);
        AppMethodBeat.m2505o(110695);
    }

    /* renamed from: f */
    public final Bitmap mo63128f(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.m2504i(110696);
        setSourceDataType(C37889e.TEXT);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        PhotoEditText photoEditText = new PhotoEditText(context);
        int fromDPToPix = C1338a.fromDPToPix(getContext(), 16);
        int fromDPToPix2 = C1338a.fromDPToPix(getContext(), 8);
        photoEditText.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
        photoEditText.setTextColor(i);
        photoEditText.setTextBackground(i2);
        photoEditText.setTextSize(0, this.eOg);
        photoEditText.setText(charSequence);
        photoEditText.setSingleLine(false);
        photoEditText.setTypeface(photoEditText.getTypeface(), 1);
        if (i2 == 0 && i != WebView.NIGHT_MODE_COLOR) {
            C8902b.m16047f(photoEditText);
        }
        C22210l c22210l = C22210l.sac;
        int width = C22210l.czI().width();
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
        C25052j.m39375o(createBitmap, "bitmap");
        AppMethodBeat.m2505o(110696);
        return createBitmap;
    }
}
