package com.tencent.p177mm.plugin.card.p355ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.plugin.card.base.CardBaseUI;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.C45783ad;
import com.tencent.p177mm.plugin.card.model.C45785f;
import com.tencent.p177mm.plugin.card.model.C45788x;
import com.tencent.p177mm.plugin.card.p352b.C27567b;
import com.tencent.p177mm.plugin.card.p931d.C27576i;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C23421oc;
import com.tencent.p177mm.protocal.protobuf.bvw;
import com.tencent.p177mm.protocal.protobuf.bvx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.IOException;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.ui.CardIndexUI */
public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    int fromScene = 0;
    private View klR;
    private TextView klS;
    private C45785f klT;
    private TextView klU;
    private TextView klV;
    private ImageView klW;
    private LinearLayout klX;
    int klY = -1;
    private long mStartTime = 0;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardIndexUI$1 */
    class C201651 implements OnClickListener {
        C201651() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88521);
            if (!TextUtils.isEmpty(CardIndexUI.this.klT.kdl)) {
                C45774b.m84626a(CardIndexUI.this, CardIndexUI.this.klT.kdl, 0);
            }
            AppMethodBeat.m2505o(88521);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88523);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        initView();
        C1720g.m3535RO().eJo.mo14539a(984, (C1202f) this);
        C42852am.baV();
        C27567b.m43779sO(1);
        int i = C42852am.bba().kbN;
        if (C16112c.m24429PK().mo28551bX(262152, 266256) || i > 0) {
            C7060h.pYm.mo8381e(11324, "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "");
            AppMethodBeat.m2505o(88523);
            return;
        }
        C7060h.pYm.mo8381e(11324, "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "");
        AppMethodBeat.m2505o(88523);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88524);
        C1720g.m3535RO().eJo.mo14546b(984, (C1202f) this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        C7060h.pYm.mo8381e(13219, "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis));
        super.onDestroy();
        AppMethodBeat.m2505o(88524);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88525);
        if (getIntent() != null) {
            this.klY = getIntent().getIntExtra("key_card_type", -1);
        }
        super.initView();
        AppMethodBeat.m2505o(88525);
    }

    public final void aZp() {
        AppMethodBeat.m2504i(88526);
        if (1 == this.klY) {
            setMMTitle((int) C25738R.string.afu);
        } else if (3 == this.klY) {
            setMMTitle((int) C25738R.string.aib);
        } else {
            setMMTitle((int) C25738R.string.ag4);
        }
        this.klU = (TextView) findViewById(2131821927);
        this.klV = (TextView) findViewById(2131822189);
        this.klW = (ImageView) findViewById(2131822187);
        this.klR = findViewById(2131822190);
        this.klS = (TextView) findViewById(2131822192);
        this.klX = (LinearLayout) findViewById(2131822188);
        this.klR.setVisibility(8);
        this.klV.setVisibility(0);
        this.klU.setVisibility(0);
        this.klW.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.klX.getLayoutParams();
        layoutParams.topMargin = C4977b.m7371b((Context) this, 100.0f);
        this.klX.setLayoutParams(layoutParams);
        if (1 == this.klY) {
            this.klV.setText(getString(C25738R.string.afi));
            this.klU.setText(getString(C25738R.string.afh));
        } else if (3 == this.klY) {
            this.klV.setText(getString(C25738R.string.afo));
            this.klU.setText(getString(C25738R.string.afn));
        } else {
            this.klV.setText(getString(C25738R.string.ago));
            this.klU.setText(getString(C25738R.string.ah3));
        }
        if (this.klY == 3) {
            this.kam.setEmptyView(null);
            this.kao.setVisibility(8);
        }
        this.klS.setOnClickListener(new C201651());
        if (this.klY == 3 && ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            C4990ab.m7416i("MicroMsg.CardIndexUI", "has load new entrance");
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, null);
            if (!C5046bo.isNullOrNil(str)) {
                try {
                    bvx bvx = new bvx();
                    bvx.parseFrom(str.getBytes("ISO-8859-1"));
                    m31202bg(bvx.wWG);
                    AppMethodBeat.m2505o(88526);
                    return;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.CardIndexUI", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(88526);
    }

    private void bdi() {
        AppMethodBeat.m2504i(88527);
        if (this.kap.getChildCount() == 0 && this.kan.getCount() == 0) {
            C4990ab.m7416i("MicroMsg.CardIndexUI", "show empty view");
            this.kao.setVisibility(0);
            this.kam.setVisibility(8);
            AppMethodBeat.m2505o(88527);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardIndexUI", "hide empty view");
        this.kao.setVisibility(8);
        this.kam.setVisibility(0);
        AppMethodBeat.m2505o(88527);
    }

    /* renamed from: bg */
    private void m31202bg(List<bvw> list) {
        AppMethodBeat.m2504i(88528);
        if (!(list == null || list.isEmpty())) {
            for (bvw bvw : list) {
                if (bvw.vTs == 1) {
                    C4990ab.m7416i("MicroMsg.CardIndexUI", "should update new invoice");
                    m31203bh(bvw.wWF);
                }
            }
        }
        bdi();
        AppMethodBeat.m2505o(88528);
    }

    /* renamed from: bh */
    private void m31203bh(List<C23421oc> list) {
        AppMethodBeat.m2504i(88529);
        this.kap.removeAllViews();
        this.kap.setPadding(0, 0, 0, 0);
        if (!(list == null || list.isEmpty())) {
            int i = 0;
            for (final C23421oc c23421oc : list) {
                View inflate = View.inflate(this.mController.ylL, 2130968946, null);
                TextView textView = (TextView) inflate.findViewById(2131822203);
                TextView textView2 = (TextView) inflate.findViewById(2131822204);
                ((CdnImageView) inflate.findViewById(2131822202)).setUrl(c23421oc.vTF);
                textView.setText(c23421oc.vTE);
                textView2.setText(c23421oc.vTG);
                if (c23421oc.vTH > 0) {
                    inflate.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(88522);
                            C4990ab.m7417i("MicroMsg.CardIndexUI", "click header view: %s", Integer.valueOf(c23421oc.vTH));
                            if (c23421oc.vTH == 1) {
                                C45774b.m84626a(CardIndexUI.this, c23421oc.vTI, 0);
                                AppMethodBeat.m2505o(88522);
                                return;
                            }
                            if (c23421oc.vTH == 2) {
                                C32628se c32628se = new C32628se();
                                c32628se.cOf.userName = c23421oc.vTJ.tzW;
                                c32628se.cOf.cOh = C5046bo.m7532bc(c23421oc.vTJ.ttg, "");
                                c32628se.cOf.scene = 1028;
                                C4879a.xxA.mo10055m(c32628se);
                            }
                            AppMethodBeat.m2505o(88522);
                        }
                    });
                }
                this.kap.addView(inflate);
                if (i == 0) {
                    this.kap.setPadding(0, C1338a.fromDPToPix(this, 13), 0, 0);
                } else {
                    LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.topMargin = C1338a.fromDPToPix(this, 6);
                        inflate.setLayoutParams(layoutParams);
                    }
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(88529);
    }

    public void onResume() {
        AppMethodBeat.m2504i(88530);
        super.onResume();
        AppMethodBeat.m2505o(88530);
    }

    public void onStop() {
        AppMethodBeat.m2504i(88531);
        super.onStop();
        AppMethodBeat.m2505o(88531);
    }

    public final C11290a aZq() {
        AppMethodBeat.m2504i(88532);
        C11290a c11290a;
        if (1 == this.klY) {
            c11290a = C11290a.MEMBER_CARD_TYPE;
            AppMethodBeat.m2505o(88532);
            return c11290a;
        } else if (3 != this.klY) {
            c11290a = C11290a.NORMAL_TYPE;
            AppMethodBeat.m2505o(88532);
            return c11290a;
        } else if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            c11290a = C11290a.GENERAL_WITHOUT_INVOICE_TYPE;
            AppMethodBeat.m2505o(88532);
            return c11290a;
        } else {
            c11290a = C11290a.GENERAL_TYPE;
            AppMethodBeat.m2505o(88532);
            return c11290a;
        }
    }

    /* renamed from: Kw */
    public final BaseAdapter mo35412Kw() {
        AppMethodBeat.m2504i(88533);
        if (3 == this.klY) {
            C2781k c2781k = new C2781k(this, aZq());
            AppMethodBeat.m2505o(88533);
            return c2781k;
        }
        BaseAdapter c11334c = new C11334c(this, aZq());
        AppMethodBeat.m2505o(88533);
        return c11334c;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88534);
        super.onSceneEnd(i, i2, str, c1207m);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C45788x) {
                this.klT = C27576i.m43809Hl((String) C1720g.m3536RP().mo5239Ry().get(282885, (Object) ""));
                if (this.klT == null) {
                    this.klT = new C45785f();
                }
                if (!(this.klT == null || TextUtils.isEmpty(this.klT.kdj))) {
                    this.klU.setText(this.klT.kdj);
                }
                if (this.klT == null || !this.klT.kdm) {
                    this.klR.setVisibility(8);
                    AppMethodBeat.m2505o(88534);
                    return;
                }
                this.klS.setText(this.klT.kdk);
                if (TextUtils.isEmpty(this.klT.kdk) || TextUtils.isEmpty(this.klT.kdl)) {
                    this.klR.setVisibility(8);
                    AppMethodBeat.m2505o(88534);
                    return;
                }
                this.klR.setVisibility(0);
                AppMethodBeat.m2505o(88534);
                return;
            } else if (c1207m instanceof C45783ad) {
                C45783ad c45783ad = (C45783ad) c1207m;
                if (c45783ad.kei && (this.kan instanceof C11334c)) {
                    ((C11334c) this.kan).mo74996pN(false);
                    ((C11334c) this.kan).mo74996pN(true);
                    ((C11334c) this.kan).mo6869KC();
                }
                if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue() && c45783ad.kek != null) {
                    m31202bg(c45783ad.kek.wWG);
                    if (this.kan instanceof C11334c) {
                        ((C11334c) this.kan).mo74996pN(false);
                        ((C11334c) this.kan).mo74996pN(true);
                        ((C11334c) this.kan).mo6869KC();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(88534);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(88535);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(88535);
    }
}
