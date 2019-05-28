package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.af.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.io.IOException;

public abstract class h extends v implements a {
    protected OnClickListener pLd = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(1713);
            h.this.ek(view);
            AppMethodBeat.o(1713);
        }
    };
    public chw sAX;
    public b sDN;
    private boolean sDO;

    public abstract f cGA();

    public abstract void cGz();

    public abstract View getWowView();

    public h(View view, b bVar) {
        super(view);
        this.sDN = bVar;
        ej(view);
    }

    public void ej(View view) {
    }

    public void cFO() {
        this.sDN.cFO();
    }

    public void cFN() {
        this.sDN.cFN();
    }

    public boolean cGy() {
        return false;
    }

    public final void c(chw chw) {
        this.sAX = chw;
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", chw.title);
        cGz();
    }

    public void mc(boolean z) {
        this.sDN.cGe();
    }

    /* Access modifiers changed, original: protected */
    public void ek(View view) {
        if (this.sDN.cFY() != cFP()) {
            this.sDN.cFR().sFo = 2;
            this.sDN.FC(cFP());
            a.kT(4);
            this.sDN.cFR().f(this.sAX);
            ((b) g.M(b.class)).getReporter().a(this.sDN.cFT(), this.sAX, cFP(), 2, "");
            return;
        }
        el(view);
        if (cGy()) {
            cFO();
            this.sDN.cFO();
            cFN();
            this.sDN.cFN();
        }
    }

    public void el(View view) {
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(b bVar, Context context, f fVar, int i) {
        chw FL = bVar.cGg().FL(i);
        ((b) g.M(b.class)).getReporter().a(bVar.cFT(), FL, i, 5, "");
        if (FL != null) {
            if (this.sDN.cFV().cGZ()) {
                this.sDN.cFV().cpN();
                this.sDO = true;
            }
            d dVar = new d(context, 1, false);
            dVar.rBl = new c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(1714);
                    lVar.ax(0, R.string.f1u, R.raw.bottomsheet_icon_moment);
                    lVar.ax(1, R.string.f1t, R.raw.bottomsheet_icon_transmit);
                    AppMethodBeat.o(1714);
                }
            };
            final f fVar2 = fVar;
            final Context context2 = context;
            final chw chw = FL;
            final b bVar2 = bVar;
            final int i2 = i;
            dVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(1715);
                    if (h.this.sDO) {
                        h.this.sDN.cFV().cEf();
                        h.this.sDO = false;
                    }
                    h.this.sDN.cGc();
                    p pVar;
                    Context context;
                    chw chw;
                    chv cFT;
                    if (menuItem.getItemId() == 0) {
                        fVar2.cGw();
                        pVar = p.sFq;
                        context = context2;
                        chw = chw;
                        cFT = bVar2.cFT();
                        if (!(chw == null || cFT == null)) {
                            byte[] toByteArray;
                            pVar.sFr = chw;
                            Intent intent = new Intent();
                            intent.putExtra("Ksnsupload_title", chw.lvA);
                            intent.putExtra("Ksnsupload_imgurl", chw.uaf);
                            intent.putExtra("Ksnsupload_link", chw.lvz);
                            intent.putExtra("KContentObjDesc", bo.isNullOrNil(chw.qVw) ? context.getString(R.string.dj6) : chw.qVw);
                            intent.putExtra("KlinkThumb_url", chw.uaf);
                            intent.putExtra("Ksnsupload_source", 1);
                            intent.putExtra("Ksnsupload_type", 16);
                            intent.putExtra("need_result", true);
                            cvi cvi = new cvi();
                            cvi.uaa = chw.xgS;
                            cvi.uab = chw.xgV;
                            cvi.uac = cFT.hlm;
                            cvi.uad = chw.xgU;
                            cvi.uae = 100201;
                            cvi.lvz = chw.lvz;
                            cvi.lvA = chw.lvA;
                            cvi.qVw = chw.qVw;
                            cvi.uaf = chw.uaf;
                            cvi.uag = chw.uag;
                            cvi.uah = chw.uah;
                            cvi.source = chw.source;
                            cvi.phw = chw.phw;
                            cvi.uai = chw.uai;
                            cvi.uaj = chw.uaj;
                            cvi.uak = p.dO(cFT.tZG).toString();
                            cvi.ual = com.tencent.mm.plugin.topstory.a.g.dN(chw.wiH).toString();
                            cvi.uam = chw.xhe;
                            cvi.thumbUrl = chw.xgQ;
                            if (p.g(chw) && cFT.xgI != null) {
                                cvi.uan = cFT.xgI.title;
                            }
                            try {
                                toByteArray = cvi.toByteArray();
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", e, "", new Object[0]);
                                toByteArray = null;
                            }
                            if (toByteArray != null) {
                                intent.putExtra("KWebSearchInfo", toByteArray);
                            }
                            com.tencent.mm.bp.d.b(context, "sns", ".ui.SnsUploadUI", intent, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        }
                        ((b) g.M(b.class)).getReporter().a(bVar2.cFT(), chw, i2, 7, "");
                        AppMethodBeat.o(1715);
                        return;
                    }
                    if (menuItem.getItemId() == 1) {
                        fVar2.cGw();
                        pVar = p.sFq;
                        context = context2;
                        chw = chw;
                        cFT = bVar2.cFT();
                        pVar.sFr = chw;
                        j.b bVar = new j.b();
                        bVar.type = 5;
                        bVar.title = chw.lvA;
                        bVar.description = bo.isNullOrNil(chw.qVw) ? context.getString(R.string.dj6) : chw.qVw;
                        bVar.url = chw.lvz;
                        bVar.thumburl = chw.uaf;
                        f abVar = new com.tencent.mm.plugin.websearch.api.ab();
                        abVar.uaa = chw.xgS;
                        abVar.uab = chw.xgV;
                        abVar.uac = cFT.hlm;
                        abVar.uad = chw.xgU;
                        abVar.uae = 100201;
                        abVar.lvz = chw.lvz;
                        abVar.lvA = chw.lvA;
                        abVar.qVw = chw.qVw;
                        abVar.uaf = chw.uaf;
                        abVar.uag = chw.uag;
                        abVar.uah = chw.uah;
                        abVar.source = chw.source;
                        abVar.phw = chw.phw;
                        abVar.uai = chw.uai;
                        abVar.uaj = chw.uaj;
                        abVar.uak = p.dO(cFT.tZG).toString();
                        abVar.ual = com.tencent.mm.plugin.topstory.a.g.dN(chw.wiH).toString();
                        abVar.uam = chw.xhe;
                        abVar.thumbUrl = chw.xgQ;
                        if (p.g(chw) && cFT.xgI != null) {
                            abVar.uan = cFT.xgI.title;
                        }
                        bVar.a(abVar);
                        String a = j.b.a(bVar, null, null);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_Msg_Type", 2);
                        intent2.putExtra("Retr_Msg_content", a);
                        intent2.putExtra("Multi_Retr", true);
                        intent2.putExtra("Retr_go_to_chattingUI", false);
                        intent2.putExtra("Retr_show_success_tips", true);
                        com.tencent.mm.bp.d.b(context, ".ui.transmit.MsgRetransmitUI", intent2, 2048);
                        ((b) g.M(b.class)).getReporter().a(bVar2.cFT(), chw, i2, 6, "");
                    }
                    AppMethodBeat.o(1715);
                }
            };
            dVar.zQf = new d.a() {
                public final void onDismiss() {
                    AppMethodBeat.i(1716);
                    if (h.this.sDO) {
                        h.this.sDN.cFV().cEf();
                        h.this.sDO = false;
                    }
                    h.this.sDN.cGc();
                    AppMethodBeat.o(1716);
                }
            };
            dVar.cpD();
        }
    }

    public int cFP() {
        return kj() - this.sDN.cGa().getHeadersCount();
    }
}
