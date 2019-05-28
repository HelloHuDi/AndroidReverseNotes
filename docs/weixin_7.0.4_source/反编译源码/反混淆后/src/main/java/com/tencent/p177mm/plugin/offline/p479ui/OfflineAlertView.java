package com.tencent.p177mm.plugin.offline.p479ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.offline.ui.OfflineAlertView */
public class OfflineAlertView extends LinearLayout {
    private View contentView = null;
    public int oZe = 0;
    private RelativeLayout oZf = null;
    boolean oZg = true;
    private C28642a oZh = null;

    /* renamed from: com.tencent.mm.plugin.offline.ui.OfflineAlertView$a */
    public interface C28642a {
        void onClose();

        void onShow();
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.OfflineAlertView$3 */
    class C346523 extends C24019s {
        C346523() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(43445);
            OfflineAlertView.this.dismiss();
            AppMethodBeat.m2505o(43445);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.OfflineAlertView$4 */
    class C346534 implements OnClickListener {
        C346534() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43446);
            C28630a.m45521eH(OfflineAlertView.this.getContext());
            AppMethodBeat.m2505o(43446);
        }
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(43452);
        init();
        AppMethodBeat.m2505o(43452);
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(43453);
        init();
        AppMethodBeat.m2505o(43453);
    }

    private void init() {
        AppMethodBeat.m2504i(43454);
        this.contentView = LayoutInflater.from(getContext()).inflate(2130971126, this);
        this.oZf = (RelativeLayout) this.contentView.findViewById(2131828881);
        AppMethodBeat.m2505o(43454);
    }

    public void setDialogState(C28642a c28642a) {
        this.oZh = c28642a;
    }

    /* renamed from: a */
    public final void mo55249a(final View view, final Runnable runnable, final Runnable runnable2) {
        AppMethodBeat.m2504i(43455);
        setVisibility(0);
        this.oZf.removeAllViews();
        this.oZf.addView(LayoutInflater.from(getContext()).inflate(2130971134, null));
        view.post(new Runnable() {
            final /* synthetic */ int bVv = 2;

            public final void run() {
                AppMethodBeat.m2504i(43443);
                OfflineAlertView.m56881a(OfflineAlertView.this, view, runnable, runnable2, this.bVv);
                AppMethodBeat.m2505o(43443);
            }
        });
        AppMethodBeat.m2505o(43455);
    }

    /* renamed from: dq */
    public final void mo55252dq(final View view) {
        AppMethodBeat.m2504i(43456);
        setVisibility(0);
        this.oZf.removeAllViews();
        this.oZf.addView(LayoutInflater.from(getContext()).inflate(2130971132, null));
        C7060h.pYm.mo8381e(13750, Integer.valueOf(1));
        view.post(new Runnable() {
            final /* synthetic */ int bVv = 4;

            public final void run() {
                AppMethodBeat.m2504i(43444);
                OfflineAlertView.m56880a(OfflineAlertView.this, view, this.bVv);
                AppMethodBeat.m2505o(43444);
            }
        });
        AppMethodBeat.m2505o(43456);
    }

    /* renamed from: a */
    public final void mo55247a(View view, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(43457);
        mo55248a(view, onClickListener, 6);
        AppMethodBeat.m2505o(43457);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo55248a(final View view, OnClickListener onClickListener, int i) {
        AppMethodBeat.m2504i(43458);
        this.oZe = i;
        setVisibility(0);
        this.oZf.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(2130971137, null);
        if (i == 6) {
            ((TextView) inflate.findViewById(2131828908)).setText(C25738R.string.daf);
        } else if ((i == 3 || i == 1) && C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            ((TextView) inflate.findViewById(2131828908)).setText(C25738R.string.dai);
        }
        TextView textView = (TextView) inflate.findViewById(2131828918);
        if (textView != null) {
            SpannableString spannableString = new SpannableString("#  " + getContext().getResources().getString(C25738R.string.fke));
            Drawable drawable = getContext().getResources().getDrawable(C25738R.drawable.icon_shield_pay);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new ImageSpan(drawable), 0, 1, 18);
            textView.setText(spannableString, BufferType.SPANNABLE);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(43449);
                    Intent intent = new Intent();
                    intent.putExtra("wallet_lock_jsapi_scene", 2);
                    C25985d.m41467b(view.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                    AppMethodBeat.m2505o(43449);
                }
            });
            textView.setVisibility(0);
        }
        this.oZf.addView(inflate);
        ((Button) this.contentView.findViewById(2131828229)).setOnClickListener(onClickListener);
        this.oZg = false;
        view.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(43450);
                C4990ab.m7417i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                LayoutParams layoutParams = (LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                    OfflineAlertView.this.contentView.invalidate();
                }
                if (OfflineAlertView.this.oZh != null) {
                    OfflineAlertView.this.oZh.onShow();
                }
                AppMethodBeat.m2505o(43450);
            }
        });
        AppMethodBeat.m2505o(43458);
    }

    /* renamed from: b */
    public final void mo55250b(final View view, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(43459);
        this.oZe = 5;
        setVisibility(0);
        this.oZg = false;
        this.oZf.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(2130971137, null);
        this.oZf.addView(inflate);
        ((TextView) inflate.findViewById(2131828908)).setText(C25738R.string.dac);
        Button button = (Button) inflate.findViewById(2131828229);
        button.setText(C25738R.string.dab);
        button.setOnClickListener(onClickListener);
        view.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(43451);
                C4990ab.m7417i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                LayoutParams layoutParams = (LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                    OfflineAlertView.this.contentView.invalidate();
                }
                if (OfflineAlertView.this.oZh != null) {
                    OfflineAlertView.this.oZh.onShow();
                }
                AppMethodBeat.m2505o(43451);
            }
        });
        AppMethodBeat.m2505o(43459);
    }

    public final boolean isShowing() {
        AppMethodBeat.m2504i(43460);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(43460);
            return true;
        }
        AppMethodBeat.m2505o(43460);
        return false;
    }

    /* renamed from: Ay */
    public final boolean mo55246Ay(int i) {
        AppMethodBeat.m2504i(43461);
        if (!isShowing()) {
            AppMethodBeat.m2505o(43461);
            return true;
        } else if (i == this.oZe) {
            AppMethodBeat.m2505o(43461);
            return true;
        } else if (i == 2 && (this.oZe == 3 || this.oZe == 4 || this.oZe == 2 || this.oZe == 5)) {
            AppMethodBeat.m2505o(43461);
            return true;
        } else if (i == 5 && this.oZe == 4) {
            AppMethodBeat.m2505o(43461);
            return true;
        } else if (i == 6) {
            AppMethodBeat.m2505o(43461);
            return true;
        } else {
            AppMethodBeat.m2505o(43461);
            return false;
        }
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(43462);
        if (this.oZf != null) {
            this.oZf.removeAllViews();
        }
        setVisibility(8);
        if (this.oZh != null) {
            this.oZh.onClose();
        }
        this.oZg = true;
        AppMethodBeat.m2505o(43462);
    }

    /* renamed from: a */
    static /* synthetic */ void m56881a(OfflineAlertView offlineAlertView, View view, final Runnable runnable, final Runnable runnable2, int i) {
        AppMethodBeat.m2504i(43463);
        offlineAlertView.oZe = i;
        offlineAlertView.setVisibility(0);
        TextView textView = (TextView) offlineAlertView.contentView.findViewById(2131828229);
        if (textView != null) {
            textView.setOnClickListener(new C24019s() {
                public final void bgW() {
                    AppMethodBeat.m2504i(43447);
                    runnable.run();
                    AppMethodBeat.m2505o(43447);
                }
            });
        }
        textView = (TextView) offlineAlertView.contentView.findViewById(2131828909);
        if (textView != null) {
            textView.setOnClickListener(new C24019s() {
                public final void bgW() {
                    AppMethodBeat.m2504i(43448);
                    runnable2.run();
                    AppMethodBeat.m2505o(43448);
                }
            });
        }
        C4990ab.m7417i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        offlineAlertView.oZg = false;
        if (offlineAlertView.oZh != null) {
            offlineAlertView.oZh.onShow();
        }
        AppMethodBeat.m2505o(43463);
    }
}
