package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelstat.C42223k;
import com.tencent.p177mm.modelstat.C42225q;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.setting.C34847a.C28928a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.NetStatPreference */
public class NetStatPreference extends Preference {
    boolean qkW;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(126966);
        this.qkW = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C28928a.NetStatPreference, i, 0);
        if (obtainStyledAttributes.getInt(0, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.qkW = z;
        obtainStyledAttributes.recycle();
        setSummary((CharSequence) context.getString(C25738R.string.e9_, new Object[]{Integer.valueOf(15)}));
        AppMethodBeat.m2505o(126966);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(126967);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970158, viewGroup2);
        AppMethodBeat.m2505o(126967);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(126968);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131826032);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        for (int i = 15; i > 0; i -= 5) {
            NetStatGroup netStatGroup = new NetStatGroup(this.mContext);
            int i2 = (currentTimeMillis - i) + 1;
            boolean z = this.qkW;
            String charSequence = DateFormat.format(netStatGroup.getContext().getString(C25738R.string.bww, new Object[]{""}), ((long) i2) * 86400000).toString();
            netStatGroup.qkV.setText(charSequence);
            C4990ab.m7410d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(charSequence)));
            netStatGroup.qkU.removeAllViews();
            for (int i3 = 0; i3 < 5; i3++) {
                NetStatUnit netStatUnit = new NetStatUnit(netStatGroup.getContext());
                C42223k md = C42225q.aks().mo51241md(i2 + i3);
                if (md != null) {
                    if (z) {
                        C4990ab.m7417i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", Integer.valueOf(md.fSZ), Integer.valueOf(md.fTv), Integer.valueOf(md.fTj), Integer.valueOf(md.fTx), Integer.valueOf(md.fTl));
                        netStatUnit.mo62621fg(md.fTv + md.fTj, md.fTl + md.fTx);
                    } else {
                        C4990ab.m7417i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", Integer.valueOf(md.fSZ), Integer.valueOf(md.fTu), Integer.valueOf(md.fTi), Integer.valueOf(md.fTw), Integer.valueOf(md.fTk));
                        netStatUnit.mo62621fg(md.fTu + md.fTi, md.fTk + md.fTw);
                    }
                }
                netStatUnit.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
                netStatGroup.qkU.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        linearLayout = (LinearLayout) view.findViewById(2131826047);
        linearLayout.removeAllViews();
        NetStatGroup netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.qkW;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), 2130970295, netStatGroup2);
        netStatGroup2.qkU = (LinearLayout) netStatGroup2.findViewById(2131826032);
        NetStatRuler netStatRuler = new NetStatRuler(netStatGroup2.getContext());
        netStatRuler.setTag(z2 ? "wifi" : "mobile");
        netStatRuler.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        netStatGroup2.qkU.addView(netStatRuler);
        linearLayout.addView(netStatGroup2);
        mo39406NW(8);
        AppMethodBeat.m2505o(126968);
    }
}
