package com.tencent.mm.plugin.appbrand.appusage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.j.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.appbrand.service.i.b;
import com.tencent.mm.plugin.appbrand.service.i.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class am implements i {
    public final b axP() {
        int i = 4;
        AppMethodBeat.i(129730);
        b bVar = new b();
        bVar.items = new ArrayList(0);
        bVar.iDI = -1;
        bVar.cEh = "";
        if (!g.RN().eJb) {
            AppMethodBeat.o(129730);
            return bVar;
        } else if (i.axb()) {
            Iterator anonymousClass1;
            final anx axM = x.axM();
            b bVar2 = new b();
            bVar2.cEh = axM == null ? null : axM.nzz;
            bVar2.iDI = axM == null ? 0 : axM.wst;
            if (axM == null) {
                final Cursor a = f.auT().a(new String[]{"brandId", "versionType"}, 4, 0);
                anonymousClass1 = new Iterator<Object[]>() {
                    boolean haU;
                    final Object[] haV = new Object[3];

                    public final boolean hasNext() {
                        AppMethodBeat.i(129724);
                        boolean moveToNext;
                        if (this.haU) {
                            moveToNext = a.moveToNext();
                            if (!moveToNext) {
                                a.close();
                            }
                            AppMethodBeat.o(129724);
                            return moveToNext;
                        }
                        this.haU = true;
                        moveToNext = a.moveToFirst();
                        AppMethodBeat.o(129724);
                        return moveToNext;
                    }

                    public final void remove() {
                    }

                    public final /* synthetic */ Object next() {
                        AppMethodBeat.i(129725);
                        this.haV[0] = a.getString(0);
                        this.haV[1] = Integer.valueOf(a.getInt(1));
                        this.haV[2] = Integer.valueOf(0);
                        Object[] objArr = this.haV;
                        AppMethodBeat.o(129725);
                        return objArr;
                    }
                };
            } else {
                AnonymousClass2 anonymousClass2 = new Iterator<Object[]>() {
                    final Object[] haV = new Object[3];
                    final Iterator<bzq> haY = axM.wss.iterator();

                    public final boolean hasNext() {
                        AppMethodBeat.i(129727);
                        boolean hasNext = this.haY.hasNext();
                        AppMethodBeat.o(129727);
                        return hasNext;
                    }

                    public final void remove() {
                    }

                    public final /* synthetic */ Object next() {
                        AppMethodBeat.i(129728);
                        bzq bzq = (bzq) this.haY.next();
                        this.haV[0] = bzq.username;
                        this.haV[1] = Integer.valueOf(bzq.wzF);
                        this.haV[2] = Integer.valueOf(bzq.vMG);
                        Object[] objArr = this.haV;
                        AppMethodBeat.o(129728);
                        return objArr;
                    }
                };
                i = axM.wss.size();
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(129729);
                        if (!bo.ek(axM.wss)) {
                            LinkedList linkedList = new LinkedList();
                            Iterator it = axM.wss.iterator();
                            while (it.hasNext()) {
                                linkedList.add(((bzq) it.next()).username);
                            }
                            r.a(linkedList, a.DEFAULT);
                        }
                        AppMethodBeat.o(129729);
                    }
                }, "BatchSyncWxaAttrBySearchShowOut");
                Object anonymousClass12 = anonymousClass2;
            }
            bVar2.items = new ArrayList(i);
            while (anonymousClass12.hasNext()) {
                Object[] objArr = (Object[]) anonymousClass12.next();
                WxaAttributes d = f.auO().d((String) objArr[0], "nickname", "brandIconURL");
                if (d != null) {
                    c cVar = new c();
                    cVar.username = (String) objArr[0];
                    cVar.har = ((Integer) objArr[1]).intValue();
                    cVar.axy = ((Integer) objArr[2]).intValue();
                    cVar.nickname = d.field_nickname;
                    cVar.haO = d.field_brandIconURL;
                    bVar2.items.add(cVar);
                }
            }
            x.a aVar = x.a.SEARCH;
            x.axL();
            AppMethodBeat.o(129730);
            return bVar2;
        } else {
            AppMethodBeat.o(129730);
            return bVar;
        }
    }

    public final void a(Context context, String str, i.a aVar) {
        AppMethodBeat.i(129731);
        Intent intent = new Intent(context, AppBrandLauncherUI.class);
        intent.putExtra("extra_enter_scene", 10);
        intent.putExtra("extra_enter_scene_note", str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + aVar.tag);
        context.startActivity(intent);
        AppMethodBeat.o(129731);
    }

    public final void a(Context context, c cVar, String str) {
        AppMethodBeat.i(129732);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1054;
        appBrandStatObject.cst = str;
        ((e) g.K(e.class)).a(context, cVar.username, null, cVar.har, cVar.axy, null, appBrandStatObject);
        AppMethodBeat.o(129732);
    }
}
