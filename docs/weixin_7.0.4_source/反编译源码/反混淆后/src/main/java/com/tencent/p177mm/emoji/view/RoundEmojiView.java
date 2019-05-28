package com.tencent.p177mm.emoji.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/emoji/view/RoundEmojiView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.view.RoundEmojiView */
public final class RoundEmojiView extends BaseEmojiView {
    private final Path eAv;
    private final RectF rect;

    public RoundEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(63326);
        this.eAv = new Path();
        this.rect = new RectF();
        AppMethodBeat.m2505o(63326);
    }

    public RoundEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final Path getPath() {
        return this.eAv;
    }

    public final RectF getRect() {
        return this.rect;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDraw(Canvas canvas) {
        RectF rectF;
        int measuredWidth;
        Drawable drawable;
        float f;
        int measuredHeight;
        Drawable drawable2;
        float f2;
        int measuredWidth2;
        Drawable drawable3;
        float f3;
        AppMethodBeat.m2504i(63325);
        int measuredWidth3 = getMeasuredWidth();
        Drawable drawable4 = getDrawable();
        C25052j.m39375o(drawable4, "drawable");
        if (measuredWidth3 >= drawable4.getBounds().right) {
            measuredWidth3 = getMeasuredHeight();
            drawable4 = getDrawable();
            C25052j.m39375o(drawable4, "drawable");
            if (measuredWidth3 >= drawable4.getBounds().bottom) {
                rectF = this.rect;
                measuredWidth = getMeasuredWidth();
                drawable = getDrawable();
                C25052j.m39375o(drawable, "drawable");
                f = ((float) (measuredWidth - drawable.getBounds().right)) / 2.0f;
                measuredHeight = getMeasuredHeight();
                drawable2 = getDrawable();
                C25052j.m39375o(drawable2, "drawable");
                f2 = ((float) (measuredHeight - drawable2.getBounds().bottom)) / 2.0f;
                measuredWidth2 = getMeasuredWidth();
                drawable3 = getDrawable();
                C25052j.m39375o(drawable3, "drawable");
                f3 = ((float) (measuredWidth2 - drawable3.getBounds().right)) / 2.0f;
                drawable3 = getDrawable();
                C25052j.m39375o(drawable3, "drawable");
                f3 += (float) drawable3.getBounds().right;
                int measuredHeight2 = getMeasuredHeight();
                Drawable drawable5 = getDrawable();
                C25052j.m39375o(drawable5, "drawable");
                float f4 = ((float) (measuredHeight2 - drawable5.getBounds().bottom)) / 2.0f;
                drawable5 = getDrawable();
                C25052j.m39375o(drawable5, "drawable");
                rectF.set(f, f2, f3, f4 + ((float) drawable5.getBounds().bottom));
                this.eAv.addRoundRect(this.rect, ((float) getMeasuredWidth()) / 10.0f, ((float) getMeasuredHeight()) / 10.0f, Direction.CW);
                if (canvas != null) {
                    canvas.save();
                }
                if (canvas != null) {
                    canvas.clipPath(this.eAv);
                }
                super.onDraw(canvas);
                if (canvas == null) {
                    canvas.restore();
                    AppMethodBeat.m2505o(63325);
                    return;
                }
                AppMethodBeat.m2505o(63325);
                return;
            }
        }
        measuredWidth3 = getMeasuredWidth();
        drawable4 = getDrawable();
        C25052j.m39375o(drawable4, "drawable");
        if (measuredWidth3 >= drawable4.getBounds().right) {
            rectF = this.rect;
            measuredWidth = getMeasuredWidth();
            drawable = getDrawable();
            C25052j.m39375o(drawable, "drawable");
            f = ((float) (measuredWidth - drawable.getBounds().right)) / 2.0f;
            measuredHeight = getMeasuredWidth();
            drawable2 = getDrawable();
            C25052j.m39375o(drawable2, "drawable");
            f2 = ((float) (measuredHeight - drawable2.getBounds().right)) / 2.0f;
            drawable2 = getDrawable();
            C25052j.m39375o(drawable2, "drawable");
            rectF.set(f, 0.0f, f2 + ((float) drawable2.getBounds().right), (float) getMeasuredHeight());
        } else {
            measuredWidth3 = getMeasuredHeight();
            drawable4 = getDrawable();
            C25052j.m39375o(drawable4, "drawable");
            if (measuredWidth3 >= drawable4.getBounds().bottom) {
                rectF = this.rect;
                measuredWidth = getMeasuredHeight();
                drawable = getDrawable();
                C25052j.m39375o(drawable, "drawable");
                f = ((float) (measuredWidth - drawable.getBounds().bottom)) / 2.0f;
                f2 = (float) getMeasuredWidth();
                measuredWidth2 = getMeasuredHeight();
                drawable3 = getDrawable();
                C25052j.m39375o(drawable3, "drawable");
                f3 = ((float) (measuredWidth2 - drawable3.getBounds().bottom)) / 2.0f;
                drawable3 = getDrawable();
                C25052j.m39375o(drawable3, "drawable");
                rectF.set(0.0f, f, f2, f3 + ((float) drawable3.getBounds().bottom));
            } else {
                this.rect.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
            }
        }
        this.eAv.addRoundRect(this.rect, ((float) getMeasuredWidth()) / 10.0f, ((float) getMeasuredHeight()) / 10.0f, Direction.CW);
        if (canvas != null) {
        }
        if (canvas != null) {
        }
        super.onDraw(canvas);
        if (canvas == null) {
        }
    }
}
