package com.tencent.p177mm.plugin.sns.p520ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p1025h.C21895a;
import com.tencent.p177mm.protocal.protobuf.C35917fq;
import com.tencent.p177mm.protocal.protobuf.C40509db;
import com.tencent.p177mm.protocal.protobuf.ary;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.g */
public final class C36817g extends C35120d<bau> {
    private List<bau> list = new ArrayList();
    private String nJy = "";
    private String path = "";
    private C40509db rgA;
    private C29214a rgB;
    private int rgh = 0;
    private int rgi = 0;
    private C35917fq rgz;

    /* renamed from: com.tencent.mm.plugin.sns.ui.g$a */
    public interface C29214a {
        /* renamed from: a */
        void mo37673a(List<bau> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, C35917fq c35917fq);

        void crw();
    }

    public C36817g(C29214a c29214a) {
        AppMethodBeat.m2504i(38091);
        this.rgB = c29214a;
        AppMethodBeat.m2505o(38091);
    }

    /* renamed from: dq */
    public final void mo55749dq(List<bau> list) {
        AppMethodBeat.m2504i(38092);
        if (this.rgB != null) {
            if (list != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap.clear();
                hashMap2.clear();
                int size = list.size();
                C4990ab.m7410d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(size)));
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
                C4990ab.m7410d("MicroMsg.ArtistAdapterHelper", "icount " + this.rgh);
                this.list = list;
                this.rgB.mo37673a(this.list, hashMap, hashMap2, this.rgi, this.rgh, this.rgz);
                AppMethodBeat.m2505o(38092);
                return;
            }
            this.rgB.crw();
        }
        AppMethodBeat.m2505o(38092);
    }

    /* renamed from: Kx */
    public final List<bau> mo55747Kx() {
        AppMethodBeat.m2504i(38093);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.rgA = null;
            String str = this.path + this.nJy + "_ARTISTF.mm";
            if (C5730e.m8628ct(str)) {
                this.rgA = (C40509db) new C40509db().parseFrom(C5730e.m8632e(str, 0, -1));
            }
            if (this.rgA == null) {
                String str2 = this.path + this.nJy + "_ARTIST.mm";
                this.rgA = C21895a.m33456YD(new String(C5730e.m8632e(str2, 0, (int) C5730e.asZ(str2))));
                if (this.rgA == null) {
                    C5730e.deleteFile(str2);
                    AppMethodBeat.m2505o(38093);
                    return null;
                }
                C5730e.deleteFile(str);
                byte[] toByteArray = this.rgA.toByteArray();
                C5730e.m8624b(str, toByteArray, toByteArray.length);
            }
            if (this.rgA == null) {
                AppMethodBeat.m2505o(38093);
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
            AppMethodBeat.m2505o(38093);
            return arrayList;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ArtistAdapterHelper", e, "loadData failed.", new Object[0]);
            AppMethodBeat.m2505o(38093);
            return null;
        }
    }

    /* renamed from: gs */
    public final void mo58678gs(String str, String str2) {
        AppMethodBeat.m2504i(38094);
        this.nJy = str;
        this.path = str2;
        mo55750hM(true);
        AppMethodBeat.m2505o(38094);
    }
}
