package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C34273cx;
import com.tencent.p177mm.plugin.game.p731d.C39184ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.tencent.mm.plugin.game.ui.GameRecomBlockView */
public class GameRecomBlockView extends LinearLayout implements OnClickListener {
    private ViewGroup mContainer = this;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int mXC;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameRecomBlockView$a */
    static class C3264a {
        public String appId;
        public String cMm;
        public String jumpUrl;
        public String mVB;
        public int mYy;

        public C3264a(String str, int i, String str2, String str3, String str4) {
            this.appId = str;
            this.mYy = i;
            this.jumpUrl = str2;
            this.mVB = str3;
            this.cMm = str4;
        }
    }

    public GameRecomBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112150);
        setOrientation(1);
        this.mContext = context;
        AppMethodBeat.m2505o(112150);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112151);
        super.onFinishInflate();
        C4990ab.m7416i("MicroMsg.GameRecomBlockView", "initView finished");
        AppMethodBeat.m2505o(112151);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo36357a(C39184ah c39184ah, int i, int i2) {
        AppMethodBeat.m2504i(112152);
        this.mContainer.removeAllViews();
        if (C5046bo.m7548ek(c39184ah.naO)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112152);
            return;
        }
        if (i == 2) {
            C34276a.m56205a(this.mContext, 10, TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER, 0, null, i2, C34276a.m56208kY(c39184ah.mZL));
        }
        this.mInflater.inflate(2130969663, this, true);
        TextView textView = (TextView) findViewById(2131824320);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131824321);
        View findViewById = findViewById(2131824322);
        TextView textView2 = (TextView) findViewById(2131824323);
        if (C5046bo.isNullOrNil(c39184ah.mZM)) {
            textView.setVisibility(8);
        } else {
            textView.setText(c39184ah.mZM);
        }
        if (C5046bo.isNullOrNil(c39184ah.naP)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(c39184ah.naP);
        }
        findViewById.setTag(new C3264a(null, 999, c39184ah.naQ, c39184ah.mZL, "game_center_mygame_more"));
        findViewById.setOnClickListener(this);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < c39184ah.naO.size()) {
                C34273cx c34273cx = (C34273cx) c39184ah.naO.get(i5);
                if (c34273cx != null) {
                    if (linearLayout.getChildCount() < 3) {
                        i3++;
                        LinearLayout linearLayout2 = (LinearLayout) this.mInflater.inflate(2130969664, this, false);
                        linearLayout2.setTag(new C3264a(c34273cx.fKh, i3, c34273cx.mZj, c34273cx.mZL, "game_center_mygame_rank"));
                        linearLayout2.setOnClickListener(this);
                        linearLayout.addView(linearLayout2, new LayoutParams(-1, -2, 1.0f));
                        textView = (TextView) linearLayout2.findViewById(2131824324);
                        ImageView imageView = (ImageView) linearLayout2.findViewById(2131824325);
                        TextView textView3 = (TextView) linearLayout2.findViewById(2131824326);
                        TextView textView4 = (TextView) linearLayout2.findViewById(2131824327);
                        switch (i5) {
                            case 0:
                                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12036q7));
                                break;
                            case 1:
                                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12037q8));
                                break;
                            case 2:
                                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12038q9));
                                break;
                        }
                        textView.setText(c34273cx.Title);
                        C28203e.bFH().mo46100h(imageView, c34273cx.mZi);
                        textView3.setText(c34273cx.ncH);
                        if (C5046bo.isNullOrNil(c34273cx.Desc)) {
                            textView4.setVisibility(8);
                        } else {
                            textView4.setText(c34273cx.Desc);
                        }
                        if (i == 2) {
                            C34276a.m56205a(this.mContext, 10, TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER, i3, c34273cx.fKh, i2, C34276a.m56208kY(c34273cx.mZL));
                        }
                    }
                }
                i4 = i5 + 1;
            }
        }
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(C25738R.color.f12022pr));
        addView(view, new LayoutParams(-1, C1338a.fromDPToPix(getContext(), 5)));
        AppMethodBeat.m2505o(112152);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112153);
        if (view.getTag() == null || !(view.getTag() instanceof C3264a)) {
            C4990ab.m7420w("MicroMsg.GameRecomBlockView", "getTag is null");
            AppMethodBeat.m2505o(112153);
            return;
        }
        C3264a c3264a = (C3264a) view.getTag();
        if (C5046bo.isNullOrNil(c3264a.jumpUrl)) {
            C4990ab.m7420w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
            AppMethodBeat.m2505o(112153);
            return;
        }
        C34277b.m56211a(this.mContext, 10, TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER, c3264a.mYy, C46001c.m85464t(this.mContext, c3264a.jumpUrl, c3264a.cMm), c3264a.appId, this.mXC, C34276a.m56208kY(c3264a.mVB));
        AppMethodBeat.m2505o(112153);
    }
}
