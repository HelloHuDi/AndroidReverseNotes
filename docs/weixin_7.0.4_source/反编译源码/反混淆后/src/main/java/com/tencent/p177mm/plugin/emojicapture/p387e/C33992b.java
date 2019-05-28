package com.tencent.p177mm.plugin.emojicapture.p387e;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.media.editor.p1203c.C42171c;
import com.tencent.p177mm.media.editor.p1203c.C45429a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.C38926a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EditorItemContainer;
import com.tencent.p177mm.plugin.emojicapture.p949c.C42970c.C27796b;
import com.tencent.p177mm.plugin.emojicapture.p949c.C42970c.C38903a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fH\u0016J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.e.b */
public final class C33992b implements C38903a {
    public static final C27797a lkm = new C27797a();
    private final Paint aFY = new Paint();
    private float aJf = 2.0f;
    private float aJg = 0.25f;
    private float eVd = 1.0f;
    private final float eVe;
    private final float eVf;
    private final float eVg;
    private final C42171c lkf = new C42171c();
    private final RectF lkg = new RectF();
    private final Path lkh = new Path();
    private final Rect lki = new Rect();
    private boolean lkj;
    private boolean lkk;
    private final C27796b lkl;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter$Companion;", "", "()V", "DEFAULT_SCALE_TO_BOUNDS", "", "MAX_SCALE_TO_BOUNDS", "MIN_SCALE_TO_BOUNDS", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.b$a */
    public static final class C27797a {
        private C27797a() {
        }

        public /* synthetic */ C27797a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.b$b */
    static final class C33993b extends C25053k implements C17126b<Matrix, C37091y> {
        final /* synthetic */ C33992b lkn;

        C33993b(C33992b c33992b) {
            this.lkn = c33992b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2755);
            Matrix matrix = (Matrix) obj;
            C25052j.m39376p(matrix, "it");
            this.lkn.lkf.aKk.set(matrix);
            C27796b b = this.lkn.lkl;
            if (b == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.m2505o(2755);
                throw c44941v;
            }
            ((View) b).invalidate();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2755);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(2764);
        AppMethodBeat.m2505o(2764);
    }

    public C33992b(C27796b c27796b) {
        C25052j.m39376p(c27796b, "view");
        AppMethodBeat.m2504i(2763);
        this.lkl = c27796b;
        C27796b c27796b2 = this.lkl;
        if (c27796b2 == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.m2505o(2763);
            throw c44941v;
        }
        Context context = ((View) c27796b2).getContext();
        C25052j.m39375o(context, "(view as View).context");
        Resources resources = context.getResources();
        this.lkf.aJf = this.aJf;
        this.lkf.aJg = this.aJg;
        this.aFY.setColor(-1);
        this.aFY.setAntiAlias(true);
        this.aFY.setStrokeWidth(resources.getDimension(C25738R.dimen.f10385zw));
        this.aFY.setStyle(Style.FILL);
        this.eVf = resources.getDimension(C25738R.dimen.f10385zw);
        this.eVg = resources.getDimension(C25738R.dimen.f10383zu);
        this.eVe = resources.getDimension(C25738R.dimen.f10384zv);
        AppMethodBeat.m2505o(2763);
    }

    public final C42171c getTouchTracker() {
        return this.lkf;
    }

    /* renamed from: dV */
    public final void mo54538dV(int i, int i2) {
        AppMethodBeat.m2504i(2756);
        this.lkf.width = i;
        this.lkf.height = i2;
        this.lki.right = i;
        this.lki.bottom = i2;
        bnJ();
        AppMethodBeat.m2505o(2756);
    }

    /* renamed from: a */
    public final void mo54537a(RectF rectF, float f) {
        AppMethodBeat.m2504i(2757);
        C25052j.m39376p(rectF, "bounds");
        this.lkg.set(rectF);
        this.lkh.addRoundRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom), f, f, Direction.CW);
        bnJ();
        AppMethodBeat.m2505o(2757);
    }

    private final void bnJ() {
        AppMethodBeat.m2504i(2758);
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
        AppMethodBeat.m2505o(2758);
    }

    public final void setEditing(boolean z) {
        AppMethodBeat.m2504i(2759);
        this.lkj = z;
        C27796b c27796b = this.lkl;
        if (c27796b == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.m2505o(2759);
            throw c44941v;
        }
        ((View) c27796b).postInvalidate();
        AppMethodBeat.m2505o(2759);
    }

    /* renamed from: G */
    public final boolean mo54536G(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(2760);
        C25052j.m39376p(motionEvent, "event");
        EditorItemContainer itemContainer = this.lkl.getItemContainer();
        if (this.lkf.mo67716u(motionEvent)) {
            C27796b c27796b;
            C44941v c44941v;
            if (itemContainer != null) {
                itemContainer.mo45680a((C38926a) this.lkl, motionEvent);
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.lkk = true;
                    c27796b = this.lkl;
                    if (c27796b != null) {
                        ((View) c27796b).bringToFront();
                        break;
                    }
                    c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.m2505o(2760);
                    throw c44941v;
                case 1:
                case 3:
                    this.lkk = true;
                    C45429a c45429a = new C45429a();
                    c45429a.aJg = this.aJg;
                    c45429a.aJf = this.aJf;
                    c45429a.mo73225g(new float[]{((float) this.lki.width()) / 2.0f, ((float) this.lki.height()) / 2.0f});
                    c45429a.mo73224b(new RectF(this.lkg.left, this.lkg.top, this.lkg.right, this.lkg.bottom));
                    c45429a.mo73223a(this.lkf.aKk, new C33993b(this));
                    break;
                case 2:
                    this.lkk = false;
                    break;
            }
            c27796b = this.lkl;
            if (c27796b == null) {
                c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.m2505o(2760);
                throw c44941v;
            }
            ((View) c27796b).invalidate();
            AppMethodBeat.m2505o(2760);
            return true;
        }
        AppMethodBeat.m2505o(2760);
        return false;
    }

    /* renamed from: h */
    public final void mo54540h(Canvas canvas) {
        AppMethodBeat.m2504i(2761);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
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
        AppMethodBeat.m2505o(2761);
    }

    /* renamed from: i */
    public final void mo54541i(Canvas canvas) {
        AppMethodBeat.m2504i(2762);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        AppMethodBeat.m2505o(2762);
    }
}
