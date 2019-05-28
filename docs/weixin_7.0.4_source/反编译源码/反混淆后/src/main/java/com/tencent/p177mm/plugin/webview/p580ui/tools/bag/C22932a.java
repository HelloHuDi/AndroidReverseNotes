package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.widget.C46700c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.a */
public final class C22932a {
    static final int uxY;
    boolean mIsShowing;
    int mScreenHeight;
    int mScreenWidth;
    C22934a uxZ;
    final C22933b uya;
    boolean uyb;
    PointF uyc = new PointF();
    boolean uyd;
    boolean uye;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.a$b */
    public interface C22933b {
        void daY();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.a$a */
    static final class C22934a extends FrameLayout {
        /* renamed from: WL */
        View f4404WL = findViewById(2131821019);
        Vibrator iVt;
        ImageView lBT = ((ImageView) findViewById(2131829163));

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.a$a$1 */
        class C145871 extends C46700c {
            C145871() {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(8142);
                C22934a.this.setVisibility(8);
                AppMethodBeat.m2505o(8142);
            }
        }

        public C22934a(Context context) {
            super(context);
            AppMethodBeat.m2504i(8143);
            this.iVt = (Vibrator) context.getSystemService("vibrator");
            LayoutInflater.from(context).inflate(2130971210, this);
            AppMethodBeat.m2505o(8143);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: af */
        public final void mo38525af(float f, float f2) {
            AppMethodBeat.m2504i(8144);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 1.0f, 1, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(50);
            this.lBT.startAnimation(scaleAnimation);
            AppMethodBeat.m2505o(8144);
        }
    }

    static {
        int i = C29876b.uyo;
        uxY = i * i;
    }

    public C22932a(C22933b c22933b) {
        AppMethodBeat.m2504i(8145);
        this.uya = c22933b;
        WindowManager windowManager = (WindowManager) C4996ah.getContext().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        if (C1443d.m3068iW(26)) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 85;
        layoutParams.width = C29876b.uyp;
        layoutParams.height = C29876b.uyp;
        layoutParams.x = 0;
        layoutParams.y = 0;
        this.uxZ = new C22934a(C4996ah.getContext());
        try {
            this.uxZ.setVisibility(8);
            windowManager.addView(this.uxZ, layoutParams);
            AppMethodBeat.m2505o(8145);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BagCancelController", "showCanceller add failed %s", e);
            AppMethodBeat.m2505o(8145);
        }
    }

    public final void daX() {
        AppMethodBeat.m2504i(8146);
        try {
            ((WindowManager) C4996ah.getContext().getSystemService("window")).removeView(this.uxZ);
            AppMethodBeat.m2505o(8146);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BagCancelController", "whenBagUnAttach remove failed %s", e);
            AppMethodBeat.m2505o(8146);
        }
    }
}
