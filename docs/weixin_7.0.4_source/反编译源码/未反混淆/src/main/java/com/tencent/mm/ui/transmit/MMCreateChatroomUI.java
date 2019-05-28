package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MMCreateChatroomUI extends MMBaseSelectContactUI {
    private int scene;
    private List<String> zID;
    private boolean zIM;
    a zIN;
    private b zIO;
    private boolean zIP;
    private boolean zoL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void Kh() {
        AppMethodBeat.i(35044);
        super.Kh();
        this.zID = getIntent().getStringArrayListExtra("query_phrase_list");
        this.zIM = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
        this.scene = getIntent().getIntExtra("scene_from", 0);
        AppMethodBeat.o(35044);
    }

    public final void initView() {
        AppMethodBeat.i(35045);
        super.initView();
        a aVar = this.zIN;
        for (String str : aVar.zID) {
            i iVar = new i();
            iVar.handler = aVar.handler;
            iVar.mEw = aVar.plf;
            iVar.query = str;
            iVar.mEv = b.mEV;
            iVar.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            iVar.mEu.add("filehelper");
            iVar.mEu.add(r.Yz());
            a search = ((n) g.M(n.class)).search(2, iVar);
            aVar.zIE = new ArrayList();
            aVar.zIE.add(search);
        }
        a(1, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35040);
                if (!MMCreateChatroomUI.this.zoL) {
                    MMCreateChatroomUI.this.zoL = true;
                    MMCreateChatroomUI.b(MMCreateChatroomUI.this);
                    if (MMCreateChatroomUI.this.scene == 3) {
                        MMCreateChatroomUI.this.zIP = true;
                        k.hA(true);
                    }
                }
                ab.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
                AppMethodBeat.o(35040);
                return true;
            }
        }, q.b.GREEN);
        Kt();
        AppMethodBeat.o(35045);
    }

    public final void Kt() {
        AppMethodBeat.i(35046);
        List dKe = this.zIN.dKe();
        if (dKe.size() > 0) {
            updateOptionMenuText(1, getString(R.string.s6) + "(" + dKe.size() + ")");
            if (dKe.size() > 1) {
                enableOptionMenu(1, true);
                AppMethodBeat.o(35046);
                return;
            }
            enableOptionMenu(1, false);
            AppMethodBeat.o(35046);
            return;
        }
        updateOptionMenuText(1, getString(R.string.s6));
        enableOptionMenu(1, false);
        AppMethodBeat.o(35046);
    }

    public void onDestroy() {
        AppMethodBeat.i(35047);
        this.zIN.finish();
        if (!this.zIP && this.scene == 3) {
            k.hA(false);
        }
        super.onDestroy();
        AppMethodBeat.o(35047);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.i(35048);
        String string = getString(R.string.e1y);
        AppMethodBeat.o(35048);
        return string;
    }

    public final o aoz() {
        AppMethodBeat.i(35049);
        if (this.zIN == null) {
            this.zIN = new a(this, this.zID, this.scene);
        }
        a aVar = this.zIN;
        AppMethodBeat.o(35049);
        return aVar;
    }

    public final m aoA() {
        AppMethodBeat.i(35050);
        if (this.zIO == null) {
            this.zIO = new b(this, this.scene);
        }
        b bVar = this.zIO;
        AppMethodBeat.o(35050);
        return bVar;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(35051);
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            a aVar2 = this.zIN;
            String str = eVar.hpS.mDx;
            int i = aVar.position;
            if (aVar2.gnG.contains(str)) {
                a aVar3;
                for (int size = aVar2.zIF.size() - 1; size >= 0; size--) {
                    aVar3 = (a) aVar2.zIF.get(size);
                    if (i >= aVar3.mFb) {
                        break;
                    }
                }
                aVar3 = null;
                if (aVar3 == null) {
                    AppMethodBeat.o(35051);
                    return false;
                } else if (!str.equals(aVar3.zII)) {
                    AppMethodBeat.o(35051);
                    return true;
                }
            }
            AppMethodBeat.o(35051);
            return false;
        }
        AppMethodBeat.o(35051);
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(35052);
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            a aVar2 = this.zIN;
            if (aVar2.gnG.contains(eVar.hpS.mDx)) {
                AppMethodBeat.o(35052);
                return true;
            }
            AppMethodBeat.o(35052);
            return false;
        }
        AppMethodBeat.o(35052);
        return false;
    }

    private void a(final com.tencent.mm.roomsdk.a.c.a aVar) {
        AppMethodBeat.i(35053);
        aVar.d(new c() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                int i3 = 0;
                AppMethodBeat.i(35041);
                c cVar = (c) aVar;
                MMCreateChatroomUI.this.zoL = false;
                if (!u.a.a(MMCreateChatroomUI.this, i, i2, str, 4)) {
                    if (i == 0 && i2 == 0 && !bo.isNullOrNil(this.chatroomName)) {
                        if (aVar.dmW()) {
                            com.tencent.mm.model.m.a(this.chatroomName, cVar.ehj, MMCreateChatroomUI.this.getString(R.string.aju), false, "");
                        }
                        List list = cVar.cGd;
                        if (list != null && list.size() > 0) {
                            LinkedList linkedList = new LinkedList();
                            while (i3 < list.size()) {
                                linkedList.add(list.get(i3));
                                i3++;
                            }
                            String str2 = "weixin://findfriend/verifycontact/" + this.chatroomName + "/";
                            if (aVar.dmW()) {
                                com.tencent.mm.model.m.a(this.chatroomName, linkedList, MMCreateChatroomUI.this.getString(R.string.ajv), true, str2);
                            }
                        }
                        MMCreateChatroomUI.a(MMCreateChatroomUI.this, this.chatroomName);
                    } else {
                        MMCreateChatroomUI.a(MMCreateChatroomUI.this, i, i2, cVar);
                        AppMethodBeat.o(35041);
                        return;
                    }
                }
                AppMethodBeat.o(35041);
            }
        });
        getString(R.string.tz);
        aVar.a(this, getString(R.string.cmb), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(35042);
                MMCreateChatroomUI.this.zoL = false;
                aVar.cancel();
                AppMethodBeat.o(35042);
            }
        });
        AppMethodBeat.o(35053);
    }

    private static List<String> O(List<String> list) {
        AppMethodBeat.i(35054);
        LinkedList linkedList = new LinkedList();
        if (!aw.RK()) {
            AppMethodBeat.o(35054);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(35054);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.o(35054);
            return linkedList;
        }
    }

    public final boolean dId() {
        return true;
    }

    public final void mO(int i) {
        AppMethodBeat.i(35055);
        a aVar = this.zIN;
        j jVar = this.zIO.mEm;
        String str = this.zIO.query;
        if (!(jVar.mEy.size() == 1 && ((l) jVar.mEy.get(0)).mDx.equals("no_result​"))) {
            a aVar2 = new a(aVar, (byte) 0);
            aVar2.mEy = jVar.mEy;
            aVar2.mDz = jVar.mDz;
            aVar2.query = str;
            aVar.zIF.add(aVar2);
            int headerViewsCount = i - aVar.zmV.getContentLV().getHeaderViewsCount();
            if (headerViewsCount >= 3) {
                jVar.mEy.add(0, (l) jVar.mEy.remove(headerViewsCount));
                i = aVar.zmV.getContentLV().getHeaderViewsCount();
            }
            aVar.dKd();
            aVar.zmV.getContentLV().post(new com.tencent.mm.ui.transmit.a.AnonymousClass2((aVar2.mFb + i) + 1));
        }
        dIb();
        dIc();
        aqX();
        AppMethodBeat.o(35055);
    }

    public final void vI(String str) {
        AppMethodBeat.i(35056);
        a aVar = this.zIN;
        aVar.gnG.remove(str);
        for (a aVar2 : aVar.zIF) {
            if (str.equals(aVar2.zII)) {
                aVar2.zII = null;
            }
        }
        aVar.notifyDataSetChanged();
        Kt();
        AppMethodBeat.o(35056);
    }

    public final /* bridge */ /* synthetic */ o dHW() {
        return this.zIN;
    }

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, int i, int i2, c cVar) {
        AppMethodBeat.i(35058);
        String str = "";
        String str2 = "";
        String string = ah.getContext().getString(R.string.ajw);
        if (i2 == -23) {
            str = mMCreateChatroomUI.getString(R.string.dtb);
            str2 = mMCreateChatroomUI.getString(R.string.dta);
        }
        List list = cVar.cGd;
        List list2 = cVar.ehk;
        if (list == null || list.size() <= 0 || (list.size() != cVar.cEX && (list2 == null || list2.size() <= 0 || cVar.cEX != list.size() + list2.size()))) {
            String str3;
            list = cVar.ehk;
            if (list == null || list.size() <= 0 || cVar.cEX != list.size()) {
                str3 = str2;
            } else {
                str = mMCreateChatroomUI.getString(R.string.cm_);
                str3 = str2 + mMCreateChatroomUI.getString(R.string.bx_, new Object[]{bo.c(O(list), string)});
            }
            List<String> list3 = cVar.cGa;
            if (list3 != null && list3.size() > 0) {
                Object obj;
                for (String str22 : list3) {
                    if (ad.aox(str22)) {
                        str = mMCreateChatroomUI.getString(R.string.cm_);
                        str3 = mMCreateChatroomUI.getString(R.string.cma);
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    str = mMCreateChatroomUI.getString(R.string.cm_);
                    str3 = str3 + mMCreateChatroomUI.getString(R.string.bxc, new Object[]{bo.c(O(list3), string)});
                }
            }
            if (str == null || str.length() <= 0) {
                Toast.makeText(mMCreateChatroomUI, mMCreateChatroomUI.getString(R.string.bwv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.o(35058);
                return;
            }
            h.b((Context) mMCreateChatroomUI, str3, str, true);
            AppMethodBeat.o(35058);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            linkedList.add(list.get(i3));
        }
        Assert.assertTrue(linkedList.size() > 0);
        str22 = ah.getContext().getString(R.string.ajw);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list2);
        h.a((Context) mMCreateChatroomUI, mMCreateChatroomUI.getString(R.string.bxl, new Object[]{bo.c(O(arrayList), str22)}), mMCreateChatroomUI.getString(R.string.cm_), mMCreateChatroomUI.getString(R.string.bxk), mMCreateChatroomUI.getString(R.string.bxj), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(35043);
                MMCreateChatroomUI.a(MMCreateChatroomUI.this, linkedList);
                AppMethodBeat.o(35043);
            }
        }, null);
        AppMethodBeat.o(35058);
    }
}
