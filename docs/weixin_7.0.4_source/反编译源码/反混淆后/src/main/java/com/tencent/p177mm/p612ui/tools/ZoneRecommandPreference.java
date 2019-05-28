package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.storage.RegionCodeDecoder.Region;

/* renamed from: com.tencent.mm.ui.tools.ZoneRecommandPreference */
public class ZoneRecommandPreference extends Preference {
    private TextView gnh;
    int status;
    Region zIl;
    Region zIm;
    Region zIn;
    private TextView zIo;
    private ImageView zIp;

    public ZoneRecommandPreference(Context context) {
        this(context, null);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(35014);
        this.status = 0;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(35014);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(35015);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970171, viewGroup2);
        this.zIo = (TextView) onCreateView.findViewById(2131826048);
        this.gnh = (TextView) onCreateView.findViewById(2131826053);
        this.zIp = (ImageView) onCreateView.findViewById(2131826052);
        AppMethodBeat.m2505o(35015);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(35016);
        super.onBindView(view);
        dKb();
        AppMethodBeat.m2505o(35016);
    }

    /* Access modifiers changed, original: final */
    public final void dKb() {
        AppMethodBeat.m2504i(35017);
        if (this.zIo == null || this.gnh == null) {
            AppMethodBeat.m2505o(35017);
            return;
        }
        switch (this.status) {
            case 0:
                this.zIo.setVisibility(8);
                this.gnh.setVisibility(0);
                this.gnh.setText(C25738R.string.e50);
                this.zIp.setImageResource(C1318a.get_location_icon);
                setEnabled(false);
                setSelectable(false);
                AppMethodBeat.m2505o(35017);
                return;
            case 1:
                this.zIo.setVisibility(0);
                this.gnh.setVisibility(8);
                this.zIp.setImageResource(C1318a.get_location_icon);
                CharSequence charSequence = "";
                if (!(this.zIl == null || C42252ah.isNullOrNil(this.zIl.getName()))) {
                    charSequence = charSequence + this.zIl.getName();
                }
                if (!(this.zIm == null || C42252ah.isNullOrNil(this.zIm.getName()))) {
                    charSequence = charSequence + " " + this.zIm.getName();
                }
                if (!(this.zIn == null || C42252ah.isNullOrNil(this.zIn.getName()))) {
                    charSequence = charSequence + " " + this.zIn.getName();
                }
                this.zIo.setText(charSequence);
                setEnabled(true);
                setSelectable(true);
                break;
            case 2:
                this.zIo.setVisibility(8);
                this.gnh.setVisibility(0);
                this.gnh.setText(C25738R.string.e4x);
                this.zIp.setImageResource(C1318a.get_location_failed_icon);
                setEnabled(false);
                setSelectable(false);
                AppMethodBeat.m2505o(35017);
                return;
        }
        AppMethodBeat.m2505o(35017);
    }

    public final void dKc() {
        AppMethodBeat.m2504i(35018);
        this.status = 2;
        dKb();
        AppMethodBeat.m2505o(35018);
    }
}
