package com.tencent.p177mm.p612ui.appbrand;

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
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.ui.appbrand.c */
public final class C36039c implements C9676i {
    private Bitmap bitmap = null;
    private ImageView cDh = null;
    private ProgressBar cDj = null;
    private View contentView = null;
    private Context context;
    private View jWH;
    private View nOh;
    private TextView rwe = null;
    private TextView rwf = null;
    C46633o vot;
    public boolean vou = true;
    private long yro = 10000;
    private ImageView yrp = null;
    private String yrq = null;
    private boolean yrr = false;
    private boolean yrs = false;
    public C5233a yrt;
    C7306ak yru = null;

    /* renamed from: com.tencent.mm.ui.appbrand.c$a */
    public interface C5233a {
        void dzn();
    }

    /* renamed from: com.tencent.mm.ui.appbrand.c$1 */
    class C303591 implements OnClickListener {
        C303591() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29958);
            if (C36039c.this.yrt != null) {
                C36039c.this.yrt.dzn();
            }
            C36039c.this.vot.dismiss();
            AppMethodBeat.m2505o(29958);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.c$4 */
    public class C360414 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(29961);
            C36039c.this.yru.sendEmptyMessage(0);
            AppMethodBeat.m2505o(29961);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29962);
            String str = super.toString() + "MicroMsg.AppBrandServiceImageBubbleshow";
            AppMethodBeat.m2505o(29962);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.c$3 */
    class C360423 implements C5015a {
        C360423() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(29960);
            C36039c c36039c = C36039c.this;
            C4990ab.m7410d("MicroMsg.AppBrandServiceImageBubble", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
            if (c36039c.vot != null) {
                c36039c.vot.dismiss();
            }
            AppMethodBeat.m2505o(29960);
            return false;
        }
    }

    public final void abU() {
        AppMethodBeat.m2504i(29963);
        C4990ab.m7410d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
        this.cDj.setVisibility(0);
        this.cDh.setVisibility(8);
        this.yrp.setVisibility(8);
        AppMethodBeat.m2505o(29963);
    }

    /* renamed from: x */
    public final void mo6524x(Bitmap bitmap) {
        AppMethodBeat.m2504i(29964);
        C4990ab.m7410d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
        if (bitmap == null) {
            C4990ab.m7420w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
            AppMethodBeat.m2505o(29964);
            return;
        }
        this.bitmap = bitmap;
        this.cDj.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled()) {
            this.yrp.setVisibility(0);
            this.cDh.setVisibility(8);
            AppMethodBeat.m2505o(29964);
            return;
        }
        this.cDh.setVisibility(0);
        this.cDh.setImageBitmap(bitmap);
        this.yrp.setVisibility(8);
        AppMethodBeat.m2505o(29964);
    }

    /* renamed from: mr */
    public final void mo6522mr() {
        AppMethodBeat.m2504i(29965);
        C4990ab.m7416i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
        this.yrp.setVisibility(0);
        this.cDj.setVisibility(8);
        this.cDh.setVisibility(8);
        AppMethodBeat.m2505o(29965);
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        AppMethodBeat.m2504i(29966);
        String bE = C38496n.m65148bE(this);
        AppMethodBeat.m2505o(29966);
        return bE;
    }

    public C36039c(Context context, View view, View view2, boolean z) {
        AppMethodBeat.m2504i(29967);
        this.context = context;
        this.jWH = view;
        this.nOh = view2;
        this.yrs = z;
        this.contentView = View.inflate(this.context, 2130969020, null);
        this.rwe = (TextView) this.contentView.findViewById(2131822428);
        this.rwf = (TextView) this.contentView.findViewById(2131822429);
        this.cDh = (ImageView) this.contentView.findViewById(2131822184);
        this.yrp = (ImageView) this.contentView.findViewById(2131822427);
        this.cDj = (ProgressBar) this.contentView.findViewById(2131822426);
        this.vot = new C46633o(this.contentView, -2, -2, true);
        this.vot.setBackgroundDrawable(new ColorDrawable(0));
        this.vot.setOutsideTouchable(true);
        this.vot.setFocusable(false);
        this.contentView.setOnClickListener(new C303591());
        this.yru = new C7306ak(this.context.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(29959);
                C36039c.m59308a(C36039c.this);
                AppMethodBeat.m2505o(29959);
            }
        };
        AppMethodBeat.m2505o(29967);
    }

    /* renamed from: a */
    static /* synthetic */ void m59308a(C36039c c36039c) {
        AppMethodBeat.m2504i(29968);
        if (c36039c.cDh == null || c36039c.vot == null || c36039c.jWH == null || c36039c.nOh == null) {
            C4990ab.m7412e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
            AppMethodBeat.m2505o(29968);
            return;
        }
        int i;
        if (c36039c.bitmap != null) {
            C4990ab.m7410d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            c36039c.abU();
        } else {
            c36039c.mo6524x(c36039c.bitmap);
        }
        i = c36039c.vou ? 83 : 85;
        int i2 = c36039c.vou ? 0 : 10;
        int gs = C40619x.m70073gs(c36039c.context);
        int height = c36039c.nOh.getHeight();
        if (c36039c.yrs && height < gs) {
            height += gs;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect dze = C5222ae.dze();
            i2 = c36039c.vou ? 0 : i2 + dze.right;
            height += dze.bottom;
            C4990ab.m7417i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", Integer.valueOf(dze.right), Integer.valueOf(dze.bottom));
        }
        c36039c.vot.showAtLocation(c36039c.jWH, i, i2, height);
        if (c36039c.yro > 0) {
            C7564ap c7564ap = new C7564ap(new C360423(), false);
            long j = c36039c.yro;
            c7564ap.mo16770ae(j, j);
        }
        AppMethodBeat.m2505o(29968);
    }
}
