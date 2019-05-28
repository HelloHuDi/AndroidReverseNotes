package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.ah;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.HashMap;

@a(dFp = ah.class)
public class ap extends a implements ah {
    private az ySV = new az(5, "msg-translate-update-worker");
    private HashMap<Long, b> ySW = new HashMap();
    private c ySX = new c<tj>() {
        {
            AppMethodBeat.i(31826);
            this.xxI = tj.class.getName().hashCode();
            AppMethodBeat.o(31826);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(31827);
            tj tjVar = (tj) bVar;
            if (tjVar instanceof tj) {
                final String str = tjVar.cPF.id;
                final int i = tjVar.cPF.ret;
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(31825);
                        if (i == 0) {
                            ap.this.a(bo.anl(str), b.Transformed);
                            ap.a(ap.this, bo.anl(str));
                            AppMethodBeat.o(31825);
                            return;
                        }
                        if (i == 3) {
                            h.bQ(ap.this.cgL.yTx.getContext(), ap.this.cgL.yTx.getMMResources().getString(R.string.ap1));
                        } else if (i != 5) {
                            h.bQ(ap.this.cgL.yTx.getContext(), ap.this.cgL.yTx.getMMResources().getString(R.string.aow));
                        }
                        ap.this.a(bo.anl(str), b.NoTransform);
                        ap.this.cgL.aWv();
                        AppMethodBeat.o(31825);
                    }
                }, (long) (i == 5 ? 2000 : 0));
            }
            AppMethodBeat.o(31827);
            return false;
        }
    };

    static /* synthetic */ void a(ap apVar, bi biVar, boolean z) {
        AppMethodBeat.i(31839);
        apVar.d(biVar, z);
        AppMethodBeat.o(31839);
    }

    public ap() {
        AppMethodBeat.i(31829);
        AppMethodBeat.o(31829);
    }

    private void dDi() {
        AppMethodBeat.i(31830);
        com.tencent.mm.sdk.b.a.xxA.d(this.ySX);
        AppMethodBeat.o(31830);
    }

    public final void a(long j, b bVar) {
        AppMethodBeat.i(31831);
        this.ySW.put(Long.valueOf(j), bVar);
        AppMethodBeat.o(31831);
    }

    public final b bl(bi biVar) {
        AppMethodBeat.i(31832);
        b bVar = (b) this.ySW.get(Long.valueOf(biVar.field_msgId));
        if (bVar == null) {
            if (!biVar.dtF()) {
                ti tiVar = new ti();
                tiVar.cPC.id = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(tiVar);
                if (tiVar.cPD.cPE) {
                    bVar = b.Transforming;
                    a(biVar.field_msgId, bVar);
                } else {
                    bVar = b.NoTransform;
                }
            } else if (biVar.dtM()) {
                bVar = b.Transformed;
            } else {
                bVar = b.NoTransform;
            }
        }
        AppMethodBeat.o(31832);
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(final MenuItem menuItem, final bi biVar) {
        AppMethodBeat.i(31833);
        final int itemId = menuItem.getItemId();
        switch (itemId) {
            case 124:
            case 125:
                int i;
                ab.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", Integer.valueOf(biVar.getType()), Boolean.valueOf(biVar.dtM()));
                if (itemId == 124) {
                    aw.ZK();
                    if (!((Boolean) com.tencent.mm.model.c.Ry().get(327712, Boolean.FALSE)).booleanValue()) {
                        i = R.string.aoz;
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(327712, Boolean.TRUE);
                        if (i != 0) {
                            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.cgL.yTx.getContext());
                            aVar.asE(this.cgL.yTx.getMMResources().getString(i));
                            aVar.asD(this.cgL.yTx.getMMResources().getString(R.string.ap0));
                            aVar.Qc(R.string.cd_).a(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(31828);
                                    ap apVar = ap.this;
                                    bi biVar = biVar;
                                    menuItem.getGroupId();
                                    ap.a(apVar, biVar, itemId == 125);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(31828);
                                }
                            });
                            aVar.aMb().show();
                        } else {
                            menuItem.getGroupId();
                            d(biVar, itemId == 125);
                        }
                        AppMethodBeat.o(31833);
                        return true;
                    }
                }
                if (itemId == 125) {
                    aw.ZK();
                    if (!((Boolean) com.tencent.mm.model.c.Ry().get(327713, Boolean.FALSE)).booleanValue()) {
                        i = R.string.anw;
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(327713, Boolean.TRUE);
                        if (i != 0) {
                        }
                        AppMethodBeat.o(31833);
                        return true;
                    }
                }
                i = 0;
                if (i != 0) {
                }
                AppMethodBeat.o(31833);
                return true;
            default:
                AppMethodBeat.o(31833);
                return false;
        }
    }

    private void d(bi biVar, boolean z) {
        AppMethodBeat.i(31835);
        if (biVar.dtF() && !z) {
            if (biVar.dtM()) {
                biVar.dtO();
                a(biVar.field_msgId, b.NoTransform);
                com.tencent.mm.modelstat.b.fRa.a(biVar, false);
            } else {
                biVar.dtN();
                a(biVar.field_msgId, b.Transformed);
                com.tencent.mm.modelstat.b.fRa.a(biVar, true);
            }
            aw.ZK();
            com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
        } else if (bl(biVar) == b.Transforming) {
            AppMethodBeat.o(31835);
            return;
        } else {
            th thVar = new th();
            thVar.cPy.cPA = false;
            thVar.cPy.id = biVar.field_msgId;
            thVar.cPy.cPz = biVar.field_content;
            thVar.cPy.cPB = biVar.dJG;
            if (!this.cgL.dFx() || biVar.field_isSend == 1) {
                thVar.cPy.type = 0;
            } else {
                thVar.cPy.type = 1;
            }
            thVar.cPy.source = this.cgL.getTalkerUserName();
            com.tencent.mm.sdk.b.a.xxA.m(thVar);
            a(biVar.field_msgId, b.Transforming);
        }
        this.cgL.aWv();
        AppMethodBeat.o(31835);
    }

    public final void dxC() {
        AppMethodBeat.i(31837);
        dDi();
        AppMethodBeat.o(31837);
    }

    public final void dDh() {
        AppMethodBeat.i(31838);
        super.dDh();
        dDi();
        AppMethodBeat.o(31838);
    }

    public final String bm(bi biVar) {
        AppMethodBeat.i(31834);
        String str = biVar.field_content;
        int i = biVar.field_isSend;
        if (this.cgL.dFw() && str != null && i == 0) {
            str = bf.oz(str);
        }
        AppMethodBeat.o(31834);
        return str;
    }

    public final void dxz() {
        AppMethodBeat.i(31836);
        this.ySW.clear();
        com.tencent.mm.sdk.b.a.xxA.c(this.ySX);
        AppMethodBeat.o(31836);
    }
}
