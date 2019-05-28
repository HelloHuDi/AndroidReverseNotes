package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.ah;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.o;
import com.tencent.mm.ui.chatting.viewitems.ay;
import com.tencent.mm.ui.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c implements OnClickListener, f, t {
    private ProgressDialog ehJ;
    private a yGF;

    public c(a aVar) {
        this.yGF = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(30383);
        String str;
        if (view.getTag() == null) {
            ab.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
            AppMethodBeat.o(30383);
        } else if (view.getTag() instanceof ay) {
            ay ayVar = (ay) view.getTag();
            if (ayVar == null) {
                ab.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                AppMethodBeat.o(30383);
                return;
            }
            str = ayVar.cJM.appId;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (g.bT(str, false) == null) {
                ab.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(str)));
            } else {
                z2 = true;
            }
            if (z2) {
                String oy;
                am.bYM().a(2, (t) this);
                final int i = this.yGF.dFx() ? 2 : 1;
                str = this.yGF.getTalkerUserName();
                if (com.tencent.mm.model.t.kH(str)) {
                    oy = bf.oy(ayVar.cKd.field_content);
                } else {
                    oy = str;
                }
                final b bVar = ayVar.cJM;
                h.d(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(R.string.rj), this.yGF.yTx.getMMResources().getString(R.string.rk), this.yGF.yTx.getMMResources().getString(R.string.c1), this.yGF.yTx.getMMResources().getString(R.string.djq), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(30380);
                        c.a(c.this, new y(2, new ah(bVar.appId, "1")));
                        com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                        if (bDb != null) {
                            c.this.yGF.yTx.getContext();
                            bDb.a(oy, bVar.appId, bVar.type, i, bVar.mediaTagName, 1);
                        }
                        AppMethodBeat.o(30380);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(30381);
                        c.a(c.this, new y(2, new ah(bVar.appId, AppEventsConstants.EVENT_PARAM_VALUE_NO)));
                        com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                        if (bDb != null) {
                            c.this.yGF.yTx.getContext();
                            bDb.a(oy, bVar.appId, bVar.type, i, bVar.mediaTagName, 2);
                        }
                        AppMethodBeat.o(30381);
                    }
                });
                AppMethodBeat.o(30383);
                return;
            }
            AppMethodBeat.o(30383);
        } else {
            if (view.getTag() instanceof o) {
                final o oVar = (o) view.getTag();
                if (oVar == null) {
                    ab.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
                    AppMethodBeat.o(30383);
                    return;
                } else if (oVar == null || bo.isNullOrNil(oVar.fhu) || oVar.cKd == null) {
                    String str2 = "MicroMsg.AppSpamClickListener";
                    str = "wrong args, tag is null ? ";
                    Object[] objArr = new Object[1];
                    if (oVar != null) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    ab.e(str2, str, objArr);
                    AppMethodBeat.o(30383);
                    return;
                } else {
                    h.a(this.yGF.yTx.getContext(), null, new String[]{this.yGF.yTx.getMMResources().getString(R.string.evg), this.yGF.yTx.getMMResources().getString(R.string.evh), this.yGF.yTx.getMMResources().getString(R.string.or)}, null, true, new com.tencent.mm.ui.base.h.c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(30379);
                            switch (i) {
                                case 0:
                                    Intent intent = new Intent();
                                    try {
                                        intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[]{URLEncoder.encode(oVar.svN, "UTF-8"), URLEncoder.encode(oVar.fhu, "UTF-8"), Long.valueOf(oVar.cKd.field_msgSvrId), Integer.valueOf((int) (oVar.cKd.field_createTime / 1000)), Integer.valueOf(42)}));
                                        intent.putExtra("show_bottom", false);
                                        intent.putExtra("showShare", false);
                                        d.b(c.this.yGF.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                        AppMethodBeat.o(30379);
                                        return;
                                    } catch (UnsupportedEncodingException e) {
                                        ab.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", e.getMessage());
                                        AppMethodBeat.o(30379);
                                        return;
                                    }
                                case 1:
                                    ab.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", oVar.svN, oVar.fhu);
                                    aw.Rg().a(1030, c.this);
                                    azo azo = new azo();
                                    azo.vEq = 1;
                                    azo.wDw = oVar.fhu;
                                    azo.Title = "";
                                    LinkedList linkedList = new LinkedList();
                                    linkedList.add(azo);
                                    qi qiVar = new qi();
                                    qiVar.cMy.cKE = oVar.svN;
                                    qiVar.cMy.cMz = linkedList;
                                    if (com.tencent.mm.sdk.b.a.xxA.m(qiVar)) {
                                        c cVar = c.this;
                                        Context context = c.this.yGF.yTx.getContext();
                                        c.this.yGF.yTx.getMMResources().getString(R.string.tz);
                                        cVar.ehJ = h.b(context, c.this.yGF.yTx.getMMResources().getString(R.string.un), true, new OnCancelListener() {
                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(30378);
                                                aw.Rg().b(1030, c.this);
                                                AppMethodBeat.o(30378);
                                            }
                                        });
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(30379);
                        }
                    });
                }
            }
            AppMethodBeat.o(30383);
        }
    }

    public final void a(int i, int i2, String str, x xVar) {
        AppMethodBeat.i(30384);
        ab.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i + ", errCode = " + i2);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        am.bYM().b(2, this);
        if (i == 0 && i2 == 0) {
            h.bQ(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(R.string.c7o));
            AppMethodBeat.o(30384);
        } else if (u.a.a(this.yGF.yTx.getContext(), i, i2, str, 4)) {
            AppMethodBeat.o(30384);
        } else {
            Toast.makeText(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(R.string.c68, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(30384);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(30385);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        aw.Rg().b(1030, (f) this);
        if (i == 0 && i2 == 0) {
            h.bQ(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(R.string.c7o));
            AppMethodBeat.o(30385);
            return;
        }
        Toast.makeText(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(R.string.evi, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.o(30385);
    }
}
