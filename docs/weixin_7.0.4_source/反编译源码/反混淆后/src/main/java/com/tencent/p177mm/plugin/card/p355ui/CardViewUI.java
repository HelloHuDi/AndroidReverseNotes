package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.CardBaseUI;
import com.tencent.p177mm.plugin.card.model.C11292t;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45775k;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44152oj;
import com.tencent.p177mm.protocal.protobuf.cdc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.ui.CardViewUI */
public class CardViewUI extends CardBaseUI {
    private int auo = 1;
    private int emC;
    private String fhu = "";
    private LinkedList<C44152oj> kip = new LinkedList();
    private int kjL;
    private String knY;
    private View knZ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardViewUI() {
        AppMethodBeat.m2504i(88671);
        AppMethodBeat.m2505o(88671);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88672);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.CardViewUI", "onCreate intent is null");
            finish();
            AppMethodBeat.m2505o(88672);
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
                C4990ab.m7412e("MicroMsg.CardViewUI", "oncreate card_list is empty");
                finish();
                AppMethodBeat.m2505o(88672);
                return;
            }
            LinkedList bR = C45775k.m84636bR(stringExtra, this.emC);
            if (bR != null && bR.size() > 0) {
                this.kip.clear();
                this.kip.addAll(bR);
            }
        }
        initView();
        AppMethodBeat.m2505o(88672);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88673);
        C1720g.m3535RO().eJo.mo14546b(699, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(88673);
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(88674);
        super.onSwipeBack();
        if (this.emC == 26) {
            overridePendingTransition(0, 0);
        }
        AppMethodBeat.m2505o(88674);
    }

    public final void aZp() {
        int i;
        AppMethodBeat.m2504i(88675);
        if (this.auo == 0) {
            setMMTitle((int) C25738R.string.aig);
        } else if (this.auo == 1) {
            setMMTitle((int) C25738R.string.aeo);
        }
        C1720g.m3535RO().eJo.mo14539a(699, (C1202f) this);
        if (this.auo == 0) {
            mo54298fE(true);
            cdc cdc = new cdc();
            cdc.xcM = this.fhu;
            C4990ab.m7417i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", this.fhu);
            C1720g.m3535RO().eJo.mo14541a(new C11292t(this.kip, cdc, this.emC), 0);
            i = C25738R.string.acd;
        } else if (this.auo == 1) {
            this.knZ = View.inflate(this, 2130968950, null);
            if (this.kap != null) {
                this.kap.addView(this.knZ);
            }
            i = C25738R.string.ahr;
        } else {
            i = C25738R.string.acd;
        }
        findViewById(2131822187).setVisibility(8);
        ((TextView) findViewById(2131821927)).setText(i);
        AppMethodBeat.m2505o(88675);
    }

    public final C11290a aZq() {
        return C11290a.CAN_GIFT_TYPE;
    }

    /* renamed from: Kw */
    public final BaseAdapter mo35412Kw() {
        AppMethodBeat.m2504i(88676);
        if (this.auo == 0) {
            C38771g c38771g = new C38771g(getApplicationContext());
            AppMethodBeat.m2505o(88676);
            return c38771g;
        }
        BaseAdapter Kw = super.mo35412Kw();
        AppMethodBeat.m2505o(88676);
        return Kw;
    }

    public final boolean aZs() {
        AppMethodBeat.m2504i(88677);
        if (this.auo == 1) {
            AppMethodBeat.m2505o(88677);
            return false;
        }
        boolean aZs = super.aZs();
        AppMethodBeat.m2505o(88677);
        return aZs;
    }

    /* renamed from: b */
    public final void mo45440b(C42837b c42837b, int i) {
        AppMethodBeat.m2504i(88678);
        if (this.auo == 1) {
            mo54294a((CardInfo) c42837b);
            AppMethodBeat.m2505o(88678);
            return;
        }
        super.mo45440b(c42837b, i);
        AppMethodBeat.m2505o(88678);
    }

    /* renamed from: a */
    public final void mo54294a(CardInfo cardInfo) {
        AppMethodBeat.m2504i(88679);
        if (this.auo == 1) {
            this.kau = cardInfo;
            mo54299l(this.knY, 1, true);
            AppMethodBeat.m2505o(88679);
            return;
        }
        super.mo54294a(cardInfo);
        if (this.kau != null) {
            C7060h.pYm.mo8381e(11582, "OperGift", Integer.valueOf(4), Integer.valueOf(this.kau.aZV().iAd), this.kau.field_card_tp_id, this.kau.field_card_id, this.knY);
        }
        AppMethodBeat.m2505o(88679);
    }

    /* renamed from: a */
    public final void mo45434a(C42837b c42837b, int i) {
        AppMethodBeat.m2504i(88680);
        if (this.auo == 0) {
            C42852am.bbb().kau = (CardInfo) c42837b;
            Intent intent = new Intent(this, CardDetailUI.class);
            intent.putExtra("key_card_id", ((CardInfo) c42837b).field_card_id);
            intent.putExtra("key_from_scene", 51);
            intent.putExtra("key_from_appbrand_type", this.kjL);
            startActivity(intent);
            AppMethodBeat.m2505o(88680);
            return;
        }
        super.mo45434a(c42837b, i);
        AppMethodBeat.m2505o(88680);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(88681);
        if (c1207m instanceof C11292t) {
            mo54298fE(false);
            if (i == 0 && i2 == 0) {
                LinkedList linkedList = ((C11292t) c1207m).kdZ;
                if (linkedList != null && linkedList.size() > 0) {
                    if (this.kan instanceof C38771g) {
                        C38771g c38771g = (C38771g) this.kan;
                        if (linkedList != null) {
                            c38771g.khh.clear();
                            c38771g.khh.addAll(linkedList);
                            c38771g.kmd.clear();
                            while (i3 < linkedList.size()) {
                                c38771g.kmd.add(Boolean.TRUE);
                                i3++;
                            }
                        }
                    }
                    this.kan.notifyDataSetChanged();
                }
                AppMethodBeat.m2505o(88681);
                return;
            }
            C42840d.m76037b(this, str, i2);
            AppMethodBeat.m2505o(88681);
            return;
        }
        super.onSceneEnd(i, i2, str, c1207m);
        AppMethodBeat.m2505o(88681);
    }
}
