package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.List;

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
        return R.layout.aln;
    }

    public final void init() {
        AppMethodBeat.i(27530);
        this.pmi = (TextView) findViewById(R.id.dq7);
        this.viw = (TextView) findViewById(R.id.dq6);
        setClickable(true);
        AppMethodBeat.o(27530);
    }

    public final boolean cby() {
        AppMethodBeat.i(27531);
        if (this.viw != null) {
            LayoutParams layoutParams = this.viw.getLayoutParams();
            layoutParams.width = a.al(getContext(), R.dimen.i8);
            this.viw.setLayoutParams(layoutParams);
        }
        String str;
        List list;
        if (!com.tencent.mm.n.a.jh(this.ldh.field_type)) {
            bv RB;
            String str2 = this.ldh.field_encryptUsername;
            if (bo.isNullOrNil(str2)) {
                aw.ZK();
                RB = c.XN().RB(this.ldh.field_username);
            } else {
                aw.ZK();
                RB = c.XN().RB(str2);
            }
            if (RB != null) {
                str = RB.field_contactLabels;
                list = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PF(str);
                if (!(bo.isNullOrNil(str) || list == null || list.size() <= 0)) {
                    this.pmi.setText(j.b(getContext(), bo.c(list, getContext().getResources().getString(R.string.at4))));
                    AppMethodBeat.o(27531);
                    return true;
                }
            }
            setVisibility(8);
            AppMethodBeat.o(27531);
            return false;
        } else if (r.mG(this.ldh.field_username)) {
            setVisibility(8);
            AppMethodBeat.o(27531);
            return false;
        } else {
            str = this.ldh.field_contactLabelIds;
            list = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PG(str);
            if (bo.isNullOrNil(str) || list == null || list.size() <= 0) {
                setVisibility(8);
                AppMethodBeat.o(27531);
                return false;
            }
            this.pmi.setText(j.b(getContext(), bo.c(list, getContext().getResources().getString(R.string.at4))));
            AppMethodBeat.o(27531);
            return true;
        }
    }
}
