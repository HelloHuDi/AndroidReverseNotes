package com.tencent.p177mm.plugin.facedetectlight.p405ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.container.C20670a;

/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.e */
public final class C39035e extends C11826a {
    private RelativeLayout lYh;
    private RelativeLayout lYi;
    private ImageView lYj;
    private ImageView lYk;
    private ImageView lYl;

    public C39035e(ViewGroup viewGroup, C20670a c20670a) {
        super(viewGroup, c20670a);
    }

    public final int btU() {
        return 2130969468;
    }

    public final void initView() {
        AppMethodBeat.m2504i(808);
        this.lYh = (RelativeLayout) findViewById(2131823747);
        this.lYi = (RelativeLayout) findViewById(2131823742);
        setVisibility(4);
        this.lYh.setVisibility(4);
        this.lYi.setVisibility(4);
        this.lYj = (ImageView) findViewById(2131823753);
        this.lYk = (ImageView) findViewById(2131823752);
        this.lYl = (ImageView) findViewById(2131823749);
        AppMethodBeat.m2505o(808);
    }
}
