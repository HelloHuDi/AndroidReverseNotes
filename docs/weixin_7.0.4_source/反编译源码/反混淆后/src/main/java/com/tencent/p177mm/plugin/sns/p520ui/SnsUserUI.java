package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Process;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p174e.C1153b;
import com.tencent.matrix.trace.p175f.C7469c;
import com.tencent.p127d.p135f.C8769e;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p232b.p233a.C32661ah;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.statusbar.C5544c;
import com.tencent.p177mm.p612ui.statusbar.C5544c.C5543a;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.plugin.sns.p520ui.C46250as.C35106c;
import com.tencent.p177mm.plugin.sns.p520ui.C46250as.C4017f;
import com.tencent.p177mm.plugin.sns.p520ui.SnsUIAction.C13559a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.ActUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI */
public class SnsUserUI extends MMActivity implements C39729a {
    private long eEO = 0;
    private int ehv;
    private long fAq = 0;
    private C4884c hAA = new C1360110();
    private String igi;
    private C1153b mnM = new C1361414();
    private View plv;
    private C5543a plx;
    private C46250as rCS;
    private SnsUIAction rCT;
    private C3890a rCU;
    private C13559a rCV;
    private RelativeLayout rCW = null;
    private TextView rCX = null;
    private int rCY = 0;
    private Runnable rCZ = new C40121();
    private boolean rjn;
    private String ryC;
    private boolean ryD;
    private int ryE;
    private boolean ryx = false;
    private OnMenuItemClickListener rzm = new C136087();

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$1 */
    class C40121 implements Runnable {
        C40121() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39785);
            SnsUserUI.this.rCS.ctK();
            SnsUserUI.this.rCS.crP();
            AppMethodBeat.m2505o(39785);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$2 */
    class C40132 implements Runnable {
        C40132() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39786);
            if (SnsUserUI.this.ryx) {
                C4990ab.m7420w("MicroMsg.SnsUserUI", "too fast that it finish");
                AppMethodBeat.m2505o(39786);
                return;
            }
            SnsUserUI.this.rCU.mo8617a(SnsUserUI.this.rCV.getType(), SnsUserUI.this.igi, SnsUserUI.this);
            if (SnsUserUI.this.rCV.getType() == 1 && SnsUserUI.this.rCV.cuk()) {
                C13373af.cnv().mo8613B(C13373af.cnM().qMB, -1);
            }
            if (!SnsUserUI.this.rCV.cuk()) {
                C3890a b = SnsUserUI.this.rCU;
                int type = SnsUserUI.this.rCV.getType();
                String c = SnsUserUI.this.igi;
                SnsUserUI.this.ryD;
                b.mo8618a(type, c, SnsUserUI.this.rjn, SnsUserUI.this.ryE);
            }
            AppMethodBeat.m2505o(39786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$18 */
    class C1360018 implements OnItemClickListener {
        C1360018() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$10 */
    class C1360110 extends C4884c<C37752ke> {
        C1360110() {
            AppMethodBeat.m2504i(39793);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(39793);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39794);
            C37752ke c37752ke = (C37752ke) c4883b;
            if (c37752ke instanceof C37752ke) {
                switch (c37752ke.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        SnsUserUI.this.rCS.notifyDataSetChanged();
                        break;
                }
            }
            AppMethodBeat.m2505o(39794);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$12 */
    class C1360212 implements Runnable {
        C1360212() {
        }

        public final void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$4 */
    class C136034 implements C5543a {
        C136034() {
        }

        /* renamed from: pO */
        public final void mo11252pO(int i) {
            AppMethodBeat.m2504i(39788);
            SnsUserUI.this.plv.setPadding(0, i, 0, 0);
            C5546d.m8368a(SnsUserUI.this.getWindow());
            AppMethodBeat.m2505o(39788);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$11 */
    class C1360411 implements Runnable {
        C1360411() {
        }

        public final void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$13 */
    class C1360513 implements C13559a {
        C1360513() {
        }

        public final void cuh() {
            AppMethodBeat.m2504i(39795);
            if (SnsUserUI.this.rCU == null) {
                SnsUserUI.this.rCU = C13373af.cnv();
            }
            C3890a b = SnsUserUI.this.rCU;
            String c = SnsUserUI.this.igi;
            SnsUserUI.this.ryD;
            b.mo8620b(2, c, SnsUserUI.this.rjn, SnsUserUI.this.ryE);
            C13373af.bCo().postDelayed(SnsUserUI.this.rCZ, 3000);
            AppMethodBeat.m2505o(39795);
        }

        public final ListView getSnsListView() {
            AppMethodBeat.m2504i(39796);
            ListView listView = (ListView) SnsUserUI.this.findViewById(2131827740);
            AppMethodBeat.m2505o(39796);
            return listView;
        }

        public final View cui() {
            AppMethodBeat.m2504i(39797);
            View findViewById = SnsUserUI.this.findViewById(2131821333);
            AppMethodBeat.m2505o(39797);
            return findViewById;
        }

        public final View getMaskView() {
            AppMethodBeat.m2504i(39798);
            View findViewById = SnsUserUI.this.findViewById(2131827838);
            AppMethodBeat.m2505o(39798);
            return findViewById;
        }

        public final MMPullDownView cuj() {
            AppMethodBeat.m2504i(39799);
            MMPullDownView mMPullDownView = (MMPullDownView) SnsUserUI.this.findViewById(2131822761);
            AppMethodBeat.m2505o(39799);
            return mMPullDownView;
        }

        public final int getType() {
            return 2;
        }

        /* renamed from: b */
        public final void mo25742b(int i, List<Integer> list, List<Integer> list2) {
            C46250as a;
            AppMethodBeat.m2504i(39800);
            if (!(i == -1 || SnsUserUI.this.rCS == null)) {
                a = SnsUserUI.this.rCS;
                if (a.rvw != null) {
                    C39831at c39831at = a.rvw;
                    C46236n DK = C13373af.cnF().mo62914DK(i);
                    if (!(DK == null || DK.cqu().xfI == null || c39831at.list.size() <= 0)) {
                        c39831at.list.add(1, DK);
                        c39831at.ctM();
                        c39831at.ctN();
                    }
                }
            }
            if (!(SnsUserUI.this.rCS == null || list == null || list2 == null)) {
                a = SnsUserUI.this.rCS;
                if (a.rvw != null) {
                    if (list == null || list2 == null || list.size() + list2.size() == 0) {
                        AppMethodBeat.m2505o(39800);
                        return;
                    }
                    int i2;
                    C46236n c46236n;
                    C39831at c39831at2 = a.rvw;
                    if (!(list == null || list.size() == 0)) {
                        C4990ab.m7410d("MicroMsg.SnsSelfHelper", "remove Items");
                        for (Integer intValue : list) {
                            int intValue2 = intValue.intValue();
                            int size = c39831at2.list.size();
                            for (i2 = 1; i2 < size; i2++) {
                                c46236n = (C46236n) c39831at2.list.get(i2);
                                if (c46236n != null && c46236n.reX == intValue2) {
                                    c39831at2.list.remove(i2);
                                    break;
                                }
                            }
                        }
                    }
                    if (!(list2 == null || list2.size() == 0)) {
                        C4990ab.m7410d("MicroMsg.SnsSelfHelper", "change Items");
                        LinkedList linkedList = new LinkedList();
                        i2 = 1;
                        while (i2 < c39831at2.list.size()) {
                            c46236n = (C46236n) c39831at2.list.get(i2);
                            if (c46236n != null) {
                                for (Integer intValue3 : list2) {
                                    int intValue4 = intValue3.intValue();
                                    if (c46236n.reX == intValue4) {
                                        C4990ab.m7410d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(intValue4)));
                                        c39831at2.list.remove(i2);
                                        linkedList.add(C13373af.cnF().mo62914DK(intValue4));
                                        i2--;
                                        break;
                                    }
                                }
                            }
                            i2++;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            c39831at2.list.add((C46236n) it.next());
                        }
                    }
                    c39831at2.ctM();
                    c39831at2.ctN();
                }
            }
            AppMethodBeat.m2505o(39800);
        }

        public final boolean cuk() {
            return false;
        }

        public final void cul() {
            AppMethodBeat.m2504i(39801);
            C3890a b = SnsUserUI.this.rCU;
            String c = SnsUserUI.this.igi;
            SnsUserUI.this.ryD;
            b.mo8618a(2, c, SnsUserUI.this.rjn, SnsUserUI.this.ryE);
            AppMethodBeat.m2505o(39801);
        }

        public final void cum() {
        }

        /* renamed from: Eh */
        public final void mo25740Eh(int i) {
            AppMethodBeat.m2504i(39802);
            C4990ab.m7417i("MicroMsg.SnsUserUI", "onListViewScoll %s", Integer.valueOf(i));
            if (i == 2) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, SnsUserUI.this.ehv);
                SnsUserUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, WXHardCoderJNI.hcSNSUserScrollDelay, WXHardCoderJNI.hcSNSUserScrollCPU, WXHardCoderJNI.hcSNSUserScrollIO, WXHardCoderJNI.hcSNSUserScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSUserScrollTimeout, 704, WXHardCoderJNI.hcSNSUserScrollAction, "MicroMsg.SnsUserUI");
                C4990ab.m7417i("MicroMsg.SnsUserUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsUserUI.this.ehv));
            }
            AppMethodBeat.m2505o(39802);
        }

        /* renamed from: ad */
        public final void mo25741ad(int i, boolean z) {
            Object obj = null;
            AppMethodBeat.m2504i(39803);
            if (SnsUserUI.this.rCS != null) {
                C46250as a = SnsUserUI.this.rCS;
                if (a.rvw != null) {
                    C39831at c39831at = a.rvw;
                    C46236n DK = C13373af.cnF().mo62914DK(i);
                    if (DK == null || DK.cqu().xfI == null || c39831at.list.size() <= 0) {
                        AppMethodBeat.m2505o(39803);
                        return;
                    }
                    for (int i2 = 0; i2 < c39831at.list.size(); i2++) {
                        if (((C46236n) c39831at.list.get(i2)).cqU() == DK.cqU()) {
                            obj = 1;
                            c39831at.list.remove(i2);
                            break;
                        }
                    }
                    if (obj != null) {
                        c39831at.list.add(DK);
                        c39831at.ctM();
                        c39831at.ctN();
                    }
                }
            }
            AppMethodBeat.m2505o(39803);
        }

        /* renamed from: ln */
        public final void mo25753ln(boolean z) {
        }

        /* renamed from: fA */
        public final void mo25749fA(int i, int i2) {
            AppMethodBeat.m2504i(39804);
            if (i2 <= 0) {
                SnsUserUI.m21833i(SnsUserUI.this);
                AppMethodBeat.m2505o(39804);
                return;
            }
            SnsUserUI.m21824a(SnsUserUI.this, i, i2);
            AppMethodBeat.m2505o(39804);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$3 */
    class C136063 implements OnMenuItemClickListener {
        C136063() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39787);
            Intent intent = new Intent();
            intent.setClass(SnsUserUI.this, SnsMsgUI.class);
            intent.putExtra("sns_msg_force_show_all", true);
            SnsUserUI.this.startActivityForResult(intent, 8);
            AppMethodBeat.m2505o(39787);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$6 */
    class C136076 implements OnClickListener {
        C136076() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$7 */
    class C136087 implements OnMenuItemClickListener {
        C136087() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39790);
            SnsUserUI.this.finish();
            AppMethodBeat.m2505o(39790);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$8 */
    class C136098 implements OnClickListener {
        C136098() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39791);
            dialogInterface.dismiss();
            SnsUserUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(39791);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$9 */
    class C136109 implements OnClickListener {
        C136109() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39792);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(39792);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$a */
    class C13611a extends C4017f {
        private C29199ax rzp = null;

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$a$1 */
        class C136121 implements C36073c {
            C136121() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(39808);
                c44273l.mo70068e(0, SnsUserUI.this.getString(C25738R.string.f9121q4));
                c44273l.mo70068e(1, SnsUserUI.this.getString(C25738R.string.f9126qa));
                AppMethodBeat.m2505o(39808);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$a$2 */
        class C136132 implements C5279d {
            C136132() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(39809);
                switch (menuItem.getItemId()) {
                    case 0:
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(2));
                        SnsUserUI.m21839o(SnsUserUI.this);
                        AppMethodBeat.m2505o(39809);
                        return;
                    case 1:
                        C7060h.pYm.mo8381e(13822, Integer.valueOf(2), Integer.valueOf(2));
                        SnsUserUI.this.rCT.mo25754Em(1);
                        break;
                }
                AppMethodBeat.m2505o(39809);
            }
        }

        C13611a() {
        }

        /* renamed from: fw */
        public void mo8864fw(int i, int i2) {
            AppMethodBeat.m2504i(39810);
            C4990ab.m7417i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(SnsUserUI.this.rjn));
            Intent intent;
            if (SnsUserUI.this.rjn && i2 == -1) {
                C1720g.m3537RQ();
                String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, null);
                if (!C5046bo.isNullOrNil(str)) {
                    C1720g.m3537RQ();
                    String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
                    new C32661ah().mo53150Fs().mo53151fk(str2).ajK();
                    byte[] atV = C8769e.atV(str);
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(atV, 0, atV.length);
                    obtain.setDataPosition(0);
                    try {
                        intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                        intent.addFlags(268435456);
                        intent.setClass(SnsUserUI.this, SnsUploadUI.class);
                        intent.putExtra("KSessionID", str2);
                        SnsUserUI.this.startActivity(intent);
                        AppMethodBeat.m2505o(39810);
                        return;
                    } catch (Exception e) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
                    }
                }
                this.rzp = new C29199ax(SnsUserUI.this);
                this.rzp.rBl = new C136121();
                this.rzp.mo47368c(0, SnsUserUI.this.mController.ylL.getString(C25738R.string.f9124q9));
                this.rzp.rBm = new C136132();
                this.rzp.cuu();
                AppMethodBeat.m2505o(39810);
                return;
            }
            intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
            intent.putExtra("sns_gallery_userName", SnsUserUI.this.igi);
            intent.putExtra("sns_gallery_is_self", SnsUserUI.this.rjn);
            intent.putExtra("sns_gallery_localId", i);
            intent.putExtra("sns_source", SnsUserUI.this.ryE);
            intent.putExtra("sns_gallery_st_time", SnsUserUI.this.rCS.rvy);
            intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.rCS.rvz);
            if (SnsUserUI.this.rCS != null) {
                intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.rCS.lQD);
                SnsUserUI.this.rCU.mo8623j(SnsUserUI.this.igi, SnsUserUI.this.rCS.mo74331fv(i, i2));
                intent.putExtra("sns_gallery_position", SnsUserUI.this.rCS.rvC);
            }
            SnsUserUI.this.startActivityForResult(intent, 8);
            AppMethodBeat.m2505o(39810);
        }

        /* renamed from: fx */
        public final void mo8865fx(int i, int i2) {
            AppMethodBeat.m2504i(39811);
            C46236n DK = C13373af.cnF().mo62914DK(i);
            if (DK == null) {
                AppMethodBeat.m2505o(39811);
            } else if (DK.field_type == 15) {
                Intent intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
                intent.putExtra("sns_gallery_userName", SnsUserUI.this.igi);
                intent.putExtra("sns_gallery_is_self", SnsUserUI.this.rjn);
                intent.putExtra("sns_gallery_localId", i);
                intent.putExtra("sns_source", SnsUserUI.this.ryE);
                intent.putExtra("sns_gallery_st_time", SnsUserUI.this.rCS.rvy);
                intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.rCS.rvz);
                if (SnsUserUI.this.rCS != null) {
                    intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.rCS.lQD);
                    SnsUserUI.this.rCU.mo8623j(SnsUserUI.this.igi, SnsUserUI.this.rCS.mo74331fv(i, i2));
                    intent.putExtra("sns_gallery_position", SnsUserUI.this.rCS.rvC);
                }
                SnsUserUI.this.startActivityForResult(intent, 8);
                AppMethodBeat.m2505o(39811);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", DK.field_userName);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", C35002v.m57490ap("sns_table_", (long) i));
                SnsUserUI.this.startActivityForResult(intent2, 12);
                AppMethodBeat.m2505o(39811);
            }
        }

        /* renamed from: Ed */
        public final void mo8863Ed(int i) {
            AppMethodBeat.m2504i(39812);
            C46236n DK = C13373af.cnF().mo62914DK(i);
            if (DK == null) {
                AppMethodBeat.m2505o(39812);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", DK.field_userName);
            intent.putExtra("INTENT_SNS_LOCAL_ID", C35002v.m57490ap("sns_table_", (long) i));
            SnsUserUI.this.startActivityForResult(intent, 12);
            AppMethodBeat.m2505o(39812);
        }

        /* renamed from: fy */
        public final void mo8866fy(int i, int i2) {
            AppMethodBeat.m2504i(39813);
            C4990ab.m7411d("MicroMsg.SnsUserUI", "onFailLongClick localId:%s position:%s", Integer.valueOf(i), Integer.valueOf(i2));
            C46236n DK = C13373af.cnF().mo62914DK(i);
            if (DK != null && DK.cnn() && DK.cqW()) {
                SnsUserUI.m21826b(SnsUserUI.this, i);
            }
            AppMethodBeat.m2505o(39813);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$14 */
    class C1361414 extends C1153b {
        C1361414() {
        }

        /* renamed from: a */
        public final void mo4386a(String str, long j, int i) {
            AppMethodBeat.m2504i(39805);
            super.mo4386a(str, j, i);
            if (i > 0 && !C5046bo.isNullOrNil(str) && str.endsWith(SnsUserUI.this.getClass().getSimpleName())) {
                SnsUserUI.this.eEO = SnsUserUI.this.eEO + ((long) i);
            }
            AppMethodBeat.m2505o(39805);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$16 */
    class C1361516 extends C13611a {
        C1361516() {
            super();
        }

        /* renamed from: fw */
        public final void mo8864fw(int i, int i2) {
            AppMethodBeat.m2504i(39807);
            super.mo8864fw(i, i2);
            AppMethodBeat.m2505o(39807);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$15 */
    class C1361615 implements Runnable {
        C1361615() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39806);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.topMargin = C40619x.m70065al(SnsUserUI.this) + SnsUserUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9719di);
            SnsUserUI.this.rCW.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(39806);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUserUI$17 */
    class C1361717 implements C35106c {
        C1361717() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsUserUI() {
        AppMethodBeat.m2504i(39814);
        AppMethodBeat.m2505o(39814);
    }

    /* renamed from: o */
    static /* synthetic */ void m21839o(SnsUserUI snsUserUI) {
        AppMethodBeat.m2504i(39831);
        snsUserUI.cuG();
        AppMethodBeat.m2505o(39831);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39815);
        if (this.mController != null) {
            this.mController.mo11176aC(2, false);
        }
        this.ylm = true;
        super.onCreate(bundle);
        if (C1720g.m3534RN().mo5161QY()) {
            C7486a aoO;
            this.plv = findViewById(2131820940);
            if (this.plv != null && C5544c.zzP) {
                C5544c az = C5544c.m8364az(this);
                C136034 c136034 = new C136034();
                this.plx = c136034;
                az.mo11253a(c136034);
                getWindow().getDecorView().requestApplyInsets();
                C5546d.m8368a(getWindow());
            }
            getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
            mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.a3p));
            mo17392b(new C1360411(), new C1360212());
            this.rCU = C13373af.cnv();
            this.ryE = getIntent().getIntExtra("sns_source", 0);
            this.igi = getIntent().getStringExtra("sns_userName");
            if (this.igi == null) {
                this.igi = "";
            }
            C1720g.m3537RQ();
            this.ryD = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(this.igi);
            this.ryC = C1853r.m3846Yz();
            this.rjn = this.ryC.equals(this.igi);
            C7309bd cnt = C13373af.cnt();
            String bc = C5046bo.m7532bc(getIntent().getStringExtra("sns_signature"), "");
            String bc2 = C5046bo.m7532bc(getIntent().getStringExtra("sns_nickName"), "");
            if (this.igi == null || this.igi.equals("")) {
                aoO = cnt.aoO(this.ryC);
            } else {
                aoO = cnt.aoO(this.igi);
            }
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                bc = aoO.signature;
                bc2 = aoO.mo16706Oi();
                C4990ab.m7417i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", aoO.field_username, Integer.valueOf((int) aoO.ewQ), bc2);
            }
            this.rCT = new SnsUIAction(this);
            this.rCT.mo25755a(this.ryC, this.igi, bc2, bc, this.ryD, this.rjn, this.ryE);
            SnsUIAction snsUIAction = this.rCT;
            C1360513 c1360513 = new C1360513();
            this.rCV = c1360513;
            snsUIAction.rBP = c1360513;
            this.rCT.onCreate();
            getIntent().setExtrasClassLoader(getClass().getClassLoader());
            initView();
            C4879a.xxA.mo10052c(this.hAA);
            AppMethodBeat.m2505o(39815);
            return;
        }
        finish();
        AppMethodBeat.m2505o(39815);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39816);
        C13373af.bCo().removeCallbacks(this.rCZ);
        this.ryx = true;
        C4879a.xxA.mo10053d(this.hAA);
        C37952b u = C37952b.m64173u(getIntent());
        if (u != null) {
            u.update();
            u.ajK();
        }
        if (!(this.rCT == null || this.rCT.tipDialog == null)) {
            this.rCT.tipDialog.dismiss();
            this.rCT.tipDialog = null;
        }
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY() && this.rCU != null) {
            this.rCU.mo8619a(this, this.rCV.getType());
        }
        if (this.rCT != null) {
            this.rCT.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(39816);
    }

    public void onDrag() {
        AppMethodBeat.m2504i(39817);
        super.onDrag();
        AppMethodBeat.m2505o(39817);
    }

    public final int getLayoutId() {
        return 2130970795;
    }

    public void onResume() {
        AppMethodBeat.m2504i(39818);
        this.fAq = C5046bo.anT();
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16643a(this.mnM);
            }
        }
        if (this.rCS != null) {
            this.rCS.notifyDataSetChanged();
        }
        setRequestedOrientation(-1);
        if (this.rjn) {
            mo17393b(getString(C25738R.string.emv), (int) C1318a.actionbar_list_icon, (OnMenuItemClickListener) new C136063());
        } else {
            enableOptionMenu(false);
        }
        setBackBtn(this.rzm, C1318a.actionbar_icon_dark_back);
        if (this.rjn) {
            setMMTitle((int) C25738R.string.enj);
        } else {
            CharSequence Oj;
            C4990ab.m7411d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", this.igi, this.rCT.title);
            C7616ad aoO = C13373af.cnt().aoO(this.igi);
            if (aoO != null) {
                C4990ab.m7410d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
                Oj = aoO.mo16707Oj();
            } else {
                C4990ab.m7411d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", this.rCT.title);
                Oj = this.rCT.title;
            }
            setMMTitle(C29036i.m46075K(Oj));
        }
        this.rCT.onResume();
        super.onResume();
        AppMethodBeat.m2505o(39818);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39819);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, this.ehv);
        this.ehv = 0;
        this.rCT.onPause();
        super.onPause();
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16644b(this.mnM);
            }
        }
        this.fAq = C5046bo.anT() > this.fAq ? C5046bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(704, WXHardCoderJNI.hcSNSUserScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.m2505o(39819);
    }

    public final void initView() {
        AppMethodBeat.m2504i(39820);
        this.rCW = (RelativeLayout) findViewById(2131827839);
        this.rCX = (TextView) findViewById(2131827840);
        this.rCW.post(new C1361615());
        this.rCS = new C46250as(this, new C1361516(), this.igi, new C1361717());
        this.rCT.nDp.setAdapter(this.rCS);
        this.rCT.nDp.setOnItemClickListener(new C1360018());
        this.rCT.nDp.postDelayed(new C40132(), 500);
        setBackBtn(this.rzm, C1318a.actionbar_icon_dark_back);
        AppMethodBeat.m2505o(39820);
    }

    /* renamed from: a */
    public final void mo17657a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.m2504i(39821);
        if (this.rCS != null) {
            this.rCS.rmL = str;
            if (str.compareTo(this.rCS.lQD) < 0) {
                C4990ab.m7417i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", str, this.rCS.lQD, Boolean.valueOf(z));
                this.rCS.ctK();
            } else {
                C4990ab.m7417i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", str, this.rCS.lQD, Boolean.valueOf(z));
            }
            this.rCS.crP();
        }
        if ((z4 || !C5046bo.isNullOrNil(str2)) && !this.ryC.equals(this.igi)) {
            this.rCT.koC = true;
            this.rCT.mo25757bf(i, str2);
        } else {
            if (this.ryC.equals(this.igi) && j != 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
                this.rCS.mo74338kI(j);
            }
            this.rCT.koC = z2;
            if (z2) {
                this.rCT.mo25760lc(false);
            } else if (z) {
                this.rCU.mo8620b(this.rCV.getType(), this.igi, this.rjn, this.ryE);
            }
        }
        if (z3) {
            this.rCT.qQt.cti();
        }
        AppMethodBeat.m2505o(39821);
    }

    /* renamed from: a */
    public final void mo17656a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
        AppMethodBeat.m2504i(39822);
        C13373af.bCo().removeCallbacks(this.rCZ);
        if (this.rCS != null) {
            this.rCS.rvv = z2;
            this.rCS.rmL = str;
            if (str.compareTo(this.rCS.lQD) < 0) {
                C4990ab.m7417i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", str, this.rCS.lQD);
                this.rCS.ctK();
            } else {
                C4990ab.m7417i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", str, this.rCS.lQD);
            }
            this.rCS.crP();
        }
        if (!z3 || this.ryC.equals(this.igi)) {
            if (this.ryC.equals(this.igi) && j != 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
                this.rCS.mo74338kI(j);
            }
            this.rCT.koC = z;
            if (z) {
                this.rCT.mo25760lc(false);
            }
            AppMethodBeat.m2505o(39822);
            return;
        }
        this.rCT.koC = true;
        this.rCT.mo25757bf(i, str2);
        AppMethodBeat.m2505o(39822);
    }

    /* renamed from: xE */
    public final void mo17446xE(int i) {
        AppMethodBeat.m2504i(39823);
        super.mo17446xE(i);
        if (VERSION.SDK_INT >= 21 && this.plv != null) {
            this.plv.setBackgroundColor(getWindow().getStatusBarColor());
            C5546d.m8368a(getWindow());
        }
        AppMethodBeat.m2505o(39823);
    }

    private void cuG() {
        AppMethodBeat.m2504i(39824);
        if (C35973a.m59177bH(this)) {
            AppMethodBeat.m2505o(39824);
            return;
        }
        C4990ab.m7411d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 18, "", "")), C5046bo.dpG(), this);
        if (C35805b.m58707a(this, "android.permission.CAMERA", 18, "", "")) {
            C4990ab.m7411d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 18, "", "")), C5046bo.dpG(), this);
            if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                C14987n.m23293G(this.mController.ylL, new Intent());
                AppMethodBeat.m2505o(39824);
                return;
            }
            AppMethodBeat.m2505o(39824);
            return;
        }
        AppMethodBeat.m2505o(39824);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(39825);
        finish();
        AppMethodBeat.m2505o(39825);
    }

    public boolean supportNavigationSwipeBack() {
        AppMethodBeat.m2504i(39826);
        boolean supportNavigationSwipeBack = super.supportNavigationSwipeBack();
        AppMethodBeat.m2505o(39826);
        return supportNavigationSwipeBack;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39827);
        C4990ab.m7417i("MicroMsg.SnsUserUI", "on activity result, %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (5985 == i && i2 == -1) {
            finish();
            AppMethodBeat.m2505o(39827);
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.rCT.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(39827);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(39828);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.SnsUserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(39828);
            return;
        }
        C4990ab.m7417i("MicroMsg.SnsUserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 18:
                if (iArr[0] != 0) {
                    int i2 = "android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0;
                    if (iArr[0] != 0) {
                        C30379h.m48445a((Context) this, getString(i2), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C136098(), new C136109());
                        break;
                    }
                }
                cuG();
                AppMethodBeat.m2505o(39828);
                return;
                break;
        }
        AppMethodBeat.m2505o(39828);
    }

    /* renamed from: i */
    static /* synthetic */ void m21833i(SnsUserUI snsUserUI) {
        AppMethodBeat.m2504i(39829);
        snsUserUI.rCW.setVisibility(8);
        AppMethodBeat.m2505o(39829);
    }

    /* renamed from: a */
    static /* synthetic */ void m21824a(SnsUserUI snsUserUI, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(39830);
        C46250as c46250as = snsUserUI.rCS;
        if (c46250as.rgf.get(Integer.valueOf(i)) == null) {
            i3 = -1;
        } else {
            i3 = ((Integer) c46250as.rgf.get(Integer.valueOf(i))).intValue();
        }
        C4990ab.m7411d("MicroMsg.SnsUserUI", "displayYearTip position:%d alpha:%d realPos:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            Object item = snsUserUI.rCS.getItem(i3);
            if (item != null && (item instanceof C46236n)) {
                float f = ((float) i2) / 100.0f;
                if (f != snsUserUI.rCW.getAlpha()) {
                    snsUserUI.rCW.setAlpha(f);
                }
                snsUserUI.rCW.setVisibility(0);
                C46236n c46236n = (C46236n) item;
                if (snsUserUI.rCY != c46236n.field_head / Downloads.MIN_WAIT_FOR_NETWORK) {
                    snsUserUI.rCY = c46236n.field_head / Downloads.MIN_WAIT_FOR_NETWORK;
                    snsUserUI.rCX.setText(String.format(snsUserUI.getResources().getString(C25738R.string.eqj), new Object[]{Integer.valueOf(snsUserUI.rCY)}));
                }
            }
        }
        AppMethodBeat.m2505o(39830);
    }

    /* renamed from: b */
    static /* synthetic */ void m21826b(SnsUserUI snsUserUI, final int i) {
        AppMethodBeat.m2504i(39832);
        C30379h.m48428a((Context) snsUserUI, (int) C25738R.string.f9089p5, (int) C25738R.string.f9238tz, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39789);
                C13373af.cnF().mo62915DL(i);
                SnsUserUI.this.rCS.crP();
                AppMethodBeat.m2505o(39789);
            }
        }, new C136076());
        AppMethodBeat.m2505o(39832);
    }
}
