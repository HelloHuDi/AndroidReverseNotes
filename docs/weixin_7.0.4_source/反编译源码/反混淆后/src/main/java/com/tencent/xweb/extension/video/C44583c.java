package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.xweb.extension.video.c */
public final class C44583c {
    C44582a ANs;
    boolean ANt = false;
    float ANu;
    /* renamed from: Yn */
    float f17539Yn;
    ImageView hZC = null;
    ImageView qyl;
    ImageView qym;
    private ImageView qyn = null;
    float ztc = 0.0f;

    /* renamed from: com.tencent.xweb.extension.video.c$1 */
    class C163861 implements OnTouchListener {
        C163861() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            float f = 0.0f;
            AppMethodBeat.m2504i(84564);
            if (motionEvent.getAction() == 0) {
                C44583c.this.ANt = false;
                C44583c.this.ztc = motionEvent.getX();
                if (C44583c.this.ANs != null) {
                    C44583c.this.ANs.aFw();
                }
            } else if (motionEvent.getAction() == 2) {
                float width = (float) C44583c.this.qyl.getWidth();
                float x = (float) ((int) ((motionEvent.getX() - C44583c.this.ztc) + width));
                if (x >= 0.0f) {
                    if (x > ((float) C44583c.this.qym.getWidth())) {
                        f = (float) C44583c.this.qym.getWidth();
                    } else {
                        f = x;
                    }
                }
                C44583c.this.ANu = (f * 100.0f) / ((float) C44583c.this.qym.getWidth());
                C44583c.this.mo71392c(C44583c.this.ANu, true);
                if (C44583c.this.ANs != null) {
                    C44583c.this.ANs.aFw();
                }
                C44583c.this.ANt = true;
            } else {
                if (C44583c.this.ANt && C44583c.this.ANs != null) {
                    C44583c.this.ANs.mo30108bw(C44583c.this.ANu);
                }
                C44583c.this.ANt = false;
            }
            AppMethodBeat.m2505o(84564);
            return true;
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.c$a */
    public interface C44582a {
        void aFw();

        /* renamed from: bw */
        void mo30108bw(float f);
    }

    public C44583c(FrameLayout frameLayout, C44582a c44582a) {
        AppMethodBeat.m2504i(84565);
        this.ANs = c44582a;
        this.qyl = (ImageView) frameLayout.findViewById(2131821425);
        this.hZC = (ImageView) frameLayout.findViewById(2131821424);
        this.qym = (ImageView) frameLayout.findViewById(2131821423);
        this.qyn = (ImageView) frameLayout.findViewById(2131821426);
        this.qyn.setOnTouchListener(new C163861());
        AppMethodBeat.m2505o(84565);
    }

    /* renamed from: c */
    public final void mo71392c(float f, boolean z) {
        AppMethodBeat.m2504i(84566);
        if (!this.ANt || z) {
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 100.0f) {
                f = 100.0f;
            }
            this.f17539Yn = f;
            LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
            layoutParams.leftMargin = (int) (((f / 100.0f) * ((float) this.qym.getWidth())) - ((float) (this.qyn.getWidth() / 2)));
            this.qyn.setLayoutParams(layoutParams);
            this.qyn.requestLayout();
            layoutParams = (LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) ((f / 100.0f) * ((float) this.qym.getWidth()));
            this.qyl.setLayoutParams(layoutParams);
            this.qyl.requestLayout();
            AppMethodBeat.m2505o(84566);
            return;
        }
        AppMethodBeat.m2505o(84566);
    }
}
