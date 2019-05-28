package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12121di;
import com.tencent.p177mm.plugin.game.p731d.C28194dh;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameNewClassifyView */
public class GameNewClassifyView extends LinearLayout implements OnClickListener {
    private LayoutInflater ezi;
    private int mXC;
    private LinearLayout mpt;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameNewClassifyView$a */
    static class C39231a {
        public String extInfo;
        public int position;
        public String url;

        public C39231a(String str, int i, String str2) {
            this.url = str;
            this.position = i;
            this.extInfo = str2;
        }
    }

    public GameNewClassifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112118);
        super.onFinishInflate();
        this.ezi = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.mpt = (LinearLayout) findViewById(2131824406);
        AppMethodBeat.m2505o(112118);
    }

    /* renamed from: a */
    public final void mo68704a(C12121di c12121di, int i, int i2) {
        AppMethodBeat.m2504i(112119);
        if (c12121di == null || C5046bo.m7548ek(c12121di.naO)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112119);
            return;
        }
        LinearLayout linearLayout;
        this.mXC = i2;
        if (this.ezi == null) {
            this.ezi = (LayoutInflater) getContext().getSystemService("layout_inflater");
        }
        this.mpt.removeAllViews();
        while (this.mpt.getChildCount() < c12121di.naO.size()) {
            linearLayout = (LinearLayout) this.ezi.inflate(2130969762, this, false);
            linearLayout.setOnClickListener(this);
            this.mpt.addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
        }
        for (int i3 = 0; i3 < this.mpt.getChildCount(); i3++) {
            if (i3 < c12121di.naO.size()) {
                this.mpt.getChildAt(i3).setVisibility(0);
            } else {
                this.mpt.getChildAt(i3).setVisibility(8);
            }
        }
        for (int i4 = 0; i4 < c12121di.naO.size(); i4++) {
            linearLayout = (LinearLayout) this.mpt.getChildAt(i4);
            TextView textView = (TextView) linearLayout.findViewById(2131824408);
            C28203e.bFH().mo46100h((ImageView) linearLayout.findViewById(2131824407), ((C28194dh) c12121di.naO.get(i4)).IconUrl);
            textView.setText(((C28194dh) c12121di.naO.get(i4)).Title);
            linearLayout.setTag(new C39231a(((C28194dh) c12121di.naO.get(i4)).mZj, i4 + 1, ((C28194dh) c12121di.naO.get(i4)).mZL));
        }
        setVisibility(0);
        if (i == 2) {
            C34276a.m56205a(getContext(), 10, 1019, 0, null, this.mXC, null);
        }
        AppMethodBeat.m2505o(112119);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112120);
        if (view.getTag() == null || !(view.getTag() instanceof C39231a)) {
            AppMethodBeat.m2505o(112120);
            return;
        }
        C39231a c39231a = (C39231a) view.getTag();
        if (!C5046bo.isNullOrNil(c39231a.url)) {
            C46001c.m85455ax(getContext(), c39231a.url);
            C34277b.m56211a(getContext(), 10, 1019, c39231a.position, 7, null, this.mXC, C34276a.m56208kY(c39231a.extInfo));
        }
        AppMethodBeat.m2505o(112120);
    }
}
