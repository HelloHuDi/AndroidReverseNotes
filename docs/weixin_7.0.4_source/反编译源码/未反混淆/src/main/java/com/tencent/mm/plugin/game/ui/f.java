package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.j;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class f extends LinearLayout implements OnClickListener {
    private String mAppId;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int mXC;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(111740);
        this.mContext = context;
        setOrientation(0);
        AppMethodBeat.o(111740);
    }

    public final void a(ag agVar, String str, int i, int i2) {
        AppMethodBeat.i(111741);
        if (agVar == null || bo.ek(agVar.naO)) {
            setVisibility(8);
            AppMethodBeat.o(111741);
            return;
        }
        if (agVar.naO.size() == 1) {
            agVar.naO.add(null);
            agVar.naO.add(null);
        } else if (agVar.naO.size() == 2) {
            agVar.naO.add(null);
        }
        this.mAppId = str;
        this.mXC = i2;
        Iterator it = agVar.naO.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(R.layout.a2h, this, false);
            addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.c0v);
            TextView textView = (TextView) linearLayout.findViewById(R.id.c0w);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.c0x);
            if (jVar == null) {
                imageView.setImageResource(R.drawable.ago);
                textView.setText(R.string.c8b);
                textView.setTextColor(this.mContext.getResources().getColor(R.color.qe));
            } else {
                linearLayout.setOnClickListener(this);
                e.bFH().h(imageView, jVar.IconUrl);
                textView.setText(jVar.Title);
                if (bo.isNullOrNil(jVar.Desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(jVar.Desc);
                    textView2.setVisibility(0);
                }
                linearLayout.setTag(jVar);
                if (i == 2) {
                    a.a(this.mContext, 10, 1002, jVar.mZN, str, i2, a.kY(jVar.mZL));
                }
            }
        }
        AppMethodBeat.o(111741);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(111742);
        if (view.getTag() == null || !(view.getTag() instanceof j)) {
            ab.w("MicroMsg.GameBlockEntranceView", "getTag is null");
            AppMethodBeat.o(111742);
            return;
        }
        j jVar = (j) view.getTag();
        if (bo.isNullOrNil(jVar.mZj)) {
            ab.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
            AppMethodBeat.o(111742);
            return;
        }
        b.a(this.mContext, 10, 1002, jVar.mZN, c.t(this.mContext, jVar.mZj, "game_center_mygame_comm"), this.mAppId, this.mXC, a.kY(jVar.mZL));
        AppMethodBeat.o(111742);
    }
}
