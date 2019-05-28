package com.tencent.p177mm.plugin.brandservice.p926b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45309aj;
import com.tencent.p177mm.plugin.brandservice.p349ui.BizSearchDetailPageUI;
import com.tencent.p177mm.protocal.protobuf.C35934mh;
import com.tencent.p177mm.protocal.protobuf.axy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.brandservice.b.b */
public final class C42790b {

    /* renamed from: com.tencent.mm.plugin.brandservice.b.b$a */
    public static class C42791a implements C1202f {
        private Context context;
        private String ctj;
        private long ctk;
        private boolean ctl;
        private int fromScene;
        private C45309aj jKt;
        private int offset;
        private String title;

        public C42791a(Context context, String str, long j, int i, int i2, String str2, boolean z, C45309aj c45309aj) {
            this.context = context;
            this.ctj = str;
            this.ctk = j;
            this.offset = i;
            this.fromScene = i2;
            this.title = str2;
            this.ctl = z;
            this.jKt = c45309aj;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(13826);
            C4990ab.m7417i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                m75883fx(false);
                AppMethodBeat.m2505o(13826);
            } else if (c1207m == null) {
                C4990ab.m7412e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
                m75883fx(false);
                AppMethodBeat.m2505o(13826);
            } else if (c1207m.getType() != FilterEnum4Shaka.MIC_WEISHI_LIULI) {
                C4990ab.m7416i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
                AppMethodBeat.m2505o(13826);
            } else {
                C4990ab.m7416i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
                C35934mh aVX = ((C20027h) c1207m).aVX();
                if (aVX == null || aVX.naO == null) {
                    C4990ab.m7412e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                    m75883fx(false);
                    AppMethodBeat.m2505o(13826);
                    return;
                }
                C4990ab.m7411d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", aVX.vQg);
                Intent intent = new Intent(this.context, BizSearchDetailPageUI.class);
                intent.putExtra("addContactScene", 35);
                intent.putExtra("fromScene", this.fromScene);
                intent.putExtra("keyword", this.ctj);
                intent.putExtra("businessType", this.ctk);
                intent.putExtra("offset", this.offset);
                intent.putExtra("title", this.title);
                intent.putExtra("showEditText", this.ctl);
                try {
                    intent.putExtra("result", aVX.toByteArray());
                    if (!(this.context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    m75883fx(true);
                } catch (Exception e) {
                    m75883fx(false);
                    C4990ab.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", e, "", new Object[0]);
                } finally {
                    AppMethodBeat.m2505o(13826);
                }
            }
        }

        /* renamed from: fx */
        private void m75883fx(boolean z) {
            AppMethodBeat.m2504i(13827);
            C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, (C1202f) this);
            if (!(this.jKt == null || this.jKt.cth.ctm == null)) {
                this.jKt.cti.ctn = z;
                this.jKt.cth.ctm.run();
            }
            AppMethodBeat.m2505o(13827);
        }
    }

    public static axy abJ() {
        AppMethodBeat.m2504i(13828);
        try {
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(67591, null);
            if (str != null) {
                axy axy = new axy();
                String[] split = str.split(",");
                axy.wfG = Integer.valueOf(split[0]).intValue();
                axy.wfJ = Integer.valueOf(split[1]).intValue();
                axy.vRq = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                axy.vRp = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                C4990ab.m7417i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", Float.valueOf(axy.vRq), Float.valueOf(axy.vRp));
                AppMethodBeat.m2505o(13828);
                return axy;
            }
            C4990ab.m7416i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            AppMethodBeat.m2505o(13828);
            return null;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", e.getMessage());
            AppMethodBeat.m2505o(13828);
            return null;
        }
    }
}
