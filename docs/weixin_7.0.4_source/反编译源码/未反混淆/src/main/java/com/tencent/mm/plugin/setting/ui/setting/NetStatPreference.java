package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.setting.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference extends Preference {
    boolean qkW;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        AppMethodBeat.i(126966);
        this.qkW = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.NetStatPreference, i, 0);
        if (obtainStyledAttributes.getInt(0, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.qkW = z;
        obtainStyledAttributes.recycle();
        setSummary((CharSequence) context.getString(R.string.e9_, new Object[]{Integer.valueOf(15)}));
        AppMethodBeat.o(126966);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(126967);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.aey, viewGroup2);
        AppMethodBeat.o(126967);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(126968);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.d_c);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        for (int i = 15; i > 0; i -= 5) {
            NetStatGroup netStatGroup = new NetStatGroup(this.mContext);
            int i2 = (currentTimeMillis - i) + 1;
            boolean z = this.qkW;
            String charSequence = DateFormat.format(netStatGroup.getContext().getString(R.string.bww, new Object[]{""}), ((long) i2) * 86400000).toString();
            netStatGroup.qkV.setText(charSequence);
            ab.d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(charSequence)));
            netStatGroup.qkU.removeAllViews();
            for (int i3 = 0; i3 < 5; i3++) {
                NetStatUnit netStatUnit = new NetStatUnit(netStatGroup.getContext());
                k md = q.aks().md(i2 + i3);
                if (md != null) {
                    if (z) {
                        ab.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", Integer.valueOf(md.fSZ), Integer.valueOf(md.fTv), Integer.valueOf(md.fTj), Integer.valueOf(md.fTx), Integer.valueOf(md.fTl));
                        netStatUnit.fg(md.fTv + md.fTj, md.fTl + md.fTx);
                    } else {
                        ab.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", Integer.valueOf(md.fSZ), Integer.valueOf(md.fTu), Integer.valueOf(md.fTi), Integer.valueOf(md.fTw), Integer.valueOf(md.fTk));
                        netStatUnit.fg(md.fTu + md.fTi, md.fTk + md.fTw);
                    }
                }
                netStatUnit.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
                netStatGroup.qkU.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        linearLayout = (LinearLayout) view.findViewById(R.id.d_r);
        linearLayout.removeAllViews();
        NetStatGroup netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.qkW;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), R.layout.ain, netStatGroup2);
        netStatGroup2.qkU = (LinearLayout) netStatGroup2.findViewById(R.id.d_c);
        NetStatRuler netStatRuler = new NetStatRuler(netStatGroup2.getContext());
        netStatRuler.setTag(z2 ? "wifi" : "mobile");
        netStatRuler.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        netStatGroup2.qkU.addView(netStatRuler);
        linearLayout.addView(netStatGroup2);
        NW(8);
        AppMethodBeat.o(126968);
    }
}
