package com.tencent.p177mm.plugin.appbrand.appusage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C41224x.C41225a;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C19734i;
import com.tencent.p177mm.plugin.appbrand.service.C19734i.C10734c;
import com.tencent.p177mm.plugin.appbrand.service.C19734i.C19733b;
import com.tencent.p177mm.plugin.appbrand.service.C19734i.C19735a;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.protocal.protobuf.anx;
import com.tencent.p177mm.protocal.protobuf.bzq;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.am */
public final class C24686am implements C19734i {
    public final C19733b axP() {
        int i = 4;
        AppMethodBeat.m2504i(129730);
        C19733b c19733b = new C19733b();
        c19733b.items = new ArrayList(0);
        c19733b.iDI = -1;
        c19733b.cEh = "";
        if (!C1720g.m3534RN().eJb) {
            AppMethodBeat.m2505o(129730);
            return c19733b;
        } else if (C19104i.axb()) {
            Iterator c20851;
            final anx axM = C41224x.axM();
            C19733b c19733b2 = new C19733b();
            c19733b2.cEh = axM == null ? null : axM.nzz;
            c19733b2.iDI = axM == null ? 0 : axM.wst;
            if (axM == null) {
                final Cursor a = C42340f.auT().mo73328a(new String[]{"brandId", "versionType"}, 4, 0);
                c20851 = new Iterator<Object[]>() {
                    boolean haU;
                    final Object[] haV = new Object[3];

                    public final boolean hasNext() {
                        AppMethodBeat.m2504i(129724);
                        boolean moveToNext;
                        if (this.haU) {
                            moveToNext = a.moveToNext();
                            if (!moveToNext) {
                                a.close();
                            }
                            AppMethodBeat.m2505o(129724);
                            return moveToNext;
                        }
                        this.haU = true;
                        moveToNext = a.moveToFirst();
                        AppMethodBeat.m2505o(129724);
                        return moveToNext;
                    }

                    public final void remove() {
                    }

                    public final /* synthetic */ Object next() {
                        AppMethodBeat.m2504i(129725);
                        this.haV[0] = a.getString(0);
                        this.haV[1] = Integer.valueOf(a.getInt(1));
                        this.haV[2] = Integer.valueOf(0);
                        Object[] objArr = this.haV;
                        AppMethodBeat.m2505o(129725);
                        return objArr;
                    }
                };
            } else {
                C246872 c246872 = new Iterator<Object[]>() {
                    final Object[] haV = new Object[3];
                    final Iterator<bzq> haY = axM.wss.iterator();

                    public final boolean hasNext() {
                        AppMethodBeat.m2504i(129727);
                        boolean hasNext = this.haY.hasNext();
                        AppMethodBeat.m2505o(129727);
                        return hasNext;
                    }

                    public final void remove() {
                    }

                    public final /* synthetic */ Object next() {
                        AppMethodBeat.m2504i(129728);
                        bzq bzq = (bzq) this.haY.next();
                        this.haV[0] = bzq.username;
                        this.haV[1] = Integer.valueOf(bzq.wzF);
                        this.haV[2] = Integer.valueOf(bzq.vMG);
                        Object[] objArr = this.haV;
                        AppMethodBeat.m2505o(129728);
                        return objArr;
                    }
                };
                i = axM.wss.size();
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(129729);
                        if (!C5046bo.m7548ek(axM.wss)) {
                            LinkedList linkedList = new LinkedList();
                            Iterator it = axM.wss.iterator();
                            while (it.hasNext()) {
                                linkedList.add(((bzq) it.next()).username);
                            }
                            C42406r.m75073a(linkedList, C33137a.DEFAULT);
                        }
                        AppMethodBeat.m2505o(129729);
                    }
                }, "BatchSyncWxaAttrBySearchShowOut");
                Object c208512 = c246872;
            }
            c19733b2.items = new ArrayList(i);
            while (c208512.hasNext()) {
                Object[] objArr = (Object[]) c208512.next();
                WxaAttributes d = C42340f.auO().mo21572d((String) objArr[0], "nickname", "brandIconURL");
                if (d != null) {
                    C10734c c10734c = new C10734c();
                    c10734c.username = (String) objArr[0];
                    c10734c.har = ((Integer) objArr[1]).intValue();
                    c10734c.axy = ((Integer) objArr[2]).intValue();
                    c10734c.nickname = d.field_nickname;
                    c10734c.haO = d.field_brandIconURL;
                    c19733b2.items.add(c10734c);
                }
            }
            C41225a c41225a = C41225a.SEARCH;
            C41224x.axL();
            AppMethodBeat.m2505o(129730);
            return c19733b2;
        } else {
            AppMethodBeat.m2505o(129730);
            return c19733b;
        }
    }

    /* renamed from: a */
    public final void mo34968a(Context context, String str, C19735a c19735a) {
        AppMethodBeat.m2504i(129731);
        Intent intent = new Intent(context, AppBrandLauncherUI.class);
        intent.putExtra("extra_enter_scene", 10);
        intent.putExtra("extra_enter_scene_note", str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c19735a.tag);
        context.startActivity(intent);
        AppMethodBeat.m2505o(129731);
    }

    /* renamed from: a */
    public final void mo34967a(Context context, C10734c c10734c, String str) {
        AppMethodBeat.m2504i(129732);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1054;
        appBrandStatObject.cst = str;
        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, c10734c.username, null, c10734c.har, c10734c.axy, null, appBrandStatObject);
        AppMethodBeat.m2505o(129732);
    }
}
