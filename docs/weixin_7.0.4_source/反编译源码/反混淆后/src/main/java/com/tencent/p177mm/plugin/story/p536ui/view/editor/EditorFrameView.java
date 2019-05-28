package com.tencent.p177mm.plugin.story.p536ui.view.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBoundaryColor", "mMaskColor", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPosition", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFramePosition;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "maskColor", "setPosition", "position", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorFrameView */
public final class EditorFrameView extends View {
    private Paint mPaint = new Paint();
    private int slu = -1;
    private int slv = -1;
    private C35242a slw = C35242a.POSITION_LEFT;
    /* renamed from: vr */
    private Path f4398vr = new Path();

    public EditorFrameView(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(110547);
        init();
        AppMethodBeat.m2505o(110547);
    }

    public EditorFrameView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(110548);
        init();
        AppMethodBeat.m2505o(110548);
    }

    public EditorFrameView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110549);
        init();
        AppMethodBeat.m2505o(110549);
    }

    private final void init() {
        AppMethodBeat.m2504i(110544);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        this.slu = context.getResources().getColor(C25738R.color.a1t);
        int fromDPToPix = C1338a.fromDPToPix(getContext(), 1);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(2.0f * ((float) fromDPToPix));
        this.mPaint.setColor(this.slv);
        this.mPaint.setPathEffect(new DashPathEffect(new float[]{((float) fromDPToPix) * 4.0f, ((float) fromDPToPix) * 4.0f}, 0.0f));
        AppMethodBeat.m2505o(110544);
    }

    public final void setMaskColor(int i) {
        this.slu = i;
    }

    public final void setPosition(C35242a c35242a) {
        AppMethodBeat.m2504i(110545);
        C25052j.m39376p(c35242a, "position");
        this.slw = c35242a;
        AppMethodBeat.m2505o(110545);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(110546);
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.save();
        }
        if (canvas != null) {
            canvas.drawColor(this.slu);
        }
        switch (C22303b.eQZ[this.slw.ordinal()]) {
            case 1:
                this.f4398vr.moveTo((float) getWidth(), 0.0f);
                this.f4398vr.lineTo((float) getWidth(), (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.f4398vr, this.mPaint);
                    break;
                }
                break;
            case 2:
                this.f4398vr.moveTo(0.0f, (float) getHeight());
                this.f4398vr.lineTo((float) getWidth(), (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.f4398vr, this.mPaint);
                    break;
                }
                break;
            case 3:
                this.f4398vr.moveTo(0.0f, 0.0f);
                this.f4398vr.lineTo(0.0f, (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.f4398vr, this.mPaint);
                    break;
                }
                break;
            case 4:
                this.f4398vr.moveTo(0.0f, 0.0f);
                this.f4398vr.lineTo((float) getWidth(), 0.0f);
                if (canvas != null) {
                    canvas.drawPath(this.f4398vr, this.mPaint);
                    break;
                }
                break;
        }
        if (canvas != null) {
            canvas.restore();
            AppMethodBeat.m2505o(110546);
            return;
        }
        AppMethodBeat.m2505o(110546);
    }
}
