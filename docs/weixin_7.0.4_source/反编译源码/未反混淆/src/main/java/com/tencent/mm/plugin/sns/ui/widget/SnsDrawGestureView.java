package com.tencent.mm.plugin.sns.ui.widget;

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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public class SnsDrawGestureView extends ImageView {
    private List<PointF> points;
    private a rNb;
    private int rNc;
    private Paint rNd;
    private Paint rNe;

    public interface a {
        void cuU();

        void dv(List<PointF> list);

        void onClick();
    }

    public SnsDrawGestureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SnsDrawGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40506);
        this.points = new ArrayList();
        this.rNc = -1;
        this.rNd = new Paint();
        this.rNe = new Paint();
        this.rNd.setColor(this.rNc);
        this.rNd.setStyle(Style.STROKE);
        this.rNd.setStrokeWidth((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 8));
        this.rNd.setPathEffect(new CornerPathEffect((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 4)));
        this.rNd.setAntiAlias(true);
        this.rNe.setColor(this.rNc);
        this.rNe.setStyle(Style.FILL);
        this.rNe.setAntiAlias(true);
        if (d.fP(21)) {
            setLayerType(1, null);
        }
        AppMethodBeat.o(40506);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(40507);
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
            ab.i("MicroMsg.SnsDrawGestureViewView", "point count %d", Integer.valueOf(this.points.size()));
            if (this.points.size() < 6) {
                this.points.clear();
                if (this.rNb != null) {
                    this.rNb.onClick();
                }
            } else if (this.rNb != null) {
                this.rNb.dv(cvz());
            }
        } else if (this.rNb != null) {
            this.rNb.dv(cvz());
        }
        AppMethodBeat.o(40507);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(40508);
        super.onDraw(canvas);
        if (this.points.size() > 0) {
            Path path = new Path();
            path.moveTo(((PointF) this.points.get(0)).x, ((PointF) this.points.get(0)).y);
            canvas.drawCircle(((PointF) this.points.get(0)).x, ((PointF) this.points.get(0)).y, ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 8)) / 2.0f, this.rNe);
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
            canvas.drawCircle(((PointF) this.points.get(this.points.size() - 1)).x, ((PointF) this.points.get(this.points.size() - 1)).y, ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 8)) / 2.0f, this.rNe);
        }
        AppMethodBeat.o(40508);
    }

    private List<PointF> cvz() {
        AppMethodBeat.i(40509);
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : this.points) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        AppMethodBeat.o(40509);
        return arrayList;
    }

    public void setPaintColor(int i) {
        AppMethodBeat.i(40510);
        this.rNc = i;
        this.rNd.setColor(this.rNc);
        this.rNe.setColor(this.rNc);
        AppMethodBeat.o(40510);
    }

    public final void cvA() {
        AppMethodBeat.i(40511);
        this.points.clear();
        postInvalidate();
        AppMethodBeat.o(40511);
    }

    public void setOnGestureListener(a aVar) {
        this.rNb = aVar;
    }

    public a getOnGestureListener() {
        return this.rNb;
    }
}
