package com.tencent.p177mm.plugin.card.p355ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C27585ab;
import com.tencent.p177mm.plugin.card.model.C38749p;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C20135h;
import com.tencent.p177mm.plugin.card.p931d.C27575f;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.sharecard.model.C42858g;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C35941nx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.ui.CardAcceptCardListUI */
public class CardAcceptCardListUI extends MMActivity implements C1202f, C5186a {
    /* renamed from: En */
    private View f2894En;
    int cME = 8;
    private C44275p ejZ = null;
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
    protected C27618a kik = null;
    private View kil;
    private View kim;
    private TextView kin;
    private Button kio;
    LinkedList<C35941nx> kip = new LinkedList();
    int kiq = 7;
    String kir = "";
    String kis = "";
    private String kit = "";
    LinkedList<C35941nx> kiu = new LinkedList();
    LinkedList<String> kiv = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.card.ui.CardAcceptCardListUI$1 */
    class C27621 implements OnMenuItemClickListener {
        C27621() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88216);
            C4990ab.m7418v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
            CardAcceptCardListUI.m19014a(CardAcceptCardListUI.this, 1);
            AppMethodBeat.m2505o(88216);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardAcceptCardListUI$3 */
    class C27633 implements OnClickListener {
        C27633() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88217);
            if (CardAcceptCardListUI.this.kcf) {
                CardAcceptCardListUI.m19015a(CardAcceptCardListUI.this, CardAcceptCardListUI.m19017b(CardAcceptCardListUI.this));
                AppMethodBeat.m2505o(88217);
                return;
            }
            CardAcceptCardListUI cardAcceptCardListUI = CardAcceptCardListUI.this;
            LinkedList b = CardAcceptCardListUI.m19017b(CardAcceptCardListUI.this);
            cardAcceptCardListUI.mo22995fE(true);
            C1720g.m3535RO().eJo.mo14541a(new C38749p(b, cardAcceptCardListUI.cME, cardAcceptCardListUI.kir, cardAcceptCardListUI.kis, cardAcceptCardListUI.kiq), 0);
            AppMethodBeat.m2505o(88217);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardAcceptCardListUI$4 */
    class C27644 implements OnClickListener {
        C27644() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88218);
            CardAcceptCardListUI.m19019c(CardAcceptCardListUI.this);
            AppMethodBeat.m2505o(88218);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardAcceptCardListUI$2 */
    class C113002 implements OnItemClickListener {
        C113002() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardAcceptCardListUI$5 */
    class C113015 implements DialogInterface.OnClickListener {
        C113015() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88219);
            dialogInterface.dismiss();
            CardAcceptCardListUI.m19014a(CardAcceptCardListUI.this, 2);
            AppMethodBeat.m2505o(88219);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardAcceptCardListUI$6 */
    class C113026 implements DialogInterface.OnClickListener {
        C113026() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88220);
            dialogInterface.dismiss();
            CardAcceptCardListUI.m19014a(CardAcceptCardListUI.this, 2);
            AppMethodBeat.m2505o(88220);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardAcceptCardListUI() {
        AppMethodBeat.m2504i(88221);
        AppMethodBeat.m2505o(88221);
    }

    public final int getLayoutId() {
        return 2130968891;
    }

    public final void initView() {
        AppMethodBeat.m2504i(88222);
        setMMTitle((int) C25738R.string.acf);
        setBackBtn(new C27621());
        this.kii = findViewById(2131821923);
        this.kij = findViewById(2131821924);
        this.f2894En = findViewById(2131821925);
        this.kij.setVisibility(4);
        this.kam = (ListView) findViewById(16908298);
        this.kao = (RelativeLayout) findViewById(2131821926);
        this.kam.setEmptyView(this.kao);
        this.kik = new C27618a(this);
        this.kam.setAdapter(this.kik);
        this.kam.setOnItemClickListener(new C113002());
        this.kil = findViewById(2131821928);
        this.kgI = (Button) findViewById(2131821929);
        this.kgI.setOnClickListener(new C27633());
        this.kgI.setEnabled(false);
        this.kim = findViewById(2131821930);
        this.kin = (TextView) findViewById(2131821931);
        this.kio = (Button) findViewById(2131821932);
        this.kio.setOnClickListener(new C27644());
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            m19020sZ(2);
            AppMethodBeat.m2505o(88222);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.cME = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.kiq = getIntent().getIntExtra("key_stastic_scene", 7);
        this.kir = getIntent().getStringExtra("src_username");
        this.kis = getIntent().getStringExtra("js_url");
        this.kit = getIntent().getStringExtra("key_consumed_card_id");
        this.fhu = getIntent().getStringExtra("key_template_id");
        ArrayList bP = C20135h.m31152bP(stringExtra, this.cME);
        if (bP == null || bP.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            m19020sZ(2);
            AppMethodBeat.m2505o(88222);
            return;
        }
        this.kip.clear();
        this.kip.addAll(bP);
        this.kiu.clear();
        this.kiv.clear();
        this.kic.clear();
        LinkedList linkedList = this.kip;
        mo22995fE(true);
        C1720g.m3535RO().eJo.mo14541a(new C27585ab(linkedList, this.cME, stringExtra2, stringExtra3, this.kir, this.kis, this.kit, this.kiq), 0);
        AppMethodBeat.m2505o(88222);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88223);
        super.onCreate(bundle);
        C1720g.m3535RO().eJo.mo14539a(690, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(687, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(902, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(88223);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fE */
    public final void mo22995fE(boolean z) {
        AppMethodBeat.m2504i(88225);
        if (z) {
            this.ejZ = C44275p.m79966b(this, getString(C25738R.string.cn5), false, null);
            AppMethodBeat.m2505o(88225);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.m2505o(88225);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88226);
        String str2;
        int dimensionPixelOffset;
        Intent intent;
        if (i != 0 || i2 != 0) {
            C4990ab.m7412e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + c1207m.getType() + "errType = " + i + " errCode = " + i2);
            mo22995fE(false);
            C42840d.m76037b(this, str, i2);
            if (c1207m instanceof C38749p) {
                this.ked = str;
                AppMethodBeat.m2505o(88226);
                return;
            } else if (c1207m instanceof C42858g) {
                this.ked = "";
            }
        } else if (c1207m instanceof C27585ab) {
            mo22995fE(false);
            C27585ab c27585ab = (C27585ab) c1207m;
            str2 = c27585ab.kdS;
            this.kee = c27585ab.kee;
            this.kef = c27585ab.kef;
            this.keg = c27585ab.keg;
            this.keh = c27585ab.keh;
            C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.kee + "  accept_button_wording: " + this.kef);
            C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.keg + "  private_wording: " + this.keh);
            ArrayList Hg = C27575f.m43793Hg(str2);
            ArrayList bf = m19018bf(Hg);
            if (Hg == null || Hg.size() <= 0) {
                C4990ab.m7412e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + Hg.size());
                if (bf != null && bf.size() > 0) {
                    C27618a c27618a = this.kik;
                    HashMap hashMap = this.kic;
                    if (bf != null) {
                        c27618a.khh.clear();
                        c27618a.khh.addAll(bf);
                        c27618a.kic.putAll(hashMap);
                    }
                }
                this.kik.notifyDataSetChanged();
                if (((CardInfo) Hg.get(0)).aZC()) {
                    this.kcf = true;
                }
            }
            this.kij.setVisibility(0);
            if (this.kik.getCount() > 0) {
                C42837b sY = this.kik.mo45469sY(0);
                C45778m.m84645a((MMActivity) this, sY);
                this.kii.setBackgroundColor(C38736l.m65701Hn(sY.aZV().color));
                this.kil.setVisibility(0);
                StateListDrawable stateListDrawable = new StateListDrawable();
                dimensionPixelOffset = getResources().getDimensionPixelOffset(C25738R.dimen.f10260w2);
                if (this.kee == 1) {
                    this.kgI.setEnabled(true);
                    ShapeDrawable dI = C38736l.m65725dI(C38736l.m65701Hn(sY.aZV().color), dimensionPixelOffset);
                    int[] iArr = new int[]{16842919};
                    stateListDrawable.addState(iArr, C38736l.m65725dI(C38736l.m65720bS(sY.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelOffset));
                    stateListDrawable.addState(new int[0], dI);
                } else {
                    this.kgI.setEnabled(false);
                    stateListDrawable.addState(new int[0], C38736l.m65725dI(C38736l.m65720bS(sY.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelOffset));
                }
                this.kgI.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.kef)) {
                    this.kgI.setText(this.kef);
                }
                if (this.keg == 1) {
                    int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
                    ShapeDrawable b = C38736l.m65718b(this, getResources().getColor(C25738R.color.a69), dimensionPixelOffset2);
                    ShapeDrawable dI2 = C38736l.m65725dI(getResources().getColor(C25738R.color.a69), dimensionPixelOffset2);
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    stateListDrawable2.addState(new int[]{16842919}, dI2);
                    stateListDrawable2.addState(new int[0], b);
                    this.kio.setBackgroundDrawable(stateListDrawable2);
                    int[] iArr2 = new int[]{C38736l.m65701Hn(sY.aZV().color), getResources().getColor(C25738R.color.a69)};
                    this.kio.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.kim.setVisibility(0);
                    if (TextUtils.isEmpty(this.keh)) {
                        this.kin.setText(C25738R.string.ah8);
                        AppMethodBeat.m2505o(88226);
                        return;
                    }
                    this.kin.setText(this.keh);
                    AppMethodBeat.m2505o(88226);
                    return;
                }
                this.kim.setVisibility(8);
                LayoutParams layoutParams = (LayoutParams) this.kij.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(C25738R.dimen.f9952l9);
                this.kij.setLayoutParams(layoutParams);
                this.kij.invalidate();
                layoutParams = (LayoutParams) this.kil.getLayoutParams();
                layoutParams.addRule(8, 2131821925);
                this.kil.setLayoutParams(layoutParams);
                this.kil.invalidate();
                AppMethodBeat.m2505o(88226);
                return;
            }
            this.kil.setVisibility(8);
            this.kim.setVisibility(8);
            this.kii.setBackgroundColor(getResources().getColor(C25738R.color.f11834ir));
            AppMethodBeat.m2505o(88226);
            return;
        } else if (c1207m instanceof C38749p) {
            mo22995fE(false);
            C38749p c38749p = (C38749p) c1207m;
            if (c38749p.kdT != 0) {
                str2 = c38749p.kdU;
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(C25738R.string.acu);
                }
                C30379h.m48448a((Context) this, str2, null, false, new C113015());
                this.ked = c38749p.kdS;
                AppMethodBeat.m2505o(88226);
                return;
            }
            C30379h.m48465bQ(this, getResources().getString(C25738R.string.aep));
            intent = new Intent();
            intent.putExtra("card_list", c38749p.kdS);
            setResult(-1, intent);
            C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            C38736l.beB();
            finish();
            AppMethodBeat.m2505o(88226);
            return;
        } else if (c1207m instanceof C42858g) {
            mo22995fE(false);
            String str3 = ((C42858g) c1207m).kdS;
            dimensionPixelOffset = ((C42858g) c1207m).kdT;
            str2 = ((C42858g) c1207m).kdU;
            this.ked = str3;
            if (dimensionPixelOffset != 0) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(C25738R.string.ahi);
                }
                C30379h.m48448a((Context) this, str2, null, false, new C113026());
                AppMethodBeat.m2505o(88226);
                return;
            }
            C30379h.m48465bQ(this, getResources().getString(C25738R.string.acl));
            intent = new Intent();
            intent.putExtra("card_list", this.ked);
            setResult(-1, intent);
            C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            C38736l.beD();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            C27575f.m43804a(shareCardInfo, str3);
            C38736l.m65713a(shareCardInfo);
            C42852am.bbd().aVU();
            finish();
            AppMethodBeat.m2505o(88226);
            return;
        }
        AppMethodBeat.m2505o(88226);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88227);
        if (i == 4) {
            C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            m19020sZ(1);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(88227);
        return onKeyDown;
    }

    /* renamed from: sZ */
    private void m19020sZ(int i) {
        AppMethodBeat.m2504i(88228);
        C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(i)));
        Intent intent = new Intent();
        intent.putExtra("card_list", this.ked);
        intent.putExtra("result_code", i);
        setResult(0, intent);
        finish();
        AppMethodBeat.m2505o(88228);
    }

    /* renamed from: c */
    public final void mo6069c(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(88229);
        switch (i) {
            case 2:
                if (i2 == -1) {
                    this.kgP = intent.getIntExtra("Ktag_range_index", 0);
                    C4990ab.m7417i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", Integer.valueOf(this.kgP));
                    if (this.kgP < 2) {
                        bbZ();
                        break;
                    }
                    this.kgQ = intent.getStringExtra("Klabel_name_list");
                    this.kgR = intent.getStringExtra("Kother_user_name_list");
                    C4990ab.m7411d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kgP), this.kgQ);
                    if (TextUtils.isEmpty(this.kgQ) && TextUtils.isEmpty(this.kgR)) {
                        C4990ab.m7412e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                        bbZ();
                        AppMethodBeat.m2505o(88229);
                        return;
                    }
                    List asList = Arrays.asList(this.kgQ.split(","));
                    this.kgT = C38736l.m65724bl(asList);
                    this.kgS = C38736l.m65723bk(asList);
                    if (this.kgR != null && this.kgR.length() > 0) {
                        this.kgS.addAll(Arrays.asList(this.kgR.split(",")));
                    }
                    if (this.kgT != null) {
                        C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.kgT.size());
                    }
                    if (this.kgS != null) {
                        C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.kgS.size());
                        Iterator it = this.kgS.iterator();
                        while (it.hasNext()) {
                            C4990ab.m7411d("MicroMsg.CardAcceptCardListUI", "username : %s", (String) it.next());
                        }
                    }
                    if (TextUtils.isEmpty(this.kgQ)) {
                        bbZ();
                    } else if (this.kgP == 2) {
                        this.kin.setText(getString(C25738R.string.ah_, new Object[]{bbF()}));
                        AppMethodBeat.m2505o(88229);
                        return;
                    } else if (this.kgP == 3) {
                        this.kin.setText(getString(C25738R.string.ah9, new Object[]{bbF()}));
                        AppMethodBeat.m2505o(88229);
                        return;
                    }
                    AppMethodBeat.m2505o(88229);
                    return;
                }
                AppMethodBeat.m2505o(88229);
                return;
        }
        AppMethodBeat.m2505o(88229);
    }

    private String bbF() {
        AppMethodBeat.m2504i(88230);
        String str;
        if (!TextUtils.isEmpty(this.kgQ) && !TextUtils.isEmpty(this.kgR)) {
            str = this.kgQ + "," + C38736l.m65704Hq(this.kgR);
            AppMethodBeat.m2505o(88230);
            return str;
        } else if (!TextUtils.isEmpty(this.kgQ)) {
            str = this.kgQ;
            AppMethodBeat.m2505o(88230);
            return str;
        } else if (TextUtils.isEmpty(this.kgR)) {
            str = "";
            AppMethodBeat.m2505o(88230);
            return str;
        } else {
            str = C38736l.m65704Hq(this.kgR);
            AppMethodBeat.m2505o(88230);
            return str;
        }
    }

    private void bbZ() {
        AppMethodBeat.m2504i(88231);
        if (TextUtils.isEmpty(this.keh)) {
            this.kin.setText(C25738R.string.ah8);
            AppMethodBeat.m2505o(88231);
            return;
        }
        this.kin.setText(this.keh);
        AppMethodBeat.m2505o(88231);
    }

    /* renamed from: bf */
    private ArrayList<CardInfo> m19018bf(List<CardInfo> list) {
        AppMethodBeat.m2504i(88232);
        if (list == null || list.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            AppMethodBeat.m2505o(88232);
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
                AppMethodBeat.m2505o(88232);
                return arrayList;
            }
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88224);
        C1720g.m3535RO().eJo.mo14546b(690, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(687, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(902, (C1202f) this);
        this.kip.clear();
        C27618a c27618a = this.kik;
        c27618a.khh.clear();
        c27618a.mContext = null;
        super.onDestroy();
        AppMethodBeat.m2505o(88224);
    }

    /* renamed from: b */
    static /* synthetic */ LinkedList m19017b(CardAcceptCardListUI cardAcceptCardListUI) {
        AppMethodBeat.m2504i(88234);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardAcceptCardListUI.kip.size(); i++) {
            linkedList.add(cardAcceptCardListUI.kip.get(i));
        }
        AppMethodBeat.m2505o(88234);
        return linkedList;
    }

    /* renamed from: c */
    static /* synthetic */ void m19019c(CardAcceptCardListUI cardAcceptCardListUI) {
        AppMethodBeat.m2504i(88236);
        C4990ab.m7416i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        C7060h.pYm.mo8381e(11582, "OpenShareUserSelectView", Integer.valueOf(0), "", "", "", "");
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.kgP);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.kgQ);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.kgR);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(C25738R.string.aha));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("KLabel_is_filter_private", true);
        C25985d.m41468b((Context) cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.ifE = cardAcceptCardListUI;
        AppMethodBeat.m2505o(88236);
    }
}
