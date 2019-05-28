package com.tencent.p177mm.p612ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.PluginOpenIM;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p612ui.contact.p625a.C15819h;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.w */
public final class C46676w extends C40845o implements C4937b {
    private final String csB;
    private Cursor gnQ;
    private HashMap<String, Integer> zkO = null;
    private SparseArray<String> zkP = null;
    private C40848a zok;

    /* renamed from: com.tencent.mm.ui.contact.w$a */
    public static class C40848a {
    }

    public C46676w(String str, MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z) {
        super((C36251l) mMBaseSelectContactUI, (List) list, false, z, false);
        AppMethodBeat.m2504i(33814);
        this.csB = str;
        this.zok = new C40848a();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this);
        m88400Km();
        AppMethodBeat.m2505o(33814);
    }

    private static ArrayList<C7616ad> arQ(String str) {
        AppMethodBeat.m2504i(33815);
        C9638aw.m17190ZK();
        Cursor aoL = C18628c.m29078XM().aoL(str);
        ArrayList arrayList = new ArrayList();
        if (aoL.moveToFirst()) {
            do {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(aoL);
                arrayList.add(c7616ad);
            } while (aoL.moveToNext());
        }
        aoL.close();
        AppMethodBeat.m2505o(33815);
        return arrayList;
    }

    /* renamed from: Km */
    private void m88400Km() {
        int i;
        AppMethodBeat.m2504i(33816);
        if (this.zkO != null) {
            this.zkO.clear();
        } else {
            this.zkO = new HashMap();
        }
        if (this.zkP != null) {
            this.zkP.clear();
        } else {
            this.zkP = new SparseArray();
        }
        ArrayList arrayList = new ArrayList();
        List vm = ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo67778vm(this.csB);
        C9638aw.m17190ZK();
        arrayList.add(C18628c.m29078XM().mo15704a(this.elZ, C4988aa.m7403gw(C4996ah.getContext()), vm));
        C46676w.arQ("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
        C9638aw.m17190ZK();
        Cursor b = C18628c.m29078XM().mo15728b(this.elZ, C4988aa.m7403gw(C4996ah.getContext()), vm);
        int[] iArr = new int[b.getCount()];
        if (b.moveToFirst()) {
            i = 0;
            do {
                iArr[i] = b.getInt(0);
                i++;
            } while (b.moveToNext());
        }
        b.close();
        C9638aw.m17190ZK();
        Cursor c = C18628c.m29078XM().mo15735c(this.elZ, C4988aa.m7403gw(C4996ah.getContext()), vm);
        if (c.moveToFirst()) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(c);
                m88401bM(i3, ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(this.csB, c7616ad.field_descWordingId));
                i3 = iArr[i2] + (i3 + 1);
                i = i2 + 1;
                if (!c.moveToNext()) {
                    break;
                }
                i2 = i;
            }
        }
        c.close();
        C4990ab.m7411d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", this.zkO.toString());
        this.gnQ = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.m2505o(33816);
    }

    /* renamed from: bM */
    private void m88401bM(int i, String str) {
        AppMethodBeat.m2504i(33817);
        this.zkO.put(str, Integer.valueOf(i));
        this.zkP.put(i, str);
        AppMethodBeat.m2505o(33817);
    }

    public final int arM(String str) {
        AppMethodBeat.m2504i(33818);
        if (str.equals("↑")) {
            AppMethodBeat.m2505o(33818);
            return 0;
        } else if (this.zkO == null) {
            AppMethodBeat.m2505o(33818);
            return -1;
        } else if (this.zkO.containsKey(str)) {
            int intValue = ((Integer) this.zkO.get(str)).intValue() + this.zmV.getContentLV().getHeaderViewsCount();
            AppMethodBeat.m2505o(33818);
            return intValue;
        } else {
            AppMethodBeat.m2505o(33818);
            return -1;
        }
    }

    public final int getCount() {
        AppMethodBeat.m2504i(33819);
        int count = this.gnQ.getCount() + this.zkO.size();
        AppMethodBeat.m2505o(33819);
        return count;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(33820);
        if (this.zkP.indexOfKey(i) >= 0) {
            String str = (String) this.zkP.get(i);
            C5445a c15819h = new C15819h(i);
            c15819h.mKQ = str;
            AppMethodBeat.m2505o(33820);
            return c15819h;
        }
        int i2 = 0;
        int i3 = i;
        while (i2 <= this.zkP.size()) {
            if (this.zkP.indexOfKey(i3) >= 0) {
                i2++;
            }
            i3--;
            if (i3 < 0) {
                break;
            }
        }
        if (this.gnQ.moveToPosition(i - i2)) {
            C4990ab.m7411d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i2));
            C7616ad c7616ad = new C7616ad();
            c7616ad.mo8995d(this.gnQ);
            C5445a c40843e = new C40843e(i);
            c40843e.ehM = c7616ad;
            c40843e.zmW = clI();
            c40843e.zmX = this.zmX;
            c40843e.zpP = true;
            AppMethodBeat.m2505o(33820);
            return c40843e;
        }
        C4990ab.m7417i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i2));
        AppMethodBeat.m2505o(33820);
        return null;
    }

    public final void finish() {
        AppMethodBeat.m2504i(33821);
        super.finish();
        C4990ab.m7416i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        AppMethodBeat.m2505o(33821);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(33822);
        m88400Km();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(33822);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final boolean mo39696c(C5445a c5445a) {
        AppMethodBeat.m2504i(33823);
        if (this.zkP.indexOfKey(c5445a.position + 1) >= 0) {
            AppMethodBeat.m2505o(33823);
            return true;
        }
        AppMethodBeat.m2505o(33823);
        return false;
    }
}
