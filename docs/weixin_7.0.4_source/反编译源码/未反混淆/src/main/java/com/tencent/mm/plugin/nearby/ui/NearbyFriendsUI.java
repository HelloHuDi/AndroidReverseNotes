package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;
import java.util.List;

@i
public class NearbyFriendsUI extends MMActivity implements f {
    boolean eVT = false;
    private com.tencent.mm.sdk.b.c ecA = new com.tencent.mm.sdk.b.c<je>() {
        {
            AppMethodBeat.i(55441);
            this.xxI = je.class.getName().hashCode();
            AppMethodBeat.o(55441);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(55442);
            je jeVar = (je) bVar;
            if (jeVar != null && (jeVar instanceof je)) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55440);
                        NearbyFriendsUI.a(NearbyFriendsUI.this);
                        AppMethodBeat.o(55440);
                    }
                });
            }
            AppMethodBeat.o(55442);
            return false;
        }
    };
    private com.tencent.mm.modelgeo.d ecr;
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(55449);
            if (NearbyFriendsUI.this.nOR) {
                AppMethodBeat.o(55449);
                return false;
            }
            NearbyFriendsUI.this.nOR = true;
            if (NearbyFriendsUI.this.eVT) {
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                g.BP(11);
                AppMethodBeat.o(55449);
                return false;
            }
            if (z) {
                boolean z2;
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.setMessage(NearbyFriendsUI.this.getString(R.string.d4o));
                }
                NearbyFriendsUI.this.oQr = new a(f2, f, (int) d2);
                e akf = e.akf();
                boolean z3 = i != 0;
                if (NearbyFriendsUI.this.ecr == null) {
                    z2 = false;
                } else {
                    z2 = NearbyFriendsUI.this.ecr.fBD;
                }
                akf.a(2001, z3, z2, f, f2, (int) d2);
                NearbyFriendsUI.this.oQd = new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.this.oQh, NearbyFriendsUI.this.oQr.fBs, NearbyFriendsUI.this.oQr.fBr, NearbyFriendsUI.this.oQr.accuracy, i, "", "");
                com.tencent.mm.kernel.g.Rg().a(NearbyFriendsUI.this.oQd, 0);
            } else {
                g.BP(11);
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                NearbyFriendsUI.this.findViewById(R.id.dgj).setVisibility(0);
                NearbyFriendsUI.this.gxZ.setVisibility(8);
                NearbyFriendsUI.this.oQo = true;
                if (!(NearbyFriendsUI.this.nPX || com.tencent.mm.modelgeo.d.agA())) {
                    NearbyFriendsUI.this.nPX = true;
                    h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(R.string.c9z), NearbyFriendsUI.this.getString(R.string.tz), NearbyFriendsUI.this.getString(R.string.ckr), NearbyFriendsUI.this.getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(55448);
                            com.tencent.mm.modelgeo.d.bX(NearbyFriendsUI.this);
                            AppMethodBeat.o(55448);
                        }
                    }, null);
                }
            }
            AppMethodBeat.o(55449);
            return false;
        }
    };
    private ListView gxZ;
    private List<axv> lQs = new LinkedList();
    private boolean nOR = false;
    private boolean nPX;
    private List<axv> nQk = new LinkedList();
    private com.tencent.mm.plugin.nearby.a.c oPQ;
    private b oQc;
    private com.tencent.mm.plugin.nearby.a.c oQd;
    private com.tencent.mm.plugin.nearby.a.d oQe;
    private boolean oQf = false;
    private String[] oQg;
    private int oQh = 1;
    private BindMobileOrQQHeaderView oQi;
    private ViewGroup oQj;
    private View oQk;
    private View oQl;
    private boolean oQm = false;
    private int oQn;
    private boolean oQo = false;
    private int oQp = 0;
    private View oQq = null;
    private a oQr;
    private p tipDialog = null;

    class a {
        public int accuracy;
        public float fBr;
        public float fBs;

        public a(float f, float f2, int i) {
            this.fBr = f;
            this.fBs = f2;
            this.accuracy = i;
        }
    }

    class b extends BaseAdapter {
        private final Context context;
        com.tencent.mm.ui.applet.b gvm = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a() {
            public final Bitmap wd(String str) {
                AppMethodBeat.i(55459);
                Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
                AppMethodBeat.o(55459);
                return a;
            }
        });
        private com.tencent.mm.ui.applet.b.b gvn = null;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(55466);
            axv zZ = zZ(i);
            AppMethodBeat.o(55466);
            return zZ;
        }

        public b(Context context) {
            AppMethodBeat.i(55462);
            this.context = context;
            AppMethodBeat.o(55462);
        }

        public final int getCount() {
            AppMethodBeat.i(55463);
            int size = NearbyFriendsUI.this.lQs.size();
            AppMethodBeat.o(55463);
            return size;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            AppMethodBeat.i(55464);
            if (this.gvn == null) {
                this.gvn = new com.tencent.mm.ui.applet.b.b() {
                    public final String mW(int i) {
                        AppMethodBeat.i(55460);
                        if (i < 0 || i >= b.this.getCount()) {
                            ab.e("MicroMsg.NearbyFriend", "pos is invalid");
                            AppMethodBeat.o(55460);
                            return null;
                        }
                        axv zZ = b.this.zZ(i);
                        if (zZ == null) {
                            AppMethodBeat.o(55460);
                            return null;
                        }
                        String str = zZ.jBB;
                        AppMethodBeat.o(55460);
                        return str;
                    }

                    public final int apO() {
                        AppMethodBeat.i(55461);
                        int count = b.this.getCount();
                        AppMethodBeat.o(55461);
                        return count;
                    }
                };
            }
            if (this.gvm != null) {
                this.gvm.a(i, this.gvn);
            }
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, R.layout.aih, null);
                dVar2.gtG = (TextView) view.findViewById(R.id.bi1);
                dVar2.oQA = (TextView) view.findViewById(R.id.dgu);
                dVar2.oQz = (TextView) view.findViewById(R.id.dgo);
                dVar2.gvq = (ImageView) view.findViewById(R.id.bi0);
                dVar2.gvr = (TextView) view.findViewById(R.id.dgl);
                dVar2.oQB = (ImageView) view.findViewById(R.id.dgn);
                dVar2.oQC = (ImageView) view.findViewById(R.id.dgp);
                dVar2.oQE = (ImageView) view.findViewById(R.id.dgq);
                dVar2.oQF = (ImageView) view.findViewById(R.id.dgr);
                dVar2.oQG = (ImageView) view.findViewById(R.id.dgs);
                LayoutParams layoutParams = dVar2.oQC.getLayoutParams();
                layoutParams.height = com.tencent.mm.bz.a.al(this.context, R.dimen.m4);
                layoutParams.width = com.tencent.mm.bz.a.al(this.context, R.dimen.m4);
                dVar2.oQC.setLayoutParams(layoutParams);
                dVar2.oQD = (ImageView) view.findViewById(R.id.dgm);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            axv axv = (axv) NearbyFriendsUI.this.lQs.get(i);
            dVar.gtG.setText(j.b(this.context, axv.jCH, dVar.gtG.getTextSize()));
            if (NearbyFriendsUI.this.oQh == 1) {
                switch (axv.guN) {
                    case 1:
                        dVar.oQD.setVisibility(0);
                        dVar.oQD.setImageResource(R.raw.ic_sex_male);
                        dVar.oQD.setContentDescription(this.context.getString(R.string.cwa));
                        break;
                    case 2:
                        dVar.oQD.setVisibility(0);
                        dVar.oQD.setImageResource(R.raw.ic_sex_female);
                        dVar.oQD.setContentDescription(this.context.getString(R.string.bsl));
                        break;
                    default:
                        dVar.oQD.setVisibility(8);
                        break;
                }
            }
            dVar.oQD.setVisibility(8);
            if (axv.wBT != 0) {
                dVar.oQB.setVisibility(0);
                dVar.oQB.setImageBitmap(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.i(com.tencent.mm.model.ao.a.flw.ky(axv.wBT), 2.0f));
                dVar.oQD.setVisibility(8);
            } else {
                dVar.oQB.setVisibility(8);
            }
            dVar.oQz.setText(axv.wBS);
            dVar.oQE.setVisibility(8);
            dVar.oQF.setVisibility(8);
            dVar.oQG.setVisibility(8);
            if (axv instanceof com.tencent.mm.plugin.nearby.a.a) {
                LinkedList linkedList = ((com.tencent.mm.plugin.nearby.a.a) axv).oPv;
                if (linkedList != null && linkedList.size() == 1) {
                    dVar.oQE.setVisibility(0);
                    NearbyFriendsUI.o(dVar.oQE, (String) linkedList.get(0));
                } else if (linkedList != null && linkedList.size() == 2) {
                    dVar.oQE.setVisibility(0);
                    dVar.oQF.setVisibility(0);
                    NearbyFriendsUI.o(dVar.oQE, (String) linkedList.get(0));
                    NearbyFriendsUI.o(dVar.oQF, (String) linkedList.get(1));
                } else if (linkedList != null && linkedList.size() >= 3) {
                    dVar.oQE.setVisibility(0);
                    dVar.oQF.setVisibility(0);
                    dVar.oQG.setVisibility(0);
                    NearbyFriendsUI.o(dVar.oQE, (String) linkedList.get(0));
                    NearbyFriendsUI.o(dVar.oQF, (String) linkedList.get(1));
                    NearbyFriendsUI.o(dVar.oQG, (String) linkedList.get(2));
                }
            }
            if (axv.guQ == null || axv.guQ.trim().equals("")) {
                dVar.oQA.setVisibility(8);
            } else {
                dVar.oQA.setVisibility(0);
                dVar.oQA.setText(j.b(this.context, axv.guQ, dVar.oQA.getTextSize()));
            }
            if (axv.wBZ == null || (axv.wBZ.guY & 1) <= 0) {
                dVar.oQC.setVisibility(8);
            } else {
                dVar.oQC.setVisibility(0);
            }
            if (c.Aa(axv.guN)) {
                dVar.gvq.setImageBitmap(null);
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePK = com.tencent.mm.plugin.i.c.XW();
                aVar.ePH = true;
                aVar.ePZ = true;
                o.ahp().a(axv.jBB, dVar.gvq, aVar.ahG());
                if (!bo.isNullOrNil(axv.guS)) {
                    dVar.gvr.setText(axv.guS);
                    dVar.gvr.setVisibility(0);
                }
                dVar.gvr.setVisibility(8);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(dVar.gvq, axv.jBB);
                if (((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoJ(axv.jBB)) {
                    dVar.gvr.setVisibility(0);
                    if (ad.Mn(axv.wBT)) {
                        dVar.gvr.setText(NearbyFriendsUI.this.getString(R.string.d4p));
                    } else {
                        ad aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(axv.jBB);
                        if (aoM != null) {
                            dVar.gtG.setText(j.b(this.context, bo.isNullOrNil(aoM.Oj()) ? axv.jCH : aoM.Oj(), dVar.gtG.getTextSize()));
                        }
                        dVar.gvr.setText(NearbyFriendsUI.this.getString(R.string.d4u));
                    }
                }
                dVar.gvr.setVisibility(8);
            }
            AppMethodBeat.o(55464);
            return view;
        }

        public final axv zZ(int i) {
            AppMethodBeat.i(55465);
            axv axv = (axv) NearbyFriendsUI.this.lQs.get(i);
            AppMethodBeat.o(55465);
            return axv;
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    static class c {
        public static int oQy = Downloads.MIN_WAIT_FOR_NETWORK;

        public static boolean Aa(int i) {
            return i == oQy;
        }

        public static String b(axv axv) {
            if (axv != null) {
                return axv.guO;
            }
            return null;
        }
    }

    static class d {
        TextView gtG;
        ImageView gvq;
        TextView gvr;
        TextView oQA;
        ImageView oQB;
        ImageView oQC;
        ImageView oQD;
        ImageView oQE;
        ImageView oQF;
        ImageView oQG;
        TextView oQz;

        d() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NearbyFriendsUI() {
        AppMethodBeat.i(55467);
        AppMethodBeat.o(55467);
    }

    static /* synthetic */ void a(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.i(55479);
        nearbyFriendsUI.bVd();
        AppMethodBeat.o(55479);
    }

    static /* synthetic */ void v(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.i(55480);
        nearbyFriendsUI.getData();
        AppMethodBeat.o(55480);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55468);
        g.BN(11);
        super.onCreate(bundle);
        setMMTitle((int) R.string.d57);
        com.tencent.mm.kernel.g.Rg().a(148, (f) this);
        com.tencent.mm.kernel.g.Rg().a(376, (f) this);
        com.tencent.mm.kernel.g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING, (f) this);
        this.ecr = com.tencent.mm.modelgeo.d.agz();
        initView();
        this.oQg = new String[]{getResources().getString(R.string.d4z), getResources().getString(R.string.d4y), getResources().getString(R.string.d4x), getResources().getString(R.string.dx5)};
        this.oQh = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(16386, null), 1);
        if (this.oQh == 3) {
            MZ(R.raw.ic_sex_male);
        } else if (this.oQh == 4) {
            MZ(R.raw.ic_sex_female);
        } else {
            MZ(0);
            this.oQh = 1;
        }
        getData();
        AppMethodBeat.o(55468);
    }

    private void getData() {
        AppMethodBeat.i(55469);
        this.nOR = false;
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.tipDialog = h.b(context, getString(R.string.d4w), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(55447);
                NearbyFriendsUI.this.eVT = true;
                g.BP(11);
                if (NearbyFriendsUI.this.oQd != null) {
                    com.tencent.mm.kernel.g.Rg().c(NearbyFriendsUI.this.oQd);
                }
                ab.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
                if (!NearbyFriendsUI.this.oQo) {
                    NearbyFriendsUI.this.finish();
                    ab.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
                }
                AppMethodBeat.o(55447);
            }
        });
        this.eVT = false;
        if (this.ecr != null) {
            this.ecr.a(this.ecy, true);
        }
        AppMethodBeat.o(55469);
    }

    public final int getLayoutId() {
        return R.layout.aif;
    }

    private void bVd() {
        AppMethodBeat.i(55470);
        if (com.tencent.mm.bn.a.dgL()) {
            View view;
            if (this.oQq != null) {
                this.gxZ.removeHeaderView(this.oQq);
                this.oQq = null;
            }
            View inflate = View.inflate(this, R.layout.aij, null);
            TextView textView = (TextView) inflate.findViewById(R.id.c_z);
            com.tencent.mm.kernel.g.RN().QU();
            int baS = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOo().baS();
            if (baS == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(R.plurals.a1, baS, new Object[]{Integer.valueOf(baS)}));
                ImageView imageView = (ImageView) inflate.findViewById(R.id.c_y);
                bf bOx = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOo().bOx();
                if (bOx != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.b(imageView, bOx.field_sayhiuser);
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(55450);
                        NearbyFriendsUI.this.gxZ.removeHeaderView(NearbyFriendsUI.this.oQq);
                        NearbyFriendsUI.this.oQq = null;
                        Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                        intent.putExtra("k_say_hi_type", 2);
                        intent.putExtra("show_clear_header", true);
                        NearbyFriendsUI.this.startActivityForResult(intent, 2009);
                        AppMethodBeat.o(55450);
                    }
                });
                view = inflate;
            }
            this.oQq = view;
            if (this.oQq != null) {
                this.gxZ.addHeaderView(this.oQq);
            }
        }
        AppMethodBeat.o(55470);
    }

    public final void initView() {
        AppMethodBeat.i(55471);
        this.gxZ = (ListView) findViewById(R.id.dgh);
        this.oQc = new b(this);
        this.gxZ.addHeaderView(bVe());
        String value = com.tencent.mm.m.g.Nu().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.oQn = Integer.valueOf(value).intValue();
            } catch (Exception e) {
                this.oQn = 0;
            }
        }
        value = (String) com.tencent.mm.kernel.g.RP().Ry().get(6, null);
        if (value != null && value.length() > 0) {
            this.oQn = 0;
        }
        this.oQp = 0;
        if (com.tencent.mm.model.a.g.aaK().oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            value = com.tencent.mm.model.a.g.aaK().oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).value;
            com.tencent.mm.plugin.account.friend.a.l.a apS = l.apS();
            if (value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.oQp = 0;
            } else if (value.equals("2")) {
                if (apS == com.tencent.mm.plugin.account.friend.a.l.a.SUCC_UNLOAD) {
                    this.oQp = 2;
                    com.tencent.mm.model.a.f.oT(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            } else if (value.equals("1") && apS == com.tencent.mm.plugin.account.friend.a.l.a.NO_INIT) {
                this.oQp = 2;
                com.tencent.mm.model.a.f.oT(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
        }
        if ((this.oQn > 0 || this.oQp > 0) && this.oQp != 1) {
            this.oQi = new BindMobileOrQQHeaderView(this);
            this.gxZ.addHeaderView(this.oQi);
        }
        this.gxZ.setAdapter(this.oQc);
        this.gxZ.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(55451);
                if (NearbyFriendsUI.this.oQn > 0 || NearbyFriendsUI.this.oQp > 0) {
                    i--;
                }
                if (com.tencent.mm.bn.a.dgL() && NearbyFriendsUI.this.oQq != null) {
                    i--;
                }
                if (NearbyFriendsUI.this.oQm) {
                    i--;
                }
                if (i < 0 || i >= NearbyFriendsUI.this.lQs.size()) {
                    AppMethodBeat.o(55451);
                    return;
                }
                axv axv = (axv) NearbyFriendsUI.this.lQs.get(i);
                Intent intent;
                if (c.Aa(axv.guN)) {
                    String b = c.b(axv);
                    ab.d("MicroMsg.NearbyFriend", "poi item click, go:" + bo.nullAsNil(b));
                    if (!bo.isNullOrNil(b)) {
                        intent = new Intent();
                        intent.putExtra("rawUrl", b);
                        intent.putExtra("geta8key_scene", 25);
                        intent.putExtra("stastic_scene", 12);
                        com.tencent.mm.bp.d.b(NearbyFriendsUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.o(55451);
                    return;
                }
                String str = axv.jBB;
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
                if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Scene", 18);
                    intent2.putExtra("Sns_from_Scene", 18);
                    intent2.putExtra("lbs_ticket", axv.wlF);
                    intent2.putExtra("Contact_IsLbsGotoChatting", true);
                    if (str != null && str.length() > 0) {
                        if (aoO.dsf()) {
                            com.tencent.mm.plugin.report.service.h.pYm.X(10298, str + ",18");
                        }
                        qh qhVar = new qh();
                        qhVar.cMw.intent = intent2;
                        qhVar.cMw.username = str;
                        com.tencent.mm.sdk.b.a.xxA.m(qhVar);
                        intent2.putExtra("CONTACT_INFO_UI_SOURCE", 5);
                        com.tencent.mm.plugin.nearby.a.gkE.c(intent2, NearbyFriendsUI.this);
                    }
                    AppMethodBeat.o(55451);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", axv.jBB);
                intent.putExtra("Contact_Alias", axv.guS);
                intent.putExtra("Contact_Nick", axv.jCH);
                intent.putExtra("Contact_Distance", axv.wBS);
                intent.putExtra("Contact_Signature", axv.guQ);
                intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(axv.guW, axv.guO, axv.guP));
                intent.putExtra("Contact_Sex", axv.guN);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_Scene", 18);
                intent.putExtra("Contact_VUser_Info", axv.wBU);
                intent.putExtra("Contact_VUser_Info_Flag", axv.wBT);
                intent.putExtra("Contact_KWeibo_flag", axv.wBX);
                intent.putExtra("Contact_KWeibo", axv.wBV);
                intent.putExtra("Contact_KWeiboNick", axv.wBW);
                intent.putExtra("Contact_KSnsIFlag", axv.wBZ.guY);
                intent.putExtra("Contact_KSnsBgId", axv.wBZ.gva);
                intent.putExtra("Contact_KSnsBgUrl", axv.wBZ.guZ);
                intent.putExtra("lbs_ticket", axv.wlF);
                intent.putExtra("Contact_IsLbsGotoChatting", true);
                if (axv.guX != null) {
                    com.tencent.mm.sdk.e.c dVar = new com.tencent.mm.aj.d();
                    dVar.field_brandList = axv.guX;
                    dVar.field_brandFlag = axv.wCa.gvb;
                    dVar.field_brandIconURL = axv.wCa.gve;
                    dVar.field_extInfo = axv.wCa.gvc;
                    dVar.field_brandInfo = axv.wCa.gvd;
                    intent.putExtra("KBrandInfo_item", new MCacheItem(dVar));
                }
                intent.putExtra("Sns_from_Scene", 18);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 5);
                com.tencent.mm.plugin.nearby.a.gkE.c(intent, NearbyFriendsUI.this);
                AppMethodBeat.o(55451);
            }
        });
        this.gxZ.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(55452);
                if (NearbyFriendsUI.this.oQc != null) {
                    b t = NearbyFriendsUI.this.oQc;
                    if (t.gvm != null) {
                        t.gvm.onTouchEvent(motionEvent);
                    }
                }
                AppMethodBeat.o(55452);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55453);
                NearbyFriendsUI.this.finish();
                AppMethodBeat.o(55453);
                return true;
            }
        });
        AnonymousClass13 anonymousClass13 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55454);
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(NearbyFriendsUI.this.gxZ);
                AppMethodBeat.o(55454);
            }
        };
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55458);
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(NearbyFriendsUI.this, 1, false);
                dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(55456);
                        switch (i) {
                            case 0:
                                NearbyFriendsUI.this.oQh = 4;
                                NearbyFriendsUI.this.oQf = false;
                                com.tencent.mm.kernel.g.RP().Ry().set(16386, Integer.valueOf(NearbyFriendsUI.this.oQh));
                                NearbyFriendsUI.v(NearbyFriendsUI.this);
                                AppMethodBeat.o(55456);
                                return;
                            case 1:
                                NearbyFriendsUI.this.oQh = 3;
                                NearbyFriendsUI.this.oQf = false;
                                com.tencent.mm.kernel.g.RP().Ry().set(16386, Integer.valueOf(NearbyFriendsUI.this.oQh));
                                NearbyFriendsUI.v(NearbyFriendsUI.this);
                                AppMethodBeat.o(55456);
                                return;
                            case 2:
                                NearbyFriendsUI.this.oQh = 1;
                                NearbyFriendsUI.this.oQf = false;
                                com.tencent.mm.kernel.g.RP().Ry().set(16386, Integer.valueOf(NearbyFriendsUI.this.oQh));
                                NearbyFriendsUI.v(NearbyFriendsUI.this);
                                AppMethodBeat.o(55456);
                                return;
                            case 3:
                                Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                                intent.putExtra("k_say_hi_type", 2);
                                NearbyFriendsUI.this.startActivityForResult(intent, 2009);
                                AppMethodBeat.o(55456);
                                return;
                            case 4:
                                NearbyFriendsUI.this.oPQ = new com.tencent.mm.plugin.nearby.a.c(2, 0.0f, 0.0f, 0, 0, "", "");
                                com.tencent.mm.kernel.g.Rg().a(NearbyFriendsUI.this.oPQ, 0);
                                NearbyFriendsUI nearbyFriendsUI = NearbyFriendsUI.this;
                                Context context = NearbyFriendsUI.this.mController.ylL;
                                NearbyFriendsUI.this.getString(R.string.tz);
                                nearbyFriendsUI.tipDialog = h.b(context, NearbyFriendsUI.this.getString(R.string.d4m), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(55455);
                                        com.tencent.mm.kernel.g.Rg().c(NearbyFriendsUI.this.oPQ);
                                        AppMethodBeat.o(55455);
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(55456);
                    }
                };
                dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        AppMethodBeat.i(55457);
                        lVar.hi(-1, R.string.d4z);
                        lVar.hi(-1, R.string.d4y);
                        lVar.hi(-1, R.string.d4x);
                        lVar.hi(-1, R.string.dx5);
                        lVar.hi(-1, R.string.d4i);
                        AppMethodBeat.o(55457);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(55458);
                return true;
            }
        });
        AppMethodBeat.o(55471);
    }

    private View bVe() {
        AppMethodBeat.i(55472);
        if (this.oQj == null) {
            this.oQj = new LinearLayout(this);
            this.oQj.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ((LinearLayout) this.oQj).setGravity(17);
        }
        this.oQm = true;
        ViewGroup viewGroup = this.oQj;
        AppMethodBeat.o(55472);
        return viewGroup;
    }

    private void bVf() {
        AppMethodBeat.i(55473);
        com.tencent.mm.plugin.nearby.a.gkE.bg(this);
        AppMethodBeat.o(55473);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(55474);
        ab.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.oQf = false;
                    getData();
                    AppMethodBeat.o(55474);
                    return;
                }
                break;
            case 2009:
                if (i2 == -1) {
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.o(55474);
    }

    public void onPause() {
        AppMethodBeat.i(55475);
        super.onPause();
        if (this.ecr != null) {
            this.ecr.c(this.ecy);
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.ecA);
        AppMethodBeat.o(55475);
    }

    public void onResume() {
        AppMethodBeat.i(55476);
        super.onResume();
        if (this.ecr != null) {
            this.ecr.a(this.ecy, true);
        }
        bVd();
        this.oQc.notifyDataSetChanged();
        com.tencent.mm.kernel.g.RN().QU();
        if (((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOo().baS() == 0) {
            this.gxZ.removeHeaderView(this.oQl);
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.ecA);
        AppMethodBeat.o(55476);
    }

    public void onDestroy() {
        AppMethodBeat.i(55477);
        if (this.oQp > 0) {
            com.tencent.mm.model.a.f.oU(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        g.BP(11);
        com.tencent.mm.kernel.g.Rg().b(148, (f) this);
        com.tencent.mm.kernel.g.Rg().b(376, (f) this);
        com.tencent.mm.kernel.g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING, (f) this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.ecr != null) {
            this.ecr.c(this.ecy);
        }
        com.tencent.mm.ah.o.acv().cancel();
        if (this.oQc != null) {
            b bVar = this.oQc;
            if (bVar.gvm != null) {
                bVar.gvm.detach();
                bVar.gvm = null;
            }
        }
        super.onDestroy();
        AppMethodBeat.o(55477);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(55478);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (mVar.getType() == 148) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            int Ah = ((com.tencent.mm.plugin.nearby.a.c) mVar).Ah();
            if (this.oQd == null && (Ah == 1 || Ah == 3 || Ah == 4)) {
                AppMethodBeat.o(55478);
                return;
            } else if ((Ah == 1 || Ah == 3 || Ah == 4) && this.oQf) {
                ab.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", Integer.valueOf(Ah));
                AppMethodBeat.o(55478);
                return;
            } else if (this.oPQ == null && Ah == 2) {
                AppMethodBeat.o(55478);
                return;
            } else {
                ab.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (mVar.getType() != 148) {
                    AppMethodBeat.o(55478);
                    return;
                } else if (i == 0 && i2 == 0) {
                    int i3;
                    if (Ah == 1 || Ah == 3 || Ah == 4) {
                        this.lQs = ((com.tencent.mm.plugin.nearby.a.c) mVar).bUZ();
                        if (this.lQs == null || this.lQs.size() == 0) {
                            findViewById(R.id.dgi).setVisibility(0);
                            this.gxZ.setVisibility(8);
                            bVf();
                            g.BP(11);
                        } else {
                            LinkedList linkedList = new LinkedList();
                            i3 = 0;
                            for (axv axv : this.lQs) {
                                if (((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoJ(axv.jBB)) {
                                    linkedList.add(i3, axv);
                                    i3++;
                                } else if (!(bo.isNullOrNil(axv.jBB) || bo.isNullOrNil(axv.wBS))) {
                                    linkedList.add(axv);
                                }
                            }
                            this.lQs.clear();
                            this.lQs = linkedList;
                            if (this.nQk != null) {
                                for (Ah = this.nQk.size() - 1; Ah >= 0; Ah--) {
                                    if (this.nQk.get(Ah) != null) {
                                        this.lQs.add(0, this.nQk.get(Ah));
                                    }
                                }
                            }
                            if (this.lQs == null || this.lQs.size() == 0) {
                                findViewById(R.id.dgi).setVisibility(0);
                                this.gxZ.setVisibility(8);
                            } else {
                                findViewById(R.id.dgi).setVisibility(8);
                                this.oQc.notifyDataSetChanged();
                                if (this.oQc.getCount() > 0) {
                                    this.gxZ.setSelection(0);
                                }
                                this.gxZ.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(55445);
                                        g.BO(11);
                                        AppMethodBeat.o(55445);
                                    }
                                });
                            }
                        }
                        if (this.oQh == 3) {
                            MZ(R.raw.ic_sex_male);
                        } else if (this.oQh == 4) {
                            MZ(R.raw.ic_sex_female);
                        } else {
                            MZ(0);
                            this.oQh = 1;
                        }
                        this.oQf = true;
                        this.oQd = null;
                    }
                    if (((com.tencent.mm.plugin.nearby.a.c) mVar).Ah() == 2) {
                        h.a(this.mController.ylL, getString(R.string.d4l), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(55446);
                                NearbyFriendsUI.this.finish();
                                AppMethodBeat.o(55446);
                            }
                        });
                        this.oPQ = null;
                    }
                    if (((com.tencent.mm.plugin.nearby.a.c) mVar).bUX()) {
                        String string = getString(R.string.d5_);
                        i3 = ((com.tencent.mm.plugin.nearby.a.c) mVar).bUY();
                        if (this.oQj != null) {
                            if (this.oQk == null) {
                                this.oQk = View.inflate(this, R.layout.aik, null);
                                this.oQj.addView(this.oQk);
                                this.oQk.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(55443);
                                        NearbyFriendsUI.x(NearbyFriendsUI.this);
                                        AppMethodBeat.o(55443);
                                    }
                                });
                            } else {
                                this.oQk.setVisibility(0);
                            }
                            ((TextView) this.oQk.findViewById(R.id.dgw)).setText(string);
                            if (i3 != 0) {
                                ((TextView) this.oQk.findViewById(R.id.dgx)).setText(String.format(getResources().getQuantityString(R.plurals.u, i3, new Object[]{Integer.valueOf(i3)}), new Object[0]));
                            }
                        }
                    } else if (!(this.oQk == null || this.oQj == null)) {
                        this.oQk.setVisibility(8);
                    }
                    this.oQo = true;
                    AppMethodBeat.o(55478);
                    return;
                } else {
                    if (Ah == 1 || Ah == 3 || Ah == 4) {
                        com.tencent.mm.h.a aVar;
                        TextView textView = (TextView) findViewById(R.id.dgi);
                        textView.setVisibility(0);
                        bVf();
                        if (str == null || str.length() <= 0) {
                            aVar = null;
                        } else {
                            aVar = com.tencent.mm.h.a.jY(str);
                        }
                        if (aVar != null && aVar.desc != null && aVar.desc.length() > 0) {
                            textView.setText(aVar.desc);
                        } else if (i2 == -2001) {
                            textView.setText(getString(R.string.d4n));
                        } else {
                            textView.setText(getString(R.string.d4q));
                        }
                        this.gxZ.setVisibility(8);
                        this.oQd = null;
                    }
                    if (((com.tencent.mm.plugin.nearby.a.c) mVar).Ah() == 2) {
                        Toast.makeText(this, R.string.d4k, 1).show();
                        this.oPQ = null;
                    }
                    AppMethodBeat.o(55478);
                    return;
                }
            }
        }
        if (mVar.getType() == 376) {
            if (((com.tencent.mm.plugin.nearby.a.d) mVar).Ah() != 1) {
                AppMethodBeat.o(55478);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0 && ((com.tencent.mm.plugin.nearby.a.d) mVar).gfa != null) {
                String str2 = ((com.tencent.mm.plugin.nearby.a.d) mVar).gfa;
                com.tencent.mm.plugin.nearby.a.b.fr(str2, ((com.tencent.mm.plugin.nearby.a.d) mVar).oPy);
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str2);
                com.tencent.mm.plugin.nearby.a.gkE.e(intent, (Context) this);
                AppMethodBeat.o(55478);
                return;
            }
            h.a(this.mController.ylL, (int) R.string.d58, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        AppMethodBeat.o(55478);
    }

    static /* synthetic */ void x(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.i(55481);
        if (nearbyFriendsUI.oQr != null) {
            nearbyFriendsUI.oQe = new com.tencent.mm.plugin.nearby.a.d(nearbyFriendsUI.oQr.fBs, nearbyFriendsUI.oQr.fBr, nearbyFriendsUI.oQr.accuracy, "", "");
            Context context = nearbyFriendsUI.mController.ylL;
            nearbyFriendsUI.getString(R.string.tz);
            nearbyFriendsUI.tipDialog = h.b(context, nearbyFriendsUI.getString(R.string.d59), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(55444);
                    com.tencent.mm.kernel.g.Rg().c(NearbyFriendsUI.this.oQe);
                    AppMethodBeat.o(55444);
                }
            });
            com.tencent.mm.plugin.nearby.a.b.zY(3);
            com.tencent.mm.kernel.g.Rg().a(nearbyFriendsUI.oQe, 0);
        }
        AppMethodBeat.o(55481);
    }

    static /* synthetic */ void o(ImageView imageView, String str) {
        AppMethodBeat.i(55482);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            AppMethodBeat.o(55482);
            return;
        }
        imageView.setImageBitmap(null);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePK = com.tencent.mm.plugin.i.c.XW();
        aVar.ePH = true;
        aVar.ePZ = true;
        o.ahp().a(str, imageView, aVar.ahG());
        AppMethodBeat.o(55482);
    }
}
