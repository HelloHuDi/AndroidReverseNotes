package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView */
public class SnsDrawGestureView extends ImageView {
    private List<PointF> points;
    private C35145a rNb;
    private int rNc;
    private Paint rNd;
    private Paint rNe;

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView$a */
    public interface C35145a {
        void cuU();

        /* renamed from: dv */
        void mo25866dv(List<PointF> list);

        void onClick();
    }

    public SnsDrawGestureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SnsDrawGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40506);
        this.points = new ArrayList();
        this.rNc = -1;
        this.rNd = new Paint();
        this.rNe = new Paint();
        this.rNd.setColor(this.rNc);
        this.rNd.setStyle(Style.STROKE);
        this.rNd.setStrokeWidth((float) C1338a.fromDPToPix(getContext(), 8));
        this.rNd.setPathEffect(new CornerPathEffect((float) C1338a.fromDPToPix(getContext(), 4)));
        this.rNd.setAntiAlias(true);
        this.rNe.setColor(this.rNc);
        this.rNe.setStyle(Style.FILL);
        this.rNe.setAntiAlias(true);
        if (C1443d.m3067fP(21)) {
            setLayerType(1, null);
        }
        AppMethodBeat.m2505o(40506);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(40507);
        if (motionEvent.getActionMasked() == 0) {
            if (this.rNb != null) {
                this.rNb.cuU();
            }
            this.points.clear();
            this.points.add(new PointF(motionEvent.getX(), motionEvent.getY()));
        } else if (motionEvent.getActionMasked() == 2) {
            this.points.add(new PointF(motionEvent.getX(), motionEvent.getY()));
            postInvalidate();
        } else if (motionEvent.getActionMasked() == 1) {
            C4990ab.m7417i("MicroMsg.SnsDrawGestureViewView", "point count %d", Integer.valueOf(this.points.size()));
            if (this.points.size() < 6) {
                this.points.clear();
                if (this.rNb != null) {
                    this.rNb.onClick();
                }
            } else if (this.rNb != null) {
                this.rNb.mo25866dv(cvz());
            }
        } else if (this.rNb != null) {
            this.rNb.mo25866dv(cvz());
        }
        AppMethodBeat.m2505o(40507);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(40508);
        super.onDraw(canvas);
        if (this.points.size() > 0) {
            Path path = new Path();
            path.moveTo(((PointF) this.points.get(0)).x, ((PointF) this.points.get(0)).y);
            canvas.drawCircle(((PointF) this.points.get(0)).x, ((PointF) this.points.get(0)).y, ((float) C1338a.fromDPToPix(getContext(), 8)) / 2.0f, this.rNe);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.points.size()) {
                    break;
                }
                path.lineTo(((PointF) this.points.get(i2)).x, ((PointF) this.points.get(i2)).y);
                i = i2 + 1;
            }
            canvas.drawPath(path, this.rNd);
            canvas.drawCircle(((PointF) this.points.get(this.points.size() - 1)).x, ((PointF) this.points.get(this.points.size() - 1)).y, ((float) C1338a.fromDPToPix(getContext(), 8)) / 2.0f, this.rNe);
        }
        AppMethodBeat.m2505o(40508);
    }

    private List<PointF> cvz() {
        AppMethodBeat.m2504i(40509);
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : this.points) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        AppMethodBeat.m2505o(40509);
        return arrayList;
    }

    public void setPaintColor(int i) {
        AppMethodBeat.m2504i(40510);
        this.rNc = i;
        this.rNd.setColor(this.rNc);
        this.rNe.setColor(this.rNc);
        AppMethodBeat.m2505o(40510);
    }

    public final void cvA() {
        AppMethodBeat.m2504i(40511);
        this.points.clear();
        postInvalidate();
        AppMethodBeat.m2505o(40511);
    }

    public void setOnGestureListener(C35145a c35145a) {
        this.rNb = c35145a;
    }

    public C35145a getOnGestureListener() {
        return this.rNb;
    }
}
