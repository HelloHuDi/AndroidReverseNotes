package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.d;
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.media.editor.a.i;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.b;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010H\u001a\u0004\u0018\u00010IH\u0016J\n\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0014J\u0010\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020Q2\u0006\u0010X\u001a\u00020OH\u0016J\u000e\u0010Y\u001a\u00020Q2\u0006\u0010\"\u001a\u00020#J\u0010\u0010Z\u001a\u00020Q2\u0006\u0010[\u001a\u00020OH\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0011R\u0014\u0010>\u001a\u00020?X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR(\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\u0007\u001a\u0004\u0018\u00010B@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006\\"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/media/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/media/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/media/editor/item/LocationItem;)V", "sourceDataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "touchDownX", "", "getTouchDownX", "()F", "setTouchDownX", "(F)V", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "", "getTouchMoved", "()Z", "setTouchMoved", "(Z)V", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getContentBoundary", "", "getSafeArea", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setSafeArea", "safeRect", "setStateResolve", "setValidArea", "validRect", "plugin-story_release"})
public class a extends View implements h, c {
    private Bitmap bitmap;
    private int color;
    private final c lkf = new c();
    private float lot;
    private float lou;
    private boolean lov;
    private final int nfE;
    private final com.tencent.mm.media.editor.view.a smB;
    private b smC;
    private int smD;
    private i smE;
    private e smF = e.TEXT;
    private Matrix smG;
    private CharSequence text;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(110631);
        Resources resources = getResources();
        j.o(resources, "resources");
        this.smB = new com.tencent.mm.media.editor.view.a(resources);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        j.o(viewConfiguration, "ViewConfiguration.get(context)");
        this.nfE = viewConfiguration.getScaledTouchSlop();
        AppMethodBeat.o(110631);
    }

    /* Access modifiers changed, original: protected|final */
    public final c getTouchTracker() {
        return this.lkf;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final void setText(CharSequence charSequence) {
        this.text = charSequence;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final int getTextBg() {
        return this.smD;
    }

    public final void setTextBg(int i) {
        this.smD = i;
    }

    public final i getLocation() {
        return this.smE;
    }

    public final void setLocation(i iVar) {
        this.smE = iVar;
    }

    public final e getSourceDataType() {
        return this.smF;
    }

    public final void setSourceDataType(e eVar) {
        AppMethodBeat.i(110619);
        j.p(eVar, "<set-?>");
        this.smF = eVar;
        AppMethodBeat.o(110619);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        AppMethodBeat.i(110620);
        this.bitmap = bitmap;
        if (bitmap != null) {
            this.lkf.width = bitmap.getWidth();
            this.lkf.height = bitmap.getHeight();
            this.lkf.aKk.preTranslate(((float) (-bitmap.getWidth())) / 2.0f, ((float) (-bitmap.getHeight())) / 2.0f);
            this.smB.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.lkf.h(new float[]{0.0f, 0.0f, (float) bitmap.getWidth(), 0.0f, 0.0f, (float) bitmap.getHeight(), (float) bitmap.getWidth(), (float) bitmap.getHeight()});
        }
        AppMethodBeat.o(110620);
    }

    public final Matrix getViewMatrix() {
        return this.smG;
    }

    public final void setViewMatrix(Matrix matrix) {
        AppMethodBeat.i(110621);
        this.smG = matrix;
        if (matrix != null) {
            this.lkf.setMatrix(matrix);
            Canvas canvas = new Canvas();
            canvas.save();
            if (this.smG != null) {
                canvas.setMatrix(matrix);
            }
            if (isActivated()) {
                this.smB.draw(canvas);
            }
            if (this.bitmap != null) {
                canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, null);
            }
        }
        AppMethodBeat.o(110621);
    }

    public final float getTouchDownX() {
        return this.lot;
    }

    public final void setTouchDownX(float f) {
        this.lot = f;
    }

    public final float getTouchDownY() {
        return this.lou;
    }

    public final void setTouchDownY(float f) {
        this.lou = f;
    }

    public final boolean getTouchMoved() {
        return this.lov;
    }

    public final void setTouchMoved(boolean z) {
        this.lov = z;
    }

    public final int getTouchSlop() {
        return this.nfE;
    }

    public void setValidArea(Rect rect) {
        AppMethodBeat.i(110622);
        j.p(rect, "validRect");
        this.lkf.aKk.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) / 2.0f);
        AppMethodBeat.o(110622);
    }

    public final void setStateResolve(b bVar) {
        AppMethodBeat.i(110623);
        j.p(bVar, "stateResolve");
        this.smC = bVar;
        AppMethodBeat.o(110623);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(110624);
        j.p(motionEvent, "event");
        boolean u = this.lkf.u(motionEvent);
        if (u) {
            b bVar = this.smC;
            if (bVar != null) {
                bVar.e(this, motionEvent);
            }
            bringToFront();
            postInvalidate();
        }
        if (u) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.lot = motionEvent.getX();
                    this.lou = motionEvent.getY();
                    this.lov = false;
                    break;
                case 1:
                    if (!this.lov) {
                        performClick();
                        break;
                    }
                    break;
                case 2:
                    float max = Math.max(Math.abs(motionEvent.getX() - this.lot), Math.abs(motionEvent.getY() - this.lou));
                    if (!this.lov) {
                        this.lov = max > ((float) this.nfE);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(110624);
        return u;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(110625);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        canvas.save();
        if (this.smG != null) {
            canvas.setMatrix(this.smG);
        } else {
            canvas.setMatrix(this.lkf.aKk);
        }
        if (isActivated()) {
            this.smB.draw(canvas);
        }
        if (this.bitmap != null) {
            canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, null);
        }
        canvas.restore();
        AppMethodBeat.o(110625);
    }

    public final com.tencent.mm.media.editor.a.b UI() {
        AppMethodBeat.i(110626);
        if (this.bitmap == null) {
            AppMethodBeat.o(110626);
            return null;
        }
        com.tencent.mm.media.editor.a.b dVar = new d(this.bitmap, this.lkf.aKk);
        AppMethodBeat.o(110626);
        return dVar;
    }

    public final com.tencent.mm.media.editor.a.a UJ() {
        AppMethodBeat.i(110627);
        com.tencent.mm.media.editor.a.a jVar;
        if (this.bitmap == null) {
            AppMethodBeat.o(110627);
            return null;
        } else if (this.smF == e.TEXT) {
            jVar = new com.tencent.mm.media.editor.a.j(this.text, this.color, this.smD, this.lkf.aKk);
            AppMethodBeat.o(110627);
            return jVar;
        } else {
            i iVar = this.smE;
            if (iVar == null) {
                j.dWJ();
            }
            String str = iVar.eUt;
            i iVar2 = this.smE;
            if (iVar2 == null) {
                j.dWJ();
            }
            jVar = new i(str, iVar2.eUu, this.lkf.aKk);
            AppMethodBeat.o(110627);
            return jVar;
        }
    }

    public void setSafeArea(Rect rect) {
        AppMethodBeat.i(110628);
        j.p(rect, "safeRect");
        this.lkf.eUN = rect;
        this.lkf.eUO = com.tencent.mm.bz.a.fromDPToPix(getContext(), 54);
        AppMethodBeat.o(110628);
    }

    public Rect getSafeArea() {
        AppMethodBeat.i(110629);
        Rect rect = this.lkf.eUN;
        if (rect == null) {
            Resources resources = getResources();
            j.o(resources, "resources");
            int i = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = getResources();
            j.o(resources2, "resources");
            rect = new Rect(0, 0, i, resources2.getDisplayMetrics().heightPixels);
        }
        AppMethodBeat.o(110629);
        return rect;
    }

    public float[] getContentBoundary() {
        AppMethodBeat.i(110630);
        float[] fArr = (float[]) this.lkf.eUT.clone();
        AppMethodBeat.o(110630);
        return fArr;
    }
}
