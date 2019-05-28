package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j */
public abstract class C16866j extends C13437h {
    int clickCount = 0;

    public C16866j(Context context, C29086r c29086r, ViewGroup viewGroup) {
        super(context, c29086r, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpH() {
        this.clickCount++;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        if (!super.mo15456al(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.clickCount);
            return true;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", e, "", new Object[0]);
            return false;
        }
    }
}
