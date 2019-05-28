package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends BaseAdapter {
    Context mContext;
    String mKey = "";
    OnClickListener mjE;
    protected String oRh = "";
    boolean oRm = false;
    private ArrayList<com.tencent.mm.plugin.nearlife.b.a> oRn = new ArrayList();
    private HashSet<String> oRo = new HashSet();
    ArrayList<LatLongData> oRp = null;
    private Map<LatLongData, SKBuiltinBuffer_t> oRq;
    private Map<LatLongData, Integer> oRr;
    private Map<String, LatLongData> oRs;
    LatLongData oRt;
    boolean oRu = true;
    int oRv = 0;

    public a(Context context, OnClickListener onClickListener, String str, boolean z) {
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

    public final void a(com.tencent.mm.plugin.nearlife.b.a aVar, int i) {
        if (!this.oRo.contains(aVar.oQU) && i <= this.oRn.size()) {
            this.oRn.add(i, aVar);
            this.oRo.add(aVar.oQU);
            this.oRs.put(aVar.oQU, this.oRt);
        }
    }

    public final void a(LatLongData latLongData, List<com.tencent.mm.plugin.nearlife.b.a> list) {
        ab.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", this.mKey, Integer.valueOf(list.size()));
        for (com.tencent.mm.plugin.nearlife.b.a aVar : list) {
            if (!this.oRo.contains(aVar.oQU)) {
                this.oRn.add(aVar);
                this.oRo.add(aVar.oQU);
                this.oRs.put(aVar.oQU, latLongData);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.oRn.size();
    }

    /* renamed from: Ad */
    public final com.tencent.mm.plugin.nearlife.b.a getItem(int i) {
        if (i < 0 || i >= this.oRn.size()) {
            return new com.tencent.mm.plugin.nearlife.b.a("", new axw());
        }
        return (com.tencent.mm.plugin.nearlife.b.a) this.oRn.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public static String cs(List<bts> list) {
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

    public final void TB(String str) {
        if (str != null) {
            this.oRh = str;
        }
    }

    public final String bVk() {
        return this.oRh;
    }

    public final void L(ArrayList<LatLongData> arrayList) {
        if (arrayList != null) {
            this.oRp = arrayList;
        }
    }

    public final SKBuiltinBuffer_t a(LatLongData latLongData) {
        if (this.oRq.containsKey(latLongData)) {
            return (SKBuiltinBuffer_t) this.oRq.get(latLongData);
        }
        return null;
    }

    public final int b(LatLongData latLongData) {
        if (this.oRr.containsKey(latLongData)) {
            return ((Integer) this.oRr.get(latLongData)).intValue();
        }
        return 1;
    }

    public final boolean bVl() {
        Iterator it = this.oRp.iterator();
        while (it.hasNext()) {
            if (b((LatLongData) it.next()) > 0) {
                return true;
            }
        }
        if (this.oRu) {
            return b(this.oRt) > 0;
        } else {
            return false;
        }
    }

    public final void a(LatLongData latLongData, int i, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
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
        ab.d(str, str2, objArr);
        if (this.oRp.contains(latLongData) || (this.oRt != null && this.oRt.equals(latLongData))) {
            this.oRr.put(latLongData, Integer.valueOf(i));
            this.oRq.put(latLongData, sKBuiltinBuffer_t);
        }
    }

    public final LatLongData TC(String str) {
        if (this.oRs.containsKey(str)) {
            return (LatLongData) this.oRs.get(str);
        }
        return null;
    }

    public final boolean TD(String str) {
        String trim = str.trim();
        Iterator it = this.oRn.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.nearlife.b.a aVar = (com.tencent.mm.plugin.nearlife.b.a) it.next();
            if (!bo.isNullOrNil(aVar.Title) && trim.equals(aVar.Title.trim())) {
                return true;
            }
        }
        return false;
    }

    public final int TE(String str) {
        Iterator it = this.oRn.iterator();
        int i = -1;
        while (it.hasNext()) {
            i++;
            if (((com.tencent.mm.plugin.nearlife.b.a) it.next()).oQU.equals(str)) {
                break;
            }
        }
        return i;
    }
}
