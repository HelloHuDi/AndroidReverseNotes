package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

public final class h extends b {
    int eot = -1;
    HashSet<Integer> yZA = new HashSet();
    int yZg = 0;

    class a extends com.tencent.mm.ui.chatting.a.c.b {
        public String appId;
        public String desc;
        public int iconRes;
        public String imagePath;
        public String source;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.i(32646);
            if (str != null) {
                String toLowerCase = str.toLowerCase();
                if (com.tencent.mm.ui.chatting.a.c.b.arh(toLowerCase)) {
                    if (!bo.isNullOrNil(this.source) && this.source.toLowerCase().contains(toLowerCase)) {
                        AppMethodBeat.o(32646);
                        return true;
                    }
                } else if (!bo.isNullOrNil(this.source) && isContains(toLowerCase, this.source.toLowerCase())) {
                    AppMethodBeat.o(32646);
                    return true;
                }
                boolean arg = super.arg(toLowerCase);
                AppMethodBeat.o(32646);
                return arg;
            }
            AppMethodBeat.o(32646);
            return false;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.c.a {
        TextView gnC;
        ImageView iqT;
        TextView moL;

        public b(View view) {
            super(view);
            AppMethodBeat.i(32647);
            this.iqT = (ImageView) view.findViewById(R.id.yk);
            this.gnC = (TextView) view.findViewById(R.id.av);
            this.moL = (TextView) view.findViewById(R.id.b8);
            this.moL.setVisibility(0);
            AppMethodBeat.o(32647);
        }
    }

    public h(Context context) {
        super(context);
        AppMethodBeat.i(32648);
        AppMethodBeat.o(32648);
    }

    public final int getType() {
        AppMethodBeat.i(32649);
        this.yZA.add(Integer.valueOf(5));
        this.yZA.add(Integer.valueOf(7));
        this.yZA.add(Integer.valueOf(27));
        this.yZA.add(Integer.valueOf(26));
        this.yZA.add(Integer.valueOf(15));
        AppMethodBeat.o(32649);
        return -1;
    }

    public final void dFH() {
        AppMethodBeat.i(32650);
        this.yYY.dFL();
        g.RQ();
        g.RS().aa(new Runnable() {
            final /* synthetic */ boolean kve = true;

            public final void run() {
                AppMethodBeat.i(32641);
                LinkedList linkedList = new LinkedList();
                aw.ZK();
                Cursor cu = c.XO().cu(h.this.emo, h.this.eot);
                if (cu == null) {
                    ab.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(32641);
                    return;
                }
                u oa;
                if (t.kH(h.this.emo)) {
                    aw.ZK();
                    oa = c.XV().oa(h.this.emo);
                } else {
                    oa = null;
                }
                long j = 0;
                while (cu.moveToNext()) {
                    try {
                        cy biVar = new bi();
                        biVar.d(cu);
                        String str = biVar.field_content;
                        if (str != null) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                            if (me != null) {
                                h hVar = h.this;
                                int i = me.type;
                                hVar.getType();
                                if (hVar.yZA.contains(Integer.valueOf(i))) {
                                    long b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                                    if (j != b) {
                                        linkedList.add(new com.tencent.mm.ui.chatting.a.c.c(biVar.field_createTime));
                                        h hVar2 = h.this;
                                        hVar2.yZg++;
                                    }
                                    String b2 = b.b(biVar, t.kH(h.this.emo));
                                    ad aoO = ((j) g.K(j.class)).XM().aoO(b2);
                                    String str2 = "";
                                    if (oa != null) {
                                        str2 = oa.mJ(b2);
                                    }
                                    int LX = com.tencent.mm.plugin.fav.ui.c.LX(me.fgp);
                                    String appName = com.tencent.mm.plugin.fav.a.b.getAppName(h.this.mContext, me.cMg);
                                    aw.ZK();
                                    ad aoO2 = c.XM().aoO(me.cMg);
                                    if (aoO2 == null || !aoO2.field_username.equals(me.cMg)) {
                                        com.tencent.mm.model.ao.a.flu.a(me.cMg, "", null);
                                    } else {
                                        appName = aoO2.Oj();
                                    }
                                    a aVar = new a(biVar.field_createTime, me.type, me.title, biVar.field_msgId, aoO.field_username, aoO.Oi(), aoO.field_conRemark, str2);
                                    aVar.source = bo.isNullOrNil(appName) ? me.description : appName;
                                    aVar.appId = me.appId;
                                    if (bo.isNullOrNil(biVar.field_imgPath)) {
                                        aVar.imagePath = me.thumburl;
                                    } else {
                                        aVar.imagePath = biVar.field_imgPath;
                                    }
                                    aVar.iconRes = LX;
                                    linkedList.add(aVar);
                                    j = b;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        cu.close();
                        AppMethodBeat.o(32641);
                    }
                }
                cu.close();
                h.this.iPr.addAll(linkedList);
                h.this.yZa = h.this.iPr;
                linkedList.clear();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32640);
                        if (h.this.yYY != null) {
                            h.this.yYY.p(AnonymousClass1.this.kve, h.this.iPr.size());
                        }
                        AppMethodBeat.o(32640);
                    }
                });
                AppMethodBeat.o(32641);
            }
        });
        AppMethodBeat.o(32650);
    }

    public final String aoy() {
        AppMethodBeat.i(32651);
        String string = this.mContext.getString(R.string.fe);
        AppMethodBeat.o(32651);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.i(32652);
        String string = this.mContext.getString(R.string.fe);
        AppMethodBeat.o(32652);
        return string;
    }

    public final e dFI() {
        AppMethodBeat.i(32653);
        AnonymousClass2 anonymousClass2 = new e() {
            public final void a(View view, int i, com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32644);
                ab.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i));
                if (bVar == null) {
                    ab.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", Integer.valueOf(i));
                    AppMethodBeat.o(32644);
                    return;
                }
                a aVar = (a) bVar;
                if (aVar.getType() == 5) {
                    h.a(h.this, view, aVar);
                    AppMethodBeat.o(32644);
                } else if (aVar.getType() == 7) {
                    h.a(h.this, aVar);
                    AppMethodBeat.o(32644);
                } else if (aVar.getType() == 15) {
                    h.b(h.this, aVar);
                    AppMethodBeat.o(32644);
                } else if (aVar.getType() == 26) {
                    h.c(h.this, aVar);
                    AppMethodBeat.o(32644);
                } else if (aVar.getType() == 27) {
                    h.d(h.this, aVar);
                    AppMethodBeat.o(32644);
                } else {
                    ab.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", Integer.valueOf(aVar.getType()));
                    AppMethodBeat.o(32644);
                }
            }

            public final void b(View view, final int i, final com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32645);
                ab.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
                new com.tencent.mm.ui.tools.j(view.getContext()).b(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(32642);
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.string.dr8));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.string.akj));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.string.am7));
                        AppMethodBeat.o(32642);
                    }
                }, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(32643);
                        if (bVar == null) {
                            ab.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", Integer.valueOf(i));
                            AppMethodBeat.o(32643);
                            return;
                        }
                        aw.ZK();
                        h.this.d(i, c.XO().jf(bVar.cvx));
                        AppMethodBeat.o(32643);
                    }
                });
                AppMethodBeat.o(32645);
            }
        };
        AppMethodBeat.o(32653);
        return anonymousClass2;
    }

    public final v v(ViewGroup viewGroup) {
        AppMethodBeat.i(32654);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.b17, viewGroup, false));
        AppMethodBeat.o(32654);
        return bVar;
    }

    public final void a(com.tencent.mm.ui.chatting.a.c.a aVar, int i) {
        AppMethodBeat.i(32655);
        b bVar = (b) aVar;
        a aVar2 = (a) Oy(i);
        if (bo.isNullOrNil(aVar2.desc) || !bo.isNullOrNil(aVar2.source)) {
            bVar.gnC.setVisibility(8);
        } else {
            bVar.gnC.setVisibility(0);
            bVar.gnC.setText(bo.bc(aVar2.desc, ""));
        }
        Bitmap a = o.ahl().a(aVar2.imagePath, com.tencent.mm.bz.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = com.tencent.mm.pluginsdk.model.app.g.b(aVar2.appId, 1, com.tencent.mm.bz.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                com.tencent.mm.at.a.a.c.a aVar3 = new com.tencent.mm.at.a.a.c.a();
                aVar3.ePT = R.color.k8;
                aVar3.ePG = true;
                aVar3.ePJ = q.v(aVar2.imagePath, aVar2.type, "@T");
                aVar3.ct(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50)).ePF = true;
                o.ahp().a(aVar2.imagePath, bVar.iqT, aVar3.ahG());
                bVar.moL.setText(bo.bc(aVar2.source, ""));
                com.tencent.mm.ui.chatting.a.c.a.c(bVar.moL, this.yYZ.yNK);
                AppMethodBeat.o(32655);
            }
        }
        bVar.iqT.setImageBitmap(a);
        bVar.moL.setText(bo.bc(aVar2.source, ""));
        com.tencent.mm.ui.chatting.a.c.a.c(bVar.moL, this.yYZ.yNK);
        AppMethodBeat.o(32655);
    }

    private static String aO(Context context, String str) {
        String str2;
        AppMethodBeat.i(32657);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.o(32657);
                return str2;
            }
        } catch (NameNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(32657);
        return str2;
    }

    private boolean a(bi biVar, f fVar) {
        AppMethodBeat.i(32656);
        if (biVar.field_talker.endsWith("@qqim") && fVar.field_packageName.equals(TbsConfig.APP_QQ)) {
            int i;
            ab.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setClassName(TbsConfig.APP_QQ, aO(this.mContext, TbsConfig.APP_QQ));
            intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            aw.ZK();
            Object obj = c.Ry().get(9, null);
            if (obj == null || !(obj instanceof Integer)) {
                i = 0;
            } else {
                i = ((Integer) obj).intValue();
            }
            if (i != 0) {
                try {
                    byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    i = 0;
                    int i2 = 0;
                    while (i < length) {
                        byte b = bytes2[i];
                        if (i2 >= bytes.length) {
                            break;
                        }
                        int i3 = i2 + 1;
                        bytes[i2] = (byte) (b ^ bytes[i2]);
                        i++;
                        i2 = i3;
                    }
                    intent.putExtra("tencent_gif", bytes);
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
                }
            }
            try {
                this.mContext.startActivity(intent);
            } catch (Exception e2) {
            }
            AppMethodBeat.o(32656);
            return true;
        }
        AppMethodBeat.o(32656);
        return false;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(32658);
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            AppMethodBeat.o(32658);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.o(32658);
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
                AppMethodBeat.o(32658);
            }
        }
        return packageInfo;
    }

    static /* synthetic */ void a(h hVar, View view, a aVar) {
        int i;
        AppMethodBeat.i(32659);
        aw.ZK();
        bi jf = c.XO().jf(aVar.cvx);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(jf.field_content);
        com.tencent.mm.af.e eVar = (com.tencent.mm.af.e) me.X(com.tencent.mm.af.e.class);
        if (eVar != null && eVar.fgb == 1 && eVar.ffZ == 5 && ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
            Bundle bundle = new Bundle();
            bundle.putInt("biz_video_scene", 1);
            bundle.putInt("biz_video_subscene", Downloads.MIN_WAIT_FOR_NETWORK);
            bundle.putInt("geta8key_scene", 1);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.a(view.getContext(), jf.field_msgId, jf.field_msgSvrId, 0, view.findViewById(R.id.yk), bundle);
            i = 1;
        } else {
            i = 0;
        }
        if (!(i != 0 || me.url == null || me.url.equals(""))) {
            String B = p.B(me.url, t.kH(hVar.emo) ? "groupmessage" : "singlemessage");
            String str = me.url;
            PackageInfo packageInfo = getPackageInfo(hVar.mContext, me.appId);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", B);
            intent.putExtra("webpageTitle", me.title);
            if (me.appId != null && ("wx751a1acca5688ba3".equals(me.appId) || "wxfbc915ff7c30e335".equals(me.appId) || "wx482a4001c37e2b74".equals(me.appId))) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("jsapi_args_appid", me.appId);
                intent.putExtra("jsapiargs", bundle2);
            }
            if (bo.isNullOrNil(str)) {
                intent.putExtra("shortUrl", me.url);
            } else {
                intent.putExtra("shortUrl", str);
            }
            intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            if (!bo.isNullOrNil(me.cMg)) {
                intent.putExtra("srcUsername", me.cMg);
                intent.putExtra("srcDisplayname", me.cMh);
            }
            intent.putExtra("msg_id", jf.field_msgId);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(jf.field_msgSvrId));
            intent.putExtra("KAppId", me.appId);
            intent.putExtra("geta8key_username", hVar.emo);
            B = b.b(jf, t.kH(hVar.emo));
            intent.putExtra("pre_username", B);
            intent.putExtra("prePublishId", "msg_" + Long.toString(jf.field_msgSvrId));
            intent.putExtra("preUsername", B);
            intent.putExtra("preChatName", hVar.emo);
            intent.putExtra("preChatTYPE", com.tencent.mm.model.u.ad(B, hVar.emo));
            intent.putExtra("preMsgIndex", 0);
            com.tencent.mm.bp.d.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(32659);
    }

    static /* synthetic */ void b(h hVar, a aVar) {
        AppMethodBeat.i(32661);
        aw.ZK();
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(c.XO().jf(aVar.cvx).field_content);
        CharSequence charSequence = me.fgX;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jk(me.url);
        }
        if (TextUtils.isEmpty(charSequence)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", r.Yz());
            intent.putExtra("rawUrl", me.url);
            com.tencent.mm.bp.d.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(32661);
            return;
        }
        ab.d("MicroMsg.UrlHistoryListPresenter", "start emoji detail from brandcontact");
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", charSequence);
        intent2.putExtra("preceding_scence", 123);
        intent2.putExtra("download_entrance_scene", 23);
        com.tencent.mm.bp.d.b(hVar.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        com.tencent.mm.plugin.report.service.h.pYm.e(10993, Integer.valueOf(2), charSequence);
        AppMethodBeat.o(32661);
    }

    static /* synthetic */ void c(h hVar, a aVar) {
        AppMethodBeat.i(32662);
        aw.ZK();
        bi jf = c.XO().jf(aVar.cvx);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(jf.field_content);
        int i = me.tid;
        String str = me.fiE;
        String str2 = me.desc;
        String str3 = me.iconUrl;
        String str4 = me.secondUrl;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", b.b(jf, t.kH(hVar.emo)));
            intent.putExtra("rawUrl", me.dJv);
            intent.putExtra("topic_id", i);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 23);
            com.tencent.mm.bp.d.b(hVar.mContext, "emoji", ".ui.EmojiStoreTopicUI", intent);
            AppMethodBeat.o(32662);
            return;
        }
        ab.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
        AppMethodBeat.o(32662);
    }

    static /* synthetic */ void d(h hVar, a aVar) {
        AppMethodBeat.i(32663);
        aw.ZK();
        bi jf = c.XO().jf(aVar.cvx);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(jf.field_content);
        int i = me.tid;
        String str = me.fiE;
        String str2 = me.desc;
        String str3 = me.iconUrl;
        String str4 = me.secondUrl;
        int i2 = me.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", b.b(jf, t.kH(hVar.emo)));
            intent.putExtra("rawUrl", me.dJv);
            intent.putExtra("set_id", i);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i2);
            com.tencent.mm.bp.d.b(hVar.mContext, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            AppMethodBeat.o(32663);
            return;
        }
        ab.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
        AppMethodBeat.o(32663);
    }
}
