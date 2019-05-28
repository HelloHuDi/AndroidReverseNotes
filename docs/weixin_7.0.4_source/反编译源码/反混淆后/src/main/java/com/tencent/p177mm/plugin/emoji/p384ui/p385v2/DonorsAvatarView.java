package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.protocal.protobuf.EmotionDonor;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView */
public class DonorsAvatarView extends LinearLayout {
    private int lcQ;
    private int lcR;
    private int lcS;
    private int lcT;
    private LayoutParams lcU;
    private int mMaxCount;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53567);
        init();
        AppMethodBeat.m2505o(53567);
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(53568);
        init();
        AppMethodBeat.m2505o(53568);
    }

    private void init() {
        AppMethodBeat.m2504i(53569);
        setOrientation(0);
        this.lcQ = C1338a.m2868gd(getContext());
        this.lcR = C1338a.m2856al(getContext(), C25738R.dimen.a0e);
        this.lcS = C1338a.m2856al(getContext(), C25738R.dimen.f9723do);
        this.lcT = C1338a.m2856al(getContext(), C25738R.dimen.f9979m4);
        this.lcU = new LayoutParams(this.lcR, this.lcR);
        this.lcU.leftMargin = this.lcS;
        this.lcU.rightMargin = this.lcS;
        this.mMaxCount = (this.lcQ - (this.lcT * 2)) / (this.lcR + (this.lcS * 2));
        C4990ab.m7417i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", Integer.valueOf(this.mMaxCount));
        AppMethodBeat.m2505o(53569);
    }

    /* renamed from: c */
    public final void mo54529c(String str, LinkedList<EmotionDonor> linkedList) {
        AppMethodBeat.m2504i(53570);
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i = 0; i < size; i++) {
                EmotionDonor emotionDonor = (EmotionDonor) linkedList.get(i);
                if (emotionDonor != null) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.lcU);
                    if (C5046bo.isNullOrNil(emotionDonor.HeadUrl)) {
                        try {
                            imageView.setImageBitmap(C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null)));
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", e, "", new Object[0]);
                        }
                    } else {
                        C32291o.ahp().mo43766a(emotionDonor.HeadUrl, imageView, C20364g.m31465l(str, emotionDonor.HeadUrl, new Object[0]));
                    }
                    addView(imageView);
                }
            }
        }
        AppMethodBeat.m2505o(53570);
    }
}
