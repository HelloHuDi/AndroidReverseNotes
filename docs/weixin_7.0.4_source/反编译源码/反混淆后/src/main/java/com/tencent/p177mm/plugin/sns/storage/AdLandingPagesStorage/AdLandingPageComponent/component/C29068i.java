package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C17391c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i */
public final class C29068i {
    public String eIq = "";
    private View jcl;
    public String kWC = "";
    private Context mContext;
    public String mTitle = "";
    C17391c qZt;
    private int qZu = -1;
    private int qZv = -1;
    private boolean qZw = false;
    private boolean qZx = false;
    public C29070a qZy;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i$1 */
    class C290661 implements OnClickListener {
        C290661() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37078);
            C29068i.this.qZt.cancel();
            AppMethodBeat.m2505o(37078);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i$2 */
    class C290672 implements OnClickListener {
        C290672() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37079);
            C29068i.this.qZt.cancel();
            AppMethodBeat.m2505o(37079);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i$a */
    public interface C29070a {
        void cpF();

        void cpG();
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i$5 */
    class C290715 implements OnCancelListener {
        C290715() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(37082);
            C29068i.this.qZy.cpG();
            AppMethodBeat.m2505o(37082);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i$4 */
    class C290724 implements OnDismissListener {
        C290724() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(37081);
            C29068i.this.qZy.cpF();
            AppMethodBeat.m2505o(37081);
        }
    }

    public C29068i(Context context, C13437h c13437h, String str, String str2, String str3, boolean z, boolean z2) {
        AppMethodBeat.m2504i(37083);
        this.eIq = str;
        this.mTitle = str2;
        this.kWC = str3;
        this.mContext = context;
        this.qZw = z;
        this.qZx = z2;
        if (!(c13437h == null || c13437h.getView() == null)) {
            this.qZt = new C17391c(context);
            this.qZt.setCanceledOnTouchOutside(true);
            this.jcl = View.inflate(context, 2130970719, null);
            if (this.jcl == null) {
                C4990ab.m7412e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
                AppMethodBeat.m2505o(37083);
                return;
            }
            Object obj;
            LinearLayout linearLayout = (LinearLayout) this.jcl.findViewById(2131827625);
            View view = c13437h.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.qZu = (int) c13437h.cpv().qWU;
            this.qZv = (int) c13437h.cpv().qWV;
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
            ((TextView) this.jcl.findViewById(2131825987)).setText(str2);
            View findViewById = this.jcl.findViewById(2131827624);
            findViewById.setOnClickListener(new C290661());
            View findViewById2 = this.jcl.findViewById(2131827626);
            findViewById2.setOnClickListener(new C290672());
            if (!this.qZx) {
                findViewById2.setVisibility(8);
            }
            if (this.qZw) {
                findViewById.setVisibility(8);
            }
            final ImageView imageView = (ImageView) this.jcl.findViewById(2131823799);
            imageView.setVisibility(8);
            if (!C5046bo.isNullOrNil(str3)) {
                Bitmap gm = C13473h.m21628gm("adId", str3);
                if (gm != null) {
                    imageView.setImageBitmap(gm);
                    imageView.setVisibility(0);
                    AppMethodBeat.m2505o(37083);
                    return;
                }
                C13473h.m21619a(str3, 0, new C3951a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                    }

                    /* renamed from: YJ */
                    public final void mo8627YJ(String str) {
                        AppMethodBeat.m2504i(37080);
                        try {
                            imageView.setImageBitmap(BitmapFactory.decodeFile(str));
                            imageView.setVisibility(0);
                            AppMethodBeat.m2505o(37080);
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.AdLandingPageBottomSheet", "%s" + C5046bo.m7574l(e));
                            AppMethodBeat.m2505o(37080);
                        }
                    }
                });
            }
        }
        AppMethodBeat.m2505o(37083);
    }

    public final void cpD() {
        AppMethodBeat.m2504i(37084);
        if (this.jcl == null || this.qZt == null) {
            AppMethodBeat.m2505o(37084);
            return;
        }
        this.qZt.getWindow().setFlags(8, 8);
        this.qZt.getWindow().addFlags(131200);
        if (this.qZy != null) {
            this.qZt.setOnDismissListener(new C290724());
            this.qZt.setOnCancelListener(new C290715());
        }
        this.qZt.setContentView(this.jcl);
        BottomSheetBehavior.m38322j((View) this.jcl.getParent()).mo41462K(C29064ad.m46206eP(this.mContext)[1]);
        this.qZt.show();
        AppMethodBeat.m2505o(37084);
    }

    public final void cpE() {
        AppMethodBeat.m2504i(37085);
        if (this.qZt != null) {
            this.qZt.dismiss();
        }
        AppMethodBeat.m2505o(37085);
    }
}
