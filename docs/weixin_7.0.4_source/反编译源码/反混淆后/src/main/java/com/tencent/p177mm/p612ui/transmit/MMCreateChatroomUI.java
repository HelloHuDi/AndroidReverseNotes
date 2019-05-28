package com.tencent.p177mm.p612ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.transmit.C30769a.C30768a;
import com.tencent.p177mm.p612ui.transmit.C30769a.C307712;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C39132b;
import com.tencent.p177mm.plugin.fts.p424ui.C34234k;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23275s.C23280a;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.transmit.MMCreateChatroomUI */
public class MMCreateChatroomUI extends MMBaseSelectContactUI {
    private int scene;
    private List<String> zID;
    private boolean zIM;
    C30769a zIN;
    private C30772b zIO;
    private boolean zIP;
    private boolean zoL;

    /* renamed from: com.tencent.mm.ui.transmit.MMCreateChatroomUI$1 */
    class C159491 implements OnMenuItemClickListener {
        C159491() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35040);
            if (!MMCreateChatroomUI.this.zoL) {
                MMCreateChatroomUI.this.zoL = true;
                MMCreateChatroomUI.m70877b(MMCreateChatroomUI.this);
                if (MMCreateChatroomUI.this.scene == 3) {
                    MMCreateChatroomUI.this.zIP = true;
                    C34234k.m56148hA(true);
                }
            }
            C4990ab.m7416i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
            AppMethodBeat.m2505o(35040);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MMCreateChatroomUI$5 */
    class C408935 implements C23280a {
        C408935() {
        }

        /* renamed from: bD */
        public final void mo27248bD(boolean z) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(35044);
        super.mo7850Kh();
        this.zID = getIntent().getStringArrayListExtra("query_phrase_list");
        this.zIM = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
        this.scene = getIntent().getIntExtra("scene_from", 0);
        AppMethodBeat.m2505o(35044);
    }

    public final void initView() {
        AppMethodBeat.m2504i(35045);
        super.initView();
        C30769a c30769a = this.zIN;
        for (String str : c30769a.zID) {
            C20846i c20846i = new C20846i();
            c20846i.handler = c30769a.handler;
            c20846i.mEw = c30769a.plf;
            c20846i.query = str;
            c20846i.mEv = C39132b.mEV;
            c20846i.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            c20846i.mEu.add("filehelper");
            c20846i.mEu.add(C1853r.m3846Yz());
            C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
            c30769a.zIE = new ArrayList();
            c30769a.zIE.add(search);
        }
        mo17379a(1, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C159491(), C5535b.GREEN);
        mo64497Kt();
        AppMethodBeat.m2505o(35045);
    }

    /* renamed from: Kt */
    public final void mo64497Kt() {
        AppMethodBeat.m2504i(35046);
        List dKe = this.zIN.dKe();
        if (dKe.size() > 0) {
            updateOptionMenuText(1, getString(C25738R.string.f9187s6) + "(" + dKe.size() + ")");
            if (dKe.size() > 1) {
                enableOptionMenu(1, true);
                AppMethodBeat.m2505o(35046);
                return;
            }
            enableOptionMenu(1, false);
            AppMethodBeat.m2505o(35046);
            return;
        }
        updateOptionMenuText(1, getString(C25738R.string.f9187s6));
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(35046);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(35047);
        this.zIN.finish();
        if (!this.zIP && this.scene == 3) {
            C34234k.m56148hA(false);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(35047);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(35048);
        String string = getString(C25738R.string.e1y);
        AppMethodBeat.m2505o(35048);
        return string;
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(35049);
        if (this.zIN == null) {
            this.zIN = new C30769a(this, this.zID, this.scene);
        }
        C30769a c30769a = this.zIN;
        AppMethodBeat.m2505o(35049);
        return c30769a;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(35050);
        if (this.zIO == null) {
            this.zIO = new C30772b(this, this.scene);
        }
        C30772b c30772b = this.zIO;
        AppMethodBeat.m2505o(35050);
        return c30772b;
    }

    /* renamed from: b */
    public final boolean mo39661b(C5445a c5445a) {
        AppMethodBeat.m2504i(35051);
        if (c5445a instanceof C40843e) {
            C40843e c40843e = (C40843e) c5445a;
            C30769a c30769a = this.zIN;
            String str = c40843e.hpS.mDx;
            int i = c5445a.position;
            if (c30769a.gnG.contains(str)) {
                C30768a c30768a;
                for (int size = c30769a.zIF.size() - 1; size >= 0; size--) {
                    c30768a = (C30768a) c30769a.zIF.get(size);
                    if (i >= c30768a.mFb) {
                        break;
                    }
                }
                c30768a = null;
                if (c30768a == null) {
                    AppMethodBeat.m2505o(35051);
                    return false;
                } else if (!str.equals(c30768a.zII)) {
                    AppMethodBeat.m2505o(35051);
                    return true;
                }
            }
            AppMethodBeat.m2505o(35051);
            return false;
        }
        AppMethodBeat.m2505o(35051);
        return false;
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(35052);
        if (c5445a instanceof C40843e) {
            C40843e c40843e = (C40843e) c5445a;
            C30769a c30769a = this.zIN;
            if (c30769a.gnG.contains(c40843e.hpS.mDx)) {
                AppMethodBeat.m2505o(35052);
                return true;
            }
            AppMethodBeat.m2505o(35052);
            return false;
        }
        AppMethodBeat.m2505o(35052);
        return false;
    }

    /* renamed from: a */
    private void m70871a(final C46610a c46610a) {
        AppMethodBeat.m2504i(35053);
        c46610a.mo74755d(new C44205c() {
            /* renamed from: a */
            public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                int i3 = 0;
                AppMethodBeat.m2504i(35041);
                C44205c c44205c = (C44205c) c46609a;
                MMCreateChatroomUI.this.zoL = false;
                if (!C30784a.m49123a(MMCreateChatroomUI.this, i, i2, str, 4)) {
                    if (i == 0 && i2 == 0 && !C5046bo.isNullOrNil(this.chatroomName)) {
                        if (c46610a.dmW()) {
                            C32794m.m53572a(this.chatroomName, c44205c.ehj, MMCreateChatroomUI.this.getString(C25738R.string.aju), false, "");
                        }
                        List list = c44205c.cGd;
                        if (list != null && list.size() > 0) {
                            LinkedList linkedList = new LinkedList();
                            while (i3 < list.size()) {
                                linkedList.add(list.get(i3));
                                i3++;
                            }
                            String str2 = "weixin://findfriend/verifycontact/" + this.chatroomName + "/";
                            if (c46610a.dmW()) {
                                C32794m.m53572a(this.chatroomName, linkedList, MMCreateChatroomUI.this.getString(C25738R.string.ajv), true, str2);
                            }
                        }
                        MMCreateChatroomUI.m70873a(MMCreateChatroomUI.this, this.chatroomName);
                    } else {
                        MMCreateChatroomUI.m70872a(MMCreateChatroomUI.this, i, i2, c44205c);
                        AppMethodBeat.m2505o(35041);
                        return;
                    }
                }
                AppMethodBeat.m2505o(35041);
            }
        });
        getString(C25738R.string.f9238tz);
        c46610a.mo48450a(this, getString(C25738R.string.cmb), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(35042);
                MMCreateChatroomUI.this.zoL = false;
                c46610a.cancel();
                AppMethodBeat.m2505o(35042);
            }
        });
        AppMethodBeat.m2505o(35053);
    }

    /* renamed from: O */
    private static List<String> m70870O(List<String> list) {
        AppMethodBeat.m2504i(35054);
        LinkedList linkedList = new LinkedList();
        if (!C9638aw.m17179RK()) {
            AppMethodBeat.m2505o(35054);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.m2505o(35054);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.mo16707Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.m2505o(35054);
            return linkedList;
        }
    }

    public final boolean dId() {
        return true;
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(35055);
        C30769a c30769a = this.zIN;
        C28109j c28109j = this.zIO.mEm;
        String str = this.zIO.query;
        if (!(c28109j.mEy.size() == 1 && ((C45966l) c28109j.mEy.get(0)).mDx.equals("no_result​"))) {
            C30768a c30768a = new C30768a(c30769a, (byte) 0);
            c30768a.mEy = c28109j.mEy;
            c30768a.mDz = c28109j.mDz;
            c30768a.query = str;
            c30769a.zIF.add(c30768a);
            int headerViewsCount = i - c30769a.zmV.getContentLV().getHeaderViewsCount();
            if (headerViewsCount >= 3) {
                c28109j.mEy.add(0, (C45966l) c28109j.mEy.remove(headerViewsCount));
                i = c30769a.zmV.getContentLV().getHeaderViewsCount();
            }
            c30769a.dKd();
            c30769a.zmV.getContentLV().post(new C307712((c30768a.mFb + i) + 1));
        }
        dIb();
        dIc();
        aqX();
        AppMethodBeat.m2505o(35055);
    }

    /* renamed from: vI */
    public final void mo7901vI(String str) {
        AppMethodBeat.m2504i(35056);
        C30769a c30769a = this.zIN;
        c30769a.gnG.remove(str);
        for (C30768a c30768a : c30769a.zIF) {
            if (str.equals(c30768a.zII)) {
                c30768a.zII = null;
            }
        }
        c30769a.notifyDataSetChanged();
        mo64497Kt();
        AppMethodBeat.m2505o(35056);
    }

    public final /* bridge */ /* synthetic */ C40845o dHW() {
        return this.zIN;
    }

    /* renamed from: a */
    static /* synthetic */ void m70872a(MMCreateChatroomUI mMCreateChatroomUI, int i, int i2, C44205c c44205c) {
        AppMethodBeat.m2504i(35058);
        String str = "";
        String str2 = "";
        String string = C4996ah.getContext().getString(C25738R.string.ajw);
        if (i2 == -23) {
            str = mMCreateChatroomUI.getString(C25738R.string.dtb);
            str2 = mMCreateChatroomUI.getString(C25738R.string.dta);
        }
        List list = c44205c.cGd;
        List list2 = c44205c.ehk;
        if (list == null || list.size() <= 0 || (list.size() != c44205c.cEX && (list2 == null || list2.size() <= 0 || c44205c.cEX != list.size() + list2.size()))) {
            String str3;
            list = c44205c.ehk;
            if (list == null || list.size() <= 0 || c44205c.cEX != list.size()) {
                str3 = str2;
            } else {
                str = mMCreateChatroomUI.getString(C25738R.string.cm_);
                str3 = str2 + mMCreateChatroomUI.getString(C25738R.string.bx_, new Object[]{C5046bo.m7536c(MMCreateChatroomUI.m70870O(list), string)});
            }
            List<String> list3 = c44205c.cGa;
            if (list3 != null && list3.size() > 0) {
                Object obj;
                for (String str22 : list3) {
                    if (C7616ad.aox(str22)) {
                        str = mMCreateChatroomUI.getString(C25738R.string.cm_);
                        str3 = mMCreateChatroomUI.getString(C25738R.string.cma);
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    str = mMCreateChatroomUI.getString(C25738R.string.cm_);
                    str3 = str3 + mMCreateChatroomUI.getString(C25738R.string.bxc, new Object[]{C5046bo.m7536c(MMCreateChatroomUI.m70870O(list3), string)});
                }
            }
            if (str == null || str.length() <= 0) {
                Toast.makeText(mMCreateChatroomUI, mMCreateChatroomUI.getString(C25738R.string.bwv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.m2505o(35058);
                return;
            }
            C30379h.m48461b((Context) mMCreateChatroomUI, str3, str, true);
            AppMethodBeat.m2505o(35058);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            linkedList.add(list.get(i3));
        }
        Assert.assertTrue(linkedList.size() > 0);
        str22 = C4996ah.getContext().getString(C25738R.string.ajw);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list2);
        C30379h.m48445a((Context) mMCreateChatroomUI, mMCreateChatroomUI.getString(C25738R.string.bxl, new Object[]{C5046bo.m7536c(MMCreateChatroomUI.m70870O(arrayList), str22)}), mMCreateChatroomUI.getString(C25738R.string.cm_), mMCreateChatroomUI.getString(C25738R.string.bxk), mMCreateChatroomUI.getString(C25738R.string.bxj), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(35043);
                MMCreateChatroomUI.m70874a(MMCreateChatroomUI.this, linkedList);
                AppMethodBeat.m2505o(35043);
            }
        }, null);
        AppMethodBeat.m2505o(35058);
    }
}
