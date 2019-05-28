package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.nearlife.p1494b.C39460a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.axw;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.a */
public abstract class C46112a extends BaseAdapter {
    Context mContext;
    String mKey = "";
    OnClickListener mjE;
    protected String oRh = "";
    boolean oRm = false;
    private ArrayList<C39460a> oRn = new ArrayList();
    private HashSet<String> oRo = new HashSet();
    ArrayList<LatLongData> oRp = null;
    private Map<LatLongData, SKBuiltinBuffer_t> oRq;
    private Map<LatLongData, Integer> oRr;
    private Map<String, LatLongData> oRs;
    LatLongData oRt;
    boolean oRu = true;
    int oRv = 0;

    public C46112a(Context context, OnClickListener onClickListener, String str, boolean z) {
        this.mContext = context;
        this.mjE = onClickListener;
        this.mKey = str;
        this.oRm = z;
        this.oRp = new ArrayList();
        this.oRq = new HashMap();
        this.oRr = new HashMap();
        this.oRs = new HashMap();
    }

    public final void bVj() {
        this.oRn.clear();
        this.oRo.clear();
        this.oRr.clear();
        this.oRq.clear();
        this.oRs.clear();
        this.oRv = 0;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public final void mo74047a(C39460a c39460a, int i) {
        if (!this.oRo.contains(c39460a.oQU) && i <= this.oRn.size()) {
            this.oRn.add(i, c39460a);
            this.oRo.add(c39460a.oQU);
            this.oRs.put(c39460a.oQU, this.oRt);
        }
    }

    /* renamed from: a */
    public final void mo74049a(LatLongData latLongData, List<C39460a> list) {
        C4990ab.m7417i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", this.mKey, Integer.valueOf(list.size()));
        for (C39460a c39460a : list) {
            if (!this.oRo.contains(c39460a.oQU)) {
                this.oRn.add(c39460a);
                this.oRo.add(c39460a.oQU);
                this.oRs.put(c39460a.oQU, latLongData);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.oRn.size();
    }

    /* renamed from: Ad */
    public final C39460a getItem(int i) {
        if (i < 0 || i >= this.oRn.size()) {
            return new C39460a("", new axw());
        }
        return (C39460a) this.oRn.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    /* renamed from: cs */
    public static String m86043cs(List<bts> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuffer.toString();
            }
            bts bts = (bts) list.get(i2);
            if (!(bts == null || bts.wVI == null || bts.wVI.equals("") || bts.wVI.toLowerCase().equals(BuildConfig.COMMAND))) {
                stringBuffer.append(bts.wVI);
                if (i2 < list.size() - 1) {
                    stringBuffer.append("·");
                }
            }
            i = i2 + 1;
        }
    }

    /* renamed from: TB */
    public final void mo74042TB(String str) {
        if (str != null) {
            this.oRh = str;
        }
    }

    public final String bVk() {
        return this.oRh;
    }

    /* renamed from: L */
    public final void mo74041L(ArrayList<LatLongData> arrayList) {
        if (arrayList != null) {
            this.oRp = arrayList;
        }
    }

    /* renamed from: a */
    public final SKBuiltinBuffer_t mo74046a(LatLongData latLongData) {
        if (this.oRq.containsKey(latLongData)) {
            return (SKBuiltinBuffer_t) this.oRq.get(latLongData);
        }
        return null;
    }

    /* renamed from: b */
    public final int mo74050b(LatLongData latLongData) {
        if (this.oRr.containsKey(latLongData)) {
            return ((Integer) this.oRr.get(latLongData)).intValue();
        }
        return 1;
    }

    public final boolean bVl() {
        Iterator it = this.oRp.iterator();
        while (it.hasNext()) {
            if (mo74050b((LatLongData) it.next()) > 0) {
                return true;
            }
        }
        if (this.oRu) {
            return mo74050b(this.oRt) > 0;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public final void mo74048a(LatLongData latLongData, int i, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        int i2 = 0;
        String str = "MicroMsg.BaseLifeAdapter";
        String str2 = "set flag & buf, lat:%f long:%f flag:%d len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Float.valueOf(latLongData.cEB);
        objArr[1] = Float.valueOf(latLongData.fFz);
        objArr[2] = Integer.valueOf(i);
        if (sKBuiltinBuffer_t != null) {
            i2 = sKBuiltinBuffer_t.getILen();
        }
        objArr[3] = Integer.valueOf(i2);
        C4990ab.m7411d(str, str2, objArr);
        if (this.oRp.contains(latLongData) || (this.oRt != null && this.oRt.equals(latLongData))) {
            this.oRr.put(latLongData, Integer.valueOf(i));
            this.oRq.put(latLongData, sKBuiltinBuffer_t);
        }
    }

    /* renamed from: TC */
    public final LatLongData mo74043TC(String str) {
        if (this.oRs.containsKey(str)) {
            return (LatLongData) this.oRs.get(str);
        }
        return null;
    }

    /* renamed from: TD */
    public final boolean mo74044TD(String str) {
        String trim = str.trim();
        Iterator it = this.oRn.iterator();
        while (it.hasNext()) {
            C39460a c39460a = (C39460a) it.next();
            if (!C5046bo.isNullOrNil(c39460a.Title) && trim.equals(c39460a.Title.trim())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: TE */
    public final int mo74045TE(String str) {
        Iterator it = this.oRn.iterator();
        int i = -1;
        while (it.hasNext()) {
            i++;
            if (((C39460a) it.next()).oQU.equals(str)) {
                break;
            }
        }
        return i;
    }
}
