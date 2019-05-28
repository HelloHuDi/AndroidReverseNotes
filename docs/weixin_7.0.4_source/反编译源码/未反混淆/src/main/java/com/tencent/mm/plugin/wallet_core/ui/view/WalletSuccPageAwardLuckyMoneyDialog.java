package com.tencent.mm.plugin.wallet_core.ui.view;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.a.a.e;
import java.io.IOException;

@a(3)
public class WalletSuccPageAwardLuckyMoneyDialog extends MMActivity {
    private ViewGroup sis;
    private ImageView tOu;
    private e tOv;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47939);
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (d.iW(19)) {
            getWindow().setFlags(67108864, 67108864);
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_layer_info");
        if (byteArrayExtra == null) {
            ab.e("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", "WalletSuccPageAwardLuckyMoneyDialog onCreate error! cannot get layerInfoBytes!");
            finish();
        }
        this.tOv = new e();
        try {
            this.tOv.parseFrom(byteArrayExtra);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", e, "parse layer info byte error! %s", e.getMessage());
            finish();
        }
        this.sis = (ViewGroup) findViewById(R.id.a3u);
        this.tOu = (ImageView) findViewById(R.id.eh9);
        this.tOu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47937);
                WalletSuccPageAwardLuckyMoneyDialog.this.finish();
                AppMethodBeat.o(47937);
            }
        });
        final ViewGroup viewGroup = this.sis;
        AnonymousClass2 anonymousClass2 = new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
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
                AppMethodBeat.i(47938);
                viewGroup.startAnimation(scaleAnimation2);
                AppMethodBeat.o(47938);
            }
        });
        scaleAnimation2.setAnimationListener(anonymousClass2);
        if (viewGroup != null) {
            viewGroup.startAnimation(scaleAnimation);
        }
        AppMethodBeat.o(47939);
    }

    public final int getLayoutId() {
        return R.layout.b67;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
