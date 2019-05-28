package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C36692b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.p177mm.p612ui.base.sortview.BaseSortView;
import com.tencent.p177mm.p612ui.base.sortview.C36085c.C15543a;
import com.tencent.p177mm.p612ui.base.sortview.C36087d;
import com.tencent.p177mm.p612ui.widget.C16002f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.profile.p1287b.C28682d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C30201lk;
import com.tencent.p177mm.protocal.protobuf.bbo;
import com.tencent.p177mm.protocal.protobuf.cfr;
import com.tencent.p177mm.protocal.protobuf.cfs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView */
public class EnterpriseBizContactListView extends BaseSortView {
    private ListView gGW;
    private String jLN;
    private boolean jLT;
    private int jLU = -1;
    private C20033b jLV;
    private C20034a jLW;
    private int jLX = 0;
    private int jLY = 0;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$c */
    public static class C2691c {
        public View contentView;
        ImageView ejo;
        TextView ejp;
        String iconUrl;
        public TextView jKK;
        ImageView jMg;
        View jMh;
        String username;
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$2 */
    class C111932 implements OnItemLongClickListener {
        C111932() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(13956);
            if (EnterpriseBizContactListView.this.jLW == null) {
                EnterpriseBizContactListView.this.jLW = new C20034a(EnterpriseBizContactListView.this);
            }
            C20034a a = EnterpriseBizContactListView.this.jLW;
            int b = EnterpriseBizContactListView.this.jLX;
            int c = EnterpriseBizContactListView.this.jLY;
            if (a.jMb == null) {
                EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) a.jMc.get();
                if (enterpriseBizContactListView == null) {
                    AppMethodBeat.m2505o(13956);
                    return false;
                }
                a.jMb = new C16002f(enterpriseBizContactListView.getContext());
            }
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof C2691c)) {
                AppMethodBeat.m2505o(13956);
                return false;
            }
            a.jMa = ((C2691c) tag).username;
            if (C5046bo.isNullOrNil(a.jMa) || C17903f.m28103kq(a.jMa)) {
                AppMethodBeat.m2505o(13956);
                return false;
            }
            a.jMb.zRY = view;
            a.jMb.mo39885a(adapterView, i, j, new C200351(i), new C200362(), b, c);
            AppMethodBeat.m2505o(13956);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$d */
    class C20030d implements Comparator<C36087d> {
        private C20030d() {
        }

        /* synthetic */ C20030d(EnterpriseBizContactListView enterpriseBizContactListView, byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            int i;
            AppMethodBeat.m2504i(13965);
            C36087d c36087d = (C36087d) obj;
            C36087d c36087d2 = (C36087d) obj2;
            String str = c36087d.yDG;
            String str2 = c36087d2.yDG;
            if (str == null || str2 == null) {
                i = 0;
            } else {
                i = str.compareToIgnoreCase(str2);
            }
            if (i != 0) {
                if (str.equalsIgnoreCase("#")) {
                    i = 1;
                }
                if (str2.equalsIgnoreCase("#")) {
                    i = -1;
                }
                AppMethodBeat.m2505o(13965);
                return i;
            }
            int i2;
            C30201lk c30201lk = (C30201lk) c36087d.data;
            C30201lk c30201lk2 = (C30201lk) c36087d2.data;
            if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                Object obj3;
                int Ny = c30201lk.ehM.mo16696Ny();
                int Ny2 = c30201lk2.ehM.mo16696Ny();
                if ((Ny < 97 || Ny > 122) && (Ny < 65 || Ny > 90)) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                Object obj4;
                if ((Ny2 < 97 || Ny2 > 122) && (Ny2 < 65 || Ny2 > 90)) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                if (obj3 != null && obj4 == null) {
                    AppMethodBeat.m2505o(13965);
                    return 1;
                } else if (obj3 == null && obj4 != null) {
                    AppMethodBeat.m2505o(13965);
                    return -1;
                }
            }
            if (c30201lk.ehM == null || c30201lk.ehM.mo14677Hu() == null || c30201lk.ehM.mo14677Hu().length() <= 0 || c30201lk2.ehM == null || c30201lk2.ehM.mo14677Hu() == null || c30201lk2.ehM.mo14677Hu().length() <= 0) {
                i2 = 0;
            } else {
                i2 = c30201lk.ehM.mo14677Hu().compareToIgnoreCase(c30201lk2.ehM.mo14677Hu());
            }
            if (i2 != 0) {
                AppMethodBeat.m2505o(13965);
                return i2;
            }
            if (c30201lk.ehM == null || c30201lk.ehM.field_nickname == null || c30201lk.ehM.field_nickname.length() <= 0 || c30201lk2.ehM == null || c30201lk2.ehM.field_nickname == null || c30201lk2.ehM.field_nickname.length() <= 0) {
                i2 = 0;
            } else {
                i2 = c30201lk.ehM.field_nickname.compareToIgnoreCase(c30201lk2.ehM.field_nickname);
            }
            if (i2 != 0) {
                AppMethodBeat.m2505o(13965);
                return i2;
            }
            if (c30201lk.ehM == null || c30201lk.ehM.field_username == null || c30201lk.ehM.field_username.length() <= 0 || c30201lk2.ehM == null || c30201lk2.ehM.field_username == null || c30201lk2.ehM.field_username.length() <= 0) {
                i = 0;
            } else {
                i = c30201lk.ehM.field_username.compareToIgnoreCase(c30201lk2.ehM.field_username);
            }
            if (i != 0) {
                AppMethodBeat.m2505o(13965);
                return i;
            }
            AppMethodBeat.m2505o(13965);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$1 */
    class C200311 implements OnItemClickListener {
        C200311() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(13955);
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof C2691c)) {
                AppMethodBeat.m2505o(13955);
                return;
            }
            C2691c c2691c = (C2691c) tag;
            if (C5046bo.isNullOrNil(c2691c.username)) {
                AppMethodBeat.m2505o(13955);
                return;
            }
            boolean rd = C17903f.m28110rd(c2691c.username);
            boolean kq = C17903f.m28103kq(c2691c.username);
            C16527d qX = C17903f.m28104qX(c2691c.username);
            String adT = qX == null ? null : qX.adT();
            if (adT == null) {
                adT = "";
            }
            Intent intent;
            if (rd) {
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", adT);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", c2691c.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                C25985d.m41467b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                EnterpriseBizContactListView.m30975a(EnterpriseBizContactListView.this, qX, 2);
                AppMethodBeat.m2505o(13955);
            } else if (kq) {
                intent = new Intent();
                intent.putExtra("Contact_User", c2691c.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 3);
                C25985d.m41473f(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", intent);
                AppMethodBeat.m2505o(13955);
            } else {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("finish_direct", true);
                intent.putExtra("Chat_User", c2691c.username);
                intent.putExtra("chat_from_scene", 2);
                Context context = EnterpriseBizContactListView.this.getContext();
                C4990ab.m7416i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                C33720b.gkE.mo38915d(intent, context);
                EnterpriseBizContactListView.m30975a(EnterpriseBizContactListView.this, qX, 1);
                AppMethodBeat.m2505o(13955);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$3 */
    class C200323 implements C15543a {
        C200323() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0182  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x01ae  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00fc  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0118  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final View mo22902a(C36087d c36087d, View view, int i, boolean z, boolean z2) {
            C2691c c2691c;
            AppMethodBeat.m2504i(13957);
            long yz = C5046bo.m7588yz();
            Context context = EnterpriseBizContactListView.this.getContext();
            if (view == null) {
                view = LayoutInflater.from(context).inflate(2130969395, null);
                c2691c = new C2691c();
                c2691c.jKK = (TextView) view.findViewById(2131821694);
                c2691c.contentView = view.findViewById(2131821695);
                c2691c.ejo = (ImageView) view.findViewById(2131821898);
                c2691c.jMg = (ImageView) view.findViewById(2131821901);
                c2691c.ejp = (TextView) view.findViewById(2131821900);
                c2691c.jMh = view.findViewById(2131821897);
                view.setTag(c2691c);
            } else {
                c2691c = (C2691c) view.getTag();
            }
            C30201lk c30201lk = (C30201lk) c36087d.data;
            if (c30201lk == null) {
                C4990ab.m7412e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
                AppMethodBeat.m2505o(13957);
            } else {
                Object obj = null;
                if (c30201lk.pkW.adR()) {
                    obj = 1;
                }
                if (EnterpriseBizContactListView.this.yDy && z) {
                    if (c36087d.yDG.equals("!2")) {
                        c2691c.jKK.setText(EnterpriseBizContactListView.this.getContext().getString(C25738R.string.be1));
                        c2691c.jKK.setVisibility(0);
                    } else if (!c36087d.yDG.equals("!1")) {
                        c2691c.jKK.setText(c36087d.yDG);
                        c2691c.jKK.setVisibility(0);
                    }
                    if (obj == null) {
                        c2691c.username = c30201lk.userName;
                        c2691c.ejo.setImageResource(C1318a.enterprise_chat_entry_avatar);
                        EnterpriseBizContactListView.m30974a(c2691c.ejp, context, EnterpriseBizContactListView.this.getResources().getString(C25738R.string.bdi), (int) c2691c.ejp.getTextSize());
                    } else {
                        c2691c.username = c30201lk.userName;
                        c2691c.iconUrl = c30201lk.pkW.field_brandIconURL;
                        c2691c.ejo.setTag(c30201lk.userName);
                        C40460b.m69434b(c2691c.ejo, c2691c.username);
                        EnterpriseBizContactListView.m30974a(c2691c.ejp, context, c30201lk.ehM.mo16707Oj(), (int) c2691c.ejp.getTextSize());
                    }
                    C4990ab.m7419v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", Integer.valueOf(c30201lk.pkW.field_status));
                    c2691c.jMg.setVisibility(c30201lk.pkW.field_status != 1 ? 0 : 8);
                    if (EnterpriseBizContactListView.this.getMode() == 0 || !z2) {
                        c2691c.jMh.setBackgroundResource(C25738R.drawable.a_q);
                    } else {
                        c2691c.jMh.setBackgroundResource(C25738R.drawable.f6625k7);
                    }
                    if (EnterpriseBizContactListView.this.yDz) {
                        c2691c.contentView.setPadding(c2691c.contentView.getPaddingLeft(), c2691c.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(C25738R.dimen.f9979m4), c2691c.contentView.getPaddingBottom());
                    } else {
                        c2691c.contentView.setPadding(c2691c.contentView.getPaddingLeft(), c2691c.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(C25738R.dimen.f9721dm), c2691c.contentView.getPaddingBottom());
                    }
                    C4990ab.m7419v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", Long.valueOf(C5046bo.m7525az(yz)));
                    AppMethodBeat.m2505o(13957);
                }
                c2691c.jKK.setVisibility(8);
                if (obj == null) {
                }
                C4990ab.m7419v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", Integer.valueOf(c30201lk.pkW.field_status));
                if (c30201lk.pkW.field_status != 1) {
                }
                c2691c.jMg.setVisibility(c30201lk.pkW.field_status != 1 ? 0 : 8);
                if (EnterpriseBizContactListView.this.getMode() == 0) {
                }
                c2691c.jMh.setBackgroundResource(C25738R.drawable.a_q);
                if (EnterpriseBizContactListView.this.yDz) {
                }
                C4990ab.m7419v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", Long.valueOf(C5046bo.m7525az(yz)));
                AppMethodBeat.m2505o(13957);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$b */
    public interface C20033b {
        boolean aWe();
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a */
    static class C20034a implements C1202f {
        public String jMa;
        C16002f jMb;
        WeakReference<EnterpriseBizContactListView> jMc;
        C44275p tipDialog;

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a$3 */
        class C111943 implements OnClickListener {
            final /* synthetic */ String ewn;
            final /* synthetic */ Context val$context;

            C111943(String str, Context context) {
                this.ewn = str;
                this.val$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13961);
                final C1207m c28682d = new C28682d(this.ewn, true);
                C1720g.m3540Rg().mo14539a(1394, C20034a.this);
                C1720g.m3540Rg().mo14541a(c28682d, 0);
                C20034a c20034a = C20034a.this;
                Context context = this.val$context;
                this.val$context.getString(C25738R.string.f9238tz);
                c20034a.tipDialog = C30379h.m48458b(context, this.val$context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(13960);
                        C1720g.m3540Rg().mo14547c(c28682d);
                        C1720g.m3540Rg().mo14546b(1394, C20034a.this);
                        AppMethodBeat.m2505o(13960);
                    }
                });
                AppMethodBeat.m2505o(13961);
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a$1 */
        class C200351 implements OnCreateContextMenuListener {
            /* renamed from: sN */
            final /* synthetic */ int f4369sN;

            C200351(int i) {
                this.f4369sN = i;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(13958);
                contextMenu.add(this.f4369sN, 1, 0, C25738R.string.bdu);
                AppMethodBeat.m2505o(13958);
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a$2 */
        class C200362 implements C5279d {
            C200362() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(13959);
                if (C5046bo.isNullOrNil(C20034a.this.jMa)) {
                    AppMethodBeat.m2505o(13959);
                    return;
                }
                if (menuItem.getItemId() == 1) {
                    C20034a c20034a = C20034a.this;
                    String str = C20034a.this.jMa;
                    EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) c20034a.jMc.get();
                    if (enterpriseBizContactListView != null) {
                        Context context = enterpriseBizContactListView.getContext();
                        C30379h.m48466d(context, context.getString(C25738R.string.bdm), "", context.getString(C25738R.string.bdl), context.getString(C25738R.string.f9076or), new C111943(str, context), null);
                    }
                }
                AppMethodBeat.m2505o(13959);
            }
        }

        public C20034a(EnterpriseBizContactListView enterpriseBizContactListView) {
            AppMethodBeat.m2504i(13962);
            this.jMc = new WeakReference(enterpriseBizContactListView);
            AppMethodBeat.m2505o(13962);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.m2504i(13963);
            C1720g.m3540Rg().mo14546b(1394, (C1202f) this);
            super.finalize();
            AppMethodBeat.m2505o(13963);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(13964);
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0) {
                if (c1207m.getType() == 1394) {
                    cfr caz = ((C28682d) c1207m).caz();
                    cfs cay = ((C28682d) c1207m).cay();
                    if (cay == null || cay.vNh == null || cay.vNh.ret != 0) {
                        if (cay == null || cay.vNh == null) {
                            C4990ab.m7421w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(c1207m.getType()));
                            AppMethodBeat.m2505o(13964);
                            return;
                        }
                        C4990ab.m7421w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(c1207m.getType()), Integer.valueOf(cay.vNh.ret));
                        AppMethodBeat.m2505o(13964);
                        return;
                    } else if (caz.xeS) {
                        C16527d qX = C17903f.m28104qX(caz.vNb);
                        qX.field_brandFlag |= 1;
                        bbo bbo = new bbo();
                        bbo.gvb = qX.field_brandFlag;
                        bbo.jBB = caz.vNb;
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(47, bbo));
                        C41747z.aeR().mo10103c(qX, new String[0]);
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(qX.field_username);
                        if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apl(qX.field_enterpriseFather) <= 0) {
                            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(qX.field_enterpriseFather);
                        } else {
                            ((C8939o) C1720g.m3528K(C8939o.class)).mo20358XQ().aoj(qX.field_enterpriseFather);
                        }
                        EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) this.jMc.get();
                        if (enterpriseBizContactListView == null) {
                            AppMethodBeat.m2505o(13964);
                            return;
                        }
                        enterpriseBizContactListView.refresh();
                    } else {
                        AppMethodBeat.m2505o(13964);
                        return;
                    }
                }
                AppMethodBeat.m2505o(13964);
                return;
            }
            AppMethodBeat.m2505o(13964);
        }
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setFatherBizName(String str) {
        this.jLN = str;
    }

    public void setExcludeBizChat(boolean z) {
        this.jLT = z;
    }

    public final void refresh() {
        AppMethodBeat.m2504i(13966);
        mo70141dJ(getSortEntityList());
        super.refresh();
        AppMethodBeat.m2505o(13966);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(13967);
        if (motionEvent.getAction() == 0) {
            this.jLX = (int) motionEvent.getRawX();
            this.jLY = (int) motionEvent.getRawY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(13967);
        return dispatchTouchEvent;
    }

    public final void aWg() {
        AppMethodBeat.m2504i(13968);
        setOnItemClickListener(new C200311());
        if (getMode() == 0) {
            setOnItemLongClickListener(new C111932());
        }
        AppMethodBeat.m2505o(13968);
    }

    public int getContactCount() {
        return this.jLU;
    }

    private List<C36087d> getSortEntityList() {
        AppMethodBeat.m2504i(13969);
        ArrayList arrayList = new ArrayList();
        C41747z.aeR();
        Cursor F = C25764e.m40941F(this.jLN, this.jLT);
        while (F.moveToNext()) {
            C30201lk c30201lk = new C30201lk();
            if (F != null) {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(F);
                C16527d c16527d = new C16527d();
                c16527d.mo8995d(F);
                c30201lk.userName = c7616ad.field_username;
                c30201lk.ehM = c7616ad;
                c30201lk.pkW = c16527d;
            }
            if (c30201lk.ehM != null) {
                C36087d c36087d = new C36087d();
                c36087d.data = c30201lk;
                if (c30201lk.pkW.adR()) {
                    c36087d.yDG = "!1";
                } else if (c30201lk.ehM.mo16702Oe()) {
                    c36087d.yDG = "!2";
                } else {
                    int Ny = c30201lk.ehM.mo16696Ny();
                    if (Ny >= 97 && Ny <= 122) {
                        Ny -= 32;
                    }
                    if (Ny < 65 || Ny > 90) {
                        c36087d.yDG = "#";
                    } else {
                        c36087d.yDG = ((char) Ny);
                    }
                }
                arrayList.add(c36087d);
            }
        }
        F.close();
        this.jLU = arrayList.size();
        Collections.sort(arrayList, new C20030d(this, (byte) 0));
        AppMethodBeat.m2505o(13969);
        return arrayList;
    }

    public static void release() {
        AppMethodBeat.m2504i(13970);
        C41747z.afb().aeL();
        AppMethodBeat.m2505o(13970);
    }

    /* renamed from: a */
    public final boolean mo22884a(String str, C36087d c36087d) {
        AppMethodBeat.m2504i(13971);
        if (!(C5046bo.isNullOrNil(str) || c36087d == null)) {
            C30201lk c30201lk = (C30201lk) c36087d.data;
            if (c30201lk == null) {
                AppMethodBeat.m2505o(13971);
                return false;
            }
            String Oj = c30201lk.ehM.mo16707Oj();
            String Ht = c30201lk.ehM.mo14676Ht();
            String Hu = c30201lk.ehM.mo14677Hu();
            String toUpperCase = str.toUpperCase();
            if (!(C5046bo.isNullOrNil(Oj) || Oj.toUpperCase().indexOf(toUpperCase) == -1) || (!(C5046bo.isNullOrNil(Ht) || Ht.toUpperCase().indexOf(toUpperCase) == -1) || (!C5046bo.isNullOrNil(Hu) && Hu.toUpperCase().startsWith(toUpperCase)))) {
                AppMethodBeat.m2505o(13971);
                return true;
            }
        }
        AppMethodBeat.m2505o(13971);
        return false;
    }

    public final View inflate() {
        AppMethodBeat.m2504i(13972);
        View inflate = View.inflate(getContext(), 2130969398, this);
        AppMethodBeat.m2505o(13972);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.m2504i(13973);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(2131821699);
        AppMethodBeat.m2505o(13973);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.m2504i(13974);
        this.gGW = (ListView) findViewById(2131821698);
        ListView listView = this.gGW;
        AppMethodBeat.m2505o(13974);
        return listView;
    }

    public View getNoResultView() {
        AppMethodBeat.m2504i(13975);
        TextView textView = (TextView) findViewById(2131821905);
        textView.setText(C25738R.string.bdv);
        AppMethodBeat.m2505o(13975);
        return textView;
    }

    public C15543a getItemViewCreator() {
        AppMethodBeat.m2504i(13976);
        C200323 c200323 = new C200323();
        AppMethodBeat.m2505o(13976);
        return c200323;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(13977);
        if (this.jLV != null) {
            this.jLV.aWe();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(13977);
            return true;
        }
        AppMethodBeat.m2505o(13977);
        return false;
    }

    public void setOnTouchListener(C20033b c20033b) {
        this.jLV = c20033b;
    }

    /* renamed from: a */
    static /* synthetic */ void m30975a(EnterpriseBizContactListView enterpriseBizContactListView, C16527d c16527d, int i) {
        AppMethodBeat.m2504i(13978);
        C36692b qC = C41747z.afa().mo20347qC(enterpriseBizContactListView.jLN);
        long j = qC != null ? qC.field_wwCorpId : 0;
        long j2 = qC != null ? qC.field_wwUserVid : 0;
        long adU = c16527d.adU();
        C7060h.pYm.mo8381e(14507, Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i));
        C4990ab.m7411d("MicroMsg.BrandService.EnterpriseBizContactListView", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i));
        AppMethodBeat.m2505o(13978);
    }

    /* renamed from: a */
    static /* synthetic */ void m30974a(TextView textView, Context context, String str, int i) {
        AppMethodBeat.m2504i(13979);
        if (textView == null) {
            AppMethodBeat.m2505o(13979);
            return;
        }
        if (!C5046bo.isNullOrNil(str)) {
            try {
                textView.setText(new SpannableString(C44089j.m79294b(context, (CharSequence) str, i)));
                AppMethodBeat.m2505o(13979);
                return;
            } catch (Exception e) {
                textView.setText("");
            }
        }
        AppMethodBeat.m2505o(13979);
    }
}
