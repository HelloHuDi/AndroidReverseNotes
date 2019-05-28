package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26129ew;
import com.tencent.p177mm.p230g.p231a.C37710ek;
import com.tencent.p177mm.p230g.p231a.C41981do;
import com.tencent.p177mm.p230g.p231a.C41987ej;
import com.tencent.p177mm.p230g.p231a.C45318dd;
import com.tencent.p177mm.p230g.p231a.C45320eg;
import com.tencent.p177mm.p230g.p231a.C45333id;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.Sort3rdAppUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.HorizontalListView;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30033c.C23234a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
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

@C5271a(3)
/* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI */
public class ChattingSendDataToDeviceUI extends MMActivity {
    private C8910b cJM;
    boolean cxS = false;
    private long edW;
    String eov = null;
    String filePath = null;
    private C7620bi kua;
    private String lsy;
    private HorizontalListView voK;
    private boolean yFW;
    boolean yGE = false;
    private C30433b yKA;
    private List<C30436c> yKB = new ArrayList();
    private List<C40439f> yKC = new ArrayList();
    private long yKD = 0;
    private boolean yKE = true;
    boolean yKF = false;
    boolean yKG = true;
    int yKH = 2;
    int yKI = -1;
    private HashMap<String, View> yKJ = new HashMap();
    private HashMap<String, C30436c> yKK = new HashMap();
    private Map<Integer, View> yKL = new HashMap();
    private Map<String, Integer> yKM = new HashMap();
    WXMediaMessage yKN = null;
    private C4884c yKO = new C2367410();
    private C4884c yKP = new C236752();
    private HorizontalListView yKr;
    private C46639b yKs;
    private C30425a yKt;
    private int yKu;
    private String yKv = "";
    private RelativeLayout yKw;
    private RelativeLayout yKx;
    private TextView yKy;
    private Boolean yKz = Boolean.FALSE;

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$10 */
    class C2367410 extends C4884c<C45320eg> {
        C2367410() {
            AppMethodBeat.m2504i(30772);
            this.xxI = C45320eg.class.getName().hashCode();
            AppMethodBeat.m2505o(30772);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(30773);
            boolean n = ChattingSendDataToDeviceUI.this.dCw().mo48834n((C45320eg) c4883b);
            AppMethodBeat.m2505o(30773);
            return n;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$2 */
    class C236752 extends C4884c<C37710ek> {
        C236752() {
            AppMethodBeat.m2504i(30761);
            this.xxI = C37710ek.class.getName().hashCode();
            AppMethodBeat.m2505o(30761);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(30762);
            boolean n = ChattingSendDataToDeviceUI.this.dCw().mo48834n((C37710ek) c4883b);
            AppMethodBeat.m2505o(30762);
            return n;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$5 */
    class C304245 implements OnClickListener {
        C304245() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(30766);
            for (String str : ChattingSendDataToDeviceUI.this.yKJ.keySet()) {
                C45318dd c45318dd = new C45318dd();
                c45318dd.cwo.ceI = str;
                C4879a.xxA.mo10055m(c45318dd);
            }
            ChattingSendDataToDeviceUI.this.finish();
            AppMethodBeat.m2505o(30766);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$a */
    class C30425a extends BaseAdapter {
        private Context context;
        private C25814c lyr;
        private List<Map<String, C30436c>> yGD = new ArrayList();
        private Map<String, C30436c> yKY;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(30782);
            C30436c Op = mo48819Op(i);
            AppMethodBeat.m2505o(30782);
            return Op;
        }

        public C30425a(Context context) {
            AppMethodBeat.m2504i(30777);
            this.context = context;
            C17927a c17927a = new C17927a();
            c17927a.ePT = C25738R.drawable.ajl;
            this.lyr = c17927a.ahG();
            AppMethodBeat.m2505o(30777);
        }

        /* renamed from: bw */
        public final void mo48820bw(List<C30436c> list) {
            AppMethodBeat.m2504i(30778);
            this.yGD.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.yKY = new HashMap();
                this.yKY.put("hard_device_info", list.get(i));
                this.yGD.add(this.yKY);
            }
            AppMethodBeat.m2505o(30778);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(30779);
            int size = this.yGD.size();
            AppMethodBeat.m2505o(30779);
            return size;
        }

        /* renamed from: Op */
        public final C30436c mo48819Op(int i) {
            AppMethodBeat.m2504i(30780);
            C30436c c30436c = (C30436c) ((Map) this.yGD.get(i)).get("hard_device_info");
            AppMethodBeat.m2505o(30780);
            return c30436c;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C23704aq c23704aq;
            View view2;
            AppMethodBeat.m2504i(30781);
            C30436c Op = mo48819Op(i);
            C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", Integer.valueOf(i), Integer.valueOf(getCount()));
            if (ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(i)) == null) {
                c23704aq = new C23704aq();
                View inflate = View.inflate(viewGroup.getContext(), 2130970614, null);
                c23704aq.lBq = inflate.findViewById(2131821064);
                c23704aq.gxi = (TextView) inflate.findViewById(2131823625);
                c23704aq.iqT = (ImageView) inflate.findViewById(2131823624);
                c23704aq.yKX = (TextView) inflate.findViewById(2131827346);
                c23704aq.yMM = (SendDataToDeviceProgressBar) inflate.findViewById(2131827345);
                c23704aq.yMM.setVisibility(4);
                ChattingSendDataToDeviceUI.this.yKL.put(Integer.valueOf(i), inflate);
                inflate.setTag(c23704aq);
                view2 = inflate;
            } else {
                View view3 = (View) ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(i));
                c23704aq = (C23704aq) view3.getTag();
                view2 = view3;
            }
            ChattingSendDataToDeviceUI.this.yKM.put(Op.deviceID, Integer.valueOf(i));
            String str = Op.eoz;
            int i2 = 8;
            int i3 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            float dm = C1338a.m2860dm(this.context);
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
            c23704aq.gxi.setText(stringBuffer.toString());
            if (i3 >= i2) {
                c23704aq.yKX.setText(stringBuffer2);
            }
            C30436c c30436c = null;
            if (ChattingSendDataToDeviceUI.this.yKK.containsKey(mo48819Op(i).deviceID)) {
                c30436c = (C30436c) ChattingSendDataToDeviceUI.this.yKK.get(mo48819Op(i).deviceID);
            }
            if (!(c30436c == null || c30436c.cxW == null)) {
                C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", Integer.valueOf(i), c30436c.cxW);
                if (c30436c.cxW.equals("send_data_sending")) {
                    c23704aq.yKX.setText(this.context.getString(C25738R.string.aol));
                    c23704aq.yKX.setTextColor(this.context.getResources().getColor(C25738R.color.f12300z_));
                    c23704aq.yMM.mo70164Os(Op.progress);
                    c23704aq.yMM.setVisibility(0);
                    final C30436c c30436c2 = (C30436c) ChattingSendDataToDeviceUI.this.yKK.get(Op.deviceID);
                    final int i5 = c30436c2.progress;
                    if (i5 >= 100) {
                        i3 = 0;
                    } else {
                        i3 = 500 / (100 - i5);
                    }
                    C7305d.m12301h(new Runnable() {

                        /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$a$1$1 */
                        class C236781 implements Runnable {
                            C236781() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(30774);
                                c23704aq.yMM.mo70164Os(0);
                                c23704aq.yMM.setVisibility(4);
                                c23704aq.yKX.setText(ChattingSendDataToDeviceUI.this.getText(C25738R.string.aoj));
                                c23704aq.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12300z_));
                                c30436c2.cxW = "send_data_sucess";
                                c30436c2.progress = 0;
                                ChattingSendDataToDeviceUI.this.yKK.put(c30436c2.deviceID, c30436c2);
                                C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", c30436c2.deviceID);
                                AppMethodBeat.m2505o(30774);
                            }
                        }

                        /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$a$1$2 */
                        class C236792 implements Runnable {
                            C236792() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(30775);
                                c23704aq.yMM.mo70164Os(0);
                                c23704aq.yMM.setVisibility(4);
                                c23704aq.yKX.setText(ChattingSendDataToDeviceUI.this.getText(C25738R.string.aog));
                                c23704aq.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12302zc));
                                c30436c2.cxW = "send_data_failed";
                                c30436c2.progress = 0;
                                ChattingSendDataToDeviceUI.this.yKK.put(c30436c2.deviceID, c30436c2);
                                C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", c30436c2.deviceID);
                                AppMethodBeat.m2505o(30775);
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(30776);
                            int i = i5 + 1;
                            while (ChattingSendDataToDeviceUI.this.yKG) {
                                if (i >= 100) {
                                    try {
                                        if (c30436c2.cxW.equals("send_data_sucess")) {
                                            ChattingSendDataToDeviceUI.this.runOnUiThread(new C236781());
                                            AppMethodBeat.m2505o(30776);
                                            return;
                                        } else if (c30436c2.cxW.equals("send_data_failed")) {
                                            ChattingSendDataToDeviceUI.this.runOnUiThread(new C236792());
                                            AppMethodBeat.m2505o(30776);
                                            return;
                                        }
                                    } catch (Exception e) {
                                        C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", e);
                                    }
                                } else {
                                    c23704aq.yMM.mo70164Os(i);
                                    c30436c2.progress = i;
                                    i++;
                                    Thread.sleep((long) i3);
                                }
                            }
                            AppMethodBeat.m2505o(30776);
                        }
                    }, "SendDataState_handler").start();
                } else if (c30436c.cxW.equals("send_data_sucess")) {
                    c23704aq.yKX.setText(this.context.getString(C25738R.string.aoj));
                    c23704aq.yKX.setTextColor(this.context.getResources().getColor(C25738R.color.f12300z_));
                    c23704aq.yMM.setVisibility(4);
                } else if (c30436c.cxW.equals("send_data_cancel")) {
                    c23704aq.yKX.setText(this.context.getString(C25738R.string.aoc));
                    c23704aq.yKX.setTextColor(this.context.getResources().getColor(C25738R.color.f12298z8));
                    c23704aq.yMM.setVisibility(4);
                } else if (c30436c.cxW.equals("send_data_failed")) {
                    c23704aq.yKX.setText(this.context.getString(C25738R.string.aog));
                    c23704aq.yKX.setTextColor(this.context.getResources().getColor(C25738R.color.f12302zc));
                    c23704aq.yMM.setVisibility(4);
                }
            }
            C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", Integer.valueOf(i), Op.eoz);
            C32291o.ahp().mo43766a(Op.iconUrl, c23704aq.iqT, this.lyr);
            c23704aq.lBq.setTag(Integer.valueOf(i));
            AppMethodBeat.m2505o(30781);
            return view2;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$3 */
    class C304283 implements OnItemClickListener {
        C304283() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(30764);
            C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", Integer.valueOf(i));
            if (i == adapterView.getAdapter().getCount() - 1) {
                Intent intent = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
                intent.addFlags(67108864);
                intent.putExtra("KFlag", ChattingSendDataToDeviceUI.this.yKD);
                ChattingSendDataToDeviceUI.this.startActivity(intent);
                AppMethodBeat.m2505o(30764);
            } else if (!ChattingSendDataToDeviceUI.this.yGE || i != adapterView.getAdapter().getCount() - 2) {
                if (i >= 0 && i < adapterView.getAdapter().getCount() - 1) {
                    final C40439f c40439f = (C40439f) ChattingSendDataToDeviceUI.this.yKC.get(i);
                    if (C46494g.m87726a(ChattingSendDataToDeviceUI.this.getBaseContext(), c40439f)) {
                        C26006a.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(30763);
                                C46494g.m87728a(ChattingSendDataToDeviceUI.this.getBaseContext(), c40439f.field_packageName, ChattingSendDataToDeviceUI.this.yKN, c40439f.field_appId, c40439f.field_openId, 0, null, null);
                                AppMethodBeat.m2505o(30763);
                            }
                        });
                    } else {
                        C30379h.m48465bQ(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(C25738R.string.aob));
                        c40439f.field_status = 4;
                        C14877am.bYJ().mo56566a(c40439f, new String[0]);
                        ChattingSendDataToDeviceUI.m48535j(ChattingSendDataToDeviceUI.this);
                        AppMethodBeat.m2505o(30764);
                        return;
                    }
                }
                AppMethodBeat.m2505o(30764);
            } else if (ChattingSendDataToDeviceUI.this.filePath == null || ChattingSendDataToDeviceUI.this.eov == null) {
                C30379h.m48465bQ(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(C25738R.string.b6t));
                AppMethodBeat.m2505o(30764);
            } else {
                C44094a.m79368a(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.eov.toLowerCase(), 1);
                AppMethodBeat.m2505o(30764);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$6 */
    class C304316 implements OnClickListener {
        C304316() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(30767);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(30767);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$b */
    public class C30433b {

        /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$b$1 */
        class C304271 implements Runnable {
            C304271() {
            }

            public final void run() {
                AppMethodBeat.m2504i(30783);
                ChattingSendDataToDeviceUI.this.yKt.mo48820bw(ChattingSendDataToDeviceUI.this.yKB);
                if (ChattingSendDataToDeviceUI.this.yKt.getCount() > 0) {
                    ChattingSendDataToDeviceUI.this.yKy.setText(C25738R.string.ajz);
                    ChattingSendDataToDeviceUI.this.yKE = false;
                }
                ChattingSendDataToDeviceUI.this.yKt.notifyDataSetChanged();
                AppMethodBeat.m2505o(30783);
            }
        }

        /* renamed from: n */
        public final boolean mo48834n(C4883b c4883b) {
            AppMethodBeat.m2504i(30784);
            boolean p;
            if (c4883b instanceof C45320eg) {
                p = m48543p(c4883b);
                AppMethodBeat.m2505o(30784);
                return p;
            } else if (c4883b instanceof C37710ek) {
                p = m48542o(c4883b);
                AppMethodBeat.m2505o(30784);
                return p;
            } else {
                AppMethodBeat.m2505o(30784);
                return true;
            }
        }

        /* renamed from: o */
        private boolean m48542o(C4883b c4883b) {
            AppMethodBeat.m2504i(30785);
            C37710ek c37710ek = (C37710ek) c4883b;
            String str = c37710ek.cxU.cxW;
            String str2 = c37710ek.cxU.ceI;
            if (str.equals("send_data_sending")) {
                ChattingSendDataToDeviceUI.m48520a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, c37710ek.cxU.progress);
            } else if (str.equals("send_data_failed")) {
                ChattingSendDataToDeviceUI.m48520a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
            } else if (str.equals("send_data_sucess")) {
                ChattingSendDataToDeviceUI.this.arb(str2);
            }
            AppMethodBeat.m2505o(30785);
            return true;
        }

        /* renamed from: p */
        private boolean m48543p(C4883b c4883b) {
            AppMethodBeat.m2504i(30786);
            List list = ((C45320eg) c4883b).cxJ.cwW;
            List arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                C30436c c30436c = new C30436c();
                c30436c.cws = (String) ((Map) list.get(i2)).get("deviceType");
                c30436c.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                c30436c.eoz = (String) ((Map) list.get(i2)).get("displayName");
                c30436c.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                c30436c.cxR = (String) ((Map) list.get(i2)).get("ability");
                c30436c.yLc = (String) ((Map) list.get(i2)).get("abilityInf");
                if ((ChattingSendDataToDeviceUI.this.cxS && ChattingSendDataToDeviceUI.m48527b(c30436c, ChattingSendDataToDeviceUI.this.lsy)) || (!ChattingSendDataToDeviceUI.this.cxS && ChattingSendDataToDeviceUI.m48526b(c30436c, ChattingSendDataToDeviceUI.this.edW))) {
                    if (ChattingSendDataToDeviceUI.this.yKK.containsKey(c30436c.deviceID) && ((C30436c) ChattingSendDataToDeviceUI.this.yKK.get(c30436c.deviceID)).cxW != null) {
                        c30436c.cxW = ((C30436c) ChattingSendDataToDeviceUI.this.yKK.get(c30436c.deviceID)).cxW;
                        c30436c.progress = ((C30436c) ChattingSendDataToDeviceUI.this.yKK.get(c30436c.deviceID)).progress;
                    }
                    arrayList.add(c30436c);
                }
                i = i2 + 1;
            }
            if (ChattingSendDataToDeviceUI.this.yKB.size() != arrayList.size()) {
                ChattingSendDataToDeviceUI.this.yKB = arrayList;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new C304271());
            }
            AppMethodBeat.m2505o(30786);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$1 */
    class C304341 implements OnItemClickListener {
        C304341() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(30760);
            ChattingSendDataToDeviceUI.this.yKF = true;
            C30436c Op = ChattingSendDataToDeviceUI.this.yKt.mo48819Op(i);
            String str = Op.cws;
            String str2 = Op.deviceID;
            String str3 = Op.cxR;
            try {
                if (ChattingSendDataToDeviceUI.this.yKJ.get(str2) != null) {
                    C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                    C45318dd c45318dd = new C45318dd();
                    c45318dd.cwo.ceI = str2;
                    C4879a.xxA.mo10055m(c45318dd);
                    ChattingSendDataToDeviceUI.m48520a(ChattingSendDataToDeviceUI.this, "send_data_cancel", str2, 0);
                    Op.cxW = "send_data_cancel";
                    ChattingSendDataToDeviceUI.this.yKJ.remove(str2);
                    C23704aq c23704aq = (C23704aq) ((View) ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(i))).getTag();
                    c23704aq.yKX.setText(ChattingSendDataToDeviceUI.this.getText(C25738R.string.aoc));
                    c23704aq.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12298z8));
                    c23704aq.yMM.setVisibility(8);
                    c23704aq.yMM.mo70164Os(0);
                    AppMethodBeat.m2505o(30760);
                    return;
                }
                Op.cxW = "send_data_sending";
                ChattingSendDataToDeviceUI.this.yKK.put(Op.deviceID, Op);
                ChattingSendDataToDeviceUI.this.yKJ.put(str2, view);
                ChattingSendDataToDeviceUI.m48520a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, 1);
                ChattingSendDataToDeviceUI.m48519a(ChattingSendDataToDeviceUI.this, 3);
                C41987ej c41987ej = new C41987ej();
                c41987ej.cxP.ceI = str2;
                c41987ej.cxP.cws = str;
                c41987ej.cxP.data = ChattingSendDataToDeviceUI.this.yKv;
                c41987ej.cxP.cxR = str3;
                if (ChattingSendDataToDeviceUI.this.cxS) {
                    c41987ej.cxP.cwT = ChattingSendDataToDeviceUI.this.lsy;
                    c41987ej.cxP.cxS = ChattingSendDataToDeviceUI.this.cxS;
                } else {
                    c41987ej.cxP.cvx = ChattingSendDataToDeviceUI.this.edW;
                }
                C4879a.xxA.mo10055m(c41987ej);
                if (!c41987ej.cxQ.cxT) {
                    ChattingSendDataToDeviceUI.arc("send_data_failed");
                    C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
                }
                AppMethodBeat.m2505o(30760);
            } catch (Exception e) {
                ChattingSendDataToDeviceUI.arc("send_data_failed");
                C4990ab.m7413e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", e);
                AppMethodBeat.m2505o(30760);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c */
    public class C30436c {
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
        AppMethodBeat.m2503at(this, z);
    }

    public ChattingSendDataToDeviceUI() {
        AppMethodBeat.m2504i(30787);
        AppMethodBeat.m2505o(30787);
    }

    /* renamed from: j */
    static /* synthetic */ void m48535j(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        AppMethodBeat.m2504i(30807);
        chattingSendDataToDeviceUI.dCu();
        AppMethodBeat.m2505o(30807);
    }

    /* JADX WARNING: Missing block: B:121:0x0344, code skipped:
            if (r6 == 62) goto L_0x02e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        String str;
        int i;
        int i2 = 6;
        AppMethodBeat.m2504i(30788);
        super.onCreate(bundle);
        this.cxS = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
        C4990ab.m7416i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.cxS);
        if (!this.cxS) {
            this.edW = getIntent().getExtras().getLong("Retr_Msg_Id");
            if (this.edW != -1) {
                C9638aw.m17190ZK();
                this.kua = C18628c.m29080XO().mo15340jf(this.edW);
                if (!(this.kua == null || this.kua.field_msgId == 0)) {
                    this.yKu = this.kua.getType();
                    this.yFW = C1855t.m3896kH(this.kua.field_talker);
                    this.yKv = this.kua.field_content;
                    if (this.yFW && this.kua.field_isSend == 0) {
                        str = this.kua.field_content;
                        i = this.kua.field_isSend;
                        if (this.yFW && str != null && i == 0) {
                            str = C1829bf.m3763oz(str);
                        }
                        this.yKv = str;
                    }
                    Long aik;
                    C25822e w;
                    if (this.kua.getType() == 49) {
                        this.cJM = C8910b.m16064me(this.yKv);
                        if (this.cJM == null) {
                            C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
                        } else if (this.cJM.type == 3) {
                            this.yKD = 16;
                        } else if (this.cJM.type == 4) {
                            this.yKD = 8;
                        } else if (this.cJM.type == 5) {
                            this.yKD = 32;
                        } else if (this.cJM.type == 6) {
                            aik = C23234a.aik(this.cJM.fgp);
                            if (aik == null) {
                                C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
                            } else {
                                this.yKD = aik.longValue();
                            }
                        } else if (this.cJM.type == 2) {
                            this.yKD = 2;
                            w = C32291o.ahl().mo73124w(this.kua);
                            if (w != null) {
                                this.yKv = w.fDK;
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
                        }
                    } else {
                        if (this.kua.getType() == 3) {
                            w = C32291o.ahl().mo73124w(this.kua);
                            if (w != null) {
                                this.yKv = w.fDK;
                            }
                        } else if (this.kua.getType() == 43) {
                            C26493s uf = C37961o.all().mo21063uf(this.kua.field_imgPath);
                            if (uf != null) {
                                this.yKv = uf.alw();
                            }
                        }
                        aik = C23234a.aik(this.yKu);
                        if (aik == null) {
                            C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
                        } else {
                            this.yKD = aik.longValue();
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", Long.valueOf(this.yKD));
                }
            }
        }
        this.yKH = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
        this.yKF = false;
        setFinishOnTouchOutside(true);
        this.yKB.clear();
        this.yKK.clear();
        this.yKw = (RelativeLayout) findViewById(2131822701);
        C9321dq c9321dq = new C9321dq();
        if (this.cxS) {
            this.lsy = getIntent().getExtras().getString("sns_local_id");
            if (this.lsy != null) {
                c9321dq.cxc.cwT = this.lsy;
                C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", this.lsy);
            }
        } else {
            c9321dq.cxc.cvx = this.edW;
        }
        C4879a.xxA.mo10055m(c9321dq);
        if (c9321dq.cxd.cwB) {
            this.yKz = Boolean.TRUE;
            C4879a.xxA.mo10052c(this.yKO);
            C4879a.xxA.mo10052c(this.yKP);
            this.yKw.setVisibility(0);
            this.voK = (HorizontalListView) findViewById(2131821698);
            this.yKy = (TextView) findViewById(2131822702);
            this.yKy.setText(C25738R.string.ao2);
            this.yKt = new C30425a(this);
            this.voK.setAdapter(this.yKt);
            this.voK.setOnItemClickListener(new C304341());
            dCv();
            if (this.cxS) {
                int i3;
                str = this.lsy;
                if (str != null) {
                    C45333id c45333id = new C45333id();
                    c45333id.cDc.cwT = str;
                    C4879a.xxA.mo10055m(c45333id);
                    i3 = c45333id.cDd.cDe.xfI.wbJ;
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
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf(j);
                    if (jf.field_msgId != 0) {
                        i = jf.getType();
                        String str2 = jf.field_content;
                        if (jf.bAA()) {
                            C8910b me = C8910b.m16064me(str2);
                            if (me == null) {
                                C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
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
            m48541uP(1);
        } else {
            this.yKw.setVisibility(8);
        }
        this.yKx = (RelativeLayout) findViewById(2131822706);
        this.yKr = (HorizontalListView) findViewById(2131822708);
        this.yKs = new C46639b(this);
        this.yKr.setOnItemClickListener(new C304283());
        this.yKr.setAdapter(this.yKs);
        AppMethodBeat.m2505o(30788);
    }

    /* renamed from: uP */
    private void m48541uP(int i) {
        AppMethodBeat.m2504i(30789);
        if (this.cxS) {
            C7060h.pYm.mo8381e(13197, Integer.valueOf(i), Integer.valueOf(this.yKI), "", Integer.valueOf(2), Integer.valueOf(this.yKH));
            AppMethodBeat.m2505o(30789);
            return;
        }
        C7060h.pYm.mo8381e(13197, Integer.valueOf(i), Integer.valueOf(this.yKI), ChattingSendDataToDeviceUI.m48540na(this.edW), Integer.valueOf(1), Integer.valueOf(this.yKH));
        AppMethodBeat.m2505o(30789);
    }

    /* renamed from: na */
    private static String m48540na(long j) {
        AppMethodBeat.m2504i(30790);
        String str = "";
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        if (jf.field_msgId == 0) {
            str = "";
            AppMethodBeat.m2505o(30790);
            return str;
        }
        String str2 = jf.field_content;
        if (jf.getType() == 49) {
            C8910b me = C8910b.m16064me(str2);
            if (me != null && me.type == 6) {
                str = me.fgp;
            }
        }
        AppMethodBeat.m2505o(30790);
        return str;
    }

    public final int getLayoutId() {
        return 2130969121;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(30791);
        super.onConfigurationChanged(configuration);
        C41981do c41981do = new C41981do();
        if (this.cxS) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            c41981do.cwR.cwT = this.lsy;
            c41981do.cwR.cwU = string;
            c41981do.cwR.cwV = i;
        } else {
            c41981do.cwR.cvx = this.edW;
        }
        C4879a.xxA.mo10055m(c41981do);
        if (c41981do.cwS.cwB && this.yKB.size() > 0) {
            C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", Integer.valueOf(this.yKB.size()));
            this.yKt.mo48820bw(this.yKB);
            if (this.yKt.getCount() > 0) {
                this.yKy.setText(C25738R.string.ajz);
                this.yKE = false;
            }
            this.yKt.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(30791);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dCu() {
        AppMethodBeat.m2504i(30792);
        if (this.yKs == null || this.yKD == 0) {
            String str = "MicroMsg.ChattingSendDataToDeviceUI";
            String str2 = "mAppInfoAdapter is null %s, contentFlag %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.yKs == null);
            objArr[1] = Long.valueOf(this.yKD);
            C4990ab.m7413e(str, str2, objArr);
            if (this.yKx != null) {
                this.yKx.setVisibility(8);
            }
            AppMethodBeat.m2505o(30792);
            return;
        }
        this.yKC = C46494g.m87735b((Context) this, this.yKD, false);
        if (!(C46494g.m87754o(this, this.yKD) || this.yKx == null)) {
            this.yKx.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        if (this.yKC != null && this.yKC.size() > 0) {
            final List mb = C14877am.dhO().mo56576mb(this.yKD);
            if (mb != null && mb.size() > 0) {
                Collections.sort(this.yKC, new Comparator<C40439f>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        AppMethodBeat.m2504i(30765);
                        C40439f c40439f = (C40439f) obj2;
                        int indexOf = mb.indexOf(c40439f.field_appId) - mb.indexOf(((C40439f) obj).field_appId);
                        AppMethodBeat.m2505o(30765);
                        return indexOf;
                    }
                });
            }
            for (C40439f c40439f : this.yKC) {
                C40830z c40830z = new C40830z();
                c40830z.appId = c40439f.field_appId;
                c40830z.eoz = c40439f.field_appName;
                c40830z.iconUrl = c40439f.field_appIconUrl;
                arrayList.add(c40830z);
            }
        }
        if (this.yKN == null) {
            IMediaObject iMediaObject = null;
            C25822e w;
            int lastIndexOf;
            switch (this.kua.getType()) {
                case 1:
                    iMediaObject = new WXTextObject(this.kua.field_content);
                case 3:
                    iMediaObject = new WXImageObject();
                    w = C32291o.ahl().mo73124w(this.kua);
                    if (w != null) {
                        iMediaObject.imagePath = C32291o.ahl().mo73119sj(w.fDz);
                        if (C5046bo.isNullOrNil(iMediaObject.imagePath)) {
                            iMediaObject.imagePath = C32291o.ahl().mo73119sj(w.fDB);
                        }
                        if (!C5046bo.isNullOrNil(iMediaObject.imagePath)) {
                            this.filePath = iMediaObject.imagePath;
                            lastIndexOf = iMediaObject.imagePath.lastIndexOf(".");
                            if (lastIndexOf >= 0 && lastIndexOf < iMediaObject.imagePath.length() - 1) {
                                this.eov = iMediaObject.imagePath.substring(lastIndexOf + 1);
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", iMediaObject.imagePath);
                case 43:
                    iMediaObject = new WXVideoObject();
                    C37961o.all();
                    String uh = C9720t.m17303uh(this.kua.field_imgPath);
                    if (uh != null) {
                        iMediaObject.videoUrl = uh;
                        this.filePath = uh;
                        lastIndexOf = uh.lastIndexOf(".");
                        if (lastIndexOf >= 0 && lastIndexOf < uh.length() - 1) {
                            this.eov = uh.substring(lastIndexOf + 1);
                        }
                    }
                case 48:
                    C9638aw.m17190ZK();
                    C5136b Ro = C18628c.m29080XO().mo15261Ro(this.kua.field_content);
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
                            C30065b aiE = C14877am.aUq().aiE(this.cJM.csD);
                            if (aiE != null) {
                                C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", aiE.field_fileFullPath);
                                iMediaObject = new WXFileObject(aiE.field_fileFullPath);
                                this.filePath = aiE.field_fileFullPath;
                                this.eov = this.cJM.fgp;
                            } else {
                                C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
                            }
                            if (C35800q.aiR(this.filePath) != null) {
                                C30379h.m48465bQ(this, getString(C25738R.string.aoa));
                                finish();
                                break;
                            }
                        } else if (this.cJM.type == 2) {
                            iMediaObject = new WXImageObject();
                            w = C32291o.ahl().mo73124w(this.kua);
                            if (w != null) {
                                iMediaObject.imagePath = C32291o.ahl().mo73119sj(w.fDz);
                                if (C5046bo.isNullOrNil(iMediaObject.imagePath)) {
                                    iMediaObject.imagePath = C32291o.ahl().mo73119sj(w.fDB);
                                }
                            }
                            this.filePath = iMediaObject.imagePath;
                            this.eov = this.cJM.fgp;
                            C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", iMediaObject.imagePath);
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
        this.yKs.mo74845bw(arrayList);
        this.yKs.notifyDataSetChanged();
        AppMethodBeat.m2505o(30792);
    }

    private void dCv() {
        AppMethodBeat.m2504i(30793);
        C41981do c41981do = new C41981do();
        if (this.cxS) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            c41981do.cwR.cwT = this.lsy;
            c41981do.cwR.cwU = string;
            c41981do.cwR.cwV = i;
        } else {
            c41981do.cwR.cvx = this.edW;
        }
        C4879a.xxA.mo10055m(c41981do);
        if (c41981do.cwS.cwB) {
            List list = c41981do.cwS.cwW;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                C30436c c30436c = new C30436c();
                c30436c.cws = (String) ((Map) list.get(i2)).get("deviceType");
                c30436c.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                c30436c.eoz = (String) ((Map) list.get(i2)).get("displayName");
                c30436c.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                c30436c.cxR = (String) ((Map) list.get(i2)).get("ability");
                c30436c.yLc = (String) ((Map) list.get(i2)).get("abilityInf");
                if (this.cxS && ChattingSendDataToDeviceUI.m48523a(c30436c, this.lsy)) {
                    this.yKB.add(c30436c);
                } else if (!this.cxS && ChattingSendDataToDeviceUI.m48522a(c30436c, this.edW)) {
                    this.yKB.add(c30436c);
                }
            }
            if (this.yKB.size() > 0) {
                C4990ab.m7410d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
                this.yKt.mo48820bw(this.yKB);
                if (this.yKt.getCount() > 0) {
                    this.yKy.setText(C25738R.string.ajz);
                    this.yKE = false;
                }
                this.yKt.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(30793);
    }

    /* renamed from: a */
    private static boolean m48524a(String str, C30436c c30436c) {
        boolean z = false;
        AppMethodBeat.m2504i(30794);
        String str2 = c30436c.cxR;
        String str3 = c30436c.yLc;
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
                C4990ab.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", e, str3, new Object[0]);
            }
        }
        AppMethodBeat.m2505o(30794);
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
    /* renamed from: a */
    private static boolean m48523a(C30436c c30436c, String str) {
        boolean z = true;
        AppMethodBeat.m2504i(30795);
        if (str == null) {
            AppMethodBeat.m2505o(30795);
            return false;
        }
        C45333id c45333id = new C45333id();
        c45333id.cDc.cwT = str;
        C4879a.xxA.mo10055m(c45333id);
        TimeLineObject timeLineObject = c45333id.cDd.cDe;
        int i = timeLineObject.xfI.wbJ;
        C4990ab.m7417i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", Integer.valueOf(i));
        String str2 = c30436c.cxR;
        if (str2 == null) {
            C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
            AppMethodBeat.m2505o(30795);
            return false;
        }
        if (i != 1) {
            if (i != 4) {
                if (i != 15) {
                    if (i == 3) {
                        z = ChattingSendDataToDeviceUI.m48524a(timeLineObject.xfI.Url, c30436c);
                    }
                    z = false;
                }
            }
        }
        AppMethodBeat.m2505o(30795);
        return z;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(30796);
        if (this.yKJ.size() > 0) {
            C5652a c5652a = new C5652a(this);
            c5652a.mo11450PZ(C25738R.string.aod);
            c5652a.mo11453Qc(C25738R.string.aof).mo11457a(new C304245());
            c5652a.mo11454Qd(C25738R.string.aoe).mo11476b(new C304316());
            c5652a.aMb().show();
            AppMethodBeat.m2505o(30796);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(30796);
    }

    public final void arb(String str) {
        AppMethodBeat.m2504i(30797);
        try {
            int i;
            final C23704aq c23704aq = (C23704aq) ((View) this.yKL.get(Integer.valueOf(((Integer) this.yKM.get(str)).intValue()))).getTag();
            C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", Integer.valueOf(c23704aq.yMM.getProgress()), str);
            final C30436c c30436c = (C30436c) this.yKK.get(str);
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(30768);
                    c23704aq.yMM.setVisibility(0);
                    c23704aq.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12300z_));
                    c23704aq.yKX.setText(ChattingSendDataToDeviceUI.this.getText(C25738R.string.aol));
                    c30436c.cxW = "send_data_sending";
                    AppMethodBeat.m2505o(30768);
                }
            });
            final int abs = Math.abs(c23704aq.yMM.getProgress());
            c30436c.progress = abs;
            if (abs >= 100) {
                i = 0;
            } else {
                i = 500 / (100 - abs);
            }
            C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", Integer.valueOf(i));
            final String str2 = str;
            C7305d.m12301h(new Runnable() {

                /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$8$1 */
                class C236771 implements Runnable {
                    C236771() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(30769);
                        c23704aq.yMM.mo70164Os(0);
                        ChattingSendDataToDeviceUI.this.yKJ.remove(str2);
                        c23704aq.yMM.setVisibility(4);
                        c23704aq.yKX.setText(ChattingSendDataToDeviceUI.this.getText(C25738R.string.aoj));
                        c23704aq.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12300z_));
                        c30436c.cxW = "send_data_sucess";
                        c30436c.progress = 0;
                        ChattingSendDataToDeviceUI.m48519a(ChattingSendDataToDeviceUI.this, 4);
                        AppMethodBeat.m2505o(30769);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(30770);
                    int i = abs + 1;
                    while (true) {
                        if (i >= 100) {
                            try {
                                ChattingSendDataToDeviceUI.this.runOnUiThread(new C236771());
                                break;
                            } catch (Exception e) {
                                C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", e);
                            }
                        } else {
                            c23704aq.yMM.mo70164Os(i);
                            i++;
                            Thread.sleep((long) i);
                        }
                    }
                    AppMethodBeat.m2505o(30770);
                }
            }, "progressSuccess_handler").start();
            this.yKK.put(c30436c.deviceID, c30436c);
            AppMethodBeat.m2505o(30797);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", e);
            AppMethodBeat.m2505o(30797);
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
    /* renamed from: a */
    private static boolean m48522a(C30436c c30436c, long j) {
        boolean z = true;
        AppMethodBeat.m2504i(30798);
        if (j == -1) {
            AppMethodBeat.m2505o(30798);
            return false;
        }
        String str = c30436c.cxR;
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        if (jf.field_msgId == 0 || str == null) {
            AppMethodBeat.m2505o(30798);
            return false;
        }
        int type = jf.getType();
        String str2 = jf.field_content;
        if (jf.bAA()) {
            C8910b me = C8910b.m16064me(str2);
            if (me == null) {
                C4990ab.m7412e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                AppMethodBeat.m2505o(30798);
                return false;
            } else if (me.type != 3) {
                if (me.type == 4) {
                    z = false;
                } else if (me.type != 6) {
                    if (me.type == 5) {
                        z = ChattingSendDataToDeviceUI.m48524a(me.url, c30436c);
                    } else {
                        if (me.type == 2) {
                        }
                    }
                }
            }
        } else {
            z = type != 3 ? false : false;
        }
        AppMethodBeat.m2505o(30798);
        return z;
    }

    public void onResume() {
        AppMethodBeat.m2504i(30799);
        super.onResume();
        dCu();
        if (this.yKz.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) this.voK.getLayoutParams();
            int i = layoutParams.height;
            float dm = C1338a.m2860dm(this);
            if (dm == 1.125f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(C25738R.dimen.f9958le);
            } else if (dm == 1.375f || dm == 1.25f || dm == 1.625f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
            }
            this.voK.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(30799);
    }

    public void onPause() {
        AppMethodBeat.m2504i(30800);
        super.onPause();
        AppMethodBeat.m2505o(30800);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(30801);
        super.onActivityResult(i, i2, intent);
        C44094a.m79367a(this, i, i2, intent, true, C25738R.string.b6t, C25738R.string.b6u, 1);
        AppMethodBeat.m2505o(30801);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30802);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
        this.yKG = false;
        if (this.yKz.booleanValue()) {
            if (!this.yKF) {
                m48541uP(2);
            }
            C4879a.xxA.mo10053d(this.yKO);
            C4879a.xxA.mo10053d(this.yKP);
            C26129ew c26129ew = new C26129ew();
            C4879a.xxA.mo10055m(c26129ew);
            if (c26129ew.cyq.cxT) {
                C4990ab.m7416i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
            }
        }
        AppMethodBeat.m2505o(30802);
    }

    public final C30433b dCw() {
        AppMethodBeat.m2504i(30803);
        if (this.yKA == null) {
            this.yKA = new C30433b();
        }
        C30433b c30433b = this.yKA;
        AppMethodBeat.m2505o(30803);
        return c30433b;
    }

    /* renamed from: a */
    static /* synthetic */ void m48520a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, final String str, final String str2, final int i) {
        AppMethodBeat.m2504i(30804);
        C4990ab.m7411d("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data State:%s progress: %d", str, Integer.valueOf(i));
        chattingSendDataToDeviceUI.runOnUiThread(new Runnable() {
            TextView yKX;

            public final void run() {
                AppMethodBeat.m2504i(30771);
                try {
                    C30436c c30436c = (C30436c) ChattingSendDataToDeviceUI.this.yKK.get(str2);
                    c30436c.cxW = str;
                    if (i > c30436c.progress) {
                        c30436c.progress = i;
                    }
                    View view = (View) ChattingSendDataToDeviceUI.this.yKL.get(Integer.valueOf(((Integer) ChattingSendDataToDeviceUI.this.yKM.get(str2)).intValue()));
                    C23704aq c23704aq = (C23704aq) view.getTag();
                    if (c23704aq == null) {
                        C4990ab.m7420w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
                        AppMethodBeat.m2505o(30771);
                        return;
                    }
                    this.yKX = c23704aq.yKX;
                    this.yKX.setVisibility(0);
                    if (str.equals("send_data_failed")) {
                        ChattingSendDataToDeviceUI.m48519a(ChattingSendDataToDeviceUI.this, 5);
                        this.yKX.setText(ChattingSendDataToDeviceUI.this.getString(C25738R.string.aog));
                        ChattingSendDataToDeviceUI.this.yKJ.remove(str2);
                        this.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12302zc));
                        ChattingSendDataToDeviceUI.m48521a(false, 0, view);
                    } else if (str.equals("send_data_sending")) {
                        this.yKX.setText(ChattingSendDataToDeviceUI.this.getString(C25738R.string.aol));
                        this.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12300z_));
                        ChattingSendDataToDeviceUI.m48521a(true, i, view);
                    } else if (str.equals("send_data_cancel")) {
                        ChattingSendDataToDeviceUI.m48519a(ChattingSendDataToDeviceUI.this, 6);
                        this.yKX.setText(ChattingSendDataToDeviceUI.this.getString(C25738R.string.aoc));
                        this.yKX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(C25738R.color.f12298z8));
                        ChattingSendDataToDeviceUI.m48521a(true, 0, view);
                    }
                    ChattingSendDataToDeviceUI.this.yKK.put(c30436c.deviceID, c30436c);
                    AppMethodBeat.m2505o(30771);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", e.getMessage());
                    AppMethodBeat.m2505o(30771);
                }
            }
        });
        AppMethodBeat.m2505o(30804);
    }

    static /* synthetic */ void arc(String str) {
        AppMethodBeat.m2504i(30806);
        C37710ek c37710ek = new C37710ek();
        c37710ek.cxU.cxW = str;
        C4879a.xxA.mo10055m(c37710ek);
        AppMethodBeat.m2505o(30806);
    }

    /* renamed from: a */
    static /* synthetic */ void m48521a(boolean z, int i, View view) {
        AppMethodBeat.m2504i(30808);
        try {
            C23704aq c23704aq = (C23704aq) view.getTag();
            if (c23704aq == null) {
                AppMethodBeat.m2505o(30808);
                return;
            }
            if (z) {
                c23704aq.yMM.setVisibility(0);
                if (i > c23704aq.yMM.getProgress()) {
                    c23704aq.yMM.mo70164Os(i);
                    AppMethodBeat.m2505o(30808);
                    return;
                }
            }
            c23704aq.yMM.setVisibility(4);
            c23704aq.yMM.mo70164Os(0);
            AppMethodBeat.m2505o(30808);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress exception %s", e);
            AppMethodBeat.m2505o(30808);
        }
    }
}
