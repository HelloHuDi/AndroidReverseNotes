package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29085j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t */
public final class C17109t extends C17097k {

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t$1 */
    class C171101 implements OnClickListener {
        C171101() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37239);
            C17109t.this.cpH();
            C29085j c29085j = (C29085j) C17109t.this.cpI();
            C17109t.this.mo31186b(C17109t.this.context, c29085j.qWf, c29085j.qWg, c29085j.qWh);
            AppMethodBeat.m2505o(37239);
        }
    }

    public C17109t(Context context, C29085j c29085j, ViewGroup viewGroup) {
        super(context, c29085j, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final void mo31177e(Button button) {
        AppMethodBeat.m2504i(37240);
        button.setOnClickListener(new C171101());
        AppMethodBeat.m2505o(37240);
    }

    /* renamed from: b */
    public final void mo31186b(Context context, String str, String str2, int i) {
        AppMethodBeat.m2504i(37241);
        String str3 = "";
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", cpC().qXp);
        intent.putExtra("sns_landing_pages_xml", "");
        if (cpP()) {
            intent.putExtra("sns_landing_pages_canvasid", str);
            intent.putExtra("sns_landing_pages_canvas_ext", str2);
        } else {
            intent.putExtra("sns_landing_pages_pageid", C5046bo.anl(str));
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
            if (!C5046bo.isNullOrNil(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", cpI().qWO);
                    jSONObject.put("adBuffer", !C5046bo.isNullOrNil(str3) ? str3 : "");
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
        C25985d.m41467b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.m2505o(37241);
    }

    private boolean cpO() {
        AppMethodBeat.m2504i(37242);
        if (((C29085j) cpI()).qWi == 1) {
            AppMethodBeat.m2505o(37242);
            return true;
        }
        AppMethodBeat.m2505o(37242);
        return false;
    }

    private boolean cpP() {
        AppMethodBeat.m2504i(37243);
        if (((C29085j) cpI()).qWj == 1) {
            AppMethodBeat.m2505o(37243);
            return true;
        }
        AppMethodBeat.m2505o(37243);
        return false;
    }
}
