package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.v;
import org.b.d.i;

public class SnsUploadConfigView extends LinearLayout implements f, a, b {
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
    com.tencent.mm.ui.i.a rCx = new com.tencent.mm.ui.i.a();
    boolean rwo = false;

    static /* synthetic */ void c(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(39712);
        snsUploadConfigView.cuy();
        AppMethodBeat.o(39712);
    }

    static /* synthetic */ void e(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(39713);
        snsUploadConfigView.cuz();
        AppMethodBeat.o(39713);
    }

    static /* synthetic */ void j(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(39715);
        snsUploadConfigView.cuA();
        AppMethodBeat.o(39715);
    }

    public SnsUploadConfigView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39701);
        this.context = context;
        this.context = context;
        View inflate = v.hu(context).inflate(R.layout.awz, this, true);
        this.rCk = (ImageView) inflate.findViewById(R.id.enm);
        this.rCl = (ImageView) inflate.findViewById(R.id.enn);
        this.rCm = (ImageView) inflate.findViewById(R.id.enk);
        this.rCn = (ImageView) inflate.findViewById(R.id.enl);
        if (!com.tencent.mm.au.b.ahM()) {
            this.rCm.setVisibility(8);
        }
        g.RQ();
        if (!g.RP().Ry().getBoolean(ac.a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, false)) {
            this.rCn.setVisibility(8);
        }
        if (!com.tencent.mm.au.b.ahP()) {
            this.rCl.setVisibility(8);
        }
        if (!r.YX()) {
            this.rCk.setVisibility(8);
        }
        this.rCm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39690);
                if (SnsUploadConfigView.this.rCr || !SnsUploadConfigView.this.rwo) {
                    SnsUploadConfigView.this.rCr = !SnsUploadConfigView.this.rCr;
                    SnsUploadConfigView.c(SnsUploadConfigView.this);
                    AppMethodBeat.o(39690);
                    return;
                }
                h.g(context, R.string.ep8, R.string.tz);
                AppMethodBeat.o(39690);
            }
        });
        this.rCn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(39695);
                if (SnsUploadConfigView.this.rCs || !SnsUploadConfigView.this.rwo) {
                    g.RQ();
                    if (g.RP().Ry().getBoolean(ac.a.USERINFO_SNS_OPEN_SHOW_WEISHI_BOOLEAN_SYNC, true)) {
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_SHOW_WEISHI_BOOLEAN_SYNC, Boolean.FALSE);
                        h.a(context, (int) R.string.eox, (int) R.string.tz, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39694);
                                SnsUploadConfigView.this.rCs = !SnsUploadConfigView.this.rCs;
                                SnsUploadConfigView.e(SnsUploadConfigView.this);
                                AppMethodBeat.o(39694);
                            }
                        });
                        AppMethodBeat.o(39695);
                        return;
                    }
                    SnsUploadConfigView snsUploadConfigView = SnsUploadConfigView.this;
                    if (SnsUploadConfigView.this.rCs) {
                        z = false;
                    }
                    snsUploadConfigView.rCs = z;
                    SnsUploadConfigView.e(SnsUploadConfigView.this);
                    AppMethodBeat.o(39695);
                    return;
                }
                h.g(context, R.string.ep_, R.string.tz);
                AppMethodBeat.o(39695);
            }
        });
        this.rCk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39696);
                SnsUploadConfigView.this.rCp = !SnsUploadConfigView.this.rCp;
                if (SnsUploadConfigView.this.rCp) {
                    SnsUploadConfigView.this.rwo = false;
                }
                SnsUploadConfigView.h(SnsUploadConfigView.this);
                AppMethodBeat.o(39696);
            }
        });
        this.rCl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39697);
                SnsUploadConfigView.this.rCq = !SnsUploadConfigView.this.rCq;
                if (SnsUploadConfigView.this.rCq) {
                    SnsUploadConfigView.this.rwo = false;
                }
                SnsUploadConfigView.j(SnsUploadConfigView.this);
                AppMethodBeat.o(39697);
            }
        });
        AppMethodBeat.o(39701);
    }

    public final void cux() {
        AppMethodBeat.i(39702);
        this.rCo = false;
        this.rCp = false;
        this.rCq = false;
        this.rCr = false;
        this.rCs = false;
        this.rCm.setImageResource(R.raw.album_qzone_icon_normal);
        this.rCn.setImageResource(R.raw.album_wesee_icon_normal);
        this.rCk.setImageResource(R.raw.album_facebook_icon_normal);
        this.rCl.setImageResource(R.raw.album_twitter_icon_normal);
        AppMethodBeat.o(39702);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cuy() {
        AppMethodBeat.i(39703);
        if (this.rCr) {
            boolean z;
            g.RQ();
            int h = bo.h((Integer) g.RP().Ry().get(9, null));
            if (h == 0) {
                h.a(getContext(), (int) R.string.ed5, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(39698);
                        com.tencent.mm.plugin.sns.c.a.gkE.g(new Intent(), SnsUploadConfigView.this.context);
                        AppMethodBeat.o(39698);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (h != 0) {
                z = true;
                if (z) {
                    this.rCr = false;
                    AppMethodBeat.o(39703);
                    return;
                }
                this.rCm.setImageResource(R.raw.album_qzone_icon_pressed);
                AppMethodBeat.o(39703);
                return;
            }
            z = false;
            if (z) {
            }
        } else {
            this.rCm.setImageResource(R.raw.album_qzone_icon_normal);
            AppMethodBeat.o(39703);
        }
    }

    /* Access modifiers changed, original: final */
    public final void cuz() {
        AppMethodBeat.i(39704);
        if (this.rCn == null) {
            AppMethodBeat.o(39704);
            return;
        }
        if (this.rCv) {
            g.RQ();
            if (g.RP().Ry().getBoolean(ac.a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, false)) {
                this.rCn.setVisibility(0);
                if (this.rCs) {
                    this.rCn.setImageResource(R.raw.album_wesee_icon_pressed);
                    AppMethodBeat.o(39704);
                    return;
                }
                this.rCn.setImageResource(R.raw.album_wesee_icon_normal);
                AppMethodBeat.o(39704);
                return;
            }
        }
        this.rCs = false;
        this.rCn.setVisibility(8);
        AppMethodBeat.o(39704);
    }

    /* Access modifiers changed, original: 0000 */
    public void setSyncFacebook(boolean z) {
        AppMethodBeat.i(39705);
        if (this.rCp) {
            boolean z2;
            if (r.Za()) {
                z2 = true;
            } else {
                h.a(getContext(), (int) R.string.e6v, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(39699);
                        d.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
                        AppMethodBeat.o(39699);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z2 = false;
            }
            if (z2) {
                if (!(z || this.rCu || !r.Za())) {
                    final com.tencent.mm.sdk.b.b gcVar = new gc();
                    gcVar.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(39691);
                            if (!gcVar.cAr.cvi) {
                                SnsUploadConfigView.m(SnsUploadConfigView.this);
                            }
                            AppMethodBeat.o(39691);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.a(gcVar, Looper.myLooper());
                }
                this.rCk.setImageResource(R.raw.album_facebook_icon_pressed);
                AppMethodBeat.o(39705);
                return;
            }
            this.rCp = false;
            AppMethodBeat.o(39705);
            return;
        }
        this.rCk.setImageResource(R.raw.album_facebook_icon_normal);
        AppMethodBeat.o(39705);
    }

    /* Access modifiers changed, original: final */
    public final void cuA() {
        AppMethodBeat.i(39706);
        if (this.rCq) {
            boolean z;
            if (this.rCx.dKv()) {
                z = true;
            } else {
                h.a(getContext(), (int) R.string.ec9, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(39700);
                        SnsUploadConfigView snsUploadConfigView = SnsUploadConfigView.this;
                        Context context = SnsUploadConfigView.this.getContext();
                        SnsUploadConfigView.this.getContext().getString(R.string.tz);
                        snsUploadConfigView.nEK = h.b(context, SnsUploadConfigView.this.getContext().getString(R.string.ey0), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        SnsUploadConfigView.this.rCx.a(SnsUploadConfigView.this, SnsUploadConfigView.this.getContext());
                        AppMethodBeat.o(39700);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z = false;
            }
            if (z) {
                this.rCl.setImageResource(R.raw.album_twitter_icon_pressed);
                AppMethodBeat.o(39706);
                return;
            }
            this.rCq = false;
            AppMethodBeat.o(39706);
            return;
        }
        this.rCl.setImageResource(R.raw.album_twitter_icon_normal);
        AppMethodBeat.o(39706);
    }

    public int getPrivated() {
        if (this.rwo) {
            return 1;
        }
        return 0;
    }

    public void setPrivated(boolean z) {
        AppMethodBeat.i(39707);
        this.rwo = z;
        if (z) {
            cux();
        }
        AppMethodBeat.o(39707);
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

    public i getTwitterAccessToken() {
        return this.rCx.zKU;
    }

    private void xv(int i) {
        AppMethodBeat.i(39708);
        h.a(getContext(), i, (int) R.string.tz, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(39708);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(39709);
        if (i == 0 && i2 == 0 && mVar != null) {
            cuz();
            AppMethodBeat.o(39709);
            return;
        }
        AppMethodBeat.o(39709);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(39710);
        if (this.nEK != null) {
            this.nEK.cancel();
        }
        switch (cVar) {
            case Finished:
                this.rCq = true;
                xv(R.string.ey2);
                break;
            case Canceled:
                this.rCq = false;
                break;
            case Failed:
                this.rCq = false;
                xv(R.string.ey1);
                break;
        }
        cuA();
        AppMethodBeat.o(39710);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(39711);
        switch (cVar) {
            case Failed:
                this.rCq = false;
                break;
        }
        cuA();
        AppMethodBeat.o(39711);
    }

    static /* synthetic */ void h(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(39714);
        snsUploadConfigView.setSyncFacebook(false);
        AppMethodBeat.o(39714);
    }

    static /* synthetic */ void m(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(39716);
        ab.e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.rCp) {
            String string = snsUploadConfigView.getContext().getString(R.string.tz);
            h.a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(R.string.bmb), string, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(39692);
                    Intent intent = new Intent();
                    intent.putExtra("is_force_unbind", true);
                    intent.putExtra("shake_music", true);
                    d.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", intent, 8);
                    AppMethodBeat.o(39692);
                }
            }, null);
        }
        snsUploadConfigView.rCp = false;
        snsUploadConfigView.setSyncFacebook(false);
        AppMethodBeat.o(39716);
    }
}
