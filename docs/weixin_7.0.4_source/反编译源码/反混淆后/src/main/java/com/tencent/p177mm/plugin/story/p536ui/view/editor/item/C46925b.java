package com.tencent.p177mm.plugin.story.p536ui.view.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.media.editor.p1203c.C42171c;
import com.tencent.p177mm.media.editor.p252a.C26382a;
import com.tencent.p177mm.media.editor.p252a.C26384d;
import com.tencent.p177mm.media.editor.p252a.C37890g;
import com.tencent.p177mm.media.editor.p252a.C45427f;
import com.tencent.p177mm.media.editor.p252a.C45428h;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.media.editor.view.C1773a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.gif.C36775h;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.EditorItemContainer.C22305b;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0011H\u0016J\u000e\u00100\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0011H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/IEditView;", "context", "Landroid/content/Context;", "isReshow", "", "(Landroid/content/Context;Z)V", "TAG", "", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "()Z", "setReshow", "(Z)V", "newRect", "Landroid/graphics/Rect;", "stateResolve", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getContentBoundary", "", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "setStateResolve", "setValidArea", "validRect", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.b */
public final class C46925b extends BaseEmojiView implements C45428h, C43664c {
    private final String TAG = "MicroMsg.EmojiItemView";
    private final C42171c lkf = new C42171c();
    private final C1773a smB;
    private C22305b smC;
    private Matrix smG;
    private Rect smZ = new Rect();
    private boolean sna;

    public C46925b(Context context, boolean z) {
        super(context);
        AppMethodBeat.m2504i(110675);
        this.sna = z;
        Resources resources = getResources();
        C25052j.m39375o(resources, "resources");
        this.smB = new C1773a(resources);
        AppMethodBeat.m2505o(110675);
    }

    public final void setReshow(boolean z) {
        this.sna = z;
    }

    public final Matrix getViewMatrix() {
        return this.smG;
    }

    public final void setViewMatrix(Matrix matrix) {
        AppMethodBeat.m2504i(110664);
        if (C25052j.m39373j(this.smG, matrix)) {
            AppMethodBeat.m2505o(110664);
            return;
        }
        if (matrix != null) {
            this.lkf.setMatrix(matrix);
        }
        AppMethodBeat.m2505o(110664);
    }

    public final void setValidArea(Rect rect) {
        AppMethodBeat.m2504i(110665);
        C25052j.m39376p(rect, "validRect");
        this.smZ = rect;
        this.lkf.aKk.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) / 2.0f);
        AppMethodBeat.m2505o(110665);
    }

    public final void setStateResolve(C22305b c22305b) {
        AppMethodBeat.m2504i(110666);
        C25052j.m39376p(c22305b, "stateResolve");
        this.smC = c22305b;
        AppMethodBeat.m2505o(110666);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(110667);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        canvas.save();
        canvas.setMatrix(this.lkf.aKk);
        if (isActivated()) {
            this.smB.draw(canvas);
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restore();
        AppMethodBeat.m2505o(110667);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(110668);
        C25052j.m39376p(motionEvent, "event");
        boolean u = this.lkf.mo67716u(motionEvent);
        if (u) {
            C22305b c22305b = this.smC;
            if (c22305b != null) {
                c22305b.mo26047e(this, motionEvent);
            }
            bringToFront();
            postInvalidate();
        }
        AppMethodBeat.m2505o(110668);
        return u;
    }

    public final void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(110669);
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (!this.sna) {
                this.lkf.width = intrinsicWidth;
                this.lkf.height = intrinsicHeight;
                this.lkf.aKk.postTranslate(((float) (-intrinsicWidth)) / 2.0f, ((float) (-intrinsicHeight)) / 2.0f);
            }
            this.smB.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lkf.mo67714h(new float[]{0.0f, 0.0f, (float) intrinsicWidth, 0.0f, 0.0f, (float) intrinsicHeight, (float) intrinsicWidth, (float) intrinsicHeight});
        }
        super.setImageDrawable(drawable);
        AppMethodBeat.m2505o(110669);
    }

    /* renamed from: UI */
    public final C9584b mo26048UI() {
        AppMethodBeat.m2504i(110670);
        Drawable drawable;
        C44941v c44941v;
        C9584b c26384d;
        if (getEmojiInfo() == null) {
            AppMethodBeat.m2505o(110670);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            drawable = getDrawable();
            if (drawable == null) {
                c44941v = new C44941v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                AppMethodBeat.m2505o(110670);
                throw c44941v;
            }
            c26384d = new C26384d(((BitmapDrawable) drawable).getBitmap(), this.lkf.aKk);
            AppMethodBeat.m2505o(110670);
            return c26384d;
        } else {
            float f = 1.0f;
            if (getDrawable() instanceof C3266d) {
                drawable = getDrawable();
                if (drawable == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.m2505o(110670);
                    throw c44941v;
                }
                f = ((C3266d) drawable).getEmojiDensityScale();
            } else if (getDrawable() instanceof C36775h) {
                drawable = getDrawable();
                if (drawable == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.m2505o(110670);
                    throw c44941v;
                }
                f = ((C36775h) drawable).getEmojiDensityScale();
            }
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            matrix.postConcat(this.lkf.aKk);
            EmojiInfo emojiInfo = getEmojiInfo();
            if (emojiInfo == null) {
                C25052j.dWJ();
            }
            c26384d = new C45427f(emojiInfo, matrix);
            AppMethodBeat.m2505o(110670);
            return c26384d;
        }
    }

    /* renamed from: UJ */
    public final C26382a mo26049UJ() {
        AppMethodBeat.m2504i(110671);
        C26382a c37890g;
        if (getEmojiInfo() == null) {
            AppMethodBeat.m2505o(110671);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            c37890g = new C37890g(getEmojiInfo(), this.lkf.aKk, this.lkf.aKk);
            AppMethodBeat.m2505o(110671);
            return c37890g;
        } else {
            float f = 1.0f;
            Drawable drawable;
            C44941v c44941v;
            if (getDrawable() instanceof C3266d) {
                drawable = getDrawable();
                if (drawable == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.m2505o(110671);
                    throw c44941v;
                }
                f = ((C3266d) drawable).getEmojiDensityScale();
            } else if (getDrawable() instanceof C36775h) {
                drawable = getDrawable();
                if (drawable == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.m2505o(110671);
                    throw c44941v;
                }
                f = ((C36775h) drawable).getEmojiDensityScale();
            }
            Matrix matrix = new Matrix();
            Matrix matrix2 = new Matrix();
            matrix2.set(this.lkf.aKk);
            matrix.setScale(f, f);
            matrix.postConcat(this.lkf.aKk);
            c37890g = new C37890g(getEmojiInfo(), matrix2, matrix);
            AppMethodBeat.m2505o(110671);
            return c37890g;
        }
    }

    public final void setSafeArea(Rect rect) {
        AppMethodBeat.m2504i(110672);
        C25052j.m39376p(rect, "safeRect");
        this.lkf.eUN = rect;
        this.lkf.eUO = C1338a.fromDPToPix(getContext(), 54);
        AppMethodBeat.m2505o(110672);
    }

    public final Rect getSafeArea() {
        AppMethodBeat.m2504i(110673);
        Rect rect = this.lkf.eUN;
        if (rect == null) {
            Resources resources = getResources();
            C25052j.m39375o(resources, "resources");
            int i = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = getResources();
            C25052j.m39375o(resources2, "resources");
            rect = new Rect(0, 0, i, resources2.getDisplayMetrics().heightPixels);
        }
        AppMethodBeat.m2505o(110673);
        return rect;
    }

    public final float[] getContentBoundary() {
        AppMethodBeat.m2504i(110674);
        float[] fArr = (float[]) this.lkf.eUT.clone();
        AppMethodBeat.m2505o(110674);
        return fArr;
    }
}
