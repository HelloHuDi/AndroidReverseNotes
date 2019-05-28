package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.sns.p520ui.SnsAdNativeLandingPagesUI;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46234v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h */
public class C13437h {
    protected int backgroundColor;
    protected View contentView = null;
    protected Context context;
    private long iBA = 0;
    protected int ieu;
    protected int iev;
    protected C29086r qZo;
    private int qZp = 0;
    private long qZq = 0;
    boolean qZr = false;
    protected ViewGroup qZs;

    public C13437h(Context context, C29086r c29086r, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(37066);
        this.context = context;
        this.qZo = c29086r;
        this.qZs = viewGroup;
        int[] eP = C29064ad.m46206eP(context);
        this.ieu = eP[0];
        this.iev = eP[1];
        if (C5222ae.m7950hD(context)) {
            this.iev -= C5222ae.m7949hC(context);
        }
        AppMethodBeat.m2505o(37066);
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final View getView() {
        AppMethodBeat.m2504i(37068);
        View view;
        if (this.contentView != null) {
            view = this.contentView;
            AppMethodBeat.m2505o(37068);
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
                AppMethodBeat.m2505o(37068);
                throw illegalStateException;
            }
        }
        cpk();
        cpp();
        cpq();
        cpz();
        view = this.contentView;
        AppMethodBeat.m2505o(37068);
        return view;
    }

    public final C29086r cpv() {
        return this.qZo;
    }

    public void cpk() {
    }

    /* Access modifiers changed, original: protected */
    public void cpp() {
        AppMethodBeat.m2504i(37069);
        C4990ab.m7420w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
        AppMethodBeat.m2505o(37069);
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
        AppMethodBeat.m2504i(37070);
        if (this.qZr) {
            AppMethodBeat.m2505o(37070);
            return;
        }
        this.qZr = true;
        this.qZq = System.currentTimeMillis();
        this.qZp++;
        AppMethodBeat.m2505o(37070);
    }

    public void cpb() {
        AppMethodBeat.m2504i(37071);
        if (this.qZr) {
            this.qZr = false;
            if (this.qZq > 0) {
                this.iBA += System.currentTimeMillis() - this.qZq;
            }
            this.qZq = 0;
            AppMethodBeat.m2505o(37071);
            return;
        }
        AppMethodBeat.m2505o(37071);
    }

    public void cpc() {
    }

    public final int cpw() {
        AppMethodBeat.m2504i(37072);
        View view = getView();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int height = view.getHeight() + i;
        C4990ab.m7419v("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", this, Integer.valueOf(i), Integer.valueOf(height));
        if (i >= 0 && height <= this.iev) {
            height = view.getHeight();
        } else if (i >= 0 || height <= 0 || height > this.iev) {
            height = (i >= 0 || height <= this.iev) ? (i >= this.iev || height <= this.iev) ? 0 : this.iev - i : this.iev;
        }
        AppMethodBeat.m2505o(37072);
        return height;
    }

    public boolean cpx() {
        AppMethodBeat.m2504i(37073);
        if (cpw() >= Math.min(getView().getHeight() >>> 1, this.iev >>> 1)) {
            AppMethodBeat.m2505o(37073);
            return true;
        }
        AppMethodBeat.m2505o(37073);
        return false;
    }

    public void coZ() {
        AppMethodBeat.m2504i(37074);
        cpb();
        AppMethodBeat.m2505o(37074);
    }

    public final String cpy() {
        return this.qZo.qWO;
    }

    /* renamed from: x */
    public boolean mo25547x(JSONArray jSONArray) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cpq() {
    }

    public final void cpz() {
        AppMethodBeat.m2504i(37076);
        if (this.contentView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("set field contentView first");
            AppMethodBeat.m2505o(37076);
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
                AppMethodBeat.m2505o(37076);
                return;
            }
            C4990ab.m7416i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.qZs);
        }
        AppMethodBeat.m2505o(37076);
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

    /* renamed from: ae */
    public void mo25536ae(Map<String, Object> map) {
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

    public final C46234v cpC() {
        AppMethodBeat.m2504i(37077);
        C46234v c46234v;
        if (this.context instanceof SnsAdNativeLandingPagesUI) {
            SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
            if (snsAdNativeLandingPagesUI.roz != null) {
                c46234v = snsAdNativeLandingPagesUI.roz;
                AppMethodBeat.m2505o(37077);
                return c46234v;
            }
            int i;
            snsAdNativeLandingPagesUI.roz = new C46234v();
            C46234v c46234v2 = snsAdNativeLandingPagesUI.roz;
            if (snsAdNativeLandingPagesUI.qXp == 0) {
                i = snsAdNativeLandingPagesUI.cvd;
            } else {
                i = snsAdNativeLandingPagesUI.qXp;
            }
            c46234v2.qXp = i;
            snsAdNativeLandingPagesUI.roz.qXq = snsAdNativeLandingPagesUI.rob;
            snsAdNativeLandingPagesUI.roz.qPj = snsAdNativeLandingPagesUI.qPj;
            snsAdNativeLandingPagesUI.roz.uin = snsAdNativeLandingPagesUI.uin;
            snsAdNativeLandingPagesUI.roz.qXr = snsAdNativeLandingPagesUI.qXr;
            snsAdNativeLandingPagesUI.roz.qTL = snsAdNativeLandingPagesUI.qTL;
            snsAdNativeLandingPagesUI.roz.hcx = snsAdNativeLandingPagesUI.hcx;
            C46234v c46234v3 = snsAdNativeLandingPagesUI.roz;
            c46234v3.qXs.putAll(snsAdNativeLandingPagesUI.qXs);
            c46234v = snsAdNativeLandingPagesUI.roz;
            AppMethodBeat.m2505o(37077);
            return c46234v;
        }
        c46234v = new C46234v();
        AppMethodBeat.m2505o(37077);
        return c46234v;
    }

    /* renamed from: a */
    public void mo25535a(C29086r c29086r) {
        AppMethodBeat.m2504i(37067);
        C29086r c29086r2 = this.qZo;
        if (c29086r2 == c29086r) {
            AppMethodBeat.m2505o(37067);
        } else if (c29086r2 == null || !c29086r2.equals(c29086r)) {
            this.qZo = c29086r;
            cpp();
            cpz();
            AppMethodBeat.m2505o(37067);
        } else {
            AppMethodBeat.m2505o(37067);
        }
    }

    /* renamed from: al */
    public boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37075);
        if (this.qZp == 0) {
            AppMethodBeat.m2505o(37075);
            return false;
        } else if (this.qZo.qXb) {
            AppMethodBeat.m2505o(37075);
            return false;
        } else {
            try {
                jSONObject.put("cid", this.qZo.qWO);
                jSONObject.put("exposureCount", this.qZp);
                jSONObject.put("stayTime", this.iBA);
                AppMethodBeat.m2505o(37075);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", e, "", new Object[0]);
                AppMethodBeat.m2505o(37075);
                return false;
            }
        }
    }
}
