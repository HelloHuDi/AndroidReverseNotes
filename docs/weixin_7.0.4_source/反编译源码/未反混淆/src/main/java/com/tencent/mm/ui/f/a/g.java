package com.tencent.mm.ui.f.a;

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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class g extends i {
    static final float[] zxQ = new float[]{20.0f, 60.0f};
    static final float[] zxR = new float[]{40.0f, 60.0f};
    static final LayoutParams zxS = new LayoutParams(-1, -1);
    private String mUrl;
    private com.tencent.mm.ui.f.a.c.a zxT;
    private ProgressDialog zxU;
    private ImageView zxV;
    private WebView zxW;
    private FrameLayout zxX;

    class a extends s {
        boolean zxZ;

        private a() {
            this.zxZ = true;
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(80333);
            ab.d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith(ServerProtocol.DIALOG_REDIRECT_URI)) {
                Bundle asa = f.asa(str);
                String string = asa.getString("error");
                if (string == null) {
                    string = asa.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                if (string == null) {
                    g.this.zxT.p(asa);
                } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                    g.this.zxT.onCancel();
                } else {
                    g.this.zxT.a(new e(string));
                }
                g.this.dismiss();
                AppMethodBeat.o(80333);
                return true;
            } else if (str.startsWith(ServerProtocol.DIALOG_CANCEL_URI)) {
                g.this.zxT.onCancel();
                try {
                    g.this.dismiss();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                }
                AppMethodBeat.o(80333);
                return true;
            } else if (str.contains("touch")) {
                AppMethodBeat.o(80333);
                return false;
            } else {
                g.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                AppMethodBeat.o(80333);
                return true;
            }
        }

        public final void a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(80334);
            super.a(webView, i, str, str2);
            this.zxZ = false;
            g.this.zxT.a(new b(str, i, str2));
            try {
                g.this.dismiss();
                g.this.zxU.dismiss();
                AppMethodBeat.o(80334);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                AppMethodBeat.o(80334);
            }
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(80335);
            ab.d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(str)));
            super.b(webView, str, bitmap);
            try {
                g.this.zxU.show();
                g.this.zxU.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(80332);
                        if (a.this.zxZ && g.this != null) {
                            g.this.zxT.onCancel();
                            g.this.dismiss();
                        }
                        AppMethodBeat.o(80332);
                    }
                });
                AppMethodBeat.o(80335);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                AppMethodBeat.o(80335);
            }
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(80336);
            super.b(webView, str);
            this.zxZ = false;
            try {
                g.this.zxU.dismiss();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
            g.this.zxX.setBackgroundColor(0);
            g.this.zxW.setVisibility(0);
            g.this.zxV.setVisibility(0);
            AppMethodBeat.o(80336);
        }
    }

    static {
        AppMethodBeat.i(80339);
        AppMethodBeat.o(80339);
    }

    public g(Context context, String str, com.tencent.mm.ui.f.a.c.a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.zxT = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(80337);
        super.onCreate(bundle);
        this.zxU = new ProgressDialog(getContext());
        this.zxU.requestWindowFeature(1);
        this.zxU.setMessage(getContext().getString(R.string.bmk));
        requestWindowFeature(1);
        this.zxX = new FrameLayout(getContext());
        this.zxV = new ImageView(getContext());
        this.zxV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(80331);
                g.this.zxT.onCancel();
                g.this.dismiss();
                AppMethodBeat.o(80331);
            }
        });
        this.zxV.setImageDrawable(getContext().getResources().getDrawable(R.drawable.acu));
        this.zxV.setVisibility(4);
        int intrinsicWidth = this.zxV.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zxW = new WebView(getContext());
        this.zxW.setVerticalScrollBarEnabled(false);
        this.zxW.setHorizontalScrollBarEnabled(false);
        this.zxW.setWebViewClient(new a(this, (byte) 0));
        this.zxW.getSettings().setJavaScriptEnabled(true);
        this.zxW.loadUrl(this.mUrl);
        this.zxW.setLayoutParams(zxS);
        this.zxW.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.zxW);
        this.zxX.addView(linearLayout);
        this.zxX.addView(this.zxV, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.zxX, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(80337);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(80338);
        if (i == 4) {
            this.zxT.onCancel();
            dismiss();
            AppMethodBeat.o(80338);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(80338);
        return onKeyDown;
    }
}
