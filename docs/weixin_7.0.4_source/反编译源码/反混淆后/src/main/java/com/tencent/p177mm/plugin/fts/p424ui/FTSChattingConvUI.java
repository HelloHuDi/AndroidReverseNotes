package com.tencent.p177mm.plugin.fts.p424ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3159c;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;

@C18524i
/* renamed from: com.tencent.mm.plugin.fts.ui.FTSChattingConvUI */
public class FTSChattingConvUI extends FTSBaseUI implements OnClickListener {
    private C7616ad ehM;
    private String mEp;
    private C16768f mIA;
    private View mIz;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSChattingConvUI$a */
    class C3167a extends C41523a<C39143b> {
        String[] mIC;

        C3167a() {
            AppMethodBeat.m2504i(61793);
            if (C1855t.m3901mN(FTSChattingConvUI.this.mEp)) {
                this.mIC = new String[8];
                this.mIC[0] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzm);
                this.mIC[1] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzj);
                this.mIC[2] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzl);
                this.mIC[3] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzk);
                this.mIC[4] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzp);
                this.mIC[5] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzn);
                this.mIC[6] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzo);
                this.mIC[7] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzi);
                AppMethodBeat.m2505o(61793);
                return;
            }
            this.mIC = new String[7];
            this.mIC[0] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzj);
            this.mIC[1] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzl);
            this.mIC[2] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzk);
            this.mIC[3] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzp);
            this.mIC[4] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzn);
            this.mIC[5] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzo);
            this.mIC[6] = FTSChattingConvUI.this.getResources().getString(C25738R.string.dzi);
            AppMethodBeat.m2505o(61793);
        }

        public final int getItemCount() {
            return this.mIC.length;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSChattingConvUI$b */
    class C39143b extends C41531v {
        TextView exj;

        public C39143b(View view) {
            super(view);
            AppMethodBeat.m2504i(61796);
            this.exj = (TextView) view.findViewById(2131820678);
            this.exj.setOnClickListener(FTSChattingConvUI.this);
            AppMethodBeat.m2505o(61796);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSChattingConvUI$1 */
    class C447401 extends C25373h {
        Paint aFY = new Paint(1);
        final int offset = ((int) FTSChattingConvUI.this.getResources().getDimension(C25738R.dimen.f9727ds));

        C447401() {
            AppMethodBeat.m2504i(61790);
            AppMethodBeat.m2505o(61790);
        }

        /* renamed from: a */
        public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(61791);
            super.mo18495a(rect, view, recyclerView, c31880s);
            rect.set(this.offset, this.offset, this.offset, this.offset);
            AppMethodBeat.m2505o(61791);
        }

        /* renamed from: a */
        public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(61792);
            super.mo6920a(canvas, recyclerView, c31880s);
            this.aFY.setColor(-2434342);
            this.aFY.setStrokeWidth(1.0f);
            this.aFY.setStyle(Style.FILL);
            int childCount = recyclerView.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                if (i == 1 || i == 4) {
                    canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.aFY);
                    canvas.drawLine((float) (childAt.getRight() + this.offset), (float) childAt.getTop(), (float) (childAt.getRight() + this.offset), (float) childAt.getBottom(), this.aFY);
                } else if (i == 7) {
                    canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.aFY);
                }
                i++;
            }
            AppMethodBeat.m2505o(61792);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(61797);
        super.onCreate(bundle);
        initView();
        C3159c fTSImageLoader = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.bzY();
        }
        AppMethodBeat.m2505o(61797);
    }

    public final void initView() {
        AppMethodBeat.m2504i(61798);
        super.initView();
        this.mIz = findViewById(2131824217);
        this.mIz.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(2131824218);
        recyclerView.setLayoutManager(new GridLayoutManager(3));
        recyclerView.mo66330a(new C447401());
        recyclerView.setAdapter(new C3167a());
        AppMethodBeat.m2505o(61798);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.m2504i(61799);
        this.mEp = getIntent().getStringExtra("detail_username");
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.mEp);
        C4990ab.m7417i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", this.mEp);
        AppMethodBeat.m2505o(61799);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7440a(C28149e c28149e) {
        AppMethodBeat.m2504i(61800);
        if (this.mIA == null) {
            this.mIA = new C16768f(c28149e, this.mEp);
        }
        C16768f c16768f = this.mIA;
        AppMethodBeat.m2505o(61800);
        return c16768f;
    }

    /* renamed from: a */
    public final void mo7441a(C3154a c3154a) {
        AppMethodBeat.m2504i(61801);
        if (C1855t.m3901mN(this.mEp)) {
            FTSChattingConvUI.m81522V(this.query, 10, c3154a.position + 1);
            AppMethodBeat.m2505o(61801);
            return;
        }
        FTSChattingConvUI.m81522V(this.query, 11, c3154a.position + 1);
        AppMethodBeat.m2505o(61801);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAV() {
        AppMethodBeat.m2504i(61802);
        super.bAV();
        this.mIz.setVisibility(0);
        AppMethodBeat.m2505o(61802);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAT() {
        AppMethodBeat.m2504i(61803);
        super.bAT();
        this.mIz.setVisibility(8);
        AppMethodBeat.m2505o(61803);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAU() {
        AppMethodBeat.m2504i(61804);
        super.bAU();
        this.mIz.setVisibility(8);
        AppMethodBeat.m2505o(61804);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAS() {
        AppMethodBeat.m2504i(61805);
        super.bAS();
        this.mIz.setVisibility(8);
        AppMethodBeat.m2505o(61805);
    }

    /* renamed from: kT */
    private void m81524kT(int i) {
        AppMethodBeat.m2504i(61806);
        if (C1855t.m3901mN(this.mEp)) {
            if (((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.mEp).afg() != null) {
                if (i == 0) {
                    C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.afg().size()), Integer.valueOf(1));
                    AppMethodBeat.m2505o(61806);
                    return;
                }
                C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.afg().size()), Integer.valueOf(1));
            }
            AppMethodBeat.m2505o(61806);
        } else if (i == 0) {
            C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(61806);
        } else {
            C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(61806);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Nv */
    public final void mo68638Nv(String str) {
        int i = 1;
        AppMethodBeat.m2504i(61807);
        super.mo68638Nv(str);
        boolean mN = C1855t.m3901mN(this.mEp);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = Integer.valueOf(0);
        if (!mN) {
            i = 0;
        }
        objArr[8] = Integer.valueOf(i);
        c7060h.mo8381e(14569, objArr);
        AppMethodBeat.m2505o(61807);
    }

    public final int getLayoutId() {
        return 2130969618;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(61808);
        super.onDestroy();
        this.mIA.finish();
        C3159c fTSImageLoader = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.bzW();
        }
        AppMethodBeat.m2505o(61808);
    }

    public void onClick(View view) {
        Bundle bundle = null;
        AppMethodBeat.m2504i(61809);
        if (view instanceof TextView) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (!C1855t.m3901mN(this.mEp)) {
                intValue++;
            }
            Intent intent;
            if (intValue == 0) {
                C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
                intent = new Intent();
                intent.putExtra("from_scene", 1);
                intent.putExtra("RoomInfo_Id", this.mEp);
                intent.putExtra("title", getResources().getString(C25738R.string.dzf));
                C25985d.m41473f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", intent);
                AppMethodBeat.m2505o(61809);
                return;
            } else if (intValue == 1) {
                C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
                intent = new Intent();
                intent.putExtra("detail_username", this.mEp);
                C25985d.m41473f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", intent);
                m81524kT(0);
                AppMethodBeat.m2505o(61809);
                return;
            } else if (intValue == 2) {
                C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 1);
                C25985d.m41473f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", intent);
                m81524kT(1);
                AppMethodBeat.m2505o(61809);
                return;
            } else if (intValue == 3) {
                Bundle toBundle;
                C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
                Intent intent2 = new Intent();
                intent2.putExtra("kintent_talker", this.mEp);
                intent2.putExtra("key_media_type", 2);
                if (VERSION.SDK_INT >= 21) {
                    toBundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                } else {
                    toBundle = null;
                }
                C25985d.m41470c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent2, toBundle);
                AppMethodBeat.m2505o(61809);
                return;
            } else if (intValue == 4) {
                C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 3);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                C25985d.m41470c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                AppMethodBeat.m2505o(61809);
                return;
            } else if (intValue == 5) {
                C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 4);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                C25985d.m41470c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                AppMethodBeat.m2505o(61809);
                return;
            } else if (intValue == 6) {
                C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 5);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                C25985d.m41470c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                AppMethodBeat.m2505o(61809);
                return;
            } else {
                if (intValue == 7) {
                    C4990ab.m7416i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
                    intent = new Intent();
                    intent.putExtra("kintent_talker", this.mEp);
                    intent.putExtra("key_media_type", 6);
                    if (VERSION.SDK_INT >= 21) {
                        bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                    }
                    C25985d.m41470c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                }
                AppMethodBeat.m2505o(61809);
                return;
            }
        }
        AppMethodBeat.m2505o(61809);
    }

    /* renamed from: V */
    private static void m81522V(String str, int i, int i2) {
        AppMethodBeat.m2504i(61810);
        C4990ab.m7419v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(0)}));
        C7060h.pYm.mo8374X(13234, r0);
        AppMethodBeat.m2505o(61810);
    }
}
