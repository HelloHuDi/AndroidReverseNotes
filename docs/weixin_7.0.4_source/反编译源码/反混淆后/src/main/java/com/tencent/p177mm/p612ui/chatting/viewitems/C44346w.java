package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C37935s;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C37758lo;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C30719l;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5366o;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7336g;
import com.tencent.p177mm.p612ui.chatting.view.AvatarImageView;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.service.C42686d.C38509a;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.protocal.protobuf.cya;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.w */
public final class C44346w extends C5378c {
    static int zeU = Color.parseColor("#888888");
    static int zeV = Color.parseColor("#888888");
    private OnClickListener lBl;
    private String mAppId;
    private C44275p sfa;
    private C46650a yJI;
    private C4884c<C37758lo> yTn;
    private C25814c yqf;
    private OnClickListener zeM;
    private OnClickListener zeN;
    private OnClickListener zeO;
    private OnClickListener zeP;
    private C30719l zeQ;
    private OnClickListener zeR;
    private String zeS;
    private int zeT;

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$11 */
    class C542411 implements OnClickListener {
        C542411() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33138);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", c40814ay.userName);
            Map z = C5049br.m7595z(c40814ay.cKd.field_content, "msg");
            String nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
            C7060h.pYm.mo8381e(11608, C44346w.this.zeS, nullAsNil, Integer.valueOf(66666));
            String nullAsNil2 = C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.weapp_username"));
            if (C5046bo.isNullOrNil(nullAsNil2)) {
                String nullAsNil3 = C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
                if (!C5046bo.isNullOrNil(nullAsNil3)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", nullAsNil3);
                    C25985d.m41467b(C44346w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.m2505o(33138);
                return;
            }
            String nullAsNil4 = C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.weapp_path"));
            int i = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
            int i2 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
            nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.cst = c40814ay.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C44346w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
            appBrandStatObject.scene = C44346w.arF(nullAsNil);
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C44346w.this.yJI.yTx.getContext(), nullAsNil2, null, i, i2, nullAsNil4, appBrandStatObject);
            AppMethodBeat.m2505o(33138);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$12 */
    class C542512 implements OnClickListener {
        C542512() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33139);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", c40814ay.userName);
            Map z = C5049br.m7595z(c40814ay.cKd.field_content, "msg");
            if (!(z == null || z.size() == 0)) {
                C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            }
            C44346w c44346w = C44346w.this;
            view.getContext();
            C44346w.m80151a(c44346w, c40814ay.userName);
            AppMethodBeat.m2505o(33139);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$14 */
    class C542614 implements C30719l {
        C542614() {
        }

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
            AppMethodBeat.m2504i(33143);
            C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
            C4879a.xxA.mo10053d(C44346w.this.yTn);
            if (C44346w.this.yJI != null) {
                ((C7336g) C44346w.this.yJI.mo74857aF(C7336g.class)).mo15846b(this);
            }
            AppMethodBeat.m2505o(33143);
        }

        public final void dxD() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$13 */
    class C734913 extends C4884c<C37758lo> {

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$13$1 */
        class C73501 implements Runnable {
            C73501() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33140);
                C44346w.this.yJI.aWv();
                AppMethodBeat.m2505o(33140);
            }
        }

        C734913() {
            AppMethodBeat.m2504i(33141);
            this.xxI = C37758lo.class.getName().hashCode();
            AppMethodBeat.m2505o(33141);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(33142);
            if (C44346w.this.yJI != null) {
                C44346w.this.yJI.yTx.getContext().runOnUiThread(new C73501());
            }
            AppMethodBeat.m2505o(33142);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$1 */
    class C306251 implements OnClickListener {
        C306251() {
        }

        public final void onClick(final View view) {
            AppMethodBeat.m2504i(33127);
            final C7620bi c7620bi = (C7620bi) view.getTag(2131822468);
            if (c7620bi == null) {
                C4990ab.m7420w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                AppMethodBeat.m2505o(33127);
                return;
            }
            Map z = C5049br.m7595z(c7620bi.field_content, "msg");
            if (z == null || z.size() == 0) {
                AppMethodBeat.m2505o(33127);
                return;
            }
            final String nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
            final int g = C5046bo.m7550g(z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
            final int g2 = C5046bo.m7550g(z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
            C36356d c36356d = new C36356d(view.getContext(), 1, false);
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(33122);
                    c44273l.add(0, 2, 0, view.getResources().getString(C25738R.string.d_o));
                    AppMethodBeat.m2505o(33122);
                }
            };
            final View view2 = view;
            c36356d.rBm = new C5279d() {

                /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$1$2$1 */
                class C306221 implements C1202f {
                    C306221() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(33124);
                        C9638aw.m17182Rg().mo14546b(1198, (C1202f) this);
                        C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.FALSE);
                        if (C44346w.this.sfa != null) {
                            C44346w.this.sfa.dismiss();
                            C44346w.this.sfa = null;
                        }
                        if (i == 0 && i2 == 0) {
                            cya abK = ((C37935s) c1207m).abK();
                            if (abK == null) {
                                C23639t.makeText(view2.getContext(), C25738R.string.d_p, 0).show();
                                AppMethodBeat.m2505o(33124);
                                return;
                            }
                            final String str2 = abK.xtv;
                            C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", nullAsNil);
                            ((C42686d) C1720g.m3528K(C42686d.class)).mo44615a(nullAsNil, new C38509a() {
                                /* renamed from: d */
                                public final void mo21701d(WxaAttributes wxaAttributes) {
                                    AppMethodBeat.m2504i(33123);
                                    if (wxaAttributes == null) {
                                        C23639t.makeText(view2.getContext(), C25738R.string.d_u, 0).show();
                                        AppMethodBeat.m2505o(33123);
                                        return;
                                    }
                                    if (TextUtils.isEmpty(wxaAttributes.field_appId) || TextUtils.isEmpty(str2)) {
                                        C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", r0, str2);
                                        C23639t.makeText(view2.getContext(), C25738R.string.d_u, 0).show();
                                        AppMethodBeat.m2505o(33123);
                                        return;
                                    }
                                    try {
                                        C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, r0, String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{URLEncoder.encode(r0, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), Integer.valueOf(1), Integer.valueOf(g), Integer.valueOf(g2)}));
                                        Intent intent = new Intent();
                                        intent.putExtra("rawUrl", r1);
                                        C25985d.m41467b(C44346w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                        AppMethodBeat.m2505o(33123);
                                    } catch (UnsupportedEncodingException e) {
                                        C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                        C23639t.makeText(view2.getContext(), C25738R.string.d_u, 0).show();
                                        AppMethodBeat.m2505o(33123);
                                    }
                                }
                            });
                            AppMethodBeat.m2505o(33124);
                            return;
                        }
                        C23639t.makeText(view2.getContext(), C25738R.string.d_p, 0).show();
                        AppMethodBeat.m2505o(33124);
                    }
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(33126);
                    C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                    switch (menuItem.getItemId()) {
                        case 2:
                            C9638aw.m17182Rg().mo14539a(1198, new C306221());
                            final C1207m c37935s = new C37935s(c7620bi.field_content);
                            C44346w c44346w = C44346w.this;
                            Context context = view2.getContext();
                            view2.getResources().getString(C25738R.string.f9238tz);
                            c44346w.sfa = C30379h.m48458b(context, view2.getResources().getString(C25738R.string.f9260un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(33125);
                                    C9638aw.m17182Rg().mo14547c(c37935s);
                                    AppMethodBeat.m2505o(33125);
                                }
                            });
                            C9638aw.m17182Rg().mo14541a(c37935s, 0);
                            C44346w.m80145M(4, C44346w.this.mAppId, C44346w.this.zeS);
                            break;
                    }
                    AppMethodBeat.m2505o(33126);
                }
            };
            c36356d.cpD();
            AppMethodBeat.m2505o(33127);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$16 */
    class C4082416 implements OnClickListener {
        C4082416() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33145);
            C40814ay c40814ay = (C40814ay) view.getTag();
            Map z = C5049br.m7595z(c40814ay.cKd.field_content, "msg");
            if (z == null) {
                C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
                AppMethodBeat.m2505o(33145);
                return;
            }
            int i = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i == 1) {
                String str = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
                String str2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_path");
                int i2 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
                int i3 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
                String nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", str);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.cst = c40814ay.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C44346w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
                if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(c40814ay.userName)) {
                    appBrandStatObject.scene = C44346w.arF(nullAsNil);
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C44346w.this.yJI.yTx.getContext(), str, null, i3, i2, str2, appBrandStatObject);
                } else {
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                    C16527d qX = C17903f.m28104qX(c40814ay.userName);
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(C44346w.this.yJI.yTx.getContext(), str, null, i3, i2, str2, appBrandStatObject, qX == null ? null : qX.field_appId);
                }
                C44346w.m80145M(9, C44346w.this.mAppId, C44346w.this.zeS);
                C7060h.pYm.mo8381e(11608, C44346w.this.zeS, c40814ay.userName, Integer.valueOf(0));
                AppMethodBeat.m2505o(33145);
                return;
            }
            if (i == 2) {
                C44346w.m80157b(view.getContext(), (String) z.get(".msg.appmsg.mmreader.category.item.schedule_username"), C5046bo.getLong((String) z.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
                C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", r0, Long.valueOf(r2));
            }
            AppMethodBeat.m2505o(33145);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$b */
    public static class C40828b {
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

        /* renamed from: aX */
        public static C40828b m70757aX(Map<String, String> map) {
            AppMethodBeat.m2504i(33156);
            C40828b c40828b = new C40828b();
            c40828b.title = (String) map.get(".msg.appmsg.mmreader.category.item.title");
            c40828b.url = (String) map.get(".msg.appmsg.mmreader.category.item.url");
            c40828b.cRS = (String) map.get(".msg.appmsg.mmreader.category.item.native_url");
            c40828b.fjv = (String) map.get(".msg.appmsg.mmreader.category.item.shorturl");
            c40828b.fjw = (String) map.get(".msg.appmsg.mmreader.category.item.longurl");
            c40828b.time = C5046bo.getLong((String) map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
            c40828b.fjx = (String) map.get(".msg.appmsg.mmreader.category.item.cover");
            c40828b.fjy = (String) map.get(".msg.appmsg.mmreader.category.item.tweetid");
            c40828b.fjz = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
            c40828b.type = C5046bo.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            c40828b.fhu = (String) map.get(".msg.appmsg.template_id");
            AppMethodBeat.m2505o(33156);
            return c40828b;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$15 */
    class C4434715 implements OnClickListener {
        C4434715() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33144);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", c40814ay.userName);
            C32628se c32628se = new C32628se();
            c32628se.cOf.userName = c40814ay.userName;
            c32628se.cOf.cOh = c40814ay.hzj;
            Map z = C5049br.m7595z(c40814ay.cKd.field_content, "msg");
            String str = "";
            if (z != null && z.size() > 0) {
                c32628se.cOf.cOi = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                str = C5046bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
            }
            c32628se.cOf.cOl = true;
            c32628se.cOf.scene = C44346w.arF(str);
            c32628se.cOf.cst = c40814ay.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C44346w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str;
            C4879a.xxA.mo10055m(c32628se);
            C44346w.m80145M(9, C44346w.this.mAppId, C44346w.this.zeS);
            C7060h.pYm.mo8381e(11608, C44346w.this.zeS, c40814ay.userName, Integer.valueOf(0));
            AppMethodBeat.m2505o(33144);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$a */
    final class C44351a implements OnClickListener {
        private C44351a() {
        }

        /* synthetic */ C44351a(C44346w c44346w, byte b) {
            this();
        }

        public final void onClick(final View view) {
            AppMethodBeat.m2504i(33155);
            if (view.getTag() instanceof C7620bi) {
                final C7620bi c7620bi = (C7620bi) view.getTag();
                if (c7620bi == null) {
                    C4990ab.m7420w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
                    AppMethodBeat.m2505o(33155);
                    return;
                }
                Map z = C5049br.m7595z(c7620bi.field_content, "msg");
                if (z == null || z.size() == 0) {
                    C4990ab.m7420w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
                    AppMethodBeat.m2505o(33155);
                    return;
                }
                final String nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
                C36356d c36356d = new C36356d(view.getContext(), 1, false);
                c36356d.rBl = new C36073c() {
                    /* renamed from: a */
                    public final void mo5746a(C44273l c44273l) {
                        AppMethodBeat.m2504i(33151);
                        c44273l.add(0, 1, 0, view.getResources().getString(C25738R.string.d_o));
                        AppMethodBeat.m2505o(33151);
                    }
                };
                c36356d.rBm = new C5279d() {

                    /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$a$2$1 */
                    class C443441 implements C1202f {
                        C443441() {
                        }

                        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                            AppMethodBeat.m2504i(33152);
                            C9638aw.m17182Rg().mo14546b(1198, (C1202f) this);
                            C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.FALSE);
                            if (C44346w.this.sfa != null) {
                                C44346w.this.sfa.dismiss();
                                C44346w.this.sfa = null;
                            }
                            if (i != 0 || i2 != 0) {
                                C23639t.makeText(view.getContext(), C25738R.string.d_p, 0).show();
                                AppMethodBeat.m2505o(33152);
                            } else if (c7620bi != view.getTag()) {
                                C4990ab.m7421w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(c7620bi.field_msgId));
                                AppMethodBeat.m2505o(33152);
                            } else {
                                cya abK = ((C37935s) c1207m).abK();
                                if (abK == null) {
                                    C23639t.makeText(view.getContext(), C25738R.string.d_p, 0).show();
                                    AppMethodBeat.m2505o(33152);
                                    return;
                                }
                                String str2 = abK.xtv;
                                C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", nullAsNil);
                                try {
                                    C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, C44346w.this.zeS, String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[]{nullAsNil, URLEncoder.encode(C44346w.this.zeS, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding)}));
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", r1);
                                    C25985d.m41467b(C44346w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    AppMethodBeat.m2505o(33152);
                                } catch (UnsupportedEncodingException e) {
                                    C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                    C23639t.makeText(view.getContext(), C25738R.string.d_u, 0).show();
                                    AppMethodBeat.m2505o(33152);
                                }
                            }
                        }
                    }

                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(33154);
                        C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                        switch (menuItem.getItemId()) {
                            case 1:
                                C9638aw.m17182Rg().mo14539a(1198, new C443441());
                                final C1207m c37935s = new C37935s(c7620bi.field_content);
                                C44346w c44346w = C44346w.this;
                                Context context = view.getContext();
                                view.getResources().getString(C25738R.string.f9238tz);
                                c44346w.sfa = C30379h.m48458b(context, view.getResources().getString(C25738R.string.f9260un), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(33153);
                                        C9638aw.m17182Rg().mo14547c(c37935s);
                                        AppMethodBeat.m2505o(33153);
                                    }
                                });
                                C9638aw.m17182Rg().mo14541a(c37935s, 0);
                                break;
                        }
                        AppMethodBeat.m2505o(33154);
                    }
                };
                c36356d.cpD();
                AppMethodBeat.m2505o(33155);
                return;
            }
            C4990ab.m7420w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
            AppMethodBeat.m2505o(33155);
        }
    }

    /* renamed from: M */
    static /* synthetic */ void m80145M(int i, String str, String str2) {
        AppMethodBeat.m2504i(33171);
        C44346w.m80144L(i, str, str2);
        AppMethodBeat.m2505o(33171);
    }

    public final boolean dHk() {
        return false;
    }

    public C44346w() {
        AppMethodBeat.m2504i(33157);
        C17927a c17927a = new C17927a();
        c17927a.ePT = C25738R.drawable.abh;
        this.yqf = c17927a.ahG();
        this.zeN = new C44351a(this, (byte) 0);
        this.zeM = new C306251();
        this.zeR = new C542411();
        this.zeO = new C542512();
        this.yTn = new C734913();
        this.zeQ = new C542614();
        this.zeP = new C4434715();
        this.lBl = new C4082416();
        AppMethodBeat.m2505o(33157);
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == 318767153) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33158);
        if (view == null || view.getTag() == null) {
            view = new C44341v(layoutInflater, 2130969042);
            C15740aw c15740aw = new C15740aw();
            c15740aw.moo = (CheckBox) view.findViewById(2131820580);
            c15740aw.iVh = view.findViewById(2131820586);
            c15740aw.qkY = (TextView) view.findViewById(2131821102);
            c15740aw.zbv = (AvatarImageView) view.findViewById(2131821101);
            c15740aw.enf = (TextView) view.findViewById(2131820587);
            c15740aw.jPr = (LinearLayout) view.findViewById(2131822453);
            c15740aw.zii.jOR = view.findViewById(2131822460);
            c15740aw.zii.zil = view.findViewById(2131822502);
            c15740aw.zii.gsf = (TextView) c15740aw.zii.jOR.findViewById(2131820678);
            c15740aw.zii.ngD = (TextView) c15740aw.zii.jOR.findViewById(2131822504);
            c15740aw.zii.ziq = (LinearLayout) c15740aw.zii.jOR.findViewById(2131822506);
            c15740aw.zii.zio = (TextView) c15740aw.jPr.findViewById(2131821867);
            c15740aw.zii.zir = c15740aw.jPr.findViewById(2131822507);
            c15740aw.zii.zim = view.findViewById(2131822503);
            c15740aw.zii.zin = view.findViewById(2131822505);
            c15740aw.zij.ziK = view.findViewById(2131822461);
            c15740aw.zij.ziL = (ImageView) view.findViewById(2131822470);
            c15740aw.zij.ziM = view.findViewById(2131822464);
            c15740aw.zij.ziO = (TextView) view.findViewById(2131822466);
            c15740aw.zij.ziN = (ImageView) view.findViewById(2131822465);
            c15740aw.zij.ziP = view.findViewById(2131822467);
            c15740aw.zij.ziQ = (ImageView) view.findViewById(2131822469);
            c15740aw.zij.ziR = view.findViewById(2131822468);
            c15740aw.zij.ziS = view.findViewById(2131822474);
            c15740aw.zij.ziT = (TextView) view.findViewById(2131822472);
            c15740aw.zij.ziU = (TextView) view.findViewById(2131822473);
            c15740aw.zij.ziV = (TextView) view.findViewById(2131822475);
            c15740aw.zij.ziW = view.findViewById(2131822471);
            c15740aw.zij.ziX = (LinearLayout) view.findViewById(2131822476);
            c15740aw.zij.ziY = (TextView) view.findViewById(2131822477);
            c15740aw.zij.zja = (TextView) view.findViewById(2131822479);
            c15740aw.zij.ziZ = (TextView) view.findViewById(2131822478);
            c15740aw.zij.zjb = (TextView) view.findViewById(2131822480);
            c15740aw.zij.zjc = view.findViewById(2131822481);
            c15740aw.zij.zjd = (LinearLayout) view.findViewById(2131822486);
            c15740aw.zij.zjh = view.findViewById(2131821475);
            c15740aw.zij.zje = view.findViewById(2131822487);
            c15740aw.zij.zjf = (LinearLayout) view.findViewById(2131822488);
            c15740aw.zij.zjg = (LinearLayout) view.findViewById(2131822499);
            c15740aw.zij.zji = (LinearLayout) view.findViewById(2131822489);
            c15740aw.zij.zjl = (TextView) view.findViewById(2131822490);
            c15740aw.zij.zjn = (ImageView) view.findViewById(2131822491);
            c15740aw.zij.zjk = view.findViewById(2131822492);
            c15740aw.zij.zjj = (LinearLayout) view.findViewById(2131822493);
            c15740aw.zij.zjm = (TextView) view.findViewById(2131822494);
            c15740aw.zij.zjo = (ImageView) view.findViewById(2131822495);
            c15740aw.zij.zjp = (ImageView) view.findViewById(2131822403);
            c15740aw.zbW = (ImageView) view.findViewById(2131822462);
            c15740aw.zij.zjq = view.findViewById(2131822496);
            c15740aw.zij.zjr = (ImageView) view.findViewById(2131822497);
            c15740aw.zij.zjs = (TextView) view.findViewById(2131822498);
            c15740aw.zij.zjt = (LinearLayout) view.findViewById(2131822500);
            c15740aw.zij.zju = (TextView) view.findViewById(2131822501);
            c15740aw.zik.zbc = (LinearLayout) view.findViewById(2131822482);
            c15740aw.zik.zbd = (CdnImageView) view.findViewById(2131822483);
            c15740aw.zik.zbe = (TextView) view.findViewById(2131822484);
            c15740aw.zik.zbf = (TextView) view.findViewById(2131822485);
            view.setTag(c15740aw);
        }
        AppMethodBeat.m2505o(33158);
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHj() {
        return false;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
        AppMethodBeat.m2504i(33159);
        this.yJI = c46650a;
        c5379a = (C15740aw) c5379a;
        final Map z = C5049br.m7595z(c7620bi.field_content, "msg");
        if (z == null || z.size() == 0) {
            C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            c5379a.jPr.setVisibility(8);
            AppMethodBeat.m2505o(33159);
            return;
        }
        c5379a.jPr.setVisibility(0);
        int i2 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.zeS = C5046bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
        this.zeT = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
        C4879a.xxA.mo10053d(this.yTn);
        ((C7336g) c46650a.mo74857aF(C7336g.class)).mo15846b(this.zeQ);
        String nullAsNil;
        String nullAsNil2;
        String nullAsNil3;
        View view;
        C40814ay c40814ay;
        if (i2 != 0) {
            WxaAttributes zb;
            int paddingLeft;
            int i3;
            int e;
            int e2;
            View inflate;
            CharSequence charSequence;
            int childCount;
            C40814ay c40814ay2;
            c5379a.zii.jOR.setVisibility(8);
            final C36212bd c36212bd = c5379a.zij;
            if (C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1) {
                m80150a(c36212bd, C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), z, c7620bi, false);
            } else if (C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0) {
                m80150a(c36212bd, C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.icon_url")), C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.display_name")), z, c7620bi, true);
            } else {
                ((View) c36212bd.ziQ.getParent()).setVisibility(8);
                if ("notifymessage".equals(c7620bi.field_talker)) {
                    CharSequence charSequence2;
                    nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
                    if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(nullAsNil)) {
                        zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(nullAsNil);
                        m80148a(c36212bd.ziN, this.yJI, nullAsNil, c7620bi, zb == null ? null : zb.field_brandIconURL);
                        charSequence2 = zb == null ? nullAsNil : zb.field_nickname;
                    } else {
                        m80148a(c36212bd.ziN, this.yJI, nullAsNil, c7620bi, null);
                        charSequence2 = ((C7335f) this.yJI.mo74857aF(C7335f.class)).arj(nullAsNil);
                    }
                    c36212bd.ziO.setText(C44089j.m79293b(this.yJI.yTx.getContext(), charSequence2, c36212bd.ziO.getTextSize()));
                    if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(nullAsNil)) {
                        c36212bd.ziM.setTag(new C40814ay(c7620bi, nullAsNil));
                        c36212bd.ziM.setOnClickListener(this.zeO);
                    } else {
                        c36212bd.ziM.setTag(new C40814ay(nullAsNil, this.yJI.dFx() ? this.yJI.getTalkerUserName() : null));
                        c36212bd.ziM.setOnClickListener(mo11027e(this.yJI));
                    }
                    c36212bd.ziM.setVisibility(0);
                } else {
                    c36212bd.ziM.setVisibility(8);
                }
            }
            if (C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) != 0) {
                c36212bd.ziM.setBackgroundResource(C25738R.drawable.f6900uv);
            } else {
                paddingLeft = c36212bd.ziM.getPaddingLeft();
                c36212bd.ziM.setBackgroundResource(C25738R.drawable.a_q);
                c36212bd.ziM.setPadding(paddingLeft, 0, 0, 0);
            }
            if (C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {
                i3 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
            } else {
                i3 = 0;
            }
            int i4 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
            int i5 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_time"), 0);
            c36212bd.ziT.setVisibility(8);
            c36212bd.ziU.setVisibility(8);
            if (i3 == 0) {
                if (i4 == 0) {
                    c36212bd.ziT.setVisibility(0);
                    nullAsNil2 = C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.title"));
                    c36212bd.ziT.setTextColor(C44346w.m80160e(z, ".msg.appmsg.mmreader.template_header.title_color", WebView.NIGHT_MODE_COLOR));
                    c36212bd.ziT.setText(nullAsNil2);
                }
                if (i5 == 0) {
                    long j = C5046bo.getLong(C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.pub_time")), 0);
                    if (j > 0) {
                        c36212bd.ziU.setText(C14835h.formatTime(this.yJI.yTx.getMMResources().getString(C25738R.string.bwz), j));
                        c36212bd.ziU.setVisibility(0);
                    } else {
                        c36212bd.ziU.setVisibility(8);
                    }
                }
            }
            nullAsNil2 = C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.first_data"));
            i4 = C44346w.m80160e(z, ".msg.appmsg.mmreader.template_header.first_color", zeV);
            if (C5046bo.isNullOrNil(nullAsNil2)) {
                c36212bd.ziV.setVisibility(8);
            } else {
                c36212bd.ziV.setTextColor(i4);
                c36212bd.ziV.setText(nullAsNil2);
                c36212bd.ziV.setVisibility(0);
                if (i2 == 2) {
                    c36212bd.ziV.setPadding(0, this.yJI.yTx.getMMResources().getDimensionPixelOffset(C25738R.dimen.f9948l5), 0, 0);
                } else {
                    c36212bd.ziV.setPadding(0, 0, 0, 0);
                }
            }
            if (i3 == 0 || !C5046bo.isNullOrNil(nullAsNil2)) {
                c36212bd.ziW.setVisibility(0);
            } else {
                c36212bd.ziW.setVisibility(8);
            }
            boolean z2 = false;
            boolean z3 = false;
            if ("notifymessage".equals(c7620bi.field_talker)) {
                nullAsNil3 = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
                z2 = ((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(nullAsNil3);
                if (z2) {
                    ((C7336g) this.yJI.mo74857aF(C7336g.class)).mo15845a(this.zeQ);
                    C4879a.xxA.mo10052c(this.yTn);
                    zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(nullAsNil3);
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
                        C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", nullAsNil3);
                        final C7620bi c7620bi2 = c7620bi;
                        ((C42686d) C1720g.m3528K(C42686d.class)).mo44615a(nullAsNil3, new C38509a() {
                            /* renamed from: d */
                            public final void mo21701d(WxaAttributes wxaAttributes) {
                                AppMethodBeat.m2504i(33147);
                                if (wxaAttributes == null) {
                                    AppMethodBeat.m2505o(33147);
                                    return;
                                }
                                C44346w.this.mAppId = wxaAttributes.field_appId;
                                final boolean z = (wxaAttributes.field_appOpt & 1) > 0;
                                C5004al.m7441d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(33146);
                                        C44346w.m80152a(C44346w.this, z, c7620bi2, c36212bd, z);
                                        AppMethodBeat.m2505o(33146);
                                    }
                                });
                                AppMethodBeat.m2505o(33147);
                            }
                        });
                    }
                }
            }
            c36212bd.ziR.setVisibility(z2 ? 0 : 8);
            c36212bd.ziR.setTag(2131822468, c7620bi);
            c36212bd.ziR.setOnClickListener(this.zeM);
            m80154a(z, c7620bi, c36212bd, z2, z3);
            c36212bd.ziL.setVisibility(8);
            c36212bd.ziV.setText(C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_header.first_data")));
            nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            nullAsNil3 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            String str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (C5046bo.isNullOrNil(nullAsNil3)) {
                c36212bd.ziX.setVisibility(8);
            } else {
                e = C44346w.m80160e(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", WebView.NIGHT_MODE_COLOR);
                e2 = C44346w.m80160e(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", WebView.NIGHT_MODE_COLOR);
                int e3 = C44346w.m80160e(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", WebView.NIGHT_MODE_COLOR);
                i5 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
                c36212bd.ziY.setTextColor(e);
                c36212bd.zja.setTextColor(e2);
                c36212bd.zjb.setTextColor(e3);
                c36212bd.zjb.getPaint().setFlags(16);
                c36212bd.ziY.setText(nullAsNil2);
                if (i5 <= 0 || i5 >= nullAsNil3.length()) {
                    c36212bd.ziZ.setTypeface(Typeface.DEFAULT);
                    c36212bd.ziZ.setVisibility(8);
                    c36212bd.zja.setTypeface(Typeface.DEFAULT);
                    c36212bd.zja.setText(nullAsNil3);
                } else {
                    c36212bd.ziZ.setVisibility(0);
                    c36212bd.ziZ.setText(nullAsNil3.substring(0, i5));
                    c36212bd.ziZ.setTextColor(e2);
                    c36212bd.ziZ.setTypeface(((C30158b) C1720g.m3528K(C30158b.class)).mo48438ex(this.yJI.yTx.getContext()));
                    c36212bd.zja.setTypeface(((C30158b) C1720g.m3528K(C30158b.class)).mo48438ex(this.yJI.yTx.getContext()));
                    c36212bd.zja.setText(nullAsNil3.substring(i5));
                }
                if (C5046bo.isNullOrNil(str2)) {
                    c36212bd.zjb.setVisibility(8);
                } else {
                    c36212bd.zjb.setText(str2);
                    c36212bd.zjb.setVisibility(0);
                }
                c36212bd.ziX.setVisibility(0);
            }
            int i6 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i6 == 2) {
                C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
                c36212bd.ziU.setVisibility(8);
                c36212bd.zjd.setVisibility(8);
                ViewGroup viewGroup = (ViewGroup) c36212bd.zjd.getParent();
                View findViewById = viewGroup.findViewById(2131824554);
                if (findViewById == null) {
                    inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130970506, null);
                    C23843av c23843av = new C23843av();
                    c23843av.iNr = (ImageView) inflate.findViewById(2131823704);
                    c23843av.zih = (TextView) inflate.findViewById(2131826964);
                    c23843av.ngD = (TextView) inflate.findViewById(2131822504);
                    c23843av.gsf = (TextView) inflate.findViewById(2131820678);
                    inflate.setTag(c23843av);
                    viewGroup.addView(inflate);
                    view = inflate;
                } else {
                    view = findViewById;
                }
                view.setVisibility(0);
                C23843av c23843av2 = (C23843av) view.getTag();
                charSequence = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_content");
                str2 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_username");
                CharSequence charSequence3 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
                String str3 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_time");
                e2 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
                c23843av2.gsf.setText(C44089j.m79292b(c23843av2.gsf.getContext(), charSequence));
                TextView textView = c23843av2.zih;
                Context context = c23843av2.gsf.getContext();
                if (C5046bo.isNullOrNil(str2)) {
                    charSequence3 = "";
                } else {
                    nullAsNil3 = null;
                    if (C1855t.m3896kH(str2)) {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(str2);
                        if (aoO != null) {
                            nullAsNil3 = aoO.mo16707Oj() == null ? aoO.mo16706Oi() : aoO.mo16707Oj();
                        }
                    } else {
                        C9638aw.m17190ZK();
                        C7616ad aoO2 = C18628c.m29078XM().aoO(str2);
                        nullAsNil3 = aoO2.mo16707Oj() == null ? aoO2.mo16706Oi() : aoO2.mo16707Oj();
                    }
                    if (C5046bo.isNullOrNil(nullAsNil3)) {
                        C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", str2, charSequence3);
                        if (charSequence3 == null) {
                            charSequence3 = C4996ah.getContext().getString(C25738R.string.ao1);
                        }
                    } else {
                        Object charSequence32 = nullAsNil3;
                    }
                }
                textView.setText(C44089j.m79292b(context, charSequence32));
                c23843av2.ngD.setText(str3);
                if (e2 == 2) {
                    c23843av2.iNr.setImageDrawable(C4996ah.getContext().getResources().getDrawable(C25738R.drawable.avo));
                } else {
                    C40460b.m69434b(c23843av2.iNr, str2);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                i4 = 0;
                e = 0;
                while (e < 100) {
                    String concat = e == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(e));
                    nullAsNil2 = (String) z.get(concat + ".value.word");
                    nullAsNil3 = (String) z.get(concat + ".key.word");
                    if (C5046bo.isNullOrNil(nullAsNil2) && C5046bo.isNullOrNil(nullAsNil3)) {
                        C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", Integer.valueOf(e));
                        break;
                    }
                    C23844ba c23844ba = new C23844ba();
                    c23844ba.ziD = nullAsNil2;
                    c23844ba.ziC = C5046bo.nullAsNil(nullAsNil3);
                    c23844ba.ziE = C44346w.m80160e(z, concat + ".key.color", zeU);
                    c23844ba.ziF = C44346w.m80160e(z, concat + ".value.color", WebView.NIGHT_MODE_COLOR);
                    c23844ba.ziG = C5046bo.getInt((String) z.get(new StringBuilder().append(concat).append(".key.hide").toString()), 0) != 0;
                    paddingLeft = (C44346w.arE(c23844ba.ziC) + 1) / 2;
                    if (paddingLeft <= i4) {
                        paddingLeft = i4;
                    }
                    arrayList.add(c23844ba);
                    e++;
                    i4 = paddingLeft;
                }
                if (i4 > 8) {
                    i5 = 8;
                } else {
                    i5 = i4;
                }
                LinearLayout linearLayout = c36212bd.zjd;
                linearLayout.setVisibility(0);
                view = ((ViewGroup) c36212bd.zjd.getParent()).findViewById(2131824554);
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
                    C23844ba c23844ba2 = (C23844ba) arrayList.get(e);
                    if (e < childCount) {
                        linearLayout2 = (LinearLayout) linearLayout.getChildAt(e);
                    } else {
                        linearLayout2 = (LinearLayout) LayoutInflater.from(this.yJI.yTx.getContext()).inflate(2130969016, null, false);
                        C30606bb c30606bb = new C30606bb();
                        c30606bb.ziH = (TextView) linearLayout2.findViewById(2131822404);
                        c30606bb.ziI = (TextView) linearLayout2.findViewById(2131822405);
                        linearLayout2.setTag(c30606bb);
                        linearLayout.addView(linearLayout2);
                    }
                    C30606bb c30606bb2 = (C30606bb) linearLayout2.getTag();
                    if (c23844ba2.ziG) {
                        c30606bb2.ziH.setVisibility(8);
                    } else {
                        c30606bb2.ziH.setVisibility(0);
                        c30606bb2.ziH.setEms(i5);
                        c30606bb2.ziH.setTextColor(c23844ba2.ziE);
                        c30606bb2.ziH.setText(c23844ba2.ziC);
                    }
                    c30606bb2.ziI.setTextColor(c23844ba2.ziF);
                    c30606bb2.ziI.setText(c23844ba2.ziD);
                    paddingLeft = e + 1;
                }
                if (linearLayout.getChildCount() == 0) {
                    c36212bd.zjc.setVisibility(8);
                    linearLayout.setVisibility(8);
                } else {
                    if (C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
                        c36212bd.zjc.setVisibility(8);
                    } else {
                        c36212bd.zjc.setVisibility(0);
                    }
                    linearLayout.setVisibility(0);
                }
            }
            if (C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0) {
                c36212bd.zjq.setVisibility(8);
                c36212bd.zjf.setVisibility(8);
                c36212bd.zjh.setVisibility(8);
                c36212bd.zjg.setVisibility(0);
                c36212bd.zje.setVisibility(0);
                m80149a(c36212bd, c7620bi, z);
            } else {
                final String nullAsNil4;
                final String str4;
                final String str5;
                final String str6;
                final int i7;
                c36212bd.zjg.setVisibility(8);
                nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
                nullAsNil3 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
                if (C5046bo.isNullOrNil(nullAsNil2)) {
                    c36212bd.zji.setVisibility(8);
                } else {
                    c36212bd.zjl.setTextColor(C44346w.m80160e(z, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", WebView.NIGHT_MODE_COLOR));
                    c36212bd.zjl.setText(nullAsNil2);
                    if (C5046bo.isNullOrNil(nullAsNil3)) {
                        c36212bd.zjn.setVisibility(8);
                        c36212bd.zjl.setPadding(0, 0, 0, 0);
                    } else {
                        c36212bd.zjn.setVisibility(0);
                        C44346w.m80163h(c36212bd.zjn, nullAsNil3);
                        c36212bd.zjl.setPadding(0, 0, C1338a.fromDPToPix(this.yJI.yTx.getContext(), 16), 0);
                    }
                    nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    nullAsNil4 = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
                    i4 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                    str4 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                    c40814ay2 = new C40814ay(c7620bi, nullAsNil4, nullAsNil2);
                    c36212bd.zji.setTag(c40814ay2);
                    c36212bd.zjq.setTag(c40814ay2);
                    if (i4 != 1 || TextUtils.isEmpty(str4)) {
                        str5 = nullAsNil4;
                        c36212bd.zji.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(33130);
                                if (!C5046bo.isNullOrNil(nullAsNil2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", nullAsNil2);
                                    C25985d.m41467b(C44346w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    C7060h.pYm.mo8381e(11608, C44346w.this.zeS, str5, Integer.valueOf(1));
                                }
                                AppMethodBeat.m2505o(33130);
                            }
                        });
                        c36212bd.zjq.setOnClickListener(null);
                    } else {
                        str6 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                        i7 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                        childCount = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                        nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                        C306263 c306263 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(33129);
                                C40814ay c40814ay = (C40814ay) view.getTag();
                                C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str4);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.cst = c40814ay.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C44346w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
                                if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(c40814ay.userName)) {
                                    appBrandStatObject.scene = C44346w.arF(nullAsNil);
                                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C44346w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                                    C16527d qX = C17903f.m28104qX(c40814ay.userName);
                                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(C44346w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject, qX == null ? null : qX.field_appId);
                                }
                                C44346w.m80145M(9, C44346w.this.mAppId, C44346w.this.zeS);
                                C7060h.pYm.mo8381e(11608, C44346w.this.zeS, nullAsNil4, Integer.valueOf(1));
                                AppMethodBeat.m2505o(33129);
                            }
                        };
                        c36212bd.zji.setOnClickListener(c306263);
                        c36212bd.zjq.setOnClickListener(c306263);
                    }
                    c36212bd.zji.setVisibility(0);
                }
                nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (C5046bo.isNullOrNil(nullAsNil2)) {
                    c36212bd.zjj.setVisibility(8);
                } else {
                    c36212bd.zjm.setTextColor(C44346w.m80160e(z, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", WebView.NIGHT_MODE_COLOR));
                    c36212bd.zjm.setText(nullAsNil2);
                    if (C5046bo.isNullOrNil(str2)) {
                        c36212bd.zjo.setVisibility(8);
                        c36212bd.zjm.setPadding(0, 0, 0, 0);
                    } else {
                        c36212bd.zjo.setVisibility(0);
                        C44346w.m80163h(c36212bd.zjo, str2);
                        c36212bd.zjm.setPadding(0, 0, C1338a.fromDPToPix(this.yJI.yTx.getContext(), 16), 0);
                    }
                    nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                    nullAsNil4 = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
                    i5 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                    str4 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                    c36212bd.zjj.setTag(new C40814ay(c7620bi, nullAsNil4, nullAsNil2));
                    if (i5 != 1 || TextUtils.isEmpty(str4)) {
                        str5 = nullAsNil4;
                        c36212bd.zjj.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(33132);
                                if (!C5046bo.isNullOrNil(nullAsNil2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", nullAsNil2);
                                    C25985d.m41467b(C44346w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    C7060h.pYm.mo8381e(11608, C44346w.this.zeS, str5, Integer.valueOf(2));
                                }
                                AppMethodBeat.m2505o(33132);
                            }
                        });
                    } else {
                        str6 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                        i7 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                        childCount = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                        nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.appmsg.template_id"));
                        c36212bd.zjj.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(33131);
                                C40814ay c40814ay = (C40814ay) view.getTag();
                                C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str4);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.cst = c40814ay.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C44346w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil;
                                if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(c40814ay.userName)) {
                                    appBrandStatObject.scene = C44346w.arF(nullAsNil);
                                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C44346w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                                    C16527d qX = C17903f.m28104qX(c40814ay.userName);
                                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(C44346w.this.yJI.yTx.getContext(), str4, null, childCount, i7, str6, appBrandStatObject, qX == null ? null : qX.field_appId);
                                }
                                C44346w.m80145M(9, C44346w.this.mAppId, C44346w.this.zeS);
                                C7060h.pYm.mo8381e(11608, C44346w.this.zeS, nullAsNil4, Integer.valueOf(2));
                                AppMethodBeat.m2505o(33131);
                            }
                        });
                    }
                    c36212bd.zjj.setVisibility(0);
                }
                c36212bd.zjp.setVisibility(8);
                if (c36212bd.zji.getVisibility() == 8 && c36212bd.zjj.getVisibility() == 8) {
                    c36212bd.zjf.setVisibility(8);
                    c36212bd.zje.setVisibility(8);
                    c36212bd.zjh.setVisibility(8);
                } else {
                    c36212bd.zjh.setVisibility(0);
                    paddingLeft = this.yJI.yTx.getMMResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
                    if (c36212bd.zji.getVisibility() == 0 && c36212bd.zjj.getVisibility() == 0) {
                        c36212bd.zji.setGravity(17);
                        c36212bd.zjj.setGravity(17);
                        c36212bd.zji.setPadding(paddingLeft, 0, paddingLeft, 0);
                        c36212bd.zjj.setPadding(paddingLeft, 0, paddingLeft, 0);
                    } else if (c36212bd.zji.getVisibility() == 0) {
                        if (C5046bo.isNullOrNil(nullAsNil3)) {
                            c36212bd.zji.setGravity(19);
                            c36212bd.zji.setPadding(paddingLeft, 0, 0, 0);
                            c36212bd.zjp.setVisibility(0);
                        } else {
                            c36212bd.zji.setGravity(17);
                            c36212bd.zji.setPadding(paddingLeft, 0, paddingLeft, 0);
                        }
                    } else if (C5046bo.isNullOrNil(str2)) {
                        c36212bd.zjj.setGravity(19);
                        c36212bd.zjj.setPadding(this.yJI.yTx.getMMResources().getDimensionPixelOffset(C25738R.dimen.f9948l5), 0, 0, 0);
                        c36212bd.zjp.setVisibility(0);
                    } else {
                        c36212bd.zjj.setGravity(17);
                        c36212bd.zjj.setPadding(paddingLeft, 0, paddingLeft, 0);
                    }
                    c36212bd.zjf.setVisibility(0);
                    c36212bd.zje.setVisibility(0);
                }
                if (c36212bd.zji.getVisibility() == 0 && c36212bd.zjj.getVisibility() == 0) {
                    c36212bd.zjk.setVisibility(0);
                } else {
                    c36212bd.zjk.setVisibility(8);
                }
                nullAsNil3 = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
                i4 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if (!C7616ad.m13549mg(nullAsNil3) && c36212bd.zji.getVisibility() != 8 && c36212bd.zjj.getVisibility() == 8 && i4 == 1 && C7616ad.m13549mg(nullAsNil2)) {
                    WxaAttributes zb2 = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(nullAsNil2);
                    str2 = zb2 == null ? null : zb2.field_brandIconURL;
                    charSequence = zb2 == null ? nullAsNil2 : zb2.field_nickname;
                    C32291o.ahp().mo43766a(str2, c36212bd.zjr, this.yqf);
                    c36212bd.zjs.setText(charSequence);
                    if (zb2 == null) {
                        ((C42686d) C1720g.m3528K(C42686d.class)).mo44615a(nullAsNil2, new C38509a() {
                            /* renamed from: d */
                            public final void mo21701d(WxaAttributes wxaAttributes) {
                                AppMethodBeat.m2504i(33134);
                                if (wxaAttributes == null) {
                                    AppMethodBeat.m2505o(33134);
                                    return;
                                }
                                final String str = wxaAttributes.field_brandIconURL;
                                final String str2 = wxaAttributes.field_nickname;
                                C5004al.m7441d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(33133);
                                        C32291o.ahp().mo43766a(str, c36212bd.zjr, C44346w.this.yqf);
                                        c36212bd.zjs.setText(TextUtils.isEmpty(str2) ? nullAsNil2 : str2);
                                        AppMethodBeat.m2505o(33133);
                                    }
                                });
                                AppMethodBeat.m2505o(33134);
                            }
                        });
                    }
                    c36212bd.zjq.setVisibility(0);
                    c36212bd.zjf.setVisibility(8);
                } else {
                    c36212bd.zjq.setVisibility(8);
                }
            }
            String nullAsNil5 = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
            String str7 = null;
            if (!C5046bo.isNullOrNil(nullAsNil5)) {
                C9638aw.m17190ZK();
                str7 = C18628c.m29078XM().aoO(nullAsNil5).mo16706Oi();
            }
            String str8 = (String) z.get(".msg.appmsg.mmreader.category.item.title");
            String str9 = (String) z.get(".msg.appmsg.mmreader.category.item.url");
            nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.category.item.native_url");
            nullAsNil3 = (String) z.get(".msg.appmsg.template_id");
            str2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if (i6 == 1 && !TextUtils.isEmpty(str2)) {
                c40814ay = new C40814ay(c7620bi, nullAsNil5, str9);
                c40814ay.position = i;
                c36212bd.ziK.setTag(c40814ay);
                c36212bd.ziK.setOnClickListener(this.lBl);
            } else if (i6 == -1 && ((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(nullAsNil5)) {
                str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                View view2 = c36212bd.ziK;
                c40814ay2 = new C40814ay(c7620bi, false, i, nullAsNil5, false, this.yJI.dDw(), nullAsNil5, str7, str8);
                c40814ay2.cRS = nullAsNil2;
                c40814ay2.hzj = str2;
                view2.setTag(c40814ay2);
                c36212bd.ziK.setOnClickListener(this.zeP);
            } else if (i6 == 2) {
                c40814ay = new C40814ay(c7620bi, nullAsNil5, str9);
                c40814ay.position = i;
                c36212bd.ziK.setTag(c40814ay);
                c36212bd.ziK.setOnClickListener(this.lBl);
            } else {
                inflate = c36212bd.ziK;
                C40814ay c40814ay3 = new C40814ay(c7620bi, false, i, str9, false, this.yJI.dDw(), nullAsNil5, str7, str8);
                c40814ay3.cRS = nullAsNil2;
                inflate.setTag(c40814ay3);
                c36212bd.ziK.setOnClickListener(mo11029h(this.yJI));
            }
            c36212bd.ziK.setOnLongClickListener(mo11021c(this.yJI));
            c36212bd.ziK.setOnTouchListener(((C15612h) this.yJI.mo74857aF(C15612h.class)).dCZ());
            if (C26373g.m41965Nv().mo5298Nk()) {
                c5379a.zbW.setVisibility(0);
                C5378c.m8140c(this.yJI, c5379a.zbW, new C5366o(nullAsNil3, c7620bi, str7));
            }
            if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(C5046bo.nullAsNil((String) z.get(".msg.fromusername"))) && "notifymessage".equals(c7620bi.field_talker)) {
                C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
                c36212bd.ziS.setTag(null);
                c36212bd.ziS.setVisibility(8);
            } else {
                if ((C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
                    C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
                } else if (c36212bd.ziM.getVisibility() == 0) {
                    c36212bd.ziR.setTag(c7620bi);
                    c36212bd.ziR.setOnClickListener(this.zeN);
                    c36212bd.ziR.setVisibility(0);
                    c36212bd.ziS.setVisibility(8);
                } else if (c36212bd.ziW.getVisibility() == 0) {
                    c36212bd.ziS.setTag(c7620bi);
                    c36212bd.ziS.setOnClickListener(this.zeN);
                    c36212bd.ziS.setVisibility(0);
                    c36212bd.ziR.setVisibility(8);
                }
                c36212bd.ziR.setTag(null);
                c36212bd.ziS.setTag(null);
                c36212bd.ziR.setVisibility(8);
                c36212bd.ziS.setVisibility(8);
            }
            c5379a.zij.ziK.setVisibility(0);
            AppMethodBeat.m2505o(33159);
            return;
        }
        c5379a.zij.ziK.setVisibility(8);
        nullAsNil = C5046bo.nullAsNil((String) z.get(".msg.fromusername"));
        int i8 = C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
        C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", Integer.valueOf(i8));
        if (i8 == 1) {
            nullAsNil3 = C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            C5378c.m8134a(c5379a, (CharSequence) C44089j.m79293b(this.yJI.yTx.getContext(), C5046bo.nullAsNil((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), c5379a.qkY.getTextSize()));
            c5379a.zbv.setTag(null);
            c5379a.zbv.setOnClickListener(null);
            C32291o.ahp().mo43766a(nullAsNil3, c5379a.zbv, this.yqf);
        } else {
            mo11011a(c5379a, this.yJI, c7620bi, nullAsNil);
            m80148a(c5379a.zbv, this.yJI, nullAsNil, c7620bi, null);
            if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(nullAsNil)) {
                c5379a.zii.zil.setTag(new C40814ay(c7620bi, nullAsNil));
                c5379a.zii.zil.setOnClickListener(this.zeO);
            } else {
                c5379a.zii.zil.setTag(new C40814ay(nullAsNil, this.yJI.dFx() ? this.yJI.getTalkerUserName() : null));
                c5379a.zii.zil.setOnClickListener(mo11027e(this.yJI));
            }
        }
        C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", c7620bi.field_talker);
        if ("notifymessage".equals(c7620bi.field_talker) || i8 == 1) {
            c5379a.zii.zil.setVisibility(0);
            c5379a.zii.gsf.setTextSize(0, (float) C1338a.m2856al(c5379a.zii.gsf.getContext(), C25738R.dimen.f9980m5));
        } else {
            c5379a.zii.zil.setVisibility(8);
            c5379a.zii.gsf.setTextSize(0, (float) C1338a.m2856al(c5379a.zii.gsf.getContext(), C25738R.dimen.f9720dk));
        }
        c5379a.zii.jOR.setVisibility(0);
        C40828b aX = C40828b.m70757aX(z);
        c5379a.zii.gsf.setText(aX.title);
        c5379a.zii.ngD.setText(C14835h.formatTime(this.yJI.yTx.getMMResources().getString(C25738R.string.bww), aX.time));
        C44353x.m80173a(c5379a.zii.ziq, z);
        String str10 = null;
        if (!C5046bo.isNullOrNil(nullAsNil)) {
            C9638aw.m17190ZK();
            str10 = C18628c.m29078XM().aoO(nullAsNil).mo16706Oi();
        }
        Object obj = !C5046bo.isNullOrNil(aX.url) ? 1 : null;
        nullAsNil2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
        if (C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0) != 1 || TextUtils.isEmpty(nullAsNil2)) {
            view = c5379a.zii.jOR;
            C40814ay c40814ay4 = new C40814ay(c7620bi, false, i, aX.url, false, this.yJI.dDw(), nullAsNil, str10, aX.title);
            c40814ay4.cRS = aX.cRS;
            view.setTag(c40814ay4);
            c5379a.zii.jOR.setOnClickListener(mo11029h(this.yJI));
        } else {
            c40814ay = new C40814ay(c7620bi, nullAsNil, aX.url);
            c40814ay.position = i;
            c5379a.zii.jOR.setTag(c40814ay);
            c5379a.zii.jOR.setOnClickListener(this.lBl);
            obj = 1;
        }
        c5379a.zii.jOR.setOnLongClickListener(mo11021c(this.yJI));
        c5379a.zii.jOR.setOnTouchListener(((C15612h) this.yJI.mo74857aF(C15612h.class)).dCZ());
        if (obj == null) {
            c5379a.zii.zir.setVisibility(8);
            c5379a.zii.zio.setVisibility(8);
        } else {
            c5379a.zii.zir.setVisibility(0);
            c5379a.zii.zio.setVisibility(0);
        }
        if (C26373g.m41965Nv().mo5298Nk()) {
            c5379a.zbW.setVisibility(0);
            C5378c.m8140c(this.yJI, c5379a.zbW, new C5366o(aX.fhu, c7620bi, str10));
        }
        C36211ax c36211ax = c5379a.zii;
        if ((C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
            C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            c36211ax.zim.setTag(null);
            c36211ax.zin.setTag(null);
            c36211ax.zim.setVisibility(8);
            c36211ax.zin.setVisibility(8);
        } else if (c36211ax.zil.getVisibility() == 0) {
            c36211ax.zim.setTag(c7620bi);
            c36211ax.zim.setOnClickListener(this.zeN);
            c36211ax.zim.setVisibility(0);
            c36211ax.zin.setVisibility(8);
        } else {
            c36211ax.zin.setTag(c7620bi);
            c36211ax.zin.setOnClickListener(this.zeN);
            c36211ax.zin.setVisibility(0);
            c36211ax.zim.setVisibility(8);
        }
        c5379a.zii.jOR.setVisibility(0);
        AppMethodBeat.m2505o(33159);
    }

    /* renamed from: a */
    public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33160);
        C40814ay c40814ay = (C40814ay) view.getTag();
        if (c40814ay == null) {
            AppMethodBeat.m2505o(33160);
            return false;
        }
        int i = c40814ay.position;
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
        }
        AppMethodBeat.m2505o(33160);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHn() {
        return this.zeT == 0;
    }

    /* renamed from: b */
    public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
        return false;
    }

    /* renamed from: a */
    public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33161);
        menuItem.getItemId();
        AppMethodBeat.m2505o(33161);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo11011a(C5379a c5379a, C46650a c46650a, C7620bi c7620bi, String str) {
        AppMethodBeat.m2504i(33162);
        if (str == null || c5379a.qkY == null) {
            AppMethodBeat.m2505o(33162);
            return;
        }
        C5378c.m8134a(c5379a, (CharSequence) C44089j.m79293b(c46650a.yTx.getContext(), ((C7335f) c46650a.mo74857aF(C7335f.class)).arj(str), c5379a.qkY.getTextSize()));
        AppMethodBeat.m2505o(33162);
    }

    /* renamed from: a */
    private void m80148a(ImageView imageView, C46650a c46650a, String str, C7620bi c7620bi, String str2) {
        AppMethodBeat.m2504i(33163);
        if (imageView == null) {
            AppMethodBeat.m2505o(33163);
        } else if (C1855t.m3923nI(str)) {
            imageView.setVisibility(8);
            AppMethodBeat.m2505o(33163);
        } else {
            imageView.setVisibility(0);
            if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(str)) {
                C32291o.ahp().mo43766a(str2, imageView, this.yqf);
                imageView.setTag(new C40814ay(c7620bi, str));
                imageView.setOnClickListener(this.zeO);
            } else {
                C40460b.m69437r(imageView, str);
                imageView.setTag(new C40814ay(str, c46650a.dFx() ? c46650a.getTalkerUserName() : null));
                imageView.setOnClickListener(mo11027e(c46650a));
            }
            imageView.setOnLongClickListener(mo11028f(c46650a));
            imageView.setContentDescription(C1854s.m3866mJ(str) + c46650a.yTx.getContext().getString(C25738R.string.f9342x9));
            AppMethodBeat.m2505o(33163);
        }
    }

    /* renamed from: a */
    private void m80150a(C36212bd c36212bd, String str, String str2, Map<String, String> map, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(33164);
        c36212bd.ziO.setText(C44089j.m79293b(this.yJI.yTx.getContext(), (CharSequence) str2, c36212bd.ziO.getTextSize()));
        C32291o.ahp().mo43766a(str, c36212bd.ziN, this.yqf);
        c36212bd.ziN.setTag(null);
        c36212bd.ziN.setOnClickListener(null);
        c36212bd.ziM.setTag(null);
        c36212bd.ziM.setOnClickListener(null);
        c36212bd.ziM.setVisibility(0);
        String nullAsNil = C5046bo.nullAsNil((String) map.get(".msg.appmsg.mmreader.template_header.weapp_username"));
        String nullAsNil2 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
        if (C5046bo.isNullOrNil(nullAsNil) && C5046bo.isNullOrNil(nullAsNil2)) {
            c36212bd.ziM.setOnClickListener(null);
        } else {
            c36212bd.ziM.setTag(new C40814ay(c7620bi, C5046bo.nullAsNil((String) map.get(".msg.fromusername"))));
            c36212bd.ziM.setOnClickListener(this.zeR);
        }
        nullAsNil = C5046bo.nullAsNil((String) map.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
        if (!z || C5046bo.isNullOrNil(nullAsNil)) {
            ((View) c36212bd.ziQ.getParent()).setVisibility(8);
            AppMethodBeat.m2505o(33164);
            return;
        }
        ((View) c36212bd.ziQ.getParent()).setVisibility(0);
        C32291o.ahp().mo43766a(nullAsNil, c36212bd.ziQ, this.yqf);
        AppMethodBeat.m2505o(33164);
    }

    /* renamed from: a */
    private void m80154a(Map<String, String> map, C7620bi c7620bi, C36212bd c36212bd, boolean z, boolean z2) {
        AppMethodBeat.m2504i(33165);
        c36212bd.zjt.setVisibility(z ? 0 : 8);
        if (z2) {
            c36212bd.ziP.setVisibility(0);
            c36212bd.zju.setText(this.yJI.yTx.getMMResources().getString(C25738R.string.d_y));
        } else {
            c36212bd.ziP.setVisibility(8);
            c36212bd.zju.setText(this.yJI.yTx.getMMResources().getString(C25738R.string.d_g));
        }
        c36212bd.zjt.setTag(2131822501, c7620bi);
        final Map<String, String> map2 = map;
        final boolean z3 = z2;
        final C36212bd c36212bd2 = c36212bd;
        final C7620bi c7620bi2 = c7620bi;
        c36212bd.zjt.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.ui.chatting.viewitems.w$18$1 */
            class C238821 implements C36073c {
                C238821() {
                }

                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(33148);
                    if (z3) {
                        c44273l.mo70048a(1, C44346w.this.yJI.yTx.getMMResources().getColor(C25738R.color.f11795hi), C44346w.this.yJI.yTx.getMMResources().getString(C25738R.string.d_x));
                        AppMethodBeat.m2505o(33148);
                        return;
                    }
                    c44273l.mo70048a(0, C44346w.this.yJI.yTx.getMMResources().getColor(C25738R.color.f12267y0), C44346w.this.yJI.yTx.getMMResources().getString(C25738R.string.d_i));
                    AppMethodBeat.m2505o(33148);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(33150);
                final String nullAsNil = C5046bo.nullAsNil((String) map2.get(".msg.fromusername"));
                C36356d c36356d = new C36356d(C44346w.this.yJI.yTx.getContext(), 1, true);
                if (z3) {
                    c36356d.mo57242q(C44346w.this.yJI.yTx.getMMResources().getString(C25738R.string.d_z), 3);
                } else {
                    c36356d.mo57242q(C44346w.this.yJI.yTx.getMMResources().getString(C25738R.string.d_j), 3);
                }
                c36356d.rBl = new C238821();
                c36356d.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(33149);
                        switch (menuItem.getItemId()) {
                            case 0:
                                C44346w.m80153a(C44346w.this, true, c36212bd2, nullAsNil, c7620bi2);
                                AppMethodBeat.m2505o(33149);
                                return;
                            case 1:
                                C44346w.m80153a(C44346w.this, false, c36212bd2, nullAsNil, c7620bi2);
                                break;
                        }
                        AppMethodBeat.m2505o(33149);
                    }
                };
                c36356d.cpD();
                AppMethodBeat.m2505o(33150);
            }
        });
        AppMethodBeat.m2505o(33165);
    }

    /* renamed from: a */
    private void m80149a(C36212bd c36212bd, C7620bi c7620bi, Map<String, String> map) {
        AppMethodBeat.m2504i(33166);
        LinearLayout linearLayout = c36212bd.zjg;
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
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", Integer.valueOf(i2));
                i = linearLayout.getChildCount();
                if (i > i2) {
                    if (i2 == 0) {
                        linearLayout.removeAllViews();
                        AppMethodBeat.m2505o(33166);
                        return;
                    }
                    linearLayout.removeViews(i2, i - i2);
                    AppMethodBeat.m2505o(33166);
                    return;
                }
            } else {
                LinearLayout linearLayout2;
                if (i2 < childCount) {
                    linearLayout2 = (LinearLayout) linearLayout.getChildAt(i2);
                } else {
                    linearLayout2 = (LinearLayout) LayoutInflater.from(this.yJI.yTx.getContext()).inflate(2130969015, null, false);
                    C23817a c23817a = new C23817a();
                    c23817a.gsf = (TextView) linearLayout2.findViewById(2131822400);
                    c23817a.iNr = (ImageView) linearLayout2.findViewById(2131822401);
                    c23817a.zbb = (LinearLayout) linearLayout2.findViewById(2131822398);
                    c23817a.grM = (TextView) linearLayout2.findViewById(2131822402);
                    linearLayout2.setTag(c23817a);
                    linearLayout.addView(linearLayout2);
                }
                C23817a c23817a2 = (C23817a) linearLayout2.getTag();
                String str3 = (String) map.get(concat + ".icon");
                c23817a2.gsf.setTextColor(C44346w.m80160e(map, concat + ".color", WebView.NIGHT_MODE_COLOR));
                if (C5046bo.getInt((String) map.get(concat + ".is_rich_text"), 0) == 0) {
                    c23817a2.gsf.setSingleLine(true);
                    c23817a2.gsf.setEllipsize(TruncateAt.END);
                    c23817a2.gsf.setText(str);
                } else {
                    C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", Integer.valueOf(C5046bo.getInt((String) map.get(concat + ".display_line_number"), 1)));
                    c23817a2.gsf.setSingleLine(false);
                    c23817a2.gsf.setText(str);
                    c23817a2.gsf.setMaxLines(r4);
                    C44089j.m79290a(c23817a2.gsf, false, null);
                }
                c23817a2.grM.setText(str2);
                if (C5046bo.isNullOrNil(str3)) {
                    c23817a2.iNr.setVisibility(8);
                    c23817a2.gsf.setPadding(0, 0, 0, 0);
                } else {
                    c23817a2.iNr.setVisibility(0);
                    C44346w.m80163h(c23817a2.iNr, str3);
                    c23817a2.gsf.setPadding(0, 0, C1338a.fromDPToPix(this.yJI.yTx.getContext(), 28), 0);
                }
                str = (String) map.get(concat + ".url");
                final String nullAsNil = C5046bo.nullAsNil((String) map.get(".msg.fromusername"));
                int i3 = C5046bo.getInt((String) map.get(concat + ".op_type"), 0);
                str3 = (String) map.get(concat + ".weapp_username");
                c23817a2.zbb.setTag(new C40814ay(c7620bi, nullAsNil, str));
                final int i4 = i2 + 1;
                if (i3 == 1 && !TextUtils.isEmpty(str3)) {
                    final String str4 = (String) map.get(concat + ".weapp_path");
                    final int i5 = C5046bo.getInt((String) map.get(concat + ".weapp_version"), 0);
                    final int i6 = C5046bo.getInt((String) map.get(concat + ".weapp_state"), 0);
                    final String nullAsNil2 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.template_id"));
                    c23817a2.zbb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(33135);
                            C40814ay c40814ay = (C40814ay) view.getTag();
                            C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str3);
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.cst = c40814ay.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.userName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C44346w.this.yJI.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nullAsNil2;
                            if (((C27500a) C1720g.m3528K(C27500a.class)).mo35247mg(c40814ay.userName)) {
                                appBrandStatObject.scene = C44346w.arF(nullAsNil2);
                                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C44346w.this.yJI.yTx.getContext(), str3, null, i6, i5, str4, appBrandStatObject);
                            } else {
                                appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
                                C16527d qX = C17903f.m28104qX(c40814ay.userName);
                                ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(C44346w.this.yJI.yTx.getContext(), str3, null, i6, i5, str4, appBrandStatObject, qX == null ? null : qX.field_appId);
                            }
                            C44346w.m80145M(9, C44346w.this.mAppId, C44346w.this.zeS);
                            C7060h.pYm.mo8381e(11608, C44346w.this.zeS, nullAsNil, Integer.valueOf(i4));
                            AppMethodBeat.m2505o(33135);
                        }
                    });
                } else if (i3 == 2) {
                    final Map<String, String> map2 = map;
                    c23817a2.zbb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(33136);
                            if (i4 == 1) {
                                C44346w.m80157b(view.getContext(), (String) map2.get(".msg.appmsg.mmreader.category.item.schedule_username"), C5046bo.getLong((String) map2.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
                                C7060h.pYm.mo8378a(795, 2, 1, false);
                                C4990ab.m7417i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", r0, Long.valueOf(r10));
                                AppMethodBeat.m2505o(33136);
                                return;
                            }
                            if (i4 == 2) {
                                C25985d.m41473f(view.getContext(), ".ui.AllRemindMsgUI", new Intent());
                            }
                            AppMethodBeat.m2505o(33136);
                        }
                    });
                } else {
                    c23817a2.zbb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(33137);
                            if (!C5046bo.isNullOrNil(str)) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str);
                                C25985d.m41467b(C44346w.this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                C7060h.pYm.mo8381e(11608, C44346w.this.zeS, nullAsNil, Integer.valueOf(i4));
                            }
                            AppMethodBeat.m2505o(33137);
                        }
                    });
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(33166);
    }

    /* renamed from: h */
    private static void m80163h(ImageView imageView, String str) {
        AppMethodBeat.m2504i(33167);
        if (C5046bo.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.m2505o(33167);
            return;
        }
        C17927a c17927a = new C17927a();
        C9638aw.m17190ZK();
        c17927a.ePK = C18628c.m29089XX();
        c17927a.ePH = true;
        c17927a.ePZ = true;
        C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        AppMethodBeat.m2505o(33167);
    }

    /* renamed from: L */
    private static void m80144L(int i, String str, String str2) {
        AppMethodBeat.m2504i(33168);
        C4990ab.m7411d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", Integer.valueOf(13796), Integer.valueOf(i), str, str2);
        C7060h.pYm.mo8381e(13796, Integer.valueOf(i), str, str2, Integer.valueOf(0), Long.valueOf(C5046bo.anT()));
        AppMethodBeat.m2505o(33168);
    }

    static {
        AppMethodBeat.m2504i(33177);
        AppMethodBeat.m2505o(33177);
    }

    /* renamed from: e */
    private static int m80160e(Map<String, String> map, String str, int i) {
        AppMethodBeat.m2504i(33169);
        if (map == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(33169);
        } else {
            try {
                i = Color.parseColor(C5046bo.nullAsNil((String) map.get(str)));
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(33169);
        }
        return i;
    }

    private static int arE(String str) {
        int i = 0;
        AppMethodBeat.m2504i(33170);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(33170);
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
                AppMethodBeat.m2505o(33170);
                return i3;
            }
        }
    }

    static /* synthetic */ int arF(String str) {
        AppMethodBeat.m2504i(33172);
        if (str == null || !str.startsWith("SUBSCRIPTION")) {
            AppMethodBeat.m2505o(33172);
            return 1014;
        }
        AppMethodBeat.m2505o(33172);
        return 1107;
    }
}
