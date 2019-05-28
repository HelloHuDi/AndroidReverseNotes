package com.tencent.p177mm.plugin.fingerprint.p414ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C43095a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;

/* renamed from: com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI */
public class SoterPayTestUI extends MMActivity implements C1202f {

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI$1 */
    class C280581 implements OnClickListener {
        C280581() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41662);
            C4990ab.m7416i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(1586, SoterPayTestUI.this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C43095a(0), 0);
            AppMethodBeat.m2505o(41662);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI$2 */
    class C280592 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI$2$1 */
        class C280601 implements C16164b<C16165c> {
            C280601() {
            }

            /* renamed from: a */
            public final /* bridge */ /* synthetic */ void mo17330a(C46744e c46744e) {
            }
        }

        C280592() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41663);
            C4990ab.m7416i("MicroMsg.SoterPayTestUI", "hy: regen and upload ask");
            C30954a.m49587a(new C280601(), false, null);
            AppMethodBeat.m2505o(41663);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI$3 */
    class C280613 implements OnClickListener {
        C280613() {
        }

        public final void onClick(View view) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41664);
        super.onCreate(bundle);
        findViewById(2131824050).setOnClickListener(new C280581());
        findViewById(2131824051).setOnClickListener(new C280592());
        findViewById(2131824052).setOnClickListener(new C280613());
        AppMethodBeat.m2505o(41664);
    }

    public final int getLayoutId() {
        return 2130969564;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41665);
        C4990ab.m7417i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        C23639t.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(c1207m.getType(), (C1202f) this);
        AppMethodBeat.m2505o(41665);
    }
}
