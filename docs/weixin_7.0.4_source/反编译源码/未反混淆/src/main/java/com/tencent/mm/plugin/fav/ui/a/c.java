package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c extends BaseAdapter implements com.tencent.mm.plugin.fav.a.l.a, com.tencent.mm.ui.base.MMTagPanel.a {
    private Context context;
    private int mlt = R.color.w4;
    private int mlu = R.drawable.nv;
    private Set<String> mlv = new HashSet();

    public static class a {
        TextView jKK;
        FavTagPanel mlw;
    }

    public abstract void Ma(String str);

    public abstract void Mb(String str);

    public c(Context context) {
        this.context = context;
    }

    public int getCount() {
        ((ae) g.M(ae.class)).getFavTagSetMgr();
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.layout.z1, null);
            a aVar2 = new a();
            aVar2.jKK = (TextView) view.findViewById(R.id.brt);
            aVar2.mlw = (FavTagPanel) view.findViewById(R.id.bru);
            aVar2.mlw.setCallBack(this);
            aVar2.mlw.setTagNormalBG(this.mlu);
            aVar2.mlw.setTagNormalTextColorRes(this.mlt);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        FavTagPanel favTagPanel = aVar.mlw;
        Set set = this.mlv;
        List<abp> vy = ((ae) g.M(ae.class)).getFavTagSetMgr().vy(i);
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
            ab.e(str, str2, objArr);
        } else {
            ab.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", Integer.valueOf(vy.size()));
            LinkedList linkedList = new LinkedList();
            for (abp abp : vy) {
                linkedList.add(abp.rMJ);
            }
            favTagPanel.a((Collection) set, (List) linkedList);
        }
        return view;
    }

    public final void JT(String str) {
    }

    public final void JU(String str) {
    }

    public final void JV(String str) {
    }

    public final void bmm() {
    }

    public final void Me(String str) {
        this.mlv.add(str);
        notifyDataSetChanged();
    }

    public final void Mf(String str) {
        this.mlv.remove(str);
        notifyDataSetChanged();
    }

    public final void bQ(List<String> list) {
        this.mlv.clear();
        if (list != null) {
            this.mlv.addAll(list);
        }
    }

    public final void JS(String str) {
        Me(str);
        Ma(str);
    }

    public final void JR(String str) {
        Mf(str);
        Mb(str);
    }

    public final void buF() {
        ab.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    public final void buG() {
        ab.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    public final void q(boolean z, int i) {
    }

    public /* synthetic */ Object getItem(int i) {
        return ((ae) g.M(ae.class)).getFavTagSetMgr().vy(i);
    }
}
