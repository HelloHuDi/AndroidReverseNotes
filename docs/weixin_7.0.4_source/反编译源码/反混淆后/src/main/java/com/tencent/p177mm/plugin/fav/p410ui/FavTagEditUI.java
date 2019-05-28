package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMTagPanel.C44799a;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C45927l;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C34149c;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C34151d;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavTagPanel;
import com.tencent.p177mm.protocal.protobuf.abp;
import com.tencent.p177mm.protocal.protobuf.abq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI */
public class FavTagEditUI extends MMActivity {
    private C27966g mjP;
    private List<String> mjQ;
    private FavTagPanel mjR;
    private FavTagPanel mjS;
    private ListView mjT;
    private ListView mjU;
    private TextView mjV;
    private C34149c mjW;
    private C34151d mjX;
    private boolean mjY;

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI$8 */
    class C118738 implements C44799a {
        C118738() {
        }

        /* renamed from: JR */
        public final void mo23722JR(String str) {
            AppMethodBeat.m2504i(74149);
            FavTagEditUI.this.mjS.removeTag(str);
            FavTagEditUI.this.mjW.mo54729Mf(str);
            FavTagEditUI.m66458c(FavTagEditUI.this);
            AppMethodBeat.m2505o(74149);
        }

        /* renamed from: JS */
        public final void mo23723JS(String str) {
            AppMethodBeat.m2504i(74150);
            FavTagEditUI.this.mjS.mo71951cc(str, true);
            FavTagEditUI.this.mjW.mo54728Me(str);
            FavTagEditUI.m66458c(FavTagEditUI.this);
            AppMethodBeat.m2505o(74150);
        }

        /* renamed from: JT */
        public final void mo23724JT(String str) {
        }

        public final void bmm() {
        }

        /* renamed from: JU */
        public final void mo23725JU(String str) {
        }

        /* renamed from: JV */
        public final void mo23726JV(String str) {
        }

        /* renamed from: q */
        public final void mo23728q(boolean z, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI$9 */
    class C118749 implements OnTouchListener {
        C118749() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74151);
            FavTagEditUI.this.mjS.dAd();
            AppMethodBeat.m2505o(74151);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI$1 */
    class C207041 implements OnMenuItemClickListener {
        C207041() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74137);
            FavTagEditUI.m66455a(FavTagEditUI.this);
            AppMethodBeat.m2505o(74137);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI$2 */
    class C279992 implements OnTouchListener {
        C279992() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74138);
            FavTagEditUI.this.mjS.dAd();
            AppMethodBeat.m2505o(74138);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI$4 */
    class C390474 implements OnClickListener {
        C390474() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(74140);
            FavTagEditUI.this.finish();
            AppMethodBeat.m2505o(74140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI$6 */
    class C390486 implements Runnable {
        C390486() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74146);
            FavTagEditUI.this.mjS.dAc();
            FavTagEditUI.this.showVKB();
            AppMethodBeat.m2505o(74146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTagEditUI$5 */
    class C390515 implements C44799a {
        C390515() {
        }

        /* renamed from: JR */
        public final void mo23722JR(String str) {
            AppMethodBeat.m2504i(74141);
            FavTagEditUI.this.mjS.removeTag(str);
            FavTagEditUI.this.mjW.mo54729Mf(str);
            if (FavTagEditUI.this.mjR != null) {
                FavTagEditUI.this.mjR.mo71952cd(str, false);
            }
            FavTagEditUI.m66458c(FavTagEditUI.this);
            AppMethodBeat.m2505o(74141);
        }

        /* renamed from: JS */
        public final void mo23723JS(String str) {
        }

        /* renamed from: JT */
        public final void mo23724JT(String str) {
            AppMethodBeat.m2504i(74142);
            FavTagEditUI.this.mjS.removeTag(str);
            FavTagEditUI.this.mjW.mo54729Mf(str);
            if (FavTagEditUI.this.mjR != null) {
                FavTagEditUI.this.mjR.mo71952cd(str, false);
            }
            FavTagEditUI.m66458c(FavTagEditUI.this);
            AppMethodBeat.m2505o(74142);
        }

        /* renamed from: JU */
        public final void mo23725JU(String str) {
            AppMethodBeat.m2504i(74143);
            if (C5046bo.isNullOrNil(str)) {
                FavTagEditUI.this.mjU.setVisibility(8);
                FavTagEditUI.this.mjT.setVisibility(0);
            } else {
                C34151d h = FavTagEditUI.this.mjX;
                h.mly.clear();
                h.mlx.clear();
                h.kPJ = C5046bo.m7532bc(str, "");
                C45927l favTagSetMgr = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr();
                boolean isNullOrNil = C5046bo.isNullOrNil(str);
                ArrayList arrayList = new ArrayList(16);
                Iterator it = favTagSetMgr.mfn.wiH.iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((abq) it.next()).wiG.iterator();
                    while (it2.hasNext()) {
                        abp abp = (abp) it2.next();
                        if (isNullOrNil || abp.rMJ.contains(str)) {
                            arrayList.add(abp.rMJ);
                        }
                    }
                }
                h.mlx.addAll(arrayList);
                h.notifyDataSetChanged();
                FavTagEditUI.this.mjU.setVisibility(0);
                FavTagEditUI.this.mjT.setVisibility(8);
            }
            FavTagEditUI.m66458c(FavTagEditUI.this);
            AppMethodBeat.m2505o(74143);
        }

        /* renamed from: JV */
        public final void mo23726JV(String str) {
            AppMethodBeat.m2504i(74144);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7410d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
                AppMethodBeat.m2505o(74144);
                return;
            }
            FavTagEditUI.this.mjS.mo71951cc(str, true);
            FavTagEditUI.m66458c(FavTagEditUI.this);
            AppMethodBeat.m2505o(74144);
        }

        public final void bmm() {
        }

        /* renamed from: q */
        public final void mo23728q(boolean z, int i) {
            AppMethodBeat.m2504i(74145);
            FavTagEditUI.this.mjY = z;
            TextView k = FavTagEditUI.this.mjV;
            int i2 = (!FavTagEditUI.this.mjY || i <= 0) ? 8 : 0;
            k.setVisibility(i2);
            FavTagEditUI.this.mjV.setText(FavTagEditUI.this.getString(C25738R.string.bs1, new Object[]{Integer.valueOf(i)}));
            FavTagEditUI.m66458c(FavTagEditUI.this);
            AppMethodBeat.m2505o(74145);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m66455a(FavTagEditUI favTagEditUI) {
        AppMethodBeat.m2504i(74159);
        favTagEditUI.bvO();
        AppMethodBeat.m2505o(74159);
    }

    /* renamed from: c */
    static /* synthetic */ void m66458c(FavTagEditUI favTagEditUI) {
        AppMethodBeat.m2504i(74160);
        favTagEditUI.bvN();
        AppMethodBeat.m2505o(74160);
    }

    public final int getLayoutId() {
        return 2130969526;
    }

    public void onCreate(Bundle bundle) {
        List list;
        AppMethodBeat.m2504i(74153);
        super.onCreate(bundle);
        final long longExtra = getIntent().getLongExtra("key_fav_item_id", -1);
        if (-1 != longExtra) {
            this.mjP = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(longExtra);
        }
        this.mjQ = getIntent().getStringArrayListExtra("key_fav_result_list");
        this.mjS = (FavTagPanel) findViewById(2131823966);
        this.mjT = (ListView) findViewById(2131823968);
        this.mjU = (ListView) findViewById(2131823973);
        this.mjV = (TextView) findViewById(2131823972);
        this.mjS.mo71963qe(true);
        this.mjS.setTagEditTextBG(C25738R.drawable.a2s);
        this.mjS.setIsAllowEnterCharacter(true);
        this.mjS.setCallBack(new C390515());
        this.mjS.postDelayed(new C390486(), 100);
        if (this.mjP != null) {
            this.mjS.mo71950a((Collection) this.mjP.field_tagProto.wiJ, (List) this.mjP.field_tagProto.wiJ);
        } else if (this.mjQ != null) {
            this.mjS.mo71950a((Collection) this.mjQ, this.mjQ);
        }
        this.mjW = new C34149c(this.mController.ylL) {
            /* renamed from: Ma */
            public final void mo23718Ma(String str) {
                AppMethodBeat.m2504i(74147);
                FavTagEditUI.this.mjS.mo71951cc(str, true);
                if (FavTagEditUI.this.mjR != null) {
                    FavTagEditUI.this.mjR.mo71952cd(str, true);
                }
                FavTagEditUI.m66458c(FavTagEditUI.this);
                AppMethodBeat.m2505o(74147);
            }

            /* renamed from: Mb */
            public final void mo23719Mb(String str) {
                AppMethodBeat.m2504i(74148);
                FavTagEditUI.this.mjS.removeTag(str);
                if (FavTagEditUI.this.mjR != null) {
                    FavTagEditUI.this.mjR.mo71952cd(str, false);
                }
                FavTagEditUI.m66458c(FavTagEditUI.this);
                AppMethodBeat.m2505o(74148);
            }
        };
        C34149c c34149c = this.mjW;
        if (this.mjP == null) {
            list = null;
        } else {
            list = this.mjP.field_tagProto.wiJ;
        }
        c34149c.mo54730bQ(list);
        if (!(this.mjP == null || this.mjP.field_tagProto.wiI.isEmpty())) {
            View inflate = View.inflate(this.mController.ylL, 2130969530, null);
            TextView textView = (TextView) inflate.findViewById(2131823978);
            textView.setText(getString(C25738R.string.bqe));
            textView.setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9859i4);
            this.mjR = (FavTagPanel) inflate.findViewById(2131823979);
            this.mjR.setVisibility(0);
            this.mjR.mo71950a((Collection) this.mjP.field_tagProto.wiJ, (List) this.mjP.field_tagProto.wiI);
            this.mjR.setBackgroundResource(C25738R.drawable.a_r);
            this.mjR.setPadding(0, 0, 0, dimensionPixelSize);
            this.mjR.setCallBack(new C118738());
            this.mjT.addHeaderView(inflate);
        }
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().buE() > 0) {
            this.mjT.addHeaderView(View.inflate(this.mController.ylL, 2130969529, null));
        }
        this.mjT.setAdapter(this.mjW);
        this.mjT.setOnTouchListener(new C118749());
        this.mjX = new C34151d(this.mController.ylL) {
            /* renamed from: KI */
            public final void mo54737KI(String str) {
                AppMethodBeat.m2504i(74152);
                FavTagEditUI.this.mjS.mo71951cc(str, true);
                FavTagEditUI.this.mjW.mo54728Me(str);
                FavTagEditUI.this.mjS.dAb();
                FavTagEditUI.this.mjS.dAd();
                FavTagEditUI.m66458c(FavTagEditUI.this);
                AppMethodBeat.m2505o(74152);
            }
        };
        this.mjU.setAdapter(this.mjX);
        this.mjU.setOnTouchListener(new C279992());
        setMMTitle((int) C25738R.string.bo8);
        setBackBtn(new C207041());
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(74139);
                if (FavTagEditUI.this.mjY) {
                    FavTagEditUI.m66458c(FavTagEditUI.this);
                    AppMethodBeat.m2505o(74139);
                } else {
                    ArrayList tagList = FavTagEditUI.this.mjS.getTagList();
                    String trim = FavTagEditUI.this.mjS.getEditText().trim();
                    if (!C5046bo.isNullOrNil(trim)) {
                        tagList.remove(trim);
                        tagList.add(trim);
                    }
                    FavTagEditUI.this.mjP = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(longExtra);
                    Intent intent;
                    if (FavTagEditUI.this.mjP != null) {
                        FavTagEditUI.m66454a(FavTagEditUI.this.mjP, tagList, FavTagEditUI.this.getIntent().getIntExtra("key_fav_scene", 1));
                        intent = new Intent();
                        intent.putExtra("key_fav_result_list", tagList);
                        FavTagEditUI.this.setResult(-1, intent);
                    } else {
                        String[] strArr = new String[tagList.size()];
                        Iterator it = tagList.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            int i2 = i + 1;
                            strArr[i] = (String) it.next();
                            i = i2;
                        }
                        intent = new Intent();
                        intent.putExtra("key_fav_result_array", strArr);
                        intent.putExtra("key_fav_result_list", tagList);
                        FavTagEditUI.this.setResult(-1, intent);
                    }
                    FavTagEditUI.this.finish();
                    FavTagEditUI.this.aqX();
                    AppMethodBeat.m2505o(74139);
                }
                return true;
            }
        }, C5535b.GREEN);
        bvN();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73772a(this.mjW);
        AppMethodBeat.m2505o(74153);
    }

    private void bvN() {
        AppMethodBeat.m2504i(74154);
        if (this.mjY) {
            C4990ab.m7420w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
            if (dxX()) {
                enableOptionMenu(0, false);
            }
            AppMethodBeat.m2505o(74154);
            return;
        }
        if (this.mjP == null) {
            if (this.mjS.getTagCount() > 0 || this.mjS.getEditText().length() > 0) {
                if (!dxX()) {
                    enableOptionMenu(0, true);
                    AppMethodBeat.m2505o(74154);
                    return;
                }
            } else if (dxX()) {
                enableOptionMenu(0, false);
                AppMethodBeat.m2505o(74154);
                return;
            }
        } else if (this.mjP.field_tagProto.wiJ.size() == this.mjS.getTagCount() && this.mjS.getEditText().length() <= 0) {
            ArrayList tagList = this.mjS.getTagList();
            int i = 0;
            while (i < tagList.size()) {
                if (((String) tagList.get(i)).equals(this.mjP.field_tagProto.wiJ.get(i))) {
                    i++;
                } else {
                    if (!dxX()) {
                        enableOptionMenu(0, true);
                    }
                    AppMethodBeat.m2505o(74154);
                    return;
                }
            }
            if (dxX()) {
                enableOptionMenu(0, false);
            }
        } else if (!dxX()) {
            enableOptionMenu(0, true);
            AppMethodBeat.m2505o(74154);
            return;
        }
        AppMethodBeat.m2505o(74154);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74155);
        super.onDestroy();
        C45927l favTagSetMgr = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr();
        C34149c c34149c = this.mjW;
        if (c34149c == null) {
            AppMethodBeat.m2505o(74155);
            return;
        }
        favTagSetMgr.fBy.remove(c34149c.toString());
        AppMethodBeat.m2505o(74155);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(74156);
        if (i == 4) {
            bvO();
            AppMethodBeat.m2505o(74156);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(74156);
        return onKeyDown;
    }

    /* renamed from: a */
    public static void m66454a(C27966g c27966g, Collection<String> collection, int i) {
        AppMethodBeat.m2504i(74158);
        if (c27966g == null) {
            AppMethodBeat.m2505o(74158);
            return;
        }
        Set set;
        C4990ab.m7411d("MicroMsg.FavTagEditUI", "mod tags %s", collection);
        HashSet hashSet = new HashSet();
        hashSet.addAll(c27966g.field_tagProto.wiJ);
        c27966g.field_tagProto.wiJ.clear();
        if (collection == null || collection.isEmpty()) {
            set = hashSet;
        } else {
            c27966g.field_tagProto.wiJ.addAll(collection);
            hashSet.removeAll(collection);
            Object set2 = hashSet;
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
        C39037b.m66415p(c27966g);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73774e(set2);
        C39037b.m66358a(c27966g, i);
        AppMethodBeat.m2505o(74158);
    }

    private void bvO() {
        AppMethodBeat.m2504i(74157);
        C30379h.m48466d(this.mController.ylL, getString(C25738R.string.bqd), "", getString(C25738R.string.f8819fx), getString(C25738R.string.f9076or), new C390474(), null);
        AppMethodBeat.m2505o(74157);
    }
}
