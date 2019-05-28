package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ZoomControls;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bi.a;
import com.tencent.tencentmap.mapsdk.maps.a.le.b;

public class lj implements le {
    private Context a;
    private ZoomControls b;
    private lk c = null;
    private ViewGroup d;
    private b e = b.RIGHT_BOTTOM;
    private a f = null;
    private iz g;
    private int h = 0;

    public lj(Context context, iz izVar) {
        AppMethodBeat.i(100416);
        this.a = context;
        this.g = izVar;
        a(context);
        d();
        AppMethodBeat.o(100416);
    }

    public void a(int i, int i2) {
    }

    public void a() {
        AppMethodBeat.i(100417);
        if (this.c != null) {
            this.c.a();
        }
        AppMethodBeat.o(100417);
    }

    public boolean a(ViewGroup viewGroup) {
        AppMethodBeat.i(100418);
        if (viewGroup == null || this.b == null || this.c == null) {
            AppMethodBeat.o(100418);
            return false;
        }
        this.d = viewGroup;
        LayoutParams e = e();
        if (viewGroup.indexOfChild(this.b) < 0) {
            viewGroup.addView(this.b, e);
        } else {
            viewGroup.updateViewLayout(this.b, e);
        }
        e = new LayoutParams(-2, -2);
        e.gravity = 85;
        e.bottomMargin = this.h + 5;
        e.rightMargin = 5;
        if (viewGroup.indexOfChild(this.c) < 0) {
            viewGroup.addView(this.c, e);
        } else {
            viewGroup.updateViewLayout(this.c, e);
        }
        AppMethodBeat.o(100418);
        return true;
    }

    public void a(b bVar) {
        AppMethodBeat.i(100419);
        if (this.e != bVar) {
            this.e = bVar;
            a(this.d);
        }
        AppMethodBeat.o(100419);
    }

    private void a(Context context) {
        AppMethodBeat.i(100420);
        this.c = new lk(context);
        this.c.setVisibility(8);
        c();
        try {
            this.b = new ZoomControls(context);
            this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.h = this.b.getMeasuredHeight();
            this.b.setVisibility(8);
            AppMethodBeat.o(100420);
        } catch (Exception e) {
            AppMethodBeat.o(100420);
        }
    }

    private void c() {
        AppMethodBeat.i(100421);
        Bitmap b = ic.b(ic.b(this.a, "location_enable.png"));
        Bitmap b2 = ic.b(ic.b(this.a, "location_state_normal.png"));
        Bitmap b3 = ic.b(ic.b(this.a, "location_state_selected.png"));
        this.c.setScaleType(ScaleType.CENTER);
        this.c.setImageBitmap(b);
        this.c.a(this.a, b2, b3);
        AppMethodBeat.o(100421);
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    private void d() {
        AppMethodBeat.i(100422);
        if (this.b != null) {
            this.b.setOnZoomInClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.i(100412);
                    lj.this.g.b().a(null);
                    AppMethodBeat.o(100412);
                }
            });
            this.b.setOnZoomOutClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.i(100413);
                    lj.this.g.b().b(null);
                    AppMethodBeat.o(100413);
                }
            });
        }
        this.c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AppMethodBeat.i(100414);
                if (lj.this.f != null) {
                    lj.this.f.a();
                }
                AppMethodBeat.o(100414);
            }
        });
        AppMethodBeat.o(100422);
    }

    public void a(boolean z, boolean z2) {
        AppMethodBeat.i(100423);
        if (this.b != null) {
            this.b.setIsZoomInEnabled(z);
            this.b.setIsZoomOutEnabled(z2);
        }
        AppMethodBeat.o(100423);
    }

    public void a(boolean z) {
        AppMethodBeat.i(100424);
        if (this.b != null) {
            this.b.setVisibility(z ? 0 : 4);
        }
        AppMethodBeat.o(100424);
    }

    public boolean b() {
        AppMethodBeat.i(100425);
        if (this.b == null) {
            AppMethodBeat.o(100425);
            return false;
        } else if (this.b.getVisibility() == 0) {
            AppMethodBeat.o(100425);
            return true;
        } else {
            AppMethodBeat.o(100425);
            return false;
        }
    }

    public void b(boolean z) {
        AppMethodBeat.i(100426);
        this.c.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(100426);
    }

    private LayoutParams e() {
        AppMethodBeat.i(100427);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        switch (this.e) {
            case LEFT_BOTTOM:
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = 5;
                layoutParams.leftMargin = 5;
                break;
            case CENTER_BOTTOM:
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = 5;
                break;
            case RIGHT_BOTTOM:
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = 5;
                layoutParams.rightMargin = 5;
                break;
            case LEFT_TOP:
                layoutParams.gravity = 51;
                layoutParams.topMargin = 5;
                layoutParams.leftMargin = 5;
                break;
            case CENTER_TOP:
                layoutParams.gravity = 49;
                layoutParams.topMargin = 5;
                break;
            case RIGHT_TOP:
                layoutParams.gravity = 53;
                layoutParams.topMargin = 5;
                layoutParams.rightMargin = 5;
                break;
            default:
                d.b("Unknown position:" + this.e);
                break;
        }
        AppMethodBeat.o(100427);
        return layoutParams;
    }
}
