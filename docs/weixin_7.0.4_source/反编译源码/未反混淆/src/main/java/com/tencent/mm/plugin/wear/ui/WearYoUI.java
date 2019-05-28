package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI extends Activity {
    private ImageView ejo;
    private TextView ejp;
    private Vibrator kgA;
    private c sWj = new c<jl>() {
        {
            AppMethodBeat.i(26467);
            this.xxI = jl.class.getName().hashCode();
            AppMethodBeat.o(26467);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26468);
            if (((jl) bVar) instanceof jl) {
                WearYoUI.this.finish();
            }
            AppMethodBeat.o(26468);
            return false;
        }
    };
    private ImageView tYQ;
    private ImageView tYR;
    private ImageView tYS;
    private ObjectAnimator[][] tYT = ((ObjectAnimator[][]) Array.newInstance(ObjectAnimator.class, new int[]{3, 3}));
    private c tYU = new c<vk>() {
        {
            AppMethodBeat.i(26463);
            this.xxI = vk.class.getName().hashCode();
            AppMethodBeat.o(26463);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26464);
            vk vkVar = (vk) bVar;
            if (vkVar instanceof vk) {
                switch (vkVar.cSs.cuy) {
                    case 1:
                        if (!WearYoUI.this.username.equals(vkVar.cSs.username)) {
                            vkVar.cSt.cSu = 2;
                            break;
                        }
                        vkVar.cSt.cSu = 1;
                        break;
                    case 2:
                        if (WearYoUI.this.username.equals(vkVar.cSs.username)) {
                            WearYoUI.b(WearYoUI.this);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(26464);
            return false;
        }
    };
    private boolean tYV;
    private AtomicInteger tYW = new AtomicInteger();
    private Runnable tYX = new Runnable() {
        public final void run() {
            AppMethodBeat.i(26465);
            WearYoUI.this.kgA.vibrate(200);
            WearYoUI.this.ejo.animate().scaleX(1.2f);
            WearYoUI.this.ejo.animate().scaleY(1.2f);
            WearYoUI.this.ejo.animate().setDuration(200);
            WearYoUI.this.ejo.animate().start();
            WearYoUI.this.ejo.animate().setListener(new a(1));
            AppMethodBeat.o(26465);
        }
    };
    private BroadcastReceiver tYY = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(26466);
            if (intent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
                WearYoUI.this.finish();
            }
            AppMethodBeat.o(26466);
        }
    };
    private String username;

    class a implements AnimatorListener {
        private int hzv = 1;

        public a(int i) {
            this.hzv = i;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(26469);
            if (this.hzv == 2) {
                ab.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", Integer.valueOf(WearYoUI.this.tYW.get()));
                if (WearYoUI.this.tYW.get() > 0) {
                    WearYoUI.this.tYW.decrementAndGet();
                    al.n(WearYoUI.this.tYX, 1000);
                    AppMethodBeat.o(26469);
                    return;
                }
                WearYoUI.this.ejo.animate().setListener(null);
                WearYoUI.this.tYV = false;
                AppMethodBeat.o(26469);
                return;
            }
            if (this.hzv == 1) {
                WearYoUI.this.ejo.animate().scaleX(1.0f);
                WearYoUI.this.ejo.animate().scaleY(1.0f);
                WearYoUI.this.ejo.animate().setDuration(100);
                WearYoUI.this.ejo.animate().start();
                WearYoUI.this.ejo.animate().setListener(new a(2));
            }
            AppMethodBeat.o(26469);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(26470);
            WearYoUI.this.tYV = false;
            AppMethodBeat.o(26470);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WearYoUI() {
        AppMethodBeat.i(26471);
        AppMethodBeat.o(26471);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26472);
        super.onCreate(bundle);
        getWindow().addFlags(4718592);
        setContentView(R.layout.b70);
        this.kgA = (Vibrator) getSystemService("vibrator");
        this.username = getIntent().getStringExtra("key_talker");
        this.ejo = (ImageView) findViewById(R.id.qk);
        this.ejp = (TextView) findViewById(R.id.b6e);
        this.tYQ = (ImageView) findViewById(R.id.fjh);
        this.tYR = (ImageView) findViewById(R.id.fji);
        this.tYS = (ImageView) findViewById(R.id.fjj);
        com.tencent.mm.pluginsdk.ui.a.b.r(this.ejo, this.username);
        this.ejp.setText(s.mJ(this.username));
        this.ejo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26462);
                com.tencent.mm.plugin.wear.model.a.cUn();
                ab.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", WearYoUI.this.username);
                Intent intent = new Intent();
                intent.putExtra("Main_User", r0);
                intent.putExtra("From_fail_notify", true);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                WearYoUI.this.finish();
                AppMethodBeat.o(26462);
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.tYU);
        com.tencent.mm.sdk.b.a.xxA.c(this.sWj);
        a(0, this.tYQ, 0);
        a(1, this.tYR, 1300);
        a(2, this.tYS, 2600);
        this.kgA.vibrate(200);
        registerReceiver(this.tYY, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        overridePendingTransition(R.anim.aj, R.anim.ak);
        AppMethodBeat.o(26472);
    }

    private void a(int i, ImageView imageView, long j) {
        AppMethodBeat.i(26473);
        this.tYT[i][0] = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 2.5f});
        this.tYT[i][0].setRepeatCount(-1);
        this.tYT[i][0].setStartDelay(j);
        this.tYT[i][0].setDuration(3900);
        this.tYT[i][0].start();
        this.tYT[i][1] = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 2.5f});
        this.tYT[i][1].setRepeatCount(-1);
        this.tYT[i][1].setStartDelay(j);
        this.tYT[i][1].setDuration(3900);
        this.tYT[i][1].start();
        this.tYT[i][2] = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{1.0f, 0.0f});
        this.tYT[i][2].setRepeatCount(-1);
        this.tYT[i][2].setInterpolator(new AccelerateInterpolator());
        this.tYT[i][2].setStartDelay(j);
        this.tYT[i][2].setDuration(3900);
        this.tYT[i][2].start();
        AppMethodBeat.o(26473);
    }

    public void onClickCheck(View view) {
        AppMethodBeat.i(26474);
        ab.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", this.username);
        aw.Rg().a(new com.tencent.mm.plugin.wear.model.d.b(this.username), 0);
        finish();
        AppMethodBeat.o(26474);
    }

    public void onClickNoCheck(View view) {
        AppMethodBeat.i(26475);
        ab.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", this.username);
        finish();
        AppMethodBeat.o(26475);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(26476);
        for (int i = 0; i < this.tYT.length; i++) {
            for (ObjectAnimator cancel : this.tYT[i]) {
                cancel.cancel();
            }
        }
        unregisterReceiver(this.tYY);
        com.tencent.mm.sdk.b.a.xxA.d(this.sWj);
        com.tencent.mm.sdk.b.a.xxA.d(this.tYU);
        com.tencent.mm.plugin.wear.model.a.cUn().tXA.cUD();
        super.onDestroy();
        AppMethodBeat.o(26476);
    }

    static /* synthetic */ void b(WearYoUI wearYoUI) {
        AppMethodBeat.i(26477);
        if (wearYoUI.tYV) {
            wearYoUI.tYW.addAndGet(1);
            ab.v("MicroMsg.Wear.WearYoUI", "startAnimation count: %d", Integer.valueOf(wearYoUI.tYW.get()));
            AppMethodBeat.o(26477);
            return;
        }
        wearYoUI.tYV = true;
        al.d(wearYoUI.tYX);
        AppMethodBeat.o(26477);
    }
}
