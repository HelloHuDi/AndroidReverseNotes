package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.aw.g;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.se;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;

public final class bc {
    Context context;
    int cvd = 0;
    long iYa = 0;
    public OnClickListener rDA = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39863);
            boolean z = view.getTag() instanceof q;
            ab.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(z)));
            if (z) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (bc.Wi(timeLineObject.Id)) {
                    h.pYm.X(10231, "1");
                    com.tencent.mm.aw.a.aic();
                } else if (!(com.tencent.mm.r.a.bJ(bc.this.context) || com.tencent.mm.r.a.bH(bc.this.context))) {
                    h.pYm.X(10090, "1,0");
                    if (timeLineObject.xfI.wbK.size() > 0) {
                        b lY;
                        String str;
                        bau bau = (bau) timeLineObject.xfI.wbK.get(0);
                        if (bc.this.cvd == 0) {
                            lY = b.lY(738);
                        } else {
                            lY = b.lZ(738);
                        }
                        b tx = lY.tx(timeLineObject.Id).tx(timeLineObject.jBB);
                        if (timeLineObject.xfH == null) {
                            str = "";
                        } else {
                            str = timeLineObject.xfH.Id;
                        }
                        tx.tx(str).tx(bau.Title).tx(bau.Desc).tx("");
                        lY.ajK();
                    }
                    if (qVar.rio) {
                        com.tencent.mm.aw.a.a(g.a(af.getAccPath(), timeLineObject, 9));
                    } else {
                        com.tencent.mm.aw.a.b(g.a(af.getAccPath(), timeLineObject, 1));
                    }
                }
                if (bc.this.rDr != null) {
                    bc.this.rDr.ctb();
                }
                AppMethodBeat.o(39863);
                return;
            }
            AppMethodBeat.o(39863);
        }
    };
    public OnClickListener rDB = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39864);
            ab.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                n YT = af.cnF().YT(qVar.cwT);
                if (bc.this.rhQ != null) {
                    bc.this.rhQ.cnj().x(YT);
                }
                if (timeLineObject.xfO == null) {
                    ab.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                    AppMethodBeat.o(39864);
                    return;
                }
                String str = timeLineObject.xfO.username;
                String str2 = timeLineObject.xfO.path;
                ab.i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
                se seVar = new se();
                seVar.cOf.userName = str;
                seVar.cOf.cOh = str2;
                seVar.cOf.scene = 1009;
                seVar.cOf.cst = timeLineObject.Id + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + timeLineObject.jBB;
                Bundle bundle = new Bundle();
                bundle.putString("stat_send_msg_user", YT.field_userName);
                bundle.putString("stat_msg_id", "sns_" + i.jV(YT.field_snsId));
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                AppMethodBeat.o(39864);
                return;
            }
            AppMethodBeat.o(39864);
        }
    };
    public OnClickListener rDC = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39865);
            ab.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (view.getTag() instanceof TimeLineObject) {
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (timeLineObject.xfO == null) {
                    ab.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                    AppMethodBeat.o(39865);
                    return;
                }
                String str = timeLineObject.xfO.username;
                se seVar = new se();
                ab.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(str)));
                seVar.cOf.userName = str;
                seVar.cOf.scene = 1009;
                seVar.cOf.cst = timeLineObject.Id + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + timeLineObject.jBB;
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                AppMethodBeat.o(39865);
                return;
            }
            AppMethodBeat.o(39865);
        }
    };
    public OnClickListener rDD = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39866);
            ab.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_product_scene", 2);
                    intent.putExtra("key_product_info", str);
                    d.b(bc.this.context, "product", ".ui.MallProductUI", intent);
                }
                AppMethodBeat.o(39866);
                return;
            }
            AppMethodBeat.o(39866);
        }
    };
    public OnClickListener rDE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39867);
            ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 12);
                    if (TextUtils.isEmpty(str)) {
                        ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                    } else {
                        String[] split = str.split("#");
                        if (split.length >= 2) {
                            ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                            intent.putExtra("key_card_id", split[0]);
                            intent.putExtra("key_card_ext", split[1]);
                            d.b(bc.this.context, "card", ".ui.CardDetailUI", intent);
                            AppMethodBeat.o(39867);
                            return;
                        } else if (split.length == 1) {
                            ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                            ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(str)));
                            intent.putExtra("key_card_id", split[0]);
                            intent.putExtra("key_card_ext", "");
                            d.b(bc.this.context, "card", ".ui.CardDetailUI", intent);
                            AppMethodBeat.o(39867);
                            return;
                        } else {
                            ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                            ab.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(str)));
                            AppMethodBeat.o(39867);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(39867);
                return;
            }
            AppMethodBeat.o(39867);
        }
    };
    public OnClickListener rDF = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39868);
            ab.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                if (qVar.rin.xfI.wbJ == 26) {
                    if (bo.isNullOrNil(qVar.rin.xfI.wbM)) {
                        AppMethodBeat.o(39868);
                        return;
                    }
                    gh ghVar = new gh();
                    ghVar.cAH.type = 37;
                    ghVar.cAH.desc = qVar.rin.xfI.wbM;
                    String str = "";
                    if (qVar.rin.xfI.wbK != null && qVar.rin.xfI.wbK.size() > 0) {
                        String fZ = an.fZ(af.getAccSnsPath(), ((bau) qVar.rin.xfI.wbK.get(0)).Id);
                        str = i.e((bau) qVar.rin.xfI.wbK.get(0));
                        str = e.ct(new StringBuilder().append(fZ).append(str).toString()) ? fZ + str : "";
                    }
                    ghVar.cAH.path = str;
                    ghVar.cAH.title = qVar.cwT;
                    ghVar.cAH.context = bc.this.context;
                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                }
            }
            AppMethodBeat.o(39868);
        }
    };
    a rDr;
    public OnClickListener rDs = new OnClickListener() {
        public final void onClick(View view) {
            boolean z;
            String str;
            AppMethodBeat.i(39869);
            bc bcVar = bc.this;
            if (view == null || !(view.getTag() instanceof TimeLineObject)) {
                z = true;
            } else {
                str = ((TimeLineObject) view.getTag()).xfH.Id;
                Intent intent;
                if ("wx485a97c844086dc9".equals(str)) {
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                    z = true;
                } else if ("wx7fa037cc7dfabad5".equals(str)) {
                    com.tencent.mm.plugin.sport.a.d.kT(34);
                    com.tencent.mm.kernel.g.RQ();
                    if (com.tencent.mm.n.a.jh(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        d.f(bcVar.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        d.b(bcVar.context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    z = true;
                } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                    ab.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else if ("wx751a1acca5688ba3".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 5);
                    if (!(com.tencent.mm.r.a.bI(bcVar.context) || com.tencent.mm.r.a.bH(bcVar.context))) {
                        d.b(bcVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wxfbc915ff7c30e335".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    if (!(com.tencent.mm.r.a.bI(bcVar.context) || com.tencent.mm.r.a.bH(bcVar.context))) {
                        d.b(bcVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wx482a4001c37e2b74".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 2);
                    if (!(com.tencent.mm.r.a.bI(bcVar.context) || com.tencent.mm.r.a.bH(bcVar.context))) {
                        d.b(bcVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if (!"wxaf060266bfa9a35c".equals(str)) {
                    z = false;
                } else if (com.tencent.mm.aw.d.aim()) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    d.b(bcVar.context, "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z) {
                if (view == null || !(view.getTag() instanceof TimeLineObject)) {
                    AppMethodBeat.o(39869);
                    return;
                }
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (timeLineObject == null || timeLineObject.xfH == null) {
                    ab.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                    AppMethodBeat.o(39869);
                    return;
                }
                String str2 = timeLineObject.xfH.Id;
                String df = com.tencent.mm.plugin.sns.c.a.gkF.df(str2);
                if (bo.isNullOrNil(df)) {
                    str = com.tencent.mm.plugin.sns.c.a.gkF.f(bc.this.context, str2, "timeline");
                    if (str == null || str.length() == 0) {
                        AppMethodBeat.o(39869);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("shortUrl", str);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("type", -255);
                    intent2.putExtra("geta8key_scene", 2);
                    com.tencent.mm.plugin.sns.c.a.gkE.i(intent2, bc.this.context);
                } else {
                    int i;
                    String str3 = timeLineObject == null ? null : timeLineObject.jBB;
                    if (timeLineObject.xfI.wbJ == 1) {
                        i = 2;
                    } else if (timeLineObject.xfI.wbJ == 3) {
                        i = 5;
                    } else {
                        i = 2;
                    }
                    String str4 = null;
                    if (!(timeLineObject.qNO == null || timeLineObject.qNO.vCy == null)) {
                        str4 = timeLineObject.qNO.vCy.vCs;
                    }
                    ok okVar = new ok();
                    okVar.cKI.context = bc.this.context;
                    okVar.cKI.scene = 4;
                    okVar.cKI.csB = str2;
                    okVar.cKI.packageName = df;
                    okVar.cKI.msgType = i;
                    okVar.cKI.cEV = str3;
                    okVar.cKI.mediaTagName = str4;
                    okVar.cKI.cKJ = 5;
                    okVar.cKI.cKK = 0;
                    okVar.cKI.cKL = timeLineObject.Id;
                    com.tencent.mm.sdk.b.a.xxA.m(okVar);
                    gt gtVar = new gt();
                    gtVar.cBv.actionCode = 2;
                    gtVar.cBv.scene = 3;
                    gtVar.cBv.extMsg = "timeline_src=3";
                    gtVar.cBv.appId = str2;
                    gtVar.cBv.context = bc.this.context;
                    com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                    AppMethodBeat.o(39869);
                    return;
                }
            }
            AppMethodBeat.o(39869);
        }
    };
    public OnClickListener rDt = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39872);
            if (view.getTag() instanceof az) {
                final az azVar = (az) view.getTag();
                if (bo.isNullOrNil(azVar.rDc)) {
                    ab.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                    Toast.makeText(bc.this.context, bc.this.context.getString(R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                    AppMethodBeat.o(39872);
                    return;
                }
                com.tencent.mm.kernel.g.RQ();
                ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(azVar.rDc);
                if (aoO == null || !aoO.field_username.equals(azVar.rDc)) {
                    com.tencent.mm.model.ao.a.flu.a(azVar.rDc, "", new com.tencent.mm.model.ao.b.a() {
                        public final void o(String str, boolean z) {
                            AppMethodBeat.i(39870);
                            if (bc.this.tipDialog != null) {
                                bc.this.tipDialog.dismiss();
                            }
                            if (z) {
                                com.tencent.mm.ah.b.U(str, 3);
                                o.acv().pZ(str);
                                Intent intent = new Intent();
                                intent.addFlags(268435456);
                                intent.putExtra("Contact_User", str);
                                intent.putExtra("Contact_Scene", 37);
                                com.tencent.mm.kernel.g.RQ();
                                ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
                                if (aoO != null && aoO.dsf()) {
                                    h.pYm.X(10298, str + ",37");
                                    intent.putExtra("Contact_Scene", 37);
                                }
                                com.tencent.mm.plugin.sns.c.a.gkE.c(intent, bc.this.context);
                                AppMethodBeat.o(39870);
                                return;
                            }
                            Toast.makeText(bc.this.context, bc.this.context.getString(R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                            AppMethodBeat.o(39870);
                        }
                    });
                    bc bcVar = bc.this;
                    Context context = bc.this.context;
                    bc.this.context.getString(R.string.tz);
                    bcVar.tipDialog = com.tencent.mm.ui.base.h.b(context, bc.this.context.getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(39871);
                            com.tencent.mm.model.ao.a.flu.or(azVar.rDc);
                            AppMethodBeat.o(39871);
                        }
                    });
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.putExtra("Contact_User", azVar.rDc);
                    h.pYm.X(10298, azVar.rDc + ",37");
                    intent.putExtra("Contact_Scene", 37);
                    com.tencent.mm.plugin.sns.c.a.gkE.c(intent, bc.this.context);
                    AppMethodBeat.o(39872);
                    return;
                }
            }
            AppMethodBeat.o(39872);
        }
    };
    public OnClickListener rDu = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39873);
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_Product_xml", str);
                    intent.putExtra("key_ProductUI_getProductInfoScene", 2);
                    d.b(view.getContext(), "scanner", ".ui.ProductUI", intent);
                }
                AppMethodBeat.o(39873);
                return;
            }
            AppMethodBeat.o(39873);
        }
    };
    public OnClickListener rDv = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39874);
            ab.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_TV_xml", str);
                    intent.putExtra("key_TV_getProductInfoScene", 2);
                    d.b(view.getContext(), "shake", ".ui.TVInfoUI", intent);
                }
                AppMethodBeat.o(39874);
                return;
            }
            AppMethodBeat.o(39874);
        }
    };
    public OnClickListener rDw = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39875);
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("preceding_scence", 10);
                    intent.putExtra("download_entrance_scene", 13);
                    d.b(view.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
                AppMethodBeat.o(39875);
                return;
            }
            AppMethodBeat.o(39875);
        }
    };
    public OnClickListener rDx = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39876);
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    d.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
                }
                AppMethodBeat.o(39876);
                return;
            }
            AppMethodBeat.o(39876);
        }
    };
    public OnClickListener rDy = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39877);
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    d.b(view.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                }
                AppMethodBeat.o(39877);
                return;
            }
            AppMethodBeat.o(39877);
        }
    };
    public OnClickListener rDz = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39878);
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    n YT = af.cnF().YT(qVar.cwT);
                    if (bc.this.rhQ != null) {
                        bc.this.rhQ.cnj().x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    d.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                }
                AppMethodBeat.o(39878);
                return;
            }
            AppMethodBeat.o(39878);
        }
    };
    ae rhQ;
    public OnClickListener rvD = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39862);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bc.this.iYa < 500) {
                AppMethodBeat.o(39862);
                return;
            }
            bc.this.iYa = currentTimeMillis;
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                TimeLineObject timeLineObject = qVar.rin;
                n YT = af.cnF().YT(qVar.cwT);
                if (bc.this.rhQ != null) {
                    bc.this.rhQ.cnj().x(YT);
                }
                bau bau;
                String B;
                if (timeLineObject.xfI.wbJ == 18) {
                    bc bcVar = bc.this;
                    Context context = bc.this.context;
                    TimeLineObject timeLineObject2 = qVar.rin;
                    com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.b.AdUrl, com.tencent.mm.plugin.sns.a.b.j.a.EnterCompleteVideo, af.cnF().YT(qVar.cwT), bcVar.cvd);
                    Intent intent = new Intent();
                    bau = null;
                    if (timeLineObject2.xfI.wbK.size() > 0) {
                        bau = (bau) timeLineObject2.xfI.wbK.get(0);
                    }
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", timeLineObject2.xfI.Url);
                    intent.putExtra("KSta_SourceType", 2);
                    intent.putExtra("KSta_Scene", com.tencent.mm.plugin.sns.a.b.j.b.AdUrl.value);
                    intent.putExtra("KSta_FromUserName", timeLineObject2.jBB);
                    intent.putExtra("KSta_SnSId", timeLineObject2.Id);
                    if (bau == null) {
                        intent.putExtra("KMediaId", "fakeid_" + (bau == null ? timeLineObject2.Id : bau.Id));
                    } else {
                        intent.putExtra("KMediaId", bau.Id);
                    }
                    cfg cfg = timeLineObject2.xfN;
                    if (cfg != null) {
                        intent.putExtra("KMediaVideoTime", cfg.fiH);
                        intent.putExtra("StreamWording", cfg.fiJ);
                        intent.putExtra("StremWebUrl", cfg.fiK);
                        intent.putExtra("KMediaTitle", cfg.fiI);
                        intent.putExtra("KStremVideoUrl", cfg.fiG);
                        intent.putExtra("KThumUrl", cfg.fiL);
                        intent.putExtra("KSta_StremVideoAduxInfo", cfg.fiM);
                        intent.putExtra("KSta_StremVideoPublishId", cfg.fiN);
                    }
                    intent.putExtra("KSta_SnsStatExtStr", timeLineObject2.rjC);
                    d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                    AppMethodBeat.o(39862);
                    return;
                } else if (timeLineObject.qNQ == null || bo.isNullOrNil(timeLineObject.qNQ.uaa)) {
                    String str = timeLineObject.xfI.Url;
                    ab.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(str)));
                    B = com.tencent.mm.plugin.sns.c.a.gkF.B(str, "timeline");
                    if (B == null || B.length() == 0) {
                        AppMethodBeat.o(39862);
                        return;
                    }
                    String str2;
                    Intent intent2 = new Intent();
                    Bundle bundle = null;
                    if (timeLineObject != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("KSnsStrId", timeLineObject.Id);
                        bundle2.putString("KSnsLocalId", qVar.cwT);
                        bundle2.putBoolean("KFromTimeline", true);
                        if (timeLineObject.xfI != null && timeLineObject.xfI.wbK.size() > 0) {
                            bundle2.putString("K_sns_thumb_url", ((bau) timeLineObject.xfI.wbK.get(0)).wEH);
                            bundle2.putString("K_sns_raw_url", timeLineObject.xfI.Url);
                            ab.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", ((bau) timeLineObject.xfI.wbK.get(0)).wEH, timeLineObject.xfI.Url);
                        }
                        bundle = bundle2;
                    }
                    bundle.putString("key_snsad_statextstr", timeLineObject.rjC);
                    intent2.putExtra("rawUrl", B);
                    intent2.putExtra("shortUrl", B);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("type", -255);
                    if (timeLineObject.xfJ != null) {
                        intent2.putExtra("srcUsername", timeLineObject.xfJ);
                        intent2.putExtra("srcDisplayname", timeLineObject.vjM);
                        ab.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + timeLineObject.vjM + " tlObj.publicUserName: " + timeLineObject.xfJ);
                    }
                    intent2.putExtra("sns_local_id", qVar.cwT);
                    if (YT != null) {
                        intent2.putExtra("KPublisherId", "sns_" + i.jV(YT.field_snsId));
                        intent2.putExtra("pre_username", YT.field_userName);
                        intent2.putExtra("prePublishId", "sns_" + i.jV(YT.field_snsId));
                        intent2.putExtra("preUsername", YT.field_userName);
                        intent2.putExtra("share_report_pre_msg_url", B);
                        intent2.putExtra("share_report_pre_msg_title", timeLineObject.xfI.Title);
                        intent2.putExtra("share_report_pre_msg_desc", timeLineObject.xfI.Desc);
                        if (timeLineObject.xfI.wbK != null && timeLineObject.xfI.wbK.size() > 0) {
                            intent2.putExtra("share_report_pre_msg_icon_url", ((bau) timeLineObject.xfI.wbK.get(0)).wEH);
                        }
                        intent2.putExtra("share_report_pre_msg_appid", "");
                        intent2.putExtra("share_report_from_scene", 1);
                    }
                    if (!(timeLineObject == null || timeLineObject.xfH == null)) {
                        intent2.putExtra("KAppId", timeLineObject.xfH.Id);
                    }
                    if (YT != null && YT.DI(32)) {
                        com.tencent.mm.plugin.sns.storage.a cqr;
                        if (bc.this.cvd == 2) {
                            cqr = YT.cqr();
                        } else {
                            cqr = YT.cqq();
                        }
                        if (cqr != null) {
                            intent2.putExtra("KsnsViewId", cqr.hnw);
                        }
                    }
                    if (!(YT == null || timeLineObject == null)) {
                        b lY;
                        if (bc.this.cvd == 0) {
                            lY = b.lY(718);
                        } else {
                            lY = b.lZ(718);
                        }
                        lY.tx(i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx(timeLineObject.xfJ).tx(timeLineObject.xfH == null ? "" : timeLineObject.xfH.Id).tx(timeLineObject.xfI.Url);
                        lY.ajK();
                        if (bc.this.cvd == 0) {
                            lY = b.lY(743);
                        } else {
                            lY = b.lZ(743);
                        }
                        b tx = lY.tx(i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx(timeLineObject.xfJ);
                        if (timeLineObject.xfH == null) {
                            str2 = "";
                        } else {
                            str2 = timeLineObject.xfH.Id;
                        }
                        tx.tx(str2).tx(timeLineObject.xfI.Url);
                        if (bundle != null) {
                            str2 = "intent_key_StatisticsOplog";
                            byte[] adk = lY.adk();
                            if (adk != null) {
                                bundle.putByteArray(str2, adk);
                            }
                        }
                    }
                    if (bundle != null) {
                        intent2.putExtra("jsapiargs", bundle);
                    }
                    intent2.putExtra("geta8key_scene", 2);
                    intent2.putExtra("from_scence", 3);
                    if (!(timeLineObject.xfI.wbN == null || timeLineObject.xfI.wbN.vGc == -1)) {
                        intent2.putExtra(m.ygo, timeLineObject.xfI.wbN.vGc);
                    }
                    int[] iArr;
                    int width;
                    if (bo.isNullOrNil(timeLineObject.rCK) || !com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.YO(timeLineObject.rCK) || YT == null) {
                        intent2.addFlags(536870912);
                        int i = timeLineObject.xfI.wbN != null ? timeLineObject.xfI.wbN.vGc : -1;
                        int bFf = bc.this.rhQ.bFf();
                        if (timeLineObject.xfI.wbN != null && i == 5 && timeLineObject.xfI.wbN.fgb == 1 && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
                            intent2.putExtra("biz_video_title", timeLineObject.xfI.Title);
                            intent2.putExtra("biz_video_vid", timeLineObject.xfI.wbN.fgd);
                            intent2.putExtra("biz_video_func_flag", timeLineObject.xfI.wbN.fgc);
                            intent2.putExtra("biz_video_desc", timeLineObject.xfI.wbN.desc);
                            if (bo.isNullOrNil(timeLineObject.xfI.wbN.lvx)) {
                                intent2.putExtra("biz_video_icon_url", intent2.getStringExtra("share_report_pre_msg_icon_url"));
                            } else {
                                intent2.putExtra("biz_video_icon_url", timeLineObject.xfI.wbN.lvx);
                            }
                            intent2.putExtra("biz_video_item_show_type", timeLineObject.xfI.wbN.vGc);
                            intent2.putExtra("biz_video_pub_time", (long) timeLineObject.xfI.wbN.fga);
                            intent2.putExtra("biz_video_duration", timeLineObject.xfI.wbN.duration);
                            intent2.putExtra("biz_video_width", timeLineObject.xfI.wbN.videoWidth);
                            intent2.putExtra("biz_video_height", timeLineObject.xfI.wbN.videoHeight);
                            intent2.putExtra("biz_video_scene", 2);
                            intent2.putExtra("biz_video_subscene", bFf);
                            iArr = new int[2];
                            View findViewById = view.findViewById(R.id.d11);
                            if (findViewById != null) {
                                width = findViewById.getWidth();
                                i = findViewById.getHeight();
                                findViewById.getLocationInWindow(iArr);
                                intent2.putExtra("img_gallery_width", width).putExtra("img_gallery_height", i).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                            }
                            d.b(bc.this.context, "brandservice", ".ui.timeline.video.BizVideoDetailUI", intent2);
                        } else if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(4) && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(bc.this.context, B, i, 2, bFf, intent2)) {
                            ab.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
                        } else {
                            com.tencent.mm.plugin.sns.c.a.gkE.i(intent2, bc.this.context);
                        }
                        B = null;
                        int i2 = 0;
                        if (!(timeLineObject == null || timeLineObject.xfH == null)) {
                            B = timeLineObject.xfH.Id;
                            i2 = bo.getInt(timeLineObject.xfH.jCh, 0);
                        }
                        str2 = com.tencent.mm.plugin.sns.c.a.gkF.t(B, i2);
                        if (!bo.isNullOrNil(str2)) {
                            String str3 = null;
                            if (!(timeLineObject == null || timeLineObject.qNO == null || timeLineObject.qNO.vCy == null)) {
                                str3 = timeLineObject.qNO.vCy.vCs;
                            }
                            com.tencent.mm.plugin.sns.c.a.gkF.a(bc.this.context, B, str2, timeLineObject == null ? null : timeLineObject.jBB, 5, 4, 1, str3, timeLineObject.Id);
                        }
                        h.pYm.e(11105, timeLineObject.jBB, timeLineObject.xfI.Url);
                        if (YT != null && YT.field_type == 4) {
                            bau = (bau) timeLineObject.xfI.wbK.get(0);
                            h hVar = h.pYm;
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(1);
                            objArr[1] = bau == null ? "" : bau.Desc;
                            objArr[2] = timeLineObject.xfH.Id;
                            hVar.e(13043, objArr);
                        }
                    } else {
                        iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width2 = view.getWidth();
                        width = view.getHeight();
                        Intent intent3 = new Intent();
                        intent3.putExtra("img_gallery_left", iArr[0]);
                        intent3.putExtra("img_gallery_top", iArr[1]);
                        intent3.putExtra("img_gallery_width", width2);
                        intent3.putExtra("img_gallery_height", width);
                        if (timeLineObject != null) {
                            LinkedList linkedList = timeLineObject.xfI.wbK;
                            if (linkedList.size() > 0) {
                                intent3.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                            }
                        }
                        intent3.putExtra("sns_landing_pages_share_sns_id", YT.cqA());
                        intent3.putExtra("sns_landing_pages_rawSnsId", YT.cqu().Id);
                        intent3.putExtra("sns_landing_pages_aid", YT.cqZ());
                        intent3.putExtra("sns_landing_pages_traceid", YT.cra());
                        intent3.putExtra("sns_landing_pages_ux_info", YT.crc());
                        intent3.putExtra("sns_landig_pages_from_source", bc.this.cvd == 0 ? 3 : 4);
                        intent3.setClass(bc.this.context, SnsAdNativeLandingPagesUI.class);
                        intent3.putExtra("sns_landing_pages_xml", timeLineObject.rCK);
                        intent3.putExtra("sns_landing_pages_rec_src", YT.cre());
                        intent3.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(intent3, bc.this.context);
                        AppMethodBeat.o(39862);
                        return;
                    }
                } else {
                    bc bcVar2 = bc.this;
                    cvi cvi = timeLineObject.qNQ;
                    if (!(cvi == null || bo.isNullOrNil(cvi.uaa))) {
                        aa.a(bcVar2.context, com.tencent.mm.plugin.topstory.a.g.a(cvi, 31, ac.adL("discoverRecommendEntry").optString("wording")));
                        String str4 = timeLineObject.jBB;
                        B = timeLineObject.Id;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("isShareClick=1");
                        stringBuffer.append("&relevant_vid=");
                        stringBuffer.append(cvi.uaa);
                        stringBuffer.append("&relevant_pre_searchid=");
                        stringBuffer.append(cvi.uac);
                        stringBuffer.append("&relevant_shared_openid=");
                        stringBuffer.append(cvi.uad);
                        stringBuffer.append("&rec_category=");
                        if (cvi.uam > 0) {
                            stringBuffer.append(cvi.uam);
                        } else {
                            stringBuffer.append(cvi.uae);
                        }
                        stringBuffer.append("&source=");
                        stringBuffer.append(cvi.source);
                        stringBuffer.append("&fromUser=");
                        stringBuffer.append(str4);
                        stringBuffer.append("&fromScene=");
                        stringBuffer.append(3);
                        stringBuffer.append("&targetInfo=");
                        stringBuffer.append(B);
                        stringBuffer.append("&expand=");
                        stringBuffer.append(cvi.uab);
                        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", stringBuffer.toString());
                        bsj bsj = new bsj();
                        bsj.wUu = stringBuffer.toString();
                        com.tencent.mm.kernel.g.Rg().a(new w(bsj), 0);
                    }
                    AppMethodBeat.o(39862);
                    return;
                }
            }
            AppMethodBeat.o(39862);
        }
    };
    p tipDialog;

    public interface a {
        void ctb();
    }

    public bc(Context context, a aVar, int i, ae aeVar) {
        AppMethodBeat.i(39879);
        this.context = context;
        this.rDr = aVar;
        this.cvd = i;
        this.rhQ = aeVar;
        AppMethodBeat.o(39879);
    }

    protected static boolean Wi(String str) {
        AppMethodBeat.i(39880);
        kd kdVar = new kd();
        kdVar.cFz.action = -2;
        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
        com.tencent.mm.aw.e eVar = kdVar.cFA.cFB;
        if (eVar != null && com.tencent.mm.aw.a.d(eVar) && str.equals(eVar.fJU) && com.tencent.mm.aw.a.aie()) {
            AppMethodBeat.o(39880);
            return true;
        }
        AppMethodBeat.o(39880);
        return false;
    }
}
