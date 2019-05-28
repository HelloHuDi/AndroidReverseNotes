package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ak;

public class MyLocationButton extends FrameLayout {
    private Context context;
    public a ecy = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113448);
            if (z) {
                MyLocationButton.this.nLF.setVisibility(8);
                MyLocationButton.this.nLE.setVisibility(0);
                if (MyLocationButton.this.nLG != null && MyLocationButton.this.nLH) {
                    MyLocationButton.this.nLG.getIController().setCenter((double) f2, (double) f);
                    if (MyLocationButton.this.nLG.getZoomLevel() < 16) {
                        MyLocationButton.this.nLG.getIController().setZoom(16);
                    }
                }
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(113447);
                        d.agz().c(MyLocationButton.this.ecy);
                        AppMethodBeat.o(113447);
                    }
                });
                AppMethodBeat.o(113448);
                return false;
            }
            AppMethodBeat.o(113448);
            return false;
        }
    };
    private ImageButton nLE;
    private LinearLayout nLF;
    private com.tencent.mm.plugin.k.d nLG;
    private boolean nLH = true;

    public MyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113449);
        this.context = context;
        init();
        AppMethodBeat.o(113449);
    }

    public MyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113450);
        this.context = context;
        init();
        AppMethodBeat.o(113450);
    }

    public void setAnimToSelf(boolean z) {
        this.nLH = z;
    }

    private void init() {
        AppMethodBeat.i(113451);
        View inflate = View.inflate(this.context, R.layout.ai7, this);
        this.nLE = (ImageButton) inflate.findViewById(R.id.dfv);
        this.nLF = (LinearLayout) inflate.findViewById(R.id.oa);
        AppMethodBeat.o(113451);
    }

    public final void bJN() {
        AppMethodBeat.i(113452);
        this.nLE.setImageResource(R.drawable.alh);
        AppMethodBeat.o(113452);
    }

    public final void bJO() {
        AppMethodBeat.i(113453);
        this.nLE.setImageResource(R.drawable.ali);
        AppMethodBeat.o(113453);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(113454);
        this.nLE.setOnClickListener(onClickListener);
        AppMethodBeat.o(113454);
    }

    public void setProgressBar(com.tencent.mm.plugin.k.d dVar) {
        AppMethodBeat.i(113455);
        this.nLG = dVar;
        this.nLF.setVisibility(0);
        this.nLE.setVisibility(8);
        d.agz().b(this.ecy, true);
        AppMethodBeat.o(113455);
    }

    public ImageButton getMyLocationBtn() {
        return this.nLE;
    }

    public LinearLayout getProgressBar() {
        return this.nLF;
    }
}
