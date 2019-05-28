package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference */
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
        AppMethodBeat.m2504i(23316);
        this.plc = -1;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(23316);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23317);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(2130969220, viewGroup2);
        AppMethodBeat.m2505o(23317);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23318);
        super.onBindView(view);
        this.pla = (LinearLayout) view.findViewById(2131821841);
        m45569cu();
        AppMethodBeat.m2505o(23318);
    }

    /* renamed from: AS */
    public final void mo46830AS(int i) {
        AppMethodBeat.m2504i(23319);
        if (i == this.plc) {
            AppMethodBeat.m2505o(23319);
            return;
        }
        this.plc = i;
        m45569cu();
        AppMethodBeat.m2505o(23319);
    }

    /* renamed from: cC */
    public final void mo46831cC(List<String> list) {
        AppMethodBeat.m2504i(23320);
        this.plb = list;
        m45569cu();
        AppMethodBeat.m2505o(23320);
    }

    /* renamed from: cu */
    private void m45569cu() {
        AppMethodBeat.m2504i(23321);
        if (this.pla == null) {
            AppMethodBeat.m2505o(23321);
            return;
        }
        this.pla.removeAllViews();
        if (this.plc >= 0) {
            int i = this.plc;
            for (int i2 = 0; i2 < 5; i2++) {
                if (i <= 0) {
                    m45567AT(C1318a.biz_info_brand_unselect);
                } else if (i <= 10) {
                    m45567AT(C1318a.biz_info_brand_half_selected);
                    i -= 20;
                } else {
                    m45567AT(C1318a.biz_info_brand_selected);
                    i -= 20;
                }
            }
            AppMethodBeat.m2505o(23321);
            return;
        }
        if (this.plb != null) {
            for (String UN : this.plb) {
                m45568UN(UN);
            }
        }
        AppMethodBeat.m2505o(23321);
    }

    /* renamed from: AT */
    private void m45567AT(int i) {
        AppMethodBeat.m2504i(23322);
        ImageView imageView = (ImageView) this.mInflater.inflate(2130969199, null);
        LayoutParams layoutParams = new LayoutParams(C1338a.fromDPToPix(this.mContext, 20), C1338a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = C1338a.fromDPToPix(this.mContext, 6);
        imageView.setImageResource(i);
        this.pla.addView(imageView, layoutParams);
        AppMethodBeat.m2505o(23322);
    }

    /* renamed from: UN */
    private void m45568UN(String str) {
        AppMethodBeat.m2504i(23323);
        CdnImageView cdnImageView = new CdnImageView(this.mContext);
        cdnImageView.setUrl(str);
        LayoutParams layoutParams = new LayoutParams(C1338a.fromDPToPix(this.mContext, 20), C1338a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = C1338a.fromDPToPix(this.mContext, 6);
        this.pla.addView(cdnImageView, layoutParams);
        AppMethodBeat.m2505o(23323);
    }
}
