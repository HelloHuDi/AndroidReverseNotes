package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.d;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001cH\u0016J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/BitmapEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "handleRemove", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "resume", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class BitmapEditorItemView extends View implements b {
    private Bitmap bitmap;
    private final a lmS;

    public BitmapEditorItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(3024);
        this.lmS = new com.tencent.mm.plugin.emojicapture.e.b(this);
        AppMethodBeat.o(3024);
    }

    public final com.tencent.mm.media.editor.a.a UJ() {
        return null;
    }

    public BitmapEditorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        AppMethodBeat.i(3017);
        this.bitmap = bitmap;
        if (bitmap != null) {
            this.lmS.dV(bitmap.getWidth(), bitmap.getHeight());
        }
        AppMethodBeat.o(3017);
    }

    public final void resume() {
    }

    public final void pause() {
    }

    public final void a(RectF rectF, float f) {
        AppMethodBeat.i(3018);
        j.p(rectF, "bounds");
        this.lmS.a(rectF, f);
        AppMethodBeat.o(3018);
    }

    public final void setEditing(boolean z) {
        AppMethodBeat.i(3019);
        this.lmS.setEditing(z);
        invalidate();
        AppMethodBeat.o(3019);
    }

    public final boolean bob() {
        return false;
    }

    public final EditorItemContainer getItemContainer() {
        AppMethodBeat.i(3020);
        if (getParent() instanceof EditorItemContainer) {
            ViewParent parent = getParent();
            if (parent == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
                AppMethodBeat.o(3020);
                throw vVar;
            }
            EditorItemContainer editorItemContainer = (EditorItemContainer) parent;
            AppMethodBeat.o(3020);
            return editorItemContainer;
        }
        AppMethodBeat.o(3020);
        return null;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3021);
        j.p(motionEvent, "event");
        boolean G = this.lmS.G(motionEvent);
        AppMethodBeat.o(3021);
        return G;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(3022);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        canvas.save();
        this.lmS.h(canvas);
        if (this.bitmap != null) {
            canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, null);
        }
        canvas.restore();
        AppMethodBeat.o(3022);
    }

    public final com.tencent.mm.media.editor.a.b UI() {
        AppMethodBeat.i(3023);
        if (this.bitmap == null) {
            AppMethodBeat.o(3023);
            return null;
        }
        com.tencent.mm.media.editor.a.b dVar = new d(this.bitmap, this.lmS.getTouchTracker().aKk);
        AppMethodBeat.o(3023);
        return dVar;
    }
}
