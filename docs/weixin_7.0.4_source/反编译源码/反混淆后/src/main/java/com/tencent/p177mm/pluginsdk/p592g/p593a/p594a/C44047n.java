package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C30039i.C23235b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.p1667a.C46487a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.protocal.protobuf.C40567rr;
import com.tencent.p177mm.protocal.protobuf.bsw;
import com.tencent.p177mm.protocal.protobuf.bta;
import com.tencent.p177mm.protocal.protobuf.btb;
import com.tencent.p177mm.protocal.protobuf.btc;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.n */
public abstract class C44047n extends C1207m implements C1918k {
    protected static final SparseArray<C46487a> veP = new SparseArray();
    private volatile C1202f ehi;
    protected final List<btc> veO = new LinkedList();

    public abstract C1929q diq();

    public abstract String getTag();

    /* renamed from: i */
    public abstract C40567rr mo69735i(C1929q c1929q);

    /* renamed from: a */
    public static void m79171a(C46487a c46487a) {
        veP.put(39, c46487a);
    }

    C44047n() {
        for (int i : C30039i.vep) {
            C46487a c46487a = (C46487a) veP.get(i);
            if (c46487a == null || !c46487a.mo41609rO(i)) {
                btc btc = new btc();
                btc.jCt = i;
                this.veO.add(btc);
            }
        }
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        C4990ab.m7410d(getTag(), "before dispatch");
        for (btc btc : this.veO) {
            C4927e c4927e;
            int i = btc.jCt;
            C14856q diy = C14857a.vfA;
            if (diy.hrm) {
                c4927e = diy.vfx.fni;
            } else {
                c4927e = null;
            }
            List emptyList;
            if (c4927e == null) {
                emptyList = Collections.emptyList();
            } else {
                Cursor a = c4927e.mo10105a("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[]{Integer.valueOf(i)}) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[]{"CheckResUpdate"}), null, null, null, null, 2);
                if (a == null || a.isClosed()) {
                    emptyList = Collections.emptyList();
                } else {
                    if (a.moveToFirst()) {
                        emptyList = new LinkedList();
                        do {
                            C44049s c44049s = new C44049s();
                            c44049s.mo8995d(a);
                            emptyList.add(c44049s);
                        } while (a.moveToNext());
                    } else {
                        emptyList = Collections.emptyList();
                    }
                    a.close();
                }
            }
            StringBuilder stringBuilder = new StringBuilder("{ ");
            for (C44049s c44049s2 : emptyList) {
                int i2 = C5046bo.getInt(c44049s2.field_fileVersion, -1);
                if (i2 >= 0) {
                    bta bta = new bta();
                    bta.wOI = c44049s2.field_subType;
                    bta.wVf = i2;
                    bta.wVd = c44049s2.field_keyVersion;
                    bta.vek = c44049s2.field_EID;
                    btc.wVk.add(bta);
                    stringBuilder.append(c44049s2.field_subType).append(", ");
                }
            }
            stringBuilder.append(" }");
            C4990ab.m7417i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", stringBuilder.toString(), Integer.valueOf(btc.jCt));
        }
        return mo4457a(c1902e, diq(), this);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        C4990ab.m7417i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            C40567rr i4 = mo69735i(c1929q);
            String tag = getTag();
            String str2 = "response.Res.size() = %s";
            Object[] objArr = new Object[1];
            objArr[0] = C5046bo.m7548ek(i4.vYY) ? BuildConfig.COMMAND : String.valueOf(i4.vYY.size());
            C4990ab.m7417i(tag, str2, objArr);
            if (!C5046bo.m7548ek(i4.vYY)) {
                final LinkedList linkedList = i4.vYY;
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(79558);
                        for (btb btb : linkedList) {
                            String tag = C44047n.this.getTag();
                            String str = "resType(%d) responses.size() = %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(btb.jCt);
                            objArr[1] = C5046bo.m7548ek(btb.wVj) ? BuildConfig.COMMAND : String.valueOf(btb.wVj.size());
                            C4990ab.m7417i(tag, str, objArr);
                            if (!C5046bo.m7548ek(btb.wVj)) {
                                Iterator it = btb.wVj.iterator();
                                while (it.hasNext()) {
                                    C44047n.m79172a(C44047n.this, btb.jCt, (bsw) it.next());
                                }
                            }
                        }
                        AppMethodBeat.m2505o(79558);
                    }
                }, "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
    }

    /* renamed from: a */
    static /* synthetic */ void m79172a(C44047n c44047n, int i, bsw bsw) {
        if (bsw != null) {
            C4990ab.m7417i(c44047n.getTag(), "resType = %d, subType = %d, res.Oper = %d", Integer.valueOf(i), Integer.valueOf(bsw.wOI), Integer.valueOf(bsw.wpk));
            if (bsw.wUV != null) {
                C4990ab.m7417i(c44047n.getTag(), "resource.Info.FileFlag %d ", Integer.valueOf(bsw.wUV.wVg));
            }
            if (C23235b.m35630KC(bsw.wpk)) {
                C4990ab.m7416i(c44047n.getTag(), "just do nothing");
                return;
            }
            if (C23235b.m35631KD(bsw.wpk)) {
                C4990ab.m7416i(c44047n.getTag(), "do cache");
                C14845c.veg.mo27148b(i, bsw, false);
            }
            if (C23235b.m35632KE(bsw.wpk)) {
                C4990ab.m7416i(c44047n.getTag(), "do decrypt");
                C14845c.veg.mo27146a(i, bsw, false, false);
            }
            if (C23235b.m35633KF(bsw.wpk)) {
                C4990ab.m7416i(c44047n.getTag(), "do delete");
                C14845c.veg.mo27145a(i, bsw, false);
            }
        }
    }
}
