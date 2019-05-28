package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppGrid */
public class AppGrid extends GridView {
    private Context context;
    private SharedPreferences ehZ;
    private OnItemClickListener jMk = new C440771();
    private OnItemLongClickListener mkF = new C440782();
    private int vlA;
    private C30113a vlB;
    private C40464b vlv;
    private int vlw;
    private int vlx = 0;
    private int vly = 0;
    private int vlz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppGrid$a */
    class C30113a extends BaseAdapter {
        List<C40439f> geU;
        private int vlD;
        private int vlE;
        private Map<String, C40439f> vlF = null;

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppGrid$a$a */
        class C30114a {
            ImageView iNr;
            TextView ngn;
            View qqT;
            TextView vlG;
            View vlH;

            C30114a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(27734);
            C40439f Fq = mo48382Fq(i);
            AppMethodBeat.m2505o(27734);
            return Fq;
        }

        public C30113a(Context context, List<C40439f> list, Map<String, C40439f> map) {
            AppMethodBeat.m2504i(27729);
            String str = "MicroMsg.AppGrid";
            String str2 = "AppGridAdapter infoList size:%s ";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
            C4990ab.m7417i(str, str2, objArr);
            this.geU = list;
            this.vlF = map;
            this.vlD = C4977b.m7371b(context, 56.0f);
            this.vlE = C4977b.m7371b(context, 53.3f);
            AppMethodBeat.m2505o(27729);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(27730);
            int f;
            if (AppGrid.this.vlz == AppGrid.this.vly - 1) {
                f = AppGrid.this.vlw - (AppGrid.this.vlz * AppGrid.this.vlx);
                AppMethodBeat.m2505o(27730);
                return f;
            }
            f = AppGrid.this.vlx;
            AppMethodBeat.m2505o(27730);
            return f;
        }

        /* renamed from: Fq */
        public final C40439f mo48382Fq(int i) {
            AppMethodBeat.m2504i(27731);
            if ((i >= AppGrid.this.vlA || AppGrid.this.vlz != 0) && (AppGrid.this.vlz * AppGrid.this.vlx) + i >= AppGrid.this.vlA && (i - AppGrid.this.vlA) + (AppGrid.this.vlz * AppGrid.this.vlx) < this.geU.size()) {
                C4990ab.m7419v("MicroMsg.AppGrid", "get item db pos: %d", Integer.valueOf((i - AppGrid.this.vlA) + (AppGrid.this.vlz * AppGrid.this.vlx)));
                C40439f c40439f = (C40439f) this.geU.get(r0);
                AppMethodBeat.m2505o(27731);
                return c40439f;
            }
            AppMethodBeat.m2505o(27731);
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C30114a c30114a;
            C40439f Fq;
            AppMethodBeat.m2504i(27732);
            if (view == null) {
                c30114a = new C30114a();
                view = View.inflate(AppGrid.this.context, 2130968752, null);
                c30114a.iNr = (ImageView) view.findViewById(2131821440);
                c30114a.qqT = view.findViewById(2131821439);
                c30114a.ngn = (TextView) view.findViewById(2131821441);
                c30114a.vlG = (TextView) view.findViewById(2131821442);
                c30114a.vlH = view.findViewById(2131821443);
                view.setTag(c30114a);
            } else {
                c30114a = (C30114a) view.getTag();
            }
            C4990ab.m7416i("MicroMsg.AppGrid", "pos:" + i + " page:" + AppGrid.this.vlz);
            c30114a.ngn.setVisibility(0);
            c30114a.vlH.setVisibility(8);
            c30114a.vlG.setVisibility(8);
            c30114a.qqT.setVisibility(0);
            LayoutParams layoutParams = c30114a.iNr.getLayoutParams();
            layoutParams.width = this.vlD;
            layoutParams.height = this.vlD;
            c30114a.iNr.setLayoutParams(layoutParams);
            int a = (AppGrid.this.vlz * AppGrid.this.vlx) + i;
            int Lb = AppGrid.this.vlv.mo48387Lb(a);
            if (a < AppGrid.this.vlA) {
                switch (Lb) {
                    case 0:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_pic);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9123q7));
                        break;
                    case 1:
                        if (!C1947ae.gjt) {
                            c30114a.iNr.setImageResource(C1318a.panel_icon_camera);
                            c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9121q4));
                            break;
                        }
                        c30114a.iNr.setImageResource(C1318a.panel_icon_sights);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9128qc));
                        break;
                    case 2:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_voip);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9132qh));
                        try {
                            C9638aw.m17190ZK();
                            if (!((Boolean) C18628c.m29072Ry().get(54, Boolean.FALSE)).booleanValue()) {
                                c30114a.vlG.setVisibility(8);
                                break;
                            }
                            c30114a.vlG.setVisibility(0);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 3:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_multitalk);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9134qj));
                        try {
                            C9638aw.m17190ZK();
                            if (!((Boolean) C18628c.m29072Ry().get(81, Boolean.FALSE)).booleanValue()) {
                                c30114a.vlG.setVisibility(8);
                                break;
                            }
                            c30114a.vlG.setVisibility(0);
                            break;
                        } catch (Exception e2) {
                            break;
                        }
                    case 4:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_voipvoice);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9134qj));
                        try {
                            C9638aw.m17190ZK();
                            if (!((Boolean) C18628c.m29072Ry().get(62, Boolean.FALSE)).booleanValue()) {
                                c30114a.vlG.setVisibility(8);
                                break;
                            }
                            c30114a.vlG.setVisibility(0);
                            break;
                        } catch (Exception e3) {
                            break;
                        }
                    case 5:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_wxtalk);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9129qd));
                        try {
                            C9638aw.m17190ZK();
                            if (!((Boolean) C18628c.m29072Ry().get(67, Boolean.FALSE)).booleanValue()) {
                                c30114a.vlG.setVisibility(8);
                                break;
                            }
                            c30114a.vlG.setVisibility(0);
                            break;
                        } catch (Exception e4) {
                            break;
                        }
                    case 6:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_location);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9119q2));
                        try {
                            C9638aw.m17190ZK();
                            if (!((Boolean) C18628c.m29072Ry().get(290817, Boolean.FALSE)).booleanValue()) {
                                c30114a.vlH.setVisibility(8);
                                break;
                            }
                            c30114a.vlH.setVisibility(0);
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                    case 7:
                        C4990ab.m7416i("MicroMsg.AppGrid", "attach lucky money");
                        m47687a(c30114a, C40439f.vbS, AppGrid.this.context.getString(C25738R.string.f9120q3));
                        break;
                    case 8:
                        C4990ab.m7416i("MicroMsg.AppGrid", "attach remittance");
                        m47687a(c30114a, C40439f.vbQ, AppGrid.this.context.getString(C25738R.string.f9130qe));
                        break;
                    case 9:
                        m47687a(c30114a, C40439f.vbT, null);
                        break;
                    case 10:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_voiceinput);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.cbb));
                        try {
                            C9638aw.m17190ZK();
                            if (!((Boolean) C18628c.m29072Ry().get(73, Boolean.FALSE)).booleanValue()) {
                                c30114a.vlG.setVisibility(8);
                                break;
                            }
                            c30114a.vlG.setVisibility(0);
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    case 11:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_fav);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9117q0));
                        break;
                    case 12:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_friendcard);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9114pw));
                        break;
                    case 13:
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.bc5));
                        try {
                            C9638aw.m17190ZK();
                            boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(208899, Boolean.FALSE)).booleanValue();
                            C9638aw.m17190ZK();
                            boolean booleanValue2 = ((Boolean) C18628c.m29072Ry().get(208913, Boolean.FALSE)).booleanValue();
                            if (!booleanValue && !booleanValue2) {
                                c30114a.vlG.setVisibility(8);
                                break;
                            }
                            c30114a.vlG.setVisibility(0);
                            if (!booleanValue2) {
                                c30114a.vlG.setText(C25738R.string.f9181s0);
                                break;
                            }
                            c30114a.vlG.setText(C25738R.string.f9144qv);
                            break;
                        } catch (Exception e7) {
                            break;
                        }
                    case 14:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_service);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9127qb));
                        try {
                            C9638aw.m17190ZK();
                            if (!((Boolean) C18628c.m29072Ry().get(327744, Boolean.TRUE)).booleanValue()) {
                                c30114a.vlH.setVisibility(8);
                                break;
                            }
                            c30114a.vlH.setVisibility(0);
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    case 15:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_enterprise);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9116pz));
                        try {
                            c30114a.vlH.setVisibility(8);
                            break;
                        } catch (Exception e9) {
                            break;
                        }
                    case 16:
                        c30114a.iNr.setImageResource(C1318a.panel_icon_file_explorer);
                        c30114a.ngn.setText(AppGrid.this.context.getString(C25738R.string.f9118q1));
                        break;
                }
            }
            layoutParams.width = this.vlE;
            layoutParams.height = this.vlE;
            c30114a.iNr.setLayoutParams(layoutParams);
            Fq = mo48382Fq(i);
            if (Fq != null) {
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    if (Fq.field_status == 5) {
                        C46494g.m87732b(Fq.field_appId, 3, C1338a.getDensity(AppGrid.this.context));
                    } else if (Fq.dhx()) {
                        C46494g.m87732b(Fq.field_appId, 4, C1338a.getDensity(AppGrid.this.context));
                    } else {
                        C46494g.m87732b(Fq.field_appId, 1, C1338a.getDensity(AppGrid.this.context));
                    }
                    if (C40439f.vbQ.equals(Fq.field_appId)) {
                        c30114a.iNr.setImageResource(C1318a.panel_icon_transfer);
                    } else if (C40439f.vbS.equals(Fq.field_appId)) {
                        c30114a.iNr.setImageResource(C1318a.panel_icon_luckymoney);
                    } else if (C40439f.vbR.equals(Fq.field_appId)) {
                        c30114a.iNr.setImageResource(C1318a.panel_icon_card);
                    } else if (C40439f.vbT.equals(Fq.field_appId)) {
                        c30114a.iNr.setImageResource(C1318a.panel_icon_aa);
                    } else {
                        c30114a.iNr.setBackgroundResource(C25738R.drawable.awg);
                    }
                } else {
                    c30114a.iNr.setBackgroundResource(C25738R.drawable.ao_);
                }
                c30114a.ngn.setText(C46494g.m87733b(AppGrid.this.context, Fq, null));
                if (Fq.dhx() && Fq.dhy()) {
                    if (AppGrid.this.ehZ == null) {
                        AppGrid.this.ehZ = AppGrid.this.context.getSharedPreferences(C4996ah.doA(), 0);
                    }
                    if (AppGrid.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + Fq.field_appId, true)) {
                        c30114a.vlG.setVisibility(0);
                    }
                }
            }
            Fq = mo48382Fq(i);
            if (Fq != null && C46494g.m87753l(Fq)) {
                c30114a.vlG.setVisibility(0);
            }
            AppMethodBeat.m2505o(27732);
            return view;
        }

        /* renamed from: a */
        private void m47687a(C30114a c30114a, String str, String str2) {
            AppMethodBeat.m2504i(27733);
            if (this.vlF == null) {
                C4990ab.m7420w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
                AppMethodBeat.m2505o(27733);
                return;
            }
            C40439f c40439f = (C40439f) this.vlF.get(str);
            if (c40439f == null) {
                C4990ab.m7420w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
                AppMethodBeat.m2505o(27733);
                return;
            }
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                if (c40439f.dhx()) {
                    C46494g.m87732b(c40439f.field_appId, 4, C1338a.getDensity(AppGrid.this.context));
                }
                if (C40439f.vbQ.equals(c40439f.field_appId)) {
                    c30114a.iNr.setImageResource(C1318a.panel_icon_transfer);
                } else if (C40439f.vbS.equals(c40439f.field_appId)) {
                    c30114a.iNr.setImageResource(C1318a.panel_icon_luckymoney);
                } else if (C40439f.vbR.equals(c40439f.field_appId)) {
                    c30114a.iNr.setImageResource(C1318a.panel_icon_card);
                } else if (C40439f.vbT.equals(c40439f.field_appId)) {
                    c30114a.iNr.setImageResource(C1318a.panel_icon_aa);
                } else {
                    c30114a.iNr.setImageResource(C25738R.drawable.awg);
                }
            } else {
                c30114a.iNr.setImageResource(C25738R.drawable.ao_);
            }
            if (C5046bo.isNullOrNil(str2)) {
                c30114a.ngn.setText(C46494g.m87733b(AppGrid.this.context, c40439f, null));
            } else {
                c30114a.ngn.setText(C46494g.m87741c(AppGrid.this.context, c40439f, str2));
            }
            if (c40439f.dhx() && c40439f.dhy()) {
                if (AppGrid.this.ehZ == null) {
                    AppGrid.this.ehZ = AppGrid.this.context.getSharedPreferences(C4996ah.doA(), 0);
                }
                if (AppGrid.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + c40439f.field_appId, true)) {
                    c30114a.vlG.setVisibility(0);
                }
            }
            int intValue;
            if (C40439f.vbQ.equals(c40439f.field_appId)) {
                C9638aw.m17190ZK();
                intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue <= 1) {
                    AppMethodBeat.m2505o(27733);
                    return;
                }
                C9638aw.m17190ZK();
                if (!C5046bo.m7508P(((String) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                    c30114a.vlG.setVisibility(0);
                }
                AppMethodBeat.m2505o(27733);
                return;
            }
            if (C40439f.vbS.equals(c40439f.field_appId)) {
                if (C16112c.m24429PK().mo28546a(C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_APP_PANEL_STRING_SYNC)) {
                    c30114a.vlH.setVisibility(0);
                } else {
                    c30114a.vlH.setVisibility(8);
                }
                C9638aw.m17190ZK();
                intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue <= 1) {
                    c30114a.vlG.setVisibility(8);
                    AppMethodBeat.m2505o(27733);
                    return;
                }
                C9638aw.m17190ZK();
                if (!C5046bo.m7508P(((String) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                    c30114a.vlG.setVisibility(0);
                }
            }
            AppMethodBeat.m2505o(27733);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppGrid$b */
    public interface C40464b {
        /* renamed from: Lb */
        int mo48387Lb(int i);

        /* renamed from: Lc */
        void mo48388Lc(int i);

        /* renamed from: a */
        void mo48389a(int i, C40439f c40439f);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppGrid$1 */
    class C440771 implements OnItemClickListener {
        C440771() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(27727);
            AppGrid.this.vlv.mo48389a(AppGrid.this.vlv.mo48387Lb((AppGrid.this.vlz * AppGrid.this.vlx) + i), AppGrid.this.vlB.mo48382Fq(i));
            AppMethodBeat.m2505o(27727);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppGrid$2 */
    class C440782 implements OnItemLongClickListener {
        C440782() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(27728);
            C40464b c = AppGrid.this.vlv;
            int Lb = AppGrid.this.vlv.mo48387Lb((AppGrid.this.vlz * AppGrid.this.vlx) + i);
            AppGrid.this.vlB.mo48382Fq(i);
            c.mo48388Lc(Lb);
            AppMethodBeat.m2505o(27728);
            return true;
        }
    }

    public AppGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(27735);
        this.context = context;
        AppMethodBeat.m2505o(27735);
    }

    public AppGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27736);
        this.context = context;
        AppMethodBeat.m2505o(27736);
    }

    /* renamed from: d */
    public final void mo69783d(List<C40439f> list, Map<String, C40439f> map) {
        AppMethodBeat.m2504i(27737);
        this.vlB = new C30113a(this.context, list, map);
        setBackgroundResource(0);
        setAdapter(this.vlB);
        setOnItemClickListener(this.jMk);
        setOnItemLongClickListener(this.mkF);
        setPadding(C4977b.m7371b(this.context, 16.0f), C4977b.m7371b(this.context, 6.0f), C4977b.m7371b(this.context, 16.0f), 0);
        AppMethodBeat.m2505o(27737);
    }

    /* renamed from: La */
    public final void mo69781La(int i) {
        AppMethodBeat.m2504i(27738);
        if (i <= 0) {
            AppMethodBeat.m2505o(27738);
            return;
        }
        setPadding(C4977b.m7371b(this.context, 16.0f), i, C4977b.m7371b(this.context, 16.0f), 0);
        setVerticalSpacing(i / 2);
        AppMethodBeat.m2505o(27738);
    }

    /* renamed from: b */
    public final void mo69782b(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(27739);
        this.vlz = i;
        this.vlw = i2;
        this.vlx = i3;
        this.vly = i4;
        this.vlA = i6;
        setNumColumns(i5);
        AppMethodBeat.m2505o(27739);
    }

    public void setOnAppSelectedListener(C40464b c40464b) {
        this.vlv = c40464b;
    }

    public int getCount() {
        AppMethodBeat.m2504i(27740);
        int count = this.vlB.getCount();
        AppMethodBeat.m2505o(27740);
        return count;
    }
}
