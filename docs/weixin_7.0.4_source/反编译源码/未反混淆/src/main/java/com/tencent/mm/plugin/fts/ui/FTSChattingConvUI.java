package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;

@i
public class FTSChattingConvUI extends FTSBaseUI implements OnClickListener {
    private ad ehM;
    private String mEp;
    private f mIA;
    private View mIz;

    class a extends android.support.v7.widget.RecyclerView.a<b> {
        String[] mIC;

        a() {
            AppMethodBeat.i(61793);
            if (t.mN(FTSChattingConvUI.this.mEp)) {
                this.mIC = new String[8];
                this.mIC[0] = FTSChattingConvUI.this.getResources().getString(R.string.dzm);
                this.mIC[1] = FTSChattingConvUI.this.getResources().getString(R.string.dzj);
                this.mIC[2] = FTSChattingConvUI.this.getResources().getString(R.string.dzl);
                this.mIC[3] = FTSChattingConvUI.this.getResources().getString(R.string.dzk);
                this.mIC[4] = FTSChattingConvUI.this.getResources().getString(R.string.dzp);
                this.mIC[5] = FTSChattingConvUI.this.getResources().getString(R.string.dzn);
                this.mIC[6] = FTSChattingConvUI.this.getResources().getString(R.string.dzo);
                this.mIC[7] = FTSChattingConvUI.this.getResources().getString(R.string.dzi);
                AppMethodBeat.o(61793);
                return;
            }
            this.mIC = new String[7];
            this.mIC[0] = FTSChattingConvUI.this.getResources().getString(R.string.dzj);
            this.mIC[1] = FTSChattingConvUI.this.getResources().getString(R.string.dzl);
            this.mIC[2] = FTSChattingConvUI.this.getResources().getString(R.string.dzk);
            this.mIC[3] = FTSChattingConvUI.this.getResources().getString(R.string.dzp);
            this.mIC[4] = FTSChattingConvUI.this.getResources().getString(R.string.dzn);
            this.mIC[5] = FTSChattingConvUI.this.getResources().getString(R.string.dzo);
            this.mIC[6] = FTSChattingConvUI.this.getResources().getString(R.string.dzi);
            AppMethodBeat.o(61793);
        }

        public final int getItemCount() {
            return this.mIC.length;
        }
    }

    class b extends v {
        TextView exj;

        public b(View view) {
            super(view);
            AppMethodBeat.i(61796);
            this.exj = (TextView) view.findViewById(R.id.cx);
            this.exj.setOnClickListener(FTSChattingConvUI.this);
            AppMethodBeat.o(61796);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(61797);
        super.onCreate(bundle);
        initView();
        c fTSImageLoader = ((n) g.M(n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.bzY();
        }
        AppMethodBeat.o(61797);
    }

    public final void initView() {
        AppMethodBeat.i(61798);
        super.initView();
        this.mIz = findViewById(R.id.by_);
        this.mIz.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bya);
        recyclerView.setLayoutManager(new GridLayoutManager(3));
        recyclerView.a(new h() {
            Paint aFY = new Paint(1);
            final int offset = ((int) FTSChattingConvUI.this.getResources().getDimension(R.dimen.ds));

            {
                AppMethodBeat.i(61790);
                AppMethodBeat.o(61790);
            }

            public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
                AppMethodBeat.i(61791);
                super.a(rect, view, recyclerView, sVar);
                rect.set(this.offset, this.offset, this.offset, this.offset);
                AppMethodBeat.o(61791);
            }

            public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
                AppMethodBeat.i(61792);
                super.a(canvas, recyclerView, sVar);
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
                AppMethodBeat.o(61792);
            }
        });
        recyclerView.setAdapter(new a());
        AppMethodBeat.o(61798);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.i(61799);
        this.mEp = getIntent().getStringExtra("detail_username");
        this.ehM = ((j) g.K(j.class)).XM().aoO(this.mEp);
        ab.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", this.mEp);
        AppMethodBeat.o(61799);
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61800);
        if (this.mIA == null) {
            this.mIA = new f(eVar, this.mEp);
        }
        f fVar = this.mIA;
        AppMethodBeat.o(61800);
        return fVar;
    }

    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        AppMethodBeat.i(61801);
        if (t.mN(this.mEp)) {
            V(this.query, 10, aVar.position + 1);
            AppMethodBeat.o(61801);
            return;
        }
        V(this.query, 11, aVar.position + 1);
        AppMethodBeat.o(61801);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAV() {
        AppMethodBeat.i(61802);
        super.bAV();
        this.mIz.setVisibility(0);
        AppMethodBeat.o(61802);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAT() {
        AppMethodBeat.i(61803);
        super.bAT();
        this.mIz.setVisibility(8);
        AppMethodBeat.o(61803);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAU() {
        AppMethodBeat.i(61804);
        super.bAU();
        this.mIz.setVisibility(8);
        AppMethodBeat.o(61804);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAS() {
        AppMethodBeat.i(61805);
        super.bAS();
        this.mIz.setVisibility(8);
        AppMethodBeat.o(61805);
    }

    private void kT(int i) {
        AppMethodBeat.i(61806);
        if (t.mN(this.mEp)) {
            if (((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().ob(this.mEp).afg() != null) {
                if (i == 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.afg().size()), Integer.valueOf(1));
                    AppMethodBeat.o(61806);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.afg().size()), Integer.valueOf(1));
            }
            AppMethodBeat.o(61806);
        } else if (i == 0) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.o(61806);
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.o(61806);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void Nv(String str) {
        int i = 1;
        AppMethodBeat.i(61807);
        super.Nv(str);
        boolean mN = t.mN(this.mEp);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
        hVar.e(14569, objArr);
        AppMethodBeat.o(61807);
    }

    public final int getLayoutId() {
        return R.layout.a1c;
    }

    public void onDestroy() {
        AppMethodBeat.i(61808);
        super.onDestroy();
        this.mIA.finish();
        c fTSImageLoader = ((n) g.M(n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.bzW();
        }
        AppMethodBeat.o(61808);
    }

    public void onClick(View view) {
        Bundle bundle = null;
        AppMethodBeat.i(61809);
        if (view instanceof TextView) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (!t.mN(this.mEp)) {
                intValue++;
            }
            Intent intent;
            if (intValue == 0) {
                ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
                intent = new Intent();
                intent.putExtra("from_scene", 1);
                intent.putExtra("RoomInfo_Id", this.mEp);
                intent.putExtra("title", getResources().getString(R.string.dzf));
                d.f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", intent);
                AppMethodBeat.o(61809);
                return;
            } else if (intValue == 1) {
                ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
                intent = new Intent();
                intent.putExtra("detail_username", this.mEp);
                d.f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", intent);
                kT(0);
                AppMethodBeat.o(61809);
                return;
            } else if (intValue == 2) {
                ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 1);
                d.f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", intent);
                kT(1);
                AppMethodBeat.o(61809);
                return;
            } else if (intValue == 3) {
                Bundle toBundle;
                ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
                Intent intent2 = new Intent();
                intent2.putExtra("kintent_talker", this.mEp);
                intent2.putExtra("key_media_type", 2);
                if (VERSION.SDK_INT >= 21) {
                    toBundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                } else {
                    toBundle = null;
                }
                d.c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent2, toBundle);
                AppMethodBeat.o(61809);
                return;
            } else if (intValue == 4) {
                ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 3);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                d.c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                AppMethodBeat.o(61809);
                return;
            } else if (intValue == 5) {
                ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 4);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                d.c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                AppMethodBeat.o(61809);
                return;
            } else if (intValue == 6) {
                ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mEp);
                intent.putExtra("key_media_type", 5);
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                }
                d.c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                AppMethodBeat.o(61809);
                return;
            } else {
                if (intValue == 7) {
                    ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
                    intent = new Intent();
                    intent.putExtra("kintent_talker", this.mEp);
                    intent.putExtra("key_media_type", 6);
                    if (VERSION.SDK_INT >= 21) {
                        bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
                    }
                    d.c((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent, bundle);
                }
                AppMethodBeat.o(61809);
                return;
            }
        }
        AppMethodBeat.o(61809);
    }

    private static void V(String str, int i, int i2) {
        AppMethodBeat.i(61810);
        ab.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(0)}));
        com.tencent.mm.plugin.report.service.h.pYm.X(13234, r0);
        AppMethodBeat.o(61810);
    }
}
