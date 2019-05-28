package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizInfoPayInfoIconPreference extends Preference {
    private LayoutInflater mInflater;
    private LinearLayout pla;
    private List<String> plb;
    private int plc;

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23316);
        this.plc = -1;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(23316);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23317);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(R.layout.qn, viewGroup2);
        AppMethodBeat.o(23317);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23318);
        super.onBindView(view);
        this.pla = (LinearLayout) view.findViewById(R.id.a81);
        cu();
        AppMethodBeat.o(23318);
    }

    public final void AS(int i) {
        AppMethodBeat.i(23319);
        if (i == this.plc) {
            AppMethodBeat.o(23319);
            return;
        }
        this.plc = i;
        cu();
        AppMethodBeat.o(23319);
    }

    public final void cC(List<String> list) {
        AppMethodBeat.i(23320);
        this.plb = list;
        cu();
        AppMethodBeat.o(23320);
    }

    private void cu() {
        AppMethodBeat.i(23321);
        if (this.pla == null) {
            AppMethodBeat.o(23321);
            return;
        }
        this.pla.removeAllViews();
        if (this.plc >= 0) {
            int i = this.plc;
            for (int i2 = 0; i2 < 5; i2++) {
                if (i <= 0) {
                    AT(R.raw.biz_info_brand_unselect);
                } else if (i <= 10) {
                    AT(R.raw.biz_info_brand_half_selected);
                    i -= 20;
                } else {
                    AT(R.raw.biz_info_brand_selected);
                    i -= 20;
                }
            }
            AppMethodBeat.o(23321);
            return;
        }
        if (this.plb != null) {
            for (String UN : this.plb) {
                UN(UN);
            }
        }
        AppMethodBeat.o(23321);
    }

    private void AT(int i) {
        AppMethodBeat.i(23322);
        ImageView imageView = (ImageView) this.mInflater.inflate(R.layout.q3, null);
        LayoutParams layoutParams = new LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        imageView.setImageResource(i);
        this.pla.addView(imageView, layoutParams);
        AppMethodBeat.o(23322);
    }

    private void UN(String str) {
        AppMethodBeat.i(23323);
        CdnImageView cdnImageView = new CdnImageView(this.mContext);
        cdnImageView.setUrl(str);
        LayoutParams layoutParams = new LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        this.pla.addView(cdnImageView, layoutParams);
        AppMethodBeat.o(23323);
    }
}
