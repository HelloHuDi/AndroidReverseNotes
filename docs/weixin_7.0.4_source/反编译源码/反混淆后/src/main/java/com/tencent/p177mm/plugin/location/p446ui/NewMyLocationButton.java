package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.location.ui.NewMyLocationButton */
public class NewMyLocationButton extends FrameLayout {
    private Context context;
    private C42206a ecy = new C344071();
    private ImageButton nLE;
    private LinearLayout nLF;
    private C28354d nLG;
    private boolean nLH = true;

    /* renamed from: com.tencent.mm.plugin.location.ui.NewMyLocationButton$1 */
    class C344071 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.location.ui.NewMyLocationButton$1$1 */
        class C344081 implements Runnable {
            C344081() {
            }

            public final void run() {
                AppMethodBeat.m2504i(113461);
                C26443d.agz().mo44208c(NewMyLocationButton.this.ecy);
                AppMethodBeat.m2505o(113461);
            }
        }

        C344071() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113462);
            if (z) {
                NewMyLocationButton.this.nLF.setVisibility(8);
                NewMyLocationButton.this.nLE.setVisibility(0);
                if (NewMyLocationButton.this.nLG != null && NewMyLocationButton.this.nLH) {
                    NewMyLocationButton.this.nLG.getIController().setCenter((double) f2, (double) f);
                    if (NewMyLocationButton.this.nLG.getZoomLevel() < 16) {
                        NewMyLocationButton.this.nLG.getIController().setZoom(16);
                    }
                }
                new C7306ak(Looper.getMainLooper()).post(new C344081());
                AppMethodBeat.m2505o(113462);
                return false;
            }
            AppMethodBeat.m2505o(113462);
            return false;
        }
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113463);
        this.context = context;
        init();
        AppMethodBeat.m2505o(113463);
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113464);
        this.context = context;
        init();
        AppMethodBeat.m2505o(113464);
    }

    public void setAnimToSelf(boolean z) {
        this.nLH = z;
    }

    private void init() {
        AppMethodBeat.m2504i(113465);
        View inflate = View.inflate(this.context, 2130970303, this);
        this.nLE = (ImageButton) inflate.findViewById(2131826354);
        this.nLF = (LinearLayout) inflate.findViewById(2131826355);
        AppMethodBeat.m2505o(113465);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(113466);
        this.nLE.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(113466);
    }

    public void setProgressBar(C28354d c28354d) {
        AppMethodBeat.m2504i(113467);
        this.nLG = c28354d;
        this.nLF.setVisibility(0);
        this.nLE.setVisibility(8);
        C26443d.agz().mo44207b(this.ecy, true);
        AppMethodBeat.m2505o(113467);
    }
}
