package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ac {
    private Context context;
    boolean eVT;
    private View ltW;
    private TextView ltX;
    private TextView ltY;
    private TextView ltZ;
    private TextView lua;
    private View lub;
    boolean luc;
    Dialog lud;
    private int width;

    public interface a {
        void Kj(String str);
    }

    public static final String dG(Context context) {
        AppMethodBeat.i(19377);
        String absolutePath = new File(context.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
        AppMethodBeat.o(19377);
        return absolutePath;
    }

    public final void a(Context context, String str, String str2, String str3, final a aVar) {
        AppMethodBeat.i(19378);
        if (this.luc) {
            AppMethodBeat.o(19378);
            return;
        }
        this.luc = true;
        this.eVT = false;
        if (this.lud == null && !bo.isNullOrNil(str3)) {
            context.getString(R.string.tz);
            this.lud = h.b(context, context.getString(R.string.bi5), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ac.this.eVT = true;
                }
            });
            this.lud.show();
        }
        this.context = context;
        this.width = ActUtil.HEIGHT;
        if (this.width > com.tencent.mm.bz.a.gd(context)) {
            this.width = com.tencent.mm.bz.a.gd(context);
        }
        this.ltW = LayoutInflater.from(context).inflate(R.layout.wu, null);
        this.ltX = (TextView) this.ltW.findViewById(R.id.bkt);
        this.ltY = (TextView) this.ltW.findViewById(R.id.bl6);
        this.ltZ = (TextView) this.ltW.findViewById(R.id.bl4);
        this.lua = (TextView) this.ltW.findViewById(R.id.bl7);
        this.lub = this.ltW.findViewById(R.id.bl2);
        this.ltX.setText(str);
        this.ltZ.setText(str2);
        b.a((ImageView) this.ltW.findViewById(R.id.bj0), r.Yz(), 0.5f, false);
        ImageView imageView = (ImageView) this.ltW.findViewById(R.id.bl1);
        this.ltW.setLayoutParams(new LayoutParams(-1, -1));
        this.ltW.measure(MeasureSpec.makeMeasureSpec(this.width, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(this.width, ErrorDialogData.SUPPRESSED));
        this.ltW.layout(0, 0, this.width, this.width);
        if (bo.isNullOrNil(str3)) {
            imageView.setImageResource(R.color.le);
            aVar.Kj(L(null));
            this.luc = false;
            AppMethodBeat.o(19378);
            return;
        }
        ad.boZ().a(str3, imageView, new g() {
            public final void sH(String str) {
            }

            public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                return null;
            }

            public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                AppMethodBeat.i(19375);
                if (ac.this.eVT) {
                    ac.this.luc = false;
                    AppMethodBeat.o(19375);
                    return;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19374);
                        if (ac.this.lud.isShowing()) {
                            ac.this.lud.dismiss();
                        }
                        AppMethodBeat.o(19374);
                    }
                });
                aVar.Kj(ac.this.L(bVar.bitmap));
                ac.this.luc = false;
                AppMethodBeat.o(19375);
            }
        });
        AppMethodBeat.o(19378);
    }

    /* Access modifiers changed, original: final */
    public final String L(Bitmap bitmap) {
        int[] ao;
        AppMethodBeat.i(19379);
        if (bitmap != null) {
            ao = ae.ao(bitmap);
        } else {
            ao = new int[]{-1, WebView.NIGHT_MODE_COLOR};
        }
        AnonymousClass3 anonymousClass3 = new ShaderFactory() {
            public final Shader resize(int i, int i2) {
                AppMethodBeat.i(19376);
                float f = 0.0f;
                float f2 = 0.0f;
                LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{0, ao[0]}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
                AppMethodBeat.o(19376);
                return linearGradient;
            }
        };
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(anonymousClass3);
        this.lub.setBackgroundDrawable(paintDrawable);
        this.ltX.setTextColor(ao[1]);
        this.ltY.setTextColor(ao[1]);
        this.ltZ.setTextColor(ao[1]);
        this.lua.setTextColor(ao[1]);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.width, Config.ARGB_8888);
        this.ltW.draw(new Canvas(createBitmap));
        File file = new File(dG(this.context));
        if (file.exists()) {
            file.delete();
        }
        try {
            d.a(createBitmap, 100, CompressFormat.JPEG, file.getAbsolutePath(), true);
        } catch (IOException e) {
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(19379);
        return absolutePath;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        String str5;
        AppMethodBeat.i(19380);
        z.aeR();
        List aew = e.aew();
        if (aew.size() > 0) {
            str5 = (String) aew.get(0);
        } else {
            str5 = null;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(str2);
        String mJ = s.mJ(str5);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = mJ;
        wXMediaMessage.description = str4;
        wXMediaMessage.setThumbImage(d.decodeFile(str2, null));
        py pyVar = new py();
        pyVar.cMe.cEl = wXMediaMessage;
        pyVar.cMe.appId = "wx7fa037cc7dfabad5";
        pyVar.cMe.appName = context.getString(R.string.bij);
        pyVar.cMe.toUser = str;
        pyVar.cMe.cMf = 2;
        if (bo.isNullOrNil(str5)) {
            pyVar.cMe.cMi = null;
        } else {
            pyVar.cMe.cMg = str5;
            pyVar.cMe.cMh = mJ;
        }
        boolean m = com.tencent.mm.sdk.b.a.xxA.m(pyVar);
        if (!bo.isNullOrNil(str3)) {
            qb qbVar = new qb();
            qbVar.cMq.cMr = str;
            qbVar.cMq.content = str3;
            qbVar.cMq.type = t.nK(str);
            qbVar.cMq.flags = 0;
            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
        }
        AppMethodBeat.o(19380);
        return m;
    }
}
