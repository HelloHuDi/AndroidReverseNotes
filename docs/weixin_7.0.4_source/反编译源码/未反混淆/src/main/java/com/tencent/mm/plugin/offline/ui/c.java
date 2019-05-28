package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c {
    Vibrator kgA;
    Activity mActivity;
    a oZn;
    q oZo;
    float oZp = 0.0f;
    int oZq = i.sHCENCODEVIDEOTIMEOUT;

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$11 */
    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ g oZt;

        AnonymousClass11(g gVar) {
            this.oZt = gVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(43481);
            dialogInterface.dismiss();
            if (c.this.oZn != null) {
                c.this.oZn.e(1, this.oZt.id, "", this.oZt.cBT);
            }
            ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
            AppMethodBeat.o(43481);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$13 */
    class AnonymousClass13 implements com.tencent.mm.plugin.wallet_core.ui.q.c {
        final /* synthetic */ g oZt;

        AnonymousClass13(g gVar) {
            this.oZt = gVar;
        }

        public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
            AppMethodBeat.i(43483);
            if (c.this.mActivity instanceof MMActivity) {
                ((MMActivity) c.this.mActivity).aqX();
            }
            if (c.this.oZn != null) {
                c.this.oZn.e(1, this.oZt.id, str, this.oZt.cBT);
            }
            ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
            AppMethodBeat.o(43483);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$1 */
    class AnonymousClass1 extends com.tencent.mm.sdk.b.c<uv> {
        final /* synthetic */ PayInfo oZr;

        AnonymousClass1(PayInfo payInfo) {
            this.oZr = payInfo;
            AppMethodBeat.i(43472);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(43472);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(43473);
            uv uvVar = (uv) bVar;
            a.xxA.d(this);
            if (uvVar.cRF.result == 0) {
                m cVar = new com.tencent.mm.plugin.offline.a.c(this.oZr.czZ, this.oZr.cIf, this.oZr.cIb);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(cVar, 0);
                com.tencent.mm.plugin.offline.g.bXc();
                c.this.oZn.bXu();
            } else if (uvVar.cRF.result == -1) {
                com.tencent.mm.plugin.offline.g.bXc();
                c.this.oZn.bXu();
            }
            AppMethodBeat.o(43473);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$12 */
    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ g oZt;

        AnonymousClass12(g gVar) {
            this.oZt = gVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(43482);
            dialogInterface.dismiss();
            if (c.this.oZn != null) {
                c.this.oZn.e(0, this.oZt.id, "", this.oZt.cBT);
            }
            com.tencent.mm.plugin.offline.g.cM(this.oZt.cBT, com.tencent.mm.plugin.offline.g.oXg);
            ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
            AppMethodBeat.o(43482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.c$15 */
    class AnonymousClass15 implements q.a {
        final /* synthetic */ g oZt;

        AnonymousClass15(g gVar) {
            this.oZt = gVar;
        }

        public final void bXx() {
            AppMethodBeat.i(43485);
            if (c.this.oZn != null) {
                c.this.oZn.e(0, this.oZt.id, "", this.oZt.cBT);
            }
            com.tencent.mm.plugin.offline.g.cM(this.oZt.cBT, com.tencent.mm.plugin.offline.g.oXg);
            ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
            AppMethodBeat.o(43485);
        }
    }

    public c(Activity activity, a aVar) {
        this.mActivity = activity;
        this.oZn = aVar;
    }

    public final void init() {
        AppMethodBeat.i(43488);
        this.kgA = (Vibrator) this.mActivity.getSystemService("vibrator");
        AppMethodBeat.o(43488);
    }

    public final void a(m mVar, int i, String str) {
        AppMethodBeat.i(43489);
        a(mVar, i, str, null);
        AppMethodBeat.o(43489);
    }

    public final void a(m mVar, int i, String str, String str2) {
        AppMethodBeat.i(43490);
        ab.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i + " msg:" + str);
        bXv();
        if (i == 409) {
            Ub(str);
            AppMethodBeat.o(43490);
        } else if (i == 410) {
            Ua(str);
            AppMethodBeat.o(43490);
        } else if (i == 413) {
            Uc(str);
            AppMethodBeat.o(43490);
        } else if (i == 411) {
            if (r.cPI().cQi() || r.cPI().cQh()) {
                ab.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
                AppMethodBeat.o(43490);
                return;
            }
            if (k.oXK && (this.mActivity instanceof WalletOfflineCoinPurseUI)) {
                ((WalletOfflineCoinPurseUI) this.mActivity).bXT();
            } else {
                com.tencent.mm.plugin.offline.c.a.c(this.mActivity, str);
            }
            h.pYm.a(135, 1, 1, true);
            AppMethodBeat.o(43490);
        } else if (this.mActivity instanceof WalletBaseUI) {
            if (!com.tencent.mm.wallet_core.d.h.a((WalletBaseUI) this.mActivity, mVar, 1000, i, str)) {
                b.c(this.mActivity, str, str2);
            }
            AppMethodBeat.o(43490);
        } else {
            b.b(this.mActivity, str);
            AppMethodBeat.o(43490);
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(43491);
        ab.i("MicroMsg.OfflineLogicMgr", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " cgi type:" + mVar.getType());
        e eVar;
        if (i == 0 && i2 == 0) {
            if (mVar instanceof e) {
                eVar = (e) mVar;
                String str2 = eVar.oXY;
                bXv();
                if (eVar.oXZ != 0 || TextUtils.isEmpty(str2)) {
                    if (!(eVar.oXZ == 0 || eVar.kCl == 0 || eVar.oYb != 1)) {
                        ab.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                        a(eVar, eVar.oXZ, eVar.oYa);
                    }
                    z = true;
                } else {
                    com.tencent.mm.plugin.offline.c.a.a(this.mActivity, str2, mVar);
                    this.mActivity.setResult(-1);
                    this.mActivity.finish();
                    z = true;
                }
            }
        } else if (mVar instanceof e) {
            eVar = (e) mVar;
            bXv();
            if (eVar.oYb == 1) {
                ab.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                a(mVar, i2, str);
            }
            z = true;
        }
        AppMethodBeat.o(43491);
        return z;
    }

    public final void bXv() {
        AppMethodBeat.i(43492);
        if (this.oZo != null) {
            this.oZo.dismiss();
            this.oZo = null;
        }
        AppMethodBeat.o(43492);
    }

    private void Ua(String str) {
        AppMethodBeat.i(43493);
        ab.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(str)));
        com.tencent.mm.ui.base.h.d(this.mActivity, str, "", getString(R.string.fnt), getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43486);
                com.tencent.mm.pluginsdk.wallet.h.aj(c.this.mActivity, 0);
                ab.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                AppMethodBeat.o(43486);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(43493);
    }

    private void Ub(String str) {
        AppMethodBeat.i(43494);
        ab.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(str)));
        com.tencent.mm.ui.base.h.d(this.mActivity, str, "", getString(R.string.fvy), getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43487);
                com.tencent.mm.pluginsdk.wallet.h.aj(c.this.mActivity, 0);
                ab.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                AppMethodBeat.o(43487);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(43494);
    }

    private void Uc(String str) {
        AppMethodBeat.i(43495);
        ab.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(str)));
        com.tencent.mm.ui.base.h.d(this.mActivity, str, "", getString(R.string.fva), getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43474);
                c.this.oZn.bXr();
                ab.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
                AppMethodBeat.o(43474);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(43495);
    }

    public final void a(s.b bVar) {
        AppMethodBeat.i(43496);
        if (bVar == null) {
            AppMethodBeat.o(43496);
            return;
        }
        ab.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
        if ("1".equals(bVar.oYP)) {
            com.tencent.mm.ui.base.h.a(this.mActivity, false, bVar.oYR, "", getString(R.string.fvo), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(43475);
                    dialogInterface.dismiss();
                    com.tencent.mm.plugin.offline.c.a.U(c.this.mActivity);
                    ab.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
                    AppMethodBeat.o(43475);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(43476);
                    dialogInterface.dismiss();
                    c.this.mActivity.finish();
                    AppMethodBeat.o(43476);
                }
            });
        }
        AppMethodBeat.o(43496);
    }

    public static boolean bXw() {
        AppMethodBeat.i(43497);
        k.bXg();
        if (k.bXh().oYL != null) {
            AppMethodBeat.o(43497);
            return true;
        }
        AppMethodBeat.o(43497);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final String getString(int i) {
        AppMethodBeat.i(43498);
        String string = this.mActivity.getString(i);
        AppMethodBeat.o(43498);
        return string;
    }
}
