package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p230g.p231a.C41964am;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p520ui.C29238s.C29239a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI */
public abstract class SnsBaseGalleryUI extends MMActivity implements C29239a {
    private LinearLayout jXf;
    private LinearLayout rpj;
    C22140r rpk;
    C29238s rpl;
    private boolean rpm = true;
    private boolean rpn = true;
    private TextView rpo = null;
    protected SnsInfoFlip rpp;
    protected Button rpq;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C13373af.cnA().mo69140aa(3, true);
        this.rpj = (LinearLayout) findViewById(2131827690);
        this.jXf = (LinearLayout) findViewById(2131821019);
        this.rpl = new C29238s(this, this);
        C1202f c1202f = this.rpl;
        C4990ab.m7416i("MicroMsg.GalleryTitleManager", "onAttach");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(218, c1202f);
        C4879a.xxA.mo10052c(c1202f.mip);
        C4879a.xxA.mo10052c(c1202f.riJ);
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
    /* renamed from: D */
    public final void mo69187D(boolean z, int i) {
        this.rpk = new C22140r(this, i, z);
        this.rpk.setBackgroundColor(C25738R.color.a3p);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.rpk.getBackground().setAlpha(50);
        this.jXf.addView(this.rpk, layoutParams);
        this.rpk.setSnsSource(getIntent().getIntExtra("sns_source", 0));
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.rpl != null) {
            C1202f c1202f = this.rpl;
            C4990ab.m7416i("MicroMsg.GalleryTitleManager", "onDetch");
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(218, c1202f);
            C4879a.xxA.mo10053d(c1202f.mip);
            C4879a.xxA.mo10053d(c1202f.riJ);
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
        return 2130970761;
    }

    /* renamed from: dh */
    public void mo8728dh(String str, int i) {
        if (this.rpm && !C13373af.cnn()) {
            C46236n YT = C13373af.cnF().mo62918YT(str);
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
            C29238s c29238s = this.rpl;
            if (c29238s.riC != null) {
                C41964am c41964am = new C41964am();
                c41964am.ctA.activity = (Activity) c29238s.context;
                c41964am.ctA.ctB = c29238s.riC;
                C4879a.xxA.mo10055m(c41964am);
                c29238s.riC = null;
                c29238s.cvo = 0;
                c29238s.cvn = 0;
            }
        }
        super.onPause();
    }

    /* renamed from: gt */
    public final void mo47407gt(String str, String str2) {
        if (this.rpm) {
            setMMTitle(str);
            setMMSubTitle(str2);
        }
    }

    /* renamed from: dg */
    public void mo8727dg(String str, int i) {
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
                C22140r c22140r = this.rpk;
                if (!this.rpn) {
                    i = 0;
                }
                c22140r.setVisibility(i);
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
