package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.LabelPreference */
public class LabelPreference extends Preference {
    public C7616ad ldh;
    private View omq;
    public C7575bv pCq;
    private TextView pmi;
    private TextView viw;

    public LabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(28069);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            LayoutInflater.from(this.mContext).inflate(2130970407, viewGroup2);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.m2505o(28069);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28070);
        super.onBindView(view);
        if (this.ldh == null) {
            view.setVisibility(8);
            AppMethodBeat.m2505o(28070);
            return;
        }
        view.setVisibility(0);
        if (this.pmi == null) {
            this.pmi = (TextView) view.findViewById(2131826655);
        }
        if (this.viw == null) {
            this.viw = (TextView) view.findViewById(2131826654);
        }
        if (this.viw != null) {
            LayoutParams layoutParams = this.viw.getLayoutParams();
            layoutParams.width = C1338a.m2856al(this.mContext, C25738R.dimen.f9862i8);
            this.viw.setLayoutParams(layoutParams);
        }
        this.pmi.setVisibility(0);
        String str;
        List list;
        if (C7486a.m12942jh(this.ldh.field_type)) {
            str = this.ldh.field_contactLabelIds;
            list = (ArrayList) C21156a.bJa().mo41634PG(str);
            if (!(C5046bo.isNullOrNil(str) || list == null || list.size() <= 0)) {
                this.pmi.setText(C44089j.m79292b(this.mContext, C5046bo.m7536c(list, this.mContext.getResources().getString(C25738R.string.at4))));
            }
            AppMethodBeat.m2505o(28070);
            return;
        }
        if (this.pCq != null) {
            str = this.pCq.field_contactLabels;
            list = (ArrayList) C21156a.bJa().mo41633PF(str);
            if (!(C5046bo.isNullOrNil(str) || list == null || list.size() <= 0)) {
                this.pmi.setText(C44089j.m79292b(this.mContext, C5046bo.m7536c(list, this.mContext.getResources().getString(C25738R.string.at4))));
            }
        }
        AppMethodBeat.m2505o(28070);
    }
}
