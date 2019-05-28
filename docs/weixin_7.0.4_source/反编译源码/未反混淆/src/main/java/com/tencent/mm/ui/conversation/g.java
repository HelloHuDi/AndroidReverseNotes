package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.conversation.c.AnonymousClass5;
import com.tencent.mm.ui.conversation.c.AnonymousClass6;
import com.tencent.mm.ui.widget.b.a;

public final class g implements OnCreateContextMenuListener, OnItemLongClickListener, OnDismissListener {
    private Activity activity;
    private ak conversation = null;
    private d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            int i2 = 4;
            AppMethodBeat.i(34260);
            switch (menuItem.getItemId()) {
                case 4:
                    if (t.kH(g.this.talker)) {
                        h.pYm.e(14553, Integer.valueOf(1), Integer.valueOf(1), g.this.talker);
                    } else {
                        h.pYm.e(14553, Integer.valueOf(0), Integer.valueOf(1), g.this.talker);
                    }
                    bi biVar = g.this.conversation.xXq;
                    if (biVar != null) {
                        ab.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", g.this.talker, g.this.activity, g.this.conversation.field_username, Long.valueOf(biVar.field_msgId), biVar.field_content, Long.valueOf(biVar.field_createTime));
                    } else {
                        ab.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", g.this.talker, g.this.activity, g.this.conversation.field_username);
                    }
                    if (f.qY(g.this.talker)) {
                        bi Rb;
                        k afc = z.afc();
                        i2 = g.this.position;
                        int i3 = g.this.conversation.field_unReadCount;
                        String a = g.this.talker;
                        afc.fwz = new bxk();
                        afc.fwz.wXv = i2;
                        afc.fwz.wXt = i3;
                        if (biVar == null) {
                            Rb = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Rb(a);
                        } else {
                            Rb = biVar;
                        }
                        if (Rb != null) {
                            afc.fwz.wXu = Rb.getType();
                            if (afc.fwz.wXt > 0) {
                                afc.fwz.wXs = ((int) (System.currentTimeMillis() - Rb.field_createTime)) / 1000;
                            }
                        }
                        k.a(afc.fwz, a);
                    }
                    c.a(g.this.talker, g.this.activity, g.this.conversation, null, true, false);
                    i2 = 1;
                    break;
                case 5:
                    ab.d("MicroMsg.ConversationClickListener", "placed to the top");
                    t.w(g.this.talker, true);
                    aw.ZK();
                    ad aoO = c.XM().aoO(g.this.talker);
                    if (aoO != null && aoO.dsf()) {
                        h.pYm.e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
                    }
                    com.tencent.mm.ui.base.h.bQ(g.this.activity, g.this.activity.getString(R.string.cvn));
                    b.fRa.c(true, g.this.talker, true);
                    break;
                case 6:
                    ab.d("MicroMsg.ConversationClickListener", "unplaced to the top");
                    t.x(g.this.talker, true);
                    aw.ZK();
                    ad aoO2 = c.XM().aoO(g.this.talker);
                    if (aoO2 != null && aoO2.dsf()) {
                        h.pYm.e(13307, aoO2.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                    }
                    com.tencent.mm.ui.base.h.bQ(g.this.activity, g.this.activity.getString(R.string.cvo));
                    b.fRa.c(true, g.this.talker, false);
                    i2 = 5;
                    break;
                case 7:
                    ab.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", g.this.talker);
                    aw.ZK();
                    c.XR().apb(g.this.talker);
                    MMAppMgr.cancelNotification(g.this.talker);
                    y.ab(g.this.talker, 1);
                    b.fRa.Q(g.this.talker, false);
                    com.tencent.mm.aq.b.agG();
                    com.tencent.mm.aq.b.rX(g.this.talker);
                    i2 = 3;
                    break;
                case 8:
                    ab.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", g.this.talker);
                    aw.ZK();
                    c.XR().apd(g.this.talker);
                    b.fRa.Q(g.this.talker, true);
                    i2 = 2;
                    break;
                case 9:
                    ab.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", g.this.talker);
                    t.kH(g.this.talker);
                    String a2 = g.this.talker;
                    Context c = g.this.activity;
                    PBool pBool = new PBool();
                    pBool.value = false;
                    c.getString(R.string.tz);
                    bf.a(a2, new AnonymousClass6(pBool, com.tencent.mm.ui.base.h.b(c, c.getString(R.string.un), true, new AnonymousClass5(pBool))));
                    i2 = -1;
                    break;
                case 10:
                    ab.d("MicroMsg.ConversationClickListener", "delete biz service: %s", g.this.talker);
                    aw.ZK();
                    com.tencent.mm.ui.tools.b.a(f.qX(g.this.talker), g.this.activity, c.XM().aoO(g.this.talker), 1);
                    break;
            }
            i2 = -1;
            if (i2 > 0) {
                h.pYm.e(11090, Integer.valueOf(i2));
                ab.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", Integer.valueOf(i2));
            }
            AppMethodBeat.o(34260);
        }
    };
    private int[] mtm = new int[2];
    private int position;
    private String talker = "";
    private ListView zqz;
    private h zrd;

    public g(h hVar, ListView listView, Activity activity, int[] iArr) {
        AppMethodBeat.i(34261);
        this.zrd = hVar;
        this.zqz = listView;
        this.activity = activity;
        this.mtm = iArr;
        AppMethodBeat.o(34261);
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(34262);
        if (i < this.zqz.getHeaderViewsCount()) {
            ab.d("MicroMsg.ConversationClickListener", "on long click header view");
            AppMethodBeat.o(34262);
            return true;
        }
        this.position = i - this.zqz.getHeaderViewsCount();
        this.conversation = (ak) this.zrd.getItem(i - this.zqz.getHeaderViewsCount());
        if (this.conversation == null) {
            ab.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", Integer.valueOf(this.zqz.getHeaderViewsCount()), Integer.valueOf(i));
            AppMethodBeat.o(34262);
            return true;
        }
        this.talker = this.conversation.field_username;
        a aVar = new a(this.activity);
        aVar.a(view, i, j, this, this.jOb, this.mtm[0], this.mtm[1]);
        aVar.zHM = this;
        if (t.kH(this.talker)) {
            h.pYm.e(14553, Integer.valueOf(1), Integer.valueOf(0), this.talker);
        } else {
            h.pYm.e(14553, Integer.valueOf(0), Integer.valueOf(0), this.talker);
        }
        AppMethodBeat.o(34262);
        return true;
    }

    public final void onDismiss() {
        AppMethodBeat.i(34263);
        h hVar = this.zrd;
        hVar.ztR = false;
        hVar.notifyDataSetChanged();
        AppMethodBeat.o(34263);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = 1;
        AppMethodBeat.i(34264);
        h hVar = this.zrd;
        ab.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", ah.anW());
        hVar.ztR = true;
        aw.ZK();
        ad aoO = c.XM().aoO(this.talker);
        if (aoO == null) {
            ab.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
            AppMethodBeat.o(34264);
            return;
        }
        CharSequence Oj = aoO.Oj();
        if (Oj.toLowerCase().endsWith("@chatroom") && ah.isNullOrNil(aoO.field_nickname)) {
            Oj = this.activity.getString(R.string.ao1);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.e.j.b(this.activity, Oj));
        if (((this.conversation != null ? 1 : 0) & t.b(this.conversation)) != 0) {
            String str = this.talker;
            aw.ZK();
            ak aoZ = c.XR().aoZ(str);
            if (aoZ == null) {
                i = 0;
            } else if (aoZ.field_unReadCount > 0 || aoZ.jl(1048576)) {
                i = 0;
            }
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 8, 0, R.string.cvl);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.string.cvj);
            }
        }
        if (this.conversation != null && t.a(this.conversation)) {
            aw.ZK();
            if (c.XR().aph(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 6, 0, R.string.cvm);
            } else if (aoO.dsf()) {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.string.b1r);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.string.cvk);
            }
        }
        if (aoO.dsf() && com.tencent.mm.n.a.jh(aoO.field_type) && !t.nJ(aoO.field_username) && !t.nl(aoO.field_username)) {
            com.tencent.mm.aj.d qX = f.qX(aoO.field_username);
            if (qX != null && qX.adM()) {
                contextMenu.add(adapterContextMenuInfo.position, 10, 0, R.string.cvi);
            }
        }
        if (!(this.conversation == null || this.conversation.field_conversationTime == -1)) {
            if (t.ne(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.string.cvt);
                AppMethodBeat.o(34264);
                return;
            } else if (t.nf(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.string.cvr);
                AppMethodBeat.o(34264);
                return;
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.string.cvq);
            }
        }
        AppMethodBeat.o(34264);
    }
}
