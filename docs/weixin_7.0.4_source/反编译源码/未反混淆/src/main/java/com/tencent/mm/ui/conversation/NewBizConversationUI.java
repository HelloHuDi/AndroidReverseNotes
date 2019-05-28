package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
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
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class NewBizConversationUI extends MMActivity {
    private ak conversation;
    private int ctE;
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
            AppMethodBeat.i(34542);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(34542);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(34543);
            k kVar = (k) bVar;
            if (!(kVar == null || kVar.csh == null || kVar.csh.csi)) {
                NewBizConversationUI.this.jOA = 0;
            }
            AppMethodBeat.o(34543);
            return false;
        }
    };
    private d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(34541);
            switch (menuItem.getItemId()) {
                case 1:
                    aw.ZK();
                    ad aoO = com.tencent.mm.model.c.XM().aoO(NewBizConversationUI.this.talker);
                    if (aoO == null) {
                        ab.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.this.talker);
                        AppMethodBeat.o(34541);
                        return;
                    }
                    if (aoO.Oe()) {
                        h.pYm.e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2));
                        t.x(NewBizConversationUI.this.talker, true);
                    } else {
                        h.pYm.e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
                        t.w(NewBizConversationUI.this.talker, true);
                    }
                    ai aiVar = new ai();
                    aiVar.ctg.userName = aoO.field_username;
                    com.tencent.mm.sdk.b.a.xxA.m(aiVar);
                    AppMethodBeat.o(34541);
                    return;
                case 2:
                    aw.ZK();
                    com.tencent.mm.ui.tools.b.a(z.aeR().qP(NewBizConversationUI.this.talker), NewBizConversationUI.this, com.tencent.mm.model.c.XM().aoO(NewBizConversationUI.this.talker), 2);
                    AppMethodBeat.o(34541);
                    return;
                case 3:
                    NewBizConversationUI.b(NewBizConversationUI.this, NewBizConversationUI.this.talker);
                    break;
            }
            AppMethodBeat.o(34541);
        }
    };
    private String talker = "";
    private p tipDialog = null;
    private ListView zqO;
    private String zqQ;
    private a zvk;
    private final int zvl = 1;

    static class a extends e {
        private String cIe;
        HashMap<String, b> jOf = new HashMap();

        public a(Context context, String str, com.tencent.mm.ui.p.a aVar) {
            super(context, aVar);
            AppMethodBeat.i(34554);
            this.cIe = str;
            AppMethodBeat.o(34554);
        }

        public final void KC() {
            AppMethodBeat.i(34555);
            aw.ZK();
            setCursor(com.tencent.mm.model.c.XR().c(t.fkP, this.elZ, this.cIe));
            if (this.yle != null) {
                this.yle.apt();
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(34555);
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(ak akVar, boolean z, int i, boolean z2) {
            AppMethodBeat.i(34556);
            if (akVar == null) {
                AppMethodBeat.o(34556);
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
                AppMethodBeat.o(34556);
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
                AppMethodBeat.o(34556);
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
                        AppMethodBeat.o(34556);
                        return;
                    } catch (UnsupportedOperationException e) {
                        ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e.getMessage());
                        AppMethodBeat.o(34556);
                        return;
                    } catch (Exception e2) {
                        ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e2.getMessage());
                    }
                }
            }
            AppMethodBeat.o(34556);
        }

        public final void a(ak akVar, int i) {
            AppMethodBeat.i(34557);
            aw.ZK();
            a(akVar, com.tencent.mm.model.c.XR().g(akVar), i, true);
            AppMethodBeat.o(34557);
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NewBizConversationUI() {
        AppMethodBeat.i(34558);
        AppMethodBeat.o(34558);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34559);
        super.onCreate(bundle);
        if (aw.RK()) {
            this.ctE = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
            this.cvd = getIntent().getIntExtra("biz_enter_source", 1);
            this.fuO = "officialaccounts";
            h.pYm.e(11404, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.ctE), Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.cvd));
            this.zqQ = getIntent().getStringExtra("enterprise_biz_display_name");
            if (bo.isNullOrNil(this.zqQ)) {
                this.zqQ = getString(R.string.a9e);
            }
            initView();
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100045");
            boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpenSearch"));
            ab.d("MicroMsg.NewBizConversationUI", "open search entrance:%b", Boolean.valueOf(z));
            if (z) {
                addIconOptionMenu(1, R.string.ewn, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(34532);
                        if (aa.HU(0)) {
                            ((m) g.K(m.class)).a(ah.getContext(), new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(34531);
                                    Intent cVd = aa.cVd();
                                    cVd.putExtra("title", NewBizConversationUI.this.getString(R.string.c2b));
                                    cVd.putExtra("searchbar_tips", NewBizConversationUI.this.getString(R.string.c2b));
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
                                        bundle = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.this, new Pair[0]).toBundle();
                                    }
                                    String adN = ac.adN("bizAccountTopSearch");
                                    if (!TextUtils.isEmpty(adN)) {
                                        cVd.putExtra("key_search_input_hint", adN);
                                    }
                                    com.tencent.mm.bp.d.a(NewBizConversationUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
                                    AppMethodBeat.o(34531);
                                }
                            });
                        } else {
                            ab.e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
                        }
                        AppMethodBeat.o(34532);
                        return true;
                    }
                });
            }
            b(getString(R.string.a_c), (int) R.raw.actionbar_icon_dark_more, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(34546);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(NewBizConversationUI.this, 1, false);
                    dVar.rBl = new n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(34544);
                            lVar.hi(1, R.string.a__);
                            AppMethodBeat.o(34544);
                        }
                    };
                    dVar.rBm = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(34545);
                            switch (menuItem.getItemId()) {
                                case 1:
                                    Intent intent = new Intent(NewBizConversationUI.this.mController.ylL, BizTimeLineNewMsgUI.class);
                                    intent.putExtra("biz_time_line_line_enter_scene", 2);
                                    NewBizConversationUI.this.startActivity(intent);
                                    AppMethodBeat.o(34545);
                                    return;
                                default:
                                    ab.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                                    AppMethodBeat.o(34545);
                                    return;
                            }
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(34546);
                    return true;
                }
            });
            aw.ZK();
            com.tencent.mm.model.c.XR().a(this.zvk);
            this.jOA = System.currentTimeMillis();
            com.tencent.mm.sdk.b.a.xxA.c(this.jOJ);
            AppMethodBeat.o(34559);
            return;
        }
        ab.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
        finish();
        AppMethodBeat.o(34559);
    }

    public final int getLayoutId() {
        return R.layout.azr;
    }

    private void initActionBar() {
        AppMethodBeat.i(34560);
        xE(-1052684);
        setMMTitle(this.zqQ);
        ta(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34547);
                NewBizConversationUI.this.finish();
                AppMethodBeat.o(34547);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        setTitleBarDoubleClickListener(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34548);
                if (NewBizConversationUI.this.uiu || NewBizConversationUI.this.isFinishing()) {
                    AppMethodBeat.o(34548);
                    return;
                }
                NewBizConversationUI.a(NewBizConversationUI.this);
                AppMethodBeat.o(34548);
            }
        });
        AppMethodBeat.o(34560);
    }

    public void onDestroy() {
        AppMethodBeat.i(34561);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34549);
                NewBizConversationUI.b(NewBizConversationUI.this);
                NewBizConversationUI.c(NewBizConversationUI.this);
                NewBizConversationUI.d(NewBizConversationUI.this);
                AppMethodBeat.o(34549);
            }
        });
        com.tencent.mm.sdk.b.a.xxA.d(this.jOJ);
        if (aw.RK()) {
            aw.ZK();
            com.tencent.mm.model.c.XR().b(this.zvk);
        }
        if (this.zvk != null) {
            this.zvk.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(34561);
    }

    public void onResume() {
        AppMethodBeat.i(34562);
        ab.v("MicroMsg.NewBizConversationUI", "on resume");
        if (this.zvk != null) {
            this.zvk.onResume();
        }
        super.onResume();
        AppMethodBeat.o(34562);
    }

    public void onPause() {
        AppMethodBeat.i(34563);
        ab.i("MicroMsg.NewBizConversationUI", "on pause");
        if (this.zvk != null) {
            this.zvk.onPause();
        }
        super.onPause();
        AppMethodBeat.o(34563);
    }

    public final void initView() {
        AppMethodBeat.i(34564);
        initActionBar();
        this.zqO = (ListView) findViewById(R.id.bi5);
        this.emptyTipTv = (TextView) findViewById(R.id.a74);
        this.emptyTipTv.setText(R.string.bd8);
        this.zvk = new a(this, this.fuO, new com.tencent.mm.ui.p.a() {
            public final void apt() {
                AppMethodBeat.i(34550);
                NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.this.zvk.getCount());
                AppMethodBeat.o(34550);
            }
        });
        this.zvk.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cZ(View view) {
                AppMethodBeat.i(34551);
                int positionForView = NewBizConversationUI.this.zqO.getPositionForView(view);
                AppMethodBeat.o(34551);
                return positionForView;
            }
        });
        this.zvk.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(34552);
                NewBizConversationUI.this.zqO.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(34552);
            }
        });
        this.zqO.setAdapter(this.zvk);
        this.jMO = new com.tencent.mm.ui.widget.b.a(this);
        this.zqO.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(34553);
                NewBizConversationUI.this.conversation = (ak) NewBizConversationUI.this.zvk.getItem(i);
                NewBizConversationUI.this.talker = NewBizConversationUI.this.conversation.field_username;
                ak g = NewBizConversationUI.this.conversation;
                if (g == null) {
                    ab.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(NewBizConversationUI.this.zvk.getCount()));
                    NewBizConversationUI.this.zvk.notifyDataSetChanged();
                    AppMethodBeat.o(34553);
                    return;
                }
                Intent intent = new Intent(NewBizConversationUI.this, ChattingUI.class);
                intent.putExtra("Chat_User", g.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("biz_click_item_unread_count", NewBizConversationUI.this.conversation.field_unReadCount);
                intent.putExtra("biz_click_item_position", i + 1);
                intent.putExtra("KOpenArticleSceneFromScene", 92);
                intent.putExtra("specific_chat_from_scene", 6);
                NewBizConversationUI.this.startActivity(intent);
                NewBizConversationUI.this.zvk.a(g, i);
                AppMethodBeat.o(34553);
            }
        });
        this.zqO.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(34533);
                switch (motionEvent.getAction()) {
                    case 0:
                        NewBizConversationUI.this.jLX = (int) motionEvent.getRawX();
                        NewBizConversationUI.this.jLY = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(34533);
                return false;
            }
        });
        this.zqO.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(34534);
                NewBizConversationUI.this.conversation = (ak) NewBizConversationUI.this.zvk.getItem(i);
                NewBizConversationUI.this.talker = NewBizConversationUI.this.conversation.field_username;
                NewBizConversationUI.this.jMO.a(view, i, j, NewBizConversationUI.this, NewBizConversationUI.this.jOb, NewBizConversationUI.this.jLX, NewBizConversationUI.this.jLY);
                AppMethodBeat.o(34534);
                return true;
            }
        });
        this.zvk.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cZ(View view) {
                AppMethodBeat.i(34535);
                int positionForView = NewBizConversationUI.this.zqO.getPositionForView(view);
                AppMethodBeat.o(34535);
                return positionForView;
            }
        });
        this.zvk.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(34536);
                NewBizConversationUI.this.zqO.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(34536);
            }
        });
        this.zvk.a((f) new f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(34537);
                if (obj == null) {
                    ab.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
                    AppMethodBeat.o(34537);
                    return;
                }
                NewBizConversationUI.b(NewBizConversationUI.this, obj.toString());
                AppMethodBeat.o(34537);
            }
        });
        AppMethodBeat.o(34564);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(34565);
        super.onActivityResult(i, i2, intent);
        if (!(this.talker == null || this.talker.isEmpty())) {
            this.talker = "";
        }
        if (i2 != -1) {
            AppMethodBeat.o(34565);
        } else {
            AppMethodBeat.o(34565);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(34566);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        aw.ZK();
        ad aoO = com.tencent.mm.model.c.XM().aoO(this.talker);
        if (aoO == null) {
            ab.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
            AppMethodBeat.o(34566);
            return;
        }
        CharSequence Oj = aoO.Oj();
        if (Oj.toLowerCase().endsWith("@chatroom") && bo.isNullOrNil(aoO.field_nickname)) {
            Oj = getString(R.string.ao1);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, Oj));
        if (com.tencent.mm.n.a.jh(aoO.field_type)) {
            if (aoO.Oe()) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.a9d);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.a9c);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.cvi);
        }
        contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.cvq);
        AppMethodBeat.o(34566);
    }

    static /* synthetic */ void a(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(34567);
        if (!(newBizConversationUI.zvk == null || newBizConversationUI.zqO == null || newBizConversationUI.zvk.getCount() <= 0)) {
            newBizConversationUI.zqO.setSelection(0);
        }
        AppMethodBeat.o(34567);
    }

    static /* synthetic */ void b(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(34568);
        if (aw.RK()) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            long j = 0;
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder("");
            aw.ZK();
            Cursor c = com.tencent.mm.model.c.XR().c(t.fkP, null, newBizConversationUI.fuO);
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
            ab.v("MicroMsg.NewBizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.o(34568);
    }

    static /* synthetic */ void c(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(34569);
        if (newBizConversationUI.jOA != 0) {
            h.pYm.e(13932, Integer.valueOf(((int) (System.currentTimeMillis() - newBizConversationUI.jOA)) / 1000), Integer.valueOf(2), Integer.valueOf(newBizConversationUI.ctE), Integer.valueOf(0), Integer.valueOf(newBizConversationUI.cvd));
        }
        AppMethodBeat.o(34569);
    }

    static /* synthetic */ void d(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.i(34570);
        if (newBizConversationUI.zvk != null) {
            LinkedList linkedList = new LinkedList();
            for (Entry entry : newBizConversationUI.zvk.jOf.entrySet()) {
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
            ab.d("MicroMsg.NewBizConversationUI", "reportExpose size:%d", Integer.valueOf(linkedList.size()));
        }
        AppMethodBeat.o(34570);
    }
}
