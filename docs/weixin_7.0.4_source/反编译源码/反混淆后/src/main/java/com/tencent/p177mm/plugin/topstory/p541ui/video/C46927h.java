package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.websearch.api.C14420ab;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.cvi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.h */
public abstract class C46927h extends C41531v implements C46304a {
    protected OnClickListener pLd = new C399841();
    public chw sAX;
    public C4232b sDN;
    private boolean sDO;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.h$2 */
    class C224172 implements C36073c {
        C224172() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(1714);
            c44273l.mo70063ax(0, C25738R.string.f1u, C1318a.bottomsheet_icon_moment);
            c44273l.mo70063ax(1, C25738R.string.f1t, C1318a.bottomsheet_icon_transmit);
            AppMethodBeat.m2505o(1714);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.h$4 */
    class C224194 implements C15994a {
        C224194() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(1716);
            if (C46927h.this.sDO) {
                C46927h.this.sDN.cFV().cEf();
                C46927h.this.sDO = false;
            }
            C46927h.this.sDN.cGc();
            AppMethodBeat.m2505o(1716);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.h$1 */
    class C399841 implements OnClickListener {
        C399841() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1713);
            C46927h.this.mo76166ek(view);
            AppMethodBeat.m2505o(1713);
        }
    }

    public abstract C35305f cGA();

    public abstract void cGz();

    public abstract View getWowView();

    public C46927h(View view, C4232b c4232b) {
        super(view);
        this.sDN = c4232b;
        mo47705ej(view);
    }

    /* renamed from: ej */
    public void mo47705ej(View view) {
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

    /* renamed from: c */
    public final void mo76164c(chw chw) {
        this.sAX = chw;
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", chw.title);
        cGz();
    }

    /* renamed from: mc */
    public void mo47707mc(boolean z) {
        this.sDN.cGe();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: ek */
    public void mo76166ek(View view) {
        if (this.sDN.cFY() != cFP()) {
            this.sDN.cFR().sFo = 2;
            this.sDN.mo9157FC(cFP());
            C14419a.m22633kT(4);
            this.sDN.cFR().mo74507f(this.sAX);
            ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(this.sDN.cFT(), this.sAX, cFP(), 2, "");
            return;
        }
        mo76167el(view);
        if (cGy()) {
            cFO();
            this.sDN.cFO();
            cFN();
            this.sDN.cFN();
        }
    }

    /* renamed from: el */
    public void mo76167el(View view) {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo76163a(C4232b c4232b, Context context, C35305f c35305f, int i) {
        chw FL = c4232b.cGg().mo26218FL(i);
        ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(c4232b.cFT(), FL, i, 5, "");
        if (FL != null) {
            if (this.sDN.cFV().cGZ()) {
                this.sDN.cFV().cpN();
                this.sDO = true;
            }
            C36356d c36356d = new C36356d(context, 1, false);
            c36356d.rBl = new C224172();
            final C35305f c35305f2 = c35305f;
            final Context context2 = context;
            final chw chw = FL;
            final C4232b c4232b2 = c4232b;
            final int i2 = i;
            c36356d.rBm = new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(1715);
                    if (C46927h.this.sDO) {
                        C46927h.this.sDN.cFV().cEf();
                        C46927h.this.sDO = false;
                    }
                    C46927h.this.sDN.cGc();
                    C39991p c39991p;
                    Context context;
                    chw chw;
                    chv cFT;
                    if (menuItem.getItemId() == 0) {
                        c35305f2.cGw();
                        c39991p = C39991p.sFq;
                        context = context2;
                        chw = chw;
                        cFT = c4232b2.cFT();
                        if (!(chw == null || cFT == null)) {
                            byte[] toByteArray;
                            c39991p.sFr = chw;
                            Intent intent = new Intent();
                            intent.putExtra("Ksnsupload_title", chw.lvA);
                            intent.putExtra("Ksnsupload_imgurl", chw.uaf);
                            intent.putExtra("Ksnsupload_link", chw.lvz);
                            intent.putExtra("KContentObjDesc", C5046bo.isNullOrNil(chw.qVw) ? context.getString(C25738R.string.dj6) : chw.qVw);
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
                            cvi.uak = C39991p.m68487dO(cFT.tZG).toString();
                            cvi.ual = C39964g.m68434dN(chw.wiH).toString();
                            cvi.uam = chw.xhe;
                            cvi.thumbUrl = chw.xgQ;
                            if (C39991p.m68488g(chw) && cFT.xgI != null) {
                                cvi.uan = cFT.xgI.title;
                            }
                            try {
                                toByteArray = cvi.toByteArray();
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", e, "", new Object[0]);
                                toByteArray = null;
                            }
                            if (toByteArray != null) {
                                intent.putExtra("KWebSearchInfo", toByteArray);
                            }
                            C25985d.m41468b(context, "sns", ".ui.SnsUploadUI", intent, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        }
                        ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(c4232b2.cFT(), chw, i2, 7, "");
                        AppMethodBeat.m2505o(1715);
                        return;
                    }
                    if (menuItem.getItemId() == 1) {
                        c35305f2.cGw();
                        c39991p = C39991p.sFq;
                        context = context2;
                        chw = chw;
                        cFT = c4232b2.cFT();
                        c39991p.sFr = chw;
                        C8910b c8910b = new C8910b();
                        c8910b.type = 5;
                        c8910b.title = chw.lvA;
                        c8910b.description = C5046bo.isNullOrNil(chw.qVw) ? context.getString(C25738R.string.dj6) : chw.qVw;
                        c8910b.url = chw.lvz;
                        c8910b.thumburl = chw.uaf;
                        C37435f c14420ab = new C14420ab();
                        c14420ab.uaa = chw.xgS;
                        c14420ab.uab = chw.xgV;
                        c14420ab.uac = cFT.hlm;
                        c14420ab.uad = chw.xgU;
                        c14420ab.uae = 100201;
                        c14420ab.lvz = chw.lvz;
                        c14420ab.lvA = chw.lvA;
                        c14420ab.qVw = chw.qVw;
                        c14420ab.uaf = chw.uaf;
                        c14420ab.uag = chw.uag;
                        c14420ab.uah = chw.uah;
                        c14420ab.source = chw.source;
                        c14420ab.phw = chw.phw;
                        c14420ab.uai = chw.uai;
                        c14420ab.uaj = chw.uaj;
                        c14420ab.uak = C39991p.m68487dO(cFT.tZG).toString();
                        c14420ab.ual = C39964g.m68434dN(chw.wiH).toString();
                        c14420ab.uam = chw.xhe;
                        c14420ab.thumbUrl = chw.xgQ;
                        if (C39991p.m68488g(chw) && cFT.xgI != null) {
                            c14420ab.uan = cFT.xgI.title;
                        }
                        c8910b.mo20334a(c14420ab);
                        String a = C8910b.m16061a(c8910b, null, null);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_Msg_Type", 2);
                        intent2.putExtra("Retr_Msg_content", a);
                        intent2.putExtra("Multi_Retr", true);
                        intent2.putExtra("Retr_go_to_chattingUI", false);
                        intent2.putExtra("Retr_show_success_tips", true);
                        C25985d.m41466b(context, ".ui.transmit.MsgRetransmitUI", intent2, 2048);
                        ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(c4232b2.cFT(), chw, i2, 6, "");
                    }
                    AppMethodBeat.m2505o(1715);
                }
            };
            c36356d.zQf = new C224194();
            c36356d.cpD();
        }
    }

    public int cFP() {
        return mo66454kj() - this.sDN.cGa().getHeadersCount();
    }
}
