package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class w extends o implements b {
    private final String csB;
    private Cursor gnQ;
    private HashMap<String, Integer> zkO = null;
    private SparseArray<String> zkP = null;
    private a zok;

    public static class a {
    }

    public w(String str, MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z) {
        super((l) mMBaseSelectContactUI, (List) list, false, z, false);
        AppMethodBeat.i(33814);
        this.csB = str;
        this.zok = new a();
        ((j) g.K(j.class)).XM().a(this);
        Km();
        AppMethodBeat.o(33814);
    }

    private static ArrayList<ad> arQ(String str) {
        AppMethodBeat.i(33815);
        aw.ZK();
        Cursor aoL = c.XM().aoL(str);
        ArrayList arrayList = new ArrayList();
        if (aoL.moveToFirst()) {
            do {
                ad adVar = new ad();
                adVar.d(aoL);
                arrayList.add(adVar);
            } while (aoL.moveToNext());
        }
        aoL.close();
        AppMethodBeat.o(33815);
        return arrayList;
    }

    private void Km() {
        int i;
        AppMethodBeat.i(33816);
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
        List vm = ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().vm(this.csB);
        aw.ZK();
        arrayList.add(c.XM().a(this.elZ, aa.gw(ah.getContext()), vm));
        arQ("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
        aw.ZK();
        Cursor b = c.XM().b(this.elZ, aa.gw(ah.getContext()), vm);
        int[] iArr = new int[b.getCount()];
        if (b.moveToFirst()) {
            i = 0;
            do {
                iArr[i] = b.getInt(0);
                i++;
            } while (b.moveToNext());
        }
        b.close();
        aw.ZK();
        Cursor c = c.XM().c(this.elZ, aa.gw(ah.getContext()), vm);
        if (c.moveToFirst()) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                ad adVar = new ad();
                adVar.d(c);
                bM(i3, ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).ba(this.csB, adVar.field_descWordingId));
                i3 = iArr[i2] + (i3 + 1);
                i = i2 + 1;
                if (!c.moveToNext()) {
                    break;
                }
                i2 = i;
            }
        }
        c.close();
        ab.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", this.zkO.toString());
        this.gnQ = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(33816);
    }

    private void bM(int i, String str) {
        AppMethodBeat.i(33817);
        this.zkO.put(str, Integer.valueOf(i));
        this.zkP.put(i, str);
        AppMethodBeat.o(33817);
    }

    public final int arM(String str) {
        AppMethodBeat.i(33818);
        if (str.equals("↑")) {
            AppMethodBeat.o(33818);
            return 0;
        } else if (this.zkO == null) {
            AppMethodBeat.o(33818);
            return -1;
        } else if (this.zkO.containsKey(str)) {
            int intValue = ((Integer) this.zkO.get(str)).intValue() + this.zmV.getContentLV().getHeaderViewsCount();
            AppMethodBeat.o(33818);
            return intValue;
        } else {
            AppMethodBeat.o(33818);
            return -1;
        }
    }

    public final int getCount() {
        AppMethodBeat.i(33819);
        int count = this.gnQ.getCount() + this.zkO.size();
        AppMethodBeat.o(33819);
        return count;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(33820);
        if (this.zkP.indexOfKey(i) >= 0) {
            String str = (String) this.zkP.get(i);
            com.tencent.mm.ui.contact.a.a hVar = new h(i);
            hVar.mKQ = str;
            AppMethodBeat.o(33820);
            return hVar;
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
            ab.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i2));
            ad adVar = new ad();
            adVar.d(this.gnQ);
            com.tencent.mm.ui.contact.a.a eVar = new e(i);
            eVar.ehM = adVar;
            eVar.zmW = clI();
            eVar.zmX = this.zmX;
            eVar.zpP = true;
            AppMethodBeat.o(33820);
            return eVar;
        }
        ab.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i2));
        AppMethodBeat.o(33820);
        return null;
    }

    public final void finish() {
        AppMethodBeat.i(33821);
        super.finish();
        ab.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        ((j) g.K(j.class)).XM().b(this);
        AppMethodBeat.o(33821);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(33822);
        Km();
        notifyDataSetChanged();
        AppMethodBeat.o(33822);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(33823);
        if (this.zkP.indexOfKey(aVar.position + 1) >= 0) {
            AppMethodBeat.o(33823);
            return true;
        }
        AppMethodBeat.o(33823);
        return false;
    }
}
