package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.md;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b implements d {
    private static String TAG = "MicroMsg.BakChatBanner";
    private ak handler = new ak(Looper.getMainLooper());
    private int jAo = 0;
    private View jAp = null;
    private c jAq;
    private int jzK = -1;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(17904);
        if (this.view != null) {
            this.jAp = this.view.findViewById(R.id.a2b);
            this.jAp.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(17901);
                    a.this.jzK = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK;
                    if (2 == a.this.jzK || 3 == a.this.jzK || 5 == a.this.jzK || 6 == a.this.jzK) {
                        ab.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK), Integer.valueOf(a.this.jAo));
                        a.d(a.this);
                        AppMethodBeat.o(17901);
                    } else if (4 == a.this.jzK) {
                        ab.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK), Integer.valueOf(a.this.jAo));
                        a.e(a.this);
                        AppMethodBeat.o(17901);
                    } else {
                        AppMethodBeat.o(17901);
                    }
                }
            });
        }
        aMN();
        this.jAq = new c<md>() {
            {
                AppMethodBeat.i(17899);
                this.xxI = md.class.getName().hashCode();
                AppMethodBeat.o(17899);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(17900);
                a.this.getView().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(17898);
                        if (a.a(a.this)) {
                            com.tencent.mm.sdk.b.a.xxA.m(new jr());
                        }
                        AppMethodBeat.o(17898);
                    }
                });
                AppMethodBeat.o(17900);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(this.jAq);
        AppMethodBeat.o(17904);
    }

    public final int getLayoutId() {
        return R.layout.fn;
    }

    private boolean fs(boolean z) {
        AppMethodBeat.i(17905);
        this.jzK = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK;
        ab.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", Integer.valueOf(this.jzK), Boolean.valueOf(z));
        if (this.jzK < 2 || this.jzK > 6) {
            this.jAp.setVisibility(8);
            AppMethodBeat.o(17905);
            return false;
        }
        this.jAp.setVisibility(0);
        if (z && !com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().aUJ()) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().a((d) this);
        }
        if (2 == this.jzK) {
            ((ImageView) this.view.findViewById(R.id.a2c)).setImageResource(R.raw.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.id.a2d)).setText(ah.getContext().getString(R.string.a21, new Object[]{Integer.valueOf(this.jAo)}));
        } else if (3 == this.jzK) {
            ((ImageView) this.view.findViewById(R.id.a2c)).setImageResource(R.raw.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.id.a2d)).setText(ah.getContext().getString(R.string.a24, new Object[]{Integer.valueOf(this.jAo)}));
        } else if (4 == this.jzK) {
            ((TextView) this.view.findViewById(R.id.a2d)).setText(ah.getContext().getString(R.string.a23));
            ((ImageView) this.view.findViewById(R.id.a2c)).setImageResource(R.raw.chatting_backup_comfirm);
        } else if (5 == this.jzK) {
            ((ImageView) this.view.findViewById(R.id.a2c)).setImageResource(R.raw.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.id.a2d)).setText(ah.getContext().getString(R.string.a20, new Object[]{Integer.valueOf(this.jAo)}));
        } else if (6 == this.jzK) {
            ((TextView) this.view.findViewById(R.id.a2d)).setText(ah.getContext().getString(R.string.a22));
            ((ImageView) this.view.findViewById(R.id.a2c)).setImageResource(R.raw.chatting_backup_comfirm);
        }
        AppMethodBeat.o(17905);
        return true;
    }

    public final boolean aMN() {
        AppMethodBeat.i(17906);
        this.jAo = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().aUM();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().a((d) this);
        boolean fs = fs(true);
        AppMethodBeat.o(17906);
        return fs;
    }

    public final void release() {
        AppMethodBeat.i(17907);
        this.jzK = -1;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().aUK();
        AppMethodBeat.o(17907);
    }

    public final void onError(int i) {
    }

    public final void rI(int i) {
        AppMethodBeat.i(17908);
        ab.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK), Integer.valueOf(i));
        this.jAo = i;
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17902);
                a.this.aMN();
                AppMethodBeat.o(17902);
            }
        });
        AppMethodBeat.o(17908);
    }

    public final void rJ(int i) {
        AppMethodBeat.i(17909);
        ab.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK), Integer.valueOf(i));
        AppMethodBeat.o(17909);
    }

    public final void aUP() {
        AppMethodBeat.i(17910);
        ab.d(TAG, "onNetFinish PCBannerStatus:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK));
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC();
        e.rF(17);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17903);
                a.this.aMN();
                AppMethodBeat.o(17903);
            }
        });
        AppMethodBeat.o(17910);
    }

    public final void aSt() {
    }

    public final void aUQ() {
    }

    public final void destroy() {
        AppMethodBeat.i(17911);
        com.tencent.mm.sdk.b.a.xxA.d(this.jAq);
        AppMethodBeat.o(17911);
    }

    public final int getOrder() {
        return 3;
    }

    static /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(17912);
        aVar.jAo = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().aUM();
        ab.d(TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzK), Integer.valueOf(aVar.jAo));
        boolean fs = aVar.fs(false);
        AppMethodBeat.o(17912);
        return fs;
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(17913);
        Intent intent = new Intent((Context) aVar.vlu.get(), BakOperatingUI.class);
        intent.putExtra("from_bak_banner", true);
        MMWizardActivity.J((Context) aVar.vlu.get(), intent);
        AppMethodBeat.o(17913);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(17914);
        Intent intent = new Intent((Context) aVar.vlu.get(), BakFinishUI.class);
        intent.putExtra("cmd", 1);
        MMWizardActivity.J((Context) aVar.vlu.get(), intent);
        AppMethodBeat.o(17914);
    }
}
