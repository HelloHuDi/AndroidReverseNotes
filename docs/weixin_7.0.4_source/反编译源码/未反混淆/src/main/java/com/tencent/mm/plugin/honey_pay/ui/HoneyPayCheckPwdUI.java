package com.tencent.mm.plugin.honey_pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.a.g;
import com.tencent.mm.plugin.honey_pay.a.n;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.a;
import java.io.IOException;

public class HoneyPayCheckPwdUI extends HoneyPayBaseUI {
    private int gOW;
    private TextView iDT;
    private String igi;
    private TextView kEq;
    private EditHintPasswdView nrZ;
    private String nra;
    private chl nrb;
    private String nsa;
    private String nsb;
    private long nsc;
    private int nsd;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41851);
        super.onCreate(bundle);
        this.igi = getIntent().getStringExtra("key_username");
        this.nsa = getIntent().getStringExtra("key_take_message");
        this.nsc = getIntent().getLongExtra("key_credit_line", 0);
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        this.nra = getIntent().getStringExtra("key_card_no");
        this.nsb = getIntent().getStringExtra("key_wishing");
        if (this.gOW == 1) {
            this.nsd = getIntent().getIntExtra("key_cardtype", 0);
            if (this.nsd == 0) {
                ab.w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", Integer.valueOf(this.nsd));
                finish();
            }
        }
        if (this.gOW == 3) {
            chl chl = new chl();
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_toke_mess");
                if (byteArrayExtra == null || byteArrayExtra.length == 0) {
                    ab.w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
                    finish();
                }
                chl.parseFrom(byteArrayExtra);
                this.nrb = chl;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", e, "", new Object[0]);
                finish();
            }
        }
        setMMTitle("");
        nf(2662);
        nf(2865);
        nf(2630);
        nf(2815);
        nf(2659);
        initView();
        AppMethodBeat.o(41851);
    }

    public final void initView() {
        AppMethodBeat.i(41852);
        this.nrZ = (EditHintPasswdView) findViewById(R.id.cfs);
        a.a(this.nrZ);
        this.nrZ.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(41833);
                if (z) {
                    if (HoneyPayCheckPwdUI.this.gOW == 1) {
                        HoneyPayCheckPwdUI.b(HoneyPayCheckPwdUI.this);
                    } else if (HoneyPayCheckPwdUI.this.gOW == 2) {
                        HoneyPayCheckPwdUI.c(HoneyPayCheckPwdUI.this);
                    } else if (HoneyPayCheckPwdUI.this.gOW == 3) {
                        HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    } else {
                        ab.w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", Integer.valueOf(HoneyPayCheckPwdUI.this.gOW));
                    }
                    HoneyPayCheckPwdUI.this.aoB();
                }
                AppMethodBeat.o(41833);
            }
        });
        e(this.nrZ, 0, false);
        this.iDT = (TextView) findViewById(R.id.cfp);
        this.kEq = (TextView) findViewById(R.id.cfq);
        if (this.gOW == 1) {
            this.iDT.setText(R.string.cc5);
        } else if (this.gOW == 2) {
            this.iDT.setText(R.string.cc6);
        } else {
            this.iDT.setText(R.string.cc8);
        }
        this.kEq.setText(R.string.cc7);
        AppMethodBeat.o(41852);
    }

    public void onDestroy() {
        AppMethodBeat.i(41853);
        super.onDestroy();
        ng(2662);
        ng(2865);
        ng(2630);
        ng(2815);
        ng(2659);
        AppMethodBeat.o(41853);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41854);
        ab.d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof w) {
            w wVar = (w) mVar;
            String str2;
            m hVar;
            if (i != 0 || i2 != 0) {
                if (this.nrZ != null) {
                    this.nrZ.cey();
                }
                bgk();
                if (!(wVar.AfO || bo.isNullOrNil(str))) {
                    ab.i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
                    h.a(this.mController.ylL, str, null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                AppMethodBeat.o(41854);
                return true;
            } else if (this.gOW == 1) {
                String str3 = wVar.tuu;
                ab.i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
                dOG();
                m cVar = new c(str3, this.nsc, this.igi, this.nsa, this.nsd, this.nsb);
                cVar.o(this);
                a(cVar, false, false);
            } else if (this.gOW == 2) {
                str2 = wVar.tuu;
                ab.i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
                dOG();
                hVar = new com.tencent.mm.plugin.honey_pay.a.h(this.nsc, str2, this.nra);
                hVar.o(this);
                a(hVar, false, false);
            } else if (this.gOW == 3) {
                str2 = wVar.tuu;
                ab.i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", this.nra);
                dOG();
                hVar = new n(this.nra, str2);
                hVar.o(this);
                a(hVar, false, false);
            }
        } else if (mVar instanceof c) {
            final c cVar2 = (c) mVar;
            bgk();
            cVar2.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41846);
                    ab.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
                    Intent intent = new Intent(HoneyPayCheckPwdUI.this.mController.ylL, HoneyPayMainUI.class);
                    intent.putExtra("key_create_succ", true);
                    if (cVar2.nqz.wci != null) {
                        intent.putExtra("key_card_no", cVar2.nqz.wci.wpp);
                        intent.putExtra("key_card_type", cVar2.nqz.wci.kdf);
                    }
                    Toast.makeText(HoneyPayCheckPwdUI.this.mController.ylL, R.string.cc9, 1).show();
                    HoneyPayCheckPwdUI.this.startActivity(intent);
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 2, 1);
                    AppMethodBeat.o(41846);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41845);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 3, 1);
                    AppMethodBeat.o(41845);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41844);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 3, 1);
                    AppMethodBeat.o(41844);
                }
            });
        } else if (mVar instanceof com.tencent.mm.plugin.honey_pay.a.h) {
            bgk();
            final com.tencent.mm.plugin.honey_pay.a.h hVar2 = (com.tencent.mm.plugin.honey_pay.a.h) mVar;
            hVar2.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41849);
                    ab.i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
                    Intent intent = new Intent();
                    intent.putExtra("key_modify_create_line_succ", true);
                    intent.putExtra("key_credit_line", hVar2.nqF);
                    HoneyPayCheckPwdUI.this.setResult(-1, intent);
                    HoneyPayCheckPwdUI.this.finish();
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 8, 1);
                    AppMethodBeat.o(41849);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41848);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 9, 1);
                    AppMethodBeat.o(41848);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41847);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 9, 1);
                    AppMethodBeat.o(41847);
                }
            });
        } else if (mVar instanceof d) {
            final d dVar = (d) mVar;
            dVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41837);
                    HoneyPayCheckPwdUI.this.nrb = dVar.nqA.woi;
                    if (dVar.nqA.woj != null) {
                        com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, dVar.nqA.woj, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(41836);
                                HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                                AppMethodBeat.o(41836);
                            }
                        });
                        HoneyPayCheckPwdUI.this.bgk();
                        AppMethodBeat.o(41837);
                        return;
                    }
                    HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    AppMethodBeat.o(41837);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41835);
                    if (dVar.nqA.woj != null) {
                        com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, dVar.nqA.woj, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(41834);
                                HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                                AppMethodBeat.o(41834);
                            }
                        });
                    } else if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    HoneyPayCheckPwdUI.this.bgk();
                    AppMethodBeat.o(41835);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41850);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    HoneyPayCheckPwdUI.this.bgk();
                    AppMethodBeat.o(41850);
                }
            });
        } else if (mVar instanceof g) {
            g gVar = (g) mVar;
            this.nrb = gVar.nqD.woi;
            gVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41840);
                    HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    AppMethodBeat.o(41840);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41839);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    HoneyPayCheckPwdUI.this.bgk();
                    AppMethodBeat.o(41839);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41838);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    HoneyPayCheckPwdUI.this.bgk();
                    AppMethodBeat.o(41838);
                }
            });
        } else if (mVar instanceof n) {
            bgk();
            ((n) mVar).a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41843);
                    HoneyPayCheckPwdUI.this.setResult(-1);
                    HoneyPayCheckPwdUI.this.finish();
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 6, 1);
                    AppMethodBeat.o(41843);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41842);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 7, 1);
                    AppMethodBeat.o(41842);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41841);
                    if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.k(875, 7, 1);
                    AppMethodBeat.o(41841);
                }
            });
        }
        AppMethodBeat.o(41854);
        return true;
    }

    public final void wU(int i) {
        AppMethodBeat.i(41855);
        super.wU(i);
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        AppMethodBeat.o(41855);
    }

    public final int getLayoutId() {
        return R.layout.a72;
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void b(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        AppMethodBeat.i(41856);
        ab.i("MicroMsg.HoneyPayCheckPwdUI", "do get create token sign");
        honeyPayCheckPwdUI.dOG();
        m dVar = new d(honeyPayCheckPwdUI.nsa, honeyPayCheckPwdUI.nsc);
        dVar.o(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.a(dVar, false, false);
        AppMethodBeat.o(41856);
    }

    static /* synthetic */ void c(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        AppMethodBeat.i(41857);
        ab.i("MicroMsg.HoneyPayCheckPwdUI", "modify credit line token sign");
        honeyPayCheckPwdUI.dOG();
        m gVar = new g(honeyPayCheckPwdUI.nra, honeyPayCheckPwdUI.nsc);
        gVar.o(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.a(gVar, false, false);
        AppMethodBeat.o(41857);
    }

    static /* synthetic */ void d(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        boolean z = true;
        AppMethodBeat.i(41858);
        String str = "MicroMsg.HoneyPayCheckPwdUI";
        String str2 = "do get pwd token: %s";
        Object[] objArr = new Object[1];
        if (honeyPayCheckPwdUI.nrb != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (honeyPayCheckPwdUI.nrb != null) {
            honeyPayCheckPwdUI.dOG();
            honeyPayCheckPwdUI.a(new w(honeyPayCheckPwdUI.nrZ.getText(), honeyPayCheckPwdUI.nrb.xgi, honeyPayCheckPwdUI.nrb.xgh, honeyPayCheckPwdUI.nrb.sign, honeyPayCheckPwdUI.nrb.kmr, honeyPayCheckPwdUI.nrb.wmb), false, false);
        }
        AppMethodBeat.o(41858);
    }
}
