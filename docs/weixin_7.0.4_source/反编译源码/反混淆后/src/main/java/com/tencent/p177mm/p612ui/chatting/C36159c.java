package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42043qi;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5366o;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40814ay;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C14887t;
import com.tencent.p177mm.pluginsdk.model.app.C40442x;
import com.tencent.p177mm.pluginsdk.model.app.C41336ah;
import com.tencent.p177mm.pluginsdk.model.app.C44061y;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.azo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.c */
public final class C36159c implements OnClickListener, C1202f, C14887t {
    private ProgressDialog ehJ;
    private C46650a yGF;

    public C36159c(C46650a c46650a) {
        this.yGF = c46650a;
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(30383);
        String str;
        if (view.getTag() == null) {
            C4990ab.m7412e("MicroMsg.AppSpamClickListener", "onClick tag is null");
            AppMethodBeat.m2505o(30383);
        } else if (view.getTag() instanceof C40814ay) {
            C40814ay c40814ay = (C40814ay) view.getTag();
            if (c40814ay == null) {
                C4990ab.m7412e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                AppMethodBeat.m2505o(30383);
                return;
            }
            str = c40814ay.cJM.appId;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (C46494g.m87739bT(str, false) == null) {
                C4990ab.m7412e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(str)));
            } else {
                z2 = true;
            }
            if (z2) {
                String oy;
                C14877am.bYM().mo27202a(2, (C14887t) this);
                final int i = this.yGF.dFx() ? 2 : 1;
                str = this.yGF.getTalkerUserName();
                if (C1855t.m3896kH(str)) {
                    oy = C1829bf.m3762oy(c40814ay.cKd.field_content);
                } else {
                    oy = str;
                }
                final C8910b c8910b = c40814ay.cJM;
                C30379h.m48466d(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(C25738R.string.f9165rj), this.yGF.yTx.getMMResources().getString(C25738R.string.f9166rk), this.yGF.yTx.getMMResources().getString(C25738R.string.f8686c1), this.yGF.yTx.getMMResources().getString(C25738R.string.djq), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(30380);
                        C36159c.m59518a(C36159c.this, new C44061y(2, new C41336ah(c8910b.appId, "1")));
                        C43155a bDb = C20928a.bDb();
                        if (bDb != null) {
                            C36159c.this.yGF.yTx.getContext();
                            bDb.mo36275a(oy, c8910b.appId, c8910b.type, i, c8910b.mediaTagName, 1);
                        }
                        AppMethodBeat.m2505o(30380);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(30381);
                        C36159c.m59518a(C36159c.this, new C44061y(2, new C41336ah(c8910b.appId, AppEventsConstants.EVENT_PARAM_VALUE_NO)));
                        C43155a bDb = C20928a.bDb();
                        if (bDb != null) {
                            C36159c.this.yGF.yTx.getContext();
                            bDb.mo36275a(oy, c8910b.appId, c8910b.type, i, c8910b.mediaTagName, 2);
                        }
                        AppMethodBeat.m2505o(30381);
                    }
                });
                AppMethodBeat.m2505o(30383);
                return;
            }
            AppMethodBeat.m2505o(30383);
        } else {
            if (view.getTag() instanceof C5366o) {
                final C5366o c5366o = (C5366o) view.getTag();
                if (c5366o == null) {
                    C4990ab.m7412e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
                    AppMethodBeat.m2505o(30383);
                    return;
                } else if (c5366o == null || C5046bo.isNullOrNil(c5366o.fhu) || c5366o.cKd == null) {
                    String str2 = "MicroMsg.AppSpamClickListener";
                    str = "wrong args, tag is null ? ";
                    Object[] objArr = new Object[1];
                    if (c5366o != null) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    C4990ab.m7413e(str2, str, objArr);
                    AppMethodBeat.m2505o(30383);
                    return;
                } else {
                    C30379h.m48424a(this.yGF.yTx.getContext(), null, new String[]{this.yGF.yTx.getMMResources().getString(C25738R.string.evg), this.yGF.yTx.getMMResources().getString(C25738R.string.evh), this.yGF.yTx.getMMResources().getString(C25738R.string.f9076or)}, null, true, new C30391c() {

                        /* renamed from: com.tencent.mm.ui.chatting.c$1$1 */
                        class C361241 implements OnCancelListener {
                            C361241() {
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(30378);
                                C9638aw.m17182Rg().mo14546b(1030, C36159c.this);
                                AppMethodBeat.m2505o(30378);
                            }
                        }

                        /* renamed from: iE */
                        public final void mo7700iE(int i) {
                            AppMethodBeat.m2504i(30379);
                            switch (i) {
                                case 0:
                                    Intent intent = new Intent();
                                    try {
                                        intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[]{URLEncoder.encode(c5366o.svN, "UTF-8"), URLEncoder.encode(c5366o.fhu, "UTF-8"), Long.valueOf(c5366o.cKd.field_msgSvrId), Integer.valueOf((int) (c5366o.cKd.field_createTime / 1000)), Integer.valueOf(42)}));
                                        intent.putExtra("show_bottom", false);
                                        intent.putExtra("showShare", false);
                                        C25985d.m41467b(C36159c.this.yGF.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                        AppMethodBeat.m2505o(30379);
                                        return;
                                    } catch (UnsupportedEncodingException e) {
                                        C4990ab.m7413e("MicroMsg.AppSpamClickListener", "exception in expore, %s", e.getMessage());
                                        AppMethodBeat.m2505o(30379);
                                        return;
                                    }
                                case 1:
                                    C4990ab.m7411d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", c5366o.svN, c5366o.fhu);
                                    C9638aw.m17182Rg().mo14539a(1030, C36159c.this);
                                    azo azo = new azo();
                                    azo.vEq = 1;
                                    azo.wDw = c5366o.fhu;
                                    azo.Title = "";
                                    LinkedList linkedList = new LinkedList();
                                    linkedList.add(azo);
                                    C42043qi c42043qi = new C42043qi();
                                    c42043qi.cMy.cKE = c5366o.svN;
                                    c42043qi.cMy.cMz = linkedList;
                                    if (C4879a.xxA.mo10055m(c42043qi)) {
                                        C36159c c36159c = C36159c.this;
                                        Context context = C36159c.this.yGF.yTx.getContext();
                                        C36159c.this.yGF.yTx.getMMResources().getString(C25738R.string.f9238tz);
                                        c36159c.ehJ = C30379h.m48458b(context, C36159c.this.yGF.yTx.getMMResources().getString(C25738R.string.f9260un), true, new C361241());
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.m2505o(30379);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(30383);
        }
    }

    /* renamed from: a */
    public final void mo9876a(int i, int i2, String str, C40442x c40442x) {
        AppMethodBeat.m2504i(30384);
        C4990ab.m7410d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i + ", errCode = " + i2);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        C14877am.bYM().mo27203b(2, this);
        if (i == 0 && i2 == 0) {
            C30379h.m48465bQ(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(C25738R.string.c7o));
            AppMethodBeat.m2505o(30384);
        } else if (C30784a.m49123a(this.yGF.yTx.getContext(), i, i2, str, 4)) {
            AppMethodBeat.m2505o(30384);
        } else {
            Toast.makeText(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(C25738R.string.c68, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(30384);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(30385);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        C9638aw.m17182Rg().mo14546b(1030, (C1202f) this);
        if (i == 0 && i2 == 0) {
            C30379h.m48465bQ(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(C25738R.string.c7o));
            AppMethodBeat.m2505o(30385);
            return;
        }
        Toast.makeText(this.yGF.yTx.getContext(), this.yGF.yTx.getMMResources().getString(C25738R.string.evi, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.m2505o(30385);
    }
}
