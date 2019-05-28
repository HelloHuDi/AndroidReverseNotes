package com.tencent.mm.ui.i;

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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@SuppressLint({"SetJavaScriptEnabled"})
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class b extends Dialog {
    static final float[] zxQ = new float[]{20.0f, 60.0f};
    static final float[] zxR = new float[]{40.0f, 60.0f};
    static final LayoutParams zxS = new LayoutParams(-1, -1);
    private String mUrl;
    private a zLh;
    private ProgressDialog zxU;
    private ImageView zxV;
    private WebView zxW;
    private FrameLayout zxX;

    public interface a {
        void dKw();

        void onCancel();

        void p(Bundle bundle);
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
    class b extends s {
        boolean zxZ;

        private b() {
            this.zxZ = true;
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(80361);
            ab.d("Twitter-WebView", "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith("wechatapp://sign-in-twitter.wechatapp.com/")) {
                Bundle asa = asa(str);
                if (asa.getString("denied") == null) {
                    b.this.zLh.p(asa);
                } else {
                    b.this.zLh.onCancel();
                }
                b.this.dismiss();
                AppMethodBeat.o(80361);
            } else {
                b.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                AppMethodBeat.o(80361);
            }
            return true;
        }

        public final void a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(80362);
            super.a(webView, i, str, str2);
            this.zxZ = false;
            a a = b.this.zLh;
            com.tencent.mm.ui.f.a.b bVar = new com.tencent.mm.ui.f.a.b(str, i, str2);
            a.dKw();
            try {
                b.this.dismiss();
                b.this.zxU.dismiss();
                AppMethodBeat.o(80362);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
                AppMethodBeat.o(80362);
            }
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(80363);
            ab.d("Twitter-WebView", "Webview loading URL: ".concat(String.valueOf(str)));
            super.b(webView, str, bitmap);
            try {
                b.this.zxU.show();
                b.this.zxU.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(80360);
                        if (b.this.zxZ && b.this != null) {
                            b.this.zLh.onCancel();
                            b.this.dismiss();
                        }
                        AppMethodBeat.o(80360);
                    }
                });
                AppMethodBeat.o(80363);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
                AppMethodBeat.o(80363);
            }
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(80364);
            super.b(webView, str);
            this.zxZ = false;
            try {
                b.this.zxU.dismiss();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
            b.this.zxX.setBackgroundColor(0);
            b.this.zxW.setVisibility(0);
            b.this.zxV.setVisibility(0);
            AppMethodBeat.o(80364);
        }

        private static Bundle arZ(String str) {
            AppMethodBeat.i(80365);
            Bundle bundle = new Bundle();
            if (str != null) {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            AppMethodBeat.o(80365);
            return bundle;
        }

        private static Bundle asa(String str) {
            AppMethodBeat.i(80366);
            Bundle arZ;
            try {
                URL url = new URL(str.replace("wechatapp", "http"));
                arZ = arZ(url.getQuery());
                arZ.putAll(arZ(url.getRef()));
                AppMethodBeat.o(80366);
                return arZ;
            } catch (MalformedURLException e) {
                arZ = new Bundle();
                AppMethodBeat.o(80366);
                return arZ;
            }
        }
    }

    static {
        AppMethodBeat.i(80369);
        AppMethodBeat.o(80369);
    }

    public b(Context context, String str, a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.zLh = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(80367);
        super.onCreate(bundle);
        this.zxU = new ProgressDialog(getContext());
        this.zxU.requestWindowFeature(1);
        this.zxU.setMessage(getContext().getString(R.string.ey0));
        requestWindowFeature(1);
        this.zxX = new FrameLayout(getContext());
        this.zxV = new ImageView(getContext());
        this.zxV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(80359);
                b.this.zLh.onCancel();
                b.this.dismiss();
                AppMethodBeat.o(80359);
            }
        });
        this.zxV.setImageDrawable(getContext().getResources().getDrawable(R.drawable.acu));
        this.zxV.setVisibility(4);
        int intrinsicWidth = this.zxV.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zxW = new WebView(getContext());
        this.zxW.setVerticalScrollBarEnabled(false);
        this.zxW.setHorizontalScrollBarEnabled(false);
        this.zxW.setWebViewClient(new b(this, (byte) 0));
        this.zxW.getSettings().setJavaScriptEnabled(true);
        this.zxW.loadUrl(this.mUrl);
        this.zxW.setLayoutParams(zxS);
        this.zxW.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.zxW);
        this.zxX.addView(linearLayout);
        this.zxX.addView(this.zxV, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.zxX, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(80367);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(80368);
        if (i == 4) {
            this.zLh.onCancel();
            dismiss();
            AppMethodBeat.o(80368);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(80368);
        return onKeyDown;
    }
}
