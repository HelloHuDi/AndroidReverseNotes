package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class t extends k {
    public t(Context context, j jVar, ViewGroup viewGroup) {
        super(context, jVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(Button button) {
        AppMethodBeat.i(37240);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(37239);
                t.this.cpH();
                j jVar = (j) t.this.cpI();
                t.this.b(t.this.context, jVar.qWf, jVar.qWg, jVar.qWh);
                AppMethodBeat.o(37239);
            }
        });
        AppMethodBeat.o(37240);
    }

    public final void b(Context context, String str, String str2, int i) {
        AppMethodBeat.i(37241);
        String str3 = "";
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", cpC().qXp);
        intent.putExtra("sns_landing_pages_xml", "");
        if (cpP()) {
            intent.putExtra("sns_landing_pages_canvasid", str);
            intent.putExtra("sns_landing_pages_canvas_ext", str2);
        } else {
            intent.putExtra("sns_landing_pages_pageid", bo.anl(str));
        }
        if (cpO()) {
            int[] iArr = new int[2];
            this.qZB.getLocationOnScreen(iArr);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_width", this.qZB.getWidth());
            intent.putExtra("img_gallery_height", this.qZB.getHeight());
        }
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", cpO());
        intent.putExtra("sns_landing_pages_extra", str3);
        intent.putExtra("sns_landing_pages_no_store", i);
        intent.putExtra("sns_landing_pages_ux_info", cpC().qPj);
        intent.putExtra("sns_landing_is_native_sight_ad", cpC().qXq);
        if ((context instanceof Activity) && cpP() && cpC().qXr == 2) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            str3 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bo.isNullOrNil(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", cpI().qWO);
                    jSONObject.put("adBuffer", !bo.isNullOrNil(str3) ? str3 : "");
                    jSONObject.put("preSessionId", stringExtra);
                } catch (Exception e) {
                }
                intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
                intent.putExtra("sns_landing_pages_sessionId", valueOf);
                intent.putExtra("sns_landing_pages_ad_buffer", str3);
            }
        }
        if (context instanceof Activity) {
            str3 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_rawSnsId");
            String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_share_sns_id");
            intent.putExtra("sns_landing_pages_rawSnsId", str3);
            intent.putExtra("sns_landing_pages_share_sns_id", stringExtra2);
        }
        d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.o(37241);
    }

    private boolean cpO() {
        AppMethodBeat.i(37242);
        if (((j) cpI()).qWi == 1) {
            AppMethodBeat.o(37242);
            return true;
        }
        AppMethodBeat.o(37242);
        return false;
    }

    private boolean cpP() {
        AppMethodBeat.i(37243);
        if (((j) cpI()).qWj == 1) {
            AppMethodBeat.o(37243);
            return true;
        }
        AppMethodBeat.o(37243);
        return false;
    }
}
