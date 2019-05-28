package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.o;

public final class c implements i {
    private Bitmap bitmap = null;
    private ImageView cDh = null;
    private ProgressBar cDj = null;
    private View contentView = null;
    private Context context;
    private View jWH;
    private View nOh;
    private TextView rwe = null;
    private TextView rwf = null;
    o vot;
    public boolean vou = true;
    private long yro = 10000;
    private ImageView yrp = null;
    private String yrq = null;
    private boolean yrr = false;
    private boolean yrs = false;
    public a yrt;
    ak yru = null;

    public interface a {
        void dzn();
    }

    public final void abU() {
        AppMethodBeat.i(29963);
        ab.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
        this.cDj.setVisibility(0);
        this.cDh.setVisibility(8);
        this.yrp.setVisibility(8);
        AppMethodBeat.o(29963);
    }

    public final void x(Bitmap bitmap) {
        AppMethodBeat.i(29964);
        ab.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
        if (bitmap == null) {
            ab.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
            AppMethodBeat.o(29964);
            return;
        }
        this.bitmap = bitmap;
        this.cDj.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled()) {
            this.yrp.setVisibility(0);
            this.cDh.setVisibility(8);
            AppMethodBeat.o(29964);
            return;
        }
        this.cDh.setVisibility(0);
        this.cDh.setImageBitmap(bitmap);
        this.yrp.setVisibility(8);
        AppMethodBeat.o(29964);
    }

    public final void mr() {
        AppMethodBeat.i(29965);
        ab.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
        this.yrp.setVisibility(0);
        this.cDj.setVisibility(8);
        this.cDh.setVisibility(8);
        AppMethodBeat.o(29965);
    }

    public final String wP() {
        AppMethodBeat.i(29966);
        String bE = n.bE(this);
        AppMethodBeat.o(29966);
        return bE;
    }

    public c(Context context, View view, View view2, boolean z) {
        AppMethodBeat.i(29967);
        this.context = context;
        this.jWH = view;
        this.nOh = view2;
        this.yrs = z;
        this.contentView = View.inflate(this.context, R.layout.la, null);
        this.rwe = (TextView) this.contentView.findViewById(R.id.amw);
        this.rwf = (TextView) this.contentView.findViewById(R.id.amx);
        this.cDh = (ImageView) this.contentView.findViewById(R.id.aga);
        this.yrp = (ImageView) this.contentView.findViewById(R.id.amv);
        this.cDj = (ProgressBar) this.contentView.findViewById(R.id.amu);
        this.vot = new o(this.contentView, -2, -2, true);
        this.vot.setBackgroundDrawable(new ColorDrawable(0));
        this.vot.setOutsideTouchable(true);
        this.vot.setFocusable(false);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(29958);
                if (c.this.yrt != null) {
                    c.this.yrt.dzn();
                }
                c.this.vot.dismiss();
                AppMethodBeat.o(29958);
            }
        });
        this.yru = new ak(this.context.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(29959);
                c.a(c.this);
                AppMethodBeat.o(29959);
            }
        };
        AppMethodBeat.o(29967);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(29968);
        if (cVar.cDh == null || cVar.vot == null || cVar.jWH == null || cVar.nOh == null) {
            ab.e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
            AppMethodBeat.o(29968);
            return;
        }
        int i;
        if (cVar.bitmap != null) {
            ab.d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            cVar.abU();
        } else {
            cVar.x(cVar.bitmap);
        }
        i = cVar.vou ? 83 : 85;
        int i2 = cVar.vou ? 0 : 10;
        int gs = x.gs(cVar.context);
        int height = cVar.nOh.getHeight();
        if (cVar.yrs && height < gs) {
            height += gs;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect dze = ae.dze();
            i2 = cVar.vou ? 0 : i2 + dze.right;
            height += dze.bottom;
            ab.i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", Integer.valueOf(dze.right), Integer.valueOf(dze.bottom));
        }
        cVar.vot.showAtLocation(cVar.jWH, i, i2, height);
        if (cVar.yro > 0) {
            ap apVar = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(29960);
                    c cVar = c.this;
                    ab.d("MicroMsg.AppBrandServiceImageBubble", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
                    if (cVar.vot != null) {
                        cVar.vot.dismiss();
                    }
                    AppMethodBeat.o(29960);
                    return false;
                }
            }, false);
            long j = cVar.yro;
            apVar.ae(j, j);
        }
        AppMethodBeat.o(29968);
    }
}
