package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends h {
    ImageView cAw;
    ProgressBar progressBar;
    boolean qZh;

    public e(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private e(Context context, ViewGroup viewGroup, byte b) {
        super(context, null, viewGroup);
        this.qZh = true;
    }

    public final void cpk() {
        AppMethodBeat.i(37052);
        View view = this.contentView;
        this.cAw = (ImageView) view.findViewById(R.id.efl);
        this.progressBar = (ProgressBar) view.findViewById(R.id.rj);
        AppMethodBeat.o(37052);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au7;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37053);
        if (this.contentView == null || this.cAw == null || this.progressBar == null) {
            AppMethodBeat.o(37053);
        } else if (((n) this.qZo) == null) {
            AppMethodBeat.o(37053);
        } else {
            float f = ((n) this.qZo).qWQ;
            float f2 = ((n) this.qZo).qWR;
            float f3 = ((n) this.qZo).qWS;
            float f4 = ((n) this.qZo).qWT;
            String str = ((n) this.qZo).qWD;
            float f5 = ((n) this.qZo).height;
            LayoutParams layoutParams = (LayoutParams) this.cAw.getLayoutParams();
            layoutParams.width = (int) ((n) this.qZo).width;
            layoutParams.height = (int) f5;
            this.cAw.setLayoutParams(layoutParams);
            this.qZh = false;
            startLoading();
            h.a(str, ((n) this.qZo).qWP, new a() {
                public final void cpu() {
                    AppMethodBeat.i(37049);
                    e.this.startLoading();
                    AppMethodBeat.o(37049);
                }

                public final void cmD() {
                    AppMethodBeat.i(37050);
                    e.this.stopLoading();
                    AppMethodBeat.o(37050);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37051);
                    try {
                        e.this.stopLoading();
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        e eVar = e.this;
                        if (decodeFile == null) {
                            ab.e("AdLandingImageComp", "when set image the bmp is null!");
                            AppMethodBeat.o(37051);
                        } else if (eVar.cAw == null) {
                            ab.e("AdLandingImageComp", "when set image the imageView is null!");
                            AppMethodBeat.o(37051);
                        } else if (decodeFile.getWidth() == 0) {
                            ab.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                            AppMethodBeat.o(37051);
                        } else {
                            eVar.cAw.setImageBitmap(decodeFile);
                            eVar.progressBar.setVisibility(8);
                            AppMethodBeat.o(37051);
                        }
                    } catch (Exception e) {
                        ab.e("AdLandingImageComp", "%s" + bo.l(e));
                        AppMethodBeat.o(37051);
                    }
                }
            });
            this.contentView.setPadding((int) f3, (int) f, (int) f4, (int) f2);
            AppMethodBeat.o(37053);
        }
    }

    public final void startLoading() {
        AppMethodBeat.i(37054);
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(37054);
    }

    public final void stopLoading() {
        AppMethodBeat.i(37055);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(37055);
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37056);
        if (super.al(jSONObject)) {
            try {
                if (!this.qZh) {
                    String ck = ag.ck(((n) this.qZo).qWD);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("imgUrlInfo", jSONObject2);
                }
                AppMethodBeat.o(37056);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("AdLandingImageComp", e, "", new Object[0]);
                AppMethodBeat.o(37056);
                return false;
            }
        }
        AppMethodBeat.o(37056);
        return false;
    }
}
