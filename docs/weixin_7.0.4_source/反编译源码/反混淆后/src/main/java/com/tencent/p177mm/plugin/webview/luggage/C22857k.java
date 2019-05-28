package com.tencent.p177mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.webview.luggage.p1330b.C40224l;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.k */
public class C22857k extends LinearLayout {
    private TextView iDT;
    private ImageView kiE;
    protected Context mContext;
    private String mTitle;
    private C24905d uiI;
    private ImageView uiY;
    private TextView uiZ;
    private C40246n uja;
    protected C40224l ujb;
    private C43906r ujc;
    public C5653c ujd = null;
    private boolean uje = false;
    private OnClickListener ujf = new C145018();

    /* renamed from: com.tencent.mm.plugin.webview.luggage.k$8 */
    class C145018 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.webview.luggage.k$8$1 */
        class C145021 extends C17817c {
            C145021() {
            }

            public final String name() {
                return "onNavigationBarRightButtonClick";
            }

            /* renamed from: wQ */
            public final JSONObject mo7075wQ() {
                AppMethodBeat.m2504i(6179);
                JSONObject jSONObject = new JSONObject();
                AppMethodBeat.m2505o(6179);
                return jSONObject;
            }
        }

        C145018() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(6180);
            if (C22857k.this.uiI == null) {
                AppMethodBeat.m2505o(6180);
                return;
            }
            C22857k.this.uiI.bPN.mo52826a(new C145021());
            AppMethodBeat.m2505o(6180);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.k$6 */
    class C228586 implements DialogInterface.OnClickListener {
        C228586() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(6177);
            C22857k.this.ujd = null;
            AppMethodBeat.m2505o(6177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.k$1 */
    class C228601 implements OnClickListener {
        C228601() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(6172);
            if (!C22857k.this.cWG()) {
                C22857k.this.bDx();
            }
            AppMethodBeat.m2505o(6172);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.k$4 */
    class C228614 implements Runnable {
        C228614() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6175);
            C22857k.this.uja = new C40246n(C22857k.this.uiI, C22857k.this.getMenuHelp());
            AppMethodBeat.m2505o(6175);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.k$5 */
    class C228625 implements DialogInterface.OnClickListener {
        C228625() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(6176);
            C22857k.this.ujd = null;
            C22857k.this.bDx();
            AppMethodBeat.m2505o(6176);
        }
    }

    public C22857k(final C24905d c24905d) {
        super(c24905d.mContext);
        AppMethodBeat.m2504i(6181);
        this.mContext = c24905d.mContext;
        this.uiI = c24905d;
        setLayoutParams(new LayoutParams(-1, getActionBarHeight()));
        setBackgroundResource(C25738R.color.f11695dt);
        View inflate = C5616v.m8409hu(getContext()).inflate(2130971208, this, false);
        addView(inflate);
        this.kiE = (ImageView) inflate.findViewById(2131822906);
        this.kiE.setOnClickListener(new C228601());
        this.iDT = (TextView) inflate.findViewById(2131820678);
        this.uiY = (ImageView) inflate.findViewById(2131822907);
        this.uiY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(6173);
                if (c24905d.bPe.mo43476xh().peek() == C22857k.this.uiI) {
                    C22857k.this.bDy();
                }
                AppMethodBeat.m2505o(6173);
            }
        });
        this.uiY.setClickable(false);
        this.uiZ = (TextView) inflate.findViewById(2131829162);
        this.uiZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(6174);
                if (c24905d.bPe.mo43476xh().peek() == C22857k.this.uiI) {
                    C22857k.this.bDy();
                }
                AppMethodBeat.m2505o(6174);
            }
        });
        this.uiZ.setClickable(false);
        AppMethodBeat.m2505o(6181);
    }

    public void setOptionEnable(boolean z) {
        AppMethodBeat.m2504i(6182);
        if (z) {
            this.uiY.setClickable(true);
            this.uiZ.setClickable(true);
            AppMethodBeat.m2505o(6182);
            return;
        }
        this.uiY.setClickable(false);
        this.uiZ.setClickable(false);
        AppMethodBeat.m2505o(6182);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitleText(String str) {
        AppMethodBeat.m2504i(6183);
        C4990ab.m7411d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", str);
        this.mTitle = str;
        this.iDT.setText(str);
        AppMethodBeat.m2505o(6183);
    }

    public void setTitleColor(int i) {
        AppMethodBeat.m2504i(6184);
        this.iDT.setTextColor(i);
        AppMethodBeat.m2505o(6184);
    }

    /* Access modifiers changed, original: protected */
    public C40224l getMenuHelp() {
        AppMethodBeat.m2504i(6185);
        if (this.ujb == null) {
            this.ujb = new C40224l();
        }
        C40224l c40224l = this.ujb;
        AppMethodBeat.m2505o(6185);
        return c40224l;
    }

    public void bDy() {
        AppMethodBeat.m2504i(6186);
        boolean z = false;
        if (getContext() instanceof MMActivity) {
            z = ((MMActivity) getContext()).mController.hideVKB();
        }
        C5004al.m7442n(new C228614(), z ? 100 : 0);
        AppMethodBeat.m2505o(6186);
    }

    public void bDz() {
        AppMethodBeat.m2504i(6187);
        if (this.uja != null) {
            this.uja.cXg();
        }
        AppMethodBeat.m2505o(6187);
    }

    private int getActionBarHeight() {
        int dimensionPixelSize;
        AppMethodBeat.m2504i(6188);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
        }
        AppMethodBeat.m2505o(6188);
        return dimensionPixelSize;
    }

    public void bDx() {
        AppMethodBeat.m2504i(6189);
        if (!this.uiI.bPe.mo43477xi().mo60238xb()) {
            ((Activity) this.mContext).finish();
        }
        AppMethodBeat.m2505o(6189);
    }

    public final void cXc() {
        AppMethodBeat.m2504i(6190);
        getMenuHelp().cXc();
        AppMethodBeat.m2505o(6190);
    }

    public final void cXd() {
        AppMethodBeat.m2504i(6191);
        getMenuHelp().cXd();
        AppMethodBeat.m2505o(6191);
    }

    /* renamed from: H */
    public final void mo38436H(JSONArray jSONArray) {
        AppMethodBeat.m2504i(6192);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                getMenuHelp().aeg(jSONArray.optString(i));
            }
        }
        AppMethodBeat.m2505o(6192);
    }

    /* renamed from: I */
    public final void mo38437I(JSONArray jSONArray) {
        AppMethodBeat.m2504i(6193);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                getMenuHelp().aeh(jSONArray.optString(i));
            }
        }
        AppMethodBeat.m2505o(6193);
    }

    public final boolean cWG() {
        AppMethodBeat.m2504i(6195);
        if (this.ujc == null || !this.ujc.cXi()) {
            AppMethodBeat.m2505o(6195);
            return false;
        }
        C4990ab.m7417i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", this.ujc.cXj(), this.ujc.cXk(), this.ujc.cXl());
        View inflate = View.inflate(getContext(), 2130970090, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131825970);
        checkBox.setChecked(false);
        checkBox.setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(2131825969);
        textView.setText(r6);
        textView.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        textView = (TextView) inflate.findViewById(2131825971);
        textView.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        textView.setVisibility(8);
        this.ujd = C30379h.m48451a(getContext(), true, "", inflate, r4, r5, new C228625(), new C228586());
        AppMethodBeat.m2505o(6195);
        return true;
    }

    /* renamed from: bD */
    public final void mo38438bD(int i, String str) {
        AppMethodBeat.m2504i(6196);
        setBackgroundColor(i);
        if (C5046bo.nullAsNil(str).equals("black")) {
            this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.kiE.setColorFilter(WebView.NIGHT_MODE_COLOR);
            if (!this.uje) {
                this.uiY.setImageResource(C1318a.actionbar_icon_dark_more);
                AppMethodBeat.m2505o(6196);
                return;
            }
        }
        this.iDT.setTextColor(-1);
        this.kiE.clearColorFilter();
        if (!this.uje) {
            this.uiY.setImageResource(C1318a.actionbar_icon_light_more);
        }
        AppMethodBeat.m2505o(6196);
    }

    public void setNavigationBarButtons(Bundle bundle) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(6197);
        if (bundle == null) {
            AppMethodBeat.m2505o(6197);
            return;
        }
        String string = bundle.getString("set_navigation_bar_buttons_left_text_color");
        final boolean z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
        final String string2 = bundle.getString("set_navigation_bar_buttons_text");
        String string3 = bundle.getString("set_navigation_bar_buttons_icon_data");
        String string4 = bundle.getString("set_navigation_bar_buttons_text_color");
        final boolean z2 = bundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
        final int bx = C29916g.m47394bx(string, -1);
        final int afy = (int) C29916g.afy(string4);
        if (!C5046bo.isNullOrNil(string3)) {
            try {
                bitmap = C29916g.afz(string3);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", e);
            }
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6178);
                if (C22857k.this == null || C22857k.this.uiI == null) {
                    AppMethodBeat.m2505o(6178);
                    return;
                }
                if (z) {
                    C22857k.m34689a(C22857k.this, true);
                } else {
                    C22857k.m34689a(C22857k.this, false);
                    if (C22857k.this.uiY == null || C22857k.this.uiZ == null) {
                        AppMethodBeat.m2505o(6178);
                        return;
                    }
                    C22857k.this.uje = false;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        C22857k.this.uiY.setVisibility(0);
                        C22857k.this.uiY.setImageBitmap(bitmap);
                        C22857k.this.uiZ.setVisibility(8);
                        C22857k.this.uje = true;
                        if (z2) {
                            C22857k.this.uiY.setOnClickListener(C22857k.this.ujf);
                        }
                    } else if (C5046bo.isNullOrNil(string2)) {
                        C22857k.this.uiY.setVisibility(0);
                        C22857k.this.uiY.setImageResource(C1318a.actionbar_icon_dark_more);
                        C22857k.this.uiZ.setVisibility(8);
                        if (z2) {
                            C22857k.this.uiY.setOnClickListener(C22857k.this.ujf);
                        }
                    } else {
                        C22857k.this.uiY.setVisibility(8);
                        C22857k.this.uiZ.setVisibility(0);
                        C22857k.this.uiZ.setText(string2);
                        if (afy != -1) {
                            C22857k.this.uiZ.setTextColor(afy);
                        }
                        if (z2) {
                            C22857k.this.uiZ.setOnClickListener(C22857k.this.ujf);
                        }
                    }
                }
                Drawable mutate = C22857k.this.getResources().getDrawable(C1318a.actionbar_icon_dark_close).mutate();
                mutate.setColorFilter(bx, Mode.SRC_IN);
                if (C22857k.this.kiE != null) {
                    C22857k.this.kiE.setImageDrawable(mutate);
                }
                AppMethodBeat.m2505o(6178);
            }
        });
        AppMethodBeat.m2505o(6197);
    }

    public void setCloseWindowConfirmInfo(Bundle bundle) {
        C43906r c43906r;
        AppMethodBeat.m2504i(6194);
        if (bundle == null) {
            c43906r = null;
        } else {
            c43906r = new C43906r(bundle);
        }
        this.ujc = c43906r;
        AppMethodBeat.m2505o(6194);
    }
}
