package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p174e.C1153b;
import com.tencent.matrix.trace.p175f.C7469c;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.data.SnsCmdList;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13428m;
import com.tencent.p177mm.plugin.sns.model.C39761q;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAvatarImageView;
import com.tencent.p177mm.plugin.sns.storage.C21992j;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.ata;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI */
public class SnsMsgUI extends MMActivity implements C1202f, C43559b {
    private long eEO = 0;
    private int ehv;
    private long fAq = 0;
    private String fsg;
    private C7306ak handler = C13373af.bCo();
    private C5279d jKa = new C350265();
    private View kmS;
    private View kmT = null;
    private boolean kmU = false;
    private int[] mkD = new int[2];
    private C1153b mnM = new C712510();
    private ListView nDp;
    private View nDr;
    long qQp;
    int rfb;
    private C22062an rhs;
    private SnsCmdList rjk = new SnsCmdList();
    private C7309bd rqa;
    private C35031a rtT;
    private boolean rtU = false;
    private boolean rtV = false;
    private boolean rtW = false;
    private C44275p rtX;
    private OnClickListener rtY = new C39901();
    private C4931a rtZ = new C350298();
    Runnable rua = new C39929();

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$11 */
    class C398711 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$11$1 */
        class C39881 implements DialogInterface.OnClickListener {
            C39881() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39076);
                SnsMsgUI.this.nDp.setVisibility(8);
                SnsMsgUI.this.nDr.setVisibility(0);
                C13373af.cnK().fni.mo10108hY("SnsComment", "delete from SnsComment");
                SnsMsgUI.this.enableOptionMenu(false);
                AppMethodBeat.m2505o(39076);
            }
        }

        C398711() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39077);
            C30379h.m48440a(SnsMsgUI.this.mController.ylL, SnsMsgUI.this.getString(C25738R.string.emw), "", new C39881(), null);
            AppMethodBeat.m2505o(39077);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$12 */
    class C398912 implements C15521c {
        C398912() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(39078);
            int positionForView = SnsMsgUI.this.nDp.getPositionForView(view);
            AppMethodBeat.m2505o(39078);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$1 */
    class C39901 implements OnClickListener {
        C39901() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39065);
            if (view.getTag() instanceof C29190ao) {
                SnsMsgUI.this.rhs.mo37617t(view, -1, 1);
                AppMethodBeat.m2505o(39065);
            } else if (view.getTag() instanceof C21992j) {
                SnsMsgUI.m68151a(SnsMsgUI.this, (C21992j) view.getTag());
                AppMethodBeat.m2505o(39065);
            } else {
                C4990ab.m7420w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
                AppMethodBeat.m2505o(39065);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$2 */
    class C39912 implements OnItemLongClickListener {
        C39912() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(39066);
            if (i < SnsMsgUI.this.nDp.getHeaderViewsCount()) {
                C4990ab.m7420w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
                AppMethodBeat.m2505o(39066);
                return true;
            }
            new C24088a(SnsMsgUI.this).mo39885a(view, i, j, SnsMsgUI.this, SnsMsgUI.this.jKa, SnsMsgUI.this.mkD[0], SnsMsgUI.this.mkD[1]);
            AppMethodBeat.m2505o(39066);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$9 */
    class C39929 implements Runnable {
        C39929() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39074);
            if (SnsMsgUI.this.rtT == null) {
                AppMethodBeat.m2505o(39074);
                return;
            }
            synchronized (SnsMsgUI.this.rtT) {
                try {
                    SnsMsgUI.this.rtT.mo5248a(null, null);
                    SnsMsgUI.this.rtU = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(39074);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$10 */
    class C712510 extends C1153b {
        C712510() {
        }

        /* renamed from: a */
        public final void mo4386a(String str, long j, int i) {
            AppMethodBeat.m2504i(39075);
            super.mo4386a(str, j, i);
            if (i > 0 && !C5046bo.isNullOrNil(str) && str.endsWith(SnsMsgUI.this.getClass().getSimpleName())) {
                SnsMsgUI.this.eEO = SnsMsgUI.this.eEO + ((long) i);
            }
            AppMethodBeat.m2505o(39075);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$3 */
    class C135403 implements OnScrollListener {
        C135403() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(39067);
            if (SnsMsgUI.this.kmU) {
                C4990ab.m7417i("MicroMsg.SnsMsgUI", "onListViewScoll %s", Integer.valueOf(i));
                if (i == 2) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, SnsMsgUI.this.ehv);
                    SnsMsgUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, WXHardCoderJNI.hcSNSMsgScrollDelay, WXHardCoderJNI.hcSNSMsgScrollCPU, WXHardCoderJNI.hcSNSMsgScrollIO, WXHardCoderJNI.hcSNSMsgScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSMsgScrollTimeout, 705, WXHardCoderJNI.hcSNSMsgScrollAction, "MicroMsg.SnsMsgUI");
                    C4990ab.m7417i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsMsgUI.this.ehv));
                }
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (C13373af.cnK().baS() > 0) {
                        C13373af.cnK().baT();
                    } else {
                        SnsMsgUI.this.rtT.bdo();
                    }
                    SnsMsgUI.this.rtT.mo5248a(null, null);
                    AppMethodBeat.m2505o(39067);
                    return;
                }
                AppMethodBeat.m2505o(39067);
                return;
            }
            AppMethodBeat.m2505o(39067);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$14 */
    class C3502214 implements C23599f {
        C3502214() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(39080);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.SnsMsgUI", "onItemDel object null");
                AppMethodBeat.m2505o(39080);
                return;
            }
            try {
                SnsMsgUI.m68150a(SnsMsgUI.this, C5046bo.ank(obj.toString()));
                AppMethodBeat.m2505o(39080);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SnsMsgUI", "onItemDel object not int");
                C4990ab.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(39080);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$15 */
    class C3502315 implements C30723a {
        C3502315() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(39081);
            C4990ab.m7418v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.this.rtT.enb + " unread:" + C13373af.cnK().baS() + "  showcount:" + SnsMsgUI.this.rtT.kmW);
            if (SnsMsgUI.this.rtT.getCount() == 0) {
                SnsMsgUI.this.nDp.setVisibility(8);
                SnsMsgUI.this.nDr.setVisibility(0);
                SnsMsgUI.this.enableOptionMenu(false);
            } else {
                SnsMsgUI.this.nDp.setVisibility(0);
                SnsMsgUI.this.nDr.setVisibility(8);
                SnsMsgUI.this.enableOptionMenu(true);
            }
            if ((SnsMsgUI.this.rtT.bdn() && C13373af.cnK().baS() == 0) || C13373af.cnK().baS() == C13373af.cnK().cqG()) {
                SnsMsgUI.this.kmS.setVisibility(8);
            }
            AppMethodBeat.m2505o(39081);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$17 */
    class C3502417 implements OnTouchListener {
        C3502417() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39083);
            switch (motionEvent.getAction()) {
                case 0:
                    SnsMsgUI.this.aqX();
                    SnsMsgUI.this.mkD[0] = (int) motionEvent.getRawX();
                    SnsMsgUI.this.mkD[1] = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(39083);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$4 */
    class C350254 implements OnMenuItemClickListener {
        C350254() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39068);
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", SnsMsgUI.this.rjk);
            SnsMsgUI.this.setResult(-1, intent);
            SnsMsgUI.this.finish();
            AppMethodBeat.m2505o(39068);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$5 */
    class C350265 implements C5279d {
        C350265() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(39069);
            switch (menuItem.getItemId()) {
                case 0:
                    SnsMsgUI.m68150a(SnsMsgUI.this, SnsMsgUI.this.rfb);
                    AppMethodBeat.m2505o(39069);
                    return;
                case 1:
                    SnsMsgUI.m68167n(SnsMsgUI.this);
                    AppMethodBeat.m2505o(39069);
                    return;
                case 2:
                    SnsMsgUI.m68152a(SnsMsgUI.this, false);
                    break;
            }
            AppMethodBeat.m2505o(39069);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$7 */
    class C350287 implements DialogInterface.OnClickListener {
        C350287() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39071);
            SnsMsgUI.m68152a(SnsMsgUI.this, true);
            AppMethodBeat.m2505o(39071);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$8 */
    class C350298 implements C4931a {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$8$1 */
        class C350301 implements Runnable {
            C350301() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39072);
                synchronized (SnsMsgUI.this.rtT) {
                    try {
                        C4990ab.m7418v("MicroMsg.SnsMsgUI", "comment notify");
                        SnsMsgUI.this.rtV = true;
                        SnsMsgUI.this.rtT.mo5248a(null, null);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(39072);
                    }
                }
            }
        }

        C350298() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(39073);
            C13373af.bCo().post(new C350301());
            AppMethodBeat.m2505o(39073);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$a */
    class C35031a extends C46692p<C21992j> {
        int enb = this.kmW;
        protected C23600g jJO;
        protected C15521c jJP;
        protected C23597d jJR = new C135411();
        int kmW = 10;
        private Set<MMSlideDelView> nDv = new HashSet();
        protected C23599f ruf;

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$a$1 */
        class C135411 implements C23597d {
            C135411() {
            }

            /* renamed from: a */
            public final void mo25718a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.m2504i(39084);
                if (z) {
                    nDv.add(mMSlideDelView);
                    AppMethodBeat.m2505o(39084);
                    return;
                }
                nDv.remove(mMSlideDelView);
                AppMethodBeat.m2505o(39084);
            }

            public final boolean bIo() {
                AppMethodBeat.m2504i(39085);
                if (nDv.size() > 0) {
                    AppMethodBeat.m2505o(39085);
                    return true;
                }
                AppMethodBeat.m2505o(39085);
                return false;
            }

            public final void bIp() {
                AppMethodBeat.m2504i(39086);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzZ();
                    }
                }
                nDv.clear();
                AppMethodBeat.m2505o(39086);
            }

            public final void bIq() {
                AppMethodBeat.m2504i(39087);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzY();
                    }
                }
                nDv.clear();
                AppMethodBeat.m2505o(39087);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$a$a */
        class C35033a {
            long cND;
            View jJW;
            TextView jJX;
            TextView pnE;
            SnsAvatarImageView ruh;
            TextView rui;
            ImageView ruj;
            TextView ruk;
            MMImageView rul;
            ImageView rum;
            TextView timeTv;

            C35033a() {
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$a$2 */
        class C350342 implements OnClickListener {
            C350342() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39088);
                C4990ab.m7418v("MicroMsg.SnsMsgUI", "on delView clicked");
                C35031a.this.jJR.bIq();
                if (C35031a.this.ruf != null) {
                    C35031a.this.ruf.mo11067bN(view.getTag());
                }
                AppMethodBeat.m2505o(39088);
            }
        }

        public C35031a(Context context, C21992j c21992j) {
            super(context, c21992j);
            AppMethodBeat.m2504i(39090);
            AppMethodBeat.m2505o(39090);
        }

        public final long getItemId(int i) {
            AppMethodBeat.m2504i(39091);
            long j = ((C21992j) getItem(i)).field_snsID;
            AppMethodBeat.m2505o(39091);
            return j;
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(39092);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(39092);
        }

        public final void setPerformItemClickListener(C23600g c23600g) {
            this.jJO = c23600g;
        }

        /* renamed from: b */
        public final void mo55663b(C23599f c23599f) {
            this.ruf = c23599f;
        }

        public final void setGetViewPositionCallback(C15521c c15521c) {
            this.jJP = c15521c;
        }

        /* renamed from: a */
        public final synchronized void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(39093);
            super.mo5248a(str, c4935m);
            AppMethodBeat.m2505o(39093);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(39094);
            if (C13373af.cnK().baS() <= 0 || SnsMsgUI.this.rtV) {
                this.enb = C13373af.cnK().cqG();
                setCursor(C13373af.cnK().mo47200DH(this.kmW));
            } else {
                setCursor(C13373af.cnK().cqF());
            }
            notifyDataSetChanged();
            AppMethodBeat.m2505o(39094);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int bdo() {
            AppMethodBeat.m2504i(39095);
            if (bdn()) {
                if (SnsMsgUI.this.kmT.getParent() != null) {
                    SnsMsgUI.this.nDp.removeFooterView(SnsMsgUI.this.kmT);
                }
                AppMethodBeat.m2505o(39095);
                return 0;
            }
            this.kmW += 10;
            if (this.kmW <= this.enb) {
                AppMethodBeat.m2505o(39095);
                return 10;
            }
            this.kmW = this.enb;
            int i = this.enb % 10;
            AppMethodBeat.m2505o(39095);
            return i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:87:0x032e A:{SYNTHETIC, Splitter:B:87:0x032e} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0140 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0339 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0362 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x035f A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0365 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0368 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x03b1 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01f5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x03b4 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01f8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0248 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x0868 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0273 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x08d5  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x02ce  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x08d9  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x02e0  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0140 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x032e A:{SYNTHETIC, Splitter:B:87:0x032e} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0339 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x01b0 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0362 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x035f A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0365 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0368 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x01d8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01f5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x03b1 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01f8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x03b4 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0230 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0248 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0273 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x0868 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x02ba  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x02ce  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x08d5  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x02e0  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x08d9  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x032e A:{SYNTHETIC, Splitter:B:87:0x032e} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0140 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0339 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x01b0 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0362 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x035f A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0365 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0368 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x01d8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x03b1 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01f5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x03b4 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01f8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0230 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0248 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x0868 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0273 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x02ba  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x08d5  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x02ce  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x08d9  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x02e0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C35033a c35033a;
            AppMethodBeat.m2504i(39096);
            C21992j c21992j = (C21992j) getItem(i);
            if (view == null || !(view.getTag() instanceof C35033a)) {
                View view2 = (MMSlideDelView) C5616v.m8409hu(this.context).inflate(2130968832, null);
                View inflate = C5616v.m8409hu(this.context).inflate(2130970782, null);
                C35033a c35033a2 = new C35033a();
                c35033a2.ruh = (SnsAvatarImageView) inflate.findViewById(2131827799);
                c35033a2.ruh.setWeakContext(this.context);
                c35033a2.pnE = (TextView) inflate.findViewById(2131827800);
                c35033a2.ruk = (TextView) inflate.findViewById(2131827802);
                c35033a2.ruj = (ImageView) inflate.findViewById(2131827801);
                c35033a2.timeTv = (TextView) inflate.findViewById(2131827803);
                c35033a2.rul = (MMImageView) inflate.findViewById(2131827806);
                c35033a2.rui = (TextView) inflate.findViewById(2131827808);
                c35033a2.rul.setOnClickListener(SnsMsgUI.this.rtY);
                c35033a2.jJW = view2.findViewById(2131821704);
                c35033a2.jJX = (TextView) view2.findViewById(2131821082);
                c35033a2.rum = (ImageView) inflate.findViewById(2131827807);
                view2.setView(inflate);
                view2.setPerformItemClickListener(this.jJO);
                view2.setGetViewPositionCallback(this.jJP);
                view2.setItemStatusCallBack(this.jJR);
                view2.setEnable(false);
                view2.setTag(c35033a2);
                c35033a = c35033a2;
                view = view2;
            } else {
                c35033a = (C35033a) view.getTag();
            }
            c35033a.rul.setTag(null);
            c35033a.cND = c21992j.field_snsID;
            c35033a.jJW.setTag(Integer.valueOf(c21992j.rfb));
            c35033a.jJW.setOnClickListener(new C350342());
            String str = "";
            can can = (can) new can().parseFrom(c21992j.field_curActionBuf);
            String str2;
            final String str3;
            C7616ad aoO;
            CharSequence Oj;
            C46236n kD;
            TextView textView;
            int i2;
            Object obj;
            TextView textView2;
            C43570e ku;
            C46236n c46236n;
            Object obj2;
            try {
                str2 = ((can) new can().parseFrom(c21992j.field_refActionBuf)).wPm;
                try {
                    if (C5046bo.isNullOrNil(str2) || str2.equals(C13373af.cnk())) {
                        str = "";
                        try {
                            if (C5046bo.isNullOrNil(can.wPm)) {
                                C40460b.m69434b(c35033a.ruh, can.wPm);
                                str3 = can.wPm;
                                c35033a.ruh.mo55778dk(str3, 6);
                                if (C5046bo.isEqual(SnsMsgUI.this.fsg, str3)) {
                                    c35033a.ruh.setShowStoryHint(false);
                                } else {
                                    SnsAvatarImageView snsAvatarImageView = c35033a.ruh;
                                    C1720g.m3537RQ();
                                    snsAvatarImageView.setShowStoryHint(((C35168e) C1720g.m3530M(C35168e.class)).hasNewStory(str3));
                                }
                                c35033a.ruh.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.m2504i(39089);
                                        Intent intent = new Intent();
                                        intent.putExtra("Contact_User", str3);
                                        intent.putExtra("CONTACT_INFO_UI_SOURCE", 11);
                                        C24826a.gkE.mo38912c(intent, SnsMsgUI.this);
                                        SnsMsgUI.m68173t(SnsMsgUI.this);
                                        AppMethodBeat.m2505o(39089);
                                    }
                                });
                            } else {
                                C4990ab.m7412e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                            }
                            aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                            if (aoO == null) {
                                Oj = aoO.mo16707Oj();
                            } else if (C5046bo.isNullOrNil(can.wZD)) {
                                Oj = can.wPm;
                            } else {
                                Oj = can.wZD;
                            }
                            c35033a.pnE.setText(C44089j.m79293b(SnsMsgUI.this, Oj, c35033a.pnE.getTextSize()));
                            kD = C13373af.cnF().mo62941kD(c21992j.field_snsID);
                            if (kD == null && kD.field_type == 21) {
                                c35033a.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(C25738R.color.a0s));
                            } else {
                                c35033a.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(C25738R.color.a0k));
                            }
                            str3 = can.wPm;
                            textView = c35033a.pnE;
                            i2 = can.vFH;
                            switch (c21992j.field_type) {
                                case 1:
                                case 2:
                                    obj = null;
                                    break;
                                case 3:
                                case 5:
                                    obj = 1;
                                    break;
                                case 4:
                                    obj = null;
                                    break;
                                case 7:
                                case 8:
                                case 13:
                                case 14:
                                case 16:
                                    obj = null;
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                            if (obj != null || SnsMsgUI.this.fsg.equals(str3)) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            } else {
                                Drawable g;
                                switch (i2) {
                                    case 18:
                                        g = C1338a.m2864g(this.context, C25738R.drawable.al5);
                                        break;
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 26:
                                    case 27:
                                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                    case 29:
                                        g = C1338a.m2864g(this.context, C25738R.drawable.al7);
                                        break;
                                    case 25:
                                        g = C1338a.m2864g(this.context, C25738R.drawable.al3);
                                        break;
                                    case 30:
                                        g = C1338a.m2864g(this.context, C25738R.drawable.al4);
                                        break;
                                    default:
                                        g = C1338a.m2864g(this.context, C25738R.drawable.al6);
                                        break;
                                }
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, g, null);
                            }
                            textView2 = c35033a.ruk;
                            if ((c21992j.field_commentflag & 1) <= 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                textView2.setTextColor(SnsMsgUI.this.getResources().getColor(C25738R.color.f11782h4));
                                textView2.setBackgroundDrawable(null);
                                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                                textView2.setText("");
                                textView2.setCompoundDrawablePadding(0);
                                Drawable g2;
                                SpannableString spannableString;
                                String str4;
                                C43570e ku2;
                                switch (can.jCt) {
                                    case 1:
                                    case 5:
                                        kD = C13373af.cnF().mo62941kD(c21992j.field_snsID);
                                        if (kD != null && kD.field_type == 7) {
                                            textView2.setText(SnsMsgUI.this.getString(C25738R.string.em6));
                                            break;
                                        }
                                        g2 = C1338a.m2864g(this.context, C1318a.friendactivity_likeicon);
                                        if (kD == null || kD.field_type != 21) {
                                            g2.clearColorFilter();
                                        } else {
                                            g2.setColorFilter(SnsMsgUI.this.getResources().getColor(C25738R.color.a0w), Mode.SRC_ATOP);
                                        }
                                        g2.setBounds(0, 0, g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                        spannableString = new SpannableString(" ");
                                        spannableString.setSpan(new ImageSpan(g2), 0, 1, 18);
                                        textView2.setText(spannableString);
                                        textView2.setContentDescription(SnsMsgUI.this.mController.ylL.getString(C25738R.string.eks));
                                        break;
                                    case 2:
                                    case 3:
                                        str4 = can.ncM;
                                        str2 = "";
                                        ku2 = C13373af.cnI().mo69174ku(c21992j.field_snsID);
                                        if (C39851d.m68264fF(can.wZL, 1)) {
                                            if (ku2 != null) {
                                                C1720g.m3537RQ();
                                                aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(ku2.field_userName);
                                                str2 = this.context.getString(C25738R.string.en1, new Object[]{aoO.mo16707Oj()});
                                            }
                                        } else if (!C5046bo.isNullOrNil(str)) {
                                            str2 = this.context.getString(C25738R.string.en2, new Object[]{str});
                                        }
                                        textView2.setText(C44089j.m79293b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                        break;
                                    case 4:
                                        textView2.setText(SnsMsgUI.this.getString(C25738R.string.eq3));
                                        break;
                                    case 7:
                                        textView2.setCompoundDrawablesWithIntrinsicBounds(C1338a.m2864g(this.context, C1318a.friendactivity_likeicon), null, null, null);
                                        textView2.setContentDescription(SnsMsgUI.this.mController.ylL.getString(C25738R.string.eks));
                                        break;
                                    case 8:
                                        str2 = "";
                                        str4 = C5046bo.nullAsNil(can.ncM);
                                        ku2 = C13373af.cnI().mo69174ku(c21992j.field_snsID);
                                        if (C39851d.m68264fF(can.wZL, 1)) {
                                            if (ku2 != null) {
                                                C1720g.m3537RQ();
                                                aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(ku2.field_userName);
                                                str2 = this.context.getString(C25738R.string.en1, new Object[]{aoO.mo16707Oj()});
                                            }
                                        } else if (!C5046bo.isNullOrNil(str)) {
                                            str2 = this.context.getString(C25738R.string.en2, new Object[]{str});
                                        }
                                        textView2.setText(C44089j.m79293b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                        break;
                                    case 13:
                                        ata ata = new ata();
                                        C4990ab.m7416i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + can.wZK);
                                        try {
                                            ata.parseFrom(C1946aa.m4150a(can.wZK));
                                            C4990ab.m7416i("MicroMsg.SnsMsgUI", "hbbuffer  " + ata.cSh);
                                        } catch (Exception e) {
                                            C4990ab.m7412e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e.getMessage());
                                        }
                                        SnsMsgUI.this.rqa.aoO(can.wPm);
                                        g2 = null;
                                        if (ata.cSh == 0) {
                                            SnsMsgUI.this.rtW = true;
                                            spannableString = new SpannableString(SnsMsgUI.this.getString(C25738R.string.cpo));
                                        } else {
                                            SnsMsgUI.this.rtW = false;
                                            spannableString = new SpannableString(" " + SnsMsgUI.this.getString(C25738R.string.cpn, new Object[]{C5046bo.m7501F(((double) ata.cSh) / 100.0d)}));
                                            g2 = SnsMsgUI.this.getResources().getDrawable(C25738R.drawable.f6346b5);
                                        }
                                        if (g2 != null) {
                                            g2.setBounds(0, 0, g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                            C5664a c5664a = new C5664a(g2);
                                            c5664a.zLT = (int) (((((float) g2.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) C1338a.fromDPToPix(SnsMsgUI.this, 2))) / 2.0f);
                                            spannableString.setSpan(c5664a, 0, 1, 33);
                                        }
                                        textView2.setText(spannableString);
                                        break;
                                    case 14:
                                        ata ata2 = new ata();
                                        C4990ab.m7416i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + can.wZK);
                                        try {
                                            ata2.parseFrom(C1946aa.m4150a(can.wZK));
                                            C4990ab.m7416i("MicroMsg.SnsMsgUI", "hbbuffer  " + ata2.cSh);
                                        } catch (Exception e2) {
                                            C4990ab.m7412e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2.getMessage());
                                        }
                                        aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                                        textView2.setText(SnsMsgUI.this.getString(C25738R.string.cpl, new Object[]{aoO.mo16707Oj(), C5046bo.m7501F(((double) ata2.cSh) / 100.0d)}));
                                        break;
                                    case 16:
                                        textView2.setText(C44089j.m79293b(SnsMsgUI.this, ("" + "[" + SnsMsgUI.this.getString(C25738R.string.eix) + "]") + " " + C5046bo.nullAsNil(can.ncM), textView2.getTextSize()));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            textView2.setText(C25738R.string.emx);
                            textView2.setBackgroundColor(SnsMsgUI.this.getResources().getColor(C25738R.color.f11900l2));
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            c35033a.timeTv.setText(C29198aw.m46376l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                            kD = null;
                            if (can.jCt != 7 || can.jCt == 8 || can.jCt == 16) {
                                ku = C13373af.cnI().mo69174ku(c21992j.field_snsID);
                                if (ku != null) {
                                    kD = ku.cqB();
                                }
                                c46236n = kD;
                            } else {
                                c46236n = C13373af.cnF().mo62941kD(c21992j.field_snsID);
                            }
                            c35033a.rul.setVisibility(8);
                            c35033a.rui.setVisibility(8);
                            c35033a.rum.setVisibility(8);
                            c35033a.rul.setImageBitmap(null);
                            C13373af.cnC().mo37461dB(c35033a.rul);
                            if (c46236n == null) {
                                LinkedList linkedList = c46236n.cqu().xfI.wbK;
                                if (c46236n.field_type == 2) {
                                    c35033a.rul.setTag(null);
                                    c35033a.rui.setVisibility(0);
                                    c35033a.rui.setText(C44089j.m79293b(SnsMsgUI.this, c46236n.cqu().xfF, c35033a.rui.getTextSize()));
                                } else {
                                    int i3;
                                    MMImageView mMImageView;
                                    obj2 = null;
                                    if (linkedList.size() > 0) {
                                        i3 = c46236n.field_type;
                                        mMImageView = c35033a.rul;
                                        int i4 = -1;
                                        switch (i3) {
                                            case 1:
                                                i4 = C25738R.drawable.avp;
                                                break;
                                            case 2:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            case 3:
                                                i4 = C1318a.app_attach_file_icon_webpage;
                                                break;
                                            case 4:
                                                i4 = C1318a.app_attach_file_icon_music;
                                                break;
                                            case 5:
                                            case 15:
                                                i4 = C1318a.app_attach_file_icon_video;
                                                break;
                                            case 6:
                                                i4 = C1318a.app_attach_file_icon_location;
                                                break;
                                            case 7:
                                                i4 = C25738R.drawable.avp;
                                                break;
                                            case 8:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            default:
                                                i4 = C1318a.app_attach_file_icon_webpage;
                                                break;
                                        }
                                        C13373af.cnC().mo37440a((bau) linkedList.get(0), c35033a.rul, i4, SnsMsgUI.this.hashCode(), C44222az.xYS);
                                        if (c46236n.field_type == 15 || (c46236n.field_type == 27 && linkedList.size() > 0 && ((bau) linkedList.get(0)).jCt == 6)) {
                                            c35033a.rum.setVisibility(0);
                                            C21992j c21992j2 = new C21992j();
                                            C13373af.cnK().mo16761b(c21992j.xDa, (C4925c) c21992j2);
                                            c35033a.rul.setTag(c21992j2);
                                            obj2 = 1;
                                        } else {
                                            C29190ao c29190ao = new C29190ao();
                                            c29190ao.czD = c46236n.cqU();
                                            c29190ao.index = 0;
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(c35033a.rul);
                                            c29190ao.rsl = arrayList;
                                            c29190ao.position = i;
                                            c35033a.rul.setTag(c29190ao);
                                            i3 = 1;
                                        }
                                    }
                                    mMImageView = c35033a.rul;
                                    if (obj2 != null) {
                                        i3 = 0;
                                    } else {
                                        i3 = 8;
                                    }
                                    mMImageView.setVisibility(i3);
                                }
                            } else if (!(can.jCt == 7 || can.jCt == 8)) {
                                if (can.jCt == 16) {
                                    if (C13428m.m21567kc(c21992j.field_snsID)) {
                                        if (can.vFa != null) {
                                            C4990ab.m7417i("MicroMsg.SnsMsgUI", "atFriend detail, aid %d", Integer.valueOf(can.vFa.wTz));
                                        }
                                        C1207m c13428m = new C13428m(c21992j.field_snsID, can.vFa);
                                        C1720g.m3537RQ();
                                        C1720g.m3535RO().eJo.mo14541a(c13428m, 0);
                                    }
                                } else if (C39761q.m68004kf(c21992j.field_snsID)) {
                                    C1720g.m3537RQ();
                                    C1720g.m3535RO().eJo.mo14541a(new C39761q(c21992j.field_snsID), 0);
                                }
                            }
                        } catch (Exception e3) {
                            C4990ab.printErrStackTrace("MicroMsg.SnsMsgUI", e3, "", new Object[0]);
                        }
                        obj2 = (c35033a.rul.getVisibility() != 0 || c35033a.rum.getVisibility() == 0) ? 1 : null;
                        view.findViewById(2131827805).setVisibility(obj2 == null ? 0 : 8);
                        view.findViewById(2131827804).setVisibility(c21992j.field_isSilence != 1 ? 0 : 8);
                        AppMethodBeat.m2505o(39096);
                        return view;
                    }
                    C7616ad aoO2 = SnsMsgUI.this.rqa.aoO(str2);
                    if (!(aoO2 == null || C5046bo.isNullOrNil(aoO2.mo16707Oj()))) {
                        str2 = aoO2.mo16707Oj();
                    }
                    str = str2;
                    if (C5046bo.isNullOrNil(can.wPm)) {
                    }
                    aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                    if (aoO == null) {
                    }
                    c35033a.pnE.setText(C44089j.m79293b(SnsMsgUI.this, Oj, c35033a.pnE.getTextSize()));
                    kD = C13373af.cnF().mo62941kD(c21992j.field_snsID);
                    if (kD == null) {
                    }
                    c35033a.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(C25738R.color.a0k));
                    str3 = can.wPm;
                    textView = c35033a.pnE;
                    i2 = can.vFH;
                    switch (c21992j.field_type) {
                        case 1:
                        case 2:
                            break;
                        case 3:
                        case 5:
                            break;
                        case 4:
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                        case 16:
                            break;
                        default:
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = c35033a.ruk;
                    if ((c21992j.field_commentflag & 1) <= 0) {
                    }
                    if (obj != null) {
                    }
                    c35033a.timeTv.setText(C29198aw.m46376l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                    kD = null;
                    if (can.jCt != 7) {
                    }
                    ku = C13373af.cnI().mo69174ku(c21992j.field_snsID);
                    if (ku != null) {
                    }
                    c46236n = kD;
                    c35033a.rul.setVisibility(8);
                    c35033a.rui.setVisibility(8);
                    c35033a.rum.setVisibility(8);
                    c35033a.rul.setImageBitmap(null);
                    C13373af.cnC().mo37461dB(c35033a.rul);
                    if (c46236n == null) {
                    }
                    if (c35033a.rul.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(2131827805).setVisibility(obj2 == null ? 0 : 8);
                    if (c21992j.field_isSilence != 1) {
                    }
                    view.findViewById(2131827804).setVisibility(c21992j.field_isSilence != 1 ? 0 : 8);
                    AppMethodBeat.m2505o(39096);
                    return view;
                } catch (Exception e4) {
                    str = str2;
                    if (C5046bo.isNullOrNil(can.wPm)) {
                    }
                    aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                    if (aoO == null) {
                    }
                    c35033a.pnE.setText(C44089j.m79293b(SnsMsgUI.this, Oj, c35033a.pnE.getTextSize()));
                    kD = C13373af.cnF().mo62941kD(c21992j.field_snsID);
                    if (kD == null) {
                    }
                    c35033a.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(C25738R.color.a0k));
                    str3 = can.wPm;
                    textView = c35033a.pnE;
                    i2 = can.vFH;
                    switch (c21992j.field_type) {
                        case 1:
                        case 2:
                            break;
                        case 3:
                        case 5:
                            break;
                        case 4:
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                        case 16:
                            break;
                        default:
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = c35033a.ruk;
                    if ((c21992j.field_commentflag & 1) <= 0) {
                    }
                    if (obj != null) {
                    }
                    c35033a.timeTv.setText(C29198aw.m46376l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                    kD = null;
                    if (can.jCt != 7) {
                    }
                    ku = C13373af.cnI().mo69174ku(c21992j.field_snsID);
                    if (ku != null) {
                    }
                    c46236n = kD;
                    c35033a.rul.setVisibility(8);
                    c35033a.rui.setVisibility(8);
                    c35033a.rum.setVisibility(8);
                    c35033a.rul.setImageBitmap(null);
                    C13373af.cnC().mo37461dB(c35033a.rul);
                    if (c46236n == null) {
                    }
                    if (c35033a.rul.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(2131827805).setVisibility(obj2 == null ? 0 : 8);
                    if (c21992j.field_isSilence != 1) {
                    }
                    view.findViewById(2131827804).setVisibility(c21992j.field_isSilence != 1 ? 0 : 8);
                    AppMethodBeat.m2505o(39096);
                    return view;
                }
            } catch (Exception e5) {
                str2 = str;
                str = str2;
                if (C5046bo.isNullOrNil(can.wPm)) {
                }
                aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                if (aoO == null) {
                }
                c35033a.pnE.setText(C44089j.m79293b(SnsMsgUI.this, Oj, c35033a.pnE.getTextSize()));
                kD = C13373af.cnF().mo62941kD(c21992j.field_snsID);
                if (kD == null) {
                }
                c35033a.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(C25738R.color.a0k));
                str3 = can.wPm;
                textView = c35033a.pnE;
                i2 = can.vFH;
                switch (c21992j.field_type) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                    case 5:
                        break;
                    case 4:
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                    case 16:
                        break;
                    default:
                        break;
                }
                if (obj != null) {
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2 = c35033a.ruk;
                if ((c21992j.field_commentflag & 1) <= 0) {
                }
                if (obj != null) {
                }
                c35033a.timeTv.setText(C29198aw.m46376l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                kD = null;
                if (can.jCt != 7) {
                }
                ku = C13373af.cnI().mo69174ku(c21992j.field_snsID);
                if (ku != null) {
                }
                c46236n = kD;
                c35033a.rul.setVisibility(8);
                c35033a.rui.setVisibility(8);
                c35033a.rum.setVisibility(8);
                c35033a.rul.setImageBitmap(null);
                C13373af.cnC().mo37461dB(c35033a.rul);
                if (c46236n == null) {
                }
                if (c35033a.rul.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(2131827805).setVisibility(obj2 == null ? 0 : 8);
                if (c21992j.field_isSilence != 1) {
                }
                view.findViewById(2131827804).setVisibility(c21992j.field_isSilence != 1 ? 0 : 8);
                AppMethodBeat.m2505o(39096);
                return view;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$13 */
    class C3980613 implements C23600g {
        C3980613() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(39079);
            SnsMsgUI.this.nDp.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(39079);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$16 */
    class C3980716 implements OnItemClickListener {
        C3980716() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(39082);
            if (i == SnsMsgUI.this.rtT.getCount()) {
                int i2;
                if (C13373af.cnK().baS() > 0) {
                    C13373af.cnK().baT();
                    i2 = SnsMsgUI.this.rtT.bdn() ? 0 : 1;
                } else {
                    i2 = SnsMsgUI.this.rtT.bdo();
                }
                SnsMsgUI.this.rtT.mo5248a(null, null);
                if (!SnsMsgUI.this.kmU) {
                    if (SnsMsgUI.this.kmS.getParent() != null) {
                        C4990ab.m7410d("MicroMsg.SnsMsgUI", "remove footer");
                        SnsMsgUI.this.nDp.removeFooterView(SnsMsgUI.this.kmS);
                    }
                    if (SnsMsgUI.this.kmT.getParent() == null && i2 > 0) {
                        SnsMsgUI.this.nDp.addFooterView(SnsMsgUI.this.kmT);
                        C4990ab.m7416i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                    }
                }
                SnsMsgUI.this.kmU = true;
                SnsMsgUI.this.kmS.setVisibility(8);
                AppMethodBeat.m2505o(39082);
                return;
            }
            SnsMsgUI.m68151a(SnsMsgUI.this, (C21992j) SnsMsgUI.this.rtT.getItem(i));
            AppMethodBeat.m2505o(39082);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsMsgUI() {
        AppMethodBeat.m2504i(39098);
        AppMethodBeat.m2505o(39098);
    }

    /* renamed from: t */
    static /* synthetic */ void m68173t(SnsMsgUI snsMsgUI) {
        AppMethodBeat.m2504i(39114);
        snsMsgUI.ctD();
        AppMethodBeat.m2505o(39114);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39099);
        super.onCreate(bundle);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(210, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(683, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(218, (C1202f) this);
        this.fsg = C1853r.m3846Yz();
        this.rqa = C13373af.cnt();
        this.rtV = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.rtV) {
            this.kmU = true;
        }
        C13373af.cnK().mo10116c(this.rtZ);
        mo17446xE(this.mController.dyj());
        initView();
        AppMethodBeat.m2505o(39099);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39100);
        C4990ab.m7410d("MicroMsg.SnsMsgUI", "msgui onDestroy");
        C13373af.cnK().baT();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(210, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(683, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(218, (C1202f) this);
        C13373af.cnK().mo10117d(this.rtZ);
        this.rtT.bIf();
        C13373af.cnC().mo37452ab(this);
        if (this.rtX != null) {
            this.rtX.dismiss();
            this.rtX = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(39100);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39101);
        this.fAq = C5046bo.anT();
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16643a(this.mnM);
            }
        }
        C13373af.cnA().mo69136a((C43559b) this);
        super.onResume();
        AppMethodBeat.m2505o(39101);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39102);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.ehv);
        this.ehv = 0;
        C13373af.cnA().mo69142b((C43559b) this);
        super.onPause();
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16644b(this.mnM);
            }
        }
        this.fAq = C5046bo.anT() > this.fAq ? C5046bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.m2505o(39102);
    }

    public final int getLayoutId() {
        return 2130970783;
    }

    public final void initView() {
        AppMethodBeat.m2504i(39103);
        setMMTitle((int) C25738R.string.en3);
        addTextOptionMenu(0, getString(C25738R.string.f9078ou), new C398711());
        this.rhs = new C22062an(this);
        this.nDr = findViewById(2131827810);
        this.nDp = (ListView) findViewById(2131827809);
        this.kmS = C5616v.m8409hu(this).inflate(2130970781, null);
        this.kmT = C5616v.m8409hu(this).inflate(2130970112, null);
        C4990ab.m7410d("MicroMsg.SnsMsgUI", "autoLoad " + this.kmU);
        if (this.kmU) {
            this.nDp.addFooterView(this.kmT);
        } else {
            this.nDp.addFooterView(this.kmS);
        }
        this.rtT = new C35031a(this, new C21992j());
        this.rtT.setGetViewPositionCallback(new C398912());
        this.rtT.setPerformItemClickListener(new C3980613());
        this.rtT.mo55663b(new C3502214());
        this.rtT.mo74992a((C30723a) new C3502315());
        this.nDp.setAdapter(this.rtT);
        this.nDp.setOnItemClickListener(new C3980716());
        C46696j c46696j = new C46696j(this);
        this.nDp.setOnTouchListener(new C3502417());
        this.nDp.setOnItemLongClickListener(new C39912());
        this.nDp.setOnScrollListener(new C135403());
        if (this.rtT.getCount() == 0) {
            this.nDp.setVisibility(8);
            this.nDr.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.nDp.setVisibility(0);
            this.nDr.setVisibility(8);
            enableOptionMenu(true);
        }
        if ((this.rtT.bdn() && C13373af.cnK().baS() == 0) || C13373af.cnK().baS() == C13373af.cnK().cqG()) {
            this.kmS.setVisibility(8);
        }
        if (this.rtT.bdn() && this.kmU) {
            this.nDp.removeFooterView(this.kmT);
        }
        setBackBtn(new C350254());
        if (this.rtT.bdn() && this.kmU) {
            this.nDp.removeFooterView(this.kmT);
        }
        AppMethodBeat.m2505o(39103);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(39104);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        C21992j c21992j = (C21992j) this.rtT.getItem(adapterContextMenuInfo.position);
        if (c21992j == null) {
            AppMethodBeat.m2505o(39104);
            return;
        }
        this.rfb = c21992j.rfb;
        this.qQp = c21992j.field_snsID;
        try {
            can can = (can) new can().parseFrom(c21992j.field_curActionBuf);
            if (can != null) {
                String Oj;
                C7616ad aoO = this.rqa.aoO(can.wPm);
                if (aoO != null) {
                    Oj = aoO.mo16707Oj();
                } else if (C5046bo.isNullOrNil(can.wZD)) {
                    Oj = can.wPm;
                } else {
                    Oj = can.wZD;
                }
                contextMenu.setHeaderTitle(C5046bo.nullAsNil(Oj));
                if (c21992j.field_isSilence == 0) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 1, getString(C25738R.string.d_7));
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 2, 1, getString(C25738R.string.d_6));
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
        }
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(C25738R.string.f9088p4));
        AppMethodBeat.m2505o(39104);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39105);
        C4990ab.m7416i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(39105);
        } else if (intent == null || !intent.getBooleanExtra("result_finish", false)) {
            if (intent != null) {
                this.rjk.mo8581CK(intent.getIntExtra("sns_gallery_op_id", 0));
            }
            AppMethodBeat.m2505o(39105);
        } else {
            finish();
            AppMethodBeat.m2505o(39105);
        }
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
        AppMethodBeat.m2504i(39106);
        this.rtT.notifyDataSetChanged();
        AppMethodBeat.m2505o(39106);
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39107);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.rjk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(39107);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(39107);
        return dispatchKeyEvent;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39108);
        if (i == 0 && i2 == 0 && (c1207m instanceof C39761q)) {
            C4990ab.m7410d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
            ctD();
        }
        if (c1207m.getType() == 218) {
            if (((C46224r) c1207m).type != 12) {
                AppMethodBeat.m2505o(39108);
                return;
            }
            if (i == 0 && i2 == 0) {
                this.rtT.mo5248a(null, null);
                Toast.makeText(this, getString(C25738R.string.d__), 0).show();
            } else {
                Toast.makeText(this, getString(C25738R.string.d_9), 0).show();
            }
            if (this.rtX != null) {
                this.rtX.dismiss();
                this.rtX = null;
            }
        }
        AppMethodBeat.m2505o(39108);
    }

    private void ctD() {
        AppMethodBeat.m2504i(39109);
        if (this.rtU) {
            AppMethodBeat.m2505o(39109);
            return;
        }
        this.rtU = true;
        this.handler.postDelayed(this.rua, 500);
        AppMethodBeat.m2505o(39109);
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
    }

    /* renamed from: n */
    static /* synthetic */ void m68167n(SnsMsgUI snsMsgUI) {
        AppMethodBeat.m2504i(39112);
        C30379h.m48466d(snsMsgUI, snsMsgUI.getString(C25738R.string.d_8), "", snsMsgUI.getString(C25738R.string.d_7), snsMsgUI.getString(C25738R.string.f9076or), new C350287(), null);
        AppMethodBeat.m2505o(39112);
    }
}
