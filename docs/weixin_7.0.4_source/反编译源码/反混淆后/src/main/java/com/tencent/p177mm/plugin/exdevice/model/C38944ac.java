package com.tencent.p177mm.plugin.exdevice.model;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.model.ac */
public final class C38944ac {
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

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ac$a */
    public interface C27846a {
        /* renamed from: Kj */
        void mo23478Kj(String str);
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ac$1 */
    class C389451 implements OnCancelListener {
        C389451() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            C38944ac.this.eVT = true;
        }
    }

    /* renamed from: dG */
    public static final String m66115dG(Context context) {
        AppMethodBeat.m2504i(19377);
        String absolutePath = new File(context.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
        AppMethodBeat.m2505o(19377);
        return absolutePath;
    }

    /* renamed from: a */
    public final void mo61828a(Context context, String str, String str2, String str3, final C27846a c27846a) {
        AppMethodBeat.m2504i(19378);
        if (this.luc) {
            AppMethodBeat.m2505o(19378);
            return;
        }
        this.luc = true;
        this.eVT = false;
        if (this.lud == null && !C5046bo.isNullOrNil(str3)) {
            context.getString(C25738R.string.f9238tz);
            this.lud = C30379h.m48458b(context, context.getString(C25738R.string.bi5), true, new C389451());
            this.lud.show();
        }
        this.context = context;
        this.width = ActUtil.HEIGHT;
        if (this.width > C1338a.m2868gd(context)) {
            this.width = C1338a.m2868gd(context);
        }
        this.ltW = LayoutInflater.from(context).inflate(2130969449, null);
        this.ltX = (TextView) this.ltW.findViewById(2131823719);
        this.ltY = (TextView) this.ltW.findViewById(2131823732);
        this.ltZ = (TextView) this.ltW.findViewById(2131823730);
        this.lua = (TextView) this.ltW.findViewById(2131823733);
        this.lub = this.ltW.findViewById(2131823728);
        this.ltX.setText(str);
        this.ltZ.setText(str2);
        C40460b.m69433a((ImageView) this.ltW.findViewById(2131823652), C1853r.m3846Yz(), 0.5f, false);
        ImageView imageView = (ImageView) this.ltW.findViewById(2131823727);
        this.ltW.setLayoutParams(new LayoutParams(-1, -1));
        this.ltW.measure(MeasureSpec.makeMeasureSpec(this.width, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(this.width, ErrorDialogData.SUPPRESSED));
        this.ltW.layout(0, 0, this.width, this.width);
        if (C5046bo.isNullOrNil(str3)) {
            imageView.setImageResource(C25738R.color.f11911le);
            c27846a.mo23478Kj(mo61827L(null));
            this.luc = false;
            AppMethodBeat.m2505o(19378);
            return;
        }
        C45891ad.boZ().mo43770a(str3, imageView, new C9014g() {

            /* renamed from: com.tencent.mm.plugin.exdevice.model.ac$2$1 */
            class C389421 implements Runnable {
                C389421() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(19374);
                    if (C38944ac.this.lud.isShowing()) {
                        C38944ac.this.lud.dismiss();
                    }
                    AppMethodBeat.m2505o(19374);
                }
            }

            /* renamed from: sH */
            public final void mo7596sH(String str) {
            }

            /* renamed from: a */
            public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                return null;
            }

            /* renamed from: b */
            public final void mo7595b(String str, View view, C37477b c37477b) {
                AppMethodBeat.m2504i(19375);
                if (C38944ac.this.eVT) {
                    C38944ac.this.luc = false;
                    AppMethodBeat.m2505o(19375);
                    return;
                }
                C5004al.m7441d(new C389421());
                c27846a.mo23478Kj(C38944ac.this.mo61827L(c37477b.bitmap));
                C38944ac.this.luc = false;
                AppMethodBeat.m2505o(19375);
            }
        });
        AppMethodBeat.m2505o(19378);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: L */
    public final String mo61827L(Bitmap bitmap) {
        int[] ao;
        AppMethodBeat.m2504i(19379);
        if (bitmap != null) {
            ao = C5222ae.m7936ao(bitmap);
        } else {
            ao = new int[]{-1, WebView.NIGHT_MODE_COLOR};
        }
        C389463 c389463 = new ShaderFactory() {
            public final Shader resize(int i, int i2) {
                AppMethodBeat.m2504i(19376);
                float f = 0.0f;
                float f2 = 0.0f;
                LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{0, ao[0]}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
                AppMethodBeat.m2505o(19376);
                return linearGradient;
            }
        };
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(c389463);
        this.lub.setBackgroundDrawable(paintDrawable);
        this.ltX.setTextColor(ao[1]);
        this.ltY.setTextColor(ao[1]);
        this.ltZ.setTextColor(ao[1]);
        this.lua.setTextColor(ao[1]);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.width, Config.ARGB_8888);
        this.ltW.draw(new Canvas(createBitmap));
        File file = new File(C38944ac.m66115dG(this.context));
        if (file.exists()) {
            file.delete();
        }
        try {
            C5056d.m7625a(createBitmap, 100, CompressFormat.JPEG, file.getAbsolutePath(), true);
        } catch (IOException e) {
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.m2505o(19379);
        return absolutePath;
    }

    /* renamed from: a */
    public static boolean m66114a(Context context, String str, String str2, String str3, String str4) {
        String str5;
        AppMethodBeat.m2504i(19380);
        C41747z.aeR();
        List aew = C25764e.aew();
        if (aew.size() > 0) {
            str5 = (String) aew.get(0);
        } else {
            str5 = null;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(str2);
        String mJ = C1854s.m3866mJ(str5);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = mJ;
        wXMediaMessage.description = str4;
        wXMediaMessage.setThumbImage(C5056d.decodeFile(str2, null));
        C26217py c26217py = new C26217py();
        c26217py.cMe.cEl = wXMediaMessage;
        c26217py.cMe.appId = "wx7fa037cc7dfabad5";
        c26217py.cMe.appName = context.getString(C25738R.string.bij);
        c26217py.cMe.toUser = str;
        c26217py.cMe.cMf = 2;
        if (C5046bo.isNullOrNil(str5)) {
            c26217py.cMe.cMi = null;
        } else {
            c26217py.cMe.cMg = str5;
            c26217py.cMe.cMh = mJ;
        }
        boolean m = C4879a.xxA.mo10055m(c26217py);
        if (!C5046bo.isNullOrNil(str3)) {
            C18372qb c18372qb = new C18372qb();
            c18372qb.cMq.cMr = str;
            c18372qb.cMq.content = str3;
            c18372qb.cMq.type = C1855t.m3925nK(str);
            c18372qb.cMq.flags = 0;
            C4879a.xxA.mo10055m(c18372qb);
        }
        AppMethodBeat.m2505o(19380);
        return m;
    }
}
