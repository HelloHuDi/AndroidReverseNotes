package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;

public class PowerSettingPreference extends Preference {
    private ad ldh;
    private View omq;
    private ImageView pon;
    private ImageView poo;
    private ImageView pop;

    public PowerSettingPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PowerSettingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28113);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            viewGroup2.addView(LayoutInflater.from(this.mContext).inflate(R.layout.alt, null), new LayoutParams(-1, -2));
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.o(28113);
        return view;
    }

    public final void onBindView(View view) {
        int i = 0;
        AppMethodBeat.i(28114);
        super.onBindView(view);
        if (this.ldh == null) {
            AppMethodBeat.o(28114);
            return;
        }
        int i2;
        if (this.pon == null) {
            this.pon = (ImageView) view.findViewById(R.id.b4r);
        }
        if (this.poo == null) {
            this.poo = (ImageView) view.findViewById(R.id.b4q);
        }
        if (this.pop == null) {
            this.pop = (ImageView) view.findViewById(R.id.b4p);
        }
        boolean Od = this.ldh.Od();
        boolean UV = n.qFA.UV(this.ldh.field_username);
        ImageView imageView = this.poo;
        if (Od) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        imageView = this.pop;
        if (UV) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        ImageView imageView2 = this.pon;
        if (!this.ldh.Oc()) {
            i = 8;
        }
        imageView2.setVisibility(i);
        AppMethodBeat.o(28114);
    }
}
