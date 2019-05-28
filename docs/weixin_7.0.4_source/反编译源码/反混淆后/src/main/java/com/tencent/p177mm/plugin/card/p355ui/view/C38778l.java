package com.tencent.p177mm.plugin.card.p355ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C15396wz;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.ui.view.l */
public final class C38778l extends C45800i {
    View kqM;
    LinearLayout kqN;
    boolean kqO = false;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.m2504i(88755);
        if (this.kqM == null) {
            this.kqM = ((ViewStub) findViewById(2131822031)).inflate();
        }
        final C15396wz c15396wz = this.kqK.bcv().aZW().vSl;
        ((TextView) this.kqM.findViewById(2131822012)).setText(c15396wz.title);
        if (c15396wz.wcV != null && c15396wz.wcV.size() > 0) {
            this.kqN = (LinearLayout) this.kqM.findViewById(2131822013);
            this.kqN.removeAllViews();
            final LinkedList linkedList = c15396wz.wcV;
            final LayoutInflater layoutInflater = (LayoutInflater) this.kqK.bcy().getSystemService("layout_inflater");
            int i;
            TextView textView;
            if (c15396wz.wcU >= linkedList.size() || this.kqO) {
                this.kqM.findViewById(2131822014).setVisibility(8);
                for (i = 0; i < linkedList.size(); i++) {
                    textView = (TextView) layoutInflater.inflate(2130968990, null, false);
                    textView.setText(((C23446tm) linkedList.get(i)).title);
                    this.kqN.addView(textView);
                }
                this.kqN.invalidate();
                AppMethodBeat.m2505o(88755);
                return;
            }
            for (i = 0; i < c15396wz.wcU; i++) {
                textView = (TextView) layoutInflater.inflate(2130968990, null, false);
                textView.setText(((C23446tm) linkedList.get(i)).title);
                this.kqN.addView(textView);
            }
            this.kqN.invalidate();
            this.kqM.findViewById(2131822014).setVisibility(0);
            this.kqM.findViewById(2131822014).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(88754);
                    C38778l.this.kqO = true;
                    C38778l.this.kqM.findViewById(2131822014).setVisibility(8);
                    int i = c15396wz.wcU;
                    while (true) {
                        int i2 = i;
                        if (i2 < linkedList.size()) {
                            TextView textView = (TextView) layoutInflater.inflate(2130968990, null, false);
                            textView.setText(((C23446tm) linkedList.get(i2)).title);
                            C38778l.this.kqN.addView(textView);
                            i = i2 + 1;
                        } else {
                            C38778l.this.kqN.invalidate();
                            AppMethodBeat.m2505o(88754);
                            return;
                        }
                    }
                }
            });
        }
        AppMethodBeat.m2505o(88755);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88756);
        if (this.kqM != null) {
            this.kqM.setVisibility(8);
        }
        AppMethodBeat.m2505o(88756);
    }
}
