package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.plugin.card.model.C38747g;
import com.tencent.p177mm.plugin.card.model.C38747g.C38745a;
import com.tencent.p177mm.plugin.card.model.C38747g.C38748b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.C45786h;
import com.tencent.p177mm.plugin.card.p352b.C2752k;
import com.tencent.p177mm.plugin.card.p352b.C2752k.C2754a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C42840d.C27574a;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.CardConsumeSuccessUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.C15368nz;
import com.tencent.p177mm.protocal.protobuf.C46570nm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI */
public class CardNewMsgUI extends MMActivity implements C2754a {
    /* renamed from: Ek */
    private View f2895Ek;
    OnClickListener gKK = new C113299();
    private C11321a kmR;
    private View kmS;
    private View kmT = null;
    private boolean kmU = false;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$3 */
    class C113193 implements OnItemLongClickListener {
        C113193() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(88594);
            CardNewMsgUI.m19048b(CardNewMsgUI.this, i);
            AppMethodBeat.m2505o(88594);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$4 */
    class C113204 implements OnScrollListener {
        C113204() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(88595);
            if (!CardNewMsgUI.this.kmU) {
                AppMethodBeat.m2505o(88595);
            } else if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (C42852am.baY().baS() > 0) {
                    C42852am.baY().baT();
                } else {
                    CardNewMsgUI.this.kmR.bdo();
                }
                CardNewMsgUI.this.kmR.mo5248a(null, null);
                AppMethodBeat.m2505o(88595);
            } else {
                AppMethodBeat.m2505o(88595);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$a */
    class C11321a extends C46692p<C38747g> {
        private int enb = this.kmW;
        private int kmW = 10;

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(88609);
            C38747g c38747g = (C38747g) obj;
            if (c38747g == null) {
                c38747g = new C38747g();
            }
            c38747g.mo8995d(cursor);
            AppMethodBeat.m2505o(88609);
            return c38747g;
        }

        public C11321a() {
            super(CardNewMsgUI.this, new C38747g());
            AppMethodBeat.m2504i(88603);
            mo74996pN(true);
            AppMethodBeat.m2505o(88603);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(88604);
            if (C42852am.baY().baS() > 0) {
                setCursor(C42852am.baY().bSd.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.enb = C42852am.baY().getCount();
                C45786h baY = C42852am.baY();
                setCursor(baY.bSd.rawQuery("select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.kmW)), null));
            }
            notifyDataSetChanged();
            AppMethodBeat.m2505o(88604);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(88605);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(88605);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int bdo() {
            AppMethodBeat.m2504i(88606);
            if (bdn()) {
                if (CardNewMsgUI.this.kmT.getParent() != null) {
                    CardNewMsgUI.this.mListView.removeFooterView(CardNewMsgUI.this.kmT);
                }
                AppMethodBeat.m2505o(88606);
                return 0;
            }
            this.kmW += 10;
            if (this.kmW <= this.enb) {
                AppMethodBeat.m2505o(88606);
                return 10;
            }
            this.kmW = this.enb;
            int i = this.enb % 10;
            AppMethodBeat.m2505o(88606);
            return i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C11330b c11330b;
            AppMethodBeat.m2504i(88607);
            C38747g c38747g = (C38747g) getItem(i);
            if (view == null) {
                view = View.inflate(CardNewMsgUI.this.mController.ylL, 2130968956, null);
                C11330b c11330b2 = new C11330b(CardNewMsgUI.this, (byte) 0);
                c11330b2.knb = (ImageView) view.findViewById(2131822233);
                c11330b2.knc = view.findViewById(2131822208);
                c11330b2.knd = (ImageView) view.findViewById(2131822209);
                c11330b2.kne = (TextView) view.findViewById(2131821185);
                c11330b2.knf = (TextView) view.findViewById(2131820988);
                c11330b2.kng = (TextView) view.findViewById(2131822234);
                c11330b2.knh = (TextView) view.findViewById(2131822235);
                c11330b2.kni = (TextView) view.findViewById(2131822238);
                c11330b2.knj = view.findViewById(2131822239);
                c11330b2.knk = (TextView) view.findViewById(2131822240);
                c11330b2.knl = (LinearLayout) view.findViewById(2131822237);
                c11330b2.knm = (LinearLayout) view.findViewById(2131822236);
                view.setTag(c11330b2);
                c11330b = c11330b2;
            } else {
                c11330b = (C11330b) view.getTag();
            }
            c11330b.kne.setText(c38747g.field_title);
            c11330b.knf.setText(C14835h.m23089c(CardNewMsgUI.this, ((long) c38747g.field_time) * 1000, true));
            c11330b.kng.setText(c38747g.field_description);
            int dimensionPixelSize = CardNewMsgUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f10265w9);
            C4990ab.m7410d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " logo_url :  " + c38747g.field_logo_url);
            if (TextUtils.isEmpty(c38747g.field_logo_color)) {
                c11330b.knc.setVisibility(8);
                c11330b.knb.setVisibility(0);
                c11330b.knb.setImageResource(C25738R.drawable.bcm);
                C45778m.m84644a(c11330b.knb, c38747g.field_logo_url, dimensionPixelSize, (int) C25738R.drawable.bcm, true);
            } else {
                C4990ab.m7410d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " field_logo_color :  " + c38747g.field_logo_color);
                c11330b.knc.setVisibility(0);
                c11330b.knb.setVisibility(8);
                if (TextUtils.isEmpty(c38747g.field_logo_url)) {
                    C45778m.m84643a(c11330b.knd, C25738R.drawable.azs, C38736l.m65701Hn(c38747g.field_logo_color));
                } else {
                    C45778m.m84641a(CardNewMsgUI.this, c11330b.knd, c38747g.field_logo_url, dimensionPixelSize, C38736l.m65701Hn(c38747g.field_logo_color));
                }
            }
            C46570nm baM = c38747g.baM();
            if (baM == null || TextUtils.isEmpty(baM.text)) {
                c11330b.knh.setVisibility(8);
            } else {
                c11330b.knh.setText(baM.text);
                c11330b.knh.setTag(c38747g);
                c11330b.knh.setVisibility(0);
                c11330b.knh.setOnClickListener(CardNewMsgUI.this.gKK);
            }
            C15368nz baN = c38747g.baN();
            if (baN == null || TextUtils.isEmpty(baN.text)) {
                c11330b.knj.setVisibility(8);
                c11330b.kni.setVisibility(8);
            } else {
                c11330b.knk.setText(baN.text);
                c11330b.knj.setVisibility(0);
                c11330b.knj.setOnClickListener(CardNewMsgUI.this.gKK);
                c11330b.knj.setTag(c38747g);
                c11330b.kni.setVisibility(0);
            }
            c38747g.baO();
            c38747g.baP();
            m19041a(c38747g.kdv, c38747g.kdw, c11330b, c38747g);
            AppMethodBeat.m2505o(88607);
            return view;
        }

        /* renamed from: a */
        private void m19041a(List<C38745a> list, List<C38748b> list2, C11330b c11330b, final C38747g c38747g) {
            AppMethodBeat.m2504i(88608);
            c11330b.knl.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                c11330b.knm.setVisibility(8);
                AppMethodBeat.m2505o(88608);
                return;
            }
            int i;
            View inflate;
            Button button;
            if (!C5046bo.m7548ek(list)) {
                for (i = 0; i < list.size(); i++) {
                    final C38745a c38745a = (C38745a) list.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.ylL, 2130968889, null);
                    if (i == 0) {
                        inflate.findViewById(2131821908).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(2131821909)).setText(c38745a.title);
                    ((TextView) inflate.findViewById(2131821910)).setText(c38745a.jcF);
                    button = (Button) inflate.findViewById(2131821911);
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(88601);
                            Intent intent = new Intent();
                            if (c38745a.kdC == 0) {
                                intent.setClass(CardNewMsgUI.this.mController.ylL, CardDetailUI.class);
                                intent.putExtra("key_card_id", c38745a.cardId);
                                intent.putExtra("key_card_ext", c38745a.kdB);
                                intent.putExtra("key_from_scene", 17);
                                CardNewMsgUI.this.startActivity(intent);
                            } else if (c38745a.kdC == 1) {
                                intent.setClass(CardNewMsgUI.this.mController.ylL, CardConsumeSuccessUI.class);
                                intent.putExtra("key_card_id", c38747g.field_card_id);
                                intent.putExtra("key_from_scene", 2);
                                CardNewMsgUI.this.startActivity(intent);
                            }
                            C7060h.pYm.mo8381e(11941, Integer.valueOf(8), c38747g.field_card_id, c38747g.field_card_tp_id, c38747g.field_msg_id, c38745a.cardId);
                            AppMethodBeat.m2505o(88601);
                        }
                    });
                    if (c38745a.kdC == 0) {
                        button.setText(C25738R.string.acb);
                    } else if (c38745a.kdC == 1) {
                        button.setText(C25738R.string.acc);
                    }
                    c11330b.knl.addView(inflate);
                }
            }
            if (!C5046bo.m7548ek(list2)) {
                for (i = 0; i < list2.size(); i++) {
                    final C38748b c38748b = (C38748b) list2.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.ylL, 2130968889, null);
                    if (i == 0 && C5046bo.m7548ek(list)) {
                        inflate.findViewById(2131821908).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(2131821909)).setText(c38748b.title);
                    ((TextView) inflate.findViewById(2131821910)).setText(c38748b.description);
                    button = (Button) inflate.findViewById(2131821911);
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(88602);
                            if (TextUtils.isEmpty(c38748b.kdF)) {
                                C4990ab.m7412e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                                AppMethodBeat.m2505o(88602);
                                return;
                            }
                            C45774b.m84626a(CardNewMsgUI.this, c38748b.kdF, 2);
                            AppMethodBeat.m2505o(88602);
                        }
                    });
                    button.setText(c38748b.kdE);
                    c11330b.knl.addView(inflate);
                }
            }
            c11330b.knm.setVisibility(0);
            AppMethodBeat.m2505o(88608);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$6 */
    class C113246 implements OnMenuItemClickListener {
        C113246() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88597);
            C7060h.pYm.mo8381e(11582, "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "");
            CardNewMsgUI.m19055h(CardNewMsgUI.this);
            AppMethodBeat.m2505o(88597);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$5 */
    class C113255 implements C30723a {
        C113255() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(88596);
            CardNewMsgUI.m19054g(CardNewMsgUI.this);
            if (CardNewMsgUI.this.kmR.bdn() && C42852am.baY().baS() == 0) {
                CardNewMsgUI.this.kmS.setVisibility(8);
            }
            AppMethodBeat.m2505o(88596);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$1 */
    class C113261 implements OnMenuItemClickListener {
        C113261() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88592);
            CardNewMsgUI.this.finish();
            AppMethodBeat.m2505o(88592);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$2 */
    class C113272 implements OnItemClickListener {
        C113272() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(88593);
            if (i == CardNewMsgUI.this.kmR.getCount()) {
                int i2 = 1;
                if (C42852am.baY().baS() > 0) {
                    C42852am.baY().baT();
                } else {
                    i2 = CardNewMsgUI.this.kmR.bdo();
                }
                CardNewMsgUI.this.kmR.mo5248a(null, null);
                if (!CardNewMsgUI.this.kmU) {
                    if (CardNewMsgUI.this.kmS.getParent() != null) {
                        C4990ab.m7410d("MicroMsg.CardNewMsgUI", "remove footer");
                        CardNewMsgUI.this.mListView.removeFooterView(CardNewMsgUI.this.kmS);
                    }
                    if (!CardNewMsgUI.this.kmR.bdn() && CardNewMsgUI.this.kmT.getParent() == null && i2 > 0) {
                        CardNewMsgUI.this.mListView.addFooterView(CardNewMsgUI.this.kmT);
                        C4990ab.m7416i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                    }
                }
                CardNewMsgUI.this.kmU = true;
                CardNewMsgUI.this.kmS.setVisibility(8);
                AppMethodBeat.m2505o(88593);
                return;
            }
            CardNewMsgUI.m19046a(CardNewMsgUI.this, i);
            AppMethodBeat.m2505o(88593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$8 */
    class C113288 extends C27574a {
        C113288() {
        }

        public final void bdj() {
            AppMethodBeat.m2504i(88599);
            C2752k bba = C42852am.bba();
            if (bba.kbM.size() != 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bba.kbM);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    C38747g c38747g = (C38747g) arrayList.get(i2);
                    if (c38747g != null) {
                        bba.kbM.remove(c38747g);
                        C2752k.m5000d(c38747g);
                    }
                    i = i2 + 1;
                }
                arrayList.clear();
            }
            CardNewMsgUI.m19054g(CardNewMsgUI.this);
            CardNewMsgUI.this.kmR.mo5248a(null, null);
            AppMethodBeat.m2505o(88599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$9 */
    class C113299 implements OnClickListener {
        C113299() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88600);
            C38747g c38747g;
            if (view.getId() == 2131822235) {
                c38747g = (C38747g) view.getTag();
                if (c38747g == null || c38747g.baM() == null) {
                    AppMethodBeat.m2505o(88600);
                    return;
                }
                C7060h.pYm.mo8381e(11941, Integer.valueOf(2), c38747g.field_card_id, c38747g.field_card_tp_id, c38747g.field_msg_id, "");
                if (c38747g.baM().kdC == 0) {
                    C4990ab.m7416i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                    if (TextUtils.isEmpty(c38747g.baM().url)) {
                        C4990ab.m7412e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                        AppMethodBeat.m2505o(88600);
                        return;
                    }
                    C45774b.m84626a(CardNewMsgUI.this, c38747g.baM().url, 2);
                    AppMethodBeat.m2505o(88600);
                    return;
                }
                if (c38747g.baM().kdC == 1) {
                    C4990ab.m7416i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                    Intent intent = new Intent();
                    intent.putExtra("KEY_CARD_ID", c38747g.field_card_id);
                    intent.putExtra("KEY_CARD_TP_ID", c38747g.field_card_tp_id);
                    intent.setClass(CardNewMsgUI.this, CardShopUI.class);
                    CardNewMsgUI.this.startActivity(intent);
                    C7060h.pYm.mo8381e(11324, "UsedStoresView", Integer.valueOf(c38747g.field_card_type), c38747g.field_card_tp_id, c38747g.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
                }
                AppMethodBeat.m2505o(88600);
                return;
            }
            if (view.getId() == 2131822239) {
                c38747g = (C38747g) view.getTag();
                if (c38747g == null || c38747g.baN() == null) {
                    AppMethodBeat.m2505o(88600);
                    return;
                } else if (c38747g.baN().type == 0) {
                    C4990ab.m7416i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                    if (TextUtils.isEmpty(c38747g.baN().url)) {
                        C4990ab.m7412e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                        AppMethodBeat.m2505o(88600);
                        return;
                    }
                    C45774b.m84626a(CardNewMsgUI.this, c38747g.baN().url, 2);
                    AppMethodBeat.m2505o(88600);
                    return;
                } else if (c38747g.baN().type == 1) {
                    C4990ab.m7416i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                }
            }
            AppMethodBeat.m2505o(88600);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardNewMsgUI$b */
    class C11330b {
        ImageView knb;
        View knc;
        ImageView knd;
        TextView kne;
        TextView knf;
        TextView kng;
        TextView knh;
        TextView kni;
        View knj;
        TextView knk;
        LinearLayout knl;
        LinearLayout knm;

        private C11330b() {
        }

        /* synthetic */ C11330b(CardNewMsgUI cardNewMsgUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardNewMsgUI() {
        AppMethodBeat.m2504i(88610);
        AppMethodBeat.m2505o(88610);
    }

    /* renamed from: g */
    static /* synthetic */ void m19054g(CardNewMsgUI cardNewMsgUI) {
        AppMethodBeat.m2504i(88619);
        cardNewMsgUI.bbB();
        AppMethodBeat.m2505o(88619);
    }

    public final int getLayoutId() {
        return 2130968958;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88611);
        super.onCreate(bundle);
        initView();
        C42852am.bba().mo6829a((C2754a) this);
        C42852am.bba().baJ();
        AppMethodBeat.m2505o(88611);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88612);
        this.kmR.bIf();
        C42852am.bba().mo6832b(this);
        if (C42852am.baY().baS() > 0) {
            C42852am.baY().baT();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(88612);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88613);
        setMMTitle((int) C25738R.string.ag6);
        setBackBtn(new C113261());
        this.mListView = (ListView) findViewById(2131822244);
        this.kmR = new C11321a();
        this.mListView.setAdapter(this.kmR);
        this.mListView.setOnItemClickListener(new C113272());
        this.mListView.setOnItemLongClickListener(new C113193());
        this.mListView.setOnScrollListener(new C113204());
        this.kmR.mo74992a((C30723a) new C113255());
        addTextOptionMenu(0, getString(C25738R.string.acz), new C113246());
        this.f2895Ek = findViewById(2131821926);
        bbB();
        this.kmS = C5616v.m8409hu(this).inflate(2130968955, null);
        this.kmT = C5616v.m8409hu(this).inflate(2130970112, null);
        int baS = C42852am.baY().baS();
        if (baS > 0) {
            this.mListView.addFooterView(this.kmS);
            AppMethodBeat.m2505o(88613);
        } else if (this.kmR.bdn() || baS != 0 || C42852am.baY().getCount() <= 0) {
            if (this.kmR.bdn() && baS == 0) {
                C42852am.baY().getCount();
            }
            AppMethodBeat.m2505o(88613);
        } else {
            this.mListView.addFooterView(this.kmT);
            this.kmU = true;
            AppMethodBeat.m2505o(88613);
        }
    }

    private void bbB() {
        AppMethodBeat.m2504i(88614);
        if (C42852am.bba().getCount() > 0) {
            this.mListView.setVisibility(0);
            this.f2895Ek.setVisibility(8);
            enableOptionMenu(true);
        } else {
            this.mListView.setVisibility(8);
            this.f2895Ek.setVisibility(0);
            enableOptionMenu(false);
        }
        this.kmR.notifyDataSetChanged();
        AppMethodBeat.m2505o(88614);
    }

    /* renamed from: au */
    private void m19047au(String str, boolean z) {
        AppMethodBeat.m2504i(88615);
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        startActivity(intent);
        AppMethodBeat.m2505o(88615);
    }

    /* renamed from: a */
    public final void mo6836a(C38747g c38747g) {
        AppMethodBeat.m2504i(88616);
        if ((c38747g.field_msg_type & 1) == 0 || (c38747g.field_msg_type & 3) == 0) {
            AppMethodBeat.m2505o(88616);
            return;
        }
        bbB();
        this.kmR.mo5248a(null, null);
        AppMethodBeat.m2505o(88616);
    }

    public final void aVU() {
    }

    /* renamed from: a */
    static /* synthetic */ void m19046a(CardNewMsgUI cardNewMsgUI, int i) {
        AppMethodBeat.m2504i(88617);
        C38747g c38747g = (C38747g) cardNewMsgUI.kmR.getItem(i);
        if (c38747g != null) {
            int i2;
            if (c38747g.field_jump_type == 3) {
                if (!TextUtils.isEmpty(c38747g.field_card_id)) {
                    cardNewMsgUI.m19047au(c38747g.field_card_id, false);
                } else if (TextUtils.isEmpty(c38747g.field_card_tp_id)) {
                    C4990ab.m7412e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.m19047au(c38747g.field_card_tp_id, false);
                }
            } else if (c38747g.field_jump_type == 2) {
                if (TextUtils.isEmpty(c38747g.field_url)) {
                    C4990ab.m7412e("MicroMsg.CardNewMsgUI", "field_url is null");
                } else {
                    C45774b.m84626a((MMActivity) cardNewMsgUI, c38747g.field_url, 4);
                }
            } else if (c38747g.field_jump_type == 1) {
                C4990ab.m7416i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (c38747g.field_jump_type == 4) {
                if (!TextUtils.isEmpty(c38747g.field_card_id)) {
                    cardNewMsgUI.m19047au(c38747g.field_card_id, true);
                } else if (TextUtils.isEmpty(c38747g.field_card_tp_id)) {
                    C4990ab.m7412e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.m19047au(c38747g.field_card_tp_id, true);
                }
            }
            if (cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false)) {
                i2 = 7;
            } else {
                i2 = 1;
            }
            C7060h.pYm.mo8381e(11941, Integer.valueOf(i2), c38747g.field_card_id, c38747g.field_card_tp_id, c38747g.field_msg_id, "");
        }
        AppMethodBeat.m2505o(88617);
    }

    /* renamed from: b */
    static /* synthetic */ void m19048b(CardNewMsgUI cardNewMsgUI, final int i) {
        AppMethodBeat.m2504i(88618);
        C30379h.m48422a((Context) cardNewMsgUI, cardNewMsgUI.getResources().getString(C25738R.string.ag7), null, cardNewMsgUI.getResources().getString(C25738R.string.f9088p4), new C30391c() {
            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(88598);
                switch (i) {
                    case 0:
                        C38747g c38747g = (C38747g) CardNewMsgUI.this.kmR.getItem(i);
                        if (c38747g != null) {
                            C42852am.bba().mo6828Gr(c38747g.field_msg_id);
                            CardNewMsgUI.m19054g(CardNewMsgUI.this);
                            CardNewMsgUI.this.kmR.mo5248a(null, null);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(88598);
            }
        });
        AppMethodBeat.m2505o(88618);
    }

    /* renamed from: h */
    static /* synthetic */ void m19055h(CardNewMsgUI cardNewMsgUI) {
        AppMethodBeat.m2504i(88620);
        C42840d.m76034a(cardNewMsgUI, new C113288());
        AppMethodBeat.m2505o(88620);
    }
}
