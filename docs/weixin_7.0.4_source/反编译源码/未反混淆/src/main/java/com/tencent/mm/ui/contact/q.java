package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q extends m {
    private int count = 0;
    private ak handler = new ak(Looper.getMainLooper());
    private g mDz;
    private a mEx;
    private List<l> mGW = null;
    private List<l> oov = null;
    private String query;
    private int zkK = BaseClientBuilder.API_PRIORITY_OTHER;
    private int zkL = BaseClientBuilder.API_PRIORITY_OTHER;
    private List<String> znn;
    private int zno = BaseClientBuilder.API_PRIORITY_OTHER;
    private int znp = BaseClientBuilder.API_PRIORITY_OTHER;
    private int znq = BaseClientBuilder.API_PRIORITY_OTHER;
    private boolean znr = true;
    private int zns = BaseClientBuilder.API_PRIORITY_OTHER;
    private boolean znt = true;
    private int znu = BaseClientBuilder.API_PRIORITY_OTHER;
    private List<l> znv = null;
    private List<l> znw = null;
    private List<Integer> znx;
    private com.tencent.mm.plugin.fts.a.l zny = new com.tencent.mm.plugin.fts.a.l() {
        public final void b(j jVar) {
            AppMethodBeat.i(105231);
            switch (jVar.bFZ) {
                case -3:
                case -2:
                case -1:
                    if (jVar.mAJ.query.equals(q.this.query)) {
                        q.c(q.this);
                        break;
                    } else {
                        AppMethodBeat.o(105231);
                        return;
                    }
                case 0:
                    if (q.this.mEx == null || !q.this.mEx.equals(q.this.mEx)) {
                        AppMethodBeat.o(105231);
                        return;
                    }
                    q.b(q.this);
                    q.this.mDz = jVar.mDz;
                    q.a(q.this, jVar.mEy);
                    q.this.znv = jVar.mEy;
                    d.bW(jVar.mEy);
                    q.a(q.this, jVar.mAJ.query, q.c(q.this));
                    AppMethodBeat.o(105231);
                    return;
            }
            AppMethodBeat.o(105231);
        }
    };
    protected com.tencent.mm.plugin.fts.a.l znz = new com.tencent.mm.plugin.fts.a.l() {
        public final void b(j jVar) {
            AppMethodBeat.i(105232);
            switch (jVar.bFZ) {
                case -3:
                case -2:
                case -1:
                    if (jVar.mAJ.query.equals(q.this.query)) {
                        q.c(q.this);
                        break;
                    } else {
                        AppMethodBeat.o(105232);
                        return;
                    }
                case 0:
                    if (q.this.mEx != null && q.this.mEx.equals(q.this.mEx)) {
                        q.this.mDz = jVar.mDz;
                        q.a(q.this, jVar.mEy);
                        if (jVar.mEy.size() > 0) {
                            switch (((l) jVar.mEy.get(0)).type) {
                                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                                    q.this.oov = jVar.mEy;
                                    break;
                                case 131075:
                                    q.this.mGW = jVar.mEy;
                                    break;
                                case 131076:
                                    q.this.znw = jVar.mEy;
                                    break;
                                case 131081:
                                    if (q.this.oov == null) {
                                        q.this.oov = jVar.mEy;
                                        break;
                                    } else {
                                        q.this.oov.addAll(jVar.mEy);
                                        break;
                                    }
                                default:
                                    ab.i("MicroMsg.MMSearchContactAdapter", "not support search");
                                    break;
                            }
                        }
                        q.a(q.this, jVar.mAJ.query, q.c(q.this));
                        AppMethodBeat.o(105232);
                        return;
                    }
            }
            AppMethodBeat.o(105232);
        }
    };

    static /* synthetic */ void b(q qVar) {
        AppMethodBeat.i(105247);
        qVar.dIe();
        AppMethodBeat.o(105247);
    }

    public q(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i) {
        super(mMBaseSelectContactUI, z, i);
        AppMethodBeat.i(105233);
        this.znn = list;
        this.znx = new ArrayList();
        ab.i("MicroMsg.MMSearchContactAdapter", "Create!");
        Kh();
        AppMethodBeat.o(105233);
    }

    public void ci(String str, boolean z) {
        AppMethodBeat.i(105234);
        if (this.zmU != null) {
            this.zmU.w(str, getCount(), z);
        }
        AppMethodBeat.o(105234);
    }

    public void a(String str, int[] iArr, boolean z) {
        AppMethodBeat.i(105235);
        clearTask();
        this.query = str;
        this.znx.clear();
        for (int valueOf : iArr) {
            this.znx.add(Integer.valueOf(valueOf));
        }
        HashSet hashSet = new HashSet();
        if (!z) {
            hashSet.add("filehelper");
        }
        ab.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", this.query);
        i iVar = new i();
        iVar.query = str;
        iVar.mEr = iArr;
        iVar.mEt = 3;
        iVar.mEw = this.zny;
        iVar.handler = this.handler;
        iVar.scene = 1;
        iVar.mEu = hashSet;
        this.mEx = ((n) com.tencent.mm.kernel.g.M(n.class)).search(1, iVar);
        AppMethodBeat.o(105235);
    }

    private void clearTask() {
        AppMethodBeat.i(105236);
        if (this.mEx != null) {
            ((n) com.tencent.mm.kernel.g.M(n.class)).cancelSearchTask(this.mEx);
            this.mEx = null;
        }
        AppMethodBeat.o(105236);
    }

    private void dIe() {
        AppMethodBeat.i(105237);
        this.znp = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znq = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znr = true;
        this.zns = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znt = true;
        this.znu = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        this.znv = null;
        this.oov = null;
        this.mGW = null;
        this.znw = null;
        this.mDz = null;
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(105237);
    }

    private void Kh() {
        AppMethodBeat.i(105238);
        ab.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.query = null;
        dIe();
        clearTask();
        clearCache();
        AppMethodBeat.o(105238);
    }

    public final void clearData() {
        AppMethodBeat.i(105239);
        Kh();
        AppMethodBeat.o(105239);
    }

    private void j(String str, boolean z, boolean z2) {
        AppMethodBeat.i(105240);
        int fp = fp(this.znv);
        int fp2 = fp(this.oov);
        int fp3 = fp(this.mGW);
        int fp4 = fp(this.znw);
        if (fp > 0) {
            this.znp = 0;
            fp = (fp + 1) + 0;
        } else {
            this.znp = BaseClientBuilder.API_PRIORITY_OTHER;
            fp = 0;
        }
        if (fp2 > 0) {
            this.znq = fp;
            if (fp2 <= 3 || (fp3 <= 0 && fp4 <= 0)) {
                this.zns = BaseClientBuilder.API_PRIORITY_OTHER;
                fp += fp2 + 1;
            } else if (this.znr) {
                fp += 4;
                this.zns = fp;
                fp++;
            } else {
                fp += fp2 + 1;
                this.zns = fp;
                fp++;
            }
        } else {
            this.znq = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (this.mDz.mEa.length <= 1 || clI()) {
            this.zno = BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            this.zno = fp;
            fp++;
        }
        if (fp3 > 0) {
            this.zkK = fp;
            if (fp3 <= 3 || fp4 <= 0) {
                this.znu = BaseClientBuilder.API_PRIORITY_OTHER;
                fp += fp3 + 1;
            } else if (this.znt) {
                fp += 4;
                this.znu = fp;
                fp++;
            } else {
                fp += fp3 + 1;
                this.znu = fp;
                fp++;
            }
        } else {
            this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (fp4 > 0) {
            this.zkL = fp;
            fp += fp4 + 1;
        } else {
            this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        ab.i("MicroMsg.MMSearchContactAdapter", "setCount %d", Integer.valueOf(fp));
        this.count = fp;
        if (z2) {
            ci(str, z);
        }
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(105240);
    }

    public int getCount() {
        return this.count;
    }

    private static int fp(List<? extends Object> list) {
        AppMethodBeat.i(105241);
        if (list == null) {
            AppMethodBeat.o(105241);
            return 0;
        }
        int size = list.size();
        AppMethodBeat.o(105241);
        return size;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(105242);
        com.tencent.mm.ui.contact.a.a aVar = null;
        int i2;
        com.tencent.mm.ui.contact.a.a eVar;
        if (i == this.zno) {
            aVar = new com.tencent.mm.ui.contact.a.g(i);
            aVar.eDk = true;
        } else if (i == this.znp) {
            aVar = hq(R.string.c20, i);
        } else if (i == this.znq) {
            aVar = hq(R.string.c1k, i);
        } else if (i == this.zkK) {
            aVar = hq(R.string.c1j, i);
        } else if (i == this.zkL) {
            aVar = hq(R.string.c1h, i);
        } else if (i == this.zns) {
            aVar = y(R.string.c1k, i, this.znr);
        } else if (i == this.znu) {
            aVar = y(R.string.c1j, i, this.znt);
        } else if (i > this.zkL) {
            i2 = (i - this.zkL) - 1;
            eVar = new e(i);
            eVar.hpS = (l) this.znw.get(i2);
            eVar.zmW = clI();
            eVar.eDk = true;
            eVar.mFm = i2 + 1;
            eVar.ej(eVar.hpS.type, eVar.hpS.mDw);
            aVar = eVar;
        } else if (i > this.zkK) {
            i2 = (i - this.zkK) - 1;
            eVar = new c(i);
            eVar.hpS = (l) this.mGW.get(i2);
            eVar.zmW = clI();
            eVar.eDk = true;
            eVar.mFm = i2 + 1;
            eVar.ej(eVar.hpS.type, eVar.hpS.mDw);
            aVar = eVar;
        } else if (i > this.znq) {
            i2 = (i - this.znq) - 1;
            eVar = new e(i);
            eVar.hpS = (l) this.oov.get(i2);
            eVar.zmW = clI();
            eVar.eDk = true;
            eVar.mFm = i2 + 1;
            eVar.ej(eVar.hpS.type, eVar.hpS.mDw);
            aVar = eVar;
        } else if (i > this.znp) {
            i2 = (i - this.znp) - 1;
            l lVar = (l) this.znv.get(i2);
            if (lVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || lVar.type == 131076 || lVar.type == 131081) {
                eVar = new e(i);
                eVar.hpS = lVar;
                eVar.zmW = clI();
                eVar.zpC = true;
                eVar.eDk = true;
                eVar.mFm = i2 + 1;
                eVar.ej(eVar.hpS.type, eVar.hpS.mDw);
                aVar = eVar;
            } else if (lVar.type == 131075) {
                eVar = new c(i);
                eVar.hpS = lVar;
                eVar.zmW = clI();
                eVar.zpC = true;
                eVar.eDk = true;
                eVar.mFm = i2 + 1;
                eVar.ej(eVar.hpS.type, eVar.hpS.mDw);
                aVar = eVar;
            } else {
                ab.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", Integer.valueOf(lVar.type));
                aVar = null;
            }
        } else {
            ab.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", Integer.valueOf(i));
        }
        if (aVar != null) {
            aVar.query = this.query;
            aVar.mDz = this.mDz;
            aVar.scene = this.scene;
        }
        AppMethodBeat.o(105242);
        return aVar;
    }

    private static com.tencent.mm.ui.contact.a.a y(int i, int i2, boolean z) {
        AppMethodBeat.i(105243);
        com.tencent.mm.ui.contact.a.j jVar = new com.tencent.mm.ui.contact.a.j(i2);
        jVar.resId = i;
        jVar.mJY = z;
        AppMethodBeat.o(105243);
        return jVar;
    }

    private com.tencent.mm.ui.contact.a.a hq(int i, int i2) {
        AppMethodBeat.i(105244);
        h hVar = new h(i2);
        hVar.mKQ = this.zmV.getActivity().getResources().getString(i);
        AppMethodBeat.o(105244);
        return hVar;
    }

    public void finish() {
        AppMethodBeat.i(105245);
        super.finish();
        ab.i("MicroMsg.MMSearchContactAdapter", "finish!");
        Kh();
        AppMethodBeat.o(105245);
    }

    /* Access modifiers changed, original: protected */
    public boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.znp, this.znq, this.zkK, this.zkL};
        for (int i2 = 0; i2 < 4; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        return false;
    }

    public final boolean Po(int i) {
        boolean z = true;
        AppMethodBeat.i(105246);
        int headerViewsCount = i - this.zmV.getContentLV().getHeaderViewsCount();
        if (headerViewsCount == this.zns) {
            if (this.znr) {
                headerViewsCount = this.zmV.getContentLV().getSelectedItemPosition();
                this.znr = false;
                j(this.query, true, false);
                this.zmV.getContentLV().setSelection(headerViewsCount);
            } else {
                this.znr = true;
                j(this.query, true, false);
                this.zmV.getContentLV().setSelection(this.zns);
            }
        } else if (headerViewsCount != this.znu) {
            com.tencent.mm.ui.contact.a.a Pn = getItem(headerViewsCount);
            if (!(Pn == null || !Pn.eDk || this.zno == BaseClientBuilder.API_PRIORITY_OTHER)) {
                if (Pn.position == this.zno) {
                    y.Pp(1);
                    z = false;
                } else {
                    y.Pp(0);
                }
            }
            z = false;
        } else if (this.znt) {
            headerViewsCount = this.zmV.getContentLV().getSelectedItemPosition();
            this.znt = false;
            j(this.query, true, false);
            this.zmV.getContentLV().setSelection(headerViewsCount);
        } else {
            this.znt = true;
            j(this.query, true, false);
            this.zmV.getContentLV().setSelection(this.znu);
        }
        AppMethodBeat.o(105246);
        return z;
    }
}
