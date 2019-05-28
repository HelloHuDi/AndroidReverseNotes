package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.h;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardAcceptCardListUI extends MMActivity implements f, a {
    private View En;
    int cME = 8;
    private p ejZ = null;
    private String fhu = "";
    protected ListView kam = null;
    protected RelativeLayout kao = null;
    private boolean kcf = false;
    private String ked = "";
    private int kee;
    private String kef;
    private int keg;
    private String keh;
    private Button kgI;
    public int kgP = 0;
    private String kgQ = "";
    private String kgR = "";
    public ArrayList<String> kgS = new ArrayList();
    public ArrayList<String> kgT = new ArrayList();
    HashMap<String, Integer> kic = new HashMap();
    private View kii;
    private View kij;
    protected a kik = null;
    private View kil;
    private View kim;
    private TextView kin;
    private Button kio;
    LinkedList<nx> kip = new LinkedList();
    int kiq = 7;
    String kir = "";
    String kis = "";
    private String kit = "";
    LinkedList<nx> kiu = new LinkedList();
    LinkedList<String> kiv = new LinkedList();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardAcceptCardListUI() {
        AppMethodBeat.i(88221);
        AppMethodBeat.o(88221);
    }

    public final int getLayoutId() {
        return R.layout.ht;
    }

    public final void initView() {
        AppMethodBeat.i(88222);
        setMMTitle((int) R.string.acf);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88216);
                ab.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
                CardAcceptCardListUI.a(CardAcceptCardListUI.this, 1);
                AppMethodBeat.o(88216);
                return true;
            }
        });
        this.kii = findViewById(R.id.a_9);
        this.kij = findViewById(R.id.a__);
        this.En = findViewById(R.id.a_a);
        this.kij.setVisibility(4);
        this.kam = (ListView) findViewById(16908298);
        this.kao = (RelativeLayout) findViewById(R.id.a_b);
        this.kam.setEmptyView(this.kao);
        this.kik = new a(this);
        this.kam.setAdapter(this.kik);
        this.kam.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.kil = findViewById(R.id.a_d);
        this.kgI = (Button) findViewById(R.id.a_e);
        this.kgI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(88217);
                if (CardAcceptCardListUI.this.kcf) {
                    CardAcceptCardListUI.a(CardAcceptCardListUI.this, CardAcceptCardListUI.b(CardAcceptCardListUI.this));
                    AppMethodBeat.o(88217);
                    return;
                }
                CardAcceptCardListUI cardAcceptCardListUI = CardAcceptCardListUI.this;
                LinkedList b = CardAcceptCardListUI.b(CardAcceptCardListUI.this);
                cardAcceptCardListUI.fE(true);
                g.RO().eJo.a(new com.tencent.mm.plugin.card.model.p(b, cardAcceptCardListUI.cME, cardAcceptCardListUI.kir, cardAcceptCardListUI.kis, cardAcceptCardListUI.kiq), 0);
                AppMethodBeat.o(88217);
            }
        });
        this.kgI.setEnabled(false);
        this.kim = findViewById(R.id.a_f);
        this.kin = (TextView) findViewById(R.id.a_g);
        this.kio = (Button) findViewById(R.id.a_h);
        this.kio.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(88218);
                CardAcceptCardListUI.c(CardAcceptCardListUI.this);
                AppMethodBeat.o(88218);
            }
        });
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            sZ(2);
            AppMethodBeat.o(88222);
            return;
        }
        ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.cME = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.kiq = getIntent().getIntExtra("key_stastic_scene", 7);
        this.kir = getIntent().getStringExtra("src_username");
        this.kis = getIntent().getStringExtra("js_url");
        this.kit = getIntent().getStringExtra("key_consumed_card_id");
        this.fhu = getIntent().getStringExtra("key_template_id");
        ArrayList bP = h.bP(stringExtra, this.cME);
        if (bP == null || bP.size() == 0) {
            ab.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            sZ(2);
            AppMethodBeat.o(88222);
            return;
        }
        this.kip.clear();
        this.kip.addAll(bP);
        this.kiu.clear();
        this.kiv.clear();
        this.kic.clear();
        LinkedList linkedList = this.kip;
        fE(true);
        g.RO().eJo.a(new com.tencent.mm.plugin.card.model.ab(linkedList, this.cME, stringExtra2, stringExtra3, this.kir, this.kis, this.kit, this.kiq), 0);
        AppMethodBeat.o(88222);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88223);
        super.onCreate(bundle);
        g.RO().eJo.a(690, (f) this);
        g.RO().eJo.a(687, (f) this);
        g.RO().eJo.a(902, (f) this);
        initView();
        AppMethodBeat.o(88223);
    }

    /* Access modifiers changed, original: final */
    public final void fE(boolean z) {
        AppMethodBeat.i(88225);
        if (z) {
            this.ejZ = p.b(this, getString(R.string.cn5), false, null);
            AppMethodBeat.o(88225);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.o(88225);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(88226);
        String str2;
        int dimensionPixelOffset;
        Intent intent;
        if (i != 0 || i2 != 0) {
            ab.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + mVar.getType() + "errType = " + i + " errCode = " + i2);
            fE(false);
            d.b(this, str, i2);
            if (mVar instanceof com.tencent.mm.plugin.card.model.p) {
                this.ked = str;
                AppMethodBeat.o(88226);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                this.ked = "";
            }
        } else if (mVar instanceof com.tencent.mm.plugin.card.model.ab) {
            fE(false);
            com.tencent.mm.plugin.card.model.ab abVar = (com.tencent.mm.plugin.card.model.ab) mVar;
            str2 = abVar.kdS;
            this.kee = abVar.kee;
            this.kef = abVar.kef;
            this.keg = abVar.keg;
            this.keh = abVar.keh;
            ab.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.kee + "  accept_button_wording: " + this.kef);
            ab.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.keg + "  private_wording: " + this.keh);
            ArrayList Hg = com.tencent.mm.plugin.card.d.f.Hg(str2);
            ArrayList bf = bf(Hg);
            if (Hg == null || Hg.size() <= 0) {
                ab.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                ab.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + Hg.size());
                if (bf != null && bf.size() > 0) {
                    a aVar = this.kik;
                    HashMap hashMap = this.kic;
                    if (bf != null) {
                        aVar.khh.clear();
                        aVar.khh.addAll(bf);
                        aVar.kic.putAll(hashMap);
                    }
                }
                this.kik.notifyDataSetChanged();
                if (((CardInfo) Hg.get(0)).aZC()) {
                    this.kcf = true;
                }
            }
            this.kij.setVisibility(0);
            if (this.kik.getCount() > 0) {
                b sY = this.kik.sY(0);
                com.tencent.mm.plugin.card.d.m.a((MMActivity) this, sY);
                this.kii.setBackgroundColor(l.Hn(sY.aZV().color));
                this.kil.setVisibility(0);
                StateListDrawable stateListDrawable = new StateListDrawable();
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.w2);
                if (this.kee == 1) {
                    this.kgI.setEnabled(true);
                    ShapeDrawable dI = l.dI(l.Hn(sY.aZV().color), dimensionPixelOffset);
                    int[] iArr = new int[]{16842919};
                    stateListDrawable.addState(iArr, l.dI(l.bS(sY.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelOffset));
                    stateListDrawable.addState(new int[0], dI);
                } else {
                    this.kgI.setEnabled(false);
                    stateListDrawable.addState(new int[0], l.dI(l.bS(sY.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelOffset));
                }
                this.kgI.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.kef)) {
                    this.kgI.setText(this.kef);
                }
                if (this.keg == 1) {
                    int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m4);
                    ShapeDrawable b = l.b(this, getResources().getColor(R.color.a69), dimensionPixelOffset2);
                    ShapeDrawable dI2 = l.dI(getResources().getColor(R.color.a69), dimensionPixelOffset2);
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    stateListDrawable2.addState(new int[]{16842919}, dI2);
                    stateListDrawable2.addState(new int[0], b);
                    this.kio.setBackgroundDrawable(stateListDrawable2);
                    int[] iArr2 = new int[]{l.Hn(sY.aZV().color), getResources().getColor(R.color.a69)};
                    this.kio.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.kim.setVisibility(0);
                    if (TextUtils.isEmpty(this.keh)) {
                        this.kin.setText(R.string.ah8);
                        AppMethodBeat.o(88226);
                        return;
                    }
                    this.kin.setText(this.keh);
                    AppMethodBeat.o(88226);
                    return;
                }
                this.kim.setVisibility(8);
                LayoutParams layoutParams = (LayoutParams) this.kij.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.nc);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.l9);
                this.kij.setLayoutParams(layoutParams);
                this.kij.invalidate();
                layoutParams = (LayoutParams) this.kil.getLayoutParams();
                layoutParams.addRule(8, R.id.a_a);
                this.kil.setLayoutParams(layoutParams);
                this.kil.invalidate();
                AppMethodBeat.o(88226);
                return;
            }
            this.kil.setVisibility(8);
            this.kim.setVisibility(8);
            this.kii.setBackgroundColor(getResources().getColor(R.color.ir));
            AppMethodBeat.o(88226);
            return;
        } else if (mVar instanceof com.tencent.mm.plugin.card.model.p) {
            fE(false);
            com.tencent.mm.plugin.card.model.p pVar = (com.tencent.mm.plugin.card.model.p) mVar;
            if (pVar.kdT != 0) {
                str2 = pVar.kdU;
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.string.acu);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str2, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(88219);
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.a(CardAcceptCardListUI.this, 2);
                        AppMethodBeat.o(88219);
                    }
                });
                this.ked = pVar.kdS;
                AppMethodBeat.o(88226);
                return;
            }
            com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.aep));
            intent = new Intent();
            intent.putExtra("card_list", pVar.kdS);
            setResult(-1, intent);
            ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            l.beB();
            finish();
            AppMethodBeat.o(88226);
            return;
        } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
            fE(false);
            String str3 = ((com.tencent.mm.plugin.card.sharecard.model.g) mVar).kdS;
            dimensionPixelOffset = ((com.tencent.mm.plugin.card.sharecard.model.g) mVar).kdT;
            str2 = ((com.tencent.mm.plugin.card.sharecard.model.g) mVar).kdU;
            this.ked = str3;
            if (dimensionPixelOffset != 0) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.string.ahi);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str2, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(88220);
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.a(CardAcceptCardListUI.this, 2);
                        AppMethodBeat.o(88220);
                    }
                });
                AppMethodBeat.o(88226);
                return;
            }
            com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.acl));
            intent = new Intent();
            intent.putExtra("card_list", this.ked);
            setResult(-1, intent);
            ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            l.beD();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            com.tencent.mm.plugin.card.d.f.a(shareCardInfo, str3);
            l.a(shareCardInfo);
            am.bbd().aVU();
            finish();
            AppMethodBeat.o(88226);
            return;
        }
        AppMethodBeat.o(88226);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88227);
        if (i == 4) {
            ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            sZ(1);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(88227);
        return onKeyDown;
    }

    private void sZ(int i) {
        AppMethodBeat.i(88228);
        ab.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(i)));
        Intent intent = new Intent();
        intent.putExtra("card_list", this.ked);
        intent.putExtra("result_code", i);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(88228);
    }

    public final void c(int i, int i2, Intent intent) {
        AppMethodBeat.i(88229);
        switch (i) {
            case 2:
                if (i2 == -1) {
                    this.kgP = intent.getIntExtra("Ktag_range_index", 0);
                    ab.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", Integer.valueOf(this.kgP));
                    if (this.kgP < 2) {
                        bbZ();
                        break;
                    }
                    this.kgQ = intent.getStringExtra("Klabel_name_list");
                    this.kgR = intent.getStringExtra("Kother_user_name_list");
                    ab.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kgP), this.kgQ);
                    if (TextUtils.isEmpty(this.kgQ) && TextUtils.isEmpty(this.kgR)) {
                        ab.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                        bbZ();
                        AppMethodBeat.o(88229);
                        return;
                    }
                    List asList = Arrays.asList(this.kgQ.split(","));
                    this.kgT = l.bl(asList);
                    this.kgS = l.bk(asList);
                    if (this.kgR != null && this.kgR.length() > 0) {
                        this.kgS.addAll(Arrays.asList(this.kgR.split(",")));
                    }
                    if (this.kgT != null) {
                        ab.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.kgT.size());
                    }
                    if (this.kgS != null) {
                        ab.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.kgS.size());
                        Iterator it = this.kgS.iterator();
                        while (it.hasNext()) {
                            ab.d("MicroMsg.CardAcceptCardListUI", "username : %s", (String) it.next());
                        }
                    }
                    if (TextUtils.isEmpty(this.kgQ)) {
                        bbZ();
                    } else if (this.kgP == 2) {
                        this.kin.setText(getString(R.string.ah_, new Object[]{bbF()}));
                        AppMethodBeat.o(88229);
                        return;
                    } else if (this.kgP == 3) {
                        this.kin.setText(getString(R.string.ah9, new Object[]{bbF()}));
                        AppMethodBeat.o(88229);
                        return;
                    }
                    AppMethodBeat.o(88229);
                    return;
                }
                AppMethodBeat.o(88229);
                return;
        }
        AppMethodBeat.o(88229);
    }

    private String bbF() {
        AppMethodBeat.i(88230);
        String str;
        if (!TextUtils.isEmpty(this.kgQ) && !TextUtils.isEmpty(this.kgR)) {
            str = this.kgQ + "," + l.Hq(this.kgR);
            AppMethodBeat.o(88230);
            return str;
        } else if (!TextUtils.isEmpty(this.kgQ)) {
            str = this.kgQ;
            AppMethodBeat.o(88230);
            return str;
        } else if (TextUtils.isEmpty(this.kgR)) {
            str = "";
            AppMethodBeat.o(88230);
            return str;
        } else {
            str = l.Hq(this.kgR);
            AppMethodBeat.o(88230);
            return str;
        }
    }

    private void bbZ() {
        AppMethodBeat.i(88231);
        if (TextUtils.isEmpty(this.keh)) {
            this.kin.setText(R.string.ah8);
            AppMethodBeat.o(88231);
            return;
        }
        this.kin.setText(this.keh);
        AppMethodBeat.o(88231);
    }

    private ArrayList<CardInfo> bf(List<CardInfo> list) {
        AppMethodBeat.i(88232);
        if (list == null || list.size() == 0) {
            ab.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            AppMethodBeat.o(88232);
            return null;
        }
        this.kiu.clear();
        this.kiv.clear();
        this.kic.clear();
        ArrayList<CardInfo> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                CardInfo cardInfo = (CardInfo) list.get(i2);
                if (this.kiv.contains(cardInfo.field_card_tp_id)) {
                    this.kic.put(cardInfo.field_card_tp_id, Integer.valueOf(((Integer) this.kic.get(cardInfo.field_card_tp_id)).intValue() + 1));
                } else {
                    arrayList.add(cardInfo);
                    this.kic.put(cardInfo.field_card_tp_id, Integer.valueOf(1));
                    this.kiv.add(cardInfo.field_card_tp_id);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(88232);
                return arrayList;
            }
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(88224);
        g.RO().eJo.b(690, (f) this);
        g.RO().eJo.b(687, (f) this);
        g.RO().eJo.b(902, (f) this);
        this.kip.clear();
        a aVar = this.kik;
        aVar.khh.clear();
        aVar.mContext = null;
        super.onDestroy();
        AppMethodBeat.o(88224);
    }

    static /* synthetic */ LinkedList b(CardAcceptCardListUI cardAcceptCardListUI) {
        AppMethodBeat.i(88234);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardAcceptCardListUI.kip.size(); i++) {
            linkedList.add(cardAcceptCardListUI.kip.get(i));
        }
        AppMethodBeat.o(88234);
        return linkedList;
    }

    static /* synthetic */ void c(CardAcceptCardListUI cardAcceptCardListUI) {
        AppMethodBeat.i(88236);
        ab.i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        com.tencent.mm.plugin.report.service.h.pYm.e(11582, "OpenShareUserSelectView", Integer.valueOf(0), "", "", "", "");
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.kgP);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.kgQ);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.kgR);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(R.string.aha));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("KLabel_is_filter_private", true);
        com.tencent.mm.bp.d.b((Context) cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.ifE = cardAcceptCardListUI;
        AppMethodBeat.o(88236);
    }
}
