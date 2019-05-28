package com.tencent.p177mm.plugin.multitalk.p459ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.plugin.multitalk.model.C12630f;
import com.tencent.p177mm.plugin.multitalk.model.C34571j;
import com.tencent.p177mm.plugin.multitalk.model.C34572p;
import com.tencent.p177mm.plugin.multitalk.p459ui.MultiTalkMainUI;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.c */
public final class C43321c implements OnClickListener {
    private TextView jKM;
    private MultiTalkMainUI oIm;
    private View oIn;
    private TextView oIo;
    private ImageView oIp;
    private LinearLayout oIq;
    private ImageButton oIr;
    private ImageButton oIs;

    public C43321c(MultiTalkMainUI multiTalkMainUI) {
        AppMethodBeat.m2504i(54188);
        this.oIm = multiTalkMainUI;
        this.oIn = multiTalkMainUI.findViewById(2131826215);
        this.oIo = (TextView) multiTalkMainUI.findViewById(2131826217);
        this.oIp = (ImageView) multiTalkMainUI.findViewById(2131826216);
        this.oIq = (LinearLayout) multiTalkMainUI.findViewById(2131826219);
        this.jKM = (TextView) multiTalkMainUI.findViewById(2131826218);
        this.oIr = (ImageButton) multiTalkMainUI.findViewById(2131826221);
        this.oIs = (ImageButton) multiTalkMainUI.findViewById(2131826220);
        this.oIr.setOnClickListener(this);
        this.oIs.setOnClickListener(this);
        AppMethodBeat.m2505o(54188);
    }

    /* renamed from: n */
    public final void mo68868n(MultiTalkGroup multiTalkGroup) {
        int i = 0;
        AppMethodBeat.m2504i(54189);
        this.oIn.setVisibility(0);
        String bRV = C34571j.bRV();
        ArrayList arrayList = new ArrayList();
        if (!C5046bo.isNullOrNil(bRV)) {
            for (int i2 = 0; i2 < multiTalkGroup.Aqg.size(); i2++) {
                if (!((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i2)).Aqh.equals(bRV)) {
                    arrayList.add(((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i2)).Aqh);
                }
            }
            this.oIo.setText(C44089j.m79292b(this.oIm, C1854s.m3866mJ(bRV)));
            C40460b.m69433a(this.oIp, bRV, 0.1f, true);
        }
        if (arrayList.size() > 0) {
            this.jKM.setVisibility(0);
            this.jKM.setText(C25738R.string.d2v);
            this.oIq.setVisibility(0);
            this.oIq.removeAllViews();
            while (i < arrayList.size()) {
                ImageView imageView = new ImageView(this.oIm.mController.ylL);
                int i3 = C43320b.oIf;
                LayoutParams layoutParams = new LayoutParams(i3, i3);
                if (i != 0) {
                    layoutParams.leftMargin = C43320b.oId;
                }
                imageView.setLayoutParams(layoutParams);
                this.oIq.addView(imageView);
                C40460b.m69434b(imageView, (String) arrayList.get(i));
                i++;
            }
            AppMethodBeat.m2505o(54189);
            return;
        }
        this.jKM.setVisibility(8);
        this.oIq.setVisibility(8);
        AppMethodBeat.m2505o(54189);
    }

    public final void bSm() {
        AppMethodBeat.m2504i(54190);
        this.oIn.setVisibility(8);
        AppMethodBeat.m2505o(54190);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(54191);
        if (view.getId() == 2131826220) {
            C34572p.bSf().mo24587h(true, false, false);
            AppMethodBeat.m2505o(54191);
            return;
        }
        if (view.getId() == 2131826221) {
            C12630f bSf = C34572p.bSf();
            if (bSf.bRd()) {
                C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", C34571j.m56700h(bSf.oGh));
                C34572p.bSe().oFP.mo58354A(bSf.oGh.Aqc, bSf.oGh.AlR, bSf.oGh.Aqe);
                AppMethodBeat.m2505o(54191);
                return;
            }
            C4990ab.m7412e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
        AppMethodBeat.m2505o(54191);
    }
}
