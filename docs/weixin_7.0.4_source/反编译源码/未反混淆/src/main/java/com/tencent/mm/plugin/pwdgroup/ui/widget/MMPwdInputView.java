package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMPwdInputView extends LinearLayout {
    public StringBuilder enD;
    public int mbi;
    private ImageView psA;
    private a psB;
    private b psC;
    private boolean psw;
    private ImageView psx;
    private ImageView psy;
    private ImageView psz;

    public interface a {
        void o(boolean z, String str);
    }

    public enum b {
        Normal,
        Shine;

        static {
            AppMethodBeat.o(24055);
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(24056);
        this.enD = new StringBuilder();
        this.psw = false;
        this.psC = b.Shine;
        View inflate = inflate(getContext(), R.layout.aly, null);
        this.psx = (ImageView) inflate.findViewById(R.id.dqm);
        this.psy = (ImageView) inflate.findViewById(R.id.dqn);
        this.psz = (ImageView) inflate.findViewById(R.id.dqo);
        this.psA = (ImageView) inflate.findViewById(R.id.dqp);
        this.psx.setImageResource(R.drawable.awu);
        this.psy.setImageResource(R.drawable.awu);
        this.psz.setImageResource(R.drawable.awu);
        this.psA.setImageResource(R.drawable.awu);
        addView(inflate);
        AppMethodBeat.o(24056);
    }

    public void setOnFinishInputListener(a aVar) {
        this.psB = aVar;
    }

    public void setNumberStyle(b bVar) {
        this.psC = bVar;
    }

    public void setNumberWidth(int i) {
        AppMethodBeat.i(24057);
        if (this.psx != null) {
            LayoutParams layoutParams = this.psx.getLayoutParams();
            layoutParams.width = i;
            this.psx.setLayoutParams(layoutParams);
            this.psy.setLayoutParams(layoutParams);
            this.psz.setLayoutParams(layoutParams);
            this.psA.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(24057);
    }

    public final void cbX() {
        AppMethodBeat.i(24058);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 4) {
                String str;
                if (this.mbi > i2) {
                    str = this.enD.toString().charAt(i2);
                } else {
                    str = "";
                }
                switch (i2) {
                    case 0:
                        q(this.psx, str);
                        break;
                    case 1:
                        q(this.psy, str);
                        break;
                    case 2:
                        q(this.psz, str);
                        break;
                    case 3:
                        q(this.psA, str);
                        break;
                    default:
                        break;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(24058);
                return;
            }
        }
    }

    private static void q(ImageView imageView, String str) {
        AppMethodBeat.i(24059);
        if (imageView == null) {
            AppMethodBeat.o(24059);
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            imageView.setImageResource(R.drawable.awk);
            AppMethodBeat.o(24059);
        } else if (str.equals("1")) {
            imageView.setImageResource(R.drawable.awl);
            AppMethodBeat.o(24059);
        } else if (str.equals("2")) {
            imageView.setImageResource(R.drawable.awm);
            AppMethodBeat.o(24059);
        } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            imageView.setImageResource(R.drawable.awn);
            AppMethodBeat.o(24059);
        } else if (str.equals("4")) {
            imageView.setImageResource(R.drawable.awo);
            AppMethodBeat.o(24059);
        } else if (str.equals("5")) {
            imageView.setImageResource(R.drawable.awp);
            AppMethodBeat.o(24059);
        } else if (str.equals("6")) {
            imageView.setImageResource(R.drawable.awq);
            AppMethodBeat.o(24059);
        } else if (str.equals("7")) {
            imageView.setImageResource(R.drawable.awr);
            AppMethodBeat.o(24059);
        } else if (str.equals("8")) {
            imageView.setImageResource(R.drawable.aws);
            AppMethodBeat.o(24059);
        } else if (str.equals("9")) {
            imageView.setImageResource(R.drawable.awt);
            AppMethodBeat.o(24059);
        } else {
            imageView.setImageResource(R.drawable.awu);
            AppMethodBeat.o(24059);
        }
    }

    public final void btM() {
        AppMethodBeat.i(24060);
        if (this.enD != null) {
            this.mbi = this.enD.length();
        } else {
            this.mbi = 0;
        }
        if (this.mbi >= 4) {
            this.psw = true;
        } else {
            this.psw = false;
        }
        if (this.psB != null) {
            this.psB.o(this.psw, this.enD.toString());
        }
        AppMethodBeat.o(24060);
    }

    public final void axQ() {
        AppMethodBeat.i(24061);
        if (this.mbi > 0) {
            this.enD.delete(0, this.mbi);
        }
        btM();
        cbX();
        AppMethodBeat.o(24061);
    }

    public final void input(String str) {
        AppMethodBeat.i(24062);
        if (TextUtils.isEmpty(str) || this.psw) {
            AppMethodBeat.o(24062);
            return;
        }
        this.enD.append(str);
        btM();
        cbX();
        AppMethodBeat.o(24062);
    }
}
