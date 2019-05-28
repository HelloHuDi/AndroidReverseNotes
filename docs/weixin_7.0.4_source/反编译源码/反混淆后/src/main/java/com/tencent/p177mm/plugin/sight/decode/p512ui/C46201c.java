package com.tencent.p177mm.plugin.sight.decode.p512ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C1321a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoSurfaceView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.sight.decode.ui.c */
public final class C46201c extends C15532i implements C42190a {
    public int cPL = 0;
    public String ePJ;
    private C42192d iaf = new C42192d();
    public String imagePath;
    private C14979e klq = null;
    public int mik = 0;
    public int qxZ = 0;
    private TextView qyR = null;
    private boolean qyS = false;

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.c$1 */
    class C38561 implements C14981a {

        /* renamed from: com.tencent.mm.plugin.sight.decode.ui.c$1$2 */
        class C38582 implements Runnable {
            C38582() {
            }

            public final void run() {
                AppMethodBeat.m2504i(70278);
                C46201c.this.qyR.setVisibility(0);
                C46201c.this.qyR.startAnimation(AnimationUtils.loadAnimation(C46201c.this.getContext(), C25738R.anim.f8332b5));
                AppMethodBeat.m2505o(70278);
            }
        }

        C38561() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(70279);
            C4990ab.m7410d("MicroMsg.VideoPopupHelper", C1447g.m3074Mp() + " onPrepared");
            C46201c.m86392a(C46201c.this);
            AppMethodBeat.m2505o(70279);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(70280);
            C4990ab.m7413e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
            C46201c.this.klq.stop();
            C4872b.m7233A(Base64.encodeToString((C21846d.ckW() + "[SightPopupHelper] on play video error, what " + i + " extra " + i2 + ", path=" + C5046bo.m7532bc(C46201c.this.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
            final String c = C46201c.this.imagePath;
            final Bitmap a = C32291o.ahl().mo73086a(c, C1338a.getDensity(C46201c.this.getContext()), C46201c.this.getContext(), -1);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(70277);
                    ImageView imageView = (ImageView) C46201c.this.findViewById(2131823993);
                    imageView.setImageBitmap(a);
                    imageView.setVisibility(0);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23713a(C46201c.this.getContext(), intent, new File(c), "video/*");
                    try {
                        C46201c.this.getContext().startActivity(Intent.createChooser(intent, C46201c.this.getContext().getString(C25738R.string.f9254ue)));
                        AppMethodBeat.m2505o(70277);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                        C30379h.m48467g(C46201c.this.getContext(), C25738R.string.d7m, C25738R.string.d7n);
                        AppMethodBeat.m2505o(70277);
                    }
                }
            });
            AppMethodBeat.m2505o(70280);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(70281);
            C4990ab.m7410d("MicroMsg.VideoPopupHelper", "on completion");
            C46201c.this.qyR.post(new C38582());
            C46201c.this.klq.setLoop(true);
            C46201c.m86392a(C46201c.this);
            AppMethodBeat.m2505o(70281);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.c$2 */
    class C349182 implements OnClickListener {
        C349182() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(70282);
            C46201c.m86396e(C46201c.this);
            AppMethodBeat.m2505o(70282);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.c$3 */
    class C349193 implements OnClickListener {
        C349193() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(70283);
            C46201c.m86396e(C46201c.this);
            AppMethodBeat.m2505o(70283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.c$4 */
    class C349204 implements Runnable {
        C349204() {
        }

        public final void run() {
            AppMethodBeat.m2504i(70284);
            C46201c.this.dismiss();
            AppMethodBeat.m2505o(70284);
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m86396e(C46201c c46201c) {
        AppMethodBeat.m2504i(70290);
        c46201c.cln();
        AppMethodBeat.m2505o(70290);
    }

    public C46201c(Context context) {
        super(context, C25738R.style.a0o);
        AppMethodBeat.m2504i(70285);
        AppMethodBeat.m2505o(70285);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(70286);
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7410d("MicroMsg.VideoPopupHelper", currentTimeMillis + " initView beg");
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(2130970671);
        if (C1321a.m2829Ib() != null) {
            C1321a.m2829Ib().mo4649Id();
        }
        C4990ab.m7410d("MicroMsg.VideoPopupHelper", C1447g.m3074Mp() + " initView: fullpath:" + this.ePJ + ", imagepath:" + this.imagePath);
        this.qyR = (TextView) findViewById(2131823800);
        findViewById(2131827573).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewById(2131823992);
        viewGroup.setBackgroundResource(C25738R.color.f11782h4);
        C4990ab.m7416i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
        if (C1443d.m3068iW(14)) {
            this.klq = new VideoTextureView(getContext());
        } else {
            this.klq = new VideoSurfaceView(getContext());
        }
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewGroup.addView((View) this.klq, layoutParams);
        this.klq.setVideoCallback(new C38561());
        findViewById(2131823992).setOnClickListener(new C349182());
        ((View) this.klq).setOnClickListener(new C349193());
        if (this.ePJ != null) {
            this.klq.stop();
            this.klq.setVideoPath(this.ePJ);
        }
        C4990ab.m7410d("MicroMsg.VideoPopupHelper", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 1;
        C4879a.xxA.mo10055m(c6550tn);
        AppMethodBeat.m2505o(70286);
    }

    private void cln() {
        AppMethodBeat.m2504i(70287);
        C4990ab.m7418v("check", "onclick");
        if (this.klq.isPlaying()) {
            this.klq.pause();
            this.iaf.mo67733cy(false);
        }
        new C7306ak().post(new C349204());
        AppMethodBeat.m2505o(70287);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(70288);
        C4990ab.m7410d("MicroMsg.VideoPopupHelper", "on dismiss");
        if (C1321a.m2829Ib() != null) {
            C1321a.m2829Ib().mo4648Ic();
        }
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
            findViewById(2131823992).setOnClickListener(null);
        }
        if (!this.qyS && isShowing()) {
            C6550tn c6550tn = new C6550tn();
            c6550tn.cPI.type = 0;
            c6550tn.cPI.cPJ = this.qxZ;
            c6550tn.cPI.cPK = this.mik;
            c6550tn.cPI.cPL = this.cPL;
            C4879a.xxA.mo10055m(c6550tn);
        }
        super.dismiss();
        this.iaf.mo67733cy(true);
        AppMethodBeat.m2505o(70288);
    }

    /* renamed from: a */
    static /* synthetic */ void m86392a(C46201c c46201c) {
        AppMethodBeat.m2504i(70289);
        if (c46201c.klq.start()) {
            c46201c.iaf.mo67732a(c46201c);
            AppMethodBeat.m2505o(70289);
            return;
        }
        c46201c.cln();
        AppMethodBeat.m2505o(70289);
    }
}
