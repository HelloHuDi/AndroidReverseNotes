package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.R;
import com.tencent.mm.ay.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.k;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.chatting.m.a.b;
import com.tencent.mm.ui.chatting.m.c;
import com.tencent.mm.ui.chatting.m.d;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@a(dFp = x.class)
public class ad extends a implements x, b {
    private j contextMenuHelper;
    private com.tencent.mm.ui.chatting.m.b yRc;
    private c yRd;
    private d yRe;

    public final void a(final View view, bi biVar, com.tencent.mm.ay.a aVar, int i) {
        AppMethodBeat.i(31618);
        Intent intent;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            String nullAsNil = bo.nullAsNil(eVar.fKX);
            ab.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", nullAsNil, Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()));
            if (eVar.fLl == null) {
                ab.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
                AppMethodBeat.o(31618);
                return;
            }
            Object obj = (((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn() || this.cgL.dFw()) ? 1 : null;
            if (obj == null) {
                ab.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
                AppMethodBeat.o(31618);
            } else if (nullAsNil.equals("invite")) {
                aK(eVar.fLl);
                AppMethodBeat.o(31618);
            } else if (nullAsNil.equals("qrcode")) {
                a(view, eVar.fLl, eVar.cGA);
                AppMethodBeat.o(31618);
            } else {
                if (nullAsNil.equals("webview") && !bo.isNullOrNil(eVar.url)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", eVar.url);
                    intent.putExtra("geta8key_username", r.Yz());
                    com.tencent.mm.bp.d.b(this.cgL.yTx.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(31618);
            }
        } else if (aVar instanceof com.tencent.mm.ay.d) {
            com.tencent.mm.ay.d dVar = (com.tencent.mm.ay.d) aVar;
            if (i == 0) {
                a(dVar.fLi, "", "", dVar.fLj, dVar.fLc, dVar.cxb, dVar.fLd, dVar.fLg, new LinkedList(), new LinkedList(), dVar.fLh, biVar);
            }
            AppMethodBeat.o(31618);
        } else if (aVar instanceof com.tencent.mm.ay.b) {
            com.tencent.mm.ay.b bVar = (com.tencent.mm.ay.b) aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(bVar.fLd);
            ((f) this.cgL.aF(f.class)).a(arrayList, bVar.cxb, biVar);
            AppMethodBeat.o(31618);
        } else if (aVar instanceof com.tencent.mm.ui.chatting.h.a) {
            aw.ZK();
            if (((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                final com.tencent.mm.ay.a aVar2 = aVar;
                h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.cfy), this.cgL.yTx.getMMResources().getString(R.string.ewj), this.cgL.yTx.getMMResources().getString(R.string.cd_), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31612);
                        ad.a(ad.this, view, (com.tencent.mm.ui.chatting.h.a) aVar2);
                        AppMethodBeat.o(31612);
                    }
                });
                AppMethodBeat.o(31618);
                return;
            }
            a(view, (com.tencent.mm.ui.chatting.h.a) aVar);
            AppMethodBeat.o(31618);
        } else if (aVar instanceof com.tencent.mm.ay.c) {
            ab.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
            if (this.cgL.dFw() && this.cgL.yTx.getContext() != null) {
                boolean z;
                if (this.cgL.sRl.dua == 0) {
                    z = true;
                } else {
                    z = false;
                }
                ((com.tencent.mm.plugin.expt.roomexpt.d) g.K(com.tencent.mm.plugin.expt.roomexpt.d.class)).gS(z);
                intent = new Intent();
                intent.putExtra("Chat_User", this.cgL.sRl.field_username);
                intent.putExtra("RoomInfo_Id", this.cgL.getTalkerUserName());
                intent.putExtra("Is_Chatroom", this.cgL.dFw());
                intent.putExtra("fromChatting", true);
                intent.putExtra("isShowSetMuteAnimation", true);
                intent.setClass(this.cgL.yTx.getContext(), ChatroomInfoUI.class);
                this.cgL.yTx.getContext().startActivity(intent);
            }
            AppMethodBeat.o(31618);
        } else if (aVar instanceof com.tencent.mm.model.bo) {
            ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDt();
            AppMethodBeat.o(31618);
        } else if (aVar instanceof k) {
            ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDu();
            AppMethodBeat.o(31618);
        } else {
            if (aVar instanceof com.tencent.mm.openim.c.a.b) {
                com.tencent.mm.openim.c.a.b bVar2 = (com.tencent.mm.openim.c.a.b) aVar;
                if (i == 0) {
                    a(bVar2.fLi, bVar2.gft, bVar2.gfu, bVar2.fLj, bVar2.fLc, bVar2.cxb, bVar2.fLd, bVar2.fLg, bVar2.gfr, bVar2.gfs, bVar2.fLh, biVar);
                }
            }
            AppMethodBeat.o(31618);
        }
    }

    private void a(final View view, com.tencent.mm.ui.chatting.h.a aVar) {
        AppMethodBeat.i(31619);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN, Boolean.FALSE);
        final bi biVar = aVar.cKd;
        if (cb.aaE() - aVar.yYP >= 300000) {
            ab.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
            h.b(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.cfz), this.cgL.yTx.getMMResources().getString(R.string.tz), true);
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31614);
                    ab.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", Long.valueOf(biVar.field_msgId));
                    t.a(ad.this.cgL.yTx.getMMResources().getString(R.string.ao0), "", biVar, "");
                    aw.ZK();
                    com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31613);
                            view.invalidate();
                            AppMethodBeat.o(31613);
                        }
                    });
                    AppMethodBeat.o(31614);
                }
            }, "deleteInvokeMsg");
            AppMethodBeat.o(31619);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(15037, Integer.valueOf(1));
        o oVar = (o) this.cgL.aF(o.class);
        oVar.dDX().setLastText(oVar.dDX().getLastText() + aVar.yYO);
        if (!oVar.dDX().cth()) {
            oVar.dDX().showVKB();
        }
        AppMethodBeat.o(31619);
    }

    private void a(View view, final LinkedList<String> linkedList, final String str) {
        AppMethodBeat.i(31620);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new j(this.cgL.yTx.getContext());
        }
        this.contextMenuHelper.b(view, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(31615);
                contextMenu.add(0, 0, 0, view.getContext().getString(R.string.dsa));
                contextMenu.add(0, 1, 1, view.getContext().getString(R.string.ds3));
                AppMethodBeat.o(31615);
            }
        }, new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(31617);
                switch (menuItem.getItemId()) {
                    case 0:
                        ((f) ad.this.cgL.aF(f.class)).aJ(linkedList);
                        AppMethodBeat.o(31617);
                        return;
                    case 1:
                        final com.tencent.mm.roomsdk.a.c.a L = com.tencent.mm.roomsdk.a.b.alY(ad.this.cgL.sRl.field_username).L(str, ad.this.cgL.sRl.field_username);
                        Activity context = ad.this.cgL.yTx.getContext();
                        ad.this.cgL.yTx.getMMResources().getString(R.string.tz);
                        L.a(context, ad.this.cgL.yTx.getMMResources().getString(R.string.ds6), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(31616);
                                L.cancel();
                                AppMethodBeat.o(31616);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(31617);
            }
        });
        AppMethodBeat.o(31620);
    }

    private void aK(LinkedList<String> linkedList) {
        AppMethodBeat.i(31621);
        if (((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
            ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).aH(linkedList);
            AppMethodBeat.o(31621);
            return;
        }
        ((f) this.cgL.aF(f.class)).aJ(linkedList);
        AppMethodBeat.o(31621);
    }

    @SuppressLint({"StringFormatMatches"})
    private void a(String str, String str2, String str3, String str4, String str5, String str6, LinkedList<String> linkedList, LinkedList<String> linkedList2, LinkedList<String> linkedList3, LinkedList<String> linkedList4, LinkedList<String> linkedList5, bi biVar) {
        AppMethodBeat.i(31622);
        Intent intent = new Intent(this.cgL.yTx.getContext(), SeeAccessVerifyInfoUI.class);
        intent.putExtra("msgLocalId", biVar.field_msgId);
        intent.putExtra("msgSvrId", biVar.field_msgSvrId);
        intent.putExtra("invitertitle", this.cgL.yTx.getMMResources().getString(R.string.c3, new Object[]{Integer.valueOf(linkedList.size())}));
        intent.putExtra("inviterusername", str);
        intent.putExtra("chatroom", str5);
        intent.putExtra("inviterappid", str2);
        intent.putExtra("inviterdescid", str3);
        intent.putExtra("invitationreason", str4);
        intent.putExtra("ticket", str6);
        intent.putExtra("username", bo.c((List) linkedList, ","));
        intent.putExtra("nickname", bo.c((List) linkedList2, ","));
        intent.putExtra("descid", bo.c((List) linkedList3, ","));
        intent.putExtra("appid", bo.c((List) linkedList4, ","));
        intent.putExtra("headimgurl", bo.c((List) linkedList5, ","));
        this.cgL.startActivity(intent);
        AppMethodBeat.o(31622);
    }

    public final void aL(LinkedList<String> linkedList) {
        AppMethodBeat.i(31623);
        if (linkedList != null && linkedList.size() > 0) {
            aK(linkedList);
        }
        AppMethodBeat.o(31623);
    }

    public final void a(View view, com.tencent.mm.ui.chatting.m.a.a aVar) {
        AppMethodBeat.i(31624);
        if (!(view == null || aVar == null)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(aVar.username);
            a(view, linkedList, aVar.link);
        }
        AppMethodBeat.o(31624);
    }

    public final void dxy() {
        AppMethodBeat.i(31625);
        super.dxy();
        this.yRe = new d(this);
        this.yRd = new c(this);
        this.yRc = new com.tencent.mm.ui.chatting.m.b(this);
        AppMethodBeat.o(31625);
    }

    public final void dxC() {
        AppMethodBeat.i(31626);
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
        AppMethodBeat.o(31626);
    }
}
