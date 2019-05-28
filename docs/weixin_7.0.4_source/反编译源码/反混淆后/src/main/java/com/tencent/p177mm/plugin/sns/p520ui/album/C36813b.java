package com.tencent.p177mm.plugin.sns.p520ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.p520ui.C29198aw;
import com.tencent.p177mm.plugin.sns.p520ui.C35120d;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35095a.C29189b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.sns.ui.album.b */
public final class C36813b extends C35120d<C29189b> {
    private boolean czr = false;
    private String lQD = "";
    private Map<String, List<C46236n>> map = new LinkedHashMap();
    private C36814a rFC = null;
    private boolean rwo = false;
    private String userName = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.b$a */
    public interface C36814a {
        /* renamed from: dt */
        void mo55735dt(List<C29189b> list);
    }

    public C36813b(C36814a c36814a, String str, boolean z) {
        AppMethodBeat.m2504i(39976);
        this.rFC = c36814a;
        this.userName = str;
        this.czr = z;
        AppMethodBeat.m2505o(39976);
    }

    /* renamed from: g */
    public final void mo58677g(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(39977);
        C4990ab.m7410d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(str)));
        this.lQD = str;
        this.rwo = z;
        mo55750hM(z2);
        AppMethodBeat.m2505o(39977);
    }

    /* renamed from: dq */
    public final void mo55749dq(List<C29189b> list) {
        AppMethodBeat.m2504i(39978);
        if (this.rFC != null) {
            this.rFC.mo55735dt(list);
        }
        AppMethodBeat.m2505o(39978);
    }

    /* renamed from: Kx */
    public final List<C29189b> mo55747Kx() {
        AppMethodBeat.m2504i(39979);
        this.map.clear();
        ArrayList arrayList = new ArrayList();
        C4990ab.m7417i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", Boolean.valueOf(this.czr), this.lQD, Boolean.valueOf(this.rwo));
        for (C46236n c46236n : C34955aj.m57402c(this.userName, this.czr, this.lQD)) {
            if (!((c46236n.field_type != 1 && c46236n.field_type != 15) || c46236n.cqu() == null || c46236n.cqu().xfI == null || c46236n.cqu().xfI.wbK.isEmpty())) {
                String charSequence = C29198aw.m46375kL(1000 * ((long) c46236n.field_createTime)).toString();
                C4990ab.m7417i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", charSequence, Long.valueOf(r6 * 1000), Long.valueOf(c46236n.field_snsId));
                List list = (List) this.map.get(charSequence);
                if (list == null) {
                    list = new ArrayList();
                    this.map.put(charSequence, list);
                }
                list.add(c46236n);
            }
        }
        for (Entry entry : this.map.entrySet()) {
            C29189b c29189b = new C29189b();
            c29189b.label = (String) entry.getKey();
            c29189b.rFt = (List) entry.getValue();
            C4990ab.m7417i("MicroMsg.SnsAlbumAdapterHelper", "%s", c29189b);
            arrayList.add(c29189b);
        }
        C4990ab.m7417i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(r3.size()), Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(39979);
        return arrayList;
    }
}
