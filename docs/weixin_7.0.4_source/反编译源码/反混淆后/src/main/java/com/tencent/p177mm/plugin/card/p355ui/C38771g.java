package com.tencent.p177mm.plugin.card.p355ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C45773c;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
/* renamed from: com.tencent.mm.plugin.card.ui.g */
public final class C38771g extends BaseAdapter {
    private OnClickListener gKK = new C27731();
    private boolean kdc = true;
    C45773c kgW;
    List<CardInfo> khh = new ArrayList();
    private boolean kmc = false;
    List<Boolean> kmd = new ArrayList();
    C38772a kme;
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.card.ui.g$1 */
    class C27731 implements OnClickListener {
        C27731() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88545);
            int intValue = ((Integer) view.getTag()).intValue();
            C38771g c38771g = C38771g.this;
            if (((Boolean) c38771g.kmd.get(intValue)).booleanValue()) {
                c38771g.kmd.set(intValue, Boolean.FALSE);
            } else {
                c38771g.kmd.set(intValue, Boolean.TRUE);
            }
            c38771g.notifyDataSetChanged();
            AppMethodBeat.m2505o(88545);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.g$a */
    public interface C38772a {
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(88550);
        CardInfo sY = mo61647sY(i);
        AppMethodBeat.m2505o(88550);
        return sY;
    }

    public C38771g(Context context) {
        AppMethodBeat.m2504i(88546);
        this.kgW = new C2782l(context, this);
        this.mContext = context;
        AppMethodBeat.m2505o(88546);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(88547);
        int size = this.khh.size();
        AppMethodBeat.m2505o(88547);
        return size;
    }

    /* renamed from: sY */
    public final CardInfo mo61647sY(int i) {
        AppMethodBeat.m2504i(88548);
        CardInfo cardInfo = (CardInfo) this.khh.get(i);
        AppMethodBeat.m2505o(88548);
        return cardInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(88549);
        C42837b sY = mo61647sY(i);
        sY.kdc = this.kdc;
        View a = this.kgW.mo6879a(i, view, sY);
        if (this.kmc && sY.aZI()) {
            this.kgW.mo6878S(a, 0);
            if (((Boolean) this.kmd.get(i)).booleanValue()) {
                this.kgW.mo6877R(a, C25738R.drawable.f6501g9);
            } else {
                this.kgW.mo6877R(a, C25738R.drawable.f6502g_);
            }
            this.kgW.mo6880a(a, i, this.gKK);
        } else {
            this.kgW.mo6878S(a, 8);
        }
        AppMethodBeat.m2505o(88549);
        return a;
    }
}
