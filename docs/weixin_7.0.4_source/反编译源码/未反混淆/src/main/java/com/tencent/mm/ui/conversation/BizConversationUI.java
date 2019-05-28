package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.o;
import com.tencent.mm.aj.x;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class BizConversationUI extends BaseConversationUI {
    private View contentView;

    public static class BizConversationFmUI extends BaseConversationFmUI {
        private ak conversation;
        private int cvd = 1;
        private TextView emptyTipTv;
        private String fuO;
        private boolean isDeleteCancel = false;
        private int jLX = 0;
        private int jLY = 0;
        private com.tencent.mm.ui.widget.b.a jMO;
        private long jOA = 0;
        private c jOJ = new c<k>() {
            {
                AppMethodBeat.i(34126);
                this.xxI = k.class.getName().hashCode();
                AppMethodBeat.o(34126);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(34127);
                k kVar = (k) bVar;
                if (!(kVar == null || kVar.csh == null || kVar.csh.csi)) {
                    BizConversationFmUI.this.jOA = 0;
                }
                AppMethodBeat.o(34127);
                return false;
            }
        };
        private d jOb = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(34125);
                switch (menuItem.getItemId()) {
                    case 1:
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(BizConversationFmUI.this.talker);
                        if (aoO == null) {
                            ab.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationFmUI.this.talker);
                            AppMethodBeat.o(34125);
                            return;
                        } else if (aoO.Oe()) {
                            h.pYm.e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2));
                            t.x(BizConversationFmUI.this.talker, true);
                            AppMethodBeat.o(34125);
                            return;
                        } else {
                            h.pYm.e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
                            t.w(BizConversationFmUI.this.talker, true);
                            AppMethodBeat.o(34125);
                            return;
                        }
                    case 2:
                        aw.ZK();
                        com.tencent.mm.ui.tools.b.a(z.aeR().qP(BizConversationFmUI.this.talker), BizConversationFmUI.this.thisActivity(), com.tencent.mm.model.c.XM().aoO(BizConversationFmUI.this.talker), 2);
                        AppMethodBeat.o(34125);
                        return;
                    case 3:
                        BizConversationFmUI.b(BizConversationFmUI.this, BizConversationFmUI.this.talker);
                        break;
                }
                AppMethodBeat.o(34125);
            }
        };
        private String talker = "";
        private p tipDialog = null;
        private ListView zqO;
        private a zqP;
        private String zqQ;

        static class a extends e {
            private String cIe;
            HashMap<String, b> jOf = new HashMap();

            public a(Context context, String str, com.tencent.mm.ui.p.a aVar) {
                super(context, aVar);
                AppMethodBeat.i(34136);
                this.cIe = str;
                AppMethodBeat.o(34136);
            }

            public final void KC() {
                AppMethodBeat.i(34137);
                aw.ZK();
                setCursor(com.tencent.mm.model.c.XR().c(t.fkP, this.elZ, this.cIe));
                if (this.yle != null) {
                    this.yle.apt();
                }
                super.notifyDataSetChanged();
                AppMethodBeat.o(34137);
            }

            /* Access modifiers changed, original: protected|final */
            public final void a(ak akVar, boolean z, int i, boolean z2) {
                AppMethodBeat.i(34138);
                if (akVar == null) {
                    AppMethodBeat.o(34138);
                    return;
                }
                b bVar;
                b bVar2 = (b) this.jOf.get(akVar.field_username);
                if (bVar2 == null) {
                    bVar2 = new b();
                    this.jOf.put(akVar.field_username, bVar2);
                    bVar = bVar2;
                } else {
                    bVar = bVar2;
                }
                if (bVar.fPZ > 0) {
                    AppMethodBeat.o(34138);
                    return;
                }
                bVar.wTL = z;
                boolean z3 = bVar.wTO || akVar.field_unReadCount > 0;
                bVar.wTO = z3;
                bVar.ndr = i + 1;
                if (z2) {
                    bVar.fPZ = bVar.ndr;
                }
                bVar.wTN = (int) (System.currentTimeMillis() / 1000);
                if (akVar.field_lastSeq == bVar.wYf) {
                    AppMethodBeat.o(34138);
                    return;
                }
                bVar.wYf = akVar.field_lastSeq;
                bi Rb = ((j) g.K(j.class)).bOr().Rb(akVar.field_username);
                if (Rb != null && Rb.drC()) {
                    o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(Rb.field_msgId, Rb.field_content);
                    if (!(b == null || bo.ek(b.fjr) || bo.isNullOrNil(((com.tencent.mm.af.p) b.fjr.get(0)).url))) {
                        try {
                            Uri parse = Uri.parse(((com.tencent.mm.af.p) b.fjr.get(0)).url);
                            bVar.wTJ = bo.getLong(parse.getQueryParameter("mid"), 0);
                            bVar.wTK = bo.getInt(parse.getQueryParameter("idx"), 0);
                            AppMethodBeat.o(34138);
                            return;
                        } catch (UnsupportedOperationException e) {
                            ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e.getMessage());
                            AppMethodBeat.o(34138);
                            return;
                        } catch (Exception e2) {
                            ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e2.getMessage());
                        }
                    }
                }
                AppMethodBeat.o(34138);
            }

            public final void a(ak akVar, int i) {
                AppMethodBeat.i(34139);
                aw.ZK();
                a(akVar, com.tencent.mm.model.c.XR().g(akVar), i, true);
                AppMethodBeat.o(34139);
            }
        }

        static class b extends brm {
            public int fPZ;
            public long wYf;

            private b() {
                this.fPZ = -1;
            }

            /* synthetic */ b(byte b) {
                this();
            }
        }

        public BizConversationFmUI() {
            AppMethodBeat.i(34140);
            AppMethodBeat.o(34140);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(34141);
            super.onActivityCreated(bundle);
            this.fuO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
            if (bo.isNullOrNil(this.fuO)) {
                this.fuO = "officialaccounts";
            }
            this.cvd = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
            if (bo.nullAsNil(this.fuO).equals("officialaccounts")) {
                h.pYm.e(11404, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.cvd));
            }
            this.zqQ = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
            if (bo.isNullOrNil(this.zqQ)) {
                this.zqQ = getString(R.string.a9e);
            }
            setMMTitle(this.zqQ);
            this.zqO = (ListView) findViewById(R.id.bi5);
            this.emptyTipTv = (TextView) findViewById(R.id.a74);
            this.emptyTipTv.setText(R.string.bd8);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(34130);
                    BizConversationFmUI.this.finish();
                    AppMethodBeat.o(34130);
                    return true;
                }
            });
            setToTop(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34131);
                    com.tencent.mm.platformtools.b.b.a(BizConversationFmUI.this.zqO);
                    AppMethodBeat.o(34131);
                }
            });
            this.zqP = new a(thisActivity(), this.fuO, new com.tencent.mm.ui.p.a() {
                public final void apt() {
                    AppMethodBeat.i(34132);
                    BizConversationFmUI.a(BizConversationFmUI.this, BizConversationFmUI.this.zqP.getCount());
                    AppMethodBeat.o(34132);
                }
            });
            this.zqP.setGetViewPositionCallback(new MMSlideDelView.c() {
                public final int cZ(View view) {
                    AppMethodBeat.i(34133);
                    int positionForView = BizConversationFmUI.this.zqO.getPositionForView(view);
                    AppMethodBeat.o(34133);
                    return positionForView;
                }
            });
            this.zqP.setPerformItemClickListener(new MMSlideDelView.g() {
                public final void q(View view, int i, int i2) {
                    AppMethodBeat.i(34134);
                    BizConversationFmUI.this.zqO.performItemClick(view, i, (long) i2);
                    AppMethodBeat.o(34134);
                }
            });
            this.zqO.setAdapter(this.zqP);
            this.jMO = new com.tencent.mm.ui.widget.b.a(thisActivity());
            this.zqO.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(34135);
                    BizConversationFmUI.this.conversation = (ak) BizConversationFmUI.this.zqP.getItem(i);
                    BizConversationFmUI.this.talker = BizConversationFmUI.this.conversation.field_username;
                    ak f = BizConversationFmUI.this.conversation;
                    if (f == null) {
                        ab.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(BizConversationFmUI.this.zqP.getCount()));
                        BizConversationFmUI.this.zqP.notifyDataSetChanged();
                        AppMethodBeat.o(34135);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("biz_click_item_unread_count", BizConversationFmUI.this.conversation.field_unReadCount);
                    bundle.putInt("biz_click_item_position", i + 1);
                    bundle.putInt("KOpenArticleSceneFromScene", 131);
                    bundle.putInt("specific_chat_from_scene", 1);
                    BizConversationFmUI.this.ui.startChatting(f.field_username, bundle, true);
                    BizConversationFmUI.this.zqP.a(f, i);
                    AppMethodBeat.o(34135);
                }
            });
            this.zqO.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(34117);
                    switch (motionEvent.getAction()) {
                        case 0:
                            BizConversationFmUI.this.jLX = (int) motionEvent.getRawX();
                            BizConversationFmUI.this.jLY = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(34117);
                    return false;
                }
            });
            this.zqO.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(34118);
                    BizConversationFmUI.this.conversation = (ak) BizConversationFmUI.this.zqP.getItem(i);
                    BizConversationFmUI.this.talker = BizConversationFmUI.this.conversation.field_username;
                    BizConversationFmUI.this.jMO.a(view, i, j, BizConversationFmUI.this, BizConversationFmUI.this.jOb, BizConversationFmUI.this.jLX, BizConversationFmUI.this.jLY);
                    AppMethodBeat.o(34118);
                    return true;
                }
            });
            this.zqP.setGetViewPositionCallback(new MMSlideDelView.c() {
                public final int cZ(View view) {
                    AppMethodBeat.i(34119);
                    int positionForView = BizConversationFmUI.this.zqO.getPositionForView(view);
                    AppMethodBeat.o(34119);
                    return positionForView;
                }
            });
            this.zqP.setPerformItemClickListener(new MMSlideDelView.g() {
                public final void q(View view, int i, int i2) {
                    AppMethodBeat.i(34120);
                    BizConversationFmUI.this.zqO.performItemClick(view, i, (long) i2);
                    AppMethodBeat.o(34120);
                }
            });
            this.zqP.a((f) new f() {
                public final void bN(Object obj) {
                    AppMethodBeat.i(34121);
                    if (obj == null) {
                        ab.e("MicroMsg.BizConversationUI", "onItemDel object null");
                        AppMethodBeat.o(34121);
                        return;
                    }
                    BizConversationFmUI.b(BizConversationFmUI.this, obj.toString());
                    AppMethodBeat.o(34121);
                }
            });
            if ("officialaccounts".equals(this.fuO)) {
                com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100045");
                boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpenSearch"));
                ab.d("MicroMsg.BizConversationUI", "open search entrance:%b", Boolean.valueOf(z));
                if (z) {
                    addIconOptionMenu(1, (int) R.string.ewn, (int) R.raw.actionbar_icon_dark_search, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(34116);
                            if (aa.HU(0)) {
                                ((m) g.K(m.class)).a(ah.getContext(), new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(34115);
                                        Intent cVd = aa.cVd();
                                        cVd.putExtra("title", BizConversationFmUI.this.getString(R.string.c2b));
                                        cVd.putExtra("searchbar_tips", BizConversationFmUI.this.getString(R.string.c2b));
                                        cVd.putExtra("KRightBtn", true);
                                        cVd.putExtra("ftsneedkeyboard", true);
                                        cVd.putExtra("publishIdPrefix", "bs");
                                        cVd.putExtra("ftsType", 2);
                                        cVd.putExtra("ftsbizscene", 11);
                                        Map d = aa.d(11, true, 2);
                                        String HP = aa.HP(bo.ank((String) d.get("scene")));
                                        d.put("sessionId", HP);
                                        cVd.putExtra("sessionId", HP);
                                        cVd.putExtra("rawUrl", aa.E(d));
                                        cVd.putExtra("key_load_js_without_delay", true);
                                        cVd.addFlags(67108864);
                                        Bundle bundle = null;
                                        if (VERSION.SDK_INT >= 21) {
                                            bundle = ActivityOptions.makeSceneTransitionAnimation(BizConversationFmUI.this.thisActivity(), new Pair[0]).toBundle();
                                        }
                                        com.tencent.mm.bp.d.a(BizConversationFmUI.this.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
                                        AppMethodBeat.o(34115);
                                    }
                                });
                            } else {
                                ab.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
                            }
                            AppMethodBeat.o(34116);
                            return true;
                        }
                    });
                }
            }
            aw.ZK();
            com.tencent.mm.model.c.XR().a(this.zqP);
            this.jOA = System.currentTimeMillis();
            com.tencent.mm.sdk.b.a.xxA.c(this.jOJ);
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(34128);
                    Looper.myQueue().removeIdleHandler(this);
                    com.tencent.mm.cj.c.aNX();
                    AppMethodBeat.o(34128);
                    return false;
                }
            });
            AppMethodBeat.o(34141);
        }

        public int getLayoutId() {
            return R.layout.azr;
        }

        public String getUserName() {
            return this.fuO;
        }

        public void onDestroy() {
            AppMethodBeat.i(34142);
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34129);
                    BizConversationFmUI.a(BizConversationFmUI.this);
                    BizConversationFmUI.b(BizConversationFmUI.this);
                    BizConversationFmUI.c(BizConversationFmUI.this);
                    AppMethodBeat.o(34129);
                }
            });
            com.tencent.mm.sdk.b.a.xxA.d(this.jOJ);
            if (aw.RK()) {
                aw.ZK();
                com.tencent.mm.model.c.XR().b(this.zqP);
            }
            if (this.zqP != null) {
                this.zqP.onDestroy();
            }
            super.onDestroy();
            AppMethodBeat.o(34142);
        }

        public void onResume() {
            AppMethodBeat.i(34143);
            ab.v("MicroMsg.BizConversationUI", "on resume");
            if (this.zqP != null) {
                this.zqP.onResume();
            }
            super.onResume();
            AppMethodBeat.o(34143);
        }

        public void onPause() {
            AppMethodBeat.i(34144);
            ab.i("MicroMsg.BizConversationUI", "on pause");
            aw.ZK();
            com.tencent.mm.model.c.XR().apb(this.fuO);
            if (this.zqP != null) {
                this.zqP.onPause();
            }
            super.onPause();
            AppMethodBeat.o(34144);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(34145);
            super.onActivityResult(i, i2, intent);
            if (!(this.talker == null || this.talker.isEmpty())) {
                this.talker = "";
            }
            if (i2 != -1) {
                AppMethodBeat.o(34145);
            } else {
                AppMethodBeat.o(34145);
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(34146);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(this.talker);
            if (aoO == null) {
                ab.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
                AppMethodBeat.o(34146);
                return;
            }
            CharSequence Oj = aoO.Oj();
            if (Oj.toLowerCase().endsWith("@chatroom") && bo.isNullOrNil(aoO.field_nickname)) {
                Oj = getString(R.string.ao1);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.e.j.b(thisActivity(), Oj));
            if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                if (aoO.Oe()) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.cvm);
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.b1r);
                }
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.cvi);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.cvq);
            AppMethodBeat.o(34146);
        }

        static /* synthetic */ void a(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.i(34147);
            if (aw.RK() && "officialaccounts".equals(bizConversationFmUI.fuO)) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                long j = 0;
                int i4 = 0;
                StringBuilder stringBuilder = new StringBuilder("");
                aw.ZK();
                Cursor c = com.tencent.mm.model.c.XR().c(t.fkP, null, bizConversationFmUI.fuO);
                if (c != null) {
                    int columnIndex = c.getColumnIndex("unReadCount");
                    int columnIndex2 = c.getColumnIndex("conversationTime");
                    int columnIndex3 = c.getColumnIndex("flag");
                    int count = c.getCount();
                    ak akVar = new ak();
                    while (c.moveToNext()) {
                        akVar.eE(c.getLong(columnIndex3));
                        i4 = c.getInt(columnIndex);
                        if (i4 > 0) {
                            j = c.getLong(columnIndex2);
                            i2++;
                            i += i4;
                        } else {
                            i4 = 0;
                        }
                        stringBuilder.append(c.isFirst() ? "" : ".").append(i4);
                        aw.ZK();
                        if (com.tencent.mm.model.c.XR().g(akVar)) {
                            i3++;
                        }
                    }
                    c.close();
                    i4 = count;
                }
                h.pYm.e(13771, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j / 1000), Integer.valueOf(i3), stringBuilder.toString());
                ab.v("MicroMsg.BizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(34147);
                return;
            }
            AppMethodBeat.o(34147);
        }

        static /* synthetic */ void b(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.i(34148);
            if (bizConversationFmUI.jOA != 0 && "officialaccounts".equals(bizConversationFmUI.fuO)) {
                h.pYm.e(13932, Integer.valueOf(((int) (System.currentTimeMillis() - bizConversationFmUI.jOA)) / 1000), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bizConversationFmUI.cvd));
            }
            AppMethodBeat.o(34148);
        }

        static /* synthetic */ void c(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.i(34149);
            if (bizConversationFmUI.zqP != null) {
                LinkedList linkedList = new LinkedList();
                for (Entry entry : bizConversationFmUI.zqP.jOf.entrySet()) {
                    boolean z;
                    b bVar = (b) entry.getValue();
                    brm brm = new brm();
                    brm.vMR = (String) entry.getKey();
                    brm.wTJ = bVar.wTJ;
                    brm.wTK = bVar.wTK;
                    brm.ndr = bVar.ndr;
                    if (bVar.fPZ > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    brm.wTM = z;
                    brm.wTO = bVar.wTO;
                    brm.wTL = bVar.wTL;
                    brm.wTN = bVar.wTN;
                    linkedList.add(brm);
                }
                g.RO().eJo.a(new x(linkedList), 0);
                ab.d("MicroMsg.BizConversationUI", "reportExpose size:%d", Integer.valueOf(linkedList.size()));
            }
            AppMethodBeat.o(34149);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34152);
        super.onCreate(bundle);
        if (aw.RK()) {
            this.contentView = v.hu(this).inflate(R.layout.hj, null);
            setContentView(this.contentView);
            this.conversationFm = new BizConversationFmUI();
            getSupportFragmentManager().beginTransaction().a((int) R.id.a9e, this.conversationFm).commit();
            com.tencent.mm.pluginsdk.f.a(this, this.contentView);
            AppMethodBeat.o(34152);
            return;
        }
        ab.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
        finish();
        AppMethodBeat.o(34152);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(34153);
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.f.a(this, this.contentView);
        AppMethodBeat.o(34153);
    }
}
