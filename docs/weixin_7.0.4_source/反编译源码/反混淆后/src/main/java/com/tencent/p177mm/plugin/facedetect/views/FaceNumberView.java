package com.tencent.p177mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.facedetect.views.FaceNumberItemView.C43047a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Timer;

/* renamed from: com.tencent.mm.plugin.facedetect.views.FaceNumberView */
public class FaceNumberView extends LinearLayout {
    private String mbh;
    private int mbi;
    private ViewGroup mbj;
    public FaceNumberItemView[] mbk;
    private int mbl;
    private Animation mbm;
    private C20662a mbn;

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceNumberView$a */
    public enum C20662a {
        Normal,
        Shine;

        static {
            AppMethodBeat.m2505o(652);
        }
    }

    public void setNumberLengthAndInflate(int i) {
        AppMethodBeat.m2504i(653);
        if (i > 12) {
            C4990ab.m7413e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(653);
        } else if (i <= 0) {
            C4990ab.m7413e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(653);
        } else if (i == this.mbl) {
            C4990ab.m7416i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
            mo35956Lw(null);
            AppMethodBeat.m2505o(653);
        } else {
            this.mbj.removeAllViews();
            this.mbl = i;
            this.mbk = new FaceNumberItemView[this.mbl];
            for (int i2 = 0; i2 < i; i2++) {
                int i3;
                int dimensionPixelSize;
                FaceNumberItemView faceNumberItemView = (FaceNumberItemView) FaceNumberView.inflate(getContext(), 2130969470, null);
                faceNumberItemView.setImageResource(C25738R.drawable.b3k);
                if (i2 == 0) {
                    i3 = 3;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(C25738R.dimen.a1w) + C1338a.fromDPToPix(getContext(), 48)) / 2;
                } else if (i2 == i - 1) {
                    i3 = 5;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(C25738R.dimen.a1w) + C1338a.fromDPToPix(getContext(), 48)) / 2;
                } else {
                    i3 = 17;
                    dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.a1w);
                }
                faceNumberItemView.setGravity(i3);
                this.mbk[i2] = faceNumberItemView;
                this.mbj.addView(faceNumberItemView, new LayoutParams(dimensionPixelSize, getResources().getDimensionPixelSize(C25738R.dimen.a1u)));
            }
            AppMethodBeat.m2505o(653);
        }
    }

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(654);
        this.mbh = null;
        this.mbk = null;
        this.mbl = 0;
        this.mbm = null;
        this.mbn = C20662a.Shine;
        this.mbj = (ViewGroup) FaceNumberView.inflate(getContext(), 2130969469, null);
        addView(this.mbj);
        this.mbm = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8362c4);
        AppMethodBeat.m2505o(654);
    }

    private void btL() {
        int i = 0;
        AppMethodBeat.m2504i(655);
        if (this.mbk != null && this.mbk.length > 0) {
            if (C5046bo.isNullOrNil(this.mbh)) {
                while (i < this.mbk.length) {
                    FaceNumberView.m31912a(this.mbk[i], "point");
                    i++;
                }
            } else {
                for (int i2 = 0; i2 < this.mbk.length; i2++) {
                    String str;
                    if (this.mbi > i2) {
                        String str2 = this.mbh.charAt(i2);
                        FaceNumberItemView faceNumberItemView;
                        if (this.mbi == i2 + 1) {
                            faceNumberItemView = this.mbk[i2];
                            if (faceNumberItemView.maW != null) {
                                faceNumberItemView.btK();
                            }
                            faceNumberItemView.maW = new Timer("FaceNumberItemView_karaoke", true);
                            faceNumberItemView.maW.scheduleAtFixedRate(new C43047a(faceNumberItemView, faceNumberItemView.mbe, (byte) 0), 0, FaceNumberItemView.maX);
                            str = str2;
                        } else {
                            this.mbk[i2].btK();
                            faceNumberItemView = this.mbk[i2];
                            faceNumberItemView.mbd = 30;
                            faceNumberItemView.invalidate();
                            str = str2;
                        }
                    } else {
                        str = "";
                    }
                    FaceNumberView.m31912a(this.mbk[i2], str);
                }
                AppMethodBeat.m2505o(655);
                return;
            }
        }
        AppMethodBeat.m2505o(655);
    }

    /* renamed from: a */
    private static void m31912a(FaceNumberItemView faceNumberItemView, String str) {
        AppMethodBeat.m2504i(656);
        if (faceNumberItemView == null) {
            AppMethodBeat.m2505o(656);
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3a);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("1")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3b);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("2")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3c);
            AppMethodBeat.m2505o(656);
        } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3d);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("4")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3e);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("5")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3f);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("6")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3g);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("7")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3h);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("8")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3i);
            AppMethodBeat.m2505o(656);
        } else if (str.equals("9")) {
            faceNumberItemView.setImageResource(C25738R.drawable.b3j);
            AppMethodBeat.m2505o(656);
        } else {
            faceNumberItemView.setImageResource(C25738R.drawable.b3k);
            AppMethodBeat.m2505o(656);
        }
    }

    private void btM() {
        AppMethodBeat.m2504i(657);
        if (this.mbh != null) {
            this.mbi = this.mbh.length();
            AppMethodBeat.m2505o(657);
            return;
        }
        this.mbi = 0;
        AppMethodBeat.m2505o(657);
    }

    /* renamed from: Lw */
    public final void mo35956Lw(String str) {
        AppMethodBeat.m2504i(658);
        this.mbh = str;
        btM();
        btL();
        AppMethodBeat.m2505o(658);
    }
}
