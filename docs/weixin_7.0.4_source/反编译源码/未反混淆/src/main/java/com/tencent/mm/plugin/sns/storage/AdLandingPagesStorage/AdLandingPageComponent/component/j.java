package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class j extends h {
    int clickCount = 0;

    public j(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
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

    public final boolean al(JSONObject jSONObject) {
        if (!super.al(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.clickCount);
            return true;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", e, "", new Object[0]);
            return false;
        }
    }
}
