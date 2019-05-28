package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p931d.C27577p;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.a */
public final class C42861a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    Bitmap gKF;
    private OnClickListener gKK = new C337771();
    private View jcl;
    MMActivity jiE;
    C42837b kaS;
    private View kfY;
    private View kfZ;
    private View kga;
    Bitmap kgb;
    private TextView kgc;
    private TextView kgd;
    CheckBox kge;
    private String kgf;
    private int kgg = 1;
    boolean kgh = false;
    C2760a kgi;
    float kgj = 0.0f;
    private OnLongClickListener kgk = new C337782();

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.a$a */
    public interface C2760a {
        /* renamed from: sV */
        void mo6843sV(int i);
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.a$1 */
    class C337771 implements OnClickListener {
        C337771() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88089);
            if (view.getId() == 2131821992) {
                if (C42861a.this.kge.isChecked()) {
                    if (C42861a.this.kgi != null) {
                        C42861a.this.kgi.mo6843sV(1);
                        AppMethodBeat.m2505o(88089);
                        return;
                    }
                } else if (C42861a.this.kgi != null) {
                    C42861a.this.kgi.mo6843sV(0);
                }
            }
            AppMethodBeat.m2505o(88089);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.a$2 */
    class C337782 implements OnLongClickListener {
        C337782() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(88090);
            if (view.getId() == 2131821958) {
                C27577p.m43810wG(C42861a.this.kaS.aZW().code);
                C30379h.m48465bQ(C42861a.this.jiE, C42861a.this.jiE.getString(C25738R.string.f9083oz));
            }
            AppMethodBeat.m2505o(88090);
            return false;
        }
    }

    public C42861a(MMActivity mMActivity, View view) {
        AppMethodBeat.m2504i(88091);
        this.jiE = mMActivity;
        this.jcl = view;
        AppMethodBeat.m2505o(88091);
    }

    /* renamed from: GL */
    public final void mo68366GL(String str) {
        this.kgg = 1;
        this.kgf = str;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ay */
    public final void mo68367ay(float f) {
        AppMethodBeat.m2504i(88093);
        LayoutParams attributes = this.jiE.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.jiE.getWindow().setAttributes(attributes);
        AppMethodBeat.m2505o(88093);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88094);
        this.kgc = (TextView) this.jcl.findViewById(2131821988);
        this.kgd = (TextView) this.jcl.findViewById(2131821981);
        this.kge = (CheckBox) this.jcl.findViewById(2131821992);
        this.kge.setChecked(true);
        this.kge.setOnClickListener(this.gKK);
        if (this.kgj < 0.8f) {
            mo68367ay(0.8f);
        }
        AppMethodBeat.m2505o(88094);
    }

    public final void bbB() {
        AppMethodBeat.m2504i(88095);
        C4990ab.m7416i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (this.kgh) {
            String str;
            ImageView imageView;
            if (!C5046bo.isNullOrNil(this.kaS.aZW().vSo)) {
                C4990ab.m7417i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", this.kaS.aZW().vSo);
                str = r0;
            } else if (this.kaS.aZQ()) {
                C4990ab.m7417i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", C42852am.bbj().getCode());
                str = r0;
            } else {
                C4990ab.m7417i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", this.kaS.aZW().code);
                str = r0;
            }
            View view;
            TextView textView;
            switch (this.kaS.aZW().vSb) {
                case 0:
                    if (this.kga == null) {
                        this.kga = ((ViewStub) this.jcl.findViewById(2131821986)).inflate();
                    }
                    TextView textView2 = (TextView) this.kga.findViewById(2131821958);
                    textView2.setText(C45778m.m84640Hu(str));
                    textView2.setOnLongClickListener(this.kgk);
                    if (!this.kaS.aZD()) {
                        textView2.setTextColor(C38736l.m65701Hn(this.kaS.aZV().color));
                    }
                    if (str.length() <= 12) {
                        textView2.setTextSize(1, 33.0f);
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView2.setTextSize(1, 30.0f);
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView2.setTextSize(1, 24.0f);
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView2.setTextSize(1, 18.0f);
                    } else if (str.length() > 40) {
                        textView2.setVisibility(8);
                    }
                    m76100da(this.kga);
                    break;
                case 1:
                    if (this.kfZ == null) {
                        this.kfZ = ((ViewStub) this.jcl.findViewById(2131821984)).inflate();
                    }
                    view = this.kfZ;
                    imageView = (ImageView) view.findViewById(2131821956);
                    textView = (TextView) view.findViewById(2131821958);
                    if (!this.kaS.aZD()) {
                        textView.setTextColor(C38736l.m65701Hn(this.kaS.aZV().color));
                    }
                    if (TextUtils.isEmpty(str) || str.length() > 40) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(C45778m.m84640Hu(str));
                        if (this.kaS.aZM()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.kgk);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                    if (this.kgg != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        C38736l.m65709K(this.kgb);
                        if (TextUtils.isEmpty(str)) {
                            this.kgb = null;
                            imageView.setImageBitmap(this.kgb);
                        } else {
                            this.kgb = C37623a.m63542b(this.jiE, str, 5, 0);
                            m76099a(imageView, this.kgb);
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.CardConsumeCodeController", e, "", new Object[0]);
                    }
                    m76100da(this.kfZ);
                    break;
                case 2:
                    if (this.kfY == null) {
                        this.kfY = ((ViewStub) this.jcl.findViewById(2131821982)).inflate();
                    }
                    view = this.kfY;
                    imageView = (ImageView) view.findViewById(2131821963);
                    textView = (TextView) view.findViewById(2131821958);
                    if (!this.kaS.aZD()) {
                        textView.setTextColor(C38736l.m65701Hn(this.kaS.aZV().color));
                    }
                    if (str.length() <= 40) {
                        textView.setText(C45778m.m84640Hu(str));
                        if (this.kaS.aZM()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.kgk);
                        } else {
                            textView.setVisibility(8);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                    if (this.kgg != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        C38736l.m65709K(this.gKF);
                        if (TextUtils.isEmpty(str)) {
                            this.gKF = null;
                            imageView.setImageBitmap(this.gKF);
                        } else {
                            this.gKF = C37623a.m63542b(this.jiE, str, 12, 3);
                            m76099a(imageView, this.gKF);
                        }
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                    }
                    m76100da(this.kfY);
                    break;
            }
            if (C5046bo.isNullOrNil(this.kaS.aZV().kCx)) {
                this.kgc.setVisibility(8);
                this.kgd.setVisibility(8);
            } else if (this.kaS.aZV().vUA != null) {
                this.kgd.setText(this.kaS.aZV().kCx);
                this.kgd.setVisibility(0);
                this.kgc.setVisibility(8);
                if (this.kfY != null) {
                    imageView = (ImageView) this.kfY.findViewById(2131821963);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = C1338a.fromDPToPix(this.jiE, 180);
                    layoutParams.width = C1338a.fromDPToPix(this.jiE, 180);
                    imageView.setLayoutParams(layoutParams);
                }
            } else {
                this.kgc.setText(this.kaS.aZV().kCx);
                this.kgc.setVisibility(0);
            }
            if (!this.kaS.aZC() || TextUtils.isEmpty(this.kaS.bab()) || this.kaS.bab().equals(C1853r.m3846Yz())) {
                this.kge.setChecked(false);
                this.kge.setVisibility(8);
                AppMethodBeat.m2505o(88095);
                return;
            }
            this.kge.setVisibility(0);
            this.kge.setText(C44089j.m79305f(this.jiE, " " + this.jiE.getString(C25738R.string.ad7, new Object[]{C38736l.m65703Hp(this.kaS.bab())}), this.jiE.getResources().getDimensionPixelOffset(C25738R.dimen.f10016ni)));
            AppMethodBeat.m2505o(88095);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
        AppMethodBeat.m2505o(88095);
    }

    /* renamed from: a */
    private void m76099a(ImageView imageView, Bitmap bitmap) {
        AppMethodBeat.m2504i(88096);
        if (imageView == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(88096);
            return;
        }
        imageView.setImageBitmap(bitmap);
        if (this.kgg != 1) {
            imageView.setAlpha(10);
            AppMethodBeat.m2505o(88096);
            return;
        }
        imageView.setAlpha(255);
        AppMethodBeat.m2505o(88096);
    }

    /* renamed from: da */
    private void m76100da(View view) {
        AppMethodBeat.m2504i(88097);
        Button button = (Button) view.findViewById(2131821957);
        if (this.kgg == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.kgg == -1) {
            button.setText(C25738R.string.afr);
        }
        AppMethodBeat.m2505o(88097);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(88092);
        this.kgj = this.jiE.getWindow().getAttributes().screenBrightness;
        AppMethodBeat.m2505o(88092);
    }
}
