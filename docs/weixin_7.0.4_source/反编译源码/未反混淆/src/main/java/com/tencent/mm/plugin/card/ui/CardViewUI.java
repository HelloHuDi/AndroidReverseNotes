package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public class CardViewUI extends CardBaseUI {
    private int auo = 1;
    private int emC;
    private String fhu = "";
    private LinkedList<oj> kip = new LinkedList();
    private int kjL;
    private String knY;
    private View knZ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardViewUI() {
        AppMethodBeat.i(88671);
        AppMethodBeat.o(88671);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88672);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.CardViewUI", "onCreate intent is null");
            finish();
            AppMethodBeat.o(88672);
            return;
        }
        this.emC = intent.getIntExtra("key_previous_scene", 7);
        this.kjL = intent.getIntExtra("key_from_appbrand_type", 0);
        this.auo = intent.getIntExtra("view_type", 0);
        this.knY = intent.getStringExtra("user_name");
        String stringExtra = intent.getStringExtra("card_list");
        this.fhu = getIntent().getStringExtra("key_template_id");
        if (this.auo == 0) {
            if (TextUtils.isEmpty(stringExtra)) {
                ab.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
                finish();
                AppMethodBeat.o(88672);
                return;
            }
            LinkedList bR = k.bR(stringExtra, this.emC);
            if (bR != null && bR.size() > 0) {
                this.kip.clear();
                this.kip.addAll(bR);
            }
        }
        initView();
        AppMethodBeat.o(88672);
    }

    public void onDestroy() {
        AppMethodBeat.i(88673);
        g.RO().eJo.b(699, (f) this);
        super.onDestroy();
        AppMethodBeat.o(88673);
    }

    public void onSwipeBack() {
        AppMethodBeat.i(88674);
        super.onSwipeBack();
        if (this.emC == 26) {
            overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(88674);
    }

    public final void aZp() {
        int i;
        AppMethodBeat.i(88675);
        if (this.auo == 0) {
            setMMTitle((int) R.string.aig);
        } else if (this.auo == 1) {
            setMMTitle((int) R.string.aeo);
        }
        g.RO().eJo.a(699, (f) this);
        if (this.auo == 0) {
            fE(true);
            cdc cdc = new cdc();
            cdc.xcM = this.fhu;
            ab.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", this.fhu);
            g.RO().eJo.a(new t(this.kip, cdc, this.emC), 0);
            i = R.string.acd;
        } else if (this.auo == 1) {
            this.knZ = View.inflate(this, R.layout.je, null);
            if (this.kap != null) {
                this.kap.addView(this.knZ);
            }
            i = R.string.ahr;
        } else {
            i = R.string.acd;
        }
        findViewById(R.id.agd).setVisibility(8);
        ((TextView) findViewById(R.id.a_c)).setText(i);
        AppMethodBeat.o(88675);
    }

    public final a aZq() {
        return a.CAN_GIFT_TYPE;
    }

    public final BaseAdapter Kw() {
        AppMethodBeat.i(88676);
        if (this.auo == 0) {
            g gVar = new g(getApplicationContext());
            AppMethodBeat.o(88676);
            return gVar;
        }
        BaseAdapter Kw = super.Kw();
        AppMethodBeat.o(88676);
        return Kw;
    }

    public final boolean aZs() {
        AppMethodBeat.i(88677);
        if (this.auo == 1) {
            AppMethodBeat.o(88677);
            return false;
        }
        boolean aZs = super.aZs();
        AppMethodBeat.o(88677);
        return aZs;
    }

    public final void b(b bVar, int i) {
        AppMethodBeat.i(88678);
        if (this.auo == 1) {
            a((CardInfo) bVar);
            AppMethodBeat.o(88678);
            return;
        }
        super.b(bVar, i);
        AppMethodBeat.o(88678);
    }

    public final void a(CardInfo cardInfo) {
        AppMethodBeat.i(88679);
        if (this.auo == 1) {
            this.kau = cardInfo;
            l(this.knY, 1, true);
            AppMethodBeat.o(88679);
            return;
        }
        super.a(cardInfo);
        if (this.kau != null) {
            h.pYm.e(11582, "OperGift", Integer.valueOf(4), Integer.valueOf(this.kau.aZV().iAd), this.kau.field_card_tp_id, this.kau.field_card_id, this.knY);
        }
        AppMethodBeat.o(88679);
    }

    public final void a(b bVar, int i) {
        AppMethodBeat.i(88680);
        if (this.auo == 0) {
            am.bbb().kau = (CardInfo) bVar;
            Intent intent = new Intent(this, CardDetailUI.class);
            intent.putExtra("key_card_id", ((CardInfo) bVar).field_card_id);
            intent.putExtra("key_from_scene", 51);
            intent.putExtra("key_from_appbrand_type", this.kjL);
            startActivity(intent);
            AppMethodBeat.o(88680);
            return;
        }
        super.a(bVar, i);
        AppMethodBeat.o(88680);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(88681);
        if (mVar instanceof t) {
            fE(false);
            if (i == 0 && i2 == 0) {
                LinkedList linkedList = ((t) mVar).kdZ;
                if (linkedList != null && linkedList.size() > 0) {
                    if (this.kan instanceof g) {
                        g gVar = (g) this.kan;
                        if (linkedList != null) {
                            gVar.khh.clear();
                            gVar.khh.addAll(linkedList);
                            gVar.kmd.clear();
                            while (i3 < linkedList.size()) {
                                gVar.kmd.add(Boolean.TRUE);
                                i3++;
                            }
                        }
                    }
                    this.kan.notifyDataSetChanged();
                }
                AppMethodBeat.o(88681);
                return;
            }
            d.b(this, str, i2);
            AppMethodBeat.o(88681);
            return;
        }
        super.onSceneEnd(i, i2, str, mVar);
        AppMethodBeat.o(88681);
    }
}
