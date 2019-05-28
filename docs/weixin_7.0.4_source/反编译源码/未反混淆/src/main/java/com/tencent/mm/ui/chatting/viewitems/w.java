package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

public final class w extends c {
    static int zeU = Color.parseColor("#888888");
    static int zeV = Color.parseColor("#888888");
    private OnClickListener lBl;
    private String mAppId;
    private p sfa;
    private com.tencent.mm.ui.chatting.d.a yJI;
    private c<lo> yTn;
    private com.tencent.mm.at.a.a.c yqf;
    private OnClickListener zeM;
    private OnClickListener zeN;
    private OnClickListener zeO;
    private OnClickListener zeP;
    private l zeQ;
    private OnClickListener zeR;
    private String zeS;
    private int zeT;

    public static class b {
        public String cRS;
        public String fhu;
        public String fjv;
        public String fjw;
        public String fjx;
        public String fjy;
        public String fjz;
        public long time;
        public String title;
        public int type;
        public String url;

        public static b aX(Map<String, String> map) {
            AppMethodBeat.i(33156);
            b bVar = new b();
            bVar.title = (String) map.get(".msg.appmsg.mmreader.category.item.title");
            bVar.url = (String) map.get(".msg.appmsg.mmreader.category.item.url");
            bVar.cRS = (String) map.get(".msg.appmsg.mmreader.category.item.native_url");
            bVar.fjv = (String) map.get(".msg.appmsg.mmreader.category.item.shorturl");
            bVar.fjw = (String) map.get(".msg.appmsg.mmreader.category.item.longurl");
            bVar.time = bo.getLong((String) map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
            bVar.fjx = (String) map.get(".msg.appmsg.mmreader.category.item.cover");
            bVar.fjy = (String) map.get(".msg.appmsg.mmreader.category.item.tweetid");
            bVar.fjz = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
            bVar.type = bo.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            bVar.fhu = (String) map.get(".msg.appmsg.template_id");
            AppMethodBeat.o(33156);
            return bVar;
        }
    }

    final class a implements OnClickListener {
        private a() {
        }

        /* synthetic */ a(w wVar, byte b) {
            this();
        }

        public final void onClick(final View view) {
            AppMethodBeat.i(33155);
            if (view.getTag() instanceof bi) {
                final bi biVar = (bi) view.getTag();
                if (biVar == null) {
                    ab.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
                    AppMethodBeat.o(33155);
                    return;
                }
                Map z = br.z(biVar.field_content, "msg");
                if (z == null || z.size() == 0) {
                    ab.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
                    AppMethodBeat.o(33155);
                    return;
                }
                final String nullAsNil = bo.nullAsNil((String) z.get(".msg.fromusername"));
                d dVar = new d(view.getContext(), 1, false);
                dVar.rBl = new n.c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        AppMethodBeat.i(33151);
                        lVar.add(0, 1, 0, view.getResources().getString(R.string.d_o));
                        AppMethodBeat.o(33151);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(33154);
                        ab.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                        switch (menuItem.getItemId()) {
                            case 1:
                                aw.Rg().a(1198, new f() {
                                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                        AppMethodBeat.i(33152);
                                        aw.Rg().b(1198, (f) this);
                                        ab.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.FALSE);
                                        if (w.this.sfa != null) {
                                            w.this.sfa.dismiss();
                                            w.this.sfa = null;
                                        }
                                        if (i != 0 || i2 != 0) {
                                            t.makeText(view.getContext(), R.string.d_p, 0).show();
                                            AppMethodBeat.o(33152);
                                        } else if (biVar != view.getTag()) {
                                            ab.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(biVar.field_msgId));
                                            AppMethodBeat.o(33152);
                                        } else {
                                            cya abK = ((s) mVar).abK();
                                            if (abK == null) {
                                                t.makeText(view.getContext(), R.string.d_p, 0).show();
                                                AppMethodBeat.o(33152);
                                                return;
                                            }
                                            String str2 = abK.xtv;
                                            ab.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", nullAsNil);
                                            try {
                                                ab.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, w.this.zeS, String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[]{nullAsNil, URLEncoder.encode(w.this.zeS, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding)}));
                                                Intent intent = new Intent();
                                                intent.putExtra("rawUrl", r1);
                                                com.tencent.mm.bp.d.b(w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                                AppMethodBeat.o(33152);
                                            } catch (UnsupportedEncodingException e) {
                                                ab.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                                t.makeText(view.getContext(), R.string.d_u, 0).show();
                                                AppMethodBeat.o(33152);
                                            }
                                        }
                                    }
                                });
                                final m sVar = new s(biVar.field_content);
                                w wVar = w.this;
                                Context context = view.getContext();
                                view.getResources().getString(R.string.tz);
                                wVar.sfa = h.b(context, view.getResources().getString(R.string.un), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(33153);
                                        aw.Rg().c(sVar);
                                        AppMethodBeat.o(33153);
                                    }
                                });
                                aw.Rg().a(sVar, 0);
                                break;
                        }
                        AppMethodBeat.o(33154);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(33155);
                return;
            }
            ab.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
            AppMethodBeat.o(33155);
        }
    }

    static /* synthetic */ void M(int i, String str, String str2) {
        AppMethodBeat.i(33171);
        L(i, str, str2);
        AppMethodBeat.o(33171);
    }

    public final boolean dHk() {
        return false;
    }

    public w() {
        AppMethodBeat.i(33157);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePT = R.drawable.abh;
        this.yqf = aVar.ahG();
        this.zeN = new a(this, (byte) 0);
        this.zeM = new OnClickListener() {
            public final void onClick(final View view) {
                AppMethodBeat.i(33127);
                final bi biVar = (bi) view.getTag(R.id.anz);
                if (biVar == null) {
                    ab.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                    AppMethodBeat.o(33127);
                    return;
                }
                Map z = br.z(biVar.field_content, "msg");
                if (z == null || z.size() == 0) {
                    AppMethodBeat.o(33127);
                    return;
                }
                final String nullAsNil = bo.nullAsNil((String) z.get(".msg.fromusername"));
                final int g = bo.g(z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                final int g2 = bo.g(z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                d dVar = new d(view.getContext(), 1, false);
                dVar.rBl = new n.c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        AppMethodBeat.i(33122);
                        lVar.add(0, 2, 0, view.getResources().getString(R.string.d_o));
                        AppMethodBeat.o(33122);
                    }
                };
                final View view2 = view;
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(33126);
                        ab.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                        switch (menuItem.getItemId()) {
                            case 2:
                                aw.Rg().a(1198, new f() {
                                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                        AppMethodBeat.i(33124);
                                        aw.Rg().b(1198, (f) this);
                                        ab.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.FALSE);
                                        if (w.this.sfa != null) {
                                            w.this.sfa.dismiss();
                                            w.this.sfa = null;
                                        }
                                        if (i == 0 && i2 == 0) {
                                            cya abK = ((s) mVar).abK();
                                            if (abK == null) {
                                                t.makeText(view2.getContext(), R.string.d_p, 0).show();
                                                AppMethodBeat.o(33124);
                                                return;
                                            }
                                            final String str2 = abK.xtv;
                                            ab.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", nullAsNil);
                                            ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).a(nullAsNil, new com.tencent.mm.plugin.appbrand.service.d.a() {
                                                public final void d(WxaAttributes wxaAttributes) {
                                                    AppMethodBeat.i(33123);
                                                    if (wxaAttributes == null) {
                                                        t.makeText(view2.getContext(), R.string.d_u, 0).show();
                                                        AppMethodBeat.o(33123);
                                                        return;
                                                    }
                                                    if (TextUtils.isEmpty(wxaAttributes.field_appId) || TextUtils.isEmpty(str2)) {
                                                        ab.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", r0, str2);
                                                        t.makeText(view2.getContext(), R.string.d_u, 0).show();
                                                        AppMethodBeat.o(33123);
                                                        return;
                                                    }
                                                    try {
                                                        ab.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, r0, String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{URLEncoder.encode(r0, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), Integer.valueOf(1), Integer.valueOf(g), Integer.valueOf(g2)}));
                                                        Intent intent = new Intent();
                                                        intent.putExtra("rawUrl", r1);
                                                        com.tencent.mm.bp.d.b(w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                                        AppMethodBeat.o(33123);
                                                    } catch (UnsupportedEncodingException e) {
                                                        ab.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                                        t.makeText(view2.getContext(), R.string.d_u, 0).show();
                                                        AppMethodBeat.o(33123);
                                                    }
                                                }
                                            });
                                            AppMethodBeat.o(33124);
                                            return;
                                        }
                                        t.makeText(view2.getContext(), R.string.d_p, 0).show();
                                        AppMethodBeat.o(33124);
                                    }
                                });
                                final m sVar = new s(biVar.field_content);
                                w wVar = w.this;
                                Context context = view2.getContext();
                                view2.getResources().getString(R.string.tz);
                                wVar.sfa = h.b(context, view2.getResources().getString(R.string.un), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(33125);
                                        aw.Rg().c(sVar);
                                        AppMethodBeat.o(33125);
                                    }
                                });
                                aw.Rg().a(sVar, 0);
                                w.M(4, w.this.mAppId, w.this.zeS);
                                break;
                        }
                        AppMethodBeat.o(33126);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(33127);
            }
        };
        this.zeR = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33138);
                ay ayVar = (ay) view.getTag();
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", ayVar.userName);
                Map z = br.z(ayVar.cKd.field_content, "msg");
                String nullAsNil = bo.nullAsNil((String) z.get(".msg.fromusername"));
                com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, nullAsNil, Integer.valueOf(66666));
                String nullAsNil2 = bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.weapp_username"));
                if (bo.isNullOrNil(nullAsNil2)) {
                    String nullAsNil3 = bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
                    if (!bo.isNullOrNil(nullAsNil3)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", nullAsNil3);
                        com.tencent.mm.bp.d.b(w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.o(33138);
                    return;
                }
                String nullAsNil4 = bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.weapp_path"));
                int i = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
                int i2 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
                nullAsNil = bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.cst = ayVar.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
                appBrandStatObject.scene = w.arF(nullAsNil);
                ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), nullAsNil2, null, i, i2, nullAsNil4, appBrandStatObject);
                AppMethodBeat.o(33138);
            }
        };
        this.zeO = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33139);
                ay ayVar = (ay) view.getTag();
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", ayVar.userName);
                Map z = br.z(ayVar.cKd.field_content, "msg");
                if (!(z == null || z.size() == 0)) {
                    bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                }
                w wVar = w.this;
                view.getContext();
                w.a(wVar, ayVar.userName);
                AppMethodBeat.o(33139);
            }
        };
        this.yTn = new c<lo>() {
            {
                AppMethodBeat.i(33141);
                this.xxI = lo.class.getName().hashCode();
                AppMethodBeat.o(33141);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(33142);
                if (w.this.yJI != null) {
                    w.this.yJI.yTx.getContext().runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(33140);
                            w.this.yJI.aWv();
                            AppMethodBeat.o(33140);
                        }
                    });
                }
                AppMethodBeat.o(33142);
                return true;
            }
        };
        this.zeQ = new l() {
            public final void dxx() {
            }

            public final void dxy() {
            }

            public final void dxz() {
            }

            public final void dxA() {
            }

            public final void dxB() {
            }

            public final void dxC() {
                AppMethodBeat.i(33143);
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
                com.tencent.mm.sdk.b.a.xxA.d(w.this.yTn);
                if (w.this.yJI != null) {
                    ((com.tencent.mm.ui.chatting.c.b.g) w.this.yJI.aF(com.tencent.mm.ui.chatting.c.b.g.class)).b(this);
                }
                AppMethodBeat.o(33143);
            }

            public final void dxD() {
            }
        };
        this.zeP = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33144);
                ay ayVar = (ay) view.getTag();
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", ayVar.userName);
                se seVar = new se();
                seVar.cOf.userName = ayVar.userName;
                seVar.cOf.cOh = ayVar.hzj;
                Map z = br.z(ayVar.cKd.field_content, "msg");
                String str = "";
                if (z != null && z.size() > 0) {
                    seVar.cOf.cOi = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                    str = bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                }
                seVar.cOf.cOl = true;
                seVar.cOf.scene = w.arF(str);
                seVar.cOf.cst = ayVar.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str;
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                w.M(9, w.this.mAppId, w.this.zeS);
                com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, ayVar.userName, Integer.valueOf(0));
                AppMethodBeat.o(33144);
            }
        };
        this.lBl = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33145);
                ay ayVar = (ay) view.getTag();
                Map z = br.z(ayVar.cKd.field_content, "msg");
                if (z == null) {
                    ab.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
                    AppMethodBeat.o(33145);
                    return;
                }
                int i = bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
                if (i == 1) {
                    String str = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
                    String str2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_path");
                    int i2 = bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
                    int i3 = bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
                    String nullAsNil = bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                    ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", str);
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.cst = ayVar.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
                    if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(ayVar.userName)) {
                        appBrandStatObject.scene = w.arF(nullAsNil);
                        ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str, null, i3, i2, str2, appBrandStatObject);
                    } else {
                        appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                        com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(ayVar.userName);
                        ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str, null, i3, i2, str2, appBrandStatObject, qX == null ? null : qX.field_appId);
                    }
                    w.M(9, w.this.mAppId, w.this.zeS);
                    com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, ayVar.userName, Integer.valueOf(0));
                    AppMethodBeat.o(33145);
                    return;
                }
                if (i == 2) {
                    w.b(view.getContext(), (String) z.get(".msg.appmsg.mmreader.category.item.schedule_username"), bo.getLong((String) z.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
                    ab.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", r0, Long.valueOf(r2));
                }
                AppMethodBeat.o(33145);
            }
        };
        AppMethodBeat.o(33157);
    }

    public final boolean aH(int i, boolean z) {
        if (i == 318767153) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33158);
        if (view == null || view.getTag() == null) {
            view = new v(layoutInflater, R.layout.lw);
            aw awVar = new aw();
            awVar.moo = (CheckBox) view.findViewById(R.id.a_);
            awVar.iVh = view.findViewById(R.id.af);
            awVar.qkY = (TextView) view.findViewById(R.id.od);
            awVar.zbv = (AvatarImageView) view.findViewById(R.id.oc);
            awVar.enf = (TextView) view.findViewById(R.id.ag);
            awVar.jPr = (LinearLayout) view.findViewById(R.id.ank);
            awVar.zii.jOR = view.findViewById(R.id.anr);
            awVar.zii.zil = view.findViewById(R.id.aow);
            awVar.zii.gsf = (TextView) awVar.zii.jOR.findViewById(R.id.cx);
            awVar.zii.ngD = (TextView) awVar.zii.jOR.findViewById(R.id.aoy);
            awVar.zii.ziq = (LinearLayout) awVar.zii.jOR.findViewById(R.id.ap0);
            awVar.zii.zio = (TextView) awVar.jPr.findViewById(R.id.a8q);
            awVar.zii.zir = awVar.jPr.findViewById(R.id.ap1);
            awVar.zii.zim = view.findViewById(R.id.aox);
            awVar.zii.zin = view.findViewById(R.id.aoz);
            awVar.zij.ziK = view.findViewById(R.id.ans);
            awVar.zij.ziL = (ImageView) view.findViewById(R.id.ao1);
            awVar.zij.ziM = view.findViewById(R.id.anv);
            awVar.zij.ziO = (TextView) view.findViewById(R.id.anx);
            awVar.zij.ziN = (ImageView) view.findViewById(R.id.anw);
            awVar.zij.ziP = view.findViewById(R.id.any);
            awVar.zij.ziQ = (ImageView) view.findViewById(R.id.ao0);
            awVar.zij.ziR = view.findViewById(R.id.anz);
            awVar.zij.ziS = view.findViewById(R.id.ao5);
            awVar.zij.ziT = (TextView) view.findViewById(R.id.ao3);
            awVar.zij.ziU = (TextView) view.findViewById(R.id.ao4);
            awVar.zij.ziV = (TextView) view.findViewById(R.id.ao6);
            awVar.zij.ziW = view.findViewById(R.id.ao2);
            awVar.zij.ziX = (LinearLayout) view.findViewById(R.id.ao7);
            awVar.zij.ziY = (TextView) view.findViewById(R.id.ao8);
            awVar.zij.zja = (TextView) view.findViewById(R.id.ao_);
            awVar.zij.ziZ = (TextView) view.findViewById(R.id.ao9);
            awVar.zij.zjb = (TextView) view.findViewById(R.id.aoa);
            awVar.zij.zjc = view.findViewById(R.id.aob);
            awVar.zij.zjd = (LinearLayout) view.findViewById(R.id.aog);
            awVar.zij.zjh = view.findViewById(R.id.yg);
            awVar.zij.zje = view.findViewById(R.id.aoh);
            awVar.zij.zjf = (LinearLayout) view.findViewById(R.id.aoi);
            awVar.zij.zjg = (LinearLayout) view.findViewById(R.id.aot);
            awVar.zij.zji = (LinearLayout) view.findViewById(R.id.aoj);
            awVar.zij.zjl = (TextView) view.findViewById(R.id.aok);
            awVar.zij.zjn = (ImageView) view.findViewById(R.id.aol);
            awVar.zij.zjk = view.findViewById(R.id.aom);
            awVar.zij.zjj = (LinearLayout) view.findViewById(R.id.aon);
            awVar.zij.zjm = (TextView) view.findViewById(R.id.aoo);
            awVar.zij.zjo = (ImageView) view.findViewById(R.id.aop);
            awVar.zij.zjp = (ImageView) view.findViewById(R.id.am8);
            awVar.zbW = (ImageView) view.findViewById(R.id.ant);
            awVar.zij.zjq = view.findViewById(R.id.aoq);
            awVar.zij.zjr = (ImageView) view.findViewById(R.id.aor);
            awVar.zij.zjs = (TextView) view.findViewById(R.id.aos);
            awVar.zij.zjt = (LinearLayout) view.findViewById(R.id.aou);
            awVar.zij.zju = (TextView) view.findViewById(R.id.aov);
            awVar.zik.zbc = (LinearLayout) view.findViewById(R.id.aoc);
            awVar.zik.zbd = (CdnImageView) view.findViewById(R.id.aod);
            awVar.zik.zbe = (TextView) view.findViewById(R.id.aoe);
            awVar.zik.zbf = (TextView) view.findViewById(R.id.aof);
            view.setTag(awVar);
        }
        AppMethodBeat.o(33158);
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHj() {
        return false;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
        AppMethodBeat.i(33159);
        this.yJI = aVar2;
        aVar = (aw) aVar;
        final Map z = br.z(biVar.field_content, "msg");
        if (z == null || z.size() == 0) {
            ab.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            aVar.jPr.setVisibility(8);
            AppMethodBeat.o(33159);
            return;
        }
        aVar.jPr.setVisibility(0);
        int i2 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.zeS = bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
        this.zeT = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
        com.tencent.mm.sdk.b.a.xxA.d(this.yTn);
        ((com.tencent.mm.ui.chatting.c.b.g) aVar2.aF(com.tencent.mm.ui.chatting.c.b.g.class)).b(this.zeQ);
        String nullAsNil;
        String nullAsNil2;
        String nullAsNil3;
        View view;
        ay ayVar;
        if (i2 != 0) {
            WxaAttributes zb;
            int paddingLeft;
            int i3;
            int e;
            int e2;
            View inflate;
            CharSequence charSequence;
            int childCount;
            ay ayVar2;
            aVar.zii.jOR.setVisibility(8);
            final bd bdVar = aVar.zij;
            if (bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1) {
                a(bdVar, bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), z, biVar, false);
            } else if (bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0) {
                a(bdVar, bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.icon_url")), bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.display_name")), z, biVar, true);
            } else {
                ((View) bdVar.ziQ.getParent()).setVisibility(8);
                if ("notifymessage".equals(biVar.field_talker)) {
                    CharSequence charSequence2;
                    nullAsNil = bo.nullAsNil((String) z.get(".msg.fromusername"));
                    if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(nullAsNil)) {
                        zb = ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(nullAsNil);
                        a(bdVar.ziN, this.yJI, nullAsNil, biVar, zb == null ? null : zb.field_brandIconURL);
                        charSequence2 = zb == null ? nullAsNil : zb.field_nickname;
                    } else {
                        a(bdVar.ziN, this.yJI, nullAsNil, biVar, null);
                        charSequence2 = ((com.tencent.mm.ui.chatting.c.b.f) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.f.class)).arj(nullAsNil);
                    }
                    bdVar.ziO.setText(j.b(this.yJI.yTx.getContext(), charSequence2, bdVar.ziO.getTextSize()));
                    if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(nullAsNil)) {
                        bdVar.ziM.setTag(new ay(biVar, nullAsNil));
                        bdVar.ziM.setOnClickListener(this.zeO);
                    } else {
                        bdVar.ziM.setTag(new ay(nullAsNil, this.yJI.dFx() ? this.yJI.getTalkerUserName() : null));
                        bdVar.ziM.setOnClickListener(e(this.yJI));
                    }
                    bdVar.ziM.setVisibility(0);
                } else {
                    bdVar.ziM.setVisibility(8);
                }
            }
            if (bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) != 0) {
                bdVar.ziM.setBackgroundResource(R.drawable.uv);
            } else {
                paddingLeft = bdVar.ziM.getPaddingLeft();
                bdVar.ziM.setBackgroundResource(R.drawable.a_q);
                bdVar.ziM.setPadding(paddingLeft, 0, 0, 0);
            }
            if (bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {
                i3 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
            } else {
                i3 = 0;
            }
            int i4 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
            int i5 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_time"), 0);
            bdVar.ziT.setVisibility(8);
            bdVar.ziU.setVisibility(8);
            if (i3 == 0) {
                if (i4 == 0) {
                    bdVar.ziT.setVisibility(0);
                    nullAsNil2 = bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.title"));
                    bdVar.ziT.setTextColor(e(z, ".msg.appmsg.mmreader.template_header.title_color", WebView.NIGHT_MODE_COLOR));
                    bdVar.ziT.setText(nullAsNil2);
                }
                if (i5 == 0) {
                    long j = bo.getLong(bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.pub_time")), 0);
                    if (j > 0) {
                        bdVar.ziU.setText(com.tencent.mm.pluginsdk.f.h.formatTime(this.yJI.yTx.getMMResources().getString(R.string.bwz), j));
                        bdVar.ziU.setVisibility(0);
                    } else {
                        bdVar.ziU.setVisibility(8);
                    }
                }
            }
            nullAsNil2 = bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.first_data"));
            i4 = e(z, ".msg.appmsg.mmreader.template_header.first_color", zeV);
            if (bo.isNullOrNil(nullAsNil2)) {
                bdVar.ziV.setVisibility(8);
            } else {
                bdVar.ziV.setTextColor(i4);
                bdVar.ziV.setText(nullAsNil2);
                bdVar.ziV.setVisibility(0);
                if (i2 == 2) {
                    bdVar.ziV.setPadding(0, this.yJI.yTx.getMMResources().getDimensionPixelOffset(R.dimen.l5), 0, 0);
                } else {
                    bdVar.ziV.setPadding(0, 0, 0, 0);
                }
            }
            if (i3 == 0 || !bo.isNullOrNil(nullAsNil2)) {
                bdVar.ziW.setVisibility(0);
            } else {
                bdVar.ziW.setVisibility(8);
            }
            boolean z2 = false;
            boolean z3 = false;
            if ("notifymessage".equals(biVar.field_talker)) {
                nullAsNil3 = bo.nullAsNil((String) z.get(".msg.fromusername"));
                z2 = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(nullAsNil3);
                if (z2) {
                    ((com.tencent.mm.ui.chatting.c.b.g) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.g.class)).a(this.zeQ);
                    com.tencent.mm.sdk.b.a.xxA.c(this.yTn);
                    zb = ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(nullAsNil3);
                    if (zb != null) {
                        boolean z4;
                        this.mAppId = zb.field_appId;
                        if ((zb.field_appOpt & 1) > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z3 = z4;
                    } else {
                        ab.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", nullAsNil3);
                        final bi biVar2 = biVar;
                        ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).a(nullAsNil3, new com.tencent.mm.plugin.appbrand.service.d.a() {
                            public final void d(WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(33147);
                                if (wxaAttributes == null) {
                                    AppMethodBeat.o(33147);
                                    return;
                                }
                                w.this.mAppId = wxaAttributes.field_appId;
                                final boolean z = (wxaAttributes.field_appOpt & 1) > 0;
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(33146);
                                        w.a(w.this, z, biVar2, bdVar, z);
                                        AppMethodBeat.o(33146);
                                    }
                                });
                                AppMethodBeat.o(33147);
                            }
                        });
                    }
                }
            }
            bdVar.ziR.setVisibility(z2 ? 0 : 8);
            bdVar.ziR.setTag(R.id.anz, biVar);
            bdVar.ziR.setOnClickListener(this.zeM);
            a(z, biVar, bdVar, z2, z3);
            bdVar.ziL.setVisibility(8);
            bdVar.ziV.setText(bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.first_data")));
            nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            nullAsNil3 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            String str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bo.isNullOrNil(nullAsNil3)) {
                bdVar.ziX.setVisibility(8);
            } else {
                e = e(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", WebView.NIGHT_MODE_COLOR);
                e2 = e(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", WebView.NIGHT_MODE_COLOR);
                int e3 = e(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", WebView.NIGHT_MODE_COLOR);
                i5 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
                bdVar.ziY.setTextColor(e);
                bdVar.zja.setTextColor(e2);
                bdVar.zjb.setTextColor(e3);
                bdVar.zjb.getPaint().setFlags(16);
                bdVar.ziY.setText(nullAsNil2);
                if (i5 <= 0 || i5 >= nullAsNil3.length()) {
                    bdVar.ziZ.setTypeface(Typeface.DEFAULT);
                    bdVar.ziZ.setVisibility(8);
                    bdVar.zja.setTypeface(Typeface.DEFAULT);
                    bdVar.zja.setText(nullAsNil3);
                } else {
                    bdVar.ziZ.setVisibility(0);
                    bdVar.ziZ.setText(nullAsNil3.substring(0, i5));
                    bdVar.ziZ.setTextColor(e2);
                    bdVar.ziZ.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) g.K(com.tencent.mm.pluginsdk.wallet.b.class)).ex(this.yJI.yTx.getContext()));
                    bdVar.zja.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) g.K(com.tencent.mm.pluginsdk.wallet.b.class)).ex(this.yJI.yTx.getContext()));
                    bdVar.zja.setText(nullAsNil3.substring(i5));
                }
                if (bo.isNullOrNil(str2)) {
                    bdVar.zjb.setVisibility(8);
                } else {
                    bdVar.zjb.setText(str2);
                    bdVar.zjb.setVisibility(0);
                }
                bdVar.ziX.setVisibility(0);
            }
            int i6 = bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i6 == 2) {
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
                bdVar.ziU.setVisibility(8);
                bdVar.zjd.setVisibility(8);
                ViewGroup viewGroup = (ViewGroup) bdVar.zjd.getParent();
                View findViewById = viewGroup.findViewById(R.id.c7d);
                if (findViewById == null) {
                    inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aob, null);
                    av avVar = new av();
                    avVar.iNr = (ImageView) inflate.findViewById(R.id.bke);
                    avVar.zih = (TextView) inflate.findViewById(R.id.dyj);
                    avVar.ngD = (TextView) inflate.findViewById(R.id.aoy);
                    avVar.gsf = (TextView) inflate.findViewById(R.id.cx);
                    inflate.setTag(avVar);
                    viewGroup.addView(inflate);
                    view = inflate;
                } else {
                    view = findViewById;
                }
                view.setVisibility(0);
                av avVar2 = (av) view.getTag();
                charSequence = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_content");
                str2 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_username");
                CharSequence charSequence3 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
                String str3 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_time");
                e2 = bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
                avVar2.gsf.setText(j.b(avVar2.gsf.getContext(), charSequence));
                TextView textView = avVar2.zih;
                Context context = avVar2.gsf.getContext();
                if (bo.isNullOrNil(str2)) {
                    charSequence3 = "";
                } else {
                    nullAsNil3 = null;
                    if (com.tencent.mm.model.t.kH(str2)) {
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(str2);
                        if (aoO != null) {
                            nullAsNil3 = aoO.Oj() == null ? aoO.Oi() : aoO.Oj();
                        }
                    } else {
                        aw.ZK();
                        ad aoO2 = com.tencent.mm.model.c.XM().aoO(str2);
                        nullAsNil3 = aoO2.Oj() == null ? aoO2.Oi() : aoO2.Oj();
                    }
                    if (bo.isNullOrNil(nullAsNil3)) {
                        ab.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", str2, charSequence3);
                        if (charSequence3 == null) {
                            charSequence3 = ah.getContext().getString(R.string.ao1);
                        }
                    } else {
                        Object charSequence32 = nullAsNil3;
                    }
                }
                textView.setText(j.b(context, charSequence32));
                avVar2.ngD.setText(str3);
                if (e2 == 2) {
                    avVar2.iNr.setImageDrawable(ah.getContext().getResources().getDrawable(R.drawable.avo));
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.b(avVar2.iNr, str2);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                i4 = 0;
                e = 0;
                while (e < 100) {
                    String concat = e == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(e));
                    nullAsNil2 = (String) z.get(concat + ".value.word");
                    nullAsNil3 = (String) z.get(concat + ".key.word");
                    if (bo.isNullOrNil(nullAsNil2) && bo.isNullOrNil(nullAsNil3)) {
                        ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", Integer.valueOf(e));
                        break;
                    }
                    ba baVar = new ba();
                    baVar.ziD = nullAsNil2;
                    baVar.ziC = bo.nullAsNil(nullAsNil3);
                    baVar.ziE = e(z, concat + ".key.color", zeU);
                    baVar.ziF = e(z, concat + ".value.color", WebView.NIGHT_MODE_COLOR);
                    baVar.ziG = bo.getInt((String) z.get(new StringBuilder().append(concat).append(".key.hide").toString()), 0) != 0;
                    paddingLeft = (arE(baVar.ziC) + 1) / 2;
                    if (paddingLeft <= i4) {
                        paddingLeft = i4;
                    }
                    arrayList.add(baVar);
                    e++;
                    i4 = paddingLeft;
                }
                if (i4 > 8) {
                    i5 = 8;
                } else {
                    i5 = i4;
                }
                LinearLayout linearLayout = bdVar.zjd;
                linearLayout.setVisibility(0);
                view = ((ViewGroup) bdVar.zjd.getParent()).findViewById(R.id.c7d);
                if (view != null) {
                    view.setVisibility(8);
                }
                if (linearLayout.getChildCount() > arrayList.size()) {
                    if (arrayList.size() == 0) {
                        linearLayout.removeAllViews();
                    } else {
                        linearLayout.removeViews(arrayList.size(), linearLayout.getChildCount() - arrayList.size());
                    }
                }
                childCount = linearLayout.getChildCount();
                paddingLeft = 0;
                while (true) {
                    e = paddingLeft;
                    if (e >= arrayList.size()) {
                        break;
                    }
                    LinearLayout linearLayout2;
                    ba baVar2 = (ba) arrayList.get(e);
                    if (e < childCount) {
                        linearLayout2 = (LinearLayout) linearLayout.getChildAt(e);
                    } else {
                        linearLayout2 = (LinearLayout) LayoutInflater.from(this.yJI.yTx.getContext()).inflate(R.layout.l7, null, false);
                        bb bbVar = new bb();
                        bbVar.ziH = (TextView) linearLayout2.findViewById(R.id.am9);
                        bbVar.ziI = (TextView) linearLayout2.findViewById(R.id.am_);
                        linearLayout2.setTag(bbVar);
                        linearLayout.addView(linearLayout2);
                    }
                    bb bbVar2 = (bb) linearLayout2.getTag();
                    if (baVar2.ziG) {
                        bbVar2.ziH.setVisibility(8);
                    } else {
                        bbVar2.ziH.setVisibility(0);
                        bbVar2.ziH.setEms(i5);
                        bbVar2.ziH.setTextColor(baVar2.ziE);
                        bbVar2.ziH.setText(baVar2.ziC);
                    }
                    bbVar2.ziI.setTextColor(baVar2.ziF);
                    bbVar2.ziI.setText(baVar2.ziD);
                    paddingLeft = e + 1;
                }
                if (linearLayout.getChildCount() == 0) {
                    bdVar.zjc.setVisibility(8);
                    linearLayout.setVisibility(8);
                } else {
                    if (bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
                        bdVar.zjc.setVisibility(8);
                    } else {
                        bdVar.zjc.setVisibility(0);
                    }
                    linearLayout.setVisibility(0);
                }
            }
            if (bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0) {
                bdVar.zjq.setVisibility(8);
                bdVar.zjf.setVisibility(8);
                bdVar.zjh.setVisibility(8);
                bdVar.zjg.setVisibility(0);
                bdVar.zje.setVisibility(0);
                a(bdVar, biVar, z);
            } else {
                final String nullAsNil4;
                final String str4;
                final String str5;
                final String str6;
                final int i7;
                bdVar.zjg.setVisibility(8);
                nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
                nullAsNil3 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
                if (bo.isNullOrNil(nullAsNil2)) {
                    bdVar.zji.setVisibility(8);
                } else {
                    bdVar.zjl.setTextColor(e(z, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", WebView.NIGHT_MODE_COLOR));
                    bdVar.zjl.setText(nullAsNil2);
                    if (bo.isNullOrNil(nullAsNil3)) {
                        bdVar.zjn.setVisibility(8);
                        bdVar.zjl.setPadding(0, 0, 0, 0);
                    } else {
                        bdVar.zjn.setVisibility(0);
                        h(bdVar.zjn, nullAsNil3);
                        bdVar.zjl.setPadding(0, 0, com.tencent.mm.bz.a.fromDPToPix(this.yJI.yTx.getContext(), 16), 0);
                    }
                    nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    nullAsNil4 = bo.nullAsNil((String) z.get(".msg.fromusername"));
                    i4 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                    str4 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                    ayVar2 = new ay(biVar, nullAsNil4, nullAsNil2);
                    bdVar.zji.setTag(ayVar2);
                    bdVar.zjq.setTag(ayVar2);
                    if (i4 != 1 || TextUtils.isEmpty(str4)) {
                        str5 = nullAsNil4;
                        bdVar.zji.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(33130);
                                if (!bo.isNullOrNil(nullAsNil2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", nullAsNil2);
                                    com.tencent.mm.bp.d.b(w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, str5, Integer.valueOf(1));
                                }
                                AppMethodBeat.o(33130);
                            }
                        });
                        bdVar.zjq.setOnClickListener(null);
                    } else {
                        str6 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                        i7 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                        childCount = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                        nullAsNil = bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                        AnonymousClass3 anonymousClass3 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(33129);
                                ay ayVar = (ay) view.getTag();
                                ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str4);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.cst = ayVar.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
                                if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(ayVar.userName)) {
                                    appBrandStatObject.scene = w.arF(nullAsNil);
                                    ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                                    com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(ayVar.userName);
                                    ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject, qX == null ? null : qX.field_appId);
                                }
                                w.M(9, w.this.mAppId, w.this.zeS);
                                com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, nullAsNil4, Integer.valueOf(1));
                                AppMethodBeat.o(33129);
                            }
                        };
                        bdVar.zji.setOnClickListener(anonymousClass3);
                        bdVar.zjq.setOnClickListener(anonymousClass3);
                    }
                    bdVar.zji.setVisibility(0);
                }
                nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (bo.isNullOrNil(nullAsNil2)) {
                    bdVar.zjj.setVisibility(8);
                } else {
                    bdVar.zjm.setTextColor(e(z, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", WebView.NIGHT_MODE_COLOR));
                    bdVar.zjm.setText(nullAsNil2);
                    if (bo.isNullOrNil(str2)) {
                        bdVar.zjo.setVisibility(8);
                        bdVar.zjm.setPadding(0, 0, 0, 0);
                    } else {
                        bdVar.zjo.setVisibility(0);
                        h(bdVar.zjo, str2);
                        bdVar.zjm.setPadding(0, 0, com.tencent.mm.bz.a.fromDPToPix(this.yJI.yTx.getContext(), 16), 0);
                    }
                    nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                    nullAsNil4 = bo.nullAsNil((String) z.get(".msg.fromusername"));
                    i5 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                    str4 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                    bdVar.zjj.setTag(new ay(biVar, nullAsNil4, nullAsNil2));
                    if (i5 != 1 || TextUtils.isEmpty(str4)) {
                        str5 = nullAsNil4;
                        bdVar.zjj.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(33132);
                                if (!bo.isNullOrNil(nullAsNil2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", nullAsNil2);
                                    com.tencent.mm.bp.d.b(w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, str5, Integer.valueOf(2));
                                }
                                AppMethodBeat.o(33132);
                            }
                        });
                    } else {
                        str6 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                        i7 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                        childCount = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                        nullAsNil = bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                        bdVar.zjj.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(33131);
                                ay ayVar = (ay) view.getTag();
                                ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str4);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.cst = ayVar.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
                                if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(ayVar.userName)) {
                                    appBrandStatObject.scene = w.arF(nullAsNil);
                                    ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                                    com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(ayVar.userName);
                                    ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject, qX == null ? null : qX.field_appId);
                                }
                                w.M(9, w.this.mAppId, w.this.zeS);
                                com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, nullAsNil4, Integer.valueOf(2));
                                AppMethodBeat.o(33131);
                            }
                        });
                    }
                    bdVar.zjj.setVisibility(0);
                }
                bdVar.zjp.setVisibility(8);
                if (bdVar.zji.getVisibility() == 8 && bdVar.zjj.getVisibility() == 8) {
                    bdVar.zjf.setVisibility(8);
                    bdVar.zje.setVisibility(8);
                    bdVar.zjh.setVisibility(8);
                } else {
                    bdVar.zjh.setVisibility(0);
                    paddingLeft = this.yJI.yTx.getMMResources().getDimensionPixelOffset(R.dimen.l5);
                    if (bdVar.zji.getVisibility() == 0 && bdVar.zjj.getVisibility() == 0) {
                        bdVar.zji.setGravity(17);
                        bdVar.zjj.setGravity(17);
                        bdVar.zji.setPadding(paddingLeft, 0, paddingLeft, 0);
                        bdVar.zjj.setPadding(paddingLeft, 0, paddingLeft, 0);
                    } else if (bdVar.zji.getVisibility() == 0) {
                        if (bo.isNullOrNil(nullAsNil3)) {
                            bdVar.zji.setGravity(19);
                            bdVar.zji.setPadding(paddingLeft, 0, 0, 0);
                            bdVar.zjp.setVisibility(0);
                        } else {
                            bdVar.zji.setGravity(17);
                            bdVar.zji.setPadding(paddingLeft, 0, paddingLeft, 0);
                        }
                    } else if (bo.isNullOrNil(str2)) {
                        bdVar.zjj.setGravity(19);
                        bdVar.zjj.setPadding(this.yJI.yTx.getMMResources().getDimensionPixelOffset(R.dimen.l5), 0, 0, 0);
                        bdVar.zjp.setVisibility(0);
                    } else {
                        bdVar.zjj.setGravity(17);
                        bdVar.zjj.setPadding(paddingLeft, 0, paddingLeft, 0);
                    }
                    bdVar.zjf.setVisibility(0);
                    bdVar.zje.setVisibility(0);
                }
                if (bdVar.zji.getVisibility() == 0 && bdVar.zjj.getVisibility() == 0) {
                    bdVar.zjk.setVisibility(0);
                } else {
                    bdVar.zjk.setVisibility(8);
                }
                nullAsNil3 = bo.nullAsNil((String) z.get(".msg.fromusername"));
                i4 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if (!ad.mg(nullAsNil3) && bdVar.zji.getVisibility() != 8 && bdVar.zjj.getVisibility() == 8 && i4 == 1 && ad.mg(nullAsNil2)) {
                    WxaAttributes zb2 = ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(nullAsNil2);
                    str2 = zb2 == null ? null : zb2.field_brandIconURL;
                    charSequence = zb2 == null ? nullAsNil2 : zb2.field_nickname;
                    o.ahp().a(str2, bdVar.zjr, this.yqf);
                    bdVar.zjs.setText(charSequence);
                    if (zb2 == null) {
                        ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).a(nullAsNil2, new com.tencent.mm.plugin.appbrand.service.d.a() {
                            public final void d(WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(33134);
                                if (wxaAttributes == null) {
                                    AppMethodBeat.o(33134);
                                    return;
                                }
                                final String str = wxaAttributes.field_brandIconURL;
                                final String str2 = wxaAttributes.field_nickname;
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(33133);
                                        o.ahp().a(str, bdVar.zjr, w.this.yqf);
                                        bdVar.zjs.setText(TextUtils.isEmpty(str2) ? nullAsNil2 : str2);
                                        AppMethodBeat.o(33133);
                                    }
                                });
                                AppMethodBeat.o(33134);
                            }
                        });
                    }
                    bdVar.zjq.setVisibility(0);
                    bdVar.zjf.setVisibility(8);
                } else {
                    bdVar.zjq.setVisibility(8);
                }
            }
            String nullAsNil5 = bo.nullAsNil((String) z.get(".msg.fromusername"));
            String str7 = null;
            if (!bo.isNullOrNil(nullAsNil5)) {
                aw.ZK();
                str7 = com.tencent.mm.model.c.XM().aoO(nullAsNil5).Oi();
            }
            String str8 = (String) z.get(".msg.appmsg.mmreader.category.item.title");
            String str9 = (String) z.get(".msg.appmsg.mmreader.category.item.url");
            nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.category.item.native_url");
            nullAsNil3 = (String) z.get(".msg.appmsg.template_id");
            str2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if (i6 == 1 && !TextUtils.isEmpty(str2)) {
                ayVar = new ay(biVar, nullAsNil5, str9);
                ayVar.position = i;
                bdVar.ziK.setTag(ayVar);
                bdVar.ziK.setOnClickListener(this.lBl);
            } else if (i6 == -1 && ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(nullAsNil5)) {
                str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                View view2 = bdVar.ziK;
                ayVar2 = new ay(biVar, false, i, nullAsNil5, false, this.yJI.dDw(), nullAsNil5, str7, str8);
                ayVar2.cRS = nullAsNil2;
                ayVar2.hzj = str2;
                view2.setTag(ayVar2);
                bdVar.ziK.setOnClickListener(this.zeP);
            } else if (i6 == 2) {
                ayVar = new ay(biVar, nullAsNil5, str9);
                ayVar.position = i;
                bdVar.ziK.setTag(ayVar);
                bdVar.ziK.setOnClickListener(this.lBl);
            } else {
                inflate = bdVar.ziK;
                ay ayVar3 = new ay(biVar, false, i, str9, false, this.yJI.dDw(), nullAsNil5, str7, str8);
                ayVar3.cRS = nullAsNil2;
                inflate.setTag(ayVar3);
                bdVar.ziK.setOnClickListener(h(this.yJI));
            }
            bdVar.ziK.setOnLongClickListener(c(this.yJI));
            bdVar.ziK.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
            if (com.tencent.mm.m.g.Nv().Nk()) {
                aVar.zbW.setVisibility(0);
                c.c(this.yJI, aVar.zbW, new com.tencent.mm.ui.chatting.s.o(nullAsNil3, biVar, str7));
            }
            if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(bo.nullAsNil((String) z.get(".msg.fromusername"))) && "notifymessage".equals(biVar.field_talker)) {
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
                bdVar.ziS.setTag(null);
                bdVar.ziS.setVisibility(8);
            } else {
                if ((bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
                    ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
                } else if (bdVar.ziM.getVisibility() == 0) {
                    bdVar.ziR.setTag(biVar);
                    bdVar.ziR.setOnClickListener(this.zeN);
                    bdVar.ziR.setVisibility(0);
                    bdVar.ziS.setVisibility(8);
                } else if (bdVar.ziW.getVisibility() == 0) {
                    bdVar.ziS.setTag(biVar);
                    bdVar.ziS.setOnClickListener(this.zeN);
                    bdVar.ziS.setVisibility(0);
                    bdVar.ziR.setVisibility(8);
                }
                bdVar.ziR.setTag(null);
                bdVar.ziS.setTag(null);
                bdVar.ziR.setVisibility(8);
                bdVar.ziS.setVisibility(8);
            }
            aVar.zij.ziK.setVisibility(0);
            AppMethodBeat.o(33159);
            return;
        }
        aVar.zij.ziK.setVisibility(8);
        nullAsNil = bo.nullAsNil((String) z.get(".msg.fromusername"));
        int i8 = bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
        ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", Integer.valueOf(i8));
        if (i8 == 1) {
            nullAsNil3 = bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            c.a(aVar, (CharSequence) j.b(this.yJI.yTx.getContext(), bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), aVar.qkY.getTextSize()));
            aVar.zbv.setTag(null);
            aVar.zbv.setOnClickListener(null);
            o.ahp().a(nullAsNil3, aVar.zbv, this.yqf);
        } else {
            a(aVar, this.yJI, biVar, nullAsNil);
            a(aVar.zbv, this.yJI, nullAsNil, biVar, null);
            if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(nullAsNil)) {
                aVar.zii.zil.setTag(new ay(biVar, nullAsNil));
                aVar.zii.zil.setOnClickListener(this.zeO);
            } else {
                aVar.zii.zil.setTag(new ay(nullAsNil, this.yJI.dFx() ? this.yJI.getTalkerUserName() : null));
                aVar.zii.zil.setOnClickListener(e(this.yJI));
            }
        }
        ab.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", biVar.field_talker);
        if ("notifymessage".equals(biVar.field_talker) || i8 == 1) {
            aVar.zii.zil.setVisibility(0);
            aVar.zii.gsf.setTextSize(0, (float) com.tencent.mm.bz.a.al(aVar.zii.gsf.getContext(), R.dimen.m5));
        } else {
            aVar.zii.zil.setVisibility(8);
            aVar.zii.gsf.setTextSize(0, (float) com.tencent.mm.bz.a.al(aVar.zii.gsf.getContext(), R.dimen.dk));
        }
        aVar.zii.jOR.setVisibility(0);
        b aX = b.aX(z);
        aVar.zii.gsf.setText(aX.title);
        aVar.zii.ngD.setText(com.tencent.mm.pluginsdk.f.h.formatTime(this.yJI.yTx.getMMResources().getString(R.string.bww), aX.time));
        x.a(aVar.zii.ziq, z);
        String str10 = null;
        if (!bo.isNullOrNil(nullAsNil)) {
            aw.ZK();
            str10 = com.tencent.mm.model.c.XM().aoO(nullAsNil).Oi();
        }
        Object obj = !bo.isNullOrNil(aX.url) ? 1 : null;
        nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
        if (bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0) != 1 || TextUtils.isEmpty(nullAsNil2)) {
            view = aVar.zii.jOR;
            ay ayVar4 = new ay(biVar, false, i, aX.url, false, this.yJI.dDw(), nullAsNil, str10, aX.title);
            ayVar4.cRS = aX.cRS;
            view.setTag(ayVar4);
            aVar.zii.jOR.setOnClickListener(h(this.yJI));
        } else {
            ayVar = new ay(biVar, nullAsNil, aX.url);
            ayVar.position = i;
            aVar.zii.jOR.setTag(ayVar);
            aVar.zii.jOR.setOnClickListener(this.lBl);
            obj = 1;
        }
        aVar.zii.jOR.setOnLongClickListener(c(this.yJI));
        aVar.zii.jOR.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
        if (obj == null) {
            aVar.zii.zir.setVisibility(8);
            aVar.zii.zio.setVisibility(8);
        } else {
            aVar.zii.zir.setVisibility(0);
            aVar.zii.zio.setVisibility(0);
        }
        if (com.tencent.mm.m.g.Nv().Nk()) {
            aVar.zbW.setVisibility(0);
            c.c(this.yJI, aVar.zbW, new com.tencent.mm.ui.chatting.s.o(aX.fhu, biVar, str10));
        }
        ax axVar = aVar.zii;
        if ((bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
            ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            axVar.zim.setTag(null);
            axVar.zin.setTag(null);
            axVar.zim.setVisibility(8);
            axVar.zin.setVisibility(8);
        } else if (axVar.zil.getVisibility() == 0) {
            axVar.zim.setTag(biVar);
            axVar.zim.setOnClickListener(this.zeN);
            axVar.zim.setVisibility(0);
            axVar.zin.setVisibility(8);
        } else {
            axVar.zin.setTag(biVar);
            axVar.zin.setOnClickListener(this.zeN);
            axVar.zin.setVisibility(0);
            axVar.zim.setVisibility(8);
        }
        aVar.zii.jOR.setVisibility(0);
        AppMethodBeat.o(33159);
    }

    public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33160);
        ay ayVar = (ay) view.getTag();
        if (ayVar == null) {
            AppMethodBeat.o(33160);
            return false;
        }
        int i = ayVar.position;
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
        }
        AppMethodBeat.o(33160);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHn() {
        return this.zeT == 0;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        AppMethodBeat.i(33161);
        menuItem.getItemId();
        AppMethodBeat.o(33161);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
        AppMethodBeat.i(33162);
        if (str == null || aVar.qkY == null) {
            AppMethodBeat.o(33162);
            return;
        }
        c.a(aVar, (CharSequence) j.b(aVar2.yTx.getContext(), ((com.tencent.mm.ui.chatting.c.b.f) aVar2.aF(com.tencent.mm.ui.chatting.c.b.f.class)).arj(str), aVar.qkY.getTextSize()));
        AppMethodBeat.o(33162);
    }

    private void a(ImageView imageView, com.tencent.mm.ui.chatting.d.a aVar, String str, bi biVar, String str2) {
        AppMethodBeat.i(33163);
        if (imageView == null) {
            AppMethodBeat.o(33163);
        } else if (com.tencent.mm.model.t.nI(str)) {
            imageView.setVisibility(8);
            AppMethodBeat.o(33163);
        } else {
            imageView.setVisibility(0);
            if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(str)) {
                o.ahp().a(str2, imageView, this.yqf);
                imageView.setTag(new ay(biVar, str));
                imageView.setOnClickListener(this.zeO);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.r(imageView, str);
                imageView.setTag(new ay(str, aVar.dFx() ? aVar.getTalkerUserName() : null));
                imageView.setOnClickListener(e(aVar));
            }
            imageView.setOnLongClickListener(f(aVar));
            imageView.setContentDescription(com.tencent.mm.model.s.mJ(str) + aVar.yTx.getContext().getString(R.string.x9));
            AppMethodBeat.o(33163);
        }
    }

    private void a(bd bdVar, String str, String str2, Map<String, String> map, bi biVar, boolean z) {
        AppMethodBeat.i(33164);
        bdVar.ziO.setText(j.b(this.yJI.yTx.getContext(), (CharSequence) str2, bdVar.ziO.getTextSize()));
        o.ahp().a(str, bdVar.ziN, this.yqf);
        bdVar.ziN.setTag(null);
        bdVar.ziN.setOnClickListener(null);
        bdVar.ziM.setTag(null);
        bdVar.ziM.setOnClickListener(null);
        bdVar.ziM.setVisibility(0);
        String nullAsNil = bo.nullAsNil((String) map.get(".msg.appmsg.mmreader.template_header.weapp_username"));
        String nullAsNil2 = bo.nullAsNil((String) map.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
        if (bo.isNullOrNil(nullAsNil) && bo.isNullOrNil(nullAsNil2)) {
            bdVar.ziM.setOnClickListener(null);
        } else {
            bdVar.ziM.setTag(new ay(biVar, bo.nullAsNil((String) map.get(".msg.fromusername"))));
            bdVar.ziM.setOnClickListener(this.zeR);
        }
        nullAsNil = bo.nullAsNil((String) map.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
        if (!z || bo.isNullOrNil(nullAsNil)) {
            ((View) bdVar.ziQ.getParent()).setVisibility(8);
            AppMethodBeat.o(33164);
            return;
        }
        ((View) bdVar.ziQ.getParent()).setVisibility(0);
        o.ahp().a(nullAsNil, bdVar.ziQ, this.yqf);
        AppMethodBeat.o(33164);
    }

    private void a(Map<String, String> map, bi biVar, bd bdVar, boolean z, boolean z2) {
        AppMethodBeat.i(33165);
        bdVar.zjt.setVisibility(z ? 0 : 8);
        if (z2) {
            bdVar.ziP.setVisibility(0);
            bdVar.zju.setText(this.yJI.yTx.getMMResources().getString(R.string.d_y));
        } else {
            bdVar.ziP.setVisibility(8);
            bdVar.zju.setText(this.yJI.yTx.getMMResources().getString(R.string.d_g));
        }
        bdVar.zjt.setTag(R.id.aov, biVar);
        final Map<String, String> map2 = map;
        final boolean z3 = z2;
        final bd bdVar2 = bdVar;
        final bi biVar2 = biVar;
        bdVar.zjt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33150);
                final String nullAsNil = bo.nullAsNil((String) map2.get(".msg.fromusername"));
                d dVar = new d(w.this.yJI.yTx.getContext(), 1, true);
                if (z3) {
                    dVar.q(w.this.yJI.yTx.getMMResources().getString(R.string.d_z), 3);
                } else {
                    dVar.q(w.this.yJI.yTx.getMMResources().getString(R.string.d_j), 3);
                }
                dVar.rBl = new n.c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        AppMethodBeat.i(33148);
                        if (z3) {
                            lVar.a(1, w.this.yJI.yTx.getMMResources().getColor(R.color.hi), w.this.yJI.yTx.getMMResources().getString(R.string.d_x));
                            AppMethodBeat.o(33148);
                            return;
                        }
                        lVar.a(0, w.this.yJI.yTx.getMMResources().getColor(R.color.y0), w.this.yJI.yTx.getMMResources().getString(R.string.d_i));
                        AppMethodBeat.o(33148);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(33149);
                        switch (menuItem.getItemId()) {
                            case 0:
                                w.a(w.this, true, bdVar2, nullAsNil, biVar2);
                                AppMethodBeat.o(33149);
                                return;
                            case 1:
                                w.a(w.this, false, bdVar2, nullAsNil, biVar2);
                                break;
                        }
                        AppMethodBeat.o(33149);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(33150);
            }
        });
        AppMethodBeat.o(33165);
    }

    private void a(bd bdVar, bi biVar, Map<String, String> map) {
        AppMethodBeat.i(33166);
        LinearLayout linearLayout = bdVar.zjg;
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                break;
            }
            String concat = i2 == 0 ? ".msg.appmsg.mmreader.template_detail.opitems.opitem" : ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i2));
            String str = (String) map.get(concat + ".word");
            String str2 = (String) map.get(concat + ".hint_word");
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", Integer.valueOf(i2));
                i = linearLayout.getChildCount();
                if (i > i2) {
                    if (i2 == 0) {
                        linearLayout.removeAllViews();
                        AppMethodBeat.o(33166);
                        return;
                    }
                    linearLayout.removeViews(i2, i - i2);
                    AppMethodBeat.o(33166);
                    return;
                }
            } else {
                LinearLayout linearLayout2;
                if (i2 < childCount) {
                    linearLayout2 = (LinearLayout) linearLayout.getChildAt(i2);
                } else {
                    linearLayout2 = (LinearLayout) LayoutInflater.from(this.yJI.yTx.getContext()).inflate(R.layout.l6, null, false);
                    a aVar = new a();
                    aVar.gsf = (TextView) linearLayout2.findViewById(R.id.am5);
                    aVar.iNr = (ImageView) linearLayout2.findViewById(R.id.am6);
                    aVar.zbb = (LinearLayout) linearLayout2.findViewById(R.id.am3);
                    aVar.grM = (TextView) linearLayout2.findViewById(R.id.am7);
                    linearLayout2.setTag(aVar);
                    linearLayout.addView(linearLayout2);
                }
                a aVar2 = (a) linearLayout2.getTag();
                String str3 = (String) map.get(concat + ".icon");
                aVar2.gsf.setTextColor(e(map, concat + ".color", WebView.NIGHT_MODE_COLOR));
                if (bo.getInt((String) map.get(concat + ".is_rich_text"), 0) == 0) {
                    aVar2.gsf.setSingleLine(true);
                    aVar2.gsf.setEllipsize(TruncateAt.END);
                    aVar2.gsf.setText(str);
                } else {
                    ab.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", Integer.valueOf(bo.getInt((String) map.get(concat + ".display_line_number"), 1)));
                    aVar2.gsf.setSingleLine(false);
                    aVar2.gsf.setText(str);
                    aVar2.gsf.setMaxLines(r4);
                    j.a(aVar2.gsf, false, null);
                }
                aVar2.grM.setText(str2);
                if (bo.isNullOrNil(str3)) {
                    aVar2.iNr.setVisibility(8);
                    aVar2.gsf.setPadding(0, 0, 0, 0);
                } else {
                    aVar2.iNr.setVisibility(0);
                    h(aVar2.iNr, str3);
                    aVar2.gsf.setPadding(0, 0, com.tencent.mm.bz.a.fromDPToPix(this.yJI.yTx.getContext(), 28), 0);
                }
                str = (String) map.get(concat + ".url");
                final String nullAsNil = bo.nullAsNil((String) map.get(".msg.fromusername"));
                int i3 = bo.getInt((String) map.get(concat + ".op_type"), 0);
                str3 = (String) map.get(concat + ".weapp_username");
                aVar2.zbb.setTag(new ay(biVar, nullAsNil, str));
                final int i4 = i2 + 1;
                if (i3 == 1 && !TextUtils.isEmpty(str3)) {
                    final String str4 = (String) map.get(concat + ".weapp_path");
                    final int i5 = bo.getInt((String) map.get(concat + ".weapp_version"), 0);
                    final int i6 = bo.getInt((String) map.get(concat + ".weapp_state"), 0);
                    final String nullAsNil2 = bo.nullAsNil((String) map.get(".msg.appmsg.template_id"));
                    aVar2.zbb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(33135);
                            ay ayVar = (ay) view.getTag();
                            ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str3);
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.cst = ayVar.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil2;
                            if (((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).mg(ayVar.userName)) {
                                appBrandStatObject.scene = w.arF(nullAsNil2);
                                ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str3, null, i6, i5, str4, appBrandStatObject);
                            } else {
                                appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                                com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(ayVar.userName);
                                ((e) g.K(e.class)).a(w.this.yJI.yTx.getContext(), str3, null, i6, i5, str4, appBrandStatObject, qX == null ? null : qX.field_appId);
                            }
                            w.M(9, w.this.mAppId, w.this.zeS);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, nullAsNil, Integer.valueOf(i4));
                            AppMethodBeat.o(33135);
                        }
                    });
                } else if (i3 == 2) {
                    final Map<String, String> map2 = map;
                    aVar2.zbb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(33136);
                            if (i4 == 1) {
                                w.b(view.getContext(), (String) map2.get(".msg.appmsg.mmreader.category.item.schedule_username"), bo.getLong((String) map2.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
                                com.tencent.mm.plugin.report.service.h.pYm.a(795, 2, 1, false);
                                ab.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", r0, Long.valueOf(r10));
                                AppMethodBeat.o(33136);
                                return;
                            }
                            if (i4 == 2) {
                                com.tencent.mm.bp.d.f(view.getContext(), ".ui.AllRemindMsgUI", new Intent());
                            }
                            AppMethodBeat.o(33136);
                        }
                    });
                } else {
                    aVar2.zbb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(33137);
                            if (!bo.isNullOrNil(str)) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str);
                                com.tencent.mm.bp.d.b(w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                com.tencent.mm.plugin.report.service.h.pYm.e(11608, w.this.zeS, nullAsNil, Integer.valueOf(i4));
                            }
                            AppMethodBeat.o(33137);
                        }
                    });
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(33166);
    }

    private static void h(ImageView imageView, String str) {
        AppMethodBeat.i(33167);
        if (bo.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.o(33167);
            return;
        }
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aw.ZK();
        aVar.ePK = com.tencent.mm.model.c.XX();
        aVar.ePH = true;
        aVar.ePZ = true;
        o.ahp().a(str, imageView, aVar.ahG());
        AppMethodBeat.o(33167);
    }

    private static void L(int i, String str, String str2) {
        AppMethodBeat.i(33168);
        ab.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", Integer.valueOf(13796), Integer.valueOf(i), str, str2);
        com.tencent.mm.plugin.report.service.h.pYm.e(13796, Integer.valueOf(i), str, str2, Integer.valueOf(0), Long.valueOf(bo.anT()));
        AppMethodBeat.o(33168);
    }

    static {
        AppMethodBeat.i(33177);
        AppMethodBeat.o(33177);
    }

    private static int e(Map<String, String> map, String str, int i) {
        AppMethodBeat.i(33169);
        if (map == null || bo.isNullOrNil(str)) {
            AppMethodBeat.o(33169);
        } else {
            try {
                i = Color.parseColor(bo.nullAsNil((String) map.get(str)));
            } catch (Exception e) {
            }
            AppMethodBeat.o(33169);
        }
        return i;
    }

    private static int arE(String str) {
        int i = 0;
        AppMethodBeat.i(33170);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(33170);
            return 0;
        }
        String str2 = "[Α-￥]";
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                if (str.substring(i2, i2 + 1).matches(str2)) {
                    i = i3 + 2;
                } else {
                    i = i3 + 1;
                }
                i2++;
            } else {
                AppMethodBeat.o(33170);
                return i3;
            }
        }
    }

    static /* synthetic */ int arF(String str) {
        AppMethodBeat.i(33172);
        if (str == null || !str.startsWith("SUBSCRIPTION")) {
            AppMethodBeat.o(33172);
            return 1014;
        }
        AppMethodBeat.o(33172);
        return 1107;
    }
}
