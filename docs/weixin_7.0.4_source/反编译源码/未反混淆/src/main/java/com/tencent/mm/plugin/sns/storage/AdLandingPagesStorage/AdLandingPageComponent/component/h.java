package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ae;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    protected int backgroundColor;
    protected View contentView = null;
    protected Context context;
    private long iBA = 0;
    protected int ieu;
    protected int iev;
    protected r qZo;
    private int qZp = 0;
    private long qZq = 0;
    boolean qZr = false;
    protected ViewGroup qZs;

    public h(Context context, r rVar, ViewGroup viewGroup) {
        AppMethodBeat.i(37066);
        this.context = context;
        this.qZo = rVar;
        this.qZs = viewGroup;
        int[] eP = ad.eP(context);
        this.ieu = eP[0];
        this.iev = eP[1];
        if (ae.hD(context)) {
            this.iev -= ae.hC(context);
        }
        AppMethodBeat.o(37066);
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final View getView() {
        AppMethodBeat.i(37068);
        View view;
        if (this.contentView != null) {
            view = this.contentView;
            AppMethodBeat.o(37068);
            return view;
        }
        if (this.contentView == null) {
            int layout = getLayout();
            if (layout != BaseClientBuilder.API_PRIORITY_OTHER) {
                this.contentView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(layout, this.qZs, false);
            } else {
                this.contentView = cpr();
                if (this.contentView != null && this.contentView.getLayoutParams() == null) {
                    this.qZs.addView(this.contentView);
                    LayoutParams layoutParams = this.contentView.getLayoutParams();
                    this.qZs.removeView(this.contentView);
                    this.contentView.setLayoutParams(layoutParams);
                }
            }
            if (this.contentView == null) {
                IllegalStateException illegalStateException = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
                AppMethodBeat.o(37068);
                throw illegalStateException;
            }
        }
        cpk();
        cpp();
        cpq();
        cpz();
        view = this.contentView;
        AppMethodBeat.o(37068);
        return view;
    }

    public final r cpv() {
        return this.qZo;
    }

    public void cpk() {
    }

    /* Access modifiers changed, original: protected */
    public void cpp() {
        AppMethodBeat.i(37069);
        ab.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
        AppMethodBeat.o(37069);
    }

    /* Access modifiers changed, original: protected */
    public int getLayout() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* Access modifiers changed, original: protected */
    public View cpr() {
        return null;
    }

    public void cpa() {
        AppMethodBeat.i(37070);
        if (this.qZr) {
            AppMethodBeat.o(37070);
            return;
        }
        this.qZr = true;
        this.qZq = System.currentTimeMillis();
        this.qZp++;
        AppMethodBeat.o(37070);
    }

    public void cpb() {
        AppMethodBeat.i(37071);
        if (this.qZr) {
            this.qZr = false;
            if (this.qZq > 0) {
                this.iBA += System.currentTimeMillis() - this.qZq;
            }
            this.qZq = 0;
            AppMethodBeat.o(37071);
            return;
        }
        AppMethodBeat.o(37071);
    }

    public void cpc() {
    }

    public final int cpw() {
        AppMethodBeat.i(37072);
        View view = getView();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int height = view.getHeight() + i;
        ab.v("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", this, Integer.valueOf(i), Integer.valueOf(height));
        if (i >= 0 && height <= this.iev) {
            height = view.getHeight();
        } else if (i >= 0 || height <= 0 || height > this.iev) {
            height = (i >= 0 || height <= this.iev) ? (i >= this.iev || height <= this.iev) ? 0 : this.iev - i : this.iev;
        }
        AppMethodBeat.o(37072);
        return height;
    }

    public boolean cpx() {
        AppMethodBeat.i(37073);
        if (cpw() >= Math.min(getView().getHeight() >>> 1, this.iev >>> 1)) {
            AppMethodBeat.o(37073);
            return true;
        }
        AppMethodBeat.o(37073);
        return false;
    }

    public void coZ() {
        AppMethodBeat.i(37074);
        cpb();
        AppMethodBeat.o(37074);
    }

    public final String cpy() {
        return this.qZo.qWO;
    }

    public boolean x(JSONArray jSONArray) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cpq() {
    }

    public final void cpz() {
        AppMethodBeat.i(37076);
        if (this.contentView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("set field contentView first");
            AppMethodBeat.o(37076);
            throw illegalStateException;
        }
        if (this.qZo != null) {
            LayoutParams layoutParams = this.contentView.getLayoutParams();
            if (layoutParams != null) {
                if (this.qZo.qWU != 2.14748365E9f) {
                    layoutParams.width = (int) this.qZo.qWU;
                }
                if (this.qZo.qWV != 2.14748365E9f) {
                    layoutParams.height = (int) this.qZo.qWV;
                }
                int gravity;
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams2.gravity = gravity;
                    }
                } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams3.gravity = gravity;
                    }
                }
                this.contentView.setLayoutParams(layoutParams);
                AppMethodBeat.o(37076);
                return;
            }
            ab.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.qZs);
        }
        AppMethodBeat.o(37076);
    }

    public final int getGravity() {
        int i = 0;
        switch (this.qZo.qWY) {
            case 0:
                i = 48;
                break;
            case 1:
                i = 16;
                break;
            case 2:
                i = 80;
                break;
        }
        switch (this.qZo.qWZ) {
            case 0:
                return i | 3;
            case 1:
                return i | 1;
            case 2:
                return i | 5;
            default:
                return i;
        }
    }

    public void ae(Map<String, Object> map) {
    }

    public void cpA() {
    }

    /* Access modifiers changed, original: protected|final */
    public final <T> T cpB() {
        try {
            return this.qZo;
        } catch (Exception e) {
            return null;
        }
    }

    public final v cpC() {
        AppMethodBeat.i(37077);
        v vVar;
        if (this.context instanceof SnsAdNativeLandingPagesUI) {
            SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
            if (snsAdNativeLandingPagesUI.roz != null) {
                vVar = snsAdNativeLandingPagesUI.roz;
                AppMethodBeat.o(37077);
                return vVar;
            }
            int i;
            snsAdNativeLandingPagesUI.roz = new v();
            v vVar2 = snsAdNativeLandingPagesUI.roz;
            if (snsAdNativeLandingPagesUI.qXp == 0) {
                i = snsAdNativeLandingPagesUI.cvd;
            } else {
                i = snsAdNativeLandingPagesUI.qXp;
            }
            vVar2.qXp = i;
            snsAdNativeLandingPagesUI.roz.qXq = snsAdNativeLandingPagesUI.rob;
            snsAdNativeLandingPagesUI.roz.qPj = snsAdNativeLandingPagesUI.qPj;
            snsAdNativeLandingPagesUI.roz.uin = snsAdNativeLandingPagesUI.uin;
            snsAdNativeLandingPagesUI.roz.qXr = snsAdNativeLandingPagesUI.qXr;
            snsAdNativeLandingPagesUI.roz.qTL = snsAdNativeLandingPagesUI.qTL;
            snsAdNativeLandingPagesUI.roz.hcx = snsAdNativeLandingPagesUI.hcx;
            v vVar3 = snsAdNativeLandingPagesUI.roz;
            vVar3.qXs.putAll(snsAdNativeLandingPagesUI.qXs);
            vVar = snsAdNativeLandingPagesUI.roz;
            AppMethodBeat.o(37077);
            return vVar;
        }
        vVar = new v();
        AppMethodBeat.o(37077);
        return vVar;
    }

    public void a(r rVar) {
        AppMethodBeat.i(37067);
        r rVar2 = this.qZo;
        if (rVar2 == rVar) {
            AppMethodBeat.o(37067);
        } else if (rVar2 == null || !rVar2.equals(rVar)) {
            this.qZo = rVar;
            cpp();
            cpz();
            AppMethodBeat.o(37067);
        } else {
            AppMethodBeat.o(37067);
        }
    }

    public boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37075);
        if (this.qZp == 0) {
            AppMethodBeat.o(37075);
            return false;
        } else if (this.qZo.qXb) {
            AppMethodBeat.o(37075);
            return false;
        } else {
            try {
                jSONObject.put("cid", this.qZo.qWO);
                jSONObject.put("exposureCount", this.qZp);
                jSONObject.put("stayTime", this.iBA);
                AppMethodBeat.o(37075);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", e, "", new Object[0]);
                AppMethodBeat.o(37075);
                return false;
            }
        }
    }
}
