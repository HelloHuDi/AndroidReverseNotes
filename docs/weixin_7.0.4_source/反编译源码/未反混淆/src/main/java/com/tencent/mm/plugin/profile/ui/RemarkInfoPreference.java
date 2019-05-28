package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference extends Preference {
    private MMActivity crP;
    private TextView gne;
    private ImageView iyo;
    private TextView pnu;
    private boolean ppo = false;
    private String summary;
    private String title;

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23761);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(23761);
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23762);
        setLayoutResource(R.layout.ae4);
        setWidgetLayoutResource(R.layout.ag5);
        AppMethodBeat.o(23762);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23763);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.af5, viewGroup2);
        AppMethodBeat.o(23763);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23764);
        this.gne = (TextView) view.findViewById(R.id.cx);
        this.pnu = (TextView) view.findViewById(R.id.a81);
        this.iyo = (ImageView) view.findViewById(R.id.aga);
        if (this.ppo) {
            this.iyo.setVisibility(0);
        } else {
            this.iyo.setVisibility(8);
        }
        if (this.gne != null) {
            this.gne.setText(this.title);
        }
        if (this.pnu != null) {
            this.pnu.setText(this.summary);
        }
        super.onBindView(view);
        AppMethodBeat.o(23764);
    }

    public final /* synthetic */ CharSequence getSummary() {
        AppMethodBeat.i(23765);
        String charSequence = this.pnu.getText().toString();
        AppMethodBeat.o(23765);
        return charSequence;
    }
}
