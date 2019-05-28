package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI extends BaseLifeUI implements f {
    String color;
    private String dud = "";
    private OnClickListener nij = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22953);
            CheckInLifeUI.a(CheckInLifeUI.this, view, false);
            AppMethodBeat.o(22953);
        }
    };
    private boolean oRT = false;
    private String oSd = "";
    private b oSj;
    private b oSk;
    private ArrayList<LatLongData> oSl;
    private c oSm = null;
    private axw oSn;
    private OnClickListener oSo = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22954);
            CheckInLifeUI.a(CheckInLifeUI.this, view, true);
            AppMethodBeat.o(22954);
        }
    };
    private a oSp = new a() {
        public final void b(Addr addr) {
            AppMethodBeat.i(22955);
            ab.i("MicroMsg.CheckInLifeUI", "get info %s", addr.toString());
            if (bo.isNullOrNil(CheckInLifeUI.this.dud)) {
                CheckInLifeUI.this.dud = addr.fBi;
                if (!bo.isNullOrNil(CheckInLifeUI.this.dud)) {
                    CheckInLifeUI.this.oSj.fs(CheckInLifeUI.this.dud, addr.fBq);
                }
                AppMethodBeat.o(22955);
                return;
            }
            AppMethodBeat.o(22955);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CheckInLifeUI() {
        AppMethodBeat.i(22956);
        AppMethodBeat.o(22956);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22957);
        super.onCreate(bundle);
        setMMTitle((int) R.string.d4_);
        this.oSm = c.agw();
        this.oSn = new axw();
        this.oSd = getIntent().getStringExtra("get_poi_classify_id");
        try {
            this.oSn = (axw) this.oSn.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf"));
            if (this.oSn != null) {
                this.oSd = this.oSn.oQU;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            this.oSn = null;
        }
        if (bo.isNullOrNil(this.oSd)) {
            this.dud = getIntent().getStringExtra("get_city");
        }
        if (!bo.isNullOrNil(this.dud)) {
            this.oSd = this.oSj.fs(this.dud, "").oQU;
        }
        this.oSj.oSd = this.oSd;
        if (!(this.oSn == null || bo.isNullOrNil(this.oSn.oQU))) {
            b bVar = this.oSj;
            com.tencent.mm.plugin.nearlife.b.a aVar = new com.tencent.mm.plugin.nearlife.b.a("", this.oSn);
            if (bVar.oSb == null) {
                bVar.a(aVar, 1);
                AppMethodBeat.o(22957);
                return;
            }
            bVar.a(aVar, 2);
        }
        AppMethodBeat.o(22957);
    }

    public final void bVo() {
        AppMethodBeat.i(22958);
        super.bVo();
        AppMethodBeat.o(22958);
    }

    public void onResume() {
        AppMethodBeat.i(22959);
        super.onResume();
        AppMethodBeat.o(22959);
    }

    public void onDestroy() {
        AppMethodBeat.i(22960);
        super.onDestroy();
        if (this.oSm != null) {
            this.oSm.a(this.oSp);
        }
        AppMethodBeat.o(22960);
    }

    public void onPause() {
        AppMethodBeat.i(22961);
        super.onPause();
        AppMethodBeat.o(22961);
    }

    public final int getLayoutId() {
        return R.layout.aid;
    }

    public final a bVm() {
        AppMethodBeat.i(22962);
        if (this.oSl == null) {
            this.oSl = M(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (getIntent().getStringExtra("select_radio_icon_color") != null) {
            this.color = getIntent().getStringExtra("select_radio_icon_color");
        }
        if (getIntent().getStringExtra("select_radio_icon_color") != null && getIntent().getStringExtra("get_poi_from_scene").equals("story")) {
            this.oRT = true;
            this.oRT = true;
        }
        if (this.oSj == null) {
            this.oSj = new b(this, this.nij, "viewlist", this.oRU, false, this.color);
            if (!(this.oSl == null || this.oSl.size() == 0)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.oSl.get(this.oSl.size() - 1));
                this.oSj.L(arrayList);
                this.oSj.oRu = false;
            }
            b bVar = this.oSj;
            AppMethodBeat.o(22962);
            return bVar;
        }
        a aVar = this.oSj;
        AppMethodBeat.o(22962);
        return aVar;
    }

    public final a bVn() {
        AppMethodBeat.i(22963);
        if (this.oSl == null) {
            this.oSl = M(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.oSk == null) {
            this.oSk = new b(this, this.oSo, "searchlist", this.oRU, true, this.color);
            this.oSk.L(this.oSl);
            this.oSk.oRu = true;
            b bVar = this.oSk;
            AppMethodBeat.o(22963);
            return bVar;
        }
        a aVar = this.oSk;
        AppMethodBeat.o(22963);
        return aVar;
    }

    public final void p(double d, double d2) {
        AppMethodBeat.i(22964);
        ab.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", Double.valueOf(d), Double.valueOf(d2));
        if (this.oSm != null && bo.isNullOrNil(this.dud)) {
            this.oSm.a(d, d2, this.oSp);
        }
        AppMethodBeat.o(22964);
    }

    private static ArrayList<LatLongData> M(ArrayList<String> arrayList) {
        AppMethodBeat.i(22965);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(22965);
            return null;
        }
        ArrayList<LatLongData> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split(IOUtils.LINE_SEPARATOR_UNIX);
            if (2 == split.length) {
                try {
                    arrayList2.add(new LatLongData(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue()));
                } catch (NumberFormatException e) {
                }
            }
        }
        ab.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + arrayList2.size());
        AppMethodBeat.o(22965);
        return arrayList2;
    }

    static /* synthetic */ void a(CheckInLifeUI checkInLifeUI, View view, boolean z) {
        AppMethodBeat.i(22966);
        ab.d("MicroMsg.CheckInLifeUI", "click tag");
        if (view.getTag() instanceof a) {
            LatLongData TC;
            int TE;
            a aVar = (a) view.getTag();
            com.tencent.mm.plugin.nearlife.b.a aVar2 = aVar.oSf;
            Intent intent = new Intent();
            try {
                intent.putExtra("get_poi_item_buf", aVar2.oRd.toByteArray());
                intent.putExtra("location_ctx", aVar2.oRc.getBuffer().wR);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            }
            if (z) {
                TC = checkInLifeUI.oSk.TC(aVar.oQU);
                TE = checkInLifeUI.oSk.TE(aVar.oQU);
                checkInLifeUI.a(TE, true, aVar.oQU, checkInLifeUI.oRT);
            } else {
                TC = checkInLifeUI.oSj.TC(aVar.oQU);
                TE = checkInLifeUI.oSj.TE(aVar.oQU);
                checkInLifeUI.a(TE, false, aVar.oQU, checkInLifeUI.oRT);
            }
            intent.putExtra("report_index", TE);
            intent.putExtra("first_start_time", checkInLifeUI.oRM);
            intent.putExtra("lastSuccStamp", checkInLifeUI.oRO);
            intent.putExtra("firstSuccStamp", checkInLifeUI.oRN);
            intent.putExtra("reqLoadCnt", checkInLifeUI.oRP);
            intent.putExtra("entry_time", checkInLifeUI.nPQ);
            intent.putExtra("search_id", aVar2.nQA);
            intent.putExtra("request_id", aVar2.nQB);
            if (TC == null) {
                if (checkInLifeUI.oRH == null) {
                    TC = new LatLongData(-85.0f, -1000.0f);
                } else {
                    TC = new LatLongData(checkInLifeUI.oRH.vRq, checkInLifeUI.oRH.vRp);
                }
            }
            ab.i("MicroMsg.CheckInLifeUI", "lbs.Type %d", Integer.valueOf(aVar2.jCt));
            switch (aVar.type) {
                case 0:
                    if (TC != null) {
                        intent.putExtra("get_lat", TC.cEB);
                        intent.putExtra("get_lng", TC.fFz);
                    }
                    if (!bo.isNullOrNil(checkInLifeUI.dud)) {
                        intent.putExtra("get_city", checkInLifeUI.dud);
                    }
                    intent.putExtra("get_poi_classify_type", aVar2.jCt);
                    intent.putExtra("get_poi_address", a.cs(aVar2.oQZ));
                    intent.putExtra("get_poi_classify_id", aVar2.oQU);
                    intent.putExtra("get_poi_name", aVar2.Title);
                    intent.putExtra("get_poi_showflag", aVar2.dtW);
                    break;
                case 1:
                    if (TC != null) {
                        intent.putExtra("get_lat", TC.cEB);
                        intent.putExtra("get_lng", TC.fFz);
                    }
                    intent.putExtra("get_city", aVar2.Title);
                    break;
            }
            intent.putExtra("get_cur_lat", checkInLifeUI.oRI);
            intent.putExtra("get_cur_lng", checkInLifeUI.oRJ);
            intent.putExtra("get_accuracy", checkInLifeUI.oRL);
            intent.putExtra("get_loctype", checkInLifeUI.oRK);
            intent.putExtra("get_is_mars", checkInLifeUI.fBD);
            checkInLifeUI.setResult(-1, intent);
            checkInLifeUI.finish();
        }
        checkInLifeUI.aqX();
        AppMethodBeat.o(22966);
    }
}
