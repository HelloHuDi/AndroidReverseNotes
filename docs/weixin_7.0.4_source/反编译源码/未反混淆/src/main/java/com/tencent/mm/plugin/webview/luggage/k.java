package com.tencent.mm.plugin.webview.luggage;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONArray;
import org.json.JSONObject;

public class k extends LinearLayout {
    private TextView iDT;
    private ImageView kiE;
    protected Context mContext;
    private String mTitle;
    private d uiI;
    private ImageView uiY;
    private TextView uiZ;
    private n uja;
    protected l ujb;
    private r ujc;
    public c ujd = null;
    private boolean uje = false;
    private OnClickListener ujf = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(6180);
            if (k.this.uiI == null) {
                AppMethodBeat.o(6180);
                return;
            }
            k.this.uiI.bPN.a(new com.tencent.luggage.d.c() {
                public final String name() {
                    return "onNavigationBarRightButtonClick";
                }

                public final JSONObject wQ() {
                    AppMethodBeat.i(6179);
                    JSONObject jSONObject = new JSONObject();
                    AppMethodBeat.o(6179);
                    return jSONObject;
                }
            });
            AppMethodBeat.o(6180);
        }
    };

    public k(final d dVar) {
        super(dVar.mContext);
        AppMethodBeat.i(6181);
        this.mContext = dVar.mContext;
        this.uiI = dVar;
        setLayoutParams(new LayoutParams(-1, getActionBarHeight()));
        setBackgroundResource(R.color.dt);
        View inflate = v.hu(getContext()).inflate(R.layout.b78, this, false);
        addView(inflate);
        this.kiE = (ImageView) inflate.findViewById(R.id.azu);
        this.kiE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(6172);
                if (!k.this.cWG()) {
                    k.this.bDx();
                }
                AppMethodBeat.o(6172);
            }
        });
        this.iDT = (TextView) inflate.findViewById(R.id.cx);
        this.uiY = (ImageView) inflate.findViewById(R.id.azv);
        this.uiY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(6173);
                if (dVar.bPe.xh().peek() == k.this.uiI) {
                    k.this.bDy();
                }
                AppMethodBeat.o(6173);
            }
        });
        this.uiY.setClickable(false);
        this.uiZ = (TextView) inflate.findViewById(R.id.fjy);
        this.uiZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(6174);
                if (dVar.bPe.xh().peek() == k.this.uiI) {
                    k.this.bDy();
                }
                AppMethodBeat.o(6174);
            }
        });
        this.uiZ.setClickable(false);
        AppMethodBeat.o(6181);
    }

    public void setOptionEnable(boolean z) {
        AppMethodBeat.i(6182);
        if (z) {
            this.uiY.setClickable(true);
            this.uiZ.setClickable(true);
            AppMethodBeat.o(6182);
            return;
        }
        this.uiY.setClickable(false);
        this.uiZ.setClickable(false);
        AppMethodBeat.o(6182);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitleText(String str) {
        AppMethodBeat.i(6183);
        ab.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", str);
        this.mTitle = str;
        this.iDT.setText(str);
        AppMethodBeat.o(6183);
    }

    public void setTitleColor(int i) {
        AppMethodBeat.i(6184);
        this.iDT.setTextColor(i);
        AppMethodBeat.o(6184);
    }

    /* Access modifiers changed, original: protected */
    public l getMenuHelp() {
        AppMethodBeat.i(6185);
        if (this.ujb == null) {
            this.ujb = new l();
        }
        l lVar = this.ujb;
        AppMethodBeat.o(6185);
        return lVar;
    }

    public void bDy() {
        AppMethodBeat.i(6186);
        boolean z = false;
        if (getContext() instanceof MMActivity) {
            z = ((MMActivity) getContext()).mController.hideVKB();
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6175);
                k.this.uja = new n(k.this.uiI, k.this.getMenuHelp());
                AppMethodBeat.o(6175);
            }
        }, z ? 100 : 0);
        AppMethodBeat.o(6186);
    }

    public void bDz() {
        AppMethodBeat.i(6187);
        if (this.uja != null) {
            this.uja.cXg();
        }
        AppMethodBeat.o(6187);
    }

    private int getActionBarHeight() {
        int dimensionPixelSize;
        AppMethodBeat.i(6188);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.fc);
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.fd);
        }
        AppMethodBeat.o(6188);
        return dimensionPixelSize;
    }

    public void bDx() {
        AppMethodBeat.i(6189);
        if (!this.uiI.bPe.xi().xb()) {
            ((Activity) this.mContext).finish();
        }
        AppMethodBeat.o(6189);
    }

    public final void cXc() {
        AppMethodBeat.i(6190);
        getMenuHelp().cXc();
        AppMethodBeat.o(6190);
    }

    public final void cXd() {
        AppMethodBeat.i(6191);
        getMenuHelp().cXd();
        AppMethodBeat.o(6191);
    }

    public final void H(JSONArray jSONArray) {
        AppMethodBeat.i(6192);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                getMenuHelp().aeg(jSONArray.optString(i));
            }
        }
        AppMethodBeat.o(6192);
    }

    public final void I(JSONArray jSONArray) {
        AppMethodBeat.i(6193);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                getMenuHelp().aeh(jSONArray.optString(i));
            }
        }
        AppMethodBeat.o(6193);
    }

    public final boolean cWG() {
        AppMethodBeat.i(6195);
        if (this.ujc == null || !this.ujc.cXi()) {
            AppMethodBeat.o(6195);
            return false;
        }
        ab.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", this.ujc.cXj(), this.ujc.cXk(), this.ujc.cXl());
        View inflate = View.inflate(getContext(), R.layout.ad4, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.d8o);
        checkBox.setChecked(false);
        checkBox.setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.d8n);
        textView.setText(r6);
        textView.setTextColor(getResources().getColor(R.color.w4));
        textView = (TextView) inflate.findViewById(R.id.d8p);
        textView.setTextColor(getResources().getColor(R.color.w4));
        textView.setVisibility(8);
        this.ujd = h.a(getContext(), true, "", inflate, r4, r5, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(6176);
                k.this.ujd = null;
                k.this.bDx();
                AppMethodBeat.o(6176);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(6177);
                k.this.ujd = null;
                AppMethodBeat.o(6177);
            }
        });
        AppMethodBeat.o(6195);
        return true;
    }

    public final void bD(int i, String str) {
        AppMethodBeat.i(6196);
        setBackgroundColor(i);
        if (bo.nullAsNil(str).equals("black")) {
            this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.kiE.setColorFilter(WebView.NIGHT_MODE_COLOR);
            if (!this.uje) {
                this.uiY.setImageResource(R.raw.actionbar_icon_dark_more);
                AppMethodBeat.o(6196);
                return;
            }
        }
        this.iDT.setTextColor(-1);
        this.kiE.clearColorFilter();
        if (!this.uje) {
            this.uiY.setImageResource(R.raw.actionbar_icon_light_more);
        }
        AppMethodBeat.o(6196);
    }

    public void setNavigationBarButtons(Bundle bundle) {
        Bitmap bitmap = null;
        AppMethodBeat.i(6197);
        if (bundle == null) {
            AppMethodBeat.o(6197);
            return;
        }
        String string = bundle.getString("set_navigation_bar_buttons_left_text_color");
        final boolean z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
        final String string2 = bundle.getString("set_navigation_bar_buttons_text");
        String string3 = bundle.getString("set_navigation_bar_buttons_icon_data");
        String string4 = bundle.getString("set_navigation_bar_buttons_text_color");
        final boolean z2 = bundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
        final int bx = g.bx(string, -1);
        final int afy = (int) g.afy(string4);
        if (!bo.isNullOrNil(string3)) {
            try {
                bitmap = g.afz(string3);
            } catch (Exception e) {
                ab.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", e);
            }
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6178);
                if (k.this == null || k.this.uiI == null) {
                    AppMethodBeat.o(6178);
                    return;
                }
                if (z) {
                    k.a(k.this, true);
                } else {
                    k.a(k.this, false);
                    if (k.this.uiY == null || k.this.uiZ == null) {
                        AppMethodBeat.o(6178);
                        return;
                    }
                    k.this.uje = false;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        k.this.uiY.setVisibility(0);
                        k.this.uiY.setImageBitmap(bitmap);
                        k.this.uiZ.setVisibility(8);
                        k.this.uje = true;
                        if (z2) {
                            k.this.uiY.setOnClickListener(k.this.ujf);
                        }
                    } else if (bo.isNullOrNil(string2)) {
                        k.this.uiY.setVisibility(0);
                        k.this.uiY.setImageResource(R.raw.actionbar_icon_dark_more);
                        k.this.uiZ.setVisibility(8);
                        if (z2) {
                            k.this.uiY.setOnClickListener(k.this.ujf);
                        }
                    } else {
                        k.this.uiY.setVisibility(8);
                        k.this.uiZ.setVisibility(0);
                        k.this.uiZ.setText(string2);
                        if (afy != -1) {
                            k.this.uiZ.setTextColor(afy);
                        }
                        if (z2) {
                            k.this.uiZ.setOnClickListener(k.this.ujf);
                        }
                    }
                }
                Drawable mutate = k.this.getResources().getDrawable(R.raw.actionbar_icon_dark_close).mutate();
                mutate.setColorFilter(bx, Mode.SRC_IN);
                if (k.this.kiE != null) {
                    k.this.kiE.setImageDrawable(mutate);
                }
                AppMethodBeat.o(6178);
            }
        });
        AppMethodBeat.o(6197);
    }

    public void setCloseWindowConfirmInfo(Bundle bundle) {
        r rVar;
        AppMethodBeat.i(6194);
        if (bundle == null) {
            rVar = null;
        } else {
            rVar = new r(bundle);
        }
        this.ujc = rVar;
        AppMethodBeat.o(6194);
    }
}
