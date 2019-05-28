package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.media.editor.a.d;
import com.tencent.mm.media.editor.a.f;
import com.tencent.mm.media.editor.a.g;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.media.editor.view.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0011H\u0016J\u000e\u00100\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0011H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/IEditView;", "context", "Landroid/content/Context;", "isReshow", "", "(Landroid/content/Context;Z)V", "TAG", "", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "()Z", "setReshow", "(Z)V", "newRect", "Landroid/graphics/Rect;", "stateResolve", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getContentBoundary", "", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "setStateResolve", "setValidArea", "validRect", "plugin-story_release"})
public final class b extends BaseEmojiView implements h, c {
    private final String TAG = "MicroMsg.EmojiItemView";
    private final c lkf = new c();
    private final a smB;
    private com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.b smC;
    private Matrix smG;
    private Rect smZ = new Rect();
    private boolean sna;

    public b(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(110675);
        this.sna = z;
        Resources resources = getResources();
        j.o(resources, "resources");
        this.smB = new a(resources);
        AppMethodBeat.o(110675);
    }

    public final void setReshow(boolean z) {
        this.sna = z;
    }

    public final Matrix getViewMatrix() {
        return this.smG;
    }

    public final void setViewMatrix(Matrix matrix) {
        AppMethodBeat.i(110664);
        if (j.j(this.smG, matrix)) {
            AppMethodBeat.o(110664);
            return;
        }
        if (matrix != null) {
            this.lkf.setMatrix(matrix);
        }
        AppMethodBeat.o(110664);
    }

    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(110665);
        j.p(rect, "validRect");
        this.smZ = rect;
        this.lkf.aKk.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) / 2.0f);
        AppMethodBeat.o(110665);
    }

    public final void setStateResolve(com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.b bVar) {
        AppMethodBeat.i(110666);
        j.p(bVar, "stateResolve");
        this.smC = bVar;
        AppMethodBeat.o(110666);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(110667);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
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
        AppMethodBeat.o(110667);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(110668);
        j.p(motionEvent, "event");
        boolean u = this.lkf.u(motionEvent);
        if (u) {
            com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.b bVar = this.smC;
            if (bVar != null) {
                bVar.e(this, motionEvent);
            }
            bringToFront();
            postInvalidate();
        }
        AppMethodBeat.o(110668);
        return u;
    }

    public final void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(110669);
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (!this.sna) {
                this.lkf.width = intrinsicWidth;
                this.lkf.height = intrinsicHeight;
                this.lkf.aKk.postTranslate(((float) (-intrinsicWidth)) / 2.0f, ((float) (-intrinsicHeight)) / 2.0f);
            }
            this.smB.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lkf.h(new float[]{0.0f, 0.0f, (float) intrinsicWidth, 0.0f, 0.0f, (float) intrinsicHeight, (float) intrinsicWidth, (float) intrinsicHeight});
        }
        super.setImageDrawable(drawable);
        AppMethodBeat.o(110669);
    }

    public final com.tencent.mm.media.editor.a.b UI() {
        AppMethodBeat.i(110670);
        Drawable drawable;
        v vVar;
        com.tencent.mm.media.editor.a.b dVar;
        if (getEmojiInfo() == null) {
            AppMethodBeat.o(110670);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            drawable = getDrawable();
            if (drawable == null) {
                vVar = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                AppMethodBeat.o(110670);
                throw vVar;
            }
            dVar = new d(((BitmapDrawable) drawable).getBitmap(), this.lkf.aKk);
            AppMethodBeat.o(110670);
            return dVar;
        } else {
            float f = 1.0f;
            if (getDrawable() instanceof com.tencent.mm.plugin.gif.d) {
                drawable = getDrawable();
                if (drawable == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.o(110670);
                    throw vVar;
                }
                f = ((com.tencent.mm.plugin.gif.d) drawable).getEmojiDensityScale();
            } else if (getDrawable() instanceof com.tencent.mm.plugin.gif.h) {
                drawable = getDrawable();
                if (drawable == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.o(110670);
                    throw vVar;
                }
                f = ((com.tencent.mm.plugin.gif.h) drawable).getEmojiDensityScale();
            }
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            matrix.postConcat(this.lkf.aKk);
            EmojiInfo emojiInfo = getEmojiInfo();
            if (emojiInfo == null) {
                j.dWJ();
            }
            dVar = new f(emojiInfo, matrix);
            AppMethodBeat.o(110670);
            return dVar;
        }
    }

    public final com.tencent.mm.media.editor.a.a UJ() {
        AppMethodBeat.i(110671);
        com.tencent.mm.media.editor.a.a gVar;
        if (getEmojiInfo() == null) {
            AppMethodBeat.o(110671);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            gVar = new g(getEmojiInfo(), this.lkf.aKk, this.lkf.aKk);
            AppMethodBeat.o(110671);
            return gVar;
        } else {
            float f = 1.0f;
            Drawable drawable;
            v vVar;
            if (getDrawable() instanceof com.tencent.mm.plugin.gif.d) {
                drawable = getDrawable();
                if (drawable == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.o(110671);
                    throw vVar;
                }
                f = ((com.tencent.mm.plugin.gif.d) drawable).getEmojiDensityScale();
            } else if (getDrawable() instanceof com.tencent.mm.plugin.gif.h) {
                drawable = getDrawable();
                if (drawable == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.o(110671);
                    throw vVar;
                }
                f = ((com.tencent.mm.plugin.gif.h) drawable).getEmojiDensityScale();
            }
            Matrix matrix = new Matrix();
            Matrix matrix2 = new Matrix();
            matrix2.set(this.lkf.aKk);
            matrix.setScale(f, f);
            matrix.postConcat(this.lkf.aKk);
            gVar = new g(getEmojiInfo(), matrix2, matrix);
            AppMethodBeat.o(110671);
            return gVar;
        }
    }

    public final void setSafeArea(Rect rect) {
        AppMethodBeat.i(110672);
        j.p(rect, "safeRect");
        this.lkf.eUN = rect;
        this.lkf.eUO = com.tencent.mm.bz.a.fromDPToPix(getContext(), 54);
        AppMethodBeat.o(110672);
    }

    public final Rect getSafeArea() {
        AppMethodBeat.i(110673);
        Rect rect = this.lkf.eUN;
        if (rect == null) {
            Resources resources = getResources();
            j.o(resources, "resources");
            int i = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = getResources();
            j.o(resources2, "resources");
            rect = new Rect(0, 0, i, resources2.getDisplayMetrics().heightPixels);
        }
        AppMethodBeat.o(110673);
        return rect;
    }

    public final float[] getContentBoundary() {
        AppMethodBeat.i(110674);
        float[] fArr = (float[]) this.lkf.eUT.clone();
        AppMethodBeat.o(110674);
        return fArr;
    }
}
