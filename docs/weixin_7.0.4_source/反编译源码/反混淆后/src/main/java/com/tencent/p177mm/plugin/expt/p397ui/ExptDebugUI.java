package com.tencent.p177mm.plugin.expt.p397ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.picker.C40908b;
import com.tencent.p177mm.p612ui.widget.picker.C40908b.C40907a;
import com.tencent.p177mm.plugin.expt.p396d.C7503a;
import com.tencent.p177mm.plugin.expt.p729b.C45898a;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.expt.ui.ExptDebugUI */
public class ExptDebugUI extends MMActivity {
    private Button grC;
    private Button gzI;
    private TextView lOS;
    private Button lOT;
    private Button lOU;
    private TextView lOV;
    private TextView lOW;
    private TextView lOX;
    private TextView lOY;
    private TextView lOZ;
    private EditText lPa;
    private Button lPb;
    private int lPc = 0;

    /* renamed from: com.tencent.mm.plugin.expt.ui.ExptDebugUI$6 */
    class C117656 implements OnClickListener {
        C117656() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73638);
            C7503a uZ = C45898a.bqR().mo73729uZ(ExptDebugUI.this.lPc);
            if (uZ != null && uZ.bro()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(ExptDebugUI.this.lPc));
                C45898a.bqR();
                C45898a.m85074a(null, null, linkedList);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(ExptDebugUI.this.lPc));
            ExptDebugUI.this.lOZ.setText(" del :" + ExptDebugUI.this.lPc + " " + (C45898a.bqR().mo73726bB(arrayList) > 0));
            AppMethodBeat.m2505o(73638);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.ui.ExptDebugUI$1 */
    class C117661 implements OnMenuItemClickListener {
        C117661() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(73632);
            ExptDebugUI.this.finish();
            AppMethodBeat.m2505o(73632);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.ui.ExptDebugUI$5 */
    class C117675 implements OnClickListener {
        C117675() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73637);
            C45898a.bqR();
            C45898a.m85079va(1);
            AppMethodBeat.m2505o(73637);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.ui.ExptDebugUI$2 */
    class C117682 implements OnClickListener {
        C117682() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73633);
            ExptDebugUI.m19601a(ExptDebugUI.this, C5046bo.getInt(ExptDebugUI.this.lOS.getText().toString().trim(), 0));
            AppMethodBeat.m2505o(73633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.ui.ExptDebugUI$4 */
    class C117694 implements OnClickListener {
        C117694() {
        }

        public final void onClick(View view) {
            ArrayList brx;
            AppMethodBeat.m2504i(73636);
            C45898a bqR = C45898a.bqR();
            if (bqR.lNF != null) {
                brx = bqR.lNF.brx();
            } else {
                brx = null;
            }
            if (brx != null && brx.size() > 0) {
                final String[] strArr = new String[brx.size()];
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = brx.get(i);
                }
                final C40908b c40908b = new C40908b(ExptDebugUI.this.mController.ylL, strArr);
                c40908b.mo64522Qq(0);
                c40908b.zSq = new C40907a() {
                    /* renamed from: d */
                    public final void mo7219d(boolean z, Object obj) {
                        AppMethodBeat.m2504i(73635);
                        c40908b.hide();
                        ExptDebugUI.m19601a(ExptDebugUI.this, C5046bo.getInt(strArr[c40908b.dLl()], 0));
                        AppMethodBeat.m2505o(73635);
                    }
                };
                c40908b.mo64521Qp(C1338a.fromDPToPix(ExptDebugUI.this.mController.ylL, C31128d.MIC_PTU_YOUJIALI));
                c40908b.show();
            }
            AppMethodBeat.m2505o(73636);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.ui.ExptDebugUI$3 */
    class C117703 implements OnClickListener {
        C117703() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73634);
            ExptDebugUI.m19602b(ExptDebugUI.this);
            AppMethodBeat.m2505o(73634);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(73639);
        super.onCreate(bundle);
        setMMTitle("Expt debug ui");
        setBackBtn(new C117661());
        this.lOS = (TextView) findViewById(2131820998);
        this.grC = (Button) findViewById(2131820999);
        this.grC.setOnClickListener(new C117682());
        this.lPa = (EditText) findViewById(2131821008);
        this.lPb = (Button) findViewById(2131821009);
        this.lPb.setOnClickListener(new C117703());
        this.lOT = (Button) findViewById(2131821000);
        this.lOT.setOnClickListener(new C117694());
        this.lOU = (Button) findViewById(2131821001);
        this.lOU.setOnClickListener(new C117675());
        this.gzI = (Button) findViewById(2131821002);
        this.gzI.setOnClickListener(new C117656());
        this.lOV = (TextView) findViewById(2131821003);
        this.lOW = (TextView) findViewById(2131821004);
        this.lOX = (TextView) findViewById(2131821005);
        this.lOY = (TextView) findViewById(2131821006);
        this.lOZ = (TextView) findViewById(2131821007);
        AppMethodBeat.m2505o(73639);
    }

    public final int getLayoutId() {
        return 2130968625;
    }

    /* renamed from: a */
    static /* synthetic */ void m19601a(ExptDebugUI exptDebugUI, int i) {
        AppMethodBeat.m2504i(73640);
        exptDebugUI.lPc = i;
        C7503a uZ = C45898a.bqR().mo73729uZ(exptDebugUI.lPc);
        if (uZ != null) {
            exptDebugUI.lOV.setText(uZ.field_exptId);
            exptDebugUI.lOW.setText(uZ.field_groupId);
            exptDebugUI.lOX.setText(uZ.field_exptSeq);
            exptDebugUI.lOY.setText(" start: " + uZ.field_startTime + " end: " + uZ.field_endTime);
        }
        HashMap a = C45898a.bqR().mo73724a(exptDebugUI.lPc, false, null, new PBool());
        if (a != null) {
            exptDebugUI.lOZ.setText(" args : " + a.toString());
        }
        AppMethodBeat.m2505o(73640);
    }

    /* renamed from: b */
    static /* synthetic */ void m19602b(ExptDebugUI exptDebugUI) {
        AppMethodBeat.m2504i(73641);
        C45898a.bqR().mo73723KY(exptDebugUI.lPa.getText().toString().trim());
        exptDebugUI.lPa.setText("");
        AppMethodBeat.m2505o(73641);
    }
}
