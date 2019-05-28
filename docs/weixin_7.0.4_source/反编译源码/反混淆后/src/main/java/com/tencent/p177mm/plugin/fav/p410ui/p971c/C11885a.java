package com.tencent.p177mm.plugin.fav.p410ui.p971c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26146ge;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;

/* renamed from: com.tencent.mm.plugin.fav.ui.c.a */
public final class C11885a extends C4884c<C26146ge> {
    private C45939l mhy;
    private C4993ae<Long, C27966g> moD;

    public C11885a() {
        AppMethodBeat.m2504i(74609);
        this.moD = new C4993ae(10);
        this.xxI = C26146ge.class.getName().hashCode();
        AppMethodBeat.m2505o(74609);
    }

    /* renamed from: a */
    private boolean m19774a(C26146ge c26146ge) {
        C27966g c27966g;
        AppMethodBeat.m2504i(74610);
        if (c26146ge.cAt.cvv == 0) {
            c27966g = null;
        } else if (c26146ge.cAt.cAA) {
            c27966g = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c26146ge.cAt.cvv);
            if (c27966g != null) {
                this.moD.put(Long.valueOf(c26146ge.cAt.cvv), c27966g);
            }
        } else {
            boolean z;
            C27966g c27966g2 = (C27966g) this.moD.get(Long.valueOf(c26146ge.cAt.cvv));
            String str = "MicroMsg.FavImageServiceListener";
            String str2 = "get item from cache itemInfo is null? %B";
            Object[] objArr = new Object[1];
            if (c27966g2 == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7411d(str, str2, objArr);
            if (c27966g2 == null) {
                c27966g = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c26146ge.cAt.cvv);
                if (c27966g != null) {
                    this.moD.put(Long.valueOf(c26146ge.cAt.cvv), c27966g);
                }
            } else {
                c27966g = c27966g2;
            }
        }
        C4990ab.m7411d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", Integer.valueOf(c26146ge.cAt.opType), Long.valueOf(c26146ge.cAt.cvv));
        if (c27966g != null || c26146ge.cAt.opType == 3 || c26146ge.cAt.opType == 4) {
            switch (c26146ge.cAt.opType) {
                case 0:
                    c26146ge.cAu.cAB = C45939l.m85275a(c26146ge.cAt.cAv, c27966g);
                    break;
                case 1:
                    if (this.mhy != null) {
                        this.mhy.mo73788b(c26146ge.cAt.cAw, c26146ge.cAt.cAv, c27966g, c26146ge.cAt.cAx, c26146ge.cAt.width, c26146ge.cAt.height);
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.FavImageServiceListener", "imageServer is null");
                    break;
                case 2:
                    C4990ab.m7411d("MicroMsg.FavImageServiceListener", "get img from Cache %s", Boolean.valueOf(c26146ge.cAt.cAy));
                    if (!c26146ge.cAt.cAy) {
                        c26146ge.cAu.cAB = C45939l.m85279b(c26146ge.cAt.cAv, c27966g, c26146ge.cAt.maxWidth);
                        break;
                    }
                    c26146ge.cAu.cAB = C45939l.m85285j(c26146ge.cAt.cAv);
                    break;
                case 3:
                    C4990ab.m7410d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.mhy != null) {
                        this.mhy.destory();
                    }
                    this.mhy = new C45939l(c26146ge.cAt.context, 16);
                    break;
                case 4:
                    C4990ab.m7410d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.mhy != null) {
                        this.mhy.destory();
                        this.mhy = null;
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(74610);
        } else {
            AppMethodBeat.m2505o(74610);
        }
        return false;
    }
}
