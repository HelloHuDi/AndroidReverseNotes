package com.tencent.mm.plugin.emojicapture.e;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fH\u0016J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b implements com.tencent.mm.plugin.emojicapture.c.c.a {
    public static final a lkm = new a();
    private final Paint aFY = new Paint();
    private float aJf = 2.0f;
    private float aJg = 0.25f;
    private float eVd = 1.0f;
    private final float eVe;
    private final float eVf;
    private final float eVg;
    private final c lkf = new c();
    private final RectF lkg = new RectF();
    private final Path lkh = new Path();
    private final Rect lki = new Rect();
    private boolean lkj;
    private boolean lkk;
    private final com.tencent.mm.plugin.emojicapture.c.c.b lkl;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter$Companion;", "", "()V", "DEFAULT_SCALE_TO_BOUNDS", "", "MAX_SCALE_TO_BOUNDS", "MIN_SCALE_TO_BOUNDS", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
    static final class b extends k implements a.f.a.b<Matrix, y> {
        final /* synthetic */ b lkn;

        b(b bVar) {
            this.lkn = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2755);
            Matrix matrix = (Matrix) obj;
            j.p(matrix, "it");
            this.lkn.lkf.aKk.set(matrix);
            com.tencent.mm.plugin.emojicapture.c.c.b b = this.lkn.lkl;
            if (b == null) {
                v vVar = new v("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(2755);
                throw vVar;
            }
            ((View) b).invalidate();
            y yVar = y.AUy;
            AppMethodBeat.o(2755);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(2764);
        AppMethodBeat.o(2764);
    }

    public b(com.tencent.mm.plugin.emojicapture.c.c.b bVar) {
        j.p(bVar, "view");
        AppMethodBeat.i(2763);
        this.lkl = bVar;
        com.tencent.mm.plugin.emojicapture.c.c.b bVar2 = this.lkl;
        if (bVar2 == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(2763);
            throw vVar;
        }
        Context context = ((View) bVar2).getContext();
        j.o(context, "(view as View).context");
        Resources resources = context.getResources();
        this.lkf.aJf = this.aJf;
        this.lkf.aJg = this.aJg;
        this.aFY.setColor(-1);
        this.aFY.setAntiAlias(true);
        this.aFY.setStrokeWidth(resources.getDimension(R.dimen.zw));
        this.aFY.setStyle(Style.FILL);
        this.eVf = resources.getDimension(R.dimen.zw);
        this.eVg = resources.getDimension(R.dimen.zu);
        this.eVe = resources.getDimension(R.dimen.zv);
        AppMethodBeat.o(2763);
    }

    public final c getTouchTracker() {
        return this.lkf;
    }

    public final void dV(int i, int i2) {
        AppMethodBeat.i(2756);
        this.lkf.width = i;
        this.lkf.height = i2;
        this.lki.right = i;
        this.lki.bottom = i2;
        bnJ();
        AppMethodBeat.o(2756);
    }

    public final void a(RectF rectF, float f) {
        AppMethodBeat.i(2757);
        j.p(rectF, "bounds");
        this.lkg.set(rectF);
        this.lkh.addRoundRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom), f, f, Direction.CW);
        bnJ();
        AppMethodBeat.o(2757);
    }

    private final void bnJ() {
        AppMethodBeat.i(2758);
        this.lkf.aKk.reset();
        this.lkf.aKk.postTranslate(((float) (-this.lki.width())) / 2.0f, ((float) (-this.lki.height())) / 2.0f);
        if (!(this.lkg.isEmpty() || this.lki.isEmpty())) {
            this.eVd = this.lkg.width() / ((float) Math.max(this.lki.width(), this.lki.height()));
            float f = this.eVd * 0.5f;
            this.aJf = this.eVd * 2.0f;
            this.aJg = this.eVd * 0.25f;
            this.lkf.aJf = this.aJf;
            this.lkf.aJg = this.aJg;
            this.lkf.aKk.postScale(f, f);
        }
        this.lkf.aKk.postTranslate((this.lkg.left + this.lkg.right) / 2.0f, (this.lkg.top + this.lkg.bottom) / 2.0f);
        AppMethodBeat.o(2758);
    }

    public final void setEditing(boolean z) {
        AppMethodBeat.i(2759);
        this.lkj = z;
        com.tencent.mm.plugin.emojicapture.c.c.b bVar = this.lkl;
        if (bVar == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(2759);
            throw vVar;
        }
        ((View) bVar).postInvalidate();
        AppMethodBeat.o(2759);
    }

    public final boolean G(MotionEvent motionEvent) {
        AppMethodBeat.i(2760);
        j.p(motionEvent, "event");
        EditorItemContainer itemContainer = this.lkl.getItemContainer();
        if (this.lkf.u(motionEvent)) {
            com.tencent.mm.plugin.emojicapture.c.c.b bVar;
            v vVar;
            if (itemContainer != null) {
                itemContainer.a((com.tencent.mm.plugin.emojicapture.ui.editor.a) this.lkl, motionEvent);
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.lkk = true;
                    bVar = this.lkl;
                    if (bVar != null) {
                        ((View) bVar).bringToFront();
                        break;
                    }
                    vVar = new v("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(2760);
                    throw vVar;
                case 1:
                case 3:
                    this.lkk = true;
                    com.tencent.mm.media.editor.c.a aVar = new com.tencent.mm.media.editor.c.a();
                    aVar.aJg = this.aJg;
                    aVar.aJf = this.aJf;
                    aVar.g(new float[]{((float) this.lki.width()) / 2.0f, ((float) this.lki.height()) / 2.0f});
                    aVar.b(new RectF(this.lkg.left, this.lkg.top, this.lkg.right, this.lkg.bottom));
                    aVar.a(this.lkf.aKk, new b(this));
                    break;
                case 2:
                    this.lkk = false;
                    break;
            }
            bVar = this.lkl;
            if (bVar == null) {
                vVar = new v("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(2760);
                throw vVar;
            }
            ((View) bVar).invalidate();
            AppMethodBeat.o(2760);
            return true;
        }
        AppMethodBeat.o(2760);
        return false;
    }

    public final void h(Canvas canvas) {
        AppMethodBeat.i(2761);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        if (this.lkk) {
            canvas.clipPath(this.lkh);
        }
        canvas.setMatrix(this.lkf.aKk);
        if (this.lkj) {
            float f = ((float) this.lki.left) - (this.eVg / this.eVd);
            float f2 = ((float) this.lki.top) - (this.eVg / this.eVd);
            float f3 = ((float) this.lki.right) + (this.eVg / this.eVd);
            float f4 = ((float) this.lki.bottom) + (this.eVg / this.eVd);
            float f5 = (this.eVe / 2.0f) / this.eVd;
            this.aFY.setStrokeWidth(this.eVf / this.eVd);
            canvas.drawRect(f - f5, f2 - f5, f + f5, f2 + f5, this.aFY);
            canvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.aFY);
            canvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.aFY);
            canvas.drawRect(f - f5, f4 - f5, f + f5, f4 + f5, this.aFY);
            canvas.drawLines(new float[]{f, f2, f3, f2, f3, f2, f3, f4, f3, f4, f, f4, f, f4, f, f2}, this.aFY);
        }
        AppMethodBeat.o(2761);
    }

    public final void i(Canvas canvas) {
        AppMethodBeat.i(2762);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        AppMethodBeat.o(2762);
    }
}
