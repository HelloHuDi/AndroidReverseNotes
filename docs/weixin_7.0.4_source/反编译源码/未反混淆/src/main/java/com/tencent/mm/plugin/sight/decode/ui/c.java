package com.tencent.mm.plugin.sight.decode.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.io.File;

public final class c extends i implements a {
    public int cPL = 0;
    public String ePJ;
    private d iaf = new d();
    public String imagePath;
    private e klq = null;
    public int mik = 0;
    public int qxZ = 0;
    private TextView qyR = null;
    private boolean qyS = false;

    static /* synthetic */ void e(c cVar) {
        AppMethodBeat.i(70290);
        cVar.cln();
        AppMethodBeat.o(70290);
    }

    public c(Context context) {
        super(context, R.style.a0o);
        AppMethodBeat.i(70285);
        AppMethodBeat.o(70285);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(70286);
        long currentTimeMillis = System.currentTimeMillis();
        ab.d("MicroMsg.VideoPopupHelper", currentTimeMillis + " initView beg");
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(R.layout.ass);
        if (com.tencent.mm.booter.a.Ib() != null) {
            com.tencent.mm.booter.a.Ib().Id();
        }
        ab.d("MicroMsg.VideoPopupHelper", g.Mp() + " initView: fullpath:" + this.ePJ + ", imagepath:" + this.imagePath);
        this.qyR = (TextView) findViewById(R.id.bn0);
        findViewById(R.id.ee0).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bs7);
        viewGroup.setBackgroundResource(R.color.h4);
        ab.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
        if (com.tencent.mm.compatible.util.d.iW(14)) {
            this.klq = new VideoTextureView(getContext());
        } else {
            this.klq = new VideoSurfaceView(getContext());
        }
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewGroup.addView((View) this.klq, layoutParams);
        this.klq.setVideoCallback(new e.a() {
            public final void pL() {
                AppMethodBeat.i(70279);
                ab.d("MicroMsg.VideoPopupHelper", g.Mp() + " onPrepared");
                c.a(c.this);
                AppMethodBeat.o(70279);
            }

            public final void onError(int i, int i2) {
                AppMethodBeat.i(70280);
                ab.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
                c.this.klq.stop();
                b.A(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.ckW() + "[SightPopupHelper] on play video error, what " + i + " extra " + i2 + ", path=" + bo.bc(c.this.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                final String c = c.this.imagePath;
                final Bitmap a = o.ahl().a(c, com.tencent.mm.bz.a.getDensity(c.this.getContext()), c.this.getContext(), -1);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(70277);
                        ImageView imageView = (ImageView) c.this.findViewById(R.id.bs8);
                        imageView.setImageBitmap(a);
                        imageView.setVisibility(0);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        k.a(c.this.getContext(), intent, new File(c), "video/*");
                        try {
                            c.this.getContext().startActivity(Intent.createChooser(intent, c.this.getContext().getString(R.string.ue)));
                            AppMethodBeat.o(70277);
                        } catch (Exception e) {
                            ab.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                            h.g(c.this.getContext(), R.string.d7m, R.string.d7n);
                            AppMethodBeat.o(70277);
                        }
                    }
                });
                AppMethodBeat.o(70280);
            }

            public final void EA() {
                AppMethodBeat.i(70281);
                ab.d("MicroMsg.VideoPopupHelper", "on completion");
                c.this.qyR.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(70278);
                        c.this.qyR.setVisibility(0);
                        c.this.qyR.startAnimation(AnimationUtils.loadAnimation(c.this.getContext(), R.anim.b5));
                        AppMethodBeat.o(70278);
                    }
                });
                c.this.klq.setLoop(true);
                c.a(c.this);
                AppMethodBeat.o(70281);
            }

            public final int dG(int i, int i2) {
                return 0;
            }

            public final void dH(int i, int i2) {
            }
        });
        findViewById(R.id.bs7).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(70282);
                c.e(c.this);
                AppMethodBeat.o(70282);
            }
        });
        ((View) this.klq).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(70283);
                c.e(c.this);
                AppMethodBeat.o(70283);
            }
        });
        if (this.ePJ != null) {
            this.klq.stop();
            this.klq.setVideoPath(this.ePJ);
        }
        ab.d("MicroMsg.VideoPopupHelper", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        tn tnVar = new tn();
        tnVar.cPI.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        AppMethodBeat.o(70286);
    }

    private void cln() {
        AppMethodBeat.i(70287);
        ab.v("check", "onclick");
        if (this.klq.isPlaying()) {
            this.klq.pause();
            this.iaf.cy(false);
        }
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(70284);
                c.this.dismiss();
                AppMethodBeat.o(70284);
            }
        });
        AppMethodBeat.o(70287);
    }

    public final void dismiss() {
        AppMethodBeat.i(70288);
        ab.d("MicroMsg.VideoPopupHelper", "on dismiss");
        if (com.tencent.mm.booter.a.Ib() != null) {
            com.tencent.mm.booter.a.Ib().Ic();
        }
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
            findViewById(R.id.bs7).setOnClickListener(null);
        }
        if (!this.qyS && isShowing()) {
            tn tnVar = new tn();
            tnVar.cPI.type = 0;
            tnVar.cPI.cPJ = this.qxZ;
            tnVar.cPI.cPK = this.mik;
            tnVar.cPI.cPL = this.cPL;
            com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        }
        super.dismiss();
        this.iaf.cy(true);
        AppMethodBeat.o(70288);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(70289);
        if (cVar.klq.start()) {
            cVar.iaf.a(cVar);
            AppMethodBeat.o(70289);
            return;
        }
        cVar.cln();
        AppMethodBeat.o(70289);
    }
}
