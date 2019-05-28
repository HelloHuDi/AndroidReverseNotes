package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.a;
import com.tencent.soter.core.a.a.b;
import com.tencent.soter.core.a.a.d;
import com.tencent.soter.core.c.i;
import com.tencent.soter.core.c.j;
import java.security.Signature;
import java.security.SignatureException;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(59392);
        super.onCreate(bundle);
        this.rOz = (Button) findViewById(R.id.eou);
        this.rOA = (Button) findViewById(R.id.eov);
        this.rOB = (Button) findViewById(R.id.eow);
        this.rOC = (Button) findViewById(R.id.eox);
        this.rOD = (Button) findViewById(R.id.eoy);
        this.rOE = (Button) findViewById(R.id.eoz);
        this.rOF = (Button) findViewById(R.id.ep0);
        this.rOG = (Button) findViewById(R.id.ep1);
        this.rOH = (Button) findViewById(R.id.ep2);
        this.rOI = (TextView) findViewById(R.id.eot);
        this.rOz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59379);
                SoterTestUI.this.rOI.setText(a.dRc() ? "passed" : "not support");
                AppMethodBeat.o(59379);
            }
        });
        this.rOA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59380);
                SoterTestUI.this.rOI.setText(com.tencent.soter.core.a.dQO().isSuccess() ? "passed" : "not support");
                AppMethodBeat.o(59380);
            }
        });
        this.rOB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59381);
                SoterTestUI.this.rOI.setText(com.tencent.soter.core.a.dQP().isSuccess() ? "passed" : "not passed");
                AppMethodBeat.o(59381);
            }
        });
        this.rOC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59382);
                i dQS = com.tencent.soter.core.a.dQS();
                if (dQS == null) {
                    SoterTestUI.this.rOI.setText("not passed: no certificate");
                    AppMethodBeat.o(59382);
                    return;
                }
                SoterTestUI.this.rOI.setText("model available: " + dQS.toString());
                AppMethodBeat.o(59382);
            }
        });
        this.rOD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59383);
                SoterTestUI.this.rOI.setText(com.tencent.soter.core.a.atZ("sample_auth_key_name").isSuccess() ? "pass" : "not passed");
                AppMethodBeat.o(59383);
            }
        });
        this.rOE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59384);
                SoterTestUI.this.rOI.setText(com.tencent.soter.core.a.cn("sample_auth_key_name", false).isSuccess() ? "pass" : "not passed");
                AppMethodBeat.o(59384);
            }
        });
        this.rOF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59385);
                i auc = com.tencent.soter.core.a.auc("sample_auth_key_name");
                if (auc == null) {
                    SoterTestUI.this.rOI.setText("not passed: no certificate");
                    AppMethodBeat.o(59385);
                    return;
                }
                SoterTestUI.this.rOI.setText("model available: " + auc.toString());
                AppMethodBeat.o(59385);
            }
        });
        this.rOG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(59391);
                final Signature aud = com.tencent.soter.core.a.aud("sample_auth_key_name");
                if (aud != null) {
                    try {
                        aud.update("challenge".getBytes());
                        aud.sign();
                        ab.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                        SoterTestUI.this.rOI.setText("not passed: signature success without fingerprint authentication");
                        AppMethodBeat.o(59391);
                        return;
                    } catch (SignatureException e) {
                        ab.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                        com.tencent.soter.core.a.a iU = com.tencent.soter.core.a.a.iU(SoterTestUI.this);
                        if (iU.isHardwareDetected() && iU.hasEnrolledFingerprints()) {
                            iU.a(new d(aud), null, new b() {
                                public final void onAuthenticationError(int i, CharSequence charSequence) {
                                    AppMethodBeat.i(59386);
                                    ab.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
                                    AppMethodBeat.o(59386);
                                }

                                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                                    AppMethodBeat.i(59387);
                                    ab.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
                                    AppMethodBeat.o(59387);
                                }

                                public final void cvW() {
                                    AppMethodBeat.i(59388);
                                    ab.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
                                    try {
                                        aud.update("challenge".getBytes());
                                        j co = com.tencent.soter.core.a.co(aud.sign());
                                        SoterTestUI.this.rOI.setText(co == null ? "not pass: exception occurs" : co.toString());
                                        AppMethodBeat.o(59388);
                                    } catch (SignatureException e) {
                                        ab.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                                        AppMethodBeat.o(59388);
                                    }
                                }

                                public final void onAuthenticationFailed() {
                                    AppMethodBeat.i(59389);
                                    ab.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
                                    AppMethodBeat.o(59389);
                                }

                                public final void onAuthenticationCancelled() {
                                    AppMethodBeat.i(59390);
                                    super.onAuthenticationCancelled();
                                    AppMethodBeat.o(59390);
                                }
                            });
                            AppMethodBeat.o(59391);
                            return;
                        }
                        ab.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                        AppMethodBeat.o(59391);
                        return;
                    }
                }
                ab.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
                AppMethodBeat.o(59391);
            }
        });
        AppMethodBeat.o(59392);
    }

    public final int getLayoutId() {
        return R.layout.axf;
    }
}
