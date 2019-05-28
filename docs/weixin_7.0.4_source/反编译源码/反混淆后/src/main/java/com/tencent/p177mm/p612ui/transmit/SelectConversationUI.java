package com.tencent.p177mm.p612ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.choosemsgfile.compat.C9236a;
import com.tencent.p177mm.choosemsgfile.compat.C9236a.C9237a;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C18643z;
import com.tencent.p177mm.model.C26424ce;
import com.tencent.p177mm.model.C26432y;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.C32809i.C32808b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p181af.C8909j.C8913a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C32599lz;
import com.tencent.p177mm.p230g.p231a.C37720gf;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5224ag;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.chatting.C44312l;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.C23923q;
import com.tencent.p177mm.p612ui.contact.C36252n;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.C41349x;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.SelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C15816g;
import com.tencent.p177mm.p612ui.contact.p625a.C46672b;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.transmit.C44389e.C30773a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5649b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.base.stub.C38669d;
import com.tencent.p177mm.plugin.base.stub.C38669d.C27497a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35898l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@C5271a(23)
@C18524i
/* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI */
public class SelectConversationUI extends MMBaseSelectContactUI {
    private static final int zJK = C15830s.m24190C(1, 2);
    private String cJh;
    private C7620bi cKd;
    private long cvv;
    private long cvx;
    private List<String> elZ;
    private int fromScene = 0;
    private int gnI;
    private String imagePath = null;
    private String kcC = null;
    private String lgZ;
    private int[] mqq = new int[]{2131822651, 2131822652, 2131822653, 2131822654, 2131822655};
    private int msgType;
    private TextView yFh;
    private int zJL;
    private boolean zJM = false;
    private boolean zJN = false;
    private boolean zJO = false;
    private boolean zJP = false;
    private boolean zJQ = false;
    private boolean zJR = false;
    private boolean zJS = false;
    private int zJT;
    private boolean zJU = false;
    private String zJV;
    private String zJW;
    private Boolean zJX = Boolean.FALSE;
    private boolean zJY = false;
    private boolean zJZ = false;
    private List<String> zKa = null;
    private ReportArgs zKb;
    private String zKc = null;
    private String zKd;
    private String zKe;
    private int zKf;
    private String zKg;
    private OnMenuItemClickListener zKh = new C2497421();
    private OnMenuItemClickListener zKi = new C2498822();
    private int zeC = -1;
    private boolean znm;
    private boolean zoG = false;

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$1 */
    class C56111 implements C27497a {
        C56111() {
        }

        /* renamed from: ft */
        public final void mo11382ft(boolean z) {
            AppMethodBeat.m2504i(35124);
            boolean isFinishing = SelectConversationUI.this.isFinishing();
            C4990ab.m7416i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
            if (!(z || isFinishing)) {
                SelectConversationUI.this.finish();
            }
            AppMethodBeat.m2505o(35124);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$7 */
    class C159557 implements C5649b {
        C159557() {
        }

        public final void bwF() {
            AppMethodBeat.m2504i(35131);
            Intent intent = new Intent(SelectConversationUI.this.mController.ylL, RetransmitPreviewUI.class);
            intent.putExtra("Retr_Msg_content", SelectConversationUI.this.cJh);
            SelectConversationUI.this.startActivity(intent);
            C5274b.m8053hL(SelectConversationUI.this.mController.ylL);
            AppMethodBeat.m2505o(35131);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$27 */
    class C2406427 implements C9237a {
        C2406427() {
        }

        /* renamed from: a */
        public final void mo20659a(int i, String str, ArrayList<MsgFile> arrayList) {
            AppMethodBeat.m2504i(35149);
            C4990ab.m7417i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", Integer.valueOf(i), arrayList);
            Intent intent;
            switch (i) {
                case -1:
                    intent = new Intent();
                    intent.putParcelableArrayListExtra("FILEPATHS", arrayList);
                    SelectConversationUI.this.setResult(-1, intent);
                    SelectConversationUI.this.finish();
                    AppMethodBeat.m2505o(35149);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("ERRMSG", str);
                    SelectConversationUI.this.setResult(1, intent);
                    SelectConversationUI.this.finish();
                    break;
            }
            AppMethodBeat.m2505o(35149);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$16 */
    class C2497316 implements C5649b {
        C2497316() {
        }

        public final void bwF() {
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$21 */
    class C2497421 implements OnMenuItemClickListener {
        C2497421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35144);
            SelectConversationUI.this.zJZ = !SelectConversationUI.this.zJZ;
            SelectConversationUI.this.dHV().mo57126qE(SelectConversationUI.this.zJZ);
            SelectConversationUI.this.zna.mo57126qE(SelectConversationUI.this.zJZ);
            SelectConversationUI.m39142k(SelectConversationUI.this);
            SelectConversationUI.this.yFh.setText(!SelectConversationUI.this.zJZ ? SelectConversationUI.this.zJL : C25738R.string.e23);
            AppMethodBeat.m2505o(35144);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$8 */
    class C249758 implements C5649b {
        C249758() {
        }

        public final void bwF() {
            AppMethodBeat.m2504i(35132);
            Intent intent = new Intent(SelectConversationUI.this.mController.ylL, ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", SelectConversationUI.this.cvx);
            intent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.this.cKd.field_msgSvrId);
            intent.putExtra("img_gallery_talker", SelectConversationUI.this.cKd.field_talker);
            intent.putExtra("img_gallery_chatroom_name", SelectConversationUI.this.cKd.field_talker);
            intent.putExtra("img_preview_only", true);
            SelectConversationUI.this.startActivity(intent);
            C5274b.m8053hL(SelectConversationUI.this.mController.ylL);
            AppMethodBeat.m2505o(35132);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$18 */
    class C2497718 implements C5649b {
        C2497718() {
        }

        public final void bwF() {
            AppMethodBeat.m2504i(35141);
            Intent intent = new Intent();
            intent.setClassName(SelectConversationUI.this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", SelectConversationUI.this.cvx);
            intent.putExtra("app_show_share", false);
            SelectConversationUI.this.startActivity(intent);
            AppMethodBeat.m2505o(35141);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$11 */
    class C2498411 implements C5649b {
        C2498411() {
        }

        public final void bwF() {
            AppMethodBeat.m2504i(35135);
            Intent intent = new Intent();
            intent.setClassName(SelectConversationUI.this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", SelectConversationUI.this.cvx);
            intent.putExtra("app_show_share", false);
            SelectConversationUI.this.startActivity(intent);
            AppMethodBeat.m2505o(35135);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$17 */
    class C2498517 implements C5649b {
        C2498517() {
        }

        public final void bwF() {
            AppMethodBeat.m2504i(35140);
            C18348nt hS = C46660k.m88363hS(SelectConversationUI.this.mController.ylL);
            C8910b me = C8910b.m16064me(C5046bo.anj(C43436n.m77553a(hS.cJZ.cKh.title, hS.cJZ.cKh.desc, hS.cJZ.cJy.cvA.cvC, hS.cJY.cKf)));
            if (me == null) {
                AppMethodBeat.m2505o(35140);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("message_id", SelectConversationUI.this.cvx);
            intent.putExtra("record_xml", me.fgU);
            intent.putExtra("record_show_share", false);
            C25985d.m41467b(SelectConversationUI.this.mController.ylL, "record", ".ui.RecordMsgDetailUI", intent);
            AppMethodBeat.m2505o(35140);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$22 */
    class C2498822 implements OnMenuItemClickListener {
        C2498822() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35145);
            if (SelectConversationUI.m39145n(SelectConversationUI.this)) {
                AppMethodBeat.m2505o(35145);
                return false;
            }
            for (String asq : SelectConversationUI.this.zKa) {
                if (SelectConversationUI.this.asq(asq)) {
                    AppMethodBeat.m2505o(35145);
                    return false;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_User", C42252ah.m74611c(SelectConversationUI.this.zKa, ","));
            Intent intent2 = (Intent) SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
            if (intent2 != null) {
                SelectConversationUI.m39119a(SelectConversationUI.this, intent, intent2);
            } else if (SelectConversationUI.this.zJQ) {
                SelectConversationUI.m39117a(SelectConversationUI.this, -1, intent);
                SelectConversationUI.this.finish();
            } else {
                SelectConversationUI.m39118a(SelectConversationUI.this, intent);
            }
            AppMethodBeat.m2505o(35145);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$23 */
    class C2498923 implements OnClickListener {
        C2498923() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35146);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(35146);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$24 */
    class C2499024 implements OnClickListener {
        C2499024() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$12 */
    class C2499212 implements View.OnClickListener {
        C2499212() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(35136);
            if (SelectConversationUI.this.zJZ) {
                SelectConversationUI.m39126b(SelectConversationUI.this);
                AppMethodBeat.m2505o(35136);
                return;
            }
            String stringExtra = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
            if (SelectConversationUI.this.zoG && C5046bo.isNullOrNil(stringExtra)) {
                SelectConversationUI.m39131d(SelectConversationUI.this);
                AppMethodBeat.m2505o(35136);
                return;
            }
            SelectConversationUI.m39133e(SelectConversationUI.this);
            AppMethodBeat.m2505o(35136);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SelectConversationUI$25 */
    class C2499325 implements OnClickListener {
        C2499325() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35147);
            SelectConversationUI.m39134f(SelectConversationUI.this);
            SelectConversationUI.this.aqX();
            AppMethodBeat.m2505o(35147);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SelectConversationUI() {
        AppMethodBeat.m2504i(35153);
        AppMethodBeat.m2505o(35153);
    }

    /* renamed from: d */
    static /* synthetic */ void m39130d(Intent intent, String str, String str2) {
        AppMethodBeat.m2504i(35200);
        SelectConversationUI.m39128c(intent, str, str2);
        AppMethodBeat.m2505o(35200);
    }

    /* renamed from: d */
    static /* synthetic */ void m39131d(SelectConversationUI selectConversationUI) {
        AppMethodBeat.m2504i(35197);
        selectConversationUI.dKn();
        AppMethodBeat.m2505o(35197);
    }

    /* renamed from: e */
    static /* synthetic */ void m39132e(Intent intent, String str, String str2) {
        AppMethodBeat.m2504i(35201);
        SelectConversationUI.m39124b(intent, str, str2);
        AppMethodBeat.m2505o(35201);
    }

    /* renamed from: e */
    static /* synthetic */ void m39133e(SelectConversationUI selectConversationUI) {
        AppMethodBeat.m2504i(35198);
        selectConversationUI.dKo();
        AppMethodBeat.m2505o(35198);
    }

    /* renamed from: f */
    static /* synthetic */ void m39134f(SelectConversationUI selectConversationUI) {
        AppMethodBeat.m2504i(35199);
        super.bMQ();
        AppMethodBeat.m2505o(35199);
    }

    /* renamed from: k */
    static /* synthetic */ void m39142k(SelectConversationUI selectConversationUI) {
        AppMethodBeat.m2504i(35203);
        selectConversationUI.m39111Kt();
        AppMethodBeat.m2505o(35203);
    }

    /* renamed from: n */
    static /* synthetic */ boolean m39145n(SelectConversationUI selectConversationUI) {
        AppMethodBeat.m2504i(35204);
        boolean qS = selectConversationUI.m39148qS(false);
        AppMethodBeat.m2505o(35204);
        return qS;
    }

    static {
        AppMethodBeat.m2504i(35207);
        AppMethodBeat.m2505o(35207);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35154);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Select_App_Id");
        String stringExtra2 = getIntent().getStringExtra("Select_Open_Id");
        C4990ab.m7416i("MicroMsg.SelectConversationUI", "onCreate, appId = " + stringExtra + ", openId = " + stringExtra2);
        if (!(C42252ah.isNullOrNil(stringExtra) || C42252ah.isNullOrNil(stringExtra2))) {
            new C38669d(this, stringExtra, stringExtra2, new C56111()).aVi();
        }
        C30036f.m47545n(this);
        AppMethodBeat.m2505o(35154);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(35155);
        super.mo7850Kh();
        this.zJM = getIntent().getBooleanExtra("select_is_ret", false);
        this.fromScene = getIntent().getIntExtra("scene_from", 0);
        C4990ab.m7417i("MicroMsg.SelectConversationUI", "from scene:%d", Integer.valueOf(this.fromScene));
        if (this.fromScene == 1) {
            this.zJN = true;
        } else if (this.fromScene == 2 || this.fromScene == 10) {
            this.zJO = true;
        } else if (this.fromScene == 3) {
            this.zJP = true;
        } else if (this.fromScene == 6) {
            this.zJQ = true;
        } else if (this.fromScene == 7) {
            this.zJR = true;
        } else if (this.fromScene == 11) {
            overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8373ce);
        }
        this.zJS = getIntent().getBooleanExtra("send_to_biz", false);
        this.zeC = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.cvv = getIntent().getLongExtra("select_fav_local_id", -1);
        this.zJT = getIntent().getIntExtra("select_fav_select_count", 0);
        this.zJY = getIntent().getBooleanExtra("mutil_select_is_ret", false);
        this.zoG = getIntent().getBooleanExtra("Select_Send_Card", false);
        this.zJU = getIntent().getBooleanExtra("Retr_Big_File", false);
        if (this.zoG) {
            this.zJV = getIntent().getStringExtra("Select_Talker_Name");
        }
        this.gnI = getIntent().getIntExtra("Select_Conv_Type", zJK);
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.cvx = getIntent().getLongExtra("Retr_Msg_Id", -1);
        C9638aw.m17190ZK();
        this.cKd = C18628c.m29080XO().mo15340jf(this.cvx);
        this.imagePath = getIntent().getStringExtra("image_path");
        this.zKc = getIntent().getStringExtra("ad_video_title");
        this.kcC = getIntent().getStringExtra("desc_title");
        this.lgZ = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.cJh = getIntent().getStringExtra("Retr_Msg_content");
        this.zKd = getIntent().getStringExtra("Retr_fav_xml_str");
        if (this.cJh == null && this.cKd != null) {
            this.cJh = this.cKd.field_content;
        }
        this.zKb = (ReportArgs) getIntent().getParcelableExtra("Select_Report_Args");
        this.zKe = getIntent().getStringExtra("KChooseMsgFileType");
        this.zKf = getIntent().getIntExtra("KChooseMsgFileCount", 9);
        this.zKg = getIntent().getStringExtra("KChooseMsgFileExtension");
        HashSet hashSet = new HashSet();
        hashSet.addAll(C15830s.dIf());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!C42252ah.isNullOrNil(stringExtra)) {
            hashSet.addAll(C42252ah.m74626j(stringExtra.split(",")));
        }
        if (C15830s.m24192hr(this.gnI, 2)) {
            HashSet dIg = C15830s.dIg();
            C15830s.m24191h(dIg);
            hashSet.addAll(dIg);
        }
        this.elZ = new ArrayList();
        this.elZ.addAll(hashSet);
        m39135fy(this.elZ);
        if (C15830s.m24192hr(this.gnI, 1)) {
            this.znm = true;
        }
        if (this.zJY) {
            this.zKa = new LinkedList();
            if (this.zJY) {
                mo17379a(1, getString(C25738R.string.f9173rr), this.zKh, C5535b.GREEN);
                m39111Kt();
            }
        }
        AppMethodBeat.m2505o(35155);
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(35156);
        C41349x c41349x = new C41349x(this, this.elZ, this.znm, this.zJZ, this.zJS, this.gnI);
        AppMethodBeat.m2505o(35156);
        return c41349x;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(35157);
        C23923q c23923q = new C23923q(this, this.elZ, this.zJZ, this.scene);
        AppMethodBeat.m2505o(35157);
        return c23923q;
    }

    /* renamed from: a */
    public final void mo7851a(ListView listView, int i) {
        AppMethodBeat.m2504i(35158);
        super.mo7851a(listView, i);
        if (this.fromScene == 11) {
            AppMethodBeat.m2505o(35158);
            return;
        }
        if (this.yFh == null) {
            if (this.zoG) {
                this.zJL = C25738R.string.e23;
            } else if (this.fromScene == 10) {
                this.zJL = C25738R.string.daq;
            } else {
                this.zJL = C25738R.string.e1s;
            }
            C2499212 c2499212 = new C2499212();
            String string = getString(this.zJL);
            View inflate = C5616v.m8409hu(this).inflate(2130969809, null);
            inflate.setOnClickListener(c2499212);
            TextView textView = (TextView) inflate.findViewById(2131822953);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.yFh = textView;
        }
        this.yFh.setVisibility(i);
        AppMethodBeat.m2505o(35158);
    }

    public final void bMQ() {
        AppMethodBeat.m2504i(35159);
        if (this.fromScene == 5) {
            C30379h.m48445a((Context) this, getString(C25738R.string.csw), null, getString(C25738R.string.e31), getString(C25738R.string.abx), true, new C2498923(), new C2499325());
        } else {
            super.bMQ();
            aqX();
        }
        if (this.zKb != null) {
            this.zKb.errCode = 0;
            ReportUtil.m79192a(this, this.zKb, true);
        }
        AppMethodBeat.m2505o(35159);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(35160);
        super.bMQ();
        AppMethodBeat.m2505o(35160);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(35161);
        int headerViewsCount;
        C5445a Pn;
        if (this.zJZ) {
            headerViewsCount = i - getContentLV().getHeaderViewsCount();
            if (headerViewsCount < 0) {
                C4990ab.m7417i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
                dKm();
                AppMethodBeat.m2505o(35161);
                return;
            }
            C36252n dHV = dHV();
            Pn = dHV.getItem(headerViewsCount);
            if (Pn == null) {
                AppMethodBeat.m2505o(35161);
            } else if (Pn.ehM == null) {
                AppMethodBeat.m2505o(35161);
            } else {
                String str = Pn.ehM.field_username;
                C4990ab.m7417i("MicroMsg.SelectConversationUI", "ClickUser=%s", str);
                if (this.zKa.contains(str) || !m39148qS(true)) {
                    dIb();
                    this.opo.ajq(str);
                    if (this.zKa.contains(str)) {
                        this.zKa.remove(str);
                    } else {
                        this.zKa.add(str);
                    }
                    m39111Kt();
                    dHV.notifyDataSetChanged();
                    AppMethodBeat.m2505o(35161);
                    return;
                }
                dIb();
                AppMethodBeat.m2505o(35161);
            }
        } else if (i < getContentLV().getHeaderViewsCount()) {
            C4990ab.m7417i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
            if (this.zoG) {
                dKn();
                AppMethodBeat.m2505o(35161);
                return;
            }
            dKo();
            AppMethodBeat.m2505o(35161);
        } else {
            Pn = (C5445a) getContentLV().getAdapter().getItem(i);
            Intent intent;
            if (Pn == null) {
                AppMethodBeat.m2505o(35161);
            } else if ((Pn instanceof C46672b) && ((C46672b) Pn).bCu == getResources().getString(C25738R.string.f8768ef)) {
                C4990ab.m7416i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
                intent = new Intent();
                intent.putExtra("list_attr", 16384);
                C25985d.m41468b((Context) this, "brandservice", ".ui.BrandServiceIndexUI", intent, 4);
                this.zJO = true;
                AppMethodBeat.m2505o(35161);
            } else if (Pn instanceof C15816g) {
                C15816g c15816g = (C15816g) Pn;
                Intent intent2 = new Intent();
                intent2.putExtra("scene", this.scene);
                ArrayList arrayList = new ArrayList();
                for (Object add : c15816g.mDz.mEa) {
                    arrayList.add(add);
                }
                intent2.putExtra("query_phrase_list", arrayList);
                C25985d.m41466b((Context) this, ".ui.transmit.MMCreateChatroomUI", intent2, 1);
                AppMethodBeat.m2505o(35161);
            } else {
                C7616ad c7616ad = Pn.ehM;
                if (c7616ad == null) {
                    AppMethodBeat.m2505o(35161);
                    return;
                }
                String str2 = c7616ad.field_username;
                C4990ab.m7417i("MicroMsg.SelectConversationUI", "doClickUser=%s", str2);
                if (!asq(str2)) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("Select_Conv_User", str2);
                    intent = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                    if (intent != null) {
                        m39113a(intent3, intent);
                    } else if (this.zJM || this.zoG || this.zJN || this.zJO || this.zJP) {
                        m39149t(intent3, str2);
                    } else if (this.fromScene == 11) {
                        ass(str2);
                    } else {
                        m39141k(-1, intent3);
                        finish();
                    }
                    aqX();
                }
                AppMethodBeat.m2505o(35161);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(35162);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            C4990ab.m7416i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            C4990ab.m7416i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        String stringExtra;
        Intent intent2;
        final String stringExtra2;
        if (i == 1) {
            if (i2 == -1 && intent != null) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                C4990ab.m7416i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
                intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent2 != null) {
                    if (asq(stringExtra)) {
                        AppMethodBeat.m2505o(35162);
                        return;
                    }
                    m39113a(intent, intent2);
                    AppMethodBeat.m2505o(35162);
                    return;
                } else if (this.zJM || this.zoG || this.zJN || this.zJO || this.zJP) {
                    m39149t(intent, stringExtra);
                    AppMethodBeat.m2505o(35162);
                    return;
                } else if (this.fromScene == 11) {
                    ass(stringExtra);
                    AppMethodBeat.m2505o(35162);
                    return;
                } else {
                    m39141k(-1, intent);
                    finish();
                }
            }
            AppMethodBeat.m2505o(35162);
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    finish();
                    if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        intent2 = new Intent(this, TaskRedirectUI.class);
                        intent2.addFlags(268435456);
                        startActivity(intent2);
                        ReportUtil.m79190F(false, 0);
                        AppMethodBeat.m2505o(35162);
                        return;
                    }
                case 0:
                    if (intent != null) {
                        this.zKb = (ReportArgs) intent.getParcelableExtra("Select_Report_Args");
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(35162);
        } else if (i == 3) {
            switch (i2) {
                case -1:
                    if (intent != null) {
                        stringExtra2 = intent.getStringExtra("received_card_name");
                        if (!(C5046bo.isNullOrNil(stringExtra2) || asq(stringExtra2))) {
                            C23273a c23273a = new C23273a(this.mController.ylL);
                            c23273a.mo38972cx(stringExtra2);
                            m39116a(c23273a, this.zJV);
                            c23273a.mo38977h(Boolean.TRUE).mo38965KQ(C25738R.string.f9221tf).mo38966a(new C30111a() {
                                /* renamed from: a */
                                public final void mo6399a(boolean z, String str, int i) {
                                    AppMethodBeat.m2504i(35148);
                                    SelectConversationUI.this.aqX();
                                    if (z) {
                                        Intent intent = new Intent();
                                        if (C1855t.m3896kH(stringExtra2)) {
                                            SelectConversationUI.m39130d(intent, SelectConversationUI.this.zJV, stringExtra2);
                                        } else {
                                            SelectConversationUI.m39132e(intent, SelectConversationUI.this.zJV, stringExtra2);
                                        }
                                        intent.putExtra("custom_send_text", str);
                                        SelectConversationUI.m39117a(SelectConversationUI.this, -1, intent);
                                        SelectConversationUI.this.finish();
                                    }
                                    AppMethodBeat.m2505o(35148);
                                }
                            }).gud.show();
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(35162);
        } else if (i == 4) {
            if (i2 == -1 && intent != null) {
                m39149t(intent, intent.getStringExtra("Select_Contact"));
            }
            AppMethodBeat.m2505o(35162);
        } else if (i == 5) {
            if (i2 == -1 && intent != null) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                for (String stringExtra22 : this.zKa) {
                    this.opo.ajr(stringExtra22);
                }
                if (C42252ah.isNullOrNil(stringExtra)) {
                    this.zKa.clear();
                } else {
                    this.zKa = C42252ah.m74626j(stringExtra.split(","));
                }
                for (String stringExtra222 : this.zKa) {
                    this.opo.mo69767bU(stringExtra222, false);
                }
                m39111Kt();
                dHV().notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(35162);
        } else {
            C4990ab.m7412e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(35162);
        }
    }

    private static boolean asp(String str) {
        AppMethodBeat.m2504i(35163);
        if (C7616ad.aox(str)) {
            AppMethodBeat.m2505o(35163);
            return true;
        } else if (C1855t.m3903mP(str)) {
            AppMethodBeat.m2505o(35163);
            return true;
        } else {
            AppMethodBeat.m2505o(35163);
            return false;
        }
    }

    public final boolean asq(String str) {
        AppMethodBeat.m2504i(35164);
        if (!SelectConversationUI.asp(str)) {
            AppMethodBeat.m2505o(35164);
            return false;
        } else if (C42252ah.isNullOrNil(getIntent().getStringExtra("Select_App_Id")) || !this.zoG) {
            if (this.zoG) {
                C9638aw.m17190ZK();
                if (C7616ad.m13547Mn(C18628c.m29078XM().aoM(this.zJV).field_verifyFlag)) {
                    asr(str);
                    AppMethodBeat.m2505o(35164);
                    return true;
                }
            }
            switch (this.msgType) {
                case 5:
                    AppMethodBeat.m2505o(35164);
                    return false;
                case 8:
                    C9638aw.m17190ZK();
                    String str2 = C18628c.m29080XO().mo15260Rn(this.cJh).svN;
                    C9638aw.m17190ZK();
                    if (C1855t.m3897kv(C18628c.m29078XM().aoM(str2).field_verifyFlag)) {
                        asr(str);
                        AppMethodBeat.m2505o(35164);
                        return true;
                    }
                    AppMethodBeat.m2505o(35164);
                    return false;
                default:
                    AppMethodBeat.m2505o(35164);
                    return false;
            }
        } else {
            AppMethodBeat.m2505o(35164);
            return false;
        }
    }

    private void asr(String str) {
        AppMethodBeat.m2504i(35165);
        try {
            List<String> j = C42252ah.m74626j(str.split(","));
            StringBuffer stringBuffer = new StringBuffer();
            Object obj = null;
            for (String str2 : j) {
                if (!C42252ah.isNullOrNil(str2)) {
                    if (obj != null) {
                        stringBuffer.append(",");
                    }
                    stringBuffer.append(C1854s.m3866mJ(str2));
                    obj = 1;
                }
            }
            C30379h.m48438a((Context) this, getString(C25738R.string.egy, new Object[]{stringBuffer}), "", null);
            AppMethodBeat.m2505o(35165);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(35165);
        }
    }

    private void ass(String str) {
        AppMethodBeat.m2504i(35166);
        C4990ab.m7417i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", str, this.zKe, Integer.valueOf(this.zKf));
        C4990ab.m7417i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", this.zKg);
        ((C9236a) C1720g.m3528K(C9236a.class)).mo20657a(this, str, this.zKe, this.zKf, this.zKg, new C2406427());
        AppMethodBeat.m2505o(35166);
    }

    /* renamed from: b */
    private static void m39124b(Intent intent, String str, String str2) {
        AppMethodBeat.m2504i(35167);
        List linkedList = new LinkedList();
        linkedList.add(str2);
        SelectConversationUI.m39114a(intent, str, linkedList);
        AppMethodBeat.m2505o(35167);
    }

    /* renamed from: a */
    private static void m39114a(Intent intent, String str, List<String> list) {
        AppMethodBeat.m2504i(35168);
        if (list.size() > 0) {
            intent.putExtra("be_send_card_name", str);
            intent.putExtra("received_card_name", C42252ah.m74611c(list, ","));
            intent.putExtra("Is_Chatroom", false);
        }
        AppMethodBeat.m2505o(35168);
    }

    /* renamed from: c */
    private static void m39128c(Intent intent, String str, String str2) {
        AppMethodBeat.m2504i(35169);
        Assert.assertTrue("cardNameToSend is null", str != null);
        intent.putExtra("be_send_card_name", str);
        intent.putExtra("received_card_name", str2);
        intent.putExtra("Is_Chatroom", true);
        AppMethodBeat.m2505o(35169);
    }

    /* renamed from: a */
    private void m39116a(C23273a c23273a, String str) {
        AppMethodBeat.m2504i(35170);
        C9638aw.m17190ZK();
        C18628c.m29078XM().aoM(str);
        String mJ = C1854s.m3866mJ(str);
        if (!C5046bo.isNullOrNil(this.zJW)) {
            mJ = this.zJW;
        }
        c23273a.ajC(new StringBuffer(ast(str)).append(mJ).toString());
        AppMethodBeat.m2505o(35170);
    }

    private String ast(String str) {
        AppMethodBeat.m2504i(35171);
        C9638aw.m17190ZK();
        C7616ad aoM = C18628c.m29078XM().aoM(str);
        String string = getResources().getString(C25738R.string.f9147qy);
        if (aoM == null) {
            AppMethodBeat.m2505o(35171);
        } else {
            if (C1855t.m3897kv(aoM.field_verifyFlag)) {
                string = getResources().getString(C25738R.string.f9146qx);
            } else if (C7616ad.aox(str)) {
                string = SelectConversationUI.m39127c(this, aoM);
            } else {
                string = getResources().getString(C25738R.string.f9147qy);
            }
            AppMethodBeat.m2505o(35171);
        }
        return string;
    }

    /* renamed from: c */
    public static String m39127c(Context context, C7616ad c7616ad) {
        String string;
        AppMethodBeat.m2504i(35172);
        if (TextUtils.isEmpty(((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(c7616ad.field_openImAppid, "openim_card_type_name", C32874a.TYPE_WORDING))) {
            string = context.getResources().getString(C25738R.string.f9147qy);
        } else {
            string = String.format("[%s]", new Object[]{((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(c7616ad.field_openImAppid, "openim_card_type_name", C32874a.TYPE_WORDING)});
        }
        AppMethodBeat.m2505o(35172);
        return string;
    }

    /* renamed from: a */
    private void m39113a(Intent intent, Intent intent2) {
        AppMethodBeat.m2504i(35173);
        C4990ab.m7410d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(intent2)));
        intent2.putExtras(intent.getExtras());
        startActivityForResult(intent2, 2);
        C5274b.m8044K(this.mController.ylL, intent2);
        AppMethodBeat.m2505o(35173);
    }

    /* renamed from: t */
    private void m39149t(final Intent intent, final String str) {
        AppMethodBeat.m2504i(35174);
        if (asq(str)) {
            AppMethodBeat.m2505o(35174);
        } else if (C15830s.m24192hr(this.gnI, 256)) {
            m39141k(-1, intent);
            finish();
            AppMethodBeat.m2505o(35174);
        } else if (C42252ah.isNullOrNil(str)) {
            C4990ab.m7418v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
            AppMethodBeat.m2505o(35174);
        } else {
            if (C1855t.m3896kH(str)) {
                int mA = C37921n.m64060mA(str);
                if (!this.zJU || mA <= C42252ah.getInt(C26373g.m41964Nu().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)) {
                    getString(C25738R.string.e1l, new Object[]{Integer.valueOf(mA)});
                } else {
                    C4990ab.m7421w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", Integer.valueOf(C42252ah.getInt(C26373g.m41964Nu().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)), Integer.valueOf(mA));
                    C30379h.m48461b((Context) this, getString(C25738R.string.e1n, new Object[]{Integer.valueOf(r1)}), "", true);
                    AppMethodBeat.m2505o(35174);
                    return;
                }
            }
            C23273a c23273a = new C23273a(this.mController.ylL);
            c23273a.mo38972cx(str);
            final String str2;
            if (this.zoG) {
                m39116a(c23273a, this.zJV);
                if (C1855t.m3896kH(str)) {
                    SelectConversationUI.m39128c(intent, this.zJV, str);
                } else {
                    SelectConversationUI.m39124b(intent, this.zJV, str);
                }
                c23273a.mo38977h(Boolean.TRUE);
            } else if (this.zJN) {
                if (this.cvv != -1) {
                    m39125b(c23273a);
                    C37720gf c37720gf = new C37720gf();
                    c37720gf.cAC.cvv = this.cvv;
                    c37720gf.cAC.cAD = c23273a;
                    c37720gf.cAC.cAE = this.zKd;
                    c37720gf.cAC.csX = this.mController.ylL;
                    C4879a.xxA.mo10055m(c37720gf);
                } else if (this.msgType == 17 && this.zJT != 0) {
                    c23273a.ajC(new StringBuffer(getResources().getString(C25738R.string.f9171rp)).append(this.mController.ylL.getString(C25738R.string.dr3, new Object[]{Integer.valueOf(this.zJT)})).toString());
                }
                c23273a.mo38977h(Boolean.TRUE);
            } else if (this.zJO) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("webview_params");
                String str3 = (String) hashMap.get("img_url");
                String str4 = (String) hashMap.get("title");
                str2 = (String) hashMap.get("url");
                c23273a.ajC(new StringBuffer(getResources().getString(C25738R.string.f9248u9)).append(str4).toString());
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(35150);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("showShare", false);
                        C25985d.m41467b(SelectConversationUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.m2505o(35150);
                    }
                });
                c23273a.ajD(str3).djx();
                c23273a.mo38977h(Boolean.TRUE);
            } else if (this.zJP && m39120a(intent, c23273a)) {
                AppMethodBeat.m2505o(35174);
                return;
            } else if (this.zJR) {
                str2 = getResources().getString(C25738R.string.f9150r1);
                if (this.kcC != null) {
                    str2 = new StringBuffer(str2).append(this.kcC).toString();
                }
                c23273a.ajC(str2);
                c23273a.mo38977h(Boolean.FALSE);
            } else {
                m39115a(c23273a);
                m39125b(c23273a);
                c23273a.mo38977h(Boolean.TRUE);
            }
            c23273a.mo38965KQ(C25738R.string.f9221tf).mo38966a(new C30111a() {
                /* renamed from: a */
                public final void mo6399a(boolean z, String str, int i) {
                    AppMethodBeat.m2504i(35151);
                    SelectConversationUI.this.aqX();
                    boolean booleanExtra = intent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
                    if (booleanExtra) {
                        int i2;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        C4990ab.m7417i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", Integer.valueOf(13943), Integer.valueOf(i2));
                        C7060h.pYm.mo8381e(13943, Integer.valueOf(i2));
                    }
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        SelectConversationUI.m39117a(SelectConversationUI.this, -1, intent);
                        C35898l.m58848hK(SelectConversationUI.this.cJh, str);
                        SelectConversationUI.this.finish();
                        AppMethodBeat.m2505o(35151);
                        return;
                    }
                    if (booleanExtra) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().aoX(stringExtra);
                    }
                    AppMethodBeat.m2505o(35151);
                }
            }).gud.show();
            AppMethodBeat.m2505o(35174);
        }
    }

    /* renamed from: a */
    private boolean m39120a(Intent intent, C23273a c23273a) {
        AppMethodBeat.m2504i(35175);
        HashMap hashMap = (HashMap) getIntent().getSerializableExtra("appbrand_params");
        if (C26424ce.m42080bc(hashMap.get("is_weishi_video"))) {
            boolean a = m39121a(c23273a, hashMap);
            AppMethodBeat.m2505o(35175);
            return a;
        }
        int i = C26424ce.getInt(hashMap.get("type"), 1);
        String e = C26424ce.m42081e(hashMap.get("title"), "");
        String e2 = C26424ce.m42081e(hashMap.get("img_url"), null);
        if (i == 2 || i == 3) {
            String e3 = C26424ce.m42081e(hashMap.get("app_id"), null);
            int i2 = C26424ce.getInt(hashMap.get("pkg_type"), 0);
            int i3 = C26424ce.getInt(hashMap.get("pkg_version"), 0);
            String e4 = C26424ce.m42081e(hashMap.get("cache_key"), null);
            String e5 = C26424ce.m42081e(hashMap.get("path"), null);
            String e6 = C26424ce.m42081e(hashMap.get("delay_load_img_path"), null);
            String e7 = C26424ce.m42081e(hashMap.get("nickname"), "");
            boolean bc = C26424ce.m42080bc(hashMap.get("is_dynamic"));
            Bundle bundle = null;
            int i4 = C26424ce.getInt(hashMap.get("biz"), C8913a.BUSINESS_MAX.ordinal());
            if (C8913a.isValid(i4)) {
                String e8 = C26424ce.m42081e(hashMap.get("tail_lang"), "");
                String e9 = C26424ce.m42081e(hashMap.get("icon_url"), "");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_biz", i4);
                bundle2.putString("key_footer_text_default", e7);
                bundle2.putString("key_footer_text", C8913a.m16077b(i4, e8, this.mController.ylL));
                bundle2.putString("key_footer_icon", e9);
                C4990ab.m7411d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", e7, e8);
                bundle = bundle2;
            } else {
                C4990ab.m7421w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", Integer.valueOf(i4));
            }
            final View d = ((C32809i) C1720g.m3528K(C32809i.class)).mo22293d((Context) this, bundle);
            e7 = C38496n.m65148bE(this);
            Bundle bundle3 = new Bundle();
            bundle3.putString("app_id", e3);
            bundle3.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            bundle3.putInt("msg_pkg_type", i2);
            bundle3.putInt("pkg_version", i3);
            bundle3.putString(MessengerShareContentUtility.IMAGE_URL, e2);
            bundle3.putBoolean("is_dynamic_page", bc);
            bundle3.putString("title", e);
            bundle3.putString("cache_key", e4);
            bundle3.putString("msg_path", e5);
            bundle3.putString("delay_load_img_path", e6);
            final C44389e c44389e = new C44389e(this);
            final Intent intent2 = intent;
            c44389e.zKR = new C30773a() {
                /* renamed from: z */
                public final void mo41880z(boolean z, String str) {
                    AppMethodBeat.m2504i(35152);
                    if (z) {
                        intent2.putExtra("custom_send_text", str);
                        SelectConversationUI.m39117a(SelectConversationUI.this, -1, intent2);
                        SelectConversationUI.this.finish();
                    } else {
                        SelectConversationUI.m39117a(SelectConversationUI.this, 0, intent2);
                        SelectConversationUI.this.finish();
                    }
                    ((C32809i) C1720g.m3528K(C32809i.class)).mo22288a(e7, d);
                    AppMethodBeat.m2505o(35152);
                }
            };
            ((C32809i) C1720g.m3528K(C32809i.class)).mo22290a(e7, d, bundle3, new C32808b() {
                /* renamed from: kQ */
                public final void mo6398kQ(int i) {
                    AppMethodBeat.m2504i(35125);
                    C4990ab.m7417i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", Integer.valueOf(i));
                    C44389e c44389e = c44389e;
                    c44389e.iHk = true;
                    if (c44389e.mo70260oC()) {
                        C5004al.m7439af(c44389e.hEw);
                        c44389e.aMl();
                    }
                    AppMethodBeat.m2505o(35125);
                }
            });
            c23273a.mo38976ev(d);
            c23273a.mo38977h(Boolean.TRUE);
            c23273a.djy();
            c23273a.jbD = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(35126);
                    ((C32809i) C1720g.m3528K(C32809i.class)).mo22288a(e7, d);
                    AppMethodBeat.m2505o(35126);
                }
            };
            c23273a.mo38965KQ(C25738R.string.f9221tf).mo38966a(new C30111a() {
                /* renamed from: a */
                public final void mo6399a(boolean z, String str, int i) {
                    AppMethodBeat.m2504i(35127);
                    SelectConversationUI.this.aqX();
                    C44389e c44389e = c44389e;
                    c44389e.iHj = true;
                    c44389e.iHl = z;
                    c44389e.text = str;
                    c44389e.iHm = i;
                    if (c44389e.mo70260oC()) {
                        c44389e.aMl();
                        AppMethodBeat.m2505o(35127);
                        return;
                    }
                    if (z) {
                        c44389e.tipDialog = C30379h.m48458b(c44389e.context, c44389e.context.getString(C25738R.string.e3l), true, null);
                        C5004al.m7442n(c44389e.hEw, 5000);
                    }
                    AppMethodBeat.m2505o(35127);
                }
            }).gud.show();
            AppMethodBeat.m2505o(35175);
            return true;
        }
        c23273a.ajC(new StringBuffer(getResources().getString(C25738R.string.f8870ho)).append(e).toString());
        c23273a.ajD(e2).djx();
        c23273a.mo38977h(Boolean.TRUE);
        AppMethodBeat.m2505o(35175);
        return false;
    }

    /* renamed from: a */
    private boolean m39121a(C23273a c23273a, HashMap<String, Object> hashMap) {
        AppMethodBeat.m2504i(35176);
        final String e = C26424ce.m42081e(hashMap.get("img_url"), null);
        if (C42252ah.isNullOrNil(e)) {
            String e2 = C26424ce.m42081e(hashMap.get("msg_img_path"), null);
            if (!C42252ah.isNullOrNil(e2)) {
                C4990ab.m7417i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", e, e2);
                c23273a.mo38971b(SelectConversationUI.asu(e2), 2);
            }
        } else {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            View inflate = LayoutInflater.from(this).inflate(2130969182, null);
            relativeLayout.addView(inflate, new LayoutParams(-2, -2));
            ((LayoutParams) inflate.getLayoutParams()).addRule(14);
            final ImageView imageView = (ImageView) inflate.findViewById(2131822916);
            ((ImageView) inflate.findViewById(2131822919)).setImageResource(C1318a.video_icon_in_gird);
            c23273a.mo38976ev(relativeLayout);
            c23273a.djy();
            C37926b.abR().mo60686a(new C9676i() {
                public final void abU() {
                }

                /* renamed from: x */
                public final void mo6524x(Bitmap bitmap) {
                    AppMethodBeat.m2504i(35128);
                    if (!(SelectConversationUI.this.isFinishing() || bitmap == null || bitmap.isRecycled() || imageView == null)) {
                        imageView.setImageBitmap(C5224ag.m7956d(SelectConversationUI.m39112a(SelectConversationUI.this, bitmap, imageView, bitmap.getWidth(), bitmap.getHeight()), (float) C5229aj.fromDPToPix(SelectConversationUI.this, 3)));
                    }
                    AppMethodBeat.m2505o(35128);
                }

                /* renamed from: mr */
                public final void mo6522mr() {
                    AppMethodBeat.m2504i(35129);
                    C4990ab.m7417i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", e);
                    AppMethodBeat.m2505o(35129);
                }

                /* renamed from: wP */
                public final String mo6523wP() {
                    return "SelectConversationUI#WEISHITHUMB";
                }
            }, e, null, null);
        }
        c23273a.mo38977h(Boolean.TRUE);
        AppMethodBeat.m2505o(35176);
        return false;
    }

    /* renamed from: a */
    private void m39115a(C23273a c23273a) {
        AppMethodBeat.m2504i(35177);
        int orientationInDegree;
        switch (this.msgType) {
            case 0:
            case 16:
                Bitmap dKl = dKl();
                if (dKl == null && this.imagePath != null) {
                    Bitmap j = C5056d.m7664j(this.imagePath, C1338a.getDensity(C4996ah.getContext()));
                    orientationInDegree = Exif.fromFile(this.imagePath).getOrientationInDegree();
                    if (orientationInDegree < 0) {
                        orientationInDegree = 0;
                    }
                    dKl = C5056d.m7648b(j, (float) orientationInDegree);
                }
                c23273a.mo38971b(dKl, 3);
                AppMethodBeat.m2505o(35177);
                return;
            case 1:
                c23273a.mo38971b(dKk(), 2);
                AppMethodBeat.m2505o(35177);
                return;
            case 2:
            case 10:
                C8910b X;
                C8910b me = C8910b.m16064me(C5046bo.anj(this.cJh));
                if (this.cKd.drC() && me == null) {
                    X = C8910b.m16058X(C5046bo.anj(this.cJh), C5046bo.anj(this.cJh));
                } else {
                    X = me;
                }
                String string;
                if (X == null) {
                    if (this.zKc != null) {
                        string = getResources().getString(C25738R.string.f9253ud);
                        c23273a.ajC(new StringBuffer(string).append(this.zKc).toString());
                    }
                    AppMethodBeat.m2505o(35177);
                    return;
                }
                String string2;
                string = X.title;
                if (C44312l.m80098f(this.cKd, this.zeC)) {
                    string2 = getResources().getString(C25738R.string.f8870ho);
                } else if (X.type == 5) {
                    string2 = getResources().getString(C25738R.string.f9248u9);
                } else if (X.type == 6) {
                    string2 = getResources().getString(C25738R.string.f9140qr);
                } else if (X.type == 24) {
                    string2 = getResources().getString(C25738R.string.f9186s5);
                    string = SelectConversationUI.m39139i(X);
                } else if (X.type == 19) {
                    string2 = getResources().getString(C25738R.string.f9212t5);
                } else if (X.type == 3) {
                    string2 = getResources().getString(C25738R.string.f9174rs);
                } else if (X.type == 4) {
                    string2 = getResources().getString(C25738R.string.f9253ud);
                } else if (X.type == 8) {
                    string2 = getResources().getString(C25738R.string.f9102pj);
                } else if (X.type != 33 && X.type != 36 && X.type != 44) {
                    string2 = getResources().getString(C25738R.string.f8820fy);
                } else if (X.fiR == 2 || X.fiR == 3 || X.type == 36) {
                    Bundle bundle;
                    int i = X.fiW;
                    if (X.mo20336cw(false)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("key_biz", i);
                        bundle2.putString("key_footer_text_default", X.cMh);
                        bundle2.putString("key_footer_text", X.mo20339p(this.mController.ylL, false));
                        bundle2.putString("key_footer_icon", X.fjb);
                        bundle = bundle2;
                    } else {
                        C4990ab.m7421w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", Integer.valueOf(i));
                        bundle = null;
                    }
                    final View d = ((C32809i) C1720g.m3528K(C32809i.class)).mo22293d((Context) this, bundle);
                    c23273a.mo38976ev(d);
                    c23273a.mo38977h(Boolean.TRUE);
                    c23273a.djy();
                    string = C32291o.ahl().mo73108c(this.cKd.field_imgPath, false, true);
                    final String bE = C38496n.m65148bE(this);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("app_id", X.fiQ);
                    bundle3.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(X.fiZ), Integer.valueOf(X.fiT)}));
                    bundle3.putInt("msg_pkg_type", X.fiZ);
                    bundle3.putInt("pkg_version", X.fiT);
                    if (!C5046bo.isNullOrNil(string)) {
                        bundle3.putString(MessengerShareContentUtility.IMAGE_URL, "file://".concat(String.valueOf(string)));
                    }
                    C41728a c41728a = (C41728a) X.mo20333X(C41728a.class);
                    if (c41728a != null) {
                        bundle3.putBoolean("is_dynamic_page", c41728a.feY);
                        bundle3.putString("cache_key", c41728a.feZ);
                    }
                    bundle3.putString("title", X.title);
                    bundle3.putString("msg_path", X.fiO);
                    ((C32809i) C1720g.m3528K(C32809i.class)).mo22289a(bE, d, bundle3);
                    c23273a.jbD = new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(35130);
                            ((C32809i) C1720g.m3528K(C32809i.class)).mo22288a(bE, d);
                            AppMethodBeat.m2505o(35130);
                        }
                    };
                    AppMethodBeat.m2505o(35177);
                    return;
                } else {
                    string2 = getResources().getString(C25738R.string.f8870ho);
                }
                if (X.type == 46) {
                    c23273a.mo38971b(dKl(), 2);
                    AppMethodBeat.m2505o(35177);
                    return;
                }
                if (string == null) {
                    string = "";
                }
                c23273a.ajC(string2 + string);
                if (X.thumburl != null) {
                    c23273a.ajD(X.thumburl).djx();
                    AppMethodBeat.m2505o(35177);
                    return;
                }
                break;
            case 3:
                if (this.kcC != null) {
                    c23273a.ajC(new StringBuffer(getResources().getString(C25738R.string.f9140qr)).append(this.kcC).toString());
                    break;
                }
                break;
            case 4:
                c23273a.ajC(this.cJh);
                c23273a.djw();
                AppMethodBeat.m2505o(35177);
                return;
            case 5:
                if (!C5046bo.isNullOrNil(this.lgZ)) {
                    c23273a.ajE(this.lgZ);
                    AppMethodBeat.m2505o(35177);
                    return;
                } else if (C5046bo.isNullOrNil(this.cKd.field_imgPath)) {
                    c23273a.ajE(this.imagePath);
                    AppMethodBeat.m2505o(35177);
                    return;
                } else {
                    c23273a.ajE(this.cKd.field_imgPath);
                    AppMethodBeat.m2505o(35177);
                    return;
                }
            case 8:
                C9638aw.m17190ZK();
                C5135a Rn = C18628c.m29080XO().mo15260Rn(this.cJh);
                this.zJV = Rn.svN;
                this.zJW = Rn.nickname;
                this.zJX = Boolean.valueOf(C1855t.m3897kv(Rn.ufB));
                m39116a(c23273a, this.zJV);
                AppMethodBeat.m2505o(35177);
                return;
            case 9:
                c23273a.ajC(dKj());
                AppMethodBeat.m2505o(35177);
                return;
            case 11:
                c23273a.mo38971b(dKk(), 2);
                AppMethodBeat.m2505o(35177);
                return;
            case 12:
                C18348nt hS = C46660k.m88363hS(this.mController.ylL);
                if (hS.cJY.cKe != null) {
                    orientationInDegree = hS.cJY.cKe.size();
                } else {
                    orientationInDegree = 0;
                }
                c23273a.ajC(new StringBuffer(getResources().getString(C25738R.string.f9171rp)).append(this.mController.ylL.getString(C25738R.string.dr3, new Object[]{Integer.valueOf(orientationInDegree)})).toString());
                AppMethodBeat.m2505o(35177);
                return;
            case 13:
                c23273a.ajC(new StringBuffer(getResources().getString(C25738R.string.f9172rq)).append(C42252ah.m74607bc(C46660k.m88363hS(this.mController.ylL).cJZ.cKh.title, "")).toString());
                AppMethodBeat.m2505o(35177);
                return;
        }
        AppMethodBeat.m2505o(35177);
    }

    /* renamed from: b */
    private void m39125b(C23273a c23273a) {
        AppMethodBeat.m2504i(35178);
        switch (this.msgType) {
            case 0:
            case 1:
            case 11:
            case 16:
                c23273a.mo38967a(new C249758());
                AppMethodBeat.m2505o(35178);
                return;
            case 2:
            case 10:
                final C8910b me = C8910b.m16064me(C5046bo.anj(this.cJh));
                if (me == null) {
                    AppMethodBeat.m2505o(35178);
                    return;
                } else if (me.type == 5 && !C44312l.m80098f(this.cKd, this.zeC)) {
                    final String str = me.url;
                    c23273a.mo38967a(new C5649b() {
                        public final void bwF() {
                            AppMethodBeat.m2504i(35134);
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", false);
                            C25985d.m41467b(SelectConversationUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.m2505o(35134);
                        }
                    });
                    AppMethodBeat.m2505o(35178);
                    return;
                } else if (me.type == 6) {
                    c23273a.mo38967a(new C2498411());
                    AppMethodBeat.m2505o(35178);
                    return;
                } else if (me.type == 24) {
                    c23273a.mo38967a(new C5649b() {
                        public final void bwF() {
                            AppMethodBeat.m2504i(35137);
                            C32599lz c32599lz = new C32599lz();
                            c32599lz.cHO.context = SelectConversationUI.this.mController.ylL;
                            c32599lz.cHO.cvx = SelectConversationUI.this.cvx;
                            c32599lz.cHO.cHP = me.fgU;
                            c32599lz.cHO.cHc = false;
                            c32599lz.cHO.scene = 7;
                            C4879a.xxA.mo10055m(c32599lz);
                            AppMethodBeat.m2505o(35137);
                        }
                    });
                    AppMethodBeat.m2505o(35178);
                    return;
                } else if (me.type == 19) {
                    c23273a.mo38967a(new C5649b() {
                        public final void bwF() {
                            AppMethodBeat.m2504i(35138);
                            Intent intent = new Intent();
                            intent.putExtra("message_id", SelectConversationUI.this.cvx);
                            intent.putExtra("record_xml", me.fgU);
                            intent.putExtra("record_show_share", false);
                            C25985d.m41467b(SelectConversationUI.this.mController.ylL, "record", ".ui.RecordMsgDetailUI", intent);
                            AppMethodBeat.m2505o(35138);
                        }
                    });
                    AppMethodBeat.m2505o(35178);
                    return;
                } else if (me.type == 3) {
                    c23273a.mo38967a(new C5649b() {
                        public final void bwF() {
                            AppMethodBeat.m2504i(35139);
                            String B = C35799p.m58684B(me.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                            String B2 = C35799p.m58684B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                            if (C5023at.isMobile(SelectConversationUI.this.mController.ylL) ? B2 != null && B2.length() > 0 : B == null || B.length() <= 0) {
                                B = B2;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", B);
                            intent.putExtra("showShare", false);
                            C25985d.m41467b(SelectConversationUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.m2505o(35139);
                        }
                    });
                    AppMethodBeat.m2505o(35178);
                    return;
                } else if (me.type == 4) {
                    c23273a.mo38967a(new C2497316());
                    AppMethodBeat.m2505o(35178);
                    return;
                }
                break;
            case 3:
                c23273a.mo38967a(new C2497718());
                break;
            case 4:
                c23273a.mo38967a(new C159557());
                AppMethodBeat.m2505o(35178);
                return;
            case 9:
                C9638aw.m17190ZK();
                final C5136b Ro = C18628c.m29080XO().mo15261Ro(this.cJh);
                final String str2 = Ro.label;
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(35133);
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", Ro.nJu);
                        intent.putExtra("kwebmap_lng", Ro.nJv);
                        intent.putExtra("Kwebmap_locaion", str2);
                        intent.putExtra("kShowshare", false);
                        C25985d.m41467b(SelectConversationUI.this.mController.ylL, C8741b.LOCATION, ".ui.RedirectUI", intent);
                        AppMethodBeat.m2505o(35133);
                    }
                });
                AppMethodBeat.m2505o(35178);
                return;
            case 12:
                C46660k.m88363hS(this.mController.ylL);
                AppMethodBeat.m2505o(35178);
                return;
            case 13:
                c23273a.mo38967a(new C2498517());
                AppMethodBeat.m2505o(35178);
                return;
        }
        AppMethodBeat.m2505o(35178);
    }

    private String dKj() {
        AppMethodBeat.m2504i(35179);
        C9638aw.m17190ZK();
        C5136b Ro = C18628c.m29080XO().mo15261Ro(this.cJh);
        String str = "";
        if (Ro != null) {
            str = Ro.label;
        }
        str = this.mController.ylL.getString(C25738R.string.f9162rf) + str;
        AppMethodBeat.m2505o(35179);
        return str;
    }

    private Bitmap dKk() {
        AppMethodBeat.m2504i(35180);
        C37961o.all();
        String ui = C9720t.m17304ui(this.cKd.field_imgPath);
        if (ui == null) {
            ui = this.imagePath;
        }
        Bitmap aml = C5056d.aml(ui);
        AppMethodBeat.m2505o(35180);
        return aml;
    }

    private Bitmap dKl() {
        AppMethodBeat.m2504i(35181);
        if (this.cKd == null) {
            AppMethodBeat.m2505o(35181);
            return null;
        }
        String str = this.cKd.field_imgPath;
        Bitmap sk = C32291o.ahl().mo73120sk(str);
        if (sk != null) {
            try {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                if (orientationInDegree < 0) {
                    orientationInDegree = 0;
                }
                sk = C5056d.m7648b(sk, (float) orientationInDegree);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(35181);
        return sk;
    }

    private static Bitmap asu(String str) {
        AppMethodBeat.m2504i(35182);
        Bitmap sk = C32291o.ahl().mo73120sk(str);
        if (sk != null) {
            try {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                if (orientationInDegree < 0) {
                    orientationInDegree = 0;
                }
                sk = C5056d.m7648b(sk, (float) orientationInDegree);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(35182);
        return sk;
    }

    /* renamed from: a */
    public static Bitmap m39112a(Context context, Bitmap bitmap, ImageView imageView, int i, int i2) {
        AppMethodBeat.m2504i(35183);
        Bitmap bitmap2 = null;
        float f = ((float) i2) / ((float) i);
        int i3 = 0;
        int i4 = 0;
        int am = C5229aj.m7981am(context, C25738R.dimen.f9786fl);
        int am2 = C5229aj.m7981am(context, C25738R.dimen.f9785fk);
        int i5 = 0;
        int i6 = 0;
        if (f > 0.0f && ((double) f) < 0.5d) {
            i4 = (int) (((float) am) / f);
            i6 = am;
            i5 = am2;
            i3 = am;
        } else if (((double) f) >= 0.5d && f < 1.0f) {
            am = (int) (((float) am2) * f);
            i6 = am;
            i5 = am2;
            i4 = am2;
            i3 = am;
        } else if (f >= 1.0f && f < 2.0f) {
            am = (int) (((float) am2) / f);
            i6 = am2;
            i5 = am;
            i4 = am;
            i3 = am2;
        } else if (f >= 2.0f) {
            i3 = (int) (((float) am) * f);
            i6 = am2;
            i5 = am;
            i4 = am;
        }
        if (i3 > 0 && i4 > 0 && bitmap != null) {
            bitmap2 = Bitmap.createScaledBitmap(bitmap, i4, i3, true);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(i5, i6));
        }
        AppMethodBeat.m2505o(35183);
        return bitmap2;
    }

    /* renamed from: i */
    private static String m39139i(C8910b c8910b) {
        AppMethodBeat.m2504i(35184);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 0;
        c18348nt.cJY.cKa = c8910b.fgU;
        C4879a.xxA.mo10055m(c18348nt);
        String replaceAll = C5046bo.m7532bc(c18348nt.cJZ.cKi.desc, c8910b.description).replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ");
        AppMethodBeat.m2505o(35184);
        return replaceAll;
    }

    private void dKm() {
        boolean z;
        AppMethodBeat.m2504i(35185);
        C4990ab.m7416i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 14);
        intent.putExtra("titile", getString(C25738R.string.f8782eu));
        intent.putExtra("list_attr", C15830s.znK);
        intent.putExtra("already_select_contact", C42252ah.m74611c(this.zKa, ","));
        intent.putExtra("max_limit_num", 9);
        String str = "Forbid_SelectChatRoom";
        if (this.zoG && C7616ad.aox(this.zJV)) {
            z = true;
        } else {
            z = false;
        }
        intent.putExtra(str, z);
        this.mController.ylL.startActivityForResult(intent, 5);
        AppMethodBeat.m2505o(35185);
    }

    private void dKn() {
        boolean z = true;
        AppMethodBeat.m2504i(35186);
        C4990ab.m7416i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", C15830s.znH);
        intent.putExtra("list_type", 3);
        intent.putExtra("be_send_card_name", this.zJV);
        intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", getString(C25738R.string.f8782eu));
        String str = "Forbid_SelectChatRoom";
        if (!(this.zoG && C7616ad.aox(this.zJV))) {
            z = false;
        }
        intent.putExtra(str, z);
        this.mController.ylL.startActivityForResult(intent, 3);
        AppMethodBeat.m2505o(35186);
    }

    private void dKo() {
        AppMethodBeat.m2504i(35187);
        C4990ab.m7416i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 5);
        intent.putExtra("titile", getString(C25738R.string.f8782eu));
        if (((this.fromScene == 4 || this.fromScene == 9) && getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || this.fromScene == 10) {
            intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
            intent.putExtra("list_attr", C15830s.m24190C(32, 16, 1, 2, 4, 16384));
        } else {
            intent.putExtra("list_attr", C15830s.znJ);
        }
        this.mController.ylL.startActivityForResult(intent, 1);
        AppMethodBeat.m2505o(35187);
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(35188);
        String stringExtra = getIntent().getStringExtra("Select_Conv_ui_title");
        if (stringExtra == null || stringExtra.length() <= 0) {
            stringExtra = getString(C25738R.string.e1v);
            AppMethodBeat.m2505o(35188);
            return stringExtra;
        }
        AppMethodBeat.m2505o(35188);
        return stringExtra;
    }

    public final boolean aow() {
        return false;
    }

    /* renamed from: vI */
    public final void mo7901vI(String str) {
        AppMethodBeat.m2504i(35190);
        this.zKa.remove(str);
        dHV().notifyDataSetChanged();
        m39111Kt();
        AppMethodBeat.m2505o(35190);
    }

    /* renamed from: Kt */
    private void m39111Kt() {
        AppMethodBeat.m2504i(35191);
        if (!this.zJY) {
            AppMethodBeat.m2505o(35191);
        } else if (this.zKa != null && this.zKa.size() > 0) {
            updateOptionMenuText(1, getString(C25738R.string.f9221tf) + "(" + this.zKa.size() + ")");
            mo17376a(1, this.zKi);
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(35191);
        } else if (this.zJZ) {
            updateOptionMenuText(1, getString(C25738R.string.f9231tr));
            mo17376a(1, this.zKh);
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(35191);
        } else {
            updateOptionMenuText(1, getString(C25738R.string.f9173rr));
            mo17376a(1, this.zKh);
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(35191);
        }
    }

    /* renamed from: qS */
    private boolean m39148qS(boolean z) {
        AppMethodBeat.m2504i(35192);
        if (z ? this.zKa.size() >= 9 : this.zKa.size() > 9) {
            C30379h.m48438a(this.mController.ylL, getString(C25738R.string.e1o, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9))}), getString(C25738R.string.f9213t6), new C2499024());
            AppMethodBeat.m2505o(35192);
            return true;
        }
        AppMethodBeat.m2505o(35192);
        return false;
    }

    public final boolean dHZ() {
        return true;
    }

    public final int[] bMP() {
        AppMethodBeat.m2504i(35193);
        int[] intArrayExtra = getIntent().getIntArrayExtra("search_range");
        if (this.fromScene == 4 || this.fromScene == 10) {
            intArrayExtra = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            AppMethodBeat.m2505o(35193);
            return intArrayExtra;
        } else if (intArrayExtra != null) {
            AppMethodBeat.m2505o(35193);
            return intArrayExtra;
        } else {
            intArrayExtra = super.bMP();
            AppMethodBeat.m2505o(35193);
            return intArrayExtra;
        }
    }

    /* renamed from: k */
    private void m39141k(int i, Intent intent) {
        AppMethodBeat.m2504i(35194);
        if (this.msgType == 5) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("emoji_thumb_path", this.lgZ);
            intent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
        }
        super.setResult(i, intent);
        AppMethodBeat.m2505o(35194);
    }

    /* renamed from: fy */
    private void m39135fy(List<String> list) {
        AppMethodBeat.m2504i(35195);
        long currentTimeMillis = System.currentTimeMillis();
        int size = list.size();
        C26432y nY = C18643z.m29128nY(getString(C25738R.string.c_1));
        Cursor cursor = null;
        try {
            C1720g.m3537RQ();
            cursor = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15738d(nY.getType(), "", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(cursor);
                list.add(c7616ad.field_username);
                cursor.moveToNext();
            }
            if (cursor != null) {
                cursor.close();
            }
            C4990ab.m7417i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(size), Integer.valueOf(list.size() - size));
            AppMethodBeat.m2505o(35195);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            C4990ab.m7417i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(size), Integer.valueOf(list.size() - size));
            AppMethodBeat.m2505o(35195);
        }
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(35189);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(35189);
            return false;
        }
        boolean contains = this.zKa.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(35189);
        return contains;
    }
}
