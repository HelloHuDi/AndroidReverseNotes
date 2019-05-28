package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI extends MMActivity implements com.tencent.mm.plugin.card.b.k.a {
    private View Ek;
    OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(88600);
            g gVar;
            if (view.getId() == R.id.aho) {
                gVar = (g) view.getTag();
                if (gVar == null || gVar.baM() == null) {
                    AppMethodBeat.o(88600);
                    return;
                }
                h.pYm.e(11941, Integer.valueOf(2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, "");
                if (gVar.baM().kdC == 0) {
                    ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                    if (TextUtils.isEmpty(gVar.baM().url)) {
                        ab.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                        AppMethodBeat.o(88600);
                        return;
                    }
                    com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, gVar.baM().url, 2);
                    AppMethodBeat.o(88600);
                    return;
                }
                if (gVar.baM().kdC == 1) {
                    ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                    Intent intent = new Intent();
                    intent.putExtra("KEY_CARD_ID", gVar.field_card_id);
                    intent.putExtra("KEY_CARD_TP_ID", gVar.field_card_tp_id);
                    intent.setClass(CardNewMsgUI.this, CardShopUI.class);
                    CardNewMsgUI.this.startActivity(intent);
                    h.pYm.e(11324, "UsedStoresView", Integer.valueOf(gVar.field_card_type), gVar.field_card_tp_id, gVar.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
                }
                AppMethodBeat.o(88600);
                return;
            }
            if (view.getId() == R.id.ahs) {
                gVar = (g) view.getTag();
                if (gVar == null || gVar.baN() == null) {
                    AppMethodBeat.o(88600);
                    return;
                } else if (gVar.baN().type == 0) {
                    ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                    if (TextUtils.isEmpty(gVar.baN().url)) {
                        ab.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                        AppMethodBeat.o(88600);
                        return;
                    }
                    com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, gVar.baN().url, 2);
                    AppMethodBeat.o(88600);
                    return;
                } else if (gVar.baN().type == 1) {
                    ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                }
            }
            AppMethodBeat.o(88600);
        }
    };
    private a kmR;
    private View kmS;
    private View kmT = null;
    private boolean kmU = false;
    private ListView mListView;

    class a extends p<g> {
        private int enb = this.kmW;
        private int kmW = 10;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(88609);
            g gVar = (g) obj;
            if (gVar == null) {
                gVar = new g();
            }
            gVar.d(cursor);
            AppMethodBeat.o(88609);
            return gVar;
        }

        public a() {
            super(CardNewMsgUI.this, new g());
            AppMethodBeat.i(88603);
            pN(true);
            AppMethodBeat.o(88603);
        }

        public final void KC() {
            AppMethodBeat.i(88604);
            if (am.baY().baS() > 0) {
                setCursor(am.baY().bSd.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.enb = am.baY().getCount();
                com.tencent.mm.plugin.card.model.h baY = am.baY();
                setCursor(baY.bSd.rawQuery("select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.kmW)), null));
            }
            notifyDataSetChanged();
            AppMethodBeat.o(88604);
        }

        public final void KD() {
            AppMethodBeat.i(88605);
            bIf();
            KC();
            AppMethodBeat.o(88605);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int bdo() {
            AppMethodBeat.i(88606);
            if (bdn()) {
                if (CardNewMsgUI.this.kmT.getParent() != null) {
                    CardNewMsgUI.this.mListView.removeFooterView(CardNewMsgUI.this.kmT);
                }
                AppMethodBeat.o(88606);
                return 0;
            }
            this.kmW += 10;
            if (this.kmW <= this.enb) {
                AppMethodBeat.o(88606);
                return 10;
            }
            this.kmW = this.enb;
            int i = this.enb % 10;
            AppMethodBeat.o(88606);
            return i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(88607);
            g gVar = (g) getItem(i);
            if (view == null) {
                view = View.inflate(CardNewMsgUI.this.mController.ylL, R.layout.jk, null);
                b bVar2 = new b(CardNewMsgUI.this, (byte) 0);
                bVar2.knb = (ImageView) view.findViewById(R.id.ahm);
                bVar2.knc = view.findViewById(R.id.agy);
                bVar2.knd = (ImageView) view.findViewById(R.id.agz);
                bVar2.kne = (TextView) view.findViewById(R.id.qm);
                bVar2.knf = (TextView) view.findViewById(R.id.la);
                bVar2.kng = (TextView) view.findViewById(R.id.ahn);
                bVar2.knh = (TextView) view.findViewById(R.id.aho);
                bVar2.kni = (TextView) view.findViewById(R.id.ahr);
                bVar2.knj = view.findViewById(R.id.ahs);
                bVar2.knk = (TextView) view.findViewById(R.id.aht);
                bVar2.knl = (LinearLayout) view.findViewById(R.id.ahq);
                bVar2.knm = (LinearLayout) view.findViewById(R.id.ahp);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.kne.setText(gVar.field_title);
            bVar.knf.setText(com.tencent.mm.pluginsdk.f.h.c(CardNewMsgUI.this, ((long) gVar.field_time) * 1000, true));
            bVar.kng.setText(gVar.field_description);
            int dimensionPixelSize = CardNewMsgUI.this.getResources().getDimensionPixelSize(R.dimen.w9);
            ab.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " logo_url :  " + gVar.field_logo_url);
            if (TextUtils.isEmpty(gVar.field_logo_color)) {
                bVar.knc.setVisibility(8);
                bVar.knb.setVisibility(0);
                bVar.knb.setImageResource(R.drawable.bcm);
                m.a(bVar.knb, gVar.field_logo_url, dimensionPixelSize, (int) R.drawable.bcm, true);
            } else {
                ab.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " field_logo_color :  " + gVar.field_logo_color);
                bVar.knc.setVisibility(0);
                bVar.knb.setVisibility(8);
                if (TextUtils.isEmpty(gVar.field_logo_url)) {
                    m.a(bVar.knd, R.drawable.azs, l.Hn(gVar.field_logo_color));
                } else {
                    m.a(CardNewMsgUI.this, bVar.knd, gVar.field_logo_url, dimensionPixelSize, l.Hn(gVar.field_logo_color));
                }
            }
            nm baM = gVar.baM();
            if (baM == null || TextUtils.isEmpty(baM.text)) {
                bVar.knh.setVisibility(8);
            } else {
                bVar.knh.setText(baM.text);
                bVar.knh.setTag(gVar);
                bVar.knh.setVisibility(0);
                bVar.knh.setOnClickListener(CardNewMsgUI.this.gKK);
            }
            nz baN = gVar.baN();
            if (baN == null || TextUtils.isEmpty(baN.text)) {
                bVar.knj.setVisibility(8);
                bVar.kni.setVisibility(8);
            } else {
                bVar.knk.setText(baN.text);
                bVar.knj.setVisibility(0);
                bVar.knj.setOnClickListener(CardNewMsgUI.this.gKK);
                bVar.knj.setTag(gVar);
                bVar.kni.setVisibility(0);
            }
            gVar.baO();
            gVar.baP();
            a(gVar.kdv, gVar.kdw, bVar, gVar);
            AppMethodBeat.o(88607);
            return view;
        }

        private void a(List<com.tencent.mm.plugin.card.model.g.a> list, List<com.tencent.mm.plugin.card.model.g.b> list2, b bVar, final g gVar) {
            AppMethodBeat.i(88608);
            bVar.knl.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                bVar.knm.setVisibility(8);
                AppMethodBeat.o(88608);
                return;
            }
            int i;
            View inflate;
            Button button;
            if (!bo.ek(list)) {
                for (i = 0; i < list.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.a aVar = (com.tencent.mm.plugin.card.model.g.a) list.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.ylL, R.layout.hr, null);
                    if (i == 0) {
                        inflate.findViewById(R.id.a9u).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.id.a9v)).setText(aVar.title);
                    ((TextView) inflate.findViewById(R.id.a9w)).setText(aVar.jcF);
                    button = (Button) inflate.findViewById(R.id.a9x);
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(88601);
                            Intent intent = new Intent();
                            if (aVar.kdC == 0) {
                                intent.setClass(CardNewMsgUI.this.mController.ylL, CardDetailUI.class);
                                intent.putExtra("key_card_id", aVar.cardId);
                                intent.putExtra("key_card_ext", aVar.kdB);
                                intent.putExtra("key_from_scene", 17);
                                CardNewMsgUI.this.startActivity(intent);
                            } else if (aVar.kdC == 1) {
                                intent.setClass(CardNewMsgUI.this.mController.ylL, CardConsumeSuccessUI.class);
                                intent.putExtra("key_card_id", gVar.field_card_id);
                                intent.putExtra("key_from_scene", 2);
                                CardNewMsgUI.this.startActivity(intent);
                            }
                            h.pYm.e(11941, Integer.valueOf(8), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, aVar.cardId);
                            AppMethodBeat.o(88601);
                        }
                    });
                    if (aVar.kdC == 0) {
                        button.setText(R.string.acb);
                    } else if (aVar.kdC == 1) {
                        button.setText(R.string.acc);
                    }
                    bVar.knl.addView(inflate);
                }
            }
            if (!bo.ek(list2)) {
                for (i = 0; i < list2.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.b bVar2 = (com.tencent.mm.plugin.card.model.g.b) list2.get(i);
                    inflate = View.inflate(CardNewMsgUI.this.mController.ylL, R.layout.hr, null);
                    if (i == 0 && bo.ek(list)) {
                        inflate.findViewById(R.id.a9u).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.id.a9v)).setText(bVar2.title);
                    ((TextView) inflate.findViewById(R.id.a9w)).setText(bVar2.description);
                    button = (Button) inflate.findViewById(R.id.a9x);
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(88602);
                            if (TextUtils.isEmpty(bVar2.kdF)) {
                                ab.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                                AppMethodBeat.o(88602);
                                return;
                            }
                            com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, bVar2.kdF, 2);
                            AppMethodBeat.o(88602);
                        }
                    });
                    button.setText(bVar2.kdE);
                    bVar.knl.addView(inflate);
                }
            }
            bVar.knm.setVisibility(0);
            AppMethodBeat.o(88608);
        }
    }

    class b {
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

        private b() {
        }

        /* synthetic */ b(CardNewMsgUI cardNewMsgUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardNewMsgUI() {
        AppMethodBeat.i(88610);
        AppMethodBeat.o(88610);
    }

    static /* synthetic */ void g(CardNewMsgUI cardNewMsgUI) {
        AppMethodBeat.i(88619);
        cardNewMsgUI.bbB();
        AppMethodBeat.o(88619);
    }

    public final int getLayoutId() {
        return R.layout.jm;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88611);
        super.onCreate(bundle);
        initView();
        am.bba().a((com.tencent.mm.plugin.card.b.k.a) this);
        am.bba().baJ();
        AppMethodBeat.o(88611);
    }

    public void onDestroy() {
        AppMethodBeat.i(88612);
        this.kmR.bIf();
        am.bba().b(this);
        if (am.baY().baS() > 0) {
            am.baY().baT();
        }
        super.onDestroy();
        AppMethodBeat.o(88612);
    }

    public final void initView() {
        AppMethodBeat.i(88613);
        setMMTitle((int) R.string.ag6);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88592);
                CardNewMsgUI.this.finish();
                AppMethodBeat.o(88592);
                return true;
            }
        });
        this.mListView = (ListView) findViewById(R.id.ahx);
        this.kmR = new a();
        this.mListView.setAdapter(this.kmR);
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(88593);
                if (i == CardNewMsgUI.this.kmR.getCount()) {
                    int i2 = 1;
                    if (am.baY().baS() > 0) {
                        am.baY().baT();
                    } else {
                        i2 = CardNewMsgUI.this.kmR.bdo();
                    }
                    CardNewMsgUI.this.kmR.a(null, null);
                    if (!CardNewMsgUI.this.kmU) {
                        if (CardNewMsgUI.this.kmS.getParent() != null) {
                            ab.d("MicroMsg.CardNewMsgUI", "remove footer");
                            CardNewMsgUI.this.mListView.removeFooterView(CardNewMsgUI.this.kmS);
                        }
                        if (!CardNewMsgUI.this.kmR.bdn() && CardNewMsgUI.this.kmT.getParent() == null && i2 > 0) {
                            CardNewMsgUI.this.mListView.addFooterView(CardNewMsgUI.this.kmT);
                            ab.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                        }
                    }
                    CardNewMsgUI.this.kmU = true;
                    CardNewMsgUI.this.kmS.setVisibility(8);
                    AppMethodBeat.o(88593);
                    return;
                }
                CardNewMsgUI.a(CardNewMsgUI.this, i);
                AppMethodBeat.o(88593);
            }
        });
        this.mListView.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(88594);
                CardNewMsgUI.b(CardNewMsgUI.this, i);
                AppMethodBeat.o(88594);
                return true;
            }
        });
        this.mListView.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(88595);
                if (!CardNewMsgUI.this.kmU) {
                    AppMethodBeat.o(88595);
                } else if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (am.baY().baS() > 0) {
                        am.baY().baT();
                    } else {
                        CardNewMsgUI.this.kmR.bdo();
                    }
                    CardNewMsgUI.this.kmR.a(null, null);
                    AppMethodBeat.o(88595);
                } else {
                    AppMethodBeat.o(88595);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.kmR.a((com.tencent.mm.ui.p.a) new com.tencent.mm.ui.p.a() {
            public final void apt() {
                AppMethodBeat.i(88596);
                CardNewMsgUI.g(CardNewMsgUI.this);
                if (CardNewMsgUI.this.kmR.bdn() && am.baY().baS() == 0) {
                    CardNewMsgUI.this.kmS.setVisibility(8);
                }
                AppMethodBeat.o(88596);
            }
        });
        addTextOptionMenu(0, getString(R.string.acz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88597);
                h.pYm.e(11582, "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "");
                CardNewMsgUI.h(CardNewMsgUI.this);
                AppMethodBeat.o(88597);
                return true;
            }
        });
        this.Ek = findViewById(R.id.a_b);
        bbB();
        this.kmS = v.hu(this).inflate(R.layout.jj, null);
        this.kmT = v.hu(this).inflate(R.layout.adp, null);
        int baS = am.baY().baS();
        if (baS > 0) {
            this.mListView.addFooterView(this.kmS);
            AppMethodBeat.o(88613);
        } else if (this.kmR.bdn() || baS != 0 || am.baY().getCount() <= 0) {
            if (this.kmR.bdn() && baS == 0) {
                am.baY().getCount();
            }
            AppMethodBeat.o(88613);
        } else {
            this.mListView.addFooterView(this.kmT);
            this.kmU = true;
            AppMethodBeat.o(88613);
        }
    }

    private void bbB() {
        AppMethodBeat.i(88614);
        if (am.bba().getCount() > 0) {
            this.mListView.setVisibility(0);
            this.Ek.setVisibility(8);
            enableOptionMenu(true);
        } else {
            this.mListView.setVisibility(8);
            this.Ek.setVisibility(0);
            enableOptionMenu(false);
        }
        this.kmR.notifyDataSetChanged();
        AppMethodBeat.o(88614);
    }

    private void au(String str, boolean z) {
        AppMethodBeat.i(88615);
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        startActivity(intent);
        AppMethodBeat.o(88615);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(88616);
        if ((gVar.field_msg_type & 1) == 0 || (gVar.field_msg_type & 3) == 0) {
            AppMethodBeat.o(88616);
            return;
        }
        bbB();
        this.kmR.a(null, null);
        AppMethodBeat.o(88616);
    }

    public final void aVU() {
    }

    static /* synthetic */ void a(CardNewMsgUI cardNewMsgUI, int i) {
        AppMethodBeat.i(88617);
        g gVar = (g) cardNewMsgUI.kmR.getItem(i);
        if (gVar != null) {
            int i2;
            if (gVar.field_jump_type == 3) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.au(gVar.field_card_id, false);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    ab.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.au(gVar.field_card_tp_id, false);
                }
            } else if (gVar.field_jump_type == 2) {
                if (TextUtils.isEmpty(gVar.field_url)) {
                    ab.e("MicroMsg.CardNewMsgUI", "field_url is null");
                } else {
                    com.tencent.mm.plugin.card.d.b.a((MMActivity) cardNewMsgUI, gVar.field_url, 4);
                }
            } else if (gVar.field_jump_type == 1) {
                ab.i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (gVar.field_jump_type == 4) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.au(gVar.field_card_id, true);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    ab.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.au(gVar.field_card_tp_id, true);
                }
            }
            if (cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false)) {
                i2 = 7;
            } else {
                i2 = 1;
            }
            h.pYm.e(11941, Integer.valueOf(i2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, "");
        }
        AppMethodBeat.o(88617);
    }

    static /* synthetic */ void b(CardNewMsgUI cardNewMsgUI, final int i) {
        AppMethodBeat.i(88618);
        com.tencent.mm.ui.base.h.a((Context) cardNewMsgUI, cardNewMsgUI.getResources().getString(R.string.ag7), null, cardNewMsgUI.getResources().getString(R.string.p4), new c() {
            public final void iE(int i) {
                AppMethodBeat.i(88598);
                switch (i) {
                    case 0:
                        g gVar = (g) CardNewMsgUI.this.kmR.getItem(i);
                        if (gVar != null) {
                            am.bba().Gr(gVar.field_msg_id);
                            CardNewMsgUI.g(CardNewMsgUI.this);
                            CardNewMsgUI.this.kmR.a(null, null);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(88598);
            }
        });
        AppMethodBeat.o(88618);
    }

    static /* synthetic */ void h(CardNewMsgUI cardNewMsgUI) {
        AppMethodBeat.i(88620);
        d.a(cardNewMsgUI, new com.tencent.mm.plugin.card.d.d.a() {
            public final void bdj() {
                AppMethodBeat.i(88599);
                k bba = am.bba();
                if (bba.kbM.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(bba.kbM);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        g gVar = (g) arrayList.get(i2);
                        if (gVar != null) {
                            bba.kbM.remove(gVar);
                            k.d(gVar);
                        }
                        i = i2 + 1;
                    }
                    arrayList.clear();
                }
                CardNewMsgUI.g(CardNewMsgUI.this);
                CardNewMsgUI.this.kmR.a(null, null);
                AppMethodBeat.o(88599);
            }
        });
        AppMethodBeat.o(88620);
    }
}
