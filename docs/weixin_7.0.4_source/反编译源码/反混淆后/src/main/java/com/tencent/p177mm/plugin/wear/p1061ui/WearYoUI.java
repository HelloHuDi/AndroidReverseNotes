package com.tencent.p177mm.plugin.wear.p1061ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C42077vk;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p1321d.C35554b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.wear.ui.WearYoUI */
public class WearYoUI extends Activity {
    private ImageView ejo;
    private TextView ejp;
    private Vibrator kgA;
    private C4884c sWj = new C297295();
    private ImageView tYQ;
    private ImageView tYR;
    private ImageView tYS;
    private ObjectAnimator[][] tYT = ((ObjectAnimator[][]) Array.newInstance(ObjectAnimator.class, new int[]{3, 3}));
    private C4884c tYU = new C297272();
    private boolean tYV;
    private AtomicInteger tYW = new AtomicInteger();
    private Runnable tYX = new C297303();
    private BroadcastReceiver tYY = new C297284();
    private String username;

    /* renamed from: com.tencent.mm.plugin.wear.ui.WearYoUI$1 */
    class C297261 implements OnClickListener {
        C297261() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26462);
            C43841a.cUn();
            C4990ab.m7417i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", WearYoUI.this.username);
            Intent intent = new Intent();
            intent.putExtra("Main_User", r0);
            intent.putExtra("From_fail_notify", true);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            C25985d.m41473f(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
            WearYoUI.this.finish();
            AppMethodBeat.m2505o(26462);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.ui.WearYoUI$2 */
    class C297272 extends C4884c<C42077vk> {
        C297272() {
            AppMethodBeat.m2504i(26463);
            this.xxI = C42077vk.class.getName().hashCode();
            AppMethodBeat.m2505o(26463);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26464);
            C42077vk c42077vk = (C42077vk) c4883b;
            if (c42077vk instanceof C42077vk) {
                switch (c42077vk.cSs.cuy) {
                    case 1:
                        if (!WearYoUI.this.username.equals(c42077vk.cSs.username)) {
                            c42077vk.cSt.cSu = 2;
                            break;
                        }
                        c42077vk.cSt.cSu = 1;
                        break;
                    case 2:
                        if (WearYoUI.this.username.equals(c42077vk.cSs.username)) {
                            WearYoUI.m47131b(WearYoUI.this);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(26464);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.ui.WearYoUI$4 */
    class C297284 extends BroadcastReceiver {
        C297284() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(26466);
            if (intent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
                WearYoUI.this.finish();
            }
            AppMethodBeat.m2505o(26466);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.ui.WearYoUI$5 */
    class C297295 extends C4884c<C26171jl> {
        C297295() {
            AppMethodBeat.m2504i(26467);
            this.xxI = C26171jl.class.getName().hashCode();
            AppMethodBeat.m2505o(26467);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26468);
            if (((C26171jl) c4883b) instanceof C26171jl) {
                WearYoUI.this.finish();
            }
            AppMethodBeat.m2505o(26468);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.ui.WearYoUI$3 */
    class C297303 implements Runnable {
        C297303() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26465);
            WearYoUI.this.kgA.vibrate(200);
            WearYoUI.this.ejo.animate().scaleX(1.2f);
            WearYoUI.this.ejo.animate().scaleY(1.2f);
            WearYoUI.this.ejo.animate().setDuration(200);
            WearYoUI.this.ejo.animate().start();
            WearYoUI.this.ejo.animate().setListener(new C29731a(1));
            AppMethodBeat.m2505o(26465);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.ui.WearYoUI$a */
    class C29731a implements AnimatorListener {
        private int hzv = 1;

        public C29731a(int i) {
            this.hzv = i;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(26469);
            if (this.hzv == 2) {
                C4990ab.m7419v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", Integer.valueOf(WearYoUI.this.tYW.get()));
                if (WearYoUI.this.tYW.get() > 0) {
                    WearYoUI.this.tYW.decrementAndGet();
                    C5004al.m7442n(WearYoUI.this.tYX, 1000);
                    AppMethodBeat.m2505o(26469);
                    return;
                }
                WearYoUI.this.ejo.animate().setListener(null);
                WearYoUI.this.tYV = false;
                AppMethodBeat.m2505o(26469);
                return;
            }
            if (this.hzv == 1) {
                WearYoUI.this.ejo.animate().scaleX(1.0f);
                WearYoUI.this.ejo.animate().scaleY(1.0f);
                WearYoUI.this.ejo.animate().setDuration(100);
                WearYoUI.this.ejo.animate().start();
                WearYoUI.this.ejo.animate().setListener(new C29731a(2));
            }
            AppMethodBeat.m2505o(26469);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(26470);
            WearYoUI.this.tYV = false;
            AppMethodBeat.m2505o(26470);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WearYoUI() {
        AppMethodBeat.m2504i(26471);
        AppMethodBeat.m2505o(26471);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26472);
        super.onCreate(bundle);
        getWindow().addFlags(4718592);
        setContentView(2130971200);
        this.kgA = (Vibrator) getSystemService("vibrator");
        this.username = getIntent().getStringExtra("key_talker");
        this.ejo = (ImageView) findViewById(2131821183);
        this.ejp = (TextView) findViewById(2131823149);
        this.tYQ = (ImageView) findViewById(2131829145);
        this.tYR = (ImageView) findViewById(2131829146);
        this.tYS = (ImageView) findViewById(2131829147);
        C40460b.m69437r(this.ejo, this.username);
        this.ejp.setText(C1854s.m3866mJ(this.username));
        this.ejo.setOnClickListener(new C297261());
        C4879a.xxA.mo10052c(this.tYU);
        C4879a.xxA.mo10052c(this.sWj);
        m47130a(0, this.tYQ, 0);
        m47130a(1, this.tYR, 1300);
        m47130a(2, this.tYS, 2600);
        this.kgA.vibrate(200);
        registerReceiver(this.tYY, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        overridePendingTransition(C25738R.anim.f8314aj, C25738R.anim.f8315ak);
        AppMethodBeat.m2505o(26472);
    }

    /* renamed from: a */
    private void m47130a(int i, ImageView imageView, long j) {
        AppMethodBeat.m2504i(26473);
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
        AppMethodBeat.m2505o(26473);
    }

    public void onClickCheck(View view) {
        AppMethodBeat.m2504i(26474);
        C4990ab.m7417i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", this.username);
        C9638aw.m17182Rg().mo14541a(new C35554b(this.username), 0);
        finish();
        AppMethodBeat.m2505o(26474);
    }

    public void onClickNoCheck(View view) {
        AppMethodBeat.m2504i(26475);
        C4990ab.m7417i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", this.username);
        finish();
        AppMethodBeat.m2505o(26475);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(26476);
        for (int i = 0; i < this.tYT.length; i++) {
            for (ObjectAnimator cancel : this.tYT[i]) {
                cancel.cancel();
            }
        }
        unregisterReceiver(this.tYY);
        C4879a.xxA.mo10053d(this.sWj);
        C4879a.xxA.mo10053d(this.tYU);
        C43841a.cUn().tXA.cUD();
        super.onDestroy();
        AppMethodBeat.m2505o(26476);
    }

    /* renamed from: b */
    static /* synthetic */ void m47131b(WearYoUI wearYoUI) {
        AppMethodBeat.m2504i(26477);
        if (wearYoUI.tYV) {
            wearYoUI.tYW.addAndGet(1);
            C4990ab.m7419v("MicroMsg.Wear.WearYoUI", "startAnimation count: %d", Integer.valueOf(wearYoUI.tYW.get()));
            AppMethodBeat.m2505o(26477);
            return;
        }
        wearYoUI.tYV = true;
        C5004al.m7441d(wearYoUI.tYX);
        AppMethodBeat.m2505o(26477);
    }
}
