package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bvw;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.x.c;
import java.io.IOException;
import java.util.List;

public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    int fromScene = 0;
    private View klR;
    private TextView klS;
    private f klT;
    private TextView klU;
    private TextView klV;
    private ImageView klW;
    private LinearLayout klX;
    int klY = -1;
    private long mStartTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88523);
        super.onCreate(bundle);
        ab.i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        initView();
        g.RO().eJo.a(984, (com.tencent.mm.ai.f) this);
        am.baV();
        b.sO(1);
        int i = am.bba().kbN;
        if (c.PK().bX(262152, 266256) || i > 0) {
            h.pYm.e(11324, "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "");
            AppMethodBeat.o(88523);
            return;
        }
        h.pYm.e(11324, "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "");
        AppMethodBeat.o(88523);
    }

    public void onDestroy() {
        AppMethodBeat.i(88524);
        g.RO().eJo.b(984, (com.tencent.mm.ai.f) this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        h.pYm.e(13219, "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis));
        super.onDestroy();
        AppMethodBeat.o(88524);
    }

    public final void initView() {
        AppMethodBeat.i(88525);
        if (getIntent() != null) {
            this.klY = getIntent().getIntExtra("key_card_type", -1);
        }
        super.initView();
        AppMethodBeat.o(88525);
    }

    public final void aZp() {
        AppMethodBeat.i(88526);
        if (1 == this.klY) {
            setMMTitle((int) R.string.afu);
        } else if (3 == this.klY) {
            setMMTitle((int) R.string.aib);
        } else {
            setMMTitle((int) R.string.ag4);
        }
        this.klU = (TextView) findViewById(R.id.a_c);
        this.klV = (TextView) findViewById(R.id.agf);
        this.klW = (ImageView) findViewById(R.id.agd);
        this.klR = findViewById(R.id.agg);
        this.klS = (TextView) findViewById(R.id.agi);
        this.klX = (LinearLayout) findViewById(R.id.age);
        this.klR.setVisibility(8);
        this.klV.setVisibility(0);
        this.klU.setVisibility(0);
        this.klW.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.klX.getLayoutParams();
        layoutParams.topMargin = BackwardSupportUtil.b.b((Context) this, 100.0f);
        this.klX.setLayoutParams(layoutParams);
        if (1 == this.klY) {
            this.klV.setText(getString(R.string.afi));
            this.klU.setText(getString(R.string.afh));
        } else if (3 == this.klY) {
            this.klV.setText(getString(R.string.afo));
            this.klU.setText(getString(R.string.afn));
        } else {
            this.klV.setText(getString(R.string.ago));
            this.klU.setText(getString(R.string.ah3));
        }
        if (this.klY == 3) {
            this.kam.setEmptyView(null);
            this.kao.setVisibility(8);
        }
        this.klS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(88521);
                if (!TextUtils.isEmpty(CardIndexUI.this.klT.kdl)) {
                    com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.this.klT.kdl, 0);
                }
                AppMethodBeat.o(88521);
            }
        });
        if (this.klY == 3 && ((Boolean) g.RP().Ry().get(a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            ab.i("MicroMsg.CardIndexUI", "has load new entrance");
            String str = (String) g.RP().Ry().get(a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, null);
            if (!bo.isNullOrNil(str)) {
                try {
                    bvx bvx = new bvx();
                    bvx.parseFrom(str.getBytes("ISO-8859-1"));
                    bg(bvx.wWG);
                    AppMethodBeat.o(88526);
                    return;
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.CardIndexUI", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(88526);
    }

    private void bdi() {
        AppMethodBeat.i(88527);
        if (this.kap.getChildCount() == 0 && this.kan.getCount() == 0) {
            ab.i("MicroMsg.CardIndexUI", "show empty view");
            this.kao.setVisibility(0);
            this.kam.setVisibility(8);
            AppMethodBeat.o(88527);
            return;
        }
        ab.i("MicroMsg.CardIndexUI", "hide empty view");
        this.kao.setVisibility(8);
        this.kam.setVisibility(0);
        AppMethodBeat.o(88527);
    }

    private void bg(List<bvw> list) {
        AppMethodBeat.i(88528);
        if (!(list == null || list.isEmpty())) {
            for (bvw bvw : list) {
                if (bvw.vTs == 1) {
                    ab.i("MicroMsg.CardIndexUI", "should update new invoice");
                    bh(bvw.wWF);
                }
            }
        }
        bdi();
        AppMethodBeat.o(88528);
    }

    private void bh(List<oc> list) {
        AppMethodBeat.i(88529);
        this.kap.removeAllViews();
        this.kap.setPadding(0, 0, 0, 0);
        if (!(list == null || list.isEmpty())) {
            int i = 0;
            for (final oc ocVar : list) {
                View inflate = View.inflate(this.mController.ylL, R.layout.ja, null);
                TextView textView = (TextView) inflate.findViewById(R.id.agt);
                TextView textView2 = (TextView) inflate.findViewById(R.id.agu);
                ((CdnImageView) inflate.findViewById(R.id.ags)).setUrl(ocVar.vTF);
                textView.setText(ocVar.vTE);
                textView2.setText(ocVar.vTG);
                if (ocVar.vTH > 0) {
                    inflate.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(88522);
                            ab.i("MicroMsg.CardIndexUI", "click header view: %s", Integer.valueOf(ocVar.vTH));
                            if (ocVar.vTH == 1) {
                                com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, ocVar.vTI, 0);
                                AppMethodBeat.o(88522);
                                return;
                            }
                            if (ocVar.vTH == 2) {
                                se seVar = new se();
                                seVar.cOf.userName = ocVar.vTJ.tzW;
                                seVar.cOf.cOh = bo.bc(ocVar.vTJ.ttg, "");
                                seVar.cOf.scene = 1028;
                                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                            }
                            AppMethodBeat.o(88522);
                        }
                    });
                }
                this.kap.addView(inflate);
                if (i == 0) {
                    this.kap.setPadding(0, com.tencent.mm.bz.a.fromDPToPix(this, 13), 0, 0);
                } else {
                    LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 6);
                        inflate.setLayoutParams(layoutParams);
                    }
                }
                i++;
            }
        }
        AppMethodBeat.o(88529);
    }

    public void onResume() {
        AppMethodBeat.i(88530);
        super.onResume();
        AppMethodBeat.o(88530);
    }

    public void onStop() {
        AppMethodBeat.i(88531);
        super.onStop();
        AppMethodBeat.o(88531);
    }

    public final n.a aZq() {
        AppMethodBeat.i(88532);
        n.a aVar;
        if (1 == this.klY) {
            aVar = n.a.MEMBER_CARD_TYPE;
            AppMethodBeat.o(88532);
            return aVar;
        } else if (3 != this.klY) {
            aVar = n.a.NORMAL_TYPE;
            AppMethodBeat.o(88532);
            return aVar;
        } else if (((Boolean) g.RP().Ry().get(a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            aVar = n.a.GENERAL_WITHOUT_INVOICE_TYPE;
            AppMethodBeat.o(88532);
            return aVar;
        } else {
            aVar = n.a.GENERAL_TYPE;
            AppMethodBeat.o(88532);
            return aVar;
        }
    }

    public final BaseAdapter Kw() {
        AppMethodBeat.i(88533);
        if (3 == this.klY) {
            k kVar = new k(this, aZq());
            AppMethodBeat.o(88533);
            return kVar;
        }
        BaseAdapter cVar = new c(this, aZq());
        AppMethodBeat.o(88533);
        return cVar;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(88534);
        super.onSceneEnd(i, i2, str, mVar);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof x) {
                this.klT = i.Hl((String) g.RP().Ry().get(282885, (Object) ""));
                if (this.klT == null) {
                    this.klT = new f();
                }
                if (!(this.klT == null || TextUtils.isEmpty(this.klT.kdj))) {
                    this.klU.setText(this.klT.kdj);
                }
                if (this.klT == null || !this.klT.kdm) {
                    this.klR.setVisibility(8);
                    AppMethodBeat.o(88534);
                    return;
                }
                this.klS.setText(this.klT.kdk);
                if (TextUtils.isEmpty(this.klT.kdk) || TextUtils.isEmpty(this.klT.kdl)) {
                    this.klR.setVisibility(8);
                    AppMethodBeat.o(88534);
                    return;
                }
                this.klR.setVisibility(0);
                AppMethodBeat.o(88534);
                return;
            } else if (mVar instanceof ad) {
                ad adVar = (ad) mVar;
                if (adVar.kei && (this.kan instanceof c)) {
                    ((c) this.kan).pN(false);
                    ((c) this.kan).pN(true);
                    ((c) this.kan).KC();
                }
                if (((Boolean) g.RP().Ry().get(a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue() && adVar.kek != null) {
                    bg(adVar.kek.wWG);
                    if (this.kan instanceof c) {
                        ((c) this.kan).pN(false);
                        ((c) this.kan).pN(true);
                        ((c) this.kan).KC();
                    }
                }
            }
        }
        AppMethodBeat.o(88534);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(88535);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(88535);
    }
}
