package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.am;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public abstract class SnsBaseGalleryUI extends MMActivity implements a {
    private LinearLayout jXf;
    private LinearLayout rpj;
    r rpk;
    s rpl;
    private boolean rpm = true;
    private boolean rpn = true;
    private TextView rpo = null;
    protected SnsInfoFlip rpp;
    protected Button rpq;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        af.cnA().aa(3, true);
        this.rpj = (LinearLayout) findViewById(R.id.eh6);
        this.jXf = (LinearLayout) findViewById(R.id.m5);
        this.rpl = new s(this, this);
        f fVar = this.rpl;
        ab.i("MicroMsg.GalleryTitleManager", "onAttach");
        g.RQ();
        g.RO().eJo.a(218, fVar);
        com.tencent.mm.sdk.b.a.xxA.c(fVar.mip);
        com.tencent.mm.sdk.b.a.xxA.c(fVar.riJ);
    }

    public void onResume() {
        super.onResume();
        if (this.rpk != null) {
            this.rpk.refresh();
        }
    }

    public void addView(View view) {
        this.rpj.addView(view, new LayoutParams(-1, -1));
    }

    @SuppressLint({"ResourceAsColor"})
    public final void D(boolean z, int i) {
        this.rpk = new r(this, i, z);
        this.rpk.setBackgroundColor(R.color.a3p);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.rpk.getBackground().setAlpha(50);
        this.jXf.addView(this.rpk, layoutParams);
        this.rpk.setSnsSource(getIntent().getIntExtra("sns_source", 0));
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.rpl != null) {
            f fVar = this.rpl;
            ab.i("MicroMsg.GalleryTitleManager", "onDetch");
            g.RQ();
            g.RO().eJo.b(218, fVar);
            com.tencent.mm.sdk.b.a.xxA.d(fVar.mip);
            com.tencent.mm.sdk.b.a.xxA.d(fVar.riJ);
        }
        if (this.rpp != null) {
            SnsInfoFlip snsInfoFlip = this.rpp;
            if (snsInfoFlip.rsn != null && (snsInfoFlip.rsn instanceof MMGestureGallery)) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) snsInfoFlip.rsn;
                mMGestureGallery.zFC.release();
                mMGestureGallery.zFD.release();
                mMGestureGallery.zFB.release();
            }
            this.rpp.onDestroy();
        }
    }

    public int getLayoutId() {
        return R.layout.av9;
    }

    public void dh(String str, int i) {
        if (this.rpm && !af.cnn()) {
            n YT = af.cnF().YT(str);
            if (YT == null || YT.field_snsId == 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        }
    }

    public void onPause() {
        if (this.rpp != null) {
            this.rpp.onPause();
        }
        if (this.rpl != null) {
            s sVar = this.rpl;
            if (sVar.riC != null) {
                am amVar = new am();
                amVar.ctA.activity = (Activity) sVar.context;
                amVar.ctA.ctB = sVar.riC;
                com.tencent.mm.sdk.b.a.xxA.m(amVar);
                sVar.riC = null;
                sVar.cvo = 0;
                sVar.cvn = 0;
            }
        }
        super.onPause();
    }

    public final void gt(String str, String str2) {
        if (this.rpm) {
            setMMTitle(str);
            setMMSubTitle(str2);
        }
    }

    public void dg(String str, int i) {
    }

    public void crM() {
        int i = 8;
        boolean z = false;
        if (this.rpm) {
            int i2;
            if (this.rpn) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            setTitleVisibility(i2);
            if (this.rpk != null) {
                r rVar = this.rpk;
                if (!this.rpn) {
                    i = 0;
                }
                rVar.setVisibility(i);
            }
            if (!this.rpn) {
                z = true;
            }
            this.rpn = z;
        }
    }

    public final void crN() {
        this.rpn = false;
        setTitleVisibility(8);
        if (this.rpk != null) {
            this.rpk.setVisibility(8);
        }
    }
}
