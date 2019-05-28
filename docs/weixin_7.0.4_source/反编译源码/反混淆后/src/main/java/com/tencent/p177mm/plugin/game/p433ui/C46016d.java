package com.tencent.p177mm.plugin.game.p433ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.model.C28236t;
import com.tencent.p177mm.plugin.game.model.C39214ax;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.game.ui.d */
public final class C46016d {
    private static Object lock = new Object();
    private Dialog dialog;
    private C7564ap kNI = new C7564ap(Looper.getMainLooper(), new C392341(), false);
    private Context mContext;
    int mXC = 0;
    OnClickListener neA = null;
    private int neB = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    String nek = null;
    /* renamed from: new */
    private C28262h f17895new = null;
    private C39240u nex = null;
    private C21034q ney = null;
    private C21036t nez = null;

    /* renamed from: com.tencent.mm.plugin.game.ui.d$1 */
    class C392341 implements C5015a {
        C392341() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(111712);
            if (C46016d.this.dialog != null) {
                C46016d.this.dialog.cancel();
            }
            AppMethodBeat.m2505o(111712);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(111717);
        AppMethodBeat.m2505o(111717);
    }

    public C46016d(Context context) {
        AppMethodBeat.m2504i(111713);
        this.mContext = context;
        AppMethodBeat.m2505o(111713);
    }

    /* renamed from: a */
    public final void mo73916a(C20992c c20992c, C21003k c21003k) {
        AppMethodBeat.m2504i(111714);
        if (c20992c == null || c21003k == null) {
            C4990ab.m7412e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            AppMethodBeat.m2505o(111714);
            return;
        }
        View view = new View(this.mContext);
        view.setTag(c20992c);
        C4990ab.m7417i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", Integer.valueOf(c20992c.status), Integer.valueOf(c21003k.mode), Integer.valueOf(c21003k.status));
        if (C46494g.m87757u(this.mContext, c20992c.field_appId) || c20992c.bDP()) {
            c21003k.mode = 1;
        }
        if (c21003k.mode == 3) {
            C39214ax.bEU();
            int k = C39214ax.m66820k(this.mContext, "com.tencent.android.qqdownloader", c20992c.dnp);
            C4990ab.m7417i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", Integer.valueOf(k), Integer.valueOf(c20992c.dnp));
            if (k == -1 || k == 1 || k == 2) {
                c21003k.mode = 1;
            }
        }
        FileDownloadTaskInfo Ir;
        switch (c20992c.status) {
            case 0:
            case 3:
            case 4:
                switch (c21003k.mode) {
                    case 3:
                        Ir = C2896d.bij().mo7040Ir(c20992c.field_appId);
                        if (Ir != null && Ir.f16167id > 0) {
                            C2896d.bij().mo7047hl(Ir.f16167id);
                        }
                        if (this.nex == null) {
                            this.nex = new C39240u(this.mContext);
                        }
                        C39240u c39240u = this.nex;
                        int i = this.mXC;
                        String str = this.nek;
                        c39240u.mXC = i;
                        c39240u.nek = str;
                        this.nex.onClick(view);
                        break;
                    case 4:
                        if (!C5046bo.isNullOrNil(c20992c.dng)) {
                            C4990ab.m7416i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            C35800q.m58699by(this.mContext, c20992c.dng);
                            C34277b.m56212a(this.mContext, c20992c.scene, c20992c.cKG, c20992c.position, 25, c20992c.field_appId, this.mXC, c20992c.ctu, this.nek);
                            break;
                        }
                        break;
                    default:
                        C4990ab.m7411d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", Integer.valueOf(c21003k.mode));
                        if (this.f17895new == null) {
                            this.f17895new = new C28262h(this.mContext);
                        }
                        this.f17895new.setSourceScene(this.mXC);
                        this.f17895new.mo46146eB(this.nek, "");
                        this.f17895new.onClick(view);
                        break;
                }
                if (c20992c.mVv) {
                    Set eb = C20993e.m32275eb(this.mContext);
                    if (!C46016d.m85564a(eb, c20992c.field_appId)) {
                        if (c21003k.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(2130969721, null);
                            ((LinearLayout) inflate.findViewById(2131824516)).setGravity(17);
                            TextView textView = (TextView) inflate.findViewById(2131825979);
                            TextView textView2 = (TextView) inflate.findViewById(2131822918);
                            ((ImageView) inflate.findViewById(2131822916)).setBackgroundResource(C25738R.drawable.adf);
                            textView.setText(C25738R.string.c5y);
                            textView2.setText(C25738R.string.c5x);
                            this.dialog = new C15532i(this.mContext, C25738R.style.f10958jz);
                            this.dialog.setContentView(inflate);
                            this.dialog.setCancelable(true);
                            this.dialog.setCanceledOnTouchOutside(true);
                            this.dialog.show();
                            long j = (long) this.neB;
                            this.kNI.mo16770ae(j, j);
                        }
                        ((C43156b) C1720g.m3528K(C43156b.class)).bCW();
                        C28236t.m44820b(c20992c.field_appId, 1, 0, null, null);
                        eb.add(c20992c.field_appId);
                        C20993e.m32264a(this.mContext, eb);
                    }
                    AppMethodBeat.m2505o(111714);
                    return;
                }
                break;
            case 1:
                if (this.nez == null) {
                    this.nez = new C21036t(this.mContext);
                    this.nez.nmX = this.neA;
                }
                this.nez.mXC = this.mXC;
                this.nez.onClick(view);
                C34277b.m56212a(this.mContext, c20992c.scene, c20992c.cKG, c20992c.position, 9, c20992c.field_appId, this.mXC, c20992c.ctu, this.nek);
                AppMethodBeat.m2505o(111714);
                return;
            case 2:
                Ir = C2896d.bij().mo7040Ir(c20992c.field_appId);
                if (Ir != null && Ir.f16167id > 0) {
                    C2896d.bij().mo7047hl(Ir.f16167id);
                }
                if (this.ney == null) {
                    this.ney = new C21034q(this.mContext);
                }
                this.ney.emC = this.mXC;
                this.ney.nlL = c20992c.dnk;
                this.ney.onClick(view);
                break;
        }
        AppMethodBeat.m2505o(111714);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo73915a(ProgressBar progressBar, Button button, C20992c c20992c, C21003k c21003k) {
        AppMethodBeat.m2504i(111715);
        if (progressBar == null || button == null) {
            AppMethodBeat.m2505o(111715);
            return;
        }
        button.setEnabled(true);
        button.setVisibility(0);
        if (c20992c.status == 1) {
            if (c20992c.mVo) {
                button.setEnabled(false);
                button.setText(C25738R.string.c4k);
                button.setVisibility(0);
                progressBar.setVisibility(8);
                AppMethodBeat.m2505o(111715);
                return;
            }
            button.setText(C25738R.string.c4j);
            button.setVisibility(0);
            progressBar.setVisibility(8);
            AppMethodBeat.m2505o(111715);
        } else if (C46494g.m87726a(this.mContext, (C40439f) c20992c)) {
            if (c20992c.versionCode <= C46001c.m85447Or(c20992c.field_packageName)) {
                button.setVisibility(0);
                progressBar.setVisibility(8);
                if (c20992c.scene == 12) {
                    button.setText(C25738R.string.c53);
                } else {
                    button.setText(C25738R.string.c6o);
                }
            } else if (c21003k.status == 1) {
                progressBar.setVisibility(0);
                progressBar.setProgress(c21003k.progress);
                button.setVisibility(8);
            } else {
                if (c20992c.scene == 12) {
                    button.setText(C25738R.string.c55);
                } else {
                    button.setText(C25738R.string.c4m);
                }
                button.setVisibility(0);
                progressBar.setVisibility(8);
            }
            C4990ab.m7417i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", c20992c.field_appId, Integer.valueOf(r0), Integer.valueOf(c20992c.versionCode));
            AppMethodBeat.m2505o(111715);
        } else if (c20992c.bDP()) {
            button.setVisibility(0);
            progressBar.setVisibility(8);
            if (c20992c.scene == 12) {
                button.setText(C25738R.string.c53);
                AppMethodBeat.m2505o(111715);
                return;
            }
            button.setText(C25738R.string.c6o);
            AppMethodBeat.m2505o(111715);
        } else {
            switch (c20992c.status) {
                case 0:
                    if (c21003k == null) {
                        button.setVisibility(8);
                        progressBar.setVisibility(8);
                        AppMethodBeat.m2505o(111715);
                        return;
                    }
                    switch (c21003k.status) {
                        case 0:
                            if (c20992c.scene == 12) {
                                if (c20992c.mVv) {
                                    if (!C46016d.m85564a(C20993e.m32275eb(this.mContext), c20992c.field_appId)) {
                                        button.setText(C25738R.string.c5c);
                                    }
                                }
                                button.setText(C25738R.string.c6g);
                            } else {
                                button.setText(C25738R.string.c6f);
                            }
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                        case 1:
                            if (c21003k.mode != 3) {
                                if (c21003k.mode == 1) {
                                    progressBar.setProgress(c21003k.progress);
                                    button.setVisibility(8);
                                    progressBar.setVisibility(0);
                                    break;
                                }
                            }
                            button.setText(C25738R.string.c6m);
                            break;
                        case 2:
                            if (c20992c.scene == 12) {
                                button.setText(C25738R.string.c5b);
                            } else {
                                button.setText(C25738R.string.c6k);
                            }
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                        case 3:
                            if (c20992c.scene == 12) {
                                button.setText(C25738R.string.c6e);
                            } else {
                                button.setText(C25738R.string.c6d);
                            }
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                    }
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                case 1:
                    if (!c20992c.mVo) {
                        button.setText(C25738R.string.c4j);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    }
                    button.setEnabled(false);
                    button.setText(C25738R.string.c4k);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                case 2:
                    button.setText(C25738R.string.c4i);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                case 3:
                    if (c21003k != null) {
                        switch (c21003k.status) {
                            case 0:
                                button.setText(C25738R.string.c4h);
                                break;
                            case 1:
                                if (c21003k.mode != 3) {
                                    if (c21003k.mode == 1) {
                                        progressBar.setProgress(c21003k.progress);
                                        button.setVisibility(8);
                                        progressBar.setVisibility(0);
                                        break;
                                    }
                                }
                                button.setText(C25738R.string.c6m);
                                break;
                                break;
                            case 2:
                                if (c20992c.scene == 12) {
                                    button.setText(C25738R.string.c5b);
                                } else {
                                    button.setText(C25738R.string.c6k);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 3:
                                if (c20992c.scene != 12) {
                                    button.setText(C25738R.string.c6d);
                                    break;
                                } else {
                                    button.setText(C25738R.string.c6e);
                                    break;
                                }
                        }
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    }
                    button.setText(C25738R.string.c4h);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    AppMethodBeat.m2505o(111715);
                    return;
                    break;
                case 4:
                    button.setText(C25738R.string.c4l);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                default:
                    button.setVisibility(8);
                    progressBar.setVisibility(8);
                    break;
            }
            C4990ab.m7417i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", c20992c.field_appId, Integer.valueOf(c20992c.status), button.getText());
            AppMethodBeat.m2505o(111715);
        }
    }

    /* renamed from: a */
    private static boolean m85564a(Set<String> set, String str) {
        AppMethodBeat.m2504i(111716);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.m2505o(111716);
            return false;
        } else if (set.contains(str)) {
            AppMethodBeat.m2505o(111716);
            return true;
        } else {
            AppMethodBeat.m2505o(111716);
            return false;
        }
    }
}
