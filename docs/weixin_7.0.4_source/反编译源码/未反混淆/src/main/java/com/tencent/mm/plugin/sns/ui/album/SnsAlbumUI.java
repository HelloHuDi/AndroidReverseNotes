package com.tencent.mm.plugin.sns.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsGalleryUI;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.plugin.sns.ui.album.a.b;
import com.tencent.mm.plugin.sns.ui.album.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMFragment;
import java.util.List;

public class SnsAlbumUI extends MMFragment implements a, a.a {
    private RecyclerView aiB = null;
    private String igi = null;
    private am.a rCU = null;
    private Runnable rCZ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(39986);
            if (SnsAlbumUI.this.rFL != null) {
                SnsAlbumUI.this.rFL.ctK();
                SnsAlbumUI.this.rFL.ll(true);
            }
            AppMethodBeat.o(39986);
        }
    };
    private LinearLayout rFJ = null;
    private LinearLayout rFK = null;
    private a rFL = null;
    private int rFM = 0;
    private String ryC = null;
    private int ryE = 0;
    private boolean ryx = false;

    public SnsAlbumUI() {
        AppMethodBeat.i(39992);
        AppMethodBeat.o(39992);
    }

    public void dealContentView(View view) {
        AppMethodBeat.i(39993);
        super.dealContentView(view);
        this.rCU = af.cnv();
        this.ryE = getActivity().getIntent().getIntExtra("sns_source", 0);
        this.igi = getActivity().getIntent().getStringExtra("sns_userName");
        this.ryC = r.Yz();
        this.rFL = new a(getContext(), this.igi, this);
        this.rFL.rFq = new c.a() {
            public final void bi(int i, String str) {
                AppMethodBeat.i(39988);
                ab.i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", Integer.valueOf(i), str);
                SnsAlbumUI.a(SnsAlbumUI.this, i, str);
                AppMethodBeat.o(39988);
            }
        };
        this.rFJ = (LinearLayout) view.findViewById(R.id.ego);
        this.rFK = (LinearLayout) view.findViewById(R.id.egq);
        this.aiB = (RecyclerView) view.findViewById(R.id.egr);
        this.rFK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39989);
                Intent intent = new Intent(SnsAlbumUI.this.getActivity(), SnsUserUI.class);
                intent.putExtra("sns_userName", SnsAlbumUI.this.igi);
                SnsAlbumUI.this.getActivity().startActivity(intent);
                AppMethodBeat.o(39989);
            }
        });
        this.aiB.setAdapter(this.rFL);
        RecyclerView recyclerView = this.aiB;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.aiB.a(new d() {
            public final void KB() {
                AppMethodBeat.i(39990);
                ab.d("MicroMsg.SnsAlbumUI", "onLoadMore");
                if (SnsAlbumUI.this.rFM == 0) {
                    SnsAlbumUI.this.rCU.b(2, SnsAlbumUI.this.igi, true, SnsAlbumUI.this.ryE);
                    af.bCo().postDelayed(SnsAlbumUI.this.rCZ, 3000);
                    SnsAlbumUI.this.rFM = SnsAlbumUI.this.rFM + 1;
                }
                AppMethodBeat.o(39990);
            }
        });
        this.aiB.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39991);
                if (SnsAlbumUI.this.ryx) {
                    ab.w("MicroMsg.SnsAlbumUI", "too fast that it finish");
                    AppMethodBeat.o(39991);
                    return;
                }
                SnsAlbumUI.this.rCU.a(2, SnsAlbumUI.this.igi, SnsAlbumUI.this);
                SnsAlbumUI.this.rCU.a(2, SnsAlbumUI.this.igi, true, SnsAlbumUI.this.ryE);
                AppMethodBeat.o(39991);
            }
        }, 500);
        AppMethodBeat.o(39993);
    }

    public int getLayoutId() {
        return R.layout.auq;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39994);
        super.onCreate(bundle);
        setMMTitle((int) R.string.f_);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39987);
                if (SnsAlbumUI.this.getActivity() != null) {
                    SnsAlbumUI.this.getActivity().finish();
                }
                AppMethodBeat.o(39987);
                return true;
            }
        });
        AppMethodBeat.o(39994);
    }

    public void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(39995);
        ab.d("MicroMsg.SnsAlbumUI", "onViewCreated");
        super.onViewCreated(view, bundle);
        AppMethodBeat.o(39995);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.i(39996);
        if (this.ryC.equals(this.igi) && j != 0) {
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
            this.rFL.kI(j);
        }
        if (z2) {
            this.rFL.cuS();
        } else if (z || cuT()) {
            this.rFM++;
            this.rCU.b(2, this.igi, true, this.ryE);
        }
        if (bo.isNullOrNil(this.rFL.rFi) && this.rFL != null) {
            this.rFL.rFh = str;
            this.rFL.ctK();
            this.rFL.ll(true);
        }
        AppMethodBeat.o(39996);
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
        AppMethodBeat.i(39997);
        af.bCo().removeCallbacks(this.rCZ);
        if (this.ryC.equals(this.igi) && j != 0) {
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
            this.rFL.kI(j);
        }
        if (z) {
            this.rFL.cuS();
            AppMethodBeat.o(39997);
        } else if (cuT()) {
            this.rFM++;
            this.rCU.b(2, this.igi, true, this.ryE);
            AppMethodBeat.o(39997);
        } else {
            if (this.rFL != null) {
                this.rFM = 0;
                this.rFL.rFj = z2;
                this.rFL.rFh = str;
                this.rFL.ctK();
                this.rFL.ll(true);
            }
            AppMethodBeat.o(39997);
        }
    }

    private boolean cuT() {
        return this.rFM < 3;
    }

    public void onDestroy() {
        AppMethodBeat.i(39998);
        super.onDestroy();
        this.ryx = true;
        af.bCo().removeCallbacks(this.rCZ);
        g.RQ();
        if (g.RN().QY() && this.rCU != null) {
            this.rCU.a(this, 2);
        }
        AppMethodBeat.o(39998);
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public final void du(List<b> list) {
        AppMethodBeat.i(39999);
        if (list == null || list.isEmpty()) {
            this.aiB.setVisibility(8);
            this.rFJ.setVisibility(0);
            AppMethodBeat.o(39999);
            return;
        }
        this.aiB.setVisibility(0);
        this.rFJ.setVisibility(8);
        AppMethodBeat.o(39999);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(40000);
        super.onActivityResult(i, i2, intent);
        ab.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", Integer.valueOf(i2), Integer.valueOf(i), intent);
        if (i == 8 && intent != null && intent.getParcelableExtra("sns_cmd_list") != null && (intent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList)) {
            for (Integer intValue : ((SnsCmdList) intent.getParcelableExtra("sns_cmd_list")).qFN) {
                int i3;
                int i4;
                int intValue2 = intValue.intValue();
                a aVar = this.rFL;
                RecyclerView recyclerView = this.aiB;
                int i5 = 0;
                while (true) {
                    i3 = i5;
                    if (i3 >= aVar.rFg.size()) {
                        i4 = -1;
                        break;
                    }
                    for (n nVar : ((b) aVar.rFg.get(i3)).rFt) {
                        if (intValue2 == nVar.reX) {
                            i4 = i3;
                            break;
                        }
                    }
                    i5 = i3 + 1;
                }
                if (i4 != -1) {
                    v cf = recyclerView.cf(i4);
                    if (cf instanceof f) {
                        c a = ((f) cf).rFA;
                        int i6 = -1;
                        int i7 = 1;
                        i5 = 0;
                        while (true) {
                            i3 = i5;
                            if (i3 >= a.rFD.size()) {
                                break;
                            }
                            if (((d) a.rFD.get(i3)).cNE == intValue2) {
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
                            a.au(i6, i7);
                        } else {
                            i5 = 0;
                        }
                        if (i5 <= 0) {
                            aVar.rFg.remove(i4);
                            aVar.ci(i4);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(40000);
    }

    static /* synthetic */ void a(SnsAlbumUI snsAlbumUI, int i, String str) {
        AppMethodBeat.i(CdnLogic.kMediaTypeStoryAudio);
        Intent intent = new Intent(snsAlbumUI.getActivity(), SnsGalleryUI.class);
        intent.putExtra("sns_gallery_userName", snsAlbumUI.igi);
        intent.putExtra("sns_gallery_is_self", bo.isEqual(snsAlbumUI.ryC, snsAlbumUI.igi));
        intent.putExtra("sns_gallery_localId", i);
        intent.putExtra("sns_source", snsAlbumUI.ryE);
        if (snsAlbumUI.rFL != null) {
            intent.putExtra("sns_gallery_limit_seq", snsAlbumUI.rFL.rFi);
            snsAlbumUI.rCU.j(snsAlbumUI.igi, snsAlbumUI.rFL.bh(i, str));
            intent.putExtra("sns_gallery_position", snsAlbumUI.rFL.rFm);
        }
        snsAlbumUI.startActivityForResult(intent, 8);
        AppMethodBeat.o(CdnLogic.kMediaTypeStoryAudio);
    }
}
