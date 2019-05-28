package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class b {

    public static class a implements f {
        private Context context;
        private String ctj;
        private long ctk;
        private boolean ctl;
        private int fromScene;
        private aj jKt;
        private int offset;
        private String title;

        public a(Context context, String str, long j, int i, int i2, String str2, boolean z, aj ajVar) {
            this.context = context;
            this.ctj = str;
            this.ctk = j;
            this.offset = i;
            this.fromScene = i2;
            this.title = str2;
            this.ctl = z;
            this.jKt = ajVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(13826);
            ab.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                fx(false);
                AppMethodBeat.o(13826);
            } else if (mVar == null) {
                ab.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
                fx(false);
                AppMethodBeat.o(13826);
            } else if (mVar.getType() != FilterEnum4Shaka.MIC_WEISHI_LIULI) {
                ab.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
                AppMethodBeat.o(13826);
            } else {
                ab.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
                mh aVX = ((h) mVar).aVX();
                if (aVX == null || aVX.naO == null) {
                    ab.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                    fx(false);
                    AppMethodBeat.o(13826);
                    return;
                }
                ab.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", aVX.vQg);
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
                    fx(true);
                } catch (Exception e) {
                    fx(false);
                    ab.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", e, "", new Object[0]);
                } finally {
                    AppMethodBeat.o(13826);
                }
            }
        }

        private void fx(boolean z) {
            AppMethodBeat.i(13827);
            g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, (f) this);
            if (!(this.jKt == null || this.jKt.cth.ctm == null)) {
                this.jKt.cti.ctn = z;
                this.jKt.cth.ctm.run();
            }
            AppMethodBeat.o(13827);
        }
    }

    public static axy abJ() {
        AppMethodBeat.i(13828);
        try {
            g.RQ();
            String str = (String) g.RP().Ry().get(67591, null);
            if (str != null) {
                axy axy = new axy();
                String[] split = str.split(",");
                axy.wfG = Integer.valueOf(split[0]).intValue();
                axy.wfJ = Integer.valueOf(split[1]).intValue();
                axy.vRq = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                axy.vRp = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                ab.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", Float.valueOf(axy.vRq), Float.valueOf(axy.vRp));
                AppMethodBeat.o(13828);
                return axy;
            }
            ab.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            AppMethodBeat.o(13828);
            return null;
        } catch (Exception e) {
            ab.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", e.getMessage());
            AppMethodBeat.o(13828);
            return null;
        }
    }
}
