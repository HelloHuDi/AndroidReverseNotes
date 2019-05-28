package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Timer;

public class FaceNumberView extends LinearLayout {
    private String mbh;
    private int mbi;
    private ViewGroup mbj;
    public FaceNumberItemView[] mbk;
    private int mbl;
    private Animation mbm;
    private a mbn;

    public enum a {
        Normal,
        Shine;

        static {
            AppMethodBeat.o(652);
        }
    }

    public void setNumberLengthAndInflate(int i) {
        AppMethodBeat.i(653);
        if (i > 12) {
            ab.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", Integer.valueOf(i));
            AppMethodBeat.o(653);
        } else if (i <= 0) {
            ab.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", Integer.valueOf(i));
            AppMethodBeat.o(653);
        } else if (i == this.mbl) {
            ab.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
            Lw(null);
            AppMethodBeat.o(653);
        } else {
            this.mbj.removeAllViews();
            this.mbl = i;
            this.mbk = new FaceNumberItemView[this.mbl];
            for (int i2 = 0; i2 < i; i2++) {
                int i3;
                int dimensionPixelSize;
                FaceNumberItemView faceNumberItemView = (FaceNumberItemView) inflate(getContext(), R.layout.xe, null);
                faceNumberItemView.setImageResource(R.drawable.b3k);
                if (i2 == 0) {
                    i3 = 3;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(R.dimen.a1w) + com.tencent.mm.bz.a.fromDPToPix(getContext(), 48)) / 2;
                } else if (i2 == i - 1) {
                    i3 = 5;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(R.dimen.a1w) + com.tencent.mm.bz.a.fromDPToPix(getContext(), 48)) / 2;
                } else {
                    i3 = 17;
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a1w);
                }
                faceNumberItemView.setGravity(i3);
                this.mbk[i2] = faceNumberItemView;
                this.mbj.addView(faceNumberItemView, new LayoutParams(dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.a1u)));
            }
            AppMethodBeat.o(653);
        }
    }

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(654);
        this.mbh = null;
        this.mbk = null;
        this.mbl = 0;
        this.mbm = null;
        this.mbn = a.Shine;
        this.mbj = (ViewGroup) inflate(getContext(), R.layout.xd, null);
        addView(this.mbj);
        this.mbm = AnimationUtils.loadAnimation(getContext(), R.anim.c4);
        AppMethodBeat.o(654);
    }

    private void btL() {
        int i = 0;
        AppMethodBeat.i(655);
        if (this.mbk != null && this.mbk.length > 0) {
            if (bo.isNullOrNil(this.mbh)) {
                while (i < this.mbk.length) {
                    a(this.mbk[i], "point");
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
                            faceNumberItemView.maW.scheduleAtFixedRate(new a(faceNumberItemView, faceNumberItemView.mbe, (byte) 0), 0, FaceNumberItemView.maX);
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
                    a(this.mbk[i2], str);
                }
                AppMethodBeat.o(655);
                return;
            }
        }
        AppMethodBeat.o(655);
    }

    private static void a(FaceNumberItemView faceNumberItemView, String str) {
        AppMethodBeat.i(656);
        if (faceNumberItemView == null) {
            AppMethodBeat.o(656);
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            faceNumberItemView.setImageResource(R.drawable.b3a);
            AppMethodBeat.o(656);
        } else if (str.equals("1")) {
            faceNumberItemView.setImageResource(R.drawable.b3b);
            AppMethodBeat.o(656);
        } else if (str.equals("2")) {
            faceNumberItemView.setImageResource(R.drawable.b3c);
            AppMethodBeat.o(656);
        } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            faceNumberItemView.setImageResource(R.drawable.b3d);
            AppMethodBeat.o(656);
        } else if (str.equals("4")) {
            faceNumberItemView.setImageResource(R.drawable.b3e);
            AppMethodBeat.o(656);
        } else if (str.equals("5")) {
            faceNumberItemView.setImageResource(R.drawable.b3f);
            AppMethodBeat.o(656);
        } else if (str.equals("6")) {
            faceNumberItemView.setImageResource(R.drawable.b3g);
            AppMethodBeat.o(656);
        } else if (str.equals("7")) {
            faceNumberItemView.setImageResource(R.drawable.b3h);
            AppMethodBeat.o(656);
        } else if (str.equals("8")) {
            faceNumberItemView.setImageResource(R.drawable.b3i);
            AppMethodBeat.o(656);
        } else if (str.equals("9")) {
            faceNumberItemView.setImageResource(R.drawable.b3j);
            AppMethodBeat.o(656);
        } else {
            faceNumberItemView.setImageResource(R.drawable.b3k);
            AppMethodBeat.o(656);
        }
    }

    private void btM() {
        AppMethodBeat.i(657);
        if (this.mbh != null) {
            this.mbi = this.mbh.length();
            AppMethodBeat.o(657);
            return;
        }
        this.mbi = 0;
        AppMethodBeat.o(657);
    }

    public final void Lw(String str) {
        AppMethodBeat.i(658);
        this.mbh = str;
        btM();
        btL();
        AppMethodBeat.o(658);
    }
}
