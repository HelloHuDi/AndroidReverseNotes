package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;

public final class c implements OnClickListener {
    private TextView jKM;
    private MultiTalkMainUI oIm;
    private View oIn;
    private TextView oIo;
    private ImageView oIp;
    private LinearLayout oIq;
    private ImageButton oIr;
    private ImageButton oIs;

    public c(MultiTalkMainUI multiTalkMainUI) {
        AppMethodBeat.i(54188);
        this.oIm = multiTalkMainUI;
        this.oIn = multiTalkMainUI.findViewById(R.id.dea);
        this.oIo = (TextView) multiTalkMainUI.findViewById(R.id.dec);
        this.oIp = (ImageView) multiTalkMainUI.findViewById(R.id.deb);
        this.oIq = (LinearLayout) multiTalkMainUI.findViewById(R.id.dee);
        this.jKM = (TextView) multiTalkMainUI.findViewById(R.id.ded);
        this.oIr = (ImageButton) multiTalkMainUI.findViewById(R.id.deg);
        this.oIs = (ImageButton) multiTalkMainUI.findViewById(R.id.def);
        this.oIr.setOnClickListener(this);
        this.oIs.setOnClickListener(this);
        AppMethodBeat.o(54188);
    }

    public final void n(MultiTalkGroup multiTalkGroup) {
        int i = 0;
        AppMethodBeat.i(54189);
        this.oIn.setVisibility(0);
        String bRV = j.bRV();
        ArrayList arrayList = new ArrayList();
        if (!bo.isNullOrNil(bRV)) {
            for (int i2 = 0; i2 < multiTalkGroup.Aqg.size(); i2++) {
                if (!((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i2)).Aqh.equals(bRV)) {
                    arrayList.add(((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i2)).Aqh);
                }
            }
            this.oIo.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.oIm, s.mJ(bRV)));
            b.a(this.oIp, bRV, 0.1f, true);
        }
        if (arrayList.size() > 0) {
            this.jKM.setVisibility(0);
            this.jKM.setText(R.string.d2v);
            this.oIq.setVisibility(0);
            this.oIq.removeAllViews();
            while (i < arrayList.size()) {
                ImageView imageView = new ImageView(this.oIm.mController.ylL);
                int i3 = b.oIf;
                LayoutParams layoutParams = new LayoutParams(i3, i3);
                if (i != 0) {
                    layoutParams.leftMargin = b.oId;
                }
                imageView.setLayoutParams(layoutParams);
                this.oIq.addView(imageView);
                b.b(imageView, (String) arrayList.get(i));
                i++;
            }
            AppMethodBeat.o(54189);
            return;
        }
        this.jKM.setVisibility(8);
        this.oIq.setVisibility(8);
        AppMethodBeat.o(54189);
    }

    public final void bSm() {
        AppMethodBeat.i(54190);
        this.oIn.setVisibility(8);
        AppMethodBeat.o(54190);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(54191);
        if (view.getId() == R.id.def) {
            p.bSf().h(true, false, false);
            AppMethodBeat.o(54191);
            return;
        }
        if (view.getId() == R.id.deg) {
            f bSf = p.bSf();
            if (bSf.bRd()) {
                ab.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", j.h(bSf.oGh));
                p.bSe().oFP.A(bSf.oGh.Aqc, bSf.oGh.AlR, bSf.oGh.Aqe);
                AppMethodBeat.o(54191);
                return;
            }
            ab.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
        AppMethodBeat.o(54191);
    }
}
