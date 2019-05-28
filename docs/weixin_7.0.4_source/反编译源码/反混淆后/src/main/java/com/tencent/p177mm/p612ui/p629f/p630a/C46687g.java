package com.tencent.p177mm.p612ui.p629f.p630a;

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
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c.C30705a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
/* renamed from: com.tencent.mm.ui.f.a.g */
public final class C46687g extends C15532i {
    static final float[] zxQ = new float[]{20.0f, 60.0f};
    static final float[] zxR = new float[]{40.0f, 60.0f};
    static final LayoutParams zxS = new LayoutParams(-1, -1);
    private String mUrl;
    private C30705a zxT;
    private ProgressDialog zxU;
    private ImageView zxV;
    private WebView zxW;
    private FrameLayout zxX;

    /* renamed from: com.tencent.mm.ui.f.a.g$1 */
    class C55111 implements OnClickListener {
        C55111() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(80331);
            C46687g.this.zxT.onCancel();
            C46687g.this.dismiss();
            AppMethodBeat.m2505o(80331);
        }
    }

    /* renamed from: com.tencent.mm.ui.f.a.g$a */
    class C46686a extends C36592s {
        boolean zxZ;

        /* renamed from: com.tencent.mm.ui.f.a.g$a$1 */
        class C240031 implements OnDismissListener {
            C240031() {
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(80332);
                if (C46686a.this.zxZ && C46687g.this != null) {
                    C46687g.this.zxT.onCancel();
                    C46687g.this.dismiss();
                }
                AppMethodBeat.m2505o(80332);
            }
        }

        private C46686a() {
            this.zxZ = true;
        }

        /* synthetic */ C46686a(C46687g c46687g, byte b) {
            this();
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(80333);
            C4990ab.m7410d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith(ServerProtocol.DIALOG_REDIRECT_URI)) {
                Bundle asa = C44373f.asa(str);
                String string = asa.getString("error");
                if (string == null) {
                    string = asa.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                if (string == null) {
                    C46687g.this.zxT.mo5794p(asa);
                } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                    C46687g.this.zxT.onCancel();
                } else {
                    C46687g.this.zxT.mo5792a(new C30706e(string));
                }
                C46687g.this.dismiss();
                AppMethodBeat.m2505o(80333);
                return true;
            } else if (str.startsWith(ServerProtocol.DIALOG_CANCEL_URI)) {
                C46687g.this.zxT.onCancel();
                try {
                    C46687g.this.dismiss();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(80333);
                return true;
            } else if (str.contains("touch")) {
                AppMethodBeat.m2505o(80333);
                return false;
            } else {
                C46687g.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                AppMethodBeat.m2505o(80333);
                return true;
            }
        }

        /* renamed from: a */
        public final void mo7559a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(80334);
            super.mo7559a(webView, i, str, str2);
            this.zxZ = false;
            C46687g.this.zxT.mo5791a(new C15885b(str, i, str2));
            try {
                C46687g.this.dismiss();
                C46687g.this.zxU.dismiss();
                AppMethodBeat.m2505o(80334);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                AppMethodBeat.m2505o(80334);
            }
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(80335);
            C4990ab.m7410d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(str)));
            super.mo7562b(webView, str, bitmap);
            try {
                C46687g.this.zxU.show();
                C46687g.this.zxU.setOnDismissListener(new C240031());
                AppMethodBeat.m2505o(80335);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                AppMethodBeat.m2505o(80335);
            }
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(80336);
            super.mo5992b(webView, str);
            this.zxZ = false;
            try {
                C46687g.this.zxU.dismiss();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
            C46687g.this.zxX.setBackgroundColor(0);
            C46687g.this.zxW.setVisibility(0);
            C46687g.this.zxV.setVisibility(0);
            AppMethodBeat.m2505o(80336);
        }
    }

    static {
        AppMethodBeat.m2504i(80339);
        AppMethodBeat.m2505o(80339);
    }

    public C46687g(Context context, String str, C30705a c30705a) {
        super(context, 16973840);
        this.mUrl = str;
        this.zxT = c30705a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(80337);
        super.onCreate(bundle);
        this.zxU = new ProgressDialog(getContext());
        this.zxU.requestWindowFeature(1);
        this.zxU.setMessage(getContext().getString(C25738R.string.bmk));
        requestWindowFeature(1);
        this.zxX = new FrameLayout(getContext());
        this.zxV = new ImageView(getContext());
        this.zxV.setOnClickListener(new C55111());
        this.zxV.setImageDrawable(getContext().getResources().getDrawable(C25738R.drawable.acu));
        this.zxV.setVisibility(4);
        int intrinsicWidth = this.zxV.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zxW = new WebView(getContext());
        this.zxW.setVerticalScrollBarEnabled(false);
        this.zxW.setHorizontalScrollBarEnabled(false);
        this.zxW.setWebViewClient(new C46686a(this, (byte) 0));
        this.zxW.getSettings().setJavaScriptEnabled(true);
        this.zxW.loadUrl(this.mUrl);
        this.zxW.setLayoutParams(zxS);
        this.zxW.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.zxW);
        this.zxX.addView(linearLayout);
        this.zxX.addView(this.zxV, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.zxX, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.m2505o(80337);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(80338);
        if (i == 4) {
            this.zxT.onCancel();
            dismiss();
            AppMethodBeat.m2505o(80338);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(80338);
        return onKeyDown;
    }
}
