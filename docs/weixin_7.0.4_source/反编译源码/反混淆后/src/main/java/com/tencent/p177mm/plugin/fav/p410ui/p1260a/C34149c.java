package com.tencent.p177mm.plugin.fav.p410ui.p1260a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.MMTagPanel.C44799a;
import com.tencent.p177mm.plugin.fav.p407a.C45927l.C43058a;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavTagPanel;
import com.tencent.p177mm.protocal.protobuf.abp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.ui.a.c */
public abstract class C34149c extends BaseAdapter implements C43058a, C44799a {
    private Context context;
    private int mlt = C25738R.color.f12212w4;
    private int mlu = C25738R.drawable.f6714nv;
    private Set<String> mlv = new HashSet();

    /* renamed from: com.tencent.mm.plugin.fav.ui.a.c$a */
    public static class C34150a {
        TextView jKK;
        FavTagPanel mlw;
    }

    /* renamed from: Ma */
    public abstract void mo23718Ma(String str);

    /* renamed from: Mb */
    public abstract void mo23719Mb(String str);

    public C34149c(Context context) {
        this.context = context;
    }

    public int getCount() {
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr();
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C34150a c34150a;
        if (view == null) {
            view = View.inflate(this.context, 2130969530, null);
            C34150a c34150a2 = new C34150a();
            c34150a2.jKK = (TextView) view.findViewById(2131823978);
            c34150a2.mlw = (FavTagPanel) view.findViewById(2131823979);
            c34150a2.mlw.setCallBack(this);
            c34150a2.mlw.setTagNormalBG(this.mlu);
            c34150a2.mlw.setTagNormalTextColorRes(this.mlt);
            view.setTag(c34150a2);
            c34150a = c34150a2;
        } else {
            c34150a = (C34150a) view.getTag();
        }
        FavTagPanel favTagPanel = c34150a.mlw;
        Set set = this.mlv;
        List<abp> vy = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73776vy(i);
        if (vy == null || vy.isEmpty()) {
            boolean z;
            String str = "MicroMsg.FavTagPanel";
            String str2 = "setTagListByTagInfo,null == tags ?%B,";
            Object[] objArr = new Object[1];
            if (vy == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
        } else {
            C4990ab.m7417i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", Integer.valueOf(vy.size()));
            LinkedList linkedList = new LinkedList();
            for (abp abp : vy) {
                linkedList.add(abp.rMJ);
            }
            favTagPanel.mo71950a((Collection) set, (List) linkedList);
        }
        return view;
    }

    /* renamed from: JT */
    public final void mo23724JT(String str) {
    }

    /* renamed from: JU */
    public final void mo23725JU(String str) {
    }

    /* renamed from: JV */
    public final void mo23726JV(String str) {
    }

    public final void bmm() {
    }

    /* renamed from: Me */
    public final void mo54728Me(String str) {
        this.mlv.add(str);
        notifyDataSetChanged();
    }

    /* renamed from: Mf */
    public final void mo54729Mf(String str) {
        this.mlv.remove(str);
        notifyDataSetChanged();
    }

    /* renamed from: bQ */
    public final void mo54730bQ(List<String> list) {
        this.mlv.clear();
        if (list != null) {
            this.mlv.addAll(list);
        }
    }

    /* renamed from: JS */
    public final void mo23723JS(String str) {
        mo54728Me(str);
        mo23718Ma(str);
    }

    /* renamed from: JR */
    public final void mo23722JR(String str) {
        mo54729Mf(str);
        mo23719Mb(str);
    }

    public final void buF() {
        C4990ab.m7410d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    public final void buG() {
        C4990ab.m7410d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    /* renamed from: q */
    public final void mo23728q(boolean z, int i) {
    }

    public /* synthetic */ Object getItem(int i) {
        return ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73776vy(i);
    }
}
