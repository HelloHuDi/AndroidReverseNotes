package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.media.editor.a.d;
import com.tencent.mm.media.editor.a.f;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0017H\u0016J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "handleRemove", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEditing", "editing", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class EmojiEditorItemView extends EmojiStatusView implements b {
    private final String TAG;
    private final a lmS;

    public EmojiEditorItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(3103);
        this.TAG = "MicroMsg.EmojiEditorItemView";
        this.lmS = new com.tencent.mm.plugin.emojicapture.e.b(this);
        AppMethodBeat.o(3103);
    }

    public final com.tencent.mm.media.editor.a.a UJ() {
        return null;
    }

    public EmojiEditorItemView(Context context) {
        this(context, null);
    }

    public EmojiEditorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(RectF rectF, float f) {
        AppMethodBeat.i(3096);
        j.p(rectF, "bounds");
        this.lmS.a(rectF, f);
        AppMethodBeat.o(3096);
    }

    public final void setEditing(boolean z) {
        AppMethodBeat.i(3097);
        this.lmS.setEditing(z);
        AppMethodBeat.o(3097);
    }

    public final boolean bob() {
        return false;
    }

    public final EditorItemContainer getItemContainer() {
        AppMethodBeat.i(3098);
        ViewParent parent = getParent();
        j.o(parent, "parent");
        if (parent.getParent() instanceof EditorItemContainer) {
            parent = getParent();
            j.o(parent, "parent");
            parent = parent.getParent();
            if (parent == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
                AppMethodBeat.o(3098);
                throw vVar;
            }
            EditorItemContainer editorItemContainer = (EditorItemContainer) parent;
            AppMethodBeat.o(3098);
            return editorItemContainer;
        }
        AppMethodBeat.o(3098);
        return null;
    }

    public final void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(3099);
        super.setImageDrawable(drawable);
        if (drawable != null) {
            this.lmS.dV(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        AppMethodBeat.o(3099);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3100);
        j.p(motionEvent, "event");
        boolean G = this.lmS.G(motionEvent);
        AppMethodBeat.o(3100);
        return G;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(3101);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        canvas.save();
        this.lmS.h(canvas);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restore();
        this.lmS.i(canvas);
        AppMethodBeat.o(3101);
    }

    public final com.tencent.mm.media.editor.a.b UI() {
        AppMethodBeat.i(3102);
        Drawable drawable;
        v vVar;
        com.tencent.mm.media.editor.a.b dVar;
        if (getEmojiInfo() == null) {
            AppMethodBeat.o(3102);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            drawable = getDrawable();
            if (drawable == null) {
                vVar = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                AppMethodBeat.o(3102);
                throw vVar;
            }
            dVar = new d(((BitmapDrawable) drawable).getBitmap(), this.lmS.getTouchTracker().aKk);
            AppMethodBeat.o(3102);
            return dVar;
        } else {
            float f = 1.0f;
            if (getDrawable() instanceof com.tencent.mm.plugin.gif.d) {
                drawable = getDrawable();
                if (drawable == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.o(3102);
                    throw vVar;
                }
                f = ((com.tencent.mm.plugin.gif.d) drawable).getEmojiDensityScale();
            } else if (getDrawable() instanceof h) {
                drawable = getDrawable();
                if (drawable == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.o(3102);
                    throw vVar;
                }
                f = ((h) drawable).getEmojiDensityScale();
            }
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            matrix.postConcat(this.lmS.getTouchTracker().aKk);
            EmojiInfo emojiInfo = getEmojiInfo();
            if (emojiInfo == null) {
                j.dWJ();
            }
            dVar = new f(emojiInfo, matrix);
            AppMethodBeat.o(3102);
            return dVar;
        }
    }
}
