package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.contact.DomainMailListPreference */
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
        AppMethodBeat.m2504i(33699);
        init();
        AppMethodBeat.m2505o(33699);
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(33700);
        init();
        AppMethodBeat.m2505o(33700);
    }

    private void init() {
        this.lyb = false;
        this.title = "";
        this.zmo = "";
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(33701);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970147, viewGroup2);
        AppMethodBeat.m2505o(33701);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(33702);
        this.gne = (TextView) view.findViewById(2131820678);
        this.zmp = (TextView) view.findViewById(2131826033);
        this.zmq = (TextView) view.findViewById(2131826034);
        this.zmr = (TextView) view.findViewById(2131826035);
        this.lyb = true;
        if (this.lyb) {
            this.gne.setText(C42252ah.nullAsNil(this.title));
            String[] split = this.zmo.split(";");
            if (C42252ah.nullAsNil(this.zmo).length() <= 0) {
                this.zmp.setVisibility(8);
                this.zmq.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.zmp.setVisibility(0);
                    this.zmp.setText(C42252ah.nullAsNil(split[0]));
                } else {
                    this.zmp.setVisibility(8);
                }
                if (split.length > 1) {
                    this.zmq.setVisibility(0);
                    this.zmq.setText(C42252ah.nullAsNil(split[1]));
                } else {
                    this.zmq.setVisibility(8);
                }
                if (split.length > 2) {
                    this.zmr.setVisibility(0);
                    this.zmr.setText(C42252ah.nullAsNil(split[2]));
                }
            }
            this.zmr.setVisibility(8);
        } else {
            C4990ab.m7412e("MicroMsg.DomainMailPreference", "initView : unbind view");
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(33702);
    }
}
