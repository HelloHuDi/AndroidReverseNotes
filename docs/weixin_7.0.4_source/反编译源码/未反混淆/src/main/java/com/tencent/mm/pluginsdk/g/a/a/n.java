package com.tencent.mm.pluginsdk.g.a.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.g.a.a.a.a;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n extends m implements k {
    protected static final SparseArray<a> veP = new SparseArray();
    private volatile f ehi;
    protected final List<btc> veO = new LinkedList();

    public abstract q diq();

    public abstract String getTag();

    public abstract rr i(q qVar);

    public static void a(a aVar) {
        veP.put(39, aVar);
    }

    n() {
        for (int i : i.vep) {
            a aVar = (a) veP.get(i);
            if (aVar == null || !aVar.rO(i)) {
                btc btc = new btc();
                btc.jCt = i;
                this.veO.add(btc);
            }
        }
    }

    public final int a(e eVar, f fVar) {
        this.ehi = fVar;
        ab.d(getTag(), "before dispatch");
        for (btc btc : this.veO) {
            com.tencent.mm.sdk.e.e eVar2;
            int i = btc.jCt;
            com.tencent.mm.pluginsdk.g.a.c.q diy = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA;
            if (diy.hrm) {
                eVar2 = diy.vfx.fni;
            } else {
                eVar2 = null;
            }
            List emptyList;
            if (eVar2 == null) {
                emptyList = Collections.emptyList();
            } else {
                Cursor a = eVar2.a("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[]{Integer.valueOf(i)}) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[]{"CheckResUpdate"}), null, null, null, null, 2);
                if (a == null || a.isClosed()) {
                    emptyList = Collections.emptyList();
                } else {
                    if (a.moveToFirst()) {
                        emptyList = new LinkedList();
                        do {
                            s sVar = new s();
                            sVar.d(a);
                            emptyList.add(sVar);
                        } while (a.moveToNext());
                    } else {
                        emptyList = Collections.emptyList();
                    }
                    a.close();
                }
            }
            StringBuilder stringBuilder = new StringBuilder("{ ");
            for (s sVar2 : emptyList) {
                int i2 = bo.getInt(sVar2.field_fileVersion, -1);
                if (i2 >= 0) {
                    bta bta = new bta();
                    bta.wOI = sVar2.field_subType;
                    bta.wVf = i2;
                    bta.wVd = sVar2.field_keyVersion;
                    bta.vek = sVar2.field_EID;
                    btc.wVk.add(bta);
                    stringBuilder.append(sVar2.field_subType).append(", ");
                }
            }
            stringBuilder.append(" }");
            ab.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", stringBuilder.toString(), Integer.valueOf(btc.jCt));
        }
        return a(eVar, diq(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ab.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            rr i4 = i(qVar);
            String tag = getTag();
            String str2 = "response.Res.size() = %s";
            Object[] objArr = new Object[1];
            objArr[0] = bo.ek(i4.vYY) ? BuildConfig.COMMAND : String.valueOf(i4.vYY.size());
            ab.i(tag, str2, objArr);
            if (!bo.ek(i4.vYY)) {
                final LinkedList linkedList = i4.vYY;
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(79558);
                        for (btb btb : linkedList) {
                            String tag = n.this.getTag();
                            String str = "resType(%d) responses.size() = %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(btb.jCt);
                            objArr[1] = bo.ek(btb.wVj) ? BuildConfig.COMMAND : String.valueOf(btb.wVj.size());
                            ab.i(tag, str, objArr);
                            if (!bo.ek(btb.wVj)) {
                                Iterator it = btb.wVj.iterator();
                                while (it.hasNext()) {
                                    n.a(n.this, btb.jCt, (bsw) it.next());
                                }
                            }
                        }
                        AppMethodBeat.o(79558);
                    }
                }, "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
    }

    static /* synthetic */ void a(n nVar, int i, bsw bsw) {
        if (bsw != null) {
            ab.i(nVar.getTag(), "resType = %d, subType = %d, res.Oper = %d", Integer.valueOf(i), Integer.valueOf(bsw.wOI), Integer.valueOf(bsw.wpk));
            if (bsw.wUV != null) {
                ab.i(nVar.getTag(), "resource.Info.FileFlag %d ", Integer.valueOf(bsw.wUV.wVg));
            }
            if (b.KC(bsw.wpk)) {
                ab.i(nVar.getTag(), "just do nothing");
                return;
            }
            if (b.KD(bsw.wpk)) {
                ab.i(nVar.getTag(), "do cache");
                c.veg.b(i, bsw, false);
            }
            if (b.KE(bsw.wpk)) {
                ab.i(nVar.getTag(), "do decrypt");
                c.veg.a(i, bsw, false, false);
            }
            if (b.KF(bsw.wpk)) {
                ab.i(nVar.getTag(), "do delete");
                c.veg.a(i, bsw, false);
            }
        }
    }
}
