package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C28181ag;
import com.tencent.p177mm.plugin.game.p731d.C28198j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.game.ui.f */
public final class C46017f extends LinearLayout implements OnClickListener {
    private String mAppId;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int mXC;

    public C46017f(Context context) {
        super(context);
        AppMethodBeat.m2504i(111740);
        this.mContext = context;
        setOrientation(0);
        AppMethodBeat.m2505o(111740);
    }

    /* renamed from: a */
    public final void mo73917a(C28181ag c28181ag, String str, int i, int i2) {
        AppMethodBeat.m2504i(111741);
        if (c28181ag == null || C5046bo.m7548ek(c28181ag.naO)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111741);
            return;
        }
        if (c28181ag.naO.size() == 1) {
            c28181ag.naO.add(null);
            c28181ag.naO.add(null);
        } else if (c28181ag.naO.size() == 2) {
            c28181ag.naO.add(null);
        }
        this.mAppId = str;
        this.mXC = i2;
        Iterator it = c28181ag.naO.iterator();
        while (it.hasNext()) {
            C28198j c28198j = (C28198j) it.next();
            LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(2130969660, this, false);
            addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
            ImageView imageView = (ImageView) linearLayout.findViewById(2131824313);
            TextView textView = (TextView) linearLayout.findViewById(2131824314);
            TextView textView2 = (TextView) linearLayout.findViewById(2131824315);
            if (c28198j == null) {
                imageView.setImageResource(C25738R.drawable.ago);
                textView.setText(C25738R.string.c8b);
                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12043qe));
            } else {
                linearLayout.setOnClickListener(this);
                C28203e.bFH().mo46100h(imageView, c28198j.IconUrl);
                textView.setText(c28198j.Title);
                if (C5046bo.isNullOrNil(c28198j.Desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(c28198j.Desc);
                    textView2.setVisibility(0);
                }
                linearLayout.setTag(c28198j);
                if (i == 2) {
                    C34276a.m56205a(this.mContext, 10, 1002, c28198j.mZN, str, i2, C34276a.m56208kY(c28198j.mZL));
                }
            }
        }
        AppMethodBeat.m2505o(111741);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(111742);
        if (view.getTag() == null || !(view.getTag() instanceof C28198j)) {
            C4990ab.m7420w("MicroMsg.GameBlockEntranceView", "getTag is null");
            AppMethodBeat.m2505o(111742);
            return;
        }
        C28198j c28198j = (C28198j) view.getTag();
        if (C5046bo.isNullOrNil(c28198j.mZj)) {
            C4990ab.m7420w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
            AppMethodBeat.m2505o(111742);
            return;
        }
        C34277b.m56211a(this.mContext, 10, 1002, c28198j.mZN, C46001c.m85464t(this.mContext, c28198j.mZj, "game_center_mygame_comm"), this.mAppId, this.mXC, C34276a.m56208kY(c28198j.mZL));
        AppMethodBeat.m2505o(111742);
    }
}
