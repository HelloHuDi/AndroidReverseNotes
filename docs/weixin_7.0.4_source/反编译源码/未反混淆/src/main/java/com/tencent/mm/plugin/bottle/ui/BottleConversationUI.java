package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.tools.j;

public class BottleConversationUI extends MMActivity {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private ListView jJY;
    private a jJZ;
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(18565);
            BottleConversationUI.a(BottleConversationUI.this, BottleConversationUI.this.talker);
            AppMethodBeat.o(18565);
        }
    };
    private String talker;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BottleConversationUI() {
        AppMethodBeat.i(18566);
        AppMethodBeat.o(18566);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18567);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(18567);
    }

    public final int getLayoutId() {
        return R.layout.azr;
    }

    public void onDestroy() {
        AppMethodBeat.i(18568);
        this.jJZ.bIf();
        super.onDestroy();
        AppMethodBeat.o(18568);
    }

    public void onResume() {
        AppMethodBeat.i(18569);
        super.onResume();
        aw.ZK();
        c.XM().a(this.jJZ);
        aw.ZK();
        c.XR().a(this.jJZ);
        this.jJZ.a(null, null);
        AppMethodBeat.o(18569);
    }

    public void onPause() {
        AppMethodBeat.i(18570);
        aw.ZK();
        c.XM().b(this.jJZ);
        aw.ZK();
        c.XR().b(this.jJZ);
        aw.ZK();
        bi yw = c.XO().yw(8);
        if (yw != null && yw.field_msgId > 0) {
            ab.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + yw.field_createTime);
            aw.ZK();
            c.Ry().set(12306, Long.valueOf(yw.field_createTime));
        }
        aw.ZK();
        ak aoZ = c.XR().aoZ("floatbottle");
        if (aoZ == null || bo.nullAsNil(aoZ.field_username).length() <= 0) {
            ab.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            aoZ.hM(0);
            aw.ZK();
            if (c.XR().a(aoZ, aoZ.field_username) == -1) {
                ab.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.jJZ.onPause();
        super.onPause();
        AppMethodBeat.o(18570);
    }

    public final void initView() {
        AppMethodBeat.i(18571);
        int YD = r.YD() | 4096;
        int YK = r.YK() & -65;
        aw.ZK();
        c.Ry().set(7, Integer.valueOf(YD));
        aw.ZK();
        c.Ry().set(34, Integer.valueOf(YK));
        this.jJY = (ListView) findViewById(R.id.bi5);
        this.emptyTipTv = (TextView) findViewById(R.id.a74);
        this.emptyTipTv.setText(R.string.aab);
        this.jJZ = new a(this, new a() {
            public final void apt() {
                AppMethodBeat.i(18553);
                BottleConversationUI bottleConversationUI = BottleConversationUI.this;
                String string = BottleConversationUI.this.getString(R.string.aah);
                int Yv = l.Yv();
                if (Yv <= 0) {
                    bottleConversationUI.setMMTitle(string);
                } else {
                    bottleConversationUI.setMMTitle(string + "(" + Yv + ")");
                }
                if (BottleConversationUI.this.jJZ.getCount() <= 0) {
                    BottleConversationUI.this.emptyTipTv.setVisibility(0);
                    BottleConversationUI.this.jJY.setVisibility(8);
                    AppMethodBeat.o(18553);
                    return;
                }
                BottleConversationUI.this.emptyTipTv.setVisibility(8);
                BottleConversationUI.this.jJY.setVisibility(0);
                AppMethodBeat.o(18553);
            }
        });
        this.jJZ.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cZ(View view) {
                AppMethodBeat.i(18558);
                int positionForView = BottleConversationUI.this.jJY.getPositionForView(view);
                AppMethodBeat.o(18558);
                return positionForView;
            }
        });
        this.jJZ.setPerformItemClickListener(new g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(18559);
                BottleConversationUI.this.jJY.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(18559);
            }
        });
        this.jJZ.a(new f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(18560);
                if (obj == null) {
                    ab.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
                    AppMethodBeat.o(18560);
                    return;
                }
                BottleConversationUI.a(BottleConversationUI.this, obj.toString());
                AppMethodBeat.o(18560);
            }
        });
        this.jJY.setAdapter(this.jJZ);
        final j jVar = new j(this);
        this.jJY.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(18561);
                if (i < BottleConversationUI.this.jJY.getHeaderViewsCount()) {
                    ab.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
                    AppMethodBeat.o(18561);
                } else {
                    jVar.a(view, i, j, BottleConversationUI.this, BottleConversationUI.this.jKa);
                    AppMethodBeat.o(18561);
                }
                return true;
            }
        });
        this.jJY.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(18562);
                ak akVar = (ak) BottleConversationUI.this.jJZ.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", akVar.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.bottle.a.gkE.d(intent, BottleConversationUI.this);
                AppMethodBeat.o(18562);
            }
        });
        com.tencent.mm.plugin.bottle.a.gkF.BS();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18563);
                BottleConversationUI.this.finish();
                AppMethodBeat.o(18563);
                return true;
            }
        });
        AnonymousClass9 anonymousClass9 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18564);
                BackwardSupportUtil.c.a(BottleConversationUI.this.jJY);
                AppMethodBeat.o(18564);
            }
        };
        AppMethodBeat.o(18571);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(18572);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.talker = ((ak) this.jJZ.getItem(adapterContextMenuInfo.position)).field_username;
        Object[] objArr = new Object[1];
        a aVar = this.jJZ;
        aw.ZK();
        objArr[0] = aVar.E(c.XM().aoO(this.talker));
        contextMenu.setHeaderTitle(getString(R.string.aa8, objArr));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.aa9);
        AppMethodBeat.o(18572);
    }
}
