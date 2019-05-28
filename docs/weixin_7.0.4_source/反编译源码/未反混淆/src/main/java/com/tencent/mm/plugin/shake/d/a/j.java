package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.c;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends b {
    public static boolean isInited = false;
    public static j qtV;
    private boolean csi = false;
    private long iQb;
    public a qtU = new a();

    public static j a(a aVar) {
        AppMethodBeat.i(24639);
        if (qtV == null || qtV.qrT == null) {
            qtV = new j(aVar);
        }
        j jVar = qtV;
        AppMethodBeat.o(24639);
        return jVar;
    }

    private j(a aVar) {
        super(aVar);
        AppMethodBeat.i(24640);
        AppMethodBeat.o(24640);
    }

    public final void init() {
        AppMethodBeat.i(24642);
        if (!isInited) {
            if (this.qtU.ckt()) {
                isInited = true;
            } else {
                ab.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
                AppMethodBeat.o(24642);
                return;
            }
        }
        AppMethodBeat.o(24642);
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void cjw() {
        AppMethodBeat.i(24643);
        this.qtU.EB();
        super.cjw();
        AppMethodBeat.o(24643);
    }

    public final void resume() {
    }

    private void c(List<d> list, long j) {
        AppMethodBeat.i(24644);
        if (this.qrT != null) {
            this.qrT.b(list, j);
        }
        AppMethodBeat.o(24644);
    }

    public final void start() {
        AppMethodBeat.i(24641);
        if (this.qrT == null) {
            ab.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            AppMethodBeat.o(24641);
            return;
        }
        this.iQb = System.currentTimeMillis();
        this.qtU.a(367, new a.a() {
            public final void b(btd btd, long j, boolean z) {
                AppMethodBeat.i(24638);
                if (j.this.qrT == null) {
                    ab.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
                    AppMethodBeat.o(24638);
                    return;
                }
                byq byq = (byq) btd;
                if (byq == null) {
                    ab.w("Micromsg.ShakeMusicMgr", "resp null & return");
                    j.a(j.this, new ArrayList());
                    AppMethodBeat.o(24638);
                } else if (byq.wXX == 1) {
                    long currentTimeMillis;
                    if (j > j.this.iQb) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - j.this.iQb;
                    }
                    if (byq != null && !bo.isNullOrNil(byq.wXZ)) {
                        boolean a;
                        ab.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", Integer.valueOf(byq.wXY), byq.wXZ);
                        String str = byq.wXZ;
                        if (str != null) {
                            str = str.trim();
                        }
                        switch (byq.wXY) {
                            case 0:
                                a = j.a(j.this, str);
                                break;
                            case 1:
                                a = j.b(j.this, str);
                                break;
                            case 2:
                                a = j.c(j.this, str);
                                break;
                            case 3:
                                a = j.d(j.this, str);
                                break;
                            case 4:
                                a = j.e(j.this, str);
                                break;
                            default:
                                ab.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + byq.wXY);
                                j.a(j.this, new ArrayList());
                                a = false;
                                break;
                        }
                        if (a) {
                            h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - j.this.iQb)));
                            h.pYm.k(835, 0, 1);
                            AppMethodBeat.o(24638);
                            return;
                        }
                        h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis));
                        h.pYm.k(835, 4, 1);
                        AppMethodBeat.o(24638);
                    } else if (z) {
                        j.a(j.this, new ArrayList());
                        h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis));
                        h.pYm.k(835, 3, 1);
                        AppMethodBeat.o(24638);
                    } else {
                        j.a(j.this, new ArrayList());
                        h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis));
                        h.pYm.k(835, 2, 1);
                        AppMethodBeat.o(24638);
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (byq != null) {
                        d dVar = new d();
                        if (!(byq.wXT == null || byq.wXT.getBuffer() == null)) {
                            dVar.field_username = byq.wXT.getBuffer().dlY();
                        }
                        if (!(byq.wXS == null || byq.wXS.getBuffer() == null)) {
                            dVar.field_nickname = byq.wXS.getBuffer().dlY();
                        }
                        if (!(byq.wXT == null || byq.wXT.getBuffer() == null)) {
                            dVar.field_distance = byq.wXT.getBuffer().dlY();
                        }
                        if (!(byq.wrE == null || byq.wrE.getBuffer() == null)) {
                            dVar.field_sns_bgurl = byq.wrE.getBuffer().dlY();
                        }
                        dVar.field_type = 4;
                        dVar.field_insertBatch = 1;
                        try {
                            dVar.field_lvbuffer = byq.toByteArray();
                        } catch (IOException e) {
                            ab.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", e.getLocalizedMessage());
                        }
                        m.cjS().a(dVar, true);
                        arrayList.add(dVar);
                    }
                    j.this.qrT.b(arrayList, j);
                    AppMethodBeat.o(24638);
                }
            }
        });
        AppMethodBeat.o(24641);
    }

    static /* synthetic */ boolean b(j jVar, String str) {
        AppMethodBeat.i(24647);
        f WL = f.WL(str);
        List arrayList = new ArrayList();
        if (WL == null || WL.userName == null) {
            ab.w("Micromsg.ShakeMusicMgr", "parse user fail");
            jVar.c(arrayList, 4);
            AppMethodBeat.o(24647);
            return false;
        }
        ab.d("Micromsg.ShakeMusicMgr", "parse user: username=" + WL.userName + ", nickname=" + WL.bCu + ", showchat=" + WL.quc);
        d dVar = new d();
        dVar.field_username = WL.userName;
        dVar.field_nickname = WL.bCu;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = WL.quc;
        m.cjS().a(dVar, true);
        arrayList.add(dVar);
        jVar.c(arrayList, 1);
        AppMethodBeat.o(24647);
        return true;
    }

    static /* synthetic */ boolean d(j jVar, String str) {
        AppMethodBeat.i(24649);
        List arrayList = new ArrayList();
        m.b WH = m.b.WH(str);
        if (WH == null || WH.qtZ == null) {
            ab.w("Micromsg.ShakeMusicMgr", "parse pay fail");
            jVar.c(arrayList, 4);
            AppMethodBeat.o(24649);
            return false;
        }
        ab.d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + WH.qtZ + ", title=" + WH.title + ", thumbUrl=" + WH.thumbUrl);
        d dVar = new d();
        dVar.field_username = WH.qtZ;
        dVar.field_nickname = WH.title;
        dVar.field_sns_bgurl = WH.thumbUrl;
        dVar.field_distance = WH.pdz;
        dVar.field_type = 9;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.cjS().a(dVar, true);
        arrayList.add(dVar);
        jVar.c(arrayList, 1);
        AppMethodBeat.o(24649);
        return true;
    }

    static /* synthetic */ boolean e(j jVar, String str) {
        AppMethodBeat.i(24650);
        List arrayList = new ArrayList();
        c WI = c.WI(str);
        if (WI == null || WI.id == null) {
            ab.w("Micromsg.ShakeMusicMgr", "parse product fail");
            jVar.c(arrayList, 4);
            AppMethodBeat.o(24650);
            return false;
        }
        ab.d("Micromsg.ShakeMusicMgr", "parese pruduct: product_id=" + WI.id + ", title=" + WI.title + ", thumbUrl=" + WI.thumbUrl);
        d dVar = new d();
        dVar.field_username = WI.id;
        dVar.field_nickname = WI.title;
        dVar.field_sns_bgurl = WI.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.cjS().a(dVar, true);
        arrayList.add(dVar);
        jVar.c(arrayList, 1);
        AppMethodBeat.o(24650);
        return true;
    }
}
