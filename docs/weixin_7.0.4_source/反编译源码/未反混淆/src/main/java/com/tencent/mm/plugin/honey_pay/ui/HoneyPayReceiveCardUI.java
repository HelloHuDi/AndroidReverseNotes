package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.e.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;
import java.io.IOException;

public class HoneyPayReceiveCardUI extends HoneyPayBaseUI {
    private int gOW;
    private String nra;
    private ImageView nsP;
    private TextView nsQ;
    private TextView nsR;
    private TextView nsS;
    private TextView nsT;
    private TextView nsU;
    private TextView nsV;
    private TextView nsW;
    private TextView nsX;
    private TextView nsY;
    private LinearLayout nsZ;
    private CdnImageView nta;
    private g ntb = new g() {
        public final Object a(m mVar) {
            return null;
        }

        public final Object b(m mVar) {
            AppMethodBeat.i(41935);
            if (mVar.type == 1) {
                Object obj = mVar.data;
                if (obj != null && (obj instanceof Bundle) && ((Bundle) obj).getBoolean("click_help", false)) {
                    h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
            }
            AppMethodBeat.o(41935);
            return null;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public HoneyPayReceiveCardUI() {
        AppMethodBeat.i(41942);
        AppMethodBeat.o(41942);
    }

    static /* synthetic */ void a(HoneyPayReceiveCardUI honeyPayReceiveCardUI, bnn bnn) {
        AppMethodBeat.i(41950);
        honeyPayReceiveCardUI.a(bnn);
        AppMethodBeat.o(41950);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41943);
        this.nqT = R.color.s3;
        super.onCreate(bundle);
        j.a(this.ntb);
        nf(2613);
        nf(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        this.nra = getIntent().getStringExtra("key_card_no");
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        initView();
        if (this.gOW == 1) {
            bnn bnn = new bnn();
            try {
                bnn.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
                a(bnn);
                if (bnn.wps != null) {
                    setMMTitle(bnn.wps.kdf);
                }
                AppMethodBeat.o(41943);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                bGa();
                AppMethodBeat.o(41943);
                return;
            }
        }
        bGa();
        AppMethodBeat.o(41943);
    }

    public final void initView() {
        AppMethodBeat.i(41944);
        this.nsP = (ImageView) findViewById(R.id.cgo);
        this.nsQ = (TextView) findViewById(R.id.cgn);
        this.nsV = (TextView) findViewById(R.id.cgj);
        this.nsR = (TextView) findViewById(R.id.cgr);
        this.nsY = (TextView) findViewById(R.id.cgs);
        this.nsS = (TextView) findViewById(R.id.cgm);
        this.nsT = (TextView) findViewById(R.id.cgt);
        this.nsU = (TextView) findViewById(R.id.cgu);
        this.nsZ = (LinearLayout) findViewById(R.id.cgq);
        this.nsW = (TextView) findViewById(R.id.cgk);
        this.nsX = (TextView) findViewById(R.id.cgl);
        this.nta = (CdnImageView) findViewById(R.id.cgp);
        this.nsT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41936);
                HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this);
                AppMethodBeat.o(41936);
            }
        });
        AppMethodBeat.o(41944);
    }

    public void onDestroy() {
        AppMethodBeat.i(41945);
        super.onDestroy();
        j.b(this.ntb);
        ng(2613);
        ng(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        AppMethodBeat.o(41945);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(41946);
        if (mVar instanceof com.tencent.mm.plugin.honey_pay.a.m) {
            final com.tencent.mm.plugin.honey_pay.a.m mVar2 = (com.tencent.mm.plugin.honey_pay.a.m) mVar;
            mVar2.a(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(41937);
                    HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, mVar2.nqK);
                    AppMethodBeat.o(41937);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                }
            });
        } else if (mVar instanceof e) {
            final e eVar = (e) mVar;
            eVar.a(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(41940);
                    if (eVar.nqB.vYe != null) {
                        ab.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
                        c.a(HoneyPayReceiveCardUI.this, bundle, eVar.nqB.vYe, false);
                    } else {
                        HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
                        c.OC(HoneyPayReceiveCardUI.this.nra);
                        HoneyPayReceiveCardUI.this.finish();
                    }
                    h.pYm.k(875, 4, 1);
                    AppMethodBeat.o(41940);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(41939);
                    if (eVar.nqB.vYe != null) {
                        ab.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
                        c.a(HoneyPayReceiveCardUI.this, bundle, eVar.nqB.vYe, false);
                    }
                    h.pYm.k(875, 5, 1);
                    AppMethodBeat.o(41939);
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(41938);
                    h.pYm.k(875, 5, 1);
                    AppMethodBeat.o(41938);
                }
            });
        }
        AppMethodBeat.o(41946);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.a78;
    }

    private void a(final bnn bnn) {
        AppMethodBeat.i(41947);
        if (bnn.wps == null) {
            AppMethodBeat.o(41947);
            return;
        }
        atk atk = bnn.wps;
        this.nsU.setText(atk.wxs);
        this.nsW.setText(j.b(this.mController.ylL, atk.nSd, this.nsW.getTextSize()));
        Object bundle = new Bundle();
        bundle.putBoolean("click_help", true);
        this.nsX.setText(j.a(this.mController.ylL, atk.pMg, (int) this.nsX.getTextSize(), bundle));
        this.nsX.setClickable(true);
        this.nsX.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        if (bo.isNullOrNil(bnn.wNr)) {
            ab.d(this.TAG, "no help url");
            this.nsS.setVisibility(8);
        } else {
            o oVar = new o(new o.a() {
                public final void df(View view) {
                    AppMethodBeat.i(41941);
                    if (!bo.isNullOrNil(bnn.wNs)) {
                        com.tencent.mm.wallet_core.ui.e.n(HoneyPayReceiveCardUI.this.mController.ylL, bnn.wNs, false);
                    }
                    h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(41941);
                }
            });
            SpannableString spannableString = new SpannableString(bnn.wNr);
            spannableString.setSpan(oVar, 0, spannableString.length(), 18);
            this.nsS.setText(spannableString);
            this.nsS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
            this.nsS.setClickable(true);
        }
        this.nsR.setText(atk.kdf);
        b.a(this.nsP, atk.vAh, 0.06f, false);
        com.tencent.mm.wallet_core.ui.e.d(this.nsQ, atk.vAh);
        com.tencent.mm.wallet_core.ui.e.d(this.nsY, atk.vAh);
        if (atk.iAd == 1) {
            this.nsV.setText(R.string.cca);
        } else if (atk.iAd == 2) {
            this.nsV.setText(R.string.ccx);
        } else {
            this.nsV.setText(j.b((Context) this, com.tencent.mm.wallet_core.ui.e.eK(r.YB(), 16), this.nsV.getTextSize()));
        }
        if (bo.isNullOrNil(atk.kKZ)) {
            this.nta.setImageResource(c.bFX());
            AppMethodBeat.o(41947);
            return;
        }
        this.nta.eb(atk.kKZ, c.bFX());
        AppMethodBeat.o(41947);
    }

    private void bGa() {
        AppMethodBeat.i(41948);
        ab.i(this.TAG, "qry user detail");
        com.tencent.mm.ai.m mVar = new com.tencent.mm.plugin.honey_pay.a.m(this.nra);
        mVar.o(this);
        a(mVar, true, false);
        AppMethodBeat.o(41948);
    }

    static /* synthetic */ void b(HoneyPayReceiveCardUI honeyPayReceiveCardUI) {
        AppMethodBeat.i(41951);
        ab.i(honeyPayReceiveCardUI.TAG, "go to honey pay card detail");
        Intent intent = new Intent(honeyPayReceiveCardUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_card_no", honeyPayReceiveCardUI.nra);
        honeyPayReceiveCardUI.startActivity(intent);
        AppMethodBeat.o(41951);
    }
}
