package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class d {
    private static Object lock = new Object();
    private Dialog dialog;
    private ap kNI = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(111712);
            if (d.this.dialog != null) {
                d.this.dialog.cancel();
            }
            AppMethodBeat.o(111712);
            return true;
        }
    }, false);
    private Context mContext;
    int mXC = 0;
    OnClickListener neA = null;
    private int neB = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    String nek = null;
    /* renamed from: new */
    private h f25new = null;
    private u nex = null;
    private q ney = null;
    private t nez = null;

    static {
        AppMethodBeat.i(111717);
        AppMethodBeat.o(111717);
    }

    public d(Context context) {
        AppMethodBeat.i(111713);
        this.mContext = context;
        AppMethodBeat.o(111713);
    }

    public final void a(c cVar, k kVar) {
        AppMethodBeat.i(111714);
        if (cVar == null || kVar == null) {
            ab.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            AppMethodBeat.o(111714);
            return;
        }
        View view = new View(this.mContext);
        view.setTag(cVar);
        ab.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", Integer.valueOf(cVar.status), Integer.valueOf(kVar.mode), Integer.valueOf(kVar.status));
        if (g.u(this.mContext, cVar.field_appId) || cVar.bDP()) {
            kVar.mode = 1;
        }
        if (kVar.mode == 3) {
            ax.bEU();
            int k = ax.k(this.mContext, "com.tencent.android.qqdownloader", cVar.dnp);
            ab.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", Integer.valueOf(k), Integer.valueOf(cVar.dnp));
            if (k == -1 || k == 1 || k == 2) {
                kVar.mode = 1;
            }
        }
        FileDownloadTaskInfo Ir;
        switch (cVar.status) {
            case 0:
            case 3:
            case 4:
                switch (kVar.mode) {
                    case 3:
                        Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(cVar.field_appId);
                        if (Ir != null && Ir.id > 0) {
                            com.tencent.mm.plugin.downloader.model.d.bij().hl(Ir.id);
                        }
                        if (this.nex == null) {
                            this.nex = new u(this.mContext);
                        }
                        u uVar = this.nex;
                        int i = this.mXC;
                        String str = this.nek;
                        uVar.mXC = i;
                        uVar.nek = str;
                        this.nex.onClick(view);
                        break;
                    case 4:
                        if (!bo.isNullOrNil(cVar.dng)) {
                            ab.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            q.by(this.mContext, cVar.dng);
                            b.a(this.mContext, cVar.scene, cVar.cKG, cVar.position, 25, cVar.field_appId, this.mXC, cVar.ctu, this.nek);
                            break;
                        }
                        break;
                    default:
                        ab.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", Integer.valueOf(kVar.mode));
                        if (this.f25new == null) {
                            this.f25new = new h(this.mContext);
                        }
                        this.f25new.setSourceScene(this.mXC);
                        this.f25new.eB(this.nek, "");
                        this.f25new.onClick(view);
                        break;
                }
                if (cVar.mVv) {
                    Set eb = e.eb(this.mContext);
                    if (!a(eb, cVar.field_appId)) {
                        if (kVar.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.a45, null);
                            ((LinearLayout) inflate.findViewById(R.id.c6c)).setGravity(17);
                            TextView textView = (TextView) inflate.findViewById(R.id.d8x);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.b06);
                            ((ImageView) inflate.findViewById(R.id.b04)).setBackgroundResource(R.drawable.adf);
                            textView.setText(R.string.c5y);
                            textView2.setText(R.string.c5x);
                            this.dialog = new i(this.mContext, R.style.jz);
                            this.dialog.setContentView(inflate);
                            this.dialog.setCancelable(true);
                            this.dialog.setCanceledOnTouchOutside(true);
                            this.dialog.show();
                            long j = (long) this.neB;
                            this.kNI.ae(j, j);
                        }
                        ((com.tencent.mm.plugin.game.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.game.a.b.class)).bCW();
                        t.b(cVar.field_appId, 1, 0, null, null);
                        eb.add(cVar.field_appId);
                        e.a(this.mContext, eb);
                    }
                    AppMethodBeat.o(111714);
                    return;
                }
                break;
            case 1:
                if (this.nez == null) {
                    this.nez = new t(this.mContext);
                    this.nez.nmX = this.neA;
                }
                this.nez.mXC = this.mXC;
                this.nez.onClick(view);
                b.a(this.mContext, cVar.scene, cVar.cKG, cVar.position, 9, cVar.field_appId, this.mXC, cVar.ctu, this.nek);
                AppMethodBeat.o(111714);
                return;
            case 2:
                Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(cVar.field_appId);
                if (Ir != null && Ir.id > 0) {
                    com.tencent.mm.plugin.downloader.model.d.bij().hl(Ir.id);
                }
                if (this.ney == null) {
                    this.ney = new q(this.mContext);
                }
                this.ney.emC = this.mXC;
                this.ney.nlL = cVar.dnk;
                this.ney.onClick(view);
                break;
        }
        AppMethodBeat.o(111714);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(ProgressBar progressBar, Button button, c cVar, k kVar) {
        AppMethodBeat.i(111715);
        if (progressBar == null || button == null) {
            AppMethodBeat.o(111715);
            return;
        }
        button.setEnabled(true);
        button.setVisibility(0);
        if (cVar.status == 1) {
            if (cVar.mVo) {
                button.setEnabled(false);
                button.setText(R.string.c4k);
                button.setVisibility(0);
                progressBar.setVisibility(8);
                AppMethodBeat.o(111715);
                return;
            }
            button.setText(R.string.c4j);
            button.setVisibility(0);
            progressBar.setVisibility(8);
            AppMethodBeat.o(111715);
        } else if (g.a(this.mContext, (f) cVar)) {
            if (cVar.versionCode <= com.tencent.mm.plugin.game.f.c.Or(cVar.field_packageName)) {
                button.setVisibility(0);
                progressBar.setVisibility(8);
                if (cVar.scene == 12) {
                    button.setText(R.string.c53);
                } else {
                    button.setText(R.string.c6o);
                }
            } else if (kVar.status == 1) {
                progressBar.setVisibility(0);
                progressBar.setProgress(kVar.progress);
                button.setVisibility(8);
            } else {
                if (cVar.scene == 12) {
                    button.setText(R.string.c55);
                } else {
                    button.setText(R.string.c4m);
                }
                button.setVisibility(0);
                progressBar.setVisibility(8);
            }
            ab.i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", cVar.field_appId, Integer.valueOf(r0), Integer.valueOf(cVar.versionCode));
            AppMethodBeat.o(111715);
        } else if (cVar.bDP()) {
            button.setVisibility(0);
            progressBar.setVisibility(8);
            if (cVar.scene == 12) {
                button.setText(R.string.c53);
                AppMethodBeat.o(111715);
                return;
            }
            button.setText(R.string.c6o);
            AppMethodBeat.o(111715);
        } else {
            switch (cVar.status) {
                case 0:
                    if (kVar == null) {
                        button.setVisibility(8);
                        progressBar.setVisibility(8);
                        AppMethodBeat.o(111715);
                        return;
                    }
                    switch (kVar.status) {
                        case 0:
                            if (cVar.scene == 12) {
                                if (cVar.mVv) {
                                    if (!a(e.eb(this.mContext), cVar.field_appId)) {
                                        button.setText(R.string.c5c);
                                    }
                                }
                                button.setText(R.string.c6g);
                            } else {
                                button.setText(R.string.c6f);
                            }
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                        case 1:
                            if (kVar.mode != 3) {
                                if (kVar.mode == 1) {
                                    progressBar.setProgress(kVar.progress);
                                    button.setVisibility(8);
                                    progressBar.setVisibility(0);
                                    break;
                                }
                            }
                            button.setText(R.string.c6m);
                            break;
                        case 2:
                            if (cVar.scene == 12) {
                                button.setText(R.string.c5b);
                            } else {
                                button.setText(R.string.c6k);
                            }
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                        case 3:
                            if (cVar.scene == 12) {
                                button.setText(R.string.c6e);
                            } else {
                                button.setText(R.string.c6d);
                            }
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                    }
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                case 1:
                    if (!cVar.mVo) {
                        button.setText(R.string.c4j);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    }
                    button.setEnabled(false);
                    button.setText(R.string.c4k);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                case 2:
                    button.setText(R.string.c4i);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                case 3:
                    if (kVar != null) {
                        switch (kVar.status) {
                            case 0:
                                button.setText(R.string.c4h);
                                break;
                            case 1:
                                if (kVar.mode != 3) {
                                    if (kVar.mode == 1) {
                                        progressBar.setProgress(kVar.progress);
                                        button.setVisibility(8);
                                        progressBar.setVisibility(0);
                                        break;
                                    }
                                }
                                button.setText(R.string.c6m);
                                break;
                                break;
                            case 2:
                                if (cVar.scene == 12) {
                                    button.setText(R.string.c5b);
                                } else {
                                    button.setText(R.string.c6k);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 3:
                                if (cVar.scene != 12) {
                                    button.setText(R.string.c6d);
                                    break;
                                } else {
                                    button.setText(R.string.c6e);
                                    break;
                                }
                        }
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    }
                    button.setText(R.string.c4h);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    AppMethodBeat.o(111715);
                    return;
                    break;
                case 4:
                    button.setText(R.string.c4l);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                default:
                    button.setVisibility(8);
                    progressBar.setVisibility(8);
                    break;
            }
            ab.i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", cVar.field_appId, Integer.valueOf(cVar.status), button.getText());
            AppMethodBeat.o(111715);
        }
    }

    private static boolean a(Set<String> set, String str) {
        AppMethodBeat.i(111716);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.o(111716);
            return false;
        } else if (set.contains(str)) {
            AppMethodBeat.o(111716);
            return true;
        } else {
            AppMethodBeat.o(111716);
            return false;
        }
    }
}
