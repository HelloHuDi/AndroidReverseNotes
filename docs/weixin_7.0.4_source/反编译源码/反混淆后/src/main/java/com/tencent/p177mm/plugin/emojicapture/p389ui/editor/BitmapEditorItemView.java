package com.tencent.p177mm.plugin.emojicapture.p389ui.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.editor.p252a.C26382a;
import com.tencent.p177mm.media.editor.p252a.C26384d;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.plugin.emojicapture.p387e.C33992b;
import com.tencent.p177mm.plugin.emojicapture.p949c.C42970c.C27796b;
import com.tencent.p177mm.plugin.emojicapture.p949c.C42970c.C38903a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001cH\u0016J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/BitmapEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "handleRemove", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "resume", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.BitmapEditorItemView */
public final class BitmapEditorItemView extends View implements C27796b {
    private Bitmap bitmap;
    private final C38903a lmS;

    public BitmapEditorItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3024);
        this.lmS = new C33992b(this);
        AppMethodBeat.m2505o(3024);
    }

    /* renamed from: UJ */
    public final C26382a mo26049UJ() {
        return null;
    }

    public BitmapEditorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(3017);
        this.bitmap = bitmap;
        if (bitmap != null) {
            this.lmS.mo54538dV(bitmap.getWidth(), bitmap.getHeight());
        }
        AppMethodBeat.m2505o(3017);
    }

    public final void resume() {
    }

    public final void pause() {
    }

    /* renamed from: a */
    public final void mo35774a(RectF rectF, float f) {
        AppMethodBeat.m2504i(3018);
        C25052j.m39376p(rectF, "bounds");
        this.lmS.mo54537a(rectF, f);
        AppMethodBeat.m2505o(3018);
    }

    public final void setEditing(boolean z) {
        AppMethodBeat.m2504i(3019);
        this.lmS.setEditing(z);
        invalidate();
        AppMethodBeat.m2505o(3019);
    }

    public final boolean bob() {
        return false;
    }

    public final EditorItemContainer getItemContainer() {
        AppMethodBeat.m2504i(3020);
        if (getParent() instanceof EditorItemContainer) {
            ViewParent parent = getParent();
            if (parent == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
                AppMethodBeat.m2505o(3020);
                throw c44941v;
            }
            EditorItemContainer editorItemContainer = (EditorItemContainer) parent;
            AppMethodBeat.m2505o(3020);
            return editorItemContainer;
        }
        AppMethodBeat.m2505o(3020);
        return null;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3021);
        C25052j.m39376p(motionEvent, "event");
        boolean G = this.lmS.mo54536G(motionEvent);
        AppMethodBeat.m2505o(3021);
        return G;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(3022);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        canvas.save();
        this.lmS.mo54540h(canvas);
        if (this.bitmap != null) {
            canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, null);
        }
        canvas.restore();
        AppMethodBeat.m2505o(3022);
    }

    /* renamed from: UI */
    public final C9584b mo26048UI() {
        AppMethodBeat.m2504i(3023);
        if (this.bitmap == null) {
            AppMethodBeat.m2505o(3023);
            return null;
        }
        C9584b c26384d = new C26384d(this.bitmap, this.lmS.getTouchTracker().aKk);
        AppMethodBeat.m2505o(3023);
        return c26384d;
    }
}
