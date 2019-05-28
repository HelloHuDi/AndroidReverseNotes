package com.tencent.p177mm.plugin.emojicapture.p389ui.editor;

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
import com.tencent.p177mm.emoji.view.EmojiStatusView;
import com.tencent.p177mm.media.editor.p252a.C26382a;
import com.tencent.p177mm.media.editor.p252a.C26384d;
import com.tencent.p177mm.media.editor.p252a.C45427f;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.plugin.emojicapture.p387e.C33992b;
import com.tencent.p177mm.plugin.emojicapture.p949c.C42970c.C27796b;
import com.tencent.p177mm.plugin.emojicapture.p949c.C42970c.C38903a;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.gif.C36775h;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0017H\u0016J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "handleRemove", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEditing", "editing", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView */
public final class EmojiEditorItemView extends EmojiStatusView implements C27796b {
    private final String TAG;
    private final C38903a lmS;

    public EmojiEditorItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3103);
        this.TAG = "MicroMsg.EmojiEditorItemView";
        this.lmS = new C33992b(this);
        AppMethodBeat.m2505o(3103);
    }

    /* renamed from: UJ */
    public final C26382a mo26049UJ() {
        return null;
    }

    public EmojiEditorItemView(Context context) {
        this(context, null);
    }

    public EmojiEditorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public final void mo35774a(RectF rectF, float f) {
        AppMethodBeat.m2504i(3096);
        C25052j.m39376p(rectF, "bounds");
        this.lmS.mo54537a(rectF, f);
        AppMethodBeat.m2505o(3096);
    }

    public final void setEditing(boolean z) {
        AppMethodBeat.m2504i(3097);
        this.lmS.setEditing(z);
        AppMethodBeat.m2505o(3097);
    }

    public final boolean bob() {
        return false;
    }

    public final EditorItemContainer getItemContainer() {
        AppMethodBeat.m2504i(3098);
        ViewParent parent = getParent();
        C25052j.m39375o(parent, "parent");
        if (parent.getParent() instanceof EditorItemContainer) {
            parent = getParent();
            C25052j.m39375o(parent, "parent");
            parent = parent.getParent();
            if (parent == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
                AppMethodBeat.m2505o(3098);
                throw c44941v;
            }
            EditorItemContainer editorItemContainer = (EditorItemContainer) parent;
            AppMethodBeat.m2505o(3098);
            return editorItemContainer;
        }
        AppMethodBeat.m2505o(3098);
        return null;
    }

    public final void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(3099);
        super.setImageDrawable(drawable);
        if (drawable != null) {
            this.lmS.mo54538dV(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        AppMethodBeat.m2505o(3099);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3100);
        C25052j.m39376p(motionEvent, "event");
        boolean G = this.lmS.mo54536G(motionEvent);
        AppMethodBeat.m2505o(3100);
        return G;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(3101);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        canvas.save();
        this.lmS.mo54540h(canvas);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restore();
        this.lmS.mo54541i(canvas);
        AppMethodBeat.m2505o(3101);
    }

    /* renamed from: UI */
    public final C9584b mo26048UI() {
        AppMethodBeat.m2504i(3102);
        Drawable drawable;
        C44941v c44941v;
        C9584b c26384d;
        if (getEmojiInfo() == null) {
            AppMethodBeat.m2505o(3102);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            drawable = getDrawable();
            if (drawable == null) {
                c44941v = new C44941v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                AppMethodBeat.m2505o(3102);
                throw c44941v;
            }
            c26384d = new C26384d(((BitmapDrawable) drawable).getBitmap(), this.lmS.getTouchTracker().aKk);
            AppMethodBeat.m2505o(3102);
            return c26384d;
        } else {
            float f = 1.0f;
            if (getDrawable() instanceof C3266d) {
                drawable = getDrawable();
                if (drawable == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.m2505o(3102);
                    throw c44941v;
                }
                f = ((C3266d) drawable).getEmojiDensityScale();
            } else if (getDrawable() instanceof C36775h) {
                drawable = getDrawable();
                if (drawable == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.m2505o(3102);
                    throw c44941v;
                }
                f = ((C36775h) drawable).getEmojiDensityScale();
            }
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            matrix.postConcat(this.lmS.getTouchTracker().aKk);
            EmojiInfo emojiInfo = getEmojiInfo();
            if (emojiInfo == null) {
                C25052j.dWJ();
            }
            c26384d = new C45427f(emojiInfo, matrix);
            AppMethodBeat.m2505o(3102);
            return c26384d;
        }
    }
}
