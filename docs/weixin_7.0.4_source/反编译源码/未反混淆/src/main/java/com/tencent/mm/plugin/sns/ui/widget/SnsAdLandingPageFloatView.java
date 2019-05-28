package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView extends FrameLayout {
    public String cHR;
    public String hcx;
    private boolean isResume;
    public ValueAnimator nVR = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f}).setDuration(100);
    public String qPj;
    public String qTM;
    private Map<String, String> qXs = new HashMap();
    public boolean rEC;
    public int rMA;
    public String rMB;
    public String rMC;
    public p rMD;
    public g rME;
    public h rMF;
    public View rMG;
    public AnimatorSet rMH = new AnimatorSet();
    public LinkedList<g> rnM = new LinkedList();
    public String rnT;
    private List<h> rot;

    public SnsAdLandingPageFloatView(Context context) {
        super(context, null);
        AppMethodBeat.i(40447);
        AppMethodBeat.o(40447);
    }

    public SnsAdLandingPageFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        AppMethodBeat.i(40448);
        AppMethodBeat.o(40448);
    }

    public SnsAdLandingPageFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, -1);
        AppMethodBeat.i(40449);
        AppMethodBeat.o(40449);
    }

    public final void onResume() {
        AppMethodBeat.i(40450);
        this.isResume = true;
        if (this.rME != null) {
            this.rMF.cpa();
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(40446);
                    SnsAdLandingPageFloatView.this.rMF.cpc();
                    AppMethodBeat.o(40446);
                }
            });
        }
        AppMethodBeat.o(40450);
    }

    public final void onPause() {
        AppMethodBeat.i(40451);
        this.isResume = false;
        if (this.rME != null) {
            this.rMF.cpb();
        }
        AppMethodBeat.o(40451);
    }

    public final void cvw() {
        AppMethodBeat.i(40452);
        if (this.rME != null && !bo.isNullOrNil(this.qTM)) {
            String str = ".adCardItemList.cardItem";
            Map z = br.z(this.qTM, "adCardItemList");
            int i = 0;
            while (true) {
                String str2;
                if (i > 0) {
                    str2 = str + i;
                } else {
                    str2 = str;
                }
                if (!z.containsKey(str2 + ".cardTpId")) {
                    break;
                }
                String bc = bo.bc((String) z.get(str2 + ".cardTpId"), "");
                String bc2 = bo.bc((String) z.get(str2 + ".cardExt"), "");
                if (!(bo.isNullOrNil(bc) || bo.isNullOrNil(bc2))) {
                    this.qXs.put(bc, bc2);
                }
                i++;
            }
        }
        AppMethodBeat.o(40452);
    }

    public List<h> getAllComp() {
        AppMethodBeat.i(40453);
        if (this.rot != null) {
            List list = this.rot;
            AppMethodBeat.o(40453);
            return list;
        }
        this.rot = new ArrayList();
        this.rot.add(this.rMF);
        i.dj(this.rot);
        List<h> list2 = this.rot;
        AppMethodBeat.o(40453);
        return list2;
    }
}
