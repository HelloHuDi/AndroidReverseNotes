package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a extends o {
    private int count = 0;
    HashSet<String> gnG;
    ak handler = new ak(Looper.getMainLooper());
    l plf = new l() {
        public final void b(j jVar) {
            AppMethodBeat.i(35023);
            a aVar = new a(a.this, (byte) 0);
            aVar.query = jVar.mAJ.query;
            aVar.mDz = jVar.mDz;
            aVar.mEy = jVar.mEy;
            if (aVar.mEy == null || aVar.mEy.size() == 0) {
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = "no_result​";
                aVar.mEy = new ArrayList();
                aVar.mEy.add(lVar);
            }
            a.this.zIF.add(aVar);
            a.b(a.this);
            AppMethodBeat.o(35023);
        }
    };
    List<String> zID;
    List<com.tencent.mm.plugin.fts.a.a.a> zIE;
    List<a> zIF;

    class a {
        g mDz;
        List<com.tencent.mm.plugin.fts.a.a.l> mEy;
        int mFb;
        int mFd;
        boolean mFg;
        String query;
        String zII;

        private a() {
            this.mFb = BaseClientBuilder.API_PRIORITY_OTHER;
            this.mFd = BaseClientBuilder.API_PRIORITY_OTHER;
            this.mFg = true;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.a$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int zIH;

        AnonymousClass2(int i) {
            this.zIH = i;
        }

        public final void run() {
            AppMethodBeat.i(35024);
            a.a(a.this, this.zIH);
            AppMethodBeat.o(35024);
        }
    }

    static /* synthetic */ boolean a(a aVar, int i) {
        AppMethodBeat.i(35033);
        boolean PN = aVar.PN(i);
        AppMethodBeat.o(35033);
        return PN;
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(35032);
        aVar.dKd();
        AppMethodBeat.o(35032);
    }

    public a(com.tencent.mm.ui.contact.l lVar, List<String> list, int i) {
        super(lVar, null, true, true, i);
        AppMethodBeat.i(35025);
        this.zID = list;
        this.zIF = new ArrayList();
        this.gnG = new HashSet();
        AppMethodBeat.o(35025);
    }

    public final void finish() {
        AppMethodBeat.i(35026);
        super.finish();
        for (com.tencent.mm.plugin.fts.a.a.a cancelSearchTask : this.zIE) {
            ((n) com.tencent.mm.kernel.g.M(n.class)).cancelSearchTask(cancelSearchTask);
        }
        AppMethodBeat.o(35026);
    }

    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        com.tencent.mm.ui.contact.a.a hVar;
        AppMethodBeat.i(35027);
        com.tencent.mm.ui.contact.a.a aVar = null;
        int size = this.zIF.size() - 1;
        while (size >= 0) {
            a aVar2 = (a) this.zIF.get(size);
            if (aVar2.mFb == i) {
                hVar = new h(i);
                hVar.mKQ = this.zmV.getActivity().getString(R.string.e1x, new Object[]{aVar2.query});
            } else if (aVar2.mFd == i) {
                hVar = new com.tencent.mm.ui.contact.a.j(i);
                hVar.resId = R.string.c1k;
                hVar.mJY = aVar2.mFg;
            } else if (i > aVar2.mFb) {
                int i2 = (i - aVar2.mFb) - 1;
                com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) aVar2.mEy.get(i2);
                if (lVar.mDx.equals("no_result​")) {
                    hVar = new i(i);
                } else {
                    aVar = new e(i);
                    aVar.hpS = lVar;
                    aVar.mDz = aVar2.mDz;
                    aVar.eDk = true;
                    aVar.mFm = i2 + 1;
                    aVar.ej(aVar.hpS.type, aVar.hpS.mDw);
                    hVar = aVar;
                }
            } else {
                hVar = aVar;
            }
            if (hVar != null) {
                hVar.query = aVar2.query;
                hVar.scene = this.scene;
                hVar.zmW = true;
                break;
            }
            size--;
            aVar = hVar;
        }
        hVar = aVar;
        AppMethodBeat.o(35027);
        return hVar;
    }

    /* Access modifiers changed, original: final */
    public final void dKd() {
        AppMethodBeat.i(35028);
        int i = 0;
        Iterator it = this.zIF.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.mEy.size() > 0) {
                    aVar.mFb = i2;
                    i2++;
                    if (aVar.mEy.size() > 3) {
                        if (aVar.mFg) {
                            i2 += 3;
                        } else {
                            i2 += aVar.mEy.size();
                        }
                        aVar.mFd = i2;
                        i = i2 + 1;
                    } else {
                        i = aVar.mEy.size() + i2;
                    }
                } else {
                    i = i2;
                }
            } else {
                this.count = i2;
                clearCache();
                notifyDataSetChanged();
                AppMethodBeat.o(35028);
                return;
            }
        }
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean Po(int i) {
        AppMethodBeat.i(35029);
        boolean PN = PN(i);
        AppMethodBeat.o(35029);
        return PN;
    }

    public final List<String> dKe() {
        AppMethodBeat.i(35031);
        HashSet hashSet = new HashSet();
        for (a aVar : this.zIF) {
            if (!ah.isNullOrNil(aVar.zII)) {
                hashSet.add(aVar.zII);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        AppMethodBeat.o(35031);
        return arrayList;
    }

    private boolean PN(int i) {
        boolean z = false;
        AppMethodBeat.i(35030);
        int headerViewsCount = i - this.zmV.getContentLV().getHeaderViewsCount();
        int size = this.zIF.size() - 1;
        while (size >= 0) {
            a aVar = (a) this.zIF.get(size);
            if (aVar.mFd == headerViewsCount) {
                if (aVar.mFg) {
                    size = this.zmV.getContentLV().getSelectedItemPosition();
                    aVar.mFg = false;
                    dKd();
                    this.zmV.getContentLV().setSelection(size);
                } else {
                    Object obj;
                    aVar.mFg = true;
                    headerViewsCount = 0;
                    while (headerViewsCount < aVar.mEy.size()) {
                        obj = (com.tencent.mm.plugin.fts.a.a.l) aVar.mEy.get(headerViewsCount);
                        if (obj.mDx.equals(aVar.zII) && headerViewsCount > 2) {
                            break;
                        }
                        headerViewsCount++;
                    }
                    obj = null;
                    headerViewsCount = 0;
                    if (obj != null) {
                        aVar.mEy.remove(headerViewsCount);
                        aVar.mEy.add(0, obj);
                    }
                    dKd();
                    this.zmV.getContentLV().setSelection(i);
                }
                notifyDataSetChanged();
                z = true;
            } else if (headerViewsCount == aVar.mFb) {
                z = true;
                break;
            } else if (i > aVar.mFb) {
                com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) aVar.mEy.get((headerViewsCount - aVar.mFb) - 1);
                if (!lVar.mDx.equals("no_result​")) {
                    MMCreateChatroomUI mMCreateChatroomUI = (MMCreateChatroomUI) this.zmV;
                    if (ah.isNullOrNil(aVar.zII)) {
                        if (!this.gnG.contains(lVar.mDx)) {
                            mMCreateChatroomUI.opo.bU(lVar.mDx, false);
                            aVar.zII = lVar.mDx;
                            this.gnG.add(aVar.zII);
                        }
                    } else if (aVar.zII.equals(lVar.mDx)) {
                        mMCreateChatroomUI.opo.ajr(aVar.zII);
                        this.gnG.remove(aVar.zII);
                        aVar.zII = null;
                    } else if (!this.gnG.contains(lVar.mDx)) {
                        this.gnG.remove(aVar.zII);
                        mMCreateChatroomUI.opo.ajr(aVar.zII);
                        aVar.zII = lVar.mDx;
                        mMCreateChatroomUI.opo.bU(aVar.zII, false);
                        this.gnG.add(aVar.zII);
                    }
                    mMCreateChatroomUI.Kt();
                    notifyDataSetChanged();
                    z = true;
                }
                z = true;
            } else {
                size--;
            }
        }
        AppMethodBeat.o(35030);
        return z;
    }
}
