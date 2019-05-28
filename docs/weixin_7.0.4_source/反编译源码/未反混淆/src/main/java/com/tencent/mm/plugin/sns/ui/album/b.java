package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b extends d<com.tencent.mm.plugin.sns.ui.album.a.b> {
    private boolean czr = false;
    private String lQD = "";
    private Map<String, List<n>> map = new LinkedHashMap();
    private a rFC = null;
    private boolean rwo = false;
    private String userName = "";

    public interface a {
        void dt(List<com.tencent.mm.plugin.sns.ui.album.a.b> list);
    }

    public b(a aVar, String str, boolean z) {
        AppMethodBeat.i(39976);
        this.rFC = aVar;
        this.userName = str;
        this.czr = z;
        AppMethodBeat.o(39976);
    }

    public final void g(String str, boolean z, boolean z2) {
        AppMethodBeat.i(39977);
        ab.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(str)));
        this.lQD = str;
        this.rwo = z;
        hM(z2);
        AppMethodBeat.o(39977);
    }

    public final void dq(List<com.tencent.mm.plugin.sns.ui.album.a.b> list) {
        AppMethodBeat.i(39978);
        if (this.rFC != null) {
            this.rFC.dt(list);
        }
        AppMethodBeat.o(39978);
    }

    public final List<com.tencent.mm.plugin.sns.ui.album.a.b> Kx() {
        AppMethodBeat.i(39979);
        this.map.clear();
        ArrayList arrayList = new ArrayList();
        ab.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", Boolean.valueOf(this.czr), this.lQD, Boolean.valueOf(this.rwo));
        for (n nVar : aj.c(this.userName, this.czr, this.lQD)) {
            if (!((nVar.field_type != 1 && nVar.field_type != 15) || nVar.cqu() == null || nVar.cqu().xfI == null || nVar.cqu().xfI.wbK.isEmpty())) {
                String charSequence = aw.kL(1000 * ((long) nVar.field_createTime)).toString();
                ab.i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", charSequence, Long.valueOf(r6 * 1000), Long.valueOf(nVar.field_snsId));
                List list = (List) this.map.get(charSequence);
                if (list == null) {
                    list = new ArrayList();
                    this.map.put(charSequence, list);
                }
                list.add(nVar);
            }
        }
        for (Entry entry : this.map.entrySet()) {
            com.tencent.mm.plugin.sns.ui.album.a.b bVar = new com.tencent.mm.plugin.sns.ui.album.a.b();
            bVar.label = (String) entry.getKey();
            bVar.rFt = (List) entry.getValue();
            ab.i("MicroMsg.SnsAlbumAdapterHelper", "%s", bVar);
            arrayList.add(bVar);
        }
        ab.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(r3.size()), Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(39979);
        return arrayList;
    }
}
