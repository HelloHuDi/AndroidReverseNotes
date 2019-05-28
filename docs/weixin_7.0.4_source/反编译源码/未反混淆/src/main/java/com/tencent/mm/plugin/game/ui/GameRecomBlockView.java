package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.cx;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;

public class GameRecomBlockView extends LinearLayout implements OnClickListener {
    private ViewGroup mContainer = this;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int mXC;

    static class a {
        public String appId;
        public String cMm;
        public String jumpUrl;
        public String mVB;
        public int mYy;

        public a(String str, int i, String str2, String str3, String str4) {
            this.appId = str;
            this.mYy = i;
            this.jumpUrl = str2;
            this.mVB = str3;
            this.cMm = str4;
        }
    }

    public GameRecomBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112150);
        setOrientation(1);
        this.mContext = context;
        AppMethodBeat.o(112150);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112151);
        super.onFinishInflate();
        ab.i("MicroMsg.GameRecomBlockView", "initView finished");
        AppMethodBeat.o(112151);
    }

    /* Access modifiers changed, original: final */
    public final void a(ah ahVar, int i, int i2) {
        AppMethodBeat.i(112152);
        this.mContainer.removeAllViews();
        if (bo.ek(ahVar.naO)) {
            setVisibility(8);
            AppMethodBeat.o(112152);
            return;
        }
        if (i == 2) {
            com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER, 0, null, i2, com.tencent.mm.plugin.game.e.a.kY(ahVar.mZL));
        }
        this.mInflater.inflate(R.layout.a2k, this, true);
        TextView textView = (TextView) findViewById(R.id.c12);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.c13);
        View findViewById = findViewById(R.id.c14);
        TextView textView2 = (TextView) findViewById(R.id.c15);
        if (bo.isNullOrNil(ahVar.mZM)) {
            textView.setVisibility(8);
        } else {
            textView.setText(ahVar.mZM);
        }
        if (bo.isNullOrNil(ahVar.naP)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(ahVar.naP);
        }
        findViewById.setTag(new a(null, 999, ahVar.naQ, ahVar.mZL, "game_center_mygame_more"));
        findViewById.setOnClickListener(this);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < ahVar.naO.size()) {
                cx cxVar = (cx) ahVar.naO.get(i5);
                if (cxVar != null) {
                    if (linearLayout.getChildCount() < 3) {
                        i3++;
                        LinearLayout linearLayout2 = (LinearLayout) this.mInflater.inflate(R.layout.a2l, this, false);
                        linearLayout2.setTag(new a(cxVar.fKh, i3, cxVar.mZj, cxVar.mZL, "game_center_mygame_rank"));
                        linearLayout2.setOnClickListener(this);
                        linearLayout.addView(linearLayout2, new LayoutParams(-1, -2, 1.0f));
                        textView = (TextView) linearLayout2.findViewById(R.id.c16);
                        ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.c17);
                        TextView textView3 = (TextView) linearLayout2.findViewById(R.id.c18);
                        TextView textView4 = (TextView) linearLayout2.findViewById(R.id.c19);
                        switch (i5) {
                            case 0:
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.q7));
                                break;
                            case 1:
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.q8));
                                break;
                            case 2:
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.q9));
                                break;
                        }
                        textView.setText(cxVar.Title);
                        e.bFH().h(imageView, cxVar.mZi);
                        textView3.setText(cxVar.ncH);
                        if (bo.isNullOrNil(cxVar.Desc)) {
                            textView4.setVisibility(8);
                        } else {
                            textView4.setText(cxVar.Desc);
                        }
                        if (i == 2) {
                            com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER, i3, cxVar.fKh, i2, com.tencent.mm.plugin.game.e.a.kY(cxVar.mZL));
                        }
                    }
                }
                i4 = i5 + 1;
            }
        }
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(R.color.pr));
        addView(view, new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(getContext(), 5)));
        AppMethodBeat.o(112152);
    }

    public void onClick(View view) {
        AppMethodBeat.i(112153);
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            ab.w("MicroMsg.GameRecomBlockView", "getTag is null");
            AppMethodBeat.o(112153);
            return;
        }
        a aVar = (a) view.getTag();
        if (bo.isNullOrNil(aVar.jumpUrl)) {
            ab.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
            AppMethodBeat.o(112153);
            return;
        }
        b.a(this.mContext, 10, TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER, aVar.mYy, c.t(this.mContext, aVar.jumpUrl, aVar.cMm), aVar.appId, this.mXC, com.tencent.mm.plugin.game.e.a.kY(aVar.mVB));
        AppMethodBeat.o(112153);
    }
}
