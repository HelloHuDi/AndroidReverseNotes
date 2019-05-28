package com.tencent.mm.pluginsdk.ui.chat;

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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.Map;

public class AppGrid extends GridView {
    private Context context;
    private SharedPreferences ehZ;
    private OnItemClickListener jMk = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(27727);
            AppGrid.this.vlv.a(AppGrid.this.vlv.Lb((AppGrid.this.vlz * AppGrid.this.vlx) + i), AppGrid.this.vlB.Fq(i));
            AppMethodBeat.o(27727);
        }
    };
    private OnItemLongClickListener mkF = new OnItemLongClickListener() {
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(27728);
            b c = AppGrid.this.vlv;
            int Lb = AppGrid.this.vlv.Lb((AppGrid.this.vlz * AppGrid.this.vlx) + i);
            AppGrid.this.vlB.Fq(i);
            c.Lc(Lb);
            AppMethodBeat.o(27728);
            return true;
        }
    };
    private int vlA;
    private a vlB;
    private b vlv;
    private int vlw;
    private int vlx = 0;
    private int vly = 0;
    private int vlz;

    class a extends BaseAdapter {
        List<f> geU;
        private int vlD;
        private int vlE;
        private Map<String, f> vlF = null;

        class a {
            ImageView iNr;
            TextView ngn;
            View qqT;
            TextView vlG;
            View vlH;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(27734);
            f Fq = Fq(i);
            AppMethodBeat.o(27734);
            return Fq;
        }

        public a(Context context, List<f> list, Map<String, f> map) {
            AppMethodBeat.i(27729);
            String str = "MicroMsg.AppGrid";
            String str2 = "AppGridAdapter infoList size:%s ";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
            ab.i(str, str2, objArr);
            this.geU = list;
            this.vlF = map;
            this.vlD = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 56.0f);
            this.vlE = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 53.3f);
            AppMethodBeat.o(27729);
        }

        public final int getCount() {
            AppMethodBeat.i(27730);
            int f;
            if (AppGrid.this.vlz == AppGrid.this.vly - 1) {
                f = AppGrid.this.vlw - (AppGrid.this.vlz * AppGrid.this.vlx);
                AppMethodBeat.o(27730);
                return f;
            }
            f = AppGrid.this.vlx;
            AppMethodBeat.o(27730);
            return f;
        }

        public final f Fq(int i) {
            AppMethodBeat.i(27731);
            if ((i >= AppGrid.this.vlA || AppGrid.this.vlz != 0) && (AppGrid.this.vlz * AppGrid.this.vlx) + i >= AppGrid.this.vlA && (i - AppGrid.this.vlA) + (AppGrid.this.vlz * AppGrid.this.vlx) < this.geU.size()) {
                ab.v("MicroMsg.AppGrid", "get item db pos: %d", Integer.valueOf((i - AppGrid.this.vlA) + (AppGrid.this.vlz * AppGrid.this.vlx)));
                f fVar = (f) this.geU.get(r0);
                AppMethodBeat.o(27731);
                return fVar;
            }
            AppMethodBeat.o(27731);
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            f Fq;
            AppMethodBeat.i(27732);
            if (view == null) {
                aVar = new a();
                view = View.inflate(AppGrid.this.context, R.layout.e2, null);
                aVar.iNr = (ImageView) view.findViewById(R.id.xi);
                aVar.qqT = view.findViewById(R.id.xh);
                aVar.ngn = (TextView) view.findViewById(R.id.xj);
                aVar.vlG = (TextView) view.findViewById(R.id.xk);
                aVar.vlH = view.findViewById(R.id.xl);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            ab.i("MicroMsg.AppGrid", "pos:" + i + " page:" + AppGrid.this.vlz);
            aVar.ngn.setVisibility(0);
            aVar.vlH.setVisibility(8);
            aVar.vlG.setVisibility(8);
            aVar.qqT.setVisibility(0);
            LayoutParams layoutParams = aVar.iNr.getLayoutParams();
            layoutParams.width = this.vlD;
            layoutParams.height = this.vlD;
            aVar.iNr.setLayoutParams(layoutParams);
            int a = (AppGrid.this.vlz * AppGrid.this.vlx) + i;
            int Lb = AppGrid.this.vlv.Lb(a);
            if (a < AppGrid.this.vlA) {
                switch (Lb) {
                    case 0:
                        aVar.iNr.setImageResource(R.raw.panel_icon_pic);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.q7));
                        break;
                    case 1:
                        if (!ae.gjt) {
                            aVar.iNr.setImageResource(R.raw.panel_icon_camera);
                            aVar.ngn.setText(AppGrid.this.context.getString(R.string.q4));
                            break;
                        }
                        aVar.iNr.setImageResource(R.raw.panel_icon_sights);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.qc));
                        break;
                    case 2:
                        aVar.iNr.setImageResource(R.raw.panel_icon_voip);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.qh));
                        try {
                            aw.ZK();
                            if (!((Boolean) c.Ry().get(54, Boolean.FALSE)).booleanValue()) {
                                aVar.vlG.setVisibility(8);
                                break;
                            }
                            aVar.vlG.setVisibility(0);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 3:
                        aVar.iNr.setImageResource(R.raw.panel_icon_multitalk);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.qj));
                        try {
                            aw.ZK();
                            if (!((Boolean) c.Ry().get(81, Boolean.FALSE)).booleanValue()) {
                                aVar.vlG.setVisibility(8);
                                break;
                            }
                            aVar.vlG.setVisibility(0);
                            break;
                        } catch (Exception e2) {
                            break;
                        }
                    case 4:
                        aVar.iNr.setImageResource(R.raw.panel_icon_voipvoice);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.qj));
                        try {
                            aw.ZK();
                            if (!((Boolean) c.Ry().get(62, Boolean.FALSE)).booleanValue()) {
                                aVar.vlG.setVisibility(8);
                                break;
                            }
                            aVar.vlG.setVisibility(0);
                            break;
                        } catch (Exception e3) {
                            break;
                        }
                    case 5:
                        aVar.iNr.setImageResource(R.raw.panel_icon_wxtalk);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.qd));
                        try {
                            aw.ZK();
                            if (!((Boolean) c.Ry().get(67, Boolean.FALSE)).booleanValue()) {
                                aVar.vlG.setVisibility(8);
                                break;
                            }
                            aVar.vlG.setVisibility(0);
                            break;
                        } catch (Exception e4) {
                            break;
                        }
                    case 6:
                        aVar.iNr.setImageResource(R.raw.panel_icon_location);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.q2));
                        try {
                            aw.ZK();
                            if (!((Boolean) c.Ry().get(290817, Boolean.FALSE)).booleanValue()) {
                                aVar.vlH.setVisibility(8);
                                break;
                            }
                            aVar.vlH.setVisibility(0);
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                    case 7:
                        ab.i("MicroMsg.AppGrid", "attach lucky money");
                        a(aVar, f.vbS, AppGrid.this.context.getString(R.string.q3));
                        break;
                    case 8:
                        ab.i("MicroMsg.AppGrid", "attach remittance");
                        a(aVar, f.vbQ, AppGrid.this.context.getString(R.string.qe));
                        break;
                    case 9:
                        a(aVar, f.vbT, null);
                        break;
                    case 10:
                        aVar.iNr.setImageResource(R.raw.panel_icon_voiceinput);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.cbb));
                        try {
                            aw.ZK();
                            if (!((Boolean) c.Ry().get(73, Boolean.FALSE)).booleanValue()) {
                                aVar.vlG.setVisibility(8);
                                break;
                            }
                            aVar.vlG.setVisibility(0);
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    case 11:
                        aVar.iNr.setImageResource(R.raw.panel_icon_fav);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.q0));
                        break;
                    case 12:
                        aVar.iNr.setImageResource(R.raw.panel_icon_friendcard);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.pw));
                        break;
                    case 13:
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.bc5));
                        try {
                            aw.ZK();
                            boolean booleanValue = ((Boolean) c.Ry().get(208899, Boolean.FALSE)).booleanValue();
                            aw.ZK();
                            boolean booleanValue2 = ((Boolean) c.Ry().get(208913, Boolean.FALSE)).booleanValue();
                            if (!booleanValue && !booleanValue2) {
                                aVar.vlG.setVisibility(8);
                                break;
                            }
                            aVar.vlG.setVisibility(0);
                            if (!booleanValue2) {
                                aVar.vlG.setText(R.string.s0);
                                break;
                            }
                            aVar.vlG.setText(R.string.qv);
                            break;
                        } catch (Exception e7) {
                            break;
                        }
                    case 14:
                        aVar.iNr.setImageResource(R.raw.panel_icon_service);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.qb));
                        try {
                            aw.ZK();
                            if (!((Boolean) c.Ry().get(327744, Boolean.TRUE)).booleanValue()) {
                                aVar.vlH.setVisibility(8);
                                break;
                            }
                            aVar.vlH.setVisibility(0);
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    case 15:
                        aVar.iNr.setImageResource(R.raw.panel_icon_enterprise);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.pz));
                        try {
                            aVar.vlH.setVisibility(8);
                            break;
                        } catch (Exception e9) {
                            break;
                        }
                    case 16:
                        aVar.iNr.setImageResource(R.raw.panel_icon_file_explorer);
                        aVar.ngn.setText(AppGrid.this.context.getString(R.string.q1));
                        break;
                }
            }
            layoutParams.width = this.vlE;
            layoutParams.height = this.vlE;
            aVar.iNr.setLayoutParams(layoutParams);
            Fq = Fq(i);
            if (Fq != null) {
                aw.ZK();
                if (c.isSDCardAvailable()) {
                    if (Fq.field_status == 5) {
                        g.b(Fq.field_appId, 3, com.tencent.mm.bz.a.getDensity(AppGrid.this.context));
                    } else if (Fq.dhx()) {
                        g.b(Fq.field_appId, 4, com.tencent.mm.bz.a.getDensity(AppGrid.this.context));
                    } else {
                        g.b(Fq.field_appId, 1, com.tencent.mm.bz.a.getDensity(AppGrid.this.context));
                    }
                    if (f.vbQ.equals(Fq.field_appId)) {
                        aVar.iNr.setImageResource(R.raw.panel_icon_transfer);
                    } else if (f.vbS.equals(Fq.field_appId)) {
                        aVar.iNr.setImageResource(R.raw.panel_icon_luckymoney);
                    } else if (f.vbR.equals(Fq.field_appId)) {
                        aVar.iNr.setImageResource(R.raw.panel_icon_card);
                    } else if (f.vbT.equals(Fq.field_appId)) {
                        aVar.iNr.setImageResource(R.raw.panel_icon_aa);
                    } else {
                        aVar.iNr.setBackgroundResource(R.drawable.awg);
                    }
                } else {
                    aVar.iNr.setBackgroundResource(R.drawable.ao_);
                }
                aVar.ngn.setText(g.b(AppGrid.this.context, Fq, null));
                if (Fq.dhx() && Fq.dhy()) {
                    if (AppGrid.this.ehZ == null) {
                        AppGrid.this.ehZ = AppGrid.this.context.getSharedPreferences(ah.doA(), 0);
                    }
                    if (AppGrid.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + Fq.field_appId, true)) {
                        aVar.vlG.setVisibility(0);
                    }
                }
            }
            Fq = Fq(i);
            if (Fq != null && g.l(Fq)) {
                aVar.vlG.setVisibility(0);
            }
            AppMethodBeat.o(27732);
            return view;
        }

        private void a(a aVar, String str, String str2) {
            AppMethodBeat.i(27733);
            if (this.vlF == null) {
                ab.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
                AppMethodBeat.o(27733);
                return;
            }
            f fVar = (f) this.vlF.get(str);
            if (fVar == null) {
                ab.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
                AppMethodBeat.o(27733);
                return;
            }
            aw.ZK();
            if (c.isSDCardAvailable()) {
                if (fVar.dhx()) {
                    g.b(fVar.field_appId, 4, com.tencent.mm.bz.a.getDensity(AppGrid.this.context));
                }
                if (f.vbQ.equals(fVar.field_appId)) {
                    aVar.iNr.setImageResource(R.raw.panel_icon_transfer);
                } else if (f.vbS.equals(fVar.field_appId)) {
                    aVar.iNr.setImageResource(R.raw.panel_icon_luckymoney);
                } else if (f.vbR.equals(fVar.field_appId)) {
                    aVar.iNr.setImageResource(R.raw.panel_icon_card);
                } else if (f.vbT.equals(fVar.field_appId)) {
                    aVar.iNr.setImageResource(R.raw.panel_icon_aa);
                } else {
                    aVar.iNr.setImageResource(R.drawable.awg);
                }
            } else {
                aVar.iNr.setImageResource(R.drawable.ao_);
            }
            if (bo.isNullOrNil(str2)) {
                aVar.ngn.setText(g.b(AppGrid.this.context, fVar, null));
            } else {
                aVar.ngn.setText(g.c(AppGrid.this.context, fVar, str2));
            }
            if (fVar.dhx() && fVar.dhy()) {
                if (AppGrid.this.ehZ == null) {
                    AppGrid.this.ehZ = AppGrid.this.context.getSharedPreferences(ah.doA(), 0);
                }
                if (AppGrid.this.ehZ.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                    aVar.vlG.setVisibility(0);
                }
            }
            int intValue;
            if (f.vbQ.equals(fVar.field_appId)) {
                aw.ZK();
                intValue = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue <= 1) {
                    AppMethodBeat.o(27733);
                    return;
                }
                aw.ZK();
                if (!bo.P(((String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                    aVar.vlG.setVisibility(0);
                }
                AppMethodBeat.o(27733);
                return;
            }
            if (f.vbS.equals(fVar.field_appId)) {
                if (com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_APP_PANEL_STRING_SYNC)) {
                    aVar.vlH.setVisibility(0);
                } else {
                    aVar.vlH.setVisibility(8);
                }
                aw.ZK();
                intValue = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue <= 1) {
                    aVar.vlG.setVisibility(8);
                    AppMethodBeat.o(27733);
                    return;
                }
                aw.ZK();
                if (!bo.P(((String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";")).contains(String.valueOf(intValue))) {
                    aVar.vlG.setVisibility(0);
                }
            }
            AppMethodBeat.o(27733);
        }
    }

    public interface b {
        int Lb(int i);

        void Lc(int i);

        void a(int i, f fVar);
    }

    public AppGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(27735);
        this.context = context;
        AppMethodBeat.o(27735);
    }

    public AppGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27736);
        this.context = context;
        AppMethodBeat.o(27736);
    }

    public final void d(List<f> list, Map<String, f> map) {
        AppMethodBeat.i(27737);
        this.vlB = new a(this.context, list, map);
        setBackgroundResource(0);
        setAdapter(this.vlB);
        setOnItemClickListener(this.jMk);
        setOnItemLongClickListener(this.mkF);
        setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 16.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 6.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 16.0f), 0);
        AppMethodBeat.o(27737);
    }

    public final void La(int i) {
        AppMethodBeat.i(27738);
        if (i <= 0) {
            AppMethodBeat.o(27738);
            return;
        }
        setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 16.0f), i, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 16.0f), 0);
        setVerticalSpacing(i / 2);
        AppMethodBeat.o(27738);
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(27739);
        this.vlz = i;
        this.vlw = i2;
        this.vlx = i3;
        this.vly = i4;
        this.vlA = i6;
        setNumColumns(i5);
        AppMethodBeat.o(27739);
    }

    public void setOnAppSelectedListener(b bVar) {
        this.vlv = bVar;
    }

    public int getCount() {
        AppMethodBeat.i(27740);
        int count = this.vlB.getCount();
        AppMethodBeat.o(27740);
        return count;
    }
}
