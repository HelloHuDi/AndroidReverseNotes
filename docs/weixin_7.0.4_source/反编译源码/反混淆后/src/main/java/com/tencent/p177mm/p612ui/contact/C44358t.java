package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.PluginOpenIM;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p877e.C42247d;
import com.tencent.p177mm.p213cd.C6394d;
import com.tencent.p177mm.p213cd.p214a.C1354d;
import com.tencent.p177mm.p213cd.p214a.C37629e;
import com.tencent.p177mm.p213cd.p214a.C7595f;
import com.tencent.p177mm.p612ui.contact.C15824a.C15825b;
import com.tencent.p177mm.p612ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40629f;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.t */
public final class C44358t extends C15824a {
    private HashSet<String> zod = new HashSet();
    private String zoe;
    OpenIMAddressUIFragment zof;

    public C44358t(Context context, String str, String str2) {
        super(context, str, null, 2);
        AppMethodBeat.m2504i(33801);
        this.zoe = str2;
        AppMethodBeat.m2505o(33801);
    }

    /* Access modifiers changed, original: protected|final */
    public final Cursor dHv() {
        AppMethodBeat.m2504i(33802);
        long currentTimeMillis = System.currentTimeMillis();
        C1720g.m3537RQ();
        C42247d appIdInfoStg = ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg();
        String str = this.zoe;
        List linkedList = new LinkedList();
        Cursor a = appIdInfoStg.fni.mo10104a("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[]{str}, 2);
        if (a.moveToFirst()) {
            do {
                str = a.getString(0);
                if (!C5046bo.isNullOrNil(str)) {
                    linkedList.add(str);
                }
            } while (a.moveToNext());
        }
        a.close();
        C9638aw.m17190ZK();
        Cursor a2 = C18628c.m29078XM().mo15704a(this.elZ, C4988aa.m7403gw(C4996ah.getContext()), linkedList);
        if (a2 instanceof C7595f) {
            a2 = new C37629e(new C1354d[]{(C1354d) C6394d.dvo(), (C7595f) a2});
        }
        C4990ab.m7410d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(33802);
        return a2;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final int mo28030a(C40629f c40629f, int i) {
        AppMethodBeat.m2504i(33803);
        if (c40629f == null) {
            C4990ab.m7413e("OpenIMContactAdapter", "contact is null, position:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(33803);
            return -1;
        } else if (C5046bo.isNullOrNil(c40629f.field_descWording)) {
            AppMethodBeat.m2505o(33803);
            return -1;
        } else {
            int hashCode = c40629f.field_descWording.hashCode();
            AppMethodBeat.m2505o(33803);
            return hashCode;
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(33806);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(33806);
            return;
        }
        C9638aw.m17190ZK();
        if (c7298n == C18628c.m29078XM()) {
            if (C7616ad.aox((String) obj)) {
                this.zof.zks = true;
                AppMethodBeat.m2505o(33806);
                return;
            }
            C4990ab.m7410d("OpenIMContactAdapter", "newcursor is not openim ，return");
        }
        AppMethodBeat.m2505o(33806);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final String mo28035b(C40629f c40629f, int i) {
        AppMethodBeat.m2504i(33804);
        String str = c40629f.field_descWording;
        if (C5046bo.isNullOrNil(str)) {
            str = "#";
            AppMethodBeat.m2505o(33804);
            return str;
        }
        AppMethodBeat.m2505o(33804);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo28031a(C40629f c40629f, C15825b c15825b) {
        AppMethodBeat.m2504i(33805);
        String str = c40629f.field_descWordingId;
        if (this.zod.contains(str)) {
            AppMethodBeat.m2505o(33805);
            return;
        }
        this.zod.add(str);
        ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(c40629f.field_openImAppid, str);
        AppMethodBeat.m2505o(33805);
    }
}
