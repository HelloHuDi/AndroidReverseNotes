package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i extends LinearLayout implements com.tencent.mm.aj.e.a {
    private Context context;
    private LinearLayout mpt = null;
    private List<String> zms;
    private Map<String, View> zmt;
    private a zmu;

    public interface a {
        void Pl(int i);
    }

    static /* synthetic */ void e(i iVar) {
        AppMethodBeat.i(33708);
        iVar.init();
        AppMethodBeat.o(33708);
    }

    public i(Context context, a aVar) {
        super(context);
        AppMethodBeat.i(33704);
        this.context = context;
        this.zmu = aVar;
        init();
        AppMethodBeat.o(33704);
    }

    public final int getEnterpriseFriendCount() {
        AppMethodBeat.i(33705);
        if (this.zms == null) {
            AppMethodBeat.o(33705);
            return 0;
        }
        int size = this.zms.size();
        AppMethodBeat.o(33705);
        return size;
    }

    private void init() {
        int i = 0;
        AppMethodBeat.i(33706);
        e aeR = z.aeR();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        e.a(stringBuilder);
        e.c(stringBuilder);
        stringBuilder.append(" and bizinfo.type = 2 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(e.aet());
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", stringBuilder.toString());
        Cursor rawQuery = aeR.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        this.zms = arrayList;
        if (this.zms == null || this.zms.size() <= 0) {
            ab.e("MicroMsg.EnterpriseBizView", "bizList is null");
            AppMethodBeat.o(33706);
            return;
        }
        ab.i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(this.zms.size()));
        this.zmt = new HashMap();
        if (this.mpt == null) {
            View.inflate(getContext(), R.layout.va, this);
            this.mpt = (LinearLayout) findViewById(R.id.nc);
        }
        while (i < this.zms.size()) {
            String str = (String) this.zms.get(i);
            j jVar = new j(getContext(), str);
            this.mpt.addView(jVar);
            this.zmt.put(str, jVar);
            if (i == this.zms.size() - 1) {
                jVar.findViewById(R.id.bhx).setBackgroundResource(R.drawable.a_q);
            }
            i++;
        }
        AppMethodBeat.o(33706);
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(33707);
        if (bVar.fwl == null) {
            AppMethodBeat.o(33707);
        } else if (bVar.fwl.adP()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33703);
                    aw.ZK();
                    ad aoO = c.XM().aoO(bVar.fuO);
                    if (i.this.zms == null || i.this.zms.size() <= 0 || !i.this.zms.contains(bVar.fuO)) {
                        if (aoO == null || ((int) aoO.ewQ) <= 0 || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                            AppMethodBeat.o(33703);
                            return;
                        }
                        if (i.this.zms != null) {
                            i.this.zms.clear();
                        }
                        if (i.this.zmt != null) {
                            i.this.zmt.clear();
                        }
                        if (i.this.mpt != null) {
                            i.this.mpt.removeAllViews();
                        }
                        i.e(i.this);
                        if (i.this.zmu != null) {
                            i.this.zmu.Pl(i.this.zms.size());
                        }
                    } else if (aoO == null || ((int) aoO.ewQ) <= 0 || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                        ab.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", bVar.fuO);
                        i.this.zms.remove(bVar.fuO);
                        if (i.this.zms.size() > 0) {
                            View view = (View) i.this.zmt.get(bVar.fuO);
                            if (!(view == null || i.this.mpt == null)) {
                                i.this.mpt.removeView(view);
                                i.this.zmt.remove(view);
                            }
                            AppMethodBeat.o(33703);
                            return;
                        } else if (i.this.zmu != null) {
                            if (i.this.zmt != null) {
                                i.this.zmt.clear();
                            }
                            if (i.this.mpt != null) {
                                i.this.mpt.removeAllViews();
                            }
                            i.this.zmu.Pl(i.this.zms.size());
                            AppMethodBeat.o(33703);
                            return;
                        }
                    }
                    AppMethodBeat.o(33703);
                }
            });
            AppMethodBeat.o(33707);
        } else {
            ab.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            AppMethodBeat.o(33707);
        }
    }
}
