package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBoundaryColor", "mMaskColor", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPosition", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFramePosition;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "maskColor", "setPosition", "position", "plugin-story_release"})
public final class EditorFrameView extends View {
    private Paint mPaint = new Paint();
    private int slu = -1;
    private int slv = -1;
    private a slw = a.POSITION_LEFT;
    private Path vr = new Path();

    public EditorFrameView(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(110547);
        init();
        AppMethodBeat.o(110547);
    }

    public EditorFrameView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(110548);
        init();
        AppMethodBeat.o(110548);
    }

    public EditorFrameView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(110549);
        init();
        AppMethodBeat.o(110549);
    }

    private final void init() {
        AppMethodBeat.i(110544);
        Context context = getContext();
        j.o(context, "context");
        this.slu = context.getResources().getColor(R.color.a1t);
        int fromDPToPix = a.fromDPToPix(getContext(), 1);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(2.0f * ((float) fromDPToPix));
        this.mPaint.setColor(this.slv);
        this.mPaint.setPathEffect(new DashPathEffect(new float[]{((float) fromDPToPix) * 4.0f, ((float) fromDPToPix) * 4.0f}, 0.0f));
        AppMethodBeat.o(110544);
    }

    public final void setMaskColor(int i) {
        this.slu = i;
    }

    public final void setPosition(a aVar) {
        AppMethodBeat.i(110545);
        j.p(aVar, "position");
        this.slw = aVar;
        AppMethodBeat.o(110545);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(110546);
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.save();
        }
        if (canvas != null) {
            canvas.drawColor(this.slu);
        }
        switch (b.eQZ[this.slw.ordinal()]) {
            case 1:
                this.vr.moveTo((float) getWidth(), 0.0f);
                this.vr.lineTo((float) getWidth(), (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.vr, this.mPaint);
                    break;
                }
                break;
            case 2:
                this.vr.moveTo(0.0f, (float) getHeight());
                this.vr.lineTo((float) getWidth(), (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.vr, this.mPaint);
                    break;
                }
                break;
            case 3:
                this.vr.moveTo(0.0f, 0.0f);
                this.vr.lineTo(0.0f, (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.vr, this.mPaint);
                    break;
                }
                break;
            case 4:
                this.vr.moveTo(0.0f, 0.0f);
                this.vr.lineTo((float) getWidth(), 0.0f);
                if (canvas != null) {
                    canvas.drawPath(this.vr, this.mPaint);
                    break;
                }
                break;
        }
        if (canvas != null) {
            canvas.restore();
            AppMethodBeat.o(110546);
            return;
        }
        AppMethodBeat.o(110546);
    }
}
