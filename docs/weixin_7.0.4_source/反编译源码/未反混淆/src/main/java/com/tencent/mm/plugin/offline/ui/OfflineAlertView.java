package com.tencent.mm.plugin.offline.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.s;

public class OfflineAlertView extends LinearLayout {
    private View contentView = null;
    public int oZe = 0;
    private RelativeLayout oZf = null;
    boolean oZg = true;
    private a oZh = null;

    public interface a {
        void onClose();

        void onShow();
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(43452);
        init();
        AppMethodBeat.o(43452);
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(43453);
        init();
        AppMethodBeat.o(43453);
    }

    private void init() {
        AppMethodBeat.i(43454);
        this.contentView = LayoutInflater.from(getContext()).inflate(R.layout.b50, this);
        this.oZf = (RelativeLayout) this.contentView.findViewById(R.id.fcc);
        AppMethodBeat.o(43454);
    }

    public void setDialogState(a aVar) {
        this.oZh = aVar;
    }

    public final void a(final View view, final Runnable runnable, final Runnable runnable2) {
        AppMethodBeat.i(43455);
        setVisibility(0);
        this.oZf.removeAllViews();
        this.oZf.addView(LayoutInflater.from(getContext()).inflate(R.layout.b58, null));
        view.post(new Runnable() {
            final /* synthetic */ int bVv = 2;

            public final void run() {
                AppMethodBeat.i(43443);
                OfflineAlertView.a(OfflineAlertView.this, view, runnable, runnable2, this.bVv);
                AppMethodBeat.o(43443);
            }
        });
        AppMethodBeat.o(43455);
    }

    public final void dq(final View view) {
        AppMethodBeat.i(43456);
        setVisibility(0);
        this.oZf.removeAllViews();
        this.oZf.addView(LayoutInflater.from(getContext()).inflate(R.layout.b56, null));
        h.pYm.e(13750, Integer.valueOf(1));
        view.post(new Runnable() {
            final /* synthetic */ int bVv = 4;

            public final void run() {
                AppMethodBeat.i(43444);
                OfflineAlertView.a(OfflineAlertView.this, view, this.bVv);
                AppMethodBeat.o(43444);
            }
        });
        AppMethodBeat.o(43456);
    }

    public final void a(View view, OnClickListener onClickListener) {
        AppMethodBeat.i(43457);
        a(view, onClickListener, 6);
        AppMethodBeat.o(43457);
    }

    /* Access modifiers changed, original: final */
    public final void a(final View view, OnClickListener onClickListener, int i) {
        AppMethodBeat.i(43458);
        this.oZe = i;
        setVisibility(0);
        this.oZf.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.b5a, null);
        if (i == 6) {
            ((TextView) inflate.findViewById(R.id.fd3)).setText(R.string.daf);
        } else if ((i == 3 || i == 1) && b.sO((String) g.RP().Ry().get(274436, null))) {
            ((TextView) inflate.findViewById(R.id.fd3)).setText(R.string.dai);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.fdc);
        if (textView != null) {
            SpannableString spannableString = new SpannableString("#  " + getContext().getResources().getString(R.string.fke));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_shield_pay);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new ImageSpan(drawable), 0, 1, 18);
            textView.setText(spannableString, BufferType.SPANNABLE);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43449);
                    Intent intent = new Intent();
                    intent.putExtra("wallet_lock_jsapi_scene", 2);
                    d.b(view.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                    AppMethodBeat.o(43449);
                }
            });
            textView.setVisibility(0);
        }
        this.oZf.addView(inflate);
        ((Button) this.contentView.findViewById(R.id.evq)).setOnClickListener(onClickListener);
        this.oZg = false;
        view.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(43450);
                ab.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                LayoutParams layoutParams = (LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                    OfflineAlertView.this.contentView.invalidate();
                }
                if (OfflineAlertView.this.oZh != null) {
                    OfflineAlertView.this.oZh.onShow();
                }
                AppMethodBeat.o(43450);
            }
        });
        AppMethodBeat.o(43458);
    }

    public final void b(final View view, OnClickListener onClickListener) {
        AppMethodBeat.i(43459);
        this.oZe = 5;
        setVisibility(0);
        this.oZg = false;
        this.oZf.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.b5a, null);
        this.oZf.addView(inflate);
        ((TextView) inflate.findViewById(R.id.fd3)).setText(R.string.dac);
        Button button = (Button) inflate.findViewById(R.id.evq);
        button.setText(R.string.dab);
        button.setOnClickListener(onClickListener);
        view.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(43451);
                ab.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                LayoutParams layoutParams = (LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                    OfflineAlertView.this.contentView.invalidate();
                }
                if (OfflineAlertView.this.oZh != null) {
                    OfflineAlertView.this.oZh.onShow();
                }
                AppMethodBeat.o(43451);
            }
        });
        AppMethodBeat.o(43459);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(43460);
        if (getVisibility() == 0) {
            AppMethodBeat.o(43460);
            return true;
        }
        AppMethodBeat.o(43460);
        return false;
    }

    public final boolean Ay(int i) {
        AppMethodBeat.i(43461);
        if (!isShowing()) {
            AppMethodBeat.o(43461);
            return true;
        } else if (i == this.oZe) {
            AppMethodBeat.o(43461);
            return true;
        } else if (i == 2 && (this.oZe == 3 || this.oZe == 4 || this.oZe == 2 || this.oZe == 5)) {
            AppMethodBeat.o(43461);
            return true;
        } else if (i == 5 && this.oZe == 4) {
            AppMethodBeat.o(43461);
            return true;
        } else if (i == 6) {
            AppMethodBeat.o(43461);
            return true;
        } else {
            AppMethodBeat.o(43461);
            return false;
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(43462);
        if (this.oZf != null) {
            this.oZf.removeAllViews();
        }
        setVisibility(8);
        if (this.oZh != null) {
            this.oZh.onClose();
        }
        this.oZg = true;
        AppMethodBeat.o(43462);
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, final Runnable runnable, final Runnable runnable2, int i) {
        AppMethodBeat.i(43463);
        offlineAlertView.oZe = i;
        offlineAlertView.setVisibility(0);
        TextView textView = (TextView) offlineAlertView.contentView.findViewById(R.id.evq);
        if (textView != null) {
            textView.setOnClickListener(new s() {
                public final void bgW() {
                    AppMethodBeat.i(43447);
                    runnable.run();
                    AppMethodBeat.o(43447);
                }
            });
        }
        textView = (TextView) offlineAlertView.contentView.findViewById(R.id.fd4);
        if (textView != null) {
            textView.setOnClickListener(new s() {
                public final void bgW() {
                    AppMethodBeat.i(43448);
                    runnable2.run();
                    AppMethodBeat.o(43448);
                }
            });
        }
        ab.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
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
        AppMethodBeat.o(43463);
    }
}
