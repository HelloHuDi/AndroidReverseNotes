package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

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
        AppMethodBeat.i(35014);
        this.status = 0;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(35014);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(35015);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.afa, viewGroup2);
        this.zIo = (TextView) onCreateView.findViewById(R.id.d_s);
        this.gnh = (TextView) onCreateView.findViewById(R.id.d_x);
        this.zIp = (ImageView) onCreateView.findViewById(R.id.d_w);
        AppMethodBeat.o(35015);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(35016);
        super.onBindView(view);
        dKb();
        AppMethodBeat.o(35016);
    }

    /* Access modifiers changed, original: final */
    public final void dKb() {
        AppMethodBeat.i(35017);
        if (this.zIo == null || this.gnh == null) {
            AppMethodBeat.o(35017);
            return;
        }
        switch (this.status) {
            case 0:
                this.zIo.setVisibility(8);
                this.gnh.setVisibility(0);
                this.gnh.setText(R.string.e50);
                this.zIp.setImageResource(R.raw.get_location_icon);
                setEnabled(false);
                setSelectable(false);
                AppMethodBeat.o(35017);
                return;
            case 1:
                this.zIo.setVisibility(0);
                this.gnh.setVisibility(8);
                this.zIp.setImageResource(R.raw.get_location_icon);
                CharSequence charSequence = "";
                if (!(this.zIl == null || ah.isNullOrNil(this.zIl.getName()))) {
                    charSequence = charSequence + this.zIl.getName();
                }
                if (!(this.zIm == null || ah.isNullOrNil(this.zIm.getName()))) {
                    charSequence = charSequence + " " + this.zIm.getName();
                }
                if (!(this.zIn == null || ah.isNullOrNil(this.zIn.getName()))) {
                    charSequence = charSequence + " " + this.zIn.getName();
                }
                this.zIo.setText(charSequence);
                setEnabled(true);
                setSelectable(true);
                break;
            case 2:
                this.zIo.setVisibility(8);
                this.gnh.setVisibility(0);
                this.gnh.setText(R.string.e4x);
                this.zIp.setImageResource(R.raw.get_location_failed_icon);
                setEnabled(false);
                setSelectable(false);
                AppMethodBeat.o(35017);
                return;
        }
        AppMethodBeat.o(35017);
    }

    public final void dKc() {
        AppMethodBeat.i(35018);
        this.status = 2;
        dKb();
        AppMethodBeat.o(35018);
    }
}
