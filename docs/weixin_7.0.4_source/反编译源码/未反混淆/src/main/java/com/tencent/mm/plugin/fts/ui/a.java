package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class a extends b implements l {
    HashSet<String> mEu = new HashSet();
    private com.tencent.mm.plugin.fts.a.a.a mEx;
    public List<com.tencent.mm.plugin.fts.a.d.e.a> mHp = Collections.synchronizedList(new LinkedList());
    protected String query;

    public abstract com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet);

    public abstract com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar);

    public abstract void a(j jVar, HashSet<String> hashSet);

    public a(Context context, e.b bVar, int i) {
        super(context, bVar, i);
    }

    public final void a(String str, ak akVar, HashSet<String> hashSet) {
        bAr();
        clearData();
        this.query = str;
        this.mEx = a(akVar, (HashSet) hashSet);
    }

    public final void bAr() {
        if (this.mEx != null) {
            ((n) g.M(n.class)).cancelSearchTask(this.mEx);
            this.mEx = null;
        }
    }

    public int vY(int i) {
        int size = this.mHp.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            int i4;
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.mHp.get(i2);
            aVar.mFb = i3;
            if (aVar.mFc) {
                i3++;
            }
            i3 += aVar.mFf.size() + aVar.mFi;
            aVar.mFd = i3;
            if (aVar.mFe) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return i3;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a vZ(int i) {
        int size = this.mHp.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.mm.plugin.fts.a.d.a.a b;
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.mHp.get(i2);
            if (aVar.mFb == i && aVar.mFc) {
                b = b(i, aVar);
            } else if (aVar.mFd == i && aVar.mFe) {
                b = c(i, aVar);
            } else if (i <= aVar.mFd) {
                b = a(i, aVar);
            } else {
                b = null;
            }
            if (b != null) {
                if (b.position == aVar.mFd) {
                    b.mFk = false;
                }
                b.mFa = this.mFa;
                b.mDz = aVar.mDz;
                b.mFl = aVar.businessType;
                return b;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public k b(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        return new k(i);
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.fts.ui.a.n c(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        com.tencent.mm.plugin.fts.ui.a.n nVar = new com.tencent.mm.plugin.fts.ui.a.n(i);
        nVar.mFn = aVar.mFd - aVar.mFb;
        nVar.mFt = true;
        return nVar;
    }

    public final void clearData() {
        this.query = null;
        this.mEu.clear();
        this.mHp.clear();
    }

    public final void b(j jVar) {
        switch (jVar.bFZ) {
            case -3:
            case -2:
            case -1:
                ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", Integer.valueOf(getType()), Integer.valueOf(jVar.bFZ), jVar.mAJ.query);
                if (!jVar.mAJ.query.equals(this.query)) {
                    ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
                    return;
                }
                break;
            case 0:
                ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", Integer.valueOf(getType()), Integer.valueOf(jVar.mEy.size()));
                if (this.query != null && this.query.equals(jVar.mAJ.query)) {
                    this.mEu = jVar.mAJ.mEu;
                    a(jVar, this.mEu);
                    break;
                }
                ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", jVar.mAJ.query, this.query);
                return;
            default:
                return;
        }
        this.mEZ.a(this, jVar.mAJ.query);
    }

    public final LinkedList<Integer> bAs() {
        LinkedList linkedList = new LinkedList();
        int size = this.mHp.size();
        for (int i = 0; i < size; i++) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.mHp.get(i);
            if (aVar.mFb != BaseClientBuilder.API_PRIORITY_OTHER) {
                linkedList.add(Integer.valueOf(aVar.mFb));
            }
        }
        return linkedList;
    }

    public com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, com.tencent.mm.plugin.fts.a.a.l lVar, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        return null;
    }

    public final int bAK() {
        int size = this.mHp.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            for (com.tencent.mm.plugin.fts.a.a.l lVar : ((com.tencent.mm.plugin.fts.a.d.e.a) this.mHp.get(i2)).mFf) {
                String bc = bo.bc(lVar.mDx, "");
                Object obj = -1;
                switch (bc.hashCode()) {
                    case -19329355:
                        if (bc.equals("create_chatroom​")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 255180560:
                        if (bc.equals("no_result​")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 541269703:
                        if (bc.equals("create_talker_message​")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                    case 1:
                    case 2:
                        break;
                    default:
                        i++;
                        break;
                }
            }
        }
        return i;
    }

    public final int bAt() {
        return bAK();
    }
}
