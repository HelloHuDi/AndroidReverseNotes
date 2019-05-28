package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class n implements c {
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

    public class a implements InfoWindowAdapter {
        private a() {
        }

        public /* synthetic */ a(n nVar, byte b) {
            this();
        }

        public final View getInfoWindow(Marker marker) {
            AppMethodBeat.i(113586);
            ab.i("ZItemOverlay", "get info window: %s", Integer.valueOf(n.this.nOA.getVisibility()));
            if ("info_window_tag".equals(marker.getTag())) {
                FrameLayout frameLayout = n.this.nOA;
                AppMethodBeat.o(113586);
                return frameLayout;
            }
            AppMethodBeat.o(113586);
            return null;
        }

        public final void onInfoWindowDettached(Marker marker, View view) {
        }
    }

    public n(d dVar, Context context) {
        AppMethodBeat.i(113587);
        this.mContext = context;
        this.nOC = false;
        this.nOz = new ImageView(context);
        this.nOz.setBackgroundResource(R.drawable.uv);
        this.nOz.setScaleType(ScaleType.CENTER_CROP);
        this.nOA = (FrameLayout) View.inflate(context, R.layout.aci, null);
        this.nOz.setImageResource(R.drawable.bmf);
        this.nLX = this.nOA;
        this.mViewManager = (ViewManager) dVar.getViewManager();
        AppMethodBeat.o(113587);
    }

    public final void setText(String str) {
        AppMethodBeat.i(113588);
        this.nJq = str;
        String str2 = this.nJq;
        this.nLs = (TextView) this.nOA.findViewById(R.id.cpx);
        this.nLt = (ProgressBar) this.nOA.findViewById(R.id.cpw);
        this.nOB = (TextView) this.nOA.findViewById(R.id.d75);
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
        AppMethodBeat.o(113588);
    }

    public final String getPreText() {
        return this.nLw;
    }
}
