package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26145gc;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p1094i.C15898a;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15905c;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15906a;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15907b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView */
public class SnsUploadConfigView extends LinearLayout implements C1202f, C15906a, C15907b {
    private static String ceO = "com.tencent.mm";
    private Context context;
    private ProgressDialog nEK = null;
    ImageView rCk;
    ImageView rCl;
    ImageView rCm;
    ImageView rCn;
    private boolean rCo = false;
    boolean rCp = false;
    boolean rCq = false;
    private boolean rCr = false;
    private boolean rCs = false;
    private boolean rCt = true;
    private boolean rCu = false;
    boolean rCv = false;
    ayt rCw = new ayt();
    C15898a rCx = new C15898a();
    boolean rwo = false;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$9 */
    class C40099 implements OnClickListener {
        C40099() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39696);
            SnsUploadConfigView.this.rCp = !SnsUploadConfigView.this.rCp;
            if (SnsUploadConfigView.this.rCp) {
                SnsUploadConfigView.this.rwo = false;
            }
            SnsUploadConfigView.m68196h(SnsUploadConfigView.this);
            AppMethodBeat.m2505o(39696);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$4 */
    class C135784 implements DialogInterface.OnClickListener {
        C135784() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39692);
            Intent intent = new Intent();
            intent.putExtra("is_force_unbind", true);
            intent.putExtra("shake_music", true);
            C25985d.m41468b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", intent, 8);
            AppMethodBeat.m2505o(39692);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$11 */
    class C2205011 implements DialogInterface.OnClickListener {
        C2205011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39698);
            C24826a.gkE.mo38921g(new Intent(), SnsUploadConfigView.this.context);
            AppMethodBeat.m2505o(39698);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$12 */
    class C2916312 implements DialogInterface.OnClickListener {
        C2916312() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$10 */
    class C3508010 implements OnClickListener {
        C3508010() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39697);
            SnsUploadConfigView.this.rCq = !SnsUploadConfigView.this.rCq;
            if (SnsUploadConfigView.this.rCq) {
                SnsUploadConfigView.this.rwo = false;
            }
            SnsUploadConfigView.m68198j(SnsUploadConfigView.this);
            AppMethodBeat.m2505o(39697);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$2 */
    class C350812 implements DialogInterface.OnClickListener {
        C350812() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$5 */
    class C350825 implements DialogInterface.OnClickListener {
        C350825() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$6 */
    class C350836 implements DialogInterface.OnClickListener {
        C350836() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$13 */
    class C3981613 implements DialogInterface.OnClickListener {
        C3981613() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39699);
            C25985d.m41467b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
            AppMethodBeat.m2505o(39699);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$14 */
    class C3981714 implements DialogInterface.OnClickListener {
        C3981714() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$15 */
    class C3981815 implements DialogInterface.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$15$1 */
        class C398191 implements OnCancelListener {
            C398191() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        C3981815() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39700);
            SnsUploadConfigView snsUploadConfigView = SnsUploadConfigView.this;
            Context context = SnsUploadConfigView.this.getContext();
            SnsUploadConfigView.this.getContext().getString(C25738R.string.f9238tz);
            snsUploadConfigView.nEK = C30379h.m48458b(context, SnsUploadConfigView.this.getContext().getString(C25738R.string.ey0), true, new C398191());
            SnsUploadConfigView.this.rCx.mo28144a(SnsUploadConfigView.this, SnsUploadConfigView.this.getContext());
            AppMethodBeat.m2505o(39700);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m68189c(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.m2504i(39712);
        snsUploadConfigView.cuy();
        AppMethodBeat.m2505o(39712);
    }

    /* renamed from: e */
    static /* synthetic */ void m68193e(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.m2504i(39713);
        snsUploadConfigView.cuz();
        AppMethodBeat.m2505o(39713);
    }

    /* renamed from: j */
    static /* synthetic */ void m68198j(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.m2504i(39715);
        snsUploadConfigView.cuA();
        AppMethodBeat.m2505o(39715);
    }

    public SnsUploadConfigView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39701);
        this.context = context;
        this.context = context;
        View inflate = C5616v.m8409hu(context).inflate(2130970825, this, true);
        this.rCk = (ImageView) inflate.findViewById(2131827929);
        this.rCl = (ImageView) inflate.findViewById(2131827930);
        this.rCm = (ImageView) inflate.findViewById(2131827927);
        this.rCn = (ImageView) inflate.findViewById(2131827928);
        if (!C17950b.ahM()) {
            this.rCm.setVisibility(8);
        }
        C1720g.m3537RQ();
        if (!C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, false)) {
            this.rCn.setVisibility(8);
        }
        if (!C17950b.ahP()) {
            this.rCl.setVisibility(8);
        }
        if (!C1853r.m3842YX()) {
            this.rCk.setVisibility(8);
        }
        this.rCm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(39690);
                if (SnsUploadConfigView.this.rCr || !SnsUploadConfigView.this.rwo) {
                    SnsUploadConfigView.this.rCr = !SnsUploadConfigView.this.rCr;
                    SnsUploadConfigView.m68189c(SnsUploadConfigView.this);
                    AppMethodBeat.m2505o(39690);
                    return;
                }
                C30379h.m48467g(context, C25738R.string.ep8, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(39690);
            }
        });
        this.rCn.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView$8$1 */
            class C350861 implements DialogInterface.OnClickListener {
                C350861() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(39694);
                    SnsUploadConfigView.this.rCs = !SnsUploadConfigView.this.rCs;
                    SnsUploadConfigView.m68193e(SnsUploadConfigView.this);
                    AppMethodBeat.m2505o(39694);
                }
            }

            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.m2504i(39695);
                if (SnsUploadConfigView.this.rCs || !SnsUploadConfigView.this.rwo) {
                    C1720g.m3537RQ();
                    if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SNS_OPEN_SHOW_WEISHI_BOOLEAN_SYNC, true)) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_SHOW_WEISHI_BOOLEAN_SYNC, Boolean.FALSE);
                        C30379h.m48431a(context, (int) C25738R.string.eox, (int) C25738R.string.f9238tz, new C350861());
                        AppMethodBeat.m2505o(39695);
                        return;
                    }
                    SnsUploadConfigView snsUploadConfigView = SnsUploadConfigView.this;
                    if (SnsUploadConfigView.this.rCs) {
                        z = false;
                    }
                    snsUploadConfigView.rCs = z;
                    SnsUploadConfigView.m68193e(SnsUploadConfigView.this);
                    AppMethodBeat.m2505o(39695);
                    return;
                }
                C30379h.m48467g(context, C25738R.string.ep_, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(39695);
            }
        });
        this.rCk.setOnClickListener(new C40099());
        this.rCl.setOnClickListener(new C3508010());
        AppMethodBeat.m2505o(39701);
    }

    public final void cux() {
        AppMethodBeat.m2504i(39702);
        this.rCo = false;
        this.rCp = false;
        this.rCq = false;
        this.rCr = false;
        this.rCs = false;
        this.rCm.setImageResource(C1318a.album_qzone_icon_normal);
        this.rCn.setImageResource(C1318a.album_wesee_icon_normal);
        this.rCk.setImageResource(C1318a.album_facebook_icon_normal);
        this.rCl.setImageResource(C1318a.album_twitter_icon_normal);
        AppMethodBeat.m2505o(39702);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cuy() {
        AppMethodBeat.m2504i(39703);
        if (this.rCr) {
            boolean z;
            C1720g.m3537RQ();
            int h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null));
            if (h == 0) {
                C30379h.m48432a(getContext(), (int) C25738R.string.ed5, (int) C25738R.string.f9238tz, new C2205011(), new C2916312());
            } else if (h != 0) {
                z = true;
                if (z) {
                    this.rCr = false;
                    AppMethodBeat.m2505o(39703);
                    return;
                }
                this.rCm.setImageResource(C1318a.album_qzone_icon_pressed);
                AppMethodBeat.m2505o(39703);
                return;
            }
            z = false;
            if (z) {
            }
        } else {
            this.rCm.setImageResource(C1318a.album_qzone_icon_normal);
            AppMethodBeat.m2505o(39703);
        }
    }

    /* Access modifiers changed, original: final */
    public final void cuz() {
        AppMethodBeat.m2504i(39704);
        if (this.rCn == null) {
            AppMethodBeat.m2505o(39704);
            return;
        }
        if (this.rCv) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, false)) {
                this.rCn.setVisibility(0);
                if (this.rCs) {
                    this.rCn.setImageResource(C1318a.album_wesee_icon_pressed);
                    AppMethodBeat.m2505o(39704);
                    return;
                }
                this.rCn.setImageResource(C1318a.album_wesee_icon_normal);
                AppMethodBeat.m2505o(39704);
                return;
            }
        }
        this.rCs = false;
        this.rCn.setVisibility(8);
        AppMethodBeat.m2505o(39704);
    }

    /* Access modifiers changed, original: 0000 */
    public void setSyncFacebook(boolean z) {
        AppMethodBeat.m2504i(39705);
        if (this.rCp) {
            boolean z2;
            if (C1853r.m3847Za()) {
                z2 = true;
            } else {
                C30379h.m48432a(getContext(), (int) C25738R.string.e6v, (int) C25738R.string.f9238tz, new C3981613(), new C3981714());
                z2 = false;
            }
            if (z2) {
                if (!(z || this.rCu || !C1853r.m3847Za())) {
                    final C4883b c26145gc = new C26145gc();
                    c26145gc.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(39691);
                            if (!c26145gc.cAr.cvi) {
                                SnsUploadConfigView.m68201m(SnsUploadConfigView.this);
                            }
                            AppMethodBeat.m2505o(39691);
                        }
                    };
                    C4879a.xxA.mo10048a(c26145gc, Looper.myLooper());
                }
                this.rCk.setImageResource(C1318a.album_facebook_icon_pressed);
                AppMethodBeat.m2505o(39705);
                return;
            }
            this.rCp = false;
            AppMethodBeat.m2505o(39705);
            return;
        }
        this.rCk.setImageResource(C1318a.album_facebook_icon_normal);
        AppMethodBeat.m2505o(39705);
    }

    /* Access modifiers changed, original: final */
    public final void cuA() {
        AppMethodBeat.m2504i(39706);
        if (this.rCq) {
            boolean z;
            if (this.rCx.dKv()) {
                z = true;
            } else {
                C30379h.m48432a(getContext(), (int) C25738R.string.ec9, (int) C25738R.string.f9238tz, new C3981815(), new C350812());
                z = false;
            }
            if (z) {
                this.rCl.setImageResource(C1318a.album_twitter_icon_pressed);
                AppMethodBeat.m2505o(39706);
                return;
            }
            this.rCq = false;
            AppMethodBeat.m2505o(39706);
            return;
        }
        this.rCl.setImageResource(C1318a.album_twitter_icon_normal);
        AppMethodBeat.m2505o(39706);
    }

    public int getPrivated() {
        if (this.rwo) {
            return 1;
        }
        return 0;
    }

    public void setPrivated(boolean z) {
        AppMethodBeat.m2504i(39707);
        this.rwo = z;
        if (z) {
            cux();
        }
        AppMethodBeat.m2505o(39707);
    }

    public int getSyncFlag() {
        int i = 0;
        if (this.rCo) {
            i = 1;
        }
        if (this.rCp) {
            i |= 2;
        }
        if (this.rCq) {
            i |= 8;
        }
        if (this.rCr) {
            i |= 4;
        }
        if (this.rCs) {
            return i | 16;
        }
        return i;
    }

    public C41173i getTwitterAccessToken() {
        return this.rCx.zKU;
    }

    /* renamed from: xv */
    private void m68202xv(int i) {
        AppMethodBeat.m2504i(39708);
        C30379h.m48432a(getContext(), i, (int) C25738R.string.f9238tz, new C350825(), new C350836());
        AppMethodBeat.m2505o(39708);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39709);
        if (i == 0 && i2 == 0 && c1207m != null) {
            cuz();
            AppMethodBeat.m2505o(39709);
            return;
        }
        AppMethodBeat.m2505o(39709);
    }

    /* renamed from: a */
    public final void mo28157a(C15905c c15905c) {
        AppMethodBeat.m2504i(39710);
        if (this.nEK != null) {
            this.nEK.cancel();
        }
        switch (c15905c) {
            case Finished:
                this.rCq = true;
                m68202xv(C25738R.string.ey2);
                break;
            case Canceled:
                this.rCq = false;
                break;
            case Failed:
                this.rCq = false;
                m68202xv(C25738R.string.ey1);
                break;
        }
        cuA();
        AppMethodBeat.m2505o(39710);
    }

    /* renamed from: b */
    public final void mo28156b(C15905c c15905c) {
        AppMethodBeat.m2504i(39711);
        switch (c15905c) {
            case Failed:
                this.rCq = false;
                break;
        }
        cuA();
        AppMethodBeat.m2505o(39711);
    }

    /* renamed from: h */
    static /* synthetic */ void m68196h(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.m2504i(39714);
        snsUploadConfigView.setSyncFacebook(false);
        AppMethodBeat.m2505o(39714);
    }

    /* renamed from: m */
    static /* synthetic */ void m68201m(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.m2504i(39716);
        C4990ab.m7412e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.rCp) {
            String string = snsUploadConfigView.getContext().getString(C25738R.string.f9238tz);
            C30379h.m48440a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(C25738R.string.bmb), string, new C135784(), null);
        }
        snsUploadConfigView.rCp = false;
        snsUploadConfigView.setSyncFacebook(false);
        AppMethodBeat.m2505o(39716);
    }
}
