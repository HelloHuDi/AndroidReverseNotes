package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g extends d<bau> {
    private List<bau> list = new ArrayList();
    private String nJy = "";
    private String path = "";
    private db rgA;
    private a rgB;
    private int rgh = 0;
    private int rgi = 0;
    private fq rgz;

    public interface a {
        void a(List<bau> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, fq fqVar);

        void crw();
    }

    public g(a aVar) {
        AppMethodBeat.i(38091);
        this.rgB = aVar;
        AppMethodBeat.o(38091);
    }

    public final void dq(List<bau> list) {
        AppMethodBeat.i(38092);
        if (this.rgB != null) {
            if (list != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap.clear();
                hashMap2.clear();
                int size = list.size();
                ab.d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(size)));
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < size) {
                    int i4;
                    String str = ((bau) list.get(i)).Desc;
                    if (i + 1 >= size) {
                        i4 = 1;
                    } else if (!str.equals(((bau) list.get(i + 1)).Desc)) {
                        i4 = 1;
                    } else if (i + 2 >= size) {
                        i4 = 2;
                    } else if (str.equals(((bau) list.get(i + 2)).Desc)) {
                        i4 = 3;
                    } else {
                        i4 = 2;
                    }
                    hashMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
                    hashMap2.put(Integer.valueOf(i2), Integer.valueOf(i4));
                    i3 += i4;
                    i2++;
                    i = i4 + i;
                }
                this.rgh = i2 + 1;
                this.rgi = list.size();
                ab.d("MicroMsg.ArtistAdapterHelper", "icount " + this.rgh);
                this.list = list;
                this.rgB.a(this.list, hashMap, hashMap2, this.rgi, this.rgh, this.rgz);
                AppMethodBeat.o(38092);
                return;
            }
            this.rgB.crw();
        }
        AppMethodBeat.o(38092);
    }

    public final List<bau> Kx() {
        AppMethodBeat.i(38093);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.rgA = null;
            String str = this.path + this.nJy + "_ARTISTF.mm";
            if (e.ct(str)) {
                this.rgA = (db) new db().parseFrom(e.e(str, 0, -1));
            }
            if (this.rgA == null) {
                String str2 = this.path + this.nJy + "_ARTIST.mm";
                this.rgA = com.tencent.mm.plugin.sns.h.a.YD(new String(e.e(str2, 0, (int) e.asZ(str2))));
                if (this.rgA == null) {
                    e.deleteFile(str2);
                    AppMethodBeat.o(38093);
                    return null;
                }
                e.deleteFile(str);
                byte[] toByteArray = this.rgA.toByteArray();
                e.b(str, toByteArray, toByteArray.length);
            }
            if (this.rgA == null) {
                AppMethodBeat.o(38093);
                return null;
            }
            Iterator it = this.rgA.vFk.iterator();
            while (it.hasNext()) {
                ary ary = (ary) it.next();
                String str3 = ary.Name;
                Iterator it2 = ary.wbK.iterator();
                while (it2.hasNext()) {
                    bau bau = (bau) it2.next();
                    bau.Desc = str3;
                    arrayList.add(bau);
                }
            }
            this.rgz = this.rgA.vFj;
            AppMethodBeat.o(38093);
            return arrayList;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ArtistAdapterHelper", e, "loadData failed.", new Object[0]);
            AppMethodBeat.o(38093);
            return null;
        }
    }

    public final void gs(String str, String str2) {
        AppMethodBeat.i(38094);
        this.nJy = str;
        this.path = str2;
        hM(true);
        AppMethodBeat.o(38094);
    }
}
