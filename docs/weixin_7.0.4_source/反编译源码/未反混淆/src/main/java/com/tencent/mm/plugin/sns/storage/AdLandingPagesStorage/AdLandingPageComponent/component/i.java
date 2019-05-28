package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i {
    public String eIq = "";
    private View jcl;
    public String kWC = "";
    private Context mContext;
    public String mTitle = "";
    c qZt;
    private int qZu = -1;
    private int qZv = -1;
    private boolean qZw = false;
    private boolean qZx = false;
    public a qZy;

    public interface a {
        void cpF();

        void cpG();
    }

    public i(Context context, h hVar, String str, String str2, String str3, boolean z, boolean z2) {
        AppMethodBeat.i(37083);
        this.eIq = str;
        this.mTitle = str2;
        this.kWC = str3;
        this.mContext = context;
        this.qZw = z;
        this.qZx = z2;
        if (!(hVar == null || hVar.getView() == null)) {
            this.qZt = new c(context);
            this.qZt.setCanceledOnTouchOutside(true);
            this.jcl = View.inflate(context, R.layout.au3, null);
            if (this.jcl == null) {
                ab.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
                AppMethodBeat.o(37083);
                return;
            }
            Object obj;
            LinearLayout linearLayout = (LinearLayout) this.jcl.findViewById(R.id.efe);
            View view = hVar.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.qZu = (int) hVar.cpv().qWU;
            this.qZv = (int) hVar.cpv().qWV;
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            if (this.qZu == BaseClientBuilder.API_PRIORITY_OTHER || this.qZv == BaseClientBuilder.API_PRIORITY_OTHER) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                layoutParams.width = this.qZu;
                layoutParams.height = this.qZv;
            }
            linearLayout.addView(view, layoutParams);
            ((TextView) this.jcl.findViewById(R.id.d95)).setText(str2);
            View findViewById = this.jcl.findViewById(R.id.efd);
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(37078);
                    i.this.qZt.cancel();
                    AppMethodBeat.o(37078);
                }
            });
            View findViewById2 = this.jcl.findViewById(R.id.eff);
            findViewById2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(37079);
                    i.this.qZt.cancel();
                    AppMethodBeat.o(37079);
                }
            });
            if (!this.qZx) {
                findViewById2.setVisibility(8);
            }
            if (this.qZw) {
                findViewById.setVisibility(8);
            }
            final ImageView imageView = (ImageView) this.jcl.findViewById(R.id.bmz);
            imageView.setVisibility(8);
            if (!bo.isNullOrNil(str3)) {
                Bitmap gm = h.gm("adId", str3);
                if (gm != null) {
                    imageView.setImageBitmap(gm);
                    imageView.setVisibility(0);
                    AppMethodBeat.o(37083);
                    return;
                }
                h.a(str3, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                    }

                    public final void YJ(String str) {
                        AppMethodBeat.i(37080);
                        try {
                            imageView.setImageBitmap(BitmapFactory.decodeFile(str));
                            imageView.setVisibility(0);
                            AppMethodBeat.o(37080);
                        } catch (Exception e) {
                            ab.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bo.l(e));
                            AppMethodBeat.o(37080);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(37083);
    }

    public final void cpD() {
        AppMethodBeat.i(37084);
        if (this.jcl == null || this.qZt == null) {
            AppMethodBeat.o(37084);
            return;
        }
        this.qZt.getWindow().setFlags(8, 8);
        this.qZt.getWindow().addFlags(131200);
        if (this.qZy != null) {
            this.qZt.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(37081);
                    i.this.qZy.cpF();
                    AppMethodBeat.o(37081);
                }
            });
            this.qZt.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(37082);
                    i.this.qZy.cpG();
                    AppMethodBeat.o(37082);
                }
            });
        }
        this.qZt.setContentView(this.jcl);
        BottomSheetBehavior.j((View) this.jcl.getParent()).K(ad.eP(this.mContext)[1]);
        this.qZt.show();
        AppMethodBeat.o(37084);
    }

    public final void cpE() {
        AppMethodBeat.i(37085);
        if (this.qZt != null) {
            this.qZt.dismiss();
        }
        AppMethodBeat.o(37085);
    }
}
