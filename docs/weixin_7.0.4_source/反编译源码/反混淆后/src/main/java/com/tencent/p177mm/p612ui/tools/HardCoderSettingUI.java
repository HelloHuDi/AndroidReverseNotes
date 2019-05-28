package com.tencent.p177mm.p612ui.tools;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.hardcoder.C34331a;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.sql.Time;
import java.text.DateFormat;

/* renamed from: com.tencent.mm.ui.tools.HardCoderSettingUI */
public class HardCoderSettingUI extends MMActivity {
    private boolean qmI = false;
    private final OnTimeSetListener qmJ = new C307425();
    private EditText zCA;
    private EditText zCB;
    private Spinner zCC;
    private Spinner zCD;
    private CheckBox zCE;
    private CheckBox zCF;
    private EditText zCG;
    private EditText zCH;
    private EditText zCI;
    private Spinner zCJ;
    private Spinner zCK;
    private CheckBox zCL;
    private CheckBox zCM;
    private EditText zCN;
    private EditText zCO;
    private EditText zCP;
    private Spinner zCQ;
    private Spinner zCR;
    private CheckBox zCS;
    private CheckBox zCT;
    private EditText zCU;
    private EditText zCV;
    private EditText zCW;
    private Spinner zCX;
    private Spinner zCY;
    private CheckBox zCZ;
    private CheckBox zCk;
    private EditText zCl;
    private CheckBox zCm;
    private CheckBox zCn;
    private CheckBox zCo;
    private TextView zCp;
    private TextView zCq;
    private CheckBox zCr;
    private EditText zCs;
    private EditText zCt;
    private EditText zCu;
    private Spinner zCv;
    private Spinner zCw;
    private CheckBox zCx;
    private CheckBox zCy;
    private EditText zCz;
    private EditText zDA;
    private EditText zDB;
    private EditText zDC;
    private Spinner zDD;
    private Spinner zDE;
    private CheckBox zDF;
    private CheckBox zDG;
    private EditText zDH;
    private EditText zDI;
    private EditText zDJ;
    private Spinner zDK;
    private Spinner zDL;
    private CheckBox zDM;
    private CheckBox zDN;
    private EditText zDO;
    private EditText zDP;
    private EditText zDQ;
    private Spinner zDR;
    private Spinner zDS;
    private CheckBox zDT;
    private CheckBox zDU;
    private EditText zDV;
    private EditText zDW;
    private EditText zDX;
    private Spinner zDY;
    private Spinner zDZ;
    private CheckBox zDa;
    private EditText zDb;
    private EditText zDc;
    private EditText zDd;
    private Spinner zDe;
    private Spinner zDf;
    private CheckBox zDg;
    private CheckBox zDh;
    private EditText zDi;
    private EditText zDj;
    private EditText zDk;
    private Spinner zDl;
    private Spinner zDm;
    private CheckBox zDn;
    private EditText zDo;
    private CheckBox zDp;
    private EditText zDq;
    private EditText zDr;
    private EditText zDs;
    private EditText zDt;
    private EditText zDu;
    private EditText zDv;
    private Spinner zDw;
    private Spinner zDx;
    private CheckBox zDy;
    private CheckBox zDz;
    private Spinner zEA;
    private Spinner zEB;
    private CheckBox zEC;
    private CheckBox zED;
    private EditText zEE;
    private EditText zEF;
    private EditText zEG;
    private Spinner zEH;
    private Spinner zEI;
    private CheckBox zEJ;
    private CheckBox zEK;
    private EditText zEL;
    private EditText zEM;
    private EditText zEN;
    private Spinner zEO;
    private Spinner zEP;
    private CheckBox zEQ;
    private CheckBox zEa;
    private CheckBox zEb;
    private EditText zEc;
    private EditText zEd;
    private EditText zEe;
    private Spinner zEf;
    private Spinner zEg;
    private CheckBox zEh;
    private CheckBox zEi;
    private EditText zEj;
    private EditText zEk;
    private EditText zEl;
    private Spinner zEm;
    private Spinner zEn;
    private CheckBox zEo;
    private CheckBox zEp;
    private EditText zEq;
    private EditText zEr;
    private EditText zEs;
    private Spinner zEt;
    private Spinner zEu;
    private CheckBox zEv;
    private CheckBox zEw;
    private EditText zEx;
    private EditText zEy;
    private EditText zEz;

    /* renamed from: com.tencent.mm.ui.tools.HardCoderSettingUI$1 */
    class C240271 implements OnMenuItemClickListener {
        C240271() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34870);
            HardCoderSettingUI.this.finish();
            AppMethodBeat.m2505o(34870);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.HardCoderSettingUI$3 */
    class C240283 implements OnClickListener {
        C240283() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34872);
            HardCoderSettingUI.this.qmI = false;
            HardCoderSettingUI.this.showDialog(1);
            AppMethodBeat.m2505o(34872);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.HardCoderSettingUI$2 */
    class C307402 implements OnClickListener {
        C307402() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34871);
            HardCoderSettingUI.this.qmI = true;
            HardCoderSettingUI.this.showDialog(1);
            AppMethodBeat.m2505o(34871);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.HardCoderSettingUI$4 */
    class C307414 implements OnClickListener {
        C307414() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34873);
            boolean isChecked = HardCoderSettingUI.this.zCk.isChecked();
            HardCoderSettingUI.this.zCr.setChecked(isChecked);
            HardCoderSettingUI.this.zDz.setChecked(isChecked);
            HardCoderSettingUI.this.zCy.setChecked(isChecked);
            HardCoderSettingUI.this.zCF.setChecked(isChecked);
            HardCoderSettingUI.this.zCM.setChecked(isChecked);
            HardCoderSettingUI.this.zCT.setChecked(isChecked);
            HardCoderSettingUI.this.zDa.setChecked(isChecked);
            HardCoderSettingUI.this.zDh.setChecked(isChecked);
            HardCoderSettingUI.this.zDp.setChecked(isChecked);
            HardCoderSettingUI.this.zDG.setChecked(isChecked);
            HardCoderSettingUI.this.zDN.setChecked(isChecked);
            HardCoderSettingUI.this.zDU.setChecked(isChecked);
            HardCoderSettingUI.this.zEb.setChecked(isChecked);
            HardCoderSettingUI.this.zEi.setChecked(isChecked);
            HardCoderSettingUI.this.zEp.setChecked(isChecked);
            HardCoderSettingUI.this.zEw.setChecked(isChecked);
            HardCoderSettingUI.this.zED.setChecked(isChecked);
            AppMethodBeat.m2505o(34873);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.HardCoderSettingUI$5 */
    class C307425 implements OnTimeSetListener {
        C307425() {
        }

        public final void onTimeSet(TimePicker timePicker, int i, int i2) {
            AppMethodBeat.m2504i(34874);
            if (HardCoderSettingUI.this.qmI) {
                WXHardCoderJNI.hcBeginTimeHour = i;
                WXHardCoderJNI.hcBeginTimeMin = i2;
                HardCoderSettingUI.this.zCp.setText(HardCoderSettingUI.m80223h(HardCoderSettingUI.this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
                AppMethodBeat.m2505o(34874);
                return;
            }
            WXHardCoderJNI.hcEndTimeHour = i;
            WXHardCoderJNI.hcEndTimeMin = i2;
            HardCoderSettingUI.this.zCq.setText(HardCoderSettingUI.m80223h(HardCoderSettingUI.this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
            AppMethodBeat.m2505o(34874);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public HardCoderSettingUI() {
        AppMethodBeat.m2504i(34875);
        AppMethodBeat.m2505o(34875);
    }

    /* renamed from: h */
    static /* synthetic */ String m80223h(Context context, int i, int i2) {
        AppMethodBeat.m2504i(34881);
        String c = HardCoderSettingUI.m80217c(context, i, i2);
        AppMethodBeat.m2505o(34881);
        return c;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34876);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.e7f);
        setBackBtn(new C240271());
        SharedPreferences sharedPreferences = this.mController.ylL.getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0);
        if (!sharedPreferences.contains(WXHardCoderJNI.KEY_HC_ENABLE)) {
            HardCoderSettingUI.m80213a(sharedPreferences.edit().putBoolean(WXHardCoderJNI.KEY_HC_ENABLE, true));
        }
        this.zCm = (CheckBox) findViewById(2131824705);
        this.zCm.setChecked(WXHardCoderJNI.getDebug());
        this.zCk = (CheckBox) findViewById(2131824704);
        this.zCk.setChecked(WXHardCoderJNI.getEnable());
        this.zCl = (EditText) findViewById(2131824707);
        this.zCl.setText(WXHardCoderJNI.hcRetryInterval);
        this.zCn = (CheckBox) findViewById(2131824706);
        this.zCo = (CheckBox) findViewById(2131824708);
        this.zCo.setChecked(WXHardCoderJNI.hcTimeLimit);
        this.zCp = (TextView) findViewById(2131824709);
        this.zCq = (TextView) findViewById(2131824710);
        this.zCp.setText(HardCoderSettingUI.m80217c(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
        this.zCq.setText(HardCoderSettingUI.m80217c(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
        this.zCp.setOnClickListener(new C307402());
        this.zCq.setOnClickListener(new C240283());
        this.zCr = (CheckBox) findViewById(2131824711);
        this.zCr.setChecked(WXHardCoderJNI.hcBootEnable);
        this.zCs = (EditText) findViewById(2131824713);
        this.zCs.setText(WXHardCoderJNI.hcBootDelay);
        this.zCt = (EditText) findViewById(2131824712);
        this.zCt.setText(WXHardCoderJNI.hcBootTimeout);
        this.zCt.setSelection(this.zCt.getText().length());
        this.zCu = (EditText) findViewById(2131824714);
        this.zCu.setText(WXHardCoderJNI.hcBootAction);
        this.zCv = (Spinner) findViewById(2131824715);
        this.zCv.setSelection(WXHardCoderJNI.hcBootCPU);
        this.zCw = (Spinner) findViewById(2131824716);
        this.zCw.setSelection(WXHardCoderJNI.hcBootIO);
        this.zCx = (CheckBox) findViewById(2131824717);
        this.zCx.setChecked(WXHardCoderJNI.hcBootThr);
        this.zCy = (CheckBox) findViewById(2131824725);
        this.zCy.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
        this.zCz = (EditText) findViewById(2131824727);
        this.zCz.setText(WXHardCoderJNI.hcEnterChattingDelay);
        this.zCA = (EditText) findViewById(2131824726);
        this.zCA.setText(WXHardCoderJNI.hcEnterChattingTimeout);
        this.zCA.setSelection(this.zCA.getText().length());
        this.zCB = (EditText) findViewById(2131824728);
        this.zCB.setText(WXHardCoderJNI.hcEnterChattingAction);
        this.zCC = (Spinner) findViewById(2131824729);
        this.zCC.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
        this.zCD = (Spinner) findViewById(2131824730);
        this.zCD.setSelection(WXHardCoderJNI.hcEnterChattingIO);
        this.zCE = (CheckBox) findViewById(2131824731);
        this.zCE.setChecked(WXHardCoderJNI.hcEnterChattingThr);
        this.zCF = (CheckBox) findViewById(2131824732);
        this.zCF.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
        this.zCG = (EditText) findViewById(2131824734);
        this.zCG.setText(WXHardCoderJNI.hcQuitChattingDelay);
        this.zCH = (EditText) findViewById(2131824733);
        this.zCH.setText(WXHardCoderJNI.hcQuitChattingTimeout);
        this.zCH.setSelection(this.zCH.getText().length());
        this.zCI = (EditText) findViewById(2131824735);
        this.zCI.setText(WXHardCoderJNI.hcQuitChattingAction);
        this.zCJ = (Spinner) findViewById(2131824736);
        this.zCJ.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
        this.zCK = (Spinner) findViewById(2131824737);
        this.zCK.setSelection(WXHardCoderJNI.hcQuitChattingIO);
        this.zCL = (CheckBox) findViewById(2131824738);
        this.zCL.setChecked(WXHardCoderJNI.hcQuitChattingThr);
        this.zCM = (CheckBox) findViewById(2131824746);
        this.zCM.setChecked(WXHardCoderJNI.hcSendMsgEnable);
        this.zCN = (EditText) findViewById(2131824748);
        this.zCN.setText(WXHardCoderJNI.hcSendMsgDelay);
        this.zCO = (EditText) findViewById(2131824747);
        this.zCO.setText(WXHardCoderJNI.hcSendMsgTimeout);
        this.zCO.setSelection(this.zCO.getText().length());
        this.zCP = (EditText) findViewById(2131824749);
        this.zCP.setText(WXHardCoderJNI.hcSendMsgAction);
        this.zCQ = (Spinner) findViewById(2131824750);
        this.zCQ.setSelection(WXHardCoderJNI.hcSendMsgCPU);
        this.zCR = (Spinner) findViewById(2131824751);
        this.zCR.setSelection(WXHardCoderJNI.hcSendMsgIO);
        this.zCS = (CheckBox) findViewById(2131824752);
        this.zCS.setChecked(WXHardCoderJNI.hcSendMsgThr);
        this.zCT = (CheckBox) findViewById(2131824739);
        this.zCT.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
        this.zCU = (EditText) findViewById(2131824741);
        this.zCU.setText(WXHardCoderJNI.hcSendPicMsgDelay);
        this.zCV = (EditText) findViewById(2131824740);
        this.zCV.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
        this.zCV.setSelection(this.zCV.getText().length());
        this.zCW = (EditText) findViewById(2131824742);
        this.zCW.setText(WXHardCoderJNI.hcSendPicMsgAction);
        this.zCX = (Spinner) findViewById(2131824743);
        this.zCX.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
        this.zCY = (Spinner) findViewById(2131824744);
        this.zCY.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
        this.zCZ = (CheckBox) findViewById(2131824745);
        this.zCZ.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
        this.zDa = (CheckBox) findViewById(2131824753);
        this.zDa.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
        this.zDb = (EditText) findViewById(2131824755);
        this.zDb.setText(WXHardCoderJNI.hcReceiveMsgDelay);
        this.zDc = (EditText) findViewById(2131824754);
        this.zDc.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
        this.zDc.setSelection(this.zDc.getText().length());
        this.zDd = (EditText) findViewById(2131824756);
        this.zDd.setText(WXHardCoderJNI.hcReceiveMsgAction);
        this.zDe = (Spinner) findViewById(2131824757);
        this.zDe.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
        this.zDf = (Spinner) findViewById(2131824758);
        this.zDf.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
        this.zDg = (CheckBox) findViewById(2131824759);
        this.zDg.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
        this.zDh = (CheckBox) findViewById(2131824760);
        this.zDh.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
        this.zDi = (EditText) findViewById(2131824763);
        this.zDi.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
        this.zDj = (EditText) findViewById(2131824762);
        this.zDj.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
        this.zDj.setSelection(this.zDj.getText().length());
        this.zDk = (EditText) findViewById(2131824764);
        this.zDk.setText(WXHardCoderJNI.hcUpdateChatroomAction);
        this.zDl = (Spinner) findViewById(2131824765);
        this.zDl.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
        this.zDm = (Spinner) findViewById(2131824766);
        this.zDm.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
        this.zDn = (CheckBox) findViewById(2131824767);
        this.zDn.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
        this.zDo = (EditText) findViewById(2131824761);
        this.zDo.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
        this.zDp = (CheckBox) findViewById(2131824768);
        this.zDp.setChecked(WXHardCoderJNI.hcDBEnable);
        this.zDq = (EditText) findViewById(2131824770);
        this.zDq.setText(WXHardCoderJNI.hcDBDelayQuery);
        this.zDr = (EditText) findViewById(2131824773);
        this.zDr.setText(WXHardCoderJNI.hcDBDelayWrite);
        this.zDs = (EditText) findViewById(2131824769);
        this.zDs.setText(WXHardCoderJNI.hcDBTimeout);
        this.zDt = (EditText) findViewById(2131824772);
        this.zDt.setText(WXHardCoderJNI.hcDBTimeoutBusy);
        this.zDu = (EditText) findViewById(2131824771);
        this.zDu.setText(WXHardCoderJNI.hcDBActionQuery);
        this.zDv = (EditText) findViewById(2131824774);
        this.zDv.setText(WXHardCoderJNI.hcDBActionWrite);
        this.zDw = (Spinner) findViewById(2131824775);
        this.zDw.setSelection(WXHardCoderJNI.hcDBCPU);
        this.zDx = (Spinner) findViewById(2131824776);
        this.zDx.setSelection(WXHardCoderJNI.hcDBIO);
        this.zDy = (CheckBox) findViewById(2131824777);
        this.zDy.setChecked(WXHardCoderJNI.hcDBThr);
        this.zDz = (CheckBox) findViewById(2131824718);
        this.zDz.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
        this.zDA = (EditText) findViewById(2131824720);
        this.zDA.setText(WXHardCoderJNI.hcEncodeVideoDelay);
        this.zDB = (EditText) findViewById(2131824719);
        this.zDB.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
        this.zDC = (EditText) findViewById(2131824721);
        this.zDC.setText(WXHardCoderJNI.hcEncodeVideoAction);
        this.zDD = (Spinner) findViewById(2131824722);
        this.zDD.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
        this.zDE = (Spinner) findViewById(2131824723);
        this.zDE.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
        this.zDF = (CheckBox) findViewById(2131824724);
        this.zDF.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
        this.zDG = (CheckBox) findViewById(2131824778);
        this.zDG.setChecked(WXHardCoderJNI.hcDecodePicEnable);
        this.zDH = (EditText) findViewById(2131824780);
        this.zDH.setText(WXHardCoderJNI.hcDecodePicDelay);
        this.zDI = (EditText) findViewById(2131824779);
        this.zDI.setText(WXHardCoderJNI.hcDecodePicTimeout);
        this.zDJ = (EditText) findViewById(2131824781);
        this.zDJ.setText(WXHardCoderJNI.hcDecodePicAction);
        this.zDK = (Spinner) findViewById(2131824782);
        this.zDK.setSelection(WXHardCoderJNI.hcDecodePicCPU);
        this.zDL = (Spinner) findViewById(2131824783);
        this.zDL.setSelection(WXHardCoderJNI.hcDecodePicIO);
        this.zDM = (CheckBox) findViewById(2131824784);
        this.zDM.setChecked(WXHardCoderJNI.hcDecodePicThr);
        this.zDN = (CheckBox) findViewById(2131824785);
        this.zDN.setChecked(WXHardCoderJNI.hcGifEnable);
        this.zDO = (EditText) findViewById(2131824787);
        this.zDO.setText(WXHardCoderJNI.hcGifDelay);
        this.zDP = (EditText) findViewById(2131824786);
        this.zDP.setText(WXHardCoderJNI.hcGifTimeout);
        this.zDQ = (EditText) findViewById(2131824788);
        this.zDQ.setText(WXHardCoderJNI.hcGifAction);
        this.zDR = (Spinner) findViewById(2131824789);
        this.zDR.setSelection(WXHardCoderJNI.hcGifCPU);
        this.zDS = (Spinner) findViewById(2131824790);
        this.zDS.setSelection(WXHardCoderJNI.hcGifIO);
        this.zDT = (CheckBox) findViewById(2131824791);
        this.zDT.setChecked(WXHardCoderJNI.hcGifThr);
        this.zDU = (CheckBox) findViewById(2131824792);
        this.zDU.setChecked(WXHardCoderJNI.hcGifFrameEnable);
        this.zDV = (EditText) findViewById(2131824794);
        this.zDV.setText(WXHardCoderJNI.hcGifFrameDelay);
        this.zDW = (EditText) findViewById(2131824793);
        this.zDW.setText(WXHardCoderJNI.hcGifFrameTimeout);
        this.zDX = (EditText) findViewById(2131824795);
        this.zDX.setText(WXHardCoderJNI.hcGifFrameAction);
        this.zDY = (Spinner) findViewById(2131824796);
        this.zDY.setSelection(WXHardCoderJNI.hcGifFrameCPU);
        this.zDZ = (Spinner) findViewById(2131824797);
        this.zDZ.setSelection(WXHardCoderJNI.hcGifFrameIO);
        this.zEa = (CheckBox) findViewById(2131824798);
        this.zEa.setChecked(WXHardCoderJNI.hcGifFrameThr);
        this.zEb = (CheckBox) findViewById(2131824799);
        this.zEb.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
        this.zEc = (EditText) findViewById(2131824801);
        this.zEc.setText(WXHardCoderJNI.hcSNSScrollDelay);
        this.zEd = (EditText) findViewById(2131824800);
        this.zEd.setText(WXHardCoderJNI.hcSNSScrollTimeout);
        this.zEe = (EditText) findViewById(2131824802);
        this.zEe.setText(WXHardCoderJNI.hcSNSScrollAction);
        this.zEf = (Spinner) findViewById(2131824803);
        this.zEf.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
        this.zEg = (Spinner) findViewById(2131824804);
        this.zEg.setSelection(WXHardCoderJNI.hcSNSScrollIO);
        this.zEh = (CheckBox) findViewById(2131824805);
        this.zEh.setChecked(WXHardCoderJNI.hcSNSScrollThr);
        this.zEi = (CheckBox) findViewById(2131824806);
        this.zEi.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
        this.zEj = (EditText) findViewById(2131824808);
        this.zEj.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
        this.zEk = (EditText) findViewById(2131824807);
        this.zEk.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
        this.zEl = (EditText) findViewById(2131824809);
        this.zEl.setText(WXHardCoderJNI.hcSNSUserScrollAction);
        this.zEm = (Spinner) findViewById(2131824810);
        this.zEm.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
        this.zEn = (Spinner) findViewById(2131824811);
        this.zEn.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
        this.zEo = (CheckBox) findViewById(2131824812);
        this.zEo.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
        this.zEp = (CheckBox) findViewById(2131824813);
        this.zEp.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
        this.zEq = (EditText) findViewById(2131824815);
        this.zEq.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
        this.zEr = (EditText) findViewById(2131824814);
        this.zEr.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
        this.zEs = (EditText) findViewById(2131824816);
        this.zEs.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
        this.zEt = (Spinner) findViewById(2131824817);
        this.zEt.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
        this.zEu = (Spinner) findViewById(2131824818);
        this.zEu.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
        this.zEv = (CheckBox) findViewById(2131824819);
        this.zEv.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
        this.zEw = (CheckBox) findViewById(2131824820);
        this.zEw.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
        this.zEx = (EditText) findViewById(2131824822);
        this.zEx.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
        this.zEy = (EditText) findViewById(2131824821);
        this.zEy.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
        this.zEz = (EditText) findViewById(2131824823);
        this.zEz.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
        this.zEA = (Spinner) findViewById(2131824824);
        this.zEA.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
        this.zEB = (Spinner) findViewById(2131824825);
        this.zEB.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
        this.zEC = (CheckBox) findViewById(2131824826);
        this.zEC.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
        this.zED = (CheckBox) findViewById(2131824827);
        this.zED.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
        this.zEE = (EditText) findViewById(2131824829);
        this.zEE.setText(WXHardCoderJNI.hcAlbumScrollDelay);
        this.zEF = (EditText) findViewById(2131824828);
        this.zEF.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
        this.zEG = (EditText) findViewById(2131824830);
        this.zEG.setText(WXHardCoderJNI.hcAlbumScrollAction);
        this.zEH = (Spinner) findViewById(2131824831);
        this.zEH.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
        this.zEI = (Spinner) findViewById(2131824832);
        this.zEI.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
        this.zEJ = (CheckBox) findViewById(2131824833);
        this.zEJ.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
        this.zEK = (CheckBox) findViewById(2131824834);
        this.zEK.setChecked(WXHardCoderJNI.hcBizEnable);
        this.zEL = (EditText) findViewById(2131824836);
        this.zEL.setText(WXHardCoderJNI.hcBizDelay);
        this.zEM = (EditText) findViewById(2131824835);
        this.zEM.setText(WXHardCoderJNI.hcBizTimeout);
        this.zEN = (EditText) findViewById(2131824837);
        this.zEN.setText(WXHardCoderJNI.hcBizAction);
        this.zEO = (Spinner) findViewById(2131824838);
        this.zEO.setSelection(WXHardCoderJNI.hcBizCPU);
        this.zEP = (Spinner) findViewById(2131824839);
        this.zEP.setSelection(WXHardCoderJNI.hcBizIO);
        this.zEQ = (CheckBox) findViewById(2131824840);
        this.zEQ.setChecked(WXHardCoderJNI.hcBizThr);
        this.zCk.setOnClickListener(new C307414());
        AppMethodBeat.m2505o(34876);
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(34877);
        switch (i) {
            case 1:
                Dialog timePickerDialog;
                if (this.qmI) {
                    timePickerDialog = new TimePickerDialog(this.mController.ylL, this.qmJ, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
                    AppMethodBeat.m2505o(34877);
                    return timePickerDialog;
                }
                timePickerDialog = new TimePickerDialog(this.mController.ylL, this.qmJ, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
                AppMethodBeat.m2505o(34877);
                return timePickerDialog;
            default:
                AppMethodBeat.m2505o(34877);
                return null;
        }
    }

    /* renamed from: a */
    private static void m80213a(Editor editor) {
        AppMethodBeat.m2504i(34879);
        editor.putBoolean(WXHardCoderJNI.KEY_HC_ENABLE, WXHardCoderJNI.getEnable());
        editor.putBoolean(WXHardCoderJNI.KEY_HC_DEBUG, WXHardCoderJNI.getDebug());
        editor.putInt(WXHardCoderJNI.KEY_HC_RETRY_INTERVAL, WXHardCoderJNI.hcRetryInterval);
        editor.putBoolean(WXHardCoderJNI.KEY_HC_TIME_LIMIT, WXHardCoderJNI.hcTimeLimit);
        editor.putInt(WXHardCoderJNI.KEY_HC_BEGIN_TIME_HOUR, WXHardCoderJNI.hcBeginTimeHour);
        editor.putInt(WXHardCoderJNI.KEY_HC_BEGIN_TIME_MIN, WXHardCoderJNI.hcBeginTimeMin);
        editor.putInt(WXHardCoderJNI.KEY_HC_END_TIME_HOUR, WXHardCoderJNI.hcEndTimeHour);
        editor.putInt(WXHardCoderJNI.KEY_HC_END_TIME_MIN, WXHardCoderJNI.hcEndTimeMin);
        editor.putBoolean(C1625i.KEY_HC_BOOT_ENABLE, WXHardCoderJNI.hcBootEnable);
        editor.putInt(C1625i.KEY_HC_BOOT_DELEY, WXHardCoderJNI.hcBootDelay);
        editor.putInt(C1625i.KEY_HC_BOOT_CPU, WXHardCoderJNI.hcBootCPU);
        editor.putInt(C1625i.KEY_HC_BOOT_IO, WXHardCoderJNI.hcBootIO);
        editor.putBoolean(C1625i.KEY_HC_BOOT_THR, WXHardCoderJNI.hcBootThr);
        editor.putInt(C1625i.KEY_HC_BOOT_TIMEOUT, WXHardCoderJNI.hcBootTimeout);
        editor.putLong(C1625i.KEY_HC_BOOT_ACTION, WXHardCoderJNI.hcBootAction);
        editor.putBoolean(C1625i.KEY_HC_ENTER_CHATTING_ENABLE, WXHardCoderJNI.hcEnterChattingEnable);
        editor.putInt(C1625i.KEY_HC_ENTER_CHATTING_DELEY, WXHardCoderJNI.hcEnterChattingDelay);
        editor.putInt(C1625i.KEY_HC_ENTER_CHATTING_CPU, WXHardCoderJNI.hcEnterChattingCPU);
        editor.putInt(C1625i.KEY_HC_ENTER_CHATTING_IO, WXHardCoderJNI.hcEnterChattingIO);
        editor.putBoolean(C1625i.KEY_HC_ENTER_CHATTING_THR, WXHardCoderJNI.hcEnterChattingThr);
        editor.putInt(C1625i.KEY_HC_ENTER_CHATTING_TIMEOUT, WXHardCoderJNI.hcEnterChattingTimeout);
        editor.putLong(C1625i.KEY_HC_ENTER_CHATTING_ACTION, WXHardCoderJNI.hcEnterChattingAction);
        editor.putBoolean(C1625i.KEY_HC_QUIT_CHATTING_ENABLE, WXHardCoderJNI.hcQuitChattingEnable);
        editor.putInt(C1625i.KEY_HC_QUIT_CHATTING_DELEY, WXHardCoderJNI.hcQuitChattingDelay);
        editor.putInt(C1625i.KEY_HC_QUIT_CHATTING_CPU, WXHardCoderJNI.hcQuitChattingCPU);
        editor.putInt(C1625i.KEY_HC_QUIT_CHATTING_IO, WXHardCoderJNI.hcQuitChattingIO);
        editor.putBoolean(C1625i.KEY_HC_QUIT_CHATTING_THR, WXHardCoderJNI.hcQuitChattingThr);
        editor.putInt(C1625i.KEY_HC_QUIT_CHATTING_TIMEOUT, WXHardCoderJNI.hcQuitChattingTimeout);
        editor.putLong(C1625i.KEY_HC_QUIT_CHATTING_ACTION, WXHardCoderJNI.hcQuitChattingAction);
        editor.putBoolean(C1625i.KEY_HC_SEND_MSG_ENABLE, WXHardCoderJNI.hcSendMsgEnable);
        editor.putInt(C1625i.KEY_HC_SEND_MSG_DELEY, WXHardCoderJNI.hcSendMsgDelay);
        editor.putInt(C1625i.KEY_HC_SEND_MSG_CPU, WXHardCoderJNI.hcSendMsgCPU);
        editor.putInt(C1625i.KEY_HC_SEND_MSG_IO, WXHardCoderJNI.hcSendMsgIO);
        editor.putBoolean(C1625i.KEY_HC_SEND_MSG_THR, WXHardCoderJNI.hcSendMsgThr);
        editor.putInt(C1625i.KEY_HC_SEND_MSG_TIMEOUT, WXHardCoderJNI.hcSendMsgTimeout);
        editor.putLong(C1625i.KEY_HC_SEND_MSG_ACTION, WXHardCoderJNI.hcSendMsgAction);
        editor.putBoolean(C1625i.KEY_HC_SEND_PIC_MSG_ENABLE, WXHardCoderJNI.hcSendPicMsgEnable);
        editor.putInt(C1625i.KEY_HC_SEND_PIC_MSG_DELEY, WXHardCoderJNI.hcSendPicMsgDelay);
        editor.putInt(C1625i.KEY_HC_SEND_PIC_MSG_CPU, WXHardCoderJNI.hcSendPicMsgCPU);
        editor.putInt(C1625i.KEY_HC_SEND_PIC_MSG_IO, WXHardCoderJNI.hcSendPicMsgIO);
        editor.putBoolean(C1625i.KEY_HC_SEND_PIC_MSG_THR, WXHardCoderJNI.hcSendPicMsgThr);
        editor.putInt(C1625i.KEY_HC_SEND_PIC_MSG_TIMEOUT, WXHardCoderJNI.hcSendPicMsgTimeout);
        editor.putLong(C1625i.KEY_HC_SEND_PIC_MSG_ACTION, WXHardCoderJNI.hcSendPicMsgAction);
        editor.putBoolean(C1625i.KEY_HC_RECEIVE_MSG_ENABLE, WXHardCoderJNI.hcReceiveMsgEnable);
        editor.putInt(C1625i.KEY_HC_RECEIVE_MSG_DELEY, WXHardCoderJNI.hcReceiveMsgDelay);
        editor.putInt(C1625i.KEY_HC_RECEIVE_MSG_CPU, WXHardCoderJNI.hcReceiveMsgCPU);
        editor.putInt(C1625i.KEY_HC_RECEIVE_MSG_IO, WXHardCoderJNI.hcReceiveMsgIO);
        editor.putBoolean(C1625i.KEY_HC_RECEIVE_MSG_THR, WXHardCoderJNI.hcReceiveMsgThr);
        editor.putInt(C1625i.KEY_HC_RECEIVE_MSG_TIMEOUT, WXHardCoderJNI.hcReceiveMsgTimeout);
        editor.putLong(C1625i.KEY_HC_RECEIVE_MSG_ACTION, WXHardCoderJNI.hcReceiveMsgAction);
        editor.putBoolean(C1625i.KEY_HC_UPDATE_CHATROOM_ENABLE, WXHardCoderJNI.hcUpdateChatroomEnable);
        editor.putInt(C1625i.KEY_HC_UPDATE_CHATROOM_DELEY, WXHardCoderJNI.hcUpdateChatroomDelay);
        editor.putInt(C1625i.KEY_HC_UPDATE_CHATROOM_CPU, WXHardCoderJNI.hcUpdateChatroomCPU);
        editor.putInt(C1625i.KEY_HC_UPDATE_CHATROOM_IO, WXHardCoderJNI.hcUpdateChatroomIO);
        editor.putBoolean(C1625i.KEY_HC_UPDATE_CHATROOM_THR, WXHardCoderJNI.hcUpdateChatroomThr);
        editor.putInt(C1625i.KEY_HC_UPDATE_CHATROOM_TIMEOUT, WXHardCoderJNI.hcUpdateChatroomTimeout);
        editor.putLong(C1625i.KEY_HC_UPDATE_CHATROOM_ACTION, WXHardCoderJNI.hcUpdateChatroomAction);
        editor.putLong(C1625i.KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT, WXHardCoderJNI.hcUpdateChatroomMemberCount);
        editor.putBoolean(C1625i.KEY_HC_DB_ENABLE, WXHardCoderJNI.hcDBEnable);
        editor.putInt(C1625i.KEY_HC_DB_DELEY_QUERY, WXHardCoderJNI.hcDBDelayQuery);
        editor.putInt(C1625i.KEY_HC_DB_DELEY_WRITE, WXHardCoderJNI.hcDBDelayWrite);
        editor.putInt(C1625i.KEY_HC_DB_CPU, WXHardCoderJNI.hcDBCPU);
        editor.putInt(C1625i.KEY_HC_DB_IO, WXHardCoderJNI.hcDBIO);
        editor.putBoolean(C1625i.KEY_HC_DB_THR, WXHardCoderJNI.hcDBThr);
        editor.putInt(C1625i.KEY_HC_DB_TIMEOUT, WXHardCoderJNI.hcDBTimeout);
        editor.putInt(C1625i.KEY_HC_DB_TIMEOUT, WXHardCoderJNI.hcDBTimeoutBusy);
        editor.putLong(C1625i.KEY_HC_DB_ACTION_QUERY, WXHardCoderJNI.hcDBActionQuery);
        editor.putLong(C1625i.KEY_HC_DB_ACTION_WRITE, WXHardCoderJNI.hcDBActionWrite);
        editor.putBoolean(C1625i.KEY_HC_ENCODE_VIDEO_ENABLE, WXHardCoderJNI.hcEncodeVideoEnable);
        editor.putInt(C1625i.KEY_HC_ENCODE_VIDEO_DELEY, WXHardCoderJNI.hcEncodeVideoDelay);
        editor.putInt(C1625i.KEY_HC_ENCODE_VIDEO_CPU, WXHardCoderJNI.hcEncodeVideoCPU);
        editor.putInt(C1625i.KEY_HC_ENCODE_VIDEO_IO, WXHardCoderJNI.hcEncodeVideoIO);
        editor.putBoolean(C1625i.KEY_HC_ENCODE_VIDEO_THR, WXHardCoderJNI.hcEncodeVideoThr);
        editor.putInt(C1625i.KEY_HC_ENCODE_VIDEO_TIMEOUT, WXHardCoderJNI.hcEncodeVideoTimeout);
        editor.putLong(C1625i.KEY_HC_ENCODE_VIDEO_ACTION, WXHardCoderJNI.hcEncodeVideoAction);
        editor.putBoolean(C1625i.KEY_HC_DECODE_PIC_ENABLE, WXHardCoderJNI.hcDecodePicEnable);
        editor.putInt(C1625i.KEY_HC_DECODE_PIC_DELEY, WXHardCoderJNI.hcDecodePicDelay);
        editor.putInt(C1625i.KEY_HC_DECODE_PIC_CPU, WXHardCoderJNI.hcDecodePicCPU);
        editor.putInt(C1625i.KEY_HC_DECODE_PIC_IO, WXHardCoderJNI.hcDecodePicIO);
        editor.putBoolean(C1625i.KEY_HC_DECODE_PIC_THR, WXHardCoderJNI.hcDecodePicThr);
        editor.putInt(C1625i.KEY_HC_DECODE_PIC_TIMEOUT, WXHardCoderJNI.hcDecodePicTimeout);
        editor.putLong(C1625i.KEY_HC_DECODE_PIC_ACTION, WXHardCoderJNI.hcDecodePicAction);
        editor.putBoolean(C1625i.KEY_HC_GIF_ENABLE, WXHardCoderJNI.hcGifEnable);
        editor.putInt(C1625i.KEY_HC_GIF_DELEY, WXHardCoderJNI.hcGifDelay);
        editor.putInt(C1625i.KEY_HC_GIF_CPU, WXHardCoderJNI.hcGifCPU);
        editor.putInt(C1625i.KEY_HC_GIF_IO, WXHardCoderJNI.hcGifIO);
        editor.putBoolean(C1625i.KEY_HC_GIF_THR, WXHardCoderJNI.hcGifThr);
        editor.putInt(C1625i.KEY_HC_GIF_TIMEOUT, WXHardCoderJNI.hcGifTimeout);
        editor.putLong(C1625i.KEY_HC_GIF_ACTION, WXHardCoderJNI.hcGifAction);
        editor.putBoolean(C1625i.KEY_HC_GIF_FRAME_ENABLE, WXHardCoderJNI.hcGifFrameEnable);
        editor.putInt(C1625i.KEY_HC_GIF_FRAME_DELEY, WXHardCoderJNI.hcGifFrameDelay);
        editor.putInt(C1625i.KEY_HC_GIF_FRAME_CPU, WXHardCoderJNI.hcGifFrameCPU);
        editor.putInt(C1625i.KEY_HC_GIF_FRAME_IO, WXHardCoderJNI.hcGifFrameIO);
        editor.putBoolean(C1625i.KEY_HC_GIF_FRAME_THR, WXHardCoderJNI.hcGifFrameThr);
        editor.putInt(C1625i.KEY_HC_GIF_FRAME_TIMEOUT, WXHardCoderJNI.hcGifFrameTimeout);
        editor.putLong(C1625i.KEY_HC_GIF_FRAME_ACTION, WXHardCoderJNI.hcGifFrameAction);
        editor.putBoolean(C1625i.KEY_HC_SNS_SCROLL_ENABLE, WXHardCoderJNI.hcSNSScrollEnable);
        editor.putInt(C1625i.KEY_HC_SNS_SCROLL_DELEY, WXHardCoderJNI.hcSNSScrollDelay);
        editor.putInt(C1625i.KEY_HC_SNS_SCROLL_CPU, WXHardCoderJNI.hcSNSScrollCPU);
        editor.putInt(C1625i.KEY_HC_SNS_SCROLL_IO, WXHardCoderJNI.hcSNSScrollIO);
        editor.putBoolean(C1625i.KEY_HC_SNS_SCROLL_THR, WXHardCoderJNI.hcSNSScrollThr);
        editor.putInt(C1625i.KEY_HC_SNS_SCROLL_TIMEOUT, WXHardCoderJNI.hcSNSScrollTimeout);
        editor.putLong(C1625i.KEY_HC_SNS_SCROLL_ACTION, WXHardCoderJNI.hcSNSScrollAction);
        editor.putBoolean(C1625i.KEY_HC_SNS_USER_SCROLL_ENABLE, WXHardCoderJNI.hcSNSUserScrollEnable);
        editor.putInt(C1625i.KEY_HC_SNS_USER_SCROLL_DELEY, WXHardCoderJNI.hcSNSUserScrollDelay);
        editor.putInt(C1625i.KEY_HC_SNS_USER_SCROLL_CPU, WXHardCoderJNI.hcSNSUserScrollCPU);
        editor.putInt(C1625i.KEY_HC_SNS_USER_SCROLL_IO, WXHardCoderJNI.hcSNSUserScrollIO);
        editor.putBoolean(C1625i.KEY_HC_SNS_USER_SCROLL_THR, WXHardCoderJNI.hcSNSUserScrollThr);
        editor.putInt(C1625i.KEY_HC_SNS_USER_SCROLL_TIMEOUT, WXHardCoderJNI.hcSNSUserScrollTimeout);
        editor.putLong(C1625i.KEY_HC_SNS_USER_SCROLL_ACTION, WXHardCoderJNI.hcSNSUserScrollAction);
        editor.putBoolean(C1625i.KEY_HC_SNS_MSG_SCROLL_ENABLE, WXHardCoderJNI.hcSNSMsgScrollEnable);
        editor.putInt(C1625i.KEY_HC_SNS_MSG_SCROLL_DELEY, WXHardCoderJNI.hcSNSMsgScrollDelay);
        editor.putInt(C1625i.KEY_HC_SNS_MSG_SCROLL_CPU, WXHardCoderJNI.hcSNSMsgScrollCPU);
        editor.putInt(C1625i.KEY_HC_SNS_MSG_SCROLL_IO, WXHardCoderJNI.hcSNSMsgScrollIO);
        editor.putBoolean(C1625i.KEY_HC_SNS_MSG_SCROLL_THR, WXHardCoderJNI.hcSNSMsgScrollThr);
        editor.putInt(C1625i.KEY_HC_SNS_MSG_SCROLL_TIMEOUT, WXHardCoderJNI.hcSNSMsgScrollTimeout);
        editor.putLong(C1625i.KEY_HC_SNS_MSG_SCROLL_ACTION, WXHardCoderJNI.hcSNSMsgScrollAction);
        editor.putBoolean(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE, WXHardCoderJNI.hcMediaGalleryScrollEnable);
        editor.putInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_DELEY, WXHardCoderJNI.hcMediaGalleryScrollDelay);
        editor.putInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_CPU, WXHardCoderJNI.hcMediaGalleryScrollCPU);
        editor.putInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_IO, WXHardCoderJNI.hcMediaGalleryScrollIO);
        editor.putBoolean(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_THR, WXHardCoderJNI.hcMediaGalleryScrollThr);
        editor.putInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT, WXHardCoderJNI.hcMediaGalleryScrollTimeout);
        editor.putLong(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_ACTION, WXHardCoderJNI.hcMediaGalleryScrollAction);
        editor.putBoolean(C1625i.KEY_HC_ALBUM_SCROLL_ENABLE, WXHardCoderJNI.hcAlbumScrollEnable);
        editor.putInt(C1625i.KEY_HC_ALBUM_SCROLL_DELEY, WXHardCoderJNI.hcAlbumScrollDelay);
        editor.putInt(C1625i.KEY_HC_ALBUM_SCROLL_CPU, WXHardCoderJNI.hcAlbumScrollCPU);
        editor.putInt(C1625i.KEY_HC_ALBUM_SCROLL_IO, WXHardCoderJNI.hcAlbumScrollIO);
        editor.putBoolean(C1625i.KEY_HC_ALBUM_SCROLL_THR, WXHardCoderJNI.hcAlbumScrollThr);
        editor.putInt(C1625i.KEY_HC_ALBUM_SCROLL_TIMEOUT, WXHardCoderJNI.hcAlbumScrollTimeout);
        editor.putLong(C1625i.KEY_HC_ALBUM_SCROLL_ACTION, WXHardCoderJNI.hcAlbumScrollAction);
        editor.apply();
        AppMethodBeat.m2505o(34879);
    }

    public final int getLayoutId() {
        return 2130969813;
    }

    /* renamed from: c */
    private static String m80217c(Context context, int i, int i2) {
        AppMethodBeat.m2504i(34880);
        String h = C4988aa.m7405h(context.getSharedPreferences(C4996ah.doA(), 0));
        String dor = C4988aa.dor();
        if (h.equalsIgnoreCase("zh_CN") || (h.equalsIgnoreCase("language_default") && "zh_CN".equalsIgnoreCase(dor))) {
            int i3;
            if (i > 12) {
                i3 = i - 12;
            } else {
                i3 = i;
            }
            h = C14835h.m23092r(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
            AppMethodBeat.m2505o(34880);
            return h;
        }
        h = DateFormat.getTimeInstance(3, C4988aa.amw(h)).format(new Time(i, i2, 0));
        AppMethodBeat.m2505o(34880);
        return h;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34878);
        C4990ab.m7416i("HardCoderSettingUI", "save");
        if (this.zCk.isChecked() && !WXHardCoderJNI.getEnable()) {
            WXHardCoderJNI.setHcEnable(this.zCk.isChecked());
            WXHardCoderJNI.initHardCoder(C34331a.bFR(), C34331a.bFR());
        }
        WXHardCoderJNI.setDebug(this.zCm.isChecked());
        WXHardCoderJNI.setHcEnable(this.zCk.isChecked());
        WXHardCoderJNI.hcRetryInterval = C5046bo.getInt(this.zCl.getText().toString(), WXHardCoderJNI.hcRetryInterval);
        if (WXHardCoderJNI.isCheckEnv()) {
            WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
            WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
            WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
        }
        WXHardCoderJNI.hcTimeLimit = this.zCo.isChecked();
        WXHardCoderJNI.hcBootEnable = this.zCr.isChecked();
        WXHardCoderJNI.hcBootDelay = C5046bo.getInt(this.zCs.getText().toString(), WXHardCoderJNI.hcBootDelay);
        WXHardCoderJNI.hcBootCPU = this.zCv.getSelectedItemPosition();
        WXHardCoderJNI.hcBootIO = this.zCw.getSelectedItemPosition();
        WXHardCoderJNI.hcBootThr = this.zCx.isChecked();
        WXHardCoderJNI.hcBootTimeout = C5046bo.getInt(this.zCt.getText().toString(), WXHardCoderJNI.hcBootTimeout);
        WXHardCoderJNI.hcBootAction = C5046bo.getLong(this.zCu.getText().toString(), WXHardCoderJNI.hcBootAction);
        WXHardCoderJNI.hcEnterChattingEnable = this.zCy.isChecked();
        WXHardCoderJNI.hcEnterChattingDelay = C5046bo.getInt(this.zCz.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
        WXHardCoderJNI.hcEnterChattingCPU = this.zCC.getSelectedItemPosition();
        WXHardCoderJNI.hcEnterChattingIO = this.zCD.getSelectedItemPosition();
        WXHardCoderJNI.hcEnterChattingThr = this.zCE.isChecked();
        WXHardCoderJNI.hcEnterChattingTimeout = C5046bo.getInt(this.zCA.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
        WXHardCoderJNI.hcEnterChattingAction = C5046bo.getLong(this.zCB.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
        WXHardCoderJNI.hcQuitChattingEnable = this.zCF.isChecked();
        WXHardCoderJNI.hcQuitChattingDelay = C5046bo.getInt(this.zCG.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
        WXHardCoderJNI.hcQuitChattingCPU = this.zCJ.getSelectedItemPosition();
        WXHardCoderJNI.hcQuitChattingIO = this.zCK.getSelectedItemPosition();
        WXHardCoderJNI.hcQuitChattingThr = this.zCL.isChecked();
        WXHardCoderJNI.hcQuitChattingTimeout = C5046bo.getInt(this.zCH.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
        WXHardCoderJNI.hcQuitChattingAction = C5046bo.getLong(this.zCI.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
        WXHardCoderJNI.hcSendMsgEnable = this.zCM.isChecked();
        WXHardCoderJNI.hcSendMsgDelay = C5046bo.getInt(this.zCN.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
        WXHardCoderJNI.hcSendMsgCPU = this.zCQ.getSelectedItemPosition();
        WXHardCoderJNI.hcSendMsgIO = this.zCR.getSelectedItemPosition();
        WXHardCoderJNI.hcSendMsgThr = this.zCS.isChecked();
        WXHardCoderJNI.hcSendMsgTimeout = C5046bo.getInt(this.zCO.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
        WXHardCoderJNI.hcSendMsgAction = C5046bo.getLong(this.zCP.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
        WXHardCoderJNI.hcSendPicMsgEnable = this.zCT.isChecked();
        WXHardCoderJNI.hcSendPicMsgDelay = C5046bo.getInt(this.zCU.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
        WXHardCoderJNI.hcSendPicMsgCPU = this.zCX.getSelectedItemPosition();
        WXHardCoderJNI.hcSendPicMsgIO = this.zCY.getSelectedItemPosition();
        WXHardCoderJNI.hcSendPicMsgThr = this.zCZ.isChecked();
        WXHardCoderJNI.hcSendPicMsgTimeout = C5046bo.getInt(this.zCV.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
        WXHardCoderJNI.hcSendPicMsgAction = C5046bo.getLong(this.zCW.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
        WXHardCoderJNI.hcReceiveMsgEnable = this.zDa.isChecked();
        WXHardCoderJNI.hcReceiveMsgDelay = C5046bo.getInt(this.zDb.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
        WXHardCoderJNI.hcReceiveMsgCPU = this.zDe.getSelectedItemPosition();
        WXHardCoderJNI.hcReceiveMsgIO = this.zDf.getSelectedItemPosition();
        WXHardCoderJNI.hcReceiveMsgThr = this.zDg.isChecked();
        WXHardCoderJNI.hcReceiveMsgTimeout = C5046bo.getInt(this.zDc.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
        WXHardCoderJNI.hcReceiveMsgAction = C5046bo.getLong(this.zDd.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
        WXHardCoderJNI.hcUpdateChatroomEnable = this.zDh.isChecked();
        WXHardCoderJNI.hcUpdateChatroomDelay = C5046bo.getInt(this.zDi.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
        WXHardCoderJNI.hcUpdateChatroomCPU = this.zDl.getSelectedItemPosition();
        WXHardCoderJNI.hcUpdateChatroomIO = this.zDm.getSelectedItemPosition();
        WXHardCoderJNI.hcUpdateChatroomThr = this.zDn.isChecked();
        WXHardCoderJNI.hcUpdateChatroomTimeout = C5046bo.getInt(this.zDj.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
        WXHardCoderJNI.hcUpdateChatroomAction = C5046bo.getLong(this.zDk.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
        WXHardCoderJNI.hcUpdateChatroomMemberCount = C5046bo.getLong(this.zDo.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
        WXHardCoderJNI.hcDBEnable = this.zDp.isChecked();
        WXHardCoderJNI.hcDBDelayQuery = C5046bo.getInt(this.zDq.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
        WXHardCoderJNI.hcDBDelayWrite = C5046bo.getInt(this.zDr.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
        WXHardCoderJNI.hcDBCPU = this.zCv.getSelectedItemPosition();
        WXHardCoderJNI.hcDBIO = this.zCw.getSelectedItemPosition();
        WXHardCoderJNI.hcDBThr = this.zCx.isChecked();
        WXHardCoderJNI.hcDBTimeout = C5046bo.getInt(this.zDs.getText().toString(), WXHardCoderJNI.hcDBTimeout);
        WXHardCoderJNI.hcDBTimeoutBusy = C5046bo.getInt(this.zDt.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
        WXHardCoderJNI.hcDBActionQuery = C5046bo.getLong(this.zDu.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
        WXHardCoderJNI.hcDBActionWrite = C5046bo.getLong(this.zDv.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
        WXHardCoderJNI.hcEncodeVideoEnable = this.zDz.isChecked();
        WXHardCoderJNI.hcEncodeVideoDelay = C5046bo.getInt(this.zDA.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
        WXHardCoderJNI.hcEncodeVideoCPU = this.zDD.getSelectedItemPosition();
        WXHardCoderJNI.hcEncodeVideoIO = this.zDE.getSelectedItemPosition();
        WXHardCoderJNI.hcEncodeVideoThr = this.zDF.isChecked();
        WXHardCoderJNI.hcEncodeVideoTimeout = C5046bo.getInt(this.zDB.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
        WXHardCoderJNI.hcEncodeVideoAction = C5046bo.getLong(this.zDC.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
        WXHardCoderJNI.hcDecodePicEnable = this.zDG.isChecked();
        WXHardCoderJNI.hcDecodePicDelay = C5046bo.getInt(this.zDH.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
        WXHardCoderJNI.hcDecodePicCPU = this.zDK.getSelectedItemPosition();
        WXHardCoderJNI.hcDecodePicIO = this.zDL.getSelectedItemPosition();
        WXHardCoderJNI.hcDecodePicThr = this.zDM.isChecked();
        WXHardCoderJNI.hcDecodePicTimeout = C5046bo.getInt(this.zDI.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
        WXHardCoderJNI.hcDecodePicAction = C5046bo.getLong(this.zDJ.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
        WXHardCoderJNI.hcGifEnable = this.zDN.isChecked();
        WXHardCoderJNI.hcGifDelay = C5046bo.getInt(this.zDO.getText().toString(), WXHardCoderJNI.hcGifDelay);
        WXHardCoderJNI.hcGifCPU = this.zDR.getSelectedItemPosition();
        WXHardCoderJNI.hcGifIO = this.zDS.getSelectedItemPosition();
        WXHardCoderJNI.hcGifThr = this.zDT.isChecked();
        WXHardCoderJNI.hcGifTimeout = C5046bo.getInt(this.zDP.getText().toString(), WXHardCoderJNI.hcGifTimeout);
        WXHardCoderJNI.hcGifAction = C5046bo.getLong(this.zDQ.getText().toString(), WXHardCoderJNI.hcGifAction);
        WXHardCoderJNI.hcGifFrameEnable = this.zDU.isChecked();
        WXHardCoderJNI.hcGifFrameDelay = C5046bo.getInt(this.zDV.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
        WXHardCoderJNI.hcGifFrameCPU = this.zDY.getSelectedItemPosition();
        WXHardCoderJNI.hcGifFrameIO = this.zDZ.getSelectedItemPosition();
        WXHardCoderJNI.hcGifFrameThr = this.zEa.isChecked();
        WXHardCoderJNI.hcGifFrameTimeout = C5046bo.getInt(this.zDW.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
        WXHardCoderJNI.hcGifFrameAction = C5046bo.getLong(this.zDX.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
        WXHardCoderJNI.hcSNSScrollEnable = this.zEb.isChecked();
        WXHardCoderJNI.hcSNSScrollDelay = C5046bo.getInt(this.zEc.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
        WXHardCoderJNI.hcSNSScrollCPU = this.zEf.getSelectedItemPosition();
        WXHardCoderJNI.hcSNSScrollIO = this.zEg.getSelectedItemPosition();
        WXHardCoderJNI.hcSNSScrollThr = this.zEh.isChecked();
        WXHardCoderJNI.hcSNSScrollTimeout = C5046bo.getInt(this.zEd.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
        WXHardCoderJNI.hcSNSScrollAction = C5046bo.getLong(this.zEe.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
        WXHardCoderJNI.hcSNSUserScrollEnable = this.zEi.isChecked();
        WXHardCoderJNI.hcSNSUserScrollDelay = C5046bo.getInt(this.zEj.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
        WXHardCoderJNI.hcSNSUserScrollCPU = this.zEm.getSelectedItemPosition();
        WXHardCoderJNI.hcSNSUserScrollIO = this.zEn.getSelectedItemPosition();
        WXHardCoderJNI.hcSNSUserScrollThr = this.zEo.isChecked();
        WXHardCoderJNI.hcSNSUserScrollTimeout = C5046bo.getInt(this.zEk.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
        WXHardCoderJNI.hcSNSUserScrollAction = C5046bo.getLong(this.zEl.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
        WXHardCoderJNI.hcSNSMsgScrollEnable = this.zEp.isChecked();
        WXHardCoderJNI.hcSNSMsgScrollDelay = C5046bo.getInt(this.zEq.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
        WXHardCoderJNI.hcSNSMsgScrollCPU = this.zEt.getSelectedItemPosition();
        WXHardCoderJNI.hcSNSMsgScrollIO = this.zEu.getSelectedItemPosition();
        WXHardCoderJNI.hcSNSMsgScrollThr = this.zEv.isChecked();
        WXHardCoderJNI.hcSNSMsgScrollTimeout = C5046bo.getInt(this.zEr.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
        WXHardCoderJNI.hcSNSMsgScrollAction = C5046bo.getLong(this.zEs.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
        WXHardCoderJNI.hcMediaGalleryScrollEnable = this.zEw.isChecked();
        WXHardCoderJNI.hcMediaGalleryScrollDelay = C5046bo.getInt(this.zEx.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
        WXHardCoderJNI.hcMediaGalleryScrollCPU = this.zEA.getSelectedItemPosition();
        WXHardCoderJNI.hcMediaGalleryScrollIO = this.zEB.getSelectedItemPosition();
        WXHardCoderJNI.hcMediaGalleryScrollThr = this.zEC.isChecked();
        WXHardCoderJNI.hcMediaGalleryScrollTimeout = C5046bo.getInt(this.zEy.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
        WXHardCoderJNI.hcMediaGalleryScrollAction = C5046bo.getLong(this.zEz.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
        WXHardCoderJNI.hcAlbumScrollEnable = this.zED.isChecked();
        WXHardCoderJNI.hcAlbumScrollDelay = C5046bo.getInt(this.zEE.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
        WXHardCoderJNI.hcAlbumScrollCPU = this.zEH.getSelectedItemPosition();
        WXHardCoderJNI.hcAlbumScrollIO = this.zEI.getSelectedItemPosition();
        WXHardCoderJNI.hcAlbumScrollThr = this.zEJ.isChecked();
        WXHardCoderJNI.hcAlbumScrollTimeout = C5046bo.getInt(this.zEF.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
        WXHardCoderJNI.hcAlbumScrollAction = C5046bo.getLong(this.zEG.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
        WXHardCoderJNI.hcBizEnable = this.zEK.isChecked();
        WXHardCoderJNI.hcBizDelay = C5046bo.getInt(this.zEL.getText().toString(), WXHardCoderJNI.hcBizDelay);
        WXHardCoderJNI.hcBizCPU = this.zEO.getSelectedItemPosition();
        WXHardCoderJNI.hcBizIO = this.zEP.getSelectedItemPosition();
        WXHardCoderJNI.hcBizThr = this.zEQ.isChecked();
        WXHardCoderJNI.hcBizTimeout = C5046bo.getInt(this.zEM.getText().toString(), WXHardCoderJNI.hcBizTimeout);
        WXHardCoderJNI.hcBizAction = C5046bo.getLong(this.zEN.getText().toString(), WXHardCoderJNI.hcBizAction);
        HardCoderSettingUI.m80213a(this.mController.ylL.getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0).edit());
        WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_SETTING);
        super.onDestroy();
        AppMethodBeat.m2505o(34878);
    }
}
