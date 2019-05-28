package com.tencent.p177mm.p612ui.p1094i;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.p629f.p630a.C15885b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@SuppressLint({"SetJavaScriptEnabled"})
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
/* renamed from: com.tencent.mm.ui.i.b */
public final class C46689b extends Dialog {
    static final float[] zxQ = new float[]{20.0f, 60.0f};
    static final float[] zxR = new float[]{40.0f, 60.0f};
    static final LayoutParams zxS = new LayoutParams(-1, -1);
    private String mUrl;
    private C44374a zLh;
    private ProgressDialog zxU;
    private ImageView zxV;
    private WebView zxW;
    private FrameLayout zxX;

    /* renamed from: com.tencent.mm.ui.i.b$1 */
    class C307181 implements OnClickListener {
        C307181() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(80359);
            C46689b.this.zLh.onCancel();
            C46689b.this.dismiss();
            AppMethodBeat.m2505o(80359);
        }
    }

    /* renamed from: com.tencent.mm.ui.i.b$a */
    public interface C44374a {
        void dKw();

        void onCancel();

        /* renamed from: p */
        void mo28149p(Bundle bundle);
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
    /* renamed from: com.tencent.mm.ui.i.b$b */
    class C44375b extends C36592s {
        boolean zxZ;

        /* renamed from: com.tencent.mm.ui.i.b$b$1 */
        class C159081 implements OnDismissListener {
            C159081() {
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(80360);
                if (C44375b.this.zxZ && C46689b.this != null) {
                    C46689b.this.zLh.onCancel();
                    C46689b.this.dismiss();
                }
                AppMethodBeat.m2505o(80360);
            }
        }

        private C44375b() {
            this.zxZ = true;
        }

        /* synthetic */ C44375b(C46689b c46689b, byte b) {
            this();
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(80361);
            C4990ab.m7410d("Twitter-WebView", "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith("wechatapp://sign-in-twitter.wechatapp.com/")) {
                Bundle asa = C44375b.asa(str);
                if (asa.getString("denied") == null) {
                    C46689b.this.zLh.mo28149p(asa);
                } else {
                    C46689b.this.zLh.onCancel();
                }
                C46689b.this.dismiss();
                AppMethodBeat.m2505o(80361);
            } else {
                C46689b.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                AppMethodBeat.m2505o(80361);
            }
            return true;
        }

        /* renamed from: a */
        public final void mo7559a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(80362);
            super.mo7559a(webView, i, str, str2);
            this.zxZ = false;
            C44374a a = C46689b.this.zLh;
            C15885b c15885b = new C15885b(str, i, str2);
            a.dKw();
            try {
                C46689b.this.dismiss();
                C46689b.this.zxU.dismiss();
                AppMethodBeat.m2505o(80362);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
                AppMethodBeat.m2505o(80362);
            }
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(80363);
            C4990ab.m7410d("Twitter-WebView", "Webview loading URL: ".concat(String.valueOf(str)));
            super.mo7562b(webView, str, bitmap);
            try {
                C46689b.this.zxU.show();
                C46689b.this.zxU.setOnDismissListener(new C159081());
                AppMethodBeat.m2505o(80363);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
                AppMethodBeat.m2505o(80363);
            }
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(80364);
            super.mo5992b(webView, str);
            this.zxZ = false;
            try {
                C46689b.this.zxU.dismiss();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
            C46689b.this.zxX.setBackgroundColor(0);
            C46689b.this.zxW.setVisibility(0);
            C46689b.this.zxV.setVisibility(0);
            AppMethodBeat.m2505o(80364);
        }

        private static Bundle arZ(String str) {
            AppMethodBeat.m2504i(80365);
            Bundle bundle = new Bundle();
            if (str != null) {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            AppMethodBeat.m2505o(80365);
            return bundle;
        }

        private static Bundle asa(String str) {
            AppMethodBeat.m2504i(80366);
            Bundle arZ;
            try {
                URL url = new URL(str.replace("wechatapp", "http"));
                arZ = C44375b.arZ(url.getQuery());
                arZ.putAll(C44375b.arZ(url.getRef()));
                AppMethodBeat.m2505o(80366);
                return arZ;
            } catch (MalformedURLException e) {
                arZ = new Bundle();
                AppMethodBeat.m2505o(80366);
                return arZ;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(80369);
        AppMethodBeat.m2505o(80369);
    }

    public C46689b(Context context, String str, C44374a c44374a) {
        super(context, 16973840);
        this.mUrl = str;
        this.zLh = c44374a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(80367);
        super.onCreate(bundle);
        this.zxU = new ProgressDialog(getContext());
        this.zxU.requestWindowFeature(1);
        this.zxU.setMessage(getContext().getString(C25738R.string.ey0));
        requestWindowFeature(1);
        this.zxX = new FrameLayout(getContext());
        this.zxV = new ImageView(getContext());
        this.zxV.setOnClickListener(new C307181());
        this.zxV.setImageDrawable(getContext().getResources().getDrawable(C25738R.drawable.acu));
        this.zxV.setVisibility(4);
        int intrinsicWidth = this.zxV.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zxW = new WebView(getContext());
        this.zxW.setVerticalScrollBarEnabled(false);
        this.zxW.setHorizontalScrollBarEnabled(false);
        this.zxW.setWebViewClient(new C44375b(this, (byte) 0));
        this.zxW.getSettings().setJavaScriptEnabled(true);
        this.zxW.loadUrl(this.mUrl);
        this.zxW.setLayoutParams(zxS);
        this.zxW.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.zxW);
        this.zxX.addView(linearLayout);
        this.zxX.addView(this.zxV, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.zxX, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.m2505o(80367);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(80368);
        if (i == 4) {
            this.zLh.onCancel();
            dismiss();
            AppMethodBeat.m2505o(80368);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(80368);
        return onKeyDown;
    }
}
