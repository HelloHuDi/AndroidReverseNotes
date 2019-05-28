package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.location_soso.ViewManager;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

/* renamed from: com.tencent.mm.plugin.location.ui.n */
public final class C12403n implements C34411c {
    public boolean czr = false;
    public String eUu;
    public boolean isVisible = true;
    private Context mContext;
    public ViewManager mViewManager;
    private String nJq;
    public double nJu = 1000000.0d;
    public double nJv = 1000000.0d;
    public boolean nLW = true;
    private View nLX;
    private TextView nLs;
    private ProgressBar nLt;
    private String nLw = "";
    public FrameLayout nOA;
    private TextView nOB;
    public boolean nOC;
    public final String nOy = "info_window_tag";
    public ImageView nOz;

    /* renamed from: com.tencent.mm.plugin.location.ui.n$a */
    public class C12404a implements InfoWindowAdapter {
        private C12404a() {
        }

        public /* synthetic */ C12404a(C12403n c12403n, byte b) {
            this();
        }

        public final View getInfoWindow(Marker marker) {
            AppMethodBeat.m2504i(113586);
            C4990ab.m7417i("ZItemOverlay", "get info window: %s", Integer.valueOf(C12403n.this.nOA.getVisibility()));
            if ("info_window_tag".equals(marker.getTag())) {
                FrameLayout frameLayout = C12403n.this.nOA;
                AppMethodBeat.m2505o(113586);
                return frameLayout;
            }
            AppMethodBeat.m2505o(113586);
            return null;
        }

        public final void onInfoWindowDettached(Marker marker, View view) {
        }
    }

    public C12403n(C28354d c28354d, Context context) {
        AppMethodBeat.m2504i(113587);
        this.mContext = context;
        this.nOC = false;
        this.nOz = new ImageView(context);
        this.nOz.setBackgroundResource(C25738R.drawable.f6900uv);
        this.nOz.setScaleType(ScaleType.CENTER_CROP);
        this.nOA = (FrameLayout) View.inflate(context, 2130970068, null);
        this.nOz.setImageResource(C25738R.drawable.bmf);
        this.nLX = this.nOA;
        this.mViewManager = (ViewManager) c28354d.getViewManager();
        AppMethodBeat.m2505o(113587);
    }

    public final void setText(String str) {
        AppMethodBeat.m2504i(113588);
        this.nJq = str;
        String str2 = this.nJq;
        this.nLs = (TextView) this.nOA.findViewById(2131825276);
        this.nLt = (ProgressBar) this.nOA.findViewById(2131825275);
        this.nOB = (TextView) this.nOA.findViewById(2131825913);
        if (str2 == null || str2.equals("")) {
            this.nLt.setVisibility(0);
        } else {
            this.nLt.setVisibility(8);
            this.nLs.setVisibility(0);
            this.nLs.setText(str2);
        }
        if (this.eUu == null || this.eUu.equals("")) {
            this.nOB.setText("");
            this.nOB.setVisibility(8);
        } else {
            this.nOB.setVisibility(0);
            this.nOB.setText(this.eUu);
        }
        if (this.nLW) {
            this.mViewManager.updateViewLayout(this.nOz, this.nJu, this.nJv, false);
            if (this.nOC) {
                this.mViewManager.showInfoWindowByView(this.nOz);
            }
        }
        AppMethodBeat.m2505o(113588);
    }

    public final String getPreText() {
        return this.nLw;
    }
}
