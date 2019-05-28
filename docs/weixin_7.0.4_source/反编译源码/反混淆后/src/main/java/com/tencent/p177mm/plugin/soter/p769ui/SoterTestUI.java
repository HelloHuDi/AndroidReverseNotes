package com.tencent.p177mm.plugin.soter.p769ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.core.p665a.C44473a;
import com.tencent.soter.core.p665a.C44473a.C36452d;
import com.tencent.soter.core.p665a.C44473a.C5825b;
import com.tencent.soter.p663a.C30954a;
import java.security.Signature;
import java.security.SignatureException;

/* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI */
public class SoterTestUI extends MMActivity {
    private Button rOA = null;
    private Button rOB = null;
    private Button rOC = null;
    private Button rOD = null;
    private Button rOE = null;
    private Button rOF = null;
    private Button rOG = null;
    private Button rOH = null;
    private TextView rOI = null;
    private Button rOz = null;

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$4 */
    class C137234 implements OnClickListener {
        C137234() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59382);
            C30972i dQS = C40997a.dQS();
            if (dQS == null) {
                SoterTestUI.this.rOI.setText("not passed: no certificate");
                AppMethodBeat.m2505o(59382);
                return;
            }
            SoterTestUI.this.rOI.setText("model available: " + dQS.toString());
            AppMethodBeat.m2505o(59382);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$5 */
    class C137245 implements OnClickListener {
        C137245() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59383);
            SoterTestUI.this.rOI.setText(C40997a.atZ("sample_auth_key_name").isSuccess() ? "pass" : "not passed");
            AppMethodBeat.m2505o(59383);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$7 */
    class C137257 implements OnClickListener {
        C137257() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59385);
            C30972i auc = C40997a.auc("sample_auth_key_name");
            if (auc == null) {
                SoterTestUI.this.rOI.setText("not passed: no certificate");
                AppMethodBeat.m2505o(59385);
                return;
            }
            SoterTestUI.this.rOI.setText("model available: " + auc.toString());
            AppMethodBeat.m2505o(59385);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$6 */
    class C137266 implements OnClickListener {
        C137266() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59384);
            SoterTestUI.this.rOI.setText(C40997a.m71093cn("sample_auth_key_name", false).isSuccess() ? "pass" : "not passed");
            AppMethodBeat.m2505o(59384);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$1 */
    class C137271 implements OnClickListener {
        C137271() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59379);
            SoterTestUI.this.rOI.setText(C30954a.dRc() ? "passed" : "not support");
            AppMethodBeat.m2505o(59379);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$2 */
    class C137282 implements OnClickListener {
        C137282() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59380);
            SoterTestUI.this.rOI.setText(C40997a.dQO().isSuccess() ? "passed" : "not support");
            AppMethodBeat.m2505o(59380);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$3 */
    class C137293 implements OnClickListener {
        C137293() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59381);
            SoterTestUI.this.rOI.setText(C40997a.dQP().isSuccess() ? "passed" : "not passed");
            AppMethodBeat.m2505o(59381);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterTestUI$8 */
    class C137308 implements OnClickListener {
        C137308() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(59391);
            final Signature aud = C40997a.aud("sample_auth_key_name");
            if (aud != null) {
                try {
                    aud.update("challenge".getBytes());
                    aud.sign();
                    C4990ab.m7412e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                    SoterTestUI.this.rOI.setText("not passed: signature success without fingerprint authentication");
                    AppMethodBeat.m2505o(59391);
                    return;
                } catch (SignatureException e) {
                    C4990ab.m7412e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                    C44473a iU = C44473a.m80472iU(SoterTestUI.this);
                    if (iU.isHardwareDetected() && iU.hasEnrolledFingerprints()) {
                        iU.mo70647a(new C36452d(aud), null, new C5825b() {
                            public final void onAuthenticationError(int i, CharSequence charSequence) {
                                AppMethodBeat.m2504i(59386);
                                C4990ab.m7416i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
                                AppMethodBeat.m2505o(59386);
                            }

                            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                                AppMethodBeat.m2504i(59387);
                                C4990ab.m7416i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
                                AppMethodBeat.m2505o(59387);
                            }

                            public final void cvW() {
                                AppMethodBeat.m2504i(59388);
                                C4990ab.m7416i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
                                try {
                                    aud.update("challenge".getBytes());
                                    C30973j co = C40997a.m71094co(aud.sign());
                                    SoterTestUI.this.rOI.setText(co == null ? "not pass: exception occurs" : co.toString());
                                    AppMethodBeat.m2505o(59388);
                                } catch (SignatureException e) {
                                    C4990ab.m7412e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                                    AppMethodBeat.m2505o(59388);
                                }
                            }

                            public final void onAuthenticationFailed() {
                                AppMethodBeat.m2504i(59389);
                                C4990ab.m7416i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
                                AppMethodBeat.m2505o(59389);
                            }

                            public final void onAuthenticationCancelled() {
                                AppMethodBeat.m2504i(59390);
                                super.onAuthenticationCancelled();
                                AppMethodBeat.m2505o(59390);
                            }
                        });
                        AppMethodBeat.m2505o(59391);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                    AppMethodBeat.m2505o(59391);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
            AppMethodBeat.m2505o(59391);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(59392);
        super.onCreate(bundle);
        this.rOz = (Button) findViewById(2131827974);
        this.rOA = (Button) findViewById(2131827975);
        this.rOB = (Button) findViewById(2131827976);
        this.rOC = (Button) findViewById(2131827977);
        this.rOD = (Button) findViewById(2131827978);
        this.rOE = (Button) findViewById(2131827979);
        this.rOF = (Button) findViewById(2131827980);
        this.rOG = (Button) findViewById(2131827981);
        this.rOH = (Button) findViewById(2131827982);
        this.rOI = (TextView) findViewById(2131827973);
        this.rOz.setOnClickListener(new C137271());
        this.rOA.setOnClickListener(new C137282());
        this.rOB.setOnClickListener(new C137293());
        this.rOC.setOnClickListener(new C137234());
        this.rOD.setOnClickListener(new C137245());
        this.rOE.setOnClickListener(new C137266());
        this.rOF.setOnClickListener(new C137257());
        this.rOG.setOnClickListener(new C137308());
        AppMethodBeat.m2505o(59392);
    }

    public final int getLayoutId() {
        return 2130970842;
    }
}
