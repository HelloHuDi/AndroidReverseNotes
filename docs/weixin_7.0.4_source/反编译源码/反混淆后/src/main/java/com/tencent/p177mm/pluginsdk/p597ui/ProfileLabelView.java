package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.ProfileLabelView */
public class ProfileLabelView extends ProfileItemView {
    public TextView pmi;
    public TextView viw;

    public ProfileLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return 2130970407;
    }

    public final void init() {
        AppMethodBeat.m2504i(27530);
        this.pmi = (TextView) findViewById(2131826655);
        this.viw = (TextView) findViewById(2131826654);
        setClickable(true);
        AppMethodBeat.m2505o(27530);
    }

    public final boolean cby() {
        AppMethodBeat.m2504i(27531);
        if (this.viw != null) {
            LayoutParams layoutParams = this.viw.getLayoutParams();
            layoutParams.width = C1338a.m2856al(getContext(), C25738R.dimen.f9862i8);
            this.viw.setLayoutParams(layoutParams);
        }
        String str;
        List list;
        if (!C7486a.m12942jh(this.ldh.field_type)) {
            C7575bv RB;
            String str2 = this.ldh.field_encryptUsername;
            if (C5046bo.isNullOrNil(str2)) {
                C9638aw.m17190ZK();
                RB = C18628c.m29079XN().mo15364RB(this.ldh.field_username);
            } else {
                C9638aw.m17190ZK();
                RB = C18628c.m29079XN().mo15364RB(str2);
            }
            if (RB != null) {
                str = RB.field_contactLabels;
                list = (ArrayList) C21156a.bJa().mo41633PF(str);
                if (!(C5046bo.isNullOrNil(str) || list == null || list.size() <= 0)) {
                    this.pmi.setText(C44089j.m79292b(getContext(), C5046bo.m7536c(list, getContext().getResources().getString(C25738R.string.at4))));
                    AppMethodBeat.m2505o(27531);
                    return true;
                }
            }
            setVisibility(8);
            AppMethodBeat.m2505o(27531);
            return false;
        } else if (C1853r.m3858mG(this.ldh.field_username)) {
            setVisibility(8);
            AppMethodBeat.m2505o(27531);
            return false;
        } else {
            str = this.ldh.field_contactLabelIds;
            list = (ArrayList) C21156a.bJa().mo41634PG(str);
            if (C5046bo.isNullOrNil(str) || list == null || list.size() <= 0) {
                setVisibility(8);
                AppMethodBeat.m2505o(27531);
                return false;
            }
            this.pmi.setText(C44089j.m79292b(getContext(), C5046bo.m7536c(list, getContext().getResources().getString(C25738R.string.at4))));
            AppMethodBeat.m2505o(27531);
            return true;
        }
    }
}
