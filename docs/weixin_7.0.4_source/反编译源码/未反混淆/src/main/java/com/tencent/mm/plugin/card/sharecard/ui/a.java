package com.tencent.mm.plugin.card.sharecard.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    Bitmap gKF;
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(88089);
            if (view.getId() == R.id.ab4) {
                if (a.this.kge.isChecked()) {
                    if (a.this.kgi != null) {
                        a.this.kgi.sV(1);
                        AppMethodBeat.o(88089);
                        return;
                    }
                } else if (a.this.kgi != null) {
                    a.this.kgi.sV(0);
                }
            }
            AppMethodBeat.o(88089);
        }
    };
    private View jcl;
    MMActivity jiE;
    b kaS;
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
    a kgi;
    float kgj = 0.0f;
    private OnLongClickListener kgk = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(88090);
            if (view.getId() == R.id.aa7) {
                p.wG(a.this.kaS.aZW().code);
                h.bQ(a.this.jiE, a.this.jiE.getString(R.string.oz));
            }
            AppMethodBeat.o(88090);
            return false;
        }
    };

    public interface a {
        void sV(int i);
    }

    public a(MMActivity mMActivity, View view) {
        AppMethodBeat.i(88091);
        this.jiE = mMActivity;
        this.jcl = view;
        AppMethodBeat.o(88091);
    }

    public final void GL(String str) {
        this.kgg = 1;
        this.kgf = str;
    }

    /* Access modifiers changed, original: final */
    public final void ay(float f) {
        AppMethodBeat.i(88093);
        LayoutParams attributes = this.jiE.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.jiE.getWindow().setAttributes(attributes);
        AppMethodBeat.o(88093);
    }

    public final void initView() {
        AppMethodBeat.i(88094);
        this.kgc = (TextView) this.jcl.findViewById(R.id.ab0);
        this.kgd = (TextView) this.jcl.findViewById(R.id.aat);
        this.kge = (CheckBox) this.jcl.findViewById(R.id.ab4);
        this.kge.setChecked(true);
        this.kge.setOnClickListener(this.gKK);
        if (this.kgj < 0.8f) {
            ay(0.8f);
        }
        AppMethodBeat.o(88094);
    }

    public final void bbB() {
        AppMethodBeat.i(88095);
        ab.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (this.kgh) {
            String str;
            ImageView imageView;
            if (!bo.isNullOrNil(this.kaS.aZW().vSo)) {
                ab.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", this.kaS.aZW().vSo);
                str = r0;
            } else if (this.kaS.aZQ()) {
                ab.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", am.bbj().getCode());
                str = r0;
            } else {
                ab.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", this.kaS.aZW().code);
                str = r0;
            }
            View view;
            TextView textView;
            switch (this.kaS.aZW().vSb) {
                case 0:
                    if (this.kga == null) {
                        this.kga = ((ViewStub) this.jcl.findViewById(R.id.aay)).inflate();
                    }
                    TextView textView2 = (TextView) this.kga.findViewById(R.id.aa7);
                    textView2.setText(m.Hu(str));
                    textView2.setOnLongClickListener(this.kgk);
                    if (!this.kaS.aZD()) {
                        textView2.setTextColor(l.Hn(this.kaS.aZV().color));
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
                    da(this.kga);
                    break;
                case 1:
                    if (this.kfZ == null) {
                        this.kfZ = ((ViewStub) this.jcl.findViewById(R.id.aaw)).inflate();
                    }
                    view = this.kfZ;
                    imageView = (ImageView) view.findViewById(R.id.aa5);
                    textView = (TextView) view.findViewById(R.id.aa7);
                    if (!this.kaS.aZD()) {
                        textView.setTextColor(l.Hn(this.kaS.aZV().color));
                    }
                    if (TextUtils.isEmpty(str) || str.length() > 40) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(m.Hu(str));
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
                        l.K(this.kgb);
                        if (TextUtils.isEmpty(str)) {
                            this.kgb = null;
                            imageView.setImageBitmap(this.kgb);
                        } else {
                            this.kgb = com.tencent.mm.bw.a.a.b(this.jiE, str, 5, 0);
                            a(imageView, this.kgb);
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.CardConsumeCodeController", e, "", new Object[0]);
                    }
                    da(this.kfZ);
                    break;
                case 2:
                    if (this.kfY == null) {
                        this.kfY = ((ViewStub) this.jcl.findViewById(R.id.aau)).inflate();
                    }
                    view = this.kfY;
                    imageView = (ImageView) view.findViewById(R.id.aab);
                    textView = (TextView) view.findViewById(R.id.aa7);
                    if (!this.kaS.aZD()) {
                        textView.setTextColor(l.Hn(this.kaS.aZV().color));
                    }
                    if (str.length() <= 40) {
                        textView.setText(m.Hu(str));
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
                        l.K(this.gKF);
                        if (TextUtils.isEmpty(str)) {
                            this.gKF = null;
                            imageView.setImageBitmap(this.gKF);
                        } else {
                            this.gKF = com.tencent.mm.bw.a.a.b(this.jiE, str, 12, 3);
                            a(imageView, this.gKF);
                        }
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                    }
                    da(this.kfY);
                    break;
            }
            if (bo.isNullOrNil(this.kaS.aZV().kCx)) {
                this.kgc.setVisibility(8);
                this.kgd.setVisibility(8);
            } else if (this.kaS.aZV().vUA != null) {
                this.kgd.setText(this.kaS.aZV().kCx);
                this.kgd.setVisibility(0);
                this.kgc.setVisibility(8);
                if (this.kfY != null) {
                    imageView = (ImageView) this.kfY.findViewById(R.id.aab);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(this.jiE, 180);
                    layoutParams.width = com.tencent.mm.bz.a.fromDPToPix(this.jiE, 180);
                    imageView.setLayoutParams(layoutParams);
                }
            } else {
                this.kgc.setText(this.kaS.aZV().kCx);
                this.kgc.setVisibility(0);
            }
            if (!this.kaS.aZC() || TextUtils.isEmpty(this.kaS.bab()) || this.kaS.bab().equals(r.Yz())) {
                this.kge.setChecked(false);
                this.kge.setVisibility(8);
                AppMethodBeat.o(88095);
                return;
            }
            this.kge.setVisibility(0);
            this.kge.setText(j.f(this.jiE, " " + this.jiE.getString(R.string.ad7, new Object[]{l.Hp(this.kaS.bab())}), this.jiE.getResources().getDimensionPixelOffset(R.dimen.ni)));
            AppMethodBeat.o(88095);
            return;
        }
        ab.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
        AppMethodBeat.o(88095);
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        AppMethodBeat.i(88096);
        if (imageView == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(88096);
            return;
        }
        imageView.setImageBitmap(bitmap);
        if (this.kgg != 1) {
            imageView.setAlpha(10);
            AppMethodBeat.o(88096);
            return;
        }
        imageView.setAlpha(255);
        AppMethodBeat.o(88096);
    }

    private void da(View view) {
        AppMethodBeat.i(88097);
        Button button = (Button) view.findViewById(R.id.aa6);
        if (this.kgg == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.kgg == -1) {
            button.setText(R.string.afr);
        }
        AppMethodBeat.o(88097);
    }

    public final void onCreate() {
        AppMethodBeat.i(88092);
        this.kgj = this.jiE.getWindow().getAttributes().screenBrightness;
        AppMethodBeat.o(88092);
    }
}
