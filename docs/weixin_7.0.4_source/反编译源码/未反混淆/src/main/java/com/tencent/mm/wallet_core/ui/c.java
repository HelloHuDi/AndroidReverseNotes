package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c {
    ViewGroup Ahn;
    private boolean Aho;
    public o gKG;
    private ImageView gKH;
    private View gKI;
    private OnClickListener gKK;
    private MMActivity jiE;
    public boolean kjx;
    private Bitmap kno;
    private View knr;
    private ImageView kns;
    private MMVerticalTextView knt;
    private ArrayList<Bitmap> knv;
    private String oXv;
    public Bitmap oZA;
    private String oZW;
    public Bitmap oZz;

    public c(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(49231);
        this.oZz = null;
        this.oZA = null;
        this.kno = null;
        this.oZW = "";
        this.oXv = "";
        this.kjx = true;
        this.knv = new ArrayList();
        this.gKG = null;
        this.Aho = false;
        this.gKK = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49227);
                if ((view.getId() == R.id.ai_ || view.getId() == R.id.aif) && c.this.gKG != null && c.this.gKG.isShowing()) {
                    c.this.gKG.dismiss();
                }
                AppMethodBeat.o(49227);
            }
        };
        this.jiE = mMActivity;
        this.Aho = z;
        AppMethodBeat.o(49231);
    }

    public c(MMActivity mMActivity) {
        this(mMActivity, false);
    }

    public final void iw(String str, String str2) {
        this.oZW = str;
        this.oXv = str2;
    }

    public final void release() {
        AppMethodBeat.i(49232);
        if (this.gKG != null && this.gKG.isShowing()) {
            this.gKG.dismiss();
        }
        e.K(this.kno);
        e.ar(this.knv);
        this.knv.clear();
        this.jiE = null;
        AppMethodBeat.o(49232);
    }

    public final void ase() {
        AppMethodBeat.i(49233);
        if (this.gKG != null) {
            AppMethodBeat.o(49233);
            return;
        }
        View view;
        if (this.Aho) {
            View inflate = View.inflate(this.jiE, R.layout.b57, null);
            MMVerticalTextView mMVerticalTextView = (MMVerticalTextView) inflate.findViewById(R.id.fd8);
            this.Ahn = (ViewGroup) inflate.findViewById(R.id.fd7);
            mMVerticalTextView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(49228);
                    ab.d("MicroMsg.OfflinePopupWindow", "on click know");
                    c.this.Ahn.setVisibility(8);
                    cm cmVar = new cm();
                    cmVar.cvK.cvL = 1;
                    a.xxA.m(cmVar);
                    AppMethodBeat.o(49228);
                }
            });
            inflate.findViewById(R.id.fd5).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(49229);
                    ab.d("MicroMsg.OfflinePopupWindow", "root on click");
                    if (c.this.gKG != null && c.this.gKG.isShowing()) {
                        c.this.gKG.dismiss();
                    }
                    AppMethodBeat.o(49229);
                }
            });
            view = inflate;
        } else {
            View inflate2 = View.inflate(this.jiE, R.layout.b5_, null);
            inflate2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(49230);
                    if (c.this.gKG != null && c.this.gKG.isShowing()) {
                        c.this.gKG.dismiss();
                    }
                    AppMethodBeat.o(49230);
                }
            });
            view = inflate2;
        }
        this.gKI = view.findViewById(R.id.ai9);
        this.gKH = (ImageView) view.findViewById(R.id.ai_);
        this.knr = view.findViewById(R.id.aic);
        this.kns = (ImageView) view.findViewById(R.id.aif);
        this.knt = (MMVerticalTextView) view.findViewById(R.id.aie);
        this.gKG = new o(view, -1, -1, true);
        this.gKG.setClippingEnabled(false);
        this.gKG.update();
        this.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
        this.gKG.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss() {
            }
        });
        AppMethodBeat.o(49233);
    }

    public final void G(View view, boolean z) {
        AppMethodBeat.i(49234);
        this.kjx = z;
        if (!(this.gKG == null || this.gKG.isShowing())) {
            this.gKG.showAtLocation(view.getRootView(), 17, 0, 0);
            this.gKG.setFocusable(true);
            this.gKG.setTouchable(true);
            this.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
            this.gKG.setOutsideTouchable(true);
            if (this.kjx) {
                dOw();
            }
            dOx();
        }
        AppMethodBeat.o(49234);
    }

    public final void dOv() {
        AppMethodBeat.i(49235);
        if (this.gKG != null && this.gKG.isShowing()) {
            dOx();
        }
        AppMethodBeat.o(49235);
    }

    public final void dOw() {
        AppMethodBeat.i(49236);
        if (this.Ahn != null) {
            this.Ahn.setVisibility(0);
        }
        AppMethodBeat.o(49236);
    }

    private void dOx() {
        AppMethodBeat.i(49237);
        if (this.kjx) {
            this.kns.setOnClickListener(this.gKK);
            Bitmap bitmap = this.kno;
            if (this.oZA != null) {
                this.kno = e.J(this.oZA);
                ab.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
            } else {
                this.kno = null;
                ab.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
            }
            this.kns.setImageBitmap(this.kno);
            this.knv.add(0, bitmap);
            bds();
            this.gKI.setVisibility(8);
            this.knr.setVisibility(0);
            this.knt.setText(e.aty(this.oXv));
        } else {
            this.gKH.setOnClickListener(this.gKK);
            this.gKH.setImageBitmap(this.oZz);
            if (this.oZz != null) {
                ab.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                ab.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.gKI.setVisibility(0);
            this.knr.setVisibility(8);
        }
        this.gKG.update();
        AppMethodBeat.o(49237);
    }

    private void bds() {
        AppMethodBeat.i(49238);
        if (this.knv.size() >= 2) {
            int size = this.knv.size() - 1;
            while (true) {
                int i = size;
                if (i <= 1) {
                    break;
                }
                e.K((Bitmap) this.knv.remove(i));
                size = i - 1;
            }
        }
        AppMethodBeat.o(49238);
    }

    public final void dismiss() {
        AppMethodBeat.i(49239);
        if (this.gKG != null && this.gKG.isShowing()) {
            this.gKG.dismiss();
        }
        AppMethodBeat.o(49239);
    }
}
