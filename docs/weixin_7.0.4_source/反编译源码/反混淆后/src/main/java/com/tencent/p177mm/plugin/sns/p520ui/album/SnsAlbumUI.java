package com.tencent.p177mm.plugin.sns.p520ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.plugin.sns.data.SnsCmdList;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsGalleryUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsUserUI;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35095a.C22059a;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35095a.C29189b;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35095a.C35098f;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35095a.C35100d;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35101c.C35103a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI */
public class SnsAlbumUI extends MMFragment implements C39729a, C22059a {
    private RecyclerView aiB = null;
    private String igi = null;
    private C3890a rCU = null;
    private Runnable rCZ = new C291881();
    private LinearLayout rFJ = null;
    private LinearLayout rFK = null;
    private C35095a rFL = null;
    private int rFM = 0;
    private String ryC = null;
    private int ryE = 0;
    private boolean ryx = false;

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI$2 */
    class C220582 implements OnMenuItemClickListener {
        C220582() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39987);
            if (SnsAlbumUI.this.getActivity() != null) {
                SnsAlbumUI.this.getActivity().finish();
            }
            AppMethodBeat.m2505o(39987);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI$1 */
    class C291881 implements Runnable {
        C291881() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39986);
            if (SnsAlbumUI.this.rFL != null) {
                SnsAlbumUI.this.rFL.ctK();
                SnsAlbumUI.this.rFL.mo55734ll(true);
            }
            AppMethodBeat.m2505o(39986);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI$4 */
    class C350914 implements OnClickListener {
        C350914() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39989);
            Intent intent = new Intent(SnsAlbumUI.this.getActivity(), SnsUserUI.class);
            intent.putExtra("sns_userName", SnsAlbumUI.this.igi);
            SnsAlbumUI.this.getActivity().startActivity(intent);
            AppMethodBeat.m2505o(39989);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI$5 */
    class C350925 extends C35104d {
        C350925() {
        }

        /* renamed from: KB */
        public final void mo55727KB() {
            AppMethodBeat.m2504i(39990);
            C4990ab.m7410d("MicroMsg.SnsAlbumUI", "onLoadMore");
            if (SnsAlbumUI.this.rFM == 0) {
                SnsAlbumUI.this.rCU.mo8620b(2, SnsAlbumUI.this.igi, true, SnsAlbumUI.this.ryE);
                C13373af.bCo().postDelayed(SnsAlbumUI.this.rCZ, 3000);
                SnsAlbumUI.this.rFM = SnsAlbumUI.this.rFM + 1;
            }
            AppMethodBeat.m2505o(39990);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI$6 */
    class C350936 implements Runnable {
        C350936() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39991);
            if (SnsAlbumUI.this.ryx) {
                C4990ab.m7420w("MicroMsg.SnsAlbumUI", "too fast that it finish");
                AppMethodBeat.m2505o(39991);
                return;
            }
            SnsAlbumUI.this.rCU.mo8617a(2, SnsAlbumUI.this.igi, SnsAlbumUI.this);
            SnsAlbumUI.this.rCU.mo8618a(2, SnsAlbumUI.this.igi, true, SnsAlbumUI.this.ryE);
            AppMethodBeat.m2505o(39991);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI$3 */
    class C350943 implements C35103a {
        C350943() {
        }

        /* renamed from: bi */
        public final void mo55729bi(int i, String str) {
            AppMethodBeat.m2504i(39988);
            C4990ab.m7417i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", Integer.valueOf(i), str);
            SnsAlbumUI.m57690a(SnsAlbumUI.this, i, str);
            AppMethodBeat.m2505o(39988);
        }
    }

    public SnsAlbumUI() {
        AppMethodBeat.m2504i(39992);
        AppMethodBeat.m2505o(39992);
    }

    public void dealContentView(View view) {
        AppMethodBeat.m2504i(39993);
        super.dealContentView(view);
        this.rCU = C13373af.cnv();
        this.ryE = getActivity().getIntent().getIntExtra("sns_source", 0);
        this.igi = getActivity().getIntent().getStringExtra("sns_userName");
        this.ryC = C1853r.m3846Yz();
        this.rFL = new C35095a(getContext(), this.igi, this);
        this.rFL.rFq = new C350943();
        this.rFJ = (LinearLayout) view.findViewById(2131827672);
        this.rFK = (LinearLayout) view.findViewById(2131827674);
        this.aiB = (RecyclerView) view.findViewById(2131827675);
        this.rFK.setOnClickListener(new C350914());
        this.aiB.setAdapter(this.rFL);
        RecyclerView recyclerView = this.aiB;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.aiB.mo66332a(new C350925());
        this.aiB.postDelayed(new C350936(), 500);
        AppMethodBeat.m2505o(39993);
    }

    public int getLayoutId() {
        return 2130970743;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39994);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f8797f_);
        setBackBtn(new C220582());
        AppMethodBeat.m2505o(39994);
    }

    public void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.m2504i(39995);
        C4990ab.m7410d("MicroMsg.SnsAlbumUI", "onViewCreated");
        super.onViewCreated(view, bundle);
        AppMethodBeat.m2505o(39995);
    }

    /* renamed from: a */
    public final void mo17657a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.m2504i(39996);
        if (this.ryC.equals(this.igi) && j != 0) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
            this.rFL.mo55733kI(j);
        }
        if (z2) {
            this.rFL.cuS();
        } else if (z || cuT()) {
            this.rFM++;
            this.rCU.mo8620b(2, this.igi, true, this.ryE);
        }
        if (C5046bo.isNullOrNil(this.rFL.rFi) && this.rFL != null) {
            this.rFL.rFh = str;
            this.rFL.ctK();
            this.rFL.mo55734ll(true);
        }
        AppMethodBeat.m2505o(39996);
    }

    /* renamed from: a */
    public final void mo17656a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
        AppMethodBeat.m2504i(39997);
        C13373af.bCo().removeCallbacks(this.rCZ);
        if (this.ryC.equals(this.igi) && j != 0) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
            this.rFL.mo55733kI(j);
        }
        if (z) {
            this.rFL.cuS();
            AppMethodBeat.m2505o(39997);
        } else if (cuT()) {
            this.rFM++;
            this.rCU.mo8620b(2, this.igi, true, this.ryE);
            AppMethodBeat.m2505o(39997);
        } else {
            if (this.rFL != null) {
                this.rFM = 0;
                this.rFL.rFj = z2;
                this.rFL.rFh = str;
                this.rFL.ctK();
                this.rFL.mo55734ll(true);
            }
            AppMethodBeat.m2505o(39997);
        }
    }

    private boolean cuT() {
        return this.rFM < 3;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39998);
        super.onDestroy();
        this.ryx = true;
        C13373af.bCo().removeCallbacks(this.rCZ);
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY() && this.rCU != null) {
            this.rCU.mo8619a(this, 2);
        }
        AppMethodBeat.m2505o(39998);
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    /* renamed from: du */
    public final void mo37614du(List<C29189b> list) {
        AppMethodBeat.m2504i(39999);
        if (list == null || list.isEmpty()) {
            this.aiB.setVisibility(8);
            this.rFJ.setVisibility(0);
            AppMethodBeat.m2505o(39999);
            return;
        }
        this.aiB.setVisibility(0);
        this.rFJ.setVisibility(8);
        AppMethodBeat.m2505o(39999);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(40000);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7411d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", Integer.valueOf(i2), Integer.valueOf(i), intent);
        if (i == 8 && intent != null && intent.getParcelableExtra("sns_cmd_list") != null && (intent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList)) {
            for (Integer intValue : ((SnsCmdList) intent.getParcelableExtra("sns_cmd_list")).qFN) {
                int i3;
                int i4;
                int intValue2 = intValue.intValue();
                C35095a c35095a = this.rFL;
                RecyclerView recyclerView = this.aiB;
                int i5 = 0;
                while (true) {
                    i3 = i5;
                    if (i3 >= c35095a.rFg.size()) {
                        i4 = -1;
                        break;
                    }
                    for (C46236n c46236n : ((C29189b) c35095a.rFg.get(i3)).rFt) {
                        if (intValue2 == c46236n.reX) {
                            i4 = i3;
                            break;
                        }
                    }
                    i5 = i3 + 1;
                }
                if (i4 != -1) {
                    C41531v cf = recyclerView.mo66357cf(i4);
                    if (cf instanceof C35098f) {
                        C35101c a = ((C35098f) cf).rFA;
                        int i6 = -1;
                        int i7 = 1;
                        i5 = 0;
                        while (true) {
                            i3 = i5;
                            if (i3 >= a.rFD.size()) {
                                break;
                            }
                            if (((C35100d) a.rFD.get(i3)).cNE == intValue2) {
                                if (i6 == -1) {
                                    i6 = i3;
                                } else {
                                    i7++;
                                }
                            }
                            i5 = i3 + 1;
                        }
                        if (i6 != -1) {
                            for (i5 = 0; i5 < i7; i5++) {
                                a.rFD.remove(i6);
                            }
                            i5 = a.rFD.size();
                            a.mo66311au(i6, i7);
                        } else {
                            i5 = 0;
                        }
                        if (i5 <= 0) {
                            c35095a.rFg.remove(i4);
                            c35095a.mo66318ci(i4);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(40000);
    }

    /* renamed from: a */
    static /* synthetic */ void m57690a(SnsAlbumUI snsAlbumUI, int i, String str) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeStoryAudio);
        Intent intent = new Intent(snsAlbumUI.getActivity(), SnsGalleryUI.class);
        intent.putExtra("sns_gallery_userName", snsAlbumUI.igi);
        intent.putExtra("sns_gallery_is_self", C5046bo.isEqual(snsAlbumUI.ryC, snsAlbumUI.igi));
        intent.putExtra("sns_gallery_localId", i);
        intent.putExtra("sns_source", snsAlbumUI.ryE);
        if (snsAlbumUI.rFL != null) {
            intent.putExtra("sns_gallery_limit_seq", snsAlbumUI.rFL.rFi);
            snsAlbumUI.rCU.mo8623j(snsAlbumUI.igi, snsAlbumUI.rFL.mo55730bh(i, str));
            intent.putExtra("sns_gallery_position", snsAlbumUI.rFL.rFm);
        }
        snsAlbumUI.startActivityForResult(intent, 8);
        AppMethodBeat.m2505o(CdnLogic.kMediaTypeStoryAudio);
    }
}
