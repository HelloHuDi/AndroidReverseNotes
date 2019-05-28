package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    static final int uxY;
    boolean mIsShowing;
    int mScreenHeight;
    int mScreenWidth;
    a uxZ;
    final b uya;
    boolean uyb;
    PointF uyc = new PointF();
    boolean uyd;
    boolean uye;

    public interface b {
        void daY();
    }

    static final class a extends FrameLayout {
        View WL = findViewById(R.id.m5);
        Vibrator iVt;
        ImageView lBT = ((ImageView) findViewById(R.id.fjz));

        public a(Context context) {
            super(context);
            AppMethodBeat.i(8143);
            this.iVt = (Vibrator) context.getSystemService("vibrator");
            LayoutInflater.from(context).inflate(R.layout.b7_, this);
            AppMethodBeat.o(8143);
        }

        /* Access modifiers changed, original: final */
        public final void af(float f, float f2) {
            AppMethodBeat.i(8144);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 1.0f, 1, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(50);
            this.lBT.startAnimation(scaleAnimation);
            AppMethodBeat.o(8144);
        }
    }

    static {
        int i = b.uyo;
        uxY = i * i;
    }

    public a(b bVar) {
        AppMethodBeat.i(8145);
        this.uya = bVar;
        WindowManager windowManager = (WindowManager) ah.getContext().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        if (d.iW(26)) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 85;
        layoutParams.width = b.uyp;
        layoutParams.height = b.uyp;
        layoutParams.x = 0;
        layoutParams.y = 0;
        this.uxZ = new a(ah.getContext());
        try {
            this.uxZ.setVisibility(8);
            windowManager.addView(this.uxZ, layoutParams);
            AppMethodBeat.o(8145);
        } catch (Exception e) {
            ab.e("MicroMsg.BagCancelController", "showCanceller add failed %s", e);
            AppMethodBeat.o(8145);
        }
    }

    public final void daX() {
        AppMethodBeat.i(8146);
        try {
            ((WindowManager) ah.getContext().getSystemService("window")).removeView(this.uxZ);
            AppMethodBeat.o(8146);
        } catch (Exception e) {
            ab.e("MicroMsg.BagCancelController", "whenBagUnAttach remove failed %s", e);
            AppMethodBeat.o(8146);
        }
    }
}
