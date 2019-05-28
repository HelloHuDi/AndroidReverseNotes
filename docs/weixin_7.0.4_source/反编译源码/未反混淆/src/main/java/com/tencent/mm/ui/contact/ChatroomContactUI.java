package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.voicesearch.b;
import java.io.IOException;

public class ChatroomContactUI extends MMActivity implements f, a {
    private d ein = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    private int jLX = 0;
    private int jLY = 0;
    private com.tencent.mm.ui.widget.b.a jMO;
    private n.d lCi = new n.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(33571);
            switch (menuItem.getItemId()) {
                case 1:
                    ChatroomContactUI.arN(ChatroomContactUI.this.zke);
                    AppMethodBeat.o(33571);
                    return;
                default:
                    AppMethodBeat.o(33571);
                    return;
            }
        }
    };
    private TextView mht;
    private ListView nIv;
    private b zkc;
    private String zke;
    private ContactCountView zkp;
    private VoiceSearchLayout zlp;
    private com.tencent.mm.modelvoiceaddr.ui.b zlq;
    private d zlr;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChatroomContactUI() {
        AppMethodBeat.i(33586);
        AppMethodBeat.o(33586);
    }

    static /* synthetic */ void c(ChatroomContactUI chatroomContactUI) {
        AppMethodBeat.i(33599);
        chatroomContactUI.bJk();
        AppMethodBeat.o(33599);
    }

    public final int getLayoutId() {
        return R.layout.ku;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33587);
        super.onCreate(bundle);
        setMMTitle((int) R.string.dl);
        initView();
        aw.Rg().a(138, (f) this);
        aw.ZK();
        c.XM().a(this.zlr);
        AppMethodBeat.o(33587);
    }

    private void dHE() {
        AppMethodBeat.i(33588);
        ((TextView) findViewById(R.id.n4)).setVisibility(8);
        AppMethodBeat.o(33588);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(33589);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        aw.ZK();
        if (c.XM().aoO(this.zke) == null) {
            ab.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.zke);
            AppMethodBeat.o(33589);
        } else if (t.mW(this.zke)) {
            contextMenu.setHeaderTitle(j.b(view.getContext(), s.mJ(this.zke)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.dt);
            AppMethodBeat.o(33589);
        } else {
            AppMethodBeat.o(33589);
        }
    }

    public final void initView() {
        AppMethodBeat.i(33590);
        dHE();
        this.nIv = (ListView) findViewById(R.id.n3);
        this.nIv.setAdapter(null);
        this.mht = (TextView) findViewById(R.id.n4);
        this.mht.setText(R.string.dx);
        String str = "@all.chatroom.contact";
        this.zlr = new d(this, str);
        this.zlr.pN(true);
        this.zkc = new b(this.mController.ylL, 1);
        this.zkc.zjx = str;
        this.zlq = new com.tencent.mm.modelvoiceaddr.ui.b((byte) 0);
        this.zlq.a(new com.tencent.mm.modelvoiceaddr.ui.b.a() {
            public final void apq() {
            }

            public final void apr() {
            }

            public final void vO(String str) {
                AppMethodBeat.i(33577);
                ab.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", str);
                ChatroomContactUI.a(ChatroomContactUI.this, ah.vA(str));
                AppMethodBeat.o(33577);
            }

            public final void apo() {
            }

            public final void app() {
            }

            public final void amJ() {
                AppMethodBeat.i(33578);
                ab.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
                ChatroomContactUI.this.aqX();
                AppMethodBeat.o(33578);
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
                AppMethodBeat.i(33579);
                ab.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
                Intent intent;
                if (z) {
                    intent = new Intent(ChatroomContactUI.this.mController.ylL, VoiceSearchResultUI.class);
                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                    intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                    intent.putExtra("VoiceSearchResultUI_ShowType", i);
                    ChatroomContactUI.this.mController.ylL.startActivity(intent);
                    AppMethodBeat.o(33579);
                    return;
                }
                intent = new Intent(ChatroomContactUI.this.mController.ylL, VoiceSearchResultUI.class);
                intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
                intent.putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.mController.ylL.getString(R.string.bx9));
                intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                intent.putExtra("VoiceSearchResultUI_ShowType", i);
                ChatroomContactUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(33579);
            }

            public final boolean vN(String str) {
                return false;
            }
        });
        a(this.zlq);
        this.zlr.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cZ(View view) {
                AppMethodBeat.i(33580);
                int positionForView = ChatroomContactUI.this.nIv.getPositionForView(view);
                AppMethodBeat.o(33580);
                return positionForView;
            }
        });
        this.zlr.setPerformItemClickListener(new g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(33581);
                ChatroomContactUI.this.nIv.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(33581);
            }
        });
        this.zlr.a(new MMSlideDelView.f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(33582);
                if (obj == null) {
                    ab.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
                    AppMethodBeat.o(33582);
                    return;
                }
                ChatroomContactUI.arN(obj.toString());
                ChatroomContactUI.c(ChatroomContactUI.this);
                AppMethodBeat.o(33582);
            }
        });
        this.nIv.setOnScrollListener(this.ein);
        this.zlr.vkK = this.ein;
        this.jMO = new com.tencent.mm.ui.widget.b.a(this.mController.ylL);
        this.nIv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(33583);
                ab.d("MicroMsg.ChatroomContactUI", "onItemClick " + i + (ChatroomContactUI.this.zkc == null ? ChatroomContactUI.this.zkc : Boolean.valueOf(ChatroomContactUI.this.zkc.zLy)));
                if (i < ChatroomContactUI.this.nIv.getHeaderViewsCount()) {
                    AppMethodBeat.o(33583);
                    return;
                }
                int headerViewsCount = i - ChatroomContactUI.this.nIv.getHeaderViewsCount();
                ad adVar;
                com.tencent.mm.g.b.a.t tVar;
                if (ChatroomContactUI.this.zkc == null || !ChatroomContactUI.this.zkc.zLy) {
                    adVar = (ad) ChatroomContactUI.this.zlr.getItem(headerViewsCount);
                    if (t.mP(adVar.field_username)) {
                        tVar = new com.tencent.mm.g.b.a.t();
                        tVar.eO(adVar.field_username);
                        tVar.cXP = 2;
                        tVar.ajK();
                    }
                    ChatroomContactUI.b(ChatroomContactUI.this, adVar.field_username);
                    AppMethodBeat.o(33583);
                    return;
                }
                boolean wK = ChatroomContactUI.this.zkc.wK(headerViewsCount);
                boolean PQ = ChatroomContactUI.this.zkc.PQ(headerViewsCount);
                ab.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(PQ)));
                Intent intent;
                if (PQ) {
                    ChatroomContactUI.this.zkc.asx(ChatroomContactUI.this.zlq == null ? "" : ChatroomContactUI.this.zlq.getSearchContent());
                    AppMethodBeat.o(33583);
                } else if (wK) {
                    but PO = ChatroomContactUI.this.zkc.PO(headerViewsCount);
                    String str = PO.wcB.wVI;
                    aw.ZK();
                    adVar = c.XM().aoO(str);
                    if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        intent.putExtra("Contact_Scene", 3);
                        if (str != null && str.length() > 0) {
                            if (adVar.dsf()) {
                                h.pYm.X(10298, str + ",3");
                            }
                            e.a(intent, str);
                            com.tencent.mm.bp.d.b(ChatroomContactUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        }
                        AppMethodBeat.o(33583);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", PO.wcB.wVI);
                    intent2.putExtra("Contact_Alias", PO.guS);
                    intent2.putExtra("Contact_Nick", PO.wyX.wVI);
                    intent2.putExtra("Contact_Signature", PO.guQ);
                    intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(PO.guW, PO.guO, PO.guP));
                    intent2.putExtra("Contact_Sex", PO.guN);
                    intent2.putExtra("Contact_VUser_Info", PO.wBU);
                    intent2.putExtra("Contact_VUser_Info_Flag", PO.wBT);
                    intent2.putExtra("Contact_KWeibo_flag", PO.wBX);
                    intent2.putExtra("Contact_KWeibo", PO.wBV);
                    intent2.putExtra("Contact_KWeiboNick", PO.wBW);
                    intent2.putExtra("Contact_KSnsIFlag", PO.wBZ.guY);
                    intent2.putExtra("Contact_KSnsBgId", PO.wBZ.gva);
                    intent2.putExtra("Contact_KSnsBgUrl", PO.wBZ.guZ);
                    if (PO.wCa != null) {
                        try {
                            intent2.putExtra("Contact_customInfo", PO.wCa.toByteArray());
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.ChatroomContactUI", e, "", new Object[0]);
                        }
                    }
                    if ((PO.wBT & 8) > 0) {
                        h.pYm.X(10298, str + ",3");
                    }
                    com.tencent.mm.bp.d.b(ChatroomContactUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    AppMethodBeat.o(33583);
                } else {
                    ad PP = ChatroomContactUI.this.zkc.PP(headerViewsCount);
                    if (PP == null) {
                        ab.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(ChatroomContactUI.this.zkc.getCount()), Integer.valueOf(headerViewsCount));
                        AppMethodBeat.o(33583);
                        return;
                    }
                    y.q(ChatroomContactUI.this.zlq.getSearchContent(), 9, 3, headerViewsCount + 1);
                    String str2 = PP.field_username;
                    if (t.mP(str2)) {
                        tVar = new com.tencent.mm.g.b.a.t();
                        tVar.eO(str2);
                        tVar.cXP = 2;
                        tVar.ajK();
                    }
                    intent = new Intent(ChatroomContactUI.this.mController.ylL, ChattingUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("Chat_User", str2);
                    intent.putExtra("Chat_Mode", 1);
                    ChatroomContactUI.this.mController.ylL.startActivity(intent);
                    AppMethodBeat.o(33583);
                }
            }
        });
        this.nIv.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(33584);
                ab.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i)));
                if (i < ChatroomContactUI.this.nIv.getHeaderViewsCount()) {
                    ab.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
                    AppMethodBeat.o(33584);
                    return true;
                } else if (ChatroomContactUI.this.zkc == null || !ChatroomContactUI.this.zkc.zLy) {
                    String str = ((ad) ChatroomContactUI.this.zlr.getItem(i - ChatroomContactUI.this.nIv.getHeaderViewsCount())).field_username;
                    if (t.ny(str) || t.nz(str)) {
                        AppMethodBeat.o(33584);
                        return true;
                    }
                    ChatroomContactUI.this.zke = str;
                    ChatroomContactUI.this.jMO.a(view, i, j, ChatroomContactUI.this, ChatroomContactUI.this.lCi, ChatroomContactUI.this.jLX, ChatroomContactUI.this.jLY);
                    AppMethodBeat.o(33584);
                    return true;
                } else {
                    AppMethodBeat.o(33584);
                    return true;
                }
            }
        });
        this.nIv.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(33585);
                switch (motionEvent.getAction()) {
                    case 0:
                        ChatroomContactUI.this.aqX();
                        ChatroomContactUI.this.jLX = (int) motionEvent.getRawX();
                        ChatroomContactUI.this.jLY = (int) motionEvent.getRawY();
                        break;
                }
                if (ChatroomContactUI.this.zlr != null) {
                    d f = ChatroomContactUI.this.zlr;
                    if (f.gvm != null) {
                        f.gvm.onTouchEvent(motionEvent);
                    }
                }
                if (ChatroomContactUI.this.zkc != null) {
                    b d = ChatroomContactUI.this.zkc;
                    if (d.gvm != null) {
                        d.gvm.onTouchEvent(motionEvent);
                    }
                }
                AppMethodBeat.o(33585);
                return false;
            }
        });
        ListView listView = this.nIv;
        ContactCountView contactCountView = new ContactCountView(this);
        this.zkp = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33572);
                ChatroomContactUI.this.finish();
                AppMethodBeat.o(33572);
                return false;
            }
        });
        addIconOptionMenu(0, R.string.cf, R.raw.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33573);
                Intent intent = new Intent(ChatroomContactUI.this, SelectContactUI.class);
                intent.putExtra("titile", ChatroomContactUI.this.getString(R.string.es));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.C(s.znG, 256, 512));
                ChatroomContactUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(33573);
                return false;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33574);
                BackwardSupportUtil.c.a(ChatroomContactUI.this.nIv);
                AppMethodBeat.o(33574);
            }
        };
        this.nIv.setAdapter(this.zlr);
        this.zkc.qU(false);
        this.nIv.setVisibility(0);
        this.zlp = new VoiceSearchLayout(this);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.zlp.setLayoutParams(layoutParams);
        this.zlp.setTopMargin(BackwardSupportUtil.b.b((Context) this, 100.0f));
        this.zlp.setVisibility(8);
        ((ViewGroup) findViewById(R.id.al1)).addView(this.zlp);
        if (this.zlp != null) {
            this.zlp.setOnVisibleChangeListener(new VoiceSearchLayout.b() {
                public final void dd(boolean z) {
                    AppMethodBeat.i(33576);
                    ab.d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(z)));
                    if (z) {
                        int firstVisiblePosition = ChatroomContactUI.this.nIv.getFirstVisiblePosition();
                        ab.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(firstVisiblePosition)));
                        if (firstVisiblePosition > 0) {
                            ChatroomContactUI.this.nIv.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(33575);
                                    ChatroomContactUI.this.nIv.setSelection(0);
                                    AppMethodBeat.o(33575);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(33576);
                }
            });
        }
        if (this.zlr.getCount() == 0) {
            this.mht.setSingleLine(false);
            this.mht.setPadding(40, 0, 40, 0);
            this.mht.setVisibility(0);
        }
        AppMethodBeat.o(33590);
    }

    public void onResume() {
        AppMethodBeat.i(33591);
        super.onResume();
        if (this.zkp != null) {
            this.zkp.setContactType(2);
            this.zkp.dHF();
        }
        aw.ZK();
        c.XV().c(this);
        if (!(this.zlq == null || this.zlp == null)) {
            com.tencent.mm.bp.d.dlL();
            if (com.tencent.mm.au.b.ahP() || !aa.dor().equals("zh_CN")) {
                this.zlq.gcl = false;
            } else {
                this.zlq.gcl = true;
                com.tencent.mm.modelvoiceaddr.ui.b bVar = this.zlq;
                bVar.gcp = this.zlp;
                bVar.gcn = 1;
                if (1 == bVar.gcn) {
                    bVar.gcm = 2;
                } else {
                    bVar.gcm = 1;
                }
            }
        }
        if (this.zkc != null) {
            this.zkc.onResume();
        }
        AppMethodBeat.o(33591);
    }

    public void onPause() {
        AppMethodBeat.i(33592);
        super.onPause();
        aw.ZK();
        c.XV().d(this);
        if (this.zlq != null) {
            com.tencent.mm.modelvoiceaddr.ui.b bVar = this.zlq;
            bVar.dJS();
            bVar.cancel();
        }
        if (this.zkc != null) {
            this.zkc.onPause();
        }
        AppMethodBeat.o(33592);
    }

    public void onDestroy() {
        AppMethodBeat.i(33593);
        super.onDestroy();
        aw.Rg().b(138, (f) this);
        aw.ZK();
        c.XM().b(this.zlr);
        d dVar = this.zlr;
        if (dVar.gvm != null) {
            dVar.gvm.detach();
            dVar.gvm = null;
        }
        this.zlr.bIf();
        this.zlr.dww();
        this.zkc.detach();
        this.zkc.bIf();
        AppMethodBeat.o(33593);
    }

    private void bJk() {
        AppMethodBeat.i(33594);
        if (this.zlr != null) {
            this.zlr.a(null, null);
        }
        if (this.zkc != null) {
            this.zkc.a(null, null);
        }
        AppMethodBeat.o(33594);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(33595);
        if (!ah.cv(this)) {
            AppMethodBeat.o(33595);
        } else if (u.a.a(this, i, i2, str, 4)) {
            AppMethodBeat.o(33595);
        } else if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 138:
                    bJk();
                    break;
            }
            AppMethodBeat.o(33595);
        } else {
            AppMethodBeat.o(33595);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(33596);
        if (this.zkp != null) {
            this.zkp.setContactType(2);
            this.zkp.dHF();
        }
        AppMethodBeat.o(33596);
    }

    static /* synthetic */ void arN(String str) {
        AppMethodBeat.i(33597);
        aw.ZK();
        ad aoO = c.XM().aoO(str);
        if (t.mP(str)) {
            aoO.NC();
            ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.a.class)).vg(aoO.field_username);
            aw.ZK();
            c.XM().b(str, aoO);
            AppMethodBeat.o(33597);
            return;
        }
        aoO.NC();
        t.u(aoO);
        if (t.kH(str)) {
            aw.ZK();
            c.XM().aoU(str);
            aw.ZK();
            c.XV().og(str);
            AppMethodBeat.o(33597);
            return;
        }
        aw.ZK();
        c.XM().b(str, aoO);
        AppMethodBeat.o(33597);
    }
}
