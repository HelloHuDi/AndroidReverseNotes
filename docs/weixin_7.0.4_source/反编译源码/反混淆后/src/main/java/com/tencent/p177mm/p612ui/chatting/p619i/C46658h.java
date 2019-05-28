package com.tencent.p177mm.p612ui.chatting.p619i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p069v7.widget.RecyclerView.C41531v;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30451e;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30453a;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30454c;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30455b;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.i.h */
public final class C46658h extends C24961b {
    int eot = -1;
    HashSet<Integer> yZA = new HashSet();
    int yZg = 0;

    /* renamed from: com.tencent.mm.ui.chatting.i.h$a */
    class C15698a extends C30455b {
        public String appId;
        public String desc;
        public int iconRes;
        public String imagePath;
        public String source;

        public C15698a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.m2504i(32646);
            if (str != null) {
                String toLowerCase = str.toLowerCase();
                if (C30455b.arh(toLowerCase)) {
                    if (!C5046bo.isNullOrNil(this.source) && this.source.toLowerCase().contains(toLowerCase)) {
                        AppMethodBeat.m2505o(32646);
                        return true;
                    }
                } else if (!C5046bo.isNullOrNil(this.source) && isContains(toLowerCase, this.source.toLowerCase())) {
                    AppMethodBeat.m2505o(32646);
                    return true;
                }
                boolean arg = super.arg(toLowerCase);
                AppMethodBeat.m2505o(32646);
                return arg;
            }
            AppMethodBeat.m2505o(32646);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.h$1 */
    class C361921 implements Runnable {
        final /* synthetic */ boolean kve = true;

        /* renamed from: com.tencent.mm.ui.chatting.i.h$1$1 */
        class C361911 implements Runnable {
            C361911() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32640);
                if (C46658h.this.yYY != null) {
                    C46658h.this.yYY.mo27870p(C361921.this.kve, C46658h.this.iPr.size());
                }
                AppMethodBeat.m2505o(32640);
            }
        }

        C361921() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32641);
            LinkedList linkedList = new LinkedList();
            C9638aw.m17190ZK();
            Cursor cu = C18628c.m29080XO().mo15322cu(C46658h.this.emo, C46658h.this.eot);
            if (cu == null) {
                C4990ab.m7412e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
                AppMethodBeat.m2505o(32641);
                return;
            }
            C7577u oa;
            if (C1855t.m3896kH(C46658h.this.emo)) {
                C9638aw.m17190ZK();
                oa = C18628c.m29087XV().mo14885oa(C46658h.this.emo);
            } else {
                oa = null;
            }
            long j = 0;
            while (cu.moveToNext()) {
                try {
                    C6575cy c7620bi = new C7620bi();
                    c7620bi.mo8995d(cu);
                    String str = c7620bi.field_content;
                    if (str != null) {
                        C8910b me = C8910b.m16064me(str);
                        if (me != null) {
                            C46658h c46658h = C46658h.this;
                            int i = me.type;
                            c46658h.getType();
                            if (c46658h.yZA.contains(Integer.valueOf(i))) {
                                long b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                                if (j != b) {
                                    linkedList.add(new C30454c(c7620bi.field_createTime));
                                    C46658h c46658h2 = C46658h.this;
                                    c46658h2.yZg++;
                                }
                                String b2 = C24961b.m39082b(c7620bi, C1855t.m3896kH(C46658h.this.emo));
                                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(b2);
                                String str2 = "";
                                if (oa != null) {
                                    str2 = oa.mo16807mJ(b2);
                                }
                                int LX = C45932c.m85252LX(me.fgp);
                                String appName = C39037b.getAppName(C46658h.this.mContext, me.cMg);
                                C9638aw.m17190ZK();
                                C7616ad aoO2 = C18628c.m29078XM().aoO(me.cMg);
                                if (aoO2 == null || !aoO2.field_username.equals(me.cMg)) {
                                    C26417a.flu.mo20966a(me.cMg, "", null);
                                } else {
                                    appName = aoO2.mo16707Oj();
                                }
                                C15698a c15698a = new C15698a(c7620bi.field_createTime, me.type, me.title, c7620bi.field_msgId, aoO.field_username, aoO.mo16706Oi(), aoO.field_conRemark, str2);
                                c15698a.source = C5046bo.isNullOrNil(appName) ? me.description : appName;
                                c15698a.appId = me.appId;
                                if (C5046bo.isNullOrNil(c7620bi.field_imgPath)) {
                                    c15698a.imagePath = me.thumburl;
                                } else {
                                    c15698a.imagePath = c7620bi.field_imgPath;
                                }
                                c15698a.iconRes = LX;
                                linkedList.add(c15698a);
                                j = b;
                            }
                        }
                    }
                } catch (Throwable th) {
                    cu.close();
                    AppMethodBeat.m2505o(32641);
                }
            }
            cu.close();
            C46658h.this.iPr.addAll(linkedList);
            C46658h.this.yZa = C46658h.this.iPr;
            linkedList.clear();
            C5004al.m7441d(new C361911());
            AppMethodBeat.m2505o(32641);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.h$2 */
    class C361932 implements C30451e {

        /* renamed from: com.tencent.mm.ui.chatting.i.h$2$1 */
        class C361941 implements OnCreateContextMenuListener {
            C361941() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(32642);
                contextMenu.add(0, 0, 0, view.getContext().getString(C25738R.string.dr8));
                contextMenu.add(0, 1, 0, view.getContext().getString(C25738R.string.akj));
                contextMenu.add(0, 2, 0, view.getContext().getString(C25738R.string.am7));
                AppMethodBeat.m2505o(32642);
            }
        }

        C361932() {
        }

        /* renamed from: a */
        public final void mo48855a(View view, int i, C30455b c30455b) {
            AppMethodBeat.m2504i(32644);
            C4990ab.m7417i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i));
            if (c30455b == null) {
                C4990ab.m7413e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", Integer.valueOf(i));
                AppMethodBeat.m2505o(32644);
                return;
            }
            C15698a c15698a = (C15698a) c30455b;
            if (c15698a.getType() == 5) {
                C46658h.m88349a(C46658h.this, view, c15698a);
                AppMethodBeat.m2505o(32644);
            } else if (c15698a.getType() == 7) {
                C46658h.m88350a(C46658h.this, c15698a);
                AppMethodBeat.m2505o(32644);
            } else if (c15698a.getType() == 15) {
                C46658h.m88353b(C46658h.this, c15698a);
                AppMethodBeat.m2505o(32644);
            } else if (c15698a.getType() == 26) {
                C46658h.m88354c(C46658h.this, c15698a);
                AppMethodBeat.m2505o(32644);
            } else if (c15698a.getType() == 27) {
                C46658h.m88355d(C46658h.this, c15698a);
                AppMethodBeat.m2505o(32644);
            } else {
                C4990ab.m7413e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", Integer.valueOf(c15698a.getType()));
                AppMethodBeat.m2505o(32644);
            }
        }

        /* renamed from: b */
        public final void mo48856b(View view, final int i, final C30455b c30455b) {
            AppMethodBeat.m2504i(32645);
            C4990ab.m7417i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
            new C46696j(view.getContext()).mo75009b(view, new C361941(), new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(32643);
                    if (c30455b == null) {
                        C4990ab.m7413e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", Integer.valueOf(i));
                        AppMethodBeat.m2505o(32643);
                        return;
                    }
                    C9638aw.m17190ZK();
                    C46658h.this.mo41865d(i, C18628c.m29080XO().mo15340jf(c30455b.cvx));
                    AppMethodBeat.m2505o(32643);
                }
            });
            AppMethodBeat.m2505o(32645);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.h$b */
    class C46657b extends C30453a {
        TextView gnC;
        ImageView iqT;
        TextView moL;

        public C46657b(View view) {
            super(view);
            AppMethodBeat.m2504i(32647);
            this.iqT = (ImageView) view.findViewById(2131821479);
            this.gnC = (TextView) view.findViewById(2131820602);
            this.moL = (TextView) view.findViewById(2131820615);
            this.moL.setVisibility(0);
            AppMethodBeat.m2505o(32647);
        }
    }

    public C46658h(Context context) {
        super(context);
        AppMethodBeat.m2504i(32648);
        AppMethodBeat.m2505o(32648);
    }

    public final int getType() {
        AppMethodBeat.m2504i(32649);
        this.yZA.add(Integer.valueOf(5));
        this.yZA.add(Integer.valueOf(7));
        this.yZA.add(Integer.valueOf(27));
        this.yZA.add(Integer.valueOf(26));
        this.yZA.add(Integer.valueOf(15));
        AppMethodBeat.m2505o(32649);
        return -1;
    }

    public final void dFH() {
        AppMethodBeat.m2504i(32650);
        this.yYY.dFL();
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C361921());
        AppMethodBeat.m2505o(32650);
    }

    public final String aoy() {
        AppMethodBeat.m2504i(32651);
        String string = this.mContext.getString(C25738R.string.f8801fe);
        AppMethodBeat.m2505o(32651);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.m2504i(32652);
        String string = this.mContext.getString(C25738R.string.f8801fe);
        AppMethodBeat.m2505o(32652);
        return string;
    }

    public final C30451e dFI() {
        AppMethodBeat.m2504i(32653);
        C361932 c361932 = new C361932();
        AppMethodBeat.m2505o(32653);
        return c361932;
    }

    /* renamed from: v */
    public final C41531v mo39525v(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(32654);
        C46657b c46657b = new C46657b(LayoutInflater.from(viewGroup.getContext()).inflate(2130970983, viewGroup, false));
        AppMethodBeat.m2505o(32654);
        return c46657b;
    }

    /* renamed from: a */
    public final void mo39523a(C30453a c30453a, int i) {
        AppMethodBeat.m2504i(32655);
        C46657b c46657b = (C46657b) c30453a;
        C15698a c15698a = (C15698a) mo39522Oy(i);
        if (C5046bo.isNullOrNil(c15698a.desc) || !C5046bo.isNullOrNil(c15698a.source)) {
            c46657b.gnC.setVisibility(8);
        } else {
            c46657b.gnC.setVisibility(0);
            c46657b.gnC.setText(C5046bo.m7532bc(c15698a.desc, ""));
        }
        Bitmap a = C32291o.ahl().mo73087a(c15698a.imagePath, C1338a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = C46494g.m87732b(c15698a.appId, 1, C1338a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                C17927a c17927a = new C17927a();
                c17927a.ePT = C25738R.color.f11875k8;
                c17927a.ePG = true;
                c17927a.ePJ = C30080q.m47642v(c15698a.imagePath, c15698a.type, "@T");
                c17927a.mo33448ct(C1338a.fromDPToPix(C4996ah.getContext(), 50), C1338a.fromDPToPix(C4996ah.getContext(), 50)).ePF = true;
                C32291o.ahp().mo43766a(c15698a.imagePath, c46657b.iqT, c17927a.ahG());
                c46657b.moL.setText(C5046bo.m7532bc(c15698a.source, ""));
                C30453a.m48568c(c46657b.moL, this.yYZ.yNK);
                AppMethodBeat.m2505o(32655);
            }
        }
        c46657b.iqT.setImageBitmap(a);
        c46657b.moL.setText(C5046bo.m7532bc(c15698a.source, ""));
        C30453a.m48568c(c46657b.moL, this.yYZ.yNK);
        AppMethodBeat.m2505o(32655);
    }

    /* renamed from: aO */
    private static String m88352aO(Context context, String str) {
        String str2;
        AppMethodBeat.m2504i(32657);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.m2505o(32657);
                return str2;
            }
        } catch (NameNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.m2505o(32657);
        return str2;
    }

    /* renamed from: a */
    private boolean m88351a(C7620bi c7620bi, C40439f c40439f) {
        AppMethodBeat.m2504i(32656);
        if (c7620bi.field_talker.endsWith("@qqim") && c40439f.field_packageName.equals(TbsConfig.APP_QQ)) {
            int i;
            C4990ab.m7410d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setClassName(TbsConfig.APP_QQ, C46658h.m88352aO(this.mContext, TbsConfig.APP_QQ));
            intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            C9638aw.m17190ZK();
            Object obj = C18628c.m29072Ry().get(9, null);
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
                    C4990ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
                }
            }
            try {
                this.mContext.startActivity(intent);
            } catch (Exception e2) {
            }
            AppMethodBeat.m2505o(32656);
            return true;
        }
        AppMethodBeat.m2505o(32656);
        return false;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(32658);
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            C40439f bT = C46494g.m87739bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            AppMethodBeat.m2505o(32658);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.m2505o(32658);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
                AppMethodBeat.m2505o(32658);
            }
        }
        return packageInfo;
    }

    /* renamed from: a */
    static /* synthetic */ void m88349a(C46658h c46658h, View view, C15698a c15698a) {
        int i;
        AppMethodBeat.m2504i(32659);
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(c15698a.cvx);
        C8910b me = C8910b.m16064me(jf.field_content);
        C25747e c25747e = (C25747e) me.mo20333X(C25747e.class);
        if (c25747e != null && c25747e.fgb == 1 && c25747e.ffZ == 5 && ((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
            Bundle bundle = new Bundle();
            bundle.putInt("biz_video_scene", 1);
            bundle.putInt("biz_video_subscene", Downloads.MIN_WAIT_FOR_NETWORK);
            bundle.putInt("geta8key_scene", 1);
            C11263c.m18982a(view.getContext(), jf.field_msgId, jf.field_msgSvrId, 0, view.findViewById(2131821479), bundle);
            i = 1;
        } else {
            i = 0;
        }
        if (!(i != 0 || me.url == null || me.url.equals(""))) {
            String B = C35799p.m58684B(me.url, C1855t.m3896kH(c46658h.emo) ? "groupmessage" : "singlemessage");
            String str = me.url;
            PackageInfo packageInfo = C46658h.getPackageInfo(c46658h.mContext, me.appId);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", B);
            intent.putExtra("webpageTitle", me.title);
            if (me.appId != null && ("wx751a1acca5688ba3".equals(me.appId) || "wxfbc915ff7c30e335".equals(me.appId) || "wx482a4001c37e2b74".equals(me.appId))) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("jsapi_args_appid", me.appId);
                intent.putExtra("jsapiargs", bundle2);
            }
            if (C5046bo.isNullOrNil(str)) {
                intent.putExtra("shortUrl", me.url);
            } else {
                intent.putExtra("shortUrl", str);
            }
            intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            if (!C5046bo.isNullOrNil(me.cMg)) {
                intent.putExtra("srcUsername", me.cMg);
                intent.putExtra("srcDisplayname", me.cMh);
            }
            intent.putExtra("msg_id", jf.field_msgId);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(jf.field_msgSvrId));
            intent.putExtra("KAppId", me.appId);
            intent.putExtra("geta8key_username", c46658h.emo);
            B = C24961b.m39082b(jf, C1855t.m3896kH(c46658h.emo));
            intent.putExtra("pre_username", B);
            intent.putExtra("prePublishId", "msg_" + Long.toString(jf.field_msgSvrId));
            intent.putExtra("preUsername", B);
            intent.putExtra("preChatName", c46658h.emo);
            intent.putExtra("preChatTYPE", C32798u.m53583ad(B, c46658h.emo));
            intent.putExtra("preMsgIndex", 0);
            C25985d.m41467b(c46658h.mContext, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(32659);
    }

    /* renamed from: b */
    static /* synthetic */ void m88353b(C46658h c46658h, C15698a c15698a) {
        AppMethodBeat.m2504i(32661);
        C9638aw.m17190ZK();
        C8910b me = C8910b.m16064me(C18628c.m29080XO().mo15340jf(c15698a.cvx).field_content);
        CharSequence charSequence = me.fgX;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35603Jk(me.url);
        }
        if (TextUtils.isEmpty(charSequence)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("rawUrl", me.url);
            C25985d.m41467b(c46658h.mContext, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(32661);
            return;
        }
        C4990ab.m7410d("MicroMsg.UrlHistoryListPresenter", "start emoji detail from brandcontact");
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", charSequence);
        intent2.putExtra("preceding_scence", 123);
        intent2.putExtra("download_entrance_scene", 23);
        C25985d.m41467b(c46658h.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        C7060h.pYm.mo8381e(10993, Integer.valueOf(2), charSequence);
        AppMethodBeat.m2505o(32661);
    }

    /* renamed from: c */
    static /* synthetic */ void m88354c(C46658h c46658h, C15698a c15698a) {
        AppMethodBeat.m2504i(32662);
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(c15698a.cvx);
        C8910b me = C8910b.m16064me(jf.field_content);
        int i = me.tid;
        String str = me.fiE;
        String str2 = me.desc;
        String str3 = me.iconUrl;
        String str4 = me.secondUrl;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", C24961b.m39082b(jf, C1855t.m3896kH(c46658h.emo)));
            intent.putExtra("rawUrl", me.dJv);
            intent.putExtra("topic_id", i);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 23);
            C25985d.m41467b(c46658h.mContext, "emoji", ".ui.EmojiStoreTopicUI", intent);
            AppMethodBeat.m2505o(32662);
            return;
        }
        C4990ab.m7416i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
        AppMethodBeat.m2505o(32662);
    }

    /* renamed from: d */
    static /* synthetic */ void m88355d(C46658h c46658h, C15698a c15698a) {
        AppMethodBeat.m2504i(32663);
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(c15698a.cvx);
        C8910b me = C8910b.m16064me(jf.field_content);
        int i = me.tid;
        String str = me.fiE;
        String str2 = me.desc;
        String str3 = me.iconUrl;
        String str4 = me.secondUrl;
        int i2 = me.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", C24961b.m39082b(jf, C1855t.m3896kH(c46658h.emo)));
            intent.putExtra("rawUrl", me.dJv);
            intent.putExtra("set_id", i);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i2);
            C25985d.m41467b(c46658h.mContext, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            AppMethodBeat.m2505o(32663);
            return;
        }
        C4990ab.m7416i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
        AppMethodBeat.m2505o(32663);
    }
}
