package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.b.a;
import com.tencent.mm.aj.a.b.a.b;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.s;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;

public class BizChatFavUI extends MMActivity implements n {
    private TextView emptyTipTv;
    private p iGY;
    private boolean isCurrentActivity;
    private ListView jJY;
    private d jKa;
    private long jMj;
    private String jMp;
    private a yEm;
    private com.tencent.mm.aj.a.d.a yEn;
    private c yEs;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30120);
        super.onCreate(bundle);
        this.jMp = getIntent().getStringExtra("Contact_User");
        ab.i("MicroMsg.BizChatFavUI", "[registerListener]");
        this.yEm = new a() {
            public final void a(b bVar) {
                AppMethodBeat.i(30107);
                if (!(bVar == null || bVar.fxr == null || !BizChatFavUI.this.jMp.equals(bVar.fxr.field_brandUserName))) {
                    ab.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
                    if (BizChatFavUI.this.isCurrentActivity) {
                        BizChatFavUI.this.yEs.KC();
                    }
                }
                AppMethodBeat.o(30107);
            }
        };
        this.yEn = new com.tencent.mm.aj.a.d.a() {
            public final void a(com.tencent.mm.aj.a.d.a.b bVar) {
                AppMethodBeat.i(30112);
                if (!(bVar == null || bVar.fxB == null)) {
                    ab.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
                    c aK = z.aeT().aK(bVar.fxq);
                    ab.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", Boolean.valueOf(aK.field_needToUpdate));
                    if (BizChatFavUI.this.isCurrentActivity) {
                        BizChatFavUI.this.yEs.KC();
                    }
                }
                AppMethodBeat.o(30112);
            }
        };
        z.aeU().a(this.yEm, getMainLooper());
        z.aeT().a(this.yEn, getMainLooper());
        initView();
        z.aeZ();
        g.RO().eJo.a(new s(this.jMp), 0);
        AppMethodBeat.o(30120);
    }

    public final int getLayoutId() {
        return R.layout.vi;
    }

    public void onResume() {
        AppMethodBeat.i(30122);
        super.onResume();
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.jMp);
        if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
            finish();
            AppMethodBeat.o(30122);
            return;
        }
        setTitleMuteIconVisibility(8);
        this.isCurrentActivity = true;
        this.yEs.a(null, null);
        aw.getNotification().jO(this.jMp);
        AppMethodBeat.o(30122);
    }

    public void onPause() {
        AppMethodBeat.i(30123);
        this.yEs.onPause();
        this.isCurrentActivity = false;
        aw.getNotification().jO("");
        super.onPause();
        AppMethodBeat.o(30123);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(30124);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jMj = ((c) this.yEs.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, R.string.a_q);
        AppMethodBeat.o(30124);
    }

    public final void a(int i, m mVar) {
        AppMethodBeat.i(30125);
        if (this.iGY != null) {
            this.iGY.dismiss();
        }
        AppMethodBeat.o(30125);
    }

    public final void initView() {
        AppMethodBeat.i(30126);
        btZ();
        dAO();
        bkL();
        dAP();
        dAN();
        AppMethodBeat.o(30126);
    }

    private void btZ() {
        AppMethodBeat.i(30127);
        this.jJY = (ListView) findViewById(R.id.bi5);
        this.emptyTipTv = (TextView) findViewById(R.id.a74);
        this.emptyTipTv.setText(R.string.a_p);
        AppMethodBeat.o(30127);
    }

    private void dAN() {
        AppMethodBeat.i(30128);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30113);
                BizChatFavUI.this.finish();
                AppMethodBeat.o(30113);
                return true;
            }
        });
        AppMethodBeat.o(30128);
    }

    private void dAO() {
        AppMethodBeat.i(30129);
        this.jJY.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(30114);
                o.ahp().cm(i);
                AppMethodBeat.o(30114);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        AppMethodBeat.o(30129);
    }

    private void bkL() {
        AppMethodBeat.i(30130);
        this.yEs = new c(this, new com.tencent.mm.ui.p.a() {
            public final void apt() {
                AppMethodBeat.i(30115);
                BizChatFavUI.this.setMMTitle(com.tencent.mm.model.s.mJ(BizChatFavUI.this.jMp));
                if (BizChatFavUI.this.yEs.getCount() <= 0) {
                    BizChatFavUI.this.emptyTipTv.setVisibility(0);
                    BizChatFavUI.this.jJY.setVisibility(8);
                    AppMethodBeat.o(30115);
                    return;
                }
                BizChatFavUI.this.emptyTipTv.setVisibility(8);
                BizChatFavUI.this.jJY.setVisibility(0);
                AppMethodBeat.o(30115);
            }
        }, this.jMp);
        this.yEs.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cZ(View view) {
                AppMethodBeat.i(30116);
                int positionForView = BizChatFavUI.this.jJY.getPositionForView(view);
                AppMethodBeat.o(30116);
                return positionForView;
            }
        });
        this.yEs.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(30117);
                BizChatFavUI.this.jJY.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(30117);
            }
        });
        this.yEs.a(new f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(30118);
                if (obj == null) {
                    ab.e("MicroMsg.BizChatFavUI", "onItemDel object null");
                    AppMethodBeat.o(30118);
                    return;
                }
                AppMethodBeat.o(30118);
            }
        });
        this.jJY.setAdapter(this.yEs);
        AppMethodBeat.o(30130);
    }

    private void dAP() {
        AppMethodBeat.i(30131);
        this.jKa = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(30119);
                switch (menuItem.getItemId()) {
                    case 0:
                        BizChatFavUI.a(BizChatFavUI.this, BizChatFavUI.this.jMj);
                        break;
                }
                AppMethodBeat.o(30119);
            }
        };
        final com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this);
        this.jJY.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(30108);
                if (i < BizChatFavUI.this.jJY.getHeaderViewsCount()) {
                    ab.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
                    AppMethodBeat.o(30108);
                } else {
                    jVar.a(view, i, j, BizChatFavUI.this, BizChatFavUI.this.jKa);
                    AppMethodBeat.o(30108);
                }
                return true;
            }
        });
        this.jJY.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(30109);
                BizChatFavUI.b(BizChatFavUI.this, ((c) BizChatFavUI.this.yEs.getItem(i)).field_bizChatLocalId);
                AppMethodBeat.o(30109);
            }
        });
        AppMethodBeat.o(30131);
    }

    public void onDestroy() {
        AppMethodBeat.i(30121);
        ab.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        z.aeU().a(this.yEm);
        z.aeT().a(this.yEn);
        this.yEs.bIf();
        super.onDestroy();
        AppMethodBeat.o(30121);
    }

    static /* synthetic */ void b(BizChatFavUI bizChatFavUI, long j) {
        AppMethodBeat.i(30133);
        Intent intent = new Intent(bizChatFavUI, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.jMp);
        intent.putExtra("key_biz_chat_id", j);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        bizChatFavUI.startActivity(intent);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30111);
                BizChatFavUI.this.finish();
                AppMethodBeat.o(30111);
            }
        }, 500);
        AppMethodBeat.o(30133);
    }
}
