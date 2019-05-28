package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l extends b {
    private static boolean isInited = false;
    private static boolean isRunning = false;
    private Context context;
    private boolean csi = false;
    private long iQb;
    private a qtU = new a();

    public l(Context context, a aVar) {
        super(aVar);
        AppMethodBeat.i(24657);
        this.context = context;
        isRunning = false;
        AppMethodBeat.o(24657);
    }

    public final void init() {
        AppMethodBeat.i(24659);
        if (!isInited) {
            if (this.qtU.ckt()) {
                isInited = true;
            } else {
                ab.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
                AppMethodBeat.o(24659);
                return;
            }
        }
        AppMethodBeat.o(24659);
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void cjw() {
        AppMethodBeat.i(24660);
        super.cjw();
        this.qtU.EB();
        if (isRunning) {
            long currentTimeMillis = System.currentTimeMillis() - this.iQb;
            ab.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", Long.valueOf(currentTimeMillis), Boolean.valueOf(isRunning));
            h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int) currentTimeMillis));
            h.pYm.k(835, 1, 1);
            isRunning = false;
        }
        AppMethodBeat.o(24660);
    }

    public final void resume() {
    }

    private void c(List<d> list, long j) {
        AppMethodBeat.i(24661);
        if (this.qrT != null) {
            this.qrT.b(list, j);
        }
        AppMethodBeat.o(24661);
    }

    public final void start() {
        AppMethodBeat.i(24658);
        ab.v("Micromsg.ShakeTVService", "hy: start shake tv!");
        if (this.qrT == null) {
            ab.w("Micromsg.ShakeTVService", "shakeGetListener == null");
            AppMethodBeat.o(24658);
        } else if (this.context instanceof Activity) {
            isRunning = true;
            this.iQb = System.currentTimeMillis();
            this.qtU.a(408, new a.a() {
                public final void b(btd btd, long j, boolean z) {
                    long currentTimeMillis;
                    AppMethodBeat.i(24656);
                    ab.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", Boolean.valueOf(z));
                    if (j > l.this.iQb) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - l.this.iQb;
                    }
                    if (btd != null && !bo.isNullOrNil(((byu) btd).vOt)) {
                        boolean a;
                        byu byu = (byu) btd;
                        ab.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", Integer.valueOf(byu.jCt), byu.vOt);
                        String str = null;
                        String str2 = null;
                        if (byu.vOt != null) {
                            byu.vOt = byu.vOt.trim();
                            int indexOf = byu.vOt.indexOf("<tvinfo>");
                            if (indexOf > 0) {
                                str = byu.vOt.substring(0, indexOf);
                                str2 = byu.vOt.substring(indexOf);
                            } else if (indexOf == 0) {
                                str2 = byu.vOt;
                            } else {
                                str = byu.vOt;
                            }
                        }
                        l.WF(str2);
                        switch (byu.jCt) {
                            case 0:
                                a = l.a(l.this, str);
                                break;
                            case 1:
                                a = l.b(l.this, str);
                                break;
                            case 2:
                                a = l.c(l.this, str);
                                break;
                            case 3:
                                a = l.d(l.this, str);
                                break;
                            case 4:
                                a = l.e(l.this, str);
                                break;
                            case 5:
                                a = l.f(l.this, str);
                                break;
                            case 6:
                                a = l.g(l.this, str);
                                break;
                            default:
                                ab.w("Micromsg.ShakeTVService", "parse unknown type:" + byu.jCt);
                                l.a(l.this, new ArrayList());
                                a = false;
                                break;
                        }
                        if (a) {
                            h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - l.this.iQb)));
                            h.pYm.k(835, 0, 1);
                        } else {
                            h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis));
                            h.pYm.k(835, 4, 1);
                        }
                    } else if (z) {
                        l.a(l.this, new ArrayList());
                        h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis));
                        h.pYm.k(835, 3, 1);
                    } else {
                        l.a(l.this, new ArrayList());
                        h.pYm.e(10987, Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis));
                        h.pYm.k(835, 2, 1);
                    }
                    l.isRunning = false;
                    AppMethodBeat.o(24656);
                }
            });
            h.pYm.k(835, 5, 1);
            AppMethodBeat.o(24658);
        } else {
            ab.e("Micromsg.ShakeTVService", "context not an Activity");
            this.qrT.b(new ArrayList(), 0);
            AppMethodBeat.o(24658);
        }
    }

    static /* synthetic */ void WF(String str) {
        n nVar;
        String[] strArr = null;
        AppMethodBeat.i(24662);
        if (bo.isNullOrNil(str)) {
            nVar = null;
        } else {
            n nVar2;
            Map z = br.z(str, "tvinfo");
            if (z != null) {
                String str2 = (String) z.get(".tvinfo.username");
                if (bo.isNullOrNil(str2)) {
                    nVar = null;
                } else {
                    n nVar3 = new n();
                    nVar3.field_username = str2;
                    nVar3.field_iconurl = bo.nullAsNil((String) z.get(".tvinfo.iconurl"));
                    nVar3.field_title = bo.nullAsNil((String) z.get(".tvinfo.title"));
                    nVar3.field_deeplink = bo.nullAsNil((String) z.get(".tvinfo.deeplinkjumpurl"));
                    nVar3.field_createtime = bo.getLong((String) z.get(".tvinfo.createtime"), 0);
                    nVar2 = nVar3;
                }
            } else {
                nVar2 = null;
            }
            nVar = nVar2;
        }
        if (nVar != null) {
            o cjU = m.cjU();
            Cursor a = cjU.bSd.a("shaketvhistory", null, "username=?", new String[]{nVar.field_username}, null, null, null, 2);
            if (a.moveToFirst()) {
                strArr = new n();
                strArr.d(a);
                a.close();
            } else {
                ab.i("MicroMsg.ShakeTvHistoryStorage", "get null with username:".concat(String.valueOf(r10)));
                a.close();
            }
            if (strArr != null) {
                ab.i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                cjU = m.cjU();
                if (bo.isNullOrNil(nVar.field_username)) {
                    ab.w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    AppMethodBeat.o(24662);
                    return;
                }
                cjU.bSd.update("shaketvhistory", nVar.Hl(), "username=?", new String[]{nVar.field_username});
                AppMethodBeat.o(24662);
                return;
            }
            ab.i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            m.cjU().b((c) nVar);
        }
        AppMethodBeat.o(24662);
    }

    static /* synthetic */ boolean b(l lVar, String str) {
        AppMethodBeat.i(24664);
        f WL = f.WL(str);
        List arrayList = new ArrayList();
        if (WL == null || WL.userName == null) {
            ab.w("Micromsg.ShakeTVService", "parse user fail");
            lVar.c(arrayList, 4);
            AppMethodBeat.o(24664);
            return false;
        }
        ab.d("Micromsg.ShakeTVService", "parse user: username=" + WL.userName + ", nickname=" + WL.bCu + ", showchat=" + WL.quc);
        d dVar = new d();
        dVar.field_username = WL.userName;
        dVar.field_nickname = WL.bCu;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = WL.quc;
        m.cjS().a(dVar, true);
        arrayList.add(dVar);
        lVar.c(arrayList, 1);
        AppMethodBeat.o(24664);
        return true;
    }

    static /* synthetic */ boolean d(l lVar, String str) {
        AppMethodBeat.i(24666);
        List arrayList = new ArrayList();
        m.b WH = m.b.WH(str);
        if (WH == null || WH.qtZ == null) {
            ab.w("Micromsg.ShakeTVService", "parse pay fail");
            lVar.c(arrayList, 4);
            AppMethodBeat.o(24666);
            return false;
        }
        ab.d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + WH.qtZ + ", title=" + WH.title + ", thumbUrl=" + WH.thumbUrl);
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
        lVar.c(arrayList, 1);
        AppMethodBeat.o(24666);
        return true;
    }

    static /* synthetic */ boolean e(l lVar, String str) {
        AppMethodBeat.i(24667);
        List arrayList = new ArrayList();
        m.c WI = m.c.WI(str);
        if (WI == null || WI.id == null) {
            ab.w("Micromsg.ShakeTVService", "parse product fail");
            lVar.c(arrayList, 4);
            AppMethodBeat.o(24667);
            return false;
        }
        ab.d("Micromsg.ShakeTVService", "parese pruduct: product_id=" + WI.id + ", title=" + WI.title + ", thumbUrl=" + WI.thumbUrl);
        d dVar = new d();
        dVar.field_username = WI.id;
        dVar.field_nickname = WI.title;
        dVar.field_sns_bgurl = WI.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.cjS().a(dVar, true);
        arrayList.add(dVar);
        lVar.c(arrayList, 1);
        AppMethodBeat.o(24667);
        return true;
    }

    static /* synthetic */ boolean f(l lVar, String str) {
        AppMethodBeat.i(24668);
        List arrayList = new ArrayList();
        m.d WJ = m.d.WJ(str);
        if (WJ == null || bo.isNullOrNil(WJ.qub)) {
            ab.w("Micromsg.ShakeTVService", "parse TempSession fail");
            lVar.c(arrayList, 4);
            AppMethodBeat.o(24668);
            return false;
        }
        d dVar = new d();
        dVar.field_username = WJ.qub;
        dVar.field_nickname = WJ.title;
        dVar.field_distance = WJ.username;
        dVar.field_sns_bgurl = WJ.thumbUrl;
        dVar.field_type = 12;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.cjS().a(dVar, true);
        arrayList.add(dVar);
        lVar.c(arrayList, 1);
        AppMethodBeat.o(24668);
        return true;
    }

    static /* synthetic */ boolean g(l lVar, String str) {
        AppMethodBeat.i(24669);
        List arrayList = new ArrayList();
        m.a WG = m.a.WG(str);
        if (WG != null) {
            d dVar = new d();
            dVar.field_username = WG.username;
            dVar.field_nickname = WG.title;
            dVar.field_reserved3 = WG.path;
            dVar.field_sns_bgurl = WG.thumbUrl;
            dVar.field_reserved2 = WG.version;
            dVar.field_type = 13;
            dVar.field_insertBatch = 1;
            dVar.field_lvbuffer = str.getBytes();
            m.cjS().a(dVar, true);
            arrayList.add(dVar);
            lVar.c(arrayList, 1);
            AppMethodBeat.o(24669);
            return true;
        }
        ab.w("Micromsg.ShakeTVService", "parse appBrand fail");
        lVar.c(arrayList, 4);
        AppMethodBeat.o(24669);
        return false;
    }
}
