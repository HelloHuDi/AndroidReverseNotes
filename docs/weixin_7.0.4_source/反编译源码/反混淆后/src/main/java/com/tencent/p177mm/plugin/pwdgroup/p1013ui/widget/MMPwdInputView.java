package com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

/* renamed from: com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView */
public class MMPwdInputView extends LinearLayout {
    public StringBuilder enD;
    public int mbi;
    private ImageView psA;
    private C43395a psB;
    private C43396b psC;
    private boolean psw;
    private ImageView psx;
    private ImageView psy;
    private ImageView psz;

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView$a */
    public interface C43395a {
        /* renamed from: o */
        void mo46860o(boolean z, String str);
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView$b */
    public enum C43396b {
        Normal,
        Shine;

        static {
            AppMethodBeat.m2505o(24055);
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(24056);
        this.enD = new StringBuilder();
        this.psw = false;
        this.psC = C43396b.Shine;
        View inflate = MMPwdInputView.inflate(getContext(), 2130970418, null);
        this.psx = (ImageView) inflate.findViewById(2131826671);
        this.psy = (ImageView) inflate.findViewById(2131826672);
        this.psz = (ImageView) inflate.findViewById(2131826673);
        this.psA = (ImageView) inflate.findViewById(2131826674);
        this.psx.setImageResource(C25738R.drawable.awu);
        this.psy.setImageResource(C25738R.drawable.awu);
        this.psz.setImageResource(C25738R.drawable.awu);
        this.psA.setImageResource(C25738R.drawable.awu);
        addView(inflate);
        AppMethodBeat.m2505o(24056);
    }

    public void setOnFinishInputListener(C43395a c43395a) {
        this.psB = c43395a;
    }

    public void setNumberStyle(C43396b c43396b) {
        this.psC = c43396b;
    }

    public void setNumberWidth(int i) {
        AppMethodBeat.m2504i(24057);
        if (this.psx != null) {
            LayoutParams layoutParams = this.psx.getLayoutParams();
            layoutParams.width = i;
            this.psx.setLayoutParams(layoutParams);
            this.psy.setLayoutParams(layoutParams);
            this.psz.setLayoutParams(layoutParams);
            this.psA.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(24057);
    }

    public final void cbX() {
        AppMethodBeat.m2504i(24058);
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
                        MMPwdInputView.m77446q(this.psx, str);
                        break;
                    case 1:
                        MMPwdInputView.m77446q(this.psy, str);
                        break;
                    case 2:
                        MMPwdInputView.m77446q(this.psz, str);
                        break;
                    case 3:
                        MMPwdInputView.m77446q(this.psA, str);
                        break;
                    default:
                        break;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(24058);
                return;
            }
        }
    }

    /* renamed from: q */
    private static void m77446q(ImageView imageView, String str) {
        AppMethodBeat.m2504i(24059);
        if (imageView == null) {
            AppMethodBeat.m2505o(24059);
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            imageView.setImageResource(C25738R.drawable.awk);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("1")) {
            imageView.setImageResource(C25738R.drawable.awl);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("2")) {
            imageView.setImageResource(C25738R.drawable.awm);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            imageView.setImageResource(C25738R.drawable.awn);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("4")) {
            imageView.setImageResource(C25738R.drawable.awo);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("5")) {
            imageView.setImageResource(C25738R.drawable.awp);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("6")) {
            imageView.setImageResource(C25738R.drawable.awq);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("7")) {
            imageView.setImageResource(C25738R.drawable.awr);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("8")) {
            imageView.setImageResource(C25738R.drawable.aws);
            AppMethodBeat.m2505o(24059);
        } else if (str.equals("9")) {
            imageView.setImageResource(C25738R.drawable.awt);
            AppMethodBeat.m2505o(24059);
        } else {
            imageView.setImageResource(C25738R.drawable.awu);
            AppMethodBeat.m2505o(24059);
        }
    }

    public final void btM() {
        AppMethodBeat.m2504i(24060);
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
            this.psB.mo46860o(this.psw, this.enD.toString());
        }
        AppMethodBeat.m2505o(24060);
    }

    public final void axQ() {
        AppMethodBeat.m2504i(24061);
        if (this.mbi > 0) {
            this.enD.delete(0, this.mbi);
        }
        btM();
        cbX();
        AppMethodBeat.m2505o(24061);
    }

    public final void input(String str) {
        AppMethodBeat.m2504i(24062);
        if (TextUtils.isEmpty(str) || this.psw) {
            AppMethodBeat.m2505o(24062);
            return;
        }
        this.enD.append(str);
        btM();
        cbX();
        AppMethodBeat.m2505o(24062);
    }
}
