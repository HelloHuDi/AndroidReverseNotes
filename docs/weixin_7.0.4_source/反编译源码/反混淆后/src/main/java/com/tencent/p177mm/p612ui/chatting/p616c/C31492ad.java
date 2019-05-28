package com.tencent.p177mm.p612ui.chatting.p616c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.ChatroomInfoUI;
import com.tencent.p177mm.chatroom.p216ui.SeeAccessVerifyInfoUI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26429k;
import com.tencent.p177mm.model.C37904bo;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C18678t;
import com.tencent.p177mm.openim.p1211c.p1212a.C42242b;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.p200ay.C17965c;
import com.tencent.p177mm.p200ay.C25849b;
import com.tencent.p177mm.p200ay.C32322e;
import com.tencent.p177mm.p200ay.C6331d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23732x;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p612ui.chatting.p618h.C46654a;
import com.tencent.p177mm.p612ui.chatting.p624m.C36199a.C15705a;
import com.tencent.p177mm.p612ui.chatting.p624m.C36199a.C30557b;
import com.tencent.p177mm.p612ui.chatting.p624m.C36875b;
import com.tencent.p177mm.p612ui.chatting.p624m.C36876c;
import com.tencent.p177mm.p612ui.chatting.p624m.C5356d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.expt.roomexpt.C38991d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@C15590a(dFp = C23732x.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ad */
public class C31492ad extends C44291a implements C23732x, C30557b {
    private C46696j contextMenuHelper;
    private C36875b yRc;
    private C36876c yRd;
    private C5356d yRe;

    /* renamed from: com.tencent.mm.ui.chatting.c.ad$3 */
    class C314953 implements OnCreateContextMenuListener {
        C314953() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(31615);
            contextMenu.add(0, 0, 0, view.getContext().getString(C25738R.string.dsa));
            contextMenu.add(0, 1, 1, view.getContext().getString(C25738R.string.ds3));
            AppMethodBeat.m2505o(31615);
        }
    }

    /* renamed from: a */
    public final void mo4613a(final View view, C7620bi c7620bi, C1304a c1304a, int i) {
        AppMethodBeat.m2504i(31618);
        Intent intent;
        if (c1304a instanceof C32322e) {
            C32322e c32322e = (C32322e) c1304a;
            String nullAsNil = C5046bo.nullAsNil(c32322e.fKX);
            C4990ab.m7411d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", nullAsNil, Boolean.valueOf(((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm()));
            if (c32322e.fLl == null) {
                C4990ab.m7412e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
                AppMethodBeat.m2505o(31618);
                return;
            }
            Object obj = (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn() || this.cgL.dFw()) ? 1 : null;
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
                AppMethodBeat.m2505o(31618);
            } else if (nullAsNil.equals("invite")) {
                m50983aK(c32322e.fLl);
                AppMethodBeat.m2505o(31618);
            } else if (nullAsNil.equals("qrcode")) {
                m50980a(view, c32322e.fLl, c32322e.cGA);
                AppMethodBeat.m2505o(31618);
            } else {
                if (nullAsNil.equals("webview") && !C5046bo.isNullOrNil(c32322e.url)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", c32322e.url);
                    intent.putExtra("geta8key_username", C1853r.m3846Yz());
                    C25985d.m41467b(this.cgL.yTx.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.m2505o(31618);
            }
        } else if (c1304a instanceof C6331d) {
            C6331d c6331d = (C6331d) c1304a;
            if (i == 0) {
                m50982a(c6331d.fLi, "", "", c6331d.fLj, c6331d.fLc, c6331d.cxb, c6331d.fLd, c6331d.fLg, new LinkedList(), new LinkedList(), c6331d.fLh, c7620bi);
            }
            AppMethodBeat.m2505o(31618);
        } else if (c1304a instanceof C25849b) {
            C25849b c25849b = (C25849b) c1304a;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(c25849b.fLd);
            ((C7335f) this.cgL.mo74857aF(C7335f.class)).mo15840a(arrayList, c25849b.cxb, c7620bi);
            AppMethodBeat.m2505o(31618);
        } else if (c1304a instanceof C46654a) {
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                final C1304a c1304a2 = c1304a;
                C30379h.m48443a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.cfy), this.cgL.yTx.getMMResources().getString(C25738R.string.ewj), this.cgL.yTx.getMMResources().getString(C25738R.string.cd_), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(31612);
                        C31492ad.m50981a(C31492ad.this, view, (C46654a) c1304a2);
                        AppMethodBeat.m2505o(31612);
                    }
                });
                AppMethodBeat.m2505o(31618);
                return;
            }
            m50979a(view, (C46654a) c1304a);
            AppMethodBeat.m2505o(31618);
        } else if (c1304a instanceof C17965c) {
            C4990ab.m7416i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
            if (this.cgL.dFw() && this.cgL.yTx.getContext() != null) {
                boolean z;
                if (this.cgL.sRl.dua == 0) {
                    z = true;
                } else {
                    z = false;
                }
                ((C38991d) C1720g.m3528K(C38991d.class)).mo45803gS(z);
                intent = new Intent();
                intent.putExtra("Chat_User", this.cgL.sRl.field_username);
                intent.putExtra("RoomInfo_Id", this.cgL.getTalkerUserName());
                intent.putExtra("Is_Chatroom", this.cgL.dFw());
                intent.putExtra("fromChatting", true);
                intent.putExtra("isShowSetMuteAnimation", true);
                intent.setClass(this.cgL.yTx.getContext(), ChatroomInfoUI.class);
                this.cgL.yTx.getContext().startActivity(intent);
            }
            AppMethodBeat.m2505o(31618);
        } else if (c1304a instanceof C37904bo) {
            ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDt();
            AppMethodBeat.m2505o(31618);
        } else if (c1304a instanceof C26429k) {
            ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDu();
            AppMethodBeat.m2505o(31618);
        } else {
            if (c1304a instanceof C42242b) {
                C42242b c42242b = (C42242b) c1304a;
                if (i == 0) {
                    m50982a(c42242b.fLi, c42242b.gft, c42242b.gfu, c42242b.fLj, c42242b.fLc, c42242b.cxb, c42242b.fLd, c42242b.fLg, c42242b.gfr, c42242b.gfs, c42242b.fLh, c7620bi);
                }
            }
            AppMethodBeat.m2505o(31618);
        }
    }

    /* renamed from: a */
    private void m50979a(final View view, C46654a c46654a) {
        AppMethodBeat.m2504i(31619);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN, Boolean.FALSE);
        final C7620bi c7620bi = c46654a.cKd;
        if (C1839cb.aaE() - c46654a.yYP >= 300000) {
            C4990ab.m7420w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
            C30379h.m48461b(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.cfz), this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz), true);
            C7305d.post(new Runnable() {

                /* renamed from: com.tencent.mm.ui.chatting.c.ad$2$1 */
                class C155931 implements Runnable {
                    C155931() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(31613);
                        view.invalidate();
                        AppMethodBeat.m2505o(31613);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(31614);
                    C4990ab.m7417i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", Long.valueOf(c7620bi.field_msgId));
                    C18678t.m29196a(C31492ad.this.cgL.yTx.getMMResources().getString(C25738R.string.ao0), "", c7620bi, "");
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                    C5004al.m7441d(new C155931());
                    AppMethodBeat.m2505o(31614);
                }
            }, "deleteInvokeMsg");
            AppMethodBeat.m2505o(31619);
            return;
        }
        C7060h.pYm.mo8381e(15037, Integer.valueOf(1));
        C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
        c15614o.dDX().setLastText(c15614o.dDX().getLastText() + c46654a.yYO);
        if (!c15614o.dDX().cth()) {
            c15614o.dDX().showVKB();
        }
        AppMethodBeat.m2505o(31619);
    }

    /* renamed from: a */
    private void m50980a(View view, final LinkedList<String> linkedList, final String str) {
        AppMethodBeat.m2504i(31620);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new C46696j(this.cgL.yTx.getContext());
        }
        this.contextMenuHelper.mo75009b(view, new C314953(), new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(31617);
                switch (menuItem.getItemId()) {
                    case 0:
                        ((C7335f) C31492ad.this.cgL.mo74857aF(C7335f.class)).mo15841aJ(linkedList);
                        AppMethodBeat.m2505o(31617);
                        return;
                    case 1:
                        final C46610a L = C30262b.alY(C31492ad.this.cgL.sRl.field_username).mo20629L(str, C31492ad.this.cgL.sRl.field_username);
                        Activity context = C31492ad.this.cgL.yTx.getContext();
                        C31492ad.this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz);
                        L.mo48450a(context, C31492ad.this.cgL.yTx.getMMResources().getString(C25738R.string.ds6), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(31616);
                                L.cancel();
                                AppMethodBeat.m2505o(31616);
                            }
                        });
                        break;
                }
                AppMethodBeat.m2505o(31617);
            }
        });
        AppMethodBeat.m2505o(31620);
    }

    /* renamed from: aK */
    private void m50983aK(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(31621);
        if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm()) {
            ((C36135d) this.cgL.mo74857aF(C36135d.class)).mo57004aH(linkedList);
            AppMethodBeat.m2505o(31621);
            return;
        }
        ((C7335f) this.cgL.mo74857aF(C7335f.class)).mo15841aJ(linkedList);
        AppMethodBeat.m2505o(31621);
    }

    @SuppressLint({"StringFormatMatches"})
    /* renamed from: a */
    private void m50982a(String str, String str2, String str3, String str4, String str5, String str6, LinkedList<String> linkedList, LinkedList<String> linkedList2, LinkedList<String> linkedList3, LinkedList<String> linkedList4, LinkedList<String> linkedList5, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31622);
        Intent intent = new Intent(this.cgL.yTx.getContext(), SeeAccessVerifyInfoUI.class);
        intent.putExtra("msgLocalId", c7620bi.field_msgId);
        intent.putExtra("msgSvrId", c7620bi.field_msgSvrId);
        intent.putExtra("invitertitle", this.cgL.yTx.getMMResources().getString(C25738R.string.f8688c3, new Object[]{Integer.valueOf(linkedList.size())}));
        intent.putExtra("inviterusername", str);
        intent.putExtra("chatroom", str5);
        intent.putExtra("inviterappid", str2);
        intent.putExtra("inviterdescid", str3);
        intent.putExtra("invitationreason", str4);
        intent.putExtra("ticket", str6);
        intent.putExtra("username", C5046bo.m7536c((List) linkedList, ","));
        intent.putExtra("nickname", C5046bo.m7536c((List) linkedList2, ","));
        intent.putExtra("descid", C5046bo.m7536c((List) linkedList3, ","));
        intent.putExtra("appid", C5046bo.m7536c((List) linkedList4, ","));
        intent.putExtra("headimgurl", C5046bo.m7536c((List) linkedList5, ","));
        this.cgL.startActivity(intent);
        AppMethodBeat.m2505o(31622);
    }

    /* renamed from: aL */
    public final void mo48965aL(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(31623);
        if (linkedList != null && linkedList.size() > 0) {
            m50983aK(linkedList);
        }
        AppMethodBeat.m2505o(31623);
    }

    /* renamed from: a */
    public final void mo48964a(View view, C15705a c15705a) {
        AppMethodBeat.m2504i(31624);
        if (!(view == null || c15705a == null)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(c15705a.username);
            m50980a(view, linkedList, c15705a.link);
        }
        AppMethodBeat.m2505o(31624);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31625);
        super.dxy();
        this.yRe = new C5356d(this);
        this.yRd = new C36876c(this);
        this.yRc = new C36875b(this);
        AppMethodBeat.m2505o(31625);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31626);
        if (this.yRc != null) {
            this.yRc.release();
            this.yRc = null;
        }
        if (this.yRd != null) {
            this.yRd.release();
            this.yRd = null;
        }
        if (this.yRe != null) {
            this.yRe.release();
            this.yRe = null;
        }
        AppMethodBeat.m2505o(31626);
    }
}
