package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.modelgeo.C18657c;
import com.tencent.p177mm.modelgeo.C18657c.C18660a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.plugin.nearlife.p1494b.C39460a;
import com.tencent.p177mm.plugin.nearlife.p471ui.C12711b.C12712a;
import com.tencent.p177mm.protocal.protobuf.axw;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI */
public class CheckInLifeUI extends BaseLifeUI implements C1202f {
    String color;
    private String dud = "";
    private OnClickListener nij = new C127081();
    private boolean oRT = false;
    private String oSd = "";
    private C12711b oSj;
    private C12711b oSk;
    private ArrayList<LatLongData> oSl;
    private C18657c oSm = null;
    private axw oSn;
    private OnClickListener oSo = new C127092();
    private C18660a oSp = new C461113();

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI$1 */
    class C127081 implements OnClickListener {
        C127081() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22953);
            CheckInLifeUI.m86040a(CheckInLifeUI.this, view, false);
            AppMethodBeat.m2505o(22953);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI$2 */
    class C127092 implements OnClickListener {
        C127092() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22954);
            CheckInLifeUI.m86040a(CheckInLifeUI.this, view, true);
            AppMethodBeat.m2505o(22954);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI$3 */
    class C461113 implements C18660a {
        C461113() {
        }

        /* renamed from: b */
        public final void mo8746b(Addr addr) {
            AppMethodBeat.m2504i(22955);
            C4990ab.m7417i("MicroMsg.CheckInLifeUI", "get info %s", addr.toString());
            if (C5046bo.isNullOrNil(CheckInLifeUI.this.dud)) {
                CheckInLifeUI.this.dud = addr.fBi;
                if (!C5046bo.isNullOrNil(CheckInLifeUI.this.dud)) {
                    CheckInLifeUI.this.oSj.mo24711fs(CheckInLifeUI.this.dud, addr.fBq);
                }
                AppMethodBeat.m2505o(22955);
                return;
            }
            AppMethodBeat.m2505o(22955);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CheckInLifeUI() {
        AppMethodBeat.m2504i(22956);
        AppMethodBeat.m2505o(22956);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22957);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.d4_);
        this.oSm = C18657c.agw();
        this.oSn = new axw();
        this.oSd = getIntent().getStringExtra("get_poi_classify_id");
        try {
            this.oSn = (axw) this.oSn.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf"));
            if (this.oSn != null) {
                this.oSd = this.oSn.oQU;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            this.oSn = null;
        }
        if (C5046bo.isNullOrNil(this.oSd)) {
            this.dud = getIntent().getStringExtra("get_city");
        }
        if (!C5046bo.isNullOrNil(this.dud)) {
            this.oSd = this.oSj.mo24711fs(this.dud, "").oQU;
        }
        this.oSj.oSd = this.oSd;
        if (!(this.oSn == null || C5046bo.isNullOrNil(this.oSn.oQU))) {
            C12711b c12711b = this.oSj;
            C39460a c39460a = new C39460a("", this.oSn);
            if (c12711b.oSb == null) {
                c12711b.mo74047a(c39460a, 1);
                AppMethodBeat.m2505o(22957);
                return;
            }
            c12711b.mo74047a(c39460a, 2);
        }
        AppMethodBeat.m2505o(22957);
    }

    public final void bVo() {
        AppMethodBeat.m2504i(22958);
        super.bVo();
        AppMethodBeat.m2505o(22958);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22959);
        super.onResume();
        AppMethodBeat.m2505o(22959);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22960);
        super.onDestroy();
        if (this.oSm != null) {
            this.oSm.mo33925a(this.oSp);
        }
        AppMethodBeat.m2505o(22960);
    }

    public void onPause() {
        AppMethodBeat.m2504i(22961);
        super.onPause();
        AppMethodBeat.m2505o(22961);
    }

    public final int getLayoutId() {
        return 2130970285;
    }

    public final C46112a bVm() {
        AppMethodBeat.m2504i(22962);
        if (this.oSl == null) {
            this.oSl = CheckInLifeUI.m86037M(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (getIntent().getStringExtra("select_radio_icon_color") != null) {
            this.color = getIntent().getStringExtra("select_radio_icon_color");
        }
        if (getIntent().getStringExtra("select_radio_icon_color") != null && getIntent().getStringExtra("get_poi_from_scene").equals("story")) {
            this.oRT = true;
            this.oRT = true;
        }
        if (this.oSj == null) {
            this.oSj = new C12711b(this, this.nij, "viewlist", this.oRU, false, this.color);
            if (!(this.oSl == null || this.oSl.size() == 0)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.oSl.get(this.oSl.size() - 1));
                this.oSj.mo74041L(arrayList);
                this.oSj.oRu = false;
            }
            C12711b c12711b = this.oSj;
            AppMethodBeat.m2505o(22962);
            return c12711b;
        }
        C46112a c46112a = this.oSj;
        AppMethodBeat.m2505o(22962);
        return c46112a;
    }

    public final C46112a bVn() {
        AppMethodBeat.m2504i(22963);
        if (this.oSl == null) {
            this.oSl = CheckInLifeUI.m86037M(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.oSk == null) {
            this.oSk = new C12711b(this, this.oSo, "searchlist", this.oRU, true, this.color);
            this.oSk.mo74041L(this.oSl);
            this.oSk.oRu = true;
            C12711b c12711b = this.oSk;
            AppMethodBeat.m2505o(22963);
            return c12711b;
        }
        C46112a c46112a = this.oSk;
        AppMethodBeat.m2505o(22963);
        return c46112a;
    }

    /* renamed from: p */
    public final void mo46734p(double d, double d2) {
        AppMethodBeat.m2504i(22964);
        C4990ab.m7417i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", Double.valueOf(d), Double.valueOf(d2));
        if (this.oSm != null && C5046bo.isNullOrNil(this.dud)) {
            this.oSm.mo33923a(d, d2, this.oSp);
        }
        AppMethodBeat.m2505o(22964);
    }

    /* renamed from: M */
    private static ArrayList<LatLongData> m86037M(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(22965);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.m2505o(22965);
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
        C4990ab.m7416i("MicroMsg.CheckInLifeUI", "parse list end, size: " + arrayList2.size());
        AppMethodBeat.m2505o(22965);
        return arrayList2;
    }

    /* renamed from: a */
    static /* synthetic */ void m86040a(CheckInLifeUI checkInLifeUI, View view, boolean z) {
        AppMethodBeat.m2504i(22966);
        C4990ab.m7410d("MicroMsg.CheckInLifeUI", "click tag");
        if (view.getTag() instanceof C12712a) {
            LatLongData TC;
            int TE;
            C12712a c12712a = (C12712a) view.getTag();
            C39460a c39460a = c12712a.oSf;
            Intent intent = new Intent();
            try {
                intent.putExtra("get_poi_item_buf", c39460a.oRd.toByteArray());
                intent.putExtra("location_ctx", c39460a.oRc.getBuffer().f1226wR);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            }
            if (z) {
                TC = checkInLifeUI.oSk.mo74043TC(c12712a.oQU);
                TE = checkInLifeUI.oSk.mo74045TE(c12712a.oQU);
                checkInLifeUI.mo46730a(TE, true, c12712a.oQU, checkInLifeUI.oRT);
            } else {
                TC = checkInLifeUI.oSj.mo74043TC(c12712a.oQU);
                TE = checkInLifeUI.oSj.mo74045TE(c12712a.oQU);
                checkInLifeUI.mo46730a(TE, false, c12712a.oQU, checkInLifeUI.oRT);
            }
            intent.putExtra("report_index", TE);
            intent.putExtra("first_start_time", checkInLifeUI.oRM);
            intent.putExtra("lastSuccStamp", checkInLifeUI.oRO);
            intent.putExtra("firstSuccStamp", checkInLifeUI.oRN);
            intent.putExtra("reqLoadCnt", checkInLifeUI.oRP);
            intent.putExtra("entry_time", checkInLifeUI.nPQ);
            intent.putExtra("search_id", c39460a.nQA);
            intent.putExtra("request_id", c39460a.nQB);
            if (TC == null) {
                if (checkInLifeUI.oRH == null) {
                    TC = new LatLongData(-85.0f, -1000.0f);
                } else {
                    TC = new LatLongData(checkInLifeUI.oRH.vRq, checkInLifeUI.oRH.vRp);
                }
            }
            C4990ab.m7417i("MicroMsg.CheckInLifeUI", "lbs.Type %d", Integer.valueOf(c39460a.jCt));
            switch (c12712a.type) {
                case 0:
                    if (TC != null) {
                        intent.putExtra("get_lat", TC.cEB);
                        intent.putExtra("get_lng", TC.fFz);
                    }
                    if (!C5046bo.isNullOrNil(checkInLifeUI.dud)) {
                        intent.putExtra("get_city", checkInLifeUI.dud);
                    }
                    intent.putExtra("get_poi_classify_type", c39460a.jCt);
                    intent.putExtra("get_poi_address", C46112a.m86043cs(c39460a.oQZ));
                    intent.putExtra("get_poi_classify_id", c39460a.oQU);
                    intent.putExtra("get_poi_name", c39460a.Title);
                    intent.putExtra("get_poi_showflag", c39460a.dtW);
                    break;
                case 1:
                    if (TC != null) {
                        intent.putExtra("get_lat", TC.cEB);
                        intent.putExtra("get_lng", TC.fFz);
                    }
                    intent.putExtra("get_city", c39460a.Title);
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
        AppMethodBeat.m2505o(22966);
    }
}
