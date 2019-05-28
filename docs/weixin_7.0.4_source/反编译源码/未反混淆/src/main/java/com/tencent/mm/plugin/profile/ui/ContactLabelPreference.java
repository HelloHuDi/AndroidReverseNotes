package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ContactLabelPreference extends Preference {
    private TextView gne;
    private MMSingelLinePanel plB;
    private ArrayList<String> plC;
    private String title;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23392);
        this.plC = new ArrayList();
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(23392);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23393);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.aeu, viewGroup2);
        AppMethodBeat.o(23393);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23394);
        this.gne = (TextView) view.findViewById(R.id.cx);
        this.plB = (MMSingelLinePanel) view.findViewById(R.id.iz);
        this.plB.setSingleLine(true);
        this.plB.yxl = false;
        this.plB.qe(false);
        if (this.gne != null) {
            this.gne.setText(this.title);
        }
        if (!(this.plB == null || this.plC == null || this.plC.size() <= 0)) {
            this.plB.a((Collection) this.plC, (List) this.plC);
        }
        super.onBindView(view);
        AppMethodBeat.o(23394);
    }
}
