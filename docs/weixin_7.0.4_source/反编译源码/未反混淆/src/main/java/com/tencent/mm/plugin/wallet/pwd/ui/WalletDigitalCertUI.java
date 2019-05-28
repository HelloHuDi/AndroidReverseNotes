package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.d;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI extends WalletBaseUI {
    private Button gzI;
    private ImageView iyo;
    private TextView pNx;
    private Button tro;
    private LinearLayout trp;
    private TextView trq;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46256);
        super.onCreate(bundle);
        nf(1654);
        nf(1568);
        nf(1669);
        initView();
        h.pYm.e(13731, Integer.valueOf(1));
        AppMethodBeat.o(46256);
    }

    public final void initView() {
        AppMethodBeat.i(46257);
        setMMTitle((int) R.string.fmc);
        this.iyo = (ImageView) findViewById(R.id.f_n);
        this.pNx = (TextView) findViewById(R.id.f_o);
        this.tro = (Button) findViewById(R.id.f_s);
        this.gzI = (Button) findViewById(R.id.f_t);
        this.trp = (LinearLayout) findViewById(R.id.f_v);
        this.trq = (TextView) findViewById(R.id.f_u);
        this.tro.setOnClickListener(new d() {
            public final void onClick(View view) {
                AppMethodBeat.i(46251);
                Intent intent = new Intent();
                intent.setClass(WalletDigitalCertUI.this, WalletIdCardCheckUI.class);
                WalletDigitalCertUI.this.startActivityForResult(intent, 1);
                AppMethodBeat.o(46251);
            }
        });
        this.gzI.setOnClickListener(new d() {
            public final void onClick(View view) {
                AppMethodBeat.i(46252);
                ab.dNZ();
                WalletDigitalCertUI.this.a(new m(ab.dNY()), true, true);
                h.pYm.e(13731, Integer.valueOf(10));
                AppMethodBeat.o(46252);
            }
        });
        setBackBtn(new t() {
            public final void Kp() {
                AppMethodBeat.i(46253);
                WalletDigitalCertUI.this.finish();
                AppMethodBeat.o(46253);
            }
        });
        cOA();
        AppMethodBeat.o(46257);
    }

    private void cOA() {
        AppMethodBeat.i(46258);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.trp.removeAllViews();
        if (ab.dNZ().dOa()) {
            this.tro.setVisibility(8);
            this.gzI.setVisibility(0);
            this.pNx.setText(R.string.fmv);
            this.iyo.setImageResource(R.drawable.bl5);
        } else {
            this.tro.setVisibility(0);
            this.gzI.setVisibility(8);
            this.pNx.setText(R.string.fmf);
            this.iyo.setImageResource(R.drawable.bl6);
        }
        Vector vector = ab.dNZ().Agf;
        if (vector.size() == 0) {
            this.trp.setVisibility(8);
            this.trq.setVisibility(8);
            AppMethodBeat.o(46258);
            return;
        }
        this.trp.setVisibility(0);
        this.trq.setVisibility(0);
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            aa aaVar = (aa) it.next();
            if (aaVar.AfZ <= 0) {
                View inflate = View.inflate(this, R.layout.b3p, null);
                TextView textView = (TextView) inflate.findViewById(R.id.f9o);
                TextView textView2 = (TextView) inflate.findViewById(R.id.f9p);
                ((TextView) inflate.findViewById(R.id.f9n)).setText(aaVar.xoz);
                textView.setText(aaVar.AfY);
                textView2.setTag(aaVar);
                textView2.setOnClickListener(new d() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(46255);
                        if (view.getTag() instanceof aa) {
                            final aa aaVar = (aa) view.getTag();
                            com.tencent.mm.ui.base.h.a(WalletDigitalCertUI.this, WalletDigitalCertUI.this.getString(R.string.fme, new Object[]{aaVar.xoz}), "", WalletDigitalCertUI.this.getString(R.string.p4), WalletDigitalCertUI.this.getString(R.string.or), true, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46254);
                                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletDigitalCertUI", "del crt %s", aaVar.xfz);
                                    WalletDigitalCertUI.this.a(new m(aaVar.xfz), true, true);
                                    bj bjVar = new bj();
                                    bjVar.cVT = 2;
                                    bjVar.dcm = 1;
                                    bjVar.ajK();
                                    AppMethodBeat.o(46254);
                                }
                            }, null);
                        }
                        AppMethodBeat.o(46255);
                    }
                });
                this.trp.addView(inflate);
            }
        }
        if (this.trp.getChildCount() == 0) {
            this.trq.setVisibility(8);
            AppMethodBeat.o(46258);
            return;
        }
        this.trq.setVisibility(0);
        AppMethodBeat.o(46258);
    }

    public void onResume() {
        AppMethodBeat.i(46259);
        super.onResume();
        AppMethodBeat.o(46259);
    }

    public void onPause() {
        AppMethodBeat.i(46260);
        super.onPause();
        AppMethodBeat.o(46260);
    }

    public void onDestroy() {
        AppMethodBeat.i(46261);
        super.onDestroy();
        ng(1654);
        ng(1568);
        ng(1669);
        AppMethodBeat.o(46261);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(46262);
        if (!(mVar instanceof k)) {
            if (mVar instanceof m) {
                if (i2 == 0) {
                    bj bjVar = new bj();
                    bjVar.cVT = 2;
                    bjVar.dcm = 2;
                    bjVar.ajK();
                    h.pYm.e(13731, Integer.valueOf(11));
                    ab.dNZ().atp(((m) mVar).Afw);
                } else {
                    h.pYm.e(13731, Integer.valueOf(12));
                }
            }
            AppMethodBeat.o(46262);
            return false;
        }
        cOA();
        AppMethodBeat.o(46262);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46263);
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            String string;
            String string2;
            boolean bxe = ((l) g.K(l.class)).bxe();
            SharedPreferences doB = ah.doB();
            if (doB != null) {
                string = doB.getString("cpu_id", null);
                string2 = doB.getString("uid", null);
            } else {
                string2 = null;
                string = null;
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(bxe));
            a(new k(bxe, string, string2), false, false);
        }
        AppMethodBeat.o(46263);
    }

    public final int getLayoutId() {
        return R.layout.b43;
    }
}
