package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class c {
    a ANs;
    boolean ANt = false;
    float ANu;
    float Yn;
    ImageView hZC = null;
    ImageView qyl;
    ImageView qym;
    private ImageView qyn = null;
    float ztc = 0.0f;

    public interface a {
        void aFw();

        void bw(float f);
    }

    public c(FrameLayout frameLayout, a aVar) {
        AppMethodBeat.i(84565);
        this.ANs = aVar;
        this.qyl = (ImageView) frameLayout.findViewById(R.id.x4);
        this.hZC = (ImageView) frameLayout.findViewById(R.id.x3);
        this.qym = (ImageView) frameLayout.findViewById(R.id.x2);
        this.qyn = (ImageView) frameLayout.findViewById(R.id.x5);
        this.qyn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 0.0f;
                AppMethodBeat.i(84564);
                if (motionEvent.getAction() == 0) {
                    c.this.ANt = false;
                    c.this.ztc = motionEvent.getX();
                    if (c.this.ANs != null) {
                        c.this.ANs.aFw();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float width = (float) c.this.qyl.getWidth();
                    float x = (float) ((int) ((motionEvent.getX() - c.this.ztc) + width));
                    if (x >= 0.0f) {
                        if (x > ((float) c.this.qym.getWidth())) {
                            f = (float) c.this.qym.getWidth();
                        } else {
                            f = x;
                        }
                    }
                    c.this.ANu = (f * 100.0f) / ((float) c.this.qym.getWidth());
                    c.this.c(c.this.ANu, true);
                    if (c.this.ANs != null) {
                        c.this.ANs.aFw();
                    }
                    c.this.ANt = true;
                } else {
                    if (c.this.ANt && c.this.ANs != null) {
                        c.this.ANs.bw(c.this.ANu);
                    }
                    c.this.ANt = false;
                }
                AppMethodBeat.o(84564);
                return true;
            }
        });
        AppMethodBeat.o(84565);
    }

    public final void c(float f, boolean z) {
        AppMethodBeat.i(84566);
        if (!this.ANt || z) {
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 100.0f) {
                f = 100.0f;
            }
            this.Yn = f;
            LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
            layoutParams.leftMargin = (int) (((f / 100.0f) * ((float) this.qym.getWidth())) - ((float) (this.qyn.getWidth() / 2)));
            this.qyn.setLayoutParams(layoutParams);
            this.qyn.requestLayout();
            layoutParams = (LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) ((f / 100.0f) * ((float) this.qym.getWidth()));
            this.qyl.setLayoutParams(layoutParams);
            this.qyl.requestLayout();
            AppMethodBeat.o(84566);
            return;
        }
        AppMethodBeat.o(84566);
    }
}
