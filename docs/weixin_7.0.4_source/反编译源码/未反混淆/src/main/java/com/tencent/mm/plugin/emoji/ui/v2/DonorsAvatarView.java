package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView extends LinearLayout {
    private int lcQ;
    private int lcR;
    private int lcS;
    private int lcT;
    private LayoutParams lcU;
    private int mMaxCount;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53567);
        init();
        AppMethodBeat.o(53567);
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53568);
        init();
        AppMethodBeat.o(53568);
    }

    private void init() {
        AppMethodBeat.i(53569);
        setOrientation(0);
        this.lcQ = a.gd(getContext());
        this.lcR = a.al(getContext(), R.dimen.a0e);
        this.lcS = a.al(getContext(), R.dimen.f15do);
        this.lcT = a.al(getContext(), R.dimen.m4);
        this.lcU = new LayoutParams(this.lcR, this.lcR);
        this.lcU.leftMargin = this.lcS;
        this.lcU.rightMargin = this.lcS;
        this.mMaxCount = (this.lcQ - (this.lcT * 2)) / (this.lcR + (this.lcS * 2));
        ab.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", Integer.valueOf(this.mMaxCount));
        AppMethodBeat.o(53569);
    }

    public final void c(String str, LinkedList<EmotionDonor> linkedList) {
        AppMethodBeat.i(53570);
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i = 0; i < size; i++) {
                EmotionDonor emotionDonor = (EmotionDonor) linkedList.get(i);
                if (emotionDonor != null) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.lcU);
                    if (bo.isNullOrNil(emotionDonor.HeadUrl)) {
                        try {
                            imageView.setImageBitmap(b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", e, "", new Object[0]);
                        }
                    } else {
                        o.ahp().a(emotionDonor.HeadUrl, imageView, g.l(str, emotionDonor.HeadUrl, new Object[0]));
                    }
                    addView(imageView);
                }
            }
        }
        AppMethodBeat.o(53570);
    }
}
