package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetectlight.ui.container.a;

public final class e extends a {
    private RelativeLayout lYh;
    private RelativeLayout lYi;
    private ImageView lYj;
    private ImageView lYk;
    private ImageView lYl;

    public e(ViewGroup viewGroup, a aVar) {
        super(viewGroup, aVar);
    }

    public final int btU() {
        return R.layout.xc;
    }

    public final void initView() {
        AppMethodBeat.i(808);
        this.lYh = (RelativeLayout) findViewById(R.id.blk);
        this.lYi = (RelativeLayout) findViewById(R.id.blf);
        setVisibility(4);
        this.lYh.setVisibility(4);
        this.lYi.setVisibility(4);
        this.lYj = (ImageView) findViewById(R.id.blq);
        this.lYk = (ImageView) findViewById(R.id.blp);
        this.lYl = (ImageView) findViewById(R.id.blm);
        AppMethodBeat.o(808);
    }
}
