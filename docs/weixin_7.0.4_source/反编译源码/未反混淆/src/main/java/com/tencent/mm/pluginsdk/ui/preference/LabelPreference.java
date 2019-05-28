package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public class LabelPreference extends Preference {
    public ad ldh;
    private View omq;
    public bv pCq;
    private TextView pmi;
    private TextView viw;

    public LabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28069);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            LayoutInflater.from(this.mContext).inflate(R.layout.aln, viewGroup2);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.o(28069);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28070);
        super.onBindView(view);
        if (this.ldh == null) {
            view.setVisibility(8);
            AppMethodBeat.o(28070);
            return;
        }
        view.setVisibility(0);
        if (this.pmi == null) {
            this.pmi = (TextView) view.findViewById(R.id.dq7);
        }
        if (this.viw == null) {
            this.viw = (TextView) view.findViewById(R.id.dq6);
        }
        if (this.viw != null) {
            LayoutParams layoutParams = this.viw.getLayoutParams();
            layoutParams.width = a.al(this.mContext, R.dimen.i8);
            this.viw.setLayoutParams(layoutParams);
        }
        this.pmi.setVisibility(0);
        String str;
        List list;
        if (com.tencent.mm.n.a.jh(this.ldh.field_type)) {
            str = this.ldh.field_contactLabelIds;
            list = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PG(str);
            if (!(bo.isNullOrNil(str) || list == null || list.size() <= 0)) {
                this.pmi.setText(j.b(this.mContext, bo.c(list, this.mContext.getResources().getString(R.string.at4))));
            }
            AppMethodBeat.o(28070);
            return;
        }
        if (this.pCq != null) {
            str = this.pCq.field_contactLabels;
            list = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PF(str);
            if (!(bo.isNullOrNil(str) || list == null || list.size() <= 0)) {
                this.pmi.setText(j.b(this.mContext, bo.c(list, this.mContext.getResources().getString(R.string.at4))));
            }
        }
        AppMethodBeat.o(28070);
    }
}
