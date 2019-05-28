package com.tencent.p177mm.p612ui.conversation;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25767k;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p189aq.C6320b;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.conversation.C36270c.C362696;
import com.tencent.p177mm.p612ui.conversation.C36270c.C362715;
import com.tencent.p177mm.p612ui.tools.C40889b;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.protocal.protobuf.bxk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.conversation.g */
public final class C30694g implements OnCreateContextMenuListener, OnItemLongClickListener, OnDismissListener {
    private Activity activity;
    private C7617ak conversation = null;
    private C5279d jOb = new C239781();
    private int[] mtm = new int[2];
    private int position;
    private String talker = "";
    private ListView zqz;
    private C23987h zrd;

    /* renamed from: com.tencent.mm.ui.conversation.g$1 */
    class C239781 implements C5279d {
        C239781() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            int i2 = 4;
            AppMethodBeat.m2504i(34260);
            switch (menuItem.getItemId()) {
                case 4:
                    if (C1855t.m3896kH(C30694g.this.talker)) {
                        C7060h.pYm.mo8381e(14553, Integer.valueOf(1), Integer.valueOf(1), C30694g.this.talker);
                    } else {
                        C7060h.pYm.mo8381e(14553, Integer.valueOf(0), Integer.valueOf(1), C30694g.this.talker);
                    }
                    C7620bi c7620bi = C30694g.this.conversation.xXq;
                    if (c7620bi != null) {
                        C4990ab.m7417i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", C30694g.this.talker, C30694g.this.activity, C30694g.this.conversation.field_username, Long.valueOf(c7620bi.field_msgId), c7620bi.field_content, Long.valueOf(c7620bi.field_createTime));
                    } else {
                        C4990ab.m7417i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", C30694g.this.talker, C30694g.this.activity, C30694g.this.conversation.field_username);
                    }
                    if (C17903f.m28105qY(C30694g.this.talker)) {
                        C7620bi Rb;
                        C25767k afc = C41747z.afc();
                        i2 = C30694g.this.position;
                        int i3 = C30694g.this.conversation.field_unReadCount;
                        String a = C30694g.this.talker;
                        afc.fwz = new bxk();
                        afc.fwz.wXv = i2;
                        afc.fwz.wXt = i3;
                        if (c7620bi == null) {
                            Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(a);
                        } else {
                            Rb = c7620bi;
                        }
                        if (Rb != null) {
                            afc.fwz.wXu = Rb.getType();
                            if (afc.fwz.wXt > 0) {
                                afc.fwz.wXs = ((int) (System.currentTimeMillis() - Rb.field_createTime)) / 1000;
                            }
                        }
                        C25767k.m40968a(afc.fwz, a);
                    }
                    C36270c.m59699a(C30694g.this.talker, C30694g.this.activity, C30694g.this.conversation, null, true, false);
                    i2 = 1;
                    break;
                case 5:
                    C4990ab.m7410d("MicroMsg.ConversationClickListener", "placed to the top");
                    C1855t.m3967w(C30694g.this.talker, true);
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(C30694g.this.talker);
                    if (aoO != null && aoO.dsf()) {
                        C7060h.pYm.mo8381e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
                    }
                    C30379h.m48465bQ(C30694g.this.activity, C30694g.this.activity.getString(C25738R.string.cvn));
                    C45457b.fRa.mo73263c(true, C30694g.this.talker, true);
                    break;
                case 6:
                    C4990ab.m7410d("MicroMsg.ConversationClickListener", "unplaced to the top");
                    C1855t.m3969x(C30694g.this.talker, true);
                    C9638aw.m17190ZK();
                    C7616ad aoO2 = C18628c.m29078XM().aoO(C30694g.this.talker);
                    if (aoO2 != null && aoO2.dsf()) {
                        C7060h.pYm.mo8381e(13307, aoO2.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                    }
                    C30379h.m48465bQ(C30694g.this.activity, C30694g.this.activity.getString(C25738R.string.cvo));
                    C45457b.fRa.mo73263c(true, C30694g.this.talker, false);
                    i2 = 5;
                    break;
                case 7:
                    C4990ab.m7411d("MicroMsg.ConversationClickListener", "jacks mark read: %s", C30694g.this.talker);
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().apb(C30694g.this.talker);
                    MMAppMgr.cancelNotification(C30694g.this.talker);
                    C37951y.m64163ab(C30694g.this.talker, 1);
                    C45457b.fRa.mo73254Q(C30694g.this.talker, false);
                    C6320b.agG();
                    C6320b.m10398rX(C30694g.this.talker);
                    i2 = 3;
                    break;
                case 8:
                    C4990ab.m7411d("MicroMsg.ConversationClickListener", "jacks set unread: %s", C30694g.this.talker);
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().apd(C30694g.this.talker);
                    C45457b.fRa.mo73254Q(C30694g.this.talker, true);
                    i2 = 2;
                    break;
                case 9:
                    C4990ab.m7411d("MicroMsg.ConversationClickListener", "jacks clear history: %s", C30694g.this.talker);
                    C1855t.m3896kH(C30694g.this.talker);
                    String a2 = C30694g.this.talker;
                    Context c = C30694g.this.activity;
                    PBool pBool = new PBool();
                    pBool.value = false;
                    c.getString(C25738R.string.f9238tz);
                    C1829bf.m3741a(a2, new C362696(pBool, C30379h.m48458b(c, c.getString(C25738R.string.f9260un), true, new C362715(pBool))));
                    i2 = -1;
                    break;
                case 10:
                    C4990ab.m7411d("MicroMsg.ConversationClickListener", "delete biz service: %s", C30694g.this.talker);
                    C9638aw.m17190ZK();
                    C40889b.m70857a(C17903f.m28104qX(C30694g.this.talker), C30694g.this.activity, C18628c.m29078XM().aoO(C30694g.this.talker), 1);
                    break;
            }
            i2 = -1;
            if (i2 > 0) {
                C7060h.pYm.mo8381e(11090, Integer.valueOf(i2));
                C4990ab.m7411d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", Integer.valueOf(i2));
            }
            AppMethodBeat.m2505o(34260);
        }
    }

    public C30694g(C23987h c23987h, ListView listView, Activity activity, int[] iArr) {
        AppMethodBeat.m2504i(34261);
        this.zrd = c23987h;
        this.zqz = listView;
        this.activity = activity;
        this.mtm = iArr;
        AppMethodBeat.m2505o(34261);
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(34262);
        if (i < this.zqz.getHeaderViewsCount()) {
            C4990ab.m7410d("MicroMsg.ConversationClickListener", "on long click header view");
            AppMethodBeat.m2505o(34262);
            return true;
        }
        this.position = i - this.zqz.getHeaderViewsCount();
        this.conversation = (C7617ak) this.zrd.getItem(i - this.zqz.getHeaderViewsCount());
        if (this.conversation == null) {
            C4990ab.m7413e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", Integer.valueOf(this.zqz.getHeaderViewsCount()), Integer.valueOf(i));
            AppMethodBeat.m2505o(34262);
            return true;
        }
        this.talker = this.conversation.field_username;
        C24088a c24088a = new C24088a(this.activity);
        c24088a.mo39885a(view, i, j, this, this.jOb, this.mtm[0], this.mtm[1]);
        c24088a.zHM = this;
        if (C1855t.m3896kH(this.talker)) {
            C7060h.pYm.mo8381e(14553, Integer.valueOf(1), Integer.valueOf(0), this.talker);
        } else {
            C7060h.pYm.mo8381e(14553, Integer.valueOf(0), Integer.valueOf(0), this.talker);
        }
        AppMethodBeat.m2505o(34262);
        return true;
    }

    public final void onDismiss() {
        AppMethodBeat.m2504i(34263);
        C23987h c23987h = this.zrd;
        c23987h.ztR = false;
        c23987h.notifyDataSetChanged();
        AppMethodBeat.m2505o(34263);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = 1;
        AppMethodBeat.m2504i(34264);
        C23987h c23987h = this.zrd;
        C4990ab.m7417i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", C42252ah.anW());
        c23987h.ztR = true;
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(this.talker);
        if (aoO == null) {
            C4990ab.m7412e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
            AppMethodBeat.m2505o(34264);
            return;
        }
        CharSequence Oj = aoO.mo16707Oj();
        if (Oj.toLowerCase().endsWith("@chatroom") && C42252ah.isNullOrNil(aoO.field_nickname)) {
            Oj = this.activity.getString(C25738R.string.ao1);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(C44089j.m79292b(this.activity, Oj));
        if (((this.conversation != null ? 1 : 0) & C1855t.m3888b(this.conversation)) != 0) {
            String str = this.talker;
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(str);
            if (aoZ == null) {
                i = 0;
            } else if (aoZ.field_unReadCount > 0 || aoZ.mo16714jl(1048576)) {
                i = 0;
            }
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 8, 0, C25738R.string.cvl);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 7, 0, C25738R.string.cvj);
            }
        }
        if (this.conversation != null && C1855t.m3881a(this.conversation)) {
            C9638aw.m17190ZK();
            if (C18628c.m29083XR().aph(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 6, 0, C25738R.string.cvm);
            } else if (aoO.dsf()) {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, C25738R.string.b1r);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, C25738R.string.cvk);
            }
        }
        if (aoO.dsf() && C7486a.m12942jh(aoO.field_type) && !C1855t.m3924nJ(aoO.field_username) && !C1855t.m3943nl(aoO.field_username)) {
            C16527d qX = C17903f.m28104qX(aoO.field_username);
            if (qX != null && qX.adM()) {
                contextMenu.add(adapterContextMenuInfo.position, 10, 0, C25738R.string.cvi);
            }
        }
        if (!(this.conversation == null || this.conversation.field_conversationTime == -1)) {
            if (C1855t.m3936ne(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, C25738R.string.cvt);
                AppMethodBeat.m2505o(34264);
                return;
            } else if (C1855t.m3937nf(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, C25738R.string.cvr);
                AppMethodBeat.m2505o(34264);
                return;
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, C25738R.string.cvq);
            }
        }
        AppMethodBeat.m2505o(34264);
    }
}
