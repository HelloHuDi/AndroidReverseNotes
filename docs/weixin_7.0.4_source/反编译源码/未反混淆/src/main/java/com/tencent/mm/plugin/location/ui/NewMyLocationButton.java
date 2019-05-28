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

public class NewMyLocationButton extends FrameLayout {
    private Context context;
    private a ecy = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113462);
            if (z) {
                NewMyLocationButton.this.nLF.setVisibility(8);
                NewMyLocationButton.this.nLE.setVisibility(0);
                if (NewMyLocationButton.this.nLG != null && NewMyLocationButton.this.nLH) {
                    NewMyLocationButton.this.nLG.getIController().setCenter((double) f2, (double) f);
                    if (NewMyLocationButton.this.nLG.getZoomLevel() < 16) {
                        NewMyLocationButton.this.nLG.getIController().setZoom(16);
                    }
                }
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(113461);
                        d.agz().c(NewMyLocationButton.this.ecy);
                        AppMethodBeat.o(113461);
                    }
                });
                AppMethodBeat.o(113462);
                return false;
            }
            AppMethodBeat.o(113462);
            return false;
        }
    };
    private ImageButton nLE;
    private LinearLayout nLF;
    private com.tencent.mm.plugin.k.d nLG;
    private boolean nLH = true;

    public NewMyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113463);
        this.context = context;
        init();
        AppMethodBeat.o(113463);
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113464);
        this.context = context;
        init();
        AppMethodBeat.o(113464);
    }

    public void setAnimToSelf(boolean z) {
        this.nLH = z;
    }

    private void init() {
        AppMethodBeat.i(113465);
        View inflate = View.inflate(this.context, R.layout.aiv, this);
        this.nLE = (ImageButton) inflate.findViewById(R.id.di2);
        this.nLF = (LinearLayout) inflate.findViewById(R.id.di3);
        AppMethodBeat.o(113465);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(113466);
        this.nLE.setOnClickListener(onClickListener);
        AppMethodBeat.o(113466);
    }

    public void setProgressBar(com.tencent.mm.plugin.k.d dVar) {
        AppMethodBeat.i(113467);
        this.nLG = dVar;
        this.nLF.setVisibility(0);
        this.nLE.setVisibility(8);
        d.agz().b(this.ecy, true);
        AppMethodBeat.o(113467);
    }
}
