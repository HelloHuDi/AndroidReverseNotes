package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.id;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI extends MMActivity {
    private com.tencent.mm.af.j.b cJM;
    boolean cxS = false;
    private long edW;
    String eov = null;
    String filePath = null;
    private bi kua;
    private String lsy;
    private HorizontalListView voK;
    private boolean yFW;
    boolean yGE = false;
    private b yKA;
    private List<c> yKB = new ArrayList();
    private List<f> yKC = new ArrayList();
    private long yKD = 0;
    private boolean yKE = true;
    boolean yKF = false;
    boolean yKG = true;
    int yKH = 2;
    int yKI = -1;
    private HashMap<String, View> yKJ = new HashMap();
    private HashMap<String, c> yKK = new HashMap();
    private Map<Integer, View> yKL = new HashMap();
    private Map<String, Integer> yKM = new HashMap();
    WXMediaMessage yKN = null;
    private com.tencent.mm.sdk.b.c yKO = new com.tencent.mm.sdk.b.c<eg>() {
        {
            AppMethodBeat.i(30772);
            this.xxI = eg.class.getName().hashCode();
            AppMethodBeat.o(30772);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30773);
            boolean n = ChattingSendDataToDeviceUI.this.dCw().n((eg) bVar);
            AppMethodBeat.o(30773);
            return n;
        }
    };
    private com.tencent.mm.sdk.b.c yKP = new com.tencent.mm.sdk.b.c<ek>() {
        {
            AppMethodBeat.i(30761);
            this.xxI = ek.class.getName().hashCode();
            AppMethodBeat.o(30761);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30762);
            boolean n = ChattingSendDataToDeviceUI.this.dCw().n((ek) bVar);
            AppMethodBeat.o(30762);
            return n;
        }
    };
    private HorizontalListView yKr;
    private b yKs;
    private a yKt;
    private int yKu;
    private String yKv = "";
    private RelativeLayout yKw;
    private RelativeLayout yKx;
    private TextView yKy;
    private Boolean yKz = Boolean.FALSE;

    class a extends BaseAdapter {
        private Context context;
        private com.tencent.mm.at.a.a.c lyr;
        private List<Map<String, c>> yGD = new ArrayList();
        private Map<String, c> yKY;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(30782);
            c Op = Op(i);
            AppMethodBeat.o(30782);
            return Op;
        }

        public a(Context context) {
            AppMethodBeat.i(30777);
            this.context = context;
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePT = R.drawable.ajl;
            this.lyr = aVar.ahG();
            AppMethodBeat.o(30777);
        }

        public final void bw(List<c> list) {
            AppMethodBeat.i(30778);
            this.yGD.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.yKY = new HashMap();
                this.yKY.put("hard_device_info", list.get(i));
                this.yGD.add(this.yKY);
            }
            AppMethodBeat.o(30778);
        }

        public final int getCount() {
            AppMethodBeat.i(30779);
            int size = this.yGD.size();
            AppMethodBeat.o(30779);
            return size;
        }

        public final c Op(int i) {
            AppMethodBeat.i(30780);
            c cVar = (c) ((Map) this.yGD.get(i)).get("hard_device_info");
            AppMethodBeat.o(30780);
            return cVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            aq aqVar;
            View view2;
            AppMethodBeat.i(30781);
            c Op = Op(i);
            ab.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", Integer.valueOf(i), Integer.valueOf(getCount()));
            if (ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(i)) == null) {
                aqVar = new aq();
                View inflate = View.inflate(viewGroup.getContext(), R.layout.ar9, null);
                aqVar.lBq = inflate.findViewById(R.id.nc);
                aqVar.gxi = (TextView) inflate.findViewById(R.id.bi_);
                aqVar.iqT = (ImageView) inflate.findViewById(R.id.bi9);
                aqVar.yKX = (TextView) inflate.findViewById(R.id.e8v);
                aqVar.yMM = (SendDataToDeviceProgressBar) inflate.findViewById(R.id.e8u);
                aqVar.yMM.setVisibility(4);
                ChattingSendDataToDeviceUI.this.yKL.put(Integer.valueOf(i), inflate);
                inflate.setTag(aqVar);
                view2 = inflate;
            } else {
                View view3 = (View) ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(i));
                aqVar = (aq) view3.getTag();
                view2 = view3;
            }
            ChattingSendDataToDeviceUI.this.yKM.put(Op.deviceID, Integer.valueOf(i));
            String str = Op.eoz;
            int i2 = 8;
            int i3 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            float dm = com.tencent.mm.bz.a.dm(this.context);
            if (dm == 1.125f || dm == 1.25f) {
                i2 = 6;
            } else if (dm == 1.375f || dm == 1.625f) {
                i2 = 5;
            }
            for (int i4 = 0; i4 < str.length(); i4++) {
                int codePointAt = Character.codePointAt(str, i4);
                String substring = str.substring(i4, i4 + 1);
                if (codePointAt < 0 || codePointAt > 255) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 <= i2) {
                    stringBuffer = stringBuffer.append(substring);
                } else {
                    stringBuffer2 = stringBuffer2.append(substring);
                }
            }
            aqVar.gxi.setText(stringBuffer.toString());
            if (i3 >= i2) {
                aqVar.yKX.setText(stringBuffer2);
            }
            c cVar = null;
            if (ChattingSendDataToDeviceUI.this.yKK.containsKey(Op(i).deviceID)) {
                cVar = (c) ChattingSendDataToDeviceUI.this.yKK.get(Op(i).deviceID);
            }
            if (!(cVar == null || cVar.cxW == null)) {
                ab.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", Integer.valueOf(i), cVar.cxW);
                if (cVar.cxW.equals("send_data_sending")) {
                    aqVar.yKX.setText(this.context.getString(R.string.aol));
                    aqVar.yKX.setTextColor(this.context.getResources().getColor(R.color.z_));
                    aqVar.yMM.Os(Op.progress);
                    aqVar.yMM.setVisibility(0);
                    final c cVar2 = (c) ChattingSendDataToDeviceUI.this.yKK.get(Op.deviceID);
                    final int i5 = cVar2.progress;
                    if (i5 >= 100) {
                        i3 = 0;
                    } else {
                        i3 = 500 / (100 - i5);
                    }
                    d.h(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(30776);
                            int i = i5 + 1;
                            while (ChattingSendDataToDeviceUI.this.yKG) {
                                if (i >= 100) {
                                    try {
                                        if (cVar2.cxW.equals("send_data_sucess")) {
                                            ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(30774);
                                                    aqVar.yMM.Os(0);
                                                    aqVar.yMM.setVisibility(4);
                                                    aqVar.yKX.setText(ChattingSendDataToDeviceUI.this.getText(R.string.aoj));
                                                    aqVar.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.z_));
                                                    cVar2.cxW = "send_data_sucess";
                                                    cVar2.progress = 0;
                                                    ChattingSendDataToDeviceUI.this.yKK.put(cVar2.deviceID, cVar2);
                                                    ab.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", cVar2.deviceID);
                                                    AppMethodBeat.o(30774);
                                                }
                                            });
                                            AppMethodBeat.o(30776);
                                            return;
                                        } else if (cVar2.cxW.equals("send_data_failed")) {
                                            ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(30775);
                                                    aqVar.yMM.Os(0);
                                                    aqVar.yMM.setVisibility(4);
                                                    aqVar.yKX.setText(ChattingSendDataToDeviceUI.this.getText(R.string.aog));
                                                    aqVar.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.zc));
                                                    cVar2.cxW = "send_data_failed";
                                                    cVar2.progress = 0;
                                                    ChattingSendDataToDeviceUI.this.yKK.put(cVar2.deviceID, cVar2);
                                                    ab.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", cVar2.deviceID);
                                                    AppMethodBeat.o(30775);
                                                }
                                            });
                                            AppMethodBeat.o(30776);
                                            return;
                                        }
                                    } catch (Exception e) {
                                        ab.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", e);
                                    }
                                } else {
                                    aqVar.yMM.Os(i);
                                    cVar2.progress = i;
                                    i++;
                                    Thread.sleep((long) i3);
                                }
                            }
                            AppMethodBeat.o(30776);
                        }
                    }, "SendDataState_handler").start();
                } else if (cVar.cxW.equals("send_data_sucess")) {
                    aqVar.yKX.setText(this.context.getString(R.string.aoj));
                    aqVar.yKX.setTextColor(this.context.getResources().getColor(R.color.z_));
                    aqVar.yMM.setVisibility(4);
                } else if (cVar.cxW.equals("send_data_cancel")) {
                    aqVar.yKX.setText(this.context.getString(R.string.aoc));
                    aqVar.yKX.setTextColor(this.context.getResources().getColor(R.color.z8));
                    aqVar.yMM.setVisibility(4);
                } else if (cVar.cxW.equals("send_data_failed")) {
                    aqVar.yKX.setText(this.context.getString(R.string.aog));
                    aqVar.yKX.setTextColor(this.context.getResources().getColor(R.color.zc));
                    aqVar.yMM.setVisibility(4);
                }
            }
            ab.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", Integer.valueOf(i), Op.eoz);
            o.ahp().a(Op.iconUrl, aqVar.iqT, this.lyr);
            aqVar.lBq.setTag(Integer.valueOf(i));
            AppMethodBeat.o(30781);
            return view2;
        }
    }

    public class b {
        public final boolean n(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30784);
            boolean p;
            if (bVar instanceof eg) {
                p = p(bVar);
                AppMethodBeat.o(30784);
                return p;
            } else if (bVar instanceof ek) {
                p = o(bVar);
                AppMethodBeat.o(30784);
                return p;
            } else {
                AppMethodBeat.o(30784);
                return true;
            }
        }

        private boolean o(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30785);
            ek ekVar = (ek) bVar;
            String str = ekVar.cxU.cxW;
            String str2 = ekVar.cxU.ceI;
            if (str.equals("send_data_sending")) {
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, ekVar.cxU.progress);
            } else if (str.equals("send_data_failed")) {
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
            } else if (str.equals("send_data_sucess")) {
                ChattingSendDataToDeviceUI.this.arb(str2);
            }
            AppMethodBeat.o(30785);
            return true;
        }

        private boolean p(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30786);
            List list = ((eg) bVar).cxJ.cwW;
            List arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                c cVar = new c();
                cVar.cws = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.eoz = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.cxR = (String) ((Map) list.get(i2)).get("ability");
                cVar.yLc = (String) ((Map) list.get(i2)).get("abilityInf");
                if ((ChattingSendDataToDeviceUI.this.cxS && ChattingSendDataToDeviceUI.b(cVar, ChattingSendDataToDeviceUI.this.lsy)) || (!ChattingSendDataToDeviceUI.this.cxS && ChattingSendDataToDeviceUI.b(cVar, ChattingSendDataToDeviceUI.this.edW))) {
                    if (ChattingSendDataToDeviceUI.this.yKK.containsKey(cVar.deviceID) && ((c) ChattingSendDataToDeviceUI.this.yKK.get(cVar.deviceID)).cxW != null) {
                        cVar.cxW = ((c) ChattingSendDataToDeviceUI.this.yKK.get(cVar.deviceID)).cxW;
                        cVar.progress = ((c) ChattingSendDataToDeviceUI.this.yKK.get(cVar.deviceID)).progress;
                    }
                    arrayList.add(cVar);
                }
                i = i2 + 1;
            }
            if (ChattingSendDataToDeviceUI.this.yKB.size() != arrayList.size()) {
                ChattingSendDataToDeviceUI.this.yKB = arrayList;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(30783);
                        ChattingSendDataToDeviceUI.this.yKt.bw(ChattingSendDataToDeviceUI.this.yKB);
                        if (ChattingSendDataToDeviceUI.this.yKt.getCount() > 0) {
                            ChattingSendDataToDeviceUI.this.yKy.setText(R.string.ajz);
                            ChattingSendDataToDeviceUI.this.yKE = false;
                        }
                        ChattingSendDataToDeviceUI.this.yKt.notifyDataSetChanged();
                        AppMethodBeat.o(30783);
                    }
                });
            }
            AppMethodBeat.o(30786);
            return true;
        }
    }

    public class c {
        String cws;
        String cxR;
        String cxW;
        String deviceID;
        String eoz;
        String iconUrl;
        int progress;
        String yLc;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChattingSendDataToDeviceUI() {
        AppMethodBeat.i(30787);
        AppMethodBeat.o(30787);
    }

    static /* synthetic */ void j(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        AppMethodBeat.i(30807);
        chattingSendDataToDeviceUI.dCu();
        AppMethodBeat.o(30807);
    }

    /* JADX WARNING: Missing block: B:121:0x0344, code skipped:
            if (r6 == 62) goto L_0x02e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        String str;
        int i;
        int i2 = 6;
        AppMethodBeat.i(30788);
        super.onCreate(bundle);
        this.cxS = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
        ab.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.cxS);
        if (!this.cxS) {
            this.edW = getIntent().getExtras().getLong("Retr_Msg_Id");
            if (this.edW != -1) {
                aw.ZK();
                this.kua = com.tencent.mm.model.c.XO().jf(this.edW);
                if (!(this.kua == null || this.kua.field_msgId == 0)) {
                    this.yKu = this.kua.getType();
                    this.yFW = t.kH(this.kua.field_talker);
                    this.yKv = this.kua.field_content;
                    if (this.yFW && this.kua.field_isSend == 0) {
                        str = this.kua.field_content;
                        i = this.kua.field_isSend;
                        if (this.yFW && str != null && i == 0) {
                            str = bf.oz(str);
                        }
                        this.yKv = str;
                    }
                    Long aik;
                    e w;
                    if (this.kua.getType() == 49) {
                        this.cJM = com.tencent.mm.af.j.b.me(this.yKv);
                        if (this.cJM == null) {
                            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
                        } else if (this.cJM.type == 3) {
                            this.yKD = 16;
                        } else if (this.cJM.type == 4) {
                            this.yKD = 8;
                        } else if (this.cJM.type == 5) {
                            this.yKD = 32;
                        } else if (this.cJM.type == 6) {
                            aik = com.tencent.mm.pluginsdk.c.a.aik(this.cJM.fgp);
                            if (aik == null) {
                                ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
                            } else {
                                this.yKD = aik.longValue();
                            }
                        } else if (this.cJM.type == 2) {
                            this.yKD = 2;
                            w = o.ahl().w(this.kua);
                            if (w != null) {
                                this.yKv = w.fDK;
                            }
                        } else {
                            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
                        }
                    } else {
                        if (this.kua.getType() == 3) {
                            w = o.ahl().w(this.kua);
                            if (w != null) {
                                this.yKv = w.fDK;
                            }
                        } else if (this.kua.getType() == 43) {
                            s uf = com.tencent.mm.modelvideo.o.all().uf(this.kua.field_imgPath);
                            if (uf != null) {
                                this.yKv = uf.alw();
                            }
                        }
                        aik = com.tencent.mm.pluginsdk.c.a.aik(this.yKu);
                        if (aik == null) {
                            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
                        } else {
                            this.yKD = aik.longValue();
                        }
                    }
                    ab.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", Long.valueOf(this.yKD));
                }
            }
        }
        this.yKH = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
        this.yKF = false;
        setFinishOnTouchOutside(true);
        this.yKB.clear();
        this.yKK.clear();
        this.yKw = (RelativeLayout) findViewById(R.id.au_);
        dq dqVar = new dq();
        if (this.cxS) {
            this.lsy = getIntent().getExtras().getString("sns_local_id");
            if (this.lsy != null) {
                dqVar.cxc.cwT = this.lsy;
                ab.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", this.lsy);
            }
        } else {
            dqVar.cxc.cvx = this.edW;
        }
        com.tencent.mm.sdk.b.a.xxA.m(dqVar);
        if (dqVar.cxd.cwB) {
            this.yKz = Boolean.TRUE;
            com.tencent.mm.sdk.b.a.xxA.c(this.yKO);
            com.tencent.mm.sdk.b.a.xxA.c(this.yKP);
            this.yKw.setVisibility(0);
            this.voK = (HorizontalListView) findViewById(R.id.a46);
            this.yKy = (TextView) findViewById(R.id.aua);
            this.yKy.setText(R.string.ao2);
            this.yKt = new a(this);
            this.voK.setAdapter(this.yKt);
            this.voK.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(30760);
                    ChattingSendDataToDeviceUI.this.yKF = true;
                    c Op = ChattingSendDataToDeviceUI.this.yKt.Op(i);
                    String str = Op.cws;
                    String str2 = Op.deviceID;
                    String str3 = Op.cxR;
                    try {
                        if (ChattingSendDataToDeviceUI.this.yKJ.get(str2) != null) {
                            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                            dd ddVar = new dd();
                            ddVar.cwo.ceI = str2;
                            com.tencent.mm.sdk.b.a.xxA.m(ddVar);
                            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", str2, 0);
                            Op.cxW = "send_data_cancel";
                            ChattingSendDataToDeviceUI.this.yKJ.remove(str2);
                            aq aqVar = (aq) ((View) ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(i))).getTag();
                            aqVar.yKX.setText(ChattingSendDataToDeviceUI.this.getText(R.string.aoc));
                            aqVar.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.z8));
                            aqVar.yMM.setVisibility(8);
                            aqVar.yMM.Os(0);
                            AppMethodBeat.o(30760);
                            return;
                        }
                        Op.cxW = "send_data_sending";
                        ChattingSendDataToDeviceUI.this.yKK.put(Op.deviceID, Op);
                        ChattingSendDataToDeviceUI.this.yKJ.put(str2, view);
                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, 1);
                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
                        ej ejVar = new ej();
                        ejVar.cxP.ceI = str2;
                        ejVar.cxP.cws = str;
                        ejVar.cxP.data = ChattingSendDataToDeviceUI.this.yKv;
                        ejVar.cxP.cxR = str3;
                        if (ChattingSendDataToDeviceUI.this.cxS) {
                            ejVar.cxP.cwT = ChattingSendDataToDeviceUI.this.lsy;
                            ejVar.cxP.cxS = ChattingSendDataToDeviceUI.this.cxS;
                        } else {
                            ejVar.cxP.cvx = ChattingSendDataToDeviceUI.this.edW;
                        }
                        com.tencent.mm.sdk.b.a.xxA.m(ejVar);
                        if (!ejVar.cxQ.cxT) {
                            ChattingSendDataToDeviceUI.arc("send_data_failed");
                            ab.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
                        }
                        AppMethodBeat.o(30760);
                    } catch (Exception e) {
                        ChattingSendDataToDeviceUI.arc("send_data_failed");
                        ab.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", e);
                        AppMethodBeat.o(30760);
                    }
                }
            });
            dCv();
            if (this.cxS) {
                int i3;
                str = this.lsy;
                if (str != null) {
                    id idVar = new id();
                    idVar.cDc.cwT = str;
                    com.tencent.mm.sdk.b.a.xxA.m(idVar);
                    i3 = idVar.cDd.cDe.xfI.wbJ;
                    if (i3 == 1) {
                        i3 = 3;
                    } else if (i3 == 4) {
                        i3 = 1;
                    } else if (i3 == 15) {
                        i3 = 6;
                    } else if (i3 == 3) {
                        i3 = 5;
                    }
                    this.yKI = i3;
                }
                i3 = 0;
                this.yKI = i3;
            } else {
                long j = this.edW;
                if (j == -1 || j == Long.MIN_VALUE) {
                    i2 = 0;
                } else {
                    aw.ZK();
                    bi jf = com.tencent.mm.model.c.XO().jf(j);
                    if (jf.field_msgId != 0) {
                        i = jf.getType();
                        String str2 = jf.field_content;
                        if (jf.bAA()) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str2);
                            if (me == null) {
                                ab.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                            } else if (me.type == 3) {
                                i2 = 1;
                            } else if (me.type != 4) {
                                if (me.type == 6) {
                                    i2 = 4;
                                } else if (me.type == 2) {
                                    i2 = 3;
                                } else if (me.type == 5) {
                                    i2 = 5;
                                }
                            }
                        } else if (i == 3) {
                            i2 = 3;
                        } else if (i == 48) {
                            i2 = 2;
                        }
                    }
                    i2 = 0;
                }
                this.yKI = i2;
            }
            uP(1);
        } else {
            this.yKw.setVisibility(8);
        }
        this.yKx = (RelativeLayout) findViewById(R.id.aue);
        this.yKr = (HorizontalListView) findViewById(R.id.aug);
        this.yKs = new b(this);
        this.yKr.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(30764);
                ab.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", Integer.valueOf(i));
                if (i == adapterView.getAdapter().getCount() - 1) {
                    Intent intent = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("KFlag", ChattingSendDataToDeviceUI.this.yKD);
                    ChattingSendDataToDeviceUI.this.startActivity(intent);
                    AppMethodBeat.o(30764);
                } else if (!ChattingSendDataToDeviceUI.this.yGE || i != adapterView.getAdapter().getCount() - 2) {
                    if (i >= 0 && i < adapterView.getAdapter().getCount() - 1) {
                        final f fVar = (f) ChattingSendDataToDeviceUI.this.yKC.get(i);
                        if (g.a(ChattingSendDataToDeviceUI.this.getBaseContext(), fVar)) {
                            com.tencent.mm.ce.a.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(30763);
                                    g.a(ChattingSendDataToDeviceUI.this.getBaseContext(), fVar.field_packageName, ChattingSendDataToDeviceUI.this.yKN, fVar.field_appId, fVar.field_openId, 0, null, null);
                                    AppMethodBeat.o(30763);
                                }
                            });
                        } else {
                            h.bQ(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.string.aob));
                            fVar.field_status = 4;
                            am.bYJ().a(fVar, new String[0]);
                            ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
                            AppMethodBeat.o(30764);
                            return;
                        }
                    }
                    AppMethodBeat.o(30764);
                } else if (ChattingSendDataToDeviceUI.this.filePath == null || ChattingSendDataToDeviceUI.this.eov == null) {
                    h.bQ(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.string.b6t));
                    AppMethodBeat.o(30764);
                } else {
                    com.tencent.mm.pluginsdk.ui.tools.a.a(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.eov.toLowerCase(), 1);
                    AppMethodBeat.o(30764);
                }
            }
        });
        this.yKr.setAdapter(this.yKs);
        AppMethodBeat.o(30788);
    }

    private void uP(int i) {
        AppMethodBeat.i(30789);
        if (this.cxS) {
            com.tencent.mm.plugin.report.service.h.pYm.e(13197, Integer.valueOf(i), Integer.valueOf(this.yKI), "", Integer.valueOf(2), Integer.valueOf(this.yKH));
            AppMethodBeat.o(30789);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(13197, Integer.valueOf(i), Integer.valueOf(this.yKI), na(this.edW), Integer.valueOf(1), Integer.valueOf(this.yKH));
        AppMethodBeat.o(30789);
    }

    private static String na(long j) {
        AppMethodBeat.i(30790);
        String str = "";
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        if (jf.field_msgId == 0) {
            str = "";
            AppMethodBeat.o(30790);
            return str;
        }
        String str2 = jf.field_content;
        if (jf.getType() == 49) {
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str2);
            if (me != null && me.type == 6) {
                str = me.fgp;
            }
        }
        AppMethodBeat.o(30790);
        return str;
    }

    public final int getLayoutId() {
        return R.layout.nz;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(30791);
        super.onConfigurationChanged(configuration);
        do doVar = new do();
        if (this.cxS) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            doVar.cwR.cwT = this.lsy;
            doVar.cwR.cwU = string;
            doVar.cwR.cwV = i;
        } else {
            doVar.cwR.cvx = this.edW;
        }
        com.tencent.mm.sdk.b.a.xxA.m(doVar);
        if (doVar.cwS.cwB && this.yKB.size() > 0) {
            ab.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", Integer.valueOf(this.yKB.size()));
            this.yKt.bw(this.yKB);
            if (this.yKt.getCount() > 0) {
                this.yKy.setText(R.string.ajz);
                this.yKE = false;
            }
            this.yKt.notifyDataSetChanged();
        }
        AppMethodBeat.o(30791);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dCu() {
        AppMethodBeat.i(30792);
        if (this.yKs == null || this.yKD == 0) {
            String str = "MicroMsg.ChattingSendDataToDeviceUI";
            String str2 = "mAppInfoAdapter is null %s, contentFlag %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.yKs == null);
            objArr[1] = Long.valueOf(this.yKD);
            ab.e(str, str2, objArr);
            if (this.yKx != null) {
                this.yKx.setVisibility(8);
            }
            AppMethodBeat.o(30792);
            return;
        }
        this.yKC = g.b((Context) this, this.yKD, false);
        if (!(g.o(this, this.yKD) || this.yKx == null)) {
            this.yKx.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        if (this.yKC != null && this.yKC.size() > 0) {
            final List mb = am.dhO().mb(this.yKD);
            if (mb != null && mb.size() > 0) {
                Collections.sort(this.yKC, new Comparator<f>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        AppMethodBeat.i(30765);
                        f fVar = (f) obj2;
                        int indexOf = mb.indexOf(fVar.field_appId) - mb.indexOf(((f) obj).field_appId);
                        AppMethodBeat.o(30765);
                        return indexOf;
                    }
                });
            }
            for (f fVar : this.yKC) {
                z zVar = new z();
                zVar.appId = fVar.field_appId;
                zVar.eoz = fVar.field_appName;
                zVar.iconUrl = fVar.field_appIconUrl;
                arrayList.add(zVar);
            }
        }
        if (this.yKN == null) {
            IMediaObject iMediaObject = null;
            e w;
            int lastIndexOf;
            switch (this.kua.getType()) {
                case 1:
                    iMediaObject = new WXTextObject(this.kua.field_content);
                case 3:
                    iMediaObject = new WXImageObject();
                    w = o.ahl().w(this.kua);
                    if (w != null) {
                        iMediaObject.imagePath = o.ahl().sj(w.fDz);
                        if (bo.isNullOrNil(iMediaObject.imagePath)) {
                            iMediaObject.imagePath = o.ahl().sj(w.fDB);
                        }
                        if (!bo.isNullOrNil(iMediaObject.imagePath)) {
                            this.filePath = iMediaObject.imagePath;
                            lastIndexOf = iMediaObject.imagePath.lastIndexOf(".");
                            if (lastIndexOf >= 0 && lastIndexOf < iMediaObject.imagePath.length() - 1) {
                                this.eov = iMediaObject.imagePath.substring(lastIndexOf + 1);
                            }
                        }
                    }
                    ab.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", iMediaObject.imagePath);
                case 43:
                    iMediaObject = new WXVideoObject();
                    com.tencent.mm.modelvideo.o.all();
                    String uh = com.tencent.mm.modelvideo.t.uh(this.kua.field_imgPath);
                    if (uh != null) {
                        iMediaObject.videoUrl = uh;
                        this.filePath = uh;
                        lastIndexOf = uh.lastIndexOf(".");
                        if (lastIndexOf >= 0 && lastIndexOf < uh.length() - 1) {
                            this.eov = uh.substring(lastIndexOf + 1);
                        }
                    }
                case 48:
                    aw.ZK();
                    com.tencent.mm.storage.bi.b Ro = com.tencent.mm.model.c.XO().Ro(this.kua.field_content);
                    iMediaObject = new WXLocationObject(Ro.nJu, Ro.nJv);
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    if (this.cJM != null) {
                        if (this.cJM.type == 3) {
                            iMediaObject = new WXMusicObject();
                            iMediaObject.musicUrl = this.cJM.url;
                            iMediaObject.musicDataUrl = this.cJM.fgM;
                            iMediaObject.musicLowBandUrl = this.cJM.fgn;
                            iMediaObject.musicLowBandDataUrl = this.cJM.fgN;
                        } else if (this.cJM.type == 4) {
                            iMediaObject = new WXVideoObject();
                            iMediaObject.videoUrl = this.cJM.url;
                            iMediaObject.videoLowBandUrl = this.cJM.fgN;
                        } else if (this.cJM.type == 5) {
                            iMediaObject = new WXWebpageObject(this.cJM.url);
                        } else if (this.cJM.type == 6) {
                            com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(this.cJM.csD);
                            if (aiE != null) {
                                ab.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", aiE.field_fileFullPath);
                                iMediaObject = new WXFileObject(aiE.field_fileFullPath);
                                this.filePath = aiE.field_fileFullPath;
                                this.eov = this.cJM.fgp;
                            } else {
                                ab.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
                            }
                            if (q.aiR(this.filePath) != null) {
                                h.bQ(this, getString(R.string.aoa));
                                finish();
                                break;
                            }
                        } else if (this.cJM.type == 2) {
                            iMediaObject = new WXImageObject();
                            w = o.ahl().w(this.kua);
                            if (w != null) {
                                iMediaObject.imagePath = o.ahl().sj(w.fDz);
                                if (bo.isNullOrNil(iMediaObject.imagePath)) {
                                    iMediaObject.imagePath = o.ahl().sj(w.fDB);
                                }
                            }
                            this.filePath = iMediaObject.imagePath;
                            this.eov = this.cJM.fgp;
                            ab.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", iMediaObject.imagePath);
                        }
                    }
            }
            this.yKN = new WXMediaMessage(iMediaObject);
            this.yKN.sdkVer = Build.SDK_INT;
            if (!(this.eov == null || this.filePath == null || iMediaObject == null || !(iMediaObject instanceof WXFileObject))) {
                this.yGE = true;
            }
        }
        this.yKs.yGE = this.yGE;
        this.yKs.bw(arrayList);
        this.yKs.notifyDataSetChanged();
        AppMethodBeat.o(30792);
    }

    private void dCv() {
        AppMethodBeat.i(30793);
        do doVar = new do();
        if (this.cxS) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            doVar.cwR.cwT = this.lsy;
            doVar.cwR.cwU = string;
            doVar.cwR.cwV = i;
        } else {
            doVar.cwR.cvx = this.edW;
        }
        com.tencent.mm.sdk.b.a.xxA.m(doVar);
        if (doVar.cwS.cwB) {
            List list = doVar.cwS.cwW;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = new c();
                cVar.cws = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.eoz = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.cxR = (String) ((Map) list.get(i2)).get("ability");
                cVar.yLc = (String) ((Map) list.get(i2)).get("abilityInf");
                if (this.cxS && a(cVar, this.lsy)) {
                    this.yKB.add(cVar);
                } else if (!this.cxS && a(cVar, this.edW)) {
                    this.yKB.add(cVar);
                }
            }
            if (this.yKB.size() > 0) {
                ab.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
                this.yKt.bw(this.yKB);
                if (this.yKt.getCount() > 0) {
                    this.yKy.setText(R.string.ajz);
                    this.yKE = false;
                }
                this.yKt.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(30793);
    }

    private static boolean a(String str, c cVar) {
        boolean z = false;
        AppMethodBeat.i(30794);
        String str2 = cVar.cxR;
        String str3 = cVar.yLc;
        String host = Uri.parse(str).getHost();
        if (str3 != null && str3.length() > 0 && str2 != null && str2.contains("wxmsg_url")) {
            try {
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("wxmsg_url");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).equals(host)) {
                        z = true;
                        break;
                    }
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", e, str3, new Object[0]);
            }
        }
        AppMethodBeat.o(30794);
        return z;
    }

    /* JADX WARNING: Missing block: B:8:0x004e, code skipped:
            if (r4.contains("wxmsg_image") != false) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:13:0x005f, code skipped:
            if (r4.contains("wxmsg_music") == false) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:18:0x006e, code skipped:
            if (r4.contains("wxmsg_video") != false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(c cVar, String str) {
        boolean z = true;
        AppMethodBeat.i(30795);
        if (str == null) {
            AppMethodBeat.o(30795);
            return false;
        }
        id idVar = new id();
        idVar.cDc.cwT = str;
        com.tencent.mm.sdk.b.a.xxA.m(idVar);
        TimeLineObject timeLineObject = idVar.cDd.cDe;
        int i = timeLineObject.xfI.wbJ;
        ab.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", Integer.valueOf(i));
        String str2 = cVar.cxR;
        if (str2 == null) {
            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
            AppMethodBeat.o(30795);
            return false;
        }
        if (i != 1) {
            if (i != 4) {
                if (i != 15) {
                    if (i == 3) {
                        z = a(timeLineObject.xfI.Url, cVar);
                    }
                    z = false;
                }
            }
        }
        AppMethodBeat.o(30795);
        return z;
    }

    public void onBackPressed() {
        AppMethodBeat.i(30796);
        if (this.yKJ.size() > 0) {
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
            aVar.PZ(R.string.aod);
            aVar.Qc(R.string.aof).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(30766);
                    for (String str : ChattingSendDataToDeviceUI.this.yKJ.keySet()) {
                        dd ddVar = new dd();
                        ddVar.cwo.ceI = str;
                        com.tencent.mm.sdk.b.a.xxA.m(ddVar);
                    }
                    ChattingSendDataToDeviceUI.this.finish();
                    AppMethodBeat.o(30766);
                }
            });
            aVar.Qd(R.string.aoe).b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(30767);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(30767);
                }
            });
            aVar.aMb().show();
            AppMethodBeat.o(30796);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(30796);
    }

    public final void arb(String str) {
        AppMethodBeat.i(30797);
        try {
            int i;
            final aq aqVar = (aq) ((View) this.yKL.get(Integer.valueOf(((Integer) this.yKM.get(str)).intValue()))).getTag();
            ab.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", Integer.valueOf(aqVar.yMM.getProgress()), str);
            final c cVar = (c) this.yKK.get(str);
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30768);
                    aqVar.yMM.setVisibility(0);
                    aqVar.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.z_));
                    aqVar.yKX.setText(ChattingSendDataToDeviceUI.this.getText(R.string.aol));
                    cVar.cxW = "send_data_sending";
                    AppMethodBeat.o(30768);
                }
            });
            final int abs = Math.abs(aqVar.yMM.getProgress());
            cVar.progress = abs;
            if (abs >= 100) {
                i = 0;
            } else {
                i = 500 / (100 - abs);
            }
            ab.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", Integer.valueOf(i));
            final String str2 = str;
            d.h(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30770);
                    int i = abs + 1;
                    while (true) {
                        if (i >= 100) {
                            try {
                                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(30769);
                                        aqVar.yMM.Os(0);
                                        ChattingSendDataToDeviceUI.this.yKJ.remove(str2);
                                        aqVar.yMM.setVisibility(4);
                                        aqVar.yKX.setText(ChattingSendDataToDeviceUI.this.getText(R.string.aoj));
                                        aqVar.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.z_));
                                        cVar.cxW = "send_data_sucess";
                                        cVar.progress = 0;
                                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 4);
                                        AppMethodBeat.o(30769);
                                    }
                                });
                                break;
                            } catch (Exception e) {
                                ab.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", e);
                            }
                        } else {
                            aqVar.yMM.Os(i);
                            i++;
                            Thread.sleep((long) i);
                        }
                    }
                    AppMethodBeat.o(30770);
                }
            }, "progressSuccess_handler").start();
            this.yKK.put(cVar.deviceID, cVar);
            AppMethodBeat.o(30797);
        } catch (Exception e) {
            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", e);
            AppMethodBeat.o(30797);
        }
    }

    /* JADX WARNING: Missing block: B:15:0x0057, code skipped:
            if (r2.contains("wxmsg_music") != false) goto L_0x0059;
     */
    /* JADX WARNING: Missing block: B:23:0x0071, code skipped:
            if (r2.contains("wxmsg_file") == false) goto L_0x0073;
     */
    /* JADX WARNING: Missing block: B:31:0x008d, code skipped:
            if (r2.contains("wxmsg_image") != false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(c cVar, long j) {
        boolean z = true;
        AppMethodBeat.i(30798);
        if (j == -1) {
            AppMethodBeat.o(30798);
            return false;
        }
        String str = cVar.cxR;
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        if (jf.field_msgId == 0 || str == null) {
            AppMethodBeat.o(30798);
            return false;
        }
        int type = jf.getType();
        String str2 = jf.field_content;
        if (jf.bAA()) {
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str2);
            if (me == null) {
                ab.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                AppMethodBeat.o(30798);
                return false;
            } else if (me.type != 3) {
                if (me.type == 4) {
                    z = false;
                } else if (me.type != 6) {
                    if (me.type == 5) {
                        z = a(me.url, cVar);
                    } else {
                        if (me.type == 2) {
                        }
                    }
                }
            }
        } else {
            z = type != 3 ? false : false;
        }
        AppMethodBeat.o(30798);
        return z;
    }

    public void onResume() {
        AppMethodBeat.i(30799);
        super.onResume();
        dCu();
        if (this.yKz.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) this.voK.getLayoutParams();
            int i = layoutParams.height;
            float dm = com.tencent.mm.bz.a.dm(this);
            if (dm == 1.125f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.dimen.le);
            } else if (dm == 1.375f || dm == 1.25f || dm == 1.625f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.dimen.m4);
            }
            this.voK.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(30799);
    }

    public void onPause() {
        AppMethodBeat.i(30800);
        super.onPause();
        AppMethodBeat.o(30800);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(30801);
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.string.b6t, R.string.b6u, 1);
        AppMethodBeat.o(30801);
    }

    public void onDestroy() {
        AppMethodBeat.i(30802);
        super.onDestroy();
        ab.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
        this.yKG = false;
        if (this.yKz.booleanValue()) {
            if (!this.yKF) {
                uP(2);
            }
            com.tencent.mm.sdk.b.a.xxA.d(this.yKO);
            com.tencent.mm.sdk.b.a.xxA.d(this.yKP);
            ew ewVar = new ew();
            com.tencent.mm.sdk.b.a.xxA.m(ewVar);
            if (ewVar.cyq.cxT) {
                ab.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
            }
        }
        AppMethodBeat.o(30802);
    }

    public final b dCw() {
        AppMethodBeat.i(30803);
        if (this.yKA == null) {
            this.yKA = new b();
        }
        b bVar = this.yKA;
        AppMethodBeat.o(30803);
        return bVar;
    }

    static /* synthetic */ void a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, final String str, final String str2, final int i) {
        AppMethodBeat.i(30804);
        ab.d("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data State:%s progress: %d", str, Integer.valueOf(i));
        chattingSendDataToDeviceUI.runOnUiThread(new Runnable() {
            TextView yKX;

            public final void run() {
                AppMethodBeat.i(30771);
                try {
                    c cVar = (c) ChattingSendDataToDeviceUI.this.yKK.get(str2);
                    cVar.cxW = str;
                    if (i > cVar.progress) {
                        cVar.progress = i;
                    }
                    View view = (View) ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(((Integer) ChattingSendDataToDeviceUI.this.yKM.get(str2)).intValue()));
                    aq aqVar = (aq) view.getTag();
                    if (aqVar == null) {
                        ab.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
                        AppMethodBeat.o(30771);
                        return;
                    }
                    this.yKX = aqVar.yKX;
                    this.yKX.setVisibility(0);
                    if (str.equals("send_data_failed")) {
                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 5);
                        this.yKX.setText(ChattingSendDataToDeviceUI.this.getString(R.string.aog));
                        ChattingSendDataToDeviceUI.this.yKJ.remove(str2);
                        this.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.zc));
                        ChattingSendDataToDeviceUI.a(false, 0, view);
                    } else if (str.equals("send_data_sending")) {
                        this.yKX.setText(ChattingSendDataToDeviceUI.this.getString(R.string.aol));
                        this.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.z_));
                        ChattingSendDataToDeviceUI.a(true, i, view);
                    } else if (str.equals("send_data_cancel")) {
                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 6);
                        this.yKX.setText(ChattingSendDataToDeviceUI.this.getString(R.string.aoc));
                        this.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.z8));
                        ChattingSendDataToDeviceUI.a(true, 0, view);
                    }
                    ChattingSendDataToDeviceUI.this.yKK.put(cVar.deviceID, cVar);
                    AppMethodBeat.o(30771);
                } catch (Exception e) {
                    ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", e.getMessage());
                    AppMethodBeat.o(30771);
                }
            }
        });
        AppMethodBeat.o(30804);
    }

    static /* synthetic */ void arc(String str) {
        AppMethodBeat.i(30806);
        ek ekVar = new ek();
        ekVar.cxU.cxW = str;
        com.tencent.mm.sdk.b.a.xxA.m(ekVar);
        AppMethodBeat.o(30806);
    }

    static /* synthetic */ void a(boolean z, int i, View view) {
        AppMethodBeat.i(30808);
        try {
            aq aqVar = (aq) view.getTag();
            if (aqVar == null) {
                AppMethodBeat.o(30808);
                return;
            }
            if (z) {
                aqVar.yMM.setVisibility(0);
                if (i > aqVar.yMM.getProgress()) {
                    aqVar.yMM.Os(i);
                    AppMethodBeat.o(30808);
                    return;
                }
            }
            aqVar.yMM.setVisibility(4);
            aqVar.yMM.Os(0);
            AppMethodBeat.o(30808);
        } catch (Exception e) {
            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress exception %s", e);
            AppMethodBeat.o(30808);
        }
    }
}
