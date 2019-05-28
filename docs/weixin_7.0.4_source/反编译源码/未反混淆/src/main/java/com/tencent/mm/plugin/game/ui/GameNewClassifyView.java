package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.d.di;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bo;

public class GameNewClassifyView extends LinearLayout implements OnClickListener {
    private LayoutInflater ezi;
    private int mXC;
    private LinearLayout mpt;

    static class a {
        public String extInfo;
        public int position;
        public String url;

        public a(String str, int i, String str2) {
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
        AppMethodBeat.i(112118);
        super.onFinishInflate();
        this.ezi = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.mpt = (LinearLayout) findViewById(R.id.c3d);
        AppMethodBeat.o(112118);
    }

    public final void a(di diVar, int i, int i2) {
        AppMethodBeat.i(112119);
        if (diVar == null || bo.ek(diVar.naO)) {
            setVisibility(8);
            AppMethodBeat.o(112119);
            return;
        }
        LinearLayout linearLayout;
        this.mXC = i2;
        if (this.ezi == null) {
            this.ezi = (LayoutInflater) getContext().getSystemService("layout_inflater");
        }
        this.mpt.removeAllViews();
        while (this.mpt.getChildCount() < diVar.naO.size()) {
            linearLayout = (LinearLayout) this.ezi.inflate(R.layout.a59, this, false);
            linearLayout.setOnClickListener(this);
            this.mpt.addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
        }
        for (int i3 = 0; i3 < this.mpt.getChildCount(); i3++) {
            if (i3 < diVar.naO.size()) {
                this.mpt.getChildAt(i3).setVisibility(0);
            } else {
                this.mpt.getChildAt(i3).setVisibility(8);
            }
        }
        for (int i4 = 0; i4 < diVar.naO.size(); i4++) {
            linearLayout = (LinearLayout) this.mpt.getChildAt(i4);
            TextView textView = (TextView) linearLayout.findViewById(R.id.c3f);
            e.bFH().h((ImageView) linearLayout.findViewById(R.id.c3e), ((dh) diVar.naO.get(i4)).IconUrl);
            textView.setText(((dh) diVar.naO.get(i4)).Title);
            linearLayout.setTag(new a(((dh) diVar.naO.get(i4)).mZj, i4 + 1, ((dh) diVar.naO.get(i4)).mZL));
        }
        setVisibility(0);
        if (i == 2) {
            com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1019, 0, null, this.mXC, null);
        }
        AppMethodBeat.o(112119);
    }

    public void onClick(View view) {
        AppMethodBeat.i(112120);
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            AppMethodBeat.o(112120);
            return;
        }
        a aVar = (a) view.getTag();
        if (!bo.isNullOrNil(aVar.url)) {
            c.ax(getContext(), aVar.url);
            b.a(getContext(), 10, 1019, aVar.position, 7, null, this.mXC, com.tencent.mm.plugin.game.e.a.kY(aVar.extInfo));
        }
        AppMethodBeat.o(112120);
    }
}
