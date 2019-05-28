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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.location.ui.MyLocationButton */
public class MyLocationButton extends FrameLayout {
    private Context context;
    public C42206a ecy = new C283701();
    private ImageButton nLE;
    private LinearLayout nLF;
    private C28354d nLG;
    private boolean nLH = true;

    /* renamed from: com.tencent.mm.plugin.location.ui.MyLocationButton$1 */
    class C283701 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.location.ui.MyLocationButton$1$1 */
        class C123811 implements Runnable {
            C123811() {
            }

            public final void run() {
                AppMethodBeat.m2504i(113447);
                C26443d.agz().mo44208c(MyLocationButton.this.ecy);
                AppMethodBeat.m2505o(113447);
            }
        }

        C283701() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113448);
            if (z) {
                MyLocationButton.this.nLF.setVisibility(8);
                MyLocationButton.this.nLE.setVisibility(0);
                if (MyLocationButton.this.nLG != null && MyLocationButton.this.nLH) {
                    MyLocationButton.this.nLG.getIController().setCenter((double) f2, (double) f);
                    if (MyLocationButton.this.nLG.getZoomLevel() < 16) {
                        MyLocationButton.this.nLG.getIController().setZoom(16);
                    }
                }
                new C7306ak(Looper.getMainLooper()).post(new C123811());
                AppMethodBeat.m2505o(113448);
                return false;
            }
            AppMethodBeat.m2505o(113448);
            return false;
        }
    }

    public MyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113449);
        this.context = context;
        init();
        AppMethodBeat.m2505o(113449);
    }

    public MyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113450);
        this.context = context;
        init();
        AppMethodBeat.m2505o(113450);
    }

    public void setAnimToSelf(boolean z) {
        this.nLH = z;
    }

    private void init() {
        AppMethodBeat.m2504i(113451);
        View inflate = View.inflate(this.context, 2130970278, this);
        this.nLE = (ImageButton) inflate.findViewById(2131826273);
        this.nLF = (LinearLayout) inflate.findViewById(2131821099);
        AppMethodBeat.m2505o(113451);
    }

    public final void bJN() {
        AppMethodBeat.m2504i(113452);
        this.nLE.setImageResource(C25738R.drawable.alh);
        AppMethodBeat.m2505o(113452);
    }

    public final void bJO() {
        AppMethodBeat.m2504i(113453);
        this.nLE.setImageResource(C25738R.drawable.ali);
        AppMethodBeat.m2505o(113453);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(113454);
        this.nLE.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(113454);
    }

    public void setProgressBar(C28354d c28354d) {
        AppMethodBeat.m2504i(113455);
        this.nLG = c28354d;
        this.nLF.setVisibility(0);
        this.nLE.setVisibility(8);
        C26443d.agz().mo44207b(this.ecy, true);
        AppMethodBeat.m2505o(113455);
    }

    public ImageButton getMyLocationBtn() {
        return this.nLE;
    }

    public LinearLayout getProgressBar() {
        return this.nLF;
    }
}
