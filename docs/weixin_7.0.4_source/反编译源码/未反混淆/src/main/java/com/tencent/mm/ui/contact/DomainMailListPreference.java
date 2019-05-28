package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference extends Preference {
    private TextView gne;
    private boolean lyb;
    private String title;
    private String zmo;
    private TextView zmp;
    private TextView zmq;
    private TextView zmr;

    public DomainMailListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33699);
        init();
        AppMethodBeat.o(33699);
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(33700);
        init();
        AppMethodBeat.o(33700);
    }

    private void init() {
        this.lyb = false;
        this.title = "";
        this.zmo = "";
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(33701);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.aen, viewGroup2);
        AppMethodBeat.o(33701);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(33702);
        this.gne = (TextView) view.findViewById(R.id.cx);
        this.zmp = (TextView) view.findViewById(R.id.d_d);
        this.zmq = (TextView) view.findViewById(R.id.d_e);
        this.zmr = (TextView) view.findViewById(R.id.d_f);
        this.lyb = true;
        if (this.lyb) {
            this.gne.setText(ah.nullAsNil(this.title));
            String[] split = this.zmo.split(";");
            if (ah.nullAsNil(this.zmo).length() <= 0) {
                this.zmp.setVisibility(8);
                this.zmq.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.zmp.setVisibility(0);
                    this.zmp.setText(ah.nullAsNil(split[0]));
                } else {
                    this.zmp.setVisibility(8);
                }
                if (split.length > 1) {
                    this.zmq.setVisibility(0);
                    this.zmq.setText(ah.nullAsNil(split[1]));
                } else {
                    this.zmq.setVisibility(8);
                }
                if (split.length > 2) {
                    this.zmr.setVisibility(0);
                    this.zmr.setText(ah.nullAsNil(split[2]));
                }
            }
            this.zmr.setVisibility(8);
        } else {
            ab.e("MicroMsg.DomainMailPreference", "initView : unbind view");
        }
        super.onBindView(view);
        AppMethodBeat.o(33702);
    }
}
