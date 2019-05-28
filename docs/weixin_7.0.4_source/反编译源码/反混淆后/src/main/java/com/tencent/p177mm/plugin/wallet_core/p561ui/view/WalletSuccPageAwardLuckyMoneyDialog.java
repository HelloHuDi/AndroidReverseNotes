package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import p1121d.p1122a.p1123a.C31177e;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog */
public class WalletSuccPageAwardLuckyMoneyDialog extends MMActivity {
    private ViewGroup sis;
    private ImageView tOu;
    private C31177e tOv;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog$1 */
    class C226421 implements OnClickListener {
        C226421() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47937);
            WalletSuccPageAwardLuckyMoneyDialog.this.finish();
            AppMethodBeat.m2505o(47937);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardLuckyMoneyDialog$2 */
    class C226432 implements AnimationListener {
        C226432() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47939);
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (C1443d.m3068iW(19)) {
            getWindow().setFlags(67108864, 67108864);
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_layer_info");
        if (byteArrayExtra == null) {
            C4990ab.m7412e("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", "WalletSuccPageAwardLuckyMoneyDialog onCreate error! cannot get layerInfoBytes!");
            finish();
        }
        this.tOv = new C31177e();
        try {
            this.tOv.parseFrom(byteArrayExtra);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", e, "parse layer info byte error! %s", e.getMessage());
            finish();
        }
        this.sis = (ViewGroup) findViewById(2131821686);
        this.tOu = (ImageView) findViewById(2131827693);
        this.tOu.setOnClickListener(new C226421());
        final ViewGroup viewGroup = this.sis;
        C226432 c226432 = new C226432();
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(47938);
                viewGroup.startAnimation(scaleAnimation2);
                AppMethodBeat.m2505o(47938);
            }
        });
        scaleAnimation2.setAnimationListener(c226432);
        if (viewGroup != null) {
            viewGroup.startAnimation(scaleAnimation);
        }
        AppMethodBeat.m2505o(47939);
    }

    public final int getLayoutId() {
        return 2130971170;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
