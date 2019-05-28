package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView */
public class NoiseDetectMaskView extends RelativeLayout {
    ProgressBar gHA = null;
    private Context mContext = null;
    TextView mMV;
    TextView sLY;
    private C35346b sLZ;
    private C35345a sMa;

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView$2 */
    class C42672 implements OnClickListener {
        C42672() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26142);
            if (NoiseDetectMaskView.this.sMa != null) {
                NoiseDetectMaskView.this.sMa.cHX();
            }
            AppMethodBeat.m2505o(26142);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView$1 */
    class C294801 implements OnClickListener {
        C294801() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26141);
            if (NoiseDetectMaskView.this.sLZ != null) {
                NoiseDetectMaskView.this.sLZ.cHY();
            }
            AppMethodBeat.m2505o(26141);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView$a */
    public interface C35345a {
        void cHX();
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView$b */
    public interface C35346b {
        void cHY();
    }

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(26143);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(2130970308, this);
        this.gHA = (ProgressBar) findViewById(2131826362);
        this.mMV = (TextView) findViewById(2131826363);
        this.sLY = (TextView) findViewById(2131826364);
        this.sLY.setOnClickListener(new C294801());
        findViewById(2131823808).setOnClickListener(new C42672());
        AppMethodBeat.m2505o(26143);
    }

    public void setOnClickRetryCallback(C35346b c35346b) {
        this.sLZ = c35346b;
    }

    public void setOnCancelDetectCallback(C35345a c35345a) {
        this.sMa = c35345a;
    }

    public final void reset() {
        AppMethodBeat.m2504i(26144);
        if (this.gHA != null) {
            this.gHA.setVisibility(0);
        }
        this.mMV.setText(C25738R.string.f2n);
        this.sLY.setVisibility(8);
        AppMethodBeat.m2505o(26144);
    }
}
