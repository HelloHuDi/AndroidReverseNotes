package com.tencent.p177mm.p612ui.chatting.p619i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
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
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C34171j;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Date;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.i.f */
public final class C30540f extends C24961b {
    int eot = -1;
    private int moz = 0;
    int yZg = 0;

    /* renamed from: com.tencent.mm.ui.chatting.i.f$1 */
    class C156951 implements Runnable {
        final /* synthetic */ boolean kve = true;

        /* renamed from: com.tencent.mm.ui.chatting.i.f$1$1 */
        class C156961 implements Runnable {
            C156961() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32610);
                if (C30540f.this.yYY != null) {
                    C30540f.this.yYY.mo27870p(C156951.this.kve, C30540f.this.iPr.size());
                }
                AppMethodBeat.m2505o(32610);
            }
        }

        C156951() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32611);
            LinkedList linkedList = new LinkedList();
            C9638aw.m17190ZK();
            Cursor cu = C18628c.m29080XO().mo15322cu(C30540f.this.emo, C30540f.this.eot);
            if (cu == null) {
                C4990ab.m7412e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
                AppMethodBeat.m2505o(32611);
                return;
            }
            C7577u oa;
            if (C1855t.m3896kH(C30540f.this.emo)) {
                C9638aw.m17190ZK();
                oa = C18628c.m29087XV().mo14885oa(C30540f.this.emo);
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
                            Object obj;
                            if (3 == me.type) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                long b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                                if (j != b) {
                                    linkedList.add(new C30454c(c7620bi.field_createTime));
                                    C30540f c30540f = C30540f.this;
                                    c30540f.yZg++;
                                }
                                String b2 = C24961b.m39082b(c7620bi, C1855t.m3896kH(C30540f.this.emo));
                                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(b2);
                                String str2 = "";
                                if (oa != null) {
                                    str2 = oa.mo16807mJ(b2);
                                }
                                int LX = C45932c.m85252LX(me.fgp);
                                String appName = C39037b.getAppName(C30540f.this.mContext, me.cMg);
                                C9638aw.m17190ZK();
                                C7616ad aoO2 = C18628c.m29078XM().aoO(me.cMg);
                                if (aoO2 == null || !aoO2.field_username.equals(me.cMg)) {
                                    C26417a.flu.mo20966a(me.cMg, "", null);
                                } else {
                                    appName = aoO2.mo16707Oj();
                                }
                                C23793a c23793a = new C23793a(c7620bi.field_createTime, me.type, me.title, c7620bi.field_msgId, aoO.field_username, aoO.mo16706Oi(), aoO.field_conRemark, str2);
                                c23793a.source = C5046bo.isNullOrNil(appName) ? me.description : appName;
                                c23793a.appId = me.appId;
                                c23793a.imagePath = c7620bi.field_imgPath;
                                c23793a.iconRes = LX;
                                linkedList.add(c23793a);
                                j = b;
                            }
                        }
                    }
                } catch (Throwable th) {
                    cu.close();
                    AppMethodBeat.m2505o(32611);
                }
            }
            cu.close();
            C30540f.this.iPr.addAll(linkedList);
            C30540f.this.yZa = C30540f.this.iPr;
            linkedList.clear();
            C5004al.m7441d(new C156961());
            AppMethodBeat.m2505o(32611);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.f$a */
    class C23793a extends C30455b {
        public String appId;
        public int iconRes;
        public String imagePath;
        public String source;

        public C23793a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.m2504i(32616);
            if (str != null) {
                String toLowerCase = str.toLowerCase();
                if (C30455b.arh(toLowerCase)) {
                    if (!C5046bo.isNullOrNil(this.source) && this.source.toLowerCase().contains(toLowerCase)) {
                        AppMethodBeat.m2505o(32616);
                        return true;
                    }
                } else if (!C5046bo.isNullOrNil(this.source) && isContains(toLowerCase, this.source.toLowerCase())) {
                    AppMethodBeat.m2505o(32616);
                    return true;
                }
                boolean arg = super.arg(toLowerCase);
                AppMethodBeat.m2505o(32616);
                return arg;
            }
            AppMethodBeat.m2505o(32616);
            return false;
        }

        public final int getType() {
            return 3;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.f$b */
    class C30541b extends C30453a {
        TextView gnC;
        ImageView iqT;
        TextView moL;
        ImageView moR;

        public C30541b(View view) {
            super(view);
            AppMethodBeat.m2504i(32617);
            this.iqT = (ImageView) view.findViewById(2131821479);
            this.gnC = (TextView) view.findViewById(2131820602);
            this.gnC.setVisibility(8);
            this.moL = (TextView) view.findViewById(2131820615);
            this.moR = (ImageView) view.findViewById(2131821480);
            this.moR.setImageResource(C25738R.drawable.f6932vs);
            this.moR.setVisibility(0);
            AppMethodBeat.m2505o(32617);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.f$2 */
    class C305422 implements C30451e {

        /* renamed from: com.tencent.mm.ui.chatting.i.f$2$1 */
        class C237911 implements OnCreateContextMenuListener {
            C237911() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(32612);
                contextMenu.add(0, 0, 0, view.getContext().getString(C25738R.string.dr8));
                contextMenu.add(0, 1, 0, view.getContext().getString(C25738R.string.akj));
                contextMenu.add(0, 2, 0, view.getContext().getString(C25738R.string.am7));
                AppMethodBeat.m2505o(32612);
            }
        }

        C305422() {
        }

        /* renamed from: a */
        public final void mo48855a(View view, int i, C30455b c30455b) {
            String str;
            int i2;
            AppMethodBeat.m2504i(32614);
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(c30455b.cvx);
            C8910b me = C8910b.m16064me(jf.field_content);
            String B = C35799p.m58684B(me.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            String B2 = C35799p.m58684B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            PackageInfo packageInfo = C30540f.getPackageInfo(C30540f.this.mContext, me.appId);
            C30540f c30540f = C30540f.this;
            if (packageInfo == null) {
                str = null;
            } else {
                str = packageInfo.versionName;
            }
            if (packageInfo == null) {
                i2 = 0;
            } else {
                i2 = packageInfo.versionCode;
            }
            c30540f.mo48953a(B, B2, str, i2, me.appId, jf.field_msgId, jf.field_msgSvrId, jf);
            AppMethodBeat.m2505o(32614);
        }

        /* renamed from: b */
        public final void mo48856b(View view, int i, final C30455b c30455b) {
            AppMethodBeat.m2504i(32615);
            C4990ab.m7417i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
            new C46696j(view.getContext()).mo75009b(view, new C237911(), new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(32613);
                    C9638aw.m17190ZK();
                    C30540f.this.mo41865d(menuItem.getItemId(), C18628c.m29080XO().mo15340jf(c30455b.cvx));
                    AppMethodBeat.m2505o(32613);
                }
            });
            AppMethodBeat.m2505o(32615);
        }
    }

    public C30540f(Context context) {
        super(context);
    }

    public final int getType() {
        return 3;
    }

    public final void dFH() {
        AppMethodBeat.m2504i(32618);
        this.yYY.dFL();
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C156951());
        AppMethodBeat.m2505o(32618);
    }

    public final String aoy() {
        AppMethodBeat.m2504i(32619);
        String string = this.mContext.getString(C25738R.string.f8800fd);
        AppMethodBeat.m2505o(32619);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.m2504i(32620);
        String string = this.mContext.getString(C25738R.string.f8800fd);
        AppMethodBeat.m2505o(32620);
        return string;
    }

    public final C30451e dFI() {
        AppMethodBeat.m2504i(32621);
        C305422 c305422 = new C305422();
        AppMethodBeat.m2505o(32621);
        return c305422;
    }

    /* renamed from: v */
    public final C41531v mo39525v(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(32622);
        C30541b c30541b = new C30541b(LayoutInflater.from(viewGroup.getContext()).inflate(2130970983, viewGroup, false));
        AppMethodBeat.m2505o(32622);
        return c30541b;
    }

    /* renamed from: a */
    public final void mo39523a(C30453a c30453a, int i) {
        AppMethodBeat.m2504i(32623);
        C30541b c30541b = (C30541b) c30453a;
        C23793a c23793a = (C23793a) mo39522Oy(i);
        c30541b.enf.setText(C34171j.m56019g(this.mContext, c23793a.timestamp));
        Bitmap a = C32291o.ahl().mo73087a(c23793a.imagePath, C1338a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = C46494g.m87732b(c23793a.appId, 1, C1338a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                c30541b.iqT.setImageResource(C1318a.app_attach_file_icon_webpage);
                c30541b.moL.setText(C5046bo.m7532bc(c23793a.source, ""));
                C30453a.m48568c(c30541b.moL, this.yYZ.yNK);
                AppMethodBeat.m2505o(32623);
            }
        }
        c30541b.iqT.setImageBitmap(a);
        c30541b.moL.setText(C5046bo.m7532bc(c23793a.source, ""));
        C30453a.m48568c(c30541b.moL, this.yYZ.yNK);
        AppMethodBeat.m2505o(32623);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo48953a(String str, String str2, String str3, int i, String str4, long j, long j2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(32624);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            C4990ab.m7412e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
            AppMethodBeat.m2505o(32624);
            return;
        }
        if (C5023at.isMobile(this.mContext) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", true);
        intent.putExtra("geta8key_username", this.emo);
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        String b = C24961b.m39082b(c7620bi, C1855t.m3896kH(this.emo));
        intent.putExtra("pre_username", b);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (c7620bi != null) {
            intent.putExtra("preUsername", b);
        }
        intent.putExtra("preChatName", this.emo);
        intent.putExtra("preChatTYPE", C32798u.m53583ad(b, this.emo));
        intent.putExtra("preMsgIndex", 0);
        C25985d.m41467b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(32624);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(32625);
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
            AppMethodBeat.m2505o(32625);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.m2505o(32625);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", e, "", new Object[0]);
                AppMethodBeat.m2505o(32625);
            }
        }
        return packageInfo;
    }
}
